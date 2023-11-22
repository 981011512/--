package com.cf.carpark.domain.request;

import java.io.Serializable;
import java.util.List;

public class CfCarParkVisitQuery implements Serializable {
    private Long id;

    private Long carParkId;

    private List<Long> carParkIds;

    private String plateNumber;

    private Long fromUid;

    private Long toUid;

    private Long processUid;

    private Long createTime;
    private Long minCreateTime;

    private Long maxCreateTime;

    private Long processTime;

    private Long minProcessTime;

    private Long maxProcessTime;

    private Long carParkUseLogId;

    private Long visitTime;

    private Long minVisitTime;

    private Long maxVisitTime;

    private Byte processStatus;

    private Long expirationTime;

    private String orderBy;

    private Integer page;

    private Integer size;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCarParkId() {
        return carParkId;
    }

    public void setCarParkId(Long carParkId) {
        this.carParkId = carParkId;
    }

    public List<Long> getCarParkIds() {
        return carParkIds;
    }

    public void setCarParkIds(List<Long> carParkIds) {
        this.carParkIds = carParkIds;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber == null ? null : plateNumber.trim();
    }

    public Long getFromUid() {
        return fromUid;
    }

    public void setFromUid(Long fromUid) {
        this.fromUid = fromUid;
    }

    public Long getToUid() {
        return toUid;
    }

    public void setToUid(Long toUid) {
        this.toUid = toUid;
    }

    public Long getProcessUid() {
        return processUid;
    }

    public void setProcessUid(Long processUid) {
        this.processUid = processUid;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getMinCreateTime() {
        return minCreateTime;
    }

    public void setMinCreateTime(Long minCreateTime) {
        this.minCreateTime = minCreateTime;
    }

    public Long getMaxCreateTime() {
        return maxCreateTime;
    }

    public void setMaxCreateTime(Long maxCreateTime) {
        this.maxCreateTime = maxCreateTime;
    }

    public Long getProcessTime() {
        return processTime;
    }

    public void setProcessTime(Long processTime) {
        this.processTime = processTime;
    }

    public Long getMinProcessTime() {
        return minProcessTime;
    }

    public void setMinProcessTime(Long minProcessTime) {
        this.minProcessTime = minProcessTime;
    }

    public Long getMaxProcessTime() {
        return maxProcessTime;
    }

    public void setMaxProcessTime(Long maxProcessTime) {
        this.maxProcessTime = maxProcessTime;
    }

    public Long getCarParkUseLogId() {
        return carParkUseLogId;
    }

    public void setCarParkUseLogId(Long carParkUseLogId) {
        this.carParkUseLogId = carParkUseLogId;
    }

    public Long getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Long visitTime) {
        this.visitTime = visitTime;
    }

    public Long getMinVisitTime() {
        return minVisitTime;
    }

    public void setMinVisitTime(Long minVisitTime) {
        this.minVisitTime = minVisitTime;
    }

    public Long getMaxVisitTime() {
        return maxVisitTime;
    }

    public void setMaxVisitTime(Long maxVisitTime) {
        this.maxVisitTime = maxVisitTime;
    }

    public Byte getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(Byte processStatus) {
        this.processStatus = processStatus;
    }

    public Long getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Long expirationTime) {
        this.expirationTime = expirationTime;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}