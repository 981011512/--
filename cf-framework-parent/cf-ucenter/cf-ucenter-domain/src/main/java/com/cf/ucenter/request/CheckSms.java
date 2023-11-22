package com.cf.ucenter.request;

import java.io.Serializable;

/**
 * 短信校验实体
 */
public class CheckSms implements Serializable {

    private String phone;

    private String smsCode;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }
}
