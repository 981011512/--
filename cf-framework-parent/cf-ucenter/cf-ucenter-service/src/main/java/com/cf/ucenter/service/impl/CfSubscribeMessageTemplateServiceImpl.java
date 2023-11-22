package com.cf.ucenter.service.impl;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.IdWorker;
import com.cf.ucenter.dao.mapper.CfSubscribeMessageTemplateMapper;
import com.cf.ucenter.domain.CfSubscribeMessageTemplate;
import com.cf.ucenter.domain.CfSubscribeMessageTemplateExample;
import com.cf.ucenter.request.CfSubscribeMessageTemplateQuery;
import com.cf.ucenter.service.CfSubscribeMessageTemplateService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfSubscribeMessageTemplateServiceImpl implements CfSubscribeMessageTemplateService {

    @Autowired
    private CfSubscribeMessageTemplateMapper cfSubscribeMessageTemplateMapper;
    @Autowired
    private IdWorker idWorker;


    @Override
    public CfSubscribeMessageTemplate add(CfSubscribeMessageTemplate cfSubscribeMessageTemplate) {
        cfSubscribeMessageTemplate.setId(idWorker.nextLongId());
        cfSubscribeMessageTemplateMapper.insertSelective(cfSubscribeMessageTemplate);
        return cfSubscribeMessageTemplate;
    }

    @Override
    public CfSubscribeMessageTemplate update(CfSubscribeMessageTemplate cfSubscribeMessageTemplate) {
        cfSubscribeMessageTemplateMapper.updateByPrimaryKeySelective(cfSubscribeMessageTemplate);
        return cfSubscribeMessageTemplate;
    }

    @Override
    public Integer delete(Long id) {
        return cfSubscribeMessageTemplateMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CfSubscribeMessageTemplate findById(Long id) {
        return cfSubscribeMessageTemplateMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfSubscribeMessageTemplate findById(Long id, boolean expectEmpty) {
        CfSubscribeMessageTemplate cfSubscribeMessageTemplate = findById(id);
        if(expectEmpty && cfSubscribeMessageTemplate!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }
        if(!expectEmpty && cfSubscribeMessageTemplate==null){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        return cfSubscribeMessageTemplate;
    }

    @Override
    public List<CfSubscribeMessageTemplate> getListByQuery(CfSubscribeMessageTemplateQuery cfSubscribeMessageTemplateQuery) {
        return cfSubscribeMessageTemplateMapper.selectByExample(getExampleByQuery(cfSubscribeMessageTemplateQuery));
    }

    @Override
    public Integer countByQuery(CfSubscribeMessageTemplateQuery cfSubscribeMessageTemplateQuery) {
        cfSubscribeMessageTemplateQuery.setPage(null);
        return cfSubscribeMessageTemplateMapper.countByExample(getExampleByQuery(cfSubscribeMessageTemplateQuery));
    }

    @Override
    public CfSubscribeMessageTemplateExample getExampleByQuery(CfSubscribeMessageTemplateQuery cfSubscribeMessageTemplateQuery) {
        CfSubscribeMessageTemplateExample cfSubscribeMessageTemplateExample = new CfSubscribeMessageTemplateExample();
        CfSubscribeMessageTemplateExample.Criteria criteria = cfSubscribeMessageTemplateExample.createCriteria();
        if(cfSubscribeMessageTemplateQuery.getAppid()!=null){
            criteria.andAppidEqualTo(cfSubscribeMessageTemplateQuery.getAppid());
        }
        if(cfSubscribeMessageTemplateQuery.getMessageScenes()!=null){
            criteria.andMessageScenesEqualTo(cfSubscribeMessageTemplateQuery.getMessageScenes());
        }
        if(StringUtils.isNotEmpty(cfSubscribeMessageTemplateQuery.getOrderBy())){
            cfSubscribeMessageTemplateExample.setOrderByClause(cfSubscribeMessageTemplateQuery.getOrderBy());
        }
        if(cfSubscribeMessageTemplateQuery.getPage()!=null && cfSubscribeMessageTemplateQuery.getSize()!=null){
            PageHelper.startPage(cfSubscribeMessageTemplateQuery.getPage(), cfSubscribeMessageTemplateQuery.getSize());
        }
        return cfSubscribeMessageTemplateExample;
    }
}
