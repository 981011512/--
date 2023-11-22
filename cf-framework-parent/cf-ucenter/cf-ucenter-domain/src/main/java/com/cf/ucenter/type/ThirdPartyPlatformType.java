package com.cf.ucenter.type;

import java.io.Serializable;

/**
 * 第三方登录平台类型
 */
public class ThirdPartyPlatformType implements Serializable {

    public final static String WX_MP = "wx_mp";   //微信小程序
    public final static String WX_WB = "wx_web";   //微信公众号
    public final static String WX_APP = "wx_app";   //微信app
    public final static String TOU_TIAO_MP = "toutiaomp";   //今日头条小程序
    public final static String ALI_WEB = "ali_web";   //支付宝生活号/h5
    public final static String ALI_MP = "ali_mp";   //支付宝小程序
}
