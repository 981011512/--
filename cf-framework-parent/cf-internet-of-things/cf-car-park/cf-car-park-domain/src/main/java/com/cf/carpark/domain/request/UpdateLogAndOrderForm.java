package com.cf.carpark.domain.request;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 岗亭人员现金收费时需要提交的请求体
 */
public class UpdateLogAndOrderForm implements Serializable {
    @ApiModelProperty(value = "停车记录id", required = true)
    private String carParkUseLogId;
    @ApiModelProperty(value = "订单金额", required = false)
    private String amountOfMoney;
    @ApiModelProperty(value = "操作类型", required = false)
    private String actionType;
    @ApiModelProperty(value = "车牌号", required = false)
    private String numberPlate;
    @ApiModelProperty(value = "优惠券id", required = false)
    private String couponId;

    public String getCarParkUseLogId() {
        return carParkUseLogId;
    }

    public void setCarParkUseLogId(String carParkUseLogId) {
        this.carParkUseLogId = carParkUseLogId;
    }

    public String getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(String amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }
}
