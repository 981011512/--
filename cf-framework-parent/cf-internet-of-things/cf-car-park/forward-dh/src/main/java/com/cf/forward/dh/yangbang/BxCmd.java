package com.cf.forward.dh.yangbang;

public abstract class BxCmd {

    //
    // 命令组
    private byte group;

    // 命令字
    private byte cmd;

    // 是否要求回复
    private byte reqResp = 0x01;

    //
    private byte r0 = 0x00;
    private byte r1 = 0x00;



    public BxCmd(byte group, byte cmd) {
        this.group = group;
        this.cmd = cmd;
    }

    /**
     * 生成命令字节流
     * @return
     */
    public abstract byte[] build();


    public byte getGroup() {
        return group;
    }

    public void setGroup(byte group) {
        this.group = group;
    }

    public byte getCmd() {
        return cmd;
    }

    public void setCmd(byte cmd) {
        this.cmd = cmd;
    }

    public byte getReqResp() {
        return reqResp;
    }

    public void setReqResp(byte reqResp) {
        this.reqResp = reqResp;
    }

    public byte getR0() {
        return r0;
    }

    public void setR0(byte r0) {
        this.r0 = r0;
    }

    public byte getR1() {
        return r1;
    }

    public void setR1(byte r1) {
        this.r1 = r1;
    }
}
