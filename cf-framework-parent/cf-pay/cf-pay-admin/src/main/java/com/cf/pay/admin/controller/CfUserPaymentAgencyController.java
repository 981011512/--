package com.cf.pay.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.framework.utils.StringTools;
import com.cf.pay.admin.config.AuthenticationInterceptor;
import com.cf.pay.admin.swagger.CfUserPaymentAgencySwagger;
import com.cf.pay.domain.CfUserPaymentAgency;
import com.cf.pay.domain.request.CfUserPaymentAgencyForm;
import com.cf.pay.domain.request.CfUserPaymentAgencyQuery;
import com.cf.pay.service.CfUserPaymentAgencyService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("userPaymentAgencyAdmin/")
@Validated
public class CfUserPaymentAgencyController implements CfUserPaymentAgencySwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfUserPaymentAgencyService cfUserPaymentAgencyService;

    @Autowired
    protected HttpServletRequest request;

    @PreAuthorize("hasAuthority('pay-CfUserPaymentAgencyController-selectListByCondition')")
    @Override
    @RequestMapping(value = "selectListByCondition", method = RequestMethod.GET)
    public ResponseResult selectListByCondition(String conditions) {
        Map conditionsMap = (JSONObject.parseObject(conditions));
        ArrayList<String> allowFileds = new ArrayList<>();
        allowFileds.add("id");
        allowFileds.add("name");
        allowFileds.add("uid");
        allowFileds.add("payment_agency_short_name");
        allowFileds.add("like");
        allowFileds.add("group");
        allowFileds.add("order");
        allowFileds.add("limit");
        Map<String, String> allowFiledsMap = new HashMap<String, String>();
        allowFiledsMap.put("id","upm");
        allowFiledsMap.put("name","upm");
        allowFiledsMap.put("uid","upm");
        allowFiledsMap.put("payment_agency_short_name","upm");
        allowFiledsMap.put("like","");
        allowFiledsMap.put("group","");
        allowFiledsMap.put("order","");
        allowFiledsMap.put("limit","");
        List<CfUserPaymentAgency> cfPaymentAgencies = cfUserPaymentAgencyService.selectListByCondition(conditionsMap, allowFiledsMap, allowFileds);
        Integer counts = cfUserPaymentAgencyService.selectListByConditionCounts(conditionsMap, allowFiledsMap, allowFileds);
        if(cfPaymentAgencies!=null && cfPaymentAgencies.size()>0){
            for (CfUserPaymentAgency cfUserPaymentAgency: cfPaymentAgencies){
                cfUserPaymentAgency.setPayKey(null);
                cfUserPaymentAgency.setSecret(null);
            }
            return new ResponseResult(CommonCode.SUCCESS, cfPaymentAgencies, null, counts);
        }
        return new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    @PreAuthorize("hasAuthority('pay-CfUserPaymentAgencyController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@RequestBody CfUserPaymentAgencyForm cfUserPaymentAgencyForm) {
        CfUserPaymentAgency cfUserPaymentAgency = new CfUserPaymentAgency();
        BeanUtils.copyProperties(cfUserPaymentAgencyForm, cfUserPaymentAgency);
        CfUserPaymentAgency userPaymentAgency = cfUserPaymentAgencyService.add(cfUserPaymentAgency);
        return new ResponseResult(CommonCode.SUCCESS, userPaymentAgency);
    }

    @PreAuthorize("hasAuthority('pay-CfUserPaymentAgencyController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@RequestBody CfUserPaymentAgencyForm cfUserPaymentAgencyForm) {
        CfUserPaymentAgency cfUserPaymentAgency = new CfUserPaymentAgency();
        BeanUtils.copyProperties(cfUserPaymentAgencyForm, cfUserPaymentAgency);
        CfUserPaymentAgency userPaymentAgency = cfUserPaymentAgencyService.update(cfUserPaymentAgency);
        return new ResponseResult(CommonCode.SUCCESS, userPaymentAgency);
    }

    @PreAuthorize("hasAuthority('pay-CfUserPaymentAgencyController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(String id) {
        Integer delete = cfUserPaymentAgencyService.delete(id);
        if(delete==0){
            return new ResponseResult(CommonCode.FAIL);
        }
        return new ResponseResult(CommonCode.SUCCESS);
    }

    @PreAuthorize("hasAuthority('pay-CfUserPaymentAgencyController-getListByQuery')")
    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(CfUserPaymentAgencyQuery cfUserPaymentAgencyQuery)throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        if(StringTools.findStringInArray(userBasicInfo.getRoleFlag().split(","), "admin")<0){
            cfUserPaymentAgencyQuery.setUid(userBasicInfo.getId());
        }
        List<CfUserPaymentAgency> cfUserPaymentAgencies = cfUserPaymentAgencyService.getListByQuery(cfUserPaymentAgencyQuery);
        if(cfUserPaymentAgencies==null || cfUserPaymentAgencies.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS,cfUserPaymentAgencies);
    }
}
