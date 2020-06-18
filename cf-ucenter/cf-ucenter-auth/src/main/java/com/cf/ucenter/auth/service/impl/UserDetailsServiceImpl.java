package com.cf.ucenter.auth.service.impl;

import com.cf.ucenter.domain.CfAuth;
import com.cf.ucenter.domain.CfUser;
import com.cf.ucenter.service.AuthService;
import com.cf.ucenter.service.CfUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;

import java.util.ArrayList;
import java.util.List;

@Service(version = "1.0.0")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Reference(version = "1.0.0", retries = 0, timeout = 10000)
    private CfUserService cfUserService;

    @Autowired
    ClientDetailsService clientDetailsService;
    @Autowired
    AuthService authService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //取出身份，如果身份为空说明没有认证
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //没有认证统一采用httpbasic认证，httpbasic中存储了client_id和client_secret，开始认证client_id和client_secret
        if(authentication==null){
            ClientDetails clientDetails = clientDetailsService.loadClientByClientId(username);
            if(clientDetails!=null){
                //密码
                String clientSecret = clientDetails.getClientSecret();
                return new User(username,clientSecret, AuthorityUtils.commaSeparatedStringToAuthorityList(""));
            }
        }
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        //远程调用用户中心根据账号查询用户信息
        CfUser cfUser = cfUserService.findByUserName(username);
        if(cfUser == null){
            //返回空给spring security表示用户不存在
            return null;
        }

//        String pws = new BCryptPasswordEncoder().encode("123");
        List<CfAuth> cfAuths = authService.selectByUidAndLevel(cfUser.getId(), (byte) 2, false);
        String authorityString = "";
        if(cfAuths!=null && cfAuths.size()>0){
            for(CfAuth cfAuth: cfAuths){
                authorityString += ","+cfAuth.getPath();
            }
            authorityString = authorityString.substring(1);
        }
        UserJwt userDetails = new UserJwt(username, cfUser.getPassword(),AuthorityUtils.commaSeparatedStringToAuthorityList(authorityString));
        userDetails.setId(cfUser.getId());
        userDetails.setUtype(cfUser.getType()+"");//用户类型
        userDetails.setName(cfUser.getUserName());//用户名称
        userDetails.setUserpic(cfUser.getAvatar());//用户头像
        return userDetails;
    }
}
