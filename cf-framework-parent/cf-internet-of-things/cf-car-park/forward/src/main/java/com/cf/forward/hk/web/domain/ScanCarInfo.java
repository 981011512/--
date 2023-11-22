package com.cf.forward.hk.web.domain;

import lombok.Data;

import java.util.Date;

/**
 *
 * @author why
 */
@Data
public class ScanCarInfo {

    /**
     * 车牌
     */
    private String numberPlate ;

    /**
     * 扫牌时间
     */
    private Date scanTime;


}
