package com.cf.pay.domain.type;

import java.io.Serializable;

/**
 * 优惠券状态
 *
 * @ClassName CouponStatus
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/12/2/002 11:06
 * @Version 1.0
 **/
public class CouponStatus implements Serializable {

    public final static Byte USED = 0;   //已使用
    public final static Byte NOT_USED = 1;   //未使用
    public final static Byte LOCKED = 2;   //已锁定

}
