package com.cf.logistics.domain.request;

import java.io.Serializable;

public class CfLogisticsStorehouseLinkUserQuery implements Serializable {
    private Long id;

    private Long nid;   //这个字段有值会导致查询条件会有  id!=nid

    private Long logisticsStorehouseId;

    private String uid;

    private Byte allowEdit;

    private Byte allowDelete;

    private Byte creater;

    private String checkPointIds;

    private Integer page;

    private Integer size;

    private String orderBy;

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

    public Long getNid() {
        return nid;
    }

    public void setNid(Long nid) {
        this.nid = nid;
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