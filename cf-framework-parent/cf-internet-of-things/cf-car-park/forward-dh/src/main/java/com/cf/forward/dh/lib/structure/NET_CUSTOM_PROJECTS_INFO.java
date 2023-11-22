package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description 项目定制信息
 * @date 2021/2/22
 */
public class NET_CUSTOM_PROJECTS_INFO extends NetSDKLib.SdkStructure {
  /** GPS位置信息 */
  public NetSDKLib.NET_GPS_INFO stuGPSInfo;
  /** 人脸比对事件触发对应球机信息 */
  public NET_FACECOMPARISON_PTZ_INFO stuFaceComparisonPTZInfo;
  /** 人脸比对时车牌信息 */
  public byte[] szPlateNumber = new byte[64];
  /** 是否报警(天津地铁和平路站定制增加) */
  public boolean bIsAlarm;
  /** 滞留类型 0-未知 1-基础滞留 2-异常滞留 */
  public int nStayEvent;
  /** 徘徊类型 0-未知 1-基础徘徊 2-异常徘徊 */
  public int nWanderEvent;
  /** 保留字节 */
  public byte[] byReserved = new byte[1012];
}
