package com.cf.chat.domain;

/**
 * 订阅消息类型
 */
public class SubscribeMessageType {

    public final static String PAY_SUCCESSFUL = "pay_successful";   //支付成功
    public final static String MONTHLY_CARD_EXPIRATION_NOTICE = "monthly_card_expiration_notice";   //月卡到期通知
    public final static String COUPON_NOTIFICATION = "coupon_notification";   //获取优惠券通知
    public final static String ADVANCE_PAYMENT_NOTICE = "advance_payment_notice";   //提前缴费通知
}
