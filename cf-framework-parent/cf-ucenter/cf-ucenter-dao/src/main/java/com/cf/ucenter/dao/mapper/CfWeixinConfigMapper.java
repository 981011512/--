package com.cf.ucenter.dao.mapper;

import com.cf.ucenter.domain.CfWeixinConfig;
import com.cf.ucenter.domain.CfWeixinConfigExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfWeixinConfigMapper {
    int countByExample(CfWeixinConfigExample example);

    int deleteByExample(CfWeixinConfigExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfWeixinConfig record);

    int insertSelective(CfWeixinConfig record);

    List<CfWeixinConfig> selectByExample(CfWeixinConfigExample example);

    CfWeixinConfig selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfWeixinConfig record, @Param("example") CfWeixinConfigExample example);

    int updateByExample(@Param("record") CfWeixinConfig record, @Param("example") CfWeixinConfigExample example);

    int updateByPrimaryKeySelective(CfWeixinConfig record);

    int updateByPrimaryKey(CfWeixinConfig record);
}