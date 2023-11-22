package com.cf.logistics.domain.request;

import java.io.Serializable;
import java.util.List;

public class CfLogisticsTaskQuery implements Serializable {
    private Long id;

    private List<Long> ids;

    private Long pid;

    private String editerUid;

    private Long createTime;

    private Long minCreateTime;

    private Long maxCreateTime;

    private Long startTime;

    private Long minStartTime;

    private Long maxStartTime;

    private Long endTime;

    private Long minEndTime;

    private Long maxEndTime;

    private Long updateTime;

    private String origin;

    private String destination;

    private String cargoType;

    private String carType;

    private Short vehiclesRequired;

    private Short reservedVehicles;

    private Integer resEach;

    private Long weight;

    private Long logisticsStorehouseId;

    private List<Long> logisticsStorehouseIds;

    private Byte taskStatus;

    private Byte taskType;

    private Long factoryId;

    private String supplier;

    private String waybillNumber;

    private Byte emergencyLevel;

    private Byte childrenTaskCounts;

    private Integer sortIndex;

    private Integer page;

    private Integer size;

    private String orderBy;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
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

    public Long getMinCreateTime() {
        return minCreateTime;
    }

    public void setMinCreateTime(Long minCreateTime) {
        this.minCreateTime = minCreateTime;
    }

    public Long getMaxCreateTime() {
        return maxCreateTime;
    }

    public void setMaxCreateTime(Long maxCreateTime) {
        this.maxCreateTime = maxCreateTime;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getMinStartTime() {
        return minStartTime;
    }

    public void setMinStartTime(Long minStartTime) {
        this.minStartTime = minStartTime;
    }

    public Long getMaxStartTime() {
        return maxStartTime;
    }

    public void setMaxStartTime(Long maxStartTime) {
        this.maxStartTime = maxStartTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Long getMinEndTime() {
        return minEndTime;
    }

    public void setMinEndTime(Long minEndTime) {
        this.minEndTime = minEndTime;
    }

    public Long getMaxEndTime() {
        return maxEndTime;
    }

    public void setMaxEndTime(Long maxEndTime) {
        this.maxEndTime = maxEndTime;
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

    public List<Long> getLogisticsStorehouseIds() {
        return logisticsStorehouseIds;
    }

    public void setLogisticsStorehouseIds(List<Long> logisticsStorehouseIds) {
        this.logisticsStorehouseIds = logisticsStorehouseIds;
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

    public String getWaybillNumber() {
        return waybillNumber;
    }

    public void setWaybillNumber(String waybillNumber) {
        this.waybillNumber = waybillNumber;
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