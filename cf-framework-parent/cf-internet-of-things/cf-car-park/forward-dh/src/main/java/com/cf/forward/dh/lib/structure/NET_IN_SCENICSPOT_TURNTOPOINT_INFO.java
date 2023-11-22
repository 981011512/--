package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 以景物标注点为中心，进行三维定位的输 入参
 * 出参 {@link NET_OUT_SCENICSPOT_TURNTOPOINT_INFO}
 * 接口 {@link NetSDKLib#CLIENT_ScenicSpotTurnToPoint}
 *
 * @author ： 47040
 * @since ： Created in 2020/10/26 17:28
 */
public class NET_IN_SCENICSPOT_TURNTOPOINT_INFO extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 通道号
     */
    public int nChannel;
    /**
     * 景物点编号
     */
    public int nIndex;

    public NET_IN_SCENICSPOT_TURNTOPOINT_INFO() {
        dwSize = this.size();
    }
}
