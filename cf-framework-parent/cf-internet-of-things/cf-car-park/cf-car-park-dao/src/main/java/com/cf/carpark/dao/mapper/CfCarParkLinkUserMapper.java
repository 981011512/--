package com.cf.carpark.dao.mapper;

import com.cf.carpark.domain.CfCarParkLinkUser;
import com.cf.carpark.domain.CfCarParkLinkUserExample;
import com.cf.carpark.domain.request.CfCarParkLinkUserQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfCarParkLinkUserMapper {
    int countByExample(CfCarParkLinkUserExample example);

    int deleteByExample(CfCarParkLinkUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfCarParkLinkUser record);

    int insertSelective(CfCarParkLinkUser record);

    List<CfCarParkLinkUser> selectByExample(CfCarParkLinkUserExample example);

    CfCarParkLinkUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfCarParkLinkUser record, @Param("example") CfCarParkLinkUserExample example);

    int updateByExample(@Param("record") CfCarParkLinkUser record, @Param("example") CfCarParkLinkUserExample example);

    int updateByPrimaryKeySelective(CfCarParkLinkUser record);

    int updateByPrimaryKey(CfCarParkLinkUser record);

    /**
     * 根据query条件原始sql查询
     * @param cfCarParkLinkUserQuery
     * @return
     */
    List<CfCarParkLinkUser> selectByQueryLeftJoinUser(CfCarParkLinkUserQuery cfCarParkLinkUserQuery);

}