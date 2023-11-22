package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description 可视对讲签名灯设置
 * @date 2020/11/06
 */
public class NET_CFG_VIDEOTALK_SIGNLIGHT extends NetSDKLib.SdkStructure{
	 /**
     * 结构体大小
     */
    public int dwSize;
    
    /**
     * 签名灯个数
     * */
    public int nSignLightNum;
    
    /**
     * 签名灯信息
     * */
    public NET_VIDEOTALK_SIGNLIGHT_INFO[] stuSignLightInfo = new NET_VIDEOTALK_SIGNLIGHT_INFO[16];
    
    
    public NET_CFG_VIDEOTALK_SIGNLIGHT() {
        dwSize = this.size();
        for (int i = 0; i < stuSignLightInfo.length; i++) {
        	stuSignLightInfo[i] = new NET_VIDEOTALK_SIGNLIGHT_INFO();
        }
    }

}
