package com.cf.ad.service;

import com.cf.ad.domain.CfAd;
import com.cf.ad.domain.CfAdExample;
import com.cf.ad.domain.request.AdCounts;
import com.cf.ad.domain.request.CfAdQuery;

import java.util.List;

public interface CfAdService {

    CfAd add(CfAd cfAd);

    CfAd update(CfAd cfAd);

    Integer updateByQuery(CfAd cfAd, CfAdQuery cfAdQuery);

    Integer delete(String id);

    CfAdExample getExampleByQuery(CfAdQuery cfAdQuery);

    List<CfAd> getListByQuery(CfAdQuery cfAdQuery);

    Integer countByQuery(CfAdQuery cfAdQuery);

    /**
     * 广告统计
     * @param adCounts
     * @return
     */
    Integer adCounts(AdCounts adCounts);

}
