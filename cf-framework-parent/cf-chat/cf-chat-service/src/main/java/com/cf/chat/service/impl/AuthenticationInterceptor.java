package com.cf.chat.service.impl;

import com.alibaba.fastjson.JSON;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.domain.ucenter.response.AuthCode;
import com.cf.framework.exception.ExceptionCast;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Component
public class AuthenticationInterceptor{

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public UserBasicInfo parseJwt(String jwt) throws Exception
    {
        Resource resource = new ClassPathResource("publickey.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(resource.getInputStream());


        BufferedReader br = new BufferedReader(inputStreamReader);
        String publickey = br.lines().collect(Collectors.joining("\n"));

        //校验jwt令牌
        String claims = JwtHelper.decodeAndVerify(jwt, new RsaVerifier(publickey)).getClaims();
        UserBasicInfo userBasicInfo = JSON.parseObject(claims, UserBasicInfo.class);
        if(!stringRedisTemplate.boundSetOps("user:"+userBasicInfo.getUsername()).isMember(jwt)){
            ExceptionCast.cast(AuthCode.AUTH_LOGIN_TOKEN_EXPIRED);
        }
        return userBasicInfo;
    }
}
