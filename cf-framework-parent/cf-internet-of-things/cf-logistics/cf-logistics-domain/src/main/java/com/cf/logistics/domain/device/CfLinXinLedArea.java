package com.cf.logistics.domain.device;

import com.cf.framework.utils.StringTools;

import java.io.Serializable;
import java.nio.charset.Charset;

/**
 * 灵信LED主板区域实体
 */
public class CfLinXinLedArea implements Serializable {

    private Integer areaNumber; //区域编号
    private Integer areaDataBlockSize; //区域数据块的大小(包含区域属性头长度 32)
    private Integer areaX; //区域开始 x 坐标
    private Integer areaY; //区域开始 y 坐标
    private Integer areaXX; //区域开始 xx 坐标
    private Integer areaYY; //区域开始 yy 坐标
    private Integer numberOfPages; //页数
    private Integer fontSizeWidth; //字体宽，如 16 则表示字体宽为 16
    private Integer fontSizeHigh; //字体高，为 24 则表示字体高为 24
    private Integer fontColor; //颜色值0：全为红色(R) 1：全为绿色(G)2：全为蓝色(B) 3：全为黄色(RG 组合) 4：全为青色（GB 组合） 5：全为紫色（RB 组合）6：全为白色（RGB 组合）10：每个字有自己独立的颜色，颜色值为 7 彩中一种，每个字符编码后附 1 字节颜色值（红色---0，绿色---1，蓝色---2，黄色----3，青色----4，紫色-----5，白色----6）12：每一页的颜色值随机，0~6 之间随机一个值。如只有一页则这一页也会不断变化颜色。
    private Integer fontInMode;    //文字进场特效
    //01 静止显示 02 向左移动
    //03 向上移动 04 向右移动
    //05 向下移动 06 闪烁
    //07 08 水平百叶（左右）
    //09 水平百叶（右左） 10 垂直百叶（上下）
    //11 垂直百叶（下上） 12
    //15 16 左右交叉拉幕
    //17 上下交叉拉幕 18
    //19 20 左右对开
    //21 上下对开 22 左右闭合
    //23 上下闭合 24
    //31 飘雪 32
    //50 向左拉幕（左覆盖） 51 向右拉幕（右覆盖）
    //52 向上拉幕（上覆盖） 53 向下拉幕（下覆盖）
    //150 左上覆盖 151 右上覆盖
    private Integer fontInSpeed;    //当前页进场移动速度，基本单位：5ms（有时候会根据具体特效变更），数值越大越慢
    private Integer fontResidenceTime;    //文字停留时间
    private Integer pageAreaX; //当前页数据有效区域 x 坐标
    private Integer pageAreaY; //当前页数据有效区域 y 坐标
    private Integer pageAreaXX; //当前页数据有效区域 xx 坐标
    private Integer pageAreaYY; //当前页数据有效区域 yy 坐标
    private Integer fontMoveStep;    //连续移动时的步长
    private Integer fontRowSpacing;    //当前页的行间距，两行之间的点数，自动换行时用
    private Integer pageDataSize;    //本页的数据长度（仅包含实际的字符编码及颜色值，字间距数据）
    private Integer fontWordSpacing;    //当前页的字间距，如为 0xFF 则为每个字后有一个间距值，间距的值在每个字符编码后面，如每个字有单独的颜色则间距值在颜色值后面
    private String hexContents; //要下发的文字内容，需转为16进制

    public CfLinXinLedArea() {
    }

    /**
     *
     * @param areaNumber    区域编号
     * @param areaX 区域开始 x 坐标
     * @param areaY 区域开始 y 坐标
     * @param areaXX    区域开始 xx 坐标
     * @param areaYY    区域开始 yy 坐标
     * @param numberOfPages 页数
     * @param fontSizeWidth 字体宽，如 16 则表示字体宽为 16
     * @param fontSizeHigh  字体高，为 24 则表示字体高为 24
     * @param fontColor 颜色值
     * @param fontInMode    文字进场特效
     * @param fontInSpeed   当前页进场移动速度
     * @param fontResidenceTime 文字停留时间
     * @param pageAreaX 当前页数据有效区域 x 坐标
     * @param pageAreaY 当前页数据有效区域 y 坐标
     * @param pageAreaXX    当前页数据有效区域 xx 坐标
     * @param pageAreaYY    当前页数据有效区域 yy 坐标
     * @param fontMoveStep  连续移动时的步长
     * @param fontRowSpacing    当前页的行间距，两行之间的点数，自动换行时用
     * @param fontWordSpacing   当前页的字间距
     * @param textContents  要下发的文字内容(例如 "武汉才风智慧科技有限公司")
     */
    public CfLinXinLedArea(Integer areaNumber, Integer areaX, Integer areaY, Integer areaXX, Integer areaYY, Integer numberOfPages, Integer fontSizeWidth, Integer fontSizeHigh, Integer fontColor, Integer fontInMode, Integer fontInSpeed, Integer fontResidenceTime, Integer pageAreaX, Integer pageAreaY, Integer pageAreaXX, Integer pageAreaYY, Integer fontMoveStep, Integer fontRowSpacing, Integer fontWordSpacing, String textContents) throws Exception {
        this.areaNumber = areaNumber;
        this.areaX = areaX;
        this.areaY = areaY;
        this.areaXX = areaXX;
        this.areaYY = areaYY;
        this.numberOfPages = numberOfPages;
        this.fontSizeWidth = fontSizeWidth;
        this.fontSizeHigh = fontSizeHigh;
        this.fontColor = fontColor;
        this.fontInMode = fontInMode;
        this.fontInSpeed = fontInSpeed;
        this.fontResidenceTime = fontResidenceTime;
        this.pageAreaX = pageAreaX;
        this.pageAreaY = pageAreaY;
        this.pageAreaXX = pageAreaXX;
        this.pageAreaYY = pageAreaYY;
        this.fontMoveStep = fontMoveStep;
        this.fontRowSpacing = fontRowSpacing;
        this.fontWordSpacing = fontWordSpacing;
        this.hexContents = StringTools.str2HexStr(textContents,"GB18030");

        //设置本页数据长度，本系统开发所有都只使用一页，暂时不考虑多页
        this.pageDataSize = StringTools.strToHexString(textContents).length()/2;
        //设置区域区块大小 76是固定的
        this.areaDataBlockSize = (76 + this.pageDataSize);
    }

