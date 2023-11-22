package com.cf.ucenter.service;

import com.cf.ucenter.domain.CfSubscribeMessageTemplate;
import com.cf.ucenter.domain.CfSubscribeMessageTemplateExample;
import com.cf.ucenter.request.CfSubscribeMessageTemplateQuery;

import java.util.List;

public interface CfSubscribeMessageTemplateService {

    CfSubscribeMessageTemplate add(CfSubscribeMessageTemplate cfSubscribeMessageTemplate);

    CfSubscribeMessageTemplate update(CfSubscribeMessageTemplate cfSubscribeMessageTemplate);

    Integer delete(Long id);

    CfSubscribeMessageTemplate findById(Long id);

    CfSubscribeMessageTemplate findById(Long id, boolean expectEmpty);

    List<CfSubscribeMessageTemplate> getListByQuery(CfSubscribeMessageTemplateQuery cfSubscribeMessageTemplateQuery);

    Integer countByQuery(CfSubscribeMessageTemplateQuery cfSubscribeMessageTemplateQuery);

    CfSubscribeMessageTemplateExample getExampleByQuery(CfSubscribeMessageTemplateQuery cfSubscribeMessageTemplateQuery);

}
