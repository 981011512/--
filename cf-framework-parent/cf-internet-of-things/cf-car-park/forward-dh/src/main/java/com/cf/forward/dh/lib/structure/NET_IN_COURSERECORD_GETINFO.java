package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 获取指定教室的录像信息入参 {@link NetSDKLib#CLIENT_OperateCourseRecordManager}
 *
 * @author ： 47040
 * @since ： Created in 2020/9/28 19:21
 */
public class NET_IN_COURSERECORD_GETINFO extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 教室ID,0为默认教室
     */
    public int nClassRoomID;

    public NET_IN_COURSERECORD_GETINFO() {
        dwSize = this.size();
    }
}
