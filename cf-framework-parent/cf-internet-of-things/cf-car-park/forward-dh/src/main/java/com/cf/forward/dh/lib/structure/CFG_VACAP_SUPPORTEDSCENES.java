package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description 场景列表
 * @date 2021/01/11
 */
public class CFG_VACAP_SUPPORTEDSCENES extends NetSDKLib.SdkStructure{
	
	/**
	 * 支持的场景个数
	 */
	public int nScenes;
	
	/**
	 * 支持的场景列表
	 */
	public CFG_CAP_SCENE[] stScenes = (CFG_CAP_SCENE[])new CFG_CAP_SCENE().toArray(NetSDKLib.MAX_SCENE_LIST_SIZE);
	
	
	/**
	 * 人数统计大类场景
	 */
	public CFG_NUMBER_STAT_INFO stuNumberStat;
	
	public CFG_VACAP_SUPPORTEDSCENES() {		
		for (int i = 0; i < stScenes.length; ++i) {
			stScenes[i] = new CFG_CAP_SCENE();
		}
	}

}
