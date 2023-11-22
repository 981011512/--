package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

import java.util.Arrays;

/**
 * @author 47081
 * @version 1.0
 * @description 门禁假日组配置,对应枚举
 * {@link com.cf.forward.dh.lib.enumeration.NET_EM_CFG_OPERATE_TYPE#NET_EM_CFG_ACCESSCTL_SPECIALDAY_GROUP}
 * @date 2020/10/19
 */
public class NET_CFG_ACCESSCTL_SPECIALDAY_GROUP_INFO extends NetSDKLib.SdkStructure {


    public int dwSize;
    /**
     * 组使能
     */
    public boolean bGroupEnable;
    /**
     * 组名称
     */
    public byte[] szGroupName = new byte[32];
    /**
     * 有效的节假日数量
     */
    public int nSpeciaday;
    /**
     * 假日信息
     */
    public NET_ACCESSCTL_SPECIALDAY_INFO[] stuSpeciaday = (NET_ACCESSCTL_SPECIALDAY_INFO[]) new NET_ACCESSCTL_SPECIALDAY_INFO().toArray(16);

    public NET_CFG_ACCESSCTL_SPECIALDAY_GROUP_INFO() {
        this.dwSize = this.size();
    }

    @Override
    public String toString() {
        return "假日组,NET_CFG_ACCESSCTL_SPECIALDAY_GROUP_INFO{" +
                "bGroupEnable=" + bGroupEnable +
                ", szGroupName=" + new String(szGroupName).trim() +
                ", nSpeciaday=" + nSpeciaday +
                ", stuSpeciaday=" + Arrays.toString(stuSpeciaday) +
                '}';
    }
}
