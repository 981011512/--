package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description 假日信息
 * @date 2020/10/19
 */
public class NET_ACCESSCTL_SPECIALDAY_INFO extends NetSDKLib.SdkStructure {
    /**
     * 组名称
     */
    public byte[] szDayName = new byte[32];
    /**
     * 开始时间
     */
    public NET_TIME stuStartTime;
    /**
     * 结束时间
     */
    public NET_TIME stuEndTime;
    public byte[] byReserved = new byte[256];

    @Override
    public String toString() {
        return "假日信息,NET_ACCESSCTL_SPECIALDAY_INFO{" +
                "szDayName=" + new String(szDayName).trim() +
                ", stuStartTime=" + stuStartTime.toStringTime() +
                ", stuEndTime=" + stuEndTime.toStringTime() +
                '}';
    }
}
