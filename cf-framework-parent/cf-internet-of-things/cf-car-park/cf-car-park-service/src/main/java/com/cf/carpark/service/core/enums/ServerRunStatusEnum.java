package com.cf.carpark.service.core.enums;

/**
 * 服务运行状态
 * @author gebilaowang
 * @date 2021/3/11 11:03
 */
public enum  ServerRunStatusEnum {
    // 已关闭
    CLOSE(0),
    // 运行中
    RUN_ING(1),
    // 关闭中，还有线程运行
    CLOSE_ING(2),
    ;
    public Integer STATUS;

    ServerRunStatusEnum(Integer status) {
        this.STATUS = status;
    }
}
