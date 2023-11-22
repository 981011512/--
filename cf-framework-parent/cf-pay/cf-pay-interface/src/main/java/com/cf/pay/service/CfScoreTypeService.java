package com.cf.pay.service;

import com.cf.pay.domain.CfScoreType;
import com.cf.pay.domain.CfScoreTypeExample;
import com.cf.pay.domain.request.CfScoreTypeQuery;

import java.util.List;

public interface CfScoreTypeService {

    CfScoreType add(CfScoreType scoreType);

    CfScoreType update(CfScoreType scoreType);

    Integer delete(String id);

    CfScoreTypeExample getExampleByQuery(CfScoreTypeQuery cfScoreTypeQuery);

    List<CfScoreType> getListByQuery(CfScoreTypeQuery cfScoreTypeQuery);

}
