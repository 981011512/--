package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 设置组合通道信息入参 {@link NetSDKLib#CLIENT_OperateCourseCompositeChannel}
 *
 * @author ： 47040
 * @since ： Created in 2020/9/28 20:51
 */
public class NET_IN_COURSECOMPOSITE_SET_INFO extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 教室ID号
     */
    public int nClassRoomId;
    /**
     * 组合通道信息
     */
    public NET_COMPOSITECHANNEL_INFO stuChannelInfo;

    public NET_IN_COURSECOMPOSITE_SET_INFO() {
        dwSize = this.size();
    }
}
