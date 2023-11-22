package com.cf.pay.dao.mapper;

import com.cf.pay.domain.CfAccount;
import com.cf.pay.domain.CfAccountExample;
import com.cf.pay.domain.request.CfAccountQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfAccountMapper {
    int countByExample(CfAccountExample example);

    int deleteByExample(CfAccountExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfAccount record);

    int insertSelective(CfAccount record);

    List<CfAccount> selectByExample(CfAccountExample example);

    CfAccount selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfAccount record, @Param("example") CfAccountExample example);

    int updateByExample(@Param("record") CfAccount record, @Param("example") CfAccountExample example);

    int updateByPrimaryKeySelective(CfAccount record);

    int updateByPrimaryKey(CfAccount record);

    Integer updateBalanceByQuery(CfAccountQuery cfAccountQuery);
}