package com.cf.sms.dao.mapper;

import com.cf.sms.domain.CfSms;
import com.cf.sms.domain.CfSmsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfSmsMapper {
    int countByExample(CfSmsExample example);

    int deleteByExample(CfSmsExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfSms record);

    int insertSelective(CfSms record);

    List<CfSms> selectByExample(CfSmsExample example);

    CfSms selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfSms record, @Param("example") CfSmsExample example);

    int updateByExample(@Param("record") CfSms record, @Param("example") CfSmsExample example);

    int updateByPrimaryKeySelective(CfSms record);

    int updateByPrimaryKey(CfSms record);

    List<CfSms> getLastSendLog(@Param("phone")String phone,@Param("type") Integer type);

    List<CfSms> getLastValidSmsCode(@Param("phone") String phone,@Param("code") String code,
                                      @Param("type") Integer type,@Param("create_time") Long createTime);

    int updateLastValidSmsCodeStatus(@Param("phone") String phone,@Param("code") String code,
                                     @Param("type") Integer type,@Param("create_time") Long createTime);
}