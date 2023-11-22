package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 锁定和解锁组合通道和逻辑通道出参 {@link NetSDKLib#CLIENT_OperateCourseCompositeChannel}
 *
 * @author ： 47040
 * @since ： Created in 2020/9/28 19:57
 */
public class NET_OUT_COURSECOMPOSITE_LOCK_CONTROL extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;

    public NET_OUT_COURSECOMPOSITE_LOCK_CONTROL() {
        dwSize = this.size();
    }
}
