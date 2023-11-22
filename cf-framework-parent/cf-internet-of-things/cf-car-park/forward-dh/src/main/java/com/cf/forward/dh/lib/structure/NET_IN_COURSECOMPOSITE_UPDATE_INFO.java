package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 组合通道信息更新到time入参 {@link NetSDKLib#CLIENT_OperateCourseCompositeChannel}
 *
 * @author ： 47040
 * @since ： Created in 2020/9/28 21:00
 */
public class NET_IN_COURSECOMPOSITE_UPDATE_INFO extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 教室ID号
     */
    public int nClassRoomId;
    /**
     * 查询时间
     */
    public NET_TIME stuTime;

    public NET_IN_COURSECOMPOSITE_UPDATE_INFO() {
        this.dwSize = this.size();
    }
}
