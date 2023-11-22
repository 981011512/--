package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 获取当前课程已录制时间出参 {@link NetSDKLib#CLIENT_OperateCourseRecordManager}
 *
 * @author ： 47040
 * @since ： Created in 2020/9/28 19:44
 */
public class NET_OUT_COURSERECORD_GET_TIME extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 已录制时间，单位:秒
     */
    public int nTime;

    public NET_OUT_COURSERECORD_GET_TIME() {
        dwSize = this.size();
    }
}
