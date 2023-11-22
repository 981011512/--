package com.cf.carpark.domain.request;

import java.io.Serializable;
import java.util.List;

/**
 * 广告下发实体
 */
public class PublishLedAd implements Serializable
{
    private String serialNumber;

    private List<String> adList;

    private String validityPeriod;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public List<String> getAdList() {
        return adList;
    }

    public void setAdList(List<String> adList) {
        this.adList = adList;
    }

    public String getValidityPeriod() {
        return validityPeriod;
    }

    public void setValidityPeriod(String validityPeriod) {
        this.validityPeriod = validityPeriod;
    }
}
