package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
/**
 * @author 251823
 * @description 联动业务大类选项
 * @date 2021/01/11
 */
public class CFG_LINK_CLASS_TYPE extends NetSDKLib.SdkStructure{
	
	/**
	 * 待级联的业务所在通道号
	 */
	public int nChannel;
	
	/**
	 * 待级联的业务大类,参考{ @link NetSDKLib.EM_SCENE_TYPE}
	 */
	public int emClassType;
	
	/**
	 * 联动状态下是否支持全时检测
	 */
	public int bSupportAllTimeWork;
	
	/**
	 * 预留字段
	 */
	public byte[] byReserved = new byte[252];
}
