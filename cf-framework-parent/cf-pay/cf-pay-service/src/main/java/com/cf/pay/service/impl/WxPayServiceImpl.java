package com.cf.pay.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cf.carpark.domain.CfCarPark;
import com.cf.carpark.domain.CfCarParkPackage;
import com.cf.carpark.domain.CfCarParkPackagePrice;
import com.cf.carpark.domain.CfCarParkUseLog;
import com.cf.carpark.domain.request.CfCarParkPackageQuery;
import com.cf.carpark.domain.type.CarParkUseLogCreatePosition;
import com.cf.carpark.domain.type.ReleaseType;
import com.cf.carpark.service.*;
import com.cf.framework.domain.pay.PayCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.BCryptUtil;
import com.cf.framework.utils.DateUtil;
import com.cf.framework.utils.Snowflake;
import com.cf.framework.utils.StringTools;
import com.cf.pay.domain.*;
import com.cf.pay.domain.request.CfOrderQuery;
import com.cf.pay.domain.response.ResultMap;
import com.cf.pay.domain.type.CouponStatus;
import com.cf.pay.domain.type.GoodsType;
import com.cf.pay.domain.type.PayStatus;
import com.cf.pay.service.*;
import com.cf.pay.service.config.WxPayAppConfig;
import com.cf.pay.service.util.SignUtil;
import com.cf.ucenter.domain.CfUser;
import com.cf.ucenter.service.CfUserService;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConstants;
import com.github.wxpay.sdk.WXPayUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 微信支付服务
 *
 * @ClassName WxPayServiceImpl
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/4/004 8:53
 * @Version 1.0
 **/
