package com.cf.pay.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.pay.admin.swagger.CfPaymentAgencySwagger;
import com.cf.pay.domain.CfPaymentAgency;
import com.cf.pay.domain.request.CfPaymentAgencyForm;
import com.cf.pay.domain.request.CfPaymentAgencyQuery;
import com.cf.pay.service.CfPaymentAgencyService;
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

/**
 * 请在此填写描述
 *
 * @ClassName CfPaymentAgencyController
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/6/5/005 7:54
 * @Version 1.0
 **/
@RestController
@RequestMapping("paymentAgencyAdmin/")
@Validated
public class CfPaymentAgencyController implements CfPaymentAgencySwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfPaymentAgencyService cfPaymentAgencyService;

    @PreAuthorize("hasAuthority('pay-CfPaymentAgencyController-selectListByCondition')")
    @Override
    @RequestMapping(value = "selectListByCondition", method = RequestMethod.GET)
    public ResponseResult selectListByCondition(String conditions) {
        Map conditionsMap = (JSONObject.parseObject(conditions));
        ArrayList<String> allowFileds = new ArrayList<>();
        allowFileds.add("id");
        allowFileds.add("name");
        allowFileds.add("short_name");
        allowFileds.add("sort_index");
        allowFileds.add("score_type");
        allowFileds.add("like");
        allowFileds.add("group");
        allowFileds.add("order");
        allowFileds.add("limit");
        Map<String, String> allowFiledsMap = new HashMap<String, String>();
        allowFiledsMap.put("id","pmt");
        allowFiledsMap.put("name","pmt");
        allowFiledsMap.put("short_name","pmt");
        allowFiledsMap.put("sort_index","pmt");
        allowFiledsMap.put("score_type","pmt");
        allowFiledsMap.put("like","");
        allowFiledsMap.put("group","");
        allowFiledsMap.put("order","");
        allowFiledsMap.put("limit","");
        List<CfPaymentAgency> cfPaymentAgencies = cfPaymentAgencyService.selectListByCondition(conditionsMap, allowFiledsMap, allowFileds);
        Integer counts = cfPaymentAgencyService.selectListByConditionCounts(conditionsMap, allowFiledsMap, allowFileds);
        if(cfPaymentAgencies!=null && cfPaymentAgencies.size()>0){
            return new ResponseResult(CommonCode.SUCCESS, cfPaymentAgencies, null, counts);
        }
        return new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    @PreAuthorize("hasAuthority('pay-CfPaymentAgencyController-selectListByQuery')")
    @Override
    @RequestMapping(value = "selectListByQuery", method = RequestMethod.GET)
    public ResponseResult selectListByQuery(CfPaymentAgencyQuery cfPaymentAgencyQuery) {
        List<CfPaymentAgency> cfPaymentAgencies = cfPaymentAgencyService.getListByQuery(cfPaymentAgencyQuery);
        if(cfPaymentAgencies==null || cfPaymentAgencies.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfPaymentAgencies);
    }

    @PreAuthorize("hasAuthority('pay-CfPaymentAgencyController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@RequestBody CfPaymentAgencyForm cfPaymentAgencyForm) {
        CfPaymentAgency cfPaymentAgency = new CfPaymentAgency();
        BeanUtils.copyProperties(cfPaymentAgencyForm, cfPaymentAgency);
        CfPaymentAgency paymentAgency = cfPaymentAgencyService.add(cfPaymentAgency);
        return new ResponseResult(CommonCode.SUCCESS, paymentAgency);
    }

    @PreAuthorize("hasAuthority('pay-CfPaymentAgencyController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@RequestBody CfPaymentAgencyForm cfPaymentAgencyForm) {
        CfPaymentAgency cfPaymentAgency = new CfPaymentAgency();
        BeanUtils.copyProperties(cfPaymentAgencyForm, cfPaymentAgency);
        CfPaymentAgency paymentAgency = cfPaymentAgencyService.update(cfPaymentAgency);
        return new ResponseResult(CommonCode.SUCCESS, paymentAgency);
    }

    @PreAuthorize("hasAuthority('pay-CfPaymentAgencyController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(String id) {
        Integer delete = cfPaymentAgencyService.delete(id);
        if(delete==0){
            return new ResponseResult(CommonCode.FAIL);
        }
        return new ResponseResult(CommonCode.SUCCESS);
    }
}
