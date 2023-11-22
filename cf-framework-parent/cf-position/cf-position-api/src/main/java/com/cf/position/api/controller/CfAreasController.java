package com.cf.position.api.controller;

import com.cf.position.domain.CfAreas;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.position.api.swagger.CfAreasSwagger;
import com.cf.position.service.CfAreasService;
import com.cf.ucenter.service.AuthService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("areas/")
@Validated
public class CfAreasController implements CfAreasSwagger {
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private CfAreasService cfAreasService;
    @Reference(version = "1.0.0", retries = 0, timeout = 5000, check = false)
    private AuthService authService;

    @Override
    @RequestMapping(value = "selectAll", method = RequestMethod.GET)
    public ResponseResult selectAll() {
        List<CfAreas> cfAreas = cfAreasService.selectAll(true);
        if(cfAreas!=null){
            return new ResponseResult(CommonCode.SUCCESS, cfAreas);
        }
        return new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    @Override
    @RequestMapping(value = "selectByLevelAndParentId", method = RequestMethod.GET)
    public ResponseResult selectByLevelAndParentId(Integer level, String parentId) {
        List<CfAreas> cfAreas = cfAreasService.selectByLevelAndParentId(level, parentId, 0, false);
        if(cfAreas!=null){
            return new ResponseResult(CommonCode.SUCCESS, cfAreas);
        }
        return new ResponseResult(CommonCode.NO_MORE_DATAS);
    }
}
