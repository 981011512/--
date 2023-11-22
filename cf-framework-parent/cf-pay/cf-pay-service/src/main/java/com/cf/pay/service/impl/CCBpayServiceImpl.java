package com.cf.pay.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cf.framework.utils.HttpClient;
import com.cf.framework.utils.Snowflake;
import com.cf.framework.utils.StringTools;
import com.cf.pay.domain.CfUserPaymentAgency;
import com.cf.pay.domain.ccbpay.CCBPayUtil;
import com.cf.pay.domain.request.CCBScannedChargebackForm;
import com.cf.pay.domain.response.CCBScannedChargeback;
import com.cf.pay.service.CCBpayService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CCBpayServiceImpl implements CCBpayService {

    private static Logger logger = LoggerFactory.getLogger(Snowflake.class);

    @Override
    public CCBScannedChargeback ccbPayRequest(String host, CfUserPaymentAgency cfUserPaymentAgency, CCBScannedChargebackForm ccbScannedChargebackForm, String requestType) throws Exception {

        ccbScannedChargebackForm.setTERMNO1("");
        ccbScannedChargebackForm.setTERMNO2("");
        ccbScannedChargebackForm.setCrdt_No("");
        ccbScannedChargebackForm.setPlateColor("1");
        ccbScannedChargebackForm.setPROINFO("");
        ccbScannedChargebackForm.setORDERID("");

        String merInfo = "MERCHANTID="+cfUserPaymentAgency.getMchId()+"&POSID="+cfUserPaymentAgency.getPayKey()+"&BRANCHID="+cfUserPaymentAgency.getAppid();

        String urlParmas = StringTools.pojoToURLParams(ccbScannedChargebackForm);

        //加密原串
        String param = merInfo;

        logger.info("urlParmas:"+urlParmas);
        logger.info("加密前的请求参数:"+param);

        CCBPayUtil ccbPayUtil = new CCBPayUtil();
        String ccbParam = ccbPayUtil.makeCCBParam(param+urlParmas, cfUserPaymentAgency.getSecret());
        //拼接请求串
        String url = host + merInfo + "&ccbParam=" + ccbParam;

        logger.error("完整的请求地址(加密处理后的):"+url);

        //向建行网关发送请求交易...
        if(requestType.equals("get")){
            JSONObject payResulJson = HttpClient.doGet(url);
            System.out.println(payResulJson);
        }else{
            HashMap<String, String> requestHeaders = new HashMap<>();
//            requestHeaders.put("Content-Type","text/html; charset=utf-8");
            ccbScannedChargebackForm.setMERCHANTID(cfUserPaymentAgency.getMchId());
            ccbScannedChargebackForm.setPOSID(cfUserPaymentAgency.getPayKey());
            ccbScannedChargebackForm.setBRANCHID(cfUserPaymentAgency.getAppid());
            ccbScannedChargebackForm.setCcbParam(ccbParam);
            JSONObject jsonObject = StringTools.pojoToJSONObject(ccbScannedChargebackForm);

            JSONObject payResulJson = (JSONObject)HttpClient.doPost(jsonObject,url,requestHeaders, true);
            System.out.println(payResulJson);
        }

        return null;
    }

}
