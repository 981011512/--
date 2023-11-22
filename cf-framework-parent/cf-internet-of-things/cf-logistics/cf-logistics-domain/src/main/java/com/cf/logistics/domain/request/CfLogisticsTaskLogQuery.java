package com.cf.logistics.domain.request;

import java.io.Serializable;
import java.util.List;

public class CfLogisticsTaskLogQuery implements Serializable {
    private Long id;

    private List<Long> ids;

    private Long pid;

    private Long taskId;

    private List<Long> taskIds;

    private String deliverUid;

    private String receiptUid;

    private String checkerUid;

    private Byte taskLogStatus;

    private Byte minTaskLogStatus;

    private Byte maxTaskLogStatus;

    private Integer reserveQuantity;

    private Integer finallyQuantity;

    private Long reserveWeight;

    private Long finallyWeight;

    private Short queueIndex;

    private Short minQueueIndex;

    private Short maxQueueIndex;

    private String numberPlate;

    private String deliveryNoteCode;

    private String deliveryNoteImage;

    private String inboundDeliveryNoteNumber;

    private String purchaseOrderNumber;

    private String itemNumber;

    private String itemDescription;

    private String category;

    private Long requestedDeliveryTime;

    private Byte exemptFromInspection;

    private Long earliestDeliveryTime;

    private Long latestDeliveryDate;

    private Long shelfLife;

    private Long notifyDriverTime;

    private Long minNotifyDriverTime;

    private Long maxNotifyDriverTime;

    private Long logisticsStorehouseId;

    private List<Long> logisticsStorehouseIds;

    private Long logisticsPlatformId;

    private Long checkTime;

    private Byte emergencyLevel;

    private Long queuingAreaId;

    private Long startQueuingTime;

    private Long callTime;

    private Long factoryId;

    private Long createTime;

    private Long minCreateTime;

    private Long maxCreateTime;

    private Integer page;

    private Integer size;

    private String orderBy;

    private Short queueIndexChangeValue;    //排队序号变动值，并非真实数据库字段

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

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public List<Long> getTaskIds() {
        return taskIds;
    }

    public void setTaskIds(List<Long> taskIds) {
        this.taskIds = taskIds;
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

    public Byte getMinTaskLogStatus() {
        return minTaskLogStatus;
    }

    public void setMinTaskLogStatus(Byte minTaskLogStatus) {
        this.minTaskLogStatus = minTaskLogStatus;
    }

    public Byte getMaxTaskLogStatus() {
        return maxTaskLogStatus;
    }

    public void setMaxTaskLogStatus(Byte maxTaskLogStatus) {
        this.maxTaskLogStatus = maxTaskLogStatus;
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

    public Short getMinQueueIndex() {
        return minQueueIndex;
    }

    public void setMinQueueIndex(Short minQueueIndex) {
        this.minQueueIndex = minQueueIndex;
    }

    public Short getMaxQueueIndex() {
        return maxQueueIndex;
    }

    public void setMaxQueueIndex(Short maxQueueIndex) {
        this.maxQueueIndex = maxQueueIndex;
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

    public Long getMinNotifyDriverTime() {
        return minNotifyDriverTime;
    }

    public void setMinNotifyDriverTime(Long minNotifyDriverTime) {
        this.minNotifyDriverTime = minNotifyDriverTime;
    }

    public Long getMaxNotifyDriverTime() {
        return maxNotifyDriverTime;
    }

    public void setMaxNotifyDriverTime(Long maxNotifyDriverTime) {
        this.maxNotifyDriverTime = maxNotifyDriverTime;
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

    public Long getLogisticsPlatformId() {
        return logisticsPlatformId;
    }

    public void setLogisticsPlatformId(Long logisticsPlatformId) {
        this.logisticsPlatformId = logisticsPlatformId;
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

    public Short getQueueIndexChangeValue() {
        return queueIndexChangeValue;
    }

    public void setQueueIndexChangeValue(Short queueIndexChangeValue) {
        this.queueIndexChangeValue = queueIndexChangeValue;
    }
}