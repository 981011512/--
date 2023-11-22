package com.cf.ucenter.service.impl;

import com.cf.framework.utils.IdWorker;
import com.cf.ucenter.dao.mapper.CfAppVersionLogMapper;
import com.cf.ucenter.domain.CfAppVersionLog;
import com.cf.ucenter.domain.CfAppVersionLogExample;
import com.cf.ucenter.request.CfAppVersionLogQuery;
import com.cf.ucenter.service.CfAppVersionLogService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * app版本发行记录服务
 *
 * @ClassName CfAppVersionLogServiceImpl
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/12/11/011 23:06
 * @Version 1.0
 **/
@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfAppVersionLogServiceImpl implements CfAppVersionLogService {

    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CfAppVersionLogMapper cfAppVersionLogMapper;

    @Override
    public CfAppVersionLog checkVersion(String platform, String versionNumber) {
        CfAppVersionLogQuery cfAppVersionLogQuery = new CfAppVersionLogQuery();
        cfAppVersionLogQuery.setPlatform(platform);
        cfAppVersionLogQuery.setVersionNumber(versionNumber);
        List<CfAppVersionLog> cfAppVersionLogs = getListByQuery(cfAppVersionLogQuery);
        if(cfAppVersionLogs!=null && cfAppVersionLogs.size()>0){
            cfAppVersionLogQuery.setVersionNumber(null);
            cfAppVersionLogQuery.setMinPublishTime(cfAppVersionLogs.get(0).getPublishTime()+1);
            cfAppVersionLogQuery.setOrderBy("publish_time DESC");
            cfAppVersionLogQuery.setPage(1);
            cfAppVersionLogQuery.setSize(1);
            List<CfAppVersionLog> lastAppVersionLogs = getListByQuery(cfAppVersionLogQuery);
            CfAppVersionLog lastCfAppVersionLog = null;
            if(lastAppVersionLogs!=null && lastAppVersionLogs.size()>0){
                lastCfAppVersionLog = lastAppVersionLogs.get(0);
            }
            cfAppVersionLogQuery.setLevel((byte)2);
            Integer forceAppVersionLogCount = countByQuery(cfAppVersionLogQuery);
            if(forceAppVersionLogCount>0){
                //强制更新
                lastCfAppVersionLog.setLevel((byte)2);
                return lastCfAppVersionLog;
            }
            cfAppVersionLogQuery.setLevel((byte)1);
            Integer recommendAppVersionLogCount = countByQuery(cfAppVersionLogQuery);
            if(recommendAppVersionLogCount>0){
                //推荐更新
                lastCfAppVersionLog.setLevel((byte)1);
                return lastCfAppVersionLog;
            }
        }
        return null;
    }

    @Override
    public CfAppVersionLog add(CfAppVersionLog cfAppVersionLog) {
        cfAppVersionLog.setId(idWorker.nextId());
        cfAppVersionLog.setPublishTime(System.currentTimeMillis());
        cfAppVersionLogMapper.insert(cfAppVersionLog);
        return cfAppVersionLog;
    }

    @Override
    public CfAppVersionLog update(CfAppVersionLog cfAppVersionLog) {
        cfAppVersionLogMapper.updateByPrimaryKey(cfAppVersionLog);
        return cfAppVersionLog;
    }

    @Override
    public Integer delete(String id) {
        return cfAppVersionLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<CfAppVersionLog> getListByQuery(CfAppVersionLogQuery cfAppVersionLogQuery) {
        return cfAppVersionLogMapper.selectByExample(getExampleByQuery(cfAppVersionLogQuery));
    }

    @Override
    public Integer countByQuery(CfAppVersionLogQuery cfAppVersionLogQuery) {
        cfAppVersionLogQuery.setPage(null);
        return cfAppVersionLogMapper.countByExample(getExampleByQuery(cfAppVersionLogQuery));
    }

    @Override
    public CfAppVersionLogExample getExampleByQuery(CfAppVersionLogQuery cfAppVersionLogQuery) {
        CfAppVersionLogExample cfAppVersionLogExample = new CfAppVersionLogExample();
        CfAppVersionLogExample.Criteria criteria = cfAppVersionLogExample.createCriteria();
        if(StringUtils.isNoneEmpty(cfAppVersionLogQuery.getPlatform())){
            criteria.andPlatformEqualTo(cfAppVersionLogQuery.getPlatform());
        }
        if(StringUtils.isNoneEmpty(cfAppVersionLogQuery.getVersionNumber())){
            criteria.andVersionNumberEqualTo(cfAppVersionLogQuery.getVersionNumber());
        }
        if(cfAppVersionLogQuery.getLevel()!=null){
            criteria.andLevelEqualTo(cfAppVersionLogQuery.getLevel());
        }
        if(cfAppVersionLogQuery.getMinLevel()!=null){
            criteria.andLevelGreaterThanOrEqualTo(cfAppVersionLogQuery.getMinLevel());
        }
        if(cfAppVersionLogQuery.getMaxLevel()!=null){
            criteria.andLevelLessThanOrEqualTo(cfAppVersionLogQuery.getMaxLevel());
        }
        if(cfAppVersionLogQuery.getMinPublishTime()!=null){
            criteria.andPublishTimeGreaterThanOrEqualTo(cfAppVersionLogQuery.getMinPublishTime());
        }
        if(cfAppVersionLogQuery.getMaxPublishTime()!=null){
            criteria.andPublishTimeLessThanOrEqualTo(cfAppVersionLogQuery.getMaxPublishTime());
        }
        if(StringUtils.isNoneEmpty(cfAppVersionLogQuery.getOrderBy())){
            cfAppVersionLogExample.setOrderByClause(cfAppVersionLogQuery.getOrderBy());
        }
        if(cfAppVersionLogQuery.getPage()!=null && cfAppVersionLogQuery.getSize()!=null){
            PageHelper.startPage(cfAppVersionLogQuery.getPage(), cfAppVersionLogQuery.getSize());
        }
        return cfAppVersionLogExample;
    }
}
