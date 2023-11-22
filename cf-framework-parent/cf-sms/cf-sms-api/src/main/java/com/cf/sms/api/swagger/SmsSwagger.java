package com.cf.sms.api.swagger;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.sms.domain.SendSms;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Api(tags = {"短信模块"})
public interface SmsSwagger {
    @ApiOperation(value = "发送短信")
    public ResponseResult sendSms(HttpServletRequest httpServletRequest, SendSms sendSms)throws Exception;
}
