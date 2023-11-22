package com.cf.forward.dh.config;

public class CameraConfig {

    public static final String logPath = "D:/dahualogging/";

    private static String dllPath;

    public static void setDllPath(String path){
        dllPath = path;
    }

    public static String getDllPath(){
        return dllPath;
    }

}


