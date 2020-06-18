package com.cf.ucenter.api.swagger;

import com.cf.framework.domain.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javax.validation.constraints.*;

/**
 * 请在此填写描述
 *
 * @ClassName UcenterSwagger
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2019/12/21/021 14:57
 * @Version 1.0
 **/
@Api(tags = {"用户常规业务模块"})
public interface UcenterSwagger {
    @ApiOperation(value = "注册用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="phone",value = "手机号",required=true,paramType="query",dataType="string"),
            @ApiImplicitParam(name="sms_code",value = "短信验证码",required=true,paramType="query",dataType="string"),
            @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "query", dataType = "string"),
            @ApiImplicitParam(name="password",value = "密码",required=true,paramType="query",dataType="string"),
            @ApiImplicitParam(name = "nick_name", value = "昵称", required = true, paramType = "query", dataType = "string")
    })
    public ResponseResult register(
            @Pattern(regexp = "^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))[0-9]{8}$",message = "手机号不合法") String phone,
            @NotEmpty String smsCode,
            @Pattern(regexp = "^[a-zA-Z0-9_]{5,32}$",message = "用户名长度5-32位") String userName,
            @Size(min = 10, max = 32, message = "密码长度10-32位") String password,
            @Size(min = 1, max = 20, message = "昵称长度1-20位") String nickName);

    @ApiOperation(value = "根据手机号/用户id/用户名查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name = "key", value = "搜索关键字", required = true, paramType = "query", dataType = "string")
    })
    public ResponseResult findByKey(
            @Pattern(regexp = "^[a-zA-Z0-9_]{1,64}$", message = "关键字长度1-64位") String key);

    @ApiOperation(value = "根据用户id获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name = "uid", value = "用户id", required = true, paramType = "query", dataType = "string")
    })
    public ResponseResult findById(String uid);

}
