package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.NET_MONITORWALL_OPERATE_TYPE;

import static com.cf.forward.dh.lib.NetSDKLib.NET_MAX_MONITORWALL_NUM;

/**
 * 电视墙获取使能 出参
 * 对应入参 {@link NET_IN_MONITORWALL_GET_ENABLE}
 * 对应枚举 {@link NET_MONITORWALL_OPERATE_TYPE#NET_MONITORWALL_OPERATE_GET_ENABLE}
 * 对应接口 {@link NetSDKLib#CLIENT_OperateMonitorWall}
 *
 * @author ： 47040
 * @since ： Created in 2020/10/19 11:16
 */
public class NET_OUT_MONITORWALL_GET_ENABLE extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 电视墙数量
     */
    public int nMonitorWallNum;
    /**
     * 电视墙使能
     */
    public NET_MONITORWALL_ENABLE_INFO[] stuEnable = new NET_MONITORWALL_ENABLE_INFO[NET_MAX_MONITORWALL_NUM];

    public NET_OUT_MONITORWALL_GET_ENABLE() {
        dwSize = this.size();
        for (int i = 0; i < stuEnable.length; i++) {
            stuEnable[i] = new NET_MONITORWALL_ENABLE_INFO();
        }
    }
}