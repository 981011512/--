package com.cf.ucenter.dao.mapper;

import com.cf.ucenter.domain.CfUserSource;
import com.cf.ucenter.domain.CfUserSourceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfUserSourceMapper {
    int countByExample(CfUserSourceExample example);

    int deleteByExample(CfUserSourceExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfUserSource record);

    int insertSelective(CfUserSource record);

    List<CfUserSource> selectByExample(CfUserSourceExample example);

    CfUserSource selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfUserSource record, @Param("example") CfUserSourceExample example);

    int updateByExample(@Param("record") CfUserSource record, @Param("example") CfUserSourceExample example);

    int updateByPrimaryKeySelective(CfUserSource record);

    int updateByPrimaryKey(CfUserSource record);

    /**
     * 批量插入
     * @param list
     * @return
     */
    int batchInsert(@Param("list") List<CfUserSource> list);
}