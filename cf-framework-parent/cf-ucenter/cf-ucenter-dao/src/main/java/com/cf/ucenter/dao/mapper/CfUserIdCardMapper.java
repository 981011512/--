package com.cf.ucenter.dao.mapper;

import com.cf.ucenter.domain.CfUserIdCard;
import com.cf.ucenter.domain.CfUserIdCardExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfUserIdCardMapper {
    int countByExample(CfUserIdCardExample example);

    int deleteByExample(CfUserIdCardExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CfUserIdCard record);

    int insertSelective(CfUserIdCard record);

    List<CfUserIdCard> selectByExample(CfUserIdCardExample example);

    CfUserIdCard selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CfUserIdCard record, @Param("example") CfUserIdCardExample example);

    int updateByExample(@Param("record") CfUserIdCard record, @Param("example") CfUserIdCardExample example);

    int updateByPrimaryKeySelective(CfUserIdCard record);

    int updateByPrimaryKey(CfUserIdCard record);
}