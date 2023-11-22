package com.cf.forward.dh.entity;

import java.time.LocalDate;

/**
 * <p>
 *
 * </p>
 *
 * @author MP生成器
 * @since 2021-04-11
 */
public class LogInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 日志ID
     */
    private Long id;

    /**
     * 类型：0:http 1:socket
     */
    private String type;

    /**
     * 日志描述
     */
    private String description;

    /**
     * 日志类型，索引inx_log_type，普通索引index
     */
    private String logType;

    /**
     * 全类名+方法名
     */
    private String method;

    /**
     * 请求参数
     */
    private String params;

    /**
     * 请求IP地址
     */
    private String requestIp;

    /**
     * 请求处理时间
     */
    private Long time;

    /**
     * 访问者用户名
     */
    private String username;

    /**
     * 异常详情记录
     */
    private String exceptionDetail;

    /**
     * 创建时间，索引inx_log_create_time，普通索引
     */
    private LocalDate createTime;

    /**
     * 请求结果
     */
    private Integer reqResult;

    /**
     * 业务处理结果
     */
    private String dealResult;

    /**
     * 请求响应
     */
    private String resMsg;

   public LogInfo getConnectLog(String method,String dealResult,String ip,String port){
       LogInfo logInfo = new LogInfo();
       logInfo.setType("2");
       logInfo.setDescription("监控断线重连");
       logInfo.setLogType("INFO");
       logInfo.setMethod(method);
       logInfo.setRequestIp(ip+":"+port);
       logInfo.setDealResult(dealResult);
       return logInfo;
   }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getExceptionDetail() {
        return exceptionDetail;
    }

    public void setExceptionDetail(String exceptionDetail) {
        this.exceptionDetail = exceptionDetail;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public Integer getReqResult() {
        return reqResult;
    }

    public void setReqResult(Integer reqResult) {
        this.reqResult = reqResult;
    }

    public String getDealResult() {
        return dealResult;
    }

    public void setDealResult(String dealResult) {
        this.dealResult = dealResult;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }
}
