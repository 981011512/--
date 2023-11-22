package com.cf.logistics.domain.request;

import java.io.Serializable;

public class CfLogisticsQueueForm implements Serializable {
    private Long id;

    private Long useLogId;

    private Short sortIndex;

    private Long logisticsStorehouseId;

    private Long logisticsPlatformId;

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

    public Long getLogisticsPlatformId() {
        return logisticsPlatformId;
    }

    public void setLogisticsPlatformId(Long logisticsPlatformId) {
        this.logisticsPlatformId = logisticsPlatformId;
    }
}