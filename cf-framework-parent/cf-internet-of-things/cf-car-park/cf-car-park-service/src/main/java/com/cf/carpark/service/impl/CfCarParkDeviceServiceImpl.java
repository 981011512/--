package com.cf.carpark.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cf.carpark.dao.mapper.CfCarParkDeviceMapper;
import com.cf.carpark.device.camera.HuaXia.HuaXiaResponse;
import com.cf.carpark.device.camera.ZhenShi.SeriaDataUtils;
import com.cf.carpark.device.camera.ZhenShiResponse911202002050;
import com.cf.carpark.device.led.PlayRule;
import com.cf.carpark.domain.CfCarParkDevice;
import com.cf.carpark.domain.CfCarParkDeviceExample;
import com.cf.carpark.domain.CfCarParkDeviceLinkUser;
import com.cf.carpark.domain.request.CfCarParkDeviceLinkUserQuery;
import com.cf.carpark.domain.request.CfCarParkDeviceQuery;
import com.cf.carpark.domain.type.DeviceBrand;
import com.cf.carpark.service.CfCarParkDeviceLinkUserService;
import com.cf.carpark.service.CfCarParkDeviceService;
import com.cf.carpark.service.CfCarParkUseLogService;
import com.cf.carpark.service.IMqttDataService;
import com.cf.carpark.service.core.cache.ClientCache;
import com.cf.carpark.service.core.dto.ClientDTO;
import com.cf.chat.domain.CfUserMessage;
import com.cf.chat.service.CfUserMessageService;
import com.cf.framework.domain.carpark.response.CarParkCode;
import com.cf.framework.domain.charging.response.ChargingCode;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.DateUtil;
import com.cf.framework.utils.DbUtils;
import com.cf.framework.utils.IdWorker;
import com.github.pagehelper.PageHelper;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
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

import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * 硬件管理服务
 *
 * @ClassName CfCarParkDeviceServiceImpl
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/1/001 15:11
 * @Version 1.0
 **/
