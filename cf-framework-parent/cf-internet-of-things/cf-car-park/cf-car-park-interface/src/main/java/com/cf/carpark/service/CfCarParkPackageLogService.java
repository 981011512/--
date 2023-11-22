package com.cf.carpark.service;

import com.cf.carpark.domain.CfCarParkPackageLog;
import com.cf.carpark.domain.CfCarParkPackageLogExample;
import com.cf.carpark.domain.request.CfCarParkPackageLogQuery;

import java.util.List;

public interface CfCarParkPackageLogService {

    CfCarParkPackageLog add(CfCarParkPackageLog cfCarParkPackageLog);

    CfCarParkPackageLog update(CfCarParkPackageLog cfCarParkPackageLog);

    Integer delete(String id);

    Integer deleteByQuery(CfCarParkPackageLogQuery cfCarParkPackageLogQuery);

    CfCarParkPackageLogExample getExampleByQuery(CfCarParkPackageLogQuery cfCarParkPackageLogQuery);

    Integer countByQuery(CfCarParkPackageLogQuery cfCarParkPackageLogQuery);

    List<CfCarParkPackageLog> getListByQuery(CfCarParkPackageLogQuery cfCarParkPackageLogQuery);

    List<CfCarParkPackageLog> selectByQuery(CfCarParkPackageLogQuery cfCarParkPackageLogQuery);
}
