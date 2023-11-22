package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;

/**
 * 
 * @author 119178
 *
 */
public class NET_COMPOSE_PLAN_DETAIL_INFO  extends SdkStructure {
	/**
	 * 预案名称, 用户自定义
	 */
	public byte[]              szName=new byte[64];                 
	/**
	 * 分割模式(参考NET_SPLIT_MODE)
	 */
	public int                 emSplitMode;			                
	/**
	 * 分割模式下的各子窗口有效个数
	 */
	public int                 nChannelCombinationNum;              
	/**
	 * 分割模式下的各子窗口显示内容; 
	 */
	public int[]               nChannelCombination=new int[64];     
	/**
	 * 输出音频通道个数
	 */
	public int                 nAudioOutNum;                        
	/**
	 * 输出音频通道信息
	 */
	public int[]               nAudioOutChn=new int[4];             
	/**
	 * 保留字节
	 */
	public byte[]              bReserved=new byte[676];             
}
