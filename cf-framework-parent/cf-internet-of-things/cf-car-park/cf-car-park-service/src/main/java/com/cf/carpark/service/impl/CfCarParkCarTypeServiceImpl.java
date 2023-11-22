package com.cf.carpark.service.impl;

import com.cf.carpark.dao.mapper.CfCarParkCarTypeMapper;
import com.cf.carpark.domain.CfCarParkCarType;
import com.cf.carpark.domain.CfCarParkCarTypeExample;
import com.cf.carpark.domain.request.CfCarParkCarTypeQuery;
import com.cf.carpark.service.CfCarParkCarTypeService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.IdWorker;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 停车场车牌类型(套餐类型)
 *
 * @ClassName CfCarParkCarTypeServiceImpl
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/23/023 21:49
 * @Version 1.0
 **/
@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfCarParkCarTypeServiceImpl implements CfCarParkCarTypeService {

    @Autowired
    private CfCarParkCarTypeMapper cfCarParkCarTypeMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public List<CfCarParkCarType> getAllList() {
        CfCarParkCarTypeExample cfCarParkCarTypeExample = new CfCarParkCarTypeExample();
        cfCarParkCarTypeExample.setOrderByClause("sort_index ASC");
        return cfCarParkCarTypeMapper.selectByExample(cfCarParkCarTypeExample);
    }

    @Override
    public CfCarParkCarType add(CfCarParkCarType cfCarParkCarType) {
        cfCarParkCarType.setId(idWorker.nextId());
        cfCarParkCarTypeMapper.insert(cfCarParkCarType);
        return cfCarParkCarType;
    }

    @Override
    public CfCarParkCarType update(CfCarParkCarType cfCarParkCarType) {
        cfCarParkCarTypeMapper.updateByPrimaryKey(cfCarParkCarType);
        return cfCarParkCarType;
    }

    @Override
    public Integer delete(String id) {
        return cfCarParkCarTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CfCarParkCarType findById(String id) {
        return cfCarParkCarTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfCarParkCarType findById(String id, boolean expectEmpty) {
        CfCarParkCarType cfCarParkCarType = findById(id);
        if(expectEmpty && cfCarParkCarType!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }else if(!expectEmpty && cfCarParkCarType==null){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        return cfCarParkCarType;
    }

    @Override
    public CfCarParkCarType findByKey(String key) {
        CfCarParkCarTypeExample cfCarParkCarTypeExample = new CfCarParkCarTypeExample();
        cfCarParkCarTypeExample.createCriteria().andFlagKeyEqualTo(key);
        List<CfCarParkCarType> cfCarParkCarTypes = cfCarParkCarTypeMapper.selectByExample(cfCarParkCarTypeExample);
        if(cfCarParkCarTypes!=null && cfCarParkCarTypes.size()>0){
            return cfCarParkCarTypes.get(0);
        }
        return null;
    }

    @Override
    public CfCarParkCarType findByKey(String key, boolean expectEmpty) {
        CfCarParkCarTypeExample cfCarParkCarTypeExample = new CfCarParkCarTypeExample();
        cfCarParkCarTypeExample.createCriteria().andFlagKeyEqualTo(key);
        List<CfCarParkCarType> cfCarParkCarTypes = cfCarParkCarTypeMapper.selectByExample(cfCarParkCarTypeExample);

        if(expectEmpty && cfCarParkCarTypes!=null && cfCarParkCarTypes.size()>0){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }else if(!expectEmpty && (cfCarParkCarTypes==null || cfCarParkCarTypes.size()==0)){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        return cfCarParkCarTypes.get(0);
    }

    @Override
    public CfCarParkCarTypeExample getExampleByQuery(CfCarParkCarTypeQuery cfCarParkCarTypeQuery) {
        CfCarParkCarTypeExample cfCarParkCarTypeExample = new CfCarParkCarTypeExample();
        CfCarParkCarTypeExample.Criteria criteria = cfCarParkCarTypeExample.createCriteria();
        if(cfCarParkCarTypeQuery.getName()!=null){
            criteria.andNameLike(cfCarParkCarTypeQuery.getName());
        }
        if(cfCarParkCarTypeQuery.getFlagKey()!=null){
            criteria.andFlagKeyEqualTo(cfCarParkCarTypeQuery.getFlagKey());
        }

        if(StringUtils.isNotEmpty(cfCarParkCarTypeQuery.getOrderBy())){
            cfCarParkCarTypeExample.setOrderByClause(cfCarParkCarTypeQuery.getOrderBy());
        }
        if(cfCarParkCarTypeQuery.getPage()!=null && cfCarParkCarTypeQuery.getSize()!=null){
            PageHelper.startPage(cfCarParkCarTypeQuery.getPage(), cfCarParkCarTypeQuery.getSize());
        }

        return cfCarParkCarTypeExample;
    }

    @Override
    public List<CfCarParkCarType> getListByQuery(CfCarParkCarTypeQuery cfCarParkCarTypeQuery) {
        cfCarParkCarTypeQuery.setPage(null);
        return cfCarParkCarTypeMapper.selectByExample(getExampleByQuery(cfCarParkCarTypeQuery));
    }

    @Override
    public Integer countByQuery(CfCarParkCarTypeQuery cfCarParkCarTypeQuery) {
        cfCarParkCarTypeQuery.setPage(null);
        return cfCarParkCarTypeMapper.countByExample(getExampleByQuery(cfCarParkCarTypeQuery));
    }
}
