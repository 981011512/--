package com.cf.carpark.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * 开闸请求实体
 */
public class OpenDoor implements Serializable {
    @ApiModelProperty(value = "备注", required = true)
    private String remarks;
    @ApiModelProperty(value = "停车记录", required = false)
    private String carParkUseLogId;
    @ApiModelProperty(value = "通道id", required = true)
    private String checkPointId;
    @ApiModelProperty(value = "开闸原因", required = true)
    private String applicationReason;
    @ApiModelProperty(value = "开闸前缀", required = true)
    @JsonProperty("RedisPreFix")
    private String RedisPreFix;
    @ApiModelProperty(value = "类型 1-正常放行/2-异常放行", required = true)
    @Min(value = 1)
    @Max(value = 2)
    private byte type;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCarParkUseLogId() {
        return carParkUseLogId;
    }

    public void setCarParkUseLogId(String carParkUseLogId) {
        this.carParkUseLogId = carParkUseLogId;
    }

    public String getCheckPointId() {
        return checkPointId;
    }

    public void setCheckPointId(String checkPointId) {
        this.checkPointId = checkPointId;
    }

    public String getApplicationReason() {
        return applicationReason;
    }

    public void setApplicationReason(String applicationReason) {
        this.applicationReason = applicationReason;
    }

    public String getRedisPreFix() {
        return RedisPreFix;
    }

    public void setRedisPreFix(String redisPreFix) {
        RedisPreFix = redisPreFix;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }
}
