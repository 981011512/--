package com.cf.carpark.domain;

import com.cf.pay.domain.CfOrder;
import com.cf.pay.domain.CfPaymentAgency;

import java.io.Serializable;

public class CfCarParkUseLog implements Serializable {
    private String id;

    private String numberPlate;

    private String uid;

    private String inSmallImage;

    private String outSmallImage;

    private String inBigImage;

    private String outBigImage;

    private String carParkId;

    private Long subscribeTime;

    private Long cancelSubscribeTime;

    private Long inTime;

    private Long outTime;

    private Byte inReleaseType;

    private Byte outReleaseType;

    private String inCheckPointId;

    private String outCheckPointId;

    private String createPosition;

    private Long payTime;

    private Long createTime;

    private CfCarPark cfCarPark;

    private CfCarParkCheckpoint cfCarParkCheckpointIn;

    private CfCarParkCheckpoint cfCarParkCheckpointOut;

    private CfCarParkDevice cfCarParkDevice;

    private String releaseNotice;

    private String inHandleUid;

    private String outHandleUid;

    private CfOrder cfOrder;

    private CfCarParkCarType cfCarParkCarType;

    private CfCarParkPackage cfCarParkPackage;

    private CfPaymentAgency cfPaymentAgency;

    private Byte countFeeStatus;

    private CfCarParkCarLimit cfCarParkCarLimit;

    private String remarks;

    private String carType;

    private Byte carStatus;

    private String visitUnit;

    private Long giveAwayParkTime;

    private Byte carNumberPlateColor;

    private String carBrand;

    private String parkingSpaceNumber;

    private Long freeTime;  //临时存储数据用，并非数据库真实存在字段

    private static final long serialVersionUID = 1L;

    public CfCarParkUseLog() {
    }

    public CfCarParkUseLog(String id, String numberPlate, String uid, String inSmallImage, String outSmallImage, String inBigImage, String outBigImage, String carParkId, Long subscribeTime, Long cancelSubscribeTime, Long inTime, Long outTime, Byte inReleaseType, Byte outReleaseType, String inCheckPointId, String outCheckPointId, String createPosition, Long payTime, Long createTime, String releaseNotice, String inHandleUid, String outHandleUid, Byte countFeeStatus, String remarks, String carType, Byte carStatus, String visitUnit) {
        this.id = id;
        this.numberPlate = numberPlate;
        this.uid = uid;
        this.inSmallImage = inSmallImage;
        this.outSmallImage = outSmallImage;
        this.inBigImage = inBigImage;
        this.outBigImage = outBigImage;
        this.carParkId = carParkId;
        this.subscribeTime = subscribeTime;
        this.cancelSubscribeTime = cancelSubscribeTime;
        this.inTime = inTime;
        this.outTime = outTime;
        this.inReleaseType = inReleaseType;
        this.outReleaseType = outReleaseType;
        this.inCheckPointId = inCheckPointId;
        this.outCheckPointId = outCheckPointId;
        this.createPosition = createPosition;
        this.payTime = payTime;
        this.createTime = createTime;
        this.releaseNotice = releaseNotice;
        this.inHandleUid = inHandleUid;
        this.outHandleUid = outHandleUid;
        this.countFeeStatus = countFeeStatus;
        this.remarks = remarks;
        this.carType = carType;
        this.carStatus = carStatus;
        this.visitUnit = visitUnit;
    }

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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getInSmallImage() {
        return inSmallImage;
    }

    public void setInSmallImage(String inSmallImage) {
        this.inSmallImage = inSmallImage == null ? null : inSmallImage.trim();
    }

    public String getOutSmallImage() {
        return outSmallImage;
    }

    public void setOutSmallImage(String outSmallImage) {
        this.outSmallImage = outSmallImage == null ? null : outSmallImage.trim();
    }

    public String getInBigImage() {
        return inBigImage;
    }

    public void setInBigImage(String inBigImage) {
        this.inBigImage = inBigImage == null ? null : inBigImage.trim();
    }

    public String getOutBigImage() {
        return outBigImage;
    }

    public void setOutBigImage(String outBigImage) {
        this.outBigImage = outBigImage == null ? null : outBigImage.trim();
    }

    public String getCarParkId() {
        return carParkId;
    }

    public void setCarParkId(String carParkId) {
        this.carParkId = carParkId == null ? null : carParkId.trim();
    }

