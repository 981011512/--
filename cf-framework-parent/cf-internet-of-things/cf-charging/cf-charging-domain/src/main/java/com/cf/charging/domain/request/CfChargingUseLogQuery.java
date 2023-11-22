package com.cf.charging.domain.request;

import java.io.Serializable;
import java.math.BigDecimal;

public class CfChargingUseLogQuery implements Serializable {
    private String id;

    private String chargingStationId;

    private String chargingDeviceId;

    private String chargingPort;

    private Long startTime;

    private Long minStartTime;

    private Long maxStartTime;

    private Long endTime;

    private Long minEndTime;

    private Long maxEndTime;

    private String uid;

    private BigDecimal chargingFee;

    private BigDecimal serviceFee;

    private Byte chargingStatus;

    private Byte chargingType;

    private Integer page;

    private Integer size;

    private String orderBy;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getChargingStationId() {
        return chargingStationId;
    }

    public void setChargingStationId(String chargingStationId) {
        this.chargingStationId = chargingStationId == null ? null : chargingStationId.trim();
    }

    public String getChargingDeviceId() {
        return chargingDeviceId;
    }

    public void setChargingDeviceId(String chargingDeviceId) {
        this.chargingDeviceId = chargingDeviceId == null ? null : chargingDeviceId.trim();
    }

    public String getChargingPort() {
        return chargingPort;
    }

    public void setChargingPort(String chargingPort) {
        this.chargingPort = chargingPort;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
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

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public BigDecimal getChargingFee() {
        return chargingFee;
    }

    public void setChargingFee(BigDecimal chargingFee) {
        this.chargingFee = chargingFee;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Byte getChargingStatus() {
        return chargingStatus;
    }

    public void setChargingStatus(Byte chargingStatus) {
        this.chargingStatus = chargingStatus;
    }

    public Byte getChargingType() {
        return chargingType;
    }

    public void setChargingType(Byte chargingType) {
        this.chargingType = chargingType;
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
}