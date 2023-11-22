package com.cf.logistics.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

public class CfLogisticsQueuingAreaPlatform implements Serializable {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long queuingAreaId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long logisticsStorehouseId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long logisticsStorehousePlatformId;

    private CfLogisticsStorehouse cfLogisticsStorehouse;

    private CfLogisticsStorehousePlatform cfLogisticsStorehousePlatform;

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

    public CfLogisticsStorehouse getCfLogisticsStorehouse() {
        return cfLogisticsStorehouse;
    }

    public void setCfLogisticsStorehouse(CfLogisticsStorehouse cfLogisticsStorehouse) {
        this.cfLogisticsStorehouse = cfLogisticsStorehouse;
    }

    public CfLogisticsStorehousePlatform getCfLogisticsStorehousePlatform() {
        return cfLogisticsStorehousePlatform;
    }

    public void setCfLogisticsStorehousePlatform(CfLogisticsStorehousePlatform cfLogisticsStorehousePlatform) {
        this.cfLogisticsStorehousePlatform = cfLogisticsStorehousePlatform;
    }
}