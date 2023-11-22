package com.cf.ucenter.api.swagger;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.ucenter.domain.CfUser;
import com.cf.ucenter.domain.WxUser;
import com.cf.ucenter.request.CfUserCustomerForm;
import com.cf.ucenter.request.CfWxUserForm;
import com.cf.ucenter.request.CheckSms;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.*;

/**
 * 请在此填写描述
 *
 * @ClassName UcenterSwagger
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/12/21/021 14:57
 * @Version 1.0
 **/
@Api(tags = {"用户常规业务模块"})
public interface UcenterSwagger {
    @ApiOperation(value = "注册用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name="phone",value = "手机号",required=true,paramType="query",dataType="string"),
            @ApiImplicitParam(name="sms_code",value = "短信验证码",required=true,paramType="query",dataType="string"),
            @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "query", dataType = "string"),
            @ApiImplicitParam(name="password",value = "密码",required=true,paramType="query",dataType="string"),
            @ApiImplicitParam(name = "nick_name", value = "昵称", required = true, paramType = "query", dataType = "string")
    })
    public ResponseResult register(
            @Pattern(regexp = "^(1[3-9])[0-9]{9}$",message = "手机号不合法") String phone,
            @NotEmpty String smsCode,
            @Pattern(regexp = "^[a-zA-Z0-9_]{5,32}$",message = "用户名长度5-32位") String userName,
            @Size(min = 10, max = 32, message = "密码长度10-32位") String password,
            @Size(min = 1, max = 20, message = "昵称长度1-20位") String nickName);

    @ApiOperation(value = "根据手机号/用户id/用户名查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name = "key", value = "搜索关键字", required = true, paramType = "query", dataType = "string")
    })
    public ResponseResult findByKey(
            @Pattern(regexp = "^[a-zA-Z0-9_]{1,64}$", message = "关键字长度1-64位") String key);

    @ApiOperation(value = "根据用户id获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name = "uid", value = "用户id", required = false, paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "simpleQuery", value = "是否为简单查询(传yes则只返回用户基本信息)", required = false, paramType = "query", dataType = "string", defaultValue = "yes")
    })
    public ResponseResult findById(String uid, String simpleQuery) throws Exception;

    @ApiOperation(value = "修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name = "password", value = "新密码", required = true, paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "smsCode", value = "当前用户绑定手机收到的验证码", required = true, paramType = "query", dataType = "string")
    })
    public ResponseResult modifyPasswordByPhoneAndCode(String password, String smsCode) throws Exception;

    @ApiOperation(value = "找回密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name = "password", value = "新密码", required = true, paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "phone", value = "手机号", required = true, paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "smsCode", value = "短信验证码", required = true, paramType = "query", dataType = "string")
    })
    public ResponseResult recoverPasswordByPhoneAndCode(String phone, String password, String smsCode);

    @ApiOperation(value = "用户基本资料更新(昵称/头像/性别等)")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult customerBaseUpdate(CfUserCustomerForm cfUserCustomerForm) throws Exception;

    @ApiOperation(value = "根据传入的微信unionid和相关用户信息进行用户(创建/更新)等操作")
    ResponseResult updateCustomerByWxUser(CfWxUserForm cfWxUserForm) throws Exception;

    @ApiOperation(value = "根据unionid和apiToekn获取用户信息(不存在则新增)")
    ResponseResult getUserInfoByUnionIdAndApiToken(CfWxUserForm cfWxUserForm);

    @ApiOperation(value = "绑定手机号")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult bindPhone(CheckSms checkSms) throws Exception;

    @ApiOperation(value = "获取用户客户端ip")
    @ApiImplicitParams({
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult getClientIp(HttpServletRequest request) throws Exception;

}
