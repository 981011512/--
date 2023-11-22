package com.cf.carpark.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.cf.carpark.admin.config.AuthenticationInterceptor;
import com.cf.carpark.admin.swagger.CfCarParkSwagger;
import com.cf.carpark.domain.*;
import com.cf.carpark.domain.ext.CfCarParkOrder;
import com.cf.carpark.domain.request.*;
import com.cf.carpark.service.CfCarParkChargingRulesService;
import com.cf.carpark.service.CfCarParkLinkUserService;
import com.cf.carpark.service.CfCarParkService;
import com.cf.carpark.service.CfDailyParkingStatistcsService;
import com.cf.framework.domain.carpark.response.CarParkCode;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.DateUtil;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.framework.utils.StringTools;
import com.cf.pay.domain.request.CfOrderQuery;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("carparkAdmin/")
@Validated
@CrossOrigin
public class CarParkController implements CfCarParkSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 60000, check = false)
    private CfCarParkService cfCarParkService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCarParkLinkUserService cfCarParkLinkUserService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCarParkChargingRulesService cfCarParkChargingRulesService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfDailyParkingStatistcsService cfDailyParkingStatistcsService;
    @Autowired
    protected HttpServletRequest request;

    @PreAuthorize("hasAuthority('carpark-CarParkController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@Validated @RequestBody CfCarParkForm cfCarParkForm) throws Exception{
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        CfCarPark cfCarPark = new CfCarPark();
        BeanUtils.copyProperties(cfCarParkForm,cfCarPark);
        cfCarPark.setCreaterId(userBasicInfo.getId());
        CfCarPark lastCfCarPark = cfCarParkService.add(cfCarPark);
        return new ResponseResult(CommonCode.SUCCESS, lastCfCarPark);
    }

    @PreAuthorize("hasAuthority('carpark-CarParkController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(String id) throws Exception {
        Integer delete = cfCarParkService.delete(id);
        return delete>0 ? new ResponseResult(CommonCode.SUCCESS) : new ResponseResult(CommonCode.FAIL);
    }

    @PreAuthorize("hasAuthority('carpark-CarParkController-addChargingRules')")
    @Override
    @RequestMapping(value = "addChargingRules", method = RequestMethod.POST)
    public ResponseResult addChargingRules(@RequestBody CfCarParkChargingRulesForm cfCarParkChargingRulesForm) throws Exception {
        CfCarParkChargingRules cfCarParkChargingRules = new CfCarParkChargingRules();
        BeanUtils.copyProperties(cfCarParkChargingRulesForm,cfCarParkChargingRules);
        CfCarParkChargingRules lastCfCarParkChargingRules = cfCarParkChargingRulesService.add(cfCarParkChargingRules);
        return new ResponseResult(CommonCode.SUCCESS, lastCfCarParkChargingRules);
    }

    @PreAuthorize("hasAuthority('carpark-CarParkController-updateChargingRules')")
    @Override
    @RequestMapping(value = "updateChargingRules", method = RequestMethod.PUT)
    public ResponseResult updateChargingRules(@RequestBody CfCarParkChargingRulesForm cfCarParkChargingRulesForm) throws Exception {
        CfCarParkChargingRules cfCarParkChargingRules = new CfCarParkChargingRules();
        BeanUtils.copyProperties(cfCarParkChargingRulesForm,cfCarParkChargingRules);
        CfCarParkChargingRules lastCfCarParkChargingRules = cfCarParkChargingRulesService.update(cfCarParkChargingRules);
        return new ResponseResult(CommonCode.SUCCESS, lastCfCarParkChargingRules);
    }

    @PreAuthorize("hasAuthority('carpark-CarParkController-deleteChargingRules')")
    @Override
    @RequestMapping(value = "deleteChargingRules", method = RequestMethod.DELETE)
    public ResponseResult deleteChargingRules(String cfCarParkChargingRulesId) {
        Integer integer = cfCarParkChargingRulesService.delete(cfCarParkChargingRulesId);
        if(integer==0){
            return new ResponseResult(CommonCode.FAIL);
        }
        return new ResponseResult(CommonCode.SUCCESS);
    }

    @PreAuthorize("hasAuthority('carpark-CarParkController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@Validated @RequestBody CfCarParkForm cfCarParkForm) {
        CfCarPark cfCarPark = new CfCarPark();
        BeanUtils.copyProperties(cfCarParkForm,cfCarPark);
        CfCarPark lastCfCarPark = cfCarParkService.update(cfCarPark);
        return new ResponseResult(CommonCode.SUCCESS, lastCfCarPark);
    }

    @PreAuthorize("hasAuthority('carpark-CarParkController-selectListByCondition')")
    @Override
    @RequestMapping(value = "selectListByCondition", method = RequestMethod.GET)
    public ResponseResult selectListByCondition(String conditions) throws Exception {

        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));

        Map conditionsMap = JSONObject.parseObject(conditions);
        ArrayList<String> allowFileds = new ArrayList<>();
        allowFileds.add("id");
        allowFileds.add("name");
        allowFileds.add("status");
        allowFileds.add("country_id");
        allowFileds.add("province_id");
        allowFileds.add("state_or_city_id");
        allowFileds.add("zone_or_county_id");
        allowFileds.add("creater_id");
        allowFileds.add("phone");
        allowFileds.add("id$in");
        allowFileds.add("like");
        allowFileds.add("group");
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
        allowFiledsMap.put("creater_id","cp");
        allowFiledsMap.put("phone","cp");
        allowFiledsMap.put("id$in","cp");
        allowFiledsMap.put("like","");
        allowFiledsMap.put("group","");
        allowFiledsMap.put("order","");
        allowFiledsMap.put("limit","");
        if(StringTools.findStringInArray(userBasicInfo.getRoleFlag().split(","), "admin")<0 && StringTools.findStringInArray(userBasicInfo.getRoleFlag().split(","), "finance")<0){
            CfCarParkLinkUserQuery cfCarParkLinkUserQuery = new CfCarParkLinkUserQuery();
            cfCarParkLinkUserQuery.setUid(userBasicInfo.getId());
            List<CfCarParkLinkUser> cfCarParkLinkUsers = cfCarParkLinkUserService.getListByQuery(cfCarParkLinkUserQuery);
            if(cfCarParkLinkUsers==null || cfCarParkLinkUsers.size()==0){
                return new ResponseResult(CommonCode.NO_MORE_DATAS);
            }
            String carParkIds = "";
            for (CfCarParkLinkUser cfCarParkLinkUser: cfCarParkLinkUsers){
                if(StringUtils.isEmpty(cfCarParkLinkUser.getCarParkId())){
                    continue;
                }
                carParkIds += ",'"+cfCarParkLinkUser.getCarParkId()+"'";
            }

            if(StringUtils.isNotEmpty(carParkIds)){
                carParkIds = carParkIds.substring(1);
            }

            if(StringUtils.isNotEmpty(carParkIds)){
                HashMap<String, String> valueMap = new HashMap<>();
                valueMap.put("operator","in");
                valueMap.put("value",carParkIds);
                conditionsMap.put("id$in", valueMap);
            }else{
                return new ResponseResult(CommonCode.NO_MORE_DATAS);
            }
        }
        List<CfCarPark> cfCarParks = cfCarParkService.selectListByCondition(conditionsMap, allowFiledsMap,allowFileds);
        Integer counts = cfCarParkService.selectListByConditionCounts(conditionsMap, allowFiledsMap, allowFileds);
        if(cfCarParks!=null && cfCarParks.size()>0){
            return new ResponseResult(CommonCode.SUCCESS, cfCarParks, null, counts);
        }
        return new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    @Override
    @PreAuthorize("hasAuthority('carpark-CarParkController-getListByQuery')")
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(CfCarParkQuery cfCarParkQuery) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        List<CfCarParkLinkUser> linkUsers = getLinkUsersAndCheck(userBasicInfo);

        if(linkUsers!=null && linkUsers.size()>0){
            if(cfCarParkQuery.getIds()==null){
                cfCarParkQuery.setIds(new ArrayList<>());
            }
            for(CfCarParkLinkUser cfCarParkLinkUser: linkUsers){
                cfCarParkQuery.getIds().add(cfCarParkLinkUser.getCarParkId());
            }
        }

        List<CfCarPark> carParks = cfCarParkService.getListByQuery(cfCarParkQuery);
        if(carParks==null || carParks.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, carParks);
    }

    @Override
    @PreAuthorize("hasAuthority('carpark-CarParkController-deBugCalculateTheAmounPayable')")
    @RequestMapping(value = "deBugCalculateTheAmounPayable", method = RequestMethod.GET)
    public BigDecimal deBugCalculateTheAmounPayable(CfCarParkUseLog cfCarParkUseLog) throws Exception {
        cfCarParkUseLog.setCountFeeStatus((byte)1);
        CfCarParkOrder cfCarParkOrder = cfCarParkChargingRulesService.deBugCalculateTheAmounPayable(cfCarParkUseLog);
        return cfCarParkOrder.getCfOrder().getAmountsPayable();
    }

    @Override
    @RequestMapping(value = "getMyCarParks", method = RequestMethod.GET)
    public ResponseResult getMyCarParks()throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        //获取我关联的停车场数据cfCarParkLinkUserService
        CfCarParkLinkUserQuery cfCarParkLinkUserQuery = new CfCarParkLinkUserQuery();
        cfCarParkLinkUserQuery.setUid(userBasicInfo.getId());
        List<CfCarParkLinkUser> cfCarParkLinkUsers = cfCarParkLinkUserService.getListByQuery(cfCarParkLinkUserQuery);
        if(cfCarParkLinkUsers==null || cfCarParkLinkUsers.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null, "please bind carPark");
        }


        List<String> carParkIds = new ArrayList<>();
        for (CfCarParkLinkUser cfCarParkLinkUser: cfCarParkLinkUsers){
            carParkIds.add(cfCarParkLinkUser.getCarParkId());
        }
        CfCarParkQuery cfCarParkQuery = new CfCarParkQuery();
        cfCarParkQuery.setIds(carParkIds);
        List<CfCarPark> carParks = cfCarParkService.getListByQuery(cfCarParkQuery);
        if(carParks==null || carParks.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, carParks);
    }

    @Override
    @PreAuthorize("hasAuthority('carpark-CarParkController-getCarParkFinanceReportList')")
    @RequestMapping(value = "getCarParkFinanceReportList", method = RequestMethod.GET)
    public ResponseResult getCarParkFinanceReportList(CfOrderQuery cfOrderQuery) throws Exception {
        if(cfOrderQuery.getYearReportTime()!=null){
            cfOrderQuery.setMinPayTime(cfOrderQuery.getYearReportTime());
            cfOrderQuery.setMaxPayTime(DateUtil.getYearEndTime(cfOrderQuery.getYearReportTime(), "GMT+8:00"));
        }else if(cfOrderQuery.getMonthReportTime()!=null){
            cfOrderQuery.setMinPayTime(cfOrderQuery.getMonthReportTime());
            cfOrderQuery.setMaxPayTime(DateUtil.getMonthEndTime(cfOrderQuery.getMonthReportTime(), "GMT+8:00"));
        }else if(cfOrderQuery.getDayReportTime()!=null){
            cfOrderQuery.setMinPayTime(cfOrderQuery.getDayReportTime());
            cfOrderQuery.setMaxPayTime(DateUtil.maxMillisecondBaseOnTheDayToTimestamp(cfOrderQuery.getDayReportTime()));
        }

        CfCarParkFinanceReport cfCarParkFinanceReport = cfCarParkService.getCarParkFinanceReportList(cfOrderQuery);
        return new ResponseResult(CommonCode.SUCCESS, cfCarParkFinanceReport);
    }

    @Override
    @PreAuthorize("hasAuthority('carpark-CarParkController-getCarParkTotalFinanceReport')")
    @RequestMapping(value = "getCarParkTotalFinanceReport", method = RequestMethod.GET)
    public ResponseResult getCarParkTotalFinanceReport(CfOrderQuery cfOrderQuery) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        List<CfCarParkLinkUser> linkUsers = getLinkUsersAndCheck(userBasicInfo);
        if(linkUsers!=null && linkUsers.size()>0){
            cfOrderQuery.setShopIds(new ArrayList<>());
            for (CfCarParkLinkUser cfCarParkLinkUser: linkUsers){
                cfOrderQuery.getShopIds().add(cfCarParkLinkUser.getCarParkId());
            }
        }
        CfCarParkFinanceReport cfCarParkFinanceReport = cfCarParkService.getCarParkTotalFinanceReport(cfOrderQuery);
        return new ResponseResult(CommonCode.SUCCESS, cfCarParkFinanceReport);
    }

    @Override
    @PreAuthorize("hasAuthority('carpark-CarParkController-getChargingRulesByCarParkId')")
    @RequestMapping(value = "getChargingRulesByCarParkId", method = RequestMethod.GET)
    public ResponseResult getChargingRulesByCarParkId(CfCarParkChargingRulesQuery cfCarParkChargingRulesQuery) throws Exception {
        List<CfCarParkChargingRules> cfCarParkChargingRules = cfCarParkChargingRulesService.getListByCondition(cfCarParkChargingRulesQuery);
        if(cfCarParkChargingRules==null || cfCarParkChargingRules.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfCarParkChargingRules);
    }

    @Override
    @PreAuthorize("hasAuthority('carpark-CarParkController-getListByLinkerUser')")
    @RequestMapping(value = "getListByLinkerUser", method = RequestMethod.GET)
    public ResponseResult getListByLinkerUser(Integer page, Integer size) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        List<CfCarPark> cfCarParks = cfCarParkService.getListByLinkerUser(userBasicInfo.getId(), page, size);
        if(cfCarParks==null || cfCarParks.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfCarParks);
    }

    @Override
    @PreAuthorize("hasAuthority('carpark-CarParkController-getStatisticsDatas')")
    @RequestMapping(value = "getStatisticsDatas", method = RequestMethod.GET)
    public ResponseResult getStatisticsDatas(CfDailyParkingStatistcsQuery cfDailyParkingStatistcsQuery) throws Exception {
        List<CfDailyParkingStatistcs> cfDailyParkingStatistcsList = cfDailyParkingStatistcsService.getListByQuery(cfDailyParkingStatistcsQuery);
        if(cfDailyParkingStatistcsList==null || cfDailyParkingStatistcsList.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfDailyParkingStatistcsList);
    }

    /**
     * 获取相关停车场的关联
     * @param userBasicInfo
     * @return
     */
    List<CfCarParkLinkUser> getLinkUsersAndCheck(UserBasicInfo userBasicInfo){
        if(StringTools.findStringInArray(userBasicInfo.getRoleFlag().split(","), "admin")<0 && StringTools.findStringInArray(userBasicInfo.getRoleFlag().split(","), "finance")<0){
            CfCarParkLinkUserQuery cfCarParkLinkUserQuery = new CfCarParkLinkUserQuery();
            cfCarParkLinkUserQuery.setUid(userBasicInfo.getId());
            List<CfCarParkLinkUser> cfCarParkLinkUsers = cfCarParkLinkUserService.getListByQuery(cfCarParkLinkUserQuery);
            if(cfCarParkLinkUsers==null || cfCarParkLinkUsers.size()==0){
                ExceptionCast.cast(CarParkCode.NOT_BIND_ANY_CARPARK);
            }
            return cfCarParkLinkUsers;
        }
        return null;
    }
}
