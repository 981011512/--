package com.cf.charging.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.cf.charging.api.config.AuthenticationInterceptor;
import com.cf.charging.api.swagger.CfChargingStationSwagger;
import com.cf.charging.domain.CfChargingStation;
import com.cf.charging.domain.CfChargingStationLinkUser;
import com.cf.charging.domain.customize.CfChargingDeviceSetting;
import com.cf.charging.domain.customize.CfChargingState;
import com.cf.charging.domain.request.CfChargingStationDeviceForm;
import com.cf.charging.domain.request.CfChargingStationForm;
import com.cf.charging.domain.request.CfChargingStationLinkUserQuery;
import com.cf.charging.domain.request.CfChargingStationQuery;
import com.cf.charging.service.CfChargingStationBusinessService;
import com.cf.charging.service.CfChargingStationLinkUserService;
import com.cf.charging.service.CfChargingStationService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.framework.utils.StringTools;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("chargingStation/")
@Validated
@CrossOrigin
public class CfChargingStationController implements CfChargingStationSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfChargingStationService cfChargingStationService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfChargingStationLinkUserService cfCarParkLinkUserQuery;

    @Autowired
    protected HttpServletRequest request;

    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@Validated @RequestBody CfChargingStationForm cfChargingStationForm) throws Exception {
        CfChargingStation cfChargingStation = new CfChargingStation();
        BeanUtils.copyProperties(cfChargingStationForm,cfChargingStation);
        CfChargingStation lastCfChargingStation = cfChargingStationService.add(cfChargingStation);
        return new ResponseResult(CommonCode.SUCCESS, lastCfChargingStation);
    }

    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@Validated @RequestBody CfChargingStationForm cfChargingStationForm) {
        CfChargingStation cfChargingStation = new CfChargingStation();
        BeanUtils.copyProperties(cfChargingStationForm,cfChargingStation);
        CfChargingStation update = cfChargingStationService.update(cfChargingStation);
        return new ResponseResult(CommonCode.SUCCESS, update);
    }

    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(CfChargingStationQuery cfChargingStationQuery) throws Exception {
        List<CfChargingStation> cfChargingStations = cfChargingStationService.getListByQuery(cfChargingStationQuery);
        if(cfChargingStations==null || cfChargingStations.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfChargingStations);
    }

    @Override
    @RequestMapping(value = "selectContalDistanceListByQuery", method = RequestMethod.GET)
    public ResponseResult selectContalDistanceListByQuery(CfChargingStationQuery cfChargingStationQuery) throws Exception {
        if(cfChargingStationQuery.getPositionX()==null || cfChargingStationQuery.getPositionY()==null){
            return new ResponseResult(CommonCode.INVALID_PARAM, null, "请提供经纬度");
        }
        if(cfChargingStationQuery.getDistance()==null || cfChargingStationQuery.getDistance().doubleValue()<0d || cfChargingStationQuery.getDistance().doubleValue()>8000){
            return new ResponseResult(CommonCode.INVALID_PARAM, null, "只能拉取附近0-8000米的设备数据");
        }
        List<CfChargingStation> cfChargingStations = cfChargingStationService.selectContalDistanceListByQuery(cfChargingStationQuery);
        if(cfChargingStations==null || cfChargingStations.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfChargingStations);
    }
}
