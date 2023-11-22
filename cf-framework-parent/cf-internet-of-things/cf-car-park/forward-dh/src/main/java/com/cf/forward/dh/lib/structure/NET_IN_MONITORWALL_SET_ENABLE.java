package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.NET_MONITORWALL_OPERATE_TYPE;

import static com.cf.forward.dh.lib.NetSDKLib.NET_MAX_MONITORWALL_NUM;

/**
 * 电视墙设置使能 入参
 * 对应出参 {@link NET_OUT_MONITORWALL_SET_ENABLE}
 * 对应枚举 {@link NET_MONITORWALL_OPERATE_TYPE#NET_MONITORWALL_OPERATE_SET_ENABLE}
 * 对应接口 {@link NetSDKLib#CLIENT_OperateMonitorWall}
 *
 * @author ： 47040
 * @since ： Created in 2020/10/19 11:25
 */
public class NET_IN_MONITORWALL_SET_ENABLE extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 要设置的电视墙数量
     */
    public int nMonitorWallNum;
    /**
     * 电视墙使能
     */
    public NET_MONITORWALL_ENABLE_INFO[] stuEnable = new NET_MONITORWALL_ENABLE_INFO[NET_MAX_MONITORWALL_NUM];

    public NET_IN_MONITORWALL_SET_ENABLE() {
        dwSize = this.size();
        for (int i = 0; i < stuEnable.length; i++) {
            stuEnable[i] = new NET_MONITORWALL_ENABLE_INFO();
        }
    }
}
