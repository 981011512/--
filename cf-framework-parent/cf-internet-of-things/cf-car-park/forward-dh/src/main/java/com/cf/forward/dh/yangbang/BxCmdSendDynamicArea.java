package com.cf.forward.dh.yangbang;

import java.util.List;

public class BxCmdSendDynamicArea extends BxCmd {

    private static final byte GROUP = (byte) 0xa3;
    private static final byte CMD = 0x06;

    //
    // process mode
    // 当该字节为 0 时，收到动态信息后不再进行清区域
    // 和初始化区域的操作，当该字节为 1 时，收到动态
    // 信息后需要进行清区域和初始化区域的操作。
    private byte processMode = 0x00;

    //
    // reserved
    private byte r2;

    //
    // 要删除的区域ID
    private byte[] delAreaIds;

    //
    // 区域
    private List<BxArea> areas;

    //

    public BxCmdSendDynamicArea(List<BxArea> areas) {
        super(GROUP, CMD);
        this.areas = areas;
    }


    @Override
    public byte[] build() {

        BxByteArray array = new BxByteArray();

        //
        // cmd group
        array.add(getGroup());
        array.add(getCmd());

        //
        // response or not
        array.add(getReqResp());

        //
        // process mod
        array.add(processMode);

        //
        // r2
        array.add(r2);

        //
        // delete area ids
        if(delAreaIds == null) {
            array.add((byte)0x00);
        }
        else {
            byte delIdNum = (byte) delAreaIds.length;
            array.add(delIdNum);
            array.add(delAreaIds);
        }

        //
        // area data
        if(areas != null) {
            if(areas.size() == 0) {
                array.add((byte)0x00);
            }
            else {
                array.add((byte)areas.size());
                for(BxArea area:areas) {
                    byte[] areaData = area.build();
                    short dataLen = (short) areaData.length;

                    array.add(dataLen);
                    array.add(areaData);
                }
            }
        }
        else {
            array.add((byte)0x00);
        }


        return array.build();
    }


    public byte getProcessMode() {
        return processMode;
    }

    public void setProcessMode(byte processMode) {
        this.processMode = processMode;
    }

    public byte[] getDelAreaIds() {
        return delAreaIds;
    }

    public void setDelAreaIds(byte[] delAreaIds) {
        this.delAreaIds = delAreaIds;
    }

    public List<BxArea> getAreas() {
        return areas;
    }

    public void setAreas(List<BxArea> areas) {
        this.areas = areas;
    }
}
