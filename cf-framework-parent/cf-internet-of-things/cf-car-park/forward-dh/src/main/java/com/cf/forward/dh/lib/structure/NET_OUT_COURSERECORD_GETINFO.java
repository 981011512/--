package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

import static com.cf.forward.dh.lib.NetSDKLib.MAX_COURSE_LOGIC_CHANNEL;

/**
 * 获取指定教室的录像信息出参 {@link NetSDKLib#CLIENT_OperateCourseRecordManager}
 *
 * @author ： 47040
 * @since ： Created in 2020/9/28 19:23
 */
public class NET_OUT_COURSERECORD_GETINFO extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 逻辑通道数量
     */
    public int nChannelNum;
    /**
     * 0:无效,1:录像,2不录像,下标对应为逻辑通道号
     */
    public int[] nCanRecord = new int[MAX_COURSE_LOGIC_CHANNEL];

    public NET_OUT_COURSERECORD_GETINFO() {
        dwSize = this.size();
    }
}