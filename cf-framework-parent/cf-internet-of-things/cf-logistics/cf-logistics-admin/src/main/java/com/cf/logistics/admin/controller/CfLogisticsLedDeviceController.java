package com.cf.logistics.admin.controller;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.logistics.admin.swagger.CfLogisticsLedDeviceSwagger;
import com.cf.logistics.domain.CfLogisticsLedDevice;
import com.cf.logistics.domain.device.CfLinXinLed;
import com.cf.logistics.domain.device.CfLinXinLedArea;
import com.cf.logistics.domain.device.CfLinXinLedProgram;
import com.cf.logistics.domain.request.CfLogisticsLedDeviceForm;
import com.cf.logistics.domain.request.CfLogisticsLedDeviceQuery;
import com.cf.logistics.service.CfLogisticsLedDeviceService;
import com.cf.logistics.service.CfLogisticsTaskLogService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("LogisticsLedDeviceAdmin/")
@Validated
@CrossOrigin
public class CfLogisticsLedDeviceController implements CfLogisticsLedDeviceSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfLogisticsLedDeviceService cfLogisticsLedDeviceService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfLogisticsTaskLogService cfLogisticsTaskLogService;
    @Autowired
    protected HttpServletRequest request;

    @PreAuthorize("hasAuthority('logistics-CfLogisticsLedDeviceController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@Validated @RequestBody CfLogisticsLedDeviceForm cfLogisticsLedDeviceForm) throws Exception {
        CfLogisticsLedDevice cfLogisticsLedDevice = new CfLogisticsLedDevice();
        BeanUtils.copyProperties(cfLogisticsLedDeviceForm,cfLogisticsLedDevice);
        CfLogisticsLedDevice lastCfLogisticsLedDevice = cfLogisticsLedDeviceService.add(cfLogisticsLedDevice);
        return new ResponseResult(CommonCode.SUCCESS, lastCfLogisticsLedDevice);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsLedDeviceController-update')")
    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseResult update(@Validated @RequestBody CfLogisticsLedDeviceForm cfLogisticsLedDeviceForm) {
        CfLogisticsLedDevice cfLogisticsLedDevice = new CfLogisticsLedDevice();
        BeanUtils.copyProperties(cfLogisticsLedDeviceForm,cfLogisticsLedDevice);
        CfLogisticsLedDevice update = cfLogisticsLedDeviceService.update(cfLogisticsLedDevice);
        return new ResponseResult(CommonCode.SUCCESS, update);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsLedDeviceController-delete')")
    @Override
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseResult delete(Long id) {
        Integer delete = cfLogisticsLedDeviceService.delete(id);
        return delete>0?new ResponseResult(CommonCode.SUCCESS, delete):new ResponseResult(CommonCode.FAIL, null);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsLedDeviceController-getListByQuery')")
    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(CfLogisticsLedDeviceQuery cfLogisticsLedDeviceQuery) throws Exception {
        List<CfLogisticsLedDevice> cfLogisticsLedDevices = cfLogisticsLedDeviceService.getListByQuery(cfLogisticsLedDeviceQuery);
        Integer countByQuery = cfLogisticsLedDeviceService.countByQuery(cfLogisticsLedDeviceQuery);
        if(cfLogisticsLedDevices==null || cfLogisticsLedDevices.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfLogisticsLedDevices, countByQuery);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsLedDeviceController-setTcpData')")
    @Override
    @RequestMapping(value = "setTcpData", method = RequestMethod.GET)
    public ResponseResult setTcpData(String serialNumber, Integer screenWidth, Integer screenHigh, Integer x, Integer y, Integer width, Integer high, Integer fontRowSpacing, String contents) throws Exception {
        //【文本列表】
        ArrayList<CfLinXinLedArea> cfLinXinLedAreaArrayList = new ArrayList<>();
        //文本1
        cfLinXinLedAreaArrayList.add(new CfLinXinLedArea(1, x, y, width, high, 1, 16, 16, 0, 1, 4, 3, x, y, width, high, 1, fontRowSpacing, 0, contents));
        //【节目】
        //节目1
        CfLinXinLedProgram cfLinXinLedProgram = new CfLinXinLedProgram(0, 0, 1, cfLinXinLedAreaArrayList);
        //【第一个主板内容】
        ArrayList<CfLinXinLedProgram> cfLinXinLedProgramArrayList = new ArrayList<>();
        cfLinXinLedProgramArrayList.add(cfLinXinLedProgram);
        CfLinXinLed cfLinXinLed = new CfLinXinLed(screenWidth, screenHigh, 1, 5, 2, cfLinXinLedProgramArrayList);
        cfLogisticsLedDeviceService.sendTcpData(serialNumber, cfLinXinLed);
        return new ResponseResult(CommonCode.SUCCESS, cfLinXinLed);
    }

    @PreAuthorize("hasAuthority('logistics-CfLogisticsLedDeviceController-flushLesScreenData')")
    @Override
    @RequestMapping(value = "flushLesScreenData", method = RequestMethod.GET)
    public ResponseResult flushLesScreenData(Long queuingAreaId) throws Exception {
        String flushLesScreenData = cfLogisticsTaskLogService.flushLesScreenData(queuingAreaId);
        return new ResponseResult(CommonCode.SUCCESS, flushLesScreenData);
    }
}
