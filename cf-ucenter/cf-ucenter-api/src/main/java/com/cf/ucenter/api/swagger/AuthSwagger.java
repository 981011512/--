package com.cf.ucenter.api.swagger;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.request.LoginRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 请在此填写描述
 *
 * @ClassName AuthSwagger
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2019/12/10/010 23:06
 * @Version 1.0
 **/
@Api(tags = {"用户授权与验证模块"})
public interface AuthSwagger {
    @ApiOperation("登录")
    public ResponseResult login(LoginRequest loginRequest);
}
