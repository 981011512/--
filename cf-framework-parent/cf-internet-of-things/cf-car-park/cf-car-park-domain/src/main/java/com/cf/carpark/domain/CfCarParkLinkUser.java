package com.cf.carpark.domain;

import com.cf.ucenter.domain.CfUser;

import java.io.Serializable;

public class CfCarParkLinkUser implements Serializable {
    private String id;

    private String carParkId;

    private String uid;

    private Byte allowEdit;

    private Byte allowDelete;

    private Byte creater;

    private CfUser cfUser;

    private CfCarPark cfCarPark;

    private String checkPointIds;

    private Long startDutyTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCarParkId() {
        return carParkId;
    }

    public void setCarParkId(String carParkId) {
        this.carParkId = carParkId == null ? null : carParkId.trim();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public Byte getAllowEdit() {
        return allowEdit;
    }

    public void setAllowEdit(Byte allowEdit) {
        this.allowEdit = allowEdit;
    }

    public Byte getAllowDelete() {
        return allowDelete;
    }

    public void setAllowDelete(Byte allowDelete) {
        this.allowDelete = allowDelete;
    }

    public Byte getCreater() {
        return creater;
    }

    public void setCreater(Byte creater) {
        this.creater = creater;
    }

    public CfUser getCfUser() {
        return cfUser;
    }

    public void setCfUser(CfUser cfUser) {
        this.cfUser = cfUser;
    }

    public CfCarPark getCfCarPark() {
        return cfCarPark;
    }

    public void setCfCarPark(CfCarPark cfCarPark) {
        this.cfCarPark = cfCarPark;
    }

    public String getCheckPointIds() {
        return checkPointIds;
    }

    public void setCheckPointIds(String checkPointIds) {
        this.checkPointIds = checkPointIds;
    }

    public Long getStartDutyTime() {
        return startDutyTime;
    }

    public void setStartDutyTime(Long startDutyTime) {
        this.startDutyTime = startDutyTime;
    }
}