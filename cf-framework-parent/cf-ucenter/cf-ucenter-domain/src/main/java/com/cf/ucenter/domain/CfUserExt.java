package com.cf.ucenter.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


public class CfUserExt extends CfUser implements Serializable {
    private List<CfRole> cfRole;

    private List<CfAuth> permissions;

    private static final long serialVersionUID = 1L;

    public CfUserExt() {
    }

    public CfUserExt(String id, String userName, String password, String avatar, Byte type, String nickName, String trueName, Long birthday, Byte sex, String sign, Long createTime, String phone, String email, List<CfRole> cfRole, List<CfAuth> permissions, Long lastLoginTime) {
        super(id, userName, password, avatar, type, nickName, trueName, phone, email, birthday, sex, sign, createTime, cfRole, new BigDecimal(0), lastLoginTime);
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