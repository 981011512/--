package com.cf.carpark.domain.request;

import java.io.Serializable;
import java.util.List;

public class CfCarParkPackageLogQuery implements Serializable {
    private String id;

    private String packageId;

    private List<String> packageIds;

    private String handleUid;

    private Long actionTime;

    private Long minActionTime;

    private Long maxActionTime;

    private Integer page;

    private Integer size;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public List<String> getPackageIds() {
        return packageIds;
    }

    public void setPackageIds(List<String> packageIds) {
        this.packageIds = packageIds;
    }

    public String getHandleUid() {
        return handleUid;
    }

    public void setHandleUid(String handleUid) {
        this.handleUid = handleUid;
    }

    public Long getActionTime() {
        return actionTime;
    }

    public void setActionTime(Long actionTime) {
        this.actionTime = actionTime;
    }

    public Long getMinActionTime() {
        return minActionTime;
    }

    public void setMinActionTime(Long minActionTime) {
        this.minActionTime = minActionTime;
    }

    public Long getMaxActionTime() {
        return maxActionTime;
    }

    public void setMaxActionTime(Long maxActionTime) {
        this.maxActionTime = maxActionTime;
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