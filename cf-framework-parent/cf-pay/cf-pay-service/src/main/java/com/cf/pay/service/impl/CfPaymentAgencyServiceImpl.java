package com.cf.pay.service.impl;

import com.cf.framework.domain.pay.PayCode;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.DbUtils;
import com.cf.framework.utils.IdWorker;
import com.cf.pay.dao.mapper.CfPaymentAgencyMapper;
import com.cf.pay.domain.CfPaymentAgency;
import com.cf.pay.domain.CfPaymentAgencyExample;
import com.cf.pay.domain.request.CfPaymentAgencyQuery;
import com.cf.pay.domain.request.CfUserPaymentAgencyQuery;
import com.cf.pay.service.CfPaymentAgencyService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 支付结构管理服务
 *
 * @ClassName CfPaymentAgencyServiceImpl
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/7/007 15:43
 * @Version 1.0
 **/
@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfPaymentAgencyServiceImpl implements CfPaymentAgencyService {

    @Autowired
    private CfPaymentAgencyMapper cfPaymentAgencyMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public List<CfPaymentAgency> findByShortName(String shortName) {
        CfPaymentAgencyExample cfPaymentAgencyExample = new CfPaymentAgencyExample();
        CfPaymentAgencyExample.Criteria criteria = cfPaymentAgencyExample.createCriteria();
        criteria.andShortNameEqualTo(shortName);
        return cfPaymentAgencyMapper.selectByExample(cfPaymentAgencyExample);
    }

    @Override
    public CfPaymentAgency findByShortName(String shortName, Boolean expectEmpty) {
        List<CfPaymentAgency> cfPaymentAgencies = findByShortName(shortName);
        if(expectEmpty && cfPaymentAgencies!=null && cfPaymentAgencies.size()>0){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }else if(!expectEmpty && (cfPaymentAgencies==null || cfPaymentAgencies.size()==0)){
            ExceptionCast.cast(PayCode.PAYMENT_INSTITUTION_DOES_NOT_EXIST);
        }
        return cfPaymentAgencies.get(0);
    }

    @Override
    public List<CfPaymentAgency> getPaymentAgencyListByCarParkId(String carParkId, String useScenes) {
        return cfPaymentAgencyMapper.getPaymentAgencyListByCarParkId(carParkId, useScenes);
    }

    @Override
    public CfPaymentAgencyExample getExampleByQuery(CfPaymentAgencyQuery cfPaymentAgencyQuery) {
        CfPaymentAgencyExample cfPaymentAgencyExample = new CfPaymentAgencyExample();
        CfPaymentAgencyExample.Criteria criteria = cfPaymentAgencyExample.createCriteria();
        if(StringUtils.isNotEmpty(cfPaymentAgencyQuery.getName())){
            criteria.andNameLike(cfPaymentAgencyQuery.getName());
        }
        if(StringUtils.isNotEmpty(cfPaymentAgencyQuery.getShortName())){
            criteria.andShortNameEqualTo(cfPaymentAgencyQuery.getShortName());
        }
        if(StringUtils.isNotEmpty(cfPaymentAgencyQuery.getScoreType())){
            criteria.andScoreTypeEqualTo(cfPaymentAgencyQuery.getScoreType());
        }
        if(StringUtils.isNotEmpty(cfPaymentAgencyQuery.getOrderBy())){
            cfPaymentAgencyExample.setOrderByClause(cfPaymentAgencyQuery.getOrderBy());
        }
        if(cfPaymentAgencyQuery.getPage()!=null && cfPaymentAgencyQuery.getSize()!=null){
            PageHelper.startPage(cfPaymentAgencyQuery.getPage(), cfPaymentAgencyQuery.getSize());
        }
        return cfPaymentAgencyExample;
    }

    @Override
    public List<CfPaymentAgency> getListByQuery(CfPaymentAgencyQuery cfPaymentAgencyQuery) {
        return cfPaymentAgencyMapper.selectByExample(getExampleByQuery(cfPaymentAgencyQuery));
    }

    @Override
    public CfPaymentAgency add(CfPaymentAgency cfPaymentAgency) {
        cfPaymentAgency.setId(idWorker.nextId());
        cfPaymentAgencyMapper.insert(cfPaymentAgency);
        return cfPaymentAgency;
    }

    @Override
    public CfPaymentAgency update(CfPaymentAgency cfPaymentAgency) {
        cfPaymentAgencyMapper.updateByPrimaryKey(cfPaymentAgency);
        return cfPaymentAgency;
    }

    @Override
    public Integer delete(String id) {
        return cfPaymentAgencyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<CfPaymentAgency> selectListByCondition(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds) {
        String sql = "SELECT pmt.* FROM cf_payment_agency pmt";
        sql = DbUtils.makeQuery(conditions, allowFiledsMap, allowFileds, sql, false);
        return cfPaymentAgencyMapper.selectListByCondition(sql);
    }

    @Override
    public Integer selectListByConditionCounts(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds) {
        String sql = "SELECT count(*) FROM cf_payment_agency pmt";
        conditions.remove("group");
        sql = DbUtils.makeQuery(conditions, allowFiledsMap, allowFileds, sql, false);
        return cfPaymentAgencyMapper.selectListByConditionCounts(sql);
    }
}
