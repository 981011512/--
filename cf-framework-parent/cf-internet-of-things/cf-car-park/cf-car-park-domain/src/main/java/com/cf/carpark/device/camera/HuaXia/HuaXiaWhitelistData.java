package com.cf.carpark.device.camera.HuaXia;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 华夏下发白名单数据实体
 */

@Getter
@Setter
@ApiModel(value = "WhitelistData", description = "华夏白名单下发表单实体")
public class HuaXiaWhitelistData implements Serializable {

    @ApiModelProperty("车牌号")
    private String plateNum;

    @ApiModelProperty("名单类型(W：表示白名单；B：表示黑名单。)")
    private String type;

    @ApiModelProperty("开始时间格式：年/月/日 时:分:秒")
    private String startTime;

    @ApiModelProperty("结束时间格式：年/月/日 时:分:秒")
    private String endTime;

}
