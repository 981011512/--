package com.cf.position.service.impl;

import com.cf.position.dao.mapper.CfAreasMapper;
import com.cf.position.domain.CfAreas;
import com.cf.position.domain.CfAreasExample;
import com.cf.position.service.CfAreasService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 地区管理
 *
 * @ClassName CfAreasServiceImpl
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/4/25/025 8:22
 * @Version 1.0
 **/
@Service(version = "1.0.0", loadbalance = "roundrobin")
public class CfAreasServiceImpl implements CfAreasService {
    @Autowired
    private CfAreasMapper cfAreasMapper;

    @Override
    public List<CfAreas> selectAll(Boolean recursive) {

        List<CfAreas> cfAreas = null;
        if(!recursive){
            CfAreasExample cfAreasExample = new CfAreasExample();
            cfAreas = cfAreasMapper.selectByExample(cfAreasExample);
        }else{
            int maxLevelType = cfAreasMapper.getMaxLevelType();
            cfAreas = selectByLevelAndParentId(0, "0", maxLevelType, true);
        }
        return cfAreas;
    }

    @Override
    public List<CfAreas> selectByLevelAndParentId(Integer level, String parentId, Integer maxLevel, boolean loop) {
        CfAreasExample cfAreasExample = new CfAreasExample();
        CfAreasExample.Criteria criteria = cfAreasExample.createCriteria();
        criteria.andLevelTypeEqualTo(level);
        if(StringUtils.isNotEmpty(parentId)){
            criteria.andParentIdEqualTo(parentId);
        }
        List<CfAreas> cfAreas = cfAreasMapper.selectByExample(cfAreasExample);
        if(loop && cfAreas!=null && cfAreas.size()>0 && cfAreas.get(0).getLevelType()<maxLevel){
            for (CfAreas cfArea: cfAreas){
                cfArea.setChildren(selectByLevelAndParentId(cfArea.getLevelType()+1, cfArea.getId(), maxLevel, loop));
            }
        }
        return cfAreas;
    }
}
