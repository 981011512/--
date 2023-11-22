package com.cf.forward.dh.yangbang;

/**
 *
 */
public enum  BxCmdCode {

    CMD_ACK("ack", (byte)0xa0, (byte)0x00),
    CMD_NACK("nack", (byte)0xa0, (byte)0x01),

    CMD_TURN_ON_OFF("turn on/off screen", (byte)0xa3, (byte)00),
    CMD_CLEAR_SCREEN("clear the screen", (byte)0xa3, (byte)0x10),
    
    CMD_SYSTEM_CLOCK_CORRECT("system clock correct", (byte)0xa2, (byte)03),

    CMD_START_WRITE_FILE("start write file", (byte)0xa1,(byte) 0x05),
    CMD_WRITE_FILE("write file", (byte)0xa1, (byte)0x06),
    CMD_WRITE_TRANS_START("start write trans", (byte)0xa1, (byte)0x07),
    CMD_WRITE_TRANS_STOP("stop the write trans", (byte)0xa1, (byte)0x08),
    CMD_WRITE_CUSTOMER_INFO("write customer information", (byte)0xa1, (byte)0x09),
    CMD_GET_FILE_INTO("get file information", (byte)0xa1, (byte)0x0a),
    CMD_GET_FILE_CONTENT("get file content", (byte)0xa1, (byte)0x0b);


    public byte group;
    public byte code;
    public String name;

    BxCmdCode(String name, byte group, byte code) {
        this.name = name;
        this.group = group;
        this.code = code;
    }

    BxCmdCode(byte group, byte code) {
        this.group = group;
        this.code = code;
    }
}
