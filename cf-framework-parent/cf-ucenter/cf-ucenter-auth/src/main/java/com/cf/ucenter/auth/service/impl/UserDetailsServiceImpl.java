package com.cf.ucenter.auth.service.impl;

import com.cf.ucenter.auth.filter.IntegrationAuthentication;
import com.cf.ucenter.auth.filter.IntegrationAuthenticationContext;
import com.cf.ucenter.auth.filter.IntegrationAuthenticator;
import com.cf.ucenter.domain.CfAuth;
import com.cf.ucenter.domain.CfRole;
import com.cf.ucenter.domain.CfUser;
import com.cf.ucenter.service.AuthService;
import com.cf.ucenter.service.CfRoleService;
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

@Service(version = "1.0.0", loadbalance = "roundrobin")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserService cfUserService;

    @Autowired
    ClientDetailsService clientDetailsService;
    @Autowired
    AuthService authService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    CfRoleService cfRoleService;

    private List<IntegrationAuthenticator> authenticators;

    @Autowired(required = false)
    public void setIntegrationAuthenticators(List<IntegrationAuthenticator> authenticators) {
        this.authenticators = authenticators;
    }

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

        IntegrationAuthentication integrationAuthentication = IntegrationAuthenticationContext.get();
        //判断是否是集成登录
        if (integrationAuthentication == null) {
            integrationAuthentication = new IntegrationAuthentication();
        }
        integrationAuthentication.setUsername(username);

        if (StringUtils.isEmpty(username)) {
            return null;
        }
        //远程调用用户中心根据账号查询用户信息
        CfUser cfUser = cfUserService.findByUserName(username);
        if(cfUser==null){
            cfUser = cfUserService.findByPhone(username);
            if(cfUser!=null){
                cfUser.setUserName(username);
                cfUser.setPassword(new BCryptPasswordEncoder().encode(integrationAuthentication.getAuthParameter("password")));
            }
        }
        if(cfUser == null){
            //返回空给spring security表示用户不存在
            return null;
        }
        updateUserLastLoginTime(cfUser.getId());

//        String pws = new BCryptPasswordEncoder().encode("123");
        return getUserDetails(cfUser);
    }

    UserJwt getUserDetails(CfUser cfUser)
    {
        List<CfAuth> cfAuths = authService.selectByUidAndLevel(cfUser.getId(), (byte) 2, false);
        String authorityString = "";
        if(cfAuths!=null && cfAuths.size()>0){
            for(CfAuth cfAuth: cfAuths){
                authorityString += ","+cfAuth.getPath();
            }
            authorityString = authorityString.substring(1);
        }

        UserJwt userDetails = new UserJwt(cfUser.getUserName(), cfUser.getPassword(),AuthorityUtils.commaSeparatedStringToAuthorityList(authorityString));
        userDetails.setId(cfUser.getId());
        userDetails.setUtype(cfUser.getType()+"");//用户类型
        userDetails.setName(cfUser.getUserName());//用户名称
        userDetails.setUserpic(cfUser.getAvatar());//用户头像
        List<CfRole> cfRoles = cfRoleService.getRolesByUid(cfUser.getId());
        String roleFlagKeyString = "";
        if(cfRoles!=null && cfRoles.size()>0){
            for(CfRole cfRole: cfRoles){
                roleFlagKeyString += ","+cfRole.getFlagKey();
            }
            roleFlagKeyString = roleFlagKeyString.substring(1);
        }
        userDetails.setRoleFlag(roleFlagKeyString);
        userDetails.setLastLoginTime(System.currentTimeMillis());
        return userDetails;
    }

    /**
     * 更新用户最近登录时间
     * @param uid
     */
    public void updateUserLastLoginTime(String uid){
        CfUser cfUser = new CfUser();
        cfUser.setId(uid);
        cfUser.setLastLoginTime(System.currentTimeMillis());
        cfUserService.updateByPrimaryKeySelective(cfUser);
    }

}
