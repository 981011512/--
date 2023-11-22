package com.cf.ucenter.domain;

import java.io.Serializable;

public class CfAccessTokenManage implements Serializable {
    private Long id;

    private String appid;

    private String tokenValue;

    private String applicationScenes;

    private Long expiredTime;

    private String tokenNotes;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue == null ? null : tokenValue.trim();
    }

    public String getApplicationScenes() {
        return applicationScenes;
    }

    public void setApplicationScenes(String applicationScenes) {
        this.applicationScenes = applicationScenes == null ? null : applicationScenes.trim();
    }

    public Long getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Long expiredTime) {
        this.expiredTime = expiredTime;
    }

    public String getTokenNotes() {
        return tokenNotes;
    }

    public void setTokenNotes(String tokenNotes) {
        this.tokenNotes = tokenNotes == null ? null : tokenNotes.trim();
    }
}