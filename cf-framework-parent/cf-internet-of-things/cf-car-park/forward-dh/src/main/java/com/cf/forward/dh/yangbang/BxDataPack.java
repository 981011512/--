package com.cf.forward.dh.yangbang;

import java.util.Arrays;

/**
 *
 */
public class BxDataPack {

    private static final int WRAP_A5_NUM = 8;
    private static final int WRAP_5A_NUM = 1;


    // 目标地址
    public short dstAddr = (short) 0xfffe;

    //
    // 源地址
    public short srcAddr = (short) 0x8000;

    //
    // 保留字
    public byte r0 = 0x00;
    public byte r1 = 0x00;
    public byte r2 = 0x00;

    //
    // option
    // 不发送 barcode
    public byte option = 0x00;

    //
    // crc 模式
    // 默认无校验
    public byte crcMode = 0x00;

    //
    // 显示模式
    public byte dispMode = 0x00;

    //
    // 设备类型
    public byte deviceType = (byte) 0xfe;

    //
    // 协议版本号
    public byte version = 0x02;

    //
    // 数据域长度
    public short dataLen;

    //
    // 数据
    public byte[] data;

    //
    // crc
    public short crc;

    private BxDataPack() {}

    public BxDataPack(byte[] data) {
        this.data = data;
        this.dataLen = (short) data.length;
    }

    public BxDataPack(BxCmd cmd) {
        this.data = cmd.build();
        this.dataLen = (short) data.length;
    }


    /**
     * 对数据进行转义
     * @param src
     * @return
     */
    private static byte[] wrap(byte[] src) {


        int len = 0;

        len = src.length;

        for(byte d : src) {
            if((d == (byte)0xa5) || (d == (byte)0x5a) || (d == (byte)0xa6) || (d == (byte)0x5b)) {
                len++;
            }
        }

        //
        // 加上帧头和帧尾的A5,5A
        //len += 2;
        len += WRAP_5A_NUM;
        len += WRAP_A5_NUM;


        //
        // 开始转义

        byte[] dst;
        dst = new byte[len];

        int offset = 0;

        //
        // 帧头
        for(int i=0; i<WRAP_A5_NUM; i++){
            dst[offset++] = (byte) 0xa5;
        }


        for(byte data : src) {
            if(data == (byte)0xa5) {
                dst[offset++] = (byte) 0xa6;
                dst[offset++] = 0x02;
            }
            else if(data == (byte)0xa6) {
                dst[offset++] = (byte) 0xa6;
                dst[offset++] = 0x01;
            }
            else if(data == 0x5a) {
                dst[offset++] = 0x5b;
                dst[offset++] = 0x02;
            }
            else if(data == 0x5b) {
                dst[offset++] = 0x5b;
                dst[offset++] = 0x01;
            }
            else{
                dst[offset++] = data;
            }
        }

        // 帧尾
        for(int i=0; i<WRAP_5A_NUM; i++){
            dst[offset++] = 0x5a;
        }

        //
        return dst;
    }


    /**
     * 对数据进行封装，生成字节流
     * @return  数据帧的字节流
     */
    public byte[] pack() {

        BxByteArray bytes = new BxByteArray();

        //
        // 目标地址
        bytes.add(dstAddr, BxByteArray.Endian.LITTLE);

        //
        // 源地址
        bytes.add(srcAddr, BxByteArray.Endian.LITTLE);

        //
        // 保留字
        bytes.add(r0);
        bytes.add(r1);
        bytes.add(r2);

        //
        // option
        bytes.add(option);

        //
        // crc mode
        bytes.add(crcMode);

        //
        bytes.add(dispMode);

        //
        bytes.add(deviceType);

        //
        bytes.add(version);

        //
        bytes.add(dataLen);

        //
        // 数据域
        bytes.add(data);

        //
        // add crc
        crc = 0x0;
        bytes.add(crc);

        //
        byte[] origin = bytes.build();
        int originLen = origin.length;
        crc = BxUtils.CRC16(origin, 0, originLen-2);

        origin[originLen-2] = (byte)(crc & 0xff);
        origin[originLen-1] = (byte)(crc>>8);


        //
        // 进行转义
        byte[] result = wrap(origin);

        //
        return result;

    }

