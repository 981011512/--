package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description 门禁的AB互锁功能, 多个门通道，只有其他B通道都关闭，唯一的A通道才打开
 * @date 2021/2/7
 */
public class CFG_ABLOCK_INFO extends NetSDKLib.SdkStructure {
  /** 最大的互锁组数 */
  public static final int CFG_MAX_ABLOCK_GROUP_NUM = 8;
  /** 使能 */
  public boolean bEnable;
  /** 有效互锁组数 */
  public int nDoors;
  /** 互锁组信息 */
  public CFG_ABLOCK_DOOR_INFO[] stuDoors =
      (CFG_ABLOCK_DOOR_INFO[]) new CFG_ABLOCK_DOOR_INFO().toArray(CFG_MAX_ABLOCK_GROUP_NUM);

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < nDoors; i++) {
      builder.append(stuDoors[i].toString()).append("\n");
    }
    return "CFG_ABLOCK_INFO{"
        + "bEnable="
        + bEnable
        + ", nDoors="
        + nDoors
        + ", stuDoors="
        + builder.toString()
        + '}';
  }
}
