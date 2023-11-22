package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description 立体行为场景能力特有字段
 * @date 2021/01/11
 */
public class CFG_STEREO_BEHAVIOR_SCENE_CAPS extends NetSDKLib.SdkStructure{
	
	/**
	 * 可查询事件的个数
	 */
	public int nEventListNum;
	
	/**
	 * 该大类下支持哪些事件可查询当前点的上一次事件内容，事件详见-智能分析事件类型
	 */
	public int[] dwOnlyFindLastEventList = new int[32];
	
    /**
     *  预留
     */
    public byte[] byReserved = new byte[892];	

}
