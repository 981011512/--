package com.cf.pay.api.swagger;

import javax.servlet.http.HttpServletRequest;

/**
 * 支付通知
 *
 * @ClassName PayNotifySwagger
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/6/2/002 7:50
 * @Version 1.0
 **/
public interface PayNotifySwagger {

    /**
     * 支付宝支付结果通知
     * @param httpServletRequest
     */
    public String AliPayNotify(HttpServletRequest httpServletRequest) throws Exception;

    /**
     * 微信支付结果通知
     * @param httpServletRequest
     */
    public String WxinPayNotify(HttpServletRequest httpServletRequest) throws Exception;

    /**
     * 易生支付结果通知
     * @param httpServletRequest
     */
    public String yiShengPayNotify(HttpServletRequest httpServletRequest) throws Exception;

    /**
     * 光大银行哆啦宝支付结果通知
     * @param httpServletRequest
     */
    public String duoLaBaoPayNotify(HttpServletRequest httpServletRequest) throws Exception;

}
