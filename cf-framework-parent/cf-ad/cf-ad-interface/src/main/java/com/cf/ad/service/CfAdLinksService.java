package com.cf.ad.service;

import com.cf.ad.domain.CfAdLinks;
import com.cf.ad.domain.CfAdLinksExample;
import com.cf.ad.domain.request.AdCounts;
import com.cf.ad.domain.request.CfAdLinksQuery;
import io.swagger.models.auth.In;

import java.util.List;

public interface CfAdLinksService {

    Integer add(CfAdLinks cfAdLinks);

    CfAdLinks update(CfAdLinks cfAdLinks);

    Integer updateByQuery(CfAdLinks cfAdLinks, CfAdLinksQuery cfAdLinksQuery);

    Integer delete(String id);

    Integer deleteByQuery(CfAdLinksQuery cfAdLinksQuery);

    CfAdLinksExample getExampleByQuery(CfAdLinksQuery cfAdLinksQuery);

    List<CfAdLinks> getListByQuery(CfAdLinksQuery cfAdLinksQuery);

    List<CfAdLinks> selectContainAdByQuery(CfAdLinksQuery cfAdLinksQuery);

    Integer countByQuery(CfAdLinksQuery cfAdLinksQuery);

    /**
     * 广告统计
     * @param adCounts
     * @return
     */
    Integer adCounts(AdCounts adCounts);

}
