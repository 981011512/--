package com.cf.ucenter.domain;

import java.io.Serializable;

public class CfRole implements Serializable {
    private String id;

    private String name;

    private String flagKey;

    private String departmentId;

    private Integer roleLevel;

    private String icon;

    private String description;

    private CfDepartment cfDepartment;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFlagKey() {
        return flagKey;
    }

    public void setFlagKey(String flagKey) {
        this.flagKey = flagKey == null ? null : flagKey.trim();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public Integer getRoleLevel() {
        return roleLevel;
    }

    public void setRoleLevel(Integer roleLevel) {
        this.roleLevel = roleLevel;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public CfDepartment getCfDepartment() {
        return cfDepartment;
    }

    public void setCfDepartment(CfDepartment cfDepartment) {
        this.cfDepartment = cfDepartment;
    }
}