package com.cf.framework.domain.report;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 每日数量统计实体
 */
public class CountByDay implements Serializable {
    //日期(字符串)
    private String day;
    //当日统计数
    private BigDecimal count;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }
}
