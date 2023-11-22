package com.cf.ucenter.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 本实体主要是针对第三方系统想通过微信用户体系来与本系统做用户体系互通
 */
public class CfWxUserForm implements Serializable {

    @ApiModelProperty(value = "签名类型（请传入 HMACSHA256 或 MD5 ）", required = false)
    private String signType;
    @ApiModelProperty(value = "请求数据校验签名(参考微信签名，特别注意：参与校验的数据 key和value 自己要转为字符串类型再进行签名)", required = false)
    private String dataSign;
    @ApiModelProperty(value = "微信用户unionid", required = true)
    private String unionid;
    @ApiModelProperty(value = "本提系统提供给第三方平台调用的密钥", required = true)
    private String token;
    @ApiModelProperty(value = "用户id(本系统会随机生成)", required = false)
    private String id;
    @ApiModelProperty(value = "用户名(本系统会随机生成)", required = false)
    private String userName;
    @ApiModelProperty(value = "用户密码(提供则录入，否则本系统随机生成)", required = false)
    private String password;
    @ApiModelProperty(value = "用户头像(提供则录入，否则本系统随机生成)", required = false)
    private String avatar;
    @ApiModelProperty(value = "用户类型(默认0)", required = false)
    private Integer type;
    @ApiModelProperty(value = "用户昵称(提供则录入，否则本系统随机生成)", required = false)
    private String nickName;
    @ApiModelProperty(value = "用户真实姓名(提供则录入，否则本系统随机生成)", required = false)
    private String trueName;
    @ApiModelProperty(value = "用户出生日期时间戳(单位毫秒)", required = false)
    private Long birthday;
    @ApiModelProperty(value = "用户性别(默认0，0-保密/1-男/2-女)", required = false)
    private Integer sex;
    @ApiModelProperty(value = "用户个性签名(提供则录入，否则本系统随机生成)", required = false)
    private String sign;
    @ApiModelProperty(value = "创建时间(本系统会自动采用当前时间戳)", required = false)
    private Long createTime;
    @ApiModelProperty(value = "用户手机号(提供则录入，否则本系统默认为空)", required = false)
    @Pattern(regexp = "^(1[3-9])[0-9]{9}$", message = "手机号不合法")
    private String phone;
    @ApiModelProperty(value = "用户邮箱(提供则录入，否则本系统默认为空)", required = false)
    private String email;
    @ApiModelProperty(value = "变动积分值(范围1-10000)", required = false)
    @Min(value = 0, message = "积分变动值最小值必须>=0")
    @Max(value = 10000, message = "积分变动值最大值必须小于10000")
    private BigDecimal score;
    @ApiModelProperty(value = "积分操作类型(-1表示减积分操作,0表示将传入的值将直接为该用户账户积分余额,1表示增加积分操作)", required = false)
    @Min(value = -1, message = "操作类型最小值必须>=-1")
    @Max(value = 1, message = "操作类型最大值必须<=1")
    private Byte scoreAction;
    @ApiModelProperty(value = "积分类型，默认为common_use通用积分", required = false)
    private String scoreType;

    @ApiModelProperty(value = "平台(wx_mp-微信小程序/wx_wb-微信公众号/wx_app-微信app/toutiao-今日头条)", required = true)
    @Pattern(regexp = "[wx_mp|wx_wb|wx_app|toutiao]", message = "平台(wx_mp-微信小程序/wx_wb-微信公众号/wx_app-微信app/toutiao-今日头条)")
    private String platform;

    @ApiModelProperty(value = "优惠券面额", required = false)
    @Min(value = 0, message = "优惠券面额最小值为0")
    private BigDecimal couponDenomination;

    @ApiModelProperty(value = "优惠券类型(1-次数券/2-金额券/3-时长券)", required = false)
    @Pattern(regexp = "^[1-3]$", message = "优惠券类型(1-次数券/2-金额券/3-时长券)")
    private Byte couponType;

    @ApiModelProperty(value = "优惠券使用场景(0-通用/1-停车场/2-传统商城)", required = false)
    @Pattern(regexp = "^[0-9]{1}$", message = "优惠券使用场景(0-通用/1-停车场/2-传统商城)")
    private Byte couponScenes;

    @ApiModelProperty(value = "停车场id串/店铺id串", required = false)
    @Pattern(regexp = "^([\\,]{0,1}[a-zA-Z0-9_\\.\\*\\s]{1,}[\\,]{0,1}){0,1}$", message = "提供停车场id串/店铺id串格式不合法")
    private String shopIds;

    @ApiModelProperty(value = "优惠券生效时间(开始时间,单位毫秒)", required = false)
    @Min(value = 0, message = "优惠券生效时间最小值为0")
    private Long effectiveTime;

    @ApiModelProperty(value = "优惠券失效时间(结束时间,单位毫秒)", required = false)
    @Min(value = 0, message = "优惠券失效时间最小值为0")
    private Long expireTime;

    @ApiModelProperty(value = "账单", required = false)
    private OrderForm orderForm;

    @ApiModelProperty(value = "应用appid（例如小程序appid）", required = true)
    private String appId;

    private static final long serialVersionUID = 1L;

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Byte getScoreAction() {
        return scoreAction;
    }

    public void setScoreAction(Byte scoreAction) {
        this.scoreAction = scoreAction;
    }

    public String getScoreType() {
        return scoreType;
    }

    public void setScoreType(String scoreType) {
        this.scoreType = scoreType;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public BigDecimal getCouponDenomination() {
        return couponDenomination;
    }

    public void setCouponDenomination(BigDecimal couponDenomination) {
        this.couponDenomination = couponDenomination;
    }

    public Byte getCouponType() {
        return couponType;
    }

    public void setCouponType(Byte couponType) {
        this.couponType = couponType;
    }

    public Byte getCouponScenes() {
        return couponScenes;
    }

    public void setCouponScenes(Byte couponScenes) {
        this.couponScenes = couponScenes;
    }

    public String getShopIds() {
        return shopIds;
    }

    public void setShopIds(String shopIds) {
        this.shopIds = shopIds;
    }

    public Long getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Long effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public OrderForm getOrderForm() {
        return orderForm;
    }

    public void setOrderForm(OrderForm orderForm) {
        this.orderForm = orderForm;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getDataSign() {
        return dataSign;
    }

    public void setDataSign(String dataSign) {
        this.dataSign = dataSign;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}