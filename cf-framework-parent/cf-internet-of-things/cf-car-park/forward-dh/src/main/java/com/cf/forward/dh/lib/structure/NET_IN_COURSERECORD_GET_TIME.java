package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 获取当前课程已录制时间入参 {@link NetSDKLib#CLIENT_OperateCourseRecordManager}
 *
 * @author ： 47040
 * @since ： Created in 2020/9/28 19:42
 */
public class NET_IN_COURSERECORD_GET_TIME extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 教室ID，0为默认教室
     */
    public int nClassRoomID;

    public NET_IN_COURSERECORD_GET_TIME() {
        dwSize = this.size();
    }
}
