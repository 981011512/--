package com.cf.pay.domain.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class CfOrderQuery implements Serializable {

    @ApiModelProperty(value = "随机id", required = false)
    private String randomId;

    @ApiModelProperty(value = "用户id(不需要传)", required = false)
    private String uid;

    @ApiModelProperty(value = "商品名称", required = false)
    private String goodsName;

    @ApiModelProperty(value = "商品id", required = false)
    private String goodsId;

    @ApiModelProperty(value = "商品id串", required = false)
    private List<String> goodsIds;

    @ApiModelProperty(value = "商品类型(1-停车/2-充值或提现/3-商城/4-转账或收款)", required = false)
    private Byte goodsType;

    @ApiModelProperty(value = "店铺id", required = false)
    private String shopId;

    @ApiModelProperty(value = "店铺id串(英文逗号隔开)", required = false)
    private List<String> shopIds;

    @ApiModelProperty(value = "应付金额", example = "56.58", required = false, notes = "保留12位小数")
    @Digits(integer = 8,fraction = 2, message = "最多保留12位小数")
    @Min(value = 0, message = "最小值为0")
    @Max(value = 10000000, message = "最小值为10000000")
    private BigDecimal amountsPayable;

    @ApiModelProperty(value = "实付金额", example = "56.58", required = false, notes = "保留12位小数")
    @Digits(integer = 8,fraction = 2, message = "最多保留12位小数")
    @Min(value = 0, message = "最小值为0")
    @Max(value = 10000000, message = "最小值为10000000")
    private BigDecimal amountActuallyPaid;

    private BigDecimal minAmountActuallyPaid;

    private BigDecimal maxAmountActuallyPaid;

    @ApiModelProperty(value = "退款金额", example = "56.58", required = false, notes = "保留12位小数")
    @Digits(integer = 8,fraction = 2, message = "最多保留12位小数")
    @Min(value = 0, message = "最小值为0")
    @Max(value = 10000000, message = "最小值为10000000")
    private BigDecimal refundAmount;

    @ApiModelProperty(value = "优惠券id", required = false)
    private String couponId;

    @ApiModelProperty(value = "订单状态(0-待支付/1-已支付/2-已发货/3-已取消/4-一退款中/5-已退款/6-退货中/7-已退货/8-交易成功/9-售后中/10-售后已结束)", required = false)
    private Byte status;

    @ApiModelProperty(value = "创建时间", required = false)
    private Long createTime;

    @ApiModelProperty(value = "创建时间(开始)", required = false)
    private Long minCreateTime;

    @ApiModelProperty(value = "创建时间(结束)", required = false)
    private Long maxCreateTime;

    @ApiModelProperty(value = "更新时间", required = false)
    private Long updateTime;

    @ApiModelProperty(value = "更新时间(开始)", required = false)
    private Long minUpdateTime;

    @ApiModelProperty(value = "更新时间(结束)", required = false)
    private Long maxUpdateTime;

    @ApiModelProperty(value = "年(年报)", required = false)
    private Long yearReportTime;

    @ApiModelProperty(value = "年月(月报)", required = false)
    private Long monthReportTime;

    @ApiModelProperty(value = "年月日(日报)", required = false)
    private Long dayReportTime;

    @ApiModelProperty(value = "支付时间=", required = false)
    private Long payTime;

    @ApiModelProperty(value = "支付时间>=", required = false)
    private Long minPayTime;

    @ApiModelProperty(value = "支付时间<=", required = false)
    private Long maxPayTime;

    @ApiModelProperty(value = "退款时间", required = false)
    private Long refundTime;

    @ApiModelProperty(value = "取消时间", required = false)
    private Long cancelTime;

    @ApiModelProperty(value = "支付方式", required = false)
    private String paymentAgencyShortName;

    @ApiModelProperty(value = "第三方支付订单id", required = false)
    private String thirdPartyOrderId;

    @ApiModelProperty(value = "作用对象(例如给某个手机号充值)", required = false)
    private String effectObject;

    private String orderBy;

    private Integer page;

    private Integer size;

    private String scoreKeyFlag;

    private BigDecimal manualOffer;

    private Long manualOfferSetTime;

    private String groupBy;

    private String countField;  //统计字段

    private String handleUid;

    private String collectionShopId;

    private String collectionOrderId;
    @ApiModelProperty(value = "报表模式(total-各项收入总统计/channel-每个渠道收入统计)", required = false)
    private String reportMode;

    private static final long serialVersionUID = 1L;

    public String getRandomId() {
        return randomId;
    }

    public void setRandomId(String randomId) {
        this.randomId = randomId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public List<String> getGoodsIds() {
        return goodsIds;
    }

    public void setGoodsIds(List<String> goodsIds) {
        this.goodsIds = goodsIds;
    }

    public Byte getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Byte goodsType) {
        this.goodsType = goodsType;
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

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId == null ? null : couponId.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getYearReportTime() {
        return yearReportTime;
    }

    public void setYearReportTime(Long yearReportTime) {
        this.yearReportTime = yearReportTime;
    }

    public Long getMonthReportTime() {
        return monthReportTime;
    }

    public void setMonthReportTime(Long monthReportTime) {
        this.monthReportTime = monthReportTime;
    }

    public Long getDayReportTime() {
        return dayReportTime;
    }

    public void setDayReportTime(Long dayReportTime) {
        this.dayReportTime = dayReportTime;
    }

    public Long getPayTime() {
        return payTime;
    }

    public void setPayTime(Long payTime) {
        this.payTime = payTime;
    }

    public Long getMinPayTime() {
        return minPayTime;
    }

    public void setMinPayTime(Long minPayTime) {
        this.minPayTime = minPayTime;
    }

    public Long getMaxPayTime() {
        return maxPayTime;
    }

    public void setMaxPayTime(Long maxPayTime) {
        this.maxPayTime = maxPayTime;
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
        this.paymentAgencyShortName = paymentAgencyShortName == null ? null : paymentAgencyShortName.trim();
    }

    public String getThirdPartyOrderId() {
        return thirdPartyOrderId;
    }

    public void setThirdPartyOrderId(String thirdPartyOrderId) {
        this.thirdPartyOrderId = thirdPartyOrderId == null ? null : thirdPartyOrderId.trim();
    }

    public Long getMinCreateTime() {
        return minCreateTime;
    }

    public void setMinCreateTime(Long minCreateTime) {
        this.minCreateTime = minCreateTime;
    }

    public Long getMaxCreateTime() {
        return maxCreateTime;
    }

    public void setMaxCreateTime(Long maxCreateTime) {
        this.maxCreateTime = maxCreateTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Long getMinUpdateTime() {
        return minUpdateTime;
    }

    public void setMinUpdateTime(Long minUpdateTime) {
        this.minUpdateTime = minUpdateTime;
    }

    public Long getMaxUpdateTime() {
        return maxUpdateTime;
    }

    public void setMaxUpdateTime(Long maxUpdateTime) {
        this.maxUpdateTime = maxUpdateTime;
    }

    public String getEffectObject() {
        return effectObject;
    }

    public void setEffectObject(String effectObject) {
        this.effectObject = effectObject;
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

    public String getScoreKeyFlag() {
        return scoreKeyFlag;
    }

    public void setScoreKeyFlag(String scoreKeyFlag) {
        this.scoreKeyFlag = scoreKeyFlag;
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

    public BigDecimal getManualOffer() {
        return manualOffer;
    }

    public void setManualOffer(BigDecimal manualOffer) {
        this.manualOffer = manualOffer;
    }

    public Long getManualOfferSetTime() {
        return manualOfferSetTime;
    }

    public void setManualOfferSetTime(Long manualOfferSetTime) {
        this.manualOfferSetTime = manualOfferSetTime;
    }

    public String getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }

    public BigDecimal getMinAmountActuallyPaid() {
        return minAmountActuallyPaid;
    }

    public void setMinAmountActuallyPaid(BigDecimal minAmountActuallyPaid) {
        this.minAmountActuallyPaid = minAmountActuallyPaid;
    }

    public BigDecimal getMaxAmountActuallyPaid() {
        return maxAmountActuallyPaid;
    }

    public void setMaxAmountActuallyPaid(BigDecimal maxAmountActuallyPaid) {
        this.maxAmountActuallyPaid = maxAmountActuallyPaid;
    }

    public String getCountField() {
        return countField;
    }

    public void setCountField(String countField) {
        this.countField = countField;
    }

    public String getHandleUid() {
        return handleUid;
    }

    public void setHandleUid(String handleUid) {
        this.handleUid = handleUid;
    }

    public String getCollectionShopId() {
        return collectionShopId;
    }

    public void setCollectionShopId(String collectionShopId) {
        this.collectionShopId = collectionShopId;
    }

    public String getCollectionOrderId() {
        return collectionOrderId;
    }

    public void setCollectionOrderId(String collectionOrderId) {
        this.collectionOrderId = collectionOrderId;
    }

    public String getReportMode() {
        return reportMode;
    }

    public void setReportMode(String reportMode) {
        this.reportMode = reportMode;
    }
}