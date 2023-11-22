package com.cf.forward.dh.yangbang;

public class BxCmdWriteFileBlock extends BxCmd {


    //
    private BxFile file;

    private boolean lastBlock = true;
    private short blockNum = 0;
    private short blockLen = 0;
    private short blockAddr = 0;

    public BxCmdWriteFileBlock(BxFile file, boolean lastBlock, short blockNum, short blockLen, short blockAddr) {
        super(BxCmdCode.CMD_WRITE_FILE.group, BxCmdCode.CMD_WRITE_FILE.code);
        this.file = file;

        this.lastBlock = lastBlock;
        this.blockNum = blockNum;
        this.blockLen = blockLen;
        this.blockAddr = blockAddr;
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
        // file name
        array.add(file.getFileName());

        //
        // is last
        if(lastBlock) {
            array.add((byte)0x01);
        }
        else {
            array.add((byte)0x00);
        }

        //
        // block number
        array.add(blockNum);

        //
        // block length
        array.add(blockLen);

        //
        // block address
        array.add(blockAddr);

        //
        // block data
        byte[] fdata = file.build();
        array.add(fdata, blockAddr, blockLen);

        //
        return array.build();
    }
}
