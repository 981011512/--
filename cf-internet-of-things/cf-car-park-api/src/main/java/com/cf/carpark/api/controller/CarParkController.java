package com.cf.carpark.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.cf.carpark.api.swagger.CfCarParkSwagger;
import com.cf.carpark.domain.CfCarPark;
import com.cf.carpark.request.CfCarParkForm;
import com.cf.carpark.service.CfCarParkService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @Reference(version = "1.0.0", retries = 0, timeout = 10000)
    private CfCarParkService cfCarParkService;

    @Override
    @RequestMapping(value = "add", method = RequestMethod.PUT)
    public ResponseResult add(@Validated CfCarParkForm cfCarParkForm) {
        CfCarPark cfCarPark = new CfCarPark();
        BeanUtils.copyProperties(cfCarParkForm,cfCarPark);
        CfCarPark lastCfCarPark = cfCarParkService.add(cfCarPark);
        return new ResponseResult(CommonCode.SUCCESS, lastCfCarPark);
    }

    @Override
    @RequestMapping(value = "selectListByCondition", method = RequestMethod.GET)
    public ResponseResult selectListByCondition(String conditions) {
        Map conditionsMap = (JSONObject.parseObject(conditions));
        ArrayList<String> allowFileds = new ArrayList<>();
        allowFileds.add("id");
        allowFileds.add("name");
        allowFileds.add("status");
        allowFileds.add("country_id");
        allowFileds.add("province_id");
        allowFileds.add("state_or_city_id");
        allowFileds.add("zone_or_county_id");
        allowFileds.add("like");
        allowFileds.add("order");
        allowFileds.add("limit");
        Map<String, String> allowFiledsMap = new HashMap<String, String>();
        allowFiledsMap.put("id","cp");
        allowFiledsMap.put("name","cp");
        allowFiledsMap.put("status","cp");
        allowFiledsMap.put("country_id","cp");
        allowFiledsMap.put("province_id","cp");
        allowFiledsMap.put("state_or_city_id","cp");
        allowFiledsMap.put("zone_or_county_id","cp");
        allowFiledsMap.put("like","");
        allowFiledsMap.put("order","");
        allowFiledsMap.put("limit","");
        List<CfCarPark> cfCarParks = cfCarParkService.selectListByCondition(conditionsMap, allowFiledsMap,allowFileds);
        if(cfCarParks!=null && cfCarParks.size()>0){
            return new ResponseResult(CommonCode.SUCCESS, cfCarParks);
        }
        return new ResponseResult(CommonCode.NO_MORE_DATAS);
    }
}
