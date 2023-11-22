package com.cf.ucenter.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class CfStaff implements Serializable{

    private String id;

    private String employerId;

    private String staffId;

    private String note;

    private Long createTime;

    private String staffName;

    private String staffAvatar;

    private BigDecimal sameDayCouponCount;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getEmployerId() {
        return employerId;
    }

    public void setEmployerId(String employerId) {
        this.employerId = employerId == null ? null : employerId.trim();
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId == null ? null : staffId.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffAvatar() {
        return staffAvatar;
    }

    public void setStaffAvatar(String staffAvatar) {
        this.staffAvatar = staffAvatar;
    }

    public BigDecimal getSameDayCouponCount() {
        return sameDayCouponCount;
    }

    public void setSameDayCouponCount(BigDecimal sameDayCouponCount) {
        this.sameDayCouponCount = sameDayCouponCount;
    }
}