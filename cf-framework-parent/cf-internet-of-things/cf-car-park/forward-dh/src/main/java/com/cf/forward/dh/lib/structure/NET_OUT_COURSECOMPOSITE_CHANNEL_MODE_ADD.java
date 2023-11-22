package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

import static com.cf.forward.dh.lib.NetSDKLib.NET_MAX_MODE_NUMBER;

/**
 * 录播主机添加模式出参
 *
 * @author ： 47040
 * @since ： Created in 2020/9/27 16:54
 */
public class NET_OUT_COURSECOMPOSITE_CHANNEL_MODE_ADD extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 实际返回个数
     */
    public int nCount;
    /**
     * 返回数组
     */
    public NET_COURSECOMPOSITE_CHANNEL_MODE_ADD_RESULT[] stResult = new NET_COURSECOMPOSITE_CHANNEL_MODE_ADD_RESULT[NET_MAX_MODE_NUMBER];

    public NET_OUT_COURSECOMPOSITE_CHANNEL_MODE_ADD() {
        dwSize = this.size();
        for (int i = 0; i < stResult.length; i++) {
            stResult[i] = new NET_COURSECOMPOSITE_CHANNEL_MODE_ADD_RESULT();
        }
    }
}
