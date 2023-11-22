package com.cf.carpark.domain.type;

import java.io.Serializable;

/**
 * 停车费查询模式
 */
public class FeeQueryMode implements Serializable {
    public final static String QUERY_MODE_QUERY_ONLY = "query_only";   //只查询不更新订单
    public final static String QUERY_MODE_QUERY_AND_UPDATE = "query_and_update";   //查询且会更新停车记录和相关订单
}
