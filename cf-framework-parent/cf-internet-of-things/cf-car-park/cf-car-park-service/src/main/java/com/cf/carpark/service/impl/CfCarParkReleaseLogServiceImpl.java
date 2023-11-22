package com.cf.carpark.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cf.carpark.dao.mapper.CfCarParkReleaseLogMapper;
import com.cf.carpark.device.camera.HuaXia.GpioData;
import com.cf.carpark.device.camera.HuaXia.HuaXiaResponse;
import com.cf.carpark.device.camera.HuaXia.TrigerData;
import com.cf.carpark.device.camera.ZhenShi.Response_AlarmInfoPlate;
import com.cf.carpark.device.camera.ZhenShi.SeriaDataUtils;
import com.cf.carpark.device.camera.ZhenShiResponse911202002050;
import com.cf.carpark.device.camera.hk.HkResponse;
import com.cf.carpark.device.led.PlayRule;
import com.cf.carpark.domain.CfCarParkDevice;
import com.cf.carpark.domain.CfCarParkReleaseLog;
import com.cf.carpark.domain.CfCarParkReleaseLogExample;
import com.cf.carpark.domain.CfCarParkUseLog;
import com.cf.carpark.domain.request.CfCarParkDeviceQuery;
import com.cf.carpark.domain.request.CfCarParkReleaseLogQuery;
import com.cf.carpark.domain.type.CarDirection;
import com.cf.carpark.domain.type.DeviceBrand;
import com.cf.carpark.domain.type.ReleaseType;
import com.cf.carpark.service.*;
import com.cf.carpark.service.core.cache.ClientCache;
import com.cf.carpark.service.core.dto.ClientDTO;
import com.cf.framework.domain.carpark.response.CarParkCode;
import com.cf.framework.domain.report.CountByKeyAndValue;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.DbUtils;
import com.cf.framework.utils.IdWorker;
import com.cf.framework.utils.StringTools;
import com.cf.pay.domain.type.PayStatus;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.config.spring.ReferenceBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.net.InetAddress;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfCarParkReleaseLogServiceImpl implements CfCarParkReleaseLogService, ApplicationContextAware {

    private String REDIS_PRE = "release_";  //放行记录数据在redis中的key前缀(开闸)
    private String REDIS_PRE_OFF = "checkouPoint_off_";  //放行记录数据在redis中的key前缀
    private String REDIS_PRE_CAPTURE = "capture_";  //相机抓拍数据在redis中的key前缀

    @Autowired
    private CfCarParkReleaseLogMapper cfCarParkReleaseLogMapper;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    StringRedisTemplate redisTemplate;
    @Autowired
    private CfCarParkUseLogService cfCarParkUseLogService;
    @Autowired
    private CfCarParkDeviceService cfCarParkDeviceService;
    @Autowired
    private CfCarParkService cfCarParkService;

    @Autowired
    private IMqttDataService iMqttDataService;
    @Autowired
    private MQTTClient mqttClient;

    public static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext _applicationContext) throws BeansException {
        applicationContext = _applicationContext;
    }

    @Override
    public CfCarParkReleaseLog add(CfCarParkReleaseLog cfCarParkReleaseLog, String redisPreFix) throws Exception {
        if(cfCarParkReleaseLog.getUid()==null){
            cfCarParkReleaseLog.setUid("");
        }
        cfCarParkReleaseLog.setId(idWorker.nextId());
        cfCarParkReleaseLog.setApplicationTime(System.currentTimeMillis());
        cfCarParkReleaseLogMapper.insert(cfCarParkReleaseLog);
        if(cfCarParkReleaseLog.getCfCarParkDevice()!=null && cfCarParkReleaseLog.getCfCarParkDevice().getLinkMode().equals("mqtt") && cfCarParkReleaseLog.getCfCarParkDevice().getType().byteValue()==(byte)2){
            Object o = executeRelease(cfCarParkReleaseLog, cfCarParkReleaseLog.getCfCarParkDevice().getBrand(), 0);
            //判断是否在本机，在本机直接mqtt与客户端交互，否则动态寻找
            boolean local = false;
            if(ClientCache.channels.size()>0){
                ConcurrentHashMap<String, ClientDTO> channels = ClientCache.channels;
                for (Map.Entry channelEntry: channels.entrySet()) {
                    ClientDTO clientDTO = (ClientDTO)channelEntry.getValue();
                    if(!clientDTO.getFlagKey().equals(cfCarParkReleaseLog.getCfCarParkDevice().getBarCode())){
                        continue;
                    }
                    local = true;
                    switch (cfCarParkReleaseLog.getCfCarParkDevice().getBrand()){
                        case "zhen_shi":
                            iMqttDataService.pushTopics(cfCarParkReleaseLog.getCfCarParkDevice().getBarCode(), JSON.toJSONString(o),"/device/" + cfCarParkReleaseLog.getCfCarParkDevice().getBarCode() + "/command");
                            break;
                        case "hua_xia":
                            iMqttDataService.pushTopics(cfCarParkReleaseLog.getDeviceSerialNumber(), JSON.toJSONString(o), "/device/"+cfCarParkReleaseLog.getDeviceSerialNumber()+"/get");
                            break;
                    }

                    break;
                }
            }
            if(!local){
                //使用mqtt客户端进行操作
//                mqttClient.startMQTTClient(cfCarParkReleaseLog.getCfCarParkDevice().getBarCode(), JSON.toJSONString(o));
                //改用Dubbo内置RPC远程服务调用
                String deviceLinkIp = getDeviceLinkLocalServerIp(cfCarParkReleaseLog.getCfCarParkDevice().getBarCode());
                if(StringUtils.isNotEmpty(deviceLinkIp)){
                    String url = "dubbo://"+deviceLinkIp+":20890/com.cf.carpark.service.IMqttDataService?version=1.0.0";//更改不同的Dubbo服务暴露的ip地址&端口
                    ReferenceBean<IMqttDataService> referenceBean = new ReferenceBean<IMqttDataService>();
                    referenceBean.setApplicationContext(applicationContext);
                    referenceBean.setInterface(IMqttDataService.class);
                    referenceBean.setUrl(url);
                    referenceBean.afterPropertiesSet();
                    IMqttDataService iMqttDataService = referenceBean.get();
                    iMqttDataService.pushTopics(cfCarParkReleaseLog.getCfCarParkDevice().getBarCode(), JSON.toJSONString(o),"/device/" + cfCarParkReleaseLog.getCfCarParkDevice().getBarCode() + "/command");
                }
            }
        }else if(cfCarParkReleaseLog.getCfCarParkDevice()!=null && cfCarParkReleaseLog.getCfCarParkDevice().getType().byteValue()==(byte)3){
            //通知地锁开闸
            cfCarParkDeviceService.controlledLockUpAndDown("down",cfCarParkReleaseLog.getCfCarParkDevice().getBarCode());
        }else{
            //放入http协议轮询redis高频缓存数据区
            updateRedisCache(cfCarParkReleaseLog, redisPreFix);
        }
        return cfCarParkReleaseLog;
    }

    @Override
    public String getDeviceLinkLocalServerIp(String sn) throws Exception{
        String deviceLinkIp = redisTemplate.boundValueOps( sn).get();
        if(StringUtils.isEmpty(deviceLinkIp)){
            //设备未注册到系统中
            ExceptionCast.cast(CarParkCode.DEVICE_IS_NOT_REGISTERED);
        }
        if(InetAddress.getLocalHost().getHostAddress().equals(deviceLinkIp)){
            //说明设备的确已经掉线，不在任何服务器中连接
            ConcurrentHashMap<String, ClientDTO> channels = ClientCache.channels;
            for (Map.Entry channelEntry: channels.entrySet()) {
                ClientDTO clientDTO = (ClientDTO)channelEntry.getValue();
                if(clientDTO.getFlagKey().equals(sn)){
                    break;
                }
            }
            throw new Exception("设备已经掉线："+sn+"，请检查网络或重启设备1分钟后再次观察和重试，若重启后依旧无法正常工作请联系技术人员");
        }

        return deviceLinkIp;
    }

    @Override
    public CfCarParkReleaseLog update(CfCarParkReleaseLog cfCarParkReleaseLog) {
        cfCarParkReleaseLogMapper.update(cfCarParkReleaseLog);
        updateRedisCache(cfCarParkReleaseLog, "");
        return cfCarParkReleaseLog;
    }

    @Override
    public void updateRedisCache(CfCarParkReleaseLog cfCarParkReleaseLog, String redisPreFix) {
        if(StringUtils.isEmpty(redisPreFix)){
            return;
        }
        String key = redisPreFix + cfCarParkReleaseLog.getDeviceSerialNumber();
        key = key.replace(" ","");
        redisTemplate.boundZSetOps(key).add(JSONObject.toJSONString(cfCarParkReleaseLog),cfCarParkReleaseLog.getExecutionTime());
        //设置有效期为30秒
        redisTemplate.expire(key,30, TimeUnit.SECONDS);
    }

    @Override
    public Integer delete(String id) {
        CfCarParkReleaseLog cfCarParkReleaseLog = findById(id, false);
        redisTemplate.boundZSetOps(REDIS_PRE+cfCarParkReleaseLog.getDeviceSerialNumber()).remove(cfCarParkReleaseLog.getExecutionTime());
        return cfCarParkReleaseLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteByQuery(CfCarParkReleaseLogQuery cfCarParkReleaseLogQuery) {
        return cfCarParkReleaseLogMapper.deleteByExample(getExampleByQuery(cfCarParkReleaseLogQuery));
    }

    @Override
    public CfCarParkReleaseLog findById(String id) {
        return cfCarParkReleaseLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfCarParkReleaseLog findById(String id, boolean exceptEmpty) {
        CfCarParkReleaseLog cfCarParkReleaseLog = findById(id);
        if(exceptEmpty && cfCarParkReleaseLog!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }
        if(!exceptEmpty && cfCarParkReleaseLog==null){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        return cfCarParkReleaseLog;
    }

    @Override
    public CfCarParkReleaseLogExample getExampleByQuery(CfCarParkReleaseLogQuery cfCarParkReleaseLogQuery) {
        CfCarParkReleaseLogExample cfCarParkReleaseLogExample = new CfCarParkReleaseLogExample();
        CfCarParkReleaseLogExample.Criteria criteria = cfCarParkReleaseLogExample.createCriteria();
        if(StringUtils.isNotEmpty(cfCarParkReleaseLogQuery.getCarparkId())){
            criteria.andCarparkIdEqualTo(cfCarParkReleaseLogQuery.getCarparkId());
        }
        if(StringUtils.isNotEmpty(cfCarParkReleaseLogQuery.getCarparkUseLogId())){
            criteria.andCarparkUseLogIdEqualTo(cfCarParkReleaseLogQuery.getCarparkUseLogId());
        }
        if(StringUtils.isNotEmpty(cfCarParkReleaseLogQuery.getUid())){
            criteria.andUidEqualTo(cfCarParkReleaseLogQuery.getUid());
        }
        if(StringUtils.isNotEmpty(cfCarParkReleaseLogQuery.getDeviceSerialNumber())){
            criteria.andDeviceSerialNumberEqualTo(cfCarParkReleaseLogQuery.getDeviceSerialNumber());
        }
        if(cfCarParkReleaseLogQuery.getStatus()!=null){
            criteria.andStatusEqualTo(cfCarParkReleaseLogQuery.getStatus());
        }
        if(cfCarParkReleaseLogQuery.getType()!=null){
            criteria.andTypeEqualTo(cfCarParkReleaseLogQuery.getType());
        }
        if(cfCarParkReleaseLogQuery.getMinApplicationTime()!=null){
            criteria.andApplicationTimeGreaterThanOrEqualTo(cfCarParkReleaseLogQuery.getMinApplicationTime());
        }
        if(cfCarParkReleaseLogQuery.getMaxApplicationTime()!=null){
            criteria.andApplicationTimeLessThanOrEqualTo(cfCarParkReleaseLogQuery.getMaxApplicationTime());
        }
        if(cfCarParkReleaseLogQuery.getMinExecutionTime()!=null){
            criteria.andExecutionTimeGreaterThanOrEqualTo(cfCarParkReleaseLogQuery.getMinExecutionTime());
        }
        if(cfCarParkReleaseLogQuery.getMaxExecutionTime()!=null){
            criteria.andExecutionTimeLessThanOrEqualTo(cfCarParkReleaseLogQuery.getMaxExecutionTime());
        }
        if(StringUtils.isNotEmpty(cfCarParkReleaseLogQuery.getOrderBy())){
            cfCarParkReleaseLogExample.setOrderByClause(cfCarParkReleaseLogQuery.getOrderBy());
        }
        if(cfCarParkReleaseLogQuery.getPage()!=null && cfCarParkReleaseLogQuery.getSize()!=null){
            PageHelper.startPage(cfCarParkReleaseLogQuery.getPage(), cfCarParkReleaseLogQuery.getSize());
        }
        return cfCarParkReleaseLogExample;
    }

    @Override
    public List<CfCarParkReleaseLog> getListByQuery(CfCarParkReleaseLogQuery cfCarParkReleaseLogQuery) {
        return cfCarParkReleaseLogMapper.selectByExample(getExampleByQuery(cfCarParkReleaseLogQuery));
    }

    @Override
    public Integer getCountByQuery(CfCarParkReleaseLogQuery cfCarParkReleaseLogQuery) {
        cfCarParkReleaseLogQuery.setPage(null);
        return cfCarParkReleaseLogMapper.countByExample(getExampleByQuery(cfCarParkReleaseLogQuery));
    }

    @Override
    public List<CfCarParkReleaseLog> selectListByCondition(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds) {
        String sql = "SELECT cprl.*,cp.id cp_id,cp.name cp_name,cp.image cp_image,cp.position_x cp_position_x,cp.position_y cp_position_y," +
                "cp.start_business_hours cp_start_business_hours,cp.end_business_hours cp_end_business_hours,cp.parking_space_number cp_parking_space_number," +
                "cp.used_parking_space_number cp_used_parking_space_number,cp.address cp_address,cp.phone cp_phone,cp.landline cp_landline,cp.status cp_status," +
                "cp.country_id cp_country_id,cp.province_id cp_province_id,cp.state_or_city_id cp_state_or_city_id,cp.zone_or_county_id cp_zone_or_county_id," +
                "cp.township_id cp_township_id,cp.free_time cp_free_time,cp.score cp_score,cp.number_of_comments cp_number_of_comments,cp.fee_upper_limit cp_fee_upper_limit," +
                "cpck.id cpck_id,cpck.name cpck_name,cpck.car_park_id cpck_car_park_id,cpck.position_x cpck_position_x,cpck.position_y cpck_position_y," +
                "cpck.position_describe cpck_position_describe,cpck.floor cpck_floor,cpck.mode cpck_mode,cpck.status cpck_status," +
                "cpdv.id cpdv_id,cpdv.car_park_id cpdv_car_park_id,cpdv.bar_code cpdv_bar_code,cpdv.brand cpdv_brand,cpdv.model cpdv_model,cpdv.status cpdv_status," +
                "cpdv.last_online_time cpdv_last_online_time,cpdv.link_mode cpdv_link_mode,cpdv.type cpdv_type,cpdv.checkpoint_id cpdv_checkpoint_id," +
                "cpdv.product_id cpdv_product_id,cpdv.direction cpdv_product_direction " +
                "FROM cf_car_park_release_log cprl " +
                "LEFT JOIN cf_car_park cp ON(cprl.carpark_id=cp.id) " +
                "LEFT JOIN cf_car_park_device cpdv ON(cpdv.bar_code=cprl.device_serial_number) " +
                "LEFT JOIN cf_car_park_checkpoint cpck ON(cpdv.checkpoint_id=cpck.id)";
        sql = DbUtils.makeQuery(conditions, allowFiledsMap, allowFileds, sql, false);
        return cfCarParkReleaseLogMapper.selectListByCondition(sql);
    }

    @Override
    public Integer selectListByConditionCounts(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds) {
        String sql = "SELECT count(*) FROM cf_car_park_release_log cprl";
        sql = DbUtils.makeQuery(conditions, allowFiledsMap, allowFileds, sql, true);
        return cfCarParkReleaseLogMapper.selectListByConditionCounts(sql);
    }

    @Override
    public Map<String, Object> releaseMonitoring(String deviceSerialNumber, String deviceBrand) {
        Object response = null;
        Integer channel = null;  //通道 0-开闸， 1-关闸
        Map<String, Object> map = new HashMap<>();

        //更新设备
//        cfCarParkDeviceService.updateLastOnLineTime(deviceSerialNumber);
        Set<String> cfCarParkReleaseLogStringList = redisTemplate.boundZSetOps(REDIS_PRE + deviceSerialNumber).rangeByScore(System.currentTimeMillis() - 604800000, System.currentTimeMillis());
        if(cfCarParkReleaseLogStringList!=null && cfCarParkReleaseLogStringList.size()>0){
            channel = 0;
            for (String cfCarParkReleaseLogString: cfCarParkReleaseLogStringList){
                CfCarParkReleaseLog carParkReleaseLog = JSON.toJavaObject(JSONObject.parseObject(cfCarParkReleaseLogString), CfCarParkReleaseLog.class);
//                redisTemplate.boundZSetOps(REDIS_PRE + deviceSerialNumber).removeRangeByScore(carParkReleaseLog.getExecutionTime(), carParkReleaseLog.getExecutionTime());
                map.put("carParkReleaseLog",carParkReleaseLog);
                map.put("prefix",REDIS_PRE + deviceSerialNumber);


                CfCarParkReleaseLog cfCarParkReleaseLog = new CfCarParkReleaseLog();
                cfCarParkReleaseLog.setId(carParkReleaseLog.getId());
                cfCarParkReleaseLog.setStatus((byte) 1);
                cfCarParkReleaseLogMapper.update(cfCarParkReleaseLog);
                if(StringUtils.isNotEmpty(cfCarParkReleaseLog.getCarparkUseLogId())){
                    CfCarParkUseLog cfCarParkUseLog = cfCarParkUseLogService.findById(cfCarParkReleaseLog.getCarparkUseLogId());
                    if(cfCarParkReleaseLog!=null){
                        CfCarParkDeviceQuery cfCarParkDeviceQuery = new CfCarParkDeviceQuery();
                        cfCarParkDeviceQuery.setBarCode(deviceSerialNumber);
                        cfCarParkDeviceQuery.setStatus((byte)1);
                        List<CfCarParkDevice> cfCarParkDevices = cfCarParkDeviceService.getListByQuery(cfCarParkDeviceQuery);
                        if(cfCarParkDevices!=null && cfCarParkDevices.size()>0){
                            if(cfCarParkDevices.get(0).getDirection().equals(CarDirection.IN)){
                                cfCarParkUseLog.setInReleaseType(ReleaseType.AUTO);
                                cfCarParkUseLog.setInTime(System.currentTimeMillis());
                            }else{
                                cfCarParkUseLog.setOutReleaseType(ReleaseType.AUTO);
                                cfCarParkUseLog.setOutTime(System.currentTimeMillis());
                            }
                        }
                        cfCarParkUseLogService.update(cfCarParkUseLog);
                    }
                }
                response = executeRelease(carParkReleaseLog, deviceBrand, channel);
                break;
            }
            if(response!=null){
                map.put("object",response);
                return map;
            }

        }else{
            channel = 1;
            cfCarParkReleaseLogStringList = redisTemplate.boundZSetOps(REDIS_PRE_OFF + deviceSerialNumber).rangeByScore(System.currentTimeMillis() - 604800000, System.currentTimeMillis());
            if(cfCarParkReleaseLogStringList==null || cfCarParkReleaseLogStringList.size()==0){

                //判断是否有抓拍命令
                Set<String> captureList = redisTemplate.boundZSetOps(REDIS_PRE_CAPTURE + deviceSerialNumber).rangeByScore(System.currentTimeMillis() - 604800000, System.currentTimeMillis());
                if(captureList!=null && captureList.size()>0){
                    ZhenShiResponse911202002050 zhenShiResponse911202002050 = new ZhenShiResponse911202002050();
                    for (String captureString: captureList){
                        if(captureString.indexOf("captureFrequency")>-1){
                            //海康和大华
                            map.put("prefix",REDIS_PRE_CAPTURE + deviceSerialNumber);
                            map.put("object",captureString);
                            map.put("capture",1);
                        }else{
                            //默认为臻识
                            map.put("prefix",REDIS_PRE_CAPTURE + deviceSerialNumber);
                            map.put("object",JSONObject.parseObject(captureString, zhenShiResponse911202002050.getClass()));
                            map.put("capture",1);
                        }
                    }
                }
                return map;
            }
            for (String cfCarParkReleaseLogString: cfCarParkReleaseLogStringList){
                CfCarParkReleaseLog carParkReleaseLog = JSON.toJavaObject(JSONObject.parseObject(cfCarParkReleaseLogString), CfCarParkReleaseLog.class);
//                redisTemplate.boundZSetOps(REDIS_PRE_OFF + deviceSerialNumber).removeRangeByScore(carParkReleaseLog.getExecutionTime(), carParkReleaseLog.getExecutionTime());
                map.put("prefix",REDIS_PRE_OFF + deviceSerialNumber);
                map.put("carParkReleaseLog",carParkReleaseLog);

                CfCarParkReleaseLog cfCarParkReleaseLog = new CfCarParkReleaseLog();
                cfCarParkReleaseLog.setId(carParkReleaseLog.getId());
                cfCarParkReleaseLog.setStatus((byte) 1);
                cfCarParkReleaseLogMapper.update(cfCarParkReleaseLog);
                if(StringUtils.isNotEmpty(cfCarParkReleaseLog.getCarparkUseLogId())){
                    CfCarParkUseLog cfCarParkUseLog = cfCarParkUseLogService.findById(cfCarParkReleaseLog.getCarparkUseLogId());
                    if(cfCarParkReleaseLog!=null){
                        CfCarParkDeviceQuery cfCarParkDeviceQuery = new CfCarParkDeviceQuery();
                        cfCarParkDeviceQuery.setBarCode(deviceSerialNumber);
                        cfCarParkDeviceQuery.setStatus((byte)1);
                        List<CfCarParkDevice> cfCarParkDevices = cfCarParkDeviceService.getListByQuery(cfCarParkDeviceQuery);
                        if(cfCarParkDevices!=null && cfCarParkDevices.size()>0){
                            if(cfCarParkDevices.get(0).getDirection().equals(CarDirection.IN)){
                                cfCarParkUseLog.setInReleaseType(ReleaseType.AUTO);
                                cfCarParkUseLog.setInTime(System.currentTimeMillis());
                            }else{
                                cfCarParkUseLog.setOutReleaseType(ReleaseType.AUTO);
                                cfCarParkUseLog.setOutTime(System.currentTimeMillis());
                            }
                        }
                        cfCarParkUseLogService.update(cfCarParkUseLog);
                    }
                }
                response = executeRelease(carParkReleaseLog, deviceBrand, channel);
                break;
            }
        }
        map.put("object",response);
        return map;
    }

    @Override
    public void cleanReleaseRedis(String redisPreFix, CfCarParkReleaseLog cfCarParkReleaseLog) {
        redisTemplate.boundZSetOps(redisPreFix).removeRangeByScore(cfCarParkReleaseLog.getExecutionTime(), cfCarParkReleaseLog.getExecutionTime());
    }

    @Override
    public void cleanCaptureRedis(String redisPreFix) {
        redisTemplate.boundZSetOps(redisPreFix).removeRangeByScore(System.currentTimeMillis()-30000, System.currentTimeMillis());
    }

    @Override
    public Object executeRelease(CfCarParkReleaseLog cfCarParkReleaseLog, String deviceBrand, Integer channel) {

        Object response = null;
        switch (deviceBrand){
            case DeviceBrand.ZHEN_SHI:
                String model = null;
                ZhenShiResponse911202002050 zhenShiResponse911202002050 = null;
                if(cfCarParkReleaseLog.getCfCarParkDevice()!=null){
                    model = cfCarParkReleaseLog.getCfCarParkDevice().getModel();
                }
                if( model!=null && cfCarParkReleaseLog.getCfCarParkDevice().getLinkMode().equals("mqtt") && StringUtils.isNumeric(model.substring((model.indexOf("-"))+1)) && new Integer(model.substring((model.indexOf("-"))+1)).intValue()>=202210285 ){
                    //说明是较新的SDK版本，mqtt要单独做处理
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("id", StringTools.getRandomString(null,16));
                    jsonObject.put("sn", cfCarParkReleaseLog.getCfCarParkDevice().getBarCode());
                    jsonObject.put("name", "gpio_out");
                    jsonObject.put("version", "1.0");
                    jsonObject.put("timestamp", System.currentTimeMillis()/1000);
                    JSONObject body = new JSONObject();
                    body.put("delay",500);
                    body.put("io",channel);
                    body.put("value",2);
                    JSONObject payload = new JSONObject();
                    payload.put("type","gpio_out");
                    payload.put("body",body);
                    jsonObject.put("payload", payload);
                    return jsonObject;
                }else{
                    zhenShiResponse911202002050 = new ZhenShiResponse911202002050();
                    zhenShiResponse911202002050.setResponse_AlarmInfoPlate(new Response_AlarmInfoPlate());
                    //如果是支付账单开闸，制作led实时显示内容和语音播报
                    if(cfCarParkReleaseLog.getCfCarParkUseLog()!=null && cfCarParkReleaseLog.getCfCarParkUseLog().getCfOrder()!=null && cfCarParkReleaseLog.getCfCarParkUseLog().getCfOrder().getStatus()==PayStatus.PAID && cfCarParkReleaseLog.getCfCarParkUseLog().getCfOrder().getAmountActuallyPaid().doubleValue()>0){
                        try {
                            PlayRule playRule = cfCarParkUseLogService.paySuccessfulPushDeviceMessage(cfCarParkReleaseLog.getCfCarParkUseLog());
                            if(playRule!=null){
                                playRule = cfCarParkUseLogService.showByDeviceRows(playRule, cfCarParkReleaseLog.getCfCarParkUseLog().getCfCarParkDevice(), SeriaDataUtils.FREEOUT);
                                zhenShiResponse911202002050 = SeriaDataUtils.setSerialDataZhenshiByPlayRule(zhenShiResponse911202002050, playRule, SeriaDataUtils.FREEOUT,"");
                            }
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }

                    zhenShiResponse911202002050.getResponse_AlarmInfoPlate().setInfo("ok");
                    zhenShiResponse911202002050.getResponse_AlarmInfoPlate().setPlateid(cfCarParkReleaseLog.getNumberPlate());
                    zhenShiResponse911202002050.getResponse_AlarmInfoPlate().setChannelNum(channel);
                    response = zhenShiResponse911202002050;
                }
                break;
            case DeviceBrand.QIAN_YI:
                zhenShiResponse911202002050 = new ZhenShiResponse911202002050();
                zhenShiResponse911202002050.setResponse_AlarmInfoPlate(new Response_AlarmInfoPlate());
                zhenShiResponse911202002050.getResponse_AlarmInfoPlate().setInfo("ok");
                zhenShiResponse911202002050.getResponse_AlarmInfoPlate().setPlateid(cfCarParkReleaseLog.getNumberPlate());
                zhenShiResponse911202002050.getResponse_AlarmInfoPlate().setChannelNum(channel);
                response = zhenShiResponse911202002050;
                break;
            case DeviceBrand.HUA_XIA:
                //{"error_num":0,"error_str":"noerror","gpio_data":[{"ionum":"io1","action":"on"}]}
                if(cfCarParkReleaseLog.getCfCarParkDevice()!=null && cfCarParkReleaseLog.getCfCarParkDevice().getLinkMode().equals("mqtt")){
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("cmd", "ioOutput");
                    jsonObject.put("msgId", System.currentTimeMillis()+StringTools.getRandomString(null,7));
                    jsonObject.put("utcTs", System.currentTimeMillis()/1000);
                    com.alibaba.fastjson.JSONObject gpioData = new com.alibaba.fastjson.JSONObject();
                    gpioData.put("ioNum","io1");
                    gpioData.put("action","on");
                    jsonObject.put("gpioData", gpioData);
                    HuaXiaResponse huaXiaResponse = new HuaXiaResponse();
                    huaXiaResponse.setMqttDatas(jsonObject);
                    response = huaXiaResponse;
//                    iMqttDataService.pushTopics(cfCarParkReleaseLog.getDeviceSerialNumber(), jsonObject.toString(), "/device/"+cfCarParkReleaseLog.getDeviceSerialNumber()+"/get");
                }else{
                    HuaXiaResponse huaXiaResponse = new HuaXiaResponse();
                    huaXiaResponse.setError_num(0);
                    huaXiaResponse.setError_str("noerror");
                    GpioData gpioData = new GpioData();
                    //请注意硬件道闸接线配合
                    if(channel==0){
                        gpioData.setIonum("io1");
                    }else{
                        gpioData.setIonum("io2");
                    }
                    gpioData.setAction("on");
                    List<GpioData> gpioDataList = new ArrayList<>();
                    gpioDataList.add(gpioData);
                    huaXiaResponse.setGpio_data(gpioDataList);
                    response = huaXiaResponse;
                }
                break;
            case DeviceBrand.HK:
                HkResponse hkResponse = new HkResponse();
                hkResponse.setOpenDoor("on");
                response = hkResponse;
                break;
            case DeviceBrand.DH:
                hkResponse = new HkResponse();
                hkResponse.setOpenDoor("on");
                response = hkResponse;
                break;
            default:
                ExceptionCast.cast(CommonCode.INVALID_PARAM, "提供相机硬件品牌暂时不支持");
        }
        return response;
    }

    @Override
    public Object capture(String sn, String deviceBrand, Integer channel) {
        CfCarParkDevice cfCarParkDevice = cfCarParkDeviceService.findByCode(sn, false);
        Object response = null;
        ZhenShiResponse911202002050 zhenShiResponse911202002050 = null;
        switch (deviceBrand){
            case DeviceBrand.ZHEN_SHI:
                zhenShiResponse911202002050 = new ZhenShiResponse911202002050();
                zhenShiResponse911202002050.setResponse_AlarmInfoPlate(new Response_AlarmInfoPlate());
                zhenShiResponse911202002050.getResponse_AlarmInfoPlate().setManualTrigger("ok");
                response = zhenShiResponse911202002050;
                break;
            case DeviceBrand.QIAN_YI:
                zhenShiResponse911202002050 = new ZhenShiResponse911202002050();
                zhenShiResponse911202002050.setResponse_AlarmInfoPlate(new Response_AlarmInfoPlate());
                zhenShiResponse911202002050.getResponse_AlarmInfoPlate().setManualTrigger("ok");
                response = zhenShiResponse911202002050;
                break;
            case DeviceBrand.HUA_XIA:
                HuaXiaResponse huaXiaResponse = new HuaXiaResponse();
                huaXiaResponse.setError_num(0);
                huaXiaResponse.setError_str("noerror");
                GpioData gpioData = new GpioData();
                TrigerData trigerData = new TrigerData();
                trigerData.setAction("on");
                List<GpioData> gpioDataList = new ArrayList<>();
                gpioDataList.add(gpioData);
                huaXiaResponse.setGpio_data(gpioDataList);
                huaXiaResponse.setTriger_data(trigerData);
                response = huaXiaResponse;
                break;
            case DeviceBrand.HK:
                HkResponse hkResponse = new HkResponse();
                hkResponse.setCaptureFrequency((byte)1);
                response = hkResponse;
                break;
            case DeviceBrand.DH:
                hkResponse = new HkResponse();
                hkResponse.setCaptureFrequency((byte)1);
                response = hkResponse;
                break;
            default:
                ExceptionCast.cast(CommonCode.INVALID_PARAM, "提供相机硬件品牌暂时不支持");
        }

        if(cfCarParkDevice.getLinkMode().equals("mqtt")){
            try {
                String model = cfCarParkDevice.getModel();
                switch (cfCarParkDevice.getBrand()){
                    case "zhen_shi":
                        if( StringUtils.isNumeric(model.substring((model.indexOf("-"))+1)) && new Integer(model.substring((model.indexOf("-"))+1)).intValue()>=202210285 ){
                            //说明是较新的SDK版本，mqtt要单独做处理
                            boolean local = false;
                            if(ClientCache.channels.size()>0){
                                ConcurrentHashMap<String, ClientDTO> channels = ClientCache.channels;
                                for (Map.Entry channelEntry: channels.entrySet()) {
                                    ClientDTO clientDTO = (ClientDTO)channelEntry.getValue();
                                    if(!clientDTO.getFlagKey().equals(sn)){
                                        continue;
                                    }
                                    local = true;
                                    JSONObject jsonObject = new JSONObject();
                                    jsonObject.put("id", StringTools.getRandomString(null,16));
                                    jsonObject.put("sn", sn);
                                    jsonObject.put("name", "snapshot");
                                    jsonObject.put("version", "1.0");
                                    jsonObject.put("timestamp", System.currentTimeMillis()/1000);
                                    JSONObject payload = new JSONObject();
                                    payload.put("type","snapshot");
                                    JSONObject body = new JSONObject();
                                    payload.put("body",body);
                                    jsonObject.put("payload", payload);
                                    response = jsonObject;
                                    iMqttDataService.pushTopics(sn, jsonObject.toString(), "/device/" + sn + "/command");
                                    break;
                                }
                            }
                            if(!local){
                                //改用Dubbo内置RPC远程服务调用
                                String deviceLinkIp = getDeviceLinkLocalServerIp(sn);
                                if(StringUtils.isNotEmpty(deviceLinkIp)){
                                    String url = "dubbo://"+deviceLinkIp+":20890/com.cf.carpark.service.IMqttDataService?version=1.0.0";//更改不同的Dubbo服务暴露的ip地址&端口
                                    ReferenceBean<IMqttDataService> referenceBean = new ReferenceBean<IMqttDataService>();
                                    referenceBean.setApplicationContext(applicationContext);
                                    referenceBean.setInterface(IMqttDataService.class);
                                    referenceBean.setUrl(url);
                                    referenceBean.afterPropertiesSet();
                                    IMqttDataService iMqttDataService = referenceBean.get();
                                    JSONObject jsonObject = new JSONObject();
                                    jsonObject.put("id", StringTools.getRandomString(null,16));
                                    jsonObject.put("sn", sn);
                                    jsonObject.put("name", "snapshot");
                                    jsonObject.put("version", "1.0");
                                    jsonObject.put("timestamp", System.currentTimeMillis()/1000);
                                    JSONObject payload = new JSONObject();
                                    payload.put("type","snapshot");
                                    JSONObject body = new JSONObject();
                                    payload.put("body",body);
                                    jsonObject.put("payload", payload);
                                    response = jsonObject;
                                    iMqttDataService.pushTopics(sn, JSON.toJSONString(jsonObject),"/device/" + sn + "/command");
                                }
                            }
                        }else{
                            mqttClient.startMQTTClient(sn, JSONObject.toJSONString(response));
                        }
                        break;
                    case "hua_xia":
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            //将抓拍命令缓存到redis中去
            String key = REDIS_PRE_CAPTURE + sn;
            redisTemplate.boundZSetOps(key).add(JSONObject.toJSONString(response),System.currentTimeMillis());
            //设置有效期为30秒
            redisTemplate.expire(key,30, TimeUnit.SECONDS);
        }
        return response;
    }

    @Override
    public CfCarParkReleaseLog executeReleaseByCarParkUseLog(CfCarParkUseLog cfCarParkUseLog, String applicationReason, byte type) throws Exception {

        if(StringUtils.isEmpty(cfCarParkUseLog.getOutCheckPointId())){
            ExceptionCast.cast(CarParkCode.CAR_NOT_IN_CARPARK_OUT_CHECKPOINT);
        }

        CfCarParkReleaseLog cfCarParkReleaseLog = new CfCarParkReleaseLog();
        cfCarParkReleaseLog.setCfCarParkUseLog(cfCarParkUseLog);
        cfCarParkReleaseLog.setCarparkId(cfCarParkUseLog.getCarParkId());
        cfCarParkReleaseLog.setCarparkUseLogId(cfCarParkUseLog.getId());
        cfCarParkReleaseLog.setNumberPlate(cfCarParkUseLog.getNumberPlate());
        if(StringUtils.isNotEmpty(cfCarParkUseLog.getUid())){
            cfCarParkReleaseLog.setUid(cfCarParkUseLog.getUid());
        }else if(cfCarParkUseLog.getOutTime()>0 && StringUtils.isNotEmpty(cfCarParkUseLog.getOutHandleUid())){
            cfCarParkReleaseLog.setUid(cfCarParkUseLog.getOutHandleUid());
        }else if(cfCarParkUseLog.getInTime()>0 && StringUtils.isNotEmpty(cfCarParkUseLog.getInHandleUid())){
            cfCarParkReleaseLog.setUid(cfCarParkUseLog.getInHandleUid());
        }else{
            cfCarParkReleaseLog.setUid("");
        }

        //获取设备
        CfCarParkDeviceQuery cfCarParkDeviceQuery = new CfCarParkDeviceQuery();
        cfCarParkDeviceQuery.setCheckpointId(cfCarParkUseLog.getOutCheckPointId());
        if(StringUtils.isEmpty(cfCarParkUseLog.getParkingSpaceNumber())){
            cfCarParkDeviceQuery.setType((byte)2);
            cfCarParkDeviceQuery.setDirection("out");
        }else{
            cfCarParkDeviceQuery.setDeviceNo(cfCarParkUseLog.getParkingSpaceNumber());
        }

        List<CfCarParkDevice> cfCarParkDevices = cfCarParkDeviceService.getListByQuery(cfCarParkDeviceQuery);
        if(cfCarParkDevices==null || cfCarParkDevices.size()==0){
            ExceptionCast.cast(CarParkCode.DEVICE_IS_NOT_REGISTERED);
        }
        cfCarParkReleaseLog.getCfCarParkUseLog().setCfCarParkDevice(cfCarParkDevices.get(0));

        if(cfCarParkDevices.get(0).getDirection().equals(CarDirection.OUT)){
            cfCarParkService.updateUsedParkingSpaceNumber(cfCarParkUseLog.getCarParkId(),-1);
        }else if(cfCarParkDevices.get(0).getDirection().equals(CarDirection.IN)){
            cfCarParkService.updateUsedParkingSpaceNumber(cfCarParkUseLog.getCarParkId(),1);
            //更新入场放行方式为人工放行
            CfCarParkUseLog parkUseLog = new CfCarParkUseLog();
            parkUseLog.setId(cfCarParkUseLog.getId());
            parkUseLog.setInReleaseType(ReleaseType.ARTIFICIAL);
            cfCarParkUseLogService.updateByPrimaryKeySelective(parkUseLog);
        }


        cfCarParkReleaseLog.setDeviceSerialNumber(cfCarParkDevices.get(0).getBarCode());
        cfCarParkReleaseLog.setApplicationTime(System.currentTimeMillis());
        cfCarParkReleaseLog.setApplicationReason(applicationReason);
        cfCarParkReleaseLog.setExecutionTime(System.currentTimeMillis());
        cfCarParkReleaseLog.setStatus((byte)0);
        cfCarParkReleaseLog.setType(type);

        cfCarParkReleaseLog.setCfCarParkDevice(cfCarParkDevices.get(0));

        CfCarParkReleaseLog carParkReleaseLog = add(cfCarParkReleaseLog, REDIS_PRE);
        if(cfCarParkUseLog.getPayTime()!=null && cfCarParkUseLog.getPayTime().longValue()>0l && cfCarParkUseLog.getCfCarParkDevice()!=null && cfCarParkUseLog.getCfCarParkDevice().getType().byteValue()==(byte)3){
            //修改地锁设备状态为正常
            CfCarParkDevice cfCarParkDevice = new CfCarParkDevice();
            cfCarParkDevice.setId(cfCarParkUseLog.getCfCarParkDevice().getId());
            cfCarParkDevice.setStatus((byte)1);
            cfCarParkDeviceService.updateByPrimaryKeySelective(cfCarParkDevice);
        }
        return carParkReleaseLog;
    }

    @Override
    public List<CountByKeyAndValue> countAndOrder(Integer day, List<String> carParkIds) {
        return cfCarParkReleaseLogMapper.countAndOrder(day, carParkIds);
    }
}
