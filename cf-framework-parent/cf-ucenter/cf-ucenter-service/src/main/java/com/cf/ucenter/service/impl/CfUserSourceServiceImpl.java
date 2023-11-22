package com.cf.ucenter.service.impl;

import com.cf.framework.utils.IdWorker;
import com.cf.ucenter.dao.mapper.CfUserSourceMapper;
import com.cf.ucenter.domain.CfUserSource;
import com.cf.ucenter.domain.CfUserSourceExample;
import com.cf.ucenter.request.CfUserSourceQuery;
import com.cf.ucenter.service.CfUserSourceService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfUserSourceServiceImpl implements CfUserSourceService {

    @Autowired
    private CfUserSourceMapper cfUserSourceMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public List<CfUserSource> add(String sourceId, String sourceType, Map<String, Map<String, Byte>> uidAndAuth, String createrId) {
        ArrayList<CfUserSource> cfUserSources = new ArrayList<>();
        for (Map.Entry<String, Map<String, Byte>> entry: uidAndAuth.entrySet()){
            CfUserSource cfUserSource = new CfUserSource();
            cfUserSource.setId(idWorker.nextId());
            cfUserSource.setSourceId(sourceId);
            cfUserSource.setSourceType(sourceType);
            cfUserSource.setUid(entry.getKey());
            cfUserSource.setAllowEdit(entry.getValue().get("allow_edit"));
            cfUserSource.setAllowDelete(entry.getValue().get("allow_delete"));
            cfUserSource.setCreaterId(createrId);
            cfUserSources.add(cfUserSource);
        }
        if(cfUserSources.size()>0){
            int batchInsert = cfUserSourceMapper.batchInsert(cfUserSources);
            if(batchInsert>0){
                return cfUserSources;
            }
        }
        return null;
    }

    @Override
    public Integer delete(String id) {
        return cfUserSourceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer batchDelete(String ids) {

        return null;
    }

    @Override
    public CfUserSource update(CfUserSource cfUserSource) {
        return null;
    }

    @Override
    public CfUserSourceExample getExampleByQuery(CfUserSourceQuery cfUserSourceQuery) {
        CfUserSourceExample cfUserSourceExample = new CfUserSourceExample();
        CfUserSourceExample.Criteria criteria = cfUserSourceExample.createCriteria();

        if(StringUtils.isNotEmpty(cfUserSourceQuery.getSourceId())){
            criteria.andSourceIdEqualTo(cfUserSourceQuery.getSourceId());
        }
        if(StringUtils.isNotEmpty(cfUserSourceQuery.getSourceType())){
            criteria.andSourceTypeEqualTo(cfUserSourceQuery.getSourceType());
        }
        if(StringUtils.isNotEmpty(cfUserSourceQuery.getUid())){
            criteria.andUidEqualTo(cfUserSourceQuery.getUid());
        }
        if(StringUtils.isNotEmpty(cfUserSourceQuery.getCreaterId())){
            criteria.andCreaterIdEqualTo(cfUserSourceQuery.getCreaterId());
        }

        if(StringUtils.isNotEmpty(cfUserSourceQuery.getOrderBy())){
            cfUserSourceExample.setOrderByClause(cfUserSourceQuery.getOrderBy());
        }
        if(cfUserSourceQuery.getPage()!=null && cfUserSourceQuery.getSize()!=null){
            PageHelper.startPage(cfUserSourceQuery.getPage(), cfUserSourceQuery.getSize());
        }
        return cfUserSourceExample;
    }

    @Override
    public List<CfUserSource> getListByQuery(CfUserSourceQuery cfUserSourceQuery) {
        return cfUserSourceMapper.selectByExample(getExampleByQuery(cfUserSourceQuery));
    }

    @Override
    public Integer countByQuery(CfUserSourceQuery cfUserSourceQuery) {
        cfUserSourceQuery.setPage(null);
        return cfUserSourceMapper.countByExample(getExampleByQuery(cfUserSourceQuery));
    }
}
