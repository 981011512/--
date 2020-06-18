package com.cf.carpark.domain;

import java.io.Serializable;

public class CfCarParkUseLog implements Serializable {
    private String id;

    private String numberPlate;

    private String carParkId;

    private Long inTime;

    private Long outTime;

    private Byte releaseType;

    private String inCheckPointId;

    private String outCheckPointId;

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

    public String getCarParkId() {
        return carParkId;
    }

    public void setCarParkId(String carParkId) {
        this.carParkId = carParkId == null ? null : carParkId.trim();
    }

    public Long getInTime() {
        return inTime;
    }

    public void setInTime(Long inTime) {
        this.inTime = inTime;
    }

    public Long getOutTime() {
        return outTime;
    }

    public void setOutTime(Long outTime) {
        this.outTime = outTime;
    }

    public Byte getReleaseType() {
        return releaseType;
    }

    public void setReleaseType(Byte releaseType) {
        this.releaseType = releaseType;
    }

    public String getInCheckPointId() {
        return inCheckPointId;
    }

    public void setInCheckPointId(String inCheckPointId) {
        this.inCheckPointId = inCheckPointId == null ? null : inCheckPointId.trim();
    }

    public String getOutCheckPointId() {
        return outCheckPointId;
    }

    public void setOutCheckPointId(String outCheckPointId) {
        this.outCheckPointId = outCheckPointId == null ? null : outCheckPointId.trim();
    }
}