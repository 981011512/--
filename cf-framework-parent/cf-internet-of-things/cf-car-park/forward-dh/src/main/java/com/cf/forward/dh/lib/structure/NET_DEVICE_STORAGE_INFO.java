package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description 设备存储信息
 * @date 2021/01/20
 */
public class NET_DEVICE_STORAGE_INFO extends NetSDKLib.SdkStructure{
	
	/**
	 * 设备名称
	 */
	public byte[] szNmae = new byte[32];
	
	/**
	 * 存储设备能否热插拔
	 */
	public int bSupportHotPlug;
	
	/**
	 * 寿命长度标识
	 */
	public float fLifePercent;
	
	/**
	 * SD卡加锁状态,参考枚举{ @link EM_SD_LOCK_STATE }
	 */
	public int emLockState;
	
	/**
	 * SD卡加密功能标识,参考枚举{ @link EM_SD_ENCRYPT_FLAG }
	 */
	public int emSDEncryptFlag;
	
	/**
	 * 健康状态标识,参考枚举{ @link EM_STORAGE_HEALTH_TYPE }
	 */
	public int emHealthType;
	
	/**
	 * 存储设备状态,参考枚举{ @link EM_STORAGE_DEVICE_STATUS }
	 */
	public int emState;
	
	/**
	 * 分区的具体信息 
	 */
	public NET_STORAGE_PARTITION_INFO[] stuPartitionInfo = new NET_STORAGE_PARTITION_INFO[12];
		
	/**
	 * 分区数量
	 */
	public int nPartition;
	
	/**
	 * 保留字节
	 */
	public byte[] byReserved = new byte[516];
	
	public NET_DEVICE_STORAGE_INFO() {
		for (int i = 0; i < stuPartitionInfo.length; i++) {
			stuPartitionInfo[i] = new NET_STORAGE_PARTITION_INFO();
		}
		
	}
	

}
