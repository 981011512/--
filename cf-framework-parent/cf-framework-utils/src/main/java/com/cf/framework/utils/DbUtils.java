package com.cf.framework.utils;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 数据库工具类
 *
 * @ClassName DbUtils
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/4/24/024 10:42
 * @Version 1.0
 **/
public class DbUtils {

    /**
     * 制作查询sql
     * @param conditions
     * @param allowFiledsMap
     * @param allowFileds
     * @param sql
     * @param count 是否是数据条数统计
     * @return
     */
    public static String makeQuery(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds, String sql, boolean count)
    {
        int counts = 0;

        for (String field: allowFileds){
            if(conditions.containsKey(field)){
                String key = field;
                Map<String, Object> conditionValue = conditions.get(key);
                String andStr = counts == 0 ? " WHERE " : conditionValue.get("operator").equals("or_and") ? " OR " : " AND ";
                counts++;

                if(conditionValue.get("operator").equals("is") || conditionValue.get("operator").equals("=") || conditionValue.get("operator").equals(">") || conditionValue.get("operator").equals(">=")
                        || conditionValue.get("operator").equals("<") || conditionValue.get("operator").equals("<=") || conditionValue.get("operator").equals("!=")){
                    if(!conditionValue.containsKey("or")){
                        if(conditionValue.get("value") instanceof Integer || conditionValue.get("value").equals("null")){
                            sql += andStr+" "+allowFiledsMap.get(key)+"."+key+" "+conditionValue.get("operator")+" "+conditionValue.get("value");
                        }else{
                            sql += andStr+allowFiledsMap.get(key)+"."+key+conditionValue.get("operator")+"'"+conditionValue.get("value").toString().replace("'","\\'")+"'";
                        }
                    }else{
                        if(conditionValue.get("value") instanceof Integer || conditionValue.get("value").equals("null")){
                            sql += andStr+" ("+allowFiledsMap.get(key)+"."+key+" "+conditionValue.get("operator")+" "+conditionValue.get("value");
                        }else{
                            sql += andStr+"("+allowFiledsMap.get(key)+"."+key+conditionValue.get("operator")+"'"+conditionValue.get("value").toString().replace("'","\\'")+"'";
                        }
                    }

                }else if(conditionValue.get("operator").equals("between")){
                    sql += andStr+allowFiledsMap.get(key)+"."+key+">="+(new BigDecimal(conditionValue.get("min")+"").doubleValue())+
                            " AND "+allowFiledsMap.get(key)+"."+key+"<="+(new BigDecimal(conditionValue.get("max")+"").doubleValue());
                }else if(conditionValue.get("operator").equals("in")){
                    sql += andStr+allowFiledsMap.get(key)+"."+key.substring(0,key.indexOf("$"))+" IN("+conditionValue.get("value")+")";
                }else if(conditionValue.get("operator").equals("or_eq")){
                    int orEQCounts = 0;
                    Map<String, Object> likeItems = (Map<String, Object>) conditionValue.get("value");
                    for(Map.Entry<String, Object> likeItemsEntry: likeItems.entrySet()){
                        String entryKey = likeItemsEntry.getKey();
                        Object orEQItemsEntryValue = likeItemsEntry.getValue();
                        if(orEQCounts==0) {
                            sql += andStr+"("  + entryKey + " = '" + orEQItemsEntryValue.toString().replace("'","\\'")+"'";
                        }else{
                            sql += " OR " + entryKey + " = '" + orEQItemsEntryValue.toString().replace("'","\\'")+"'";
                        }
                        orEQCounts++;
                    }
                    if(orEQCounts>0){
                        sql += ") ";
                    }
                }else if(conditionValue.get("operator").equals("or_and")){
                    int orEQCounts = 0;
                    Map<String, Object> likeItems = (Map<String, Object>) conditionValue.get("value");
                    for(Map.Entry<String, Object> likeItemsEntry: likeItems.entrySet()){

                        String entryKey = likeItemsEntry.getKey();
                        Map<String, String> orEQItemsEntryValue = (Map<String, String>)likeItemsEntry.getValue();
                        if(orEQCounts==0) {
                            sql += andStr+"("  + orEQItemsEntryValue.get("alias")+ "." + entryKey + orEQItemsEntryValue.get("operator") +" '" + orEQItemsEntryValue.get("value").toString().replace("'","\\'")+"'";
                        }else{
                            sql += " AND " + orEQItemsEntryValue.get("alias")+ "." + entryKey + orEQItemsEntryValue.get("operator") +" '" + orEQItemsEntryValue.get("value").toString().replace("'","\\'")+"'";
                        }
                        orEQCounts++;
                    }
                    if(orEQCounts>0){
                        sql += ") ";
                    }
                    if(conditionValue.containsKey("and")){
                        sql += ") ";
                    }
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
                                    sql += andStr+"(" + likeItemsEntryValue.get("alias") + "." + entryKey + " LIKE '" + likeItemsEntryValue.get("value").toString().replace("'","\\'")+"%'";
                                }else{
                                    sql += " OR " + likeItemsEntryValue.get("alias") + "." + entryKey + " LIKE '" + likeItemsEntryValue.get("value").toString().replace("'","\\'")+"%'";
                                }
                                likeCounts++;
                            }
                            if(likeCounts>0){
                                sql += ") ";
                            }
                        }
                    }
                }else if(conditionValue.get("operator").equals("group")){
                    sql += " GROUP BY "+conditionValue.get("alias")+"."+conditionValue.get("field");
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
                }else if(!count && conditionValue.get("operator").equals("limit")
                        && conditionValue.get("page")!=null && conditionValue.get("page") instanceof Integer
                        && conditionValue.get("limit")!=null && conditionValue.get("limit") instanceof Integer){
                    sql += " LIMIT "+(((Integer)conditionValue.get("page")-1)*(Integer)conditionValue.get("limit"))+","+(Integer)conditionValue.get("limit");
                }
            }
        }
        return sql;
    }

    /**
     * 制作制作orderBy，防止sql注入
     * @param allowOrderBy
     * @param sourceOrderBy
     * @return
     */
    public static String makeAllowOrderBy(List<String> allowOrderBy, String sourceOrderBy){
        if(allowOrderBy==null || allowOrderBy.size()==0 || StringUtils.isEmpty(sourceOrderBy)){
            return sourceOrderBy;
        }
        String[] orderByList = sourceOrderBy.split(",");
        String returnString = "";
        int length = orderByList.length;
        for(int i=0; i<length; i++){
            if(allowOrderBy.contains(orderByList[i])){
                returnString += ","+orderByList[i];
            }
        }
        if(StringUtils.isNotEmpty(returnString)){
            returnString = returnString.substring(1);
        }
        return StringUtils.isEmpty(returnString) ? null : returnString;
    }
}
