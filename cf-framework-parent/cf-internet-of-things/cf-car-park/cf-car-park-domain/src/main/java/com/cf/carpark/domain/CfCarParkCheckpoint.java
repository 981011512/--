package com.cf.carpark.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class CfCarParkCheckpoint implements Serializable {
    private String id;

    private String name;

    private String carParkId;

    private String carParkName;

    private BigDecimal positionX;

    private BigDecimal positionY;

    private String positionDescribe;

    private Byte floor;

    private Byte mode;

    private Byte status;

    private BigDecimal distance;

    private String dutyUid;

    private String direction;

    private String userName;

    private Byte allowTemporaryCar;

    private Byte allowUnconditionalOpen;

    private Byte defaultCheckPoint;

    private Byte addForbiddenData;

    private Byte allowExpiredCar;

    private Byte allowPackageCar;

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

    public String getCarParkName() {
        return carParkName;
    }

    public void setCarParkName(String carParkName) {
        this.carParkName = carParkName;
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

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public String getDutyUid() {
        return dutyUid;
    }

    public void setDutyUid(String dutyUid) {
        this.dutyUid = dutyUid;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Byte getAllowTemporaryCar() {
        return allowTemporaryCar;
    }

    public void setAllowTemporaryCar(Byte allowTemporaryCar) {
        this.allowTemporaryCar = allowTemporaryCar;
    }

    public Byte getAllowUnconditionalOpen() {
        return allowUnconditionalOpen;
    }

    public void setAllowUnconditionalOpen(Byte allowUnconditionalOpen) {
        this.allowUnconditionalOpen = allowUnconditionalOpen;
    }

    public Byte getDefaultCheckPoint() {
        return defaultCheckPoint;
    }

    public void setDefaultCheckPoint(Byte defaultCheckPoint) {
        this.defaultCheckPoint = defaultCheckPoint;
    }

    public Byte getAddForbiddenData() {
        return addForbiddenData;
    }

    public void setAddForbiddenData(Byte addForbiddenData) {
        this.addForbiddenData = addForbiddenData;
    }

    public Byte getAllowExpiredCar() {
        return allowExpiredCar;
    }

    public void setAllowExpiredCar(Byte allowExpiredCar) {
        this.allowExpiredCar = allowExpiredCar;
    }

    public Byte getAllowPackageCar() {
        return allowPackageCar;
    }

    public void setAllowPackageCar(Byte allowPackageCar) {
        this.allowPackageCar = allowPackageCar;
    }
}