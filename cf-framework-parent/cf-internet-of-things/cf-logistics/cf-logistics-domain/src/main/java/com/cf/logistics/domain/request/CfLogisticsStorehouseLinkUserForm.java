package com.cf.logistics.domain.request;

import java.io.Serializable;

public class CfLogisticsStorehouseLinkUserForm implements Serializable {
    private Long id;

    private Long logisticsStorehouseId;

    private String uid;

    private Byte allowEdit;

    private Byte allowDelete;

    private Byte creater;

    private String checkPointIds;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLogisticsStorehouseId() {
        return logisticsStorehouseId;
    }

    public void setLogisticsStorehouseId(Long logisticsStorehouseId) {
        this.logisticsStorehouseId = logisticsStorehouseId;
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
}