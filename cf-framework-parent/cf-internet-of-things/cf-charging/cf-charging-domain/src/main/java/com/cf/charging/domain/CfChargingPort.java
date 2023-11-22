package com.cf.charging.domain;

import java.io.Serializable;

public class CfChargingPort implements Serializable {
    private String id;

    private Byte portNumber;

    private String chargingStationId;

    private String chargingDeviceId;

    private Byte status;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Byte getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(Byte portNumber) {
        this.portNumber = portNumber;
    }

    public String getChargingStationId() {
        return chargingStationId;
    }

    public void setChargingStationId(String chargingStationId) {
        this.chargingStationId = chargingStationId == null ? null : chargingStationId.trim();
    }

    public String getChargingDeviceId() {
        return chargingDeviceId;
    }

    public void setChargingDeviceId(String chargingDeviceId) {
        this.chargingDeviceId = chargingDeviceId == null ? null : chargingDeviceId.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}