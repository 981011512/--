package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description 获取能力的请求数据扩展
 * @date 2021/01/11
 */
public class CFG_CAP_ANALYSE_REQ_EXTEND_INFO extends NetSDKLib.SdkStructure{
	
	/**
	 * 结构体大小 
	 */
	public int dwSize;
	
	/**
	 * 智能分析实例类型,参考{ @link CFG_EM_INSTANCE_SUBCLASS_TYPE}
	 */
	public int emSubClassID;
	
	public CFG_CAP_ANALYSE_REQ_EXTEND_INFO() {
		this.dwSize = this.size();		
	}

}
