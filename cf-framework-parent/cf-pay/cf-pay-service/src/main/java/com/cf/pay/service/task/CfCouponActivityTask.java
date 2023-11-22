package com.cf.pay.service.task;

import com.cf.chat.domain.CfUserMessage;
import com.cf.framework.utils.DateUtil;
import com.cf.pay.domain.type.CountModel;
import com.cf.pay.service.CfCouponActivityService;
import com.cf.pay.service.CfDailyIncomeStatisticsService;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @version 1.0
 **/
@Component
public class CfCouponActivityTask {
    @Autowired
    private CfCouponActivityService cfCouponActivityService;
    @Autowired
    private CfDailyIncomeStatisticsService cfDailyIncomeStatisticsService;
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
    @Scheduled(cron="0 0/10 * * * *")
//    @Scheduled(cron="0/10 * * * * *")
    public void handleCfCouponActivityTask() throws Exception{
        cfCouponActivityService.handleAutoGiveAway();
    }

    /**
     * 统计昨日和对应月份财务数据
     * @throws Exception
     */
    @Scheduled(cron="0 30 02 * * *")
    public void statisticsIncomeDataTask() throws Exception{
        String key = "statisticsIncomeDataTask";
        boolean action = false;
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        String actionHost = stringRedisTemplate.boundValueOps(key).get();
        if(StringUtils.isNotEmpty(actionHost) && hostAddress.equals(actionHost)){
            action = true;
        }

        if(action){
            Long current = System.currentTimeMillis();
            String dateStr = DateUtil.stampToDate(DateUtil.minMillisecondBaseOnTheDayToTimestamp(current)-2000l,"yyyy-MM-dd");
            Long startTime = DateUtil.minMillisecondBaseOnTheDayToTimestamp(DateUtil.minMillisecondBaseOnTheDayToTimestamp(current)-2000l);
            Long endTime = DateUtil.maxMillisecondBaseOnTheDayToTimestamp(DateUtil.minMillisecondBaseOnTheDayToTimestamp(current)-2000l);
            Thread thread = new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    //异步统计
                    //统计昨天的数据
                    cfDailyIncomeStatisticsService.statisticsDatas(dateStr,startTime,endTime, CountModel.COUNT_MODEL_DAY);
                }
            });
            thread.start();
        }

    }

    /**
     * 统计今日财务数据
     * @throws Exception
     */
    @Scheduled(cron="0 0/60 * * * *")
    public void statisticsTodayIncomeDataTask() throws Exception{
        String key = "statisticsTodayIncomeDataTask";
        boolean action = false;
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        String actionHost = stringRedisTemplate.boundValueOps(key).get();
        if(StringUtils.isNotEmpty(actionHost) && hostAddress.equals(actionHost)){
            action = true;
        }
        if(action){
            String dateStr = DateUtil.stampToDate(System.currentTimeMillis(), "yyyy-MM-dd");
            Long startTime = DateUtil.minMillisecondBaseOnTheDayToTimestamp(System.currentTimeMillis());
            Long endTime = System.currentTimeMillis();
            Thread thread1 = new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    //异步统计
                    //统计今天的数据
                    cfDailyIncomeStatisticsService.statisticsDatas(dateStr, startTime, endTime, CountModel.COUNT_MODEL_DAY);
                }
            });
            thread1.start();
            Thread thread2 = new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    //异步统计
                    //统计对应月份的数据
                    cfDailyIncomeStatisticsService.statisticsDatas(dateStr,DateUtil.getMonthStartTime(startTime,"GMT+8:00"),DateUtil.getMonthEndTime(endTime,"GMT+8:00"),CountModel.COUNT_MODEL_MONTH);
                }
            });
            thread2.start();
            Thread thread3 = new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    //异步统计
                    //统计对应年份的数据
                    cfDailyIncomeStatisticsService.statisticsDatas(dateStr,DateUtil.getYearStartTime(startTime,"GMT+8:00"),DateUtil.getYearEndTime(endTime,"GMT+8:00"),CountModel.COUNT_MODEL_YEAR);
                }
            });
            thread3.start();
        }
    }
}
