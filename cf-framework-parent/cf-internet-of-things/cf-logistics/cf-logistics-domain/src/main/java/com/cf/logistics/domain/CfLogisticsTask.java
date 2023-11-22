package com.cf.logistics.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

public class CfLogisticsTask implements Serializable {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long pid;

    private String editerUid;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long startTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long endTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long updateTime;

    private String origin;

    private String destination;

    private String cargoType;

    private String carType;

    private Short vehiclesRequired;

    private Short reservedVehicles;

    private Integer resEach;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long weight;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long logisticsStorehouseId;

    private Byte taskStatus;

    private Byte taskType;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long factoryId;

    private String supplier;

    private String waybillNumber;

    private String taskTitle;

    private Byte emergencyLevel;

    private Byte childrenTaskCounts;

    private Integer sortIndex;

    private CfLogisticsStorehouse cfLogisticsStorehouse;

    private CfLogisticsFactory cfLogisticsFactory;

    private String driverName;  //司机姓名，需要自动预约时请传入，并非真实数据库表字段
    private String driverTel;   //司机手机号，需要自动预约时请传入，并非真实数据库表字段
    private String vehicleName; //司机车辆车牌号，需要自动预约时请传入，并非真实数据库表字段

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getEditerUid() {
        return editerUid;
    }

    public void setEditerUid(String editerUid) {
        this.editerUid = editerUid == null ? null : editerUid.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin == null ? null : origin.trim();
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination == null ? null : destination.trim();
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType == null ? null : cargoType.trim();
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType == null ? null : carType.trim();
    }

    public Short getVehiclesRequired() {
        return vehiclesRequired;
    }

    public void setVehiclesRequired(Short vehiclesRequired) {
        this.vehiclesRequired = vehiclesRequired;
    }

    public Short getReservedVehicles() {
        return reservedVehicles;
    }

    public void setReservedVehicles(Short reservedVehicles) {
        this.reservedVehicles = reservedVehicles;
    }

    public Integer getResEach() {
        return resEach;
    }

    public void setResEach(Integer resEach) {
        this.resEach = resEach;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Long getLogisticsStorehouseId() {
        return logisticsStorehouseId;
    }

    public void setLogisticsStorehouseId(Long logisticsStorehouseId) {
        this.logisticsStorehouseId = logisticsStorehouseId;
    }

    public Byte getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Byte taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Byte getTaskType() {
        return taskType;
    }

    public void setTaskType(Byte taskType) {
        this.taskType = taskType;
    }

    public Long getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Long factoryId) {
        this.factoryId = factoryId;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier == null ? null : supplier.trim();
    }

    public CfLogisticsStorehouse getCfLogisticsStorehouse() {
        return cfLogisticsStorehouse;
    }

    public void setCfLogisticsStorehouse(CfLogisticsStorehouse cfLogisticsStorehouse) {
        this.cfLogisticsStorehouse = cfLogisticsStorehouse;
    }

    public String getWaybillNumber() {
        return waybillNumber;
    }

    public void setWaybillNumber(String waybillNumber) {
        this.waybillNumber = waybillNumber;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public Byte getEmergencyLevel() {
        return emergencyLevel;
    }

    public void setEmergencyLevel(Byte emergencyLevel) {
        this.emergencyLevel = emergencyLevel;
    }

    public Byte getChildrenTaskCounts() {
        return childrenTaskCounts;
    }

    public void setChildrenTaskCounts(Byte childrenTaskCounts) {
        this.childrenTaskCounts = childrenTaskCounts;
    }

    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }

    public CfLogisticsFactory getCfLogisticsFactory() {
        return cfLogisticsFactory;
    }

    public void setCfLogisticsFactory(CfLogisticsFactory cfLogisticsFactory) {
        this.cfLogisticsFactory = cfLogisticsFactory;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverTel() {
        return driverTel;
    }

    public void setDriverTel(String driverTel) {
        this.driverTel = driverTel;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
}