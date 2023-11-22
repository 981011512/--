package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description 获取音频解码能力集出参
 * @date 2021/01/06
 */
public class NET_OUT_AUDIO_DECODE_CAPS extends NetSDKLib.SdkStructure{
	/**
     * 结构体大小,赋值为 sizeof(NET_OUT_AUDIO_DECODE_CAPS)
     */
    public int dwSize;
    
    /**
     * 音频解码格式信息
     * */
    public NET_AUDIO_DECODE_FORMAT[] stuDecodeFormats = (NET_AUDIO_DECODE_FORMAT[])new NET_AUDIO_DECODE_FORMAT().toArray(64);
    
    /**
     * 返回的音频解码格式信息数量
     * */
    public int nFormatsRet;
    
    
    public NET_OUT_AUDIO_DECODE_CAPS(){
        this.dwSize=size();                
    }

}
