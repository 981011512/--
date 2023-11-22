package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description 获取热度图数据接口入参,
 * @date 2020/9/21
 */
public class NET_IN_GET_VIDEOSTAT_HEATMAP extends NetSDKLib.SdkStructure {
    /**
     * 此结构体大小
     */
    public int dwSize;
    /**
     * 计划（预置点,仅球机有效,范围1~MaxNumberStatPlan）
     */
    public int nPlanID;
    /**
     * 开始时间
     */
    public NET_TIME stuStartTime;
    /**
     * 结束时间
     */
    public NET_TIME stuEndTime;
    /**
     * Ai热度图类型,枚举值类型{@link com.cf.forward.dh.lib.enumeration.EM_HEATMAP_TYPE}
     */
    public int emHeatMapType;
    public NET_IN_GET_VIDEOSTAT_HEATMAP(){
        this.dwSize=size();
    }
}
