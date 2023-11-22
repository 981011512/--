package com.cf.logistics.domain.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class CfLogisticsStorehousePlatformQuery implements Serializable {
    private Long id;

    private List<Long> ids;

    private String platformName;

    private Long storehouseId;

    private BigDecimal positionX;

    private BigDecimal positionY;

    private Integer queueCapacity;

    private Integer usedQueueCapacity;

    private Byte platformStatus;

    private Short sortIndex;

    private String handleUid;

    private Integer page;

    private Integer size;

    private String orderBy;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
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