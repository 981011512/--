package com.cf.sms.service;

import com.cf.framework.domain.response.ResponseResult;

/**
 * 短信
 *
 * @ClassName SmsService
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/12/25/025 22:48
 * @Version 1.0
 **/
public interface SmsService {
    /**
     * 发送短信
     * @param phone
     * @param type
     */
    public void sendSms(String phone, Integer type);

    /**
     * 检查是否频繁发送
     * @param phone
     * @param type
     */
    public void checkSendFrequently(String phone, Integer type);

    /**
     * 通过阿里云发送短信
     * @param PhoneNumbers
     * @param TemplateParam
     * @param signName
     * @param templateCode
     * @param regionId
     * @param accessKeyId
     * @param secret
     * @param SmsUpExtendCode
     * @param OutId
     */
    public void sendSmsByAli(String PhoneNumbers, String TemplateParam, String signName, String templateCode, String regionId, String accessKeyId, String secret, String SmsUpExtendCode, String OutId);

    /**
     * 校验短信验证码
     * @param phone
     * @param code
     * @param type
     */
    public void checkCode(String phone, String code, Integer type);

    /**
     * 校验腾讯图形验证码(微信小程序专用)
     * @param ip
     * @param ticket
     * @param platform
     * @param randstr
     */
    void checkTencentMpCaptcha(String ip, String ticket, String platform, String randstr) throws Exception;
}
