package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.sun.jna.Pointer;

/**
 * @author 47081
 * @version 1.0
 * @description 语音激励
 * @date 2020/11/9
 */
public class CFG_AUDIO_SPIRIT extends NetSDKLib.SdkStructure {
    /**
     * 使能
     */
    public boolean 				bEnable;
    /**
     * 激励音量阈值, 0~100
     */
    public int					nAudioLimit;		//
    /**
     * 激励延时时间, 单位: 秒
     */
        public int					nDelayTime;			//
    /**
     * 语音激励音频通道属性,由用户申请内存,大小为sizeof(CFG_AUDIO_SPIRIT_CHANNEL)*nChannelCount
     * 对应结构体数组{@link CFG_AUDIO_SPIRIT_CHANNEL}
     */
        public Pointer pstuChannels;	//
    /**
     * 音频通道数
     */
        public int					nChannelCount;		//
    /**
     * 激励联动项
     */
        public CFG_AUDIO_SPIRIT_LINKAGE stuLinkage;	//

}
