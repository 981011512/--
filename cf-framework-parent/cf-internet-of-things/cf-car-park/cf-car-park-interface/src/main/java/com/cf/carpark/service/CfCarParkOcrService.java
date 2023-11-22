package com.cf.carpark.service;

/**
 * 云端车牌识别OCR服务
 */
public interface CfCarParkOcrService {

    /**
     * 阿里云车牌识别服务
     * @param numberPlateImageURL
     * @return
     */
    String AliNumberPlateOcr(String numberPlateImageURL) throws Exception;

}
