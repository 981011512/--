package com.cf.pay.domain.type;

import java.io.Serializable;

/**
 * 优惠券类型
 *
 * @ClassName CouponType
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2022/12/2/002 11:06
 * @Version 1.0
 **/
public class CouponType implements Serializable {

    public final static byte TIMES_COUPON = 1;   //次数券
    public final static byte AMOUNT_COUPON = 2;   //金额券
    public final static byte TIME_COUPON = 3;   //时长券

}
