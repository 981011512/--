package com.cf.charging.api.controller;

import com.cf.charging.api.swagger.CfChargingPortSwagger;
import com.cf.charging.domain.CfChargingPort;
import com.cf.charging.domain.request.CfChargingPortQuery;
import com.cf.charging.service.CfChargingPortService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("chargingPort/")
@Validated
@CrossOrigin
public class CfChargingPortController implements CfChargingPortSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfChargingPortService cfChargingPortService;

    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(CfChargingPortQuery cfChargingPortQuery) throws Exception {
        if(StringUtils.isEmpty(cfChargingPortQuery.getChargingDeviceId())){
            return new ResponseResult(CommonCode.INVALID_PARAM, null, "请提供充电桩id");
        }
        List<CfChargingPort> cfChargingPortList = cfChargingPortService.getListByQuery(cfChargingPortQuery);
        if(cfChargingPortList==null || cfChargingPortList.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfChargingPortList);
    }
}
