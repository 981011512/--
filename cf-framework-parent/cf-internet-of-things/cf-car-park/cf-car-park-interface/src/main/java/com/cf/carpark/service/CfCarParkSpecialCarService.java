package com.cf.carpark.service;

import com.cf.carpark.domain.CfCarPark;
import com.cf.carpark.domain.CfCarParkSpecialCar;
import com.cf.carpark.domain.CfCarParkSpecialCarExample;
import com.cf.carpark.domain.request.CfCarParkSpecialCarQuery;

import java.util.List;
import java.util.Map;

public interface CfCarParkSpecialCarService {

    CfCarParkSpecialCar add(CfCarParkSpecialCar cfCarParkSpecialCar);

    Integer batchAdd(List<CfCarParkSpecialCar> cfCarParkSpecialCarList);

    CfCarParkSpecialCar update(CfCarParkSpecialCar cfCarParkSpecialCar);

    Integer delete(String id);

    Integer deleteByQuery(CfCarParkSpecialCarQuery cfCarParkSpecialCarQuery);

    CfCarParkSpecialCar findById(String id);

    CfCarParkSpecialCar findById(String id, boolean expectEmpty);

    CfCarParkSpecialCarExample getExampleByQuery(CfCarParkSpecialCarQuery cfCarParkSpecialCarQuery);

    List<CfCarParkSpecialCar> getListByQuery(CfCarParkSpecialCarQuery cfCarParkSpecialCarQuery);

    List<CfCarParkSpecialCar> selectContinCarParkByQuery(CfCarParkSpecialCarQuery cfCarParkSpecialCarQuery);

    Integer countByQuery(CfCarParkSpecialCarQuery cfCarParkSpecialCarQuery);

    /**
     * 处理自动赠送优惠券额度
     */
    void handleAutoGiveAway() throws Exception;
}
