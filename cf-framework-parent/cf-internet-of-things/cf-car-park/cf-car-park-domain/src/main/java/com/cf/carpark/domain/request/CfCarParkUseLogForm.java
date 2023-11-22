package com.cf.carpark.domain.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class CfCarParkUseLogForm implements Serializable {

    private String id;

    @ApiModelProperty(value = "车牌号", required = true)
    @Pattern(regexp = "^[\\u0391-\\uFFE5A-Za-z]{1}[A-Z0-9]{5,6}[\\u0391-\\uFFE5A-Z0-9]{1,2}$", message = "车牌号不合法")
    private String numberPlate;

    private String uid;

    private String inSmallImage;

    private String outSmallImage;

    private String inBigImage;

    private String outBigImage;

    @ApiModelProperty(value = "停车场id", required = true)
    @NotEmpty(message = "请提供停车场id")
    private String carParkId;

    @ApiModelProperty(value = "预订停车时间", required = true)
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

    @ApiModelProperty(value = "支付方式id", required = true)
    private String payTypeId;

    private String inHandleUid;

    private String outHandleUid;

    private Byte countFeeStatus;

    private String remarks;

    private String carType;

    private Byte carStatus;

    private String visitUnit;

    private Long giveAwayParkTime;

    private Byte carNumberPlateColor;

    private String carBrand;

    private String parkingSpaceNumber;

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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public String getPayTypeId() {
        return payTypeId;
    }

    public void setPayTypeId(String payTypeId) {
        this.payTypeId = payTypeId;
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

    public Byte getCountFeeStatus() {
        return countFeeStatus;
    }

    public void setCountFeeStatus(Byte countFeeStatus) {
        this.countFeeStatus = countFeeStatus;
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
}