package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description \if ENGLISH_LANG
 * <p>
 * \else
 * 太阳能板信息
 * \endif
 * @date 2020/8/11
 */
public class SOLARCELL_PANEL_INFO extends NetSDKLib.SdkStructure {

    /**
     * 电压（单位：伏特）
     */
    public float fVoltage;
    /**
     * 电流（单位：安培）
     */
    public float fElectricCurrent;
    /**
     * 充电功率
     */
    public float fChargingPower;
    /**
     * 保留字节
     */
    public byte[] byReserved = new byte[252];

}
