package com.cf.charging.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.cf.charging.admin.config.AuthenticationInterceptor;
import com.cf.charging.admin.swagger.CfChargingStationSwagger;
import com.cf.charging.domain.CfChargingStation;
import com.cf.charging.domain.CfChargingStationLinkUser;
import com.cf.charging.domain.request.CfChargingStationForm;
import com.cf.charging.domain.request.CfChargingStationLinkUserQuery;
import com.cf.charging.domain.request.CfChargingStationQuery;
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
@RequestMapping("chargingStationAdmin/")
@Validated
@CrossOrigin
public class CfChargingStationController implements CfChargingStationSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfChargingStationService cfChargingStationService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfChargingStationLinkUserService cfChargingStationLinkUserService;
    @Autowired
    protected HttpServletRequest request;

    @PreAuthorize("hasAuthority('charging-CfChargingStationController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@Validated @RequestBody CfChargingStationForm cfChargingStationForm) throws Exception {
        CfChargingStation cfChargingStation = new CfChargingStation();
        BeanUtils.copyProperties(cfChargingStationForm,cfChargingStation);
        CfChargingStation lastCfChargingStation = cfChargingStationService.add(cfChargingStation);
        return new ResponseResult(CommonCode.SUCCESS, lastCfChargingStation);
    }

    @PreAuthorize("hasAuthority('charging-CfChargingStationController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@Validated @RequestBody CfChargingStationForm cfChargingStationForm) {
        CfChargingStation cfChargingStation = new CfChargingStation();
        BeanUtils.copyProperties(cfChargingStationForm,cfChargingStation);
        CfChargingStation update = cfChargingStationService.update(cfChargingStation);
        return new ResponseResult(CommonCode.SUCCESS, update);
    }

    @PreAuthorize("hasAuthority('charging-CfChargingStationController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(String id) {
        Integer delete = cfChargingStationService.delete(id);
        return delete>0?new ResponseResult(CommonCode.SUCCESS, delete):new ResponseResult(CommonCode.FAIL, null);
    }

    @PreAuthorize("hasAuthority('charging-CfChargingStationController-selectListByCondition')")
    @Override
    @RequestMapping(value = "selectListByCondition", method = RequestMethod.GET)
    public ResponseResult selectListByCondition(String conditions) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));

        Map conditionsMap = JSONObject.parseObject(conditions);
        ArrayList<String> allowFileds = new ArrayList<>();
        allowFileds.add("id");
        allowFileds.add("station_name");
        allowFileds.add("status");
        allowFileds.add("country_id");
        allowFileds.add("province_id");
        allowFileds.add("state_or_city_id");
        allowFileds.add("zone_or_county_id");
        allowFileds.add("id$in");
        allowFileds.add("like");
        allowFileds.add("group");
        allowFileds.add("order");
        allowFileds.add("limit");
        Map<String, String> allowFiledsMap = new HashMap<String, String>();
        allowFiledsMap.put("id","cst");
        allowFiledsMap.put("station_name","cst");
        allowFiledsMap.put("status","cst");
        allowFiledsMap.put("country_id","cst");
        allowFiledsMap.put("province_id","cst");
        allowFiledsMap.put("state_or_city_id","cst");
        allowFiledsMap.put("zone_or_county_id","cst");
        allowFiledsMap.put("id$in","cst");
        allowFiledsMap.put("like","");
        allowFiledsMap.put("group","");
        allowFiledsMap.put("order","");
        allowFiledsMap.put("limit","");
        if(StringTools.findStringInArray(userBasicInfo.getRoleFlag().split(","), "admin")<0 && StringTools.findStringInArray(userBasicInfo.getRoleFlag().split(","), "finance")<0){
            CfChargingStationLinkUserQuery cfChargingStationLinkUserQuery = new CfChargingStationLinkUserQuery();
            cfChargingStationLinkUserQuery.setUid(userBasicInfo.getId());
            List<CfChargingStationLinkUser> cfChargingStationLinkUsers = cfChargingStationLinkUserService.getListByQuery(cfChargingStationLinkUserQuery);
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
            conditionsMap.put("id$in", valueMap);
        }
        List<CfChargingStation> cfChargingStations = cfChargingStationService.selectListByCondition(conditionsMap, allowFiledsMap,allowFileds);
        Integer counts = cfChargingStationService.selectListByConditionCounts(conditionsMap, allowFiledsMap, allowFileds);
        if(cfChargingStations!=null && cfChargingStations.size()>0){
            return new ResponseResult(CommonCode.SUCCESS, cfChargingStations, null, counts);
        }
        return new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    @PreAuthorize("hasAuthority('charging-CfChargingStationController-getListByQuery')")
    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(CfChargingStationQuery cfChargingStationQuery) throws Exception {
        List<CfChargingStation> cfChargingStations = cfChargingStationService.getListByQuery(cfChargingStationQuery);
        if(cfChargingStations==null || cfChargingStations.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfChargingStations);
    }
}
