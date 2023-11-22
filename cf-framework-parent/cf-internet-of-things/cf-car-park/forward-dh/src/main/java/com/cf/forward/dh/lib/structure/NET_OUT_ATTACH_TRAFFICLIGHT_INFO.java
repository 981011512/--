package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * className：NET_OUT_ATTACH_TRAFFICLIGHT_INFO
 * description：CLIENT_AttachTrafficLightState 接口出参
 * author：251589
 * createTime：2021/1/19 14:56
 *
 * @version v1.0
 */
public class NET_OUT_ATTACH_TRAFFICLIGHT_INFO extends NetSDKLib.SdkStructure {
    /**
     *  结构体大小
     */
    public int dwSize;

    public NET_OUT_ATTACH_TRAFFICLIGHT_INFO(){
        this.dwSize = this.size();
    }
}
