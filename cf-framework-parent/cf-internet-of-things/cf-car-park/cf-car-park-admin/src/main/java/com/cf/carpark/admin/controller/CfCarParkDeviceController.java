package com.cf.carpark.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.cf.carpark.admin.config.AuthenticationInterceptor;
import com.cf.carpark.admin.swagger.CfCarParkDeviceSwagger;
import com.cf.carpark.domain.CfCarParkDevice;
import com.cf.carpark.domain.CfCarParkDeviceLinkUser;
import com.cf.carpark.domain.request.*;
import com.cf.carpark.domain.type.DeviceType;
import com.cf.carpark.service.CfCarParkDeviceLinkUserService;
import com.cf.carpark.service.CfCarParkDeviceService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.AuthToken;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.framework.utils.StringTools;
import com.cf.ucenter.service.AuthService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请在此填写描述
 *
 * @ClassName CfCarParkDeviceController
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/19/019 22:12
 * @Version 1.0
 **/
@RestController
@RequestMapping("carparkDeviceAdmin/")
@Validated
public class CfCarParkDeviceController implements CfCarParkDeviceSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCarParkDeviceService cfCarParkDeviceService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private AuthService authService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCarParkDeviceLinkUserService cfCarParkDeviceLinkUserService;
    @Autowired
    protected HttpServletRequest request;

    @PreAuthorize("hasAuthority('carpark-CfCarParkDeviceController-selectListByCondition')")
    @Override
    @RequestMapping(value = "selectListByCondition", method = RequestMethod.GET)
    public ResponseResult selectListByCondition(String conditions) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        Map conditionsMap = (JSONObject.parseObject(conditions));
        ArrayList<String> allowFileds = new ArrayList<>();
        allowFileds.add("id");
        allowFileds.add("car_park_id");
        allowFileds.add("bar_code");
        allowFileds.add("model");
        allowFileds.add("brand");
        allowFileds.add("vendor_id");
        allowFileds.add("status");
        allowFileds.add("last_online_time");
        allowFileds.add("link_mode");
        allowFileds.add("type");
        allowFileds.add("checkpoint_id");
        allowFileds.add("direction");
        allowFileds.add("id$in");
        allowFileds.add("like");
        allowFileds.add("order");
        allowFileds.add("limit");
        Map<String, String> allowFiledsMap = new HashMap<String, String>();
        allowFiledsMap.put("id","cpdv");
        allowFiledsMap.put("car_park_id","cpdv");
        allowFiledsMap.put("bar_code","cpdv");
        allowFiledsMap.put("model","cpdv");
        allowFiledsMap.put("brand","cpdv");
        allowFiledsMap.put("vendor_id","cpdv");
        allowFiledsMap.put("status","cpdv");
        allowFiledsMap.put("last_online_time","cpdv");
        allowFiledsMap.put("link_mode","cpdv");
        allowFiledsMap.put("type","cpdv");
        allowFiledsMap.put("checkpoint_id","cpdv");
        allowFiledsMap.put("direction","cpdv");
        allowFiledsMap.put("id$in","cpdv");
        allowFiledsMap.put("like","");
        allowFiledsMap.put("order","");
        allowFiledsMap.put("limit","");

        if(StringTools.findStringInArray(userBasicInfo.getRoleFlag().split(","), "admin")<0){
            CfCarParkDeviceLinkUserQuery cfCarParkDeviceLinkUserQuery = new CfCarParkDeviceLinkUserQuery();
            cfCarParkDeviceLinkUserQuery.setUid(userBasicInfo.getId());
            List<CfCarParkDeviceLinkUser> cfCarParkDeviceLinkUserList = cfCarParkDeviceLinkUserService.getListByQuery(cfCarParkDeviceLinkUserQuery);
            if(cfCarParkDeviceLinkUserList==null || cfCarParkDeviceLinkUserList.size()==0){
                ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
            }
            String deviceIds = "";
            for (CfCarParkDeviceLinkUser cfCarParkDeviceLinkUser: cfCarParkDeviceLinkUserList){
                if(StringUtils.isEmpty(cfCarParkDeviceLinkUser.getDeviceId())){
                    continue;
                }
                deviceIds += ",'"+cfCarParkDeviceLinkUser.getDeviceId()+"'";
            }
            if(StringUtils.isNotEmpty(deviceIds)){
                deviceIds = deviceIds.substring(1);
            }

            if(StringUtils.isNotEmpty(deviceIds)){
                HashMap<String, String> valueMap = new HashMap<>();
                valueMap.put("operator","in");
                valueMap.put("value",deviceIds);
                conditionsMap.put("id$in", valueMap);
            }else{
                return new ResponseResult(CommonCode.NO_MORE_DATAS);
            }
        }

        List<CfCarParkDevice> cfCarParkDevices = cfCarParkDeviceService.selectListByCondition(conditionsMap, allowFiledsMap,allowFileds);
        Integer counts = cfCarParkDeviceService.selectListByConditionCounts(conditionsMap, allowFiledsMap, allowFileds);
        if(cfCarParkDevices!=null && cfCarParkDevices.size()>0){
            return new ResponseResult(CommonCode.SUCCESS, cfCarParkDevices, null, counts);
        }
        return new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkDeviceController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@Validated @RequestBody CfCarParkDeviceForm cfCarParkDeviceForm) {
        CfCarParkDevice cfCarParkDevice = new CfCarParkDevice();
        BeanUtils.copyProperties(cfCarParkDeviceForm, cfCarParkDevice);
        CfCarParkDevice carParkDevice = cfCarParkDeviceService.add(cfCarParkDevice);
        return new ResponseResult(CommonCode.SUCCESS, carParkDevice);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkDeviceController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@Validated @RequestBody CfCarParkDeviceForm cfCarParkDeviceForm) {
        CfCarParkDevice cfCarParkDevice = new CfCarParkDevice();
        BeanUtils.copyProperties(cfCarParkDeviceForm, cfCarParkDevice);
        CfCarParkDevice carParkDevice = cfCarParkDeviceService.update(cfCarParkDevice);
        return new ResponseResult(CommonCode.SUCCESS, carParkDevice);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkDeviceController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(String id) {
        Integer delete = cfCarParkDeviceService.delete(id);
        if(delete>0){
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkDeviceController-getListByQuery')")
    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(CfCarParkDeviceQuery cfCarParkDeviceQuery) {
        List<CfCarParkDevice> cfCarParkDevices = cfCarParkDeviceService.getListByQuery(cfCarParkDeviceQuery);
        if(cfCarParkDevices!=null && cfCarParkDevices.size()>0){
            return new ResponseResult(CommonCode.SUCCESS, cfCarParkDevices);
        }
        return new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    @Override
    @RequestMapping(value = "getListByMacAddress", method = RequestMethod.GET)
    public ResponseResult getListByMacAddress(String macAddress) {
        if(StringUtils.isEmpty(macAddress)){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        CfCarParkDeviceQuery cfCarParkDeviceQuery = new CfCarParkDeviceQuery();
        cfCarParkDeviceQuery.setMacAddress(macAddress);
        List<CfCarParkDevice> cfCarParkDevices = cfCarParkDeviceService.getListByQuery(cfCarParkDeviceQuery);
        if(cfCarParkDevices!=null && cfCarParkDevices.size()>0){
            return new ResponseResult(CommonCode.SUCCESS, cfCarParkDevices);
        }
        return new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    @Override
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseResult login(@RequestBody CfCarParkDeviceLogin cfCarParkDeviceLogin) {
        CfCarParkDeviceQuery cfCarParkDeviceQuery = new CfCarParkDeviceQuery();
        cfCarParkDeviceQuery.setUsername(cfCarParkDeviceLogin.getUsername());
        cfCarParkDeviceQuery.setPassword(cfCarParkDeviceLogin.getPassword());
        cfCarParkDeviceQuery.setBarCode(cfCarParkDeviceLogin.getSn());
        List<CfCarParkDevice> cfCarParkDevices = cfCarParkDeviceService.getListByQuery(cfCarParkDeviceQuery);
        if(cfCarParkDevices==null || cfCarParkDevices.size()==0){
            return new ResponseResult(CommonCode.FAIL);
        }

        UserBasicInfo userBasicInfo = new UserBasicInfo();
        userBasicInfo.setId(cfCarParkDevices.get(0).getId());
        userBasicInfo.setUsername(cfCarParkDevices.get(0).getBarCode());
        userBasicInfo.setAuthorities(new ArrayList<>());
        AuthToken authToken = authService.createJwtToken(userBasicInfo);
        userBasicInfo.setExp(2592000000l);
        return new ResponseResult(CommonCode.SUCCESS, null, authToken, 0);
    }

    @Override
    @RequestMapping(value = "controlledLockUpAndDown", method = RequestMethod.GET)
    public ResponseResult controlledLockUpAndDown(String action, String serialNumber) throws Exception {
        cfCarParkDeviceService.controlledLockUpAndDown(action,serialNumber);
        return new ResponseResult(CommonCode.SUCCESS, null);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkDeviceController-publishLedAd')")
    @Override
    @RequestMapping(value = "publishLedAd", method = RequestMethod.PUT)
    public ResponseResult publishLedAd(@RequestBody PublishLedAd publishLedAd) throws Exception {
        cfCarParkDeviceService.publishLedAd(publishLedAd.getSerialNumber(),publishLedAd.getAdList(),publishLedAd.getValidityPeriod());
        return new ResponseResult(CommonCode.SUCCESS, null);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkDeviceController-count')")
    @Override
    @RequestMapping(value = "count", method = RequestMethod.GET)
    public ResponseResult count() throws Exception {
        Map<String, Integer> result = new HashMap<>();
        //获取数量
        CfCarParkDeviceQuery cfCarParkDeviceQuery = new CfCarParkDeviceQuery();
        cfCarParkDeviceQuery.setType(DeviceType.LICENSE_PLATE_RECOGNITION_CAMERA);
        Integer counts = cfCarParkDeviceService.countByQuery(cfCarParkDeviceQuery);
        result.put("license_plate_recognition_camera",counts);

        cfCarParkDeviceQuery.setType(DeviceType.FLOOR_LOCK);
        counts = cfCarParkDeviceService.countByQuery(cfCarParkDeviceQuery);
        result.put("floor_lock",counts);

        cfCarParkDeviceQuery.setType(DeviceType.HIGH_POSITION_CAMERA);
        counts = cfCarParkDeviceService.countByQuery(cfCarParkDeviceQuery);
        result.put("high_position_camera",counts);

        //获取在线数量
        cfCarParkDeviceQuery.setType(DeviceType.LICENSE_PLATE_RECOGNITION_CAMERA);
        cfCarParkDeviceQuery.setStatus((byte)1);
        counts = cfCarParkDeviceService.countByQuery(cfCarParkDeviceQuery);
        result.put("license_plate_recognition_camera_online",counts);

        cfCarParkDeviceQuery.setType(DeviceType.FLOOR_LOCK);
        counts = cfCarParkDeviceService.countByQuery(cfCarParkDeviceQuery);
        result.put("floor_lock_online",counts);

        cfCarParkDeviceQuery.setType(DeviceType.HIGH_POSITION_CAMERA);
        counts = cfCarParkDeviceService.countByQuery(cfCarParkDeviceQuery);
        result.put("high_position_camera_online",counts);
        return new ResponseResult(CommonCode.SUCCESS, result);
    }
}
