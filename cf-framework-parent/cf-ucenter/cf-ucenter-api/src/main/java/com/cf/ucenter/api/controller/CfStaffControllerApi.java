package com.cf.ucenter.api.controller;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.Response;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.domain.ucenter.response.StaffCode;
import com.cf.framework.utils.DateUtil;
import com.cf.framework.utils.FileUtils;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.framework.utils.IdWorker;
import com.cf.pay.domain.CfCouponActivity;
import com.cf.pay.domain.CfStaffCouponSetting;
import com.cf.pay.domain.request.CfCouponActivityQuery;
import com.cf.pay.domain.request.CfStaffCouponSettingQuery;
import com.cf.pay.service.CfCouponActivityService;
import com.cf.pay.service.CfStaffCouponSettingService;
import com.cf.ucenter.api.config.AuthenticationInterceptor;
import com.cf.ucenter.api.swagger.CfStaffSwagger;
import com.cf.ucenter.domain.CfStaff;
import com.cf.ucenter.request.CfStaffForm;
import com.cf.ucenter.request.CfStaffQuery;
import com.cf.ucenter.service.CfStaffService;
import com.cf.ucenter.service.CfSystemConfigService;
import com.cf.ucenter.service.CfUserRoleService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("staff/")
public class CfStaffControllerApi implements CfStaffSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfStaffService cfStaffService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfStaffCouponSettingService cfStaffCouponSettingService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCouponActivityService cfCouponActivityService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserRoleService cfUserRoleService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfSystemConfigService cfSystemConfigService;
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    private IdWorker idWorker;

    @Override
//    @PreAuthorize("hasAuthority('staff-CfStaffControllerApi-employerDeleteStaff')")
    @RequestMapping(value = "employerDeleteStaff", method = RequestMethod.DELETE)
    public ResponseResult employerDeleteStaff(String id) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        CfStaff cfStaff = cfStaffService.employerDeleteStaff(userBasicInfo.getId(), id);
        //删除员工优惠券发券活动相关数据
        CfCouponActivityQuery cfCouponActivityQuery = new CfCouponActivityQuery();
        cfCouponActivityQuery.setMainBodyId(userBasicInfo.getId());
        List<CfCouponActivity> cfCouponActivityList = cfCouponActivityService.getListByQuery(cfCouponActivityQuery);
        if(cfCouponActivityList!=null && cfCouponActivityList.size()>0){
            ArrayList<String> couponActivityIds = new ArrayList<>();
            for (CfCouponActivity cfCouponActivity: cfCouponActivityList){
                couponActivityIds.add(cfCouponActivity.getImage());
            }
            CfStaffCouponSettingQuery cfStaffCouponSettingQuery = new CfStaffCouponSettingQuery();
            cfStaffCouponSettingQuery.setCouponActivityIds(couponActivityIds);
            cfStaffCouponSettingService.deleteByQuery(cfStaffCouponSettingQuery);
        }
        return new ResponseResult(CommonCode.SUCCESS);
    }

    @Override
//    @PreAuthorize("hasAuthority('staff-CfStaffControllerApi-employerUpdateStaff')")
    @RequestMapping(value = "employerUpdateStaff", method = RequestMethod.PUT)
    public ResponseResult employerUpdateStaff(@RequestBody CfStaffForm cfStaffForm) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        if(userBasicInfo.getId().equals(cfStaffForm.getStaffId())){
            return new ResponseResult(StaffCode.CANT_NOT_ADD_YOURSELF);
        }
        if(cfStaffForm.getNote()==null){
            cfStaffForm.setNote("");
        }
        CfStaff cfStaff = new CfStaff();
        BeanUtils.copyProperties(cfStaffForm, cfStaff);
        cfStaff.setEmployerId(userBasicInfo.getId());
        CfStaff cfStaff1 = cfStaffService.employerUpdateStaff(cfStaff);
        return new ResponseResult(CommonCode.SUCCESS, cfStaff1);
    }

    @Override
