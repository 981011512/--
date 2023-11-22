package com.cf.forward.dh.yangbang;

/**
 * 文件
 */
public abstract class BxFile {

    //
    // 文件类型
    private BxFileType type;

    //
    // 文件ID
    private int id;

    //
    // 文件长度
    private int length;

    //
    public BxFile(BxFileType type, int id) {
        this.type = type;
        this.id = id;
    }

    /**
     * 生成文件字节流
     * @return  文件的字节流
     */
    public byte[] build() {
        //
        BxByteArray array = new BxByteArray();

        //
        // 文件类型
        array.add(type.getCode());

        //
        // 文件名
        // P000
        byte[] name = getFileName();
        array.add(name);

        //
        // 文件长度
        // 先默认成 0
        array.add(length);

        //
        // data
        byte[] data = onBuild();
        array.add(data);


        //
        return array.build();
    }

    /**
     * 生成除文件头及文件校验以外的字节流
     * @return  文件内容的字节流
     */
    public abstract byte[] onBuild();


    public byte[] getFileName() {

        byte[] bname = new byte[4];

        //
        // 文件名
        // P000
        byte[] prefix = type.getPrefix().getBytes();
        bname[0] = prefix[0];

        if(id>99) {
            id = 99;
        }

        byte btmp = (byte) (id/100%10 + 0x30);
        bname[1] = btmp;

        id = id%100;
        btmp = (byte) (id/10 + 0x30);
        bname[2] = btmp;

        id = id % 10;
        btmp = (byte) (id + 0x30);
        bname[3] = btmp;

        return bname;
    }
}
