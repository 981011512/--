package com.cf.pay.dao.mapper;

import com.cf.pay.domain.CfHistoryOrder;
import com.cf.pay.domain.CfHistoryOrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfHistoryOrderMapper {
    int countByExample(CfHistoryOrderExample example);

    int deleteByExample(CfHistoryOrderExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfHistoryOrder record);

    int insertSelective(CfHistoryOrder record);

    List<CfHistoryOrder> selectByExample(CfHistoryOrderExample example);

    CfHistoryOrder selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfHistoryOrder record, @Param("example") CfHistoryOrderExample example);

    int updateByExample(@Param("record") CfHistoryOrder record, @Param("example") CfHistoryOrderExample example);

    int updateByPrimaryKeySelective(CfHistoryOrder record);

    int updateByPrimaryKey(CfHistoryOrder record);
}