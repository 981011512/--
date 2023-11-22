package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description 热度图数据信息
 * @date 2020/9/21
 */
public class NET_CB_VIDEOSTAT_HEATMAP extends NetSDKLib.SdkStructure {
    public int nToken;
    /**
     * 热度图类型,对应枚举类型{@link com.cf.forward.dh.lib.enumeration.EM_HEATMAP_TYPE}
     */
    public int emHeatMapType;
    /**
     * 保留字节
     */
    public byte[] byReserved = new byte[1024];
}
