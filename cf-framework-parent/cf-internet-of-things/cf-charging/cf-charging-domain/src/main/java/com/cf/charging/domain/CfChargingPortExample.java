package com.cf.charging.domain;

import java.util.ArrayList;
import java.util.List;

public class CfChargingPortExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfChargingPortExample() {
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

        public Criteria andPortNumberIsNull() {
            addCriterion("port_number is null");
            return (Criteria) this;
        }

        public Criteria andPortNumberIsNotNull() {
            addCriterion("port_number is not null");
            return (Criteria) this;
        }

        public Criteria andPortNumberEqualTo(Byte value) {
            addCriterion("port_number =", value, "portNumber");
            return (Criteria) this;
        }

        public Criteria andPortNumberNotEqualTo(Byte value) {
            addCriterion("port_number <>", value, "portNumber");
            return (Criteria) this;
        }

        public Criteria andPortNumberGreaterThan(Byte value) {
            addCriterion("port_number >", value, "portNumber");
            return (Criteria) this;
        }

        public Criteria andPortNumberGreaterThanOrEqualTo(Byte value) {
            addCriterion("port_number >=", value, "portNumber");
            return (Criteria) this;
        }

        public Criteria andPortNumberLessThan(Byte value) {
            addCriterion("port_number <", value, "portNumber");
            return (Criteria) this;
        }

        public Criteria andPortNumberLessThanOrEqualTo(Byte value) {
            addCriterion("port_number <=", value, "portNumber");
            return (Criteria) this;
        }

        public Criteria andPortNumberIn(List<Byte> values) {
            addCriterion("port_number in", values, "portNumber");
            return (Criteria) this;
        }

        public Criteria andPortNumberNotIn(List<Byte> values) {
            addCriterion("port_number not in", values, "portNumber");
            return (Criteria) this;
        }

        public Criteria andPortNumberBetween(Byte value1, Byte value2) {
            addCriterion("port_number between", value1, value2, "portNumber");
            return (Criteria) this;
        }

        public Criteria andPortNumberNotBetween(Byte value1, Byte value2) {
            addCriterion("port_number not between", value1, value2, "portNumber");
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