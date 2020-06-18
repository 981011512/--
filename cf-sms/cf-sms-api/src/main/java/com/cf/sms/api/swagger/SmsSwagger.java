package com.cf.sms.api.swagger;

import com.cf.framework.domain.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Api(tags = {"短信模块"})
public interface SmsSwagger {
    @ApiOperation(value = "发送短信")
    @ApiImplicitParams({
            @ApiImplicitParam(name="phone",value = "手机号",required=true,paramType="query",dataType="string"),
            @ApiImplicitParam(name="type",value = "业务类型(1-注册/2-身份验证/3-通知)",required=true,paramType="query",dataType="int"),
    })
    public ResponseResult sendSms(
        @Pattern(regexp = "^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))[0-9]{8}$",message = "手机号不合法") String phone,
        @Min(value = 1,message = "业务类型(1-注册/2-身份验证/3-通知)") @Max(value = 3,message = "业务类型(1-注册/2-身份验证/3-通知)") Integer type);
}
