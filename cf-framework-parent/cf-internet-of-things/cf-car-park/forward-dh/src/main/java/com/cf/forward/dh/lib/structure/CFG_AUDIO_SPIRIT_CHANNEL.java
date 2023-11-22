package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description 语音激励音频通道配置
 * @date 2020/11/9
 */
public class CFG_AUDIO_SPIRIT_CHANNEL extends NetSDKLib.SdkStructure {
    /**
     * 语音激励联动视频通道号
     */
    public int				nChannel;				 
    /**
     * 语音激励优先级, 1~10
     */
    public int				nPriority;				 
    /**
     * 对应的视频摄像机的预置点, 与云台一致0~255
     */
    public int				nPreset;

    @Override
    public String toString() {
        return "CFG_AUDIO_SPIRIT_CHANNEL{" +
                "nChannel=" + nChannel +
                ", nPriority=" + nPriority +
                ", nPreset=" + nPreset +
                '}';
    }
}
