package com.cf.ucenter.dao.mapper;

import com.cf.ucenter.domain.CfUser;
import com.cf.ucenter.domain.CfUserExample;
import com.cf.ucenter.domain.CfUserExt;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfUserMapper {
    int countByExample(CfUserExample example);

    int deleteByExample(CfUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfUser record);

    int insertSelective(CfUser record);

    List<CfUser> selectByExample(CfUserExample example);

    CfUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfUser record, @Param("example") CfUserExample example);

    int updateByExample(@Param("record") CfUser record, @Param("example") CfUserExample example);

    int updateByPrimaryKeySelective(CfUser record);

    int updateByPrimaryKey(CfUser record);

    /**
     * 根据条件查询用户数据列表
     * @param conditions
     * @return
     */
    List<CfUser> selectListByCondition(String conditions);

    /**
     * 根据条件查询用户数据列表数
     * @param conditions
     * @return
     */
    Integer selectListByConditionCounts(String conditions);

    /**
     * 根据id获取指定管理员信息
     * @param id
     * @return
     */
    CfUserExt getUserAdministratorByUid(String id);
}