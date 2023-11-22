package com.cf.sms.api.controller;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.utils.HttpClient;
import com.cf.sms.api.swagger.SmsSwagger;
import com.cf.sms.domain.SendSms;
import com.cf.sms.service.SmsService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@RestController
@RequestMapping("sms/")
@Validated
public class SmsController implements SmsSwagger {
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private SmsService smsService;

    @Override
    @RequestMapping(value = "sendSms", method = RequestMethod.POST)
    public ResponseResult sendSms(HttpServletRequest httpServletRequest, @RequestBody @Validated SendSms sendSms)throws Exception {
        smsService.checkTencentMpCaptcha(HttpClient.getIPAddress(httpServletRequest), sendSms.getTicket(), sendSms.getPlatform(), sendSms.getRandstr());
        smsService.sendSms(sendSms.getPhone(),sendSms.getType());
        return new ResponseResult(CommonCode.SUCCESS);
    }
}
