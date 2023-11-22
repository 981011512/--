package com.cf.charging.admin.controller;

import com.cf.charging.admin.swagger.CfChargingStationDeviceSwagger;
import com.cf.charging.domain.CfChargingStationDevice;
import com.cf.charging.domain.customize.CfChargingState;
import com.cf.charging.domain.request.CfChargingStationDeviceForm;
import com.cf.charging.domain.request.CfChargingStationDeviceQuery;
import com.cf.charging.domain.type.ChargingDeviceType;
import com.cf.charging.service.CfChargingStationBusinessService;
import com.cf.charging.service.CfChargingStationDeviceService;
import com.cf.charging.service.CfChargingStationLinkUserService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("chargingStationDeviceAdmin/")
@Validated
@CrossOrigin
public class CfChargingStationDeviceController implements CfChargingStationDeviceSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfChargingStationLinkUserService cfChargingStationLinkUserService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfChargingStationDeviceService cfChargingStationDeviceService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfChargingStationBusinessService cfChargingStationBusinessService;
    @Autowired
    protected HttpServletRequest request;


    @PreAuthorize("hasAuthority('charging-CfChargingStationDeviceController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@Validated @RequestBody CfChargingStationDeviceForm cfChargingStationDeviceForm) throws Exception {
        CfChargingStationDevice cfChargingStationDevice = new CfChargingStationDevice();
        BeanUtils.copyProperties(cfChargingStationDeviceForm,cfChargingStationDevice);
        CfChargingStationDevice lastCfChargingStationDevice = cfChargingStationDeviceService.add(cfChargingStationDevice);
        return new ResponseResult(CommonCode.SUCCESS, lastCfChargingStationDevice);
    }

    @PreAuthorize("hasAuthority('charging-CfChargingStationDeviceController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@Validated @RequestBody CfChargingStationDeviceForm cfChargingStationDeviceForm) {
        CfChargingStationDevice cfChargingStationDevice = new CfChargingStationDevice();
        BeanUtils.copyProperties(cfChargingStationDeviceForm,cfChargingStationDevice);
        CfChargingStationDevice lastCfChargingStationDevice = cfChargingStationDeviceService.update(cfChargingStationDevice);
        return new ResponseResult(CommonCode.SUCCESS, lastCfChargingStationDevice);
    }

    @PreAuthorize("hasAuthority('charging-CfChargingStationDeviceController-getListByQuery')")
    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(CfChargingStationDeviceQuery cfChargingStationDeviceQuery) throws Exception {
        List<CfChargingStationDevice> cfChargingStationDeviceList = cfChargingStationDeviceService.getListByQuery(cfChargingStationDeviceQuery);
        if(cfChargingStationDeviceList==null || cfChargingStationDeviceList.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfChargingStationDeviceList);
    }

    @PreAuthorize("hasAuthority('charging-CfChargingStationDeviceController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(String id) throws Exception {
        Integer delete = cfChargingStationDeviceService.delete(id);
        return delete>0?new ResponseResult(CommonCode.SUCCESS, delete):new ResponseResult(CommonCode.FAIL, null);
    }

    @PreAuthorize("hasAuthority('charging-CfChargingStationDeviceController-chargingSettiong')")
    @Override
    @RequestMapping(value = "chargingSettiong", method = RequestMethod.POST)
    public ResponseResult chargingSettiong(@Validated @RequestBody CfChargingStationDeviceForm cfChargingStationDeviceForm) throws Exception {
        CfChargingState cfChargingState = cfChargingStationBusinessService.chargingSettiong(cfChargingStationDeviceForm);
        return new ResponseResult(CommonCode.SUCCESS, cfChargingState);
    }

    @PreAuthorize("hasAuthority('charging-CfChargingStationDeviceController-stopCharging')")
    @Override
    @RequestMapping(value = "stopCharging", method = RequestMethod.POST)
    public ResponseResult stopCharging(@Validated @RequestBody CfChargingStationDeviceForm cfChargingStationDeviceForm) throws Exception {
        CfChargingState cfChargingState = cfChargingStationBusinessService.stopCharging(cfChargingStationDeviceForm);
        return new ResponseResult(CommonCode.SUCCESS, cfChargingState);
    }

    @PreAuthorize("hasAuthority('charging-CfChargingStationDeviceController-counts')")
    @Override
    @RequestMapping(value = "counts", method = RequestMethod.GET)
    public ResponseResult counts() throws Exception {
        Map<String,Integer> result = new HashMap<>();
        CfChargingStationDeviceQuery cfChargingStationDeviceQuery = new CfChargingStationDeviceQuery();
        cfChargingStationDeviceQuery.setType(ChargingDeviceType.CHARGING_DEVICE);
        Integer count = cfChargingStationDeviceService.countByQuery(cfChargingStationDeviceQuery);
        result.put("charging_device",count);

        cfChargingStationDeviceQuery.setType(ChargingDeviceType.CHARGING_DEVICE);
        cfChargingStationDeviceQuery.setStatus((byte)1);
        count = cfChargingStationDeviceService.countByQuery(cfChargingStationDeviceQuery);
        result.put("charging_device_online",count);
        return new ResponseResult(CommonCode.SUCCESS,result);
    }
}
