package com.cf.carpark.device.camera.ZhenShi;

import java.io.Serializable;

/**
 * 请在此填写描述
 *
 * @ClassName TimeStamp
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/1/001 14:57
 * @Version 1.0
 **/
public class TimeStamp implements Serializable {
    Timeval timeval;

    public Timeval getTimeval() {
        return timeval;
    }

    public void setTimeval(Timeval timeval) {
        this.timeval = timeval;
    }
}
