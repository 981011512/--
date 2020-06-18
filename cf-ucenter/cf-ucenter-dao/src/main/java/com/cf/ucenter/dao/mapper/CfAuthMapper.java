package com.cf.ucenter.dao.mapper;

import com.cf.ucenter.domain.CfAuth;
import com.cf.ucenter.domain.CfAuthExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfAuthMapper {
    int countByExample(CfAuthExample example);

    int deleteByExample(CfAuthExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfAuth record);

    int insertSelective(CfAuth record);

    List<CfAuth> selectByExample(CfAuthExample example);

    CfAuth selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfAuth record, @Param("example") CfAuthExample example);

    int updateByExample(@Param("record") CfAuth record, @Param("example") CfAuthExample example);

    int updateByPrimaryKeySelective(CfAuth record);

    int updateByPrimaryKey(CfAuth record);

    List<CfAuth> selectByUid(String uid);

    List<CfAuth> selectByUidAndLevel(@Param("uid")String uid, @Param("level")Byte level);

    List<CfAuth> selectByUidAndRoleIdAndLevel(@Param("uid")String uid, @Param("level")Byte level);

    List<CfAuth> selectByUidAndModuleAndLevel(@Param("uid")String uid, @Param("module")String module, @Param("level")Byte level);

    List<CfAuth> selectByUidAndControllerAndLevel(@Param("uid")String uid, @Param("controller")String controller, @Param("level")Byte level);

    List<CfAuth> selectByRoleIdAndLevel(@Param("roleId")String roleId, @Param("level")Byte level);

    List<CfAuth> selectByRoleIdAndModuleAndLevel(@Param("roleId")String roleId, @Param("module")String module, @Param("level")Byte level);

    List<CfAuth> selectByRoleIdAndControllerAndLevel(@Param("roleId")String roleId, @Param("controller")String controller, @Param("level")Byte level);
}