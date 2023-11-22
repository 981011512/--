package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.NET_EM_RECORD_MODE;

/**
 * 获取录像模式出参，对应接口{@link NetSDKLib#CLIENT_GetCourseRecordMode}
 *
 * @author ： 47040
 * @since ： Created in 2020/9/28 15:50
 */
public class NET_OUT_GET_COURSE_RECORD_MODE extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 录像模式{@link NET_EM_RECORD_MODE}
     */
    public int emRecordMode;

    public NET_OUT_GET_COURSE_RECORD_MODE() {
        dwSize = this.size();
    }
}
