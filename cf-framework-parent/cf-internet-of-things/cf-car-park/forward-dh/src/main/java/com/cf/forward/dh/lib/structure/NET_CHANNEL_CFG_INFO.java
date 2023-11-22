package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.EM_ENTRY_DIRECTION;
import com.cf.forward.dh.lib.enumeration.EM_ENTRY_TYPE;
import com.sun.jna.Pointer;

/**
 * @author 251823
 * @version 1.0
 * @description 通道信息
 * @date 2020/11/06
 */
public class NET_CHANNEL_CFG_INFO extends NetSDKLib.SdkStructure {
  /** 上报的相机编号 */
  public int nCameraNo;

  /** 进口方向{@link EM_ENTRY_DIRECTION} */
  public int emEntryDirection;

  /** 进口类型{@link EM_ENTRY_TYPE} */
  public int[] emEntryType = new int[16];
  /** 进口类型个数 */
  public int nRetEntryTypeNum;

  /** 车道号 */
  public int nLaneNo;
  /** 上报的相机编号，用户分配内存,int类型 */
  public Pointer pCameraNo;
  /** pCameraNo 个数 */
  public int nCameraCount;
  /** 返回的 pCameraNo 个数，获取时有效，设置时无效 */
  public int nCameraCountRet;
  /** 保留字节 */
  public byte[] byReserved = new byte[940];
}
