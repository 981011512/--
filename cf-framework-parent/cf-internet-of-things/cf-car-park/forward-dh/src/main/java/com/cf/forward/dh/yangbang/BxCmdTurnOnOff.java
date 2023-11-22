package com.cf.forward.dh.yangbang;

public class BxCmdTurnOnOff extends BxCmd {

    private boolean on = true;

    public BxCmdTurnOnOff(boolean on) {
        super(BxCmdCode.CMD_TURN_ON_OFF.group, BxCmdCode.CMD_TURN_ON_OFF.code);
        this.on = on;
    }

    @Override
    public byte[] build() {
        //
        BxByteArray array = new BxByteArray();

        // cmd
        //
        // cmd group
        array.add(getGroup());
        array.add(getCmd());

        //
        // response or not
        array.add(getReqResp());

        //
        // r0, r1
        array.add((byte)0x00);
        array.add((byte)0x00);

        //
        // 0x01 - on
        // 0x02 - off
        if(on) {
            array.add((byte)0x01);
        }
        else {
            array.add((byte)0x02);
        }

        return array.build();
    }
}
