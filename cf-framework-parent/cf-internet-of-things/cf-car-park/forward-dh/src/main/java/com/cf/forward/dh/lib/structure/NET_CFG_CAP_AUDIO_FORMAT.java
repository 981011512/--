package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 支持的音频格式
 * @author 47081
 * @version 1.0
 * @description
 * @date 2020/6/9
 */
public class NET_CFG_CAP_AUDIO_FORMAT extends NetSDKLib.SdkStructure {
    /**
     * 音频压缩格式，具体见枚举EM_TALK_AUDIO_TYPE
     */
    public int                      emCompression;
    /**
     * 音频属性个数
     */
    public int		                 nPropertyNum;
    /**
     * 音频属性
     */
    public NET_CFG_AUDIO_PROPERTY[]  stuProperty=(NET_CFG_AUDIO_PROPERTY[]) new NET_CFG_AUDIO_PROPERTY().toArray(32);
}
