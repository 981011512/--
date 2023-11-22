package com.cf.ad.api.controller;

import com.cf.ad.api.swagger.CfAdSwagger;
import com.cf.ad.domain.CfAd;
import com.cf.ad.domain.request.CfAdQuery;
import com.cf.ad.service.CfAdService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.utils.Snowflake;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 *
 * @ClassName CfCarParkUseLogController
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/4/28/028 8:55
 * @Version 1.0
 **/
@RestController
@RequestMapping("ad/")
@Validated
public class CfAdController implements CfAdSwagger {
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfAdService cfAdService;
    @Autowired
    protected HttpServletRequest request;

    private static Logger logger = LoggerFactory.getLogger(Snowflake.class);

    @Override
    @RequestMapping(value = "findById", method = RequestMethod.GET)
    public ResponseResult findById(String id) throws Exception {
        if(id!=null){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        CfAdQuery cfAdQuery = new CfAdQuery();
        cfAdQuery.setId(id);
        List<CfAd> cfAdList = cfAdService.getListByQuery(cfAdQuery);
        if(cfAdList==null || cfAdList.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        return new ResponseResult(CommonCode.SUCCESS, cfAdList.get(0));
    }
}
