package com.cf.forward.dh.yangbang;

public class BxCmdStartWriteFile extends BxCmd {

    //
    private BxFile file;


    public BxCmdStartWriteFile(BxFile file) {
        super(BxCmdCode.CMD_START_WRITE_FILE.group, BxCmdCode.CMD_START_WRITE_FILE.code);

        this.file = file;
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
        // overwrite
        // 文件覆盖方式：
        // 0x00——若文件系统中已经存在该文件，则不再下
        // 发该文件，返回 ERR_FILE_EXIST 状态。
        // 0x01——若文件系统中已经存在该文件，则直接覆
        // 盖该文件。
        array.add((byte)0x01);

        //
        // 文件名
        byte[] name = file.getFileName();
        array.add(name);

        //
        // 文件长度
        // 4bytes


        return array.build();

    }
}
