package com.cf.ucenter.api.controller;

import com.alibaba.fastjson.JSON;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.AuthToken;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.domain.ucenter.request.LoginRequest;
import com.cf.framework.domain.ucenter.response.AuthCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.ucenter.api.swagger.AuthSwagger;
import com.cf.ucenter.service.AuthService;
import com.cf.ucenter.domain.CfUser;
import com.cf.ucenter.service.CfUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 请在此填写描述
 *
 * @ClassName AuthSwaggerController
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2019/12/10/010 23:10
 * @Version 1.0
 **/
@RestController
@RequestMapping("/")
public class AuthSwaggerController implements AuthSwagger {

    @Value("${auth.clientId}")
    String clientId;
    @Value("${auth.clientSecret}")
    String clientSecret;
    @Value("${auth.cookieDomain}")
    String cookieDomain;
    @Value("${auth.cookieMaxAge}")
    int cookieMaxAge;

    @Reference(version = "1.0.0", retries = 0, timeout = 10000)
    private AuthService authService;

    @Reference(version = "1.0.0", retries = 0, timeout = 10000)
    private CfUserService cfUserService;

    @Override
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseResult login(LoginRequest loginRequest) {
        if(loginRequest==null || StringUtils.isEmpty(loginRequest.getUsername())){
            ExceptionCast.cast(AuthCode.AUTH_USERNAME_NONE);
        }
        if(StringUtils.isEmpty(loginRequest.getPassword())){
            ExceptionCast.cast(AuthCode.AUTH_PASSWORD_NONE);
        }
        AuthToken authToken = authService.login(loginRequest.getUsername(), loginRequest.getPassword(), clientId, clientSecret);
        UserBasicInfo userBasicInfo = JSON.parseObject(authService.checkJwtToken(authToken.getJwt_token()), UserBasicInfo.class);
        CfUser cfUser = cfUserService.getUserByUid(userBasicInfo.getId(), true);
        cfUser.setPassword(null);
        return new ResponseResult(CommonCode.SUCCESS, cfUser, authToken, 0);
    }
}
