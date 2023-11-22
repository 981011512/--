package com.cf.forward.dh.lib.enumeration;

/**
 * AccessControlCustomPassword记录集中密码的保存方式
 */
public enum EM_CUSTOM_PASSWORD_ENCRYPTION_MODE {
    /**
     * 未知方式
     */
    EM_CUSTOM_PASSWORD_ENCRYPTION_MODE_UNKNOWN,
    /**
     * 明文
     */
    EM_CUSTOM_PASSWORD_ENCRYPTION_MODE_PLAINTEXT,
    /**
     * MD5加密方式
     */
    EM_CUSTOM_PASSWORD_ENCRYPTION_MODE_MD5,
}
