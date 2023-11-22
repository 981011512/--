package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description 电视墙输出模式信息
 * @date 2021/2/22
 */
public class AV_CFG_MONITOR_WALL_OUT_MODE_INFO extends NetSDKLib.SdkStructure {
  /** 水平分辨率 */
  public int nWidth;
  /** 垂直分辨率 */
  public int nHeight;
  /** 保留字节 */
  public byte[] byReserved = new byte[256];
}
