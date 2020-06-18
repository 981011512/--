package com.cf.carpark.domain;

import java.io.Serializable;

public class CfCar implements Serializable {
    private String id;

    private String numberPlate;

    private Boolean energyType;

    private String uid;

    private Boolean payType;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate == null ? null : numberPlate.trim();
    }

    public Boolean getEnergyType() {
        return energyType;
    }

    public void setEnergyType(Boolean energyType) {
        this.energyType = energyType;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public Boolean getPayType() {
        return payType;
    }

    public void setPayType(Boolean payType) {
        this.payType = payType;
    }
}