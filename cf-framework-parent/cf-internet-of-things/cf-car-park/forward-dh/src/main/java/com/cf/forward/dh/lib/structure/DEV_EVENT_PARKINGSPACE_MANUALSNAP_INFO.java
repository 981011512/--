package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 事件 路侧停车位手动抓图
 * 枚举 {@link NetSDKLib#EVENT_IVS_TRAFFIC_PARKINGSPACE_MANUALSNAP}
 *
 * @author 47040
 * @since Created in 2020/11/18 14:25
 */
public class DEV_EVENT_PARKINGSPACE_MANUALSNAP_INFO extends NetSDKLib.SdkStructure {
    /**
     * 通道号
     */
    public int nChannel;
    /**
     * 事件名称
     */
    public byte[] szName = new byte[128];
    /**
     * 保留字节
     */
    public byte[] bReserved1 = new byte[4];
    /**
     * 时间戳(单位是毫秒)
     */
    public double PTS;
    /**
     * 事件发生的时间
     */
    public NET_TIME_EX UTC;
    /**
     * 事件ID
     */
    public int nEventID;
    /**
     * 事件对应文件信息
     */
    public NetSDKLib.NET_EVENT_FILE_INFO stuFileInfo;
    /**
     * 表示交通车辆的数据库记录
     */
    public NetSDKLib.DEV_EVENT_TRAFFIC_TRAFFICCAR_INFO stTrafficCar;
    /**
     * 和客户端请求的抓图序列号对应
     */
    public byte[] szSerialNo = new byte[128];
    /**
     * 有效停车个数
     */
    public int nParkingNum;
    /**
     * 停车信息
     */
    public NET_MANUALSNAP_PARKINGSPACE_INFO[] stuParkingInfo = new NET_MANUALSNAP_PARKINGSPACE_INFO[32];
    /**
     * 保留字节,留待扩展.
     */
    public byte[] bReserved = new byte[516];

    public DEV_EVENT_PARKINGSPACE_MANUALSNAP_INFO() {
        for (int i = 0; i < stuParkingInfo.length; i++) {
            stuParkingInfo[i] = new NET_MANUALSNAP_PARKINGSPACE_INFO();
        }
    }
}
