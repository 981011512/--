package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description 着火点的GPS坐标
 * @date 2021/2/22
 */
public class NET_FIRING_GPS_INFO extends NetSDKLib.SdkStructure {
  /** 经度(单位是百万分之度,范围0-360度)如东经120.178274度表示为300178274 */
  public int dwLongitude;
  /** 纬度(单位是百万分之度,范围0-180度)如北纬30.183382度表示为120183382 */
  public int dwLatidude;
  /** 高度, 单位为米 */
  public double dbAltitude;
  /** 预留32字节 */
  public byte[] szReserve = new byte[32];
}
