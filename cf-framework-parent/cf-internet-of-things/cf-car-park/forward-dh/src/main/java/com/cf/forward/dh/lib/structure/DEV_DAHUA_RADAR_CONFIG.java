package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * className：DEV_DAHUA_RADAR_CONFIG
 * description：
 * author：251589
 * createTime：2020/12/29 11:02
 *
 * @version v1.0
 */
public class DEV_DAHUA_RADAR_CONFIG extends NetSDKLib.SdkStructure {
    /**
     *  角度，用于修正雷达探头安装的角度造成的速度误差 单位度，范围0~45
     */
    public int    nAngle;

    /**
     *  是否启用低限速，为 TRUE NET_RADAR_CARSPEED_INFO 结构中各下限值有效
     */
    public boolean    bLowSpeed;

    /**
     *  是否启用大小车限速，为 FALSE 时仅小车速度配置（stuSmallCarSpeed）有效
     */
    public boolean    bSpeedForSize;

    /**
     *  小车速度配置，bSpeedForSize 为 TRUE 时 nTriggerLower 成员同时也代表中车和大车的触发值下限
     */
    public NET_RADAR_CARSPEED_INFO    stuSmallCarSpeed;

    /**
     *  中车速度配置，bSpeedForSize 为 TRUE 时有效，但 nTriggerLower 成员始终无效
     */
    public NET_RADAR_CARSPEED_INFO    stuMediumCarSpeed;

    /**
     *  大车速度配置，bSpeedForSize 为 TRUE 时有效，但 nTriggerLower 成员始终无效
     */
    public NET_RADAR_CARSPEED_INFO    stuBigCarSpeed;

    /**
     *  设备安装地址
     */
    public byte[]    szName = new byte[256];

    /**
     *  灵敏度 范围0~5，0最高
     */
    public int    nSensitivity;

    /**
     *  检测模式，取值：-1 无意义 0 前向来车 1 前向去车 2 后向来车 3 后向去车 4 前向双向 5 后向双向
     */
    public int    nDetectMode;

    /**
     *  保留字节
     */
    public byte[]    bReserved = new byte[1024];

}
