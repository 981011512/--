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
 * @description 支持的云台精确定位方式类型
 * @date 2020/11/9
 */
public class CFG_PTZ_ABSOLUTELY_CAPS extends NetSDKLib.SdkStructure {
    /**
     * 是否支持归一化定位
     */
    public boolean bSupportNormal;
    /**
     * 是否支持实际参数值定位
     */
    public boolean bSupportReal;
    /**
     * 预留
     */
    public byte[] byReserved = new byte[120];

    @Override
    public String toString() {
        return "CFG_PTZ_ABSOLUTELY_CAPS{" +
                "bSupportNormal=" + bSupportNormal +
                ", bSupportReal=" + bSupportReal +
                '}';
    }
}
