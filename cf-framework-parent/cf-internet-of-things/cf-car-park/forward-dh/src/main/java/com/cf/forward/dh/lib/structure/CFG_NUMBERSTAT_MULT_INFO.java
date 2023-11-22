package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description 客流量统计PD
 * @date 2021/01/11
 */
public class CFG_NUMBERSTAT_MULT_INFO extends NetSDKLib.SdkStructure{
	
	/**
	 * 最大返回规则个数
	 */
	public int nMaxRules;
	
	/**
	 * 隐藏部分参数配置使能 true-对于StereoNumber/NumberStat算法大类，隐藏StereoCalibrate标定配置和规则的MaxHeight/MinHeight
	 */
	public int bHiddenDetailEnable;
	
	/**
	 * 相机类型，0：表示老单目客流 1：表示新统一单目客流 2：表示新统一双目客流
	 */
	public int nCameraType;
	
	/**
	 * 支持的事件类型规则个数
	 */
	public int nMaxSupportedRulesNum;
	
	/**
	 * 支持的事件类型规则列表，事件类型，详见dhnetsdk.h中"智能分析事件类型"
	 */
	public CFG_SUPPORTED_RULES_INFO[] stuSupportedRules = (CFG_SUPPORTED_RULES_INFO[])new CFG_SUPPORTED_RULES_INFO().toArray(NetSDKLib.MAX_RULE_LIST_SIZE);
	
	
	public CFG_NUMBERSTAT_MULT_INFO() {
		for (int i = 0; i < stuSupportedRules.length; i++) {
			stuSupportedRules[i] = new CFG_SUPPORTED_RULES_INFO();
		}
	}

}
