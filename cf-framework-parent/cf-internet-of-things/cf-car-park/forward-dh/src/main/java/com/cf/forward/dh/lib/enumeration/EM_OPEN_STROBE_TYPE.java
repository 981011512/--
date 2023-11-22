package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 开闸类型
 * @date 2021/2/22
 */
public enum EM_OPEN_STROBE_TYPE {
    /**
     * 未知
     */
    EM_OPEN_STROBE_TYPE_UNKNOWN,
    /**
     * 正常开闸(默认)
     */
    EM_OPEN_STROBE_TYPE_NORMAL,
    /**
     * 测试手动开闸（用于施工前期）
     */
    EM_OPEN_STROBE_TYPE_TEST,
    /**
     * 手动开闸
     */
    EM_OPEN_STROBE_TYPE_MANUAL;
    public static EM_OPEN_STROBE_TYPE getOpenStrobeTyppe(int type){
        for (EM_OPEN_STROBE_TYPE strobeType : EM_OPEN_STROBE_TYPE.values() ) {
            if(strobeType.ordinal()==type){
                return strobeType;
            }
        }
        return EM_OPEN_STROBE_TYPE_UNKNOWN;
    }
}
