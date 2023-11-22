package com.cf.carpark.domain;

import java.util.ArrayList;
import java.util.List;

public class CfCarParkReleaseLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfCarParkReleaseLogExample() {
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

        public Criteria andCarparkUseLogIdIsNull() {
            addCriterion("carpark_use_log_id is null");
            return (Criteria) this;
        }

        public Criteria andCarparkUseLogIdIsNotNull() {
            addCriterion("carpark_use_log_id is not null");
            return (Criteria) this;
        }

        public Criteria andCarparkUseLogIdEqualTo(String value) {
            addCriterion("carpark_use_log_id =", value, "carparkUseLogId");
            return (Criteria) this;
        }

        public Criteria andCarparkUseLogIdNotEqualTo(String value) {
            addCriterion("carpark_use_log_id <>", value, "carparkUseLogId");
            return (Criteria) this;
        }

        public Criteria andCarparkUseLogIdGreaterThan(String value) {
            addCriterion("carpark_use_log_id >", value, "carparkUseLogId");
            return (Criteria) this;
        }

        public Criteria andCarparkUseLogIdGreaterThanOrEqualTo(String value) {
            addCriterion("carpark_use_log_id >=", value, "carparkUseLogId");
            return (Criteria) this;
        }

        public Criteria andCarparkUseLogIdLessThan(String value) {
            addCriterion("carpark_use_log_id <", value, "carparkUseLogId");
            return (Criteria) this;
        }

        public Criteria andCarparkUseLogIdLessThanOrEqualTo(String value) {
            addCriterion("carpark_use_log_id <=", value, "carparkUseLogId");
            return (Criteria) this;
        }

        public Criteria andCarparkUseLogIdLike(String value) {
            addCriterion("carpark_use_log_id like", value, "carparkUseLogId");
            return (Criteria) this;
        }

        public Criteria andCarparkUseLogIdNotLike(String value) {
            addCriterion("carpark_use_log_id not like", value, "carparkUseLogId");
            return (Criteria) this;
        }

        public Criteria andCarparkUseLogIdIn(List<String> values) {
            addCriterion("carpark_use_log_id in", values, "carparkUseLogId");
            return (Criteria) this;
        }

        public Criteria andCarparkUseLogIdNotIn(List<String> values) {
            addCriterion("carpark_use_log_id not in", values, "carparkUseLogId");
            return (Criteria) this;
        }

        public Criteria andCarparkUseLogIdBetween(String value1, String value2) {
            addCriterion("carpark_use_log_id between", value1, value2, "carparkUseLogId");
            return (Criteria) this;
        }

        public Criteria andCarparkUseLogIdNotBetween(String value1, String value2) {
            addCriterion("carpark_use_log_id not between", value1, value2, "carparkUseLogId");
            return (Criteria) this;
        }

        public Criteria andNumberPlateIsNull() {
            addCriterion("number_plate is null");
            return (Criteria) this;
        }

        public Criteria andNumberPlateIsNotNull() {
            addCriterion("number_plate is not null");
            return (Criteria) this;
        }

        public Criteria andNumberPlateEqualTo(String value) {
            addCriterion("number_plate =", value, "numberPlate");
            return (Criteria) this;
        }

        public Criteria andNumberPlateNotEqualTo(String value) {
            addCriterion("number_plate <>", value, "numberPlate");
            return (Criteria) this;
        }

        public Criteria andNumberPlateGreaterThan(String value) {
            addCriterion("number_plate >", value, "numberPlate");
            return (Criteria) this;
        }

        public Criteria andNumberPlateGreaterThanOrEqualTo(String value) {
            addCriterion("number_plate >=", value, "numberPlate");
            return (Criteria) this;
        }

        public Criteria andNumberPlateLessThan(String value) {
            addCriterion("number_plate <", value, "numberPlate");
            return (Criteria) this;
        }

        public Criteria andNumberPlateLessThanOrEqualTo(String value) {
            addCriterion("number_plate <=", value, "numberPlate");
            return (Criteria) this;
        }

        public Criteria andNumberPlateLike(String value) {
            addCriterion("number_plate like", value, "numberPlate");
            return (Criteria) this;
        }

        public Criteria andNumberPlateNotLike(String value) {
            addCriterion("number_plate not like", value, "numberPlate");
            return (Criteria) this;
        }

        public Criteria andNumberPlateIn(List<String> values) {
            addCriterion("number_plate in", values, "numberPlate");
            return (Criteria) this;
        }

        public Criteria andNumberPlateNotIn(List<String> values) {
            addCriterion("number_plate not in", values, "numberPlate");
            return (Criteria) this;
        }

        public Criteria andNumberPlateBetween(String value1, String value2) {
            addCriterion("number_plate between", value1, value2, "numberPlate");
            return (Criteria) this;
        }

