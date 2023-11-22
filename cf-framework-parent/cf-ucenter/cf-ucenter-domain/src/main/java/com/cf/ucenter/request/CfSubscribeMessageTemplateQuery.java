package com.cf.ucenter.request;

import java.io.Serializable;

public class CfSubscribeMessageTemplateQuery implements Serializable {
    private Long id;

    private String appid;

    private String messageScenes;

    private String templateId;

    private String templateContents;

    private String templateNotes;

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

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public String getMessageScenes() {
        return messageScenes;
    }

    public void setMessageScenes(String messageScenes) {
        this.messageScenes = messageScenes == null ? null : messageScenes.trim();
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId == null ? null : templateId.trim();
    }

    public String getTemplateContents() {
        return templateContents;
    }

    public void setTemplateContents(String templateContents) {
        this.templateContents = templateContents == null ? null : templateContents.trim();
    }

    public String getTemplateNotes() {
        return templateNotes;
    }

    public void setTemplateNotes(String templateNotes) {
        this.templateNotes = templateNotes == null ? null : templateNotes.trim();
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