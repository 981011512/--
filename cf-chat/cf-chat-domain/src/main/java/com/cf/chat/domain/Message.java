package com.cf.chat.domain;

import com.cf.chat.domain.CfUserMessage;

import java.io.Serializable;

public class Message implements Serializable {
    private String type; // 消息类型(尝试连接/正常发包/心跳等)
    private CfUserMessage cfUserMessage;    // 聊天消息
    private Object ext;  // 扩展消息字段
    private String token;   //创建会话链接时需要传入

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CfUserMessage getCfUserMessage() {
        return cfUserMessage;
    }

    public void setCfUserMessage(CfUserMessage cfUserMessage) {
        this.cfUserMessage = cfUserMessage;
    }

    public Object getExt() {
        return ext;
    }

    public void setExt(Object ext) {
        this.ext = ext;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