        public Criteria andNumberPlateNotBetween(String value1, String value2) {
            addCriterion("number_plate not between", value1, value2, "numberPlate");
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

        public Criteria andDeviceSerialNumberIsNull() {
            addCriterion("device_serial_number is null");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberIsNotNull() {
            addCriterion("device_serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberEqualTo(String value) {
            addCriterion("device_serial_number =", value, "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberNotEqualTo(String value) {
            addCriterion("device_serial_number <>", value, "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberGreaterThan(String value) {
            addCriterion("device_serial_number >", value, "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("device_serial_number >=", value, "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberLessThan(String value) {
            addCriterion("device_serial_number <", value, "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("device_serial_number <=", value, "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberLike(String value) {
            addCriterion("device_serial_number like", value, "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberNotLike(String value) {
            addCriterion("device_serial_number not like", value, "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberIn(List<String> values) {
            addCriterion("device_serial_number in", values, "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberNotIn(List<String> values) {
            addCriterion("device_serial_number not in", values, "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberBetween(String value1, String value2) {
            addCriterion("device_serial_number between", value1, value2, "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceSerialNumberNotBetween(String value1, String value2) {
            addCriterion("device_serial_number not between", value1, value2, "deviceSerialNumber");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeIsNull() {
            addCriterion("application_time is null");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeIsNotNull() {
            addCriterion("application_time is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeEqualTo(Long value) {
            addCriterion("application_time =", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeNotEqualTo(Long value) {
            addCriterion("application_time <>", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeGreaterThan(Long value) {
            addCriterion("application_time >", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("application_time >=", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeLessThan(Long value) {
            addCriterion("application_time <", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeLessThanOrEqualTo(Long value) {
            addCriterion("application_time <=", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeIn(List<Long> values) {
            addCriterion("application_time in", values, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeNotIn(List<Long> values) {
            addCriterion("application_time not in", values, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeBetween(Long value1, Long value2) {
            addCriterion("application_time between", value1, value2, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeNotBetween(Long value1, Long value2) {
            addCriterion("application_time not between", value1, value2, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonIsNull() {
            addCriterion("application_reason is null");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonIsNotNull() {
            addCriterion("application_reason is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonEqualTo(String value) {
            addCriterion("application_reason =", value, "applicationReason");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonNotEqualTo(String value) {
            addCriterion("application_reason <>", value, "applicationReason");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonGreaterThan(String value) {
            addCriterion("application_reason >", value, "applicationReason");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonGreaterThanOrEqualTo(String value) {
            addCriterion("application_reason >=", value, "applicationReason");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonLessThan(String value) {
            addCriterion("application_reason <", value, "applicationReason");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonLessThanOrEqualTo(String value) {
            addCriterion("application_reason <=", value, "applicationReason");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonLike(String value) {
            addCriterion("application_reason like", value, "applicationReason");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonNotLike(String value) {
            addCriterion("application_reason not like", value, "applicationReason");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonIn(List<String> values) {
            addCriterion("application_reason in", values, "applicationReason");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonNotIn(List<String> values) {
            addCriterion("application_reason not in", values, "applicationReason");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonBetween(String value1, String value2) {
            addCriterion("application_reason between", value1, value2, "applicationReason");
            return (Criteria) this;
        }

        public Criteria andApplicationReasonNotBetween(String value1, String value2) {
            addCriterion("application_reason not between", value1, value2, "applicationReason");
            return (Criteria) this;
        }

        public Criteria andExecutionTimeIsNull() {
            addCriterion("execution_time is null");
            return (Criteria) this;
        }

        public Criteria andExecutionTimeIsNotNull() {
            addCriterion("execution_time is not null");
            return (Criteria) this;
        }

        public Criteria andExecutionTimeEqualTo(Long value) {
            addCriterion("execution_time =", value, "executionTime");
            return (Criteria) this;
        }

        public Criteria andExecutionTimeNotEqualTo(Long value) {
            addCriterion("execution_time <>", value, "executionTime");
            return (Criteria) this;
        }

        public Criteria andExecutionTimeGreaterThan(Long value) {
            addCriterion("execution_time >", value, "executionTime");
            return (Criteria) this;
        }

        public Criteria andExecutionTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("execution_time >=", value, "executionTime");
            return (Criteria) this;
        }

        public Criteria andExecutionTimeLessThan(Long value) {
            addCriterion("execution_time <", value, "executionTime");
            return (Criteria) this;
        }

        public Criteria andExecutionTimeLessThanOrEqualTo(Long value) {
            addCriterion("execution_time <=", value, "executionTime");
            return (Criteria) this;
        }

        public Criteria andExecutionTimeIn(List<Long> values) {
            addCriterion("execution_time in", values, "executionTime");
            return (Criteria) this;
        }

        public Criteria andExecutionTimeNotIn(List<Long> values) {
            addCriterion("execution_time not in", values, "executionTime");
            return (Criteria) this;
        }

        public Criteria andExecutionTimeBetween(Long value1, Long value2) {
            addCriterion("execution_time between", value1, value2, "executionTime");
            return (Criteria) this;
        }

        public Criteria andExecutionTimeNotBetween(Long value1, Long value2) {
            addCriterion("execution_time not between", value1, value2, "executionTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Byte value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Byte value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Byte value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Byte value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Byte value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Byte> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Byte> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Byte value1, Byte value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("type not between", value1, value2, "type");
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