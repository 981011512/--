package com.cf.carpark.domain.type;

import java.io.Serializable;

/**
 * 停车场放行方式
 *
 * @ClassName ReleaseType
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/3/003 16:37
 * @Version 1.0
 **/
public class ReleaseType implements Serializable {

    public static final Byte UNKNOWN = 0;  //未知
    public static final Byte AUTO = 1;  //自动放行
    public static final Byte ARTIFICIAL = 2;  //人工放行
    public static final Byte PHONE = 3;  //手机放行

}
