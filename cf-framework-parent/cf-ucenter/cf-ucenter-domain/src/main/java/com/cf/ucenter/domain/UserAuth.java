package com.cf.ucenter.domain;

import com.cf.framework.domain.ucenter.ext.AuthToken;

import java.io.Serializable;

public class UserAuth implements Serializable {

    CfUser cfUser;

    AuthToken authToken;

    public CfUser getCfUser() {
        return cfUser;
    }

    public void setCfUser(CfUser cfUser) {
        this.cfUser = cfUser;
    }

    public AuthToken getAuthToken() {
        return authToken;
    }

    public void setAuthToken(AuthToken authToken) {
        this.authToken = authToken;
    }
}
