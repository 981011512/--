package com.cf.pay.domain.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class CfCouponActivityQuery implements Serializable {
    @ApiModelProperty(value = "数据id", required = false)
    private String id;

    @ApiModelProperty(value = "数据id列表", required = false)
    private List<String> ids;

    private String title;

    private String subtitle;
    @ApiModelProperty(value = "活动类型:0-通用/1-停车场/2-传统商城", required = false)
    private Byte type;

    private Long startTime;
    @ApiModelProperty(value = "开始时间>=", required = false)
    private Long minStartTime;
    @ApiModelProperty(value = "开始时间<=", required = false)
    private Long maxStartTime;

    private Long endTime;
    @ApiModelProperty(value = "结束时间>=", required = false)
    private Long minEndTime;
    @ApiModelProperty(value = "结束时间<=", required = false)
    private Long maxEndTime;
    @ApiModelProperty(value = "店主id(主办方/发起者id)", required = false)
    private String mainBodyId;
    @ApiModelProperty(value = "店主id串(主办方/发起者id)", required = false)
    private List<String> mainBodyIds;
    @ApiModelProperty(value = "创建者id", required = false)
    private String createrId;
    @ApiModelProperty(value = "活动优惠券面额", required = false)
    private BigDecimal denomination;
    @ApiModelProperty(value = "活动优惠券面额>=", required = false)
    private BigDecimal minDenomination;
    @ApiModelProperty(value = "活动优惠券面额<=", required = false)
    private BigDecimal maxDenomination;
    @ApiModelProperty(value = "门槛价格", required = false)
    private BigDecimal thresholdPrice;
    @ApiModelProperty(value = "门槛价格>=", required = false)
    private BigDecimal minThresholdPrice;
    @ApiModelProperty(value = "门槛价格<=", required = false)
    private BigDecimal maxThresholdPrice;
    @ApiModelProperty(value = "商品id", required = false)
    private String goodsId;
    @ApiModelProperty(value = "总发行量", required = false)
    private Integer totalIssueQuantity;
    @ApiModelProperty(value = "总发行量>=", required = false)
    private Integer minTotalIssueQuantity;
    @ApiModelProperty(value = "总发行量<=", required = false)
    private Integer maxTotalIssueQuantity;
    @ApiModelProperty(value = "已发行量", required = false)
    private Integer issuedQuantity;

    private Long unitOfTime;

    private Integer unitOfTimeTotalIssueQuantity;

    private Integer unitOfTimeTotalIssuedQuantity;

    private Integer unitOfTimeIssueGradient;

    private Long lastIssueTime;

    private Byte repeatTimes;
    @ApiModelProperty(value = "状态状态(0-暂停/1-正常)", required = false)
    private Byte status;

    private Long createTime;

    private Long updateTime;

    private String phone;

    private BigDecimal rechargeRatio;

    private String orderBy;

    @ApiModelProperty(value = "页码", required = true)
    @Min(value = 1, message = "页码最小值1")
    @Max(value = 200, message = "页码最大值200")
    private Integer page;
    @ApiModelProperty(value = "每页条数", required = true)
    @Min(value = 1, message = "每页条数最小值1")
    @Max(value = 30, message = "每页条数最大值30")
    private Integer size;

    private String shopkeeperName;

    private String projectName;

    private String tradeType;

    private Byte couponType;

    private Byte autoGiveAway;

    private Byte autoCleared;

    private String autoGiveAwayDate;

    private Long minAutoGiveAwayTime;

    private Long maxAutoGiveAwayTime;

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

    public BigDecimal getMinDenomination() {
        return minDenomination;
    }

    public void setMinDenomination(BigDecimal minDenomination) {
        this.minDenomination = minDenomination;
    }

    public BigDecimal getMaxDenomination() {
        return maxDenomination;
    }

    public void setMaxDenomination(BigDecimal maxDenomination) {
        this.maxDenomination = maxDenomination;
    }

    public BigDecimal getMinThresholdPrice() {
        return minThresholdPrice;
    }

    public void setMinThresholdPrice(BigDecimal minThresholdPrice) {
        this.minThresholdPrice = minThresholdPrice;
    }

    public BigDecimal getMaxThresholdPrice() {
        return maxThresholdPrice;
    }

    public void setMaxThresholdPrice(BigDecimal maxThresholdPrice) {
        this.maxThresholdPrice = maxThresholdPrice;
    }

    public Integer getMinTotalIssueQuantity() {
        return minTotalIssueQuantity;
    }

    public void setMinTotalIssueQuantity(Integer minTotalIssueQuantity) {
        this.minTotalIssueQuantity = minTotalIssueQuantity;
    }

    public Integer getMaxTotalIssueQuantity() {
        return maxTotalIssueQuantity;
    }

    public void setMaxTotalIssueQuantity(Integer maxTotalIssueQuantity) {
        this.maxTotalIssueQuantity = maxTotalIssueQuantity;
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

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public List<String> getMainBodyIds() {
        return mainBodyIds;
    }

    public void setMainBodyIds(List<String> mainBodyIds) {
        this.mainBodyIds = mainBodyIds;
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

    public Long getMinAutoGiveAwayTime() {
        return minAutoGiveAwayTime;
    }

    public void setMinAutoGiveAwayTime(Long minAutoGiveAwayTime) {
        this.minAutoGiveAwayTime = minAutoGiveAwayTime;
    }

    public Long getMaxAutoGiveAwayTime() {
        return maxAutoGiveAwayTime;
    }

    public void setMaxAutoGiveAwayTime(Long maxAutoGiveAwayTime) {
        this.maxAutoGiveAwayTime = maxAutoGiveAwayTime;
    }
}