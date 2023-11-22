package com.cf.ucenter.dao.mapper;

import com.cf.ucenter.domain.CfStaff;
import com.cf.ucenter.domain.CfStaffExample;
import com.cf.ucenter.request.CfStaffQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfStaffMapper {
    int countByExample(CfStaffExample example);

    int deleteByExample(CfStaffExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfStaff record);

    int insertSelective(CfStaff record);

    List<CfStaff> selectByExample(CfStaffExample example);

    CfStaff selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfStaff record, @Param("example") CfStaffExample example);

    int updateByExample(@Param("record") CfStaff record, @Param("example") CfStaffExample example);

    int updateByPrimaryKeySelective(CfStaff record);

    int updateByPrimaryKey(CfStaff record);

    List<CfStaff> selectByQuery(CfStaffQuery cfStaffQuery);

    List<CfStaff> selectByQueryContainCouponCount(CfStaffQuery cfStaffQuery);
}