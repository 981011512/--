package com.cf.ucenter.domain;

import java.io.Serializable;

public class CfUserGroup implements Serializable {
    private String id;

    private String name;

    private String avatar;

    private Short people;

    private Short peopleCap;

    private Byte level;

    private Byte status;

    private String createrId;

    private Long createTime;

    private String announcement;

    private static final long serialVersionUID = 1L;

    public CfUserGroup() {
    }

    public CfUserGroup(String id, String name, String avatar, Short people, Short peopleCap, Byte level, Byte status, String createrId, Long createTime, String announcement) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.people = people;
        this.peopleCap = peopleCap;
        this.level = level;
        this.status = status;
        this.createrId = createrId;
        this.createTime = createTime;
        this.announcement = announcement;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public Short getPeople() {
        return people;
    }

    public void setPeople(Short people) {
        this.people = people;
    }

    public Short getPeopleCap() {
        return peopleCap;
    }

    public void setPeopleCap(Short peopleCap) {
        this.peopleCap = peopleCap;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getCreaterId() {
        return createrId;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId == null ? null : createrId.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement == null ? null : announcement.trim();
    }
}