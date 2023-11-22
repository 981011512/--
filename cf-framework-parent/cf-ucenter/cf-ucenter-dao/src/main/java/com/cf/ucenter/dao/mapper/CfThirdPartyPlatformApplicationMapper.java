package com.cf.ucenter.dao.mapper;

import com.cf.ucenter.domain.CfThirdPartyPlatformApplication;
import com.cf.ucenter.domain.CfThirdPartyPlatformApplicationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfThirdPartyPlatformApplicationMapper {
    int countByExample(CfThirdPartyPlatformApplicationExample example);

    int deleteByExample(CfThirdPartyPlatformApplicationExample example);

    int deleteByPrimaryKey(String appid);

    int insert(CfThirdPartyPlatformApplication record);

    int insertSelective(CfThirdPartyPlatformApplication record);

    List<CfThirdPartyPlatformApplication> selectByExample(CfThirdPartyPlatformApplicationExample example);

    CfThirdPartyPlatformApplication selectByPrimaryKey(String appid);

    int updateByExampleSelective(@Param("record") CfThirdPartyPlatformApplication record, @Param("example") CfThirdPartyPlatformApplicationExample example);

    int updateByExample(@Param("record") CfThirdPartyPlatformApplication record, @Param("example") CfThirdPartyPlatformApplicationExample example);

    int updateByPrimaryKeySelective(CfThirdPartyPlatformApplication record);

    int updateByPrimaryKey(CfThirdPartyPlatformApplication record);
}