package com.cf.forward.dh.entity;

import java.io.Serializable;

public class LedContents implements Serializable {

    private String contents1;   //第一行内容
    private String contents2;   //第二行内容
    private String contents3;   //第三行内容
    private String contents4;   //第四行内容
    private String voiceContents;   //语音播报内容

    public String getContents1() {
        return contents1;
    }

    public void setContents1(String contents1) {
        this.contents1 = contents1;
    }

    public String getContents2() {
        return contents2;
    }

    public void setContents2(String contents2) {
        this.contents2 = contents2;
    }

    public String getContents3() {
        return contents3;
    }

    public void setContents3(String contents3) {
        this.contents3 = contents3;
    }

    public String getContents4() {
        return contents4;
    }

    public void setContents4(String contents4) {
        this.contents4 = contents4;
    }

    public String getVoiceContents() {
        return voiceContents;
    }

    public void setVoiceContents(String voiceContents) {
        this.voiceContents = voiceContents;
    }
}
