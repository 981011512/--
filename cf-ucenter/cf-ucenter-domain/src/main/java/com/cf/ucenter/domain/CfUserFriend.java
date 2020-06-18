package com.cf.ucenter.domain;

import java.io.Serializable;

public class CfUserFriend implements Serializable {
    private String id;

    private String uid;

    private String friendId;

    private Long createTime;

    public CfUserFriend() {
    }

    public CfUserFriend(String id, String uid, String friendId, Long createTime) {
        this.id = id;
        this.uid = uid;
        this.friendId = friendId;
        this.createTime = createTime;
    }

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId == null ? null : friendId.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}