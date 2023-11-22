package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description 事件类型EVENT_IVS_FIRE_LANE_DETECTION (消防占道检测事件)对应的数据块描述信息
 * @date 2021/03/12
 */
public class DEV_EVENT_FIRE_LANE_DETECTION_INFO extends NetSDKLib.SdkStructure {
	 /**
     *  通道号
     */
    public int nChannelID;

    /**
     *  1:开始，2:停止
     */
    public int nAction;

    /**
     *  事件名称
     */
    public byte[] szName = new byte[128];

    /**
     *  时间戳(单位是毫秒)
     */
    public double PTS;

    /**
     *  事件发生的时间
     */
    public NET_TIME_EX UTC;

    /**
     *  事件ID
     */
    public int nEventID;

    /**
     *  帧序号
     */
    public int nSequence;

    /**
     *  规则编号
     */
    public int nRuleID;

    /**
     *  检测到的物体个数
     */
    public int nObjectNum;

    /**
     *  检测到的物体
     */
    public NetSDKLib.NET_MSG_OBJECT[] stuObjects = (NetSDKLib.NET_MSG_OBJECT[]) new NetSDKLib.NET_MSG_OBJECT().toArray(64);
    /**
     *  事件对应文件信息
     */
    public NetSDKLib.NET_EVENT_FILE_INFO stuFileInfo;

    /**
     *  stuSceneImage 是否有效
     */
    public int bSceneImage;

    /**
     *  全景广角图
     */
    public NetSDKLib.SCENE_IMAGE_INFO_EX stuSceneImage;

    /**
     *  预留字段
     */
    public byte[] bReserved = new byte[1020];

}
