package com.cf.carpark.domain;

import java.io.Serializable;

public class CfDailyParkingStatistcs implements Serializable {
    private String id;

    private String title;

    private String carparkId;

    private Short year;

    private Byte month;

    private Byte date;

    private Long startTime;

    private Long endTime;

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

    public Byte getMonth() {
        return month;
    }

    public void setMonth(Byte month) {
        this.month = month;
    }

    public Byte getDate() {
        return date;
    }

    public void setDate(Byte date) {
        this.date = date;
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
}