package com.cf.ucenter.admin.controller;

import com.alibaba.fastjson.JSON;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.ucenter.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
    @Autowired
    protected HttpServletRequest request;
    protected UserBasicInfo userBasicInfo;

    /**
     * 解析jwt令牌，获取基础的用户信息
     * @param authService
     */
    protected void getUserBasicInfoByJwt(AuthService authService)
    {
        //取到jwt令牌
        String jwt = HttpHearderUtils.getAuthorization(request);
        String jwtToken = authService.checkJwtToken(jwt);
        userBasicInfo = JSON.parseObject(jwtToken, UserBasicInfo.class);
    }
}
