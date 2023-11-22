package com.cf.ucenter.api.swagger;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.request.LoginRequest;
import com.cf.pay.domain.request.CfAccountQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.Pattern;

/**
 * 请在此填写描述
 *
 * @ClassName AuthSwagger
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/12/10/010 23:06
 * @Version 1.0
 **/
@Api(tags = {"用户授权与验证模块"})
public interface AuthSwagger {
    @ApiOperation("登录")
    public ResponseResult login(LoginRequest loginRequest) throws Exception;

    @ApiOperation(value = "手机登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult loginByPhone(@RequestBody LoginRequest loginRequest) throws Exception;

    @ApiOperation("退出登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="type",value = "方式(all-当前用户所有客户端都退出登录/current-只退出当前客户端)",required=true,paramType="query",dataType="string")
    })
    public ResponseResult logout(String type) throws Exception;

    @ApiOperation("微信登录")
    @ApiImplicitParams({
    })
    public ModelAndView wxLogin() throws Exception;

    @ApiOperation("网页根据微信code码获取微信用户基本用户数据信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "微信code码", required = true, paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "appid", value = "微信公众号appid", required = false, paramType = "query", dataType = "string")
    })
    public ModelAndView getWxBaseUserInfoByCode(String code, String appid) throws Exception;

    @ApiOperation("生成跳转到微信小程序的数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name = "url", value = "要跳转的地址", required = true, paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "appid", value = "如果不是系统默认的appid，请在此提供appid，会调取cf_third_party_platform_application数据库表的数据", required = false, paramType = "query", dataType = "string")
    })
    public ResponseResult createJumpToWxMinData(String url, String appid) throws Exception;

    @ApiOperation("网页根据支付宝code码获取微信用户基本用户数据信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "auth_code", value = "支付宝code码", required = true, paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "appid", value = "如果不是系统默认的appid，请在此提供appid，会调取cf_third_party_platform_application数据库表的数据", required = false, paramType = "query", dataType = "string")
    })
    public ModelAndView getAliBaseUserInfoByCode(String auth_code, String appid) throws Exception;

    @ApiOperation("小程序根据支付宝code码获取用户基本用户数据信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "auth_code", value = "支付宝code码", required = true, paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "appid", value = "如果不是系统默认的appid，请在此提供appid，会调取cf_third_party_platform_application数据库表的数据", required = false, paramType = "query", dataType = "string")
    })
    public ResponseResult getAliMinBaseUserInfoByCode(String auth_code, String appid) throws Exception;

    @ApiOperation("根据微信code码获取微信用户基本用户数据信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "微信code码", required = true, paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "loginType", value = "登录方式(mp-小程序|app-手机应用)\")", required = true, paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "encryptedData", value = "为小程序登录时请提供", required = false, paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "iv", value = "为小程序登录时请提供", required = false, paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "url", value = "回调地址，如果不给使用系统配置", required = false, paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "appid", value = "如果不是系统默认的appid，请在此提供appid，会调取cf_third_party_platform_application数据库表的数据", required = false, paramType = "query", dataType = "string")
    })
    public ResponseResult getWxBaseUserInfoByCodeAndLoginType(String code,@Pattern(regexp = "^[mp|app]$", message = "请提供登录方式(mp-小程序|app-手机应用)") String loginType, String encryptedData, String iv, String url, String appid) throws Exception;

    @ApiOperation("获取用户手机号，成功获取后会更新用户手机号")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name = "code", value = "code码", required = true, paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "loginType", value = "登录方式(wx_mp-小程序|ali_mp-支付宝小程序))", required = true, paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "encryptedData", value = "通过解密获取手机号时请提供", required = false, paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "iv", value = "通过解密获取手机号时请提供", required = false, paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "appid", value = "非系统默认小程序时需要传入appid", required = false, paramType = "query", dataType = "string")
    })
    public ResponseResult getUserPhonenumberByCodeAndLoginType(
            String code,
            @Pattern(regexp = "^[wx_mp|ali_mp]$", message = "请提供登录方式(wx_mp-小程序|ali_mp-支付宝小程序)") String loginType,
            String encryptedData, String iv, String appid
    ) throws Exception;

    @ApiOperation("获取指定用户的账户")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string")
    })
    public ResponseResult getUserAccount(CfAccountQuery cfAccountQuery) throws Exception;
}
