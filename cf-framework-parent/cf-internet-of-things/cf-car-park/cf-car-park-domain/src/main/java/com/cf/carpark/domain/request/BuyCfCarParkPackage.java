package com.cf.carpark.domain.request;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class BuyCfCarParkPackage implements Serializable {

    @ApiModelProperty(value = "套餐产品id", required = true)
    private String cfCarParkPackagePriceId;
    @ApiModelProperty(value = "支付账号id", required = true)
    private String payTypeId;
    @ApiModelProperty(value = "车牌号", required = true)
    private String numberPlate;

    public String getCfCarParkPackagePriceId() {
        return cfCarParkPackagePriceId;
    }

    public void setCfCarParkPackagePriceId(String cfCarParkPackagePriceId) {
        this.cfCarParkPackagePriceId = cfCarParkPackagePriceId;
    }

    public String getPayTypeId() {
        return payTypeId;
    }

    public void setPayTypeId(String payTypeId) {
        this.payTypeId = payTypeId;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }
}
