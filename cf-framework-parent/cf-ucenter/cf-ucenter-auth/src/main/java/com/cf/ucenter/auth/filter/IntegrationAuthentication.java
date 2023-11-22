package com.cf.ucenter.auth.filter;

import lombok.Data;

import java.util.Map;

/**
 * @author LIQIU
 * @date 2018-3-30
 **/
@Data
public class IntegrationAuthentication {

    private String authType;
    private String username;
    private Map<String,String[]> authParameters;

    public String getAuthParameter(String paramter){
        String[] values = this.authParameters.get(paramter);
        if(values != null && values.length > 0){
            return values[0];
        }
        return null;
    }
}
