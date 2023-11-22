package com.cf.carpark.admin.swagger;

import com.cf.carpark.domain.request.CfCarParkCarTypeForm;
import com.cf.framework.domain.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 请在此填写描述
 *
 * @ClassName CfCarParkLoginSwagger
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2021/5/23/023 21:59
 * @Version 1.0
 **/
@Api(tags = {"停车场登录"})
public interface CfCarParkLoginSwagger {

    @ApiOperation(value = "登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="username",value = "用户名",required=true,paramType="query",dataType="string"),
            @ApiImplicitParam(name="password",value = "密码",required=true,paramType="query",dataType="string"),
            @ApiImplicitParam(name="code",value = "验证码",required=false,paramType="query",dataType="string")
    })
    public ResponseResult login(String username, String password, String code) throws Exception;

    @ApiOperation(value = "退出")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="type",value = "方式(all-当前用户所有客户端都退出登录/current-只退出当前客户端)",required=false,paramType="query",dataType="string")
    })
    public ResponseResult logout(String type) throws Exception;
}
