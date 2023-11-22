package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

public class NET_OUT_STARTSERACH_DEVICE extends NetSDKLib.SdkStructure {

	/**
	 *  结构体大小
	 */
	public 	int                   dwSize;							
	
	public NET_OUT_STARTSERACH_DEVICE()
	    {
	     this.dwSize = this.size();
	    }// 此结构体大小
}
