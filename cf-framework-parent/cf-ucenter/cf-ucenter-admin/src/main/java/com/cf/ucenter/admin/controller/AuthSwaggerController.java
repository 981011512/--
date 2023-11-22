package com.cf.ucenter.admin.controller;

//import com.cf.carpark.service.CfCarParkCheckpointService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.AuthToken;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.domain.ucenter.request.LoginRequest;
import com.cf.framework.domain.ucenter.response.AuthCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.ucenter.admin.config.AuthenticationInterceptor;
import com.cf.ucenter.admin.swagger.AuthSwagger;
import com.cf.ucenter.domain.CfAuth;
import com.cf.ucenter.domain.CfUserExt;
import com.cf.ucenter.request.CfAuthForm;
import com.cf.ucenter.service.AuthService;
import com.cf.ucenter.service.CfUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * 请在此填写描述
 *
 * @ClassName AuthSwaggerController
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/12/10/010 23:10
 * @Version 1.0
 **/
@RestController
@RequestMapping("authAdmin/")
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
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    protected HttpServletRequest request;

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private AuthService authService;

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfUserService cfUserService;
//    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
//    private CfCarParkCheckpointService cfCarParkCheckpointService;

    @Override
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseResult login(@RequestBody LoginRequest loginRequest) throws Exception {
        if(loginRequest==null || StringUtils.isEmpty(loginRequest.getUsername())){
            ExceptionCast.cast(AuthCode.AUTH_USERNAME_NONE);
        }
        if(StringUtils.isEmpty(loginRequest.getPassword())){
            ExceptionCast.cast(AuthCode.AUTH_PASSWORD_NONE);
        }
        AuthToken authToken = authService.login(loginRequest.getUsername(), loginRequest.getPassword(), clientId, clientSecret);
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(authToken.getJwt_token());

        if(userBasicInfo.getRoleFlag().indexOf("toll_collector")>=0){
            //自动值班(过滤已经被值班的通道)

        }

        CfUserExt cfUserExt = cfUserService.getUserAdministratorByUid(userBasicInfo.getId());
        cfUserExt.setPassword(null);
        return new ResponseResult(CommonCode.SUCCESS, cfUserExt, authToken, 0);
    }

    @Override
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public ResponseResult logout(String type) throws Exception{
        String jwt = HttpHearderUtils.getAuthorization(request);
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(jwt);
        Object deleteResult = null;
        if(type.equals("all")){
            deleteResult = stringRedisTemplate.delete("user:" + userBasicInfo.getUsername());
        }else if(type.equals("current")){
            deleteResult = stringRedisTemplate.boundSetOps("user:" + userBasicInfo.getUsername()).remove(jwt);
        }else{
            return new ResponseResult(CommonCode.FAIL, null, "invalid typ");
        }
//        //退出所有岗亭值班
        authService.removeCheckPointDutyByUid(userBasicInfo.getId());
        return new ResponseResult(CommonCode.SUCCESS, deleteResult);
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
    public ResponseResult addAuth(@RequestBody CfAuthForm cfAuthForm) {
        CfAuth cfAuth = new CfAuth();
        BeanUtils.copyProperties(cfAuthForm, cfAuth);
        CfAuth cfAuthNew = authService.addAuth(cfAuth);
        return new ResponseResult(CommonCode.SUCCESS, cfAuthNew);
    }

    @PreAuthorize("hasAuthority('ucenter-AuthSwaggerController-updateAuth')")
    @Override
    @RequestMapping(value = "updateAuth", method = RequestMethod.PUT)
    public ResponseResult updateAuth(@RequestBody CfAuthForm cfAuthForm) {
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

    @Override
    @RequestMapping(value = "getAuthPathByRoleId", method = RequestMethod.GET)
    public ResponseResult getAuthPathByRoleId(String roleId) {
        String[] cfAuthList = authService.getAuthPathByRoleId(roleId);
        return new ResponseResult(CommonCode.SUCCESS, cfAuthList);
    }

    @Override
    @RequestMapping(value = "getFullAuthsByRoleId", method = RequestMethod.GET)
    public ResponseResult getFullAuthsByRoleId(String roleId) {
        List<CfAuth> cfAuthList = authService.getFullAuthsByRoleId(roleId);
        return new ResponseResult(CommonCode.SUCCESS, cfAuthList);
    }
}
