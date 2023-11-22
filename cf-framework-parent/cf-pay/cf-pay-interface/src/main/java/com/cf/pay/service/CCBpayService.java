package com.cf.pay.service;

import com.cf.pay.domain.CfUserPaymentAgency;
import com.cf.pay.domain.request.CCBScannedChargebackForm;
import com.cf.pay.domain.response.CCBScannedChargeback;

import java.util.Map;

/**
 * 建行支付相关
 */
public interface CCBpayService {

    /**
     * 向建行发起请求
     * @param host  接口请求地址
     * @param cfUserPaymentAgency  支付账号数据
     * @param ccbScannedChargebackForm  请求参数
     * @param requestType  请求协议类型(get或post)
     * @return
     */
    CCBScannedChargeback ccbPayRequest(String host, CfUserPaymentAgency cfUserPaymentAgency, CCBScannedChargebackForm ccbScannedChargebackForm, String requestType) throws Exception;


}
