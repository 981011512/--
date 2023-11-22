package com.cf.carpark.service.task;

import com.alibaba.fastjson.JSON;
import com.cf.carpark.domain.CfCarParkPackage;
import com.cf.carpark.domain.request.CfCarParkPackageQuery;
import com.cf.carpark.service.*;
import com.cf.carpark.service.core.cache.ClientCache;
import com.cf.carpark.service.core.dto.ClientDTO;
import com.cf.framework.utils.DateUtil;
import com.cf.sms.service.SmsService;
import com.cf.ucenter.domain.CfWeixinConfig;
import com.cf.ucenter.service.CfWeixinConfigService;
import com.cf.ucenter.wxtools.WeiXinConfigUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author Administrator
 * @version 1.0
 **/
@Component
public class CfCarParkDeviceTask {
    @Autowired
    private CfCarParkDeviceService cfCarParkDeviceService;
    @Autowired
    private CfCarParkPackageService cfCarParkPackageService;
    @Autowired
    private CfCarParkSpecialCarService cfCarParkSpecialCarService;
    @Autowired
    private CfDailyParkingStatistcsService cfDailyParkingStatistcsService;

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private SmsService smsService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfWeixinConfigService cfWeixinConfigService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private IMqttDataService iMqttDataService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    /**
     * 例子：
     * 0/3 * * * * * 每隔3秒执行
     * 0 0/5 * * * * 每隔5分钟执行
     * 0 0 0 * * * 表示每天0点执行
     * 0 0 12 ? * WEN 每周三12点执行
     * 0 15 10 ? * MON-FRI 每月的周一到周五10点 15分执行
     * 0 15 10 ? * MON,FRI 每月的周一和周五10点 15分执行
     */
    @Scheduled(cron="0 0/1 * * * *")
    public void monitorDeviceStatus() throws Exception{
        cfCarParkDeviceService.monitorDeviceStatus();
    }

    /**
     * 短信通知即将过期的套餐
     * @throws Exception
     */
    @Scheduled(cron="0/60 * * * * *")
    public void noticeExpiringSoonCarParkPackageTask() throws Exception{
        CfCarParkPackageQuery cfCarParkPackageQuery = new CfCarParkPackageQuery();
        cfCarParkPackageQuery.setNoticeExpiringSoon((byte)0);
        cfCarParkPackageQuery.setMinEndTime(System.currentTimeMillis());
        cfCarParkPackageQuery.setMaxEndTime(System.currentTimeMillis()+86400000l);
        cfCarParkPackageQuery.setPage(1);
        cfCarParkPackageQuery.setSize(100);
        List<CfCarParkPackage> cfCarParkPackageList = cfCarParkPackageService.selectByQuery(cfCarParkPackageQuery);
        if(cfCarParkPackageList==null || cfCarParkPackageList.size()==0){
            return;
        }
        List<CfWeixinConfig> cfWeixinConfigs = cfWeixinConfigService.getWeiXinLoginConfigragtion("ali_sms");
        String signName = null;
        try {
            signName = WeiXinConfigUtils.getWeiXinConfigragtionByEnName("notice_expiring_soon_car_park_package_sign_name", cfWeixinConfigs);
        } catch (Exception e){
            return;
        }
        String templateCode = WeiXinConfigUtils.getWeiXinConfigragtionByEnName("notice_expiring_soon_car_park_package_code", cfWeixinConfigs);
        String regionId = WeiXinConfigUtils.getWeiXinConfigragtionByEnName("region_id", cfWeixinConfigs);
        String accessKeyId = WeiXinConfigUtils.getWeiXinConfigragtionByEnName("access_key_id", cfWeixinConfigs);
        String secret = WeiXinConfigUtils.getWeiXinConfigragtionByEnName("secret", cfWeixinConfigs);

        List<String> IdList = new ArrayList<>();
        for(CfCarParkPackage cfCarParkPackage: cfCarParkPackageList){
            IdList.add(cfCarParkPackage.getId());
        }
        //更新挑选已经被选中的数据通知状态
        CfCarParkPackage cfCarParkPackage = new CfCarParkPackage();
        cfCarParkPackage.setNoticeExpiringSoon((byte)1);

        cfCarParkPackageQuery.setIds(IdList);
        cfCarParkPackageQuery.setNoticeExpiringSoon(null);
        cfCarParkPackageQuery.setMinEndTime(null);
        cfCarParkPackageQuery.setMaxEndTime(null);
        cfCarParkPackageQuery.setPage(null);
        cfCarParkPackageQuery.setSize(null);

        cfCarParkPackageService.updateByQuery(cfCarParkPackage, cfCarParkPackageQuery);
        for(CfCarParkPackage carParkPackage: cfCarParkPackageList){
            IdList.add(carParkPackage.getId());
            if(carParkPackage.getPhone().length()==11){
                //发送阿里云短信
                smsService.sendSmsByAli(carParkPackage.getPhone(),
                        "{\"number_plate\":\""+carParkPackage.getNumberPlate()+
                                "\",\"goods_name\":\""+carParkPackage.getCfCarParkCarType().getName()+
                                "\",\"end_time\":\""+ DateUtil.stampToDate(carParkPackage.getEndTime(),"yyyy-MM-dd HH:mm:ss") +"\"}",
                        signName,templateCode,regionId,accessKeyId,secret,"","");
            }
        }
    }

