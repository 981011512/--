package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;

public class NET_IN_SET_PARK_CONTROL_INFO  extends SdkStructure{
	/**
	 * 结构体大小
	 */
	public int					dwSize;					
	/**
	 * 屏幕信息个数
	 */
	public int						nScreenShowInfoNum;		
	/**
	 * 屏幕信息
	 */
	public NET_SCREEN_SHOW_INFO[]	stuScreenShowInfo=(NET_SCREEN_SHOW_INFO[]) new NET_SCREEN_SHOW_INFO().toArray(16);	
	/**
	 * 字节补齐
	 */
	public byte[]					byReserved=new byte[4];			
	/**
	 * 播报信息个数
	 */
	public int						nBroadcastInfoNum;		
	/**
	 * 播报信息
	 */
	public NET_BROADCAST_INFO[]		stuBroadcastInfo =(NET_BROADCAST_INFO[]) new NET_BROADCAST_INFO().toArray(16);	 
	
	public NET_IN_SET_PARK_CONTROL_INFO() {
        this.dwSize = this.size();
    }
}
