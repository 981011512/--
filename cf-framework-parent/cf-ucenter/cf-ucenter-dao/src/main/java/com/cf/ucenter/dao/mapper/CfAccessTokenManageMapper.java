package com.cf.ucenter.dao.mapper;

import com.cf.ucenter.domain.CfAccessTokenManage;
import com.cf.ucenter.domain.CfAccessTokenManageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfAccessTokenManageMapper {
    int countByExample(CfAccessTokenManageExample example);

    int deleteByExample(CfAccessTokenManageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CfAccessTokenManage record);

    int insertSelective(CfAccessTokenManage record);

    List<CfAccessTokenManage> selectByExample(CfAccessTokenManageExample example);

    CfAccessTokenManage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CfAccessTokenManage record, @Param("example") CfAccessTokenManageExample example);

    int updateByExample(@Param("record") CfAccessTokenManage record, @Param("example") CfAccessTokenManageExample example);

    int updateByPrimaryKeySelective(CfAccessTokenManage record);

    int updateByPrimaryKey(CfAccessTokenManage record);
}