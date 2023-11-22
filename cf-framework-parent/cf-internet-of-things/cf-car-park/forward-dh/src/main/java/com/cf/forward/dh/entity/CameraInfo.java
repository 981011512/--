package com.cf.forward.dh.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author MP生成器
 * @since 2021-04-11
 */
public class CameraInfo {

    private static final SimpleDateFormat FORMAT = new SimpleDateFormat ("yyyyMMddhhmmss");

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String uuid;

    private String username;

    private String password;

    private String ip;

    private Integer port;

    private boolean openHeartbeatMinitor;   //是否已经开启了心跳

    /**
     * 摄像机名称
     */
    private String name;

    /**
     * 服务端启动端口
     */
    private Integer serverPort;

    private Integer isListen;

    private Integer pid;

    private String server;  //服务器地址

    public String logFileName(){
        return "log-"+name+"-"+FORMAT.format(new Date())+".log";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getServerPort() {
        return serverPort;
    }

    public void setServerPort(Integer serverPort) {
        this.serverPort = serverPort;
    }

    public Integer getIsListen() {
        return isListen;
    }

    public void setIsListen(Integer isListen) {
        this.isListen = isListen;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public boolean getOpenHeartbeatMinitor() {
        return openHeartbeatMinitor;
    }

    public void setOpenHeartbeatMinitor(boolean openHeartbeatMinitor) {
        this.openHeartbeatMinitor = openHeartbeatMinitor;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }
}
