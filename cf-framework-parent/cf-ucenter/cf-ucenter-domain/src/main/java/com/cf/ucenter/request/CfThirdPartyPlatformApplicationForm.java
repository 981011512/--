package com.cf.ucenter.request;

import java.io.Serializable;

public class CfThirdPartyPlatformApplicationForm implements Serializable {
    private String appid;

    private String applicationName;

    private String publicKey;

    private String privateKey;

    private String platform;

    private String authToken;

    private String aesEncryption;

    private String originalId;

    private static final long serialVersionUID = 1L;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName == null ? null : applicationName.trim();
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey == null ? null : publicKey.trim();
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey == null ? null : privateKey.trim();
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getAesEncryption() {
        return aesEncryption;
    }

    public void setAesEncryption(String aesEncryption) {
        this.aesEncryption = aesEncryption;
    }

    public String getOriginalId() {
        return originalId;
    }

    public void setOriginalId(String originalId) {
        this.originalId = originalId;
    }
}