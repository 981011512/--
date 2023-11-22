package com.cf.ucenter.request;

import com.cf.framework.utils.DateUtil;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class CfStaffQuery implements Serializable {

    @ApiModelProperty(value = "员工记录id", required = false)
    private String id;
    @ApiModelProperty(value = "雇主id", required = false)
    private String employerId;
    @ApiModelProperty(value = "员工id", required = false)
    private String staffId;
    @ApiModelProperty(value = "创建时间>=", required = false)
    private Long minCreateTime;
    @ApiModelProperty(value = "创建时间<=", required = false)
    private Long maxCreateTime;
    @ApiModelProperty(value = "页码", required = true)
    private Integer page;
    @ApiModelProperty(value = "每页请求数", required = true)
    private Integer size;
    @ApiModelProperty(value = "排序字段", required = false)
    private String orderBy;
    @ApiModelProperty(value = "统计发券量开始时间(默认当天凌晨开始)", required = false)
    private Long countStartTime;
    @ApiModelProperty(value = "统计发券量结束时间(默认当天晚上24点)", required = false)
    private Long countEndTime;

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

    public Long getCountStartTime() {
        return countStartTime;
    }

    public void setCountStartTime(Long countStartTime) {
        this.countStartTime = countStartTime;
    }

    public Long getCountEndTime() {
        return countEndTime;
    }

    public void setCountEndTime(Long countEndTime) {
        this.countEndTime = countEndTime;
    }
}