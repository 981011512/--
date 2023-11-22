package com.cf.pay.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class CfDailyIncomeStatistics implements Serializable {
    private String id;

    private String title;

    private String shopId;

    private Byte goodsType;

    private Short year;

    private Byte month;

    private Byte date;

    private Long startTime;

    private Long endTime;

    private String paymentAgencyShortName;

    private BigDecimal amountsPayable;

    private BigDecimal amountActuallyPaid;

    private BigDecimal refundAmount;

    private Integer payCounts;

    private Long countsTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public Byte getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Byte goodsType) {
        this.goodsType = goodsType;
    }

    public Short getYear() {
        return year;
    }

    public void setYear(Short year) {
        this.year = year;
    }

    public Byte getMonth() {
        return month;
    }

    public void setMonth(Byte month) {
        this.month = month;
    }

    public Byte getDate() {
        return date;
    }

    public void setDate(Byte date) {
        this.date = date;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getPaymentAgencyShortName() {
        return paymentAgencyShortName;
    }

    public void setPaymentAgencyShortName(String paymentAgencyShortName) {
        this.paymentAgencyShortName = paymentAgencyShortName == null ? null : paymentAgencyShortName.trim();
    }

    public BigDecimal getAmountsPayable() {
        return amountsPayable;
    }

    public void setAmountsPayable(BigDecimal amountsPayable) {
        this.amountsPayable = amountsPayable;
    }

    public BigDecimal getAmountActuallyPaid() {
        return amountActuallyPaid;
    }

    public void setAmountActuallyPaid(BigDecimal amountActuallyPaid) {
        this.amountActuallyPaid = amountActuallyPaid;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public Integer getPayCounts() {
        return payCounts;
    }

    public void setPayCounts(Integer payCounts) {
        this.payCounts = payCounts;
    }

    public Long getCountsTime() {
        return countsTime;
    }

    public void setCountsTime(Long countsTime) {
        this.countsTime = countsTime;
    }
}