package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 日志信息里的时间定义
 * @author 47081
 */
public class DHDEVTIME extends NetSDKLib.SdkStructure {
    /**
     * 秒    1-60
     *//*
    public int                second;
    *//**
     * 分    1-60
     *//*
    public int                minute;
    *//**
     * 时    1-24
     *//*
    public int                hour;
    *//**
     * 日    1-31
     *//*
    public int                day;
    *//**
     * 月    1-12
     *//*
    public int                month;
    *//**
     * 年    2000-2063
     *//*
    public int                year;*/
    public int                date;


/**
 *second:6;                // 秒    1-60
 *minute:6;                // 分    1-60
 *hour:5;                  // 时    1-24
 *day:5;                   // 日    1-31
 *month:4;                 // 月    1-12
 *year:6;                  // 年    2000-2063
 *
 */
public int getSecond(){
    return getAnd(date,0,6);
}
public int getMinute(){
    return getAnd(date,6,6+6);
}
public int getHour(){return getAnd(date,6+6,6+6+5);}
public int getDay(){return getAnd(date,6+6+5,6+6+5+5);}
public int getMonth(){return getAnd(date,6+6+5+5,6+6+5+5+4);}
public int getYear(){return 2000+getAnd(date,6+6+5+5+4,6+6+5+5+4+6);}

    /**
     * c层处理后的原始年份信息
     * @return
     */
    public int getOriginalYear(){return getAnd(date,6+6+5+5+4,6+6+5+5+4+6);};
public String getDate(){
    return getYear()+"-"+getMonth()+"-"+getDay()+" "+getHour()+":"+getMinute()+":"+getSecond();
}

    /**
     * 按位与
     * @param date 原始数据
     * @param start 需要偏移的位数
     * @param end 与的位数
     * @return
     */
    private int getAnd(int date,int start,int end){
        return date>>start&getOr(start,end);
    }

    /**
     * 按位与的位数
     * @param start 开始与的位数
     * @param end 结束与的位数
     * @return
     */
    private int getOr(int start,int end){
        int result=0;
        for (int i = 0; i < end-start; i++) {
            result|=(1<<i);
        }
        return result;
    }
}
