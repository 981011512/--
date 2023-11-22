package com.cf.pay.api.controller;

import com.cf.framework.domain.pay.PayCode;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.domain.ucenter.response.UcenterCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.DateUtil;
import com.cf.framework.utils.FileUtils;
import com.cf.framework.utils.HttpClient;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.pay.api.config.AuthenticationInterceptor;
import com.cf.pay.api.swagger.CfCouponActivitySwagger;
import com.cf.pay.domain.*;
import com.cf.pay.domain.request.*;
import com.cf.pay.domain.response.ResultMap;
import com.cf.pay.domain.type.CouponType;
import com.cf.pay.service.*;
import com.cf.ucenter.domain.CfRole;
import com.cf.ucenter.domain.CfStaff;
import com.cf.ucenter.domain.CfUser;
import com.cf.ucenter.request.CfStaffQuery;
import com.cf.ucenter.service.CfRoleService;
import com.cf.ucenter.service.CfStaffService;
import com.cf.ucenter.service.CfSystemConfigService;
import com.cf.ucenter.service.CfUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("couponActivity/")
@Validated
public class CfCouponActivityControllerApi implements CfCouponActivitySwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCouponActivityService cfCouponActivityService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCouponActivityCouponTypeService cfCouponActivityCouponTypeService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfStaffCouponLogService cfStaffCouponLogService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfQrCodeService cfQrCodeService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserService cfUserService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfStaffService cfStaffService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfStaffCouponSettingService cfStaffCouponSettingService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfSystemConfigService cfSystemConfigService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfRoleService cfRoleService;
    @Autowired
    protected HttpServletRequest request;

    @Override
//    @PreAuthorize("hasAuthority('couponActivity-CfCouponActivityControllerApi-getMyCouponActivityList')")
    @RequestMapping(value = "getMyCouponActivityList", method = RequestMethod.GET)
    public ResponseResult getMyCouponActivityList(@Validated CfCouponActivityQuery cfCouponActivityQuery) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        //判断是员工还是商户
        if(userBasicInfo.getRoles()==null || userBasicInfo.getRoles().size()==0){
            String roleFlag = userBasicInfo.getRoleFlag();
            if(StringUtils.isNotEmpty(roleFlag)){
                String[] roleKeys = roleFlag.split(",");
                for (String roleKey: roleKeys){
                    if(userBasicInfo.getRoles()==null){
                        userBasicInfo.setRoles(new ArrayList<>());
                    }
                    userBasicInfo.getRoles().add(roleKey);
                }
            }
        }
        List<String> roles = userBasicInfo.getRoles();
        if(roles.size()==0){
            //找到用户对应角色
            List<CfRole> cfRoleList = cfRoleService.getRolesByUid(userBasicInfo.getId());
            for(CfRole cfRole: cfRoleList){
                roles.add(cfRole.getFlagKey());
            }
        }
        if(roles!=null && roles.contains("merchant") || (roles!=null && roles.contains("[merchant]"))){
            cfCouponActivityQuery.setMainBodyId(userBasicInfo.getId());
        }else if(roles!=null && roles.contains("staff") || (roles!=null && roles.contains("[staff]"))){
            //获取该员工所有参与管理的优惠活动
            CfStaffQuery cfStaffQuery = new CfStaffQuery();
            cfStaffQuery.setStaffId(userBasicInfo.getId());
            List<CfStaff> cfStaffs = cfStaffService.getListByQuery(cfStaffQuery);
            if(cfStaffs==null || cfStaffs.size()==0){
                return new ResponseResult(CommonCode.NO_MORE_DATAS);
            }
            ArrayList<String> mainBodyIds = new ArrayList<>();
            for(CfStaff cfStaff: cfStaffs){
                mainBodyIds.add(cfStaff.getEmployerId());
            }
            cfCouponActivityQuery.setMainBodyIds(mainBodyIds);
        }else{
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        List<CfCouponActivity> cfCouponActivities = cfCouponActivityService.getListByQuery(cfCouponActivityQuery);
        if(cfCouponActivities==null || cfCouponActivities.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        for (CfCouponActivity cfCouponActivity: cfCouponActivities){
            //可用额度等于充值额度+自动赠送额度
            BigDecimal totalIssueQuota = cfCouponActivity.getTotalIssueQuota();
            cfCouponActivity.setTotalIssueQuota(totalIssueQuota.add(cfCouponActivity.getAutoGiveAwayOverageQuota()));
        }
        return new ResponseResult(CommonCode.SUCCESS, cfCouponActivities);
    }

    @Override
    @RequestMapping(value = "activityDetail", method = RequestMethod.GET)
    public ResponseResult activityDetail(String activityId) throws Exception {
        CfCouponActivity cfCouponActivity = cfCouponActivityService.findById(activityId, false);
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));

        //可用额度等于充值额度+自动赠送额度
        BigDecimal totalIssueQuota = cfCouponActivity.getTotalIssueQuota();
        cfCouponActivity.setTotalIssueQuota(totalIssueQuota.add(cfCouponActivity.getAutoGiveAwayOverageQuota()));

        CfStaffCouponLogQuery cfStaffCouponLogQuery = new CfStaffCouponLogQuery();
        cfStaffCouponLogQuery.setMinCreateTime(DateUtil.getSameDayMinOrMaxTimestamp("min"));
        cfStaffCouponLogQuery.setMaxCreateTime(DateUtil.getSameDayMinOrMaxTimestamp("max"));
        cfStaffCouponLogQuery.setCouponActivityId(activityId);
        cfStaffCouponLogQuery.setCouponType((byte)2);
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
//    @PreAuthorize("hasAuthority('couponActivity-CfCouponActivityControllerApi-shopkeeperAddCouponActivityCouponType')")
    @RequestMapping(value = "shopkeeperAddCouponActivityCouponType", method = RequestMethod.POST)
    public ResponseResult shopkeeperAddCouponActivityCouponType(@Validated @RequestBody CfCouponActivityCouponTypeForm cfCouponActivityCouponTypeForm) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        CfCouponActivityCouponType cfCouponActivityCouponType = new CfCouponActivityCouponType();
        BeanUtils.copyProperties(cfCouponActivityCouponTypeForm, cfCouponActivityCouponType);
        CfCouponActivityCouponType couponActivityCouponType = cfCouponActivityCouponTypeService.shopkeeperAddCouponType(userBasicInfo.getId(), cfCouponActivityCouponType);
        return new ResponseResult(CommonCode.SUCCESS, couponActivityCouponType);
    }

    @Override
