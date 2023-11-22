package com.cf.pay.api.config;

import com.alibaba.fastjson.JSON;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.domain.ucenter.response.AuthCode;
import com.cf.framework.exception.ExceptionCast;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        //取出头信息
        String authorization = httpServletRequest.getHeader("Authorization");
        if(StringUtils.isEmpty(authorization)){
            ExceptionCast.cast(AuthCode.AUTH_LOGIN_TOKEN_ILLEGAL);
            return false;
        }
        if(!authorization.startsWith("Bearer ")){
            ExceptionCast.cast(AuthCode.AUTH_LOGIN_TOKEN_ILLEGAL);
            return false;
        }
        //取到jwt令牌
        String jwt = authorization.substring(7);

        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(jwt);

        if(!stringRedisTemplate.boundSetOps("user:"+userBasicInfo.getUsername()).isMember(jwt)){
            ExceptionCast.cast(AuthCode.AUTH_LOGIN_TOKEN_EXPIRED);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }

    public static UserBasicInfo parseJwt(String jwt) throws Exception
    {
        if(StringUtils.isEmpty(jwt)){
            return new UserBasicInfo();
        }
        Resource resource = new ClassPathResource("publickey.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(resource.getInputStream());
        BufferedReader br = new BufferedReader(inputStreamReader);
        String publickey = br.lines().collect(Collectors.joining("\n"));

        //校验jwt令牌
        String claims = JwtHelper.decodeAndVerify(jwt, new RsaVerifier(publickey)).getClaims();
        return JSON.parseObject(claims, UserBasicInfo.class);
    }
}
