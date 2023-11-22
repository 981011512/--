package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description 无硬盘报警
 * @date 2020/9/9
 */
public class ALARM_NO_DISK_INFO extends NetSDKLib.SdkStructure {
    public int dwSize;
    /**
     * 时间
     */
    public NET_TIME stuTime;
    /**
     * 事件动作, 0:Start, 1:Stop
     */
    public int dwAction;

    public ALARM_NO_DISK_INFO() {
        this.dwSize = this.size();
    }
}
