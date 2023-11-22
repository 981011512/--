package com.cf.carpark.device.camera.ZhenShi;

import java.io.Serializable;

/**
 * 汽车品牌实体
 */
public class CarBrand implements Serializable {

    private String brand;
    private String year;
    private String type;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
