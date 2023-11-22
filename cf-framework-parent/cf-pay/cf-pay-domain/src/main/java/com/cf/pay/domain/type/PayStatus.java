package com.cf.pay.domain.type;

import java.io.Serializable;

/**
 * 支付状态
 *
 * @ClassName GoodsType
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/2/002 11:06
 * @Version 1.0
 **/
public class PayStatus implements Serializable {

    public final static Byte TO_BE_PAID = 0;   //待支付
    public final static Byte PAID = 1;   //已支付(待发货)
    public final static Byte SHIPPED = 2;   //已发货
    public final static Byte CANCELLED = 3;   //已取消
    public final static Byte REFUNDING = 4;   //退款中
    public final static Byte REFUNDED = 5;   //已退款
    public final static Byte RETURNING = 6;   //退货中
    public final static Byte RETURNED = 7;   //已退货
    public final static Byte SUCCEEDED = 8;   //交易成功
    public final static Byte AFTER_SALE_ING = 9;   //售后中
    public final static Byte AFTER_SALE = 10;   //售后已结束
    public final static Byte PREPAID = 11;   //预付

}
