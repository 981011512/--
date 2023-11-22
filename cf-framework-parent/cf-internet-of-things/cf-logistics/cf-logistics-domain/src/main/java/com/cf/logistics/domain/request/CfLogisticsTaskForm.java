package com.cf.logistics.domain.request;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class CfLogisticsTaskForm implements Serializable {
    @ApiModelProperty(value = "", example = "数据id，无需提供，系统会自动维护", required = false)
    private Long id;
    @ApiModelProperty(value = "", example = "父级id，如果当前任务为子任务时需要提供父级任务id，如果没有的话请提供空", required = false)
    private Long pid;
    @ApiModelProperty(value = "", example = "创建或编辑者id，无需提供，系统会自动维护", required = false)
    private String editerUid;
    @ApiModelProperty(value = "", example = "创建时间，无需提供，系统会自动维护", required = false)
    private Long createTime;
    @ApiModelProperty(value = "", example = "开始时间，单位为毫秒", required = true)
    private Long startTime;
    @ApiModelProperty(value = "", example = "结束时间，单位为毫秒", required = true)
    private Long endTime;
    @ApiModelProperty(value = "", example = "更新时间，无需提供，系统会自动维护", required = false)
    private Long updateTime;
    @ApiModelProperty(value = "", example = "始发地，没有的话请提供空字符串", required = false)
    private String origin;
    @ApiModelProperty(value = "", example = "目的地，没有的话请提供空字符串", required = false)
    private String destination;
    @ApiModelProperty(value = "", example = "货物类型，没有的话请提供空字符串", required = false)
    private String cargoType;
    @ApiModelProperty(value = "", example = "货物类型id，司机主动创建任务时，必须提供", required = false)
    private Long cargoTypeId;
    @ApiModelProperty(value = "", example = "要求车辆类型，没有的话请提供空字符串", required = false)
    private String carType;
    @ApiModelProperty(value = "", example = "需要车辆数", required = true)
    private Short vehiclesRequired;
    @ApiModelProperty(value = "", example = "已经预约车辆数，无需提供，系统会自动维护，首次创建可以提供0或者给空而不是空字符串", required = false)
    private Short reservedVehicles;
    @ApiModelProperty(value = "", example = "货物数量", required = true)
    private Integer resEach;
    @ApiModelProperty(value = "", example = "货物重量，单位：克", required = true)
    private Long weight;
    @ApiModelProperty(value = "", example = "仓库id", required = true)
    private Long logisticsStorehouseId;
    @ApiModelProperty(value = "", example = "仓库名称(提供此名称会自动查询对应的仓库并赋值给仓库id)", required = true)
    private String logisticsStorehouseName;
    @ApiModelProperty(value = "", example = "任务状态(0-预约中，1-装/卸货中，2-已结束)", required = true)
    private Byte taskStatus;
    @ApiModelProperty(value = "", example = "任务类型(0-拉货/1-送货)", required = true)
    private Byte taskType;
    @ApiModelProperty(value = "", example = "工厂id，没有的话请提供空或者0", required = false)
    private Long factoryId;
    @ApiModelProperty(value = "", example = "工厂名称，会根据工厂名称去查询工厂", required = false)
    private String factory;
    @ApiModelProperty(value = "", example = "供应商名称，没有的话请提供空字符串", required = false)
    private String supplier;
    @ApiModelProperty(value = "", example = "运单号", required = true)
    private String waybillNumber;
    @ApiModelProperty(value = "", example = "任务标题", required = true)
    private String taskTitle;
    @ApiModelProperty(value = "", example = "紧急程度(0-一般/1-紧急)", required = true)
    private Byte emergencyLevel;
    @ApiModelProperty(value = "0", example = "子任务数", required = false)
    private Byte childrenTaskCounts;

    @ApiModelProperty(value = "0", example = "排序序号", required = false)
    private Integer sortIndex;
    @ApiModelProperty(value = "", example = "如果你是第三方系统调用时请提供，密钥key编号，由我方系统提供，请联系我们获取", required = false)
    private Long keyId;
    @ApiModelProperty(value = "", example = "如果你是第三方系统调用时请提供，签名方式(MD5/HMACSHA256)", required = false)
    private String signType;
    @ApiModelProperty(value = "", example = "如果你是第三方系统调用时请提供，签名(字段排序后再进行加密，注意不要把sign字段参与加密)", required = false)
    private String sign;
    @ApiModelProperty(value = "", example = "司机姓名，需要自动预约时请传入", required = false)
    private String driverName;
    @ApiModelProperty(value = "", example = "司机手机号，需要自动预约时请传入", required = false)
    private String driverTel;
    @ApiModelProperty(value = "", example = "司机车辆车牌号，需要自动预约时请传入", required = false)
    private String vehicleName;

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

    public Long getCargoTypeId() {
        return cargoTypeId;
    }

    public void setCargoTypeId(Long cargoTypeId) {
        this.cargoTypeId = cargoTypeId;
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

    public String getLogisticsStorehouseName() {
        return logisticsStorehouseName;
    }

    public void setLogisticsStorehouseName(String logisticsStorehouseName) {
        this.logisticsStorehouseName = logisticsStorehouseName;
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

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
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

    public Long getKeyId() {
        return keyId;
    }

    public void setKeyId(Long keyId) {
        this.keyId = keyId;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
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