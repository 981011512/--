package com.cf.carpark.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class CfCarParkCheckpoint implements Serializable {
    private String id;

    private String name;

    private String carParkId;

    private BigDecimal positionX;

    private BigDecimal positionY;

    private String positionDescribe;

    private Byte floor;

    private Byte mode;

    private Byte status;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCarParkId() {
        return carParkId;
    }

    public void setCarParkId(String carParkId) {
        this.carParkId = carParkId == null ? null : carParkId.trim();
    }

    public BigDecimal getPositionX() {
        return positionX;
    }

    public void setPositionX(BigDecimal positionX) {
        this.positionX = positionX;
    }

    public BigDecimal getPositionY() {
        return positionY;
    }

    public void setPositionY(BigDecimal positionY) {
        this.positionY = positionY;
    }

    public String getPositionDescribe() {
        return positionDescribe;
    }

    public void setPositionDescribe(String positionDescribe) {
        this.positionDescribe = positionDescribe == null ? null : positionDescribe.trim();
    }

    public Byte getFloor() {
        return floor;
    }

    public void setFloor(Byte floor) {
        this.floor = floor;
    }

    public Byte getMode() {
        return mode;
    }

    public void setMode(Byte mode) {
        this.mode = mode;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}