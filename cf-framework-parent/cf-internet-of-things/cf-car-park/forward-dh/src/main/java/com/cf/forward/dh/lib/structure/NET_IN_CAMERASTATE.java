package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.sun.jna.Pointer;

/**
 * {@link NetSDKLib#CLIENT_AttachCameraState} 输入参数
 * {@link NET_OUT_CAMERASTATE} 对应接口出参
 *
 * @author ： 47040
 * @since ： Created in 2021/1/15 14:03
 */
public class NET_IN_CAMERASTATE extends NetSDKLib.SdkStructure {

    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * int*[]
     * 由用户申请内存，大小为sizeof(int)*nChannels
     * 观察的通道号,数组元素中,有一个是-1,则观察所有通道
     */
    public Pointer pChannels;
    /**
     * pChannels指针长度
     */
    public int nChannels;
    /**
     * 状态回调函数
     */
    public NetSDKLib.fCameraStateCallBack cbCamera;
    /**
     * 用户数据
     */
    public Pointer dwUser;

    public NET_IN_CAMERASTATE() {
        this.dwSize = this.size();
    }

}
