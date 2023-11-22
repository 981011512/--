package com.cf.ucenter.service;

import com.cf.ucenter.domain.CfRoleAuth;
import com.cf.ucenter.domain.CfRoleAuthExample;
import com.cf.ucenter.request.CfRoleAuthQuery;

import java.util.List;

public interface CfRoleAuthService {

    CfRoleAuth add(CfRoleAuth cfRoleAuth);

    CfRoleAuth update(CfRoleAuth cfRoleAuth);

    Integer delete(String id);

    Integer deleteByQuery(CfRoleAuthQuery cfRoleAuthQuery);

    CfRoleAuthExample getExampleByQuery(CfRoleAuthQuery cfRoleAuthQuery);

    List<CfRoleAuth> getListByQuery(CfRoleAuthQuery cfRoleAuthQuery);

    Integer countByQuery(CfRoleAuthQuery cfRoleAuthQuery);

}
