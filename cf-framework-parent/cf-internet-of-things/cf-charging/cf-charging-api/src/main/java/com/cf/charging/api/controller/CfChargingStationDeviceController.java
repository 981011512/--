package com.cf.charging.api.controller;

import com.cf.charging.api.config.AuthenticationInterceptor;
import com.cf.charging.api.swagger.CfChargingStationDeviceSwagger;
import com.cf.charging.domain.CfChargingStationDevice;
import com.cf.charging.domain.CfChargingUseLog;
import com.cf.charging.domain.customize.CfChargingState;
import com.cf.charging.domain.request.CfChargingStationDeviceForm;
import com.cf.charging.domain.request.CfChargingStationDeviceQuery;
import com.cf.charging.service.CfChargingStationBusinessService;
import com.cf.charging.service.CfChargingStationDeviceService;
import com.cf.charging.service.CfChargingStationLinkUserService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.utils.HttpHearderUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("chargingStationDevice/")
@Validated
@CrossOrigin
public class CfChargingStationDeviceController implements CfChargingStationDeviceSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfChargingStationDeviceService cfChargingStationDeviceService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfChargingStationLinkUserService cfCarParkLinkUserQuery;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfChargingStationBusinessService cfChargingStationBusinessService;
    @Autowired
    protected HttpServletRequest request;

    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(CfChargingStationDeviceQuery cfChargingStationDeviceQuery) throws Exception {
        List<CfChargingStationDevice> cfChargingStationDeviceList = cfChargingStationDeviceService.getListByQuery(cfChargingStationDeviceQuery);
        if(cfChargingStationDeviceList==null || cfChargingStationDeviceList.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfChargingStationDeviceList);
    }

    @Override
    @RequestMapping(value = "startCharging", method = RequestMethod.POST)
    public ResponseResult startCharging(@Validated @RequestBody CfChargingStationDeviceForm cfChargingStationDeviceForm) throws Exception {
        if(StringUtils.isEmpty(cfChargingStationDeviceForm.getId())){
            return new ResponseResult(CommonCode.INVALID_PARAM, null, "请提供设备id");
        }

        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        cfChargingStationDeviceForm.setUid(userBasicInfo.getId());
        CfChargingUseLog cfChargingUseLog = cfChargingStationBusinessService.startCharging(cfChargingStationDeviceForm);
        return new ResponseResult(CommonCode.SUCCESS, cfChargingUseLog);
    }

    @Override
    @RequestMapping(value = "stopCharging", method = RequestMethod.POST)
    public ResponseResult stopCharging(@Validated @RequestBody CfChargingStationDeviceForm cfChargingStationDeviceForm) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        cfChargingStationDeviceForm.setUid(userBasicInfo.getId());
        CfChargingUseLog cfChargingUseLog = cfChargingStationBusinessService.clientStopCharging(cfChargingStationDeviceForm);
        return new ResponseResult(CommonCode.SUCCESS, cfChargingUseLog);
    }
}
