package com.cf.ucenter.service;

import com.cf.ucenter.domain.CfThirdPartyLogin;
import com.cf.ucenter.domain.CfThirdPartyLoginExample;
import com.cf.ucenter.request.CfThirdPartyLoginQuery;

import java.util.List;

public interface CfThirdPartyLoginService {

    CfThirdPartyLogin add(CfThirdPartyLogin cfThirdPartyLogin);

    CfThirdPartyLogin update(CfThirdPartyLogin cfThirdPartyLogin);

    Integer updateByQuery(CfThirdPartyLogin cfThirdPartyLogin, CfThirdPartyLoginQuery cfThirdPartyLoginQuery);

    Integer delete(String id);

    CfThirdPartyLogin findById(String id);

    CfThirdPartyLogin findById(String id, boolean expectEmpty);

    CfThirdPartyLoginExample getExampleByQuery(CfThirdPartyLoginQuery cfThirdPartyLoginQuery);

    List<CfThirdPartyLogin> getListByQuery(CfThirdPartyLoginQuery cfThirdPartyLoginQuery);

    Integer countByQuery(CfThirdPartyLoginQuery cfThirdPartyLoginQuery);

}
