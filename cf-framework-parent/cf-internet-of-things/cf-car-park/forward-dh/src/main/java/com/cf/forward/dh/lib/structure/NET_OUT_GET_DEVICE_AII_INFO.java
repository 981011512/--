package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description CLIENT_GetDeviceAllInfo 输出结构体
 * @date 2021/01/20
 */
public class NET_OUT_GET_DEVICE_AII_INFO extends NetSDKLib.SdkStructure{
	/**
     * 赋值为结构体大小
     */
    public int dwSize;
    
    /**
     * 信息的个数 
     */
    public int nInfoCount;
    
    /**
     * 设备存储信息
     */
    public NET_DEVICE_STORAGE_INFO[] stuStorageInfo = new NET_DEVICE_STORAGE_INFO[8];
    
    public NET_OUT_GET_DEVICE_AII_INFO(){
        this.dwSize=size();
        for (int i = 0; i < stuStorageInfo.length; i++) {
        	stuStorageInfo[i] = new NET_DEVICE_STORAGE_INFO();
		}
        
    }
}