    /**
     * 将BYTE数组解析成 BxDataPack
     * @param src
     * @return
     */
    public static BxDataPack parse(byte[] src, int length) {

        //
        // 反转义
        byte[] dst = unwrap(src, length);
        if(dst == null) {
            return null;
        }
        else {

            //
            // check crc
            //if(BxUtils.CRC16())
            short crcCalculated = BxUtils.CRC16(dst, 0, dst.length-2);
            short crcGot = BxUtils.bytesToShort(dst, dst.length-2, BxUtils.ENDIAN.LITTLE);

            if(crcCalculated != crcGot)
                return null;


            BxDataPack pack = new BxDataPack();

            int offset = 0;

            //
            // 目标地址
            pack.dstAddr = BxUtils.bytesToShort(dst, offset, BxUtils.ENDIAN.LITTLE);
            offset += 2;

            //
            // 源地址
            pack.srcAddr = BxUtils.bytesToShort(dst, offset, BxUtils.ENDIAN.LITTLE);
            offset += 2;

            //
            // 保留字 r0, r1, r2
            pack.r0 = dst[offset++];
            pack.r1 = dst[offset++];
            pack.r2 = dst[offset++];

            //
            // option
            pack.option = dst[offset++];

            //
            // 校验模式
            pack.crcMode = dst[offset++];

            //
            // 显示模式
            pack.dispMode = dst[offset++];

            //
            // 设备类型
            pack.deviceType = dst[offset++];

            //
            // 协议版本
            pack.version = dst[offset++];

            //
            // 数据域长度
            pack.dataLen = BxUtils.bytesToShort(dst, offset, BxUtils.ENDIAN.LITTLE);
            offset += 2;

            //
            // 数据
            //pack.data = new byte[pack.dataLen];
            pack.data = Arrays.copyOfRange(dst, offset, offset+pack.dataLen);
            offset += pack.dataLen;

            //
            // crc
            pack.crc = BxUtils.bytesToShort(dst, offset, BxUtils.ENDIAN.LITTLE);

            //
            return pack;
        }

    }


    /**
     * 去除数据转义
     * @param src
     * @param length
     * @return
     */
    private static byte[] unwrap(byte[] src, int length) {

        int len = 0;

        if(length == 0)
            len = 0;

        if(src[0] != (byte)0xa5)
            len = 0;

        if(src[length-1] != (byte)0x5a)
            len = 0;

        len = length;

        for(byte d : src) {
            if((d == (byte)0xa5) || (d == (byte)0x5a) || (d == (byte)0xa6) || (d == (byte)0x5b)) {
                len--;
            }
        }

        byte[] dst;

        //
        // 如果计算的帧长度为0，说明数据不正确
        if(len == 0)
            return null;

        dst = new byte[len];

        int offset = 0;
        for(int i=0; i<length; ) {

            if((src[i] == (byte)0xa5) || (src[i] == 0x5a)) {
                i++;
            }
            else if(src[i] == (byte)0xa6) {
                if(src[i+1] == 0x01) {
                    dst[offset++] = (byte)0xa6;
                    i = i+2;
                }
                else if(src[i+1] == 0x02) {
                    dst[offset++] = (byte)0xa5;
                    i = i+2;
                }
                else
                    return null;
            }

            else if(src[i] == 0x5b) {
                if(src[i+1] == 0x01) {
                    dst[offset++] = (byte)0x5b;
                    i = i+2;
                }
                else if(src[i+1] == 0x02) {
                    dst[offset++] = (byte)0x5a;
                    i = i+2;
                }
                else
                    return null;
            }

            else {
                dst[offset++] = src[i++];
            }
        }


        return dst;
    }
}
