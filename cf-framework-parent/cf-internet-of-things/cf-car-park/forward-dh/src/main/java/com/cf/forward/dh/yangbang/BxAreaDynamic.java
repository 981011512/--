package com.cf.forward.dh.yangbang;

public class BxAreaDynamic extends BxArea {

    private static final byte TYPE = 0x00;

    private boolean is5K = false;
    
    //
    // id
    // 动态区域编号
    // 注意：该参数只对动态区有效，其他区域为默认
    // 值，动态区必须统一编号，编号从 0 开始递增。
    private byte id = 0x00;

    //
    // 行间距
    private byte lineSpace = 0x00;

    //
    // 动态区运行模式
    //0—动态区数据循环显示。
    //1—动态区数据显示完成后静止显示最后一页数
    //据。
    //2—动态区数据循环显示，超过设定时间后数据仍
    //未更新时不再显示
    //3—动态区数据循环显示，超过设定时间后数据仍
    //未更新时显示 Logo 信息,Logo 信息即为动态区域
    //的最后一页信息
    //4—动态区数据顺序显示，显示完最后一页后就不
    //再显示
    //5—动态区数据顺序显示，超过设定次数后数据仍
    //未更新时不再显示
    private byte runMode = 0x00;

    //
    // 动 态 区 数 据 超 时 时 间 ， 单 位 为 秒 / 次 数 （ 若
    // RunMode=5，则表示更新次数）
    private short timeout = 5;

    //
    // 是否使能语音播放
    //0 表示不使能语音
    //1 表示播放下文中 Data 部分内容
    //2 表示播放下文中 SoundData 部分内容
    private byte soundMode = 0x00;

    //
    private byte soundPerson = 0x00;
    private byte soundRepeat = 0x00;
    private byte soundVolume = 0x05;
    private byte soundSpeed = 0x05;
    public byte[] soundData;

    //
    // extend para len
    private byte extendParaLen = 0x00;

    //
    // type setting
    // 属于 extend para
    private byte typeSetting = 0x00;

    //
    // text alignment
    private byte alignment = 0x00;

    //
    // single line
    private byte singleLine = 0x02;

    //
    // 是否自动换行
    // 是否自动换行
    // 0x01——不自动换行，显示数据在换行时必须插入
    // 换行符
    // 0x02——自动换行，显示内容不需要换行符，但是
    // 只能使用统一的中文字体和英文字体
    private byte autoNewLine = 0x01;

    //
    // 显示方式
    // 0x01——静止显示
    //0x02——快速打出
    //0x03——向左移动
    //0x04——向右移动
    //0x05——向上移动
    //0x06——向下移动
    private byte dispMode = 0x02;

    //
    private byte exitMode = 0x00;

    //
    // speed
    private byte speed = 0x00;

    //
    // hold time
    private byte holdTime = 0x08;

    //
    // data
    private byte[] data;

    /**
     * 动态区
     * @param id	动态区ID
     * @param x		动态区x坐标
     * @param y		动态区y坐标
     * @param w		动态区宽度
     * @param h		动态区高度
     * @param data	需要显示的数据
     * @param is5K	是否是5K系列的字库卡
     */
    public BxAreaDynamic(byte id, short x, short y, short w, short h, byte[] data, boolean is5K) {
        super(TYPE, x, y, w, h);
        this.id = id;
        this.data = data;
        this.is5K = is5K;
    }


