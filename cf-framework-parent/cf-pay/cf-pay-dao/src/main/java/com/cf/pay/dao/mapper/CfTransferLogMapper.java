package com.cf.pay.dao.mapper;

import com.cf.pay.domain.CfTransferLog;
import com.cf.pay.domain.CfTransferLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfTransferLogMapper {
    int countByExample(CfTransferLogExample example);

    int deleteByExample(CfTransferLogExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfTransferLog record);

    int insertSelective(CfTransferLog record);

    List<CfTransferLog> selectByExample(CfTransferLogExample example);

    CfTransferLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfTransferLog record, @Param("example") CfTransferLogExample example);

    int updateByExample(@Param("record") CfTransferLog record, @Param("example") CfTransferLogExample example);

    int updateByPrimaryKeySelective(CfTransferLog record);

    int updateByPrimaryKey(CfTransferLog record);
}