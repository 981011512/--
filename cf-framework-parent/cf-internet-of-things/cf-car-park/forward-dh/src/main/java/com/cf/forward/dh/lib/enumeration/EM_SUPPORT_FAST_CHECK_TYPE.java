package com.cf.forward.dh.lib.enumeration;

public enum EM_SUPPORT_FAST_CHECK_TYPE {
    /**
     *未知
     */
    EM_SUPPORT_FAST_CHECK_UNKNOWN(-1),
    /**
     * 不支持
     */
    EM_SUPPORT_FAST_CHECK_NONSUPPORT(0),
    /**
     * 支持
     */
    EM_SUPPORT_FAST_CHECK_SUPPORT(1);
    private int type;
    EM_SUPPORT_FAST_CHECK_TYPE(int type) {
        this.type=type;
    }
    public int getType(){
        return type;
    }
}
