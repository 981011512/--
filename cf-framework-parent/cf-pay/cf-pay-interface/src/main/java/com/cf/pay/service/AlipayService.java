package com.cf.pay.service;

import com.cf.pay.domain.CfOrder;
import com.cf.pay.domain.CfUserPaymentAgency;
import com.cf.pay.domain.response.ResultMap;

import java.util.Map;

/**
 * 支付宝支付服务
 *
 * @ClassName AlipayService
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/6/2/002 5:57
 * @Version 1.0
 **/
public interface AlipayService {

    public Object initAlipayConfig(CfUserPaymentAgency cfUserPaymentAgency) throws Exception;

    /**
     * 调用支付宝进行支付
     * @param cfOrder
     * @param buyerId   支付宝自己的用户id
     * @param buyerId   alipayConfig
     * @return
     */
    ResultMap doPay(CfOrder cfOrder, String buyerId, Object alipayConfig) throws Exception;

    /**
     * 校验支付宝支付结果
     * @return
     * @throws Exception
     */
    boolean rsaCertCheck(Map<String,String> params) throws Exception;

}
