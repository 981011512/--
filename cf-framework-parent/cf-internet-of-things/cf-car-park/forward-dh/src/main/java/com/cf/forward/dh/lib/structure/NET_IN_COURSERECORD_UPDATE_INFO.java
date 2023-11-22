package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 录像信息更新到time入参 {@link NetSDKLib#CLIENT_OperateCourseRecordManager}
 *
 * @author ： 47040
 * @since ： Created in 2020/9/28 19:37
 */
public class NET_IN_COURSERECORD_UPDATE_INFO extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 教室ID,0为默认教室
     */
    public int nClassRoomID;
    /**
     * 查询时间
     */
    public NET_TIME stuTime;

    public NET_IN_COURSERECORD_UPDATE_INFO() {
        dwSize = this.size();
    }
}
