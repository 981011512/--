package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

import static com.cf.forward.dh.lib.NetSDKLib.MAX_COURSE_LOGIC_CHANNEL;

/**
 * 设置指定教室的录像信息入参  {@link NetSDKLib#CLIENT_OperateCourseRecordManager}
 *
 * @author ： 47040
 * @since ： Created in 2020/9/28 19:28
 */
public class NET_IN_COURSERECORD_SETINFO extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 教室ID,0为默认教室
     */
    public int nClassRoomID;
    /**
     * 逻辑通道数量
     */
    public int nChannelNum;
    /**
     * 0:无效,1:录像,2不录像,下标对应为逻辑通道号
     */
    public int[] nCanRecord = new int[MAX_COURSE_LOGIC_CHANNEL];

    public NET_IN_COURSERECORD_SETINFO() {
        dwSize = this.size();
    }
}