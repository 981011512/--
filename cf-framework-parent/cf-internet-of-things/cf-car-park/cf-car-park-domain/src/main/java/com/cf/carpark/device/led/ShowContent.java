package com.cf.carpark.device.led;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class ShowContent implements Serializable {
    private Map<String, TextPlay> textPlay;
    private Map<Integer, VoicePlay> voicePlay;
    private Object imagePlay;
    private Object videoPlay;
    private String deviceModel; //设备型号

    public Map<String, TextPlay> getTextPlay() {
        return textPlay;
    }

    public void setTextPlay(Map<String, TextPlay> textPlay) {
        this.textPlay = textPlay;
    }

    public Map<Integer, VoicePlay> getVoicePlay() {
        return voicePlay;
    }

    public void setVoicePlay(Map<Integer, VoicePlay> voicePlay) {
        this.voicePlay = voicePlay;
    }

    public Object getImagePlay() {
        return imagePlay;
    }

    public void setImagePlay(Object imagePlay) {
        this.imagePlay = imagePlay;
    }

    public Object getVideoPlay() {
        return videoPlay;
    }

    public void setVideoPlay(Object videoPlay) {
        this.videoPlay = videoPlay;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }
}
