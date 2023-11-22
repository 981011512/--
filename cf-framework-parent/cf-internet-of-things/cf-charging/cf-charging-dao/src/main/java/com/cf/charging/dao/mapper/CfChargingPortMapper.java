package com.cf.charging.dao.mapper;

import com.cf.charging.domain.CfChargingPort;
import com.cf.charging.domain.CfChargingPortExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfChargingPortMapper {
    int countByExample(CfChargingPortExample example);

    int deleteByExample(CfChargingPortExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfChargingPort record);

    int insertSelective(CfChargingPort record);

    List<CfChargingPort> selectByExample(CfChargingPortExample example);

    CfChargingPort selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfChargingPort record, @Param("example") CfChargingPortExample example);

    int updateByExample(@Param("record") CfChargingPort record, @Param("example") CfChargingPortExample example);

    int updateByPrimaryKeySelective(CfChargingPort record);

    int updateByPrimaryKey(CfChargingPort record);
}