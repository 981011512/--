package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;
/**
 * 
 * @author 119178
 * 合成通道的预案分割配置 ( NET_EM_CFG_COMPOSE_PLAN )
 */
public class NET_COMPOSE_PLAN_INFO  extends SdkStructure {
	
	public int				               dwSize;
	/**
	 * 预案配置是否开启
	 */
	public int                             bEnable;  
	/**
	 * 合成通道预案有效个数
	 */
	public int                             nPlansNum;          
	/**
	 * 合成通道预案信息
	 */
	public NET_COMPOSE_PLAN_DETAIL_INFO[]  stuPlans=(NET_COMPOSE_PLAN_DETAIL_INFO[])new NET_COMPOSE_PLAN_DETAIL_INFO().toArray(4);        
	
	public NET_COMPOSE_PLAN_INFO() {
		this.dwSize = this.size();
	}
}
