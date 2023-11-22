package com.cf.logistics.domain.device;

import java.io.Serializable;
import java.util.List;

/**
 * 灵信LED主板节目实体
 */
public class CfLinXinLedProgram implements Serializable {

    private Integer programNumber; //节目编号
    private Integer programDataBlockSize; //节目数据块的大小（包含节目属性长度 26）
    private Integer areaSize; //节目中区域个数
    private Integer programPlayMode; //0—单节目循环播放，非 0—单节目定长播放秒数
    private Integer cyclePlaybackTimes; //单节目循环播放时的次数

    private List<CfLinXinLedArea> cfLinXinLedAreaList;    //节目包含的区域数据

    public CfLinXinLedProgram() {
    }

    public CfLinXinLedProgram(Integer programNumber, Integer programPlayMode, Integer cyclePlaybackTimes, List<CfLinXinLedArea> cfLinXinLedAreaList) throws Exception {
        this.programNumber = programNumber;
        this.programPlayMode = programPlayMode;
        this.cyclePlaybackTimes = cyclePlaybackTimes;
        this.cfLinXinLedAreaList = cfLinXinLedAreaList;
        //设置节目区块数据
        if(cfLinXinLedAreaList==null || cfLinXinLedAreaList.size()==0){
            throw new Exception("请至少传入一个区域");
        }
        int areaDataSizeCount = 0;
        for(CfLinXinLedArea cfLinXinLedArea: cfLinXinLedAreaList){
            areaDataSizeCount += cfLinXinLedArea.getAreaDataBlockSize();
        }
        this.programDataBlockSize = 26 + areaDataSizeCount;
        //设置节目区域个数
        this.areaSize = cfLinXinLedAreaList.size();
    }

    public Integer getProgramNumber() {
        return programNumber;
    }

    public void setProgramNumber(Integer programNumber) {
        this.programNumber = programNumber;
    }

    public Integer getProgramDataBlockSize() {
        return programDataBlockSize;
    }

    public void setProgramDataBlockSize(Integer programDataBlockSize) {
        this.programDataBlockSize = programDataBlockSize;
    }

    public Integer getAreaSize() {
        return areaSize;
    }

    public void setAreaSize(Integer areaSize) {
        this.areaSize = areaSize;
    }

    public Integer getProgramPlayMode() {
        return programPlayMode;
    }

    public void setProgramPlayMode(Integer programPlayMode) {
        this.programPlayMode = programPlayMode;
    }

    public Integer getCyclePlaybackTimes() {
        return cyclePlaybackTimes;
    }

    public void setCyclePlaybackTimes(Integer cyclePlaybackTimes) {
        this.cyclePlaybackTimes = cyclePlaybackTimes;
    }

    public List<CfLinXinLedArea> getCfLinXinLedAreaList() {
        return cfLinXinLedAreaList;
    }

    public void setCfLinXinLedAreaList(List<CfLinXinLedArea> cfLinXinLedAreaList) {
        this.cfLinXinLedAreaList = cfLinXinLedAreaList;
    }
}
