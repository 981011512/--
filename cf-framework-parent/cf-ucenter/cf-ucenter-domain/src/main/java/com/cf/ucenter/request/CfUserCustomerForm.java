package com.cf.ucenter.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class CfUserCustomerForm implements Serializable {
    private String id;

    @ApiModelProperty(value = "用户名", required = false)
    private String userName;
    @ApiModelProperty(value = "头像", required = false)
    private String avatar;

    private Integer type;
    @ApiModelProperty(value = "昵称", required = false)
    private String nickName;

    private String trueName;

    private Long birthday;

    @ApiModelProperty(value = "性别(0-保密/1-男/2-女)", example = "true", required = false, allowableValues = "0,1,2")
    @Min(value = 0, message = "性别值最小0")
    @Max(value = 2, message = "性别值最大2")
    private Integer sex;
    @ApiModelProperty(value = "个性签名", required = false)
    private String sign;

    @ApiModelProperty(value = "手机号", example = "true", required = false)
    @Pattern(regexp = "^(1[3-9])[0-9]{9}$", message = "手机号不合法")
    private String phone;
    @ApiModelProperty(value = "邮箱", example = "true", required = false)
    @Email(message = "邮箱格式不正确")
    private String email;

    private static final long serialVersionUID = 1L;

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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
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
}