    public Integer getAreaNumber() {
        return areaNumber;
    }

    public void setAreaNumber(Integer areaNumber) {
        this.areaNumber = areaNumber;
    }

    public Integer getAreaDataBlockSize() {
        return areaDataBlockSize;
    }

    public void setAreaDataBlockSize(Integer areaDataBlockSize) {
        this.areaDataBlockSize = areaDataBlockSize;
    }

    public Integer getAreaX() {
        return areaX;
    }

    public void setAreaX(Integer areaX) {
        this.areaX = areaX;
    }

    public Integer getAreaY() {
        return areaY;
    }

    public void setAreaY(Integer areaY) {
        this.areaY = areaY;
    }

    public Integer getAreaXX() {
        return areaXX;
    }

    public void setAreaXX(Integer areaXX) {
        this.areaXX = areaXX;
    }

    public Integer getAreaYY() {
        return areaYY;
    }

    public void setAreaYY(Integer areaYY) {
        this.areaYY = areaYY;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Integer getFontSizeWidth() {
        return fontSizeWidth;
    }

    public void setFontSizeWidth(Integer fontSizeWidth) {
        this.fontSizeWidth = fontSizeWidth;
    }

    public Integer getFontSizeHigh() {
        return fontSizeHigh;
    }

    public void setFontSizeHigh(Integer fontSizeHigh) {
        this.fontSizeHigh = fontSizeHigh;
    }

    public Integer getFontColor() {
        return fontColor;
    }

    public void setFontColor(Integer fontColor) {
        this.fontColor = fontColor;
    }

    public Integer getFontInMode() {
        return fontInMode;
    }

    public void setFontInMode(Integer fontInMode) {
        this.fontInMode = fontInMode;
    }

    public Integer getFontInSpeed() {
        return fontInSpeed;
    }

    public void setFontInSpeed(Integer fontInSpeed) {
        this.fontInSpeed = fontInSpeed;
    }

    public Integer getFontResidenceTime() {
        return fontResidenceTime;
    }

    public void setFontResidenceTime(Integer fontResidenceTime) {
        this.fontResidenceTime = fontResidenceTime;
    }

    public Integer getPageAreaX() {
        return pageAreaX;
    }

    public void setPageAreaX(Integer pageAreaX) {
        this.pageAreaX = pageAreaX;
    }

    public Integer getPageAreaY() {
        return pageAreaY;
    }

    public void setPageAreaY(Integer pageAreaY) {
        this.pageAreaY = pageAreaY;
    }

    public Integer getPageAreaXX() {
        return pageAreaXX;
    }

    public void setPageAreaXX(Integer pageAreaXX) {
        this.pageAreaXX = pageAreaXX;
    }

    public Integer getPageAreaYY() {
        return pageAreaYY;
    }

    public void setPageAreaYY(Integer pageAreaYY) {
        this.pageAreaYY = pageAreaYY;
    }

    public Integer getFontMoveStep() {
        return fontMoveStep;
    }

    public void setFontMoveStep(Integer fontMoveStep) {
        this.fontMoveStep = fontMoveStep;
    }

    public Integer getFontRowSpacing() {
        return fontRowSpacing;
    }

    public void setFontRowSpacing(Integer fontRowSpacing) {
        this.fontRowSpacing = fontRowSpacing;
    }

    public Integer getPageDataSize() {
        return pageDataSize;
    }

    public void setPageDataSize(Integer pageDataSize) {
        this.pageDataSize = pageDataSize;
    }

    public Integer getFontWordSpacing() {
        return fontWordSpacing;
    }

    public void setFontWordSpacing(Integer fontWordSpacing) {
        this.fontWordSpacing = fontWordSpacing;
    }

    public String getHexContents() {
        return hexContents;
    }

    public void setHexContents(String hexContents) {
        this.hexContents = hexContents;
    }
}