@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class WxPayServiceImpl implements WxPayService {
    private WxPayAppConfig wxPayAppConfig;
    @Autowired
    private CfOrderService cfOrderService;
    @Autowired
    private CfUserPaymentAgencyService cfUserPaymentAgencyService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCarParkService cfCarParkService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCarParkPackageService cfCarParkPackageService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCarParkPackagePriceService cfCarParkPackagePriceService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCarParkUseLogService cfCarParkUseLogService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCouponActivityService cfCouponActivityService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCouponService cfCouponService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfCarParkReleaseLogService cfCarParkReleaseLogService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserService cfUserService;

    private static Logger logger = LoggerFactory.getLogger(Snowflake.class);

    public WxPayServiceImpl(){}

    public WxPayServiceImpl(CfUserPaymentAgency cfUserPaymentAgency){
        this._initWxPayAppConfig(cfUserPaymentAgency);
    }

    private WxPayAppConfig _initWxPayAppConfig(CfUserPaymentAgency cfUserPaymentAgency){
        WxPayAppConfig _wxPayAppConfig = new WxPayAppConfig();
        _wxPayAppConfig.setKey(cfUserPaymentAgency.getPayKey());
        _wxPayAppConfig.setAppID(cfUserPaymentAgency.getAppid());
        _wxPayAppConfig.setSubAppID(cfUserPaymentAgency.getSubAppid());
        _wxPayAppConfig.setCertPath(cfUserPaymentAgency.getCertPath());
        _wxPayAppConfig.setMchID(cfUserPaymentAgency.getMchId());
        _wxPayAppConfig.setSubMchID(cfUserPaymentAgency.getSubMchId());
        _wxPayAppConfig.setPayNotifyUrl(cfUserPaymentAgency.getPayNotifyUrl());
        _wxPayAppConfig.setRefundNotifyUrl(cfUserPaymentAgency.getRefundPayNotifyUrl());
        wxPayAppConfig = _wxPayAppConfig;
        return _wxPayAppConfig;
    }

    @Override
    public ResultMap unifiedOrder(String orderNo, double amount, String body, String ip, String openid, CfUserPaymentAgency cfUserPaymentAgency) throws Exception{
        Map<String, String> returnMap = new HashMap<>();
        //微信支付处理  自己生成预支付信息
        return ResultMap.ok().put("data", returnMap);
    }

    @Override
    public String notify(String notifyStr) throws Exception{
        String xmlBack = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[报文为空]]></return_msg></xml> ";
        // 转换成map
        Map<String, String> resultMap = WXPayUtil.xmlToMap(notifyStr);
        if(StringUtils.isEmpty(resultMap.get("out_trade_no"))){
            ExceptionCast.cast(PayCode.WECHAT_PAY_NOTIFY_FAIL, "weixin_XML missing out_trade_no");
        }
        if(!resultMap.get("result_code").equals("SUCCESS")){
            ExceptionCast.cast(PayCode.WECHAT_PAY_NOTIFY_FAIL, "pay fail");
        }

        CfOrder cfOrder = cfOrderService.findById(resultMap.get("out_trade_no"),false);
        if(cfOrder==null){
            ExceptionCast.cast(PayCode.ORDER_DOES_NOT_EXIST, notifyStr);
        }
        if(cfOrder.getStatus()==PayStatus.PAID){
            return null;
        }
        //如果支付方式为套餐，设置为微信支付
        if(cfOrder.getPaymentAgencyShortName().equals("package")){
            CfUserPaymentAgency cfUserPaymentAgency = cfUserPaymentAgencyService.findById(cfOrder.getId());
            if(cfUserPaymentAgency!=null){
                cfOrder.setPaymentAgencyShortName(cfUserPaymentAgency.getPaymentAgencyShortName());
            }else{
                cfOrder.setPaymentAgencyShortName("wei_xin_pay_cny");
            }
        }
        CfUserPaymentAgency cfUserPaymentAgency = cfUserPaymentAgencyService.findById(cfOrder.getUserPaymentAgencyId());
        if(cfUserPaymentAgency==null){
            ExceptionCast.cast(PayCode.MERCHANT_PAYMENT_ACCOUNT_DOES_NOT_EXIST, notifyStr);
        }
        WxPayAppConfig _wxPayAppConfig = this._initWxPayAppConfig(cfUserPaymentAgency);
        WXPay wxpayApp = new WXPay(_wxPayAppConfig);
        if (wxpayApp.isPayResultNotifySignatureValid(resultMap)) {
            if (resultMap.get("return_code").equals("SUCCESS")) {
                if (StringUtils.isNotEmpty(resultMap.get("out_trade_no"))) {
                    cfOrder.setThirdPartyOrderId(resultMap.get("transaction_id"));
                    cfOrder.setPayTime(DateUtil.dateToStamp(resultMap.get("time_end"),"yyyyMMddHHmmss"));
                    cfOrderService.paySuccessAndupdateOrder(cfOrder, (new BigDecimal(resultMap.get("total_fee"))).divide(new BigDecimal(100)));
                    xmlBack = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
                }
            }
        }
        return xmlBack;
    }

    @Override
    public ResultMap refund(String orderNo, BigDecimal totalFee, BigDecimal amount, String refundReason) throws Exception{

        if(StringUtils.isBlank(orderNo)){
            ExceptionCast.cast(PayCode.ORDER_NUMBER_CANNOT_BE_EMPTY);
        }
        if(amount.doubleValue() <= 0){
            ExceptionCast.cast(PayCode.THE_REFUND_AMOUNT_TOO_SMALL);
        }

        Map<String, String> responseMap = new HashMap<>();
        Map<String, String> requestMap = new HashMap<>();
        WXPay wxpay = new WXPay(wxPayAppConfig);
        requestMap.put("out_trade_no", orderNo);
        requestMap.put("out_refund_no", orderNo);
        requestMap.put("total_fee", totalFee.toString());
        requestMap.put("refund_fee", String.valueOf((amount.doubleValue()*100)));//所需退款金额
        requestMap.put("refund_desc", refundReason);
        responseMap = wxpay.refund(requestMap);
        String return_code = responseMap.get("return_code");   //返回状态码
        String return_msg = responseMap.get("return_msg");     //返回信息
        if ("SUCCESS".equals(return_code)) {
            String result_code = responseMap.get("result_code");       //业务结果
            String err_code_des = responseMap.get("err_code_des");     //错误代码描述
            if ("SUCCESS".equals(result_code)) {
                //表示退款申请接受成功，结果通过退款查询接口查询
                //修改用户订单状态为退款申请中或已退款。退款异步通知根据需求，可选
                //
                return ResultMap.ok("success");
            } else {
                ExceptionCast.cast(PayCode.WECHAT_REFUND_FAILED, "["+orderNo+"]:"+return_msg);
                return ResultMap.error(err_code_des);
            }
        } else {
            ExceptionCast.cast(PayCode.THE_REFUND_AMOUNT_TOO_SMALL, "["+orderNo+"]:"+return_msg);
        }
        return null;
    }

    @Override
    public String yiShengNotify(String notifyStr) throws Exception {
        Map<String, String> parse = (Map<String, String>) JSONObject.parse(notifyStr);

        CfOrder cfOrder = cfOrderService.findById(parse.get("tradetrace"),false);
        if(cfOrder==null){
            ExceptionCast.cast(PayCode.ORDER_DOES_NOT_EXIST, notifyStr);
        }
        if(cfOrder.getStatus()==PayStatus.PAID){
            return null;
        }

        CfUserPaymentAgency cfUserPaymentAgency = cfUserPaymentAgencyService.findById(cfOrder.getUserPaymentAgencyId());
        if(cfUserPaymentAgency==null){
            ExceptionCast.cast(PayCode.MERCHANT_PAYMENT_ACCOUNT_DOES_NOT_EXIST, notifyStr);
        }

        boolean checksign = SignUtil.checksign(notifyStr, cfUserPaymentAgency.getSecret());
        if(!checksign){
            return null;
        }

        cfOrder.setThirdPartyOrderId(parse.get("wxtransactionid"));
        cfOrder.setPayTime(DateUtil.dateToStamp(parse.get("wxtimeend"),"yyyyMMddHHmmss"));
        cfOrderService.paySuccessAndupdateOrder(cfOrder, (new BigDecimal(parse.get("payamt"))).divide(new BigDecimal(100)));

        return "{\"resultcode\":\"00\"}";
    }

    @Override
    public String duoLaBaoNotify(Map<String, String> notifyMap) throws Exception {
        if(!notifyMap.containsKey("timestamp") || !notifyMap.containsKey("token") || notifyMap.get("status")==null || !notifyMap.get("status").equals("SUCCESS")){
            return null;
        }
        CfOrder cfOrder = cfOrderService.findById(notifyMap.get("requestNum"),false);
        if(cfOrder==null){
            ExceptionCast.cast(PayCode.ORDER_DOES_NOT_EXIST, notifyMap.toString());
        }
        if(cfOrder.getStatus()==PayStatus.PAID){
            return null;
        }

        CfUserPaymentAgency cfUserPaymentAgency = cfUserPaymentAgencyService.findById(cfOrder.getUserPaymentAgencyId());
        if(cfUserPaymentAgency==null){
            ExceptionCast.cast(PayCode.MERCHANT_PAYMENT_ACCOUNT_DOES_NOT_EXIST, notifyMap.toString());
        }

        String token = BCryptUtil.SHA1("secretKey=" + cfUserPaymentAgency.getSecret() + "&timestamp=" + notifyMap.get("timestamp"));
        if(!token.toUpperCase().equals(notifyMap.get("token"))){
            return null;
        }

        cfOrder.setThirdPartyOrderId(notifyMap.get("orderNum"));
        cfOrder.setPayTime(DateUtil.dateToStamp(notifyMap.get("completeTime"),"yyyyMMddHHmmss"));
        cfOrderService.paySuccessAndupdateOrder(cfOrder, (new BigDecimal(notifyMap.get("orderAmount"))));

        return "ok";
    }
}
