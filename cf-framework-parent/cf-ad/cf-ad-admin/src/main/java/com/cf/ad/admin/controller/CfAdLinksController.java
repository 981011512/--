package com.cf.ad.admin.controller;

import com.cf.ad.admin.swagger.CfAdLinkersSwagger;
import com.cf.ad.domain.CfAdLinks;
import com.cf.ad.domain.request.CfAdLinksForm;
import com.cf.ad.domain.request.CfAdLinksQuery;
import com.cf.ad.service.CfAdLinksService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.utils.Snowflake;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @ClassName CfCarParkUseLogController
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/4/28/028 8:55
 * @Version 1.0
 **/
@RestController
@RequestMapping("adlinksAdmin/")
@Validated
public class CfAdLinksController implements CfAdLinkersSwagger {
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfAdLinksService cfAdLinksService;

    private static Logger logger = LoggerFactory.getLogger(Snowflake.class);

    @PreAuthorize("hasAuthority('ad-CfAdLinksController-getListByQuery')")
    @Override
    @RequestMapping(value = "getListByQuery", method = RequestMethod.GET)
    public ResponseResult getListByQuery(CfAdLinksQuery cfAdLinksQuery) throws Exception {
        List<CfAdLinks> cfAdLinks = cfAdLinksService.getListByQuery(cfAdLinksQuery);
        if(cfAdLinks==null || cfAdLinks.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        Integer integer = cfAdLinksService.countByQuery(cfAdLinksQuery);
        return new ResponseResult(CommonCode.SUCCESS, cfAdLinks, integer);
    }

    @PreAuthorize("hasAuthority('ad-CfAdLinksController-add')")
    @Override
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseResult add(@RequestBody CfAdLinksForm cfAdLinksForm) throws Exception {
        CfAdLinks cfAdLinks = new CfAdLinks();
        BeanUtils.copyProperties(cfAdLinksForm, cfAdLinks);
        Integer add = cfAdLinksService.add(cfAdLinks);
        return add>0 ? new ResponseResult(CommonCode.SUCCESS, null, add) : new ResponseResult(CommonCode.FAIL);
    }
}
