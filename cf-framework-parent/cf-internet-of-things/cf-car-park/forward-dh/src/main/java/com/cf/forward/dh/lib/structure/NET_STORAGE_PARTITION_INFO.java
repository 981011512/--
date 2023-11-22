package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description 设备存储分区信息
 * @date 2021/01/21
 */
public class NET_STORAGE_PARTITION_INFO extends NetSDKLib.SdkStructure{
	
	/**
	 * 分区是否异常
	 */
	public int bError;
	
	/**
	 * 分区属性类型,参考枚举{ @link EM_PARTITION_TYPE }
	 */
	public int emType;
	
	/**
	 * 分区总空间，单位字节
	 */
	public double dTotalBytes;
	
	/**
	 * 分区使用空间
	 */
	public double dUsedBytes;
	
	/**
	 * 分区名字
	 */
	public byte[] szPath = new byte[128];
	
	/**
	 * 保留字节
	 */
	public byte[] byReserved = new byte[128];
	
}
