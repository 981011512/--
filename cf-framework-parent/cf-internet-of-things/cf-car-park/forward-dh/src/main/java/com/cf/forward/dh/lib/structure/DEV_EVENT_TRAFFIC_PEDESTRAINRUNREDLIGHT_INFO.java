package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

import java.text.NumberFormat;

/**
 * @author 47081
 * @version 1.0
 * @description 事件类型
 * {@link com.cf.forward.dh.lib.enumeration.EM_EVENT_IVS_TYPE#EVENT_IVS_TRAFFIC_PEDESTRAINRUNREDLIGHT}
 * (交通-行人闯红灯事件)对应的数据块描述信息
 * @date 2020/10/14
 */
public class DEV_EVENT_TRAFFIC_PEDESTRAINRUNREDLIGHT_INFO extends NetSDKLib.SdkStructure {
    /**
     * 通道号
     */
    public int nChannelID;
    /**
     * 事件名称
     */
    public byte[] szName = new byte[128];
    /**
     * 字节对齐
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
     * 对应车道号
     */
    public int nLane;
    /**
     * 行人信息
     */
    public NetSDKLib.NET_MSG_OBJECT stuObject;
    /**
     * 事件对应文件信息
     */
    public NetSDKLib.NET_EVENT_FILE_INFO stuFileInfo;
    /**
     * 表示抓拍序号,如3,2,1,1表示抓拍结束,0表示异常结束
     */
    public int nSequence;
    /**
     * 事件动作,0表示脉冲事件,1表示持续性事件开始,2表示持续性事件结束;
     */
    public byte bEventAction;
    public byte[] byReserved = new byte[2];
    /**
     * 图片的序号, 同一时间内(精确到秒)可能有多张图片, 从0开始
     */
    public byte byImageIndex;
    /**
     * 抓图标志(按位),具体见
     * {@link NetSDKLib.NET_RESERVED_COMMON}
     */
    public int dwSnapFlagMask;
    /**
     * 对应图片的分辨率
     */
    public NetSDKLib.NET_RESOLUTION_INFO stuResolution;
    /**
     * 保留字节
     */
    public byte[] bReserved = new byte[1024];
    /**
     * 公共信息
     */
    public NetSDKLib.EVENT_COMM_INFO stCommInfo;

    @Override
    public String toString() {
        NumberFormat nf=NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        return "行人闯红灯事件,DEV_EVENT_TRAFFIC_PEDESTRAINRUNREDLIGHT_INFO{" +
                "通道号=" + nChannelID +
                ", 事件名称=" + new String(szName).trim() +
                ", 时间戳=" + nf.format(PTS) +
                ", 事件发生的时间=" + UTC.toStringTime() +
                ", 事件ID=" + nEventID +
                ", 车道号=" + nLane +
                ", 行人信息={ nAction:"+stuObject.nAction+",szObjectType=" + new String(stuObject.szObjectType).trim()+",szObjectSubType:"+new String(stuObject.szObjectSubType).trim() +
                "}, 文件信息=" + stuFileInfo +
                ", 抓拍序号=" + nSequence +
                ", 事件动作=" + bEventAction +
                ", 图片序号=" + byImageIndex +
                ", 抓图标志=" + dwSnapFlagMask +
                ", 图片的分辨率=" + stuResolution.toString() +
                ", 公共信息= { emSnapCategory:" + stCommInfo.emSnapCategory +'}'+
                '}';
    }
}
