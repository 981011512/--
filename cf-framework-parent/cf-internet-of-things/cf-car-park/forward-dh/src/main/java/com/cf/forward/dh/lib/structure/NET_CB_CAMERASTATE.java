package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 设备状态回调结果
 * {@link NetSDKLib.fCameraStateCallBack}
 *
 * @author ： 47040
 * @since ： Created in 2021/1/15 14:14
 */
public class NET_CB_CAMERASTATE extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 所在通道
     */
    public int nChannel;
    /**
     * 连接状态
     * {@link NetSDKLib.CONNECT_STATE emConnectState}
     */
    public int emConnectState;

    public NET_CB_CAMERASTATE() {
        this.dwSize = this.size();
    }

}
