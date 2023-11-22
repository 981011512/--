package com.cf.carpark.domain.request;

import java.io.Serializable;

public class CfDailyParkingStatistcsQuery implements Serializable {
    private String id;

    private String title;

    private String carparkId;

    private Short year;
    private Short minYear;
    private Short maxYear;

    private Byte month;
    private Byte minMonth;
    private Byte maxMonth;

    private Byte date;
    private Byte minDate;
    private Byte maxDate;

    private Long startTime;

    private Long minStartTime;

    private Long maxStartTime;

    private Long endTime;

    private Long minEndTime;

    private Long maxEndTime;

    private Integer parkingCounts;

    private Integer parkingTemporaryCounts;

    private Integer parkingSpace;

    private Integer parkingUsedSpace;

    private Integer parkingNotInTimeCounts;

    private Integer parkingAbnormalReleaseCounts;

    private Integer parkingPackageRenewalCounts;

    private Long parkingTimeCounts;

    private Long countsTime;

    private Integer yellowNumberPlateCounts;

    private Integer blueNumberPlateCounts;

    private Integer greenNumberPlateCounts;

    private Integer page;

    private Integer size;

    private String orderBy;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getCarparkId() {
        return carparkId;
    }

    public void setCarparkId(String carparkId) {
        this.carparkId = carparkId == null ? null : carparkId.trim();
    }

    public Short getYear() {
        return year;
    }

    public void setYear(Short year) {
        this.year = year;
    }

    public Short getMinYear() {
        return minYear;
    }

    public void setMinYear(Short minYear) {
        this.minYear = minYear;
    }

    public Short getMaxYear() {
        return maxYear;
    }

    public void setMaxYear(Short maxYear) {
        this.maxYear = maxYear;
    }

    public Byte getMonth() {
        return month;
    }

    public void setMonth(Byte month) {
        this.month = month;
    }

    public Byte getMinMonth() {
        return minMonth;
    }

    public void setMinMonth(Byte minMonth) {
        this.minMonth = minMonth;
    }

    public Byte getMaxMonth() {
        return maxMonth;
    }

    public void setMaxMonth(Byte maxMonth) {
        this.maxMonth = maxMonth;
    }

    public Byte getDate() {
        return date;
    }

    public void setDate(Byte date) {
        this.date = date;
    }

    public Byte getMinDate() {
        return minDate;
    }

    public void setMinDate(Byte minDate) {
        this.minDate = minDate;
    }

    public Byte getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(Byte maxDate) {
        this.maxDate = maxDate;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Integer getParkingCounts() {
        return parkingCounts;
    }

    public void setParkingCounts(Integer parkingCounts) {
        this.parkingCounts = parkingCounts;
    }

    public Integer getParkingTemporaryCounts() {
        return parkingTemporaryCounts;
    }

    public void setParkingTemporaryCounts(Integer parkingTemporaryCounts) {
        this.parkingTemporaryCounts = parkingTemporaryCounts;
    }

    public Integer getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(Integer parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public Integer getParkingUsedSpace() {
        return parkingUsedSpace;
    }

    public void setParkingUsedSpace(Integer parkingUsedSpace) {
        this.parkingUsedSpace = parkingUsedSpace;
    }

    public Integer getParkingNotInTimeCounts() {
        return parkingNotInTimeCounts;
    }

    public void setParkingNotInTimeCounts(Integer parkingNotInTimeCounts) {
        this.parkingNotInTimeCounts = parkingNotInTimeCounts;
    }

    public Integer getParkingAbnormalReleaseCounts() {
        return parkingAbnormalReleaseCounts;
    }

    public void setParkingAbnormalReleaseCounts(Integer parkingAbnormalReleaseCounts) {
        this.parkingAbnormalReleaseCounts = parkingAbnormalReleaseCounts;
    }

    public Integer getParkingPackageRenewalCounts() {
        return parkingPackageRenewalCounts;
    }

    public void setParkingPackageRenewalCounts(Integer parkingPackageRenewalCounts) {
        this.parkingPackageRenewalCounts = parkingPackageRenewalCounts;
    }

    public Long getParkingTimeCounts() {
        return parkingTimeCounts;
    }

    public void setParkingTimeCounts(Long parkingTimeCounts) {
        this.parkingTimeCounts = parkingTimeCounts;
    }

    public Long getCountsTime() {
        return countsTime;
    }

    public void setCountsTime(Long countsTime) {
        this.countsTime = countsTime;
    }

    public Integer getYellowNumberPlateCounts() {
        return yellowNumberPlateCounts;
    }

    public void setYellowNumberPlateCounts(Integer yellowNumberPlateCounts) {
        this.yellowNumberPlateCounts = yellowNumberPlateCounts;
    }

    public Integer getBlueNumberPlateCounts() {
        return blueNumberPlateCounts;
    }

    public void setBlueNumberPlateCounts(Integer blueNumberPlateCounts) {
        this.blueNumberPlateCounts = blueNumberPlateCounts;
    }

    public Integer getGreenNumberPlateCounts() {
        return greenNumberPlateCounts;
    }

    public void setGreenNumberPlateCounts(Integer greenNumberPlateCounts) {
        this.greenNumberPlateCounts = greenNumberPlateCounts;
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

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Long getMinStartTime() {
        return minStartTime;
    }

    public void setMinStartTime(Long minStartTime) {
        this.minStartTime = minStartTime;
    }

    public Long getMaxStartTime() {
        return maxStartTime;
    }

    public void setMaxStartTime(Long maxStartTime) {
        this.maxStartTime = maxStartTime;
    }

    public Long getMinEndTime() {
        return minEndTime;
    }

    public void setMinEndTime(Long minEndTime) {
        this.minEndTime = minEndTime;
    }

    public Long getMaxEndTime() {
        return maxEndTime;
    }

    public void setMaxEndTime(Long maxEndTime) {
        this.maxEndTime = maxEndTime;
    }
}