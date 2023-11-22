package com.cf.carpark.domain.request;

import java.io.Serializable;
import java.util.List;

public class CfCarParkWhitelistIssuedLogQuery implements Serializable {
    private String id;

    private String deviceSn;

    private String numberPlate;

    private List<String> numberPlates;

    private Long issuedTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDeviceSn() {
        return deviceSn;
    }

    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn == null ? null : deviceSn.trim();
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate == null ? null : numberPlate.trim();
    }

    public Long getIssuedTime() {
        return issuedTime;
    }

    public void setIssuedTime(Long issuedTime) {
        this.issuedTime = issuedTime;
    }

    public List<String> getNumberPlates() {
        return numberPlates;
    }

    public void setNumberPlates(List<String> numberPlates) {
        this.numberPlates = numberPlates;
    }
}