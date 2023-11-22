package com.cf.ucenter.dao.mapper;

import com.cf.ucenter.domain.CfThirdPartySystemCallKeys;
import com.cf.ucenter.domain.CfThirdPartySystemCallKeysExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfThirdPartySystemCallKeysMapper {
    int countByExample(CfThirdPartySystemCallKeysExample example);

    int deleteByExample(CfThirdPartySystemCallKeysExample example);

    int deleteByPrimaryKey(Long keyId);

    int insert(CfThirdPartySystemCallKeys record);

    int insertSelective(CfThirdPartySystemCallKeys record);

    List<CfThirdPartySystemCallKeys> selectByExample(CfThirdPartySystemCallKeysExample example);

    CfThirdPartySystemCallKeys selectByPrimaryKey(Long keyId);

    int updateByExampleSelective(@Param("record") CfThirdPartySystemCallKeys record, @Param("example") CfThirdPartySystemCallKeysExample example);

    int updateByExample(@Param("record") CfThirdPartySystemCallKeys record, @Param("example") CfThirdPartySystemCallKeysExample example);

    int updateByPrimaryKeySelective(CfThirdPartySystemCallKeys record);

    int updateByPrimaryKey(CfThirdPartySystemCallKeys record);
}