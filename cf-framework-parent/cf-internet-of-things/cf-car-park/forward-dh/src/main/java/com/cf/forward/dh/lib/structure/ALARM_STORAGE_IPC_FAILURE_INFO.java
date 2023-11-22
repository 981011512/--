package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * IPC的存储介质故障事件(SD卡异常) 报警
 * {@link NetSDKLib#NET_ALARM_STORAGE_IPC_FAILURE}
 *
 * @author 47040
 * @version 1.0.0
 * @since Created in 2021/3/12 10:44
 */
public class ALARM_STORAGE_IPC_FAILURE_INFO extends NetSDKLib.SdkStructure {
    /**
     * 0:开始 1:停止
     */
    public int nAction;
    /**
     * 发生报警的通道号
     */
    public int nChannelID;
    /**
     * 保留字节
     */
    public byte[] byReserved = new byte[1024];
}
