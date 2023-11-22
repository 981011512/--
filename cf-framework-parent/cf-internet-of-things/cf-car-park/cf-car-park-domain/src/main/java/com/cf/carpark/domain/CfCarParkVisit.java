package com.cf.carpark.domain;

import com.cf.ucenter.domain.CfUser;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

public class CfCarParkVisit implements Serializable {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long carParkId;

    private String plateNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long fromUid;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long toUid;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long processUid;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long processTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long carParkUseLogId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long visitTime;

    private Byte processStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long expirationTime;

    private String destination;

    private String reason;

    private CfCarPark cfCarPark;

    private CfUser fromUser;

    private CfUser toUser;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCarParkId() {
        return carParkId;
    }

    public void setCarParkId(Long carParkId) {
        this.carParkId = carParkId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber == null ? null : plateNumber.trim();
    }

    public Long getFromUid() {
        return fromUid;
    }

    public void setFromUid(Long fromUid) {
        this.fromUid = fromUid;
    }

    public Long getToUid() {
        return toUid;
    }

    public void setToUid(Long toUid) {
        this.toUid = toUid;
    }

    public Long getProcessUid() {
        return processUid;
    }

    public void setProcessUid(Long processUid) {
        this.processUid = processUid;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getProcessTime() {
        return processTime;
    }

    public void setProcessTime(Long processTime) {
        this.processTime = processTime;
    }

    public Long getCarParkUseLogId() {
        return carParkUseLogId;
    }

    public void setCarParkUseLogId(Long carParkUseLogId) {
        this.carParkUseLogId = carParkUseLogId;
    }

    public Long getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Long visitTime) {
        this.visitTime = visitTime;
    }

    public Byte getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(Byte processStatus) {
        this.processStatus = processStatus;
    }

    public Long getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Long expirationTime) {
        this.expirationTime = expirationTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public CfCarPark getCfCarPark() {
        return cfCarPark;
    }

    public void setCfCarPark(CfCarPark cfCarPark) {
        this.cfCarPark = cfCarPark;
    }

    public CfUser getFromUser() {
        return fromUser;
    }

    public void setFromUser(CfUser fromUser) {
        this.fromUser = fromUser;
    }

    public CfUser getToUser() {
        return toUser;
    }

    public void setToUser(CfUser toUser) {
        this.toUser = toUser;
    }
}