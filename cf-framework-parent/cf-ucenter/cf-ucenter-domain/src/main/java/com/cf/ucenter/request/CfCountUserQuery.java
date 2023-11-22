package com.cf.ucenter.request;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class CfCountUserQuery implements Serializable {
    @ApiModelProperty(value = "字符串日期", required = false)
    private String date;
    @ApiModelProperty(value = "字符串结束日期", required = false)
    private String endDate;
    @ApiModelProperty(value = "年份", required = false)
    private Integer year;
    @ApiModelProperty(value = "月份", required = false)
    private Integer month;
    @ApiModelProperty(value = "前N天", required = false)
    private Integer day;
    @ApiModelProperty(value = "统计方式(before_day_count_by_day-前N天每天停车数,month_count_by_day-某年月每天停车数,year_count_by_month-某年每月的停车数)", required = true)
    private String countType;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getCountType() {
        return countType;
    }

    public void setCountType(String countType) {
        this.countType = countType;
    }
}