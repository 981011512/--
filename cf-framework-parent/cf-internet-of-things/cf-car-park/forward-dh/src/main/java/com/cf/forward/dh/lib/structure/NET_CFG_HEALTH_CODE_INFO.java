package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.NET_EM_CFG_OPERATE_TYPE;

/**
 * @author 47081
 * @version 1.0
 * @description 健康码使能,
 * 对应枚举类型{@link NET_EM_CFG_OPERATE_TYPE#NET_EM_CFG_HEALTH_CODE}
 * @date 2020/9/10
 */
public class NET_CFG_HEALTH_CODE_INFO extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 健康码使能，TRUE：使能；FALSE：未使能
     */
    public boolean bEnable;
    /**
     * 健康码离线使能，TRUE：使能；FALSE：未使能
     */
    public boolean bOfflineEnable;
    /**
     * 健康码读头使能，TRUE：使能；FALSE：未使能
     */
    public boolean bQRCodeReaderEnable;
    public NET_CFG_HEALTH_CODE_INFO(){
        this.dwSize=size();
    }
    @Override
    public String toString() {
        return "NET_CFG_HEALTH_CODE_INFO{" +
                "dwSize=" + dwSize +
                ", bEnable=" + bEnable +
                ", bOfflineEnable=" + bOfflineEnable +
                ", bQRCodeReaderEnable=" + bQRCodeReaderEnable +
                '}';
    }
}
