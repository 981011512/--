package com.cf.logistics.domain.device;

import java.io.Serializable;
import java.util.List;

/**
 * 灵信LED主板实体，
 * 主板型号：C2M
 *
 * * 【显示数据属性】
 *  * 75757575757575757575757575757575	全为 0x00
 *  * 8000	显示屏宽，横向点数
 *  * 4000	显示屏高，纵向点数
 *  * 03	1—单基色，2—双基色，3—三基色
 *  * 05	灰度等级 bit 数（无灰度为 1，4 级灰度为 2，8 级灰度为 3，16 级灰度为 4，32 级灰度时为 5）
 *  * 01	存入所在位置的节目个数(两者之和需小于 256)
 *  * 03	0---节目存入 Flash，如之前有 RAM 节目存在时是混合一起播放1---节目存入 RAM，如之前有 Flash 节目存在时是混合一起播放2—节目存入 Flash 且仅播放 Flash 节目3—节目存入 RAM 且仅播放 RAM 节目
 *  * 0000000000000000	全为 0x00
 *  * 97000000	整个节目数据的总大小（包含显示数据属性长度 44）
 *  * 0000000000000000	全为 0x00
 *  * 【节目属性】
 *  * 80	节目编号，从 0 开始，从小到大排，不能跳跃
 *  * 6B000000	节目数据块的大小（包含节目属性长度 26）
 *  * 02	固定为 0x02
 *  * 01	节目中区域个数
 *  * 0000	D1D0：0—单节目循环播放，非 0—单节目定长播放秒数
 *  * 01	单节目循环播放时的次数
 *  * 00000000000000000000000000000000	全为 0x00
 *  * 【区域属性】
 *  * 01	区域编号
 *  * 51000000	区域数据块的大小(包含区域属性头长度 32)
 *  * E5	固定为 0Xe5
 *  * 01	固定为 0x01
 *  * 01	固定为 0x01
 *  * 00000000	全部为 0x00
 *  * [区域坐标]
 *  * 0000	区域开始 x 坐标
 *  * 0000	区域开始 y 坐标
 *  * 7F00	区域开始 xx 坐标
 *  * 3F00	区域开始 yy 坐标
 *  * 000000000000000000000000	全部为 0x00
 *  * 02	固定为 0x02
 *  * 31000000	区域数据块的大小减去 32
 *  * 0E	固定为 0x0e
 *  * 0100	区域中的页数
 *  * [文字大小（字高宽点数）]
 *  * 10	GB2312 字体宽，如 16 则表示字体宽为 16
 *  * 10	GB2312 字体高，为 24 则表示字体高为 24
 *  * 00	颜色值0：全为红色(R) 1：全为绿色(G)2：全为蓝色(B) 3：全为黄色(RG 组合) 4：全为青色（GB 组合） 5：全为紫色（RB 组合）6：全为白色（RGB 组合）10：每个字有自己独立的颜色，颜色值为 7 彩中一种，每个字符编码后附 1 字节颜色值（红色---0，绿色---1，蓝色---2，黄色----3，青色----4，紫色-----5，白色----6）12：每一页的颜色值随机，0~6 之间随机一个值。如只有一页则这一页也会不断变化颜色。
 *  * 03	固定 0x03
 *  * 000000000000000000000000	全为 0x00
 *  * 01	当前页进场特效
 *  * FF	固定 0x00
 *  * 04	当前页进场移动速度，基本单位：5ms（有时候会根据具体特效变更），数值越大越慢
 *  * FF	固定 0x00
 *  * 0300	当前页停留时间，单位：1s
 *  * 0000	当前页数据有效区域 x 坐标
 *  * 0000	当前页数据有效区域 y 坐标
 *  * 7F00	当前页数据有效区域 xx 坐标
 *  * 3F00	当前页数据有效区域 yy 坐标
 *  * 01	连续移动时的步长
 *  * 00	当前页的行间距，两行之间的点数，自动换行时用。
 *  * 0500	本页的数据长度（仅包含实际的字符编码及颜色值，字间距数据）
 *  * 00	当前页的字间距，如为 0xFF 则为每个字后有一个间距值，间距的值在每个字符编码后面，如每个字有单独的颜色则间距值在颜色值后面
 *  * FF	固定 0x00
 *  * 68656C6C6F	文字数据内容
 */
