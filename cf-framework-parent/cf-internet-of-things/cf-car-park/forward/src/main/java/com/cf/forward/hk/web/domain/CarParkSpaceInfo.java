package com.cf.forward.hk.web.domain;

import lombok.Data;

/**
 * 道闸停车信息
 * @author why
 */
@Data
public class CarParkSpaceInfo {
    /**
     * 1-匝道
     * 2-相机
     */
    private Integer deviceType;
    /**
     * 方向：
     * 入口 （in）
     * 出口 (out)
     */
    private String direction;
    /**
     * 停车场名称
     */
    public String carparkName;

    /**
     * 剩余车位数
     */
    public int spaceNum;
}
