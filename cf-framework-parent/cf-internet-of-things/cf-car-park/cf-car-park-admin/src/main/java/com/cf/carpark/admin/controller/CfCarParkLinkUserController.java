package com.cf.carpark.admin.controller;

import com.cf.carpark.admin.config.AuthenticationInterceptor;
import com.cf.carpark.admin.swagger.CfCarParkLinkUserSwagger;
import com.cf.carpark.domain.CfCarParkLinkUser;
import com.cf.carpark.domain.CfCarParkPaymentAgency;
import com.cf.carpark.domain.request.CfCarParkLinkUserForm;
import com.cf.carpark.domain.request.CfCarParkLinkUserQuery;
import com.cf.carpark.domain.type.ActionType;
import com.cf.carpark.service.CfCarParkLinkUserService;
import com.cf.framework.domain.carpark.response.CarParkCode;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.framework.utils.StringTools;
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
import java.util.List;

@RestController
@RequestMapping("carparkLinkUserAdmin/")
@Validated
public class CfCarParkLinkUserController implements CfCarParkLinkUserSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 10000, check = false)
    private CfCarParkLinkUserService cfCarParkLinkUserService;
    @Autowired
    protected HttpServletRequest request;

    @PreAuthorize("hasAuthority('carpark-CfCarParkLinkUserController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@Validated @RequestBody CfCarParkLinkUserForm cfCarParkLinkUserForm) throws Exception{
        UserBasicInfo userBasicInfo = checkAuth(cfCarParkLinkUserForm.getCarParkId());
        CfCarParkLinkUser cfCarParkLinkUser = new CfCarParkLinkUser();
        BeanUtils.copyProperties(cfCarParkLinkUserForm,cfCarParkLinkUser);
        if(StringTools.findStringInArray(userBasicInfo.getRoleFlag().split(","), "admin")<0){
            cfCarParkLinkUser.setCreater((byte)0);
        }
        if(cfCarParkLinkUser.getStartDutyTime()==null){
            cfCarParkLinkUser.setStartDutyTime(0l);
        }
        CfCarParkLinkUser carParkLinkUser = cfCarParkLinkUserService.add(cfCarParkLinkUser);
        return new ResponseResult(CommonCode.SUCCESS, carParkLinkUser);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkLinkUserController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@RequestBody CfCarParkLinkUserForm cfCarParkLinkUserForm) throws Exception {
        UserBasicInfo userBasicInfo = checkAuth(cfCarParkLinkUserForm.getCarParkId());
        CfCarParkLinkUser cfCarParkLinkUser = new CfCarParkLinkUser();
        BeanUtils.copyProperties(cfCarParkLinkUserForm,cfCarParkLinkUser);
//        cfCarParkLinkUser.setUid(userBasicInfo.getId());
        if(StringTools.findStringInArray(userBasicInfo.getRoleFlag().split(","), "admin")<0){
            CfCarParkLinkUser parkLinkUser = cfCarParkLinkUserService.findById(cfCarParkLinkUserForm.getId(), false);
            cfCarParkLinkUser.setCreater(parkLinkUser.getCreater());
        }
        if(cfCarParkLinkUser.getStartDutyTime()==null){
            cfCarParkLinkUser.setStartDutyTime(0l);
        }
        CfCarParkLinkUser carParkLinkUser = cfCarParkLinkUserService.update(cfCarParkLinkUser);
        return new ResponseResult(CommonCode.SUCCESS, carParkLinkUser);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkLinkUserController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(String id) throws Exception {
        CfCarParkLinkUser cfCarParkLinkUser = cfCarParkLinkUserService.findById(id, false);
        UserBasicInfo userBasicInfo = checkAuth(cfCarParkLinkUser.getCarParkId());
        if(StringTools.findStringInArray(userBasicInfo.getRoleFlag().split(","), "admin")<0 && cfCarParkLinkUser.getCreater()==(byte)1){
            return new ResponseResult(CommonCode.FAIL,null,"无权操作");
        }
        checkAuth(cfCarParkLinkUser.getCarParkId());
        Integer delete = cfCarParkLinkUserService.delete(id);
        return delete>0?new ResponseResult(CommonCode.SUCCESS):new ResponseResult(CommonCode.FAIL);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkLinkUserController-getCarParkLinkUserListByQuery')")
    @Override
    @RequestMapping(value = "getCarParkLinkUserListByQuery", method = RequestMethod.GET)
    public ResponseResult getCarParkLinkUserListByQuery(CfCarParkLinkUserQuery cfCarParkLinkUserQuery) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        if(StringTools.findStringInArray(userBasicInfo.getRoleFlag().split(","), "admin")<0){
            cfCarParkLinkUserQuery.setUid(userBasicInfo.getId());
        }
        List<CfCarParkLinkUser> cfCarParkLinkUsers = cfCarParkLinkUserService.selectByQueryLeftJoinUser(cfCarParkLinkUserQuery);
        Integer total = 0;
        if(cfCarParkLinkUserQuery.getPage()==1){
            total = cfCarParkLinkUserService.countByQuery(cfCarParkLinkUserQuery);
        }
        if(cfCarParkLinkUsers==null || cfCarParkLinkUsers.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfCarParkLinkUsers, total);
    }

    private UserBasicInfo checkAuth(String carParkId) throws Exception{
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        boolean checkSaasAction = cfCarParkLinkUserService.checkSaasAction(userBasicInfo, carParkId, "");
        if(!checkSaasAction){
            ExceptionCast.cast(CarParkCode.NO_PERMISSION);
        }
        return userBasicInfo;
    }

    List<CfCarParkLinkUser> getCarParkLinkUser(UserBasicInfo userBasicInfo, CfCarParkLinkUserService _cfCarParkLinkUserService) throws Exception {
        CfCarParkLinkUserQuery cfCarParkLinkUserQuery = new CfCarParkLinkUserQuery();
        if(StringTools.findStringInArray(userBasicInfo.getRoleFlag().split(","), "admin")<0){
            cfCarParkLinkUserQuery.setUid(userBasicInfo.getId());
        }
        List<CfCarParkLinkUser> cfCarParkLinkUsers = _cfCarParkLinkUserService.selectByQueryLeftJoinUser(cfCarParkLinkUserQuery);

        if(cfCarParkLinkUsers==null || cfCarParkLinkUsers.size()==0){
            return null;
        }
        return cfCarParkLinkUsers;
    }
}
