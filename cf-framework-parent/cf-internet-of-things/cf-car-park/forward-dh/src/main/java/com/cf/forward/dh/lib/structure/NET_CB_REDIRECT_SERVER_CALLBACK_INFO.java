package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description fRedirectServerCallBackEx输入参数
 * @date 2021/3/13
 */
public class NET_CB_REDIRECT_SERVER_CALLBACK_INFO extends NetSDKLib.SdkStructure {
  /** 主动注册重定向服务器接收到的设备IP */
  public String szIP;
  /** 主动注册重定向服务器接收到的设备端口 */
  public int nPort;
  /** 主动注册重定向服务器接收到的设备ID */
  public byte[] szDeviceID = new byte[256];
  /** 预留字节 */
  public byte[] byReserved = new byte[1024];
}
