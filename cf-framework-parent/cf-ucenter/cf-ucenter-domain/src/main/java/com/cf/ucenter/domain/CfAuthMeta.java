package com.cf.ucenter.domain;

import java.io.Serializable;

/**
 * 权限路由mete数据
 * title: '首页',
 *       icon: 'home-2-line',
 *       breadcrumbHidden: true,
 */
public class CfAuthMeta implements Serializable {

    private String title;   //路由标题
    private String icon;    //路由图标
    private boolean breadcrumbHidden;   //是否隐藏面包屑

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isBreadcrumbHidden() {
        return breadcrumbHidden;
    }

    public void setBreadcrumbHidden(boolean breadcrumbHidden) {
        this.breadcrumbHidden = breadcrumbHidden;
    }
}
