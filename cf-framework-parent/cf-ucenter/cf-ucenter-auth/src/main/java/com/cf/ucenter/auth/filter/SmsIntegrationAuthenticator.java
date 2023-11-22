package com.cf.ucenter.auth.filter;

import com.cf.sms.service.SmsService;
import com.cf.ucenter.domain.CfUser;
import com.cf.ucenter.service.CfUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.stereotype.Component;

/**
 * 短信验证码集成认证
 *
 * @author LIQIU
 * @date 2018-3-31
 **/
@Component
public class SmsIntegrationAuthenticator extends AbstractPreparableIntegrationAuthenticator implements  ApplicationEventPublisherAware {

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserService cfUserService;

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private SmsService smsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private ApplicationEventPublisher applicationEventPublisher;

    private final static String SMS_AUTH_TYPE = "sms";

    @Override
    public CfUser authenticate(IntegrationAuthentication integrationAuthentication) {

        //获取密码，实际值是验证码
        String password = integrationAuthentication.getAuthParameter("password");
        //获取用户名，实际值是手机号
        String username = integrationAuthentication.getUsername();
        //通过手机号码查询用户
        CfUser cfUser = cfUserService.findByPhone(username);
        if (cfUser != null) {
            //将密码设置为验证码
            cfUser.setPassword(passwordEncoder.encode(password));
        }
        return cfUser;
    }

    @Override
    public void prepare(IntegrationAuthentication integrationAuthentication) {
        String smsToken = integrationAuthentication.getAuthParameter("sms_token");
        String smsCode = integrationAuthentication.getAuthParameter("password");
        String username = integrationAuthentication.getAuthParameter("username");
        smsService.checkCode(username,smsCode,2);
    }

    @Override
    public boolean support(IntegrationAuthentication integrationAuthentication) {
        return SMS_AUTH_TYPE.equals(integrationAuthentication.getAuthType());
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
