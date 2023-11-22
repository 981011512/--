package com.cf.carpark.api.controller;

import com.cf.carpark.api.swagger.CfCarParkChargingRulesSwagger;
import com.cf.carpark.domain.CfCarParkChargingRules;
import com.cf.carpark.domain.request.CfCarParkChargingRulesQuery;
import com.cf.carpark.service.CfCarParkChargingRulesService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.utils.DateUtil;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("carparkChargingRules/")
@Validated
public class CfCarParkChargingRulesController implements CfCarParkChargingRulesSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCarParkChargingRulesService cfCarParkChargingRulesService;

    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(CfCarParkChargingRulesQuery cfCarParkChargingRulesQuery) throws Exception {
        List<CfCarParkChargingRules> cfCarParkChargingRules = cfCarParkChargingRulesService.getListByCondition(cfCarParkChargingRulesQuery);
        if(cfCarParkChargingRules==null || cfCarParkChargingRules.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        for(CfCarParkChargingRules chargingRules: cfCarParkChargingRules){
            chargingRules.setStartTime(DateUtil.minMillisecondBaseOnTheDayToTimestamp(System.currentTimeMillis())+chargingRules.getStartTime());
            chargingRules.setEndTime(DateUtil.minMillisecondBaseOnTheDayToTimestamp(System.currentTimeMillis())+chargingRules.getEndTime());
        }
        return new ResponseResult(CommonCode.SUCCESS, cfCarParkChargingRules);
    }
}
