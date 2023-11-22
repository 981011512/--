package com.cf.charging.service.impl;

import com.cf.charging.dao.mapper.CfChargingStationDeviceMapper;
import com.cf.charging.domain.CfChargingStationDevice;
import com.cf.charging.domain.CfChargingStationDeviceExample;
import com.cf.charging.domain.request.CfChargingStationDeviceQuery;
import com.cf.charging.service.CfChargingStationDeviceService;
import com.cf.framework.domain.charging.response.ChargingCode;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.IdWorker;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfChargingStationDeviceServiceImpl implements CfChargingStationDeviceService {

    @Autowired
    private CfChargingStationDeviceMapper cfChargingStationDeviceMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public CfChargingStationDevice add(CfChargingStationDevice cfChargingStationDevice) {
        cfChargingStationDevice.setId(idWorker.nextId());
        cfChargingStationDeviceMapper.insertSelective(cfChargingStationDevice);
        return cfChargingStationDevice;
    }

    @Override
    public CfChargingStationDevice update(CfChargingStationDevice cfChargingStationDevice) {
        cfChargingStationDeviceMapper.updateByPrimaryKeySelective(cfChargingStationDevice);
        return cfChargingStationDevice;
    }

    @Override
    public Integer delete(String id) {
        return cfChargingStationDeviceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CfChargingStationDevice findById(String id) {
        return cfChargingStationDeviceMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfChargingStationDevice findById(String id, boolean expectEmpty) {
        CfChargingStationDevice cfChargingStationDevice = findById(id);
        if(expectEmpty && cfChargingStationDevice!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }else if(!expectEmpty && cfChargingStationDevice==null){
            ExceptionCast.cast(ChargingCode.BIND_LICENSE_PLATES_REPEATEDLY);
        }
        return cfChargingStationDevice;
    }

    @Override
    public CfChargingStationDeviceExample getExampleByQuery(CfChargingStationDeviceQuery cfChargingStationDeviceQuery) {
        CfChargingStationDeviceExample cfChargingStationDeviceExample = new CfChargingStationDeviceExample();
        CfChargingStationDeviceExample.Criteria criteria = cfChargingStationDeviceExample.createCriteria();

        if(cfChargingStationDeviceQuery.getId()!=null){
            criteria.andIdEqualTo(cfChargingStationDeviceQuery.getId());
        }
        if(cfChargingStationDeviceQuery.getIds()!=null && cfChargingStationDeviceQuery.getIds().size()>0){
            criteria.andIdIn(cfChargingStationDeviceQuery.getIds());
        }
        if(cfChargingStationDeviceQuery.getChargingStationId()!=null){
            criteria.andChargingStationIdEqualTo(cfChargingStationDeviceQuery.getChargingStationId());
        }
        if(cfChargingStationDeviceQuery.getBarCode()!=null){
            criteria.andBarCodeEqualTo(cfChargingStationDeviceQuery.getBarCode());
        }
        if(cfChargingStationDeviceQuery.getBarCodes()!=null && cfChargingStationDeviceQuery.getBarCodes().size()>0){
            criteria.andBarCodeIn(cfChargingStationDeviceQuery.getBarCodes());
        }
        if(cfChargingStationDeviceQuery.getNoticed()!=null){
            criteria.andNoticedEqualTo(cfChargingStationDeviceQuery.getNoticed());
        }
        if(cfChargingStationDeviceQuery.getModel()!=null){
            criteria.andModelEqualTo(cfChargingStationDeviceQuery.getModel());
        }
        if(cfChargingStationDeviceQuery.getBrand()!=null){
            criteria.andBrandEqualTo(cfChargingStationDeviceQuery.getBrand());
        }
        if(cfChargingStationDeviceQuery.getStatus()!=null){
            criteria.andStatusEqualTo(cfChargingStationDeviceQuery.getStatus());
        }
        if(cfChargingStationDeviceQuery.getMinLastOnlineTime()!=null){
            criteria.andLastOnlineTimeGreaterThanOrEqualTo(cfChargingStationDeviceQuery.getMinLastOnlineTime());
        }
        if(cfChargingStationDeviceQuery.getMaxLastOnlineTime()!=null){
            criteria.andLastOnlineTimeLessThanOrEqualTo(cfChargingStationDeviceQuery.getMaxLastOnlineTime());
        }
        if(StringUtils.isNotEmpty(cfChargingStationDeviceQuery.getLinkMode())){
            criteria.andLinkModeEqualTo(cfChargingStationDeviceQuery.getLinkMode());
        }
        if(cfChargingStationDeviceQuery.getType()!=null){
            criteria.andTypeEqualTo(cfChargingStationDeviceQuery.getType());
        }
        if(StringUtils.isNotEmpty(cfChargingStationDeviceQuery.getCheckpointId())){
            criteria.andCheckpointIdEqualTo(cfChargingStationDeviceQuery.getCheckpointId());
        }
        if(StringUtils.isNotEmpty(cfChargingStationDeviceQuery.getProductId())){
            criteria.andProductIdEqualTo(cfChargingStationDeviceQuery.getProductId());
        }
        if(cfChargingStationDeviceQuery.getUsername()!=null){
            criteria.andUsernameEqualTo(cfChargingStationDeviceQuery.getUsername());
        }
        if(cfChargingStationDeviceQuery.getPassword()!=null){
            criteria.andPasswordEqualTo(cfChargingStationDeviceQuery.getPassword());
        }
        if(cfChargingStationDeviceQuery.getMacAddress()!=null){
            criteria.andMacAddressEqualTo(cfChargingStationDeviceQuery.getMacAddress());
        }
        
        if(StringUtils.isNotEmpty(cfChargingStationDeviceQuery.getOrderBy())){
            cfChargingStationDeviceExample.setOrderByClause(cfChargingStationDeviceQuery.getOrderBy());
        }
        if(cfChargingStationDeviceQuery.getPage()!=null && cfChargingStationDeviceQuery.getSize()!=null){
            PageHelper.startPage(cfChargingStationDeviceQuery.getPage(), cfChargingStationDeviceQuery.getSize());
        }
        
        return cfChargingStationDeviceExample;
    }

    @Override
    public List<CfChargingStationDevice> getListByQuery(CfChargingStationDeviceQuery cfChargingStationDeviceQuery) {
        return cfChargingStationDeviceMapper.selectByExample(getExampleByQuery(cfChargingStationDeviceQuery));
    }

    @Override
    public Integer countByQuery(CfChargingStationDeviceQuery cfChargingStationDeviceQuery) {
        cfChargingStationDeviceQuery.setPage(null);
        return cfChargingStationDeviceMapper.countByExample(getExampleByQuery(cfChargingStationDeviceQuery));
    }
}
