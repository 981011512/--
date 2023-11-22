package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description 刻录参数配置
 * 对应枚举{@link com.cf.forward.dh.lib.enumeration.NET_EM_CFG_OPERATE_TYPE#NET_EM_CFG_BURN_PARAM}
 * @date 2020/11/10
 */
public class NET_BURN_PARAM_INFO extends NetSDKLib.SdkStructure {
    public int dwSize;
    /**
     * 有效刻录通道个数
     */
    public int nChannelCount;
    /**
     * 刻录通道
     */
    public int[] nChannels = new int[64];
    /**
     * 刻录模式,对应枚举{@link NetSDKLib.NET_BURN_MODE}
     */
    public int emMode;
    /**
     * 刻录格式,对应枚举{@link NetSDKLib.NET_BURN_RECORD_PACK}
     */
    public int emFormat;
    /**
     * 刻录文件长度，单位为MB
     */
    public short nBurnFileLength;

    public NET_BURN_PARAM_INFO() {
        this.dwSize = size();
    }
}
