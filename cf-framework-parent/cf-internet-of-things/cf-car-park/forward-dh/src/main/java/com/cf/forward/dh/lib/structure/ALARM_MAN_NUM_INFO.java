package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib.MAN_NUM_LIST_INFO;
import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;
/**
 * @description 立体视觉区域内人数统计报警
 * @author 119178
 * @date 2021/3/18
 */
public class ALARM_MAN_NUM_INFO extends SdkStructure{
	/**
	 * 通道号
	 */
	public int							nChannel;	
	/**
	 * 事件动作,1表示持续性事件开始,2表示持续性事件结束;
	 */
	public int                         nAction;    
	/**
	 * 事件ID
	 */
	public int					        nEventID;		
	/**
	 * 时间戳(单位是毫秒)
	 */
	public double				        dbPTS;	
	/**
	 * 事件发生的时间
	 */
	public NET_TIME_EX			        stuTime;			 		
	/**
	 * 区域人员列表数量
	 */
	public int							nManListCount;		
	/**
	 * 区域内人员列表
	 */
	public MAN_NUM_LIST_INFO[]			stuManList =(MAN_NUM_LIST_INFO[]) new MAN_NUM_LIST_INFO().toArray(64);
	/**
	 * 事件名称
	 */
	public byte []						szName=new byte[128];	
	/**
	 * 变化前人数（邮储银行智能项目定制）
	 */
	public int						nPrevNumber;			
	/**
	 * 当前人数（邮储银行智能项目定制）
	 */
	public int						nCurrentNumber;	
	/**
	 * 规则名称
	 */
	public byte []						szRuleName=new byte[128];
	/**
	 * 保留字节
	 */
	public byte []                        byReserved= new byte[760];    		
}
