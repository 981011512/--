package com.cf.sms.service;

import com.cf.framework.domain.response.ResponseResult;

/**
 * 短信
 *
 * @ClassName SmsService
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2019/12/25/025 22:48
 * @Version 1.0
 **/
public interface SmsService {
    /**
     * 发送短信
     * @param phone
     * @param type
     */
    public ResponseResult sendSms(String phone, Integer type);

    /**
     * 检查是否频繁发送
     * @param phone
     * @param type
     */
    public void checkSendFrequently(String phone, Integer type);

    /**
     * 通过阿里云发送短信
     * @param RegionId
     * @param PhoneNumbers
     * @param SignName
     * @param TemplateCode
     * @param TemplateParam
     * @param SmsUpExtendCode
     * @param OutId
     */
    public void sendSmsByAli(String RegionId,String PhoneNumbers,String SignName,String TemplateCode,String TemplateParam,
                             String SmsUpExtendCode,String OutId);

    /**
     * 校验短信验证码
     * @param phone
     * @param code
     * @param type
     */
    public void checkCode(String phone, String code, Integer type);
}
