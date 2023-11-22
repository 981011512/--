package com.cf.pay.api.controller;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.pay.api.swagger.CfPaymentAgencySwagger;
import com.cf.pay.domain.CfPaymentAgency;
import com.cf.pay.domain.CfUserPaymentAgency;
import com.cf.pay.domain.request.CfPaymentAgencyQuery;
import com.cf.pay.domain.request.CfUserPaymentAgencyQuery;
import com.cf.pay.service.CfPaymentAgencyService;
import com.cf.pay.service.CfUserPaymentAgencyService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @ClassName CfPaymentAgencyController
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/29/029 7:36
 * @Version 1.0
 **/
@RestController
@RequestMapping("pay/")
@Validated
public class CfPaymentAgencyController implements CfPaymentAgencySwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfPaymentAgencyService cfPaymentAgencyService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserPaymentAgencyService cfUserPaymentAgencyService;

    @Override
    @RequestMapping(value = "getPaymentAgencyListByCarParkId", method = RequestMethod.GET)
    public ResponseResult getPaymentAgencyListByCarParkId(String carParkId, String useScenes) {
        List<CfPaymentAgency> cfPaymentAgencies = cfPaymentAgencyService.getPaymentAgencyListByCarParkId(carParkId, useScenes);
        if(cfPaymentAgencies==null || cfPaymentAgencies.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfPaymentAgencies);
    }

    @Override
    @RequestMapping(value = "getPaymentAgencyListByQuery", method = RequestMethod.GET)
    public ResponseResult getPaymentAgencyListByQuery(CfPaymentAgencyQuery cfPaymentAgencyQuery) {
        List<CfPaymentAgency> cfPaymentAgencies = cfPaymentAgencyService.getListByQuery(cfPaymentAgencyQuery);
        if(cfPaymentAgencies==null || cfPaymentAgencies.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfPaymentAgencies);
    }

    @Override
    @RequestMapping(value = "getUserPaymentAgencyListByQuery", method = RequestMethod.GET)
    public ResponseResult getUserPaymentAgencyListByQuery(CfUserPaymentAgencyQuery cfUserPaymentAgencyQuery) {
        List<CfUserPaymentAgency> cfUserPaymentAgencies = cfUserPaymentAgencyService.getListByQuery(cfUserPaymentAgencyQuery);
        if(cfUserPaymentAgencies==null || cfUserPaymentAgencies.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        for (CfUserPaymentAgency cfUserPaymentAgency: cfUserPaymentAgencies){
            cfUserPaymentAgency.setAppid("");
            cfUserPaymentAgency.setCertPath("");
            cfUserPaymentAgency.setMchId("");
            cfUserPaymentAgency.setPayKey("");
            cfUserPaymentAgency.setPayNotifyUrl("");
            cfUserPaymentAgency.setRefundPayNotifyUrl("");
            cfUserPaymentAgency.setSecret("");
        }
        return new ResponseResult(CommonCode.SUCCESS, cfUserPaymentAgencies);
    }
}
