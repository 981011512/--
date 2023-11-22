package com.cf.carpark.device.camera.hk;

import com.cf.carpark.device.led.PlayRule;

import java.io.Serializable;

/**
 * 海康车牌识别相机响应消息实体
 */
public class HkResponse implements Serializable {

    private String openDoor;    //是否开闸 on-开闸  off-关闸

    private Byte captureFrequency;  //抓拍次数(不为空或者大于0，表示需要抓拍)

    private PlayRule playRule;  //显示规则

    public String getOpenDoor() {
        return openDoor;
    }

    public void setOpenDoor(String openDoor) {
        this.openDoor = openDoor;
    }

    public Byte getCaptureFrequency() {
        return captureFrequency;
    }

    public void setCaptureFrequency(Byte captureFrequency) {
        this.captureFrequency = captureFrequency;
    }

    public PlayRule getPlayRule() {
        return playRule;
    }

    public void setPlayRule(PlayRule playRule) {
        this.playRule = playRule;
    }
}