@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfCarParkDeviceServiceImpl implements CfCarParkDeviceService, ApplicationContextAware {

    // 用户保存用户id与通道的Map对象
    public static Map<String, Object> groundLockClientMap = new HashMap<>();

    public static final String DEVICE_LINK_IP = "ground_lock_link_ip_";

    @Autowired
    private CfCarParkDeviceMapper cfCarParkDeviceMapper;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CfCarParkDeviceLinkUserService cfCarParkDeviceLinkUserService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserMessageService cfUserMessageService;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private CfCarParkUseLogService cfCarParkUseLogService;
    @Autowired
    private IMqttDataService iMqttDataService;

    public static ApplicationContext applicationContext;

    @Override
    public CfCarParkDevice findById(String id) {
        return cfCarParkDeviceMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfCarParkDevice findById(String id, Boolean expectEmpty) {
        CfCarParkDevice cfCarParkDevice = findById(id);
        if(expectEmpty && cfCarParkDevice!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }
        if(!expectEmpty && cfCarParkDevice==null){
            System.out.println("未找到指定设备数据，传入数据id为："+id);
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        return cfCarParkDevice;
    }

    @Override
    public CfCarParkDevice findByCode(String barCode, Boolean expectEmpty) {
        CfCarParkDeviceExample cfCarParkDeviceExample = new CfCarParkDeviceExample();
        CfCarParkDeviceExample.Criteria criteria = cfCarParkDeviceExample.createCriteria();
        criteria.andBarCodeEqualTo(barCode);
        List<CfCarParkDevice> cfCarParkDevices = cfCarParkDeviceMapper.selectByExample(cfCarParkDeviceExample);
        if(expectEmpty && cfCarParkDevices.size()>0){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }
        if(!expectEmpty && cfCarParkDevices.size()==0){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        return cfCarParkDevices.get(0);
    }

    @Override
    public List<CfCarParkDevice> selectListByCondition(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds) {
        String sql = "SELECT cpdv.*,cp.id cp_id,cp.name cp_name,cp.image cp_image,cp.position_x cp_position_x,cp.position_y cp_position_y," +
                "cp.start_business_hours cp_start_business_hours,cp.end_business_hours cp_end_business_hours,cp.parking_space_number cp_parking_space_number," +
                "cp.used_parking_space_number cp_used_parking_space_number,cp.address cp_address,cp.phone cp_phone,cp.landline cp_landline,cp.status cp_status," +
                "cp.country_id cp_country_id,cp.province_id cp_province_id,cp.state_or_city_id cp_state_or_city_id,cp.zone_or_county_id cp_zone_or_county_id," +
                "cp.township_id cp_township_id,cp.free_time cp_free_time,cp.score cp_score,cp.number_of_comments cp_number_of_comments,cp.fee_upper_limit cp_fee_upper_limit," +
                "cp.unit_duration cp_unit_duration," +
                "cpck.id cpck_id,cpck.name cpck_name,cpck.car_park_id cpck_car_park_id,cpck.position_x cpck_position_x,cpck.position_y cpck_position_y," +
                "cpck.position_describe cpck_position_describe,cpck.floor cpck_floor,cpck.mode cpck_mode,cpck.status cpck_status " +
                "FROM cf_car_park_device cpdv " +
                "LEFT JOIN cf_car_park cp ON(cpdv.car_park_id=cp.id) " +
                "LEFT JOIN cf_car_park_checkpoint cpck ON(cpdv.checkpoint_id=cpck.id)";
        sql = DbUtils.makeQuery(conditions, allowFiledsMap, allowFileds, sql, false);
        return cfCarParkDeviceMapper.selectListByCondition(sql);
    }

    @Override
    public Integer selectListByConditionCounts(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds) {
        String sql = "SELECT count(*) FROM cf_car_park_device cpdv";
        sql = DbUtils.makeQuery(conditions, allowFiledsMap, allowFileds, sql, false);
        return cfCarParkDeviceMapper.selectListByConditionCounts(sql);
    }

    @Override
    public CfCarParkDevice add(CfCarParkDevice cfCarParkDevice) {
        cfCarParkDevice.setId(idWorker.nextId());
        if(StringUtils.isEmpty(cfCarParkDevice.getPlayContents())){
            cfCarParkDevice.setPlayContents("{\"approach\":{\"textPlay\":{\"1\":{\"type\":\"plaintext\",\"value\":\"\",\"color\":\"green\",\"inMode\":\"right_to_left\",\"outMode\":\"right_to_left\",\"status\":0,\"serialChannel\":0},\"2\":{\"type\":\"plaintext\",\"value\":\"\",\"color\":\"yellow\",\"inMode\":\"buttom_to_top\",\"outMode\":\"buttom_to_top\",\"status\":0,\"serialChannel\":0},\"3\":{\"type\":\"plaintext\",\"value\":\"\",\"color\":\"red\",\"inMode\":\"top_to_buttom\",\"outMode\":\"top_to_buttom\",\"status\":0,\"serialChannel\":0},\"4\":{\"type\":\"plaintext\",\"value\":\"欢迎光临,请减速慢行\",\"color\":\"green\",\"inMode\":\"right_to_left\",\"outMode\":\"right_to_left\",\"status\":1,\"serialChannel\":0}},\"voicePlay\":{\"1\":{\"value\":\"\",\"playMode\":\"only_add\",\"status\":0,\"serialChannel\":0,\"type\":\"plaintext\"},\"2\":{\"value\":\"\",\"playMode\":\"only_add\",\"status\":0,\"serialChannel\":0,\"type\":\"plaintext\"},\"3\":{\"value\":\"\",\"playMode\":\"add_and_play\",\"status\":0,\"serialChannel\":0,\"type\":\"plaintext\"}},\"imagePlay\":\"\",\"videoPlay\":\"\",\"deviceModel\":\"miu_new\"},\"freeOut\":{\"textPlay\":{\"1\":{\"type\":\"plaintext\",\"value\":\"\",\"color\":\"green\",\"inMode\":\"right_to_left\",\"outMode\":\"right_to_left\",\"status\":0,\"serialChannel\":0},\"2\":{\"type\":\"plaintext\",\"value\":\"\",\"color\":\"yellow\",\"inMode\":\"buttom_to_top\",\"outMode\":\"buttom_to_top\",\"status\":0,\"serialChannel\":0},\"3\":{\"type\":\"plaintext\",\"value\":\"\",\"color\":\"red\",\"inMode\":\"top_to_buttom\",\"outMode\":\"top_to_buttom\",\"status\":0,\"serialChannel\":0},\"4\":{\"type\":\"plaintext\",\"value\":\"\",\"color\":\"green\",\"inMode\":\"right_to_left\",\"outMode\":\"right_to_left\",\"status\":0,\"serialChannel\":0}},\"voicePlay\":{\"1\":{\"value\":\"\",\"playMode\":\"only_add\",\"status\":0,\"serialChannel\":0,\"type\":\"plaintext\"},\"2\":{\"value\":\"\",\"playMode\":\"only_add\",\"status\":0,\"serialChannel\":0,\"type\":\"plaintext\"},\"3\":{\"value\":\"\",\"playMode\":\"add_and_play\",\"status\":0,\"serialChannel\":0,\"type\":\"plaintext\"}},\"imagePlay\":\"\",\"videoPlay\":\"\",\"deviceModel\":\"miu_new\"},\"payOut\":{\"textPlay\":{\"1\":{\"type\":\"plaintext\",\"value\":\"\",\"color\":\"green\",\"inMode\":\"right_to_left\",\"outMode\":\"right_to_left\",\"status\":0,\"serialChannel\":0},\"2\":{\"type\":\"fee\",\"value\":\"请缴费{$fee}元\",\"color\":\"red\",\"inMode\":\"right_to_left\",\"outMode\":\"right_to_left\",\"status\":0,\"serialChannel\":0},\"3\":{\"type\":\"plaintext\",\"value\":\"\",\"color\":\"yellow\",\"inMode\":\"buttom_to_top\",\"outMode\":\"buttom_to_top\",\"status\":0,\"serialChannel\":0},\"4\":{\"type\":\"duration\",\"value\":\"停车时长{$duration}\",\"color\":\"green\",\"inMode\":\"right_to_left\",\"outMode\":\"right_to_left\",\"status\":0,\"serialChannel\":0}},\"voicePlay\":{\"1\":{\"value\":\"\",\"playMode\":\"only_add\",\"status\":0,\"serialChannel\":0,\"type\":\"plaintext\"},\"2\":{\"value\":\"\",\"playMode\":\"only_add\",\"status\":0,\"serialChannel\":0,\"type\":\"plaintext\"},\"3\":{\"value\":\"请缴费{$fee}元\",\"playMode\":\"add_and_play\",\"status\":0,\"serialChannel\":0,\"type\":\"fee\"}},\"imagePlay\":\"\",\"videoPlay\":\"\",\"deviceModel\":\"miu_new\"},\"abnormalOut\":{\"textPlay\":{\"1\":{\"type\":\"plaintext\",\"value\":\"\",\"color\":\"green\",\"inMode\":\"right_to_left\",\"outMode\":\"right_to_left\",\"status\":0,\"serialChannel\":0},\"2\":{\"type\":\"plaintext\",\"value\":\"\",\"color\":\"yellow\",\"inMode\":\"buttom_to_top\",\"outMode\":\"buttom_to_top\",\"status\":0,\"serialChannel\":0},\"3\":{\"type\":\"plaintext\",\"value\":\"\",\"color\":\"red\",\"inMode\":\"top_to_buttom\",\"outMode\":\"top_to_buttom\",\"status\":0,\"serialChannel\":0},\"4\":{\"type\":\"plaintext\",\"value\":\"\",\"color\":\"green\",\"inMode\":\"right_to_left\",\"outMode\":\"right_to_left\",\"status\":0,\"serialChannel\":0}},\"voicePlay\":{\"1\":{\"value\":\"\",\"playMode\":\"only_add\",\"status\":0,\"serialChannel\":0,\"type\":\"plaintext\"},\"2\":{\"value\":\"\",\"playMode\":\"only_add\",\"status\":0,\"serialChannel\":0,\"type\":\"plaintext\"},\"3\":{\"value\":\"\",\"playMode\":\"add_and_play\",\"status\":0,\"serialChannel\":0,\"type\":\"plaintext\"}},\"imagePlay\":\"\",\"videoPlay\":\"\",\"deviceModel\":\"miu_new\"}}");
        }
        if(cfCarParkDevice.getNoticed()==null){
            cfCarParkDevice.setNoticed((byte)0);
        }
        cfCarParkDeviceMapper.insertSelective(cfCarParkDevice);
        return cfCarParkDevice;
    }

    @Override
    public Integer delete(String id) {
        return cfCarParkDeviceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteByQuery(CfCarParkDeviceQuery cfCarParkDeviceQuery) {
        return cfCarParkDeviceMapper.deleteByExample(getExampleByQuery(cfCarParkDeviceQuery));
    }

    @Override
    public CfCarParkDevice update(CfCarParkDevice cfCarParkDevice) {
        if(StringUtils.isEmpty(cfCarParkDevice.getPlayContents())){
            cfCarParkDevice.setPlayContents("{\"approach\":{\"textPlay\":{\"1\":{\"type\":\"plaintext\",\"value\":\"\",\"color\":\"green\",\"inMode\":\"right_to_left\",\"outMode\":\"right_to_left\",\"status\":0,\"serialChannel\":0},\"2\":{\"type\":\"plaintext\",\"value\":\"\",\"color\":\"yellow\",\"inMode\":\"buttom_to_top\",\"outMode\":\"buttom_to_top\",\"status\":0,\"serialChannel\":0},\"3\":{\"type\":\"plaintext\",\"value\":\"\",\"color\":\"red\",\"inMode\":\"top_to_buttom\",\"outMode\":\"top_to_buttom\",\"status\":0,\"serialChannel\":0},\"4\":{\"type\":\"plaintext\",\"value\":\"欢迎光临,请减速慢行\",\"color\":\"green\",\"inMode\":\"right_to_left\",\"outMode\":\"right_to_left\",\"status\":1,\"serialChannel\":0}},\"voicePlay\":{\"1\":{\"value\":\"\",\"playMode\":\"only_add\",\"status\":0,\"serialChannel\":0,\"type\":\"plaintext\"},\"2\":{\"value\":\"\",\"playMode\":\"only_add\",\"status\":0,\"serialChannel\":0,\"type\":\"plaintext\"},\"3\":{\"value\":\"\",\"playMode\":\"add_and_play\",\"status\":0,\"serialChannel\":0,\"type\":\"plaintext\"}},\"imagePlay\":\"\",\"videoPlay\":\"\",\"deviceModel\":\"miu_new\"},\"freeOut\":{\"textPlay\":{\"1\":{\"type\":\"plaintext\",\"value\":\"\",\"color\":\"green\",\"inMode\":\"right_to_left\",\"outMode\":\"right_to_left\",\"status\":0,\"serialChannel\":0},\"2\":{\"type\":\"plaintext\",\"value\":\"\",\"color\":\"yellow\",\"inMode\":\"buttom_to_top\",\"outMode\":\"buttom_to_top\",\"status\":0,\"serialChannel\":0},\"3\":{\"type\":\"plaintext\",\"value\":\"\",\"color\":\"red\",\"inMode\":\"top_to_buttom\",\"outMode\":\"top_to_buttom\",\"status\":0,\"serialChannel\":0},\"4\":{\"type\":\"plaintext\",\"value\":\"\",\"color\":\"green\",\"inMode\":\"right_to_left\",\"outMode\":\"right_to_left\",\"status\":0,\"serialChannel\":0}},\"voicePlay\":{\"1\":{\"value\":\"\",\"playMode\":\"only_add\",\"status\":0,\"serialChannel\":0,\"type\":\"plaintext\"},\"2\":{\"value\":\"\",\"playMode\":\"only_add\",\"status\":0,\"serialChannel\":0,\"type\":\"plaintext\"},\"3\":{\"value\":\"\",\"playMode\":\"add_and_play\",\"status\":0,\"serialChannel\":0,\"type\":\"plaintext\"}},\"imagePlay\":\"\",\"videoPlay\":\"\",\"deviceModel\":\"miu_new\"},\"payOut\":{\"textPlay\":{\"1\":{\"type\":\"plaintext\",\"value\":\"\",\"color\":\"green\",\"inMode\":\"right_to_left\",\"outMode\":\"right_to_left\",\"status\":0,\"serialChannel\":0},\"2\":{\"type\":\"fee\",\"value\":\"请缴费{$fee}元\",\"color\":\"red\",\"inMode\":\"right_to_left\",\"outMode\":\"right_to_left\",\"status\":0,\"serialChannel\":0},\"3\":{\"type\":\"plaintext\",\"value\":\"\",\"color\":\"yellow\",\"inMode\":\"buttom_to_top\",\"outMode\":\"buttom_to_top\",\"status\":0,\"serialChannel\":0},\"4\":{\"type\":\"duration\",\"value\":\"停车时长{$duration}\",\"color\":\"green\",\"inMode\":\"right_to_left\",\"outMode\":\"right_to_left\",\"status\":0,\"serialChannel\":0}},\"voicePlay\":{\"1\":{\"value\":\"\",\"playMode\":\"only_add\",\"status\":0,\"serialChannel\":0,\"type\":\"plaintext\"},\"2\":{\"value\":\"\",\"playMode\":\"only_add\",\"status\":0,\"serialChannel\":0,\"type\":\"plaintext\"},\"3\":{\"value\":\"请缴费{$fee}元\",\"playMode\":\"add_and_play\",\"status\":0,\"serialChannel\":0,\"type\":\"fee\"}},\"imagePlay\":\"\",\"videoPlay\":\"\",\"deviceModel\":\"miu_new\"},\"abnormalOut\":{\"textPlay\":{\"1\":{\"type\":\"plaintext\",\"value\":\"\",\"color\":\"green\",\"inMode\":\"right_to_left\",\"outMode\":\"right_to_left\",\"status\":0,\"serialChannel\":0},\"2\":{\"type\":\"plaintext\",\"value\":\"\",\"color\":\"yellow\",\"inMode\":\"buttom_to_top\",\"outMode\":\"buttom_to_top\",\"status\":0,\"serialChannel\":0},\"3\":{\"type\":\"plaintext\",\"value\":\"\",\"color\":\"red\",\"inMode\":\"top_to_buttom\",\"outMode\":\"top_to_buttom\",\"status\":0,\"serialChannel\":0},\"4\":{\"type\":\"plaintext\",\"value\":\"\",\"color\":\"green\",\"inMode\":\"right_to_left\",\"outMode\":\"right_to_left\",\"status\":0,\"serialChannel\":0}},\"voicePlay\":{\"1\":{\"value\":\"\",\"playMode\":\"only_add\",\"status\":0,\"serialChannel\":0,\"type\":\"plaintext\"},\"2\":{\"value\":\"\",\"playMode\":\"only_add\",\"status\":0,\"serialChannel\":0,\"type\":\"plaintext\"},\"3\":{\"value\":\"\",\"playMode\":\"add_and_play\",\"status\":0,\"serialChannel\":0,\"type\":\"plaintext\"}},\"imagePlay\":\"\",\"videoPlay\":\"\",\"deviceModel\":\"miu_new\"}}");
        }
        cfCarParkDeviceMapper.updateByPrimaryKey(cfCarParkDevice);
        return cfCarParkDevice;
    }

    @Override
    public CfCarParkDevice updateByPrimaryKeySelective(CfCarParkDevice cfCarParkDevice) {
        cfCarParkDeviceMapper.updateByPrimaryKeySelective(cfCarParkDevice);
        return cfCarParkDevice;
    }

    @Override
    public Integer updateByQuery(CfCarParkDevice cfCarParkDevice, CfCarParkDeviceQuery cfCarParkDeviceQuery) {
        return cfCarParkDeviceMapper.updateByExampleSelective(cfCarParkDevice, getExampleByQuery(cfCarParkDeviceQuery));
    }

    @Override
    public CfCarParkDeviceExample getExampleByQuery(CfCarParkDeviceQuery cfCarParkDeviceQuery) {
        CfCarParkDeviceExample cfCarParkDeviceExample = new CfCarParkDeviceExample();
        CfCarParkDeviceExample.Criteria criteria = cfCarParkDeviceExample.createCriteria();
        if(cfCarParkDeviceQuery.getIds()!=null && cfCarParkDeviceQuery.getIds().size()>0){
            criteria.andIdIn(cfCarParkDeviceQuery.getIds());
        }
        if(cfCarParkDeviceQuery.getCarParkId()!=null){
            criteria.andCarParkIdEqualTo(cfCarParkDeviceQuery.getCarParkId());
        }
        if(cfCarParkDeviceQuery.getBarCode()!=null){
            criteria.andBarCodeEqualTo(cfCarParkDeviceQuery.getBarCode());
        }
        if(cfCarParkDeviceQuery.getBarCodes()!=null && cfCarParkDeviceQuery.getBarCodes().size()>0){
            criteria.andBarCodeIn(cfCarParkDeviceQuery.getBarCodes());
        }
        if(cfCarParkDeviceQuery.getNoticed()!=null){
            criteria.andNoticedEqualTo(cfCarParkDeviceQuery.getNoticed());
        }
        if(cfCarParkDeviceQuery.getModel()!=null){
            criteria.andModelEqualTo(cfCarParkDeviceQuery.getModel());
        }
        if(cfCarParkDeviceQuery.getBrand()!=null){
            criteria.andBrandEqualTo(cfCarParkDeviceQuery.getBrand());
        }
        if(cfCarParkDeviceQuery.getStatus()!=null){
            criteria.andStatusEqualTo(cfCarParkDeviceQuery.getStatus());
        }
        if(cfCarParkDeviceQuery.getMinLastOnlineTime()!=null){
            criteria.andLastOnlineTimeGreaterThanOrEqualTo(cfCarParkDeviceQuery.getMinLastOnlineTime());
        }
        if(cfCarParkDeviceQuery.getMaxLastOnlineTime()!=null){
            criteria.andLastOnlineTimeLessThanOrEqualTo(cfCarParkDeviceQuery.getMaxLastOnlineTime());
        }
        if(StringUtils.isNotEmpty(cfCarParkDeviceQuery.getLinkMode())){
            criteria.andLinkModeEqualTo(cfCarParkDeviceQuery.getLinkMode());
        }
        if(cfCarParkDeviceQuery.getType()!=null){
            criteria.andTypeEqualTo(cfCarParkDeviceQuery.getType());
        }
        if(StringUtils.isNotEmpty(cfCarParkDeviceQuery.getCheckpointId())){
            criteria.andCheckpointIdEqualTo(cfCarParkDeviceQuery.getCheckpointId());
        }
        if(cfCarParkDeviceQuery.getCheckpointIds()!=null && cfCarParkDeviceQuery.getCheckpointIds().size()>0){
            criteria.andCheckpointIdIn(cfCarParkDeviceQuery.getCheckpointIds());
        }
        if(StringUtils.isNotEmpty(cfCarParkDeviceQuery.getProductId())){
            criteria.andProductIdEqualTo(cfCarParkDeviceQuery.getProductId());
        }
        if(cfCarParkDeviceQuery.getDirection()!=null){
            criteria.andDirectionEqualTo(cfCarParkDeviceQuery.getDirection());
        }
        if(cfCarParkDeviceQuery.getUsername()!=null){
            criteria.andUsernameEqualTo(cfCarParkDeviceQuery.getUsername());
        }
        if(cfCarParkDeviceQuery.getPassword()!=null){
            criteria.andPasswordEqualTo(cfCarParkDeviceQuery.getPassword());
        }
        if(cfCarParkDeviceQuery.getMacAddress()!=null){
            criteria.andMacAddressEqualTo(cfCarParkDeviceQuery.getMacAddress());
        }
        if(cfCarParkDeviceQuery.getDeviceNo()!=null){
            criteria.andDeviceNoEqualTo(cfCarParkDeviceQuery.getDeviceNo());
        }
        if(StringUtils.isNotEmpty(cfCarParkDeviceQuery.getOrderBy())){
            cfCarParkDeviceExample.setOrderByClause(cfCarParkDeviceQuery.getOrderBy());
        }
        if(cfCarParkDeviceQuery.getPage()!=null && cfCarParkDeviceQuery.getSize()!=null){
            PageHelper.startPage(cfCarParkDeviceQuery.getPage(), cfCarParkDeviceQuery.getSize());
        }
        return cfCarParkDeviceExample;
    }

    @Override
    public List<CfCarParkDevice> getListByQuery(CfCarParkDeviceQuery cfCarParkDeviceQuery) {
        return cfCarParkDeviceMapper.selectByExample(getExampleByQuery(cfCarParkDeviceQuery));
    }

    @Override
    public Integer countByQuery(CfCarParkDeviceQuery cfCarParkDeviceQuery) {
        cfCarParkDeviceQuery.setPage(null);
        return cfCarParkDeviceMapper.countByExample(getExampleByQuery(cfCarParkDeviceQuery));
    }

    @Override
    public void updateLastOnLineTime(String deviceSerialNumber) {
        //先查出旧数据
        CfCarParkDeviceExample cfCarParkDeviceExample = new CfCarParkDeviceExample();
        CfCarParkDeviceExample.Criteria criteria = cfCarParkDeviceExample.createCriteria();
        criteria.andBarCodeEqualTo(deviceSerialNumber);
        List<CfCarParkDevice> carParkDevices = cfCarParkDeviceMapper.selectByExample(cfCarParkDeviceExample);
        //实时更新数据
        CfCarParkDevice carParkDevice = new CfCarParkDevice();
        carParkDevice.setLastOnlineTime(System.currentTimeMillis());
        carParkDevice.setNoticed((byte)0);
        CfCarParkDeviceQuery carParkDeviceQuery = new CfCarParkDeviceQuery();
        carParkDeviceQuery.setBarCode(deviceSerialNumber);
        updateByQuery(carParkDevice, carParkDeviceQuery);
        //判断是否满足条件通知设备已恢复正常
        if(carParkDevices!=null && carParkDevices.size()>0 && carParkDevices.get(0).getNoticed()==(byte)1 && (System.currentTimeMillis()-carParkDevices.get(0).getLastOnlineTime()>=5000)){
            //通知相关管理员该设备已恢复正常状态
            List<CfCarParkDevice> cfCarParkDevices = getListByQuery(carParkDeviceQuery);
            if(cfCarParkDevices!=null && cfCarParkDevices.size()>0){
                sendMessage(cfCarParkDevices, "设备上线通知", "您序列号为"+deviceSerialNumber+"设备网络已恢复正常，您可以点击详情查看具体信息，同时建议您关注线下设备情况", false);
            }
        }

    }

    @Override
    public void monitorDeviceStatus() {
        if(ClientCache.channels.size()>0){
            CfCarParkDeviceQuery cfCarParkDeviceQuery = new CfCarParkDeviceQuery();
            cfCarParkDeviceQuery.setNoticed((byte)0);
            cfCarParkDeviceQuery.setBarCodes(new ArrayList<>());
            ConcurrentHashMap<String, ClientDTO> channels = ClientCache.channels;
            long currentTimeMillis = System.currentTimeMillis();
            List<Channel> offLineChanell = new ArrayList<>();
            for (Map.Entry<String, ClientDTO> channelEntry: channels.entrySet()) {
                ClientDTO clientDTO = channelEntry.getValue();
                //3分钟内没数据上传或者心跳，表示已经断线
                if(clientDTO.getLastOnLineTime()!=null && currentTimeMillis-clientDTO.getLastOnLineTime()>180000){
                    //标记掉线设备
                    offLineChanell.add(clientDTO.getChannel());
                    cfCarParkDeviceQuery.getBarCodes().add(channelEntry.getValue().getFlagKey());
                    System.out.println(DateUtil.stampToDate(currentTimeMillis,"yyyy-MM-dd HH:mm:ss") +"设备掉线："+channelEntry.getValue().getFlagKey());
                    break;
                }
            }
            if(offLineChanell.size()>0){
                for(Channel channel: offLineChanell){
                }
                List<CfCarParkDevice> cfCarParkDevices = getListByQuery(cfCarParkDeviceQuery);
                if(cfCarParkDevices!=null && cfCarParkDevices.size()>0){
                    sendMessage(cfCarParkDevices, "设备掉线通知", "您有新增掉线的设备，请点击详情查看和及时处理", true);
                }
            }

        }
    }

    private void sendMessage(List<CfCarParkDevice> cfCarParkDevices, String messageTitle, String messageContents, boolean remarkNoticed){
        List<String> deviceIds = new ArrayList<>();
        if(cfCarParkDevices!=null && cfCarParkDevices.size()>0){
            for (CfCarParkDevice cfCarParkDevice: cfCarParkDevices){
                deviceIds.add(cfCarParkDevice.getId());
            }

            //查询通道的关联且允许通知的用户
            CfCarParkDeviceLinkUserQuery cfCarParkDeviceLinkUserQuery = new CfCarParkDeviceLinkUserQuery();
            cfCarParkDeviceLinkUserQuery.setDeviceIds(deviceIds);

            List<CfCarParkDeviceLinkUser> cfCarParkDeviceLinkUsers = cfCarParkDeviceLinkUserService.getListByQuery(cfCarParkDeviceLinkUserQuery);

            if(cfCarParkDeviceLinkUsers!=null && cfCarParkDeviceLinkUsers.size()>0){
                //开始给用户发送硬件掉线消息通知
                CfUserMessage cfUserMessage = new CfUserMessage();
                Map<String, Object> message = new HashMap<>();

                for(CfCarParkDeviceLinkUser cfCarParkDeviceLinkUser: cfCarParkDeviceLinkUsers){
                    message.put("title",messageTitle);
                    message.put("contents",messageContents);
                    message.put("data",cfCarParkDeviceLinkUser);
                    cfUserMessage.setFromUid("0");
                    cfUserMessage.setToUid(cfCarParkDeviceLinkUser.getUid());
                    cfUserMessage.setGroupId("");
                    cfUserMessage.setContents(JSONObject.toJSONString(message));
                    cfUserMessage.setType(2);
                    cfUserMessage.setIp("");
                    try {
                        cfUserMessageService.sendMessage(cfUserMessage);
                    } catch (Exception e){
                        e.printStackTrace();
                    }

                }

                //是否标记该设备已被通知
                if(remarkNoticed){
                    CfCarParkDevice carParkDevice = new CfCarParkDevice();
                    carParkDevice.setNoticed((byte)1);
                    CfCarParkDeviceQuery carParkDeviceQuery = new CfCarParkDeviceQuery();
                    carParkDeviceQuery.setIds(deviceIds);
                    updateByQuery(carParkDevice, carParkDeviceQuery);
                }
            }
        }
    }

    @Override
    public void handleLink(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            ByteBuf buf = (ByteBuf) msg;
            byte[] data = new byte[buf.readableBytes()];
            buf.readBytes(data);
            String bytesToString = new String(data, StandardCharsets.ISO_8859_1);

            System.out.println("parking tcp data:"+bytesToString);

            if(bytesToString.indexOf("1ACF")==0){
                //地锁

            }
        } catch (Exception e){
            //调用此方法，避免没有调用release()方法，最终导致gc问题
            ctx.channel().writeAndFlush(new TextWebSocketFrame("FF"));
            throw e;
        }

    }

    @Override
    public void controlledLockUpAndDown(String action, String serialNumber) throws Exception {

    }

    @Override
    public String checkSameServer(String serialNumber) throws Exception {

        String deviceLinkIp = redisTemplate.boundValueOps(CfCarParkDeviceServiceImpl.DEVICE_LINK_IP + serialNumber).get();
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
    public void setApplicationContext(ApplicationContext _applicationContext) throws BeansException {
        applicationContext = _applicationContext;
    }

    @Override
    public void publishLedAd(String serialNumber, List<String> adList, String validityPeriod) throws Exception {
        CfCarParkDevice cfCarParkDevice = findByCode(serialNumber, false);

        Object object = null;

        if(adList!=null && adList.size()>0){
            PlayRule playRule = null;
            int index = 0;
            for (String contents: adList){
                String showString = index==0 ? cfCarParkDevice.getPlayContents() : JSONObject.toJSONString(playRule);
                playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(showString, SeriaDataUtils.APPROACH, contents, "text", "plaintext");
                index++;
            }
            if(cfCarParkDevice.getBrand().equals(DeviceBrand.ZHEN_SHI) || cfCarParkDevice.getBrand().equals(DeviceBrand.QIAN_YI)){
                //臻识/千熠
                ZhenShiResponse911202002050 zhenShiResponse911202002050 = new ZhenShiResponse911202002050();
                cfCarParkUseLogService.setCameraOpenOrClose(zhenShiResponse911202002050, "on");
                cfCarParkUseLogService.showByDeviceRows(playRule, cfCarParkDevice, SeriaDataUtils.APPROACH);
                SeriaDataUtils.setSerialDataZhenshiByPlayRule(zhenShiResponse911202002050, playRule, SeriaDataUtils.APPROACH,"permanent");
                SeriaDataUtils.showZhenShiAd(zhenShiResponse911202002050, "00","00");
                object = zhenShiResponse911202002050;
            }else if(cfCarParkDevice.getBrand().equals(DeviceBrand.HUA_XIA)){
                //华夏
                HuaXiaResponse huaXiaResponse = new HuaXiaResponse();
                cfCarParkUseLogService.setCameraOpenOrClose(huaXiaResponse, "off");
                SeriaDataUtils.setSerialDataHuaXiaByPlayRule(huaXiaResponse, playRule, SeriaDataUtils.APPROACH,validityPeriod);
                object = huaXiaResponse;
            }else if(cfCarParkDevice.getBrand().equals(DeviceBrand.HK) || cfCarParkDevice.getBrand().equals(DeviceBrand.DH)){
                //不做任何操作
            }else{
                ExceptionCast.cast(CarParkCode.BRAND_DEVICES_THAT_IS_NOT_CURRENTLY_SUPPORTED);
            }
            iMqttDataService.pushTopics(serialNumber, JSON.toJSONString(object),"/device/" + serialNumber + "/command");
        }
    }
}
