package com.cf.ucenter.domain;

import java.io.Serializable;
import java.util.List;


public class CfUserExt extends CfUser implements Serializable {
    private List<CfRole> cfRole;

    private List<CfAuth> permissions;

    private static final long serialVersionUID = 1L;

    public CfUserExt() {
    }

    public CfUserExt(String id, String userName, String password, String avatar, Integer type, String nickName, String trueName, Long birthday, Integer sex, String sign, Long createTime, String phone, String email, List<CfRole> cfRole, List<CfAuth> permissions) {
        super(id, userName, password, avatar, type, nickName, trueName, birthday, sex, sign, createTime, phone, email);
        this.cfRole = cfRole;
        this.permissions = permissions;
    }

    public List<CfRole> getCfRole() {
        return cfRole;
    }

    public void setCfRole(List<CfRole> cfRole) {
        this.cfRole = cfRole;
    }

    public List<CfAuth> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<CfAuth> permissions) {
        this.permissions = permissions;
    }
}