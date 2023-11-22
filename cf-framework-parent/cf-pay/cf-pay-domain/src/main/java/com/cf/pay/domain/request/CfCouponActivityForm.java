package com.cf.pay.domain.request;

import java.io.Serializable;
import java.math.BigDecimal;

public class CfCouponActivityForm implements Serializable {
    private String id;

    private String title;

    private String subtitle;

    private Byte type;

    private Long startTime;

    private Long endTime;

    private String mainBodyId;

    private String createrId;

    private BigDecimal denomination;

    private BigDecimal thresholdPrice;

    private String goodsId;

    private Integer totalIssueQuantity;

    private Integer issuedQuantity;

    private Long unitOfTime;

    private Integer unitOfTimeTotalIssueQuantity;

    private Integer unitOfTimeTotalIssuedQuantity;

    private Integer unitOfTimeIssueGradient;

    private Long lastIssueTime;

    private Byte repeatTimes;

    private Byte status;

    private Long createTime;

    private Long updateTime;

    private BigDecimal totalIssueQuota;

    private BigDecimal issuedQuota;

    private String phone;

    private BigDecimal rechargeRatio;

    private String shopkeeperName;

    private String projectName;

    private String tradeType;

    private Byte couponType;

    private Byte autoGiveAway;

    private Byte autoCleared;

    private String autoGiveAwayDate;

    private BigDecimal autoGiveAwayQuota;

    private Long autoGiveAwayTime;

    private BigDecimal autoGiveAwayOverageQuota;

    private Integer remainingTimes;

    private Long remainingTime;

    private BigDecimal timesCouponPrice;

    private BigDecimal timeCouponPrice;

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

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle == null ? null : subtitle.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
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

    public String getMainBodyId() {
        return mainBodyId;
    }

    public void setMainBodyId(String mainBodyId) {
        this.mainBodyId = mainBodyId == null ? null : mainBodyId.trim();
    }

    public String getCreaterId() {
        return createrId;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId == null ? null : createrId.trim();
    }

    public BigDecimal getDenomination() {
        return denomination;
    }

    public void setDenomination(BigDecimal denomination) {
        this.denomination = denomination;
    }

    public BigDecimal getThresholdPrice() {
        return thresholdPrice;
    }

    public void setThresholdPrice(BigDecimal thresholdPrice) {
        this.thresholdPrice = thresholdPrice;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public Integer getTotalIssueQuantity() {
        return totalIssueQuantity;
    }

    public void setTotalIssueQuantity(Integer totalIssueQuantity) {
        this.totalIssueQuantity = totalIssueQuantity;
    }

    public Integer getIssuedQuantity() {
        return issuedQuantity;
    }

    public void setIssuedQuantity(Integer issuedQuantity) {
        this.issuedQuantity = issuedQuantity;
    }

    public Long getUnitOfTime() {
        return unitOfTime;
    }

    public void setUnitOfTime(Long unitOfTime) {
        this.unitOfTime = unitOfTime;
    }

    public Integer getUnitOfTimeTotalIssueQuantity() {
        return unitOfTimeTotalIssueQuantity;
    }

    public void setUnitOfTimeTotalIssueQuantity(Integer unitOfTimeTotalIssueQuantity) {
        this.unitOfTimeTotalIssueQuantity = unitOfTimeTotalIssueQuantity;
    }

    public Integer getUnitOfTimeTotalIssuedQuantity() {
        return unitOfTimeTotalIssuedQuantity;
    }

    public void setUnitOfTimeTotalIssuedQuantity(Integer unitOfTimeTotalIssuedQuantity) {
        this.unitOfTimeTotalIssuedQuantity = unitOfTimeTotalIssuedQuantity;
    }

    public Integer getUnitOfTimeIssueGradient() {
        return unitOfTimeIssueGradient;
    }

    public void setUnitOfTimeIssueGradient(Integer unitOfTimeIssueGradient) {
        this.unitOfTimeIssueGradient = unitOfTimeIssueGradient;
    }

    public Long getLastIssueTime() {
        return lastIssueTime;
    }

    public void setLastIssueTime(Long lastIssueTime) {
        this.lastIssueTime = lastIssueTime;
    }

    public Byte getRepeatTimes() {
        return repeatTimes;
    }

    public void setRepeatTimes(Byte repeatTimes) {
        this.repeatTimes = repeatTimes;
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

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BigDecimal getRechargeRatio() {
        return rechargeRatio;
    }

    public void setRechargeRatio(BigDecimal rechargeRatio) {
        this.rechargeRatio = rechargeRatio;
    }

    public String getShopkeeperName() {
        return shopkeeperName;
    }

    public void setShopkeeperName(String shopkeeperName) {
        this.shopkeeperName = shopkeeperName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public Byte getCouponType() {
        return couponType;
    }

    public void setCouponType(Byte couponType) {
        this.couponType = couponType;
    }

    public Byte getAutoGiveAway() {
        return autoGiveAway;
    }

    public void setAutoGiveAway(Byte autoGiveAway) {
        this.autoGiveAway = autoGiveAway;
    }

    public Byte getAutoCleared() {
        return autoCleared;
    }

    public void setAutoCleared(Byte autoCleared) {
        this.autoCleared = autoCleared;
    }

    public String getAutoGiveAwayDate() {
        return autoGiveAwayDate;
    }

    public void setAutoGiveAwayDate(String autoGiveAwayDate) {
        this.autoGiveAwayDate = autoGiveAwayDate;
    }

    public BigDecimal getTotalIssueQuota() {
        return totalIssueQuota;
    }

    public void setTotalIssueQuota(BigDecimal totalIssueQuota) {
        this.totalIssueQuota = totalIssueQuota;
    }

    public BigDecimal getIssuedQuota() {
        return issuedQuota;
    }

    public void setIssuedQuota(BigDecimal issuedQuota) {
        this.issuedQuota = issuedQuota;
    }

    public BigDecimal getAutoGiveAwayQuota() {
        return autoGiveAwayQuota;
    }

    public void setAutoGiveAwayQuota(BigDecimal autoGiveAwayQuota) {
        this.autoGiveAwayQuota = autoGiveAwayQuota;
    }

    public Long getAutoGiveAwayTime() {
        return autoGiveAwayTime;
    }

    public void setAutoGiveAwayTime(Long autoGiveAwayTime) {
        this.autoGiveAwayTime = autoGiveAwayTime;
    }

    public BigDecimal getAutoGiveAwayOverageQuota() {
        return autoGiveAwayOverageQuota;
    }

    public void setAutoGiveAwayOverageQuota(BigDecimal autoGiveAwayOverageQuota) {
        this.autoGiveAwayOverageQuota = autoGiveAwayOverageQuota;
    }

    public Integer getRemainingTimes() {
        return remainingTimes;
    }

    public void setRemainingTimes(Integer remainingTimes) {
        this.remainingTimes = remainingTimes;
    }

    public Long getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(Long remainingTime) {
        this.remainingTime = remainingTime;
    }

    public BigDecimal getTimesCouponPrice() {
        return timesCouponPrice;
    }

    public void setTimesCouponPrice(BigDecimal timesCouponPrice) {
        this.timesCouponPrice = timesCouponPrice;
    }

    public BigDecimal getTimeCouponPrice() {
        return timeCouponPrice;
    }

    public void setTimeCouponPrice(BigDecimal timeCouponPrice) {
        this.timeCouponPrice = timeCouponPrice;
    }
}