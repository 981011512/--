package com.cf.ad.domain.request;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 广告统计
 */
public class AdCounts implements Serializable {
    @ApiModelProperty(value = "广告关联id/广告id", required = true)
    private String id;
    @ApiModelProperty(value = "统计字段", required = true)
    private String field;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
