package com.cf.carpark.service;

public interface MQTTClient {

    void startMQTTClient(String sn, String payLoad) throws Exception;

}
