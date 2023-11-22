package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 获取景物点支持的能力
 * 出参(CLIENT_ScenicSpotGetCaps 输入参数)
 * 接口 {@link NetSDKLib#CLIENT_ScenicSpotGetCaps}
 *
 * @author ： 47040
 * @since ： Created in 2020/10/26 16:29
 */
public class NET_IN_SCENICSPOT_GETCAPS_INFO extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 通道号
     */
    public int nChannel;

    public NET_IN_SCENICSPOT_GETCAPS_INFO() {
        dwSize = this.size();
    }
}
