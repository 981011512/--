package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.sun.jna.Pointer;

/**
 * @author 251589
 * @version V1.0
 * @Description:
 * @date 2020/12/14 20:48
 */
public class NET_OUT_TRAFFIC_RADAR_GET_OBJECT_INFO extends NetSDKLib.SdkStructure {
    public int dwSize;
    public int nMaxObjectNum;			                // 用户申请目标最大个数
    public Pointer pObjectInfo;			// 目标信息内存由用户申请 指针对应NET_OBJECT_RADAR_INFO
    public int nObjectNum;			                	// 获取到目标的个数

    public NET_OUT_TRAFFIC_RADAR_GET_OBJECT_INFO() {
        this.dwSize = this.size();
    }
}
