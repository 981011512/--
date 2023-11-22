package com.cf.pay.dao.mapper;

import com.cf.pay.domain.CfTaxAccount;
import com.cf.pay.domain.CfTaxAccountExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfTaxAccountMapper {
    int countByExample(CfTaxAccountExample example);

    int deleteByExample(CfTaxAccountExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfTaxAccount record);

    int insertSelective(CfTaxAccount record);

    List<CfTaxAccount> selectByExampleWithBLOBs(CfTaxAccountExample example);

    List<CfTaxAccount> selectByExample(CfTaxAccountExample example);

    CfTaxAccount selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfTaxAccount record, @Param("example") CfTaxAccountExample example);

    int updateByExampleWithBLOBs(@Param("record") CfTaxAccount record, @Param("example") CfTaxAccountExample example);

    int updateByExample(@Param("record") CfTaxAccount record, @Param("example") CfTaxAccountExample example);

    int updateByPrimaryKeySelective(CfTaxAccount record);

    int updateByPrimaryKeyWithBLOBs(CfTaxAccount record);

    int updateByPrimaryKey(CfTaxAccount record);

    /**
     * 根据条件查询支付机构数据列表
     * @param conditions
     * @return
     */
    List<CfTaxAccount> selectListByCondition(String conditions);

    /**
     * 根据条件查询支付机构数据列表数
     * @param conditions
     * @return
     */
    Integer selectListByConditionCounts(String conditions);
}