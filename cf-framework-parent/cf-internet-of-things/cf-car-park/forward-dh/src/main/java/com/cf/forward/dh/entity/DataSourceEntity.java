package com.cf.forward.dh.entity;

import lombok.Data;

@Data
public class DataSourceEntity {
    private String url;
    private String driverClassName;
    private String username;
    private String password;
}
