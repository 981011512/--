package com.cf.pay.domain.type;

import java.io.Serializable;

/**
 * 优惠券使用场景
 *
 * @ClassName CouponScenes
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/12/2/002 11:06
 * @Version 1.0
 **/
public class CouponScenes implements Serializable {

    public final static Byte COMMON_USE = 0;   //通用
    public final static Byte CARPARK = 1;   //停车场
    public final static Byte MALL_COMMON_USE = 2;   //商城消费

}
