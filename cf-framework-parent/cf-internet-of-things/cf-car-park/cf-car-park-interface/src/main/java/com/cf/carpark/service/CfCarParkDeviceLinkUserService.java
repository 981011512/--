package com.cf.carpark.service;

import com.cf.carpark.domain.CfCarParkDeviceLinkUser;
import com.cf.carpark.domain.CfCarParkDeviceLinkUserExample;
import com.cf.carpark.domain.request.CfCarParkDeviceLinkUserQuery;

import java.util.List;

public interface CfCarParkDeviceLinkUserService {

    CfCarParkDeviceLinkUser add(CfCarParkDeviceLinkUser cfCarParkDeviceLinkUser);

    Integer batchAdd(List<CfCarParkDeviceLinkUser> cfCarParkDeviceLinkUsers);

    Integer deleteByQuery(CfCarParkDeviceLinkUserQuery cfCarParkDeviceLinkUserQuery);

    List<CfCarParkDeviceLinkUser> getListByQuery(CfCarParkDeviceLinkUserQuery cfCarParkDeviceLinkUserQuery);

    CfCarParkDeviceLinkUserExample getExampleByQuery(CfCarParkDeviceLinkUserQuery cfCarParkDeviceLinkUserQuery);
}
