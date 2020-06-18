package com.cf.framework.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 请在此填写描述
 *
 * @ClassName HttpHearderUtils
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2019/12/21/021 15:11
 * @Version 1.0
 **/
public class HttpHearderUtils {

    /**
     * 取出请求头的Authorization数据
     * @param request
     * @return
     */
    public static String getAuthorization(HttpServletRequest request)
    {
        //取出头信息
        String authorization = request.getHeader("Authorization");
        if(StringUtils.isEmpty(authorization)){
            return null;
        }
        if(!authorization.startsWith("Bearer ")){
            return null;
        }
        //取到jwt令牌
        String jwt = authorization.substring(7);
        return jwt;
    }

}
