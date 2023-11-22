package com.cf.ucenter.service.impl;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.ucenter.response.UcenterCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.ucenter.dao.mapper.CfSystemConfigMapper;
import com.cf.ucenter.domain.CfSystemConfig;
import com.cf.ucenter.domain.CfSystemConfigExample;
import com.cf.ucenter.request.CfSystemConfigQuery;
import com.cf.ucenter.service.CfSystemConfigService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfSystemConfigServiceImpl implements CfSystemConfigService {

    @Autowired
    private CfSystemConfigMapper cfSystemConfigMapper;


    @Override
    public CfSystemConfig add(CfSystemConfig cfSystemConfig) {
        int insert = cfSystemConfigMapper.insert(cfSystemConfig);
        if(insert>0){
            return cfSystemConfig;
        }
        ExceptionCast.cast(CommonCode.FAIL);
        return null;
    }

    @Override
    public CfSystemConfig update(CfSystemConfig cfSystemConfig) {
        int update = cfSystemConfigMapper.updateByPrimaryKey(cfSystemConfig);
        if(update>0){
            return cfSystemConfig;
        }
        ExceptionCast.cast(CommonCode.FAIL);
        return null;
    }

    @Override
    public Integer delete(String enName) {
        int delete = cfSystemConfigMapper.deleteByPrimaryKey(enName);
        if(delete>0){
            ExceptionCast.cast(CommonCode.SUCCESS);
        }
        ExceptionCast.cast(CommonCode.FAIL);
        return null;
    }

    @Override
    public CfSystemConfigExample getExampleByQuery(CfSystemConfigQuery cfSystemConfigQuery) {
        CfSystemConfigExample cfSystemConfigExample = new CfSystemConfigExample();
        CfSystemConfigExample.Criteria criteria = cfSystemConfigExample.createCriteria();
        if(StringUtils.isNotEmpty(cfSystemConfigQuery.getEnName())){
            criteria.andEnNameEqualTo(cfSystemConfigQuery.getEnName());
        }
        return cfSystemConfigExample;
    }

    @Override
    public List<CfSystemConfig> getListByQuery(CfSystemConfigQuery cfSystemConfigQuery) {
        return cfSystemConfigMapper.selectByExample(getExampleByQuery(cfSystemConfigQuery));
    }

    @Override
    public Integer countByQuery(CfSystemConfigQuery cfSystemConfigQuery) {
        return cfSystemConfigMapper.countByExample(getExampleByQuery(cfSystemConfigQuery));
    }

    @Override
    public String getValueByKey(String configKey, String defaultValue) {
        String value = defaultValue;

        CfSystemConfigQuery cfSystemConfigQuery = new CfSystemConfigQuery();
        cfSystemConfigQuery.setEnName(configKey);
        List<CfSystemConfig> cfSystemConfigs = getListByQuery(cfSystemConfigQuery);
        if(cfSystemConfigs!=null && cfSystemConfigs.size()>0){
            value = cfSystemConfigs.get(0).getValue();
        }
        return value;
    }
}
