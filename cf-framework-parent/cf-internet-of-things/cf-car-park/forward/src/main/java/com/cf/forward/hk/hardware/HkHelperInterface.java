package com.cf.forward.hk.hardware;

import com.cf.carpark.domain.CfCarParkPackage;

import java.util.List;

/**
 * 海康道闸控制接口
 */
public interface HkHelperInterface {

    /**
     *
     * @param isOpen
     * @return
     */
   boolean openAndClose(boolean isOpen);

    /**
     *
     * @param content LED 显示内容
     * @param showTime 显示时间（ s ）
     */
   void controlLED(String content, int showTime);


    /**
     * 语音播报
     */
    void controlVoice( String content);


    /**
     * LED 空闲监听
     */
    void ledOutFree();

    /**
     * 批量添加 黑/白 名单车牌列表
     * @param cfCarParkPackageList
     * @param type //名单属性（黑白名单）：0- 白名单，1- 黑名单
     */
    void addCarPackageList(List<CfCarParkPackage> cfCarParkPackageList, byte type);

}
