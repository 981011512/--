package com.cf.ucenter.domain;

import java.io.Serializable;

public class CfUserGroupMember implements Serializable {
    private String id;

    private String groupId;

    private String uid;

    private Integer level;

    private String nickName;

    private Integer joinType;

    private Long joinTime;

    private Integer status;

    private Long mutedDeadline;

    private static final long serialVersionUID = 1L;

    public CfUserGroupMember() {
    }

    public CfUserGroupMember(String id, String groupId, String uid, Integer level, String nickName, Integer joinType, Long joinTime, Integer status, Long mutedDeadline) {
        this.id = id;
        this.groupId = groupId;
        this.uid = uid;
        this.level = level;
        this.nickName = nickName;
        this.joinType = joinType;
        this.joinTime = joinTime;
        this.status = status;
        this.mutedDeadline = mutedDeadline;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Integer getJoinType() {
        return joinType;
    }

    public void setJoinType(Integer joinType) {
        this.joinType = joinType;
    }

    public Long getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Long joinTime) {
        this.joinTime = joinTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getMutedDeadline() {
        return mutedDeadline;
    }

    public void setMutedDeadline(Long mutedDeadline) {
        this.mutedDeadline = mutedDeadline;
    }
}