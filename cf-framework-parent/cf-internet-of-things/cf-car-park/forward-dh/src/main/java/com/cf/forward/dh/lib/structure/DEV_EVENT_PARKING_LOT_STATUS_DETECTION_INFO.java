package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 事件类型 EVENT_IVS_PARKING_LOT_STATUS_DETECTION(室外停车位状态检测)对应的数据块描述信息
 *
 * @author ： 47040
 * @since ： Created in 2020/8/14 18:56
 */
public class DEV_EVENT_PARKING_LOT_STATUS_DETECTION_INFO extends NetSDKLib.SdkStructure {
    /**
     * 通道号
     */
    public int nChannelID;
    /**
     * 1:开始 2:停止
     */
    public int nAction;
    /**
     * 事件名称
     */
    public byte[] szName = new byte[128];
    /**
     * 智能事件所属大类 {@link NetSDKLib.EM_CLASS_TYPE}
     */
    public int emClassType;
    /**
     * 事件发生的时间
     */
    public NET_TIME_EX UTC;
    /**
     * 时间戳(单位是毫秒)
     */
    public double PTS;
    /**
     * 事件ID
     */
    public int nEventID;
    /**
     * 智能事件规则编号，用于标示哪个规则触发的事件
     */
    public int nRuleID;
    /**
     * 帧序号
     */
    public int nSequence;
    /**
     * 室外停车位个数
     */
    public int nParkingStatusNum;
    /**
     * 室外停车位状态
     */
    public NetSDKLib.NET_PARKING_STATUS[] stuParkingStatus = new NetSDKLib.NET_PARKING_STATUS[100];
    /**
     * 全景广角图
     */
    public NetSDKLib.SCENE_IMAGE_INFO_EX stuSceneImage;
    /**
     * 预留字节
     */
    public byte[] byReserved = new byte[1020];

    public DEV_EVENT_PARKING_LOT_STATUS_DETECTION_INFO() {
        for (int i = 0; i < stuParkingStatus.length; i++) {
            stuParkingStatus[i] = new NetSDKLib.NET_PARKING_STATUS();
        }
    }
}
