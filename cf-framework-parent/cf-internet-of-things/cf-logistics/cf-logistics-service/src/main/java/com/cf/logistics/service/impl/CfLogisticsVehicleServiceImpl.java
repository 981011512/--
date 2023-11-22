package com.cf.logistics.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.HttpClient;
import com.cf.framework.utils.IdWorker;
import com.cf.logistics.dao.mapper.CfLogisticsVehicleMapper;
import com.cf.logistics.domain.CfLogisticsVehicle;
import com.cf.logistics.domain.CfLogisticsVehicleExample;
import com.cf.logistics.domain.request.CfLogisticsVehicleQuery;
import com.cf.logistics.service.CfLogisticsVehicleService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfLogisticsVehicleServiceImpl implements CfLogisticsVehicleService {

    @Value("${logistics.tms-url}")
    private String tmsUrl;
    @Autowired
    private CfLogisticsVehicleMapper cfLogisticsVehicleMapper;
    @Autowired
    private IdWorker idWorker;


    @Override
    public CfLogisticsVehicle add(CfLogisticsVehicle cfLogisticsVehicle) {
        cfLogisticsVehicle.setId(idWorker.nextLongId());
        cfLogisticsVehicle.setCreateTime(System.currentTimeMillis());
        cfLogisticsVehicle.setUpdateTime(System.currentTimeMillis());
        cfLogisticsVehicleMapper.insertSelective(cfLogisticsVehicle);
        return cfLogisticsVehicle;
    }

    @Override
    public CfLogisticsVehicle update(CfLogisticsVehicle cfLogisticsVehicle) {
        cfLogisticsVehicle.setUpdateTime(System.currentTimeMillis());
        cfLogisticsVehicleMapper.updateByPrimaryKeySelective(cfLogisticsVehicle);
        return cfLogisticsVehicle;
    }

    @Override
    public Integer delete(Long id) {
        return cfLogisticsVehicleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CfLogisticsVehicle findById(Long id) {
        return cfLogisticsVehicleMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfLogisticsVehicle findById(Long id, boolean expect) {
        CfLogisticsVehicle cfLogisticsVehicle = findById(id);
        if(expect && cfLogisticsVehicle!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }
        if(!expect && cfLogisticsVehicle==null){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        return cfLogisticsVehicle;
    }

    @Override
    public CfLogisticsVehicleExample getExampleByQuer(CfLogisticsVehicleQuery cfLogisticsVehicleQuery) {
        CfLogisticsVehicleExample cfLogisticsVehicleExample = new CfLogisticsVehicleExample();
        CfLogisticsVehicleExample.Criteria criteria = cfLogisticsVehicleExample.createCriteria();
        if(cfLogisticsVehicleQuery.getUid()!=null){
            criteria.andUidEqualTo(cfLogisticsVehicleQuery.getUid());
        }
        if(cfLogisticsVehicleQuery.getVehicleVin()!=null){
            criteria.andVehicleVinEqualTo(cfLogisticsVehicleQuery.getVehicleVin());
        }
        if(cfLogisticsVehicleQuery.getNumberPlate()!=null){
            criteria.andNumberPlateEqualTo(cfLogisticsVehicleQuery.getNumberPlate());
        }
        if(cfLogisticsVehicleQuery.getVehicleOwner()!=null){
            criteria.andVehicleOwnerEqualTo(cfLogisticsVehicleQuery.getVehicleOwner());
        }
        if(cfLogisticsVehicleQuery.getVehicleType()!=null){
            criteria.andVehicleTypeEqualTo(cfLogisticsVehicleQuery.getVehicleType());
        }
        if(StringUtils.isNotEmpty(cfLogisticsVehicleQuery.getOrderBy())){
            cfLogisticsVehicleExample.setOrderByClause(cfLogisticsVehicleQuery.getOrderBy());
        }
        if(cfLogisticsVehicleQuery.getPage()!=null && cfLogisticsVehicleQuery.getSize()!=null){
            PageHelper.startPage(cfLogisticsVehicleQuery.getPage(), cfLogisticsVehicleQuery.getSize());
        }
        return cfLogisticsVehicleExample;
    }

    @Override
    public List<CfLogisticsVehicle> getListByQuery(CfLogisticsVehicleQuery cfLogisticsVehicleQuery) {
        return cfLogisticsVehicleMapper.selectByExample(getExampleByQuer(cfLogisticsVehicleQuery));
    }

    @Override
    public Integer countByQuery(CfLogisticsVehicleQuery cfLogisticsVehicleQuery) {
        cfLogisticsVehicleQuery.setPage(null);
        cfLogisticsVehicleQuery.setOrderBy(null);
        return cfLogisticsVehicleMapper.countByExample(getExampleByQuer(cfLogisticsVehicleQuery));
    }

    @Override
    public List<CfLogisticsVehicle> synchronizeTmsVehicle() throws Exception {
        if(StringUtils.isEmpty(tmsUrl)){
            return null;
        }
        List<CfLogisticsVehicle> cfLogisticsVehicleList = new ArrayList<>();
        JSONObject vehicleList = HttpClient.doGet(tmsUrl+"/interface/adapter/interface_paidui_truck");
        if(vehicleList!=null && vehicleList.containsKey("messageType") && vehicleList.get("data")!=null){
            Object[] data = ((JSONArray) vehicleList.get("data")).stream().toArray();
            List<JSONObject> dataList = new ArrayList<>();
            HashMap<String, String> requestHeaders = new HashMap<>();
            requestHeaders.put("Content-Type","application/json;charset=UTF-8");
            CfLogisticsVehicleQuery cfLogisticsVehicleQuery = new CfLogisticsVehicleQuery();

            for(int i=0; i<data.length; i++){
                //限制单次同步数据为30条
                if(i>30){
                    break;
                }
                CfLogisticsVehicle cfLogisticsVehicle = new CfLogisticsVehicle();
                JSONObject params = new JSONObject();
                JSONObject jsonObject = (JSONObject) data[i];
                cfLogisticsVehicle.setNumberPlate(jsonObject.getString("vehicleName"));
                String owner = jsonObject.getString("owner");
                if(owner!=null && owner.length()>20){
                    owner = owner.substring(0, 20);
                }else{
                    owner = "";
                }
                cfLogisticsVehicle.setVehicleOwner(owner);
                cfLogisticsVehicle.setVehicleType(jsonObject.getString("truckType"));
                cfLogisticsVehicle.setVehicleVin(jsonObject.getString("vin"));
                cfLogisticsVehicle.setVehicleSize(jsonObject.getString("size"));
                cfLogisticsVehicle.setApprovedLoad(new Double((new Double(jsonObject.getString("loadWeight"))).doubleValue()*1000000).intValue());
                String truckPlateColour = jsonObject.getString("truckPlateColour");
                switch (truckPlateColour){
                    case "蓝色":
                        cfLogisticsVehicle.setNumberPlateColor((byte)1);
                        break;
                    case "黄色":
                        cfLogisticsVehicle.setNumberPlateColor((byte)2);
                        break;
                    case "白色":
                        cfLogisticsVehicle.setNumberPlateColor((byte)3);
                        break;
                    case "黑色":
                        cfLogisticsVehicle.setNumberPlateColor((byte)4);
                        break;
                    case "绿色":
                        cfLogisticsVehicle.setNumberPlateColor((byte)5);
                        break;
                    default:
                        cfLogisticsVehicle.setNumberPlateColor((byte)0);
                }
                cfLogisticsVehicle.setRoadTransportCertificateNumber(jsonObject.getString("roadTransportCertificate"));
                cfLogisticsVehicle.setOperatingLicenseNumber(jsonObject.getString("certificate"));

                //判断是否存在重复的车牌号
                cfLogisticsVehicleQuery.setNumberPlate(cfLogisticsVehicle.getNumberPlate());
                Integer integer = countByQuery(cfLogisticsVehicleQuery);
                if(integer>0){
                    update(cfLogisticsVehicle);
                }else{
                    add(cfLogisticsVehicle);
                }
                cfLogisticsVehicleList.add(cfLogisticsVehicle);

                params.put("vehicleName",cfLogisticsVehicle.getNumberPlate());
                params.put("success","true");
                dataList.add(params);
            }
            if(dataList.size()>0){
                JSONObject[] paramsList = new JSONObject[dataList.size()];
                int i = 0;
                for(JSONObject params: dataList){
                    paramsList[i] = params;
                    i++;
                }
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("data",paramsList);
                updateTMSData(jsonObject, requestHeaders);
            }
        }
        return cfLogisticsVehicleList;
    }

    /**
     * 告诉TMS系统指定数据已更新
     */
    private void updateTMSData(JSONObject paramsObject, HashMap<String, String> requestHeaders) throws Exception{
        if(StringUtils.isEmpty(tmsUrl)){
            return;
        }
        JSONObject updateResult = (JSONObject)HttpClient.doPostByString(paramsObject.toJSONString(),tmsUrl+"/interface/adapter/paidui_update_truck",requestHeaders, true);
    };
}
