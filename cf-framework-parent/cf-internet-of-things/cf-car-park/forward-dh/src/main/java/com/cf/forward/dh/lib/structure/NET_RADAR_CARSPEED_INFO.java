package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * className：NET_RADAR_CARSPEED_INFO
 * description： 雷达配置——车速
 * author：251589
 * createTime：2020/12/29 11:05
 *
 * @version v1.0
 */
public class NET_RADAR_CARSPEED_INFO extends NetSDKLib.SdkStructure {
    public int    nTriggerLower;    // 触发值下限 范围 1~255km/h
    public int    nTriggerUpper;    // 触发值上限 范围 1~255km/h
    public int    nLimitLower;    // 限速值下限 范围 5~255km/h
    public int    nLimitUpper;    // 限速值上限 范围 5~255km/h
}
