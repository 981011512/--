package com.cf.ucenter.type;

import java.io.Serializable;

/**
 * 微信小程序订阅消息模板
 */
public class CfWeiXinSubscribeToNotificationsType implements Serializable {

    public final static String PAY_SUCCESSFUL = "pay_successful";   //支付成功
    public final static String MONTHLY_CARD_EXPIRATION_NOTICE = "monthly_card_expiration_notice";   //月卡过期提醒
    public final static String COUPON_NOTIFICATION = "coupon_notification";   //微信提醒
    public final static String LOGISTICS_LOADING_AND_UNLOADING = "logistics_loading_and_unloading";   //物流装卸货通知
    public final static String LOGISTICS_QUEUE = "logistics_queue";   //物流排队通知
    public final static String LOGISTICS_NUMBER_OVER = "logistics_number_over";   //物流排队过号通知
    public final static String LOGISTICS_CANCEL_APPOINTMENT = "logistics_cancel_appointment";   //物流排队取消排队通知

}
