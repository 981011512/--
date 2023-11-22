package com.cf.carpark.domain.request;

import java.io.Serializable;
import java.util.List;

public class CfCarParkPaymentAgencyQuery implements Serializable {
    private String id;

    private String carParkId;

    private String carParkIds;

    private List<String> carParkIdList;

    private String userPaymentAgency;

    private Integer sortIndex;

    private String orderBy;

    private Integer page;

    private Integer size;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCarParkId() {
        return carParkId;
    }

    public void setCarParkId(String carParkId) {
        this.carParkId = carParkId == null ? null : carParkId.trim();
    }

    public String getCarParkIds() {
        return carParkIds;
    }

    public void setCarParkIds(String carParkIds) {
        this.carParkIds = carParkIds;
    }

    public String getUserPaymentAgency() {
        return userPaymentAgency;
    }

    public void setUserPaymentAgency(String userPaymentAgency) {
        this.userPaymentAgency = userPaymentAgency == null ? null : userPaymentAgency.trim();
    }

    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
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

    public List<String> getCarParkIdList() {
        return carParkIdList;
    }

    public void setCarParkIdList(List<String> carParkIdList) {
        this.carParkIdList = carParkIdList;
    }
}