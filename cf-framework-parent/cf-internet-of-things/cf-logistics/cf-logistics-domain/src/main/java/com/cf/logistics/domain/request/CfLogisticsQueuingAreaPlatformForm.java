package com.cf.logistics.domain.request;

import java.io.Serializable;

public class CfLogisticsQueuingAreaPlatformForm implements Serializable {
    private Long id;

    private Long queuingAreaId;

    private Long logisticsStorehouseId;

    private Long logisticsStorehousePlatformId;

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
}