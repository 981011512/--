package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description 活跃度统计规则
 * @date 2021/01/11
 */
public class CFG_ACTIVITY_ANALYSE_CAPS extends NetSDKLib.SdkStructure{
	
	/**
	 * 是否支持本地数据存储
	 */
	public int bSupportLocalDataStore;
	
	/**
	 * 该规则支持的最大规则数
	 */
	public int nMaxRules;
	
	/**
	 * 预留字段
	 */
	public byte[] byReserved = new byte[256];

}
