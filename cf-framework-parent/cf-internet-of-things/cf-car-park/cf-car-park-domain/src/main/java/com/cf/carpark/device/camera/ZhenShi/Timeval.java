package com.cf.carpark.device.camera.ZhenShi;

import java.io.Serializable;

/**
 *
 * @ClassName Timeval
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/1/001 14:57
 * @Version 1.0
 **/
public class Timeval implements Serializable {
    Integer decyear;
    Integer decmon;
    Integer decday;
    Integer dechour;
    Integer decmin;
    Integer decsec;
    Integer sec;
    Integer usec;

    public Integer getDecyear() {
        return decyear;
    }

    public void setDecyear(Integer decyear) {
        this.decyear = decyear;
    }

    public Integer getDecmon() {
        return decmon;
    }

    public void setDecmon(Integer decmon) {
        this.decmon = decmon;
    }

    public Integer getDecday() {
        return decday;
    }

    public void setDecday(Integer decday) {
        this.decday = decday;
    }

    public Integer getDechour() {
        return dechour;
    }

    public void setDechour(Integer dechour) {
        this.dechour = dechour;
    }

    public Integer getDecmin() {
        return decmin;
    }

    public void setDecmin(Integer decmin) {
        this.decmin = decmin;
    }

    public Integer getDecsec() {
        return decsec;
    }

    public void setDecsec(Integer decsec) {
        this.decsec = decsec;
    }

    public Integer getSec() {
        return sec;
    }

    public void setSec(Integer sec) {
        this.sec = sec;
    }

    public Integer getUsec() {
        return usec;
    }

    public void setUsec(Integer usec) {
        this.usec = usec;
    }
}
