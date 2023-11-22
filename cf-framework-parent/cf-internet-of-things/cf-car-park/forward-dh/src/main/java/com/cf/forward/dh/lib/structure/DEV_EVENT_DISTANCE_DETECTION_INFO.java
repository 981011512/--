package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @description: (倒地报警事件)对应数据块描述信息
 * @author: 251589
 * @time: 2020/11/25 19:16
 */
public class DEV_EVENT_DISTANCE_DETECTION_INFO extends NetSDKLib.SdkStructure {
    /**
     * 通道号
     */
    public int nChannelID;

    /**
     * 事件名称
     */
    public byte[] szName = new byte[128];

    /**
     * 0:脉冲 1:开始 2:停止
     */
    public int nAction;

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
     * 检测到的物体
     */
    public NetSDKLib.DH_MSG_OBJECT stuObject;

    /**
     * 检测区域顶点数
     */
    public int nDetectRegionNum;

    /**
     * #define DH_MAX_DETECT_REGION_NUM 20 // 规则检测区域最大顶点数
     */
    public NetSDKLib.NET_POINT stuDetectRegion[] = new NetSDKLib.NET_POINT[20];

    /**
     * 智能事件公共信息;
     */
    public NetSDKLib.EVENT_INTELLI_COMM_INFO stuIntelliCommInfo;

    /**
     * 事件关联ID。应用场景是同一个物体或者同一张图片做不同分析，产生的多个事件的SourceID相同
     * 缺省时为空字符串，表示无此信息
     * 格式：类型+时间+序列号，其中类型2位，时间14位，序列号5位
     */
    public byte[] szSourceID = new byte[32];

    /**
     * 保留字节
     */
    public byte[] bReserved = new byte[992];
}
