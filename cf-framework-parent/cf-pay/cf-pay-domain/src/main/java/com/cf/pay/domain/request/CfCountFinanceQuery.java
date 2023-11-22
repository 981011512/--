package com.cf.pay.domain.request;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CfCountFinanceQuery implements Serializable {
    @ApiModelProperty(value = "字符串日期", required = false)
    private String date;
    @ApiModelProperty(value = "字符串结束日期", required = false)
    private String endDate;
    @ApiModelProperty(value = "年份", required = false)
    private Integer year;
    @ApiModelProperty(value = "月份", required = false)
    private Integer month;
    @ApiModelProperty(value = "前N天", required = false)
    private Integer day;
    @ApiModelProperty(value = "商品类型(1-停车/2-充值或提现/3-商城/4-转账或收款/5-停车套餐/6-车位预订/7-优惠券活动充值)", required = false)
    private Byte goodsType;
    @ApiModelProperty(value = "订单状态(0-待支付/1-已支付/2-已发货/3-已取消/4-一退款中/5-已退款/6-退货中/7-已退货/8-交易成功/9-售后中/10-售后已结束)", required = false)
    private Byte status;
    @ApiModelProperty(value = "支付时间", required = false)
    private Long payTime;

    @ApiModelProperty(value = "退款时间", required = false)
    private Long refundTime;

    @ApiModelProperty(value = "取消时间", required = false)
    private Long cancelTime;

    @ApiModelProperty(value = "支付方式", required = false)
    private String paymentAgencyShortName;

    @ApiModelProperty(value = "支付方式", required = false)
    private ArrayList<String> paymentAgencyShortNames;

    @ApiModelProperty(value = "店铺id", required = false)
    private String shopId;

    private List<String> shopIds;

    @ApiModelProperty(value = "统计方式(before_day_count_by_day-前N天每天统计数,month_count_by_day-某年月每天统计数,year_count_by_month-某年每月的统计数)", required = false)
    private String countType;
    @ApiModelProperty(value = "统计字段", required = true)
    private String countField;
    @ApiModelProperty(value = "是否统计所有总数", required = false)
    private Boolean countAll;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getCountType() {
        return countType;
    }

    public void setCountType(String countType) {
        this.countType = countType;
    }

    public Byte getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Byte goodsType) {
        this.goodsType = goodsType;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getPayTime() {
        return payTime;
    }

    public void setPayTime(Long payTime) {
        this.payTime = payTime;
    }

    public Long getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Long refundTime) {
        this.refundTime = refundTime;
    }

    public Long getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Long cancelTime) {
        this.cancelTime = cancelTime;
    }

    public String getPaymentAgencyShortName() {
        return paymentAgencyShortName;
    }

    public void setPaymentAgencyShortName(String paymentAgencyShortName) {
        this.paymentAgencyShortName = paymentAgencyShortName;
    }

    public String getCountField() {
        return countField;
    }

    public void setCountField(String countField) {
        this.countField = countField;
    }

    public Boolean getCountAll() {
        return countAll;
    }

    public void setCountAll(Boolean countAll) {
        this.countAll = countAll;
    }

    public ArrayList<String> getPaymentAgencyShortNames() {
        return paymentAgencyShortNames;
    }

    public void setPaymentAgencyShortNames(ArrayList<String> paymentAgencyShortNames) {
        this.paymentAgencyShortNames = paymentAgencyShortNames;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public List<String> getShopIds() {
        return shopIds;
    }

    public void setShopIds(List<String> shopIds) {
        this.shopIds = shopIds;
    }
}