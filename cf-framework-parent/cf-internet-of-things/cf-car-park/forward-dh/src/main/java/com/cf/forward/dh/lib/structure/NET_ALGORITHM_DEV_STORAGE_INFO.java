package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.EM_ALGORITHM_PARTITION_TYPE;
import com.cf.forward.dh.lib.enumeration.EM_STORAGE_PACKET_TYPE;

/**
 * @author 47081
 * @description 设备分区信息
 * @date 2021/2/20
 * @version 1.0
 */
public class NET_ALGORITHM_DEV_STORAGE_INFO extends NetSDKLib.SdkStructure {
  /** 分区打包方式,对应枚举类型为{@link EM_STORAGE_PACKET_TYPE} */
  public int emPakcetType; // 分区打包方式
  /*以下信息当emPakcetType 为EM_STORAGE_PACKET_PARTITION 时有效*/

  /** 分区起始地址 */
  public int nAddr;
  /** 分区大小，单位byte */
  public int nSize;
  /** 分区类型,对应枚举类型为{@link EM_ALGORITHM_PARTITION_TYPE} */
  public int emPartitionType;
  /** 分区块大小，单位KB */
  public int nBlock;
  /*以上信息当emPakcetType 为EM_STORAGE_PACKET_PARTITION 时有效*/
  /** 预留字节 */
  public byte[] byReserved = new byte[1020];
}
