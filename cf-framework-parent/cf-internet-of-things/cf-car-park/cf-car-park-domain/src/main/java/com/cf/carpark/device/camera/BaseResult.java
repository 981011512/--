package com.cf.carpark.device.camera;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class BaseResult implements Serializable {

    /**
     * 是否放行
     */
    private Boolean pass;

    /**
     * 停车记录ID
     */
    private String carLogId;

    /**
     * 是否要收费
     */
    private boolean free;

    /**
     * 是否是特殊车辆
     */
    private boolean special;

    /**
     * 是否是白名单
     */
    private boolean inWhiteList;

    /**
     *  是否已支付
     */
    private Boolean payed;

    /**
     *  停车费用
     */
    private BigDecimal money;

    /**
     *  停车时长
     */
    private String parkingTime;

    /**
     *  剩余天数
     */
    private Integer remainDays;

    /**
     * 会员卡类型   {number:次卡,day:天卡,month:月卡,season:季卡,year:年卡}
     */
    private String typeKey;

    /**
     *  剩余车位数
     */
    private Integer spaceNum;

    /**
     *  in：入场，out：出场
     */
    private String direction;

    /**
     * 欠费订单数量
     */
    private Integer arrearsOrderNumber;

    /**
     * 欠费订单金额
     */
    private BigDecimal arrearsOrderAcount;

}
