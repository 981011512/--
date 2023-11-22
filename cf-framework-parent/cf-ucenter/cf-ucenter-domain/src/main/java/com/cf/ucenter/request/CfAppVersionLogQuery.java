package com.cf.ucenter.request;

import java.io.Serializable;

public class CfAppVersionLogQuery implements Serializable {
    private String id;

    private String platform;

    private String versionNumber;

    private Byte level;

    private Byte minLevel;

    private Byte maxLevel;

    private String note;

    private Long minPublishTime;

    private Long maxPublishTime;

    private String url;

    private String orderBy;

    private Integer page;

    private Integer size;

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
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

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    public String getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber == null ? null : versionNumber.trim();
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Byte getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(Byte minLevel) {
        this.minLevel = minLevel;
    }

    public Byte getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(Byte maxLevel) {
        this.maxLevel = maxLevel;
    }

    public Long getMinPublishTime() {
        return minPublishTime;
    }

    public void setMinPublishTime(Long minPublishTime) {
        this.minPublishTime = minPublishTime;
    }

    public Long getMaxPublishTime() {
        return maxPublishTime;
    }

    public void setMaxPublishTime(Long maxPublishTime) {
        this.maxPublishTime = maxPublishTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}