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
 * @description 云台-区域扫描能力集
 * @date 2020/11/9
 */
public class CFG_PTZ_AREA_SCAN extends NetSDKLib.SdkStructure {
    /**
     * 是否支持区域扫描
     */
    public boolean bIsSupportAutoAreaScan;
    /**
     * 区域扫描的个数
     */
    public int wScanNum;
}
