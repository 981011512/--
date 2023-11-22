package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.NET_EM_RECORD_MODE;

/**
 * 设置录像模式入参，对应接口{link NetSDKLib#CLIENT_SetCourseRecordMode}
 *
 * @author ： 47040
 * @since ： Created in 2020/9/28 15:38
 */
public class NET_IN_SET_COURSE_RECORD_MODE extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 录像模式 {@link NET_EM_RECORD_MODE}
     */
    public int emRecordMode;
    /**
     * 教室id号
     */
    public int nClassRoomID;

    public NET_IN_SET_COURSE_RECORD_MODE() {
        dwSize = this.size();
    }
}
