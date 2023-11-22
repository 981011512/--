package com.cf.pay.domain.request;

import java.io.Serializable;

public class CfTaxAccountQuery implements Serializable {
    private String id;

    private String taxAgency;

    private String image;

    private String uid;

    private Long createTime;

    private Long minCreateTime;

    private Long maxCreateTime;

    private Long updateTime;

    private Long minUpdateTime;

    private Long maxUpdateTime;

    private String configParams;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTaxAgency() {
        return taxAgency;
    }

    public void setTaxAgency(String taxAgency) {
        this.taxAgency = taxAgency == null ? null : taxAgency.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Long getMinCreateTime() {
        return minCreateTime;
    }

    public void setMinCreateTime(Long minCreateTime) {
        this.minCreateTime = minCreateTime;
    }

    public Long getMaxCreateTime() {
        return maxCreateTime;
    }

    public void setMaxCreateTime(Long maxCreateTime) {
        this.maxCreateTime = maxCreateTime;
    }

    public Long getMinUpdateTime() {
        return minUpdateTime;
    }

    public void setMinUpdateTime(Long minUpdateTime) {
        this.minUpdateTime = minUpdateTime;
    }

    public Long getMaxUpdateTime() {
        return maxUpdateTime;
    }

    public void setMaxUpdateTime(Long maxUpdateTime) {
        this.maxUpdateTime = maxUpdateTime;
    }

    public String getConfigParams() {
        return configParams;
    }

    public void setConfigParams(String configParams) {
        this.configParams = configParams == null ? null : configParams.trim();
    }
}