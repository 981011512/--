package com.cf.logistics.domain.request;

import java.io.Serializable;
import java.math.BigDecimal;

public class CfLogisticsStorehousePlatformForm implements Serializable {
    private Long id;

    private String platformName;

    private Long storehouseId;

    private BigDecimal positionX;

    private BigDecimal positionY;

    private Integer queueCapacity;

    private Integer usedQueueCapacity;

    private Byte platformStatus;

    private Short sortIndex;

    private String handleUid;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName == null ? null : platformName.trim();
    }

    public Long getStorehouseId() {
        return storehouseId;
    }

    public void setStorehouseId(Long storehouseId) {
        this.storehouseId = storehouseId;
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

    public Byte getPlatformStatus() {
        return platformStatus;
    }

    public void setPlatformStatus(Byte platformStatus) {
        this.platformStatus = platformStatus;
    }

    public Short getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Short sortIndex) {
        this.sortIndex = sortIndex;
    }

    public String getHandleUid() {
        return handleUid;
    }

    public void setHandleUid(String handleUid) {
        this.handleUid = handleUid == null ? null : handleUid.trim();
    }
}