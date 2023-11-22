package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

public class NET_OUT_STORAGE_DEV_INFOS extends NetSDKLib.SdkStructure {
	
	public NET_OUT_STORAGE_DEV_INFOS() {
		
		System.out.println("NET_OUT_STORAGE_DEV_INFOS " + this.size());
		
		this.dwSize = this.size();
		
		for (int i = 0; i < stuStoregeDevInfos.length; i++) {
			stuStoregeDevInfos[i] = new NET_STORAGE_DEVICE();
		}
	}
	
    public int                		dwSize;
    public int                 		nDevInfosNum;                       				//获取到设备的存储模块名数量
    //public NET_STORAGE_DEVICE[] 	stuStoregeDevInfos = (NET_STORAGE_DEVICE[])new NET_STORAGE_DEVICE().toArray(128); 	//设备名列表
    
    public NET_STORAGE_DEVICE[] 	stuStoregeDevInfos = new NET_STORAGE_DEVICE[128];//(NET_STORAGE_DEVICE[])new NET_STORAGE_DEVICE().toArray(128); 	//设备名列表
}
