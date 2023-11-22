package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

import java.util.Arrays;

/**
 * @author 47081
 * @version 1.0
 * @description 门禁假日计划配置
 * 对应枚举类型{@link com.cf.forward.dh.lib.enumeration.NET_EM_CFG_OPERATE_TYPE#NET_EM_CFG_ACCESSCTL_SPECIALDAYS_SCHEDULE}
 * @date 2020/10/19
 */
public class NET_CFG_ACCESSCTL_SPECIALDAYS_SCHEDULE_INFO extends NetSDKLib.SdkStructure {
    public int dwSize;
    /**
     * 假日计划名称
     */
    public byte[] szSchduleName = new byte[64];
    /**
     * 假日计划使能
     */
    public boolean bSchdule;
    /**
     * {@link com.cf.forward.dh.lib.enumeration.NET_EM_CFG_OPERATE_TYPE#NET_EM_CFG_ACCESSCTL_SPECIALDAY_GROUP} 配置的下标
     */
    public int nGroupNo;
    /**
     * 一天的时间段个数
     */
    public int nTimeSection;
    /**
     * 时间段
     */
    public SDK_TSECT[] stuTimeSection = (SDK_TSECT[]) new SDK_TSECT().toArray(6);
    /**
     * 有效的门数量
     */
    public int nDoorNum;
    /**
     * 生效的门通道号
     */
    public int[] nDoors = new int[64];

    public NET_CFG_ACCESSCTL_SPECIALDAYS_SCHEDULE_INFO() {
        this.dwSize = this.size();
    }

    @Override
    public String toString() {
        return "NET_CFG_ACCESSCTL_SPECIALDAYS_SCHEDULE_INFO{" +
                "szSchduleName=" + new String(szSchduleName).trim() +
                ", bSchdule=" + bSchdule +
                ", nGroupNo=" + nGroupNo +
                ", nTimeSection=" + nTimeSection +
                ", stuTimeSection=" + Arrays.toString(stuTimeSection) +
                ", nDoorNum=" + nDoorNum +
                ", nDoors=" + Arrays.toString(nDoors) +
                '}';
    }
}
