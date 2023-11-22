package com.cf.charging.domain.customize;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 充电口状态实体
 */
public class CfChargingState implements Serializable {

    private Byte finishCode;    //结束原因编码

    private String port;    //充电端口

    private Byte chargingStatus;    //充电状态(0‐空闲中1‐正准备开始充电/2‐充电进行中/3‐充电结束/4‐启动失败/5‐系统故障(不能给汽车充电))

    private Byte portStatus;    //充电枪口状态

    private Byte parkingSpaceOccupancy; //车位是否占用(0-空闲/1-占用)

    private String orderId; //订单id(本系统充电记录id，并非本系统的账单id)

    private String carVin;  //车辆vin码

    private Byte groundLockStatus;  //地锁状态(0-打开/1-锁住)

    private float bmsVoltRequest;  //电池管理系统电压要求

    private float bmsAmpereRequest;  //电池管理系统电流要求

    private Byte bmsChargingMode;   //电池管理系统充电模式 1：恒压充电 2：恒流充电

    private float chargingPower;    //充电功率(单位 千瓦-kw)

    private Integer chargingAmpere;  //充电电流(单位 安培-A)

    private Integer chargingVolt;  //充电电压(单位 伏特-V)

    private float capacity; //车辆电池容量(单位 千瓦时-kwh)

    private Double chargingedKwh; //已充电度数(单位 千瓦时-kwh)

    private Long chargingedTime;    //已经充电时长(单位 毫秒-ms)

    private Long chargingedRemainingTime;    //预计充满时间(单位 毫秒-ms)

    private double beforeElectricityMeter;  //充电前电表数

    private double currentElectricityMeter;  //当前电表数

    private byte currentSoc;    //当前soc 1-100%

    private float highestSinglePowerBatteryCellVoltage; //最高单体动力蓄电池电池电压

    private byte numberOfTheHighestSinglePowerBatteryVoltage;   //最高单体动力蓄电池电压所在编号

    private byte numberOfTheLowestSinglePowerBatteryVoltage;   //最高单体动力蓄电池电压所在编号

    private float minimumSinglePowerBatteryCellVoltage; //最低单体动力蓄电池电池电压

    private byte maximumPowerBatteryTemperature;    //最高动力蓄电池温度

    private byte maximumTemperatureDetectionPoint;  //最高温度检测点

    private Long endTime;   //结束时间

    @Override
    public String toString() {
        return "CfChargingState{" +
                "finishCode=" + finishCode +
                ", port='" + port + '\'' +
                ", chargingStatus=" + chargingStatus +
                ", portStatus=" + portStatus +
                ", parkingSpaceOccupancy=" + parkingSpaceOccupancy +
                ", orderId='" + orderId + '\'' +
                ", carVin='" + carVin + '\'' +
                ", groundLockStatus=" + groundLockStatus +
                ", bmsVoltRequest=" + bmsVoltRequest +
                ", bmsAmpereRequest=" + bmsAmpereRequest +
                ", bmsChargingMode=" + bmsChargingMode +
                ", chargingPower=" + chargingPower +
                ", chargingAmpere=" + chargingAmpere +
                ", chargingVolt=" + chargingVolt +
                ", capacity=" + capacity +
                ", chargingedKwh=" + chargingedKwh +
                ", chargingedTime=" + chargingedTime +
                ", chargingedRemainingTime=" + chargingedRemainingTime +
                ", beforeElectricityMeter=" + beforeElectricityMeter +
                ", currentElectricityMeter=" + currentElectricityMeter +
                ", currentSoc=" + currentSoc +
                ", highestSinglePowerBatteryCellVoltage=" + highestSinglePowerBatteryCellVoltage +
                ", numberOfTheHighestSinglePowerBatteryVoltage=" + numberOfTheHighestSinglePowerBatteryVoltage +
                ", numberOfTheLowestSinglePowerBatteryVoltage=" + numberOfTheLowestSinglePowerBatteryVoltage +
                ", minimumSinglePowerBatteryCellVoltage=" + minimumSinglePowerBatteryCellVoltage +
                ", maximumPowerBatteryTemperature=" + maximumPowerBatteryTemperature +
                ", maximumTemperatureDetectionPoint=" + maximumTemperatureDetectionPoint +
                '}';
    }

    public Byte getFinishCode() {
        return finishCode;
    }

