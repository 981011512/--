package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * {@link NetSDKLib#CLIENT_AttachCameraState} 输出参数
 * {@link NET_IN_CAMERASTATE} 对应接口入参
 *
 * @author ： 47040
 * @since ： Created in 2021/1/15 14:08
 */
public class NET_OUT_CAMERASTATE extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 物体ID,每个ID表示一个唯一的物体
     */
    public int nObjectID;

    public NET_OUT_CAMERASTATE() {
        this.dwSize = this.size();
    }
}
