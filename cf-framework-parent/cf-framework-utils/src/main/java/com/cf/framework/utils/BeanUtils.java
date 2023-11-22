package com.cf.framework.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义的Bean工具类
 *
 * @ClassName BeaUtils
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/1/001 20:10
 * @Version 1.0
 **/
public class BeanUtils {

    /**
     * 将Map转为Bean
     *
     * @param type
     * @param map
     * @param <T>
     * @return
     * @throws IntrospectionException    获取类属性异常
     * @throws IllegalAccessException    创建Bean对象异常
     * @throws InstantiationException    创建Bean对象异常
     * @throws InvocationTargetException 对象转换异常
     */
    public static <T> T deepMapToBean(Class<T> type, Map map) throws IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException {
        if(map==null){
            return null;
        }
        BeanInfo beanInfo = Introspector.getBeanInfo(type); // 获取类属性
        T bean = null;
        if(type.getName().equals("java.util.Map")){
            return (T)map;
        }else{
            bean = type.newInstance(); // 创建 JavaBean 对象
        }

        // 给 JavaBean 对象的属性赋值
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (int i = 0; i < propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();
            if (map.containsKey(propertyName) || map.containsKey(upperFirst(propertyName))) {
                if(map.containsKey(upperFirst(propertyName))){
                    descriptor.setName(upperFirst(propertyName));
                }
                Object value = map.get(descriptor.getName());
                if(value instanceof String || value instanceof Integer || value instanceof Long || value instanceof Byte || value instanceof Short || value instanceof Boolean){
                    Object[] args = new Object[1];
                    args[0] = value;
                    descriptor.getWriteMethod().invoke(bean, args);
                }else {
                    Class<?> propertyType = descriptor.getPropertyType();
                    Object o = BeanUtils.deepMapToBean(propertyType, (Map) value);
                    Object[] args = new Object[1];
                    args[0] = o;
                    descriptor.getWriteMethod().invoke(bean, args);
                }

            }
        }
        return bean;
    }

    public static String upperFirst(String oldStr){

        char[]chars = oldStr.toCharArray();

        chars[0] -= 32;

        return String.valueOf(chars);

    }

    /**
     * 对象转为Map
     * @param obj
     * @return
     * @throws Exception
     */
    public static Map<String, Object> objectToMap(Object obj) throws Exception {
        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo
                .getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();
            if (key.compareToIgnoreCase("class") == 0) {
                continue;
            }
            Method getter = property.getReadMethod();
            Object value = getter != null ? getter.invoke(obj) : null;
            map.put(key, value);
        }
        return map;
    }

}
