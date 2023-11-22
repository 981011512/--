package com.cf.ucenter.dao.mapper;

import com.cf.ucenter.domain.CfUserDriverLicense;
import com.cf.ucenter.domain.CfUserDriverLicenseExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfUserDriverLicenseMapper {
    int countByExample(CfUserDriverLicenseExample example);

    int deleteByExample(CfUserDriverLicenseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CfUserDriverLicense record);

    int insertSelective(CfUserDriverLicense record);

    List<CfUserDriverLicense> selectByExample(CfUserDriverLicenseExample example);

    CfUserDriverLicense selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CfUserDriverLicense record, @Param("example") CfUserDriverLicenseExample example);

    int updateByExample(@Param("record") CfUserDriverLicense record, @Param("example") CfUserDriverLicenseExample example);

    int updateByPrimaryKeySelective(CfUserDriverLicense record);

    int updateByPrimaryKey(CfUserDriverLicense record);
}