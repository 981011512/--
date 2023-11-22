package com.cf.charging.domain.request;

import java.io.Serializable;

public class CfChargingStationLinkUserQuery implements Serializable {
    private String id;

    private String chargingStationId;

    private String uid;

    private Byte allowEdit;

    private Byte allowDelete;

    private Byte creater;

    private String checkPointIds;

    private Long startDutyTime;

    private Integer page;

    private Integer size;

    private String orderBy;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getChargingStationId() {
        return chargingStationId;
    }

    public void setChargingStationId(String chargingStationId) {
        this.chargingStationId = chargingStationId == null ? null : chargingStationId.trim();
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

    public String getCheckPointIds() {
        return checkPointIds;
    }

    public void setCheckPointIds(String checkPointIds) {
        this.checkPointIds = checkPointIds == null ? null : checkPointIds.trim();
    }

    public Long getStartDutyTime() {
        return startDutyTime;
    }

    public void setStartDutyTime(Long startDutyTime) {
        this.startDutyTime = startDutyTime;
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