package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description 硬盘操作
 * @date 2021/1/27
 */
public class DISKCTRL_PARAM extends NetSDKLib.SdkStructure {
  /** 结构体大小,版本控制用 */
  public int dwSize;
  /** 为硬盘信息结构体DH_HARDDISK_STATE里的数组stDisks下标,从0开始 */
  public int nIndex;
  /** 操作类型, 0 - 清除数据,1 - 设为读写盘, 2 - 设为只读盘,3 - 设为冗余盘, 4 - 恢复错误, 5 - 设为快照盘,7 - 弹出SD卡（对SD卡操作有效） */
  public int ctrlType; //
  /** 磁盘信息, 由于磁盘顺序可能改变导致下标不准, 用来代替下标 */
  public NetSDKLib.NET_DEV_DISKSTATE stuDisk;

  public DISKCTRL_PARAM() {
    this.dwSize = this.size();
  }
}
