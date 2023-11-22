package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.sun.jna.Callback;
import com.sun.jna.Pointer;

/**
 * @author 47081
 * @version 1.0
 * @description CLIENT_StartRedirectServiceEx接口输入参数, {@link
 *     com.cf.forward.dh.lib.NetSDKLib#CLIENT_StartRedirectServiceEx(Pointer, Pointer)}
 * @date 2021/3/13
 */
public class NET_IN_START_REDIRECT_SERVICE extends NetSDKLib.SdkStructure {
  /** 结构体大小, 需要赋值为当前结构体所在大小 */
  public int dwSize;
  /** 预留字节 */
  public byte[] byReserved = new byte[4];
  /** 主动注册重定向服务器IP */
  public byte[] szIP = new byte[64];
  /** 主动注册重定向服务器端口 */
  public short nPort;
  /** 预留字节 */
  public byte[] byReserved1 = new byte[6];
  /** 设备重定向回调函数(扩展) */
  public Callback cbFuncEx;
  /** 用户参数, 与fRedirectServerCallBackEx绑定 */
  public Pointer dwUserData;

  /**
   * DWORD dwSize; // 结构体大小, 需要赋值为当前结构体所在大小
   * BYTE byReserved[4]; // 预留字节
   * char szIP[64]; //
   * 主动注册重定向服务器IP WORD nPort; // 主动注册重定向服务器端口
   * BYTE byReserved1[6]; // 预留字节
   * fRedirectServerCallBackEx
   * cbFuncEx; // 设备重定向回调函数(扩展) LDWORD dwUserData; // 用户参数, 与fRedirectServerCallBackEx绑定
   */
  public NET_IN_START_REDIRECT_SERVICE() {
    this.dwSize = this.size();
  }
}
