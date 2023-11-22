package com.cf.carpark.service;

import com.cf.carpark.domain.CfCarParkCarLimit;
import com.cf.carpark.domain.CfCarParkCarLimitExample;
import com.cf.carpark.domain.request.CfCarParkCarLimitQuery;

import java.util.List;

public interface CfCarParkCarLimitService {

    CfCarParkCarLimit add(CfCarParkCarLimit cfCarParkCarLimit);

    Integer delete(String id);

    Integer deleteByQuery(CfCarParkCarLimitQuery cfCarParkCarLimitQuery);

    CfCarParkCarLimit update(CfCarParkCarLimit cfCarParkCarLimit);

    CfCarParkCarLimitExample getExampleByQuery(CfCarParkCarLimitQuery cfCarParkCarLimitQuery);

    List<CfCarParkCarLimit> getListByQuery(CfCarParkCarLimitQuery cfCarParkCarLimitQuery)
            ;
    List<CfCarParkCarLimit> selectContinCarParkByQuery(CfCarParkCarLimitQuery cfCarParkCarLimitQuery);

    Integer countByQuery(CfCarParkCarLimitQuery cfCarParkCarLimitQuery);

    /**
     * 获取车辆限制类型
     * @param numberPlate
     * @param carParkId
     * @return
     */
    CfCarParkCarLimit getCarTypeLimit(String numberPlate, String carParkId);

}
