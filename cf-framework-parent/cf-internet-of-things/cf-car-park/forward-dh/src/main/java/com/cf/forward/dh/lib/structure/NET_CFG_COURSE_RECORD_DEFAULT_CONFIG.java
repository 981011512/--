package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.EM_CAN_START_STREAM;
import com.cf.forward.dh.lib.enumeration.EM_COMPOSIT_CHANNEL_BIND_MODE;
import com.cf.forward.dh.lib.enumeration.EM_IS_RECORD;

/**
 * @author ： 47040
 * @since ： Created in 2020/9/27 15:16
 */
public class NET_CFG_COURSE_RECORD_DEFAULT_CONFIG extends NetSDKLib.SdkStructure {

    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 组合通道默认模式; 0: 无效, 1: 电影模式, 2: 常态模式, 3: 精品模式, 小于0: 自定义模式
     */
    public int nCompositChannelMode;
    /**
     * 能否被拉流逻辑通道数
     */
    public int nCanStartStreamNum;
    /**
     * 是否要录像逻辑通道号数
     */
    public int nIsRecordNum;
    /**
     * 能否被拉流 {@link EM_CAN_START_STREAM}
     */
    public int[] emCanStartStream = new int[64];
    /**
     * 是否要录像 {@link EM_IS_RECORD}
     */
    public int[] emIsRecord = new int[64];
    /**
     * 默认组合通道绑定模式 {@link EM_COMPOSIT_CHANNEL_BIND_MODE}
     */
    public int emCompositChannelBindMode;
    /**
     * 保留字节
     */
    public byte[] byReserved = new byte[4];

    public NET_CFG_COURSE_RECORD_DEFAULT_CONFIG() {
        this.dwSize = this.size();
    }
}
