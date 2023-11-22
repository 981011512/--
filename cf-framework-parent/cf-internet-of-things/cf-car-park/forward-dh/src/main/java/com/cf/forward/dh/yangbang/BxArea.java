package com.cf.forward.dh.yangbang;

public abstract class BxArea {

    private byte type = 0x00;
    private short x;
    private short y;
    private short w;
    private short h;

    public BxArea(byte type, short x, short y, short w, short h) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public short getX() {
        return x;
    }

    public void setX(short x) {
        this.x = x;
    }

    public short getY() {
        return y;
    }

    public void setY(short y) {
        this.y = y;
    }

    public short getW() {
        return w;
    }

    public void setW(short w) {
        this.w = w;
    }

    public short getH() {
        return h;
    }

    public void setH(short h) {
        this.h = h;
    }

    public abstract byte[] build();
}
