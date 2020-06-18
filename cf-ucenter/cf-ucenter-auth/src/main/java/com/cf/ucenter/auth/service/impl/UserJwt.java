package com.cf.ucenter.auth.service.impl;

import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Data
@ToString
public class UserJwt extends User {

    private String id;
    private String name;
    private String userpic;
    private String utype;
    private String companyId;
    private Long expired;

    public UserJwt(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

}
