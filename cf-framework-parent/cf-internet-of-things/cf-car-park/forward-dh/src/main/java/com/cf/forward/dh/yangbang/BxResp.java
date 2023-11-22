package com.cf.forward.dh.yangbang;

import java.util.Arrays;

public class BxResp {

    public byte group;
    public byte cmd;
    public byte error;
    public byte r0;
    public byte r1;
    public byte[] data;

    private BxResp() {

    }

    /**
     * 由 data pack 解析 BxResp 对象
     * @param pack  输入的 BxDataPack
     * @return  BxResp 对象
     */
    private static BxResp parse(BxDataPack pack) {

        //
        BxResp resp = new BxResp();

        //
        int offset = 0;

        //
        // command group
        resp.group = pack.data[offset++];

        //
        // command
        resp.cmd = pack.data[offset++];

        //
        // error
        resp.error = pack.data[offset++];

        //
        // r0,r1
        resp.r0 = pack.data[offset++];
        resp.r1 = pack.data[offset++];

        //
        // data
        resp.data = Arrays.copyOfRange(pack.data, offset, offset+pack.dataLen - 5);

        //
        return resp;
    }

    /**
     * 由字节数组解析 BxResp
     * @param src   字节数组
     * @param len   长度
     * @return  BxResp 对象
     */
    public static BxResp parse(byte[] src, int len) {

        //
        // 解析出 data pack
        BxDataPack rPack = BxDataPack.parse(src, len);

        if(rPack == null) {
            return null;
        }
        else {
            return parse(rPack);
        }
    }


    /**
     * 判断 response 是否为 ACK
     * @return is ack or not
     */
    public boolean isAck() {

        if((group == BxCmdCode.CMD_ACK.group) && (cmd == BxCmdCode.CMD_ACK.code)) {
            return true;
        }
        else {
            return false;
        }
    }
}
