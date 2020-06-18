package com.cf.carpark.domain;

import java.util.ArrayList;
import java.util.List;

public class CfCarParkUseLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfCarParkUseLogExample() {
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

        public Criteria andCarParkIdIsNull() {
            addCriterion("car_park_id is null");
            return (Criteria) this;
        }

        public Criteria andCarParkIdIsNotNull() {
            addCriterion("car_park_id is not null");
            return (Criteria) this;
        }

        public Criteria andCarParkIdEqualTo(String value) {
            addCriterion("car_park_id =", value, "carParkId");
            return (Criteria) this;
        }

        public Criteria andCarParkIdNotEqualTo(String value) {
            addCriterion("car_park_id <>", value, "carParkId");
            return (Criteria) this;
        }

        public Criteria andCarParkIdGreaterThan(String value) {
            addCriterion("car_park_id >", value, "carParkId");
            return (Criteria) this;
        }

        public Criteria andCarParkIdGreaterThanOrEqualTo(String value) {
            addCriterion("car_park_id >=", value, "carParkId");
            return (Criteria) this;
        }

        public Criteria andCarParkIdLessThan(String value) {
            addCriterion("car_park_id <", value, "carParkId");
            return (Criteria) this;
        }

        public Criteria andCarParkIdLessThanOrEqualTo(String value) {
            addCriterion("car_park_id <=", value, "carParkId");
            return (Criteria) this;
        }

        public Criteria andCarParkIdLike(String value) {
            addCriterion("car_park_id like", value, "carParkId");
            return (Criteria) this;
        }

        public Criteria andCarParkIdNotLike(String value) {
            addCriterion("car_park_id not like", value, "carParkId");
            return (Criteria) this;
        }

        public Criteria andCarParkIdIn(List<String> values) {
            addCriterion("car_park_id in", values, "carParkId");
            return (Criteria) this;
        }

        public Criteria andCarParkIdNotIn(List<String> values) {
            addCriterion("car_park_id not in", values, "carParkId");
            return (Criteria) this;
        }

        public Criteria andCarParkIdBetween(String value1, String value2) {
            addCriterion("car_park_id between", value1, value2, "carParkId");
            return (Criteria) this;
        }

        public Criteria andCarParkIdNotBetween(String value1, String value2) {
            addCriterion("car_park_id not between", value1, value2, "carParkId");
            return (Criteria) this;
        }

        public Criteria andInTimeIsNull() {
            addCriterion("in_time is null");
            return (Criteria) this;
        }

        public Criteria andInTimeIsNotNull() {
            addCriterion("in_time is not null");
            return (Criteria) this;
        }

