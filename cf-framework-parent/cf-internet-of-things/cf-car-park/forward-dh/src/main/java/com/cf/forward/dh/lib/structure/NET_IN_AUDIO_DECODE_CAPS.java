package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description 获取音频解码能力集入参
 * @date 2021/01/06
 */
public class NET_IN_AUDIO_DECODE_CAPS extends NetSDKLib.SdkStructure{
	
	/**
     * 结构体大小
     */
    public int dwSize;
    
    /**
     * 通道号
     * */
    public int nChannel;
    
    
    /**
     * 数据流源类型 { @link EM_AUDIO_DATA_SOURCE_TYPE}
     * */
    public int emSourceType;
    
    
    public NET_IN_AUDIO_DECODE_CAPS(){
        this.dwSize=size();
    }

}
