package com.cf.logistics.domain.request;

import java.io.Serializable;

public class CfLogisticsVehicleForm implements Serializable {
    
    private Long id;

    private String numberPlate;

    private String vehicleOwner;

    private String vehicleType;

    private String vehicleVin;

    private String vehicleSize;

    private Integer approvedLoad;

    private Byte numberPlateColor;

    private String roadTransportCertificateNumber;

    private String operatingLicenseNumber;

    private String uid;

    private String actionUid;

    private Long createTime;

    private Long updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate == null ? null : numberPlate.trim();
    }

    public String getVehicleOwner() {
        return vehicleOwner;
    }

    public void setVehicleOwner(String vehicleOwner) {
        this.vehicleOwner = vehicleOwner == null ? null : vehicleOwner.trim();
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType == null ? null : vehicleType.trim();
    }

    public String getVehicleVin() {
        return vehicleVin;
    }

    public void setVehicleVin(String vehicleVin) {
        this.vehicleVin = vehicleVin == null ? null : vehicleVin.trim();
    }

    public String getVehicleSize() {
        return vehicleSize;
    }

    public void setVehicleSize(String vehicleSize) {
        this.vehicleSize = vehicleSize;
    }

    public Integer getApprovedLoad() {
        return approvedLoad;
    }

    public void setApprovedLoad(Integer approvedLoad) {
        this.approvedLoad = approvedLoad;
    }

    public Byte getNumberPlateColor() {
        return numberPlateColor;
    }

    public void setNumberPlateColor(Byte numberPlateColor) {
        this.numberPlateColor = numberPlateColor;
    }

    public String getRoadTransportCertificateNumber() {
        return roadTransportCertificateNumber;
    }

    public void setRoadTransportCertificateNumber(String roadTransportCertificateNumber) {
        this.roadTransportCertificateNumber = roadTransportCertificateNumber == null ? null : roadTransportCertificateNumber.trim();
    }

    public String getOperatingLicenseNumber() {
        return operatingLicenseNumber;
    }

    public void setOperatingLicenseNumber(String operatingLicenseNumber) {
        this.operatingLicenseNumber = operatingLicenseNumber == null ? null : operatingLicenseNumber.trim();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getActionUid() {
        return actionUid;
    }

    public void setActionUid(String actionUid) {
        this.actionUid = actionUid == null ? null : actionUid.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}