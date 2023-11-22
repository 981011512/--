package com.cf.ucenter.request;

import java.io.Serializable;

public class CfThirdPartySystemCallKeysQuery implements Serializable {
    private Long keyId;

    private String useScenes;

    private String keyValue;

    private Long startTime;

    private Long endTime;

    private String companyName;

    private String keyNotes;

    private Integer page;

    private Integer size;

    private String orderBy;

    private static final long serialVersionUID = 1L;

    public Long getKeyId() {
        return keyId;
    }

    public void setKeyId(Long keyId) {
        this.keyId = keyId;
    }

    public String getUseScenes() {
        return useScenes;
    }

    public void setUseScenes(String useScenes) {
        this.useScenes = useScenes == null ? null : useScenes.trim();
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue == null ? null : keyValue.trim();
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getKeyNotes() {
        return keyNotes;
    }

    public void setKeyNotes(String keyNotes) {
        this.keyNotes = keyNotes == null ? null : keyNotes.trim();
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