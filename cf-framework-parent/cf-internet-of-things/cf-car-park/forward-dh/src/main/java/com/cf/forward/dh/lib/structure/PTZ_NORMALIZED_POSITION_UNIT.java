package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description 归一化的云台控制坐标单元
 * @date 2021/2/20
 */
public class PTZ_NORMALIZED_POSITION_UNIT extends NetSDKLib.SdkStructure {
  /** 云台水平方向角度,范围[-1, 1] */
  public double dbPositionX;
  /** 云台垂直方向角度,范围[-1, 1] */
  public double dbPositionY;
  /** 云台光圈放大倍率,范围[0, 1] */
  public double dbZoom;
  /** 预留字节 */
  public byte[] szReserved = new byte[32];
}
