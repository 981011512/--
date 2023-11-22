package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

import static com.cf.forward.dh.lib.constant.SDKStructureFieldLenth.MAX_EVENT_NAME_LEN;

/**
 * 事件类型 (车间距过小报警事件）对应的数据块描述信息
 * {@link NetSDKLib#EVENT_IVS_TRAFFIC_CARDISTANCESHORT}
 *
 * @author ： 47040
 * @since ： Created in 2020/12/12 11:46
 */
public class DEV_EVENT_TRAFFIC_CARDISTANCESHORT_INFO extends NetSDKLib.SdkStructure {
    /**
     * 通道号
     */
    public int nChannelID;
    /**
     * 保留字节，为了对齐
     */
    public byte[] byReserved = new byte[4];
    /**
     * 事件名称
     */
    public byte[] szName = new byte[MAX_EVENT_NAME_LEN];
    /**
     * 时间戳(单位是毫秒)
     */
    public double dbPTS;
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
     * 车道号
     */
    public int nLane;
    /**
     * 表示抓拍序号,如 3,2,1/0  1 表示抓拍结束,0 表示异常结束
     */
    public int nSequence;
    /**
     * 车辆信息
     */
    public NetSDKLib.DEV_EVENT_TRAFFIC_TRAFFICCAR_INFO stTrafficCar;
    /**
     * 事件对应文件信息
     */
    public NetSDKLib.NET_EVENT_FILE_INFO stuFileInfo;
    /**
     * 保留字节
     */
    public byte[] byReserved1 = new byte[1024];
    /**
     * 公共信息
     */
    public NetSDKLib.EVENT_COMM_INFO stCommInfo;
}