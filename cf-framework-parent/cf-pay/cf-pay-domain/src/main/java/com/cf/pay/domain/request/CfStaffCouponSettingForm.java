package com.cf.pay.domain.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.math.BigDecimal;

public class CfStaffCouponSettingForm implements Serializable {
    @ApiModelProperty(value = "数据id", required = false)
    private String id;
    @ApiModelProperty(value = "当日员工发券额度", required = false)
    @Min(message = "当日发券额度最小值为1", value = 1)
    private BigDecimal sameDayQuota;
    @ApiModelProperty(value = "员工id", required = false)
    private String staffId;
    @ApiModelProperty(value = "优惠券活动id", required = false)
    private String couponActivityId;

    private Byte couponType;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public BigDecimal getSameDayQuota() {
        return sameDayQuota;
    }

    public void setSameDayQuota(BigDecimal sameDayQuota) {
        this.sameDayQuota = sameDayQuota;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId == null ? null : staffId.trim();
    }

    public String getCouponActivityId() {
        return couponActivityId;
    }

    public void setCouponActivityId(String couponActivityId) {
        this.couponActivityId = couponActivityId == null ? null : couponActivityId.trim();
    }

    public Byte getCouponType() {
        return couponType;
    }

    public void setCouponType(Byte couponType) {
        this.couponType = couponType;
    }
}