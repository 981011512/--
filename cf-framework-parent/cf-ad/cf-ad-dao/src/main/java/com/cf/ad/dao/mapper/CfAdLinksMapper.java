package com.cf.ad.dao.mapper;

import com.cf.ad.domain.CfAdLinks;
import com.cf.ad.domain.CfAdLinksExample;
import com.cf.ad.domain.request.AdCounts;
import com.cf.ad.domain.request.CfAdLinksQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfAdLinksMapper {
    int countByExample(CfAdLinksExample example);

    int deleteByExample(CfAdLinksExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfAdLinks record);

    int insertSelective(CfAdLinks record);

    List<CfAdLinks> selectByExample(CfAdLinksExample example);

    CfAdLinks selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfAdLinks record, @Param("example") CfAdLinksExample example);

    int updateByExample(@Param("record") CfAdLinks record, @Param("example") CfAdLinksExample example);

    int updateByPrimaryKeySelective(CfAdLinks record);

    int updateByPrimaryKey(CfAdLinks record);

    /**
     * 批量插入
     * @param cfAdLinksList
     * @return
     */
    int batchInsert(List<CfAdLinks> cfAdLinksList);

    List<CfAdLinks> selectContainAdByQuery(CfAdLinksQuery cfAdLinksQuery);

    /**
     * 广告统计
     * @param adCounts
     * @return
     */
    Integer adCounts(AdCounts adCounts);
}