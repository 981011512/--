package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
/**
 * @author 251823
 * @description 支持的规则
 * @date 2021/01/11
 */
public class CFG_SUPPORTED_RULES_INFO extends NetSDKLib.SdkStructure{
	
	/**
	 * 客流量统计规则
	 */
	public CFG_NUMBERSTAT_RULE_INFO stuNumberStat;
	
	/**
	 * 排队检测规则
	 */
	public CFG_QUEUEDETECTION_RULE_INFO stuQueueDetection;
	
	/**
	 * 区域内人数统计规则
	 */
	public CFG_MANNUMDETECTION_RULE_INFO stuManNumDetection;
		
}
