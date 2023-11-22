package com.cf.ucenter.request;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class CfStaffForm implements Serializable {
    @ApiModelProperty(value = "员工记录id", required = false)
    private String id;
    @ApiModelProperty(value = "雇主id", required = false)
    private String employerId;
    @ApiModelProperty(value = "员工id", required = false)
    private String staffId;
    @ApiModelProperty(value = "备注", required = false)
    private String note;
    @ApiModelProperty(value = "创建时间", required = false)
    private Long createTime;

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
}