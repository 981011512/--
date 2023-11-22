package com.cf.forward.dh.lib.enumeration;

public enum EM_SUPPORT_FAST_IMPORT_TYPE {
    /**
     * 未知
     */
    EM_SUPPORT_FAST_IMPORT_UNKNOWN(-1),
    /**
     * 不支持
     */
    EM_SUPPORT_FAST_IMPORT_NONSUPPORT(0),
    /**
     * 支持
     */
    EM_SUPPORT_FAST_IMPORT_SUPPORT(1);
    private int type;

    EM_SUPPORT_FAST_IMPORT_TYPE(int type) {
        this.type=type;
    }
    public int getType(){
        return type;
    }
}
