package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @version 1.0
 * @description {@link NetSDKLib#CLIENT_SetChannelCfg}的入参
 * @date 2020/11/06
 */
public class NET_IN_SET_CHANNEL_CFG extends NetSDKLib.SdkStructure {

  /** 结构体大小 */
  public int dwSize;
  /** 检测通道 */
  public int nChannelNo;

  /** 通道信息 */
  public NET_CHANNEL_CFG_INFO stuChannelInfo;

  public NET_IN_SET_CHANNEL_CFG() {
    this.dwSize = this.size();
  }
}
