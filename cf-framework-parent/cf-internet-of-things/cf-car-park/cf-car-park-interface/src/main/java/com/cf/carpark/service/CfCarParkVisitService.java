package com.cf.carpark.service;

import com.cf.carpark.domain.CfCarParkVisit;
import com.cf.carpark.domain.CfCarParkVisitExample;
import com.cf.carpark.domain.request.CfCarParkVisitQuery;

import java.util.List;

/**
 * 车辆到访申请记录管理
 */
public interface CfCarParkVisitService {

    CfCarParkVisit add(CfCarParkVisit cfCarParkVisit);

    CfCarParkVisit update(CfCarParkVisit cfCarParkVisit);

    Integer updateByQuery(CfCarParkVisit cfCarParkVisit, CfCarParkVisitQuery cfCarParkVisitQuery);

    Integer delete(Long id);

    Integer deleteByQuery(CfCarParkVisitQuery cfCarParkVisitQuery);

    CfCarParkVisit findById(Long id);

    CfCarParkVisit findById(Long id, boolean expectEmpty);

    CfCarParkVisitExample getExampleByQuery(CfCarParkVisitQuery cfCarParkVisitQuery);

    List<CfCarParkVisit> getListByQuery(CfCarParkVisitQuery cfCarParkVisitQuery);

    Integer countByQuery(CfCarParkVisitQuery cfCarParkVisitQuery);

    List<CfCarParkVisit> selectContinByQuery(CfCarParkVisitQuery cfCarParkVisitQuery);

}
