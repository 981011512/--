package com.cf.pay.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.cf.framework.utils.Snowflake;
import com.cf.pay.api.swagger.PayNotifySwagger;
import com.cf.pay.service.AlipayService;
import com.cf.pay.service.WxPayService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 支付通知
 *
 * @ClassName PayNotifyController
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/6/2/002 7:51
 * @Version 1.0
 **/
@RestController
@RequestMapping("payNotify/")
public class PayNotifyController implements PayNotifySwagger {

    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private WxPayService wxPayService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private AlipayService alipayService;

    private static Logger logger = LoggerFactory.getLogger(Snowflake.class);

    @Override
    @RequestMapping(value = "AliPayNotify")
    public String AliPayNotify(HttpServletRequest request) throws Exception {
        //获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        boolean rsaCertCheck = alipayService.rsaCertCheck(params);
        return rsaCertCheck ? "success" : "fail";
    }

    @Override
    @RequestMapping(value = "WxinPayNotify")
    public String WxinPayNotify(HttpServletRequest httpServletRequest) throws Exception{
        InputStream is = null;
        String xmlBack = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[报文为空]]></return_msg></xml> ";
        StringBuilder sb = null;
        try {
            is = httpServletRequest.getInputStream();
            // 将InputStream转换成String
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            xmlBack = wxPayService.notify(sb.toString());
        } catch (Exception e) {
            logger.error("wei_xin_callback_data:"+sb.toString());
            throw e;
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return xmlBack;
    }

    @Override
    @RequestMapping(value = "yiShengPayNotify")
    public String yiShengPayNotify(HttpServletRequest httpServletRequest) throws Exception {

        Map<String, String> allRequestParam = getAllRequestParam(httpServletRequest);

        String notice = null;
        for ( Map.Entry<String, String> entry: allRequestParam.entrySet()){
            notice = entry.getKey();
            break;
        }
        return wxPayService.yiShengNotify(notice);
    }

    @Override
    @RequestMapping(value = "duoLaBaoPayNotify")
    public String duoLaBaoPayNotify(HttpServletRequest httpServletRequest) throws Exception {
        Map<String, String> allRequestParam = getAllRequestParam(httpServletRequest);
        if(StringUtils.isNotEmpty(httpServletRequest.getHeader("timestamp"))){
            allRequestParam.put("timestamp",httpServletRequest.getHeader("timestamp"));
        }
        if(StringUtils.isNotEmpty(httpServletRequest.getHeader("token"))){
            allRequestParam.put("token",httpServletRequest.getHeader("token"));
        }
        return wxPayService.duoLaBaoNotify(allRequestParam);
    }

    private Map<String, String> getAllRequestParam(final HttpServletRequest request) throws Exception {
        Map res = new HashMap();
        Enumeration<?> temp = request.getParameterNames();
        if (null != temp && temp.hasMoreElements()) {
            while (temp.hasMoreElements()) {
                String en = (String) temp.nextElement();
                String value = request.getParameter(en);
                res.put(en, value);
            }
        }
        return res;
    }
}
