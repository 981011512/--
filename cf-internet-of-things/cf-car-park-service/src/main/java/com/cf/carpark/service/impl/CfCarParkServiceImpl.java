package com.cf.carpark.service.impl;

import com.cf.carpark.dao.mapper.CfCarParkMapper;
import com.cf.carpark.domain.CfCarPark;
import com.cf.carpark.request.CfCarParkForm;
import com.cf.carpark.service.CfCarParkService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.utils.IdWorker;
import io.swagger.models.auth.In;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 请在此填写描述
 *
 * @ClassName CfCarParkServiceImpl
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/3/14/014 9:28
 * @Version 1.0
 **/
@Service(version = "1.0.0")
@Transactional
public class CfCarParkServiceImpl implements CfCarParkService {
    @Autowired
    private CfCarParkMapper cfCarParkMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public CfCarPark add(CfCarPark cfCarPark) {
        cfCarPark.setId(idWorker.nextId());
        cfCarParkMapper.insert(cfCarPark);
        return cfCarPark;
    }

    @Override
    public Integer delete(String id) {
        return null;
    }

    @Override
    public CfCarPark update(CfCarPark cfCarPark) {
        cfCarParkMapper.updateByPrimaryKeySelective(cfCarPark);
        return cfCarPark;
    }

    @Override
    public CfCarPark findById(String id) {
        CfCarPark cfCarPark = cfCarParkMapper.selectByPrimaryKey(id);
        return cfCarPark;
    }

    @Override
    public List<CfCarPark> selectListByCondition(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds) {
        String sql = "SELECT cp.* FROM cf_car_park cp";
        int counts = 0;

        for (String field: allowFileds){
            if(conditions.containsKey(field)){
                String key = field;
                Map<String, Object> conditionValue = conditions.get(key);
                String andStr = counts == 0 ? " WHERE " : " AND ";
                counts++;

                if(conditionValue.get("operator").equals("=") || conditionValue.get("operator").equals(">") || conditionValue.get("operator").equals(">=")
                        || conditionValue.get("operator").equals("<") || conditionValue.get("operator").equals("<=") || conditionValue.get("operator").equals("!=")){
                    if(conditionValue.get("value") instanceof Integer){
                        sql += andStr+allowFiledsMap.get(key)+"."+key+conditionValue.get("operator")+conditionValue.get("value");
                    }else{
                        sql += andStr+allowFiledsMap.get(key)+"."+key+conditionValue.get("operator")+"'"+conditionValue.get("value")+"'";
                    }
                }else if(conditionValue.get("operator").equals("between")){
                    sql += andStr+allowFiledsMap.get(key)+"."+key+">="+(Integer)conditionValue.get("min")+
                            " AND "+allowFiledsMap.get(key)+"."+key+"<="+(Integer)conditionValue.get("max");
                }else if(conditionValue.get("operator").equals("like")){
                    Map<String, Object> likeList = (Map<String, Object>) conditionValue.get("list");
                    for(Map.Entry<String, Object> entry: likeList.entrySet()){
                        String entryKey = entry.getKey();
                        if(allowFiledsMap.containsKey(entryKey)){
                            int likeCounts = 0;
                            Map<String, Object> likeItems = (Map<String, Object>) entry.getValue();
                            for(Map.Entry<String, Object> likeItemsEntry: likeItems.entrySet()){
                                Map<String,String> likeItemsEntryValue = (Map<String,String>)likeItemsEntry.getValue();
                                if(likeCounts==0) {
                                    sql += andStr+"(" + likeItemsEntryValue.get("alias") + "." + entryKey + " LIKE '%" + likeItemsEntryValue.get("value")+"%'";
                                }else{
                                    sql += " OR " + likeItemsEntryValue.get("alias") + "." + entryKey + " LIKE '%" + likeItemsEntryValue.get("value")+"%'";
                                }
                                likeCounts++;
                            }
                            if(likeCounts>0){
                                sql += ") ";
                            }
                        }
                    }
                }else if(conditionValue.get("operator").equals("order")){
                    Map<String, Object> orderList = (Map<String, Object>) conditionValue.get("list");
                    int orderCounts = 0;
                    for(Map.Entry<String, Object> entry: orderList.entrySet()){
                        if(allowFiledsMap.containsKey(entry.getKey())){
                            Map<String, String> orderItem = (Map<String, String>) entry.getValue();
                            if((((String)orderItem.get("type")).toLowerCase().equals("asc")
                                    || ((String)orderItem.get("type")).toLowerCase().equals("desc"))
                            && allowFiledsMap.containsValue((String)orderItem.get("alias"))){
                                if(orderCounts==0) {
                                    sql += " ORDER BY " + orderItem.get("alias") + "." + entry.getKey() + " " + orderItem.get("type");
                                }else{
                                    sql += "," + orderItem.get("alias") + "." + entry.getKey() + " " + orderItem.get("type");
                                }
                                orderCounts++;
                            }
                        }
                    }
                }else if(conditionValue.get("operator").equals("limit")
                        && conditionValue.get("page")!=null && conditionValue.get("page") instanceof Integer
                        && conditionValue.get("limit")!=null && conditionValue.get("limit") instanceof Integer){
                    sql += " LIMIT "+(((Integer)conditionValue.get("page")-1)*(Integer)conditionValue.get("limit"))+","+(Integer)conditionValue.get("limit");
                }
            }
        }
        return cfCarParkMapper.selectListByCondition(sql);
    }
}
