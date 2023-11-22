package com.cf.carpark.device.camera.ZhenShi;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 *
 * @ClassName PlateResult
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/1/001 14:54
 * @Version 1.0
 **/
public class PlateResult implements Serializable {
    Integer colorType; //0：未知、1：蓝色、2：黄色、3：白色、4：黑色、5：绿色
    Integer type;
    Integer triggerType;
    Integer plateid;
    String license; //车牌号
    TimeStamp timeStamp;
    Integer imageFragmentFileLen;    //小图的大小
    String imageFragmentFile;    //小图
    String imageFragmentPath;    //小图(新版)
    Integer imageFileLenl;  //大图大小
    String imageFile;    //小图
    String imagePath;   //图片路径
//    CarBrand car_brand; //车辆品牌

    public Integer getColorType() {
        return colorType;
    }

    public void setColorType(Integer colorType) {
        this.colorType = colorType;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(Integer triggerType) {
        this.triggerType = triggerType;
    }

    public Integer getPlateid() {
        return plateid;
    }

    public void setPlateid(Integer plateid) {
        this.plateid = plateid;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public TimeStamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(TimeStamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getImageFragmentFileLen() {
        return imageFragmentFileLen;
    }

    public void setImageFragmentFileLen(Integer imageFragmentFileLen) {
        this.imageFragmentFileLen = imageFragmentFileLen;
    }

    public String getImageFragmentFile() {
        return imageFragmentFile;
    }

    public void setImageFragmentFile(String imageFragmentFile) {
        this.imageFragmentFile = imageFragmentFile;
    }

    public String getImageFragmentPath() {
        return imageFragmentPath;
    }

    public void setImageFragmentPath(String imageFragmentPath) {
        this.imageFragmentPath = imageFragmentPath;
    }

    public Integer getImageFileLenl() {
        return imageFileLenl;
    }

    public void setImageFileLenl(Integer imageFileLenl) {
        this.imageFileLenl = imageFileLenl;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

//    @JsonProperty("car_brand")
//    public CarBrand getCar_brand() {
//        return car_brand;
//    }
//
//    public void setCar_brand(CarBrand car_brand) {
//        this.car_brand = car_brand;
//    }
}
