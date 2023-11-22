package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.NetSDKLib.fSearchDevicesCBEx;
import com.sun.jna.Pointer;

public class NET_IN_STARTSERACH_DEVICE extends NetSDKLib.SdkStructure {

	   /**
	    * 结构体大小
	    */
	   public int                      dwSize; 
	   
	   /**
	    * 发起搜索的本地IP
	    */
	   public byte[]                   szLocalIp=new byte[64];
	   
	   /**
	    * 设备信息回调函数
	    */
	   public fSearchDevicesCBEx       cbSearchDevices;                 
	   
	   /**
	    * 用户自定义数据
	    */
	   public Pointer                  pUserData;                      
	   
	   /**
	    * 下发搜索类型(参考EM_SEND_SEARCH_TYPE)
	    */
	   public int                      emSendType;     
	   
	   public NET_IN_STARTSERACH_DEVICE()
	    {
	     this.dwSize = this.size();
	    }// 此结构体大小
	    
}
