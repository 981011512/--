package com.cf.logistics.service.impl;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.IdWorker;
import com.cf.logistics.domain.CfLogisticsStorehouseLinkUser;
import com.cf.logistics.domain.CfLogisticsStorehouseLinkUserExample;
import com.cf.logistics.domain.request.CfLogisticsStorehouseLinkUserQuery;
import com.cf.logistics.service.CfLogisticsStorehouseLinkUserService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfLogisticsStorehouseLinkUserServiceImpl implements CfLogisticsStorehouseLinkUserService {

    @Autowired
    private com.cf.logistics.dao.mapper.CfLogisticsStorehouseLinkUserMapper CfLogisticsStorehouseLinkUserMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public CfLogisticsStorehouseLinkUser add(CfLogisticsStorehouseLinkUser cfLogisticsStorehouseLinkUser) {
        checkRepeat(cfLogisticsStorehouseLinkUser);
        if(cfLogisticsStorehouseLinkUser.getId()==null){
            cfLogisticsStorehouseLinkUser.setId(idWorker.nextLongId());
        }
        CfLogisticsStorehouseLinkUserMapper.insertSelective(cfLogisticsStorehouseLinkUser);
        return cfLogisticsStorehouseLinkUser;
    }

    @Override
    public CfLogisticsStorehouseLinkUser update(CfLogisticsStorehouseLinkUser cfLogisticsStorehouseLinkUser) {
        checkRepeat(cfLogisticsStorehouseLinkUser);
        CfLogisticsStorehouseLinkUserMapper.updateByPrimaryKeySelective(cfLogisticsStorehouseLinkUser);
        return cfLogisticsStorehouseLinkUser;
    }

    @Override
    public int updateByQuery(CfLogisticsStorehouseLinkUser CfLogisticsStorehouseLinkUser, CfLogisticsStorehouseLinkUserQuery cfLogisticsStorehouseLinkUserQuery) {
        return CfLogisticsStorehouseLinkUserMapper.updateByExampleSelective(CfLogisticsStorehouseLinkUser,getExampleByQuery(cfLogisticsStorehouseLinkUserQuery));
    }

    @Override
    public int delete(Long id) {
        return CfLogisticsStorehouseLinkUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CfLogisticsStorehouseLinkUser findById(Long id) {
        return CfLogisticsStorehouseLinkUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfLogisticsStorehouseLinkUser findById(Long id, boolean expectEmpty) {
        CfLogisticsStorehouseLinkUser cfLogisticsStorehouseLinkUser = findById(id);
        if(expectEmpty && cfLogisticsStorehouseLinkUser!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }
        if(!expectEmpty && cfLogisticsStorehouseLinkUser==null){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        return cfLogisticsStorehouseLinkUser;
    }

    @Override
    public List<CfLogisticsStorehouseLinkUser> getListByQuery(CfLogisticsStorehouseLinkUserQuery cfLogisticsStorehouseLinkUserQuery) {
        return CfLogisticsStorehouseLinkUserMapper.selectByExample(getExampleByQuery(cfLogisticsStorehouseLinkUserQuery));
    }

    @Override
    public List<CfLogisticsStorehouseLinkUser> selectListByQuery(CfLogisticsStorehouseLinkUserQuery cfLogisticsStorehouseLinkUserQuery) {
        return CfLogisticsStorehouseLinkUserMapper.selectListByQuery(cfLogisticsStorehouseLinkUserQuery);
    }

    @Override
    public Integer countByQuery(CfLogisticsStorehouseLinkUserQuery cfLogisticsStorehouseLinkUserQuery) {
        cfLogisticsStorehouseLinkUserQuery.setPage(null);
        cfLogisticsStorehouseLinkUserQuery.setOrderBy(null);
        return CfLogisticsStorehouseLinkUserMapper.countByExample(getExampleByQuery(cfLogisticsStorehouseLinkUserQuery));
    }

    @Override
    public CfLogisticsStorehouseLinkUserExample getExampleByQuery(CfLogisticsStorehouseLinkUserQuery cfLogisticsStorehouseLinkUserQuery) {
        CfLogisticsStorehouseLinkUserExample cfLogisticsStorehouseLinkUserExample = new CfLogisticsStorehouseLinkUserExample();
        CfLogisticsStorehouseLinkUserExample.Criteria criteria = cfLogisticsStorehouseLinkUserExample.createCriteria();

        if(cfLogisticsStorehouseLinkUserQuery.getNid()!=null){
            criteria.andIdNotEqualTo(cfLogisticsStorehouseLinkUserQuery.getNid());
        }
        if(cfLogisticsStorehouseLinkUserQuery.getLogisticsStorehouseId()!=null){
            criteria.andLogisticsStorehouseIdEqualTo(cfLogisticsStorehouseLinkUserQuery.getLogisticsStorehouseId());
        }
        if(cfLogisticsStorehouseLinkUserQuery.getUid()!=null){
            criteria.andUidEqualTo(cfLogisticsStorehouseLinkUserQuery.getUid());
        }

        if(StringUtils.isNotEmpty(cfLogisticsStorehouseLinkUserQuery.getOrderBy())){
            cfLogisticsStorehouseLinkUserExample.setOrderByClause(cfLogisticsStorehouseLinkUserQuery.getOrderBy());
        }
        if(cfLogisticsStorehouseLinkUserQuery.getPage()!=null && cfLogisticsStorehouseLinkUserQuery.getSize()!=null){
            PageHelper.startPage(cfLogisticsStorehouseLinkUserQuery.getPage(), cfLogisticsStorehouseLinkUserQuery.getSize());
        }
        return cfLogisticsStorehouseLinkUserExample;
    }

    @Override
    public void checkRepeat(CfLogisticsStorehouseLinkUser cfLogisticsStorehouseLinkUser) {
        CfLogisticsStorehouseLinkUserQuery cfLogisticsStorehouseLinkUserQuery = new CfLogisticsStorehouseLinkUserQuery();
        cfLogisticsStorehouseLinkUserQuery.setNid(cfLogisticsStorehouseLinkUser.getId());
        cfLogisticsStorehouseLinkUserQuery.setUid(cfLogisticsStorehouseLinkUser.getUid());
        cfLogisticsStorehouseLinkUserQuery.setLogisticsStorehouseId(cfLogisticsStorehouseLinkUser.getLogisticsStorehouseId());
        Integer integer = countByQuery(cfLogisticsStorehouseLinkUserQuery);
        if(integer.intValue()>0){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }
    }
}
