package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description 场景组合
 * @date 2021/01/11
 */
public class CFG_SUPPORTED_COMP extends NetSDKLib.SdkStructure{
	
	/**
	 * 场景组合项下支持的场景个数
	 */
	public int nSupportedData;
	
	/**
	 * 场景组合项下支持的场景列表
	 */
	 public StringByteArrSixteen[] szSupportedData = (StringByteArrSixteen[])new StringByteArrSixteen().toArray(NetSDKLib.MAX_SUPPORTED_COMP_DATA);
	 
	 public CFG_SUPPORTED_COMP() {
		 for (int i = 0; i < szSupportedData.length; i++) {
			 szSupportedData[i] = new StringByteArrSixteen();
			}
	 }
}
