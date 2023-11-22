package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description
 * \if ENGLISH_LANG
 * solarcell system history info
 * \else
 * 太阳能系统历史数据信息
 * \endif
 * @date 2020/8/11
 */
public class SOLARCELL_SYSTEM_HISTORY_INFO extends NetSDKLib.SdkStructure {

    /**
     * 系统运行时间（单位：天）
     */
    public int nSystemTotalRunDay;
    /**
     * 蓄电池总过放次数
     */
    public int nBatteryOverDischargeCount;
    /**
     * 蓄电池总充满电次数
     */
    public int nBatteryTotalChargeCount;
    /**
     * 保留字节
     */
    public byte[] byReserved = new byte[252];

}
