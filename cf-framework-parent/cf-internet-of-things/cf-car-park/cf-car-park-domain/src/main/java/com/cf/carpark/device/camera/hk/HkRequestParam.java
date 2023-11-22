package com.cf.carpark.device.camera.hk;

import com.cf.carpark.device.camera.BaseRequestParam;
import lombok.Data;

import java.io.Serializable;

@Data
public class HkRequestParam extends BaseRequestParam implements Serializable {

    private String cameraIp;

    private String deviceBrand;

    private String smallImage;

    private String bigImage;

    private String smallImagePath;

    private String bigImagePath;

    private String plateColor;
}
