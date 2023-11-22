package com.cf.ucenter.dao.mapper;

import com.cf.ucenter.domain.CfSubscribeMessageTemplate;
import com.cf.ucenter.domain.CfSubscribeMessageTemplateExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfSubscribeMessageTemplateMapper {
    int countByExample(CfSubscribeMessageTemplateExample example);

    int deleteByExample(CfSubscribeMessageTemplateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CfSubscribeMessageTemplate record);

    int insertSelective(CfSubscribeMessageTemplate record);

    List<CfSubscribeMessageTemplate> selectByExample(CfSubscribeMessageTemplateExample example);

    CfSubscribeMessageTemplate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CfSubscribeMessageTemplate record, @Param("example") CfSubscribeMessageTemplateExample example);

    int updateByExample(@Param("record") CfSubscribeMessageTemplate record, @Param("example") CfSubscribeMessageTemplateExample example);

    int updateByPrimaryKeySelective(CfSubscribeMessageTemplate record);

    int updateByPrimaryKey(CfSubscribeMessageTemplate record);
}