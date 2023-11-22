package com.cf.carpark.admin.controller;

import com.cf.carpark.admin.config.AuthenticationInterceptor;
import com.cf.carpark.admin.swagger.CfCarParkPaymentAgencySwagger;
import com.cf.carpark.domain.CfCarParkLinkUser;
import com.cf.carpark.domain.CfCarParkPaymentAgency;
import com.cf.carpark.domain.request.CfCarParkLinkUserQuery;
import com.cf.carpark.domain.request.CfCarParkPaymentAgencyForm;
import com.cf.carpark.domain.request.CfCarParkPaymentAgencyQuery;
import com.cf.carpark.service.CfCarParkLinkUserService;
import com.cf.carpark.service.CfCarParkPaymentAgencyService;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("cfCarParkPaymentAgencyAdmin/")
@Validated
public class CfCarParkPaymentAgencyController implements CfCarParkPaymentAgencySwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCarParkPaymentAgencyService cfCarParkPaymentAgencyService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfCarParkLinkUserService cfCarParkLinkUserService;
    @Autowired
    protected HttpServletRequest request;

    @PreAuthorize("hasAuthority('carpark-CfCarParkPaymentAgencyController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@RequestBody CfCarParkPaymentAgencyForm cfCarParkPaymentAgencyForm) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        cfCarParkLinkUserService.checkHostOrAdminer(userBasicInfo, cfCarParkPaymentAgencyForm.getCarParkId());
        CfCarParkPaymentAgency cfCarParkPaymentAgency = new CfCarParkPaymentAgency();
        BeanUtils.copyProperties(cfCarParkPaymentAgencyForm, cfCarParkPaymentAgency);
        CfCarParkPaymentAgency carParkPaymentAgency = cfCarParkPaymentAgencyService.add(cfCarParkPaymentAgency);
        return new ResponseResult(CommonCode.SUCCESS, carParkPaymentAgency);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkPaymentAgencyController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@RequestBody CfCarParkPaymentAgencyForm cfCarParkPaymentAgencyForm) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        cfCarParkLinkUserService.checkHostOrAdminer(userBasicInfo, cfCarParkPaymentAgencyForm.getCarParkId());
        CfCarParkPaymentAgency cfCarParkPaymentAgency = new CfCarParkPaymentAgency();
        BeanUtils.copyProperties(cfCarParkPaymentAgencyForm, cfCarParkPaymentAgency);
        CfCarParkPaymentAgency carParkPaymentAgency = cfCarParkPaymentAgencyService.update(cfCarParkPaymentAgency);
        return new ResponseResult(CommonCode.SUCCESS, carParkPaymentAgency);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkPaymentAgencyController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(String id) throws Exception {
        CfCarParkPaymentAgency cfCarParkPaymentAgency = cfCarParkPaymentAgencyService.findById(id, false);
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        cfCarParkLinkUserService.checkHostOrAdminer(userBasicInfo, cfCarParkPaymentAgency.getCarParkId());
        Integer delete = cfCarParkPaymentAgencyService.delete(id);
        return delete>0?new ResponseResult(CommonCode.SUCCESS):new ResponseResult(CommonCode.FAIL);
    }

    @PreAuthorize("hasAuthority('carpark-CfCarParkPaymentAgencyController-selectByQuery')")
    @Override
    @RequestMapping(value = "selectByQuery", method = RequestMethod.GET)
    public ResponseResult selectByQuery(CfCarParkPaymentAgencyQuery cfCarParkPaymentAgencyQuery) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        if(StringTools.findStringInArray(userBasicInfo.getRoleFlag().split(","), "admin")<0 && StringTools.findStringInArray(userBasicInfo.getRoleFlag().split(","), "finance")<0){
            CfCarParkLinkUserQuery cfCarParkLinkUserQuery = new CfCarParkLinkUserQuery();
            cfCarParkLinkUserQuery.setUid(userBasicInfo.getId());
            List<CfCarParkLinkUser> cfCarParkLinkUsers = cfCarParkLinkUserService.getListByQuery(cfCarParkLinkUserQuery);
            if(cfCarParkLinkUsers==null || cfCarParkLinkUsers.size()==0){
                return new ResponseResult(CommonCode.NO_MORE_DATAS);
            }
            String carParkIds = "";
            for (CfCarParkLinkUser cfCarParkLinkUser: cfCarParkLinkUsers){
                carParkIds += ",'"+cfCarParkLinkUser.getCarParkId()+"'";
                cfCarParkPaymentAgencyQuery.getCarParkIdList().add(cfCarParkLinkUser.getCarParkId());
            }
            cfCarParkPaymentAgencyQuery.setCarParkIds(carParkIds.substring(1));
            cfCarParkPaymentAgencyQuery.setCarParkId(null);
        }
        List<CfCarParkPaymentAgency> cfCarParkPaymentAgencies = cfCarParkPaymentAgencyService.selectByQuery(cfCarParkPaymentAgencyQuery);
        Integer total = 0;
        if(cfCarParkPaymentAgencyQuery.getPage()==1){
            total = cfCarParkPaymentAgencyService.countByQuery(cfCarParkPaymentAgencyQuery);
        }

        if(cfCarParkPaymentAgencies==null || cfCarParkPaymentAgencies.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfCarParkPaymentAgencies, total);
    }
}
