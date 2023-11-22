package com.cf.pay.domain.type;

import java.io.Serializable;

/**
 * 支付固定配置
 *
 * @ClassName GoodsType
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/07/2/002 11:06
 * @Version 1.0
 **/
public class PayConfig implements Serializable {

    public final static Long ORDER_EXPIRATION_TIME = 900000l;   //订单过期时间

}
