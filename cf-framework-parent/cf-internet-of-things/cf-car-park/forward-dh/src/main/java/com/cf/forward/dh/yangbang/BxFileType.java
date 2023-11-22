package com.cf.forward.dh.yangbang;

/**
 * Bx file type
 */
public enum BxFileType {


    PROGRAM((byte)0x00, "P", "Program file");


    private byte code;
    private String name;
    private String prefix;

    BxFileType(byte code, String prefix, String name) {
        this.code = code;
        this.name = name;
        this.prefix = prefix;
    }

    public byte getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getPrefix() {
        return prefix;
    }
}
