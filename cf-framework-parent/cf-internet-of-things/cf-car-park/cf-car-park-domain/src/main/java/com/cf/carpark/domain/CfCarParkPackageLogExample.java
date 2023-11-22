package com.cf.carpark.domain;

import java.util.ArrayList;
import java.util.List;

public class CfCarParkPackageLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfCarParkPackageLogExample() {
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

        public Criteria andPackageIdIsNull() {
            addCriterion("package_id is null");
            return (Criteria) this;
        }

        public Criteria andPackageIdIsNotNull() {
            addCriterion("package_id is not null");
            return (Criteria) this;
        }

        public Criteria andPackageIdEqualTo(String value) {
            addCriterion("package_id =", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdNotEqualTo(String value) {
            addCriterion("package_id <>", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdGreaterThan(String value) {
            addCriterion("package_id >", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdGreaterThanOrEqualTo(String value) {
            addCriterion("package_id >=", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdLessThan(String value) {
            addCriterion("package_id <", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdLessThanOrEqualTo(String value) {
            addCriterion("package_id <=", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdLike(String value) {
            addCriterion("package_id like", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdNotLike(String value) {
            addCriterion("package_id not like", value, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdIn(List<String> values) {
            addCriterion("package_id in", values, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdNotIn(List<String> values) {
            addCriterion("package_id not in", values, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdBetween(String value1, String value2) {
            addCriterion("package_id between", value1, value2, "packageId");
            return (Criteria) this;
        }

        public Criteria andPackageIdNotBetween(String value1, String value2) {
            addCriterion("package_id not between", value1, value2, "packageId");
            return (Criteria) this;
        }

        public Criteria andBeforeCarParkIdIsNull() {
            addCriterion("before_car_park_id is null");
            return (Criteria) this;
        }

        public Criteria andBeforeCarParkIdIsNotNull() {
            addCriterion("before_car_park_id is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeCarParkIdEqualTo(String value) {
            addCriterion("before_car_park_id =", value, "beforeCarParkId");
            return (Criteria) this;
        }

        public Criteria andBeforeCarParkIdNotEqualTo(String value) {
            addCriterion("before_car_park_id <>", value, "beforeCarParkId");
            return (Criteria) this;
        }

        public Criteria andBeforeCarParkIdGreaterThan(String value) {
            addCriterion("before_car_park_id >", value, "beforeCarParkId");
            return (Criteria) this;
        }

        public Criteria andBeforeCarParkIdGreaterThanOrEqualTo(String value) {
            addCriterion("before_car_park_id >=", value, "beforeCarParkId");
            return (Criteria) this;
        }

        public Criteria andBeforeCarParkIdLessThan(String value) {
            addCriterion("before_car_park_id <", value, "beforeCarParkId");
            return (Criteria) this;
        }

        public Criteria andBeforeCarParkIdLessThanOrEqualTo(String value) {
            addCriterion("before_car_park_id <=", value, "beforeCarParkId");
            return (Criteria) this;
        }

        public Criteria andBeforeCarParkIdLike(String value) {
            addCriterion("before_car_park_id like", value, "beforeCarParkId");
            return (Criteria) this;
        }

        public Criteria andBeforeCarParkIdNotLike(String value) {
            addCriterion("before_car_park_id not like", value, "beforeCarParkId");
            return (Criteria) this;
        }

        public Criteria andBeforeCarParkIdIn(List<String> values) {
            addCriterion("before_car_park_id in", values, "beforeCarParkId");
            return (Criteria) this;
        }

        public Criteria andBeforeCarParkIdNotIn(List<String> values) {
            addCriterion("before_car_park_id not in", values, "beforeCarParkId");
            return (Criteria) this;
        }

        public Criteria andBeforeCarParkIdBetween(String value1, String value2) {
            addCriterion("before_car_park_id between", value1, value2, "beforeCarParkId");
            return (Criteria) this;
        }

        public Criteria andBeforeCarParkIdNotBetween(String value1, String value2) {
            addCriterion("before_car_park_id not between", value1, value2, "beforeCarParkId");
            return (Criteria) this;
        }

        public Criteria andAfterCarParkIdIsNull() {
            addCriterion("after_car_park_id is null");
            return (Criteria) this;
        }

        public Criteria andAfterCarParkIdIsNotNull() {
            addCriterion("after_car_park_id is not null");
            return (Criteria) this;
        }

        public Criteria andAfterCarParkIdEqualTo(String value) {
            addCriterion("after_car_park_id =", value, "afterCarParkId");
            return (Criteria) this;
        }

        public Criteria andAfterCarParkIdNotEqualTo(String value) {
            addCriterion("after_car_park_id <>", value, "afterCarParkId");
            return (Criteria) this;
        }

        public Criteria andAfterCarParkIdGreaterThan(String value) {
            addCriterion("after_car_park_id >", value, "afterCarParkId");
            return (Criteria) this;
        }

        public Criteria andAfterCarParkIdGreaterThanOrEqualTo(String value) {
            addCriterion("after_car_park_id >=", value, "afterCarParkId");
            return (Criteria) this;
        }

        public Criteria andAfterCarParkIdLessThan(String value) {
            addCriterion("after_car_park_id <", value, "afterCarParkId");
            return (Criteria) this;
        }

        public Criteria andAfterCarParkIdLessThanOrEqualTo(String value) {
            addCriterion("after_car_park_id <=", value, "afterCarParkId");
            return (Criteria) this;
        }

        public Criteria andAfterCarParkIdLike(String value) {
            addCriterion("after_car_park_id like", value, "afterCarParkId");
            return (Criteria) this;
        }

        public Criteria andAfterCarParkIdNotLike(String value) {
            addCriterion("after_car_park_id not like", value, "afterCarParkId");
            return (Criteria) this;
        }

        public Criteria andAfterCarParkIdIn(List<String> values) {
            addCriterion("after_car_park_id in", values, "afterCarParkId");
            return (Criteria) this;
        }

        public Criteria andAfterCarParkIdNotIn(List<String> values) {
            addCriterion("after_car_park_id not in", values, "afterCarParkId");
            return (Criteria) this;
        }

        public Criteria andAfterCarParkIdBetween(String value1, String value2) {
            addCriterion("after_car_park_id between", value1, value2, "afterCarParkId");
            return (Criteria) this;
        }

        public Criteria andAfterCarParkIdNotBetween(String value1, String value2) {
            addCriterion("after_car_park_id not between", value1, value2, "afterCarParkId");
            return (Criteria) this;
        }

        public Criteria andBeforeTypeKeyIsNull() {
            addCriterion("before_type_key is null");
            return (Criteria) this;
        }

        public Criteria andBeforeTypeKeyIsNotNull() {
            addCriterion("before_type_key is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeTypeKeyEqualTo(String value) {
            addCriterion("before_type_key =", value, "beforeTypeKey");
            return (Criteria) this;
        }

        public Criteria andBeforeTypeKeyNotEqualTo(String value) {
            addCriterion("before_type_key <>", value, "beforeTypeKey");
            return (Criteria) this;
        }

        public Criteria andBeforeTypeKeyGreaterThan(String value) {
            addCriterion("before_type_key >", value, "beforeTypeKey");
            return (Criteria) this;
        }

        public Criteria andBeforeTypeKeyGreaterThanOrEqualTo(String value) {
            addCriterion("before_type_key >=", value, "beforeTypeKey");
            return (Criteria) this;
        }

        public Criteria andBeforeTypeKeyLessThan(String value) {
            addCriterion("before_type_key <", value, "beforeTypeKey");
            return (Criteria) this;
        }

        public Criteria andBeforeTypeKeyLessThanOrEqualTo(String value) {
            addCriterion("before_type_key <=", value, "beforeTypeKey");
            return (Criteria) this;
        }

        public Criteria andBeforeTypeKeyLike(String value) {
            addCriterion("before_type_key like", value, "beforeTypeKey");
            return (Criteria) this;
        }

        public Criteria andBeforeTypeKeyNotLike(String value) {
            addCriterion("before_type_key not like", value, "beforeTypeKey");
            return (Criteria) this;
        }

        public Criteria andBeforeTypeKeyIn(List<String> values) {
            addCriterion("before_type_key in", values, "beforeTypeKey");
            return (Criteria) this;
        }

        public Criteria andBeforeTypeKeyNotIn(List<String> values) {
            addCriterion("before_type_key not in", values, "beforeTypeKey");
            return (Criteria) this;
        }

        public Criteria andBeforeTypeKeyBetween(String value1, String value2) {
            addCriterion("before_type_key between", value1, value2, "beforeTypeKey");
            return (Criteria) this;
        }

        public Criteria andBeforeTypeKeyNotBetween(String value1, String value2) {
            addCriterion("before_type_key not between", value1, value2, "beforeTypeKey");
            return (Criteria) this;
        }

        public Criteria andAfterTypeKeyIsNull() {
            addCriterion("after_type_key is null");
            return (Criteria) this;
        }

        public Criteria andAfterTypeKeyIsNotNull() {
            addCriterion("after_type_key is not null");
            return (Criteria) this;
        }

        public Criteria andAfterTypeKeyEqualTo(String value) {
            addCriterion("after_type_key =", value, "afterTypeKey");
            return (Criteria) this;
        }

        public Criteria andAfterTypeKeyNotEqualTo(String value) {
            addCriterion("after_type_key <>", value, "afterTypeKey");
            return (Criteria) this;
        }

        public Criteria andAfterTypeKeyGreaterThan(String value) {
            addCriterion("after_type_key >", value, "afterTypeKey");
            return (Criteria) this;
        }

        public Criteria andAfterTypeKeyGreaterThanOrEqualTo(String value) {
            addCriterion("after_type_key >=", value, "afterTypeKey");
            return (Criteria) this;
        }

        public Criteria andAfterTypeKeyLessThan(String value) {
            addCriterion("after_type_key <", value, "afterTypeKey");
            return (Criteria) this;
        }

        public Criteria andAfterTypeKeyLessThanOrEqualTo(String value) {
            addCriterion("after_type_key <=", value, "afterTypeKey");
            return (Criteria) this;
        }

        public Criteria andAfterTypeKeyLike(String value) {
            addCriterion("after_type_key like", value, "afterTypeKey");
            return (Criteria) this;
        }

        public Criteria andAfterTypeKeyNotLike(String value) {
            addCriterion("after_type_key not like", value, "afterTypeKey");
            return (Criteria) this;
        }

        public Criteria andAfterTypeKeyIn(List<String> values) {
            addCriterion("after_type_key in", values, "afterTypeKey");
            return (Criteria) this;
        }

        public Criteria andAfterTypeKeyNotIn(List<String> values) {
            addCriterion("after_type_key not in", values, "afterTypeKey");
            return (Criteria) this;
        }

        public Criteria andAfterTypeKeyBetween(String value1, String value2) {
            addCriterion("after_type_key between", value1, value2, "afterTypeKey");
            return (Criteria) this;
        }

        public Criteria andAfterTypeKeyNotBetween(String value1, String value2) {
            addCriterion("after_type_key not between", value1, value2, "afterTypeKey");
            return (Criteria) this;
        }

        public Criteria andBeforeStartTimeIsNull() {
            addCriterion("before_start_time is null");
            return (Criteria) this;
        }

        public Criteria andBeforeStartTimeIsNotNull() {
            addCriterion("before_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeStartTimeEqualTo(Long value) {
            addCriterion("before_start_time =", value, "beforeStartTime");
            return (Criteria) this;
        }

        public Criteria andBeforeStartTimeNotEqualTo(Long value) {
            addCriterion("before_start_time <>", value, "beforeStartTime");
            return (Criteria) this;
        }

        public Criteria andBeforeStartTimeGreaterThan(Long value) {
            addCriterion("before_start_time >", value, "beforeStartTime");
            return (Criteria) this;
        }

        public Criteria andBeforeStartTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("before_start_time >=", value, "beforeStartTime");
            return (Criteria) this;
        }

        public Criteria andBeforeStartTimeLessThan(Long value) {
            addCriterion("before_start_time <", value, "beforeStartTime");
            return (Criteria) this;
        }

        public Criteria andBeforeStartTimeLessThanOrEqualTo(Long value) {
            addCriterion("before_start_time <=", value, "beforeStartTime");
            return (Criteria) this;
        }

        public Criteria andBeforeStartTimeIn(List<Long> values) {
            addCriterion("before_start_time in", values, "beforeStartTime");
            return (Criteria) this;
        }

        public Criteria andBeforeStartTimeNotIn(List<Long> values) {
            addCriterion("before_start_time not in", values, "beforeStartTime");
            return (Criteria) this;
        }

        public Criteria andBeforeStartTimeBetween(Long value1, Long value2) {
            addCriterion("before_start_time between", value1, value2, "beforeStartTime");
            return (Criteria) this;
        }

        public Criteria andBeforeStartTimeNotBetween(Long value1, Long value2) {
            addCriterion("before_start_time not between", value1, value2, "beforeStartTime");
            return (Criteria) this;
        }

        public Criteria andAfterStartTimeIsNull() {
            addCriterion("after_start_time is null");
            return (Criteria) this;
        }

        public Criteria andAfterStartTimeIsNotNull() {
            addCriterion("after_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andAfterStartTimeEqualTo(Long value) {
            addCriterion("after_start_time =", value, "afterStartTime");
            return (Criteria) this;
        }

        public Criteria andAfterStartTimeNotEqualTo(Long value) {
            addCriterion("after_start_time <>", value, "afterStartTime");
            return (Criteria) this;
        }

        public Criteria andAfterStartTimeGreaterThan(Long value) {
            addCriterion("after_start_time >", value, "afterStartTime");
            return (Criteria) this;
        }

        public Criteria andAfterStartTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("after_start_time >=", value, "afterStartTime");
            return (Criteria) this;
        }

        public Criteria andAfterStartTimeLessThan(Long value) {
            addCriterion("after_start_time <", value, "afterStartTime");
            return (Criteria) this;
        }

        public Criteria andAfterStartTimeLessThanOrEqualTo(Long value) {
            addCriterion("after_start_time <=", value, "afterStartTime");
            return (Criteria) this;
        }

        public Criteria andAfterStartTimeIn(List<Long> values) {
            addCriterion("after_start_time in", values, "afterStartTime");
            return (Criteria) this;
        }

        public Criteria andAfterStartTimeNotIn(List<Long> values) {
            addCriterion("after_start_time not in", values, "afterStartTime");
            return (Criteria) this;
        }

        public Criteria andAfterStartTimeBetween(Long value1, Long value2) {
            addCriterion("after_start_time between", value1, value2, "afterStartTime");
            return (Criteria) this;
        }

        public Criteria andAfterStartTimeNotBetween(Long value1, Long value2) {
            addCriterion("after_start_time not between", value1, value2, "afterStartTime");
            return (Criteria) this;
        }

        public Criteria andBeforeEndTimeIsNull() {
            addCriterion("before_end_time is null");
            return (Criteria) this;
        }

        public Criteria andBeforeEndTimeIsNotNull() {
            addCriterion("before_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeEndTimeEqualTo(Long value) {
            addCriterion("before_end_time =", value, "beforeEndTime");
            return (Criteria) this;
        }

        public Criteria andBeforeEndTimeNotEqualTo(Long value) {
            addCriterion("before_end_time <>", value, "beforeEndTime");
            return (Criteria) this;
        }

        public Criteria andBeforeEndTimeGreaterThan(Long value) {
            addCriterion("before_end_time >", value, "beforeEndTime");
            return (Criteria) this;
        }

        public Criteria andBeforeEndTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("before_end_time >=", value, "beforeEndTime");
            return (Criteria) this;
        }

        public Criteria andBeforeEndTimeLessThan(Long value) {
            addCriterion("before_end_time <", value, "beforeEndTime");
            return (Criteria) this;
        }

        public Criteria andBeforeEndTimeLessThanOrEqualTo(Long value) {
            addCriterion("before_end_time <=", value, "beforeEndTime");
            return (Criteria) this;
        }

        public Criteria andBeforeEndTimeIn(List<Long> values) {
            addCriterion("before_end_time in", values, "beforeEndTime");
            return (Criteria) this;
        }

        public Criteria andBeforeEndTimeNotIn(List<Long> values) {
            addCriterion("before_end_time not in", values, "beforeEndTime");
            return (Criteria) this;
        }

        public Criteria andBeforeEndTimeBetween(Long value1, Long value2) {
            addCriterion("before_end_time between", value1, value2, "beforeEndTime");
            return (Criteria) this;
        }

        public Criteria andBeforeEndTimeNotBetween(Long value1, Long value2) {
            addCriterion("before_end_time not between", value1, value2, "beforeEndTime");
            return (Criteria) this;
        }

        public Criteria andAfterEndTimeIsNull() {
            addCriterion("after_end_time is null");
            return (Criteria) this;
        }

        public Criteria andAfterEndTimeIsNotNull() {
            addCriterion("after_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andAfterEndTimeEqualTo(Long value) {
            addCriterion("after_end_time =", value, "afterEndTime");
            return (Criteria) this;
        }

        public Criteria andAfterEndTimeNotEqualTo(Long value) {
            addCriterion("after_end_time <>", value, "afterEndTime");
            return (Criteria) this;
        }

        public Criteria andAfterEndTimeGreaterThan(Long value) {
            addCriterion("after_end_time >", value, "afterEndTime");
            return (Criteria) this;
        }

        public Criteria andAfterEndTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("after_end_time >=", value, "afterEndTime");
            return (Criteria) this;
        }

        public Criteria andAfterEndTimeLessThan(Long value) {
            addCriterion("after_end_time <", value, "afterEndTime");
            return (Criteria) this;
        }

        public Criteria andAfterEndTimeLessThanOrEqualTo(Long value) {
            addCriterion("after_end_time <=", value, "afterEndTime");
            return (Criteria) this;
        }

        public Criteria andAfterEndTimeIn(List<Long> values) {
            addCriterion("after_end_time in", values, "afterEndTime");
            return (Criteria) this;
        }

        public Criteria andAfterEndTimeNotIn(List<Long> values) {
            addCriterion("after_end_time not in", values, "afterEndTime");
            return (Criteria) this;
        }

        public Criteria andAfterEndTimeBetween(Long value1, Long value2) {
            addCriterion("after_end_time between", value1, value2, "afterEndTime");
            return (Criteria) this;
        }

        public Criteria andAfterEndTimeNotBetween(Long value1, Long value2) {
            addCriterion("after_end_time not between", value1, value2, "afterEndTime");
            return (Criteria) this;
        }

        public Criteria andBeforeCreateTimeIsNull() {
            addCriterion("before_create_time is null");
            return (Criteria) this;
        }

        public Criteria andBeforeCreateTimeIsNotNull() {
            addCriterion("before_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeCreateTimeEqualTo(Long value) {
            addCriterion("before_create_time =", value, "beforeCreateTime");
            return (Criteria) this;
        }

        public Criteria andBeforeCreateTimeNotEqualTo(Long value) {
            addCriterion("before_create_time <>", value, "beforeCreateTime");
            return (Criteria) this;
        }

        public Criteria andBeforeCreateTimeGreaterThan(Long value) {
            addCriterion("before_create_time >", value, "beforeCreateTime");
            return (Criteria) this;
        }

        public Criteria andBeforeCreateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("before_create_time >=", value, "beforeCreateTime");
            return (Criteria) this;
        }

        public Criteria andBeforeCreateTimeLessThan(Long value) {
            addCriterion("before_create_time <", value, "beforeCreateTime");
            return (Criteria) this;
        }

        public Criteria andBeforeCreateTimeLessThanOrEqualTo(Long value) {
            addCriterion("before_create_time <=", value, "beforeCreateTime");
            return (Criteria) this;
        }

        public Criteria andBeforeCreateTimeIn(List<Long> values) {
            addCriterion("before_create_time in", values, "beforeCreateTime");
            return (Criteria) this;
        }

        public Criteria andBeforeCreateTimeNotIn(List<Long> values) {
            addCriterion("before_create_time not in", values, "beforeCreateTime");
            return (Criteria) this;
        }

        public Criteria andBeforeCreateTimeBetween(Long value1, Long value2) {
            addCriterion("before_create_time between", value1, value2, "beforeCreateTime");
            return (Criteria) this;
        }

        public Criteria andBeforeCreateTimeNotBetween(Long value1, Long value2) {
            addCriterion("before_create_time not between", value1, value2, "beforeCreateTime");
            return (Criteria) this;
        }

        public Criteria andAfterCreateTimeIsNull() {
            addCriterion("after_create_time is null");
            return (Criteria) this;
        }

        public Criteria andAfterCreateTimeIsNotNull() {
            addCriterion("after_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andAfterCreateTimeEqualTo(Long value) {
            addCriterion("after_create_time =", value, "afterCreateTime");
            return (Criteria) this;
        }

        public Criteria andAfterCreateTimeNotEqualTo(Long value) {
            addCriterion("after_create_time <>", value, "afterCreateTime");
            return (Criteria) this;
        }

        public Criteria andAfterCreateTimeGreaterThan(Long value) {
            addCriterion("after_create_time >", value, "afterCreateTime");
            return (Criteria) this;
        }

        public Criteria andAfterCreateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("after_create_time >=", value, "afterCreateTime");
            return (Criteria) this;
        }

        public Criteria andAfterCreateTimeLessThan(Long value) {
            addCriterion("after_create_time <", value, "afterCreateTime");
            return (Criteria) this;
        }

        public Criteria andAfterCreateTimeLessThanOrEqualTo(Long value) {
            addCriterion("after_create_time <=", value, "afterCreateTime");
            return (Criteria) this;
        }

        public Criteria andAfterCreateTimeIn(List<Long> values) {
            addCriterion("after_create_time in", values, "afterCreateTime");
            return (Criteria) this;
        }

        public Criteria andAfterCreateTimeNotIn(List<Long> values) {
            addCriterion("after_create_time not in", values, "afterCreateTime");
            return (Criteria) this;
        }

        public Criteria andAfterCreateTimeBetween(Long value1, Long value2) {
            addCriterion("after_create_time between", value1, value2, "afterCreateTime");
            return (Criteria) this;
        }

        public Criteria andAfterCreateTimeNotBetween(Long value1, Long value2) {
            addCriterion("after_create_time not between", value1, value2, "afterCreateTime");
            return (Criteria) this;
        }

        public Criteria andBeforeUidIsNull() {
            addCriterion("before_uid is null");
            return (Criteria) this;
        }

        public Criteria andBeforeUidIsNotNull() {
            addCriterion("before_uid is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeUidEqualTo(String value) {
            addCriterion("before_uid =", value, "beforeUid");
            return (Criteria) this;
        }

        public Criteria andBeforeUidNotEqualTo(String value) {
            addCriterion("before_uid <>", value, "beforeUid");
            return (Criteria) this;
        }

        public Criteria andBeforeUidGreaterThan(String value) {
            addCriterion("before_uid >", value, "beforeUid");
            return (Criteria) this;
        }

        public Criteria andBeforeUidGreaterThanOrEqualTo(String value) {
            addCriterion("before_uid >=", value, "beforeUid");
            return (Criteria) this;
        }

        public Criteria andBeforeUidLessThan(String value) {
            addCriterion("before_uid <", value, "beforeUid");
            return (Criteria) this;
        }

        public Criteria andBeforeUidLessThanOrEqualTo(String value) {
            addCriterion("before_uid <=", value, "beforeUid");
            return (Criteria) this;
        }

        public Criteria andBeforeUidLike(String value) {
            addCriterion("before_uid like", value, "beforeUid");
            return (Criteria) this;
        }

        public Criteria andBeforeUidNotLike(String value) {
            addCriterion("before_uid not like", value, "beforeUid");
            return (Criteria) this;
        }

        public Criteria andBeforeUidIn(List<String> values) {
            addCriterion("before_uid in", values, "beforeUid");
            return (Criteria) this;
        }

        public Criteria andBeforeUidNotIn(List<String> values) {
            addCriterion("before_uid not in", values, "beforeUid");
            return (Criteria) this;
        }

        public Criteria andBeforeUidBetween(String value1, String value2) {
            addCriterion("before_uid between", value1, value2, "beforeUid");
            return (Criteria) this;
        }

        public Criteria andBeforeUidNotBetween(String value1, String value2) {
            addCriterion("before_uid not between", value1, value2, "beforeUid");
            return (Criteria) this;
        }

        public Criteria andAfterUidIsNull() {
            addCriterion("after_uid is null");
            return (Criteria) this;
        }

        public Criteria andAfterUidIsNotNull() {
            addCriterion("after_uid is not null");
            return (Criteria) this;
        }

        public Criteria andAfterUidEqualTo(String value) {
            addCriterion("after_uid =", value, "afterUid");
            return (Criteria) this;
        }

        public Criteria andAfterUidNotEqualTo(String value) {
            addCriterion("after_uid <>", value, "afterUid");
            return (Criteria) this;
        }

        public Criteria andAfterUidGreaterThan(String value) {
            addCriterion("after_uid >", value, "afterUid");
            return (Criteria) this;
        }

        public Criteria andAfterUidGreaterThanOrEqualTo(String value) {
            addCriterion("after_uid >=", value, "afterUid");
            return (Criteria) this;
        }

        public Criteria andAfterUidLessThan(String value) {
            addCriterion("after_uid <", value, "afterUid");
            return (Criteria) this;
        }

        public Criteria andAfterUidLessThanOrEqualTo(String value) {
            addCriterion("after_uid <=", value, "afterUid");
            return (Criteria) this;
        }

        public Criteria andAfterUidLike(String value) {
            addCriterion("after_uid like", value, "afterUid");
            return (Criteria) this;
        }

        public Criteria andAfterUidNotLike(String value) {
            addCriterion("after_uid not like", value, "afterUid");
            return (Criteria) this;
        }

        public Criteria andAfterUidIn(List<String> values) {
            addCriterion("after_uid in", values, "afterUid");
            return (Criteria) this;
        }

        public Criteria andAfterUidNotIn(List<String> values) {
            addCriterion("after_uid not in", values, "afterUid");
            return (Criteria) this;
        }

        public Criteria andAfterUidBetween(String value1, String value2) {
            addCriterion("after_uid between", value1, value2, "afterUid");
            return (Criteria) this;
        }

        public Criteria andAfterUidNotBetween(String value1, String value2) {
            addCriterion("after_uid not between", value1, value2, "afterUid");
            return (Criteria) this;
        }

        public Criteria andBeforeNumberPlateIsNull() {
            addCriterion("before_number_plate is null");
            return (Criteria) this;
        }

        public Criteria andBeforeNumberPlateIsNotNull() {
            addCriterion("before_number_plate is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeNumberPlateEqualTo(String value) {
            addCriterion("before_number_plate =", value, "beforeNumberPlate");
            return (Criteria) this;
        }

        public Criteria andBeforeNumberPlateNotEqualTo(String value) {
            addCriterion("before_number_plate <>", value, "beforeNumberPlate");
            return (Criteria) this;
        }

        public Criteria andBeforeNumberPlateGreaterThan(String value) {
            addCriterion("before_number_plate >", value, "beforeNumberPlate");
            return (Criteria) this;
        }

        public Criteria andBeforeNumberPlateGreaterThanOrEqualTo(String value) {
            addCriterion("before_number_plate >=", value, "beforeNumberPlate");
            return (Criteria) this;
        }

        public Criteria andBeforeNumberPlateLessThan(String value) {
            addCriterion("before_number_plate <", value, "beforeNumberPlate");
            return (Criteria) this;
        }

        public Criteria andBeforeNumberPlateLessThanOrEqualTo(String value) {
            addCriterion("before_number_plate <=", value, "beforeNumberPlate");
            return (Criteria) this;
        }

        public Criteria andBeforeNumberPlateLike(String value) {
            addCriterion("before_number_plate like", value, "beforeNumberPlate");
            return (Criteria) this;
        }

        public Criteria andBeforeNumberPlateNotLike(String value) {
            addCriterion("before_number_plate not like", value, "beforeNumberPlate");
            return (Criteria) this;
        }

        public Criteria andBeforeNumberPlateIn(List<String> values) {
            addCriterion("before_number_plate in", values, "beforeNumberPlate");
            return (Criteria) this;
        }

        public Criteria andBeforeNumberPlateNotIn(List<String> values) {
            addCriterion("before_number_plate not in", values, "beforeNumberPlate");
            return (Criteria) this;
        }

        public Criteria andBeforeNumberPlateBetween(String value1, String value2) {
            addCriterion("before_number_plate between", value1, value2, "beforeNumberPlate");
            return (Criteria) this;
        }

        public Criteria andBeforeNumberPlateNotBetween(String value1, String value2) {
            addCriterion("before_number_plate not between", value1, value2, "beforeNumberPlate");
            return (Criteria) this;
        }

        public Criteria andAfterNumberPlateIsNull() {
            addCriterion("after_number_plate is null");
            return (Criteria) this;
        }

        public Criteria andAfterNumberPlateIsNotNull() {
            addCriterion("after_number_plate is not null");
            return (Criteria) this;
        }

        public Criteria andAfterNumberPlateEqualTo(String value) {
            addCriterion("after_number_plate =", value, "afterNumberPlate");
            return (Criteria) this;
        }

        public Criteria andAfterNumberPlateNotEqualTo(String value) {
            addCriterion("after_number_plate <>", value, "afterNumberPlate");
            return (Criteria) this;
        }

        public Criteria andAfterNumberPlateGreaterThan(String value) {
            addCriterion("after_number_plate >", value, "afterNumberPlate");
            return (Criteria) this;
        }

        public Criteria andAfterNumberPlateGreaterThanOrEqualTo(String value) {
            addCriterion("after_number_plate >=", value, "afterNumberPlate");
            return (Criteria) this;
        }

        public Criteria andAfterNumberPlateLessThan(String value) {
            addCriterion("after_number_plate <", value, "afterNumberPlate");
            return (Criteria) this;
        }

        public Criteria andAfterNumberPlateLessThanOrEqualTo(String value) {
            addCriterion("after_number_plate <=", value, "afterNumberPlate");
            return (Criteria) this;
        }

        public Criteria andAfterNumberPlateLike(String value) {
            addCriterion("after_number_plate like", value, "afterNumberPlate");
            return (Criteria) this;
        }

        public Criteria andAfterNumberPlateNotLike(String value) {
            addCriterion("after_number_plate not like", value, "afterNumberPlate");
            return (Criteria) this;
        }

        public Criteria andAfterNumberPlateIn(List<String> values) {
            addCriterion("after_number_plate in", values, "afterNumberPlate");
            return (Criteria) this;
        }

        public Criteria andAfterNumberPlateNotIn(List<String> values) {
            addCriterion("after_number_plate not in", values, "afterNumberPlate");
            return (Criteria) this;
        }

        public Criteria andAfterNumberPlateBetween(String value1, String value2) {
            addCriterion("after_number_plate between", value1, value2, "afterNumberPlate");
            return (Criteria) this;
        }

        public Criteria andAfterNumberPlateNotBetween(String value1, String value2) {
            addCriterion("after_number_plate not between", value1, value2, "afterNumberPlate");
            return (Criteria) this;
        }

        public Criteria andBeforeSpecialGiveIsNull() {
            addCriterion("before_special_give is null");
            return (Criteria) this;
        }

        public Criteria andBeforeSpecialGiveIsNotNull() {
            addCriterion("before_special_give is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeSpecialGiveEqualTo(Byte value) {
            addCriterion("before_special_give =", value, "beforeSpecialGive");
            return (Criteria) this;
        }

        public Criteria andBeforeSpecialGiveNotEqualTo(Byte value) {
            addCriterion("before_special_give <>", value, "beforeSpecialGive");
            return (Criteria) this;
        }

        public Criteria andBeforeSpecialGiveGreaterThan(Byte value) {
            addCriterion("before_special_give >", value, "beforeSpecialGive");
            return (Criteria) this;
        }

        public Criteria andBeforeSpecialGiveGreaterThanOrEqualTo(Byte value) {
            addCriterion("before_special_give >=", value, "beforeSpecialGive");
            return (Criteria) this;
        }

        public Criteria andBeforeSpecialGiveLessThan(Byte value) {
            addCriterion("before_special_give <", value, "beforeSpecialGive");
            return (Criteria) this;
        }

        public Criteria andBeforeSpecialGiveLessThanOrEqualTo(Byte value) {
            addCriterion("before_special_give <=", value, "beforeSpecialGive");
            return (Criteria) this;
        }

        public Criteria andBeforeSpecialGiveIn(List<Byte> values) {
            addCriterion("before_special_give in", values, "beforeSpecialGive");
            return (Criteria) this;
        }

        public Criteria andBeforeSpecialGiveNotIn(List<Byte> values) {
            addCriterion("before_special_give not in", values, "beforeSpecialGive");
            return (Criteria) this;
        }

        public Criteria andBeforeSpecialGiveBetween(Byte value1, Byte value2) {
            addCriterion("before_special_give between", value1, value2, "beforeSpecialGive");
            return (Criteria) this;
        }

        public Criteria andBeforeSpecialGiveNotBetween(Byte value1, Byte value2) {
            addCriterion("before_special_give not between", value1, value2, "beforeSpecialGive");
            return (Criteria) this;
        }

        public Criteria andAfterSpecialGiveIsNull() {
            addCriterion("after_special_give is null");
            return (Criteria) this;
        }

        public Criteria andAfterSpecialGiveIsNotNull() {
            addCriterion("after_special_give is not null");
            return (Criteria) this;
        }

        public Criteria andAfterSpecialGiveEqualTo(Byte value) {
            addCriterion("after_special_give =", value, "afterSpecialGive");
            return (Criteria) this;
        }

        public Criteria andAfterSpecialGiveNotEqualTo(Byte value) {
            addCriterion("after_special_give <>", value, "afterSpecialGive");
            return (Criteria) this;
        }

        public Criteria andAfterSpecialGiveGreaterThan(Byte value) {
            addCriterion("after_special_give >", value, "afterSpecialGive");
            return (Criteria) this;
        }

        public Criteria andAfterSpecialGiveGreaterThanOrEqualTo(Byte value) {
            addCriterion("after_special_give >=", value, "afterSpecialGive");
            return (Criteria) this;
        }

        public Criteria andAfterSpecialGiveLessThan(Byte value) {
            addCriterion("after_special_give <", value, "afterSpecialGive");
            return (Criteria) this;
        }

        public Criteria andAfterSpecialGiveLessThanOrEqualTo(Byte value) {
            addCriterion("after_special_give <=", value, "afterSpecialGive");
            return (Criteria) this;
        }

        public Criteria andAfterSpecialGiveIn(List<Byte> values) {
            addCriterion("after_special_give in", values, "afterSpecialGive");
            return (Criteria) this;
        }

        public Criteria andAfterSpecialGiveNotIn(List<Byte> values) {
            addCriterion("after_special_give not in", values, "afterSpecialGive");
            return (Criteria) this;
        }

        public Criteria andAfterSpecialGiveBetween(Byte value1, Byte value2) {
            addCriterion("after_special_give between", value1, value2, "afterSpecialGive");
            return (Criteria) this;
        }

        public Criteria andAfterSpecialGiveNotBetween(Byte value1, Byte value2) {
            addCriterion("after_special_give not between", value1, value2, "afterSpecialGive");
            return (Criteria) this;
        }

        public Criteria andBeforePackagePriceIdIsNull() {
            addCriterion("before_package_price_id is null");
            return (Criteria) this;
        }

        public Criteria andBeforePackagePriceIdIsNotNull() {
            addCriterion("before_package_price_id is not null");
            return (Criteria) this;
        }

        public Criteria andBeforePackagePriceIdEqualTo(String value) {
            addCriterion("before_package_price_id =", value, "beforePackagePriceId");
            return (Criteria) this;
        }

        public Criteria andBeforePackagePriceIdNotEqualTo(String value) {
            addCriterion("before_package_price_id <>", value, "beforePackagePriceId");
            return (Criteria) this;
        }

        public Criteria andBeforePackagePriceIdGreaterThan(String value) {
            addCriterion("before_package_price_id >", value, "beforePackagePriceId");
            return (Criteria) this;
        }

        public Criteria andBeforePackagePriceIdGreaterThanOrEqualTo(String value) {
            addCriterion("before_package_price_id >=", value, "beforePackagePriceId");
            return (Criteria) this;
        }

        public Criteria andBeforePackagePriceIdLessThan(String value) {
            addCriterion("before_package_price_id <", value, "beforePackagePriceId");
            return (Criteria) this;
        }

        public Criteria andBeforePackagePriceIdLessThanOrEqualTo(String value) {
            addCriterion("before_package_price_id <=", value, "beforePackagePriceId");
            return (Criteria) this;
        }

        public Criteria andBeforePackagePriceIdLike(String value) {
            addCriterion("before_package_price_id like", value, "beforePackagePriceId");
            return (Criteria) this;
        }

        public Criteria andBeforePackagePriceIdNotLike(String value) {
            addCriterion("before_package_price_id not like", value, "beforePackagePriceId");
            return (Criteria) this;
        }

        public Criteria andBeforePackagePriceIdIn(List<String> values) {
            addCriterion("before_package_price_id in", values, "beforePackagePriceId");
            return (Criteria) this;
        }

        public Criteria andBeforePackagePriceIdNotIn(List<String> values) {
            addCriterion("before_package_price_id not in", values, "beforePackagePriceId");
            return (Criteria) this;
        }

        public Criteria andBeforePackagePriceIdBetween(String value1, String value2) {
            addCriterion("before_package_price_id between", value1, value2, "beforePackagePriceId");
            return (Criteria) this;
        }

        public Criteria andBeforePackagePriceIdNotBetween(String value1, String value2) {
            addCriterion("before_package_price_id not between", value1, value2, "beforePackagePriceId");
            return (Criteria) this;
        }

        public Criteria andAfterPackagePriceIdIsNull() {
            addCriterion("after_package_price_id is null");
            return (Criteria) this;
        }

        public Criteria andAfterPackagePriceIdIsNotNull() {
            addCriterion("after_package_price_id is not null");
            return (Criteria) this;
        }

        public Criteria andAfterPackagePriceIdEqualTo(String value) {
            addCriterion("after_package_price_id =", value, "afterPackagePriceId");
            return (Criteria) this;
        }

        public Criteria andAfterPackagePriceIdNotEqualTo(String value) {
            addCriterion("after_package_price_id <>", value, "afterPackagePriceId");
            return (Criteria) this;
        }

        public Criteria andAfterPackagePriceIdGreaterThan(String value) {
            addCriterion("after_package_price_id >", value, "afterPackagePriceId");
            return (Criteria) this;
        }

        public Criteria andAfterPackagePriceIdGreaterThanOrEqualTo(String value) {
            addCriterion("after_package_price_id >=", value, "afterPackagePriceId");
            return (Criteria) this;
        }

        public Criteria andAfterPackagePriceIdLessThan(String value) {
            addCriterion("after_package_price_id <", value, "afterPackagePriceId");
            return (Criteria) this;
        }

        public Criteria andAfterPackagePriceIdLessThanOrEqualTo(String value) {
            addCriterion("after_package_price_id <=", value, "afterPackagePriceId");
            return (Criteria) this;
        }

        public Criteria andAfterPackagePriceIdLike(String value) {
            addCriterion("after_package_price_id like", value, "afterPackagePriceId");
            return (Criteria) this;
        }

        public Criteria andAfterPackagePriceIdNotLike(String value) {
            addCriterion("after_package_price_id not like", value, "afterPackagePriceId");
            return (Criteria) this;
        }

        public Criteria andAfterPackagePriceIdIn(List<String> values) {
            addCriterion("after_package_price_id in", values, "afterPackagePriceId");
            return (Criteria) this;
        }

        public Criteria andAfterPackagePriceIdNotIn(List<String> values) {
            addCriterion("after_package_price_id not in", values, "afterPackagePriceId");
            return (Criteria) this;
        }

        public Criteria andAfterPackagePriceIdBetween(String value1, String value2) {
            addCriterion("after_package_price_id between", value1, value2, "afterPackagePriceId");
            return (Criteria) this;
        }

        public Criteria andAfterPackagePriceIdNotBetween(String value1, String value2) {
            addCriterion("after_package_price_id not between", value1, value2, "afterPackagePriceId");
            return (Criteria) this;
        }

        public Criteria andBeforeTransRegionalIsNull() {
            addCriterion("before_trans_regional is null");
            return (Criteria) this;
        }

        public Criteria andBeforeTransRegionalIsNotNull() {
            addCriterion("before_trans_regional is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeTransRegionalEqualTo(Byte value) {
            addCriterion("before_trans_regional =", value, "beforeTransRegional");
            return (Criteria) this;
        }

        public Criteria andBeforeTransRegionalNotEqualTo(Byte value) {
            addCriterion("before_trans_regional <>", value, "beforeTransRegional");
            return (Criteria) this;
        }

        public Criteria andBeforeTransRegionalGreaterThan(Byte value) {
            addCriterion("before_trans_regional >", value, "beforeTransRegional");
            return (Criteria) this;
        }

        public Criteria andBeforeTransRegionalGreaterThanOrEqualTo(Byte value) {
            addCriterion("before_trans_regional >=", value, "beforeTransRegional");
            return (Criteria) this;
        }

        public Criteria andBeforeTransRegionalLessThan(Byte value) {
            addCriterion("before_trans_regional <", value, "beforeTransRegional");
            return (Criteria) this;
        }

        public Criteria andBeforeTransRegionalLessThanOrEqualTo(Byte value) {
            addCriterion("before_trans_regional <=", value, "beforeTransRegional");
            return (Criteria) this;
        }

        public Criteria andBeforeTransRegionalIn(List<Byte> values) {
            addCriterion("before_trans_regional in", values, "beforeTransRegional");
            return (Criteria) this;
        }

        public Criteria andBeforeTransRegionalNotIn(List<Byte> values) {
            addCriterion("before_trans_regional not in", values, "beforeTransRegional");
            return (Criteria) this;
        }

        public Criteria andBeforeTransRegionalBetween(Byte value1, Byte value2) {
            addCriterion("before_trans_regional between", value1, value2, "beforeTransRegional");
            return (Criteria) this;
        }

        public Criteria andBeforeTransRegionalNotBetween(Byte value1, Byte value2) {
            addCriterion("before_trans_regional not between", value1, value2, "beforeTransRegional");
            return (Criteria) this;
        }

        public Criteria andAfterTransRegionalIsNull() {
            addCriterion("after_trans_regional is null");
            return (Criteria) this;
        }

        public Criteria andAfterTransRegionalIsNotNull() {
            addCriterion("after_trans_regional is not null");
            return (Criteria) this;
        }

        public Criteria andAfterTransRegionalEqualTo(Byte value) {
            addCriterion("after_trans_regional =", value, "afterTransRegional");
            return (Criteria) this;
        }

        public Criteria andAfterTransRegionalNotEqualTo(Byte value) {
            addCriterion("after_trans_regional <>", value, "afterTransRegional");
            return (Criteria) this;
        }

        public Criteria andAfterTransRegionalGreaterThan(Byte value) {
            addCriterion("after_trans_regional >", value, "afterTransRegional");
            return (Criteria) this;
        }

        public Criteria andAfterTransRegionalGreaterThanOrEqualTo(Byte value) {
            addCriterion("after_trans_regional >=", value, "afterTransRegional");
            return (Criteria) this;
        }

        public Criteria andAfterTransRegionalLessThan(Byte value) {
            addCriterion("after_trans_regional <", value, "afterTransRegional");
            return (Criteria) this;
        }

        public Criteria andAfterTransRegionalLessThanOrEqualTo(Byte value) {
            addCriterion("after_trans_regional <=", value, "afterTransRegional");
            return (Criteria) this;
        }

        public Criteria andAfterTransRegionalIn(List<Byte> values) {
            addCriterion("after_trans_regional in", values, "afterTransRegional");
            return (Criteria) this;
        }

        public Criteria andAfterTransRegionalNotIn(List<Byte> values) {
            addCriterion("after_trans_regional not in", values, "afterTransRegional");
            return (Criteria) this;
        }

        public Criteria andAfterTransRegionalBetween(Byte value1, Byte value2) {
            addCriterion("after_trans_regional between", value1, value2, "afterTransRegional");
            return (Criteria) this;
        }

        public Criteria andAfterTransRegionalNotBetween(Byte value1, Byte value2) {
            addCriterion("after_trans_regional not between", value1, value2, "afterTransRegional");
            return (Criteria) this;
        }

        public Criteria andBeforeParentIdIsNull() {
            addCriterion("before_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andBeforeParentIdIsNotNull() {
            addCriterion("before_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeParentIdEqualTo(String value) {
            addCriterion("before_parent_id =", value, "beforeParentId");
            return (Criteria) this;
        }

        public Criteria andBeforeParentIdNotEqualTo(String value) {
            addCriterion("before_parent_id <>", value, "beforeParentId");
            return (Criteria) this;
        }

        public Criteria andBeforeParentIdGreaterThan(String value) {
            addCriterion("before_parent_id >", value, "beforeParentId");
            return (Criteria) this;
        }

        public Criteria andBeforeParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("before_parent_id >=", value, "beforeParentId");
            return (Criteria) this;
        }

        public Criteria andBeforeParentIdLessThan(String value) {
            addCriterion("before_parent_id <", value, "beforeParentId");
            return (Criteria) this;
        }

        public Criteria andBeforeParentIdLessThanOrEqualTo(String value) {
            addCriterion("before_parent_id <=", value, "beforeParentId");
            return (Criteria) this;
        }

        public Criteria andBeforeParentIdLike(String value) {
            addCriterion("before_parent_id like", value, "beforeParentId");
            return (Criteria) this;
        }

        public Criteria andBeforeParentIdNotLike(String value) {
            addCriterion("before_parent_id not like", value, "beforeParentId");
            return (Criteria) this;
        }

        public Criteria andBeforeParentIdIn(List<String> values) {
            addCriterion("before_parent_id in", values, "beforeParentId");
            return (Criteria) this;
        }

        public Criteria andBeforeParentIdNotIn(List<String> values) {
            addCriterion("before_parent_id not in", values, "beforeParentId");
            return (Criteria) this;
        }

        public Criteria andBeforeParentIdBetween(String value1, String value2) {
            addCriterion("before_parent_id between", value1, value2, "beforeParentId");
            return (Criteria) this;
        }

        public Criteria andBeforeParentIdNotBetween(String value1, String value2) {
            addCriterion("before_parent_id not between", value1, value2, "beforeParentId");
            return (Criteria) this;
        }

        public Criteria andAfterParentIdIsNull() {
            addCriterion("after_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andAfterParentIdIsNotNull() {
            addCriterion("after_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andAfterParentIdEqualTo(String value) {
            addCriterion("after_parent_id =", value, "afterParentId");
            return (Criteria) this;
        }

        public Criteria andAfterParentIdNotEqualTo(String value) {
            addCriterion("after_parent_id <>", value, "afterParentId");
            return (Criteria) this;
        }

        public Criteria andAfterParentIdGreaterThan(String value) {
            addCriterion("after_parent_id >", value, "afterParentId");
            return (Criteria) this;
        }

        public Criteria andAfterParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("after_parent_id >=", value, "afterParentId");
            return (Criteria) this;
        }

        public Criteria andAfterParentIdLessThan(String value) {
            addCriterion("after_parent_id <", value, "afterParentId");
            return (Criteria) this;
        }

        public Criteria andAfterParentIdLessThanOrEqualTo(String value) {
            addCriterion("after_parent_id <=", value, "afterParentId");
            return (Criteria) this;
        }

        public Criteria andAfterParentIdLike(String value) {
            addCriterion("after_parent_id like", value, "afterParentId");
            return (Criteria) this;
        }

        public Criteria andAfterParentIdNotLike(String value) {
            addCriterion("after_parent_id not like", value, "afterParentId");
            return (Criteria) this;
        }

        public Criteria andAfterParentIdIn(List<String> values) {
            addCriterion("after_parent_id in", values, "afterParentId");
            return (Criteria) this;
        }

        public Criteria andAfterParentIdNotIn(List<String> values) {
            addCriterion("after_parent_id not in", values, "afterParentId");
            return (Criteria) this;
        }

        public Criteria andAfterParentIdBetween(String value1, String value2) {
            addCriterion("after_parent_id between", value1, value2, "afterParentId");
            return (Criteria) this;
        }

        public Criteria andAfterParentIdNotBetween(String value1, String value2) {
            addCriterion("after_parent_id not between", value1, value2, "afterParentId");
            return (Criteria) this;
        }

        public Criteria andBeforePhoneIsNull() {
            addCriterion("before_phone is null");
            return (Criteria) this;
        }

        public Criteria andBeforePhoneIsNotNull() {
            addCriterion("before_phone is not null");
            return (Criteria) this;
        }

        public Criteria andBeforePhoneEqualTo(String value) {
            addCriterion("before_phone =", value, "beforePhone");
            return (Criteria) this;
        }

        public Criteria andBeforePhoneNotEqualTo(String value) {
            addCriterion("before_phone <>", value, "beforePhone");
            return (Criteria) this;
        }

        public Criteria andBeforePhoneGreaterThan(String value) {
            addCriterion("before_phone >", value, "beforePhone");
            return (Criteria) this;
        }

        public Criteria andBeforePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("before_phone >=", value, "beforePhone");
            return (Criteria) this;
        }

        public Criteria andBeforePhoneLessThan(String value) {
            addCriterion("before_phone <", value, "beforePhone");
            return (Criteria) this;
        }

        public Criteria andBeforePhoneLessThanOrEqualTo(String value) {
            addCriterion("before_phone <=", value, "beforePhone");
            return (Criteria) this;
        }

        public Criteria andBeforePhoneLike(String value) {
            addCriterion("before_phone like", value, "beforePhone");
            return (Criteria) this;
        }

        public Criteria andBeforePhoneNotLike(String value) {
            addCriterion("before_phone not like", value, "beforePhone");
            return (Criteria) this;
        }

        public Criteria andBeforePhoneIn(List<String> values) {
            addCriterion("before_phone in", values, "beforePhone");
            return (Criteria) this;
        }

        public Criteria andBeforePhoneNotIn(List<String> values) {
            addCriterion("before_phone not in", values, "beforePhone");
            return (Criteria) this;
        }

        public Criteria andBeforePhoneBetween(String value1, String value2) {
            addCriterion("before_phone between", value1, value2, "beforePhone");
            return (Criteria) this;
        }

        public Criteria andBeforePhoneNotBetween(String value1, String value2) {
            addCriterion("before_phone not between", value1, value2, "beforePhone");
            return (Criteria) this;
        }

        public Criteria andAfterPhoneIsNull() {
            addCriterion("after_phone is null");
            return (Criteria) this;
        }

        public Criteria andAfterPhoneIsNotNull() {
            addCriterion("after_phone is not null");
            return (Criteria) this;
        }

        public Criteria andAfterPhoneEqualTo(String value) {
            addCriterion("after_phone =", value, "afterPhone");
            return (Criteria) this;
        }

        public Criteria andAfterPhoneNotEqualTo(String value) {
            addCriterion("after_phone <>", value, "afterPhone");
            return (Criteria) this;
        }

        public Criteria andAfterPhoneGreaterThan(String value) {
            addCriterion("after_phone >", value, "afterPhone");
            return (Criteria) this;
        }

        public Criteria andAfterPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("after_phone >=", value, "afterPhone");
            return (Criteria) this;
        }

        public Criteria andAfterPhoneLessThan(String value) {
            addCriterion("after_phone <", value, "afterPhone");
            return (Criteria) this;
        }

        public Criteria andAfterPhoneLessThanOrEqualTo(String value) {
            addCriterion("after_phone <=", value, "afterPhone");
            return (Criteria) this;
        }

        public Criteria andAfterPhoneLike(String value) {
            addCriterion("after_phone like", value, "afterPhone");
            return (Criteria) this;
        }

        public Criteria andAfterPhoneNotLike(String value) {
            addCriterion("after_phone not like", value, "afterPhone");
            return (Criteria) this;
        }

        public Criteria andAfterPhoneIn(List<String> values) {
            addCriterion("after_phone in", values, "afterPhone");
            return (Criteria) this;
        }

        public Criteria andAfterPhoneNotIn(List<String> values) {
            addCriterion("after_phone not in", values, "afterPhone");
            return (Criteria) this;
        }

        public Criteria andAfterPhoneBetween(String value1, String value2) {
            addCriterion("after_phone between", value1, value2, "afterPhone");
            return (Criteria) this;
        }

        public Criteria andAfterPhoneNotBetween(String value1, String value2) {
            addCriterion("after_phone not between", value1, value2, "afterPhone");
            return (Criteria) this;
        }

        public Criteria andBeforeMainCarParkIdIsNull() {
            addCriterion("before_main_car_park_id is null");
            return (Criteria) this;
        }

        public Criteria andBeforeMainCarParkIdIsNotNull() {
            addCriterion("before_main_car_park_id is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeMainCarParkIdEqualTo(String value) {
            addCriterion("before_main_car_park_id =", value, "beforeMainCarParkId");
            return (Criteria) this;
        }

        public Criteria andBeforeMainCarParkIdNotEqualTo(String value) {
            addCriterion("before_main_car_park_id <>", value, "beforeMainCarParkId");
            return (Criteria) this;
        }

        public Criteria andBeforeMainCarParkIdGreaterThan(String value) {
            addCriterion("before_main_car_park_id >", value, "beforeMainCarParkId");
            return (Criteria) this;
        }

        public Criteria andBeforeMainCarParkIdGreaterThanOrEqualTo(String value) {
            addCriterion("before_main_car_park_id >=", value, "beforeMainCarParkId");
            return (Criteria) this;
        }

        public Criteria andBeforeMainCarParkIdLessThan(String value) {
            addCriterion("before_main_car_park_id <", value, "beforeMainCarParkId");
            return (Criteria) this;
        }

        public Criteria andBeforeMainCarParkIdLessThanOrEqualTo(String value) {
            addCriterion("before_main_car_park_id <=", value, "beforeMainCarParkId");
            return (Criteria) this;
        }

        public Criteria andBeforeMainCarParkIdLike(String value) {
            addCriterion("before_main_car_park_id like", value, "beforeMainCarParkId");
            return (Criteria) this;
        }

        public Criteria andBeforeMainCarParkIdNotLike(String value) {
            addCriterion("before_main_car_park_id not like", value, "beforeMainCarParkId");
            return (Criteria) this;
        }

        public Criteria andBeforeMainCarParkIdIn(List<String> values) {
            addCriterion("before_main_car_park_id in", values, "beforeMainCarParkId");
            return (Criteria) this;
        }

        public Criteria andBeforeMainCarParkIdNotIn(List<String> values) {
            addCriterion("before_main_car_park_id not in", values, "beforeMainCarParkId");
            return (Criteria) this;
        }

        public Criteria andBeforeMainCarParkIdBetween(String value1, String value2) {
            addCriterion("before_main_car_park_id between", value1, value2, "beforeMainCarParkId");
            return (Criteria) this;
        }

        public Criteria andBeforeMainCarParkIdNotBetween(String value1, String value2) {
            addCriterion("before_main_car_park_id not between", value1, value2, "beforeMainCarParkId");
            return (Criteria) this;
        }

        public Criteria andAfterMainCarParkIdIsNull() {
            addCriterion("after_main_car_park_id is null");
            return (Criteria) this;
        }

        public Criteria andAfterMainCarParkIdIsNotNull() {
            addCriterion("after_main_car_park_id is not null");
            return (Criteria) this;
        }

        public Criteria andAfterMainCarParkIdEqualTo(String value) {
            addCriterion("after_main_car_park_id =", value, "afterMainCarParkId");
            return (Criteria) this;
        }

        public Criteria andAfterMainCarParkIdNotEqualTo(String value) {
            addCriterion("after_main_car_park_id <>", value, "afterMainCarParkId");
            return (Criteria) this;
        }

        public Criteria andAfterMainCarParkIdGreaterThan(String value) {
            addCriterion("after_main_car_park_id >", value, "afterMainCarParkId");
            return (Criteria) this;
        }

        public Criteria andAfterMainCarParkIdGreaterThanOrEqualTo(String value) {
            addCriterion("after_main_car_park_id >=", value, "afterMainCarParkId");
            return (Criteria) this;
        }

        public Criteria andAfterMainCarParkIdLessThan(String value) {
            addCriterion("after_main_car_park_id <", value, "afterMainCarParkId");
            return (Criteria) this;
        }

        public Criteria andAfterMainCarParkIdLessThanOrEqualTo(String value) {
            addCriterion("after_main_car_park_id <=", value, "afterMainCarParkId");
            return (Criteria) this;
        }

        public Criteria andAfterMainCarParkIdLike(String value) {
            addCriterion("after_main_car_park_id like", value, "afterMainCarParkId");
            return (Criteria) this;
        }

        public Criteria andAfterMainCarParkIdNotLike(String value) {
            addCriterion("after_main_car_park_id not like", value, "afterMainCarParkId");
            return (Criteria) this;
        }

        public Criteria andAfterMainCarParkIdIn(List<String> values) {
            addCriterion("after_main_car_park_id in", values, "afterMainCarParkId");
            return (Criteria) this;
        }

        public Criteria andAfterMainCarParkIdNotIn(List<String> values) {
            addCriterion("after_main_car_park_id not in", values, "afterMainCarParkId");
            return (Criteria) this;
        }

        public Criteria andAfterMainCarParkIdBetween(String value1, String value2) {
            addCriterion("after_main_car_park_id between", value1, value2, "afterMainCarParkId");
            return (Criteria) this;
        }

        public Criteria andAfterMainCarParkIdNotBetween(String value1, String value2) {
            addCriterion("after_main_car_park_id not between", value1, value2, "afterMainCarParkId");
            return (Criteria) this;
        }

        public Criteria andBeforeRemarksIsNull() {
            addCriterion("before_remarks is null");
            return (Criteria) this;
        }

        public Criteria andBeforeRemarksIsNotNull() {
            addCriterion("before_remarks is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeRemarksEqualTo(String value) {
            addCriterion("before_remarks =", value, "beforeRemarks");
            return (Criteria) this;
        }

        public Criteria andBeforeRemarksNotEqualTo(String value) {
            addCriterion("before_remarks <>", value, "beforeRemarks");
            return (Criteria) this;
        }

        public Criteria andBeforeRemarksGreaterThan(String value) {
            addCriterion("before_remarks >", value, "beforeRemarks");
            return (Criteria) this;
        }

        public Criteria andBeforeRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("before_remarks >=", value, "beforeRemarks");
            return (Criteria) this;
        }

        public Criteria andBeforeRemarksLessThan(String value) {
            addCriterion("before_remarks <", value, "beforeRemarks");
            return (Criteria) this;
        }

        public Criteria andBeforeRemarksLessThanOrEqualTo(String value) {
            addCriterion("before_remarks <=", value, "beforeRemarks");
            return (Criteria) this;
        }

        public Criteria andBeforeRemarksLike(String value) {
            addCriterion("before_remarks like", value, "beforeRemarks");
            return (Criteria) this;
        }

        public Criteria andBeforeRemarksNotLike(String value) {
            addCriterion("before_remarks not like", value, "beforeRemarks");
            return (Criteria) this;
        }

        public Criteria andBeforeRemarksIn(List<String> values) {
            addCriterion("before_remarks in", values, "beforeRemarks");
            return (Criteria) this;
        }

        public Criteria andBeforeRemarksNotIn(List<String> values) {
            addCriterion("before_remarks not in", values, "beforeRemarks");
            return (Criteria) this;
        }

        public Criteria andBeforeRemarksBetween(String value1, String value2) {
            addCriterion("before_remarks between", value1, value2, "beforeRemarks");
            return (Criteria) this;
        }

        public Criteria andBeforeRemarksNotBetween(String value1, String value2) {
            addCriterion("before_remarks not between", value1, value2, "beforeRemarks");
            return (Criteria) this;
        }

        public Criteria andAfterRemarksIsNull() {
            addCriterion("after_remarks is null");
            return (Criteria) this;
        }

        public Criteria andAfterRemarksIsNotNull() {
            addCriterion("after_remarks is not null");
            return (Criteria) this;
        }

        public Criteria andAfterRemarksEqualTo(String value) {
            addCriterion("after_remarks =", value, "afterRemarks");
            return (Criteria) this;
        }

        public Criteria andAfterRemarksNotEqualTo(String value) {
            addCriterion("after_remarks <>", value, "afterRemarks");
            return (Criteria) this;
        }

        public Criteria andAfterRemarksGreaterThan(String value) {
            addCriterion("after_remarks >", value, "afterRemarks");
            return (Criteria) this;
        }

        public Criteria andAfterRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("after_remarks >=", value, "afterRemarks");
            return (Criteria) this;
        }

        public Criteria andAfterRemarksLessThan(String value) {
            addCriterion("after_remarks <", value, "afterRemarks");
            return (Criteria) this;
        }

        public Criteria andAfterRemarksLessThanOrEqualTo(String value) {
            addCriterion("after_remarks <=", value, "afterRemarks");
            return (Criteria) this;
        }

        public Criteria andAfterRemarksLike(String value) {
            addCriterion("after_remarks like", value, "afterRemarks");
            return (Criteria) this;
        }

        public Criteria andAfterRemarksNotLike(String value) {
            addCriterion("after_remarks not like", value, "afterRemarks");
            return (Criteria) this;
        }

        public Criteria andAfterRemarksIn(List<String> values) {
            addCriterion("after_remarks in", values, "afterRemarks");
            return (Criteria) this;
        }

        public Criteria andAfterRemarksNotIn(List<String> values) {
            addCriterion("after_remarks not in", values, "afterRemarks");
            return (Criteria) this;
        }

        public Criteria andAfterRemarksBetween(String value1, String value2) {
            addCriterion("after_remarks between", value1, value2, "afterRemarks");
            return (Criteria) this;
        }

        public Criteria andAfterRemarksNotBetween(String value1, String value2) {
            addCriterion("after_remarks not between", value1, value2, "afterRemarks");
            return (Criteria) this;
        }

        public Criteria andBeforeCarOwnerNameIsNull() {
            addCriterion("before_car_owner_name is null");
            return (Criteria) this;
        }

        public Criteria andBeforeCarOwnerNameIsNotNull() {
            addCriterion("before_car_owner_name is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeCarOwnerNameEqualTo(String value) {
            addCriterion("before_car_owner_name =", value, "beforeCarOwnerName");
            return (Criteria) this;
        }

        public Criteria andBeforeCarOwnerNameNotEqualTo(String value) {
            addCriterion("before_car_owner_name <>", value, "beforeCarOwnerName");
            return (Criteria) this;
        }

        public Criteria andBeforeCarOwnerNameGreaterThan(String value) {
            addCriterion("before_car_owner_name >", value, "beforeCarOwnerName");
            return (Criteria) this;
        }

        public Criteria andBeforeCarOwnerNameGreaterThanOrEqualTo(String value) {
            addCriterion("before_car_owner_name >=", value, "beforeCarOwnerName");
            return (Criteria) this;
        }

        public Criteria andBeforeCarOwnerNameLessThan(String value) {
            addCriterion("before_car_owner_name <", value, "beforeCarOwnerName");
            return (Criteria) this;
        }

        public Criteria andBeforeCarOwnerNameLessThanOrEqualTo(String value) {
            addCriterion("before_car_owner_name <=", value, "beforeCarOwnerName");
            return (Criteria) this;
        }

        public Criteria andBeforeCarOwnerNameLike(String value) {
            addCriterion("before_car_owner_name like", value, "beforeCarOwnerName");
            return (Criteria) this;
        }

        public Criteria andBeforeCarOwnerNameNotLike(String value) {
            addCriterion("before_car_owner_name not like", value, "beforeCarOwnerName");
            return (Criteria) this;
        }

        public Criteria andBeforeCarOwnerNameIn(List<String> values) {
            addCriterion("before_car_owner_name in", values, "beforeCarOwnerName");
            return (Criteria) this;
        }

        public Criteria andBeforeCarOwnerNameNotIn(List<String> values) {
            addCriterion("before_car_owner_name not in", values, "beforeCarOwnerName");
            return (Criteria) this;
        }

        public Criteria andBeforeCarOwnerNameBetween(String value1, String value2) {
            addCriterion("before_car_owner_name between", value1, value2, "beforeCarOwnerName");
            return (Criteria) this;
        }

        public Criteria andBeforeCarOwnerNameNotBetween(String value1, String value2) {
            addCriterion("before_car_owner_name not between", value1, value2, "beforeCarOwnerName");
            return (Criteria) this;
        }

        public Criteria andAfterCarOwnerNameIsNull() {
            addCriterion("after_car_owner_name is null");
            return (Criteria) this;
        }

        public Criteria andAfterCarOwnerNameIsNotNull() {
            addCriterion("after_car_owner_name is not null");
            return (Criteria) this;
        }

        public Criteria andAfterCarOwnerNameEqualTo(String value) {
            addCriterion("after_car_owner_name =", value, "afterCarOwnerName");
            return (Criteria) this;
        }

        public Criteria andAfterCarOwnerNameNotEqualTo(String value) {
            addCriterion("after_car_owner_name <>", value, "afterCarOwnerName");
            return (Criteria) this;
        }

        public Criteria andAfterCarOwnerNameGreaterThan(String value) {
            addCriterion("after_car_owner_name >", value, "afterCarOwnerName");
            return (Criteria) this;
        }

        public Criteria andAfterCarOwnerNameGreaterThanOrEqualTo(String value) {
            addCriterion("after_car_owner_name >=", value, "afterCarOwnerName");
            return (Criteria) this;
        }

        public Criteria andAfterCarOwnerNameLessThan(String value) {
            addCriterion("after_car_owner_name <", value, "afterCarOwnerName");
            return (Criteria) this;
        }

        public Criteria andAfterCarOwnerNameLessThanOrEqualTo(String value) {
            addCriterion("after_car_owner_name <=", value, "afterCarOwnerName");
            return (Criteria) this;
        }

        public Criteria andAfterCarOwnerNameLike(String value) {
            addCriterion("after_car_owner_name like", value, "afterCarOwnerName");
            return (Criteria) this;
        }

        public Criteria andAfterCarOwnerNameNotLike(String value) {
            addCriterion("after_car_owner_name not like", value, "afterCarOwnerName");
            return (Criteria) this;
        }

        public Criteria andAfterCarOwnerNameIn(List<String> values) {
            addCriterion("after_car_owner_name in", values, "afterCarOwnerName");
            return (Criteria) this;
        }

        public Criteria andAfterCarOwnerNameNotIn(List<String> values) {
            addCriterion("after_car_owner_name not in", values, "afterCarOwnerName");
            return (Criteria) this;
        }

        public Criteria andAfterCarOwnerNameBetween(String value1, String value2) {
            addCriterion("after_car_owner_name between", value1, value2, "afterCarOwnerName");
            return (Criteria) this;
        }

        public Criteria andAfterCarOwnerNameNotBetween(String value1, String value2) {
            addCriterion("after_car_owner_name not between", value1, value2, "afterCarOwnerName");
            return (Criteria) this;
        }

        public Criteria andBeforeGroupFlagIsNull() {
            addCriterion("before_group_flag is null");
            return (Criteria) this;
        }

        public Criteria andBeforeGroupFlagIsNotNull() {
            addCriterion("before_group_flag is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeGroupFlagEqualTo(String value) {
            addCriterion("before_group_flag =", value, "beforeGroupFlag");
            return (Criteria) this;
        }

        public Criteria andBeforeGroupFlagNotEqualTo(String value) {
            addCriterion("before_group_flag <>", value, "beforeGroupFlag");
            return (Criteria) this;
        }

        public Criteria andBeforeGroupFlagGreaterThan(String value) {
            addCriterion("before_group_flag >", value, "beforeGroupFlag");
            return (Criteria) this;
        }

        public Criteria andBeforeGroupFlagGreaterThanOrEqualTo(String value) {
            addCriterion("before_group_flag >=", value, "beforeGroupFlag");
            return (Criteria) this;
        }

        public Criteria andBeforeGroupFlagLessThan(String value) {
            addCriterion("before_group_flag <", value, "beforeGroupFlag");
            return (Criteria) this;
        }

        public Criteria andBeforeGroupFlagLessThanOrEqualTo(String value) {
            addCriterion("before_group_flag <=", value, "beforeGroupFlag");
            return (Criteria) this;
        }

        public Criteria andBeforeGroupFlagLike(String value) {
            addCriterion("before_group_flag like", value, "beforeGroupFlag");
            return (Criteria) this;
        }

        public Criteria andBeforeGroupFlagNotLike(String value) {
            addCriterion("before_group_flag not like", value, "beforeGroupFlag");
            return (Criteria) this;
        }

        public Criteria andBeforeGroupFlagIn(List<String> values) {
            addCriterion("before_group_flag in", values, "beforeGroupFlag");
            return (Criteria) this;
        }

        public Criteria andBeforeGroupFlagNotIn(List<String> values) {
            addCriterion("before_group_flag not in", values, "beforeGroupFlag");
            return (Criteria) this;
        }

        public Criteria andBeforeGroupFlagBetween(String value1, String value2) {
            addCriterion("before_group_flag between", value1, value2, "beforeGroupFlag");
            return (Criteria) this;
        }

        public Criteria andBeforeGroupFlagNotBetween(String value1, String value2) {
            addCriterion("before_group_flag not between", value1, value2, "beforeGroupFlag");
            return (Criteria) this;
        }

        public Criteria andBeforeStatusIsNull() {
            addCriterion("before_status is null");
            return (Criteria) this;
        }

        public Criteria andBeforeStatusIsNotNull() {
            addCriterion("before_status is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeStatusEqualTo(Byte value) {
            addCriterion("before_status =", value, "beforeStatus");
            return (Criteria) this;
        }

        public Criteria andBeforeStatusNotEqualTo(Byte value) {
            addCriterion("before_status <>", value, "beforeStatus");
            return (Criteria) this;
        }

        public Criteria andBeforeStatusGreaterThan(Byte value) {
            addCriterion("before_status >", value, "beforeStatus");
            return (Criteria) this;
        }

        public Criteria andBeforeStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("before_status >=", value, "beforeStatus");
            return (Criteria) this;
        }

        public Criteria andBeforeStatusLessThan(Byte value) {
            addCriterion("before_status <", value, "beforeStatus");
            return (Criteria) this;
        }

        public Criteria andBeforeStatusLessThanOrEqualTo(Byte value) {
            addCriterion("before_status <=", value, "beforeStatus");
            return (Criteria) this;
        }

        public Criteria andBeforeStatusIn(List<Byte> values) {
            addCriterion("before_status in", values, "beforeStatus");
            return (Criteria) this;
        }

        public Criteria andBeforeStatusNotIn(List<Byte> values) {
            addCriterion("before_status not in", values, "beforeStatus");
            return (Criteria) this;
        }

        public Criteria andBeforeStatusBetween(Byte value1, Byte value2) {
            addCriterion("before_status between", value1, value2, "beforeStatus");
            return (Criteria) this;
        }

        public Criteria andBeforeStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("before_status not between", value1, value2, "beforeStatus");
            return (Criteria) this;
        }

        public Criteria andAfterStatusIsNull() {
            addCriterion("after_status is null");
            return (Criteria) this;
        }

        public Criteria andAfterStatusIsNotNull() {
            addCriterion("after_status is not null");
            return (Criteria) this;
        }

        public Criteria andAfterStatusEqualTo(Byte value) {
            addCriterion("after_status =", value, "afterStatus");
            return (Criteria) this;
        }

        public Criteria andAfterStatusNotEqualTo(Byte value) {
            addCriterion("after_status <>", value, "afterStatus");
            return (Criteria) this;
        }

        public Criteria andAfterStatusGreaterThan(Byte value) {
            addCriterion("after_status >", value, "afterStatus");
            return (Criteria) this;
        }

        public Criteria andAfterStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("after_status >=", value, "afterStatus");
            return (Criteria) this;
        }

        public Criteria andAfterStatusLessThan(Byte value) {
            addCriterion("after_status <", value, "afterStatus");
            return (Criteria) this;
        }

        public Criteria andAfterStatusLessThanOrEqualTo(Byte value) {
            addCriterion("after_status <=", value, "afterStatus");
            return (Criteria) this;
        }

        public Criteria andAfterStatusIn(List<Byte> values) {
            addCriterion("after_status in", values, "afterStatus");
            return (Criteria) this;
        }

        public Criteria andAfterStatusNotIn(List<Byte> values) {
            addCriterion("after_status not in", values, "afterStatus");
            return (Criteria) this;
        }

        public Criteria andAfterStatusBetween(Byte value1, Byte value2) {
            addCriterion("after_status between", value1, value2, "afterStatus");
            return (Criteria) this;
        }

        public Criteria andAfterStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("after_status not between", value1, value2, "afterStatus");
            return (Criteria) this;
        }

        public Criteria andHandleUidIsNull() {
            addCriterion("handle_uid is null");
            return (Criteria) this;
        }

        public Criteria andHandleUidIsNotNull() {
            addCriterion("handle_uid is not null");
            return (Criteria) this;
        }

        public Criteria andHandleUidEqualTo(String value) {
            addCriterion("handle_uid =", value, "handleUid");
            return (Criteria) this;
        }

        public Criteria andHandleUidNotEqualTo(String value) {
            addCriterion("handle_uid <>", value, "handleUid");
            return (Criteria) this;
        }

        public Criteria andHandleUidGreaterThan(String value) {
            addCriterion("handle_uid >", value, "handleUid");
            return (Criteria) this;
        }

        public Criteria andHandleUidGreaterThanOrEqualTo(String value) {
            addCriterion("handle_uid >=", value, "handleUid");
            return (Criteria) this;
        }

        public Criteria andHandleUidLessThan(String value) {
            addCriterion("handle_uid <", value, "handleUid");
            return (Criteria) this;
        }

        public Criteria andHandleUidLessThanOrEqualTo(String value) {
            addCriterion("handle_uid <=", value, "handleUid");
            return (Criteria) this;
        }

        public Criteria andHandleUidLike(String value) {
            addCriterion("handle_uid like", value, "handleUid");
            return (Criteria) this;
        }

        public Criteria andHandleUidNotLike(String value) {
            addCriterion("handle_uid not like", value, "handleUid");
            return (Criteria) this;
        }

        public Criteria andHandleUidIn(List<String> values) {
            addCriterion("handle_uid in", values, "handleUid");
            return (Criteria) this;
        }

        public Criteria andHandleUidNotIn(List<String> values) {
            addCriterion("handle_uid not in", values, "handleUid");
            return (Criteria) this;
        }

        public Criteria andHandleUidBetween(String value1, String value2) {
            addCriterion("handle_uid between", value1, value2, "handleUid");
            return (Criteria) this;
        }

        public Criteria andHandleUidNotBetween(String value1, String value2) {
            addCriterion("handle_uid not between", value1, value2, "handleUid");
            return (Criteria) this;
        }

        public Criteria andActionTimeIsNull() {
            addCriterion("action_time is null");
            return (Criteria) this;
        }

        public Criteria andActionTimeIsNotNull() {
            addCriterion("action_time is not null");
            return (Criteria) this;
        }

        public Criteria andActionTimeEqualTo(Long value) {
            addCriterion("action_time =", value, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeNotEqualTo(Long value) {
            addCriterion("action_time <>", value, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeGreaterThan(Long value) {
            addCriterion("action_time >", value, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("action_time >=", value, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeLessThan(Long value) {
            addCriterion("action_time <", value, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeLessThanOrEqualTo(Long value) {
            addCriterion("action_time <=", value, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeIn(List<Long> values) {
            addCriterion("action_time in", values, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeNotIn(List<Long> values) {
            addCriterion("action_time not in", values, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeBetween(Long value1, Long value2) {
            addCriterion("action_time between", value1, value2, "actionTime");
            return (Criteria) this;
        }

        public Criteria andActionTimeNotBetween(Long value1, Long value2) {
            addCriterion("action_time not between", value1, value2, "actionTime");
            return (Criteria) this;
        }

        public Criteria andAfterGroupFlagIsNull() {
            addCriterion("after_group_flag is null");
            return (Criteria) this;
        }

        public Criteria andAfterGroupFlagIsNotNull() {
            addCriterion("after_group_flag is not null");
            return (Criteria) this;
        }

        public Criteria andAfterGroupFlagEqualTo(String value) {
            addCriterion("after_group_flag =", value, "afterGroupFlag");
            return (Criteria) this;
        }

        public Criteria andAfterGroupFlagNotEqualTo(String value) {
            addCriterion("after_group_flag <>", value, "afterGroupFlag");
            return (Criteria) this;
        }

        public Criteria andAfterGroupFlagGreaterThan(String value) {
            addCriterion("after_group_flag >", value, "afterGroupFlag");
            return (Criteria) this;
        }

        public Criteria andAfterGroupFlagGreaterThanOrEqualTo(String value) {
            addCriterion("after_group_flag >=", value, "afterGroupFlag");
            return (Criteria) this;
        }

        public Criteria andAfterGroupFlagLessThan(String value) {
            addCriterion("after_group_flag <", value, "afterGroupFlag");
            return (Criteria) this;
        }

        public Criteria andAfterGroupFlagLessThanOrEqualTo(String value) {
            addCriterion("after_group_flag <=", value, "afterGroupFlag");
            return (Criteria) this;
        }

        public Criteria andAfterGroupFlagLike(String value) {
            addCriterion("after_group_flag like", value, "afterGroupFlag");
            return (Criteria) this;
        }

        public Criteria andAfterGroupFlagNotLike(String value) {
            addCriterion("after_group_flag not like", value, "afterGroupFlag");
            return (Criteria) this;
        }

        public Criteria andAfterGroupFlagIn(List<String> values) {
            addCriterion("after_group_flag in", values, "afterGroupFlag");
            return (Criteria) this;
        }

        public Criteria andAfterGroupFlagNotIn(List<String> values) {
            addCriterion("after_group_flag not in", values, "afterGroupFlag");
            return (Criteria) this;
        }

        public Criteria andAfterGroupFlagBetween(String value1, String value2) {
            addCriterion("after_group_flag between", value1, value2, "afterGroupFlag");
            return (Criteria) this;
        }

        public Criteria andAfterGroupFlagNotBetween(String value1, String value2) {
            addCriterion("after_group_flag not between", value1, value2, "afterGroupFlag");
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