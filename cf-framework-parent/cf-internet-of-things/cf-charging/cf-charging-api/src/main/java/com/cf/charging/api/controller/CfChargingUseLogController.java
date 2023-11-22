package com.cf.charging.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.cf.charging.api.config.AuthenticationInterceptor;
import com.cf.charging.api.swagger.CfChargingUseLogSwagger;
import com.cf.charging.domain.CfChargingStation;
import com.cf.charging.domain.CfChargingStationDevice;
import com.cf.charging.domain.CfChargingUseLog;
import com.cf.charging.domain.request.CfChargingPortQuery;
import com.cf.charging.domain.request.CfChargingStationDeviceForm;
import com.cf.charging.domain.request.CfChargingUseLogQuery;
import com.cf.charging.service.CfChargingStationBusinessService;
import com.cf.charging.service.CfChargingStationDeviceService;
import com.cf.charging.service.CfChargingStationService;
import com.cf.charging.service.CfChargingUseLogService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.framework.utils.StringTools;
import com.cf.pay.domain.CfOrder;
import com.cf.pay.domain.request.CfOrderQuery;
import com.cf.pay.service.CfOrderService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("chargingUseLog/")
@Validated
@CrossOrigin
public class CfChargingUseLogController implements CfChargingUseLogSwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfChargingUseLogService cfChargingUseLogService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfChargingStationDeviceService cfChargingStationDeviceService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfChargingStationBusinessService cfChargingStationBusinessService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfOrderService cfOrderService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfChargingStationService cfChargingStationService;
    @Autowired
    protected HttpServletRequest request;

    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(CfChargingUseLogQuery cfChargingUseLogQuery) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        cfChargingUseLogQuery.setUid(userBasicInfo.getId());
        //排序按开始时间倒序取
            cfChargingUseLogQuery.setOrderBy("start_time desc");
        if(cfChargingUseLogQuery.getSize()>20){
            cfChargingUseLogQuery.setSize(5);
        }
        List<CfChargingUseLog> cfChargingUseLogList = cfChargingUseLogService.selectListByQuery(cfChargingUseLogQuery);
        if(cfChargingUseLogList==null || cfChargingUseLogList.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS, null);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfChargingUseLogList);
    }

    @Override
    @RequestMapping(value = "getChargingOrderByUesLogId", method = RequestMethod.GET)
    public ResponseResult getChargingOrderByUesLogId(String id) throws Exception {
        CfChargingUseLog cfChargingUseLog = cfChargingUseLogService.findById(id, false);
        CfOrderQuery cfOrderQuery = new CfOrderQuery();
        cfOrderQuery.setGoodsId(cfChargingUseLog.getId());
        List<CfOrder> cfOrderList = cfOrderService.getListByQuery(cfOrderQuery);
        if(cfOrderList==null || cfOrderList.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        cfChargingUseLog.setCfOrder(cfOrderList.get(0));
        if(StringUtils.isNotEmpty(cfChargingUseLog.getChargingStationId())){
            cfChargingUseLog.setCfChargingStation(cfChargingStationService.findById(cfChargingUseLog.getChargingStationId(), false));
        }

        return new ResponseResult(CommonCode.SUCCESS, cfChargingUseLog);
    }

    @RequestMapping(value = "test")
    public ResponseResult test(HttpServletRequest httpServletRequest) throws Exception {
        Map carLogMap = null;
        String sb = getHttpData(httpServletRequest);

        if(StringUtils.isNotEmpty(sb)){
            carLogMap = (JSONObject.parseObject(sb));
        }else{
            if(carLogMap==null || carLogMap.get("AlarmInfoPlate")==null){
                carLogMap = new HashMap<String, Object>();
                Map<String, String[]> parameterMap = request.getParameterMap();
                for(Map.Entry<String, String[]> map:parameterMap.entrySet()){
                    carLogMap.put(map.getKey(), map.getValue()[0]);
                }
            }
        }
        return new ResponseResult(CommonCode.SUCCESS, carLogMap);
    }

    public String getHttpData(HttpServletRequest httpServletRequest) throws Exception {
        BufferedReader bufferedReader = null;
        InputStream inputStream = null;
        StringBuffer sb = null;
        try{
            inputStream = httpServletRequest.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            sb = new StringBuffer();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e){
            throw e;
        }finally {
            try{
                bufferedReader.close();
                inputStream.close();
            }catch (Exception e){
                throw e;
            }

        }
        return sb.toString();
    }
}
