package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 某月的各天是否存在录像的状态信息
 * {@link NetSDKLib#CLIENT_QueryRecordStatus}
 *
 * @author ： 47040
 * @since ： Created in 2021/2/27 19:57
 */
public class NET_RECORD_STATUS extends NetSDKLib.SdkStructure {
    /**
     * 某月内的各天是否存在录像的状态掩码,0表示没有,1表示有。
     */
    public byte[] flag = new byte[32];
    /**
     * 保留
     */
    public byte[] Reserved = new byte[64];
}
