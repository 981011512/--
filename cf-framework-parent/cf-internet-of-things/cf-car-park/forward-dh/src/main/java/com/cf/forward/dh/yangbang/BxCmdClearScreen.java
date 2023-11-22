package com.cf.forward.dh.yangbang;

/**
 *
 */
public class BxCmdClearScreen extends BxCmd {

    public BxCmdClearScreen() {
        super(BxCmdCode.CMD_CLEAR_SCREEN.group, BxCmdCode.CMD_CLEAR_SCREEN.code);
    }

    @Override
    public byte[] build() {

        BxByteArray array = new BxByteArray();

        //
        // group, code
        array.add(getGroup());
        array.add(getCmd());

        //
        // response or not
        array.add(getReqResp());

        //
        // 2 bytes reserved data
        // r0, r1
        array.add((byte)0x00);
        array.add((byte)0x00);

        //
        return array.build();
    }
}
