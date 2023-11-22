package com.cf.carpark.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.cf.carpark.admin.config.AuthenticationInterceptor;
import com.cf.carpark.admin.swagger.CfCarParkReleaseLogSwagger;
import com.cf.carpark.domain.*;
import com.cf.carpark.domain.request.*;
import com.cf.carpark.service.*;
import com.cf.framework.domain.carpark.response.CarParkCode;
import com.cf.framework.domain.report.CountByKeyAndValue;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.DateUtil;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.framework.utils.StringTools;
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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("carParkReleaseLogAdmin/")
@Validated
public class CfCarParkReleaseLogController implements CfCarParkReleaseLogSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCarParkReleaseLogService cfCarParkReleaseLogService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCarParkDeviceService cfCarParkDeviceService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCarParkCheckpointService cfCarParkCheckpointService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCarParkUseLogService cfCarParkUseLogService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCarParkDeviceLinkUserService cfCarParkDeviceLinkUserService;
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected CarParkController carParkController;

    public static Map<String, Long> checkPointOpenDoorLimit = new HashMap<>();  //岗亭开闸频率限制

    @PreAuthorize("hasAuthority('carpark-CfCarParkReleaseLogController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@RequestBody CfCarParkReleaseLogForm cfCarParkReleaseLogForm) throws Exception {
        CfCarParkReleaseLog cfCarParkReleaseLog = new CfCarParkReleaseLog();
        BeanUtils.copyProperties(cfCarParkReleaseLogForm, cfCarParkReleaseLog);
        CfCarParkReleaseLog carParkReleaseLog = cfCarParkReleaseLogService.add(cfCarParkReleaseLog, "");
        return new ResponseResult(CommonCode.SUCCESS, carParkReleaseLog);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkReleaseLogController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@RequestBody CfCarParkReleaseLogForm cfCarParkReleaseLogForm) {
        CfCarParkReleaseLog cfCarParkReleaseLog = new CfCarParkReleaseLog();
        BeanUtils.copyProperties(cfCarParkReleaseLogForm, cfCarParkReleaseLog);
        CfCarParkReleaseLog carParkReleaseLog = cfCarParkReleaseLogService.update(cfCarParkReleaseLog);
        return new ResponseResult(CommonCode.SUCCESS, carParkReleaseLog);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkReleaseLogController-selectListByCondition')")
    @Override
    @RequestMapping(value = "selectListByCondition", method = RequestMethod.GET)
    public ResponseResult selectListByCondition(String conditions) throws Exception {

        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));

        Map conditionsMap = (JSONObject.parseObject(conditions));
        ArrayList<String> allowFileds = new ArrayList<>();
        allowFileds.add("id");
        allowFileds.add("carpark_id");
        allowFileds.add("carpark_use_log_id");
        allowFileds.add("uid");
        allowFileds.add("device_serial_number");
        allowFileds.add("number_plate");
        allowFileds.add("application_time");
        allowFileds.add("execution_time");
        allowFileds.add("status");
        allowFileds.add("carpark_id$in");
        allowFileds.add("like");
        allowFileds.add("order");
        allowFileds.add("limit");
        Map<String, String> allowFiledsMap = new HashMap<String, String>();
        allowFiledsMap.put("id","cprl");
        allowFiledsMap.put("carpark_id","cprl");
        allowFiledsMap.put("carpark_use_log_id","cprl");
        allowFiledsMap.put("uid","cprl");
        allowFiledsMap.put("device_serial_number","cprl");
        allowFiledsMap.put("number_plate","cprl");
        allowFiledsMap.put("application_time","cprl");
        allowFiledsMap.put("execution_time","cprl");
        allowFiledsMap.put("status","cprl");
        allowFiledsMap.put("carpark_id$in","cpdv");
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
            String carParkIds = "";
            for (CfCarParkDeviceLinkUser cfCarParkDeviceLinkUser: cfCarParkDeviceLinkUserList){
                if(StringUtils.isEmpty(cfCarParkDeviceLinkUser.getCarParkId())){
                    continue;
                }
                carParkIds += ",'"+cfCarParkDeviceLinkUser.getCarParkId()+"'";
            }
            if(StringUtils.isNotEmpty(carParkIds)){
                carParkIds = carParkIds.substring(1);
            }
            if(StringUtils.isNotEmpty(carParkIds)){
                HashMap<String, String> valueMap = new HashMap<>();
                valueMap.put("operator","in");
                valueMap.put("value",carParkIds);
                conditionsMap.put("carpark_id$in", valueMap);
            }else{
                return new ResponseResult(CommonCode.NO_MORE_DATAS);
            }
        }

        List<CfCarParkUseLog> cfCarParks = cfCarParkReleaseLogService.selectListByCondition(conditionsMap, allowFiledsMap,allowFileds);
        Integer counts = cfCarParkReleaseLogService.selectListByConditionCounts(conditionsMap, allowFiledsMap, allowFileds);
        if(cfCarParks!=null && cfCarParks.size()>0){
            return new ResponseResult(CommonCode.SUCCESS, cfCarParks, null, counts);
        }
        return new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkReleaseLogController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(String id) {
        cfCarParkReleaseLogService.delete(id);
        return new ResponseResult(CommonCode.SUCCESS);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkReleaseLogController-releaseByCheckPointId')")
    @Override
    @RequestMapping(value = "releaseByCheckPointId", method = RequestMethod.POST)
    public ResponseResult releaseOrOffByCheckPointId(@RequestBody @Validated OpenDoor openDoor)throws Exception {

        //限制手动开闸频率3秒一次
        long currentTimeMillis = System.currentTimeMillis();
        if(!checkPointOpenDoorLimit.containsKey(openDoor.getCheckPointId()) || (currentTimeMillis-checkPointOpenDoorLimit.get(openDoor.getCheckPointId()))>3000 ){
            checkPointOpenDoorLimit.put(openDoor.getCheckPointId(), currentTimeMillis);
        }else{
            checkPointOpenDoorLimit.put(openDoor.getCheckPointId(), currentTimeMillis);
            return new ResponseResult(CommonCode.FREQUENT_OPERATION);
        }


        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));

        CfCarParkCheckpoint cfCarParkCheckpoint = cfCarParkCheckpointService.checkUserAuthOfCheckPoint(userBasicInfo, openDoor.getCheckPointId());

        CfCarParkReleaseLog cfCarParkReleaseLog = new CfCarParkReleaseLog();
        cfCarParkReleaseLog.setCarparkId(cfCarParkCheckpoint.getCarParkId());
        if(StringUtils.isEmpty(openDoor.getCarParkUseLogId())){
            cfCarParkReleaseLog.setCarparkUseLogId("");
        }else{
            cfCarParkReleaseLog.setCarparkUseLogId(openDoor.getCarParkUseLogId());
            if(StringUtils.isNotEmpty(openDoor.getRemarks())){
                CfCarParkUseLog cfCarParkUseLog = new CfCarParkUseLog();
                cfCarParkUseLog.setRemarks(openDoor.getRemarks());
                cfCarParkUseLog.setId(openDoor.getCarParkUseLogId());
                cfCarParkUseLogService.updateByPrimaryKeySelective(cfCarParkUseLog);
            }
        }

        cfCarParkReleaseLog.setNumberPlate("");
        cfCarParkReleaseLog.setUid(userBasicInfo.getId());
        //获取设备
        CfCarParkDeviceQuery cfCarParkDeviceQuery = new CfCarParkDeviceQuery();
        cfCarParkDeviceQuery.setCheckpointId(openDoor.getCheckPointId());
        cfCarParkDeviceQuery.setType((byte)2);
