package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 获取锁定状态入参 {@link NetSDKLib#CLIENT_OperateCourseCompositeChannel}
 *
 * @author ： 47040
 * @since ： Created in 2020/9/28 19:58
 */
public class NET_IN_COURSECOMPOSITE_GET_LOCKINFO extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 教室ID号
     */
    public int nClassRoomID;
    /**
     * 逻辑通道号
     */
    public int nLogicChannel;

    public NET_IN_COURSECOMPOSITE_GET_LOCKINFO() {
        dwSize = this.size();
    }
}
