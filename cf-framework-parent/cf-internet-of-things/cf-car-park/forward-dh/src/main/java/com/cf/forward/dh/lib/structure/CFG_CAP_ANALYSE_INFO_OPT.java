package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
/**
 * @author 251823
 * @description 视频分析能力集 简化结构体,用于查询IPC是否有人脸识别能力 
 * @date 2021/01/12
 */
public class CFG_CAP_ANALYSE_INFO_OPT extends NetSDKLib.SdkStructure{
	
	/**
	 * 支持的场景个数
	 */
	public int nSupportedSceneNum;	
	
	/**
	 * 支持的场景列表
	 */
	public MaxNameByteArrInfo[] szSceneName = (MaxNameByteArrInfo[])new MaxNameByteArrInfo().toArray(NetSDKLib.MAX_SCENE_LIST_SIZE);
	
	public CFG_CAP_ANALYSE_INFO_OPT() {
		for (int i = 0; i < szSceneName.length; i++) {
			szSceneName[i] = new MaxNameByteArrInfo();
		}
	}
}
