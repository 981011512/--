package com.cf.ucenter.service.impl;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.ucenter.response.StaffCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.IdWorker;
import com.cf.ucenter.dao.mapper.CfRoleMapper;
import com.cf.ucenter.dao.mapper.CfStaffMapper;
import com.cf.ucenter.domain.*;
import com.cf.ucenter.request.CfStaffQuery;
import com.cf.ucenter.service.CfStaffService;
import com.cf.ucenter.service.CfUserRoleService;
import com.cf.ucenter.service.CfUserService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfStaffServiceImpl implements CfStaffService {

    @Autowired
    private CfStaffMapper cfStaffMapper;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CfUserService cfUserService;
    @Autowired
    private CfUserRoleService cfUserRoleService;
    @Autowired
    private CfRoleMapper cfRoleMapper;

    @Override
    public CfStaff add(CfStaff cfStaff) {
        if(cfStaff.getStaffId().equals(cfStaff.getEmployerId())){
            ExceptionCast.cast(StaffCode.CANT_NOT_ADD_YOURSELF);
        }
        //判断是否存在相同的雇主和员工数据，如果存在直接更新
        CfStaff staff = checkStaffExistByEmployerIdAndStaffId(cfStaff.getEmployerId(), cfStaff.getStaffId(), "");
        if(staff!=null){
            staff.setNote(cfStaff.getNote());
            return update(staff);
        }
        cfStaff.setId(idWorker.nextId());
        cfStaff.setCreateTime(System.currentTimeMillis());
        cfStaffMapper.insert(cfStaff);
        return cfStaff;
    }

    @Override
    public CfStaff update(CfStaff cfStaff) {
        if(cfStaff.getStaffId().equals(cfStaff.getEmployerId())){
            ExceptionCast.cast(StaffCode.CANT_NOT_ADD_YOURSELF);
        }
        cfStaffMapper.updateByPrimaryKey(cfStaff);
        return cfStaff;
    }

    @Override
    public Integer delete(String id) {
        return cfStaffMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CfStaffExample getExampleByQuery(CfStaffQuery cfStaffQuery) {
        CfStaffExample cfStaffExample = new CfStaffExample();
        CfStaffExample.Criteria criteria = cfStaffExample.createCriteria();
        if(StringUtils.isNotEmpty(cfStaffQuery.getEmployerId())){
            criteria.andEmployerIdEqualTo(cfStaffQuery.getEmployerId());
        }
        if(StringUtils.isNotEmpty(cfStaffQuery.getStaffId())){
            criteria.andStaffIdEqualTo(cfStaffQuery.getStaffId());
        }
        if(cfStaffQuery.getMinCreateTime()!=null){
            criteria.andCreateTimeGreaterThanOrEqualTo(cfStaffQuery.getMinCreateTime());
        }
        if(cfStaffQuery.getMaxCreateTime()!=null){
            criteria.andCreateTimeLessThanOrEqualTo(cfStaffQuery.getMaxCreateTime());
        }

        if(StringUtils.isNotEmpty(cfStaffQuery.getOrderBy())){
            cfStaffExample.setOrderByClause(cfStaffQuery.getOrderBy());
        }
        if(cfStaffQuery.getPage()!=null && cfStaffQuery.getSize()!=null){
            PageHelper.startPage(cfStaffQuery.getPage(), cfStaffQuery.getSize());
        }
        return cfStaffExample;
    }

    @Override
    public List<CfStaff> getListByQuery(CfStaffQuery cfStaffQuery) {
        return cfStaffMapper.selectByExample(getExampleByQuery(cfStaffQuery));
    }

    @Override
    public Integer countByQuery(CfStaffQuery cfStaffQuery) {
        cfStaffQuery.setPage(null);
        return cfStaffMapper.countByExample(getExampleByQuery(cfStaffQuery));
    }

    @Override
    public CfStaff employerDeleteStaff(String employerId, String id) {
        CfStaff cfStaff = cfStaffMapper.selectByPrimaryKey(id);
        if(cfStaff==null || cfStaff.getId()==null){
            ExceptionCast.cast(StaffCode.STAFF_DOES_NOT_EXIST);
        }
        if(!cfStaff.getEmployerId().equals(employerId)){
            ExceptionCast.cast(StaffCode.STAFF_NOT_BELONG_TO_YOU);
        }
        int i = cfStaffMapper.deleteByPrimaryKey(id);
        if(i==0){
            ExceptionCast.cast(CommonCode.FAIL);
        }
        cfUserRoleService.deleteUserRoleByRoleFlagKey(cfStaff.getStaffId(), "staff");
        return cfStaff;
    }

    @Override
    public CfStaff employerUpdateStaff(CfStaff cfStaff) {
        CfStaff cfStaffOld = cfStaffMapper.selectByPrimaryKey(cfStaff.getId());
        if(cfStaffOld==null || cfStaffOld.getId()==null){
            ExceptionCast.cast(StaffCode.STAFF_DOES_NOT_EXIST);
        }
        cfStaff.setCreateTime(cfStaffOld.getCreateTime());
        cfStaff.setStaffId(cfStaffOld.getStaffId());
        if(!cfStaff.getEmployerId().equals(cfStaffOld.getEmployerId())){
            ExceptionCast.cast(StaffCode.STAFF_NOT_BELONG_TO_YOU);
        }
        update(cfStaff);
        return cfStaff;
    }

    @Override
    public CfStaff employerAddStaff(CfStaff cfStaff) {
        CfUser cfUser = cfUserService.getUserByUid(cfStaff.getStaffId(), false);
        if(cfUser==null || cfUser.getId()==null){
            ExceptionCast.cast(StaffCode.STAFF_DOES_NOT_EXIST);
        }
        add(cfStaff);
        cfUserRoleService.addByUidAndRoleKey(cfUser.getId(),"staff");
        return cfStaff;
    }

    @Override
    public List<CfStaff> selectByQuery(CfStaffQuery cfStaffQuery) {
        return cfStaffMapper.selectByQuery(cfStaffQuery);
    }

    @Override
    public CfStaff checkStaffExistByEmployerIdAndStaffId(String employerId, String staffId, String exceptionScene) {
        CfStaffQuery cfStaffQuery = new CfStaffQuery();
        cfStaffQuery.setEmployerId(employerId);
        cfStaffQuery.setStaffId(staffId);
        List<CfStaff> cfStaffs = getListByQuery(cfStaffQuery);
        if(cfStaffs!=null && cfStaffs.size()>0){
            if(exceptionScene.equals("yes")){
                ExceptionCast.cast(StaffCode.CANT_NOT_REPEAT_ADD_STAFF);
            }
            return cfStaffs.get(0);
        }
        if(exceptionScene.equals("no")){
            ExceptionCast.cast(StaffCode.STAFF_DOES_NOT_EXIST);
        }
        return null;
    }

    @Override
    public List<CfStaff> selectByQueryContainCouponCount(CfStaffQuery cfStaffQuery) {
        return cfStaffMapper.selectByQueryContainCouponCount(cfStaffQuery);
    }
}
