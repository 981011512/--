package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251589
 * @version V1.0
 * @Description: // CLIENT_QueryDevInfo NET_QUERY_TRAFFIC_RADAR_GET_OBJECT 类型接口输入参数
 * @date 2020/12/14 20:46
 */
public class NET_IN_TRAFFIC_RADAR_GET_OBJECT_INFO extends NetSDKLib.SdkStructure {
    public int dwSize;
    public int nChannel;				// 通道号

    public NET_IN_TRAFFIC_RADAR_GET_OBJECT_INFO() {
        this.dwSize = this.size();
    }
}
