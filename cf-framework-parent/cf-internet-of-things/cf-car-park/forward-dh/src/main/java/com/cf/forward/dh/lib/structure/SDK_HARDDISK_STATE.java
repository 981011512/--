package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description 设备硬盘信息
 * @date 2021/1/27
 */
public class SDK_HARDDISK_STATE extends NetSDKLib.SdkStructure {
  /** 个数 */
  public int dwDiskNum;
  /** 硬盘或分区信息 */
  public NetSDKLib.NET_DEV_DISKSTATE[] stDisks =
      (NetSDKLib.NET_DEV_DISKSTATE[]) new NetSDKLib.NET_DEV_DISKSTATE().toArray(256);
}
