package com.cf.sms.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 发送短信请求实体
 */
public class SendSms implements Serializable {

    @ApiModelProperty(value = "图片", required = true)
    @Pattern(regexp = "^(1[3-9])[0-9]{9}$", message = "手机号不合法")
    private String phone;
    @ApiModelProperty(value = "短信类型(1-注册/2-身份验证/3-通知)", required = true)
    @Min(value = 1, message = "最小值1")
    @Max(value = 3, message = "最大值3")
    private Integer type;
    @ApiModelProperty(value = "腾讯滑动验证票据", required = true)
    private String ticket;
    @Pattern(regexp = "^(web|wxmin){1}$", message = "web-网页或app/wxmin-微信小程序")
    private String platform;
    @ApiModelProperty(value = "随机字符串", required = false)
    private String randstr;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getRandstr() {
        return randstr;
    }

    public void setRandstr(String randstr) {
        this.randstr = randstr;
    }
}
