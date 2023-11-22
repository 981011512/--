package com.cf.ucenter.domain;

import java.io.Serializable;

/**
 * 微信用户基本数据
 * {
 *     "openid": "OPENID",
 *     "nickname": "NICKNAME",
 *     "sex": 1,
 *     "province": "PROVINCE",
 *     "city": "CITY",
 *     "country": "COUNTRY",
 *     "headimgurl": "http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/0",
 *     "privilege": ["PRIVILEGE1", "PRIVILEGE2"],
 *     "unionid": " o6_bmasdasdsad6_2sgVt7hMZOPfL"
 * }
 */
public class WxUser implements Serializable {

    private String appid;

    private String openid;

    private String nickname;

    private Integer sex; //1 为男性，2 为女性

    private String province;

    private String city;

    private String country;

    private String headimgurl;

    private String privilege;

    private String unionid;

    private static final long serialVersionUID = 1L;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }
}
