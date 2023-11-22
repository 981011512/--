package com.cf.ad.api.controller;

import com.cf.ad.api.swagger.CfAdLinkersSwagger;
import com.cf.ad.domain.CfAdLinks;
import com.cf.ad.domain.request.AdCounts;
import com.cf.ad.domain.request.CfAdLinksQuery;
import com.cf.ad.service.CfAdLinksService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.utils.FileUtils;
import com.cf.framework.utils.Snowflake;
import com.cf.ucenter.service.CfSystemConfigService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("adlinks/")
@Validated
public class CfAdLinksController implements CfAdLinkersSwagger {
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfAdLinksService cfAdLinksService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfSystemConfigService cfSystemConfigService;

    private static Logger logger = LoggerFactory.getLogger(Snowflake.class);

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

    @Override
    @RequestMapping(value = "selectContainAdByQuery", method = RequestMethod.GET)
    public ResponseResult selectContainAdByQuery(CfAdLinksQuery cfAdLinksQuery) throws Exception {
        List<CfAdLinks> cfAdLinks = cfAdLinksService.selectContainAdByQuery(cfAdLinksQuery);
        if(cfAdLinks==null || cfAdLinks.size()==0){
            return new ResponseResult(CommonCode.NO_MORE_DATAS);
        }
        Integer integer = cfAdLinksService.countByQuery(cfAdLinksQuery);

        String fileSourceAddress = cfSystemConfigService.getValueByKey("file_source_address", "http://file.cfeng.wang/");

        for (CfAdLinks adLinks: cfAdLinks){
            if(adLinks.getCfAd()!=null && StringUtils.isNotEmpty(adLinks.getCfAd().getCover())){
                FileUtils.handleFileSourcePrefix(adLinks.getCfAd(), fileSourceAddress, "cover");
            }
        }
        return new ResponseResult(CommonCode.SUCCESS, cfAdLinks, integer);
    }

    @Override
    @RequestMapping(value = "adCounts", method = RequestMethod.PUT)
    public ResponseResult adCounts(@RequestBody AdCounts adCounts) throws Exception {
        Integer integer = cfAdLinksService.adCounts(adCounts);
        return integer>0 ? new ResponseResult(CommonCode.SUCCESS, integer) : new ResponseResult(CommonCode.FAIL, integer);
    }
}
