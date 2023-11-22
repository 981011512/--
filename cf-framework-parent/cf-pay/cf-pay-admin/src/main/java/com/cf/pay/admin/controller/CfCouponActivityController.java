package com.cf.pay.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.cf.framework.domain.pay.PayCode;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.domain.ucenter.response.UcenterCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.*;
import com.cf.pay.admin.config.AuthenticationInterceptor;
import com.cf.pay.admin.swagger.CfCouponActivitySwagger;
import com.cf.pay.domain.*;
import com.cf.pay.domain.request.*;
import com.cf.pay.domain.response.ResultMap;
import com.cf.pay.domain.type.CouponType;
import com.cf.pay.service.*;
import com.cf.ucenter.domain.CfStaff;
import com.cf.ucenter.domain.CfUser;
import com.cf.ucenter.request.CfStaffQuery;
import com.cf.ucenter.service.CfStaffService;
import com.cf.ucenter.service.CfSystemConfigService;
import com.cf.ucenter.service.CfUserService;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("couponActivityAdmin/")
@Validated
public class CfCouponActivityController implements CfCouponActivitySwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCouponActivityService cfCouponActivityService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCouponActivityCouponTypeService cfCouponActivityCouponTypeService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfStaffCouponLogService cfStaffCouponLogService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfQrCodeService cfQrCodeService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfUserService cfUserService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfStaffService cfStaffService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfStaffCouponSettingService cfStaffCouponSettingService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCouponActivityLinkShopService cfCouponActivityLinkShopService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfSystemConfigService cfSystemConfigService;
    @Autowired
    protected HttpServletRequest request;

    @Override
    @PreAuthorize("hasAuthority('pay-CfCouponActivityController-selectListByCondition')")
    @RequestMapping(value = "selectListByCondition", method = {RequestMethod.GET})
    public ResponseResult selectListByCondition(String conditions) throws Exception {
        Map conditionsMap = (JSONObject.parseObject(conditions));
        ArrayList<String> allowFileds = new ArrayList<>();
        allowFileds.add("id");
        allowFileds.add("title");
        allowFileds.add("type");
        allowFileds.add("start_time");
        allowFileds.add("end_time");
        allowFileds.add("main_body_id");
        allowFileds.add("creater_id");
        allowFileds.add("goods_id");
        allowFileds.add("status");
        allowFileds.add("create_time");
        allowFileds.add("phone");
        allowFileds.add("recharge_ratio");
        allowFileds.add("shopkeeper_name");
        allowFileds.add("project_name");
        allowFileds.add("trade_type");
        allowFileds.add("coupon_type");
        allowFileds.add("auto_give_away");
        allowFileds.add("auto_cleared");
        allowFileds.add("auto_give_away_date");
        allowFileds.add("like");
        allowFileds.add("group");
        allowFileds.add("order");
        allowFileds.add("limit");
        Map<String, String> allowFiledsMap = new HashMap<String, String>();
        allowFiledsMap.put("id","cpa");
        allowFiledsMap.put("title","cpa");
        allowFiledsMap.put("type","cpa");
        allowFiledsMap.put("start_time","cpa");
        allowFiledsMap.put("end_time","cpa");
        allowFiledsMap.put("main_body_id","cpa");
        allowFiledsMap.put("creater_id","cpa");
        allowFiledsMap.put("goods_id","cpa");
        allowFiledsMap.put("status","cpa");
        allowFiledsMap.put("create_time","cpa");
        allowFiledsMap.put("phone","cpa");
        allowFiledsMap.put("recharge_ratio","cpa");
        allowFiledsMap.put("shopkeeper_name","cpa");
        allowFiledsMap.put("project_name","cpa");
        allowFiledsMap.put("trade_type","cpa");
        allowFiledsMap.put("coupon_type","cpa");
        allowFiledsMap.put("auto_give_away","cpa");
        allowFiledsMap.put("auto_cleared","cpa");
        allowFiledsMap.put("auto_give_away_date","cpa");
        allowFiledsMap.put("like","");
        allowFiledsMap.put("group","");
        allowFiledsMap.put("order","");
        allowFiledsMap.put("limit","");

        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        if(StringTools.findStringInArray(userBasicInfo.getRoleFlag().split(","), "admin")<0){
            HashMap<String, String> valueMap = new HashMap<>();
            valueMap.put("operator","=");
            valueMap.put("value",userBasicInfo.getId());
            conditionsMap.put("main_body_id", valueMap);
        }

        List<CfCouponActivity> cfCouponActivities = cfCouponActivityService.selectListByCondition(conditionsMap, allowFiledsMap, allowFileds);
        Integer counts = cfCouponActivityService.selectListByConditionCounts(conditionsMap, allowFiledsMap, allowFileds);
        if(cfCouponActivities!=null && cfCouponActivities.size()>0){
            return new ResponseResult(CommonCode.SUCCESS, cfCouponActivities, null, counts);
        }
        return new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    @PreAuthorize("hasAuthority('pay-CfCouponActivityController-activityDetail')")
    @Override
    @RequestMapping(value = "activityDetail", method = RequestMethod.GET)
    public ResponseResult activityDetail(String activityId) throws Exception {
        CfCouponActivity cfCouponActivity = cfCouponActivityService.findById(activityId, false);
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));

        CfStaffCouponLogQuery cfStaffCouponLogQuery = new CfStaffCouponLogQuery();
        cfStaffCouponLogQuery.setMinCreateTime(DateUtil.getSameDayMinOrMaxTimestamp("min"));
        cfStaffCouponLogQuery.setMaxCreateTime(DateUtil.getSameDayMinOrMaxTimestamp("max"));
        cfStaffCouponLogQuery.setCouponActivityId(activityId);
        //判断是员工还是商户
        List<String> roles = userBasicInfo.getRoles();
        if(roles!=null && roles.contains("merchant")){
            //获取商户今日的总发券量
            cfCouponActivity.setTodayIssued(cfStaffCouponLogService.countDenominationByQuery(cfStaffCouponLogQuery));
        }else if(roles!=null && roles.contains("staff")){
            //获取员工今日的总发券量
            cfStaffCouponLogQuery.setStaffId(userBasicInfo.getId());
            cfCouponActivity.setTodayIssued(cfStaffCouponLogService.countDenominationByQuery(cfStaffCouponLogQuery));
            //获取用户每日发券额度
            CfStaffCouponSettingQuery cfStaffCouponSettingQuery = new CfStaffCouponSettingQuery();
            cfStaffCouponSettingQuery.setStaffId(userBasicInfo.getId());
            cfStaffCouponSettingQuery.setCouponActivityId(activityId);
            List<CfStaffCouponSetting> staffCouponSettings = cfStaffCouponSettingService.getListByQuery(cfStaffCouponSettingQuery);
            if(staffCouponSettings!=null && staffCouponSettings.size()>0){
                cfCouponActivity.setTodayQuota(staffCouponSettings.get(0).getSameDayQuota());
            }else{
                cfCouponActivity.setTodayQuota(new BigDecimal("0.00"));
            }
        }else{
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfCouponActivity);
    }

    @Override
    @PreAuthorize("hasAuthority('pay-CfCouponActivityController-addCouponActivityCouponType')")
    @RequestMapping(value = "addCouponActivityCouponType", method = RequestMethod.POST)
    public ResponseResult addCouponActivityCouponType(@Validated @RequestBody CfCouponActivityCouponTypeForm cfCouponActivityCouponTypeForm) throws Exception {
        CfCouponActivityCouponType cfCouponActivityCouponType = new CfCouponActivityCouponType();
        BeanUtils.copyProperties(cfCouponActivityCouponTypeForm, cfCouponActivityCouponType);
        CfCouponActivityCouponType couponActivityCouponType = cfCouponActivityCouponTypeService.add(cfCouponActivityCouponType);
        return new ResponseResult(CommonCode.SUCCESS, couponActivityCouponType);
    }

    @Override
    @PreAuthorize("hasAuthority('pay-CfCouponActivityController-updateCouponActivityCouponType')")
    @RequestMapping(value = "updateCouponActivityCouponType", method = RequestMethod.PUT)
    public ResponseResult updateCouponActivityCouponType(@Validated @RequestBody CfCouponActivityCouponTypeForm cfCouponActivityCouponTypeForm) throws Exception {
        CfCouponActivityCouponType cfCouponActivityCouponType = new CfCouponActivityCouponType();
        BeanUtils.copyProperties(cfCouponActivityCouponTypeForm, cfCouponActivityCouponType);
        CfCouponActivityCouponType couponActivityCouponType = cfCouponActivityCouponTypeService.update(cfCouponActivityCouponType);
        return new ResponseResult(CommonCode.SUCCESS, couponActivityCouponType);
    }

    @Override
    @PreAuthorize("hasAuthority('pay-CfCouponActivityController-deleteCouponActivityCouponType')")
    @RequestMapping(value = "deleteCouponActivityCouponType", method = RequestMethod.DELETE)
    public ResponseResult deleteCouponActivityCouponType(@Validated String couponActivityCouponTypeId) throws Exception {
        Integer delete = cfCouponActivityCouponTypeService.delete(couponActivityCouponTypeId);
        if(delete>0){
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);
    }

    @Override
    @PreAuthorize("hasAuthority('pay-CfCouponActivityController-getCouponActivityCouponTypeListByQuery')")
    @RequestMapping(value = "getCouponActivityCouponTypeListByQuery", method = RequestMethod.GET)
    public ResponseResult getCouponActivityCouponTypeListByQuery(CfCouponActivityCouponTypeQuery cfCouponActivityCouponTypeQuery) throws Exception {
        if(StringUtils.isEmpty(cfCouponActivityCouponTypeQuery.getCouponActivityId())){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        List<CfCouponActivityCouponType> cfCouponActivityCouponTypes = cfCouponActivityCouponTypeService.getListByQuery(cfCouponActivityCouponTypeQuery);
        if(cfCouponActivityCouponTypes==null || cfCouponActivityCouponTypes.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfCouponActivityCouponTypes);
    }

    @Override
    @PreAuthorize("hasAuthority('pay-CfCouponActivityController-getCouponActivityCouponLogList')")
    @RequestMapping(value = "getCouponActivityCouponLogList", method = RequestMethod.GET)
    public ResponseResult getCouponActivityCouponLogList(CfStaffCouponLogQuery cfStaffCouponLogQuery) throws Exception {

        if(StringUtils.isEmpty(cfStaffCouponLogQuery.getCouponActivityId())){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        List<String> roles = userBasicInfo.getRoles();
        if(roles!=null && roles.contains("merchant")){
            cfCouponActivityService.checkActivityAscription(userBasicInfo.getId(), cfStaffCouponLogQuery.getCouponActivityId());
        }else if(roles!=null && roles.contains("staff")){
            cfStaffCouponLogQuery.setStaffId(userBasicInfo.getId());
        }

        if(cfStaffCouponLogQuery.getMinCreateTime()==null){
            cfStaffCouponLogQuery.setMinCreateTime(DateUtil.getSameDayMinOrMaxTimestamp("min"));
        }
        if(cfStaffCouponLogQuery.getMaxCreateTime()==null){
            cfStaffCouponLogQuery.setMaxCreateTime(DateUtil.getSameDayMinOrMaxTimestamp("max"));
        }
        List<CfStaffCouponLog> staffCouponLogServiceListByQuery = cfStaffCouponLogService.selectByQuery(cfStaffCouponLogQuery);
        if(staffCouponLogServiceListByQuery==null || staffCouponLogServiceListByQuery.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        Integer integer = cfStaffCouponLogService.countByQuery(cfStaffCouponLogQuery);
        String fileSourceAddress = cfSystemConfigService.getValueByKey("file_source_address", "http://file.cfeng.wang/");
        for (CfStaffCouponLog cfStaffCouponLog: staffCouponLogServiceListByQuery){
            FileUtils.handleFileSourcePrefix(cfStaffCouponLog, fileSourceAddress, "staffAvatar");
            FileUtils.handleFileSourcePrefix(cfStaffCouponLog, fileSourceAddress, "toUidAvatar");
        }
        return new ResponseResult(CommonCode.SUCCESS, staffCouponLogServiceListByQuery, integer);
    }

    @Override
    @PreAuthorize("hasAuthority('pay-CfCouponActivityController-staffCreateCouponQrCode')")
    @RequestMapping(value = "staffCreateCouponQrCode", method = RequestMethod.POST)
    public ResponseResult staffCreateCouponQrCode(@RequestBody CfQrCodeForm cfQrCodeForm) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        //查询优惠券活动类型面额
        if(StringUtils.isEmpty(cfQrCodeForm.getCouponActivityTypeId())){
            CfCouponActivityCouponType cfCouponActivityCouponType = cfCouponActivityCouponTypeService.findById(cfQrCodeForm.getCouponActivityTypeId(), true);
            if(cfCouponActivityCouponType.getCouponActivityId().equals(cfQrCodeForm.getSourceId())){
                cfQrCodeForm.setQuantity(cfCouponActivityCouponType.getDenomination().longValue());
            }
        }
        CfQrCode cfQrCode = new CfQrCode();
        BeanUtils.copyProperties(cfQrCodeForm, cfQrCode);
        cfQrCode.setCreaterId(userBasicInfo.getId());
        CfQrCode qrCode = cfQrCodeService.staffCreateCouponQrCode(cfQrCode);
        return new ResponseResult(CommonCode.SUCCESS, qrCode);
    }

    @Override
    @PreAuthorize("hasAuthority('pay-CfCouponActivityController-rechargeToCouponActivity')")
    @RequestMapping(value = "rechargeToCouponActivity", method = RequestMethod.POST)
    public ResponseResult rechargeToCouponActivity(HttpServletRequest httpServletRequest, String couponActivityId, BigDecimal amountOfMoney, String useScenes, Byte couponType) throws Exception {
        if(amountOfMoney.compareTo(new BigDecimal(0.00))<=0){
            ExceptionCast.cast(PayCode.NO_NEED_TO_PAY);
        }
        if(couponType==null){
            couponType = CouponType.AMOUNT_COUPON;
        }
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        ResultMap resultMap = cfCouponActivityService.rechargeToCouponActivity(userBasicInfo.getId(), couponActivityId, amountOfMoney, useScenes, HttpClient.getIPAddress(httpServletRequest), couponType);
        return new ResponseResult(CommonCode.SUCCESS, resultMap);
    }

    @Override
    @PreAuthorize("hasAuthority('pay-CfCouponActivityController-add')")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@RequestBody CfCouponActivityForm cfCouponActivityForm) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        CfCouponActivity cfCouponActivity = new CfCouponActivity();
        BeanUtils.copyProperties(cfCouponActivityForm, cfCouponActivity);
        cfCouponActivity.setCreaterId(userBasicInfo.getId());
        CfCouponActivity couponActivity = cfCouponActivityService.add(cfCouponActivity);
        return new ResponseResult(CommonCode.SUCCESS, couponActivity);
    }

    @Override
    @PreAuthorize("hasAuthority('pay-CfCouponActivityController-update')")
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@RequestBody CfCouponActivityForm cfCouponActivityForm) throws Exception {
        CfCouponActivity cfCouponActivity = new CfCouponActivity();
        BeanUtils.copyProperties(cfCouponActivityForm, cfCouponActivity);
        CfCouponActivity couponActivity = cfCouponActivityService.updateByPrimaryKeySelective(cfCouponActivity);
        return new ResponseResult(CommonCode.SUCCESS, couponActivity);
    }

    @Override
    @PreAuthorize("hasAuthority('pay-CfCouponActivityController-delete')")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(String id) throws Exception {
        Integer delete = cfCouponActivityService.delete(id);
        return delete>0 ? new ResponseResult(CommonCode.SUCCESS) : new ResponseResult(CommonCode.FAIL);
    }

    @Override
    @PreAuthorize("hasAuthority('pay-CfCouponActivityController-getCouponActivityLinkShops')")
    @RequestMapping(value = "getCouponActivityLinkShops", method = RequestMethod.GET)
    public ResponseResult getCouponActivityLinkShops(byte couponActivityType, String couponActivityId) throws Exception {
        List<CfCouponActivityLinkShop> couponActivityLinkShops = cfCouponActivityService.getCouponActivityLinkShops(couponActivityType, couponActivityId);
        if(couponActivityLinkShops==null || couponActivityLinkShops.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, couponActivityLinkShops);
    }

    @Override
    @PreAuthorize("hasAuthority('pay-CfCouponActivityController-addActivityLinkShop')")
    @RequestMapping(value = "addActivityLinkShop", method = RequestMethod.POST)
    public ResponseResult addActivityLinkShop(@RequestBody CfCouponActivityLinkShopForm cfCouponActivityLinkShopForm) throws Exception {
        CfCouponActivityLinkShop cfCouponActivityLinkShop = new CfCouponActivityLinkShop();
        BeanUtils.copyProperties(cfCouponActivityLinkShopForm, cfCouponActivityLinkShop);
        CfCouponActivityLinkShop activityLinkShop = cfCouponActivityLinkShopService.add(cfCouponActivityLinkShop);
        return new ResponseResult(CommonCode.SUCCESS, activityLinkShop);
    }

    @Override
    @PreAuthorize("hasAuthority('pay-CfCouponActivityController-updateActivityLinkShop')")
    @RequestMapping(value = "updateActivityLinkShop", method = RequestMethod.PUT)
    public ResponseResult updateActivityLinkShop(@RequestBody CfCouponActivityLinkShopForm cfCouponActivityLinkShopForm) throws Exception {
        CfCouponActivityLinkShop cfCouponActivityLinkShop = new CfCouponActivityLinkShop();
        BeanUtils.copyProperties(cfCouponActivityLinkShopForm, cfCouponActivityLinkShop);
        CfCouponActivityLinkShop activityLinkShop = cfCouponActivityLinkShopService.update(cfCouponActivityLinkShop);
        return new ResponseResult(CommonCode.SUCCESS, activityLinkShop);
    }

    @Override
    @PreAuthorize("hasAuthority('pay-CfCouponActivityController-deleteActivityLinkShop')")
    @RequestMapping(value = "deleteActivityLinkShop", method = RequestMethod.DELETE)
    public ResponseResult deleteActivityLinkShop(String cfCouponActivityLinkShopId) throws Exception {
        Integer delete = cfCouponActivityLinkShopService.delete(cfCouponActivityLinkShopId);
        if(delete>0){
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);
    }
}