//    @PreAuthorize("hasAuthority('staff-CfStaffControllerApi-employerAddStaff')")
    @RequestMapping(value = "employerAddStaff", method = RequestMethod.POST)
    public ResponseResult employerAddStaff(@RequestBody CfStaffForm cfStaffForm) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        if(userBasicInfo.getId().equals(cfStaffForm.getStaffId())){
            return new ResponseResult(StaffCode.CANT_NOT_ADD_YOURSELF);
        }
        if(cfStaffForm.getNote()==null){
            cfStaffForm.setNote("");
        }
        CfStaff cfStaff = new CfStaff();
        BeanUtils.copyProperties(cfStaffForm, cfStaff);
        cfStaff.setEmployerId(userBasicInfo.getId());
        CfStaff cfStaff1 = cfStaffService.employerAddStaff(cfStaff);
        //自动给其创建一个额度为0的员工设置项(不存在则创建)
        CfCouponActivityQuery cfCouponActivityQuery = new CfCouponActivityQuery();
        cfCouponActivityQuery.setMainBodyId(userBasicInfo.getId());
        List<CfCouponActivity> cfCouponActivities = cfCouponActivityService.getListByQuery(cfCouponActivityQuery);
        if(cfCouponActivities!=null && cfCouponActivities.size()>0){
            ArrayList<CfStaffCouponSetting> cfStaffCouponSettingArrayList = new ArrayList<>();
            for(CfCouponActivity cfCouponActivity: cfCouponActivities){
                CfStaffCouponSettingQuery cfStaffCouponSettingQuery = new CfStaffCouponSettingQuery();
                cfStaffCouponSettingQuery.setCouponActivityId(cfCouponActivity.getId());
                cfStaffCouponSettingQuery.setStaffId(cfStaffForm.getStaffId());
                //删掉原来的，再添加
                cfStaffCouponSettingService.deleteByQuery(cfStaffCouponSettingQuery);
                //直接添加一个默认的
                for(byte i=(byte)0; i<(byte)3; i++){
                    CfStaffCouponSetting cfStaffCouponSetting = new CfStaffCouponSetting();
                    cfStaffCouponSetting.setId(idWorker.nextId());
                    cfStaffCouponSetting.setSameDayQuota(new BigDecimal(0.00));
                    cfStaffCouponSetting.setCouponActivityId(cfCouponActivity.getId());
                    cfStaffCouponSetting.setStaffId(cfStaffForm.getStaffId());
                    cfStaffCouponSetting.setCouponType(i);
                    cfStaffCouponSettingArrayList.add(cfStaffCouponSetting);
                }
                cfStaffCouponSettingService.batchAdd(cfStaffCouponSettingArrayList);
            }
        }
        return new ResponseResult(CommonCode.SUCCESS, cfStaff1);
    }

    @Override
//    @PreAuthorize("hasAuthority('staff-CfStaffControllerApi-getMyStaffList')")
    @RequestMapping(value = "getMyStaffList", method = RequestMethod.GET)
    public ResponseResult getMyStaffList(CfStaffQuery cfStaffQuery) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        cfStaffQuery.setEmployerId(userBasicInfo.getId());
        if(cfStaffQuery.getCountStartTime()==null){
            cfStaffQuery.setCountStartTime(DateUtil.getSameDayMinOrMaxTimestamp("min"));
        }
        if(cfStaffQuery.getCountEndTime()==null){
            cfStaffQuery.setCountEndTime(DateUtil.getSameDayMinOrMaxTimestamp("max"));
        }
        List<CfStaff> cfStaffs = cfStaffService.selectByQueryContainCouponCount(cfStaffQuery);
        if (cfStaffs==null || cfStaffs.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        String fileSourceAddress = cfSystemConfigService.getValueByKey("file_source_address", "http://file.cfeng.wang/");
        for(CfStaff cfStaff: cfStaffs){
            FileUtils.handleFileSourcePrefix(cfStaff, "", "staffAvatar");
        }
        return new ResponseResult(CommonCode.SUCCESS, cfStaffs);
    }
}
