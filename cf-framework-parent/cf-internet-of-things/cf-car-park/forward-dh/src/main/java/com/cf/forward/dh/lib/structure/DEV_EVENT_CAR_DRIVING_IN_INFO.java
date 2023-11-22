package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.EM_CAPTURE_PROCESS_END_TYPE;
import com.cf.forward.dh.lib.enumeration.EM_TRIGGER_TYPE;

/**
 * @author ： 47040
 * @since ： Created in 2020/8/19 10:08
 */
public class DEV_EVENT_CAR_DRIVING_IN_INFO extends NetSDKLib.SdkStructure {
    /**
     * 通道号
     */
    public int nChannelID;
    /**
     * 0:脉冲
     */
    public int nAction;
    /**
     * 事件名称
     */
    public byte[] szName = new byte[128];
    /**
     * 时间戳(单位:毫秒)
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
     * 检测到的车牌信息
     */
    public NetSDKLib.DH_MSG_OBJECT stuObject;
    /**
     * 检测到的车辆信息
     */
    public NetSDKLib.DH_MSG_OBJECT stuVehicle;
    /**
     * 触发类型 {@link EM_TRIGGER_TYPE}
     */
    public int emTriggerType;
    /**
     * 标记抓拍帧
     */
    public int nMark;
    /**
     * 视频分析的数据源地址
     */
    public int nSource;
    /**
     * 视频分析帧序号
     */
    public int nFrameSequence;
    /**
     * 车道号
     */
    public int nLaneID;
    /**
     * 车速(单位:km/h)
     */
    public int nSpeed;
    /**
     * 交通车辆的数据库记录
     */
    public NetSDKLib.DEV_EVENT_TRAFFIC_TRAFFICCAR_INFO stuTrafficCar;
    /**
     * 公共信息
     */
    public NetSDKLib.EVENT_COMM_INFO stuCommInfo;
    /**
     * 抓拍过程 {@link EM_CAPTURE_PROCESS_END_TYPE}
     */
    public int emCaptureProcess;
    /**
     * 保留字节
     */
    public byte[] bReserved = new byte[1020];
}
