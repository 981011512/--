package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;

/** 事件类型 EVENT_IVS_WANDERDETECTION( 徘徊事件)对应的规则配置 */
public class NET_WANDERDETECTION_RULE_INFO extends SdkStructure {
  /** 检测区域顶点数 */
  public int nDetectRegionPoint;
  /** 检测区域 */
  public POINTCOORDINATE[] stuDetectRegion = (POINTCOORDINATE[]) new POINTCOORDINATE().toArray(20);
  /** 触发报警位置数 */
  public int nTriggerPosition;
  /** 触发报警位置,0-目标外接框中心, 1-目标外接框左端中心, 2-目标外接框顶端中心, 3-目标外接框右端中心, 4-目标外接框底端中心 */
  public byte[] bTriggerPosition = new byte[8];
  /** 触发报警的徘徊或滞留人数 */
  public int nTriggerTargetsNumber;
  /** 最短持续时间 单位：秒，0~65535 */
  public int nMinDuration;
  /** 报告时间间隔,单位秒 0~600;等于0表示不重复报警, 默认值30 */
  public int nReportInterval;
  /** 跟踪持续时间,0秒:一直跟踪,1~300秒:跟踪持续时间 */
  public int nTrackDuration;
  /** 规则特定的尺寸过滤器是否有效 */
  public boolean bSizeFileter;
  /** 规则特定的尺寸过滤器 */
  public NET_CFG_SIZEFILTER_INFO stuSizeFileter;
  /** 保留字节 */
  public byte[] byReserved = new byte[4096];
}
