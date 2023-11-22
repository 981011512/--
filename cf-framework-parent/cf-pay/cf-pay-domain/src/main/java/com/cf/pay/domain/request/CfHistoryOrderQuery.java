package com.cf.pay.domain.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.math.BigDecimal;

public class CfHistoryOrderQuery implements Serializable {
    private String id;

    private String shopId;

    private Long orderTime;

    private BigDecimal parkFeeAmountsPayable;

    private BigDecimal parkFeeAmountActuallyPaid;

    private BigDecimal parkPackageAmountsPayable;

    private BigDecimal parkPackageAmountActuallyPaid;

    private BigDecimal cashPay;

    private BigDecimal weixinH5Pay;

    private BigDecimal weixinMinPay;

    private BigDecimal weixinAppPay;

    private BigDecimal aliH5Pay;

    private BigDecimal aliMinPay;

    private BigDecimal aliAppPay;

    private BigDecimal parkPackagePay;

    private BigDecimal bbcPay;

    private BigDecimal rechargeAmountsPayable;

    private BigDecimal rechargeAmountActuallyPaid;

    private String orderBy;

    private Integer page;

    private Integer size;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public Long getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Long orderTime) {
        this.orderTime = orderTime;
    }

    public BigDecimal getParkFeeAmountsPayable() {
        return parkFeeAmountsPayable;
    }

    public void setParkFeeAmountsPayable(BigDecimal parkFeeAmountsPayable) {
        this.parkFeeAmountsPayable = parkFeeAmountsPayable;
    }

    public BigDecimal getParkFeeAmountActuallyPaid() {
        return parkFeeAmountActuallyPaid;
    }

    public void setParkFeeAmountActuallyPaid(BigDecimal parkFeeAmountActuallyPaid) {
        this.parkFeeAmountActuallyPaid = parkFeeAmountActuallyPaid;
    }

    public BigDecimal getParkPackageAmountsPayable() {
        return parkPackageAmountsPayable;
    }

    public void setParkPackageAmountsPayable(BigDecimal parkPackageAmountsPayable) {
        this.parkPackageAmountsPayable = parkPackageAmountsPayable;
    }

    public BigDecimal getParkPackageAmountActuallyPaid() {
        return parkPackageAmountActuallyPaid;
    }

    public void setParkPackageAmountActuallyPaid(BigDecimal parkPackageAmountActuallyPaid) {
        this.parkPackageAmountActuallyPaid = parkPackageAmountActuallyPaid;
    }

    public BigDecimal getCashPay() {
        return cashPay;
    }

    public void setCashPay(BigDecimal cashPay) {
        this.cashPay = cashPay;
    }

    public BigDecimal getWeixinH5Pay() {
        return weixinH5Pay;
    }

    public void setWeixinH5Pay(BigDecimal weixinH5Pay) {
        this.weixinH5Pay = weixinH5Pay;
    }

    public BigDecimal getWeixinMinPay() {
        return weixinMinPay;
    }

    public void setWeixinMinPay(BigDecimal weixinMinPay) {
        this.weixinMinPay = weixinMinPay;
    }

    public BigDecimal getWeixinAppPay() {
        return weixinAppPay;
    }

    public void setWeixinAppPay(BigDecimal weixinAppPay) {
        this.weixinAppPay = weixinAppPay;
    }

    public BigDecimal getAliH5Pay() {
        return aliH5Pay;
    }

    public void setAliH5Pay(BigDecimal aliH5Pay) {
        this.aliH5Pay = aliH5Pay;
    }

    public BigDecimal getAliMinPay() {
        return aliMinPay;
    }

    public void setAliMinPay(BigDecimal aliMinPay) {
        this.aliMinPay = aliMinPay;
    }

    public BigDecimal getAliAppPay() {
        return aliAppPay;
    }

    public void setAliAppPay(BigDecimal aliAppPay) {
        this.aliAppPay = aliAppPay;
    }

    public BigDecimal getParkPackagePay() {
        return parkPackagePay;
    }

    public void setParkPackagePay(BigDecimal parkPackagePay) {
        this.parkPackagePay = parkPackagePay;
    }

    public BigDecimal getBbcPay() {
        return bbcPay;
    }

    public void setBbcPay(BigDecimal bbcPay) {
        this.bbcPay = bbcPay;
    }

    public BigDecimal getRechargeAmountsPayable() {
        return rechargeAmountsPayable;
    }

    public void setRechargeAmountsPayable(BigDecimal rechargeAmountsPayable) {
        this.rechargeAmountsPayable = rechargeAmountsPayable;
    }

    public BigDecimal getRechargeAmountActuallyPaid() {
        return rechargeAmountActuallyPaid;
    }

    public void setRechargeAmountActuallyPaid(BigDecimal rechargeAmountActuallyPaid) {
        this.rechargeAmountActuallyPaid = rechargeAmountActuallyPaid;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}