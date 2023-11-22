package com.cf.logistics.domain;

import com.cf.ucenter.domain.CfUser;
import com.cf.ucenter.domain.CfUserDriverLicense;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

public class CfLogisticsTaskLog implements Serializable {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long pid;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long taskId;

    private String deliverUid;

    private String receiptUid;

    private String checkerUid;

    private Byte taskLogStatus;

    private Integer reserveQuantity;

    private Integer finallyQuantity;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long reserveWeight;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long finallyWeight;

    private Short queueIndex;

    private String numberPlate;

    private String deliveryNoteCode;

    private String deliveryNoteImage;

    private String inboundDeliveryNoteNumber;

    private String purchaseOrderNumber;

    private String itemNumber;

    private String itemDescription;

    private String category;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long requestedDeliveryTime;

    private Byte exemptFromInspection;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long earliestDeliveryTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long latestDeliveryDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long shelfLife;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long notifyDriverTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long logisticsStorehouseId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long logisticsPlatformId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long factoryId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createTime;

    private CfLogisticsStorehouse cfLogisticsStorehouse;

    private CfLogisticsTask cfLogisticsTask;

    private CfLogisticsStorehousePlatform cfLogisticsStorehousePlatform;

    private CfLogisticsQueuingArea cfLogisticsQueuingArea;

    private CfUser cfUser;

    private CfUserDriverLicense cfUserDriverLicense;

    private Integer numberOfPeopleInLine;   //当前排队人数

    private CfLogisticsFactory cfLogisticsFactory;

    private byte reserved;  //是否已经预约(0-否/1-是，主要用户返回当前用户是否已经预约)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long checkTime;

    private Byte emergencyLevel;

    private Long queuingAreaId;

    private Long startQueuingTime;

    private Long callTime;

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

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getDeliverUid() {
        return deliverUid;
    }

    public void setDeliverUid(String deliverUid) {
        this.deliverUid = deliverUid == null ? null : deliverUid.trim();
    }

    public String getReceiptUid() {
        return receiptUid;
    }

    public void setReceiptUid(String receiptUid) {
        this.receiptUid = receiptUid == null ? null : receiptUid.trim();
    }

    public String getCheckerUid() {
        return checkerUid;
    }

    public void setCheckerUid(String checkerUid) {
        this.checkerUid = checkerUid == null ? null : checkerUid.trim();
    }

    public Byte getTaskLogStatus() {
        return taskLogStatus;
    }

    public void setTaskLogStatus(Byte taskLogStatus) {
        this.taskLogStatus = taskLogStatus;
    }

    public Integer getReserveQuantity() {
        return reserveQuantity;
    }

    public void setReserveQuantity(Integer reserveQuantity) {
        this.reserveQuantity = reserveQuantity;
    }

    public Integer getFinallyQuantity() {
        return finallyQuantity;
    }

    public void setFinallyQuantity(Integer finallyQuantity) {
        this.finallyQuantity = finallyQuantity;
    }

    public Long getReserveWeight() {
        return reserveWeight;
    }

    public void setReserveWeight(Long reserveWeight) {
        this.reserveWeight = reserveWeight;
    }

    public Long getFinallyWeight() {
        return finallyWeight;
    }

    public void setFinallyWeight(Long finallyWeight) {
        this.finallyWeight = finallyWeight;
    }

    public Short getQueueIndex() {
        return queueIndex;
    }

    public void setQueueIndex(Short queueIndex) {
        this.queueIndex = queueIndex;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate == null ? null : numberPlate.trim();
    }

    public String getDeliveryNoteCode() {
        return deliveryNoteCode;
    }

    public void setDeliveryNoteCode(String deliveryNoteCode) {
        this.deliveryNoteCode = deliveryNoteCode == null ? null : deliveryNoteCode.trim();
    }

    public String getDeliveryNoteImage() {
        return deliveryNoteImage;
    }

    public void setDeliveryNoteImage(String deliveryNoteImage) {
        this.deliveryNoteImage = deliveryNoteImage == null ? null : deliveryNoteImage.trim();
    }

    public String getInboundDeliveryNoteNumber() {
        return inboundDeliveryNoteNumber;
    }

    public void setInboundDeliveryNoteNumber(String inboundDeliveryNoteNumber) {
        this.inboundDeliveryNoteNumber = inboundDeliveryNoteNumber == null ? null : inboundDeliveryNoteNumber.trim();
    }

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber == null ? null : purchaseOrderNumber.trim();
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber == null ? null : itemNumber.trim();
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription == null ? null : itemDescription.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public Long getRequestedDeliveryTime() {
        return requestedDeliveryTime;
    }

    public void setRequestedDeliveryTime(Long requestedDeliveryTime) {
        this.requestedDeliveryTime = requestedDeliveryTime;
    }

