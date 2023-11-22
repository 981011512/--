package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.NET_MONITORWALL_OPERATE_TYPE;

/**
 * 电视墙设置使能 出参
 * 对应入参 {@link NET_IN_MONITORWALL_SET_ENABLE}
 * 对应枚举 {@link NET_MONITORWALL_OPERATE_TYPE#NET_MONITORWALL_OPERATE_SET_ENABLE}
 * 对应接口 {@link NetSDKLib#CLIENT_OperateMonitorWall}
 *
 * @author ： 47040
 * @since ： Created in 2020/10/19 11:30
 */
public class NET_OUT_MONITORWALL_SET_ENABLE extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;

    public NET_OUT_MONITORWALL_SET_ENABLE() {
        dwSize = this.size();
    }
}
