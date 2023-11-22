package com.cf.forward.hk.web.service.impl;

import com.cf.forward.hk.hardware.HkHelper;
import com.cf.forward.hk.web.service.HkHelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author why
 */
@Service
public class HkHelperServiceImpl implements HkHelperService {


    @Autowired
    private HkHelper hkHelper;



    @Override
    public Boolean openAndClose(boolean isOpen) {
        return  hkHelper.openAndClose(isOpen);
    }
}
