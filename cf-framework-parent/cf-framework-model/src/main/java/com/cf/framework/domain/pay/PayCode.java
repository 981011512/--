package com.cf.framework.domain.pay;

import com.cf.framework.domain.response.ResultCode;

/**
 * 支付
 *
 * @ClassName MessageCode
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/12/15/015 21:45
 * @Version 1.0
 **/
public enum PayCode implements ResultCode {

    ORDER_NUMBER_CANNOT_BE_EMPTY(false,12000,"订单编号不能为空！"),
    THE_REFUND_AMOUNT_TOO_SMALL(false,12001,"退款金额必须大于0！"),
    FAILED_TO_OBTAIN_PREPAID_TRANSACTION_SESSION_ID(false,12002,"获取预支付交易会话标识失败！"),
    WECHAT_PAY_FAILED_TO_PLACE_A_UNIFIED_ORDER(false,12003,"微信支付统一下单失败！"),
    WECHAT_REFUND_FAILED(false,12004,"微信退款失败！"),
    ORDER_DOES_NOT_EXIST(false,12005,"订单不存在！"),
    NO_NEED_TO_PAY(false,12006,"无需支付！"),
    PAYMENT_INSTITUTION_DOES_NOT_EXIST(false,12007,"支付机构不存在！"),
    MERCHANT_PAYMENT_ACCOUNT_DOES_NOT_EXIST(false,12008,"商户支付账号不存在！"),
    NO_PARKING_PAYMENT_CONFIGURATION_FOUND(false,12009,"没有找到停车场支付配置！"),
    THIS_COUPON_DOES_NOT_BELONG_TO_YOU(false,12010,"该优惠券不属于你！"),
    COUPON_USAGE_SCENARIOS_DO_NOT_MATCH(false,12011,"优惠券使用场景不匹配！"),
    COUPON_HAS_EXPIRED_OR_IS_NOT_YET_VALID(false,12012,"优惠券已过期或未生效！"),
    MISSING_ALIPAY_APPCERTPATH(false,12013,"缺少支付宝应用公钥证书路径！"),
    MISSING_ALIPAY_ALIPAYPUBLICCERTPATH(false,12014,"缺少支付宝公钥证书路径！"),
    MISSING_ALIPAY_ROOTCERTPATH(false,12015,"缺少支付宝根证书路径！"),
    MISSING_OR_WRONG_CERTIFICATION_PATH_CONFIGURATION(false,12016,"缺少或错误证书路径配置！"),
    ALIPAY_PREORDER_ERROR(false,12017,"支付宝预下单错误！"),
    WECHAT_PAY_NOTIFY_FAIL(false,12018,"微信支付通知失败！"),
    TAX_ACCOUNT_NOT_EXIST(false,12019,"税务账号不存在！"),
    TAX_ACCOUNT_MISSING_CONFIGURATION(false,12020,"税务账号缺少配置！"),
    TAX_PLATFORM_NOT_EXIST(false,12021,"税务平台不存在！"),
    COUPON_USAGE_OBJECT_DO_NOT_MATCH(false,12022,"优惠使用对象不匹配！")
    ;
    //操作代码
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private PayCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }

    @Override
    public void setMessage(String _message) {
        this.message = _message;
    }

    String mixMessage;
    @Override
    public String mixMessage() {
        return mixMessage;
    }

    @Override
    public void setMixMessage(String _mixMessage) {
        this.mixMessage = _mixMessage;
    }
}
