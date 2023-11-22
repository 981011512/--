package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 设置停车车位状态 出参
 * 接口 {@link NetSDKLib#CLIENT_SetParkingSpaceState}
 * 入参 {@link NET_IN_SET_PARKINGSPACE_STATE_INFO}
 *
 * @author 47040
 * @since Created in 2020/11/18 13:34
 */
public class NET_OUT_SET_PARKINGSPACE_STATE_INFO extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;

    public NET_OUT_SET_PARKINGSPACE_STATE_INFO() {
        dwSize = this.size();
    }
}
