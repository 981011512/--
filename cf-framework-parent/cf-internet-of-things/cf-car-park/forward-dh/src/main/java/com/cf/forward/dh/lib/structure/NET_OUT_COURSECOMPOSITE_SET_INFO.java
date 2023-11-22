package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 设置组合通道信息出参 {@link NetSDKLib#CLIENT_OperateCourseCompositeChannel}
 *
 * @author ： 47040
 * @since ： Created in 2020/9/28 20:54
 */
public class NET_OUT_COURSECOMPOSITE_SET_INFO extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;

    public NET_OUT_COURSECOMPOSITE_SET_INFO() {
        dwSize = this.size();
    }
}
