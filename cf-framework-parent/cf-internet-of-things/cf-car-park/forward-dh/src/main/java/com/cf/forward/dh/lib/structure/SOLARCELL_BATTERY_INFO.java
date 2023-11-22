package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description \if ENGLISH_LANG
 * <p>
 * \else
 * 太阳能蓄电池信息
 * \endif
 * @date 2020/8/11
 */
public class SOLARCELL_BATTERY_INFO extends NetSDKLib.SdkStructure {

    /**
     * 电量百分比（范围：0~100）
     */
    public int nElectricityQuantityPercent;
    /**
     * 电压（单位：伏特）
     */
    public float fVoltage;
    /**
     * 温度（单位：摄氏度）
     */
    public float fTemperature;
    /**
     * 控制温度（单位：摄氏度）
     */
    public float fControllerTemper;
    /**
     * 保留字节
     */
    public byte[] byReserved = new byte[256];
}
