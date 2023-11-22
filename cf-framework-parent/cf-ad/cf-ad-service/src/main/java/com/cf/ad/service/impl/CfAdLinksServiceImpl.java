package com.cf.ad.service.impl;

import com.cf.ad.dao.mapper.CfAdLinksMapper;
import com.cf.ad.dao.mapper.CfAdMapper;
import com.cf.ad.domain.CfAd;
import com.cf.ad.domain.CfAdLinks;
import com.cf.ad.domain.CfAdLinksExample;
import com.cf.ad.domain.request.AdCounts;
import com.cf.ad.domain.request.CfAdLinksQuery;
import com.cf.ad.domain.request.CfAdQuery;
import com.cf.ad.service.CfAdLinksService;
import com.cf.ad.service.CfAdService;
import com.cf.framework.domain.ad.AdCode;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.IdWorker;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfAdLinksServiceImpl implements CfAdLinksService {

    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CfAdLinksMapper cfAdLinksMapper;
    @Autowired
    private CfAdMapper cfAdMapper;
    @Autowired
    private CfAdService cfAdService;

    @Override
    public Integer add(CfAdLinks cfAdLinks) {
        if(cfAdLinks.getCarrierIds()==null || cfAdLinks.getCarrierIds().size()==0 || StringUtils.isEmpty(cfAdLinks.getAdId())){
            return null;
        }
        //先清除掉原来的
        CfAdLinksQuery cfAdLinksQuery = new CfAdLinksQuery();
        cfAdLinksQuery.setAdId(cfAdLinks.getAdId());
        cfAdLinksQuery.setScenes(cfAdLinks.getScenes());
        cfAdLinksQuery.setPlatform(cfAdLinks.getPlatform());
        cfAdLinksQuery.setCarrierIds(cfAdLinks.getCarrierIds());
        deleteByQuery(cfAdLinksQuery);

        ArrayList<CfAdLinks> cfAdLinksArrayList = new ArrayList<>();
        CfAdQuery cfAdQuery = new CfAdQuery();
        cfAdQuery.setId(cfAdLinks.getAdId());
        List<CfAd> cfAdList = cfAdService.getListByQuery(cfAdQuery);
        if(cfAdList==null || cfAdList.size()==0){
            ExceptionCast.cast(AdCode.AD_NOT_EXIST);
        }
        //批量添加
        for (String carrierId: cfAdLinks.getCarrierIds()){
            cfAdLinks.setCarrierId(carrierId);
            cfAdLinks.setPlatform(cfAdList.get(0).getPlatform());
            cfAdLinks.setSortIndex(cfAdList.get(0).getSortIndex());
            cfAdLinks.setStartTime(cfAdList.get(0).getStartTime());
            cfAdLinks.setEndTime(cfAdList.get(0).getEndTime());
            if(cfAdLinks.getCreateTime()==null){
                cfAdLinks.setCreateTime(System.currentTimeMillis());
            }
            if(cfAdLinks.getStartTime()==null){
                cfAdLinks.setStartTime(System.currentTimeMillis());
            }
            if(cfAdLinks.getEndTime()==null){
                cfAdLinks.setEndTime(System.currentTimeMillis());
            }
            if(cfAdLinks.getShowCounts()==null){
                cfAdLinks.setShowCounts(0);
            }
            if(cfAdLinks.getClickCounts()==null){
                cfAdLinks.setClickCounts(0);
            }

            CfAdLinks adLinks = new CfAdLinks();
            BeanUtils.copyProperties(cfAdLinks, adLinks);
            adLinks.setId(idWorker.nextId());
            cfAdLinksArrayList.add(adLinks);
        }
        return cfAdLinksMapper.batchInsert(cfAdLinksArrayList);
    }

    @Override
    public CfAdLinks update(CfAdLinks cfAdLinks) {
        cfAdLinksMapper.updateByPrimaryKeySelective(cfAdLinks);
        return cfAdLinks;
    }

    @Override
    public Integer updateByQuery(CfAdLinks cfAdLinks, CfAdLinksQuery cfAdLinksQuery) {
        return cfAdLinksMapper.updateByExampleSelective(cfAdLinks, getExampleByQuery(cfAdLinksQuery));
    }

    @Override
    public Integer delete(String id) {
        return cfAdLinksMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteByQuery(CfAdLinksQuery cfAdLinksQuery) {
        return cfAdLinksMapper.deleteByExample(getExampleByQuery(cfAdLinksQuery));
    }

    @Override
    public CfAdLinksExample getExampleByQuery(CfAdLinksQuery cfAdLinksQuery) {
        CfAdLinksExample cfAdLinksExample = new CfAdLinksExample();
        CfAdLinksExample.Criteria criteria = cfAdLinksExample.createCriteria();
        if(cfAdLinksQuery.getId()!=null){
            criteria.andIdEqualTo(cfAdLinksQuery.getId());
        }
        if(cfAdLinksQuery.getAdId()!=null){
            criteria.andAdIdEqualTo(cfAdLinksQuery.getAdId());
        }
        if(cfAdLinksQuery.getScenes()!=null){
            criteria.andScenesEqualTo(cfAdLinksQuery.getScenes());
        }
        if(cfAdLinksQuery.getPlatform()!=null){
            criteria.andPlatformEqualTo(cfAdLinksQuery.getPlatform());
        }
        if(cfAdLinksQuery.getCarrierId()!=null){
            criteria.andCarrierIdEqualTo(cfAdLinksQuery.getCarrierId());
        }
        if(cfAdLinksQuery.getCarrierIds()!=null){
            criteria.andCarrierIdIn(cfAdLinksQuery.getCarrierIds());
        }
        if(cfAdLinksQuery.getMinStartTime()!=null){
            criteria.andStartTimeGreaterThanOrEqualTo(cfAdLinksQuery.getMinStartTime());
        }
        if(cfAdLinksQuery.getMaxStartTime()!=null){
            criteria.andStartTimeLessThanOrEqualTo(cfAdLinksQuery.getMaxStartTime());
        }
        if(cfAdLinksQuery.getMinEndTime()!=null){
            criteria.andEndTimeGreaterThanOrEqualTo(cfAdLinksQuery.getMinEndTime());
        }
        if(cfAdLinksQuery.getMaxEndTime()!=null){
            criteria.andEndTimeLessThanOrEqualTo(cfAdLinksQuery.getMaxEndTime());
        }

        if(StringUtils.isNotEmpty(cfAdLinksQuery.getOrderBy())){
            cfAdLinksExample.setOrderByClause(cfAdLinksQuery.getOrderBy());
        }
        if(cfAdLinksQuery.getPage()!=null && cfAdLinksQuery.getSize()!=null){
            PageHelper.startPage(cfAdLinksQuery.getPage(), cfAdLinksQuery.getSize());
        }
        return cfAdLinksExample;
    }

    @Override
    public List<CfAdLinks> getListByQuery(CfAdLinksQuery cfAdLinksQuery) {
        return cfAdLinksMapper.selectByExample(getExampleByQuery(cfAdLinksQuery));
    }

    @Override
    public List<CfAdLinks> selectContainAdByQuery(CfAdLinksQuery cfAdLinksQuery) {
        return cfAdLinksMapper.selectContainAdByQuery(cfAdLinksQuery);
    }

    @Override
    public Integer countByQuery(CfAdLinksQuery cfAdLinksQuery) {
        cfAdLinksQuery.setPage(null);
        return cfAdLinksMapper.countByExample(getExampleByQuery(cfAdLinksQuery));
    }

    @Override
    public Integer adCounts(AdCounts adCounts) {
        if(!adCounts.getField().equals("show_counts") && !adCounts.getField().equals("click_counts")){
            ExceptionCast.cast(CommonCode.INVALID_PARAM, "统计的字段不支持");
        }
        Integer integer = cfAdLinksMapper.adCounts(adCounts);
        if(integer>0){
            CfAdLinks cfAdLinks = cfAdLinksMapper.selectByPrimaryKey(adCounts.getId());
            adCounts.setId(cfAdLinks.getAdId());
            return cfAdMapper.adCounts(adCounts);
        }
        return integer;
    }
}
