package com.cf.carpark.service.impl;

import com.cf.carpark.dao.mapper.CfCarParkPaymentAgencyMapper;
import com.cf.carpark.domain.CfCarParkLinkUser;
import com.cf.carpark.domain.CfCarParkPaymentAgency;
import com.cf.carpark.domain.CfCarParkPaymentAgencyExample;
import com.cf.carpark.domain.request.CfCarParkLinkUserQuery;
import com.cf.carpark.domain.request.CfCarParkPaymentAgencyQuery;
import com.cf.carpark.service.CfCarParkPaymentAgencyService;
import com.cf.framework.domain.pay.PayCode;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.IdWorker;
import com.cf.pay.domain.CfUserPaymentAgency;
import com.cf.pay.service.CfUserPaymentAgencyService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 停车场与支付机构关联管理服务
 *
 * @ClassName CfCarParkPaymentAgencyServiceImpl
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/10/010 10:03
 * @Version 1.0
 **/
@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfCarParkPaymentAgencyServiceImpl implements CfCarParkPaymentAgencyService {

    @Autowired
    CfCarParkPaymentAgencyMapper cfCarParkPaymentAgencyMapper;
    @Autowired
    private IdWorker idWorker;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfUserPaymentAgencyService cfUserPaymentAgencyService;

    @Override
    public CfCarParkPaymentAgency findByCarParkIdAndUserPaymentAgencyId(String carParkId, String userPaymentAgencyId) {
        CfCarParkPaymentAgencyExample cfCarParkPaymentAgencyExample = new CfCarParkPaymentAgencyExample();
        CfCarParkPaymentAgencyExample.Criteria criteria = cfCarParkPaymentAgencyExample.createCriteria();
        CfCarParkPaymentAgencyExample.Criteria criteria1 = criteria.andCarParkIdEqualTo(carParkId).andUserPaymentAgencyEqualTo(userPaymentAgencyId);
        List<CfCarParkPaymentAgency> cfCarParkPaymentAgencies = cfCarParkPaymentAgencyMapper.selectByExample(cfCarParkPaymentAgencyExample);
        if(cfCarParkPaymentAgencies==null || cfCarParkPaymentAgencies.size()==0){
            ExceptionCast.cast(PayCode.NO_PARKING_PAYMENT_CONFIGURATION_FOUND);
        }
        return cfCarParkPaymentAgencies.get(0);
    }

    @Override
    public CfCarParkPaymentAgency add(CfCarParkPaymentAgency cfCarParkPaymentAgency) {
        checkRepeatData(cfCarParkPaymentAgency);
        cfCarParkPaymentAgency.setId(idWorker.nextId());
        cfCarParkPaymentAgencyMapper.insert(cfCarParkPaymentAgency);
        return cfCarParkPaymentAgency;
    }

    @Override
    public CfCarParkPaymentAgency update(CfCarParkPaymentAgency cfCarParkPaymentAgency) {
        checkRepeatData(cfCarParkPaymentAgency);
        cfCarParkPaymentAgencyMapper.updateByPrimaryKey(cfCarParkPaymentAgency);
        return cfCarParkPaymentAgency;
    }

    @Override
    public Integer delete(String id) {
        return cfCarParkPaymentAgencyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteByQuery(CfCarParkPaymentAgencyQuery cfCarParkPaymentAgencyQuery) {
        return cfCarParkPaymentAgencyMapper.deleteByExample(getExampleByQuery(cfCarParkPaymentAgencyQuery));
    }

    @Override
    public CfCarParkPaymentAgencyExample getExampleByQuery(CfCarParkPaymentAgencyQuery cfCarParkPaymentAgencyQuery) {
        CfCarParkPaymentAgencyExample cfCarParkPaymentAgencyExample = new CfCarParkPaymentAgencyExample();
        CfCarParkPaymentAgencyExample.Criteria criteria = cfCarParkPaymentAgencyExample.createCriteria();
        if(StringUtils.isNotEmpty(cfCarParkPaymentAgencyQuery.getCarParkId())){
            criteria.andCarParkIdEqualTo(cfCarParkPaymentAgencyQuery.getCarParkId());
        }
        if(cfCarParkPaymentAgencyQuery.getCarParkIdList()!=null && cfCarParkPaymentAgencyQuery.getCarParkIdList().size()>0){
            criteria.andCarParkIdIn(cfCarParkPaymentAgencyQuery.getCarParkIdList());
        }
        if(StringUtils.isNotEmpty(cfCarParkPaymentAgencyQuery.getUserPaymentAgency())){
            criteria.andUserPaymentAgencyEqualTo(cfCarParkPaymentAgencyQuery.getUserPaymentAgency());
        }
        if(StringUtils.isNotEmpty(cfCarParkPaymentAgencyQuery.getOrderBy())){
            cfCarParkPaymentAgencyExample.setOrderByClause(cfCarParkPaymentAgencyQuery.getOrderBy());
        }
        if(cfCarParkPaymentAgencyQuery.getPage()!=null && cfCarParkPaymentAgencyQuery.getSize()!=null){
            PageHelper.startPage(cfCarParkPaymentAgencyQuery.getPage(), cfCarParkPaymentAgencyQuery.getSize());
        }
        return cfCarParkPaymentAgencyExample;
    }

    @Override
    public List<CfCarParkPaymentAgency> getListByQuery(CfCarParkPaymentAgencyQuery cfCarParkPaymentAgencyQuery) {
        return cfCarParkPaymentAgencyMapper.selectByExample(getExampleByQuery(cfCarParkPaymentAgencyQuery));
    }

    @Override
    public Integer countByQuery(CfCarParkPaymentAgencyQuery cfCarParkPaymentAgencyQuery) {
        cfCarParkPaymentAgencyQuery.setPage(null);
        return cfCarParkPaymentAgencyMapper.countByExample(getExampleByQuery(cfCarParkPaymentAgencyQuery));
    }

    @Override
    public CfCarParkPaymentAgency findById(String id) {
        return cfCarParkPaymentAgencyMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfCarParkPaymentAgency findById(String id, boolean expectEmpty) {
        CfCarParkPaymentAgency cfCarParkPaymentAgency = findById(id);
        if(expectEmpty && cfCarParkPaymentAgency!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }
        if(!expectEmpty && cfCarParkPaymentAgency==null){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        return cfCarParkPaymentAgency;
    }

    @Override
    public List<CfCarParkPaymentAgency> selectByQuery(CfCarParkPaymentAgencyQuery cfCarParkPaymentAgencyQuery) {
        return cfCarParkPaymentAgencyMapper.selectByQuery(cfCarParkPaymentAgencyQuery);
    }

    @Override
    public CfUserPaymentAgency getUserPaymentAgencyByCarParkIdAndShortName(String carParkId, String paymentAgency) {
        List<CfUserPaymentAgency> cfUserPaymentAgencies = cfUserPaymentAgencyService.selectListByCarParkIdAndPaymentAgencyShortName(carParkId, paymentAgency);
        if(cfUserPaymentAgencies==null || cfUserPaymentAgencies.size()==0){
            ExceptionCast.cast(PayCode.PAYMENT_INSTITUTION_DOES_NOT_EXIST);
        }
        return cfUserPaymentAgencies.get(0);
    }

    @Override
    public void checkRepeatData(CfCarParkPaymentAgency cfCarParkPaymentAgency) {
        CfCarParkPaymentAgencyQuery cfCarParkPaymentAgencyQuery = new CfCarParkPaymentAgencyQuery();
        cfCarParkPaymentAgencyQuery.setUserPaymentAgency(cfCarParkPaymentAgency.getUserPaymentAgency());
        cfCarParkPaymentAgencyQuery.setCarParkId(cfCarParkPaymentAgency.getCarParkId());
        cfCarParkPaymentAgencyQuery.setPage(1);
        cfCarParkPaymentAgencyQuery.setSize(1);
        List<CfCarParkPaymentAgency> cfCarParkPaymentAgencies = getListByQuery(cfCarParkPaymentAgencyQuery);
        if(cfCarParkPaymentAgencies!=null && cfCarParkPaymentAgencies.size()>0){
            if((StringUtils.isNotEmpty(cfCarParkPaymentAgency.getId()) && !cfCarParkPaymentAgencies.get(0).getId().equals(cfCarParkPaymentAgency.getId())) || StringUtils.isEmpty(cfCarParkPaymentAgency.getId())){
                ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
            }
        }
    }
}
