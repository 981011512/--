package com.cf.pay.domain.request;

import java.io.Serializable;

public class CfUserPaymentAgencyForm implements Serializable {
    private String id;

    private String name;

    private String uid;

    private String paymentAgencyShortName;

    private String payKey;

    private String secret;

    private String appid;

    private String accountNumberNote;

    private String mchId;

    private String certPath;

    private String payNotifyUrl;

    private String refundPayNotifyUrl;

    private String useScenes;

    private String subMchId;

    private String subAppid;

    private String authToken;

    private static final long serialVersionUID = 1L;

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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getPaymentAgencyShortName() {
        return paymentAgencyShortName;
    }

    public void setPaymentAgencyShortName(String paymentAgencyShortName) {
        this.paymentAgencyShortName = paymentAgencyShortName == null ? null : paymentAgencyShortName.trim();
    }

    public String getPayKey() {
        return payKey;
    }

    public void setPayKey(String payKey) {
        this.payKey = payKey == null ? null : payKey.trim();
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret == null ? null : secret.trim();
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public String getAccountNumberNote() {
        return accountNumberNote;
    }

    public void setAccountNumberNote(String accountNumberNote) {
        this.accountNumberNote = accountNumberNote == null ? null : accountNumberNote.trim();
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId == null ? null : mchId.trim();
    }

    public String getCertPath() {
        return certPath;
    }

    public void setCertPath(String certPath) {
        this.certPath = certPath == null ? null : certPath.trim();
    }

    public String getPayNotifyUrl() {
        return payNotifyUrl;
    }

    public void setPayNotifyUrl(String payNotifyUrl) {
        this.payNotifyUrl = payNotifyUrl == null ? null : payNotifyUrl.trim();
    }

    public String getRefundPayNotifyUrl() {
        return refundPayNotifyUrl;
    }

    public void setRefundPayNotifyUrl(String refundPayNotifyUrl) {
        this.refundPayNotifyUrl = refundPayNotifyUrl == null ? null : refundPayNotifyUrl.trim();
    }

    public String getUseScenes() {
        return useScenes;
    }

    public void setUseScenes(String useScenes) {
        this.useScenes = useScenes;
    }

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId;
    }

    public String getSubAppid() {
        return subAppid;
    }

    public void setSubAppid(String subAppid) {
        this.subAppid = subAppid;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}