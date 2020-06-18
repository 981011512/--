package com.cf.ucenter.admin.controller;

import com.alibaba.fastjson.JSON;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.AuthToken;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.domain.ucenter.request.LoginRequest;
import com.cf.framework.domain.ucenter.response.AuthCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.ucenter.admin.swagger.AuthSwagger;
import com.cf.ucenter.domain.CfAuth;
import com.cf.ucenter.domain.CfUser;
import com.cf.ucenter.domain.CfUserExt;
import com.cf.ucenter.request.CfAuthForm;
import com.cf.ucenter.service.AuthService;
import com.cf.ucenter.service.CfUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * 请在此填写描述
 *
 * @ClassName AuthSwaggerController
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2019/12/10/010 23:10
 * @Version 1.0
 **/
@RestController
@RequestMapping("auth/")
@Validated
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
        CfUserExt cfUserExt = cfUserService.getUserAdministratorByUid(userBasicInfo.getId());
        cfUserExt.setPassword(null);
        return new ResponseResult(CommonCode.SUCCESS, cfUserExt, authToken, 0);
    }

    @PreAuthorize("hasAuthority('ucenter-AuthSwaggerController-getAuths')")
    @Override
    @RequestMapping(value = "getAuths", method = RequestMethod.GET)
    public ResponseResult getAuths(
        @RequestParam(value = "type", required = false)
        @Pattern(regexp = "^(user|role){1}$", message = "暂时只支持user|role两种类型")String type,
    String value) {
        List<CfAuth> cfAuths = null;
        if(value==null || value.equals("")){
            cfAuths = authService.recursiveQuery((byte) 0, null);
        }else{
            cfAuths = type.equals("user")?authService.getAuthsByUid(value):authService.getAuthsByRoleId(value);
        }
        if(cfAuths==null){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfAuths);
    }

    @PreAuthorize("hasAuthority('ucenter-AuthSwaggerController-addAuth')")
    @Override
    @RequestMapping(value = "addAuth", method = RequestMethod.POST)
    public ResponseResult addAuth(CfAuthForm cfAuthForm) {
        CfAuth cfAuth = new CfAuth();
        BeanUtils.copyProperties(cfAuthForm, cfAuth);
        CfAuth cfAuthNew = authService.addAuth(cfAuth);
        return new ResponseResult(CommonCode.SUCCESS, cfAuthNew);
    }

    @PreAuthorize("hasAuthority('ucenter-AuthSwaggerController-updateAuth')")
    @Override
    @RequestMapping(value = "updateAuth", method = RequestMethod.PUT)
    public ResponseResult updateAuth(CfAuthForm cfAuthForm) {
        CfAuth cfAuth = new CfAuth();
        BeanUtils.copyProperties(cfAuthForm, cfAuth);
        CfAuth cfAuthNew = authService.updateAuth(cfAuth);
        return new ResponseResult(CommonCode.SUCCESS, cfAuthNew);
    }

    @PreAuthorize("hasAuthority('ucenter-AuthSwaggerController-deleteAuth')")
    @Override
    @RequestMapping(value = "deleteAuth", method = RequestMethod.DELETE)
    public ResponseResult deleteAuth(String id) {
        Integer integer = authService.deleteAuth(id);
        return new ResponseResult(CommonCode.SUCCESS, integer);
    }
}
