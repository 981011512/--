package com.cf.pay.dao.mapper;

import com.cf.pay.domain.CfAccountLog;
import com.cf.pay.domain.CfAccountLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfAccountLogMapper {
    int countByExample(CfAccountLogExample example);

    int deleteByExample(CfAccountLogExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfAccountLog record);

    int insertSelective(CfAccountLog record);

    List<CfAccountLog> selectByExample(CfAccountLogExample example);

    CfAccountLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfAccountLog record, @Param("example") CfAccountLogExample example);

    int updateByExample(@Param("record") CfAccountLog record, @Param("example") CfAccountLogExample example);

    int updateByPrimaryKeySelective(CfAccountLog record);

    int updateByPrimaryKey(CfAccountLog record);
}