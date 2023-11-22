package com.cf.logistics.service;

import com.cf.logistics.domain.CfLogisticsQueuingArea;
import com.cf.logistics.domain.CfLogisticsQueuingAreaExample;
import com.cf.logistics.domain.request.CfLogisticsQueuingAreaQuery;

import java.util.List;

public interface CfLogisticsQueuingAreaService {

    CfLogisticsQueuingArea add(CfLogisticsQueuingArea cfLogisticsQueuingArea);

    CfLogisticsQueuingArea update(CfLogisticsQueuingArea cfLogisticsQueuingArea);

    Integer delete(Long id);

    CfLogisticsQueuingArea findById(Long id);

    CfLogisticsQueuingArea findById(Long id, boolean expectEmpty);

    CfLogisticsQueuingAreaExample getExampleByQuery(CfLogisticsQueuingAreaQuery cfLogisticsQueuingAreaQuery);

    List<CfLogisticsQueuingArea> getListByQuery(CfLogisticsQueuingAreaQuery cfLogisticsQueuingAreaQuery);

    List<CfLogisticsQueuingArea> selectListByQuery(CfLogisticsQueuingAreaQuery cfLogisticsQueuingAreaQuery);

    Integer countByQuery(CfLogisticsQueuingAreaQuery cfLogisticsQueuingAreaQuery);

}
