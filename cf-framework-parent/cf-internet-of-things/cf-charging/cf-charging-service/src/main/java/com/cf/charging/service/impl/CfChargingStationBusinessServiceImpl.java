package com.cf.charging.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cf.charging.domain.*;
import com.cf.charging.domain.customize.CfChargingState;
import com.cf.charging.domain.request.*;
import com.cf.charging.service.*;
import com.cf.chat.domain.CfUserMessage;
import com.cf.chat.service.CfUserMessageService;
import com.cf.framework.domain.charging.response.ChargingCode;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.DateUtil;
import com.cf.framework.utils.HttpClient;
import com.cf.framework.utils.IdWorker;
import com.cf.framework.utils.StringTools;
import com.cf.pay.domain.CfAccount;
import com.cf.pay.domain.CfOrder;
import com.cf.pay.domain.request.CfAccountQuery;
import com.cf.pay.domain.request.CfOrderQuery;
import com.cf.pay.domain.type.GoodsType;
import com.cf.pay.domain.type.PayStatus;
import com.cf.pay.service.CfAccountService;
import com.cf.pay.service.CfOrderService;
import com.cf.ucenter.domain.CfWeixinConfig;
import com.cf.ucenter.service.CfWeixinConfigService;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.config.spring.ReferenceBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfChargingStationBusinessServiceImpl implements CfChargingStationBusinessService, ApplicationContextAware {

    public static final String DEVICE_LINK_IP = "device_link_ip_";
    public static Map<String, Channel> channelMap;
    public static Map<String, NioEventLoopGroup> groupMap;

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserMessageService cfUserMessageService;

    @Autowired
    private CfChargingStationDeviceService cfChargingStationDeviceService;
    @Autowired
    private CfChargingPortService cfChargingPortService;
    @Autowired
    private CfChargingUseLogService cfChargingUseLogService;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private CfChargingStationRulesService cfChargingStationRulesService;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CfChargingStationService cfChargingStationService;

    public static ApplicationContext applicationContext;

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfAccountService cfAccountService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfOrderService cfOrderService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfWeixinConfigService cfWeixinConfigService;

    @Override
    public void handleLink(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] data = new byte[buf.readableBytes()];
        buf.readBytes(data);
        String bytesToString16 = StringTools.bytesToString16(data).toLowerCase();
        //判断充电站品牌

    }

    @Override
    public CfChargingUseLog startCharging(CfChargingStationDeviceForm cfChargingStationDeviceForm) throws Exception {

        //检查该设备状态
        CfChargingStationDeviceQuery cfChargingStationDeviceQuery = new CfChargingStationDeviceQuery();
        cfChargingStationDeviceQuery.setId(cfChargingStationDeviceForm.getId());
        List<CfChargingStationDevice> cfChargingStationDevices = cfChargingStationDeviceService.getListByQuery(cfChargingStationDeviceQuery);
        if(cfChargingStationDevices==null || cfChargingStationDevices.size()==0){
            ExceptionCast.cast(ChargingCode.DEVICE_IS_NOT_REGISTERED);
        }
        cfChargingStationDeviceForm.setBrand(cfChargingStationDevices.get(0).getBrand());
        cfChargingStationDeviceForm.setBarCode(cfChargingStationDevices.get(0).getBarCode());

        //判断该设备是否在本机
        String deviceLinkIp = checkSameServer(cfChargingStationDeviceForm.getBarCode());
        if(StringUtils.isNotEmpty(deviceLinkIp)){
            String url = "dubbo://"+deviceLinkIp+":28101/com.cf.charging.service.CfChargingStationBusinessService?version=1.0.0";//更改不同的Dubbo服务暴露的ip地址&端口
            ReferenceBean<CfChargingStationBusinessService> referenceBean = new ReferenceBean<CfChargingStationBusinessService>();
            referenceBean.setApplicationContext(applicationContext);
            referenceBean.setInterface(CfChargingStationBusinessService.class);
            referenceBean.setUrl(url);
            referenceBean.afterPropertiesSet();
            CfChargingStationBusinessService cfChargingStationBusinessService = referenceBean.get();
            return cfChargingStationBusinessService.startCharging(cfChargingStationDeviceForm);
        }

        //检查充电口状态
        CfChargingPortQuery cfChargingPortQuery = new CfChargingPortQuery();
        cfChargingPortQuery.setChargingDeviceId(cfChargingStationDevices.get(0).getId());
        cfChargingPortQuery.setPortNumber(cfChargingStationDeviceForm.getChargingPort());
        List<CfChargingPort> cfChargingPorts = cfChargingPortService.getListByQuery(cfChargingPortQuery);
        if(cfChargingPorts==null || cfChargingPorts.size()==0){
            ExceptionCast.cast(ChargingCode.CHARGING_PORT_NOT_EXIST);
        }
        if(cfChargingPorts.get(0).getStatus()==(byte)2){
            //触发设备状态检查
            getPortRealTimeData(cfChargingStationDeviceForm);
            ExceptionCast.cast(ChargingCode.CHARGING_PORT_USED);
        }

        //新增充电记录
        CfChargingUseLog cfChargingUseLog = new CfChargingUseLog();
        cfChargingUseLog.setChargingStationId(cfChargingStationDevices.get(0).getChargingStationId());
        cfChargingUseLog.setChargingDeviceId(cfChargingStationDevices.get(0).getId());
        cfChargingUseLog.setChargingPort(cfChargingStationDeviceForm.getChargingPort().toString());
        cfChargingUseLog.setUid(cfChargingStationDeviceForm.getUid());
        //查询该充电站的收费规则
        CfChargingStationRulesQuery cfChargingStationRulesQuery = new CfChargingStationRulesQuery();
        cfChargingStationRulesQuery.setChargingStationId(cfChargingStationDevices.get(0).getChargingStationId());
        cfChargingStationRulesQuery.setStatus((byte)1);
        List<CfChargingStationRules> cfChargingStationRulesList = cfChargingStationRulesService.getListByQuery(cfChargingStationRulesQuery);
        if(cfChargingStationRulesList==null || cfChargingStationRulesList.size()==0){
            ExceptionCast.cast(ChargingCode.MISSING_FEE_RULES);
        }
        //获取当前电价
        long currentTime = System.currentTimeMillis();  //当前时间戳
        long earlyMorningTime = DateUtil.minMillisecondBaseOnTheDayToTimestamp(currentTime).longValue(); //当天凌晨时间戳
        Integer chargingAmount = 0;
        byte b = (byte)4;
        if(b==(byte)2){
            //汽车
            if(cfChargingStationDeviceForm.getChargingFee().doubleValue()<0){
                ExceptionCast.cast(CommonCode.INVALID_PARAM,"充电费用不能小于0");
            }
            cfChargingUseLog.setPlanChargingFee(cfChargingStationDeviceForm.getChargingFee());
            for (CfChargingStationRules cfChargingStationRules: cfChargingStationRulesList){
                if(currentTime >= earlyMorningTime+cfChargingStationRules.getStartTime() && currentTime <= earlyMorningTime+cfChargingStationRules.getEndTime()){
                    cfChargingUseLog.setChargingPrice(cfChargingStationRules.getFee());
                    cfChargingUseLog.setServicePrice(cfChargingStationRules.getServiceFee());
                    break;
                }
            }
            if(cfChargingUseLog.getChargingPrice()==null){
                ExceptionCast.cast(ChargingCode.NOT_MATCHED_TO_CHARGING_PRICE);
            }

            cfChargingUseLog.setPlanChargingKwh(cfChargingUseLog.getPlanChargingFee().divide(cfChargingUseLog.getChargingPrice().add(cfChargingUseLog.getServicePrice()),2,BigDecimal.ROUND_HALF_UP).floatValue());
            chargingAmount = new Double(cfChargingUseLog.getPlanChargingKwh()*10).intValue();
        } else {
            cfChargingUseLog.setChargingPrice(cfChargingStationRulesList.get(0).getFee());
            cfChargingUseLog.setServicePrice(cfChargingStationRulesList.get(0).getServiceFee());
            cfChargingUseLog.setPlanChargingTime(cfChargingStationDeviceForm.getPlanChargingTime());
            //计算两轮充电费用
            cfChargingStationDeviceForm.setChargingFee(new BigDecimal(cfChargingStationDeviceForm.getPlanChargingTime().doubleValue()/3600000d).multiply(cfChargingUseLog.getChargingPrice()).setScale(2,BigDecimal.ROUND_HALF_DOWN));
            chargingAmount = new Double(cfChargingStationDeviceForm.getPlanChargingTime().doubleValue()/60000d).intValue();
            cfChargingUseLog.setPlanChargingFee(cfChargingStationDeviceForm.getChargingFee());
        }

        //将对应的充电口状态设置为已占用
//        CfChargingPort cfChargingPort = new CfChargingPort();
//        cfChargingPort.setId(cfChargingPorts.get(0).getId());
//        cfChargingPort.setStatus((byte)1);
//        cfChargingPortService.update(cfChargingPort);

        //检查账户余额是否足够
        CfAccountQuery cfAccountQuery = new CfAccountQuery();
        cfAccountQuery.setUid(cfChargingStationDeviceForm.getUid());
        cfAccountQuery.setChangeValue(cfChargingStationDeviceForm.getChargingFee().negate());
        cfAccountQuery.setScoreType("cny");
        cfAccountService.checkBalanceByQuery(cfAccountQuery);

        cfChargingUseLog = cfChargingUseLogService.add(cfChargingUseLog);


        switch (cfChargingStationDeviceForm.getBrand()){
            case "lv_chong_chong":
                //开始充电
                break;
            default:
                ExceptionCast.cast(ChargingCode.BRAND_DEVICES_THAT_IS_NOT_CURRENTLY_SUPPORTED);
        }

        //消费一个充电口
        CfChargingStationDevice cfChargingStationDevice = cfChargingStationDeviceService.findById(cfChargingUseLog.getChargingDeviceId());
        if(cfChargingStationDevice!=null){
            CfChargingStation cfChargingStation = new CfChargingStation();
            cfChargingStation.setId(cfChargingUseLog.getChargingStationId());
            switch (cfChargingStationDevice.getPowerType()){
                case (byte)1:
                    cfChargingStation.setUsedSlowChargeNumber((short)1);
                    break;
                case (byte)2:
                    cfChargingStation.setUsedFastChargeNumber((short)1);
                    break;
                case (byte)3:
                    cfChargingStation.setUsedSuperFastChargeNumber((short)1);
                    break;
            }
            cfChargingStationService.increaseOrreduceFieldValue(cfChargingStation);
        }

        return cfChargingUseLog;
    }

    @Override
    public CfChargingState stopCharging(CfChargingStationDeviceForm cfChargingStationDeviceForm) throws Exception {
        //检查该设备状态
        CfChargingStationDeviceQuery cfChargingStationDeviceQuery = new CfChargingStationDeviceQuery();
        cfChargingStationDeviceQuery.setId(cfChargingStationDeviceForm.getId());
        List<CfChargingStationDevice> cfChargingStationDevices = cfChargingStationDeviceService.getListByQuery(cfChargingStationDeviceQuery);
        if(cfChargingStationDevices==null || cfChargingStationDevices.size()==0){
            ExceptionCast.cast(ChargingCode.DEVICE_IS_NOT_REGISTERED);
        }
        cfChargingStationDeviceForm.setBrand(cfChargingStationDevices.get(0).getBrand());
        cfChargingStationDeviceForm.setBarCode(cfChargingStationDevices.get(0).getBarCode());

        //判断该设备是否在本机
        String deviceLinkIp = checkSameServer(cfChargingStationDeviceForm.getBarCode());
        if(StringUtils.isNotEmpty(deviceLinkIp)){
            String url = "dubbo://"+deviceLinkIp+":28101/com.cf.charging.service.CfChargingStationBusinessService?version=1.0.0";//更改不同的Dubbo服务暴露的ip地址&端口
            ReferenceBean<CfChargingStationBusinessService> referenceBean = new ReferenceBean<CfChargingStationBusinessService>();
            referenceBean.setApplicationContext(applicationContext);
            referenceBean.setInterface(CfChargingStationBusinessService.class);
            referenceBean.setUrl(url);
            referenceBean.afterPropertiesSet();
            CfChargingStationBusinessService cfChargingStationBusinessService = referenceBean.get();
            return cfChargingStationBusinessService.stopCharging(cfChargingStationDeviceForm);
        }



        switch (cfChargingStationDeviceForm.getBrand()){
            case "lv_chong_chong":
                //停止充电
                break;
            default:
                ExceptionCast.cast(ChargingCode.BRAND_DEVICES_THAT_IS_NOT_CURRENTLY_SUPPORTED);
        }
        return null;
    }

    @Override
    public CfChargingUseLog clientStopCharging(CfChargingStationDeviceForm cfChargingStationDeviceForm) throws Exception {

        //查询传入的充电记录
        CfChargingUseLog chargingUseLog = cfChargingUseLogService.findById(cfChargingStationDeviceForm.getChargingUseLogId(), false);
        if(!cfChargingStationDeviceForm.getUid().equals(chargingUseLog.getUid())){
            ExceptionCast.cast(ChargingCode.THE_RECORD_DOES_NOT_BELONG_TO_YOU);
        }
        //找到指定的充电设备，同时检查设备状态
        CfChargingStationDevice cfChargingStationDevice = cfChargingStationDeviceService.findById(chargingUseLog.getChargingDeviceId(), false);
        cfChargingStationDeviceForm.setBrand(cfChargingStationDevice.getBrand());
        cfChargingStationDeviceForm.setBarCode(cfChargingStationDevice.getBarCode());
        cfChargingStationDeviceForm.setChargingPort(new Byte(chargingUseLog.getChargingPort()));

        //判断该设备是否在本机
        String deviceLinkIp = checkSameServer(cfChargingStationDeviceForm.getBarCode());
        if(StringUtils.isNotEmpty(deviceLinkIp)){
            String url = "dubbo://"+deviceLinkIp+":28101/com.cf.charging.service.CfChargingStationBusinessService?version=1.0.0";//更改不同的Dubbo服务暴露的ip地址&端口
            ReferenceBean<CfChargingStationBusinessService> referenceBean = new ReferenceBean<CfChargingStationBusinessService>();
            referenceBean.setApplicationContext(applicationContext);
            referenceBean.setInterface(CfChargingStationBusinessService.class);
            referenceBean.setUrl(url);
            referenceBean.afterPropertiesSet();
            CfChargingStationBusinessService cfChargingStationBusinessService = referenceBean.get();
            return cfChargingStationBusinessService.clientStopCharging(cfChargingStationDeviceForm);
        }

        //判断当前用户是否为当前枪口正在充电的用户
        CfChargingUseLog lastChargingUseLog = cfChargingUseLogService.getCharingUseLogByDevcieSerialNumber(cfChargingStationDevice.getBarCode(), cfChargingStationDeviceForm.getChargingPort().toString());
        if(lastChargingUseLog==null || !lastChargingUseLog.getId().equals(chargingUseLog.getId())){
            ExceptionCast.cast(ChargingCode.NON_CHARGING_USERS);
        }

        switch (cfChargingStationDeviceForm.getBrand()){
            case "lv_chong_chong":
                //停止充电
                break;
            default:
                ExceptionCast.cast(ChargingCode.BRAND_DEVICES_THAT_IS_NOT_CURRENTLY_SUPPORTED);
        }
        return null;
    }

    @Override
    public CfChargingState chargingSettiong(CfChargingStationDeviceForm cfChargingStationDeviceForm) throws Exception {
        //检查该设备状态
        CfChargingStationDeviceQuery cfChargingStationDeviceQuery = new CfChargingStationDeviceQuery();
        cfChargingStationDeviceQuery.setId(cfChargingStationDeviceForm.getId());
        List<CfChargingStationDevice> cfChargingStationDevices = cfChargingStationDeviceService.getListByQuery(cfChargingStationDeviceQuery);
        if(cfChargingStationDevices==null || cfChargingStationDevices.size()==0){
            ExceptionCast.cast(ChargingCode.DEVICE_IS_NOT_REGISTERED);
        }
        cfChargingStationDeviceForm.setBrand(cfChargingStationDevices.get(0).getBrand());
        cfChargingStationDeviceForm.setBarCode(cfChargingStationDevices.get(0).getBarCode());

        //判断该设备是否在本机
        String deviceLinkIp = checkSameServer(cfChargingStationDeviceForm.getBarCode());
        if(StringUtils.isNotEmpty(deviceLinkIp)){
            String url = "dubbo://"+deviceLinkIp+":28101/com.cf.charging.service.CfChargingStationBusinessService?version=1.0.0";//更改不同的Dubbo服务暴露的ip地址&端口
            ReferenceBean<CfChargingStationBusinessService> referenceBean = new ReferenceBean<CfChargingStationBusinessService>();
            referenceBean.setApplicationContext(applicationContext);
            referenceBean.setInterface(CfChargingStationBusinessService.class);
            referenceBean.setUrl(url);
            referenceBean.afterPropertiesSet();
            CfChargingStationBusinessService cfChargingStationBusinessService = referenceBean.get();
            return cfChargingStationBusinessService.chargingSettiong(cfChargingStationDeviceForm);
        }

        switch (cfChargingStationDeviceForm.getBrand()){
            case "lv_chong_chong":
                //设置充电配置
                break;
            default:
                ExceptionCast.cast(ChargingCode.BRAND_DEVICES_THAT_IS_NOT_CURRENTLY_SUPPORTED);
        }
        return null;
    }

    @Override
    public CfChargingState getPortRealTimeData(CfChargingStationDeviceForm cfChargingStationDeviceForm) throws Exception {
        if(StringUtils.isEmpty(cfChargingStationDeviceForm.getBrand())){
            //检查该设备状态
            CfChargingStationDeviceQuery cfChargingStationDeviceQuery = new CfChargingStationDeviceQuery();
            cfChargingStationDeviceQuery.setId(cfChargingStationDeviceForm.getId());
            List<CfChargingStationDevice> cfChargingStationDevices = cfChargingStationDeviceService.getListByQuery(cfChargingStationDeviceQuery);
            if(cfChargingStationDevices==null || cfChargingStationDevices.size()==0){
                ExceptionCast.cast(ChargingCode.DEVICE_IS_NOT_REGISTERED);
            }
            cfChargingStationDeviceForm.setBrand(cfChargingStationDevices.get(0).getBrand());
            cfChargingStationDeviceForm.setBarCode(cfChargingStationDevices.get(0).getBarCode());
        }

        //判断该设备是否在本机
        String deviceLinkIp = checkSameServer(cfChargingStationDeviceForm.getBarCode());
        if(StringUtils.isNotEmpty(deviceLinkIp)){
            String url = "dubbo://"+deviceLinkIp+":28101/com.cf.charging.service.CfChargingStationBusinessService?version=1.0.0";//更改不同的Dubbo服务暴露的ip地址&端口
            ReferenceBean<CfChargingStationBusinessService> referenceBean = new ReferenceBean<CfChargingStationBusinessService>();
            referenceBean.setApplicationContext(applicationContext);
            referenceBean.setInterface(CfChargingStationBusinessService.class);
            referenceBean.setUrl(url);
            referenceBean.afterPropertiesSet();
            CfChargingStationBusinessService cfChargingStationBusinessService = referenceBean.get();
            return cfChargingStationBusinessService.getPortRealTimeData(cfChargingStationDeviceForm);
        }

        switch (cfChargingStationDeviceForm.getBrand()){
            case "lv_chong_chong":
                //实时上报充电数据
                break;
            default:
                ExceptionCast.cast(ChargingCode.BRAND_DEVICES_THAT_IS_NOT_CURRENTLY_SUPPORTED);
        }
        return null;
    }

    @Override
    public void finishCharing(CfChargingState cfChargingState) {

        if(StringUtils.isEmpty(cfChargingState.getOrderId())){
            return;
        }

        CfChargingUseLog cfChargingUseLog = cfChargingUseLogService.findById(cfChargingState.getOrderId());
        if(cfChargingUseLog==null || cfChargingUseLog.getEndTime()>0){
            return;
        }

        //修改结束时间
        CfChargingUseLog updateChargingUseLog = new CfChargingUseLog();
        updateChargingUseLog.setId(cfChargingState.getOrderId());
        if(cfChargingState.getEndTime()==null || cfChargingState.getEndTime()==0){
            updateChargingUseLog.setEndTime(System.currentTimeMillis());
        }else{
            updateChargingUseLog.setEndTime(cfChargingState.getEndTime());
        }
        updateChargingUseLog.setChargingPower((new Double(cfChargingState.getChargingPower())).intValue());
        updateChargingUseLog.setChargingedKwh(cfChargingState.getChargingedKwh().floatValue());
        if(cfChargingState.getEndTime()==null){
            //汽车充电
            updateChargingUseLog.setEndTime(System.currentTimeMillis());
            updateChargingUseLog.setChargingFee(cfChargingUseLog.getChargingPrice().multiply(new BigDecimal(cfChargingState.getChargingedKwh())).setScale(2,BigDecimal.ROUND_HALF_UP));
            updateChargingUseLog.setServiceFee(cfChargingUseLog.getServicePrice().multiply(new BigDecimal(cfChargingState.getChargingedKwh())).setScale(2,BigDecimal.ROUND_HALF_UP));
        }else{
            //两轮充电
            updateChargingUseLog.setChargingFee(cfChargingUseLog.getChargingPrice().multiply(new BigDecimal((cfChargingState.getEndTime().doubleValue()-cfChargingUseLog.getStartTime().doubleValue())/3600000d)).setScale(2,BigDecimal.ROUND_HALF_UP));
            updateChargingUseLog.setServiceFee(cfChargingUseLog.getServicePrice().multiply(new BigDecimal((cfChargingState.getEndTime().doubleValue()-cfChargingUseLog.getStartTime().doubleValue())/3600000d)).setScale(2,BigDecimal.ROUND_HALF_UP));
        }

        updateChargingUseLog.setChargingStatus((byte)3);
        cfChargingUseLogService.update(updateChargingUseLog);

        //如果最终充电金数小于计划充电数(偏差值大于0.05度电时)，退回部分资金
        BigDecimal refundAmount = new BigDecimal("0.00");  //退款金额
        if( (cfChargingState.getEndTime()==null && (cfChargingUseLog.getPlanChargingKwh()-updateChargingUseLog.getChargingedKwh() > 0.01) && cfChargingUseLog.getPlanChargingFee().doubleValue()>(updateChargingUseLog.getChargingFee().add(updateChargingUseLog.getServiceFee())).doubleValue()) ||
                (cfChargingState.getEndTime()!=null && (cfChargingUseLog.getPlanChargingTime()-(cfChargingState.getEndTime()-cfChargingUseLog.getStartTime()) >= 300000l))){
            CfAccountQuery cfAccountQuery = new CfAccountQuery();
            cfAccountQuery.setUid(cfChargingUseLog.getUid());
            //计算电费后退回(注意 单价=电费单价+服务费单价)
            cfAccountQuery.setChangeValue( cfChargingUseLog.getPlanChargingFee().subtract(updateChargingUseLog.getChargingFee().add(updateChargingUseLog.getServiceFee())) );
            cfAccountQuery.setScoreType("cny");
            CfAccount cfAccount = cfAccountService.checkAndAddBalance(cfAccountQuery);
            //新增退款账单记录
            CfOrder cfOrder = new CfOrder();
            cfOrder.setRandomId(idWorker.nextId());
            cfOrder.setUid(cfAccountQuery.getUid());
            cfOrder.setGoodsName("新能源提前结束充电部分退款");
            cfOrder.setGoodsId(cfAccount.getId());
            cfOrder.setGoodsType(GoodsType.REFUND);
            cfOrder.setAmountsPayable(cfAccountQuery.getChangeValue());
            cfOrder.setAmountActuallyPaid(cfAccountQuery.getChangeValue());
            cfOrder.setStatus(PayStatus.PAID);
            cfOrder.setPayTime(System.currentTimeMillis());
            cfOrder.setPaymentAgencyShortName("system_fund_account");
            cfOrder.setEffectObject(cfAccount.getId());
            cfOrder.setHandleUid(cfAccountQuery.getHandleUid());
            cfOrder.setScoreKeyFlag(cfAccountQuery.getScoreType());
            cfOrder.setShopId(cfAccountQuery.getShopId());
            cfOrderService.add(cfOrder);
            refundAmount = cfOrder.getAmountActuallyPaid();
        }

        //更新充电账单
        CfOrder cfOrder = new CfOrder();
        cfOrder.setAmountsPayable(cfChargingUseLog.getPlanChargingFee());
        cfOrder.setAmountActuallyPaid(updateChargingUseLog.getChargingFee().add(updateChargingUseLog.getServiceFee()));
        cfOrder.setPayTime(updateChargingUseLog.getEndTime());
        cfOrder.setStatus(PayStatus.PAID);
        cfOrder.setRefundAmount(refundAmount);
        CfOrderQuery cfOrderQuery = new CfOrderQuery();
        cfOrderQuery.setGoodsId(cfChargingState.getOrderId());
        cfOrderService.updateByQuery(cfOrder, cfOrderQuery);

        //归还一个充电口
        CfChargingStationDevice cfChargingStationDevice = cfChargingStationDeviceService.findById(cfChargingUseLog.getChargingDeviceId());
        if(cfChargingStationDevice!=null){
            CfChargingStation cfChargingStation = new CfChargingStation();
            cfChargingStation.setId(cfChargingUseLog.getChargingStationId());
            switch (cfChargingStationDevice.getPowerType()){
                case (byte)1:
                    cfChargingStation.setUsedSlowChargeNumber((short)-1);
                    break;
                case (byte)2:
                    cfChargingStation.setUsedFastChargeNumber((short)-1);
                    break;
                case (byte)3:
                    cfChargingStation.setUsedSuperFastChargeNumber((short)-1);
                    break;
            }
            cfChargingStationService.increaseOrreduceFieldValue(cfChargingStation);
        }
    }

    /**
     * 获取本服务器的外网ip
     * @return
     */
    private String getServiceIp() throws Exception {
        JSONObject jsonObject = HttpClient.doGet(cfWeixinConfigService.returnGetIpUrl());

        //获取配置
        List<CfWeixinConfig> cfWeixinConfigs = cfWeixinConfigService.getWeiXinLoginConfigragtion("server_ip_list");
        CfWeixinConfig cfWeixinConfig = cfWeixinConfigs.get(0);
        Map<String, String> map = (Map<String, String>)JSONObject.parseObject(cfWeixinConfig.getValue(), Map.class);
        String ip = "";
        int i = 0;
        String defaultIp = "";
        for (Map.Entry<String, String> entry:map.entrySet()){
            if(i==0){
                defaultIp = entry.getKey();
            }
            i++;
            if(!map.containsKey(jsonObject.getString("data"))){
                break;
            }
            if(jsonObject.getString("data").equals(entry.getKey())){
                ip = entry.getKey();
                break;
            }
        }
        return ip.equals("") ? defaultIp : ip;
    }

    @Override
    public String checkSameServer(String serialNumber) throws Exception {

        String deviceLinkIp = redisTemplate.boundValueOps(CfChargingStationBusinessServiceImpl.DEVICE_LINK_IP + serialNumber).get();
        if(StringUtils.isEmpty(deviceLinkIp)){
            //设备未注册到系统中
            ExceptionCast.cast(ChargingCode.DEVICE_OFFLINE);
        }
        if(InetAddress.getLocalHost().getHostAddress().equals(deviceLinkIp)){
            //说明设备的确已经掉线，不在任何服务器中连接
            return null;
        }
        return deviceLinkIp;

    }

    @Override
    public Channel initSocketClientAndSendMessage(String host, String message) throws Exception {
        if(channelMap==null){
            channelMap = new HashMap<>();
        }
        if(groupMap==null){
            groupMap = new HashMap<>();
        }

        if(channelMap.get(host)==null){
            NioEventLoopGroup group = new NioEventLoopGroup();
            try {
                Bootstrap b = new Bootstrap();
                b.group(group) // 注册线程池
                        .channel(NioSocketChannel.class) // 使用NioSocketChannel来作为连接用的channel类
                        .remoteAddress(new InetSocketAddress(host, 9003)) // 绑定连接端口和host信息
                        .handler(new ChannelInitializer() {// 绑定连接初始化器
                            @Override
                            protected void initChannel(Channel ch) throws Exception {
                                System.out.println("正在连接中...");
                                ch.pipeline().addLast(new StringEncoder(Charset.forName("GBK")));
//                                ch.pipeline().addLast(new EchoClientHandler());
                                ch.pipeline().addLast(new ByteArrayEncoder());
                                ch.pipeline().addLast(new ChunkedWriteHandler());

                            }
                        });
                // System.out.println("服务端连接成功..");

                ChannelFuture cf = b.connect(); // 同步连接服务器
                System.out.println("服务端连接成功..."); // 连接完成
                channelMap.put(host, cf.channel());
                groupMap.put(host, group);
                return null;


//            cf.channel().closeFuture().sync(); // 异步等待关闭连接channel
//            System.out.println("连接已关闭.."); // 关闭完成

            } catch (Exception e){
                group.shutdownGracefully().sync(); // 释放线程池资源
                return null;
            }
        }else{
            channelMap.get(host).writeAndFlush(StringTools.hexStringToBytes(message));
            return channelMap.get(host);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext _applicationContext) throws BeansException {
        applicationContext = _applicationContext;
    }

    @Override
    public void charingAndBilling(CfChargingUseLog cfChargingUseLog) {
        //检查账户余额是否足够，足够进行扣费
        CfAccountQuery cfAccountQuery = new CfAccountQuery();
        cfAccountQuery.setUid(cfChargingUseLog.getUid());
        cfAccountQuery.setChangeValue(cfChargingUseLog.getPlanChargingFee().negate());
        cfAccountQuery.setScoreType("cny");
        cfAccountService.checkAndUseBalanceByQuery(cfAccountQuery);
        //更新充电记录为正在充电
        CfChargingUseLog updateChargingUseLog = new CfChargingUseLog();
        updateChargingUseLog.setId(cfChargingUseLog.getId());
        updateChargingUseLog.setChargingStatus((byte)2);
        cfChargingUseLogService.update(updateChargingUseLog);
    }

    @Override
    public void sendMessage(Object messageContents, String uid, Integer messageType) throws Exception {
        CfUserMessage cfUserMessage = new CfUserMessage();
        cfUserMessage.setFromUid("0");
        cfUserMessage.setToUid(uid);
        cfUserMessage.setGroupId("");
        cfUserMessage.setContents(JSONObject.toJSONString(messageContents));
        cfUserMessage.setType(messageType);
        cfUserMessage.setIp("");
        try {
            System.out.println("要发送的消息:"+JSONObject.toJSONString(cfUserMessage));
            cfUserMessageService.sendMessage(cfUserMessage);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
