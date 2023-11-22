package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
/**
 * @author 251823
 * @description 订阅云台元数据接口输输出参数
 * @date 2021/02/26
 */
public class NET_OUT_PTZ_STATUS_PROC extends NetSDKLib.SdkStructure{
	 /**
     * dwSize;
     */
    public int dwSize;
    public NET_OUT_PTZ_STATUS_PROC(){
        this.dwSize = this.size();
    }
}
