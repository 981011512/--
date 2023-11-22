package com.cf.pay.dao.mapper;

import com.cf.pay.domain.CfQrCode;
import com.cf.pay.domain.CfQrCodeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfQrCodeMapper {
    int countByExample(CfQrCodeExample example);

    int deleteByExample(CfQrCodeExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfQrCode record);

    int insertSelective(CfQrCode record);

    List<CfQrCode> selectByExample(CfQrCodeExample example);

    CfQrCode selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfQrCode record, @Param("example") CfQrCodeExample example);

    int updateByExample(@Param("record") CfQrCode record, @Param("example") CfQrCodeExample example);

    int updateByPrimaryKeySelective(CfQrCode record);

    int updateByPrimaryKey(CfQrCode record);
}