package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @Author 251589
 * @Description：
 * @Date 2020/11/27 12:08
 */
public class START_LISTEN_FINISH_RESULT_INFO  extends NetSDKLib.SdkStructure {
    public int dwEventResult;						// 事件订阅返回结果 NET_NOERROR：成功  非0：失败，值为错误码，详见_EC(x)
    public byte[] byReserved = new byte[508];
}
