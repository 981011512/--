package com.cf.pay.domain.type;

import java.io.Serializable;

/**
 * 商品类型
 *
 * @ClassName GoodsType
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/2/002 11:06
 * @Version 1.0
 **/
public class GoodsType implements Serializable {

    public final static Byte CARPARK_PAYMENT = 1;   //停车缴费
    public final static Byte DEPOSIT = 2;   //充值
    public final static Byte MALL_CONSUMPTION = 3;   //商城消费

    public final static Byte TRANSFER = 4;   //转账
    public final static Byte CARPARK_PAYMENT_PACKEAGE = 5;   //停车套餐
    public final static Byte PARKING_SUBSCRIPTION = 6;   //车位预订
    public final static Byte COUPON_ACTIVITY_RECHARGE = 7;   //优惠券活动充值
    public final static Byte NEW_ENERGY_CHARGING = 8;   //新能源充电
    public final static Byte WITHDRAW = 9;   //提现
    public final static Byte REFUND = 10;   //退款

    public final static Byte COLLECTION = 11;   //收款

}
