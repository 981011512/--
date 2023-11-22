package com.cf.ucenter.service.impl;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.IdWorker;
import com.cf.ucenter.dao.mapper.CfThirdPartySystemCallKeysMapper;
import com.cf.ucenter.domain.CfThirdPartySystemCallKeys;
import com.cf.ucenter.domain.CfThirdPartySystemCallKeysExample;
import com.cf.ucenter.request.CfThirdPartySystemCallKeysQuery;
import com.cf.ucenter.service.CfThirdPartySystemCallKeysService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfThirdPartySystemCallKeysServiceImpl implements CfThirdPartySystemCallKeysService {

    @Autowired
    private CfThirdPartySystemCallKeysMapper cfThirdPartySystemCallKeysMapper;
    @Autowired
    private IdWorker idWorker;


    @Override
    public CfThirdPartySystemCallKeys add(CfThirdPartySystemCallKeys cfThirdPartySystemCallKeys) {
        if(cfThirdPartySystemCallKeys.getKeyId()==null){
            cfThirdPartySystemCallKeys.setKeyId(idWorker.nextLongId());
        }
        cfThirdPartySystemCallKeysMapper.insertSelective(cfThirdPartySystemCallKeys);
        return cfThirdPartySystemCallKeys;
    }

    @Override
    public CfThirdPartySystemCallKeys update(CfThirdPartySystemCallKeys cfThirdPartySystemCallKeys) {
        cfThirdPartySystemCallKeysMapper.updateByPrimaryKeySelective(cfThirdPartySystemCallKeys);
        return cfThirdPartySystemCallKeys;
    }

    @Override
    public Integer delete(Long id) {
        return cfThirdPartySystemCallKeysMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CfThirdPartySystemCallKeys findById(Long id) {
        return cfThirdPartySystemCallKeysMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfThirdPartySystemCallKeys findById(Long id, boolean expectEmpty) {
        CfThirdPartySystemCallKeys cfThirdPartySystemCallKeys = findById(id);
        if(expectEmpty && cfThirdPartySystemCallKeys!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }
        if(!expectEmpty && cfThirdPartySystemCallKeys==null){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        return cfThirdPartySystemCallKeys;
    }

    @Override
    public List<CfThirdPartySystemCallKeys> getListByQuery(CfThirdPartySystemCallKeysQuery cfThirdPartySystemCallKeysQuery) {
        return cfThirdPartySystemCallKeysMapper.selectByExample(getExampleByQuery(cfThirdPartySystemCallKeysQuery));
    }

    @Override
    public Integer countByQuery(CfThirdPartySystemCallKeysQuery cfThirdPartySystemCallKeysQuery) {
        cfThirdPartySystemCallKeysQuery.setPage(null);
        return cfThirdPartySystemCallKeysMapper.countByExample(getExampleByQuery(cfThirdPartySystemCallKeysQuery));
    }

    @Override
    public CfThirdPartySystemCallKeysExample getExampleByQuery(CfThirdPartySystemCallKeysQuery cfThirdPartySystemCallKeysQuery) {
        CfThirdPartySystemCallKeysExample cfThirdPartySystemCallKeysExample = new CfThirdPartySystemCallKeysExample();
        CfThirdPartySystemCallKeysExample.Criteria criteria = cfThirdPartySystemCallKeysExample.createCriteria();

        if(StringUtils.isNotEmpty(cfThirdPartySystemCallKeysQuery.getUseScenes())){
            criteria.andUseScenesEqualTo(cfThirdPartySystemCallKeysQuery.getUseScenes());
        }
        if(StringUtils.isNotEmpty(cfThirdPartySystemCallKeysQuery.getCompanyName())){
            criteria.andCompanyNameLike("%"+cfThirdPartySystemCallKeysQuery.getCompanyName()+"%");
        }

        if(StringUtils.isNotEmpty(cfThirdPartySystemCallKeysQuery.getOrderBy())){
            cfThirdPartySystemCallKeysExample.setOrderByClause(cfThirdPartySystemCallKeysQuery.getOrderBy());
        }
        if(cfThirdPartySystemCallKeysQuery.getPage()!=null && cfThirdPartySystemCallKeysQuery.getSize()!=null){
            PageHelper.startPage(cfThirdPartySystemCallKeysQuery.getPage(), cfThirdPartySystemCallKeysQuery.getSize());
        }
        return cfThirdPartySystemCallKeysExample;
    }
}
