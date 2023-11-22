package com.cf.carpark.device.camera.HuaXia;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 下发白名单数据实体
 */
public class WhitelistData implements Serializable {
    @JsonProperty("Action")
    private String Action;
    @JsonProperty("PlateNumber")
    private String PlateNumber;
    @JsonProperty("Type")
    private String Type;
    @JsonProperty("Start")
    private String Start;
    @JsonProperty("End")
    private String End;

    public String getAction() {
        return Action;
    }

    public void setAction(String action) {
        Action = action;
    }

    public String getPlateNumber() {
        return PlateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        PlateNumber = plateNumber;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getStart() {
        return Start;
    }

    public void setStart(String start) {
        Start = start;
    }

    public String getEnd() {
        return End;
    }

    public void setEnd(String end) {
        End = end;
    }
}
