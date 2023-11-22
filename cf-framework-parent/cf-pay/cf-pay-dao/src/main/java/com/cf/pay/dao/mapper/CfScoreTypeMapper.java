package com.cf.pay.dao.mapper;

import com.cf.pay.domain.CfScoreType;
import com.cf.pay.domain.CfScoreTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfScoreTypeMapper {
    int countByExample(CfScoreTypeExample example);

    int deleteByExample(CfScoreTypeExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfScoreType record);

    int insertSelective(CfScoreType record);

    List<CfScoreType> selectByExample(CfScoreTypeExample example);

    CfScoreType selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfScoreType record, @Param("example") CfScoreTypeExample example);

    int updateByExample(@Param("record") CfScoreType record, @Param("example") CfScoreTypeExample example);

    int updateByPrimaryKeySelective(CfScoreType record);

    int updateByPrimaryKey(CfScoreType record);
}