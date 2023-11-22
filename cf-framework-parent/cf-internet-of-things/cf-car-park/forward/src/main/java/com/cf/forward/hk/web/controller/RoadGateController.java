package com.cf.forward.hk.web.controller;


import com.cf.forward.hk.hardware.HkHelper;
import com.cf.forward.hk.web.service.HkHelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author why
 * <p>
 * 道闸控制
 */
@RestController
@RequestMapping("hk/roadGate")
public class RoadGateController {


    @Autowired
    private HkHelperService hkHelperService;

    /**
     * 开关闸
     *
     * @param isOpen 1 开闸 , 0 关闸
     */
    @GetMapping("/openAndClose")
    public void openAndClose(Integer isOpen) {
        if (null != isOpen && isOpen == 1) {
            hkHelperService.openAndClose(true);
        } else {
            hkHelperService.openAndClose(false);
        }
    }


}
