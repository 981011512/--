package com.cf.carpark.service.core.server;

import com.cf.carpark.service.core.dto.InitParamDTO;

/**
 * @author gebilaowang
 * @date 2021/3/25 16:10
 */
public abstract class AbsServer implements IServer {
    // 服务器参数
    protected InitParamDTO initParamDTO;
}
