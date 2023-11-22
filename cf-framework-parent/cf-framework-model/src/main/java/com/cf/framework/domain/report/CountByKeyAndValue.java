package com.cf.framework.domain.report;

import java.io.Serializable;

/**
 * 键值 形式统计的数据返回实体
 */
public class CountByKeyAndValue implements Serializable {

    private String countKey;

    private Integer countValue;

    public String getCountKey() {
        return countKey;
    }

    public void setCountKey(String countKey) {
        this.countKey = countKey;
    }

    public Integer getCountValue() {
        return countValue;
    }

    public void setCountValue(Integer countValue) {
        this.countValue = countValue;
    }
}
