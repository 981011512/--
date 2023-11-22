package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * className：DEV_RADAR_CONFIG
 * description：
 * author：251589
 * createTime：2020/12/29 10:54
 *
 * @version v1.0
 */
public class DEV_RADAR_CONFIG extends NetSDKLib.SdkStructure {
    public int    dwSize;    // 结构体大小
    public boolean    bEnable;    // 是否开启功能
    public int    nPort;    // 串口端口号
    public NET_COMM_PROP    stuCommAttr;    // 串口属性
    public int    nAddress;    // 设备地址，如果串口上挂了多个串口设备，通过地址区分
    public int    nPreSpeedWait;    // 速度先来情况下等待时间，速度来时尚未抓拍 范围 (1 -- 5000ms)
    public int    nDelaySpeedWait;    // 速度后来情况下等待时间，抓拍时还没有来速度 范围 (1 -- 5000ms)
    public boolean    bDahuaRadarEnable;    // 大华雷达配置是否可用
    public DEV_DAHUA_RADAR_CONFIG    stuDhRadarConfig;    // 大华雷达参数配置
    public boolean    bSTJ77D5RadarEnable;    // 森思泰克77Ghz网络雷达配置是否可用
    public NET_STJ77D5_RADAR_CONFIG    stuSTJ77D5RadarConfig;    // 森思泰克77Ghz网络雷达配置

    public DEV_RADAR_CONFIG(){
        this.dwSize = size();
    }
}
