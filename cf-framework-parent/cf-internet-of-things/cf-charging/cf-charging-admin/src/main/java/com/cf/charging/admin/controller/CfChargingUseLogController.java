package com.cf.charging.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.cf.charging.admin.config.AuthenticationInterceptor;
import com.cf.charging.admin.swagger.CfChargingUseLogSwagger;
import com.cf.charging.domain.CfChargingPort;
import com.cf.charging.domain.CfChargingStationLinkUser;
import com.cf.charging.domain.CfChargingUseLog;
import com.cf.charging.domain.request.CfChargingStationLinkUserQuery;
import com.cf.charging.domain.request.CfChargingUseLogForm;
import com.cf.charging.service.CfChargingStationLinkUserService;
import com.cf.charging.service.CfChargingUseLogService;
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
@RequestMapping("chargingUseLogAdmin/")
@Validated
@CrossOrigin
public class CfChargingUseLogController implements CfChargingUseLogSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfChargingStationLinkUserService cfCarParkLinkUserQuery;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfChargingUseLogService cfChargingUseLogService;
    @Autowired
    protected HttpServletRequest request;

    @PreAuthorize("hasAuthority('charging-CfChargingUseLogController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@Validated @RequestBody CfChargingUseLogForm cfChargingUseLogForm) throws Exception {
        CfChargingUseLog cfChargingUseLog = new CfChargingUseLog();
        BeanUtils.copyProperties(cfChargingUseLogForm,cfChargingUseLog);
        CfChargingUseLog lastCfChargingUseLog = cfChargingUseLogService.add(cfChargingUseLog);
        return new ResponseResult(CommonCode.SUCCESS, lastCfChargingUseLog);
    }

    @PreAuthorize("hasAuthority('charging-CfChargingUseLogController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@Validated @RequestBody CfChargingUseLogForm cfChargingUseLogForm) {
        CfChargingUseLog cfChargingUseLog = new CfChargingUseLog();
        BeanUtils.copyProperties(cfChargingUseLogForm,cfChargingUseLog);
        CfChargingUseLog lastCfChargingUseLog = cfChargingUseLogService.update(cfChargingUseLog);
        return new ResponseResult(CommonCode.SUCCESS, lastCfChargingUseLog);
    }

    @PreAuthorize("hasAuthority('charging-CfChargingUseLogController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(String id) throws Exception {
        Integer delete = cfChargingUseLogService.delete(id);
        return delete>0?new ResponseResult(CommonCode.SUCCESS, delete):new ResponseResult(CommonCode.FAIL, null);
    }

    @PreAuthorize("hasAuthority('charging-CfChargingUseLogController-selectListByCondition')")
    @Override
    @RequestMapping(value = "selectListByCondition", method = RequestMethod.GET)
    public ResponseResult selectListByCondition(String conditions) throws Exception {

        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));

        Map conditionsMap = JSONObject.parseObject(conditions);
        ArrayList<String> allowFileds = new ArrayList<>();
        allowFileds.add("id");
        allowFileds.add("charging_station_id");
        allowFileds.add("start_time");
        allowFileds.add("end_time");
        allowFileds.add("uid");
        allowFileds.add("id$in");
        allowFileds.add("charging_station_id$in");
        allowFileds.add("station_name");
        allowFileds.add("like");
        allowFileds.add("group");
        allowFileds.add("order");
        allowFileds.add("limit");
        Map<String, String> allowFiledsMap = new HashMap<String, String>();
        allowFiledsMap.put("id","cstul");
        allowFiledsMap.put("charging_station_id","cstul");
        allowFiledsMap.put("start_time","cstul");
        allowFiledsMap.put("end_time","cstul");
        allowFiledsMap.put("uid","cstul");
        allowFiledsMap.put("id$in","cstul");
        allowFiledsMap.put("charging_station_id$in","cstul");
        allowFiledsMap.put("station_name","cst");
        allowFiledsMap.put("like","");
        allowFiledsMap.put("group","");
        allowFiledsMap.put("order","");
        allowFiledsMap.put("limit","");

        if(StringTools.findStringInArray(userBasicInfo.getRoleFlag().split(","), "admin")<0 && StringTools.findStringInArray(userBasicInfo.getRoleFlag().split(","), "finance")<0){
            CfChargingStationLinkUserQuery cfChargingStationLinkUserQuery = new CfChargingStationLinkUserQuery();
            cfChargingStationLinkUserQuery.setUid(userBasicInfo.getId());
            List<CfChargingStationLinkUser> cfChargingStationLinkUsers = cfCarParkLinkUserQuery.getListByQuery(cfChargingStationLinkUserQuery);
            if(cfChargingStationLinkUsers==null || cfChargingStationLinkUsers.size()==0){
                return new ResponseResult(CommonCode.NO_MORE_DATAS);
            }
            String chargingStationIds = "";
            for (CfChargingStationLinkUser cfChargingStationLinkUser: cfChargingStationLinkUsers){
                chargingStationIds += ",'"+cfChargingStationLinkUser.getChargingStationId()+"'";
            }
            HashMap<String, String> valueMap = new HashMap<>();
            valueMap.put("operator","in");
            valueMap.put("value",chargingStationIds.substring(1));
            conditionsMap.put("charging_station_id$in", valueMap);
        }

        List<CfChargingPort> cfChargingPortList = cfChargingUseLogService.selectListByCondition(conditionsMap, allowFiledsMap,allowFileds);

        if(cfChargingPortList==null || cfChargingPortList.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null, 0);
        }
        Integer counts = cfChargingUseLogService.selectListByConditionCounts(conditionsMap, allowFiledsMap, allowFileds);
        return new ResponseResult(CommonCode.SUCCESS, cfChargingPortList, counts);
    }
}
