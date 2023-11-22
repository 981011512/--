package com.cf.pay.domain.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.math.BigDecimal;

public class CfStaffCouponLogQuery implements Serializable {
    @ApiModelProperty(value = "数据id", required = false)
    private String id;
    @ApiModelProperty(value = "优惠券id", required = false)
    private String couponId;
    @ApiModelProperty(value = "优惠券活动id", required = false)
    private String couponActivityId;
    @ApiModelProperty(value = "员工id", required = false)
    private String staffId;
    @ApiModelProperty(value = "受赠人id", required = false)
    private String toUid;
    @ApiModelProperty(value = "优惠券面额", required = false)
    private BigDecimal denomination;
    @ApiModelProperty(value = "创建时间>=(默认值当天凌晨0点)", required = false)
    private Long minCreateTime;
    @ApiModelProperty(value = "创建时间<=(默认值当天晚上24点)", required = false)
    private Long maxCreateTime;
    @ApiModelProperty(value = "页码", required = false)
    @Min(message = "页码>=1", value = 1)
    @Max(message = "页码<=1000", value = 1000)
    private Integer page;
    @ApiModelProperty(value = "每页请求数", required = false)
    @Min(message = "每页请求数>=3", value = 3)
    @Max(message = "每页请求数<=30", value = 30)
    private Integer size;
    @ApiModelProperty(value = "排序", required = false)
    private String orderBy;

    @ApiModelProperty(value = "受赠体(商品id/车牌号等)", required = false)
    private String recipientBody;
    @ApiModelProperty(value = "优惠券类型(1-次数券/2-金额券/3-时长券)", required = false)
    private Byte couponType;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId == null ? null : couponId.trim();
    }

    public String getCouponActivityId() {
        return couponActivityId;
    }

    public void setCouponActivityId(String couponActivityId) {
        this.couponActivityId = couponActivityId == null ? null : couponActivityId.trim();
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId == null ? null : staffId.trim();
    }

    public String getToUid() {
        return toUid;
    }

    public void setToUid(String toUid) {
        this.toUid = toUid == null ? null : toUid.trim();
    }

    public BigDecimal getDenomination() {
        return denomination;
    }

    public void setDenomination(BigDecimal denomination) {
        this.denomination = denomination;
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

    public String getRecipientBody() {
        return recipientBody;
    }

    public void setRecipientBody(String recipientBody) {
        this.recipientBody = recipientBody;
    }

    public Byte getCouponType() {
        return couponType;
    }

    public void setCouponType(Byte couponType) {
        this.couponType = couponType;
    }
}