package com.cf.pay.service.impl;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.IdWorker;
import com.cf.pay.dao.mapper.CfStaffCouponSettingMapper;
import com.cf.pay.domain.CfStaffCouponSetting;
import com.cf.pay.domain.CfStaffCouponSettingExample;
import com.cf.pay.domain.request.CfStaffCouponSettingQuery;
import com.cf.pay.service.CfCouponActivityService;
import com.cf.pay.service.CfStaffCouponSettingService;
import com.cf.ucenter.service.CfStaffService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfStaffCouponSettingServiceImpl implements CfStaffCouponSettingService {

    @Autowired
    private CfStaffCouponSettingMapper cfStaffCouponSettingMapper;
    @Autowired
    private IdWorker idWorker;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfStaffService cfStaffService;
    @Autowired
    private CfCouponActivityService cfCouponActivityService;


    @Override
    public CfStaffCouponSetting add(CfStaffCouponSetting cfStaffCouponSetting) {
        //禁止重复录入，如果已经存在，则更新
        CfStaffCouponSettingQuery cfStaffCouponSettingQuery = new CfStaffCouponSettingQuery();
        cfStaffCouponSettingQuery.setCouponActivityId(cfStaffCouponSetting.getCouponActivityId());
        cfStaffCouponSettingQuery.setStaffId(cfStaffCouponSetting.getStaffId());
        List<CfStaffCouponSetting> cfStaffCouponSettings = getListByQuery(cfStaffCouponSettingQuery);
        if(cfStaffCouponSettings!=null && cfStaffCouponSettings.size()>0){
            cfStaffCouponSettings.get(0).setSameDayQuota(cfStaffCouponSetting.getSameDayQuota());
            return update(cfStaffCouponSettings.get(0));
        }
        cfStaffCouponSetting.setId(idWorker.nextId());
        cfStaffCouponSettingMapper.insert(cfStaffCouponSetting);
        return cfStaffCouponSetting;
    }

    @Override
    public Integer batchAdd(List<CfStaffCouponSetting> cfStaffCouponSettingList) {
        return cfStaffCouponSettingMapper.batchAdd(cfStaffCouponSettingList);
    }

    @Override
    public CfStaffCouponSetting employerAddStaffCouponSetting(String employerId, CfStaffCouponSetting cfStaffCouponSetting) {
        //检查正在设置的员工是否属于当前雇主员工
        cfStaffService.checkStaffExistByEmployerIdAndStaffId(employerId, cfStaffCouponSetting.getStaffId(), "no");
        //检查优惠券活动是否存在，以及该活动是否属于当前店主
        cfCouponActivityService.checkActivityAscription(employerId, cfStaffCouponSetting.getCouponActivityId());
        cfStaffCouponSetting.setCouponType(cfStaffCouponSetting.getCouponType());
        return add(cfStaffCouponSetting);
    }

    @Override
    public CfStaffCouponSetting update(CfStaffCouponSetting cfStaffCouponSetting) {
        cfStaffCouponSettingMapper.updateByPrimaryKey(cfStaffCouponSetting);
        return cfStaffCouponSetting;
    }

    @Override
    public CfStaffCouponSetting employerUpdateStaffCouponSetting(String employerId, CfStaffCouponSetting cfStaffCouponSetting) {
        //检查正在设置的员工是否属于当前雇主员工
        cfStaffService.checkStaffExistByEmployerIdAndStaffId(employerId, cfStaffCouponSetting.getStaffId(), "no");
        //检查优惠券活动是否存在，以及该活动是否属于当前店主
        cfCouponActivityService.checkActivityAscription(employerId, cfStaffCouponSetting.getCouponActivityId());
        CfStaffCouponSetting staffCouponSetting = cfStaffCouponSettingMapper.selectByPrimaryKey(cfStaffCouponSetting.getId());
        if(staffCouponSetting==null || staffCouponSetting.getId()==null){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        staffCouponSetting.setSameDayQuota(cfStaffCouponSetting.getSameDayQuota());
        return update(staffCouponSetting);
    }

    @Override
    public Integer delete(String id) {
        return cfStaffCouponSettingMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteByQuery(CfStaffCouponSettingQuery cfStaffCouponSettingQuery) {
        return cfStaffCouponSettingMapper.deleteByExample(getExampleByQuery(cfStaffCouponSettingQuery));
    }

    @Override
    public CfStaffCouponSetting findById(String id) {
        return cfStaffCouponSettingMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfStaffCouponSettingExample getExampleByQuery(CfStaffCouponSettingQuery cfStaffCouponSettingQuery) {
        CfStaffCouponSettingExample cfStaffCouponSettingExample = new CfStaffCouponSettingExample();
        CfStaffCouponSettingExample.Criteria criteria = cfStaffCouponSettingExample.createCriteria();
        if(StringUtils.isNotEmpty(cfStaffCouponSettingQuery.getCouponActivityId())){
            criteria.andCouponActivityIdEqualTo(cfStaffCouponSettingQuery.getCouponActivityId());
        }
        if(cfStaffCouponSettingQuery.getCouponType()!=null){
            criteria.andCouponTypeEqualTo(cfStaffCouponSettingQuery.getCouponType());
        }
        if(cfStaffCouponSettingQuery.getStaffId()!=null){
            criteria.andStaffIdEqualTo(cfStaffCouponSettingQuery.getStaffId());
        }
        if(cfStaffCouponSettingQuery.getCouponActivityId()!=null){
            criteria.andCouponActivityIdEqualTo(cfStaffCouponSettingQuery.getCouponActivityId());
        }
        if(cfStaffCouponSettingQuery.getCouponActivityIds()!=null && cfStaffCouponSettingQuery.getCouponActivityIds().size()>0){
            criteria.andCouponActivityIdIn(cfStaffCouponSettingQuery.getCouponActivityIds());
        }
        return cfStaffCouponSettingExample;
    }

    @Override
    public List<CfStaffCouponSetting> getListByQuery(CfStaffCouponSettingQuery cfStaffCouponSettingQuery) {
        return cfStaffCouponSettingMapper.selectByExample(getExampleByQuery(cfStaffCouponSettingQuery));
    }

    @Override
    public Integer countByQuery(CfStaffCouponSettingQuery cfStaffCouponSettingQuery) {
        return cfStaffCouponSettingMapper.countByExample(getExampleByQuery(cfStaffCouponSettingQuery));
    }
}