    public void setFinishCode(Byte finishCode) {
        this.finishCode = finishCode;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public Byte getChargingStatus() {
        return chargingStatus;
    }

    public void setChargingStatus(Byte chargingStatus) {
        this.chargingStatus = chargingStatus;
    }

    public Byte getPortStatus() {
        return portStatus;
    }

    public void setPortStatus(Byte portStatus) {
        this.portStatus = portStatus;
    }

    public Byte getParkingSpaceOccupancy() {
        return parkingSpaceOccupancy;
    }

    public void setParkingSpaceOccupancy(Byte parkingSpaceOccupancy) {
        this.parkingSpaceOccupancy = parkingSpaceOccupancy;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCarVin() {
        return carVin;
    }

    public void setCarVin(String carVin) {
        this.carVin = carVin;
    }

    public Byte getGroundLockStatus() {
        return groundLockStatus;
    }

    public void setGroundLockStatus(Byte groundLockStatus) {
        this.groundLockStatus = groundLockStatus;
    }

    public float getBmsVoltRequest() {
        return bmsVoltRequest;
    }

    public void setBmsVoltRequest(float bmsVoltRequest) {
        this.bmsVoltRequest = bmsVoltRequest;
    }

    public float getBmsAmpereRequest() {
        return bmsAmpereRequest;
    }

    public void setBmsAmpereRequest(float bmsAmpereRequest) {
        this.bmsAmpereRequest = bmsAmpereRequest;
    }

    public Byte getBmsChargingMode() {
        return bmsChargingMode;
    }

    public void setBmsChargingMode(Byte bmsChargingMode) {
        this.bmsChargingMode = bmsChargingMode;
    }

    public float getChargingPower() {
        return chargingPower;
    }

    public void setChargingPower(float chargingPower) {
        this.chargingPower = chargingPower;
    }

    public Integer getChargingAmpere() {
        return chargingAmpere;
    }

    public void setChargingAmpere(Integer chargingAmpere) {
        this.chargingAmpere = chargingAmpere;
    }

    public Integer getChargingVolt() {
        return chargingVolt;
    }

    public void setChargingVolt(Integer chargingVolt) {
        this.chargingVolt = chargingVolt;
    }

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    public Double getChargingedKwh() {
        return chargingedKwh;
    }

    public void setChargingedKwh(Double chargingedKwh) {
        this.chargingedKwh = chargingedKwh;
    }

    public Long getChargingedTime() {
        return chargingedTime;
    }

    public void setChargingedTime(Long chargingedTime) {
        this.chargingedTime = chargingedTime;
    }

    public Long getChargingedRemainingTime() {
        return chargingedRemainingTime;
    }

    public void setChargingedRemainingTime(Long chargingedRemainingTime) {
        this.chargingedRemainingTime = chargingedRemainingTime;
    }

    public double getBeforeElectricityMeter() {
        return beforeElectricityMeter;
    }

    public void setBeforeElectricityMeter(double beforeElectricityMeter) {
        this.beforeElectricityMeter = beforeElectricityMeter;
    }

    public double getCurrentElectricityMeter() {
        return currentElectricityMeter;
    }

    public void setCurrentElectricityMeter(double currentElectricityMeter) {
        this.currentElectricityMeter = currentElectricityMeter;
    }

    public byte getCurrentSoc() {
        return currentSoc;
    }

    public void setCurrentSoc(byte currentSoc) {
        this.currentSoc = currentSoc;
    }

    public float getHighestSinglePowerBatteryCellVoltage() {
        return highestSinglePowerBatteryCellVoltage;
    }

    public void setHighestSinglePowerBatteryCellVoltage(float highestSinglePowerBatteryCellVoltage) {
        this.highestSinglePowerBatteryCellVoltage = highestSinglePowerBatteryCellVoltage;
    }

    public byte getNumberOfTheHighestSinglePowerBatteryVoltage() {
        return numberOfTheHighestSinglePowerBatteryVoltage;
    }

    public void setNumberOfTheHighestSinglePowerBatteryVoltage(byte numberOfTheHighestSinglePowerBatteryVoltage) {
        this.numberOfTheHighestSinglePowerBatteryVoltage = numberOfTheHighestSinglePowerBatteryVoltage;
    }

    public byte getNumberOfTheLowestSinglePowerBatteryVoltage() {
        return numberOfTheLowestSinglePowerBatteryVoltage;
    }

    public void setNumberOfTheLowestSinglePowerBatteryVoltage(byte numberOfTheLowestSinglePowerBatteryVoltage) {
        this.numberOfTheLowestSinglePowerBatteryVoltage = numberOfTheLowestSinglePowerBatteryVoltage;
    }

    public float getMinimumSinglePowerBatteryCellVoltage() {
        return minimumSinglePowerBatteryCellVoltage;
    }

    public void setMinimumSinglePowerBatteryCellVoltage(float minimumSinglePowerBatteryCellVoltage) {
        this.minimumSinglePowerBatteryCellVoltage = minimumSinglePowerBatteryCellVoltage;
    }

    public byte getMaximumPowerBatteryTemperature() {
        return maximumPowerBatteryTemperature;
    }

    public void setMaximumPowerBatteryTemperature(byte maximumPowerBatteryTemperature) {
        this.maximumPowerBatteryTemperature = maximumPowerBatteryTemperature;
    }

    public byte getMaximumTemperatureDetectionPoint() {
        return maximumTemperatureDetectionPoint;
    }

    public void setMaximumTemperatureDetectionPoint(byte maximumTemperatureDetectionPoint) {
        this.maximumTemperatureDetectionPoint = maximumTemperatureDetectionPoint;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }
}
