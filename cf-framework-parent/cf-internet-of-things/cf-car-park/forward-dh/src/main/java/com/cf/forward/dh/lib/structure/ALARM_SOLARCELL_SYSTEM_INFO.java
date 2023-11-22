package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.constant.SDK_ALARM_Ex_TYPE;
import com.cf.forward.dh.lib.enumeration.EM_SOLARCELL_SYSTEM_FAULT_TYPE;

/**
 * @author 47081
 * @version 1.0
 * @description \if ENGLISH_LANG
 * <p>
 * \else
 * 事件类型 {@link SDK_ALARM_Ex_TYPE#SDK_ALARM_SOLARCELL_SYSTEM_INFO}(太阳能系统信息上报)
 * \endif
 * @date 2020/8/11
 */
public class ALARM_SOLARCELL_SYSTEM_INFO extends NetSDKLib.SdkStructure {
    /**
     * 0:脉冲
     */
    public int nAction;
    /**
     * 事件发生的时间
     */
    public NET_TIME_EX UTC;
    /**
     * 时间戳(单位是毫秒)
     */
    public double PTS;
    /**
     * 蓄电池信息
     */
    public SOLARCELL_BATTERY_INFO stuBatteryInfo;
    /**
     * 太阳能板信息
     */
    public SOLARCELL_PANEL_INFO stuSolarPanel;
    /**
     * 历史数据信息
     */
    public SOLARCELL_SYSTEM_HISTORY_INFO stuHistoryInfo;
    /**
     * 系统故障,枚举值参考{@link EM_SOLARCELL_SYSTEM_FAULT_TYPE#getType()}
     */
    public int[] emSystemFault = new int[32];
    /**
     * 系统故障个数
     */
    public int nSystemFault;
    /**
     * 保留字节
     */
    public byte[] byReserved = new byte[1020];
}
