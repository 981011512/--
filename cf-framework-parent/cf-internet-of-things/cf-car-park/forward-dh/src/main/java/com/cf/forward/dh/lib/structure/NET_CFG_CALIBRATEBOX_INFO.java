package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;

/**
 * 校准框信息
 */
public class NET_CFG_CALIBRATEBOX_INFO extends SdkStructure {
    /**
     * 校准框中心点坐标(点的坐标归一化到[0,8191]区间)
     */
    public POINTCOORDINATE stuCenterPoint;
    /**
     * 相对基准校准框的比率(比如1表示基准框大小，0.5表示基准框大小的一半)
     */
    public float               fRatio;
}