    public Long getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(Long subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    public Long getCancelSubscribeTime() {
        return cancelSubscribeTime;
    }

    public void setCancelSubscribeTime(Long cancelSubscribeTime) {
        this.cancelSubscribeTime = cancelSubscribeTime;
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

    public Byte getInReleaseType() {
        return inReleaseType;
    }

    public void setInReleaseType(Byte inReleaseType) {
        this.inReleaseType = inReleaseType;
    }

    public Byte getOutReleaseType() {
        return outReleaseType;
    }

    public void setOutReleaseType(Byte outReleaseType) {
        this.outReleaseType = outReleaseType;
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

    public String getCreatePosition() {
        return createPosition;
    }

    public void setCreatePosition(String createPosition) {
        this.createPosition = createPosition == null ? null : createPosition.trim();
    }

    public Long getPayTime() {
        return payTime;
    }

    public void setPayTime(Long payTime) {
        this.payTime = payTime;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public CfCarPark getCfCarPark() {
        return cfCarPark;
    }

    public void setCfCarPark(CfCarPark cfCarPark) {
        this.cfCarPark = cfCarPark;
    }

    public CfCarParkCheckpoint getCfCarParkCheckpointIn() {
        return cfCarParkCheckpointIn;
    }

    public void setCfCarParkCheckpointIn(CfCarParkCheckpoint cfCarParkCheckpointIn) {
        this.cfCarParkCheckpointIn = cfCarParkCheckpointIn;
    }

    public CfCarParkCheckpoint getCfCarParkCheckpointOut() {
        return cfCarParkCheckpointOut;
    }

    public void setCfCarParkCheckpointOut(CfCarParkCheckpoint cfCarParkCheckpointOut) {
        this.cfCarParkCheckpointOut = cfCarParkCheckpointOut;
    }

    public String getReleaseNotice() {
        return releaseNotice;
    }

    public void setReleaseNotice(String releaseNotice) {
        this.releaseNotice = releaseNotice;
    }

    public CfCarParkDevice getCfCarParkDevice() {
        return cfCarParkDevice;
    }

    public void setCfCarParkDevice(CfCarParkDevice cfCarParkDevice) {
        this.cfCarParkDevice = cfCarParkDevice;
    }

    public String getInHandleUid() {
        return inHandleUid;
    }

    public void setInHandleUid(String inHandleUid) {
        this.inHandleUid = inHandleUid;
    }

    public String getOutHandleUid() {
        return outHandleUid;
    }

    public void setOutHandleUid(String outHandleUid) {
        this.outHandleUid = outHandleUid;
    }

    public CfOrder getCfOrder() {
        return cfOrder;
    }

    public void setCfOrder(CfOrder cfOrder) {
        this.cfOrder = cfOrder;
    }

    public CfCarParkCarType getCfCarParkCarType() {
        return cfCarParkCarType;
    }

    public void setCfCarParkCarType(CfCarParkCarType cfCarParkCarType) {
        this.cfCarParkCarType = cfCarParkCarType;
    }

    public CfCarParkPackage getCfCarParkPackage() {
        return cfCarParkPackage;
    }

    public void setCfCarParkPackage(CfCarParkPackage cfCarParkPackage) {
        this.cfCarParkPackage = cfCarParkPackage;
    }

    public CfPaymentAgency getCfPaymentAgency() {
        return cfPaymentAgency;
    }

    public void setCfPaymentAgency(CfPaymentAgency cfPaymentAgency) {
        this.cfPaymentAgency = cfPaymentAgency;
    }

    public Byte getCountFeeStatus() {
        return countFeeStatus;
    }

    public void setCountFeeStatus(Byte countFeeStatus) {
        this.countFeeStatus = countFeeStatus;
    }

    public CfCarParkCarLimit getCfCarParkCarLimit() {
        return cfCarParkCarLimit;
    }

    public void setCfCarParkCarLimit(CfCarParkCarLimit cfCarParkCarLimit) {
        this.cfCarParkCarLimit = cfCarParkCarLimit;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Byte getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(Byte carStatus) {
        this.carStatus = carStatus;
    }

    public String getVisitUnit() {
        return visitUnit;
    }

    public void setVisitUnit(String visitUnit) {
        this.visitUnit = visitUnit;
    }

    public Long getGiveAwayParkTime() {
        return giveAwayParkTime;
    }

    public void setGiveAwayParkTime(Long giveAwayParkTime) {
        this.giveAwayParkTime = giveAwayParkTime;
    }

    public Byte getCarNumberPlateColor() {
        return carNumberPlateColor;
    }

    public void setCarNumberPlateColor(Byte carNumberPlateColor) {
        this.carNumberPlateColor = carNumberPlateColor;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getParkingSpaceNumber() {
        return parkingSpaceNumber;
    }

    public void setParkingSpaceNumber(String parkingSpaceNumber) {
        this.parkingSpaceNumber = parkingSpaceNumber;
    }

    public Long getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(Long freeTime) {
        this.freeTime = freeTime;
    }
}