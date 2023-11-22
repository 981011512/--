package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

import static com.cf.forward.dh.lib.NetSDKLib.HDBJ_MAX_OBJECTS_NUM;
import static com.cf.forward.dh.lib.constant.SDKStructureFieldLenth.SDK_MAX_DETECT_REGION_NUM;

/**
 * @author 47081
 * @version 1.0
 * @description 事件类型
 * {@link com.cf.forward.dh.lib.enumeration.EM_EVENT_IVS_TYPE#EVENT_IVS_SHOP_WINDOW_POST}(橱窗张贴事件)对应的数据块描述信息
 * @date 2020/11/16
 */
public class DEV_EVENT_SHOP_WINDOW_POST_INFO extends NetSDKLib.SdkStructure {
    /**
     * 通道号
     */
    public int nChannelID;
    /**
     * 0:脉冲 1:开始 2:停止
     */
    public byte nAction;
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
     * 智能事件规则编号，用于标示哪个规则触发的事件
     */
    public short nRuleID;
    /**
     * EM_CLASS_TYPE,智能事件所属大类
     */
    public int emClassType;
    /**
     * 事件对应文件信息
     */
    public NetSDKLib.NET_EVENT_FILE_INFO stuFileInfo;
    /**
     * 检测区域顶点数
     */
    public int nDetectRegionNum;
    /**
     * 检测区域
     */
    public NetSDKLib.NET_POINT[] stuDetectRegion = (NetSDKLib.NET_POINT[]) new NetSDKLib.NET_POINT().toArray(SDK_MAX_DETECT_REGION_NUM);
    /**
     * 检测到的物体个数
     */
    public int nObjectNum;
    /**
     * 检测到的物体
     */
    public NetSDKLib.NET_MSG_OBJECT[] stuObjects = (NetSDKLib.NET_MSG_OBJECT[]) new NetSDKLib.NET_MSG_OBJECT().toArray(HDBJ_MAX_OBJECTS_NUM);
    /**
     * 事件触发的预置点号，从1开始
     */
    public short nPresetID;
    /**
     * 事件触发的预置点名称
     */
    public byte[] szPresetName = new byte[64];
    /**
     * 商铺地址
     */
    public byte[] szShopAddress = new byte[256];
    /**
     * 违法持续时长，单位：秒,缺省值0表示无意义
     */
    public short nViolationDuration;
    /**
     * 抓图标志(按位),具体见 NET_RESERVED_COMMON
     */
    public int dwSnapFlagMask;
    /**
     * 保留字节
     */
    public byte[] bReserved = new byte[1024];
}
