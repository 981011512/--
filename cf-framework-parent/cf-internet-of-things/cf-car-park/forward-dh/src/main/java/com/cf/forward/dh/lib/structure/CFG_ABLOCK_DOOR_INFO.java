package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

import java.util.Arrays;

/**
 * @author 47081
 * @version 1.0
 * @description 门禁的AB互锁的组
 * @date 2021/2/7
 */
public class CFG_ABLOCK_DOOR_INFO extends NetSDKLib.SdkStructure {
  /** 最大的门禁的互锁门通道数 */
  public static final int CFG_MAX_ABLOCK_DOORS_NUM = 8;
  /** 有效互锁门的个数 */
  public int nDoor;
  /** 互锁的门的通道号 */
  public int[] anDoor = new int[CFG_MAX_ABLOCK_DOORS_NUM];

  @Override
  public String toString() {
    return "CFG_ABLOCK_DOOR_INFO{" +
            "nDoor=" + nDoor +
            ", anDoor=" + Arrays.toString(anDoor) +
            '}';
  }
}
