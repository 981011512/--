package com.cf.ucenter.service;

import com.cf.ucenter.domain.CfUserDriverLicense;
import com.cf.ucenter.domain.CfUserDriverLicenseExample;
import com.cf.ucenter.request.CfUserDriverLicenseQuery;

import java.util.List;

public interface CfUserDriverLicenseService {

    CfUserDriverLicense add(CfUserDriverLicense cfUserIdCard) throws Exception;

    CfUserDriverLicense update(CfUserDriverLicense cfUserIdCard) throws Exception;

    Integer updateByQUery(CfUserDriverLicense cfUserIdCard, CfUserDriverLicenseQuery cfUserIdCardQuery) throws Exception;

    Integer delete(Long id);

    CfUserDriverLicense findById(Long id);

    CfUserDriverLicense findById(Long id, boolean expectEmpty);

    List<CfUserDriverLicense> getListByQuery(CfUserDriverLicenseQuery cfUserIdCardQuery);

    Integer countByQuery(CfUserDriverLicenseQuery cfUserIdCardQuery);

    /**
     * 通过证件号排查该证件是否已经被绑定过
     * @param cfUserDriverLicense
     */
    void checkRepeatByLicenseNumber(CfUserDriverLicense cfUserDriverLicense);

    CfUserDriverLicenseExample getExampleByQuery(CfUserDriverLicenseQuery cfUserIdCardQuery);

    /**
     * 同步TMS物流系统司机信息
     */
    List<CfUserDriverLicense> synchronizeTmsDriver()throws Exception;
    
}
