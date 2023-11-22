package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 音频属性
 * @author 47081
 * @version 1.0
 * @description
 * @date 2020/6/9
 */
public class NET_CFG_AUDIO_PROPERTY extends NetSDKLib.SdkStructure {
    /**
     * 码流大小，单位:kbps，比如192kbps
     */
    public int            nBitRate;
    /**
     * 采样的位深，如8或16
     */
    public int            nSampleBit;
    /**
     * 采样率，单位:Hz，比如44100Hz
     */
    public int            nSampleRate;

}
