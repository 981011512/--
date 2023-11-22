package com.cf.logistics.service.socket;

import io.netty.channel.Channel;

import java.io.Serializable;

/**
 * 平板地锁接客户端
 */
public class CfLogisticsLedClient implements Serializable {

    private Channel channel;
    private String serialNumber; //序列号(网络id)
    private String frameHeader; //帧头
    private String address; //地址
    private String marker; //标识
    private String opcode; //操作码
    private String reservedCode; //保留码
    private String frameNumber; //帧序号
    private String totalLength; //总长度
    private String frameLength; //帧长度
    private String endOfFrame; //帧尾
    private String heartBeatContents; //记录心跳内容

    @Override
    public String toString() {
        return "CfLogisticsLedClient{" +
                "serialNumber='" + serialNumber + '\'' +
                ", frameHeader='" + frameHeader + '\'' +
                ", address='" + address + '\'' +
                ", marker='" + marker + '\'' +
                ", opcode='" + opcode + '\'' +
                ", reservedCode='" + reservedCode + '\'' +
                ", frameNumber='" + frameNumber + '\'' +
                ", totalLength='" + totalLength + '\'' +
                ", frameLength='" + frameLength + '\'' +
                ", endOfFrame='" + endOfFrame + '\'' +
                ", heartBeatContents='" + heartBeatContents + '\'' +
                '}';
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getFrameHeader() {
        return frameHeader;
    }

    public void setFrameHeader(String frameHeader) {
        this.frameHeader = frameHeader;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMarker() {
        return marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public String getOpcode() {
        return opcode;
    }

    public void setOpcode(String opcode) {
        this.opcode = opcode;
    }

    public String getReservedCode() {
        return reservedCode;
    }

    public void setReservedCode(String reservedCode) {
        this.reservedCode = reservedCode;
    }

    public String getFrameNumber() {
        return frameNumber;
    }

    public void setFrameNumber(String frameNumber) {
        this.frameNumber = frameNumber;
    }

    public String getTotalLength() {
        return totalLength;
    }

    public void setTotalLength(String totalLength) {
        this.totalLength = totalLength;
    }

    public String getFrameLength() {
        return frameLength;
    }

    public void setFrameLength(String frameLength) {
        this.frameLength = frameLength;
    }

    public String getEndOfFrame() {
        return endOfFrame;
    }

    public void setEndOfFrame(String endOfFrame) {
        this.endOfFrame = endOfFrame;
    }

    public String getHeartBeatContents() {
        return heartBeatContents;
    }

    public void setHeartBeatContents(String heartBeatContents) {
        this.heartBeatContents = heartBeatContents;
    }
}
