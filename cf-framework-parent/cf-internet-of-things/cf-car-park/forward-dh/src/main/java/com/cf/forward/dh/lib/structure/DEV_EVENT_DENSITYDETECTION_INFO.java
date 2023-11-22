package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.NetSDKLib.DH_MSG_OBJECT;
import com.cf.forward.dh.lib.NetSDKLib.DH_POINT;
import com.cf.forward.dh.lib.NetSDKLib.EVENT_INTELLI_COMM_INFO;
import com.cf.forward.dh.lib.NetSDKLib.NET_EVENT_FILE_INFO;

/**
 * 事件类型EVENT_IVS_DENSITYDETECTION(人员密集度检测)对应的数据块描述信息
 *
 * @author 119178
 */
public class DEV_EVENT_DENSITYDETECTION_INFO extends NetSDKLib.SdkStructure {
  /** 通道号 */
  public int nChannelID;
  /** 事件名称 */
  public byte[] szName = new byte[128];
  /** 字节对齐 */
  public byte[] bReserved1 = new byte[4];
  /** 时间戳(单位是毫秒) */
  public double PTS;
  /** 事件发生的时间 */
  public NET_TIME_EX UTC;
  /** 事件ID */
  public int nEventID;
  /** 检测到的物体个数 */
  public int nObjectNum;
  /** 检测到的物体列表 */
  public DH_MSG_OBJECT[] stuObjectIDs = (DH_MSG_OBJECT[]) new DH_MSG_OBJECT().toArray(16);
  /** 事件对应文件信息 */
  public NET_EVENT_FILE_INFO stuFileInfo;
  /** 事件动作,0表示脉冲事件,1表示持续性事件开始,2表示持续性事件结束; */
  public byte bEventAction;
  /** 保留字节 */
  public byte[] byReserved = new byte[2];
  /** 图片的序号, 同一时间内(精确到秒)可能有多张图片, 从0开始 */
  public byte byImageIndex;
  /** 规则检测区域顶点数 */
  public int nDetectRegionNum;
  /** 规则检测区域 */
  public DH_POINT[] DetectRegion = (DH_POINT[]) new DH_POINT().toArray(20);
  /** 抓图标志(按位),具体见NET_RESERVED_COMMON */
  public int dwSnapFlagMask;
  /** 事件源设备上的index,-1表示数据无效 */
  public int nSourceIndex;
  /** 事件源设备唯一标识,字段不存在或者为空表示本地设备 */
  public byte[] szSourceDevice = new byte[260];
  /** 事件触发累计次数 */
  public int nOccurrenceCount;
  /** 智能事件公共信息 */
  public EVENT_INTELLI_COMM_INFO stuIntelliCommInfo;
  /** 密度检测数值单位(0-Level,1-Percent) */
  public int nUnit;
  /** 密度值，单位为Level时，取值0~3，分别表示(很稀疏，稀疏，密集，很密集)单位为Percent时，取值0~100 */
  public int nValue;
  /** 保留字节,留待扩展. */
  public byte[] bReserved = new byte[612];
}
