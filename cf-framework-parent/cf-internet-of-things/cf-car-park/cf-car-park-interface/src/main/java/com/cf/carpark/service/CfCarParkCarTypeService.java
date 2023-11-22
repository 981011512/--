package com.cf.carpark.service;

import com.cf.carpark.domain.CfCarParkCarType;
import com.cf.carpark.domain.CfCarParkCarTypeExample;
import com.cf.carpark.domain.request.CfCarParkCarTypeQuery;

import java.util.List;

/**
 * 停车场车牌类型(套餐类型)
 *
 * @ClassName CfCarParkCarTypeService
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/23/023 21:49
 * @Version 1.0
 **/
public interface CfCarParkCarTypeService {

    public List<CfCarParkCarType> getAllList();

    public CfCarParkCarType add(CfCarParkCarType cfCarParkCarType);

    public CfCarParkCarType update(CfCarParkCarType cfCarParkCarType);

    public Integer delete(String id);

    public CfCarParkCarType findById(String id);

    public CfCarParkCarType findById(String id, boolean expectEmpty);

    CfCarParkCarType findByKey(String key);

    CfCarParkCarType findByKey(String key, boolean expectEmpty);

    CfCarParkCarTypeExample getExampleByQuery(CfCarParkCarTypeQuery cfCarParkCarTypeQuery);

    List<CfCarParkCarType> getListByQuery(CfCarParkCarTypeQuery cfCarParkCarTypeQuery);

    Integer countByQuery(CfCarParkCarTypeQuery cfCarParkCarTypeQuery);

}
