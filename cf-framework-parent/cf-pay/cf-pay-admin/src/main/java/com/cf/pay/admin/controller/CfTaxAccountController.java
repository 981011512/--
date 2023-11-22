package com.cf.pay.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.pay.admin.swagger.CfTaxAccountSwagger;
import com.cf.pay.domain.CfTaxAccount;
import com.cf.pay.domain.request.CfTaxAccountForm;
import com.cf.pay.service.CfTaxAccountService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("taxAccountAdmin/")
@Validated
public class CfTaxAccountController implements CfTaxAccountSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfTaxAccountService cfTaxAccountService;

    @Override
    @PreAuthorize("hasAuthority('pay-CfTaxAccountController-selectListByCondition')")
    @RequestMapping(value = "selectListByCondition", method = RequestMethod.GET)
    public ResponseResult selectListByCondition(String conditions) {
        Map conditionsMap = (JSONObject.parseObject(conditions));
        ArrayList<String> allowFileds = new ArrayList<>();
        allowFileds.add("id");
        allowFileds.add("tax_agency");
        allowFileds.add("uid");
        allowFileds.add("create_time");
        allowFileds.add("update_time");
        allowFileds.add("like");
        allowFileds.add("group");
        allowFileds.add("order");
        allowFileds.add("limit");
        Map<String, String> allowFiledsMap = new HashMap<String, String>();
        allowFiledsMap.put("id","ta");
        allowFiledsMap.put("tax_agency","ta");
        allowFiledsMap.put("uid","ta");
        allowFiledsMap.put("create_time","ta");
        allowFiledsMap.put("update_time","ta");
        allowFiledsMap.put("like","");
        allowFiledsMap.put("group","");
        allowFiledsMap.put("order","");
        allowFiledsMap.put("limit","");
        List<CfTaxAccount> cfPaymentAgencies = cfTaxAccountService.selectListByCondition(conditionsMap, allowFiledsMap, allowFileds);
        Integer counts = cfTaxAccountService.selectListByConditionCounts(conditionsMap, allowFiledsMap, allowFileds);
        if(cfPaymentAgencies!=null && cfPaymentAgencies.size()>0){
            return new ResponseResult(CommonCode.SUCCESS, cfPaymentAgencies, null, counts);
        }
        return new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    @Override
    @PreAuthorize("hasAuthority('pay-CfTaxAccountController-add')")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@RequestBody CfTaxAccountForm cfTaxAccountForm) {
        CfTaxAccount cfTaxAccount = new CfTaxAccount();
        BeanUtils.copyProperties(cfTaxAccountForm, cfTaxAccount);
        CfTaxAccount taxAccount = cfTaxAccountService.add(cfTaxAccount);
        return new ResponseResult(CommonCode.SUCCESS, taxAccount);
    }

    @Override
    @PreAuthorize("hasAuthority('pay-CfPaymentAgencyController-update')")
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@RequestBody CfTaxAccountForm cfTaxAccountForm) {
        CfTaxAccount cfTaxAccount = new CfTaxAccount();
        BeanUtils.copyProperties(cfTaxAccountForm, cfTaxAccount);
        CfTaxAccount taxAccount = cfTaxAccountService.update(cfTaxAccount);
        return new ResponseResult(CommonCode.SUCCESS, taxAccount);
    }

    @Override
    @PreAuthorize("hasAuthority('pay-CfPaymentAgencyController-delete')")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(String id) {
        Integer delete = cfTaxAccountService.delete(id);
        return delete>0?new ResponseResult(CommonCode.SUCCESS):new ResponseResult(CommonCode.FAIL);
    }
}
