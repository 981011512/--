package com.cf.ucenter.domain;

import java.io.Serializable;
import java.util.List;

public class CfAuth implements Serializable {
    private String id;

    private String name;

    private String module;

    private String controller;

    private String method;

    private String path;

    private Byte level;

    private String description;

    private String gained;

    private List<CfAuth> children;

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

    public String getGained() {
        return gained;
    }

    public void setGained(String gained) {
        this.gained = gained;
    }

    public List<CfAuth> getChildren() {
        return children;
    }

    public void setChildren(List<CfAuth> children) {
        this.children = children;
    }
}