package com.cf.carpark.domain.request;

import java.io.Serializable;
import java.math.BigDecimal;

public class CfCarParkChargingRulesQuery implements Serializable {

    private String carParkId;

    private Long startTime;

    private Long minStartTime;

    private Long maxStartTime;

    private Long endTime;

    private Long minEndTime;

    private Long maxEndTime;

    private BigDecimal fee;

    private Long createTime;

    private Long updateTime;

    private Byte status;

    private String carType;

    private Integer page;

    private Integer size;

    private String orderBy;

    private static final long serialVersionUID = 1L;

    public String getCarParkId() {
        return carParkId;
    }

    public void setCarParkId(String carParkId) {
        this.carParkId = carParkId == null ? null : carParkId.trim();
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

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
}