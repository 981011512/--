package com.cf.carpark.domain;

import java.util.ArrayList;
import java.util.List;

public class CfDailyParkingStatistcsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfDailyParkingStatistcsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andCarparkIdIsNull() {
            addCriterion("carpark_id is null");
            return (Criteria) this;
        }

        public Criteria andCarparkIdIsNotNull() {
            addCriterion("carpark_id is not null");
            return (Criteria) this;
        }

        public Criteria andCarparkIdEqualTo(String value) {
            addCriterion("carpark_id =", value, "carparkId");
            return (Criteria) this;
        }

        public Criteria andCarparkIdNotEqualTo(String value) {
            addCriterion("carpark_id <>", value, "carparkId");
            return (Criteria) this;
        }

        public Criteria andCarparkIdGreaterThan(String value) {
            addCriterion("carpark_id >", value, "carparkId");
            return (Criteria) this;
        }

        public Criteria andCarparkIdGreaterThanOrEqualTo(String value) {
            addCriterion("carpark_id >=", value, "carparkId");
            return (Criteria) this;
        }

        public Criteria andCarparkIdLessThan(String value) {
            addCriterion("carpark_id <", value, "carparkId");
            return (Criteria) this;
        }

        public Criteria andCarparkIdLessThanOrEqualTo(String value) {
            addCriterion("carpark_id <=", value, "carparkId");
            return (Criteria) this;
        }

        public Criteria andCarparkIdLike(String value) {
            addCriterion("carpark_id like", value, "carparkId");
            return (Criteria) this;
        }

        public Criteria andCarparkIdNotLike(String value) {
            addCriterion("carpark_id not like", value, "carparkId");
            return (Criteria) this;
        }

        public Criteria andCarparkIdIn(List<String> values) {
            addCriterion("carpark_id in", values, "carparkId");
            return (Criteria) this;
        }

        public Criteria andCarparkIdNotIn(List<String> values) {
            addCriterion("carpark_id not in", values, "carparkId");
            return (Criteria) this;
        }

        public Criteria andCarparkIdBetween(String value1, String value2) {
            addCriterion("carpark_id between", value1, value2, "carparkId");
            return (Criteria) this;
        }

        public Criteria andCarparkIdNotBetween(String value1, String value2) {
            addCriterion("carpark_id not between", value1, value2, "carparkId");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(Short value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Short value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Short value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Short value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Short value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Short value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Short> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Short> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Short value1, Short value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Short value1, Short value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andMonthIsNull() {
            addCriterion("month is null");
            return (Criteria) this;
        }

        public Criteria andMonthIsNotNull() {
            addCriterion("month is not null");
            return (Criteria) this;
        }

        public Criteria andMonthEqualTo(Byte value) {
            addCriterion("month =", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotEqualTo(Byte value) {
            addCriterion("month <>", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThan(Byte value) {
            addCriterion("month >", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThanOrEqualTo(Byte value) {
            addCriterion("month >=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThan(Byte value) {
            addCriterion("month <", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThanOrEqualTo(Byte value) {
            addCriterion("month <=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthIn(List<Byte> values) {
            addCriterion("month in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotIn(List<Byte> values) {
            addCriterion("month not in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthBetween(Byte value1, Byte value2) {
            addCriterion("month between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotBetween(Byte value1, Byte value2) {
            addCriterion("month not between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Byte value) {
            addCriterion("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Byte value) {
            addCriterion("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Byte value) {
            addCriterion("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Byte value) {
            addCriterion("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Byte value) {
            addCriterion("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Byte value) {
            addCriterion("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Byte> values) {
            addCriterion("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Byte> values) {
            addCriterion("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Byte value1, Byte value2) {
            addCriterion("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Byte value1, Byte value2) {
            addCriterion("date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Long value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Long value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Long value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Long value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Long value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Long> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Long> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Long value1, Long value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Long value1, Long value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Long value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Long value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Long value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Long value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Long value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Long> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Long> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Long value1, Long value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Long value1, Long value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andParkingCountsIsNull() {
            addCriterion("parking_counts is null");
            return (Criteria) this;
        }

        public Criteria andParkingCountsIsNotNull() {
            addCriterion("parking_counts is not null");
            return (Criteria) this;
        }

        public Criteria andParkingCountsEqualTo(Integer value) {
            addCriterion("parking_counts =", value, "parkingCounts");
            return (Criteria) this;
        }

        public Criteria andParkingCountsNotEqualTo(Integer value) {
            addCriterion("parking_counts <>", value, "parkingCounts");
            return (Criteria) this;
        }

        public Criteria andParkingCountsGreaterThan(Integer value) {
            addCriterion("parking_counts >", value, "parkingCounts");
            return (Criteria) this;
        }

        public Criteria andParkingCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("parking_counts >=", value, "parkingCounts");
            return (Criteria) this;
        }

        public Criteria andParkingCountsLessThan(Integer value) {
            addCriterion("parking_counts <", value, "parkingCounts");
            return (Criteria) this;
        }

        public Criteria andParkingCountsLessThanOrEqualTo(Integer value) {
            addCriterion("parking_counts <=", value, "parkingCounts");
            return (Criteria) this;
        }

        public Criteria andParkingCountsIn(List<Integer> values) {
            addCriterion("parking_counts in", values, "parkingCounts");
            return (Criteria) this;
        }

        public Criteria andParkingCountsNotIn(List<Integer> values) {
            addCriterion("parking_counts not in", values, "parkingCounts");
            return (Criteria) this;
        }

        public Criteria andParkingCountsBetween(Integer value1, Integer value2) {
            addCriterion("parking_counts between", value1, value2, "parkingCounts");
            return (Criteria) this;
        }

        public Criteria andParkingCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("parking_counts not between", value1, value2, "parkingCounts");
            return (Criteria) this;
        }

        public Criteria andParkingTemporaryCountsIsNull() {
            addCriterion("parking_temporary_counts is null");
            return (Criteria) this;
        }

        public Criteria andParkingTemporaryCountsIsNotNull() {
            addCriterion("parking_temporary_counts is not null");
            return (Criteria) this;
        }

        public Criteria andParkingTemporaryCountsEqualTo(Integer value) {
            addCriterion("parking_temporary_counts =", value, "parkingTemporaryCounts");
            return (Criteria) this;
        }

        public Criteria andParkingTemporaryCountsNotEqualTo(Integer value) {
            addCriterion("parking_temporary_counts <>", value, "parkingTemporaryCounts");
            return (Criteria) this;
        }

        public Criteria andParkingTemporaryCountsGreaterThan(Integer value) {
            addCriterion("parking_temporary_counts >", value, "parkingTemporaryCounts");
            return (Criteria) this;
        }

        public Criteria andParkingTemporaryCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("parking_temporary_counts >=", value, "parkingTemporaryCounts");
            return (Criteria) this;
        }

        public Criteria andParkingTemporaryCountsLessThan(Integer value) {
            addCriterion("parking_temporary_counts <", value, "parkingTemporaryCounts");
            return (Criteria) this;
        }

        public Criteria andParkingTemporaryCountsLessThanOrEqualTo(Integer value) {
            addCriterion("parking_temporary_counts <=", value, "parkingTemporaryCounts");
            return (Criteria) this;
        }

        public Criteria andParkingTemporaryCountsIn(List<Integer> values) {
            addCriterion("parking_temporary_counts in", values, "parkingTemporaryCounts");
            return (Criteria) this;
        }

        public Criteria andParkingTemporaryCountsNotIn(List<Integer> values) {
            addCriterion("parking_temporary_counts not in", values, "parkingTemporaryCounts");
            return (Criteria) this;
        }

        public Criteria andParkingTemporaryCountsBetween(Integer value1, Integer value2) {
            addCriterion("parking_temporary_counts between", value1, value2, "parkingTemporaryCounts");
            return (Criteria) this;
        }

        public Criteria andParkingTemporaryCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("parking_temporary_counts not between", value1, value2, "parkingTemporaryCounts");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceIsNull() {
            addCriterion("parking_space is null");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceIsNotNull() {
            addCriterion("parking_space is not null");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceEqualTo(Integer value) {
            addCriterion("parking_space =", value, "parkingSpace");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNotEqualTo(Integer value) {
            addCriterion("parking_space <>", value, "parkingSpace");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceGreaterThan(Integer value) {
            addCriterion("parking_space >", value, "parkingSpace");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceGreaterThanOrEqualTo(Integer value) {
            addCriterion("parking_space >=", value, "parkingSpace");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceLessThan(Integer value) {
            addCriterion("parking_space <", value, "parkingSpace");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceLessThanOrEqualTo(Integer value) {
            addCriterion("parking_space <=", value, "parkingSpace");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceIn(List<Integer> values) {
            addCriterion("parking_space in", values, "parkingSpace");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNotIn(List<Integer> values) {
            addCriterion("parking_space not in", values, "parkingSpace");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceBetween(Integer value1, Integer value2) {
            addCriterion("parking_space between", value1, value2, "parkingSpace");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNotBetween(Integer value1, Integer value2) {
            addCriterion("parking_space not between", value1, value2, "parkingSpace");
            return (Criteria) this;
        }

        public Criteria andParkingUsedSpaceIsNull() {
            addCriterion("parking_used_space is null");
            return (Criteria) this;
        }

        public Criteria andParkingUsedSpaceIsNotNull() {
            addCriterion("parking_used_space is not null");
            return (Criteria) this;
        }

        public Criteria andParkingUsedSpaceEqualTo(Integer value) {
            addCriterion("parking_used_space =", value, "parkingUsedSpace");
            return (Criteria) this;
        }

        public Criteria andParkingUsedSpaceNotEqualTo(Integer value) {
            addCriterion("parking_used_space <>", value, "parkingUsedSpace");
            return (Criteria) this;
        }

        public Criteria andParkingUsedSpaceGreaterThan(Integer value) {
            addCriterion("parking_used_space >", value, "parkingUsedSpace");
            return (Criteria) this;
        }

        public Criteria andParkingUsedSpaceGreaterThanOrEqualTo(Integer value) {
            addCriterion("parking_used_space >=", value, "parkingUsedSpace");
            return (Criteria) this;
        }

        public Criteria andParkingUsedSpaceLessThan(Integer value) {
            addCriterion("parking_used_space <", value, "parkingUsedSpace");
            return (Criteria) this;
        }

        public Criteria andParkingUsedSpaceLessThanOrEqualTo(Integer value) {
            addCriterion("parking_used_space <=", value, "parkingUsedSpace");
            return (Criteria) this;
        }

        public Criteria andParkingUsedSpaceIn(List<Integer> values) {
            addCriterion("parking_used_space in", values, "parkingUsedSpace");
            return (Criteria) this;
        }

        public Criteria andParkingUsedSpaceNotIn(List<Integer> values) {
            addCriterion("parking_used_space not in", values, "parkingUsedSpace");
            return (Criteria) this;
        }

        public Criteria andParkingUsedSpaceBetween(Integer value1, Integer value2) {
            addCriterion("parking_used_space between", value1, value2, "parkingUsedSpace");
            return (Criteria) this;
        }

        public Criteria andParkingUsedSpaceNotBetween(Integer value1, Integer value2) {
            addCriterion("parking_used_space not between", value1, value2, "parkingUsedSpace");
            return (Criteria) this;
        }

        public Criteria andParkingNotInTimeCountsIsNull() {
            addCriterion("parking_not_in_time_counts is null");
            return (Criteria) this;
        }

        public Criteria andParkingNotInTimeCountsIsNotNull() {
            addCriterion("parking_not_in_time_counts is not null");
            return (Criteria) this;
        }

        public Criteria andParkingNotInTimeCountsEqualTo(Integer value) {
            addCriterion("parking_not_in_time_counts =", value, "parkingNotInTimeCounts");
            return (Criteria) this;
        }

        public Criteria andParkingNotInTimeCountsNotEqualTo(Integer value) {
            addCriterion("parking_not_in_time_counts <>", value, "parkingNotInTimeCounts");
            return (Criteria) this;
        }

        public Criteria andParkingNotInTimeCountsGreaterThan(Integer value) {
            addCriterion("parking_not_in_time_counts >", value, "parkingNotInTimeCounts");
            return (Criteria) this;
        }

        public Criteria andParkingNotInTimeCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("parking_not_in_time_counts >=", value, "parkingNotInTimeCounts");
            return (Criteria) this;
        }

        public Criteria andParkingNotInTimeCountsLessThan(Integer value) {
            addCriterion("parking_not_in_time_counts <", value, "parkingNotInTimeCounts");
            return (Criteria) this;
        }

        public Criteria andParkingNotInTimeCountsLessThanOrEqualTo(Integer value) {
            addCriterion("parking_not_in_time_counts <=", value, "parkingNotInTimeCounts");
            return (Criteria) this;
        }

        public Criteria andParkingNotInTimeCountsIn(List<Integer> values) {
            addCriterion("parking_not_in_time_counts in", values, "parkingNotInTimeCounts");
            return (Criteria) this;
        }

        public Criteria andParkingNotInTimeCountsNotIn(List<Integer> values) {
            addCriterion("parking_not_in_time_counts not in", values, "parkingNotInTimeCounts");
            return (Criteria) this;
        }

        public Criteria andParkingNotInTimeCountsBetween(Integer value1, Integer value2) {
            addCriterion("parking_not_in_time_counts between", value1, value2, "parkingNotInTimeCounts");
            return (Criteria) this;
        }

        public Criteria andParkingNotInTimeCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("parking_not_in_time_counts not between", value1, value2, "parkingNotInTimeCounts");
            return (Criteria) this;
        }

        public Criteria andParkingAbnormalReleaseCountsIsNull() {
            addCriterion("parking_abnormal_release_counts is null");
            return (Criteria) this;
        }

        public Criteria andParkingAbnormalReleaseCountsIsNotNull() {
            addCriterion("parking_abnormal_release_counts is not null");
            return (Criteria) this;
        }

        public Criteria andParkingAbnormalReleaseCountsEqualTo(Integer value) {
            addCriterion("parking_abnormal_release_counts =", value, "parkingAbnormalReleaseCounts");
            return (Criteria) this;
        }

        public Criteria andParkingAbnormalReleaseCountsNotEqualTo(Integer value) {
            addCriterion("parking_abnormal_release_counts <>", value, "parkingAbnormalReleaseCounts");
            return (Criteria) this;
        }

        public Criteria andParkingAbnormalReleaseCountsGreaterThan(Integer value) {
            addCriterion("parking_abnormal_release_counts >", value, "parkingAbnormalReleaseCounts");
            return (Criteria) this;
        }

        public Criteria andParkingAbnormalReleaseCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("parking_abnormal_release_counts >=", value, "parkingAbnormalReleaseCounts");
            return (Criteria) this;
        }

        public Criteria andParkingAbnormalReleaseCountsLessThan(Integer value) {
            addCriterion("parking_abnormal_release_counts <", value, "parkingAbnormalReleaseCounts");
            return (Criteria) this;
        }

        public Criteria andParkingAbnormalReleaseCountsLessThanOrEqualTo(Integer value) {
            addCriterion("parking_abnormal_release_counts <=", value, "parkingAbnormalReleaseCounts");
            return (Criteria) this;
        }

        public Criteria andParkingAbnormalReleaseCountsIn(List<Integer> values) {
            addCriterion("parking_abnormal_release_counts in", values, "parkingAbnormalReleaseCounts");
            return (Criteria) this;
        }

        public Criteria andParkingAbnormalReleaseCountsNotIn(List<Integer> values) {
            addCriterion("parking_abnormal_release_counts not in", values, "parkingAbnormalReleaseCounts");
            return (Criteria) this;
        }

        public Criteria andParkingAbnormalReleaseCountsBetween(Integer value1, Integer value2) {
            addCriterion("parking_abnormal_release_counts between", value1, value2, "parkingAbnormalReleaseCounts");
            return (Criteria) this;
        }

        public Criteria andParkingAbnormalReleaseCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("parking_abnormal_release_counts not between", value1, value2, "parkingAbnormalReleaseCounts");
            return (Criteria) this;
        }

        public Criteria andParkingPackageRenewalCountsIsNull() {
            addCriterion("parking_package_renewal_counts is null");
            return (Criteria) this;
        }

        public Criteria andParkingPackageRenewalCountsIsNotNull() {
            addCriterion("parking_package_renewal_counts is not null");
            return (Criteria) this;
        }

        public Criteria andParkingPackageRenewalCountsEqualTo(Integer value) {
            addCriterion("parking_package_renewal_counts =", value, "parkingPackageRenewalCounts");
            return (Criteria) this;
        }

        public Criteria andParkingPackageRenewalCountsNotEqualTo(Integer value) {
            addCriterion("parking_package_renewal_counts <>", value, "parkingPackageRenewalCounts");
            return (Criteria) this;
        }

        public Criteria andParkingPackageRenewalCountsGreaterThan(Integer value) {
            addCriterion("parking_package_renewal_counts >", value, "parkingPackageRenewalCounts");
            return (Criteria) this;
        }

        public Criteria andParkingPackageRenewalCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("parking_package_renewal_counts >=", value, "parkingPackageRenewalCounts");
            return (Criteria) this;
        }

        public Criteria andParkingPackageRenewalCountsLessThan(Integer value) {
            addCriterion("parking_package_renewal_counts <", value, "parkingPackageRenewalCounts");
            return (Criteria) this;
        }

        public Criteria andParkingPackageRenewalCountsLessThanOrEqualTo(Integer value) {
            addCriterion("parking_package_renewal_counts <=", value, "parkingPackageRenewalCounts");
            return (Criteria) this;
        }

        public Criteria andParkingPackageRenewalCountsIn(List<Integer> values) {
            addCriterion("parking_package_renewal_counts in", values, "parkingPackageRenewalCounts");
            return (Criteria) this;
        }

        public Criteria andParkingPackageRenewalCountsNotIn(List<Integer> values) {
            addCriterion("parking_package_renewal_counts not in", values, "parkingPackageRenewalCounts");
            return (Criteria) this;
        }

        public Criteria andParkingPackageRenewalCountsBetween(Integer value1, Integer value2) {
            addCriterion("parking_package_renewal_counts between", value1, value2, "parkingPackageRenewalCounts");
            return (Criteria) this;
        }

        public Criteria andParkingPackageRenewalCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("parking_package_renewal_counts not between", value1, value2, "parkingPackageRenewalCounts");
            return (Criteria) this;
        }

        public Criteria andParkingTimeCountsIsNull() {
            addCriterion("parking_time_counts is null");
            return (Criteria) this;
        }

        public Criteria andParkingTimeCountsIsNotNull() {
            addCriterion("parking_time_counts is not null");
            return (Criteria) this;
        }

        public Criteria andParkingTimeCountsEqualTo(Long value) {
            addCriterion("parking_time_counts =", value, "parkingTimeCounts");
            return (Criteria) this;
        }

        public Criteria andParkingTimeCountsNotEqualTo(Long value) {
            addCriterion("parking_time_counts <>", value, "parkingTimeCounts");
            return (Criteria) this;
        }

        public Criteria andParkingTimeCountsGreaterThan(Long value) {
            addCriterion("parking_time_counts >", value, "parkingTimeCounts");
            return (Criteria) this;
        }

        public Criteria andParkingTimeCountsGreaterThanOrEqualTo(Long value) {
            addCriterion("parking_time_counts >=", value, "parkingTimeCounts");
            return (Criteria) this;
        }

        public Criteria andParkingTimeCountsLessThan(Long value) {
            addCriterion("parking_time_counts <", value, "parkingTimeCounts");
            return (Criteria) this;
        }

        public Criteria andParkingTimeCountsLessThanOrEqualTo(Long value) {
            addCriterion("parking_time_counts <=", value, "parkingTimeCounts");
            return (Criteria) this;
        }

        public Criteria andParkingTimeCountsIn(List<Long> values) {
            addCriterion("parking_time_counts in", values, "parkingTimeCounts");
            return (Criteria) this;
        }

        public Criteria andParkingTimeCountsNotIn(List<Long> values) {
            addCriterion("parking_time_counts not in", values, "parkingTimeCounts");
            return (Criteria) this;
        }

        public Criteria andParkingTimeCountsBetween(Long value1, Long value2) {
            addCriterion("parking_time_counts between", value1, value2, "parkingTimeCounts");
            return (Criteria) this;
        }

        public Criteria andParkingTimeCountsNotBetween(Long value1, Long value2) {
            addCriterion("parking_time_counts not between", value1, value2, "parkingTimeCounts");
            return (Criteria) this;
        }

        public Criteria andCountsTimeIsNull() {
            addCriterion("counts_time is null");
            return (Criteria) this;
        }

        public Criteria andCountsTimeIsNotNull() {
            addCriterion("counts_time is not null");
            return (Criteria) this;
        }

        public Criteria andCountsTimeEqualTo(Long value) {
            addCriterion("counts_time =", value, "countsTime");
            return (Criteria) this;
        }

        public Criteria andCountsTimeNotEqualTo(Long value) {
            addCriterion("counts_time <>", value, "countsTime");
            return (Criteria) this;
        }

        public Criteria andCountsTimeGreaterThan(Long value) {
            addCriterion("counts_time >", value, "countsTime");
            return (Criteria) this;
        }

        public Criteria andCountsTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("counts_time >=", value, "countsTime");
            return (Criteria) this;
        }

        public Criteria andCountsTimeLessThan(Long value) {
            addCriterion("counts_time <", value, "countsTime");
            return (Criteria) this;
        }

        public Criteria andCountsTimeLessThanOrEqualTo(Long value) {
            addCriterion("counts_time <=", value, "countsTime");
            return (Criteria) this;
        }

        public Criteria andCountsTimeIn(List<Long> values) {
            addCriterion("counts_time in", values, "countsTime");
            return (Criteria) this;
        }

        public Criteria andCountsTimeNotIn(List<Long> values) {
            addCriterion("counts_time not in", values, "countsTime");
            return (Criteria) this;
        }

        public Criteria andCountsTimeBetween(Long value1, Long value2) {
            addCriterion("counts_time between", value1, value2, "countsTime");
            return (Criteria) this;
        }

        public Criteria andCountsTimeNotBetween(Long value1, Long value2) {
            addCriterion("counts_time not between", value1, value2, "countsTime");
            return (Criteria) this;
        }

        public Criteria andYellowNumberPlateCountsIsNull() {
            addCriterion("yellow_number_plate_counts is null");
            return (Criteria) this;
        }

        public Criteria andYellowNumberPlateCountsIsNotNull() {
            addCriterion("yellow_number_plate_counts is not null");
            return (Criteria) this;
        }

        public Criteria andYellowNumberPlateCountsEqualTo(Integer value) {
            addCriterion("yellow_number_plate_counts =", value, "yellowNumberPlateCounts");
            return (Criteria) this;
        }

        public Criteria andYellowNumberPlateCountsNotEqualTo(Integer value) {
            addCriterion("yellow_number_plate_counts <>", value, "yellowNumberPlateCounts");
            return (Criteria) this;
        }

        public Criteria andYellowNumberPlateCountsGreaterThan(Integer value) {
            addCriterion("yellow_number_plate_counts >", value, "yellowNumberPlateCounts");
            return (Criteria) this;
        }

        public Criteria andYellowNumberPlateCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("yellow_number_plate_counts >=", value, "yellowNumberPlateCounts");
            return (Criteria) this;
        }

        public Criteria andYellowNumberPlateCountsLessThan(Integer value) {
            addCriterion("yellow_number_plate_counts <", value, "yellowNumberPlateCounts");
            return (Criteria) this;
        }

        public Criteria andYellowNumberPlateCountsLessThanOrEqualTo(Integer value) {
            addCriterion("yellow_number_plate_counts <=", value, "yellowNumberPlateCounts");
            return (Criteria) this;
        }

        public Criteria andYellowNumberPlateCountsIn(List<Integer> values) {
            addCriterion("yellow_number_plate_counts in", values, "yellowNumberPlateCounts");
            return (Criteria) this;
        }

        public Criteria andYellowNumberPlateCountsNotIn(List<Integer> values) {
            addCriterion("yellow_number_plate_counts not in", values, "yellowNumberPlateCounts");
            return (Criteria) this;
        }

        public Criteria andYellowNumberPlateCountsBetween(Integer value1, Integer value2) {
            addCriterion("yellow_number_plate_counts between", value1, value2, "yellowNumberPlateCounts");
            return (Criteria) this;
        }

        public Criteria andYellowNumberPlateCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("yellow_number_plate_counts not between", value1, value2, "yellowNumberPlateCounts");
            return (Criteria) this;
        }

        public Criteria andBlueNumberPlateCountsIsNull() {
            addCriterion("blue_number_plate_counts is null");
            return (Criteria) this;
        }

        public Criteria andBlueNumberPlateCountsIsNotNull() {
            addCriterion("blue_number_plate_counts is not null");
            return (Criteria) this;
        }

        public Criteria andBlueNumberPlateCountsEqualTo(Integer value) {
            addCriterion("blue_number_plate_counts =", value, "blueNumberPlateCounts");
            return (Criteria) this;
        }

        public Criteria andBlueNumberPlateCountsNotEqualTo(Integer value) {
            addCriterion("blue_number_plate_counts <>", value, "blueNumberPlateCounts");
            return (Criteria) this;
        }

        public Criteria andBlueNumberPlateCountsGreaterThan(Integer value) {
            addCriterion("blue_number_plate_counts >", value, "blueNumberPlateCounts");
            return (Criteria) this;
        }

        public Criteria andBlueNumberPlateCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("blue_number_plate_counts >=", value, "blueNumberPlateCounts");
            return (Criteria) this;
        }

        public Criteria andBlueNumberPlateCountsLessThan(Integer value) {
            addCriterion("blue_number_plate_counts <", value, "blueNumberPlateCounts");
            return (Criteria) this;
        }

        public Criteria andBlueNumberPlateCountsLessThanOrEqualTo(Integer value) {
            addCriterion("blue_number_plate_counts <=", value, "blueNumberPlateCounts");
            return (Criteria) this;
        }

        public Criteria andBlueNumberPlateCountsIn(List<Integer> values) {
            addCriterion("blue_number_plate_counts in", values, "blueNumberPlateCounts");
            return (Criteria) this;
        }

        public Criteria andBlueNumberPlateCountsNotIn(List<Integer> values) {
            addCriterion("blue_number_plate_counts not in", values, "blueNumberPlateCounts");
            return (Criteria) this;
        }

        public Criteria andBlueNumberPlateCountsBetween(Integer value1, Integer value2) {
            addCriterion("blue_number_plate_counts between", value1, value2, "blueNumberPlateCounts");
            return (Criteria) this;
        }

        public Criteria andBlueNumberPlateCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("blue_number_plate_counts not between", value1, value2, "blueNumberPlateCounts");
            return (Criteria) this;
        }

        public Criteria andGreenNumberPlateCountsIsNull() {
            addCriterion("green_number_plate_counts is null");
            return (Criteria) this;
        }

        public Criteria andGreenNumberPlateCountsIsNotNull() {
            addCriterion("green_number_plate_counts is not null");
            return (Criteria) this;
        }

        public Criteria andGreenNumberPlateCountsEqualTo(Integer value) {
            addCriterion("green_number_plate_counts =", value, "greenNumberPlateCounts");
            return (Criteria) this;
        }

        public Criteria andGreenNumberPlateCountsNotEqualTo(Integer value) {
            addCriterion("green_number_plate_counts <>", value, "greenNumberPlateCounts");
            return (Criteria) this;
        }

        public Criteria andGreenNumberPlateCountsGreaterThan(Integer value) {
            addCriterion("green_number_plate_counts >", value, "greenNumberPlateCounts");
            return (Criteria) this;
        }

        public Criteria andGreenNumberPlateCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("green_number_plate_counts >=", value, "greenNumberPlateCounts");
            return (Criteria) this;
        }

        public Criteria andGreenNumberPlateCountsLessThan(Integer value) {
            addCriterion("green_number_plate_counts <", value, "greenNumberPlateCounts");
            return (Criteria) this;
        }

        public Criteria andGreenNumberPlateCountsLessThanOrEqualTo(Integer value) {
            addCriterion("green_number_plate_counts <=", value, "greenNumberPlateCounts");
            return (Criteria) this;
        }

        public Criteria andGreenNumberPlateCountsIn(List<Integer> values) {
            addCriterion("green_number_plate_counts in", values, "greenNumberPlateCounts");
            return (Criteria) this;
        }

        public Criteria andGreenNumberPlateCountsNotIn(List<Integer> values) {
            addCriterion("green_number_plate_counts not in", values, "greenNumberPlateCounts");
            return (Criteria) this;
        }

        public Criteria andGreenNumberPlateCountsBetween(Integer value1, Integer value2) {
            addCriterion("green_number_plate_counts between", value1, value2, "greenNumberPlateCounts");
            return (Criteria) this;
        }

        public Criteria andGreenNumberPlateCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("green_number_plate_counts not between", value1, value2, "greenNumberPlateCounts");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}