        public Criteria andInTimeEqualTo(Long value) {
            addCriterion("in_time =", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotEqualTo(Long value) {
            addCriterion("in_time <>", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeGreaterThan(Long value) {
            addCriterion("in_time >", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("in_time >=", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeLessThan(Long value) {
            addCriterion("in_time <", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeLessThanOrEqualTo(Long value) {
            addCriterion("in_time <=", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeIn(List<Long> values) {
            addCriterion("in_time in", values, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotIn(List<Long> values) {
            addCriterion("in_time not in", values, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeBetween(Long value1, Long value2) {
            addCriterion("in_time between", value1, value2, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotBetween(Long value1, Long value2) {
            addCriterion("in_time not between", value1, value2, "inTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeIsNull() {
            addCriterion("out_time is null");
            return (Criteria) this;
        }

        public Criteria andOutTimeIsNotNull() {
            addCriterion("out_time is not null");
            return (Criteria) this;
        }

        public Criteria andOutTimeEqualTo(Long value) {
            addCriterion("out_time =", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotEqualTo(Long value) {
            addCriterion("out_time <>", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeGreaterThan(Long value) {
            addCriterion("out_time >", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("out_time >=", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeLessThan(Long value) {
            addCriterion("out_time <", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeLessThanOrEqualTo(Long value) {
            addCriterion("out_time <=", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeIn(List<Long> values) {
            addCriterion("out_time in", values, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotIn(List<Long> values) {
            addCriterion("out_time not in", values, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeBetween(Long value1, Long value2) {
            addCriterion("out_time between", value1, value2, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotBetween(Long value1, Long value2) {
            addCriterion("out_time not between", value1, value2, "outTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTypeIsNull() {
            addCriterion("release_type is null");
            return (Criteria) this;
        }

        public Criteria andReleaseTypeIsNotNull() {
            addCriterion("release_type is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseTypeEqualTo(Byte value) {
            addCriterion("release_type =", value, "releaseType");
            return (Criteria) this;
        }

        public Criteria andReleaseTypeNotEqualTo(Byte value) {
            addCriterion("release_type <>", value, "releaseType");
            return (Criteria) this;
        }

        public Criteria andReleaseTypeGreaterThan(Byte value) {
            addCriterion("release_type >", value, "releaseType");
            return (Criteria) this;
        }

        public Criteria andReleaseTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("release_type >=", value, "releaseType");
            return (Criteria) this;
        }

        public Criteria andReleaseTypeLessThan(Byte value) {
            addCriterion("release_type <", value, "releaseType");
            return (Criteria) this;
        }

        public Criteria andReleaseTypeLessThanOrEqualTo(Byte value) {
            addCriterion("release_type <=", value, "releaseType");
            return (Criteria) this;
        }

        public Criteria andReleaseTypeIn(List<Byte> values) {
            addCriterion("release_type in", values, "releaseType");
            return (Criteria) this;
        }

        public Criteria andReleaseTypeNotIn(List<Byte> values) {
            addCriterion("release_type not in", values, "releaseType");
            return (Criteria) this;
        }

        public Criteria andReleaseTypeBetween(Byte value1, Byte value2) {
            addCriterion("release_type between", value1, value2, "releaseType");
            return (Criteria) this;
        }

        public Criteria andReleaseTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("release_type not between", value1, value2, "releaseType");
            return (Criteria) this;
        }

        public Criteria andInCheckPointIdIsNull() {
            addCriterion("in_check_point_id is null");
            return (Criteria) this;
        }

        public Criteria andInCheckPointIdIsNotNull() {
            addCriterion("in_check_point_id is not null");
            return (Criteria) this;
        }

        public Criteria andInCheckPointIdEqualTo(String value) {
            addCriterion("in_check_point_id =", value, "inCheckPointId");
            return (Criteria) this;
        }

        public Criteria andInCheckPointIdNotEqualTo(String value) {
            addCriterion("in_check_point_id <>", value, "inCheckPointId");
            return (Criteria) this;
        }

        public Criteria andInCheckPointIdGreaterThan(String value) {
            addCriterion("in_check_point_id >", value, "inCheckPointId");
            return (Criteria) this;
        }

        public Criteria andInCheckPointIdGreaterThanOrEqualTo(String value) {
            addCriterion("in_check_point_id >=", value, "inCheckPointId");
            return (Criteria) this;
        }

        public Criteria andInCheckPointIdLessThan(String value) {
            addCriterion("in_check_point_id <", value, "inCheckPointId");
            return (Criteria) this;
        }

        public Criteria andInCheckPointIdLessThanOrEqualTo(String value) {
            addCriterion("in_check_point_id <=", value, "inCheckPointId");
            return (Criteria) this;
        }

        public Criteria andInCheckPointIdLike(String value) {
            addCriterion("in_check_point_id like", value, "inCheckPointId");
            return (Criteria) this;
        }

        public Criteria andInCheckPointIdNotLike(String value) {
            addCriterion("in_check_point_id not like", value, "inCheckPointId");
            return (Criteria) this;
        }

        public Criteria andInCheckPointIdIn(List<String> values) {
            addCriterion("in_check_point_id in", values, "inCheckPointId");
            return (Criteria) this;
        }

        public Criteria andInCheckPointIdNotIn(List<String> values) {
            addCriterion("in_check_point_id not in", values, "inCheckPointId");
            return (Criteria) this;
        }

        public Criteria andInCheckPointIdBetween(String value1, String value2) {
            addCriterion("in_check_point_id between", value1, value2, "inCheckPointId");
            return (Criteria) this;
        }

        public Criteria andInCheckPointIdNotBetween(String value1, String value2) {
            addCriterion("in_check_point_id not between", value1, value2, "inCheckPointId");
            return (Criteria) this;
        }

        public Criteria andOutCheckPointIdIsNull() {
            addCriterion("out_check_point_id is null");
            return (Criteria) this;
        }

        public Criteria andOutCheckPointIdIsNotNull() {
            addCriterion("out_check_point_id is not null");
            return (Criteria) this;
        }

        public Criteria andOutCheckPointIdEqualTo(String value) {
            addCriterion("out_check_point_id =", value, "outCheckPointId");
            return (Criteria) this;
        }

        public Criteria andOutCheckPointIdNotEqualTo(String value) {
            addCriterion("out_check_point_id <>", value, "outCheckPointId");
            return (Criteria) this;
        }

        public Criteria andOutCheckPointIdGreaterThan(String value) {
            addCriterion("out_check_point_id >", value, "outCheckPointId");
            return (Criteria) this;
        }

        public Criteria andOutCheckPointIdGreaterThanOrEqualTo(String value) {
            addCriterion("out_check_point_id >=", value, "outCheckPointId");
            return (Criteria) this;
        }

        public Criteria andOutCheckPointIdLessThan(String value) {
            addCriterion("out_check_point_id <", value, "outCheckPointId");
            return (Criteria) this;
        }

        public Criteria andOutCheckPointIdLessThanOrEqualTo(String value) {
            addCriterion("out_check_point_id <=", value, "outCheckPointId");
            return (Criteria) this;
        }

        public Criteria andOutCheckPointIdLike(String value) {
            addCriterion("out_check_point_id like", value, "outCheckPointId");
            return (Criteria) this;
        }

        public Criteria andOutCheckPointIdNotLike(String value) {
            addCriterion("out_check_point_id not like", value, "outCheckPointId");
            return (Criteria) this;
        }

        public Criteria andOutCheckPointIdIn(List<String> values) {
            addCriterion("out_check_point_id in", values, "outCheckPointId");
            return (Criteria) this;
        }

        public Criteria andOutCheckPointIdNotIn(List<String> values) {
            addCriterion("out_check_point_id not in", values, "outCheckPointId");
            return (Criteria) this;
        }

        public Criteria andOutCheckPointIdBetween(String value1, String value2) {
            addCriterion("out_check_point_id between", value1, value2, "outCheckPointId");
            return (Criteria) this;
        }

        public Criteria andOutCheckPointIdNotBetween(String value1, String value2) {
            addCriterion("out_check_point_id not between", value1, value2, "outCheckPointId");
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