package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.EM_DRIVING_DIRECTION;

/**
 * @author ： 47040
 * @since ： Created in 2020/8/19 10:30
 */
public class DEV_EVENT_CAR_DRIVING_IN_OUT_INFO {
    /**
     * 通道号
     */
    public int nChannelID;
    /**
     * 事件ID
     */
    public int nEventID;
    /**
     * 事件名称
     */
    public byte[] szName = new byte[128];
    /**
     * 时间戳(单位是毫秒)
     */
    public double PTS;
    /**
     * 事件发生的时间
     */
    public NET_TIME_EX UTC;
    /**
     * 车牌信息
     */
    public NetSDKLib.DH_MSG_OBJECT stuObject;
    /**
     * 车身信息
     */
    public NetSDKLib.DH_MSG_OBJECT stuVehicle;
    /**
     * 事件对应文件信息
     */
    public NetSDKLib.NET_EVENT_FILE_INFO stuFileInfo;
    /**
     * 表示抓拍序号,如3-2-1/0,1表示抓拍正常结束,0表示抓拍异常结束
     */
    public int nSequence;
    /**
     * 帧序号
     */
    public int nFrameSequence;
    /**
     * 车辆行驶方向 {@link EM_DRIVING_DIRECTION}
     */
    public int emDrivingDirection;
    /**
     * 大图信息
     */
    public NetSDKLib.NET_EVENT_IMAGE_OFFSET_INFO stuGlobalScene;
    /**
     * 车位抠图信息
     */
    public NetSDKLib.NET_EVENT_IMAGE_OFFSET_INFO stuParkingImage;
    /**
     * 车位(地磁)编号
     */
    public byte[] szParkingNum = new byte[32];
    /**
     * 0:脉冲
     */
    public int nAction;
    /**
     * 预留字节
     */
    public byte[] byReserved = new byte[508];
}
