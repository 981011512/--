package com.cf.logistics.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;

public class CfLogisticsQueuingArea implements Serializable {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private String areaName;

    private Integer queueCapacity;

    private Integer usedQueueCapacity;

    private BigDecimal positionX;

    private BigDecimal positionY;

    private Byte areaStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long factoryId;

    private Integer sortIndex;

    private String groupFlag;

    private CfLogisticsFactory cfLogisticsFactory;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public Integer getQueueCapacity() {
        return queueCapacity;
    }

    public void setQueueCapacity(Integer queueCapacity) {
        this.queueCapacity = queueCapacity;
    }

    public Integer getUsedQueueCapacity() {
        return usedQueueCapacity;
    }

    public void setUsedQueueCapacity(Integer usedQueueCapacity) {
        this.usedQueueCapacity = usedQueueCapacity;
    }

    public BigDecimal getPositionX() {
        return positionX;
    }

    public void setPositionX(BigDecimal positionX) {
        this.positionX = positionX;
    }

    public BigDecimal getPositionY() {
        return positionY;
    }

    public void setPositionY(BigDecimal positionY) {
        this.positionY = positionY;
    }

    public Byte getAreaStatus() {
        return areaStatus;
    }

    public void setAreaStatus(Byte areaStatus) {
        this.areaStatus = areaStatus;
    }

    public Long getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Long factoryId) {
        this.factoryId = factoryId;
    }

    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }

    public String getGroupFlag() {
        return groupFlag;
    }

    public void setGroupFlag(String groupFlag) {
        this.groupFlag = groupFlag;
    }

    public CfLogisticsFactory getCfLogisticsFactory() {
        return cfLogisticsFactory;
    }

    public void setCfLogisticsFactory(CfLogisticsFactory cfLogisticsFactory) {
        this.cfLogisticsFactory = cfLogisticsFactory;
    }
}