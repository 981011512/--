package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 录播主机添加模式返回信息
 *
 * @author ： 47040
 * @since ： Created in 2020/9/27 16:55
 */
public class NET_COURSECOMPOSITE_CHANNEL_MODE_ADD_RESULT extends NetSDKLib.SdkStructure {
    /**
     * 模式, 0 无效, 1 电影模式, 2 常态模式, 3 精品模式, 小于0 自定义模式
     */
    public int nMode;
    /**
     * 返回码, 1 成功, 2 失败, 3 已满, 4 资源不足
     */
    public int nReturnCode;
    /**
     * 保留字节
     */
    public byte[] byReserved = new byte[64];
}
