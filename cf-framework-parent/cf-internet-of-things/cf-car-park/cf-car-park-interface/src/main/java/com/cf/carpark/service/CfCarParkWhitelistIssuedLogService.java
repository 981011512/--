package com.cf.carpark.service;

import com.cf.carpark.domain.CfCarParkWhitelistIssuedLog;
import com.cf.carpark.domain.CfCarParkWhitelistIssuedLogExample;
import com.cf.carpark.domain.request.CfCarParkWhitelistIssuedLogQuery;

import java.util.List;

public interface CfCarParkWhitelistIssuedLogService {

    /**
     * 批量添加
     * @param cfCarParkWhitelistIssuedLogList
     * @return
     */
    Integer batchAdd(List<CfCarParkWhitelistIssuedLog> cfCarParkWhitelistIssuedLogList);

    List<CfCarParkWhitelistIssuedLog> getListByQuery(CfCarParkWhitelistIssuedLogQuery cfCarParkWhitelistIssuedLogQuery);

    CfCarParkWhitelistIssuedLogExample getExampleByQuery(CfCarParkWhitelistIssuedLogQuery cfCarParkWhitelistIssuedLogQuery);

    /**
     * 根据条件删除
     * @param cfCarParkWhitelistIssuedLogQuery
     * @return
     */
    Integer deleteByQuery(CfCarParkWhitelistIssuedLogQuery cfCarParkWhitelistIssuedLogQuery);

}
