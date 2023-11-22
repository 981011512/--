package com.cf.logistics.dao.mapper;

import com.cf.logistics.domain.CfLogisticsStorehouseLinkUser;
import com.cf.logistics.domain.CfLogisticsStorehouseLinkUserExample;
import com.cf.logistics.domain.request.CfLogisticsStorehouseLinkUserQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfLogisticsStorehouseLinkUserMapper {
    int countByExample(CfLogisticsStorehouseLinkUserExample example);

    int deleteByExample(CfLogisticsStorehouseLinkUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CfLogisticsStorehouseLinkUser record);

    int insertSelective(CfLogisticsStorehouseLinkUser record);

    List<CfLogisticsStorehouseLinkUser> selectByExample(CfLogisticsStorehouseLinkUserExample example);

    CfLogisticsStorehouseLinkUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CfLogisticsStorehouseLinkUser record, @Param("example") CfLogisticsStorehouseLinkUserExample example);

    int updateByExample(@Param("record") CfLogisticsStorehouseLinkUser record, @Param("example") CfLogisticsStorehouseLinkUserExample example);

    int updateByPrimaryKeySelective(CfLogisticsStorehouseLinkUser record);

    int updateByPrimaryKey(CfLogisticsStorehouseLinkUser record);

    List<CfLogisticsStorehouseLinkUser> selectListByQuery(CfLogisticsStorehouseLinkUserQuery cfLogisticsStorehouseLinkUserQuery);
}