//    @PreAuthorize("hasAuthority('couponActivity-CfCouponActivityControllerApi-shopkeeperUpdateCouponActivityCouponType')")
    @RequestMapping(value = "shopkeeperUpdateCouponActivityCouponType", method = RequestMethod.PUT)
    public ResponseResult shopkeeperUpdateCouponActivityCouponType(@Validated @RequestBody CfCouponActivityCouponTypeForm cfCouponActivityCouponTypeForm) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        CfCouponActivityCouponType cfCouponActivityCouponType = new CfCouponActivityCouponType();
        BeanUtils.copyProperties(cfCouponActivityCouponTypeForm, cfCouponActivityCouponType);
        CfCouponActivityCouponType couponActivityCouponType = cfCouponActivityCouponTypeService.shopkeeperUpdateCouponType(userBasicInfo.getId(), cfCouponActivityCouponType);
        return new ResponseResult(CommonCode.SUCCESS, couponActivityCouponType);
    }

    @Override
//    @PreAuthorize("hasAuthority('couponActivity-CfCouponActivityControllerApi-shopkeeperDeleteCouponActivityCouponType')")
    @RequestMapping(value = "shopkeeperDeleteCouponActivityCouponType", method = RequestMethod.DELETE)
    public ResponseResult shopkeeperDeleteCouponActivityCouponType(@Validated String couponActivityCouponTypeId) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        Integer delete = cfCouponActivityCouponTypeService.shopkeeperDelete(userBasicInfo.getId(), couponActivityCouponTypeId);
        if(delete>0){
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);
    }

    @Override
//    @PreAuthorize("hasAuthority('couponActivity-CfCouponActivityControllerApi-getCouponActivityCouponTypeListByQuery')")
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
//    @PreAuthorize("hasAuthority('couponActivity-CfCouponActivityControllerApi-getCouponActivityCouponLogList')")
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
//    @PreAuthorize("hasAuthority('couponActivity-CfCouponActivityControllerApi-staffCreateCouponQrCode')")
    @RequestMapping(value = "staffCreateCouponQrCode", method = RequestMethod.POST)
    public ResponseResult staffCreateCouponQrCode(@RequestBody CfQrCodeForm cfQrCodeForm) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        CfQrCode cfQrCode = new CfQrCode();
        BeanUtils.copyProperties(cfQrCodeForm, cfQrCode);
        cfQrCode.setCreaterId(userBasicInfo.getId());
        CfQrCode qrCode = cfQrCodeService.staffCreateCouponQrCode(cfQrCode);
        return new ResponseResult(CommonCode.SUCCESS, qrCode);
    }

    @Override
//    @PreAuthorize("hasAuthority('couponActivity-CfCouponActivityControllerApi-staffOrShopkeeperGiveCouponToCar')")
    @RequestMapping(value = "staffOrShopkeeperGiveCouponToCar", method = RequestMethod.POST)
    public ResponseResult staffOrShopkeeperGiveCouponToCar(@RequestBody @Validated StaffOrShopkeeperGiveCouponToCar staffOrShopkeeperGiveCouponToCar) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        if(staffOrShopkeeperGiveCouponToCar.getCouponType()==null){
            staffOrShopkeeperGiveCouponToCar.setCouponType(CouponType.AMOUNT_COUPON);
        }
        String toUid = "";
        if(StringUtils.isEmpty(staffOrShopkeeperGiveCouponToCar.getPhone())){
            staffOrShopkeeperGiveCouponToCar.setPhone("");
        }else{
            CfUser cfUser = cfUserService.findByPhone(staffOrShopkeeperGiveCouponToCar.getPhone());
            if(cfUser==null){
                return new ResponseResult(UcenterCode.PHONE_IS_NOT_REGISTERED);
            }else{
                toUid = cfUser.getId();
            }
        }
        //查询优惠券活动类型面额
        CfCouponActivityCouponType cfCouponActivityCouponType = null;
        if(StringUtils.isNotEmpty(staffOrShopkeeperGiveCouponToCar.getCouponActivityCouponTypeId())){
            cfCouponActivityCouponType = cfCouponActivityCouponTypeService.findById(staffOrShopkeeperGiveCouponToCar.getCouponActivityCouponTypeId(), true);
            if(cfCouponActivityCouponType.getCouponActivityId().equals(staffOrShopkeeperGiveCouponToCar.getCfCouponActivityId())){
                staffOrShopkeeperGiveCouponToCar.setQuantity(cfCouponActivityCouponType.getDenomination().intValue());
            }
        }
        CfCoupon cfCoupon = cfCouponActivityService.staffOrShopkeeperGiveCouponToCar(userBasicInfo.getId(), toUid, staffOrShopkeeperGiveCouponToCar.getNumberPlate(), staffOrShopkeeperGiveCouponToCar.getCouponType(), staffOrShopkeeperGiveCouponToCar.getCfCouponActivityId(), staffOrShopkeeperGiveCouponToCar.getQuantity(), cfCouponActivityCouponType);
        return new ResponseResult(CommonCode.SUCCESS, cfCoupon);
    }

    @Override
//    @PreAuthorize("hasAuthority('couponActivity-CfCouponActivityControllerApi-getCouponByQrCode')")
    @RequestMapping(value = "getCouponByQrCode", method = RequestMethod.POST)
    public ResponseResult getCouponByQrCode(@RequestBody @Validated GetCouponByQrCode getCouponByQrCode) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        if(StringUtils.isEmpty(getCouponByQrCode.getNumberPlate())){
            getCouponByQrCode.setNumberPlate("");
        }
        CfCouponActivityCouponType cfCouponActivityCouponType = null;
        if(StringUtils.isNotEmpty(getCouponByQrCode.getCouponActivityCouponTypeId())){
            cfCouponActivityCouponType = cfCouponActivityCouponTypeService.findById(getCouponByQrCode.getCouponActivityCouponTypeId(), false);
        }
        CfCoupon cfCoupon = cfCouponActivityService.getCouponByQrCode(userBasicInfo.getId(), getCouponByQrCode.getQrCodeId(), getCouponByQrCode.getNumberPlate(), cfCouponActivityCouponType);
        return new ResponseResult(CommonCode.SUCCESS, cfCoupon);
    }

    @Override
//    @PreAuthorize("hasAuthority('couponActivity-CfCouponActivityControllerApi-rechargeToCouponActivity')")
    @RequestMapping(value = "rechargeToCouponActivity", method = RequestMethod.POST)
    public ResponseResult rechargeToCouponActivity(HttpServletRequest httpServletRequest, @RequestBody @Validated RechargeToCouponActivity rechargeToCouponActivity) throws Exception {
        if(rechargeToCouponActivity.getAmountOfMoney().compareTo(new BigDecimal(0.00))<=0){
            ExceptionCast.cast(PayCode.NO_NEED_TO_PAY);
        }
        if(rechargeToCouponActivity.getCouponType()==null){
            rechargeToCouponActivity.setCouponType(CouponType.AMOUNT_COUPON);
        }
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        ResultMap resultMap = cfCouponActivityService.rechargeToCouponActivity(userBasicInfo.getId(), rechargeToCouponActivity.getCouponActivityId(), rechargeToCouponActivity.getAmountOfMoney(), rechargeToCouponActivity.getUseScenes(), HttpClient.getIPAddress(httpServletRequest), rechargeToCouponActivity.getCouponType());
        return new ResponseResult(CommonCode.SUCCESS, resultMap);
    }
}
