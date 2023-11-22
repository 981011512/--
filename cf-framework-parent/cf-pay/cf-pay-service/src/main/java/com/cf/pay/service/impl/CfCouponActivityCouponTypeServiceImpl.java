package com.cf.pay.service.impl;

import com.cf.framework.domain.pay.CouponCode;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.IdWorker;
import com.cf.pay.dao.mapper.CfCouponActivityCouponTypeMapper;
import com.cf.pay.domain.CfCouponActivityCouponType;
import com.cf.pay.domain.CfCouponActivityCouponTypeExample;
import com.cf.pay.domain.request.CfCouponActivityCouponTypeQuery;
import com.cf.pay.service.CfCouponActivityCouponTypeService;
import com.cf.pay.service.CfCouponActivityService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfCouponActivityCouponTypeServiceImpl implements CfCouponActivityCouponTypeService {

    @Autowired
    private CfCouponActivityCouponTypeMapper cfCouponActivityCouponTypeMapper;
    @Autowired
    private CfCouponActivityService cfCouponActivityService;
    @Autowired
    private IdWorker idWorker;

    @Override
    public CfCouponActivityCouponType add(CfCouponActivityCouponType cfCouponActivityCouponType) {
        cfCouponActivityCouponType.setId(idWorker.nextId());
        cfCouponActivityCouponTypeMapper.insert(cfCouponActivityCouponType);
        return cfCouponActivityCouponType;
    }

    @Override
    public CfCouponActivityCouponType shopkeeperAddCouponType(String shopkeeperId, CfCouponActivityCouponType cfCouponActivityCouponType) {
        if(cfCouponActivityCouponType.getCouponType()!=(byte)2){
            ExceptionCast.cast(CommonCode.UNAUTHORISE,"该功能您只能操作金额券");
        }
        cfCouponActivityService.checkActivityAscription(shopkeeperId, cfCouponActivityCouponType.getCouponActivityId());
        return add(cfCouponActivityCouponType);
    }

    @Override
    public CfCouponActivityCouponType update(CfCouponActivityCouponType cfCouponActivityCouponType) {
        cfCouponActivityCouponTypeMapper.updateByPrimaryKey(cfCouponActivityCouponType);
        return cfCouponActivityCouponType;
    }

    @Override
    public CfCouponActivityCouponType findById(String id) {
        return cfCouponActivityCouponTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfCouponActivityCouponType findById(String id, boolean expectEmpty) {
        CfCouponActivityCouponType couponActivityCouponType = findById(id);
        if(expectEmpty && couponActivityCouponType!=null){
            ExceptionCast.cast(CouponCode.COUPON_TYPE_EXIST_EXISTED);
        }
        if(!expectEmpty && couponActivityCouponType==null){
            ExceptionCast.cast(CouponCode.COUPON_TYPE_NOT_EXIST);
        }
        return couponActivityCouponType;
    }

    @Override
    public CfCouponActivityCouponType shopkeeperUpdateCouponType(String shopkeeperId, CfCouponActivityCouponType cfCouponActivityCouponType) {
        if(cfCouponActivityCouponType.getCouponType()!=(byte)2){
            ExceptionCast.cast(CommonCode.UNAUTHORISE,"该功能您只能操作金额券");
        }
        cfCouponActivityService.checkActivityAscription(shopkeeperId, cfCouponActivityCouponType.getCouponActivityId());
        return update(cfCouponActivityCouponType);
    }

    @Override
    public Integer delete(String id) {
        return cfCouponActivityCouponTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer shopkeeperDelete(String shopkeeperId, String id) {
        CfCouponActivityCouponType cfCouponActivityCouponType = cfCouponActivityCouponTypeMapper.selectByPrimaryKey(id);
        if(cfCouponActivityCouponType==null || cfCouponActivityCouponType.getId()==null){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        cfCouponActivityService.checkActivityAscription(shopkeeperId, cfCouponActivityCouponType.getCouponActivityId());
        return delete(id);
    }

    @Override
    public CfCouponActivityCouponTypeExample getExampleByQuery(CfCouponActivityCouponTypeQuery cfCouponActivityCouponTypeQuery) {
        CfCouponActivityCouponTypeExample cfCouponActivityCouponTypeExample = new CfCouponActivityCouponTypeExample();
        CfCouponActivityCouponTypeExample.Criteria criteria = cfCouponActivityCouponTypeExample.createCriteria();
        if(StringUtils.isNotEmpty(cfCouponActivityCouponTypeQuery.getCouponActivityId())){
            criteria.andCouponActivityIdEqualTo(cfCouponActivityCouponTypeQuery.getCouponActivityId());
        }
        if(cfCouponActivityCouponTypeQuery.getCouponType()!=null){
            criteria.andCouponTypeEqualTo(cfCouponActivityCouponTypeQuery.getCouponType());
        }
        if(StringUtils.isNotEmpty(cfCouponActivityCouponTypeQuery.getOrderBy())){
            cfCouponActivityCouponTypeExample.setOrderByClause(cfCouponActivityCouponTypeQuery.getOrderBy());
        }
        return cfCouponActivityCouponTypeExample;
    }

    @Override
    public List<CfCouponActivityCouponType> getListByQuery(CfCouponActivityCouponTypeQuery cfCouponActivityCouponTypeQuery) {
        return cfCouponActivityCouponTypeMapper.selectByExample(getExampleByQuery(cfCouponActivityCouponTypeQuery));
    }

    @Override
    public Integer countByQuery(CfCouponActivityCouponTypeQuery cfCouponActivityCouponTypeQuery) {
        return cfCouponActivityCouponTypeMapper.countByExample(getExampleByQuery(cfCouponActivityCouponTypeQuery));
    }
}
