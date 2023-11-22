package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

import java.util.Arrays;

/**
 * @description: (倒地报警事件)对应数据块描述信息
 * @author: 251589
 * @time: 2020/11/25 19:16
 */
public class DEV_EVENT_TUMBLE_DETECTION_INFO extends NetSDKLib.SdkStructure {
    /**
     * 通道号
     */
    public int nChannelID;

    /**
     * #define DH_EVENT_NAME_LEN   128  事件名称
     */
    public byte[] szName = new byte[128];

    /**
     * 事件动作,1表示持续性事件开始,2表示持续性事件结束;
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
     * UTC时间对应的毫秒数
     */
    public int UTCMS;

    /**
     * 智能事件所属大类
     */
    public int emClassType;

    /**
     * 目标ID
     */
    public int nObjectID;

    /**
     *  物体类型,支持以下:"Unknown", "Human", "Vehicle", "Fire", "Smoke", "Plate", "HumanFace",
     * 	"Container", "Animal", "TrafficLight", "PastePaper", "HumanHead", "BulletHole", "Entity"
     *  #define DH_COMMON_STRING_16  16  // 通用字符串长度16
     */
    public byte[] szObjectType = new byte[16];

    /**
     * 智能物体全局唯一物体标识
     * 有效数据位21位，包含’\0’
     * 前2位%d%d:01-视频片段, 02-图片, 03-文件, 99-其他
     * 中间14位YYYYMMDDhhmmss:年月日时分秒
     * 	后5位%u%u%u%u%u：物体ID，如00001
     */
    public NetSDKLib.NET_RECT stuBoundingBox;

    /**
     * 保留字节
     */

    public byte[] bReserved = new byte[1002];

    @Override
    public String toString() {
        return "(倒地报警事件)对应数据块描述信息 DEV_EVENT_TUMBLE_DETECTION_INFO{" +
                "通道号 =" + nChannelID +
                ", 事件名称 =" + Arrays.toString(szName) +
                ", 事件动作 =" + nAction +
                ", 时间戳（毫秒） =" + PTS +
                ", 事件发生的时间 =" + UTC +
                ", 事件ID =" + nEventID +
                ", UTC时间对应的毫秒数 =" + UTCMS +
                ", 智能事件所属大类 =" + emClassType +
                ", 目标ID =" + nObjectID +
                ", 物体类型 =" + Arrays.toString(szObjectType) +
                ", 物体包围盒 =" + stuBoundingBox +
                ", 保留字节 =" + Arrays.toString(bReserved) +
                '}';
    }

}
