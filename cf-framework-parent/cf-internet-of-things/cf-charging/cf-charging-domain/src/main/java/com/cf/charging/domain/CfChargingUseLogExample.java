package com.cf.charging.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CfChargingUseLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfChargingUseLogExample() {
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

        public Criteria andChargingStationIdIsNull() {
            addCriterion("charging_station_id is null");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdIsNotNull() {
            addCriterion("charging_station_id is not null");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdEqualTo(String value) {
            addCriterion("charging_station_id =", value, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdNotEqualTo(String value) {
            addCriterion("charging_station_id <>", value, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdGreaterThan(String value) {
            addCriterion("charging_station_id >", value, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdGreaterThanOrEqualTo(String value) {
            addCriterion("charging_station_id >=", value, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdLessThan(String value) {
            addCriterion("charging_station_id <", value, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdLessThanOrEqualTo(String value) {
            addCriterion("charging_station_id <=", value, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdLike(String value) {
            addCriterion("charging_station_id like", value, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdNotLike(String value) {
            addCriterion("charging_station_id not like", value, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdIn(List<String> values) {
            addCriterion("charging_station_id in", values, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdNotIn(List<String> values) {
            addCriterion("charging_station_id not in", values, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdBetween(String value1, String value2) {
            addCriterion("charging_station_id between", value1, value2, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdNotBetween(String value1, String value2) {
            addCriterion("charging_station_id not between", value1, value2, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingDeviceIdIsNull() {
            addCriterion("charging_device_id is null");
            return (Criteria) this;
        }

        public Criteria andChargingDeviceIdIsNotNull() {
            addCriterion("charging_device_id is not null");
            return (Criteria) this;
        }

        public Criteria andChargingDeviceIdEqualTo(String value) {
            addCriterion("charging_device_id =", value, "chargingDeviceId");
            return (Criteria) this;
        }

        public Criteria andChargingDeviceIdNotEqualTo(String value) {
            addCriterion("charging_device_id <>", value, "chargingDeviceId");
            return (Criteria) this;
        }

        public Criteria andChargingDeviceIdGreaterThan(String value) {
            addCriterion("charging_device_id >", value, "chargingDeviceId");
            return (Criteria) this;
        }

        public Criteria andChargingDeviceIdGreaterThanOrEqualTo(String value) {
            addCriterion("charging_device_id >=", value, "chargingDeviceId");
            return (Criteria) this;
        }

        public Criteria andChargingDeviceIdLessThan(String value) {
            addCriterion("charging_device_id <", value, "chargingDeviceId");
            return (Criteria) this;
        }

        public Criteria andChargingDeviceIdLessThanOrEqualTo(String value) {
            addCriterion("charging_device_id <=", value, "chargingDeviceId");
            return (Criteria) this;
        }

        public Criteria andChargingDeviceIdLike(String value) {
            addCriterion("charging_device_id like", value, "chargingDeviceId");
            return (Criteria) this;
        }

        public Criteria andChargingDeviceIdNotLike(String value) {
            addCriterion("charging_device_id not like", value, "chargingDeviceId");
            return (Criteria) this;
        }

        public Criteria andChargingDeviceIdIn(List<String> values) {
            addCriterion("charging_device_id in", values, "chargingDeviceId");
            return (Criteria) this;
        }

        public Criteria andChargingDeviceIdNotIn(List<String> values) {
            addCriterion("charging_device_id not in", values, "chargingDeviceId");
            return (Criteria) this;
        }

        public Criteria andChargingDeviceIdBetween(String value1, String value2) {
            addCriterion("charging_device_id between", value1, value2, "chargingDeviceId");
            return (Criteria) this;
        }

        public Criteria andChargingDeviceIdNotBetween(String value1, String value2) {
            addCriterion("charging_device_id not between", value1, value2, "chargingDeviceId");
            return (Criteria) this;
        }

        public Criteria andChargingPortIsNull() {
            addCriterion("charging_port is null");
            return (Criteria) this;
        }

        public Criteria andChargingPortIsNotNull() {
            addCriterion("charging_port is not null");
            return (Criteria) this;
        }

        public Criteria andChargingPortEqualTo(String value) {
            addCriterion("charging_port =", value, "chargingPort");
            return (Criteria) this;
        }

        public Criteria andChargingPortNotEqualTo(String value) {
            addCriterion("charging_port <>", value, "chargingPort");
            return (Criteria) this;
        }

        public Criteria andChargingPortGreaterThan(String value) {
            addCriterion("charging_port >", value, "chargingPort");
            return (Criteria) this;
        }

        public Criteria andChargingPortGreaterThanOrEqualTo(String value) {
            addCriterion("charging_port >=", value, "chargingPort");
            return (Criteria) this;
        }

        public Criteria andChargingPortLessThan(String value) {
            addCriterion("charging_port <", value, "chargingPort");
            return (Criteria) this;
        }

        public Criteria andChargingPortLessThanOrEqualTo(String value) {
            addCriterion("charging_port <=", value, "chargingPort");
            return (Criteria) this;
        }

        public Criteria andChargingPortLike(String value) {
            addCriterion("charging_port like", value, "chargingPort");
            return (Criteria) this;
        }

        public Criteria andChargingPortNotLike(String value) {
            addCriterion("charging_port not like", value, "chargingPort");
            return (Criteria) this;
        }

        public Criteria andChargingPortIn(List<String> values) {
            addCriterion("charging_port in", values, "chargingPort");
            return (Criteria) this;
        }

        public Criteria andChargingPortNotIn(List<String> values) {
            addCriterion("charging_port not in", values, "chargingPort");
            return (Criteria) this;
        }

        public Criteria andChargingPortBetween(String value1, String value2) {
            addCriterion("charging_port between", value1, value2, "chargingPort");
            return (Criteria) this;
        }

        public Criteria andChargingPortNotBetween(String value1, String value2) {
            addCriterion("charging_port not between", value1, value2, "chargingPort");
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

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(String value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(String value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(String value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(String value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(String value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(String value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLike(String value) {
            addCriterion("uid like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotLike(String value) {
            addCriterion("uid not like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<String> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<String> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(String value1, String value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(String value1, String value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andChargingFeeIsNull() {
            addCriterion("charging_fee is null");
            return (Criteria) this;
        }

        public Criteria andChargingFeeIsNotNull() {
            addCriterion("charging_fee is not null");
            return (Criteria) this;
        }

        public Criteria andChargingFeeEqualTo(BigDecimal value) {
            addCriterion("charging_fee =", value, "chargingFee");
            return (Criteria) this;
        }

        public Criteria andChargingFeeNotEqualTo(BigDecimal value) {
            addCriterion("charging_fee <>", value, "chargingFee");
            return (Criteria) this;
        }

        public Criteria andChargingFeeGreaterThan(BigDecimal value) {
            addCriterion("charging_fee >", value, "chargingFee");
            return (Criteria) this;
        }

        public Criteria andChargingFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("charging_fee >=", value, "chargingFee");
            return (Criteria) this;
        }

        public Criteria andChargingFeeLessThan(BigDecimal value) {
            addCriterion("charging_fee <", value, "chargingFee");
            return (Criteria) this;
        }

        public Criteria andChargingFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("charging_fee <=", value, "chargingFee");
            return (Criteria) this;
        }

        public Criteria andChargingFeeIn(List<BigDecimal> values) {
            addCriterion("charging_fee in", values, "chargingFee");
            return (Criteria) this;
        }

        public Criteria andChargingFeeNotIn(List<BigDecimal> values) {
            addCriterion("charging_fee not in", values, "chargingFee");
            return (Criteria) this;
        }

        public Criteria andChargingFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("charging_fee between", value1, value2, "chargingFee");
            return (Criteria) this;
        }

        public Criteria andChargingFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("charging_fee not between", value1, value2, "chargingFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeIsNull() {
            addCriterion("service_fee is null");
            return (Criteria) this;
        }

        public Criteria andServiceFeeIsNotNull() {
            addCriterion("service_fee is not null");
            return (Criteria) this;
        }

        public Criteria andServiceFeeEqualTo(BigDecimal value) {
            addCriterion("service_fee =", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeNotEqualTo(BigDecimal value) {
            addCriterion("service_fee <>", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeGreaterThan(BigDecimal value) {
            addCriterion("service_fee >", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("service_fee >=", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeLessThan(BigDecimal value) {
            addCriterion("service_fee <", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("service_fee <=", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeIn(List<BigDecimal> values) {
            addCriterion("service_fee in", values, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeNotIn(List<BigDecimal> values) {
            addCriterion("service_fee not in", values, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("service_fee between", value1, value2, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("service_fee not between", value1, value2, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andPlanChargingFeeIsNull() {
            addCriterion("plan_charging_fee is null");
            return (Criteria) this;
        }

        public Criteria andPlanChargingFeeIsNotNull() {
            addCriterion("plan_charging_fee is not null");
            return (Criteria) this;
        }

        public Criteria andPlanChargingFeeEqualTo(BigDecimal value) {
            addCriterion("plan_charging_fee =", value, "planChargingFee");
            return (Criteria) this;
        }

        public Criteria andPlanChargingFeeNotEqualTo(BigDecimal value) {
            addCriterion("plan_charging_fee <>", value, "planChargingFee");
            return (Criteria) this;
        }

        public Criteria andPlanChargingFeeGreaterThan(BigDecimal value) {
            addCriterion("plan_charging_fee >", value, "planChargingFee");
            return (Criteria) this;
        }

        public Criteria andPlanChargingFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("plan_charging_fee >=", value, "planChargingFee");
            return (Criteria) this;
        }

        public Criteria andPlanChargingFeeLessThan(BigDecimal value) {
            addCriterion("plan_charging_fee <", value, "planChargingFee");
            return (Criteria) this;
        }

        public Criteria andPlanChargingFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("plan_charging_fee <=", value, "planChargingFee");
            return (Criteria) this;
        }

        public Criteria andPlanChargingFeeIn(List<BigDecimal> values) {
            addCriterion("plan_charging_fee in", values, "planChargingFee");
            return (Criteria) this;
        }

        public Criteria andPlanChargingFeeNotIn(List<BigDecimal> values) {
            addCriterion("plan_charging_fee not in", values, "planChargingFee");
            return (Criteria) this;
        }

        public Criteria andPlanChargingFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("plan_charging_fee between", value1, value2, "planChargingFee");
            return (Criteria) this;
        }

        public Criteria andPlanChargingFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("plan_charging_fee not between", value1, value2, "planChargingFee");
            return (Criteria) this;
        }

        public Criteria andChargingedKwhIsNull() {
            addCriterion("charginged_kwh is null");
            return (Criteria) this;
        }

        public Criteria andChargingedKwhIsNotNull() {
            addCriterion("charginged_kwh is not null");
            return (Criteria) this;
        }

        public Criteria andChargingedKwhEqualTo(Float value) {
            addCriterion("charginged_kwh =", value, "chargingedKwh");
            return (Criteria) this;
        }

        public Criteria andChargingedKwhNotEqualTo(Float value) {
            addCriterion("charginged_kwh <>", value, "chargingedKwh");
            return (Criteria) this;
        }

        public Criteria andChargingedKwhGreaterThan(Float value) {
            addCriterion("charginged_kwh >", value, "chargingedKwh");
            return (Criteria) this;
        }

        public Criteria andChargingedKwhGreaterThanOrEqualTo(Float value) {
            addCriterion("charginged_kwh >=", value, "chargingedKwh");
            return (Criteria) this;
        }

        public Criteria andChargingedKwhLessThan(Float value) {
            addCriterion("charginged_kwh <", value, "chargingedKwh");
            return (Criteria) this;
        }

        public Criteria andChargingedKwhLessThanOrEqualTo(Float value) {
            addCriterion("charginged_kwh <=", value, "chargingedKwh");
            return (Criteria) this;
        }

        public Criteria andChargingedKwhIn(List<Float> values) {
            addCriterion("charginged_kwh in", values, "chargingedKwh");
            return (Criteria) this;
        }

        public Criteria andChargingedKwhNotIn(List<Float> values) {
            addCriterion("charginged_kwh not in", values, "chargingedKwh");
            return (Criteria) this;
        }

        public Criteria andChargingedKwhBetween(Float value1, Float value2) {
            addCriterion("charginged_kwh between", value1, value2, "chargingedKwh");
            return (Criteria) this;
        }

        public Criteria andChargingedKwhNotBetween(Float value1, Float value2) {
            addCriterion("charginged_kwh not between", value1, value2, "chargingedKwh");
            return (Criteria) this;
        }

        public Criteria andPlanChargingKwhIsNull() {
            addCriterion("plan_charging_kwh is null");
            return (Criteria) this;
        }

        public Criteria andPlanChargingKwhIsNotNull() {
            addCriterion("plan_charging_kwh is not null");
            return (Criteria) this;
        }

        public Criteria andPlanChargingKwhEqualTo(Float value) {
            addCriterion("plan_charging_kwh =", value, "planChargingKwh");
            return (Criteria) this;
        }

        public Criteria andPlanChargingKwhNotEqualTo(Float value) {
            addCriterion("plan_charging_kwh <>", value, "planChargingKwh");
            return (Criteria) this;
        }

        public Criteria andPlanChargingKwhGreaterThan(Float value) {
            addCriterion("plan_charging_kwh >", value, "planChargingKwh");
            return (Criteria) this;
        }

        public Criteria andPlanChargingKwhGreaterThanOrEqualTo(Float value) {
            addCriterion("plan_charging_kwh >=", value, "planChargingKwh");
            return (Criteria) this;
        }

        public Criteria andPlanChargingKwhLessThan(Float value) {
            addCriterion("plan_charging_kwh <", value, "planChargingKwh");
            return (Criteria) this;
        }

        public Criteria andPlanChargingKwhLessThanOrEqualTo(Float value) {
            addCriterion("plan_charging_kwh <=", value, "planChargingKwh");
            return (Criteria) this;
        }

        public Criteria andPlanChargingKwhIn(List<Float> values) {
            addCriterion("plan_charging_kwh in", values, "planChargingKwh");
            return (Criteria) this;
        }

        public Criteria andPlanChargingKwhNotIn(List<Float> values) {
            addCriterion("plan_charging_kwh not in", values, "planChargingKwh");
            return (Criteria) this;
        }

        public Criteria andPlanChargingKwhBetween(Float value1, Float value2) {
            addCriterion("plan_charging_kwh between", value1, value2, "planChargingKwh");
            return (Criteria) this;
        }

        public Criteria andPlanChargingKwhNotBetween(Float value1, Float value2) {
            addCriterion("plan_charging_kwh not between", value1, value2, "planChargingKwh");
            return (Criteria) this;
        }

        public Criteria andChargingPriceIsNull() {
            addCriterion("charging_price is null");
            return (Criteria) this;
        }

        public Criteria andChargingPriceIsNotNull() {
            addCriterion("charging_price is not null");
            return (Criteria) this;
        }

        public Criteria andChargingPriceEqualTo(BigDecimal value) {
            addCriterion("charging_price =", value, "chargingPrice");
            return (Criteria) this;
        }

        public Criteria andChargingPriceNotEqualTo(BigDecimal value) {
            addCriterion("charging_price <>", value, "chargingPrice");
            return (Criteria) this;
        }

        public Criteria andChargingPriceGreaterThan(BigDecimal value) {
            addCriterion("charging_price >", value, "chargingPrice");
            return (Criteria) this;
        }

        public Criteria andChargingPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("charging_price >=", value, "chargingPrice");
            return (Criteria) this;
        }

        public Criteria andChargingPriceLessThan(BigDecimal value) {
            addCriterion("charging_price <", value, "chargingPrice");
            return (Criteria) this;
        }

        public Criteria andChargingPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("charging_price <=", value, "chargingPrice");
            return (Criteria) this;
        }

        public Criteria andChargingPriceIn(List<BigDecimal> values) {
            addCriterion("charging_price in", values, "chargingPrice");
            return (Criteria) this;
        }

        public Criteria andChargingPriceNotIn(List<BigDecimal> values) {
            addCriterion("charging_price not in", values, "chargingPrice");
            return (Criteria) this;
        }

        public Criteria andChargingPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("charging_price between", value1, value2, "chargingPrice");
            return (Criteria) this;
        }

        public Criteria andChargingPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("charging_price not between", value1, value2, "chargingPrice");
            return (Criteria) this;
        }

        public Criteria andChargingStatusIsNull() {
            addCriterion("charging_status is null");
            return (Criteria) this;
        }

        public Criteria andChargingStatusIsNotNull() {
            addCriterion("charging_status is not null");
            return (Criteria) this;
        }

        public Criteria andChargingStatusEqualTo(Byte value) {
            addCriterion("charging_status =", value, "chargingStatus");
            return (Criteria) this;
        }

        public Criteria andChargingStatusNotEqualTo(Byte value) {
            addCriterion("charging_status <>", value, "chargingStatus");
            return (Criteria) this;
        }

        public Criteria andChargingStatusGreaterThan(Byte value) {
            addCriterion("charging_status >", value, "chargingStatus");
            return (Criteria) this;
        }

        public Criteria andChargingStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("charging_status >=", value, "chargingStatus");
            return (Criteria) this;
        }

        public Criteria andChargingStatusLessThan(Byte value) {
            addCriterion("charging_status <", value, "chargingStatus");
            return (Criteria) this;
        }

        public Criteria andChargingStatusLessThanOrEqualTo(Byte value) {
            addCriterion("charging_status <=", value, "chargingStatus");
            return (Criteria) this;
        }

        public Criteria andChargingStatusIn(List<Byte> values) {
            addCriterion("charging_status in", values, "chargingStatus");
            return (Criteria) this;
        }

        public Criteria andChargingStatusNotIn(List<Byte> values) {
            addCriterion("charging_status not in", values, "chargingStatus");
            return (Criteria) this;
        }

        public Criteria andChargingStatusBetween(Byte value1, Byte value2) {
            addCriterion("charging_status between", value1, value2, "chargingStatus");
            return (Criteria) this;
        }

        public Criteria andChargingStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("charging_status not between", value1, value2, "chargingStatus");
            return (Criteria) this;
        }

        public Criteria andEndReasonIsNull() {
            addCriterion("end_reason is null");
            return (Criteria) this;
        }

        public Criteria andEndReasonIsNotNull() {
            addCriterion("end_reason is not null");
            return (Criteria) this;
        }

        public Criteria andEndReasonEqualTo(String value) {
            addCriterion("end_reason =", value, "endReason");
            return (Criteria) this;
        }

        public Criteria andEndReasonNotEqualTo(String value) {
            addCriterion("end_reason <>", value, "endReason");
            return (Criteria) this;
        }

        public Criteria andEndReasonGreaterThan(String value) {
            addCriterion("end_reason >", value, "endReason");
            return (Criteria) this;
        }

        public Criteria andEndReasonGreaterThanOrEqualTo(String value) {
            addCriterion("end_reason >=", value, "endReason");
            return (Criteria) this;
        }

        public Criteria andEndReasonLessThan(String value) {
            addCriterion("end_reason <", value, "endReason");
            return (Criteria) this;
        }

        public Criteria andEndReasonLessThanOrEqualTo(String value) {
            addCriterion("end_reason <=", value, "endReason");
            return (Criteria) this;
        }

        public Criteria andEndReasonLike(String value) {
            addCriterion("end_reason like", value, "endReason");
            return (Criteria) this;
        }

        public Criteria andEndReasonNotLike(String value) {
            addCriterion("end_reason not like", value, "endReason");
            return (Criteria) this;
        }

        public Criteria andEndReasonIn(List<String> values) {
            addCriterion("end_reason in", values, "endReason");
            return (Criteria) this;
        }

        public Criteria andEndReasonNotIn(List<String> values) {
            addCriterion("end_reason not in", values, "endReason");
            return (Criteria) this;
        }

        public Criteria andEndReasonBetween(String value1, String value2) {
            addCriterion("end_reason between", value1, value2, "endReason");
            return (Criteria) this;
        }

        public Criteria andEndReasonNotBetween(String value1, String value2) {
            addCriterion("end_reason not between", value1, value2, "endReason");
            return (Criteria) this;
        }

        public Criteria andServicePriceIsNull() {
            addCriterion("service_price is null");
            return (Criteria) this;
        }

        public Criteria andServicePriceIsNotNull() {
            addCriterion("service_price is not null");
            return (Criteria) this;
        }

        public Criteria andServicePriceEqualTo(BigDecimal value) {
            addCriterion("service_price =", value, "servicePrice");
            return (Criteria) this;
        }

        public Criteria andServicePriceNotEqualTo(BigDecimal value) {
            addCriterion("service_price <>", value, "servicePrice");
            return (Criteria) this;
        }

        public Criteria andServicePriceGreaterThan(BigDecimal value) {
            addCriterion("service_price >", value, "servicePrice");
            return (Criteria) this;
        }

        public Criteria andServicePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("service_price >=", value, "servicePrice");
            return (Criteria) this;
        }

        public Criteria andServicePriceLessThan(BigDecimal value) {
            addCriterion("service_price <", value, "servicePrice");
            return (Criteria) this;
        }

        public Criteria andServicePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("service_price <=", value, "servicePrice");
            return (Criteria) this;
        }

        public Criteria andServicePriceIn(List<BigDecimal> values) {
            addCriterion("service_price in", values, "servicePrice");
            return (Criteria) this;
        }

        public Criteria andServicePriceNotIn(List<BigDecimal> values) {
            addCriterion("service_price not in", values, "servicePrice");
            return (Criteria) this;
        }

        public Criteria andServicePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("service_price between", value1, value2, "servicePrice");
            return (Criteria) this;
        }

        public Criteria andServicePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("service_price not between", value1, value2, "servicePrice");
            return (Criteria) this;
        }

        public Criteria andChargingPowerIsNull() {
            addCriterion("charging_power is null");
            return (Criteria) this;
        }

        public Criteria andChargingPowerIsNotNull() {
            addCriterion("charging_power is not null");
            return (Criteria) this;
        }

        public Criteria andChargingPowerEqualTo(Integer value) {
            addCriterion("charging_power =", value, "chargingPower");
            return (Criteria) this;
        }

        public Criteria andChargingPowerNotEqualTo(Integer value) {
            addCriterion("charging_power <>", value, "chargingPower");
            return (Criteria) this;
        }

        public Criteria andChargingPowerGreaterThan(Integer value) {
            addCriterion("charging_power >", value, "chargingPower");
            return (Criteria) this;
        }

        public Criteria andChargingPowerGreaterThanOrEqualTo(Integer value) {
            addCriterion("charging_power >=", value, "chargingPower");
            return (Criteria) this;
        }

        public Criteria andChargingPowerLessThan(Integer value) {
            addCriterion("charging_power <", value, "chargingPower");
            return (Criteria) this;
        }

        public Criteria andChargingPowerLessThanOrEqualTo(Integer value) {
            addCriterion("charging_power <=", value, "chargingPower");
            return (Criteria) this;
        }

        public Criteria andChargingPowerIn(List<Integer> values) {
            addCriterion("charging_power in", values, "chargingPower");
            return (Criteria) this;
        }

        public Criteria andChargingPowerNotIn(List<Integer> values) {
            addCriterion("charging_power not in", values, "chargingPower");
            return (Criteria) this;
        }

        public Criteria andChargingPowerBetween(Integer value1, Integer value2) {
            addCriterion("charging_power between", value1, value2, "chargingPower");
            return (Criteria) this;
        }

        public Criteria andChargingPowerNotBetween(Integer value1, Integer value2) {
            addCriterion("charging_power not between", value1, value2, "chargingPower");
            return (Criteria) this;
        }

        public Criteria andPlanChargingTimeIsNull() {
            addCriterion("plan_charging_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanChargingTimeIsNotNull() {
            addCriterion("plan_charging_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanChargingTimeEqualTo(Long value) {
            addCriterion("plan_charging_time =", value, "planChargingTime");
            return (Criteria) this;
        }

        public Criteria andPlanChargingTimeNotEqualTo(Long value) {
            addCriterion("plan_charging_time <>", value, "planChargingTime");
            return (Criteria) this;
        }

        public Criteria andPlanChargingTimeGreaterThan(Long value) {
            addCriterion("plan_charging_time >", value, "planChargingTime");
            return (Criteria) this;
        }

        public Criteria andPlanChargingTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("plan_charging_time >=", value, "planChargingTime");
            return (Criteria) this;
        }

        public Criteria andPlanChargingTimeLessThan(Long value) {
            addCriterion("plan_charging_time <", value, "planChargingTime");
            return (Criteria) this;
        }

        public Criteria andPlanChargingTimeLessThanOrEqualTo(Long value) {
            addCriterion("plan_charging_time <=", value, "planChargingTime");
            return (Criteria) this;
        }

        public Criteria andPlanChargingTimeIn(List<Long> values) {
            addCriterion("plan_charging_time in", values, "planChargingTime");
            return (Criteria) this;
        }

        public Criteria andPlanChargingTimeNotIn(List<Long> values) {
            addCriterion("plan_charging_time not in", values, "planChargingTime");
            return (Criteria) this;
        }

        public Criteria andPlanChargingTimeBetween(Long value1, Long value2) {
            addCriterion("plan_charging_time between", value1, value2, "planChargingTime");
            return (Criteria) this;
        }

        public Criteria andPlanChargingTimeNotBetween(Long value1, Long value2) {
            addCriterion("plan_charging_time not between", value1, value2, "planChargingTime");
            return (Criteria) this;
        }

        public Criteria andChargingTypeIsNull() {
            addCriterion("charging_type is null");
            return (Criteria) this;
        }

        public Criteria andChargingTypeIsNotNull() {
            addCriterion("charging_type is not null");
            return (Criteria) this;
        }

        public Criteria andChargingTypeEqualTo(Byte value) {
            addCriterion("charging_type =", value, "chargingType");
            return (Criteria) this;
        }

        public Criteria andChargingTypeNotEqualTo(Byte value) {
            addCriterion("charging_type <>", value, "chargingType");
            return (Criteria) this;
        }

        public Criteria andChargingTypeGreaterThan(Byte value) {
            addCriterion("charging_type >", value, "chargingType");
            return (Criteria) this;
        }

        public Criteria andChargingTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("charging_type >=", value, "chargingType");
            return (Criteria) this;
        }

        public Criteria andChargingTypeLessThan(Byte value) {
            addCriterion("charging_type <", value, "chargingType");
            return (Criteria) this;
        }

        public Criteria andChargingTypeLessThanOrEqualTo(Byte value) {
            addCriterion("charging_type <=", value, "chargingType");
            return (Criteria) this;
        }

        public Criteria andChargingTypeIn(List<Byte> values) {
            addCriterion("charging_type in", values, "chargingType");
            return (Criteria) this;
        }

        public Criteria andChargingTypeNotIn(List<Byte> values) {
            addCriterion("charging_type not in", values, "chargingType");
            return (Criteria) this;
        }

        public Criteria andChargingTypeBetween(Byte value1, Byte value2) {
            addCriterion("charging_type between", value1, value2, "chargingType");
            return (Criteria) this;
        }

        public Criteria andChargingTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("charging_type not between", value1, value2, "chargingType");
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