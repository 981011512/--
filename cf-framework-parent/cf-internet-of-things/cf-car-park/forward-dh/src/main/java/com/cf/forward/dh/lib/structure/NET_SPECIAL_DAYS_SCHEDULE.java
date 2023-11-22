package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

public class NET_SPECIAL_DAYS_SCHEDULE extends NetSDKLib.SdkStructure {
    /**
     * 是否支持假日计划
     */
    public boolean								bSupport;
    /**
     * 设备支持的最大计划数量
     */
    public int									nMaxSpecialDaysSchedules;
    /**
     * 每天最多的时间段
     */
    public int									nMaxTimePeriodsPerDay;
    /**
     * 设备支持的最大假日组数
     */
    public int									nMaxSpecialDayGroups;
    /**
     * ，每个假日组里最大的假日数
     */
    public int									nMaxDaysInSpecialDayGroup;
    /**
     * 保留字节
     */
    public byte[]								byReserved=new byte[128];
}