//        cfCarParkDeviceQuery.setDirection("out");
        List<CfCarParkDevice> cfCarParkDevices = cfCarParkDeviceService.getListByQuery(cfCarParkDeviceQuery);
        if(cfCarParkDevices==null || cfCarParkDevices.size()==0){
            ExceptionCast.cast(CarParkCode.DEVICE_IS_NOT_REGISTERED);
        }
        cfCarParkReleaseLog.setDeviceSerialNumber(cfCarParkDevices.get(0).getBarCode());
        cfCarParkReleaseLog.setApplicationTime(System.currentTimeMillis());
        cfCarParkReleaseLog.setApplicationReason(openDoor.getApplicationReason());
        cfCarParkReleaseLog.setExecutionTime(System.currentTimeMillis());
        cfCarParkReleaseLog.setStatus((byte)0);
        cfCarParkReleaseLog.setType(openDoor.getType());
        cfCarParkReleaseLog.setCfCarParkDevice(cfCarParkDevices.get(0));
        CfCarParkReleaseLog carParkReleaseLog = cfCarParkReleaseLogService.add(cfCarParkReleaseLog, openDoor.getRedisPreFix());
        return new ResponseResult(CommonCode.SUCCESS,carParkReleaseLog);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkReleaseLogController-countByQuery')")
    @Override
    @RequestMapping(value = "countByQuery", method = RequestMethod.GET)
    public ResponseResult countByQuery(CfCarParkReleaseLogQuery cfCarParkReleaseLogQuery)throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        if(cfCarParkReleaseLogQuery.getMinApplicationTime()==null || cfCarParkReleaseLogQuery.getMinApplicationTime()<=0){
            cfCarParkReleaseLogQuery.setMinApplicationTime(DateUtil.minMillisecondBaseOnTheDayToTimestamp(System.currentTimeMillis()));
        }
        if(cfCarParkReleaseLogQuery.getMaxApplicationTime()==null || cfCarParkReleaseLogQuery.getMaxApplicationTime()<=0){
            cfCarParkReleaseLogQuery.setMinApplicationTime(DateUtil.maxMillisecondBaseOnTheDayToTimestamp(System.currentTimeMillis()));
        }
        cfCarParkReleaseLogQuery.setUid(userBasicInfo.getId());
        Integer counts = cfCarParkReleaseLogService.getCountByQuery(cfCarParkReleaseLogQuery);
        return new ResponseResult(CommonCode.SUCCESS, counts);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkReleaseLogController-countAndOrder')")
    @Override
    @RequestMapping(value = "countAndOrder", method = RequestMethod.GET)
    public ResponseResult countAndOrder(Integer day) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        List<CfCarParkLinkUser> linkUsers = carParkController.getLinkUsersAndCheck(userBasicInfo);
        List<String> carParkIds = null;
        if(linkUsers!=null && linkUsers.size()>0){
            carParkIds = new ArrayList<>();
            for (CfCarParkLinkUser cfCarParkLinkUser: linkUsers){
                carParkIds.add(cfCarParkLinkUser.getCarParkId());
            }
        }
        List<CountByKeyAndValue> countByKeyAndValues = cfCarParkReleaseLogService.countAndOrder(day, carParkIds);
        return new ResponseResult(CommonCode.SUCCESS, countByKeyAndValues);
    }
}
