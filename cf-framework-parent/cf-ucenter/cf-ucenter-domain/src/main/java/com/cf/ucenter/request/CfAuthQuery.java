package com.cf.ucenter.request;

import com.cf.ucenter.domain.CfAuthMeta;

import java.io.Serializable;
import java.util.List;

public class CfAuthQuery implements Serializable {
    private String id;

    private List<String> ids;

    private String name;

    private String module;

    private String controller;

    private String method;

    private String path;

    private Byte level;

    private String description;

    private Short sortIndex;

    private Byte breadcrumbHidden;

    private Byte showMenu;

    private Integer page;

    private Integer size;

    private String orderBy;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module == null ? null : module.trim();
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller == null ? null : controller.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Short getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Short sortIndex) {
        this.sortIndex = sortIndex;
    }

    public Byte getBreadcrumbHidden() {
        return breadcrumbHidden;
    }

    public void setBreadcrumbHidden(Byte breadcrumbHidden) {
        this.breadcrumbHidden = breadcrumbHidden;
    }

    public Byte getShowMenu() {
        return showMenu;
    }

    public void setShowMenu(Byte showMenu) {
        this.showMenu = showMenu;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}