    /**
     * 自动给特殊车辆定期赠送免费时长任务
     * @throws Exception
     */
    @Scheduled(cron="0 0/10 * * * *")
    public void autoGiveAwayCarParkSpecialCarTimeTask() throws Exception{
        cfCarParkSpecialCarService.handleAutoGiveAway();
    }

    /**
     * 统计昨日和本周停车数据
     * @throws Exception
     */
    @Scheduled(cron="0 30 03 * * *")
    public void statisticsParkgingDataTask() throws Exception{
        String key = "statisticsParkgingDataTask";
        boolean action = false;
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        String actionHost = stringRedisTemplate.boundValueOps(key).get();
        if(StringUtils.isNotEmpty(actionHost) && hostAddress.equals(actionHost)){
            action = true;
        }

        if(action) {
            Long current = System.currentTimeMillis();
            String dateStr = DateUtil.stampToDate(DateUtil.minMillisecondBaseOnTheDayToTimestamp(current) - 2000l, "yyyy-MM-dd");
            Long startTime = DateUtil.minMillisecondBaseOnTheDayToTimestamp(DateUtil.minMillisecondBaseOnTheDayToTimestamp(current) - 2000l);
            Long endTime = DateUtil.maxMillisecondBaseOnTheDayToTimestamp(DateUtil.minMillisecondBaseOnTheDayToTimestamp(current) - 2000l);
            //统计昨天的数据
            cfDailyParkingStatistcsService.statisticsDatas(dateStr, startTime, endTime, false);
            //统计对应月份的数据
            cfDailyParkingStatistcsService.statisticsDatas(dateStr, DateUtil.getMonthStartTime(startTime, "GMT+8:00"), DateUtil.getMonthEndTime(endTime, "GMT+8:00"), true);
        }
    }

    /**
     * 统计今日停车数据
     * @throws Exception
     */
    @Scheduled(cron="0 0/30 * * * *")
    public void statisticsTodayParkgingDataTask() throws Exception{
        String key = "statisticsTodayParkgingDataTask";
        boolean action = false;
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        String actionHost = stringRedisTemplate.boundValueOps(key).get();
        if(StringUtils.isNotEmpty(actionHost) && hostAddress.equals(actionHost)){
            action = true;
        }

        if(action) {
            String dateStr = DateUtil.stampToDate(System.currentTimeMillis(), "yyyy-MM-dd");
            Long startTime = DateUtil.minMillisecondBaseOnTheDayToTimestamp(System.currentTimeMillis());
            Long endTime = System.currentTimeMillis();
            cfDailyParkingStatistcsService.statisticsDatas(dateStr, startTime, endTime, false);
        }
    }
}
