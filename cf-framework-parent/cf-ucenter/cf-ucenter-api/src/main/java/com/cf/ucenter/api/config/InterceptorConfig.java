package com.cf.ucenter.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor()).excludePathPatterns("/v2/api-docs", "/swagger-resources/configuration/ui",
                "/swagger-resources","/swagger-resources/configuration/security",
                "/swagger-ui.html","/webjars/**","/course/coursepic/list/**","/auth/login",
                "/ucenter/register","/ucenter/recoverPasswordByPhoneAndCode",
                "/auth/loginByPhone","/appVersion/checkVersion","/auth/createJwt",
                "/auth/wxLogin","/auth/testWxin","/auth/getWxBaseUserInfoByCode",
                "/auth/getWxBaseUserInfoByCodeAndLoginType","/ucenter/updateCustomerByWxUser",
                "/ucenter/getUserInfoByUnionIdAndApiToken","/ucenter/getClientIp","/auth/getAliBaseUserInfoByCode",
                "/auth/createJumpToWxMinData","/auth/getAliMinBaseUserInfoByCode");
    }
    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }
}
