package com.cf.carpark.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.cf.carpark.api.swagger.CfCarParkSwagger;
import com.cf.carpark.device.camera.ZhenShi.SeriaDataUtils;
import com.cf.carpark.device.camera.ZhenShiResponse911202002050;
import com.cf.carpark.device.led.PlayRule;
import com.cf.carpark.domain.CfCarPark;
import com.cf.carpark.domain.CfCarParkChargingRules;
import com.cf.carpark.domain.request.CfCarParkChargingRulesQuery;
import com.cf.carpark.domain.request.CfCarParkForm;
import com.cf.carpark.domain.request.CfCarParkQuery;
import com.cf.carpark.service.CfCarParkChargingRulesService;
import com.cf.carpark.service.CfCarParkService;
import com.cf.carpark.service.IMqttDataService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请在此填写描述
 *
 * @ClassName CarParkController
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/3/14/014 9:47
 * @Version 1.0
 **/
@RestController
@RequestMapping("carpark/")
@Validated
public class CarParkController implements CfCarParkSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCarParkService cfCarParkService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCarParkChargingRulesService cfCarParkChargingRulesService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private IMqttDataService iMqttDataService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    @RequestMapping(value = "selectNearbyDatas", method = RequestMethod.GET)
    public ResponseResult selectNearbyDatas(BigDecimal positionX, BigDecimal positionY, Integer page, Integer limit) throws Exception {
        if(page>3 || limit>10){
            return new ResponseResult(CommonCode.INVALID_PARAM, null, "you got too much data !");
        }
        List<CfCarPark> cfCarParks = cfCarParkService.selectNearbyDatas(positionX, positionY, page, limit);
        if(cfCarParks==null || cfCarParks.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
//        CfCarParkChargingRulesQuery cfCarParkChargingRulesQuery = new CfCarParkChargingRulesQuery();
//        for(CfCarPark cfCarPark: cfCarParks){
//            cfCarParkChargingRulesQuery.setCarParkId(cfCarPark.getId());
//            cfCarPark.setCfCarParkChargingRules(cfCarParkChargingRulesService.getListByCondition(cfCarParkChargingRulesQuery));
//        }
        return new ResponseResult(CommonCode.SUCCESS, cfCarParks);
    }

    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(@Validated CfCarParkQuery cfCarParkQuery) throws Exception {
        if(cfCarParkQuery.getPage()>3 || cfCarParkQuery.getSize()>10){
            return new ResponseResult(CommonCode.INVALID_PARAM, null, "you got too much data !");
        }
        if(StringUtils.isNotEmpty(cfCarParkQuery.getName()) && cfCarParkQuery.getName().length()<2){
            return new ResponseResult(CommonCode.INVALID_PARAM, null, "请输入2个以上关键字进行搜索");
        }
        long currentTimeMillis = System.currentTimeMillis();
        cfCarParkQuery.setCurrentHourTime(DateUtil.getMillisecondBaseOnTheDay(currentTimeMillis));
        cfCarParkQuery.setCurrentTimeStamp(currentTimeMillis);
        List<CfCarPark> cfCarParks = cfCarParkService.selectContalDistanceListByQuery(cfCarParkQuery);
        if(cfCarParks==null || cfCarParks.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
//        CfCarParkChargingRulesQuery cfCarParkChargingRulesQuery = new CfCarParkChargingRulesQuery();
//        for(CfCarPark cfCarPark: cfCarParks){
//            cfCarParkChargingRulesQuery.setCarParkId(cfCarPark.getId());
//            cfCarPark.setCfCarParkChargingRules(cfCarParkChargingRulesService.getListByCondition(cfCarParkChargingRulesQuery));
//        }
        return new ResponseResult(CommonCode.SUCCESS, cfCarParks);
    }

    @Override
    @RequestMapping(value = "getCarParkChargingRules", method = RequestMethod.GET)
    public ResponseResult getCarParkChargingRules(String carParkId) throws Exception {
        CfCarParkChargingRulesQuery cfCarParkChargingRulesQuery = new CfCarParkChargingRulesQuery();
        cfCarParkChargingRulesQuery.setCarParkId(carParkId);
        List<CfCarParkChargingRules> cfCarParkChargingRules = cfCarParkChargingRulesService.getListByCondition(cfCarParkChargingRulesQuery);
        if(cfCarParkChargingRules!=null && cfCarParkChargingRules.size()>0){
            return new ResponseResult(CommonCode.SUCCESS, cfCarParkChargingRules);
        }
        return new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    @Override
    @RequestMapping(value = "selectContainDistanceListByCouponId", method = RequestMethod.GET)
    public ResponseResult selectContalDistanceListByCouponId(BigDecimal positionX, BigDecimal positionY, String couponId) throws Exception {
        List<CfCarPark> cfCarParks = cfCarParkService.selectContainDistanceListByCouponId(positionX, positionY, couponId);
        if(cfCarParks==null || cfCarParks.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfCarParks);
    }

    @Override
    @RequestMapping(value = "getMqttLinkIp")
    public String getMqttLinkIp() throws Exception {
        return iMqttDataService.getMinDeviceLinkCountsServiceIp();
    }

    @Override
    @RequestMapping(value = "test", method = RequestMethod.POST)
    public Object test() throws Exception {
        String playRuleString = "{\"approach\":{\"textPlay\":{\"1\":{\"type\":\"plaintext\",\"value\":\"大数据智能停车系统\",\"color\":\"green\",\"inMode\":\"right_to_left\",\"outMode\":\"right_to_left\",\"status\":1,\"serialChannel\":0},\"2\":{\"type\":\"plaintext\",\"value\":\"\",\"color\":\"yellow\",\"inMode\":\"buttom_to_top\",\"outMode\":\"buttom_to_top\",\"status\":0,\"serialChannel\":0},\"3\":{\"type\":\"plaintext\",\"value\":\"\",\"color\":\"red\",\"inMode\":\"top_to_buttom\",\"outMode\":\"top_to_buttom\",\"status\":0,\"serialChannel\":0},\"4\":{\"type\":\"plaintext\",\"value\":\"欢迎光临,请减速慢行\",\"color\":\"green\",\"inMode\":\"right_to_left\",\"outMode\":\"right_to_left\",\"status\":1,\"serialChannel\":0}},\"voicePlay\":{\"1\":{\"value\":\"\",\"playMode\":\"only_add\",\"status\":0,\"serialChannel\":0,\"type\":\"plaintext\"},\"2\":{\"value\":\"\",\"playMode\":\"only_add\",\"status\":0,\"serialChannel\":0,\"type\":\"plaintext\"},\"3\":{\"value\":\"欢迎光临\",\"playMode\":\"add_and_play\",\"status\":1,\"serialChannel\":0,\"type\":\"plaintext\"}},\"imagePlay\":\"\",\"videoPlay\":\"\",\"deviceModel\":\"miu_new\"},\"freeOut\":{\"textPlay\":{\"1\":{\"type\":\"plaintext\",\"value\":\"大数据智能停车系统\",\"color\":\"green\",\"inMode\":\"right_to_left\",\"outMode\":\"right_to_left\",\"status\":1,\"serialChannel\":0},\"2\":{\"type\":\"plaintext\",\"value\":\"\",\"color\":\"yellow\",\"inMode\":\"buttom_to_top\",\"outMode\":\"buttom_to_top\",\"status\":0,\"serialChannel\":0},\"3\":{\"type\":\"plaintext\",\"value\":\"\",\"color\":\"red\",\"inMode\":\"top_to_buttom\",\"outMode\":\"top_to_buttom\",\"status\":0,\"serialChannel\":0},\"4\":{\"type\":\"plaintext\",\"value\":\"欢迎光临,请减速慢行\",\"color\":\"green\",\"inMode\":\"right_to_left\",\"outMode\":\"right_to_left\",\"status\":1,\"serialChannel\":0}},\"voicePlay\":{\"1\":{\"value\":\"\",\"playMode\":\"only_add\",\"status\":0,\"serialChannel\":0,\"type\":\"plaintext\"},\"2\":{\"value\":\"\",\"playMode\":\"only_add\",\"status\":0,\"serialChannel\":0,\"type\":\"plaintext\"},\"3\":{\"value\":\"欢迎光临\",\"playMode\":\"add_and_play\",\"status\":1,\"serialChannel\":0,\"type\":\"plaintext\"}},\"imagePlay\":\"\",\"videoPlay\":\"\",\"deviceModel\":\"miu_new\"},\"payOut\":{\"textPlay\":{\"1\":{\"type\":\"plaintext\",\"value\":\"\",\"color\":\"green\",\"inMode\":\"right_to_left\",\"outMode\":\"right_to_left\",\"status\":0,\"serialChannel\":0},\"2\":{\"type\":\"plaintext\",\"value\":\"\",\"color\":\"yellow\",\"inMode\":\"buttom_to_top\",\"outMode\":\"buttom_to_top\",\"status\":0,\"serialChannel\":0},\"3\":{\"type\":\"fee\",\"value\":\"请缴费{$fee}元\",\"color\":\"red\",\"inMode\":\"right_to_left\",\"outMode\":\"right_to_left\",\"status\":0,\"serialChannel\":0},\"4\":{\"type\":\"duration\",\"value\":\"停车时长{$duration}\",\"color\":\"green\",\"inMode\":\"right_to_left\",\"outMode\":\"right_to_left\",\"status\":0,\"serialChannel\":0}},\"voicePlay\":{\"1\":{\"value\":\"\",\"playMode\":\"only_add\",\"status\":0,\"serialChannel\":0,\"type\":\"plaintext\"},\"2\":{\"value\":\"\",\"playMode\":\"only_add\",\"status\":0,\"serialChannel\":0,\"type\":\"plaintext\"},\"3\":{\"value\":\"请缴费{$fee}元\",\"playMode\":\"add_and_play\",\"status\":0,\"serialChannel\":0,\"type\":\"fee\"}},\"imagePlay\":\"\",\"videoPlay\":\"\",\"deviceModel\":\"miu_new\"},\"abnormalOut\":{\"textPlay\":{\"1\":{\"type\":\"plaintext\",\"value\":\"大数据智能停车系统\",\"color\":\"green\",\"inMode\":\"right_to_left\",\"outMode\":\"right_to_left\",\"status\":1,\"serialChannel\":0},\"2\":{\"type\":\"plaintext\",\"value\":\"\",\"color\":\"yellow\",\"inMode\":\"buttom_to_top\",\"outMode\":\"buttom_to_top\",\"status\":0,\"serialChannel\":0},\"3\":{\"type\":\"plaintext\",\"value\":\"\",\"color\":\"red\",\"inMode\":\"top_to_buttom\",\"outMode\":\"top_to_buttom\",\"status\":0,\"serialChannel\":0},\"4\":{\"type\":\"plaintext\",\"value\":\"欢迎光临,请减速慢行\",\"color\":\"green\",\"inMode\":\"right_to_left\",\"outMode\":\"right_to_left\",\"status\":1,\"serialChannel\":0}},\"voicePlay\":{\"1\":{\"value\":\"\",\"playMode\":\"only_add\",\"status\":0,\"serialChannel\":0,\"type\":\"plaintext\"},\"2\":{\"value\":\"\",\"playMode\":\"only_add\",\"status\":0,\"serialChannel\":0,\"type\":\"plaintext\"},\"3\":{\"value\":\"欢迎光临\",\"playMode\":\"add_and_play\",\"status\":1,\"serialChannel\":0,\"type\":\"plaintext\"}},\"imagePlay\":\"\",\"videoPlay\":\"\",\"deviceModel\":\"miu_new\"}}";

        PlayRule playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(playRuleString, "payOut", "京A88888", "text", "plaintext");

        playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), "payOut", "临时车", "text", "plaintext");

        playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), "payOut", "36.00", "text", "fee");

        playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), "payOut", "08小时56分24秒", "text", "duration");

        playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), "payOut", "京A88888", "voice", "plaintext");

        playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), "payOut", "临时车", "voice", "plaintext");

        playRule = SeriaDataUtils.setSerialDataZhenshiMultiple(JSONObject.toJSONString(playRule), "payOut", "36.00", "voice", "fee");

        ZhenShiResponse911202002050 zhenShiResponse911202002050 = new ZhenShiResponse911202002050();

        SeriaDataUtils.setSerialDataZhenshiByPlayRule(zhenShiResponse911202002050, playRule, "payOut","");

//        SeriaDataUtils.setSerialDataZhenshi(zhenShiResponse911202002050,"京A88888",0,(byte)1,"red","to_top","to_top","miu_new","text","");

//        SeriaDataUtils.setSerialDataZhenshi(zhenShiResponse911202002050,"京A88888",0,(byte)0,"","","","miu_new","voice","add_and_play");
//        SeriaDataUtils.setSerialDataZhenshi(zhenShiResponse911202002050,"月卡车",0,(byte)0,"","","","miu_new","voice","only_add");
//        SeriaDataUtils.setSerialDataZhenshi(zhenShiResponse911202002050,"请缴费12.00元",0,(byte)0,"","","","miu_new","voice","add_and_play");

        return zhenShiResponse911202002050;
    }
}