    @Override
    public byte[] build() {

        BxByteArray array = new BxByteArray();

        // 区域类型
        array.add(TYPE);

        // x, y, w, h
        short x8 = is5K ? (short)(getX() / 8) : getX(); 
        short w8 = is5K ? (short)(getW() / 8) : getW();
        array.add(x8);
        array.add(getY());
        array.add(w8);
        array.add(getH());

        //
        // 动态区编号
        array.add(id);

        //
        // 行间距
        array.add(lineSpace);

        //
        // 运行模式
        array.add(runMode);

        //
        // timeout
        array.add(timeout);

        //
        // sound mode
        array.add(soundMode);

        //
        // sound mode = 0x01
        // 0x00 - 表示不使能语音
        // 0x01 - 表示播放下文中 Data 部分内容
        // 0x02 - 表示播放下文中 SoundData 部分内容
        if((soundMode == 0x01) || (soundMode == 0x02)) {
            //
            // person/repeat times
            byte pr = (byte) (((soundRepeat << 4) & 0xf0) | (soundPerson & 0x0f));
            array.add(pr);

            //
            // sound volume
            array.add(soundVolume);

            // sound speed
            array.add(soundSpeed);
        }

        //
        // sound data
        if(soundMode == 0x02) {
            // sound data length
            int soundDataLen = soundData.length;
            array.add(soundDataLen);

            // sound data
            array.add(soundData);
        }

        //
        // extendParaLen
        array.add(extendParaLen);

        //
        // type setting
        //array.add(typeSetting);

        //
        // alignment
        array.add(alignment);

        //
        // single line
        array.add(singleLine);

        //
        // new line
        array.add(autoNewLine);

        //
        // display mode
        array.add(dispMode);
        array.add(exitMode);
        array.add(speed);
        array.add(holdTime);

        //
        int dataLen = data.length;
        array.add(dataLen);;

        //
        array.add(data);

        return array.build();
    }

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public byte getLineSpace() {
        return lineSpace;
    }

    public void setLineSpace(byte lineSpace) {
        this.lineSpace = lineSpace;
    }

    public byte getRunMode() {
        return runMode;
    }

    public void setRunMode(byte runMode) {
        this.runMode = runMode;
    }

    public short getTimeout() {
        return timeout;
    }

    public void setTimeout(short timeout) {
        this.timeout = timeout;
    }

    public byte getSoundMode() {
        return soundMode;
    }

    public void setSoundMode(byte soundMode) {
        if(soundMode > 2)
            this.soundMode = 0x02;
        else
            this.soundMode = soundMode;
    }

    public byte getExtendParaLen() {
        return extendParaLen;
    }

    public void setExtendParaLen(byte extendParaLen) {
        this.extendParaLen = extendParaLen;
    }

    public byte getTypeSetting() {
        return typeSetting;
    }

    public void setTypeSetting(byte typeSetting) {
        this.typeSetting = typeSetting;
    }

    public byte getAlignment() {
        return alignment;
    }

    public void setAlignment(byte alignment) {
        this.alignment = alignment;
    }

    public byte getSingleLine() {
        return singleLine;
    }

    public void setSingleLine(byte singleLine) {
        this.singleLine = singleLine;
    }

    public byte getAutoNewLine() {
        return autoNewLine;
    }

    public void setAutoNewLine(byte autoNewLine) {
        this.autoNewLine = autoNewLine;
    }

    public byte getDispMode() {
        return dispMode;
    }

    public void setDispMode(byte dispMode) {
        this.dispMode = dispMode;
    }

    public byte getExitMode() {
        return exitMode;
    }

    public void setExitMode(byte exitMode) {
        this.exitMode = exitMode;
    }

    public byte getSpeed() {
        return speed;
    }

    public void setSpeed(byte speed) {
        this.speed = speed;
    }

    public byte getHoldTime() {
        return holdTime;
    }

    public void setHoldTime(byte holdTime) {
        this.holdTime = holdTime;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }



    public byte getSoundPerson() {
        return soundPerson;
    }

    public void setSoundPerson(byte soundPerson) {
        if(soundPerson > 5)
            this.soundPerson = 0;
        else
            this.soundPerson = soundPerson;
    }

    public byte getSoundRepeat() {
        return soundRepeat;
    }

    public void setSoundRepeat(byte soundRepeat) {
        if(soundRepeat > 15)
            this.soundRepeat = 15;
        else
            this.soundRepeat = soundRepeat;
    }

    public byte getSoundVolume() {
        return soundVolume;
    }

    public void setSoundVolume(byte soundVolume) {
        if(soundVolume > 10)
            this.soundVolume = 10;
        else
            this.soundVolume = soundVolume;
    }

    public byte getSoundSpeed() {
        return soundSpeed;
    }

    public void setSoundSpeed(byte soundSpeed) {
        if(soundSpeed < 1)
            this.soundSpeed = 1;
        else if(soundSpeed > 10)
            this.soundSpeed = 10;
        else
            this.soundSpeed = soundSpeed;
    }

    public byte[] getSoundData() {
        return soundData;
    }

    public void setSoundData(byte[] soundData) {
        this.soundData = soundData;
    }
}
