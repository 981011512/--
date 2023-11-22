package com.cf.carpark.service.impl;

import com.cf.carpark.dao.mapper.CfCarParkCarLimitMapper;
import com.cf.carpark.domain.CfCarParkCarLimit;
import com.cf.carpark.domain.CfCarParkCarLimitExample;
import com.cf.carpark.domain.CfCarParkSpecialCar;
import com.cf.carpark.domain.request.CfCarParkCarLimitQuery;
import com.cf.carpark.domain.request.CfCarParkSpecialCarQuery;
import com.cf.carpark.service.CfCarParkCarLimitService;
import com.cf.carpark.service.CfCarParkSpecialCarService;
import com.cf.framework.utils.IdWorker;
import com.github.pagehelper.PageHelper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfCarParkCarLimitServiceImpl implements CfCarParkCarLimitService {

    @Autowired
    private CfCarParkCarLimitMapper cfCarParkCarLimitMapper;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CfCarParkSpecialCarService cfCarParkSpecialCarService;

    @Override
    public CfCarParkCarLimit add(CfCarParkCarLimit cfCarParkCarLimit) {
        cfCarParkCarLimit.setId(idWorker.nextId());
        cfCarParkCarLimitMapper.insert(cfCarParkCarLimit);
        return cfCarParkCarLimit;
    }

    @Override
    public Integer delete(String id) {
        return cfCarParkCarLimitMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteByQuery(CfCarParkCarLimitQuery cfCarParkCarLimitQuery) {
        return cfCarParkCarLimitMapper.deleteByExample(getExampleByQuery(cfCarParkCarLimitQuery));
    }

    @Override
    public CfCarParkCarLimit update(CfCarParkCarLimit cfCarParkCarLimit) {
        cfCarParkCarLimitMapper.updateByPrimaryKey(cfCarParkCarLimit);
        return cfCarParkCarLimit;
    }

    @Override
    public CfCarParkCarLimitExample getExampleByQuery(CfCarParkCarLimitQuery cfCarParkCarLimitQuery) {
        CfCarParkCarLimitExample cfCarParkCarLimitExample = new CfCarParkCarLimitExample();
        CfCarParkCarLimitExample.Criteria criteria = cfCarParkCarLimitExample.createCriteria();
        if(cfCarParkCarLimitQuery.getId()!=null){
            criteria.andIdEqualTo(cfCarParkCarLimitQuery.getId());
        }
        if(cfCarParkCarLimitQuery.getCarParkId()!=null){
            criteria.andCarParkIdEqualTo(cfCarParkCarLimitQuery.getCarParkId());
        }
        if(cfCarParkCarLimitQuery.getCarTypeKey()!=null){
            criteria.andCarTypeKeyEqualTo(cfCarParkCarLimitQuery.getCarTypeKey());
        }

        if(cfCarParkCarLimitQuery.getPage()!=null && cfCarParkCarLimitQuery.getSize()!=null){
            PageHelper.startPage(cfCarParkCarLimitQuery.getPage(), cfCarParkCarLimitQuery.getSize());
        }
        return cfCarParkCarLimitExample;
    }

    @Override
    public List<CfCarParkCarLimit> getListByQuery(CfCarParkCarLimitQuery cfCarParkCarLimitQuery) {
        return cfCarParkCarLimitMapper.selectByExample(getExampleByQuery(cfCarParkCarLimitQuery));
    }

    @Override
    public List<CfCarParkCarLimit> selectContinCarParkByQuery(CfCarParkCarLimitQuery cfCarParkCarLimitQuery) {
        return cfCarParkCarLimitMapper.selectContinCarParkByQuery(cfCarParkCarLimitQuery);
    }

    @Override
    public Integer countByQuery(CfCarParkCarLimitQuery cfCarParkCarLimitQuery) {
        cfCarParkCarLimitQuery.setPage(null);
        return cfCarParkCarLimitMapper.countByExample(getExampleByQuery(cfCarParkCarLimitQuery));
    }

    public CfCarParkCarLimit getCarTypeLimit(String numberPlate, String carParkId)
    {
        String carTypeKey = "temporary_car";

        CfCarParkSpecialCarQuery cfCarParkSpecialCarQuery = new CfCarParkSpecialCarQuery();
        cfCarParkSpecialCarQuery.setNumberPlate(numberPlate);
        cfCarParkSpecialCarQuery.setCarParkId(carParkId);
        cfCarParkSpecialCarQuery.setMaxStartTime(System.currentTimeMillis());
        cfCarParkSpecialCarQuery.setMinEndTime(System.currentTimeMillis());
        cfCarParkSpecialCarQuery.setPage(1);
        cfCarParkSpecialCarQuery.setSize(1);
        List<CfCarParkSpecialCar> cfCarParkSpecialCars = cfCarParkSpecialCarService.getListByQuery(cfCarParkSpecialCarQuery);
        if(cfCarParkSpecialCars!=null && cfCarParkSpecialCars.size()>0){
            carTypeKey = cfCarParkSpecialCars.get(0).getTypeKey();
        }
        CfCarParkCarLimitQuery cfCarParkCarLimitQuery = new CfCarParkCarLimitQuery();
        cfCarParkCarLimitQuery.setCarTypeKey(carTypeKey);
        cfCarParkCarLimitQuery.setCarParkId(carParkId);
        cfCarParkCarLimitQuery.setPage(1);
        cfCarParkCarLimitQuery.setSize(1);
        List<CfCarParkCarLimit> cfCarParkCarLimits = getListByQuery(cfCarParkCarLimitQuery);
        if(cfCarParkCarLimits==null || cfCarParkCarLimits.size()==0){
            return null;
        }
        if(cfCarParkSpecialCars!=null && cfCarParkSpecialCars.size()>0){
            cfCarParkCarLimits.get(0).setCfCarParkSpecialCar(cfCarParkSpecialCars.get(0));
        }
        return cfCarParkCarLimits.get(0);
    }
}
