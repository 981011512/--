package com.cf.forward.hk.web.domain;

import lombok.Data;

import java.util.Date;

/**
 * 停车信息
 * @author why
 */
@Data
public class StopCarInfo {

    /**
     * 车牌
     */
    private String numberPlate ;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * LED 显示信息
     */
    private String showTxt;


}
