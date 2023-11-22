package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author ： 47040
 * @since ： Created in 2020/8/27 16:35
 */
public class NETDEV_VIRTUALCAMERA_STATE_INFO  extends NetSDKLib.SdkStructure {

    /**
     * 结构体大小
     */
    public int                  nStructSize;
    /**
     * 通道号
     */
    public int                  nChannelID;
    /**
     * 连接状态 {@link NetSDKLib.CONNECT_STATE}
     */
    public int                  emConnectState;
    /**
     * 此虚拟摄像头所连接的POE端口号,0表示不是POE连接
     */
    public int                  uiPOEPort;
    /**
     * 设备名称
     */
    public byte[]               szDeviceName = new byte[64];
    /**
     * 设备类型
     */
    public byte[]               szDeviceType = new byte[128];
    /**
     * 系统版本
     */
    public byte[]               szSystemType = new byte[128];
    /**
     * 序列号
     */
    public byte[]               szSerialNo = new byte[48];
    /**
     * 视频输入
     */
    public int                  nVideoInput;
    /**
     * 音频输入
     */
    public int                  nAudioInput;
    /**
     * 外部报警
     */
    public int                  nAlarmOutput;

    public NETDEV_VIRTUALCAMERA_STATE_INFO(){
        nStructSize = this.size();
    }
}
