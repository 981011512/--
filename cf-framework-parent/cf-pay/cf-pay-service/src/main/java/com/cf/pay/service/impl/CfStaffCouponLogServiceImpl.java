package com.cf.pay.service.impl;

import com.cf.framework.utils.IdWorker;
import com.cf.pay.dao.mapper.CfStaffCouponLogMapper;
import com.cf.pay.domain.CfStaffCouponLog;
import com.cf.pay.domain.CfStaffCouponLogExample;
import com.cf.pay.domain.request.CfStaffCouponLogQuery;
import com.cf.pay.service.CfStaffCouponLogService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfStaffCouponLogServiceImpl implements CfStaffCouponLogService {

    @Autowired
    private CfStaffCouponLogMapper cfStaffCouponLogMapper;
    @Autowired
    private IdWorker idWorker;


    @Override
    public CfStaffCouponLog add(CfStaffCouponLog cfStaffCouponLog) {
        cfStaffCouponLog.setId(idWorker.nextId());
        cfStaffCouponLog.setCreateTime(System.currentTimeMillis());
        cfStaffCouponLogMapper.insert(cfStaffCouponLog);
        return cfStaffCouponLog;
    }

    @Override
    public CfStaffCouponLog update(CfStaffCouponLog cfStaffCouponLog) {
        cfStaffCouponLogMapper.updateByPrimaryKey(cfStaffCouponLog);
        return cfStaffCouponLog;
    }

    @Override
    public Integer delete(String id) {
        return cfStaffCouponLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CfStaffCouponLogExample getExampleByQuery(CfStaffCouponLogQuery cfStaffCouponLogQuery) {
        CfStaffCouponLogExample cfStaffCouponLogExample = new CfStaffCouponLogExample();
        CfStaffCouponLogExample.Criteria criteria = cfStaffCouponLogExample.createCriteria();
        if(StringUtils.isNotEmpty(cfStaffCouponLogQuery.getCouponId())){
            criteria.andCouponIdEqualTo(cfStaffCouponLogQuery.getCouponId());
        }
        if(StringUtils.isNotEmpty(cfStaffCouponLogQuery.getCouponActivityId())){
            criteria.andCouponActivityIdEqualTo(cfStaffCouponLogQuery.getCouponActivityId());
        }
        if(StringUtils.isNotEmpty(cfStaffCouponLogQuery.getStaffId())){
            criteria.andStaffIdEqualTo(cfStaffCouponLogQuery.getStaffId());
        }
        if(StringUtils.isNotEmpty(cfStaffCouponLogQuery.getToUid())){
            criteria.andToUidEqualTo(cfStaffCouponLogQuery.getToUid());
        }
        if(StringUtils.isNotEmpty(cfStaffCouponLogQuery.getRecipientBody())){
            criteria.andRecipientBodyEqualTo(cfStaffCouponLogQuery.getRecipientBody());
        }
        if(cfStaffCouponLogQuery.getCouponType()!=null){
            criteria.andCouponTypeEqualTo(cfStaffCouponLogQuery.getCouponType());
        }
        if(cfStaffCouponLogQuery.getMinCreateTime()!=null){
            criteria.andCreateTimeGreaterThanOrEqualTo(cfStaffCouponLogQuery.getMinCreateTime());
        }
        if(cfStaffCouponLogQuery.getMaxCreateTime()!=null){
            criteria.andCreateTimeLessThanOrEqualTo(cfStaffCouponLogQuery.getMaxCreateTime());
        }
        if(StringUtils.isNotEmpty(cfStaffCouponLogQuery.getOrderBy())){
            cfStaffCouponLogExample.setOrderByClause(cfStaffCouponLogQuery.getOrderBy());
        }

        if(cfStaffCouponLogQuery.getPage()!=null && cfStaffCouponLogQuery.getSize()!=null){
            PageHelper.startPage(cfStaffCouponLogQuery.getPage(), cfStaffCouponLogQuery.getSize());
        }
        return cfStaffCouponLogExample;
    }

    @Override
    public List<CfStaffCouponLog> getListByQuery(CfStaffCouponLogQuery cfStaffCouponLogQuery) {
        return cfStaffCouponLogMapper.selectByExample(getExampleByQuery(cfStaffCouponLogQuery));
    }

    @Override
    public Integer countByQuery(CfStaffCouponLogQuery cfStaffCouponLogQuery) {
        cfStaffCouponLogQuery.setPage(null);
        return cfStaffCouponLogMapper.countByExample(getExampleByQuery(cfStaffCouponLogQuery));
    }

    @Override
    public List<CfStaffCouponLog> selectByQuery(CfStaffCouponLogQuery cfStaffCouponLogQuery) {
        return cfStaffCouponLogMapper.selectByQuery(cfStaffCouponLogQuery);
    }

    @Override
    public BigDecimal countDenominationByQuery(CfStaffCouponLogQuery cfStaffCouponLogQuery) {
        return cfStaffCouponLogMapper.countDenominationByQuery(cfStaffCouponLogQuery);
    }
}
