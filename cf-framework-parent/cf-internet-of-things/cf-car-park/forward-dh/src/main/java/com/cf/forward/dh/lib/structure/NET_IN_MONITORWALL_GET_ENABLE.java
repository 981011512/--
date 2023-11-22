package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.NET_MONITORWALL_OPERATE_TYPE;

import static com.cf.forward.dh.lib.NetSDKLib.NET_MAX_MONITORWALL_NUM;

/**
 * 电视墙获取使能 入参
 * 对应出参 {@link NET_OUT_MONITORWALL_GET_ENABLE}
 * 对应枚举 {@link NET_MONITORWALL_OPERATE_TYPE#NET_MONITORWALL_OPERATE_GET_ENABLE}
 * 对应接口 {@link NetSDKLib#CLIENT_OperateMonitorWall}
 *
 * @author ： 47040
 * @since ： Created in 2020/10/19 11:04
 */
public class NET_IN_MONITORWALL_GET_ENABLE extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 要查询的电视墙数量, -1表示查询所有电视墙
     */
    public int nMonitorWallNum;
    /**
     * 电视墙名称, nMonitorWallNum > 0 时有效
     */
    public NET_MONITORWALL_NAME[] szNames = new NET_MONITORWALL_NAME[NET_MAX_MONITORWALL_NUM];

    public NET_IN_MONITORWALL_GET_ENABLE() {
        dwSize = this.size();
        for (int i = 0; i < szNames.length; i++) {
            szNames[i] = new NET_MONITORWALL_NAME();
        }
    }
}
