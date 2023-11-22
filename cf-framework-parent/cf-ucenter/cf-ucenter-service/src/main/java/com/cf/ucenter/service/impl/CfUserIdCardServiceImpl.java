package com.cf.ucenter.service.impl;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.ucenter.response.UcenterCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.IdWorker;
import com.cf.ucenter.dao.mapper.CfUserIdCardMapper;
import com.cf.ucenter.domain.CfUser;
import com.cf.ucenter.domain.CfUserIdCard;
import com.cf.ucenter.domain.CfUserIdCardExample;
import com.cf.ucenter.request.CfUserIdCardQuery;
import com.cf.ucenter.service.CfUserIdCardService;
import com.cf.ucenter.service.CfUserService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0", loadbalance = "roundrobin")
@Transactional
public class CfUserIdCardServiceImpl implements CfUserIdCardService {

    @Autowired
    private CfUserIdCardMapper cfUserIdCardMapper;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CfUserService cfUserService;

    @Override
    public CfUserIdCard add(CfUserIdCard cfUserIdCard) {
        checkRepeatByLicenseNumber(cfUserIdCard);
        cfUserIdCard.setId(idWorker.nextLongId());
        cfUserIdCardMapper.insertSelective(cfUserIdCard);
        //修改用户证件证件上传状态
        if(StringUtils.isNotEmpty(cfUserIdCard.getUid())){
            CfUser cfUser = new CfUser();
            cfUser.setId(cfUserIdCard.getUid());
            cfUser.setIdCardStatus((byte)1);
            cfUserService.updateByPrimaryKeySelective(cfUser);
        }

        return cfUserIdCard;
    }

    @Override
    public CfUserIdCard update(CfUserIdCard cfUserIdCard) {
        checkRepeatByLicenseNumber(cfUserIdCard);
        cfUserIdCardMapper.updateByPrimaryKeySelective(cfUserIdCard);
        //修改用户证件证件上传状态
        if(StringUtils.isNotEmpty(cfUserIdCard.getUid())){
            CfUser cfUser = new CfUser();
            cfUser.setId(cfUserIdCard.getUid());
            if(cfUserIdCard.getCheckStatus()!=null && cfUserIdCard.getCheckStatus()==(byte)1){
                cfUser.setIdCardStatus((byte)2);
            }else{
                cfUser.setIdCardStatus((byte)1);
            }
            cfUserService.updateByPrimaryKeySelective(cfUser);
        }
        return cfUserIdCard;
    }

    @Override
    public Integer delete(Long id) {
        return cfUserIdCardMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CfUserIdCard findById(Long id) {
        return cfUserIdCardMapper.selectByPrimaryKey(id);
    }

    @Override
    public CfUserIdCard findById(Long id, boolean expectEmpty) {
        CfUserIdCard cfUserIdCard = findById(id);
        if(expectEmpty && cfUserIdCard!=null){
            ExceptionCast.cast(CommonCode.DUPLICATE_DATA);
        }
        if(!expectEmpty && cfUserIdCard==null){
            ExceptionCast.cast(CommonCode.NO_MORE_DATAS);
        }
        return cfUserIdCard;
    }

    @Override
    public List<CfUserIdCard> getListByQuery(CfUserIdCardQuery cfUserIdCardQuery) {
        return cfUserIdCardMapper.selectByExample(getExampleByQuery(cfUserIdCardQuery));
    }

    @Override
    public Integer countByQuery(CfUserIdCardQuery cfUserIdCardQuery) {
        cfUserIdCardQuery.setPage(null);
        return cfUserIdCardMapper.countByExample(getExampleByQuery(cfUserIdCardQuery));
    }

    @Override
    public void checkRepeatByLicenseNumber(CfUserIdCard cfUserIdCard) {
        if(StringUtils.isEmpty(cfUserIdCard.getIdentityNumber())){
            return;
        }
        CfUserIdCardQuery cfUserIdCardQuery = new CfUserIdCardQuery();
        cfUserIdCardQuery.setIdentityNumber(cfUserIdCard.getIdentityNumber());
        List<CfUserIdCard> cfUserIdCardList = getListByQuery(cfUserIdCardQuery);
        if((cfUserIdCard.getId()==null && cfUserIdCardList!=null && cfUserIdCardList.size()>0) || (cfUserIdCard.getId()!=null && cfUserIdCardList!=null && cfUserIdCardList.size()>0 && cfUserIdCard.getId()!=cfUserIdCardList.get(0).getId())){
            ExceptionCast.cast(UcenterCode.ID_NUMBER_IS_BOUND);
        }
    }

    @Override
    public CfUserIdCardExample getExampleByQuery(CfUserIdCardQuery cfUserIdCardQuery) {
        CfUserIdCardExample cfUserIdCardExample = new CfUserIdCardExample();
        CfUserIdCardExample.Criteria criteria = cfUserIdCardExample.createCriteria();
        if(cfUserIdCardQuery.getUid()!=null){
            criteria.andUidEqualTo(cfUserIdCardQuery.getUid());
        }
        if(cfUserIdCardQuery.getCheckStatus()!=null){
            criteria.andCheckStatusEqualTo(cfUserIdCardQuery.getCheckStatus());
        }
        if(StringUtils.isNotEmpty(cfUserIdCardQuery.getOrderBy())){
            cfUserIdCardExample.setOrderByClause(cfUserIdCardQuery.getOrderBy());
        }
        if(cfUserIdCardQuery.getPage()!=null && cfUserIdCardQuery.getSize()!=null){
            PageHelper.startPage(cfUserIdCardQuery.getPage(), cfUserIdCardQuery.getSize());
        }
        return cfUserIdCardExample;
    }
}
