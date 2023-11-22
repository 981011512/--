package com.cf.forward.dh.yangbang;

import java.util.List;

/**
 * Program file
 */
public class BxFileProgram extends BxFile{

    //
    // 优先级
    private byte priority = 0x00;

    //
    // 显示模式
    // 0x00 - 顺序播放
    // 其它 - 定长播放
    private short playMode = 0x00;

    //
    // 播放次数
    private byte playTimes = 0x01;

    //
    // 区域
    private List<BxArea> areas;

    //
    private short span;

    /**
     *
     * @param id    文件id
     * @param areas 区域
     */
    public BxFileProgram(int id, List<BxArea> areas) {
        super(BxFileType.PROGRAM, id);
        this.areas = areas;
    }

    @Override
    public byte[] onBuild() {

        BxByteArray array = new BxByteArray();

        //
        // priority
        array.add(priority);

        //
        // display type
        array.add(playMode);

        //
        // play times
        array.add(playTimes);

        //
        // program life
        // 8 bytes
        for(int i=0; i<8; i++) {
            array.add((byte)0xff);
        }

        //
        // program week
        array.add((byte)0xff);

        //
        // program time
        array.add((byte)0x00);
        array.add((byte)0x00);

        //
        // area number
        array.add((byte)areas.size());

        //
        // area data
        for(BxArea area : areas) {
            byte[] adata = area.build();
            array.add(adata.length);
            array.add(adata);
        }

        //
        // crc
        array.add((short)0x00);

        //
        return array.build();
    }
}
