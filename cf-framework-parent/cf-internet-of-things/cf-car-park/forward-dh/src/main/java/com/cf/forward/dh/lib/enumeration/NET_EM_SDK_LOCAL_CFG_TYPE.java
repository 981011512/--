package com.cf.forward.dh.lib.enumeration;

import com.cf.forward.dh.lib.structure.NET_CONFIG_OPENSSL_INFO;

/**
 * @author 47081
 * @version 1.0
 * @description CLIENT_SetSDKLocalCfg/CLIENT_GetSDKLocalCfg 接口配置本地参数类型
 * @date 2021/3/2
 */
public enum NET_EM_SDK_LOCAL_CFG_TYPE {
    /**
     * openssl库信息配置，对应结构体
     * {@link NET_CONFIG_OPENSSL_INFO}
     */
    NET_SDK_LOCAL_CFG_TYPE_OPENSSL,
    /**
     * StreamConvertor转码库信息配置，对应结构体 NET_CONFIG_STREAMCONVERTOR_INFO
     */
    NET_SDK_LOCAL_CFG_TYPE_STREAMCONVERTOR
}
