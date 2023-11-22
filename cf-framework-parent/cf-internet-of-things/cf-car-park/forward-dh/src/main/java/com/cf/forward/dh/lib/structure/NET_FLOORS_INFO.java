package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description 楼层号(梯控需求)
 * @date 2021/2/8
 */
public class NET_FLOORS_INFO extends NetSDKLib.SdkStructure {
  /** 有效的楼层数量再次扩展 */
  public int nFloorNumEx2;
  /** 楼层号(梯控需求)最多不超过256个，楼层号不超过999 */
  public NET_FLOORS_EX[] szFloorEx = (NET_FLOORS_EX[]) new NET_FLOORS_EX().toArray(256);
  /** 保留字节 */
  public byte[] byReserved = new byte[512];
}
