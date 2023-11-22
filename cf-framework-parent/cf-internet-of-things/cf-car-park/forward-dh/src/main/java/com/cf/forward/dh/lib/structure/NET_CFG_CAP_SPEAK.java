package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description
 * @date 2020/6/9
 */
public class NET_CFG_CAP_SPEAK extends NetSDKLib.SdkStructure {
    /**
     * 支持的音频格式个数
     */
    public int						     nAudioCapNum;
    /**
     * 支持的音频格式
     */
    public NET_CFG_CAP_AUDIO_FORMAT[]	 stuAudioCap=(NET_CFG_CAP_AUDIO_FORMAT[])new NET_CFG_CAP_AUDIO_FORMAT().toArray(16);
    /**
     * 音频播放路径个数
     */
    public int                           nAudioPlayPathNum;
    /**
     * 音频播放路径
     */
    public NET_CFG_AUDIO_PLAY_PATH[]         stuAudioPlayPath=(NET_CFG_AUDIO_PLAY_PATH[])new NET_CFG_AUDIO_PLAY_PATH().toArray(8);
}
