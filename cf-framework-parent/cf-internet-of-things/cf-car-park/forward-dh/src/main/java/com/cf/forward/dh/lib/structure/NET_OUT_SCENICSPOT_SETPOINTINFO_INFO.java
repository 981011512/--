package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 设置景物点，原编号的景物点将会被覆盖 出参
 * 入参 {@link NET_IN_SCENICSPOT_SETPOINTINFO_INFO}
 * 接口 {@link NetSDKLib#CLIENT_ScenicSpotSetPointInfo}
 *
 * @author ： 47040
 * @since ： Created in 2020/10/26 16:14
 */
public class NET_OUT_SCENICSPOT_SETPOINTINFO_INFO extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;

    public NET_OUT_SCENICSPOT_SETPOINTINFO_INFO() {
        dwSize = this.size();
    }
}