package com.cf.ucenter.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class CfUser implements Serializable {
    private String id;

    private String userName;

    private String password;

    private String avatar;

    private Byte type;

    private String nickName;

    private String trueName;

    private String phone;

    private String email;

    private Long birthday;

    private Byte sex;

    private String sign;

    private Long createTime;

    private List<CfRole> cfRoles;

    private BigDecimal score;

    private Long lastLoginTime;

    private Byte idCardStatus;

    private Byte driverLicenseStatus;

    private static final long serialVersionUID = 1L;

    public CfUser() {
    }

    public CfUser(String id, String userName, String password, String avatar, Byte type, String nickName, String trueName, String phone, String email, Long birthday, Byte sex, String sign, Long createTime, List<CfRole> cfRoles, BigDecimal score, Long lastLoginTime) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.avatar = avatar;
        this.type = type;
        this.nickName = nickName;
        this.trueName = trueName;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
        this.sex = sex;
        this.sign = sign;
        this.createTime = createTime;
        this.cfRoles = cfRoles;
        this.score = score;
        this.lastLoginTime = lastLoginTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName == null ? null : trueName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public List<CfRole> getCfRoles() {
        return cfRoles;
    }

    public void setCfRoles(List<CfRole> cfRoles) {
        this.cfRoles = cfRoles;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Byte getIdCardStatus() {
        return idCardStatus;
    }

    public void setIdCardStatus(Byte idCardStatus) {
        this.idCardStatus = idCardStatus;
    }

    public Byte getDriverLicenseStatus() {
        return driverLicenseStatus;
    }

    public void setDriverLicenseStatus(Byte driverLicenseStatus) {
        this.driverLicenseStatus = driverLicenseStatus;
    }
}