public class CfLinXinLed implements Serializable {

    private Integer screenWidth; //显示屏宽，横向点数
    private Integer screenHigh; //显示屏高，纵向点数
    private Integer primaryColor; //1—单基色，2—双基色，3—三基色
    private Integer grayScale; //灰度等级 bit 数（无灰度为 1，4 级灰度为 2，8 级灰度为 3，16 级灰度为 4，32 级灰度时为 5）
    private Integer numberOfPrograms; //存入所在位置的节目个数(两者之和需小于 256)
    private Integer playbackMode; //0---节目存入 Flash，如之前有 RAM 节目存在时是混合一起播放1---节目存入 RAM，如之前有 Flash 节目存在时是混合一起播放2—节目存入 Flash 且仅播放 Flash 节目3—节目存入 RAM 且仅播放 RAM 节目
    private Integer totalSizeOfProgramData; //整个节目数据的总大小（包含显示数据属性长度 44）

    private List<CfLinXinLedProgram> cfLinXinLedProgramList; //节目数据

    public CfLinXinLed() {
    }

    public CfLinXinLed(Integer screenWith, Integer screenHigh, Integer primaryColor, Integer grayScale, Integer playbackMode, List<CfLinXinLedProgram> cfLinXinLedProgramList) throws Exception {
        this.screenWidth = screenWith;
        this.screenHigh = screenHigh;
        this.primaryColor = primaryColor;
        this.grayScale = grayScale;
        this.playbackMode = playbackMode;
        this.cfLinXinLedProgramList = cfLinXinLedProgramList;

        if(cfLinXinLedProgramList==null || cfLinXinLedProgramList.size()==0){
            throw new Exception("请至少传入一个节目");
        }
        //设置节目个数
        this.numberOfPrograms = cfLinXinLedProgramList.size();
        //设置整个节目数据的总大小
        int programsDataCount = 0;
        for(CfLinXinLedProgram cfLinXinLedProgram: cfLinXinLedProgramList){
            programsDataCount += cfLinXinLedProgram.getProgramDataBlockSize();
        }
        this.totalSizeOfProgramData = 44 + programsDataCount;
    }

    public Integer getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(Integer screenWidth) {
        this.screenWidth = screenWidth;
    }

    public Integer getScreenHigh() {
        return screenHigh;
    }

    public void setScreenHigh(Integer screenHigh) {
        this.screenHigh = screenHigh;
    }

    public Integer getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(Integer primaryColor) {
        this.primaryColor = primaryColor;
    }

    public Integer getGrayScale() {
        return grayScale;
    }

    public void setGrayScale(Integer grayScale) {
        this.grayScale = grayScale;
    }

    public Integer getNumberOfPrograms() {
        return numberOfPrograms;
    }

    public void setNumberOfPrograms(Integer numberOfPrograms) {
        this.numberOfPrograms = numberOfPrograms;
    }

    public Integer getPlaybackMode() {
        return playbackMode;
    }

    public void setPlaybackMode(Integer playbackMode) {
        this.playbackMode = playbackMode;
    }

    public Integer getTotalSizeOfProgramData() {
        return totalSizeOfProgramData;
    }

    public void setTotalSizeOfProgramData(Integer totalSizeOfProgramData) {
        this.totalSizeOfProgramData = totalSizeOfProgramData;
    }

    public List<CfLinXinLedProgram> getCfLinXinLedProgramList() {
        return cfLinXinLedProgramList;
    }

    public void setCfLinXinLedProgramList(List<CfLinXinLedProgram> cfLinXinLedProgramList) {
        this.cfLinXinLedProgramList = cfLinXinLedProgramList;
    }
}