    public Byte getExemptFromInspection() {
        return exemptFromInspection;
    }

    public void setExemptFromInspection(Byte exemptFromInspection) {
        this.exemptFromInspection = exemptFromInspection;
    }

    public Long getEarliestDeliveryTime() {
        return earliestDeliveryTime;
    }

    public void setEarliestDeliveryTime(Long earliestDeliveryTime) {
        this.earliestDeliveryTime = earliestDeliveryTime;
    }

    public Long getLatestDeliveryDate() {
        return latestDeliveryDate;
    }

    public void setLatestDeliveryDate(Long latestDeliveryDate) {
        this.latestDeliveryDate = latestDeliveryDate;
    }

    public Long getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Long shelfLife) {
        this.shelfLife = shelfLife;
    }

    public Long getNotifyDriverTime() {
        return notifyDriverTime;
    }

    public void setNotifyDriverTime(Long notifyDriverTime) {
        this.notifyDriverTime = notifyDriverTime;
    }

    public Long getLogisticsStorehouseId() {
        return logisticsStorehouseId;
    }

    public void setLogisticsStorehouseId(Long logisticsStorehouseId) {
        this.logisticsStorehouseId = logisticsStorehouseId;
    }

    public Long getLogisticsPlatformId() {
        return logisticsPlatformId;
    }

    public void setLogisticsPlatformId(Long logisticsPlatformId) {
        this.logisticsPlatformId = logisticsPlatformId;
    }

    public Long getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Long factoryId) {
        this.factoryId = factoryId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public CfLogisticsStorehouse getCfLogisticsStorehouse() {
        return cfLogisticsStorehouse;
    }

    public void setCfLogisticsStorehouse(CfLogisticsStorehouse cfLogisticsStorehouse) {
        this.cfLogisticsStorehouse = cfLogisticsStorehouse;
    }

    public CfUser getCfUser() {
        return cfUser;
    }

    public void setCfUser(CfUser cfUser) {
        this.cfUser = cfUser;
    }

    public CfUserDriverLicense getCfUserDriverLicense() {
        return cfUserDriverLicense;
    }

    public void setCfUserDriverLicense(CfUserDriverLicense cfUserDriverLicense) {
        this.cfUserDriverLicense = cfUserDriverLicense;
    }

    public CfLogisticsTask getCfLogisticsTask() {
        return cfLogisticsTask;
    }

    public void setCfLogisticsTask(CfLogisticsTask cfLogisticsTask) {
        this.cfLogisticsTask = cfLogisticsTask;
    }

    public CfLogisticsStorehousePlatform getCfLogisticsStorehousePlatform() {
        return cfLogisticsStorehousePlatform;
    }

    public void setCfLogisticsStorehousePlatform(CfLogisticsStorehousePlatform cfLogisticsStorehousePlatform) {
        this.cfLogisticsStorehousePlatform = cfLogisticsStorehousePlatform;
    }

    public CfLogisticsQueuingArea getCfLogisticsQueuingArea() {
        return cfLogisticsQueuingArea;
    }

    public void setCfLogisticsQueuingArea(CfLogisticsQueuingArea cfLogisticsQueuingArea) {
        this.cfLogisticsQueuingArea = cfLogisticsQueuingArea;
    }

    public Integer getNumberOfPeopleInLine() {
        return numberOfPeopleInLine;
    }

    public void setNumberOfPeopleInLine(Integer numberOfPeopleInLine) {
        this.numberOfPeopleInLine = numberOfPeopleInLine;
    }

    public CfLogisticsFactory getCfLogisticsFactory() {
        return cfLogisticsFactory;
    }

    public void setCfLogisticsFactory(CfLogisticsFactory cfLogisticsFactory) {
        this.cfLogisticsFactory = cfLogisticsFactory;
    }

    public byte getReserved() {
        return reserved;
    }

    public void setReserved(byte reserved) {
        this.reserved = reserved;
    }

    public Long getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Long checkTime) {
        this.checkTime = checkTime;
    }

    public Byte getEmergencyLevel() {
        return emergencyLevel;
    }

    public void setEmergencyLevel(Byte emergencyLevel) {
        this.emergencyLevel = emergencyLevel;
    }

    public Long getQueuingAreaId() {
        return queuingAreaId;
    }

    public void setQueuingAreaId(Long queuingAreaId) {
        this.queuingAreaId = queuingAreaId;
    }

    public Long getStartQueuingTime() {
        return startQueuingTime;
    }

    public void setStartQueuingTime(Long startQueuingTime) {
        this.startQueuingTime = startQueuingTime;
    }

    public Long getCallTime() {
        return callTime;
    }

    public void setCallTime(Long callTime) {
        this.callTime = callTime;
    }
}