package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 事件类型(道路安全预警)对应的数据块描述信息
 * {@link NetSDKLib#EVENT_IVS_TRAFFIC_ROAD_ALERT}
 *
 * @author ： 47040
 * @since ： Created in 2020/12/12 15:03
 */
public class DEV_EVENT_TRAFFIC_ROAD_ALERT_INFO extends NetSDKLib.SdkStructure {
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
     * 车牌信息
     */
    public NetSDKLib.DH_MSG_OBJECT stuObject;
    /**
     * 车身信息
     */
    public NetSDKLib.DH_MSG_OBJECT stuVehicle;
    /**
     * 交通车辆信息
     */
    public NetSDKLib.DEV_EVENT_TRAFFIC_TRAFFICCAR_INFO stTrafficCar;
    /**
     * 事件组ID，同一辆车抓拍过程内GroupID相同
     */
    public int nGroupID;
    /**
     * 一个事件组内的抓拍张数
     */
    public int nCountInGroup;
    /**
     * 一个事件组内的抓拍序号
     */
    public int nIndexInGroup;
    /**
     * 对应车道号
     */
    public int nLane;
    /**
     * 公共信息
     */
    public NetSDKLib.EVENT_COMM_INFO stCommInfo;
    /**
     * 事件对应文件信息
     */
    public NetSDKLib.NET_EVENT_FILE_INFO stFileInfo;
    /**
     * 表示抓拍序号,如3,2,1. 1表示抓拍结束,0表示异常结束
     */
    public int nSequence;
    /**
     * 预留字段
     */
    public byte[] byReserved = new byte[1020];
}
