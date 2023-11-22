package com.cf.pay.service.impl;

import com.cf.framework.domain.pay.PayCode;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.DbUtils;
import com.cf.framework.utils.IdWorker;
import com.cf.pay.dao.mapper.CfUserPaymentAgencyMapper;
import com.cf.pay.domain.CfUserPaymentAgency;
import com.cf.pay.domain.CfUserPaymentAgencyExample;
import com.cf.pay.domain.request.CfUserPaymentAgencyQuery;
import com.cf.pay.service.CfUserPaymentAgencyService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 用户名下的支付账户管理服务
 *
 * @ClassName CfUserPaymentAgencyServiceImpl
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/9/009 20:07
 * @Version 1.0
 **/
@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfUserPaymentAgencyServiceImpl implements CfUserPaymentAgencyService {

    @Autowired
    private CfUserPaymentAgencyMapper cfUserPaymentAgencyMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public CfUserPaymentAgency findById(String id) {
        return cfUserPaymentAgencyMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfUserPaymentAgency findById(String id, Boolean expectEmpty) {
        CfUserPaymentAgency cfUserPaymentAgency = findById(id);
        if(expectEmpty && cfUserPaymentAgency!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }else if(!expectEmpty && cfUserPaymentAgency==null){
            ExceptionCast.cast(PayCode.MERCHANT_PAYMENT_ACCOUNT_DOES_NOT_EXIST);
        }
        return cfUserPaymentAgency;
    }

    @Override
    public CfUserPaymentAgency findByUidAndPaymentAgencyShortName(String uid, String paymentAgencyShortName) {
        CfUserPaymentAgencyExample cfUserPaymentAgencyExample = new CfUserPaymentAgencyExample();
        CfUserPaymentAgencyExample.Criteria criteria = cfUserPaymentAgencyExample.createCriteria();
        criteria.andUidEqualTo(uid).andPaymentAgencyShortNameEqualTo(paymentAgencyShortName);
        List<CfUserPaymentAgency> cfUserPaymentAgencies = cfUserPaymentAgencyMapper.selectByExample(cfUserPaymentAgencyExample);
        if(cfUserPaymentAgencies==null || cfUserPaymentAgencies.size()==0){
            ExceptionCast.cast(PayCode.MERCHANT_PAYMENT_ACCOUNT_DOES_NOT_EXIST);
        }
        return cfUserPaymentAgencies.get(0);
    }

    @Override
    public CfUserPaymentAgencyExample getExampleByQuery(CfUserPaymentAgencyQuery cfUserPaymentAgencyQuery) {
        CfUserPaymentAgencyExample cfUserPaymentAgencyExample = new CfUserPaymentAgencyExample();
        CfUserPaymentAgencyExample.Criteria criteria = cfUserPaymentAgencyExample.createCriteria();
        if(StringUtils.isNotEmpty(cfUserPaymentAgencyQuery.getName())){
            criteria.andNameLike("%"+cfUserPaymentAgencyQuery.getName()+"%");
        }
        if(StringUtils.isNotEmpty(cfUserPaymentAgencyQuery.getPaymentAgencyShortName())){
            criteria.andPaymentAgencyShortNameEqualTo(cfUserPaymentAgencyQuery.getPaymentAgencyShortName());
        }
        if(StringUtils.isNotEmpty(cfUserPaymentAgencyQuery.getUseScenes())){
            criteria.andUseScenesEqualTo(cfUserPaymentAgencyQuery.getUseScenes());
        }
        if(StringUtils.isNotEmpty(cfUserPaymentAgencyQuery.getUid())){
            criteria.andUidEqualTo(cfUserPaymentAgencyQuery.getUid());
        }
        if(StringUtils.isNotEmpty(cfUserPaymentAgencyQuery.getOrderBy())){
            cfUserPaymentAgencyExample.setOrderByClause(cfUserPaymentAgencyQuery.getOrderBy());
        }
        return cfUserPaymentAgencyExample;
    }

    @Override
    public List<CfUserPaymentAgency> getListByQuery(CfUserPaymentAgencyQuery cfUserPaymentAgencyQuery) {
        return cfUserPaymentAgencyMapper.selectByExample(getExampleByQuery(cfUserPaymentAgencyQuery));
    }

    @Override
    public List<CfUserPaymentAgency> selectListByCondition(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds) {
        String sql = "SELECT upm.* FROM cf_user_payment_agency upm";
        sql = DbUtils.makeQuery(conditions, allowFiledsMap, allowFileds, sql, false);
        return cfUserPaymentAgencyMapper.selectListByCondition(sql);
    }

    @Override
    public Integer selectListByConditionCounts(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds) {
        String sql = "SELECT count(*) FROM cf_user_payment_agency upm";
        conditions.remove("group");
        sql = DbUtils.makeQuery(conditions, allowFiledsMap, allowFileds, sql, false);
        return cfUserPaymentAgencyMapper.selectListByConditionCounts(sql);
    }

    @Override
    public CfUserPaymentAgency add(CfUserPaymentAgency cfUserPaymentAgency) {
        cfUserPaymentAgency.setId(idWorker.nextId());
        cfUserPaymentAgencyMapper.insert(cfUserPaymentAgency);
        return cfUserPaymentAgency;
    }

    @Override
    public CfUserPaymentAgency update(CfUserPaymentAgency cfUserPaymentAgency) {
        cfUserPaymentAgencyMapper.updateByPrimaryKeySelective(cfUserPaymentAgency);
        return cfUserPaymentAgency;
    }

    @Override
    public Integer delete(String id) {
        return cfUserPaymentAgencyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<CfUserPaymentAgency> selectListByCarParkIdAndPaymentAgencyShortName(String carParkId, String paymentAgencyShortName) {
        return cfUserPaymentAgencyMapper.selectListByCarParkIdAndPaymentAgencyShortName(carParkId, paymentAgencyShortName);
    }
}
