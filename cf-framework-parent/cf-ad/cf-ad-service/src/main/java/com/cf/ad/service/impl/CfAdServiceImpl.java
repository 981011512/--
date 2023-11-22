package com.cf.ad.service.impl;

import com.cf.ad.dao.mapper.CfAdLinksMapper;
import com.cf.ad.dao.mapper.CfAdMapper;
import com.cf.ad.domain.CfAd;
import com.cf.ad.domain.CfAdExample;
import com.cf.ad.domain.request.AdCounts;
import com.cf.ad.domain.request.CfAdQuery;
import com.cf.ad.service.CfAdService;
import com.cf.framework.utils.IdWorker;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfAdServiceImpl implements CfAdService {

    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CfAdMapper cfAdMapper;
    @Autowired
    private CfAdLinksMapper cfAdLinksMapper;

    @Override
    public CfAd add(CfAd cfAd) {
        cfAd.setId(idWorker.nextId());
        cfAd.setCreateTime(System.currentTimeMillis());
        cfAdMapper.insertSelective(cfAd);
        return cfAd;
    }

    @Override
    public CfAd update(CfAd cfAd) {
        cfAdMapper.updateByPrimaryKeySelective(cfAd);
        return cfAd;
    }

    @Override
    public Integer updateByQuery(CfAd cfAd, CfAdQuery cfAdQuery) {
        return cfAdMapper.updateByExampleSelective(cfAd, getExampleByQuery(cfAdQuery));
    }

    @Override
    public Integer delete(String id) {
        return null;
    }

    @Override
    public CfAdExample getExampleByQuery(CfAdQuery cfAdQuery) {
        CfAdExample cfAdExample = new CfAdExample();
        CfAdExample.Criteria criteria = cfAdExample.createCriteria();
        if(cfAdQuery.getId()!=null){
            criteria.andIdEqualTo(cfAdQuery.getId());
        }
        if(cfAdQuery.getMaterialType()!=null){
            criteria.andMaterialTypeEqualTo(cfAdQuery.getMaterialType());
        }
        if(cfAdQuery.getMinStartTime()!=null){
            criteria.andStartTimeGreaterThanOrEqualTo(cfAdQuery.getMinStartTime());
        }
        if(cfAdQuery.getMaxStartTime()!=null){
            criteria.andStartTimeLessThanOrEqualTo(cfAdQuery.getMaxStartTime());
        }
        if(cfAdQuery.getMinEndTime()!=null){
            criteria.andEndTimeGreaterThanOrEqualTo(cfAdQuery.getMinEndTime());
        }
        if(cfAdQuery.getMaxEndTime()!=null){
            criteria.andEndTimeLessThanOrEqualTo(cfAdQuery.getMaxEndTime());
        }
        if(StringUtils.isNotEmpty(cfAdQuery.getOrderBy())){
            cfAdExample.setOrderByClause(cfAdQuery.getOrderBy());
        }
        if(cfAdQuery.getPage()!=null && cfAdQuery.getSize()!=null){
            PageHelper.startPage(cfAdQuery.getPage(), cfAdQuery.getSize());
        }
        return cfAdExample;
    }

    @Override
    public List<CfAd> getListByQuery(CfAdQuery cfAdQuery) {
        return cfAdMapper.selectByExample(getExampleByQuery(cfAdQuery));
    }

    @Override
    public Integer countByQuery(CfAdQuery cfAdQuery) {
        cfAdQuery.setPage(null);
        return cfAdMapper.countByExample(getExampleByQuery(cfAdQuery));
    }

    @Override
    public Integer adCounts(AdCounts adCounts) {
        return cfAdLinksMapper.adCounts(adCounts);
    }
}
