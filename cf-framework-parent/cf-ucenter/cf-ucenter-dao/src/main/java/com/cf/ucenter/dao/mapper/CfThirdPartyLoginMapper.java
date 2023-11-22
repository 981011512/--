package com.cf.ucenter.dao.mapper;

import com.cf.ucenter.domain.CfThirdPartyLogin;
import com.cf.ucenter.domain.CfThirdPartyLoginExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfThirdPartyLoginMapper {
    int countByExample(CfThirdPartyLoginExample example);

    int deleteByExample(CfThirdPartyLoginExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfThirdPartyLogin record);

    int insertSelective(CfThirdPartyLogin record);

    List<CfThirdPartyLogin> selectByExample(CfThirdPartyLoginExample example);

    CfThirdPartyLogin selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfThirdPartyLogin record, @Param("example") CfThirdPartyLoginExample example);

    int updateByExample(@Param("record") CfThirdPartyLogin record, @Param("example") CfThirdPartyLoginExample example);

    int updateByPrimaryKeySelective(CfThirdPartyLogin record);

    int updateByPrimaryKey(CfThirdPartyLogin record);
}