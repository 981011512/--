package com.cf.charging.api.controller;

import com.cf.charging.api.swagger.CfChargingStationRulesSwagger;
import com.cf.charging.domain.CfChargingStationRules;
import com.cf.charging.domain.request.CfChargingStationRulesQuery;
import com.cf.charging.service.CfChargingStationRulesService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("chargingRules/")
@Validated
@CrossOrigin
public class CfChargingStationRulesController implements CfChargingStationRulesSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfChargingStationRulesService cfChargingStationRulesService;

    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(CfChargingStationRulesQuery cfChargingStationRulesQuery) throws Exception {
        List<CfChargingStationRules> cfChargingStationRulesList = cfChargingStationRulesService.getListByQuery(cfChargingStationRulesQuery);
        if(cfChargingStationRulesList==null || cfChargingStationRulesList.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfChargingStationRulesList);
    }
}
