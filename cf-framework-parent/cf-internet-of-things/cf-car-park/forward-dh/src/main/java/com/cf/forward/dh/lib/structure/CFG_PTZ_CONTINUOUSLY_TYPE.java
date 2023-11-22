package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description 连续移动方式类型
 * @date 2020/11/11
 */
public class CFG_PTZ_CONTINUOUSLY_TYPE extends NetSDKLib.SdkStructure {
    /**
     * 是否支持归一化值定位
     */
    public boolean bSupportNormal;
    /**
     * 是否支持非归一化值定位
     */
    public boolean bSupportExtra;
    /**
     * 预留
     */
    public byte[] byReserved = new byte[120];

}
