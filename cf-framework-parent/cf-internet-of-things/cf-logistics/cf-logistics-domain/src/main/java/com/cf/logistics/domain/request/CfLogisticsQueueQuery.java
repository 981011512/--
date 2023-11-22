package com.cf.logistics.domain.request;

import java.io.Serializable;
import java.util.List;

public class CfLogisticsQueueQuery implements Serializable {
    private Long id;

    private Long useLogId;

    private Short sortIndex;

    private Long logisticsStorehouseId;

    private List<Long> logisticsStorehouseIds;

    private Long logisticsPlatformId;

    private List<Long> logisticsPlatformIds;

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

    public Long getUseLogId() {
        return useLogId;
    }

    public void setUseLogId(Long useLogId) {
        this.useLogId = useLogId;
    }

    public Short getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Short sortIndex) {
        this.sortIndex = sortIndex;
    }

    public Long getLogisticsStorehouseId() {
        return logisticsStorehouseId;
    }

    public void setLogisticsStorehouseId(Long logisticsStorehouseId) {
        this.logisticsStorehouseId = logisticsStorehouseId;
    }

    public List<Long> getLogisticsStorehouseIds() {
        return logisticsStorehouseIds;
    }

    public void setLogisticsStorehouseIds(List<Long> logisticsStorehouseIds) {
        this.logisticsStorehouseIds = logisticsStorehouseIds;
    }

    public Long getLogisticsPlatformId() {
        return logisticsPlatformId;
    }

    public void setLogisticsPlatformId(Long logisticsPlatformId) {
        this.logisticsPlatformId = logisticsPlatformId;
    }

    public List<Long> getLogisticsPlatformIds() {
        return logisticsPlatformIds;
    }

    public void setLogisticsPlatformIds(List<Long> logisticsPlatformIds) {
        this.logisticsPlatformIds = logisticsPlatformIds;
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