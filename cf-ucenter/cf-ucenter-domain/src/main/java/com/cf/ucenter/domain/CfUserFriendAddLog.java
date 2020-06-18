package com.cf.ucenter.domain;

import java.io.Serializable;

public class CfUserFriendAddLog implements Serializable {
    private String id;

    private String fromUid;

    private String toUid;

    private String groupId;

    private Long createTime;

    private Integer status;

    private String remark;

    private Integer type;

    private String nickName;

    private String avatar;

    private static final long serialVersionUID = 1L;

    public CfUserFriendAddLog() {
    }

    public CfUserFriendAddLog(String id, String fromUid, String toUid, String groupId, Long createTime, Integer status, String remark, Integer type) {
        this.id = id;
        this.fromUid = fromUid;
        this.toUid = toUid;
        this.groupId = groupId;
        this.createTime = createTime;
        this.status = status;
        this.remark = remark;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFromUid() {
        return fromUid;
    }

    public void setFromUid(String fromUid) {
        this.fromUid = fromUid == null ? null : fromUid.trim();
    }

    public String getToUid() {
        return toUid;
    }

    public void setToUid(String toUid) {
        this.toUid = toUid == null ? null : toUid.trim();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}