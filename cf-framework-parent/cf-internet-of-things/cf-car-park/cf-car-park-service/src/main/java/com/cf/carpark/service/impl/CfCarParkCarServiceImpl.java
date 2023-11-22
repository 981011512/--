package com.cf.carpark.service.impl;

import com.cf.carpark.dao.mapper.CfCarParkCarMapper;
import com.cf.carpark.domain.CfCarParkCar;
import com.cf.carpark.domain.CfCarParkCarExample;
import com.cf.carpark.domain.request.CfCarParkCarQuery;
import com.cf.carpark.domain.request.CfCarParkUseLogQuery;
import com.cf.framework.domain.carpark.response.CarParkCode;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.DbUtils;
import com.cf.framework.utils.IdWorker;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 车辆管理
 *
 * @ClassName CfCarParkCarService
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/4/29/029 7:06
 * @Version 1.0
 **/
@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfCarParkCarServiceImpl implements com.cf.carpark.service.CfCarParkCarService {

    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CfCarParkCarMapper cfCarParkCarMapper;

    @Override
    public CfCarParkCar add(CfCarParkCar cfCarParkCar) {
        cfCarParkCar.setId(idWorker.nextId());
        handleCfCarParkCarDefaultValue(cfCarParkCar);
        cfCarParkCar.setUpdateTime(System.currentTimeMillis());

        //禁止重复录入 存在相同直接更新
        CfCarParkCarQuery cfCarParkCarQuery = new CfCarParkCarQuery();
        cfCarParkCarQuery.setUid(cfCarParkCar.getUid());
        cfCarParkCarQuery.setNumberPlate(cfCarParkCar.getNumberPlate());
        List<CfCarParkCar> cfCarParkCars = mapperSelectByQuery(cfCarParkCarQuery);
        if(cfCarParkCars!=null && cfCarParkCars.size()>0){
            cfCarParkCar.setId(cfCarParkCars.get(0).getId());
            cfCarParkCarMapper.updateByPrimaryKey(cfCarParkCar);
        }else{
            cfCarParkCar.setCreateTime(System.currentTimeMillis());
            cfCarParkCarMapper.insert(cfCarParkCar);
        }
        return cfCarParkCar;
    }

    @Override
    public CfCarParkCar bindCarToUser(CfCarParkCar cfCarParkCar) {
        handleCfCarParkCarDefaultValue(cfCarParkCar);
        CfCarParkCarQuery cfCarParkCarQuery = new CfCarParkCarQuery();
        cfCarParkCarQuery.setUid(cfCarParkCar.getUid());
        cfCarParkCarQuery.setNumberPlate(cfCarParkCar.getNumberPlate());
        List<CfCarParkCar> myCarsByCondition = getMyCarsByCondition(cfCarParkCarQuery);
        if(myCarsByCondition!=null && myCarsByCondition.size()>0){
            ExceptionCast.cast(CarParkCode.BIND_LICENSE_PLATES_REPEATEDLY);
        }
        Integer countsByUid = cfCarParkCarMapper.getCountsByUid(cfCarParkCar.getUid());
        if(countsByUid>=300){
            ExceptionCast.cast(CarParkCode.BIND_CAR_REACHED_THE_UPPER_LIMIT);
        }
        return add(cfCarParkCar);
    }

    @Override
    public Integer delete(String id) {
        return cfCarParkCarMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteByQuery(CfCarParkCarQuery cfCarParkCarQuery) {
        return cfCarParkCarMapper.deleteByExample(getExampleByQuery(cfCarParkCarQuery));
    }

    @Override
    public CfCarParkCar update(CfCarParkCar cfCarParkCar) {
        handleCfCarParkCarDefaultValue(cfCarParkCar);
        cfCarParkCar.setUpdateTime(System.currentTimeMillis());
        cfCarParkCarMapper.updateByPrimaryKeySelective(cfCarParkCar);
        return cfCarParkCar;
    }

    @Override
    public Integer updateByQuery(CfCarParkCar cfCarParkCar, CfCarParkCarQuery cfCarParkCarQuery) {
        return cfCarParkCarMapper.updateByExampleSelective(cfCarParkCar, getExampleByQuery(cfCarParkCarQuery));
    }

    @Override
    public CfCarParkCar findById(String id) {
        return cfCarParkCarMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CfCarParkCar> selectListByCondition(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds) {
        String sql = "SELECT cpc.*,u.user_name FROM cf_car_park_car cpc LEFT JOIN cf_user u ON(cpc.uid=u.id)";
        sql = DbUtils.makeQuery(conditions, allowFiledsMap, allowFileds, sql, false);
        return cfCarParkCarMapper.selectListByCondition(sql);
    }

    @Override
    public Integer selectListByConditionCounts(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds) {
        String sql = "SELECT count(*) FROM cf_car_park_car";
        sql = DbUtils.makeQuery(conditions, allowFiledsMap, allowFileds, sql, true);
        return cfCarParkCarMapper.selectListByConditionCounts(sql);
    }

    @Override
    public List<CfCarParkCar> getMyCarsByCondition(CfCarParkCarQuery cfCarParkCarQuery) {
        CfCarParkCarExample cfCarParkCarExample = new CfCarParkCarExample();
        CfCarParkCarExample.Criteria criteria = cfCarParkCarExample.createCriteria();
        if(cfCarParkCarQuery.getUid()!=null){
            criteria.andUidEqualTo(cfCarParkCarQuery.getUid());
        }
        if(cfCarParkCarQuery.getNumberPlate()!=null){
            criteria.andNumberPlateEqualTo(cfCarParkCarQuery.getNumberPlate());
        }
        if(cfCarParkCarQuery.getStatus()!=null){
            criteria.andStatusEqualTo(cfCarParkCarQuery.getStatus());
        }
        if(cfCarParkCarQuery.getCarTypeKey()!=null){
            criteria.andCarTypeKeyEqualTo(cfCarParkCarQuery.getCarTypeKey());
        }
        if(StringUtils.isNotEmpty(cfCarParkCarQuery.getOrderBy())){
            cfCarParkCarExample.setOrderByClause(cfCarParkCarQuery.getOrderBy());
        }
        if(cfCarParkCarQuery.getPage()!=null && cfCarParkCarQuery.getSize()!=null){
            PageHelper.startPage(cfCarParkCarQuery.getPage(), cfCarParkCarQuery.getSize());
        }
        return cfCarParkCarMapper.selectByExample(cfCarParkCarExample);
    }

    @Override
    public List<CfCarParkCar> selectByQuery(CfCarParkCarQuery cfCarParkCarQuery) {
        return cfCarParkCarMapper.selectByQuery(cfCarParkCarQuery);
    }

    public CfCarParkCar handleCfCarParkCarDefaultValue(CfCarParkCar cfCarParkCar)
    {
        if(StringUtils.isEmpty(cfCarParkCar.getImage())){
            cfCarParkCar.setImage("");
        }
        if(StringUtils.isEmpty(cfCarParkCar.getBrand())){
            cfCarParkCar.setBrand("");
        }
        if(StringUtils.isEmpty(cfCarParkCar.getModel())){
            cfCarParkCar.setModel("");
        }
        if(StringUtils.isEmpty(cfCarParkCar.getUid())){
            cfCarParkCar.setUid("");
        }
        if(cfCarParkCar.getPurchaseTime()==null){
            cfCarParkCar.setPurchaseTime(0L);
        }
        if(cfCarParkCar.getPrice()==null){
            cfCarParkCar.setPrice(new BigDecimal("0.00"));
        }
        if(StringUtils.isEmpty(cfCarParkCar.getIdentityNumber())){
            cfCarParkCar.setIdentityNumber("");
        }
        if(StringUtils.isEmpty(cfCarParkCar.getIdentityImage())){
            cfCarParkCar.setIdentityImage("");
        }
        return cfCarParkCar;
    }

    @Override
    public CfCarParkCarExample getExampleByQuery(CfCarParkCarQuery cfCarParkCarQuery) {
        CfCarParkCarExample cfCarParkCarExample = new CfCarParkCarExample();
        CfCarParkCarExample.Criteria criteria = cfCarParkCarExample.createCriteria();
        if(cfCarParkCarQuery.getId()!=null){
            criteria.andIdEqualTo(cfCarParkCarQuery.getId());
        }
        if(cfCarParkCarQuery.getUid()!=null){
            criteria.andUidEqualTo(cfCarParkCarQuery.getUid());
        }
        if(cfCarParkCarQuery.getNumberPlate()!=null){
            criteria.andNumberPlateEqualTo(cfCarParkCarQuery.getNumberPlate());
        }
        if(cfCarParkCarQuery.getStatus()!=null){
            criteria.andStatusEqualTo(cfCarParkCarQuery.getStatus());
        }
        if(StringUtils.isNotEmpty(cfCarParkCarQuery.getOrderBy())){
            cfCarParkCarExample.setOrderByClause(cfCarParkCarQuery.getOrderBy());
        }
        if(cfCarParkCarQuery.getPage()!=null && cfCarParkCarQuery.getSize()!=null){
            PageHelper.startPage(cfCarParkCarQuery.getPage(), cfCarParkCarQuery.getSize());
        }
        return cfCarParkCarExample;
    }

    @Override
    public List<CfCarParkCar> mapperSelectByQuery(CfCarParkCarQuery cfCarParkCarQuery) {
        return cfCarParkCarMapper.selectByExample(getExampleByQuery(cfCarParkCarQuery));
    }

    @Override
    public Integer countByQuery(CfCarParkCarQuery cfCarParkCarQuery) {
        cfCarParkCarQuery.setPage(null);
        return cfCarParkCarMapper.countByExample(getExampleByQuery(cfCarParkCarQuery));
    }
}
