package com.cf.pay.domain.request;

import java.io.Serializable;
import java.math.BigDecimal;

public class CfDailyIncomeStatisticsQuery implements Serializable {
    private String id;

    private String title;

    private String shopId;

    private Byte goodsType;

    private Short year;

    private Short minYear;

    private Short maxYear;

    private Byte month;

    private Byte minMonth;

    private Byte maxMonth;

    private Byte date;

    private Byte minDate;

    private Byte maxDate;

    private Long startTime;

    private Long minStartTime;

    private Long maxStartTime;

    private Long endTime;

    private Long minEndTime;

    private Long maxEndTime;

    private String paymentAgencyShortName;

    private BigDecimal amountsPayable;

    private BigDecimal amountActuallyPaid;

    private BigDecimal refundAmount;

    private Integer payCounts;

    private Long countsTime;

    private Integer page;

    private Integer size;

    private String orderBy;

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

    public Short getMinYear() {
        return minYear;
    }

    public void setMinYear(Short minYear) {
        this.minYear = minYear;
    }

    public Short getMaxYear() {
        return maxYear;
    }

    public void setMaxYear(Short maxYear) {
        this.maxYear = maxYear;
    }

    public Byte getMonth() {
        return month;
    }

    public void setMonth(Byte month) {
        this.month = month;
    }

    public Byte getMinMonth() {
        return minMonth;
    }

    public void setMinMonth(Byte minMonth) {
        this.minMonth = minMonth;
    }

    public Byte getMaxMonth() {
        return maxMonth;
    }

    public void setMaxMonth(Byte maxMonth) {
        this.maxMonth = maxMonth;
    }

    public Byte getDate() {
        return date;
    }

    public void setDate(Byte date) {
        this.date = date;
    }

    public Byte getMinDate() {
        return minDate;
    }

    public void setMinDate(Byte minDate) {
        this.minDate = minDate;
    }

    public Byte getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(Byte maxDate) {
        this.maxDate = maxDate;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getMinStartTime() {
        return minStartTime;
    }

    public void setMinStartTime(Long minStartTime) {
        this.minStartTime = minStartTime;
    }

    public Long getMaxStartTime() {
        return maxStartTime;
    }

    public void setMaxStartTime(Long maxStartTime) {
        this.maxStartTime = maxStartTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Long getMinEndTime() {
        return minEndTime;
    }

    public void setMinEndTime(Long minEndTime) {
        this.minEndTime = minEndTime;
    }

    public Long getMaxEndTime() {
        return maxEndTime;
    }

    public void setMaxEndTime(Long maxEndTime) {
        this.maxEndTime = maxEndTime;
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

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}