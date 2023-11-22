package com.cf.pay.api.controller;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.pay.api.config.AuthenticationInterceptor;
import com.cf.pay.api.swagger.CfStaffCouponSettingSwagger;
import com.cf.pay.domain.CfStaffCouponSetting;
import com.cf.pay.domain.request.CfStaffCouponSettingForm;
import com.cf.pay.domain.request.CfStaffCouponSettingQuery;
import com.cf.pay.service.CfCouponActivityService;
import com.cf.pay.service.CfStaffCouponSettingService;
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
import java.util.List;

@RestController
@RequestMapping("staffCouponSetting/")
public class CfStaffCouponSettingController implements CfStaffCouponSettingSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfStaffCouponSettingService cfStaffCouponSettingService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCouponActivityService cfCouponActivityService;
    @Autowired
    protected HttpServletRequest request;

    @Override
//    @PreAuthorize("hasAuthority('staffCouponSetting-CfStaffCouponSettingController-employerAddStaffCouponSetting')")
    @RequestMapping(value = "employerAddStaffCouponSetting", method = RequestMethod.POST)
    public ResponseResult employerAddStaffCouponSetting(@Validated @RequestBody CfStaffCouponSettingForm cfStaffCouponSettingForm) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        CfStaffCouponSetting cfStaffCouponSetting = new CfStaffCouponSetting();
        BeanUtils.copyProperties(cfStaffCouponSettingForm, cfStaffCouponSetting);
        CfStaffCouponSetting staffCouponSetting = cfStaffCouponSettingService.employerAddStaffCouponSetting(userBasicInfo.getId(), cfStaffCouponSetting);
        return new ResponseResult(CommonCode.SUCCESS, staffCouponSetting);
    }

    @Override
//    @PreAuthorize("hasAuthority('staffCouponSetting-CfStaffCouponSettingController-employerUpdateStaffCouponSetting')")
    @RequestMapping(value = "employerUpdateStaffCouponSetting", method = RequestMethod.PUT)
    public ResponseResult employerUpdateStaffCouponSetting(@Validated @RequestBody CfStaffCouponSettingForm cfStaffCouponSettingForm) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        CfStaffCouponSetting cfStaffCouponSetting = new CfStaffCouponSetting();
        BeanUtils.copyProperties(cfStaffCouponSettingForm, cfStaffCouponSetting);
        CfStaffCouponSetting staffCouponSetting = cfStaffCouponSettingService.employerUpdateStaffCouponSetting(userBasicInfo.getId(), cfStaffCouponSetting);
        return new ResponseResult(CommonCode.SUCCESS, staffCouponSetting);
    }

    @Override
//    @PreAuthorize("hasAuthority('staffCouponSetting-CfStaffCouponSettingController-getStaffCouponSettingByQuery')")
    @RequestMapping(value = "getStaffCouponSettingByQuery", method = RequestMethod.GET)
    public ResponseResult getStaffCouponSettingByQuery(CfStaffCouponSettingQuery cfStaffCouponSettingQuery) throws Exception {
        List<CfStaffCouponSetting> staffCouponSettingServiceListByQuery = cfStaffCouponSettingService.getListByQuery(cfStaffCouponSettingQuery);
        if(staffCouponSettingServiceListByQuery==null || staffCouponSettingServiceListByQuery.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, staffCouponSettingServiceListByQuery);
    }
}
