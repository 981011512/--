package com.cf.carpark.service;

import com.cf.carpark.domain.CfDailyParkingStatistcs;
import com.cf.carpark.domain.CfDailyParkingStatistcsExample;
import com.cf.carpark.domain.request.CfDailyParkingStatistcsQuery;

import java.util.List;

public interface CfDailyParkingStatistcsService {

    CfDailyParkingStatistcs add(CfDailyParkingStatistcs cfDailyParkingStatistcs);

    CfDailyParkingStatistcs update(CfDailyParkingStatistcs cfDailyParkingStatistcs);

    Integer updateByQuery(CfDailyParkingStatistcs cfDailyParkingStatistcs, CfDailyParkingStatistcsQuery cfDailyParkingStatistcsQuery);

    Integer delete(String id);

    Integer deleteByQuery(CfDailyParkingStatistcsQuery cfDailyParkingStatistcsQuery);

    CfDailyParkingStatistcs findById(String id);

    CfDailyParkingStatistcs findById(String id, boolean expectEmpty);

    CfDailyParkingStatistcsExample getExampleByQuery(CfDailyParkingStatistcsQuery cfDailyParkingStatistcsQuery);

    List<CfDailyParkingStatistcs> getListByQuery(CfDailyParkingStatistcsQuery cfDailyParkingStatistcsQuery);

    Integer countByQuery(CfDailyParkingStatistcsQuery cfDailyParkingStatistcsQuery);

    void statisticsDatas(String dateStr,Long startTime,Long endTime, boolean countMonth) throws Exception;

}
