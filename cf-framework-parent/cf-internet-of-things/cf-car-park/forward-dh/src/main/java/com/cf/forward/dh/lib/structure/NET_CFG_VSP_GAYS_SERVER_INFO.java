package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.NET_EM_CFG_OPERATE_TYPE;

import static com.cf.forward.dh.lib.constant.SDKStructureFieldLenth.MAX_SIP_SERVER_NUM;

/**
 * 公安一所平台接入配置信息
 * {@link NET_EM_CFG_OPERATE_TYPE#NET_EM_CFG_VSP_GAYS_SERVER}
 *
 * @author 47040
 * @version 1.0.0
 * @since Created in 2021/3/9 9:31
 */
public class NET_CFG_VSP_GAYS_SERVER_INFO extends NetSDKLib.SdkStructure {

    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 下发 SIP 服务器信息的个数,不超过 MAX_SIP_SERVER_NUM
     */
    public int nSipServerInfoNum;
    /**
     * SIP服务器信息
     */
    public NET_SIP_SERVER_INFO[] stuSipServerInfo = new NET_SIP_SERVER_INFO[MAX_SIP_SERVER_NUM];
    /**
     * 获取到的实际返回SIP服务器信息个数
     */
    public int nRetSipServerInfoNum;
    /**
     * 保留字节
     */
    public byte[] byReserved = new byte[4];

    public NET_CFG_VSP_GAYS_SERVER_INFO() {
        dwSize = this.size();
        for (int i = 0; i < stuSipServerInfo.length; i++) {
            stuSipServerInfo[i] = new NET_SIP_SERVER_INFO();
        }
    }

}
