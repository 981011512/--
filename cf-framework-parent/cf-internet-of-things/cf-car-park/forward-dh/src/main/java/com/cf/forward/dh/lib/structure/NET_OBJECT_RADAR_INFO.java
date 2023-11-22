package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251589
 * @version V1.0
 * @Description:
 * @date 2020/12/14 20:56
 */
public class NET_OBJECT_RADAR_INFO extends NetSDKLib.SdkStructure {
    public int nID;				              // 物体ID
    public int nVerticalPos;		          // 物体在道路方向上的坐标，雷达为坐标原点 单位：cm
    public int nHorizontalPos;		          // 物体在垂直道路方向上的坐标，雷达为坐标原点 单位：cm
    public int nObjectLen;			          // 物体长度 单位：cm
    public byte[] byReserved = new byte[256]; // 保留字节
}
