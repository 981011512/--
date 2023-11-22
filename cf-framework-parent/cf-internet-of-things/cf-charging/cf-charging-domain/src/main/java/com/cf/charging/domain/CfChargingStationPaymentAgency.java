package com.cf.charging.domain;

import java.io.Serializable;

public class CfChargingStationPaymentAgency implements Serializable {
    private String id;

    private String chargingStationId;

    private String userPaymentAgency;

    private Integer sortIndex;

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

    public String getUserPaymentAgency() {
        return userPaymentAgency;
    }

    public void setUserPaymentAgency(String userPaymentAgency) {
        this.userPaymentAgency = userPaymentAgency == null ? null : userPaymentAgency.trim();
    }

    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }
}