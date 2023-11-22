package com.cf.logistics.domain.request;

import java.io.Serializable;

public class CfLogisticsStorehousePlatformCargoTypeForm implements Serializable {
    private Long id;

    private Long logisticsStorehouseId;

    private Long logisticsStorehousePlatformId;

    private String cargoType;

    private Long factoryId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType == null ? null : cargoType.trim();
    }

    public Long getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Long factoryId) {
        this.factoryId = factoryId;
    }
}