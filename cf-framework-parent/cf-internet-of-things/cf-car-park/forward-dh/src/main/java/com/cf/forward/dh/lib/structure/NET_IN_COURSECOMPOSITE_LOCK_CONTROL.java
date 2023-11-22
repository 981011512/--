package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 锁定和解锁组合通道和逻辑通道入参 {@link NetSDKLib#CLIENT_OperateCourseCompositeChannel}
 *
 * @author ： 47040
 * @since ： Created in 2020/9/28 19:53
 */
public class NET_IN_COURSECOMPOSITE_LOCK_CONTROL extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 1 TRUE锁定，0 FALSE 解锁
     */
    public int bLock;
    /**
     * 教室ID号
     */
    public int nClassRoomID;
    /**
     * 逻辑通道号
     */
    public int nLogicChannel;

    public NET_IN_COURSECOMPOSITE_LOCK_CONTROL() {
        dwSize = this.size();
    }
}
