package com.cf.ucenter.request;

import com.cf.ucenter.domain.CfRole;

import java.io.Serializable;
import java.util.List;

public class CfUserQuery implements Serializable {
    private String id;

    private String userName;

    private String password;

    private String avatar;

    private Byte type;

    private String nickName;

    private String trueName;

    private Long birthday;

    private Integer sex;

    private String sign;

    private Long createTime;

    private String phone;

    private String email;

    private Byte idCardStatus;

    private Byte driverLicenseStatus;

    private List<CfRole> cfRoles;

    private static final long serialVersionUID = 1L;

    private Integer page;

    private Integer size;

    private String orderBy;

    public CfUserQuery() {
    }

    public String getId() {
        return id;
    }

    public CfUserQuery(String id, String userName, String password, String avatar, Byte type, String nickName, String trueName, Long birthday, Integer sex, String sign, Long createTime, String phone, String email) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.avatar = avatar;
        this.type = type;
        this.nickName = nickName;
        this.trueName = trueName;
        this.birthday = birthday;
        this.sex = sex;
        this.sign = sign;
        this.createTime = createTime;
        this.phone = phone;
        this.email = email;
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

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<CfRole> getCfRoles() {
        return cfRoles;
    }

    public void setCfRoles(List<CfRole> cfRoles) {
        this.cfRoles = cfRoles;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}