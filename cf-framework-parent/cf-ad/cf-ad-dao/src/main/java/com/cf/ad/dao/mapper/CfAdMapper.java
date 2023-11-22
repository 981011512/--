package com.cf.ad.dao.mapper;

import com.cf.ad.domain.CfAd;
import com.cf.ad.domain.CfAdExample;
import com.cf.ad.domain.request.AdCounts;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfAdMapper {
    int countByExample(CfAdExample example);

    int deleteByExample(CfAdExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfAd record);

    int insertSelective(CfAd record);

    List<CfAd> selectByExample(CfAdExample example);

    CfAd selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfAd record, @Param("example") CfAdExample example);

    int updateByExample(@Param("record") CfAd record, @Param("example") CfAdExample example);

    int updateByPrimaryKeySelective(CfAd record);

    int updateByPrimaryKey(CfAd record);

    /**
     * 广告统计
     * @param adCounts
     * @return
     */
    Integer adCounts(AdCounts adCounts);
}