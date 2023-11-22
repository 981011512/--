package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 门禁卡操作数据错误码
 * @date 2021/2/8
 */
public enum NET_ACCESS_ERRORCODE {
    /**
     * 未知错误
     */
    NET_ACCESS_ERRORCODE_UNKNOWN(0,"未知错误"),
    /**
     * 不支持该数据类型
     */
    NET_ACCESS_ERRORCODE_NOTSUPPORT(1,"不支持该数据类型"),
    /**
     * 数据类型已存满
     */
    NET_ACCESS_ERRORCODE_FULLDATA(2,"数据类型已满"),
    /**
     * 不支持下发操作
     */
    NET_ACCESS_ERRORCODE_NOTSUPPORTISSUED(3,"不支持下发操作");
    private int code;
    private String desc;

    NET_ACCESS_ERRORCODE(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
    public static NET_ACCESS_ERRORCODE getNetAccessErrorCode(int code){
        for (NET_ACCESS_ERRORCODE errorCode :NET_ACCESS_ERRORCODE.values() ) {
            if(errorCode.code==code){
                return errorCode;
            }
        }
        return NET_ACCESS_ERRORCODE_UNKNOWN;
    }

}
