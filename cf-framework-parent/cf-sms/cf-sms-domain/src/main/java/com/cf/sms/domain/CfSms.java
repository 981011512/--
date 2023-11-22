package com.cf.sms.domain;

import java.io.Serializable;

public class CfSms implements Serializable {

    final public static Integer SMS_TYPE_REGISTER = 1;
    final public static Integer SMS_TYPE_IDENTITY = 2;
    final public static Integer SMS_TYPE_NOTICE = 3;
    final public static Long SMS_SEND_FREQUENTLY_LIMIT_TIME = 60000L;  //短信发送间隔时间(限制频繁发送)
    final public static Long SMS_CODE_VALID_TIME = 300000L;  //短信验证码有效时间

    private String id;

    private String phone;

    private String code;

    private Integer type;

    private Integer status;

    private Long createTime;

    private Long expireTime;

    private static final long serialVersionUID = 1L;

    public CfSms() {
    }

    public CfSms(String id, String phone, String code, Integer type, Integer status, Long createTime, Long expireTime) {
        this.id = id;
        this.phone = phone;
        this.code = code;
        this.type = type;
        this.status = status;
        this.createTime = createTime;
        this.expireTime = expireTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }
}