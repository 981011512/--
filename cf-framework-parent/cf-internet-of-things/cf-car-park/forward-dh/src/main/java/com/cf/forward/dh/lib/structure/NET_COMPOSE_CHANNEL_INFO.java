package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.constant.SDKStructureFieldLenth;

/**
 * @author 47081
 * @version 1.0
 * @description
 * @date 2020/11/12
 */
public class NET_COMPOSE_CHANNEL_INFO extends NetSDKLib.SdkStructure {
    public int dwSize;
    // 分割模式
    public int emSplitMode;
    // 割模式下的各子窗口显示内容
    public int[] nChannelCombination = new int[
            SDKStructureFieldLenth.CFG_MAX_VIDEO_CHANNEL_NUM];
    // 分割窗口数量
    public int nChannelCount;
    public NET_COMPOSE_CHANNEL_INFO(){
        this.dwSize=size();
    }
}
