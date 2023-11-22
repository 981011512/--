package com.cf.logistics.dao.mapper;

import com.cf.logistics.domain.CfLogisticsCarType;
import com.cf.logistics.domain.CfLogisticsCarTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfLogisticsCarTypeMapper {
    int countByExample(CfLogisticsCarTypeExample example);

    int deleteByExample(CfLogisticsCarTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CfLogisticsCarType record);

    int insertSelective(CfLogisticsCarType record);

    List<CfLogisticsCarType> selectByExample(CfLogisticsCarTypeExample example);

    CfLogisticsCarType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CfLogisticsCarType record, @Param("example") CfLogisticsCarTypeExample example);

    int updateByExample(@Param("record") CfLogisticsCarType record, @Param("example") CfLogisticsCarTypeExample example);

    int updateByPrimaryKeySelective(CfLogisticsCarType record);

    int updateByPrimaryKey(CfLogisticsCarType record);
}