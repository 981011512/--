package com.cf.pay.domain;

import java.io.Serializable;

public class CarParkPaymentAgency implements Serializable {
    private String id;

    private String carParkId;

    private String userPaymentAgency;

    private Integer sortIndex;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCarParkId() {
        return carParkId;
    }

    public void setCarParkId(String carParkId) {
        this.carParkId = carParkId == null ? null : carParkId.trim();
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