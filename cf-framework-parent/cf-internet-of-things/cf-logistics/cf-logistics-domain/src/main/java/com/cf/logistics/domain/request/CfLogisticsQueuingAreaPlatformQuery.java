package com.cf.logistics.domain.request;

import java.io.Serializable;
import java.util.List;

public class CfLogisticsQueuingAreaPlatformQuery implements Serializable {
    private Long id;

    private Long queuingAreaId;

    private Long logisticsStorehouseId;

    private Long logisticsStorehousePlatformId;

    private List<Long> logisticsStorehousePlatformIds;

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

    public Long getQueuingAreaId() {
        return queuingAreaId;
    }

    public void setQueuingAreaId(Long queuingAreaId) {
        this.queuingAreaId = queuingAreaId;
    }

    public Long getLogisticsStorehouseId() {
        return logisticsStorehouseId;
    }

    public void setLogisticsStorehouseId(Long logisticsStorehouseId) {
        this.logisticsStorehouseId = logisticsStorehouseId;
    }

    public Long getLogisticsStorehousePlatformId() {
        return logisticsStorehousePlatformId;
    }

    public void setLogisticsStorehousePlatformId(Long logisticsStorehousePlatformId) {
        this.logisticsStorehousePlatformId = logisticsStorehousePlatformId;
    }

    public List<Long> getLogisticsStorehousePlatformIds() {
        return logisticsStorehousePlatformIds;
    }

    public void setLogisticsStorehousePlatformIds(List<Long> logisticsStorehousePlatformIds) {
        this.logisticsStorehousePlatformIds = logisticsStorehousePlatformIds;
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