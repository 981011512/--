package com.cf.forward.dh.lib.structure;/**
 * @author 47081
 * @descriptio
 * @date 2020/11/9
 * @version 1.0
 */

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description 图像测距能力集
 * @date 2020/11/9
 */
public class CFG_PTZ_MEASURE_DISTANCE extends NetSDKLib.SdkStructure {
    /**
     * 是否支持图像测距
     */
    public boolean bSupport;
    /**
     * 是否将图像测距结果数据叠加至码流
     */
    public boolean bOsdEnable;
    /**
     * 图像测距信息的最小显示时长, 单位秒
     */
    public int nDisplayMin;
    /**
     * 图像测距信息的最大显示时长, 单位秒
     */
    public int nDisplayMax;
}
