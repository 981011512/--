package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 设置当前位置聚焦值
 * 对应接口 {@link NetSDKLib#CLIENT_DHPTZControlEx2}
 * 对应枚举 {@link NetSDKLib.NET_EXTPTZ_ControlType#NET_EXTPTZ_BASE_SET_FOCUS_MAP_VALUE}
 *
 * @author ： 47040
 * @since ： Created in 2021/3/26 17:04
 */
public class NET_IN_PTZBASE_SET_FOCUS_MAP_VALUE_INFO extends NetSDKLib.SdkStructure {

    /**
     * 结构体大小
     */
    public int dwSize;

    /**
     * 聚焦映射值, 取值范围 [0, 28672]
     */
    public int nfocusMapValue;

    public NET_IN_PTZBASE_SET_FOCUS_MAP_VALUE_INFO() {
        this.dwSize = this.size();
    }

}
