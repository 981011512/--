package com.cf.charging.domain.request;

import java.io.Serializable;
import java.util.List;

public class CfChargingStationPaymentAgencyQuery implements Serializable {
    private String id;

    private String chargingStationId;

    private List<String> chargingStationIds;

    private String userPaymentAgency;

    private Integer sortIndex;

    private Integer page;

    private Integer size;

    private String orderBy;

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

    public List<String> getChargingStationIds() {
        return chargingStationIds;
    }

    public void setChargingStationIds(List<String> chargingStationIds) {
        this.chargingStationIds = chargingStationIds;
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