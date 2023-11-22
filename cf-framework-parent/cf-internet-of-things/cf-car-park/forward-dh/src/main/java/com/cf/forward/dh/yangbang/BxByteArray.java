package com.cf.forward.dh.yangbang;

import java.util.Arrays;

/**
 * Created by WYD-WORK on 2015/10/20.
 */
public class BxByteArray {

    // 默认容量
    private static final int DEFAULT_CAPACITY = 128;

    // 字节数组
    private byte[] list;

    // 写指针
    private int next;


    public BxByteArray(int capacity) {
        list = new byte[capacity];
        next = 0;
    }


    public BxByteArray() {
        this(DEFAULT_CAPACITY);
    }

    //
    // 向字节数组中PUSH入一个字节
    public void add(byte data) {

        if(next == list.length) {
            // 如果写指针超过 list 长度
            // 将数组长度控大一倍
            list = Arrays.copyOf(list, list.length*2);
        }

        list[next++] = data;
    }

    //
    // 向字节数组中 push 入一个short
    public void add(short data) {
        add(data, Endian.LITTLE);
    }

    //
    // 向字节数组中 push 入一个short
    public void add(short data, Endian endian) {

        if((next + 1) >= list.length) {
            list = Arrays.copyOf(list, list.length*2);
        }

        if(endian == Endian.LITTLE) {
            list[next++] = (byte) data;
            list[next++] = (byte) (data >> 8);
        }
        else {
            list[next++] = (byte) (data >> 8);
            list[next++] = (byte) data;
        }
    }

    public void add(int data) {
        add(data, Endian.LITTLE);
    }

    //
    // 向字节数组中 push 入一个 int
    public void add(int data, Endian endian) {

        if((next + 3) >= list.length) {
            list = Arrays.copyOf(list, list.length*2);
        }

        if(endian == Endian.LITTLE) {
            list[next++] = (byte) data;
            list[next++] = (byte) (data >> 8);
            list[next++] = (byte) (data >> 16);
            list[next++] = (byte) (data >> 24);
        }
        else {
            list[next++] = (byte) (data >> 24);
            list[next++] = (byte) (data >> 16);
            list[next++] = (byte) (data >> 8);
            list[next++] = (byte) data;
        }
    }

    //
    // 向字节数组中 push 入一个 byte[] 数组
    public void add(byte[] src) {

        if(src != null) {

            if ((next + src.length - 1) >= list.length) {
                list = Arrays.copyOf(list, list.length + src.length);
            }

            for (int i = 0; i < src.length; i++) {
                list[next++] = src[i];
            }
        }
    }

    //
    // 向字节数组中 push 入一个 byte[] 数组
    public void add(byte[] src, int offset, int length) {

        if(src != null) {
            if ((next + length - 1) >= list.length) {
                list = Arrays.copyOf(list, list.length + length);
            }

            for (int i = 0; i < length; i++) {
                list[next++] = src[offset++];
            }
        }
    }

    //
    // 设置某个位置的数据
    public void set(int index, byte data) {
        if(index <= list.length) {
            list[index] = data;
        }
    }

    //
    // 读取指定位置的一个字节
    public byte get(int index) {
        return list[index];
    }

    //
    // 获取一个数组
    public byte[] build() {

        byte[] array = new byte[next];

        System.arraycopy(list, 0, array, 0, next);

        return array;
    }

    //
    // 返回实际 size
    public int size() {
        return next;
    }


    //
    // 清空 array
    public void clear() {
        next = 0;
    }


    //
    enum Endian {
        LITTLE, BIG
    }

}
