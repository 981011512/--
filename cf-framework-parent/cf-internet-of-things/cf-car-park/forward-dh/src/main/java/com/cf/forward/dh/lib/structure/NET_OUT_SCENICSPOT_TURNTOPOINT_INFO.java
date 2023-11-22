package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 以景物标注点为中心，进行三维定位的 出参
 * 入参 {@link NET_IN_SCENICSPOT_TURNTOPOINT_INFO}
 * 接口 {@link NetSDKLib#CLIENT_ScenicSpotTurnToPoint}
 *
 * @author ： 47040
 * @since ： Created in 2020/10/26 17:29
 */
public class NET_OUT_SCENICSPOT_TURNTOPOINT_INFO extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;

    public NET_OUT_SCENICSPOT_TURNTOPOINT_INFO() {
        dwSize = this.size();
    }
}
