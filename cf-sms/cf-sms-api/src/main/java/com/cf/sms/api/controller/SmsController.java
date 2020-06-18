package com.cf.sms.api.controller;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.sms.api.swagger.SmsSwagger;
import com.cf.sms.service.SmsService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@RestController
@RequestMapping("sms/")
@Validated
public class SmsController implements SmsSwagger {
    @Reference(version = "1.0.0", retries = 0, timeout = 10000)
    private SmsService smsService;

    @Override
    @RequestMapping(value = "sendSms", method = RequestMethod.POST)
    public ResponseResult sendSms(
        @Pattern(regexp = "^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))[0-9]{8}$", message = "手机号不合法") String phone,
        @Min(value = 1, message = "业务类型(1-注册/2-身份验证/3-通知)") @Max(value = 3, message = "业务类型(1-注册/2-身份验证/3-通知)") Integer type) {
        return smsService.sendSms(phone,type);
    }
}
