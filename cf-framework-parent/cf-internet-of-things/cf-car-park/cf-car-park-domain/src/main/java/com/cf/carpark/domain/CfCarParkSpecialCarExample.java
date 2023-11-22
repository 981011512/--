package com.cf.carpark.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CfCarParkSpecialCarExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfCarParkSpecialCarExample() {
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

        public Criteria andTypeKeyIsNull() {
            addCriterion("type_key is null");
            return (Criteria) this;
        }

        public Criteria andTypeKeyIsNotNull() {
            addCriterion("type_key is not null");
            return (Criteria) this;
        }

        public Criteria andTypeKeyEqualTo(String value) {
            addCriterion("type_key =", value, "typeKey");
            return (Criteria) this;
        }

        public Criteria andTypeKeyNotEqualTo(String value) {
            addCriterion("type_key <>", value, "typeKey");
            return (Criteria) this;
        }

        public Criteria andTypeKeyGreaterThan(String value) {
            addCriterion("type_key >", value, "typeKey");
            return (Criteria) this;
        }

        public Criteria andTypeKeyGreaterThanOrEqualTo(String value) {
            addCriterion("type_key >=", value, "typeKey");
            return (Criteria) this;
        }

        public Criteria andTypeKeyLessThan(String value) {
            addCriterion("type_key <", value, "typeKey");
            return (Criteria) this;
        }

        public Criteria andTypeKeyLessThanOrEqualTo(String value) {
            addCriterion("type_key <=", value, "typeKey");
            return (Criteria) this;
        }

        public Criteria andTypeKeyLike(String value) {
            addCriterion("type_key like", value, "typeKey");
            return (Criteria) this;
        }

        public Criteria andTypeKeyNotLike(String value) {
            addCriterion("type_key not like", value, "typeKey");
            return (Criteria) this;
        }

        public Criteria andTypeKeyIn(List<String> values) {
            addCriterion("type_key in", values, "typeKey");
            return (Criteria) this;
        }

        public Criteria andTypeKeyNotIn(List<String> values) {
            addCriterion("type_key not in", values, "typeKey");
            return (Criteria) this;
        }

        public Criteria andTypeKeyBetween(String value1, String value2) {
            addCriterion("type_key between", value1, value2, "typeKey");
            return (Criteria) this;
        }

        public Criteria andTypeKeyNotBetween(String value1, String value2) {
            addCriterion("type_key not between", value1, value2, "typeKey");
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

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Long value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Long value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Long value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Long value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Long value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Long> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Long> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Long value1, Long value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Long value1, Long value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andCarOwnerNameIsNull() {
            addCriterion("car_owner_name is null");
            return (Criteria) this;
        }

        public Criteria andCarOwnerNameIsNotNull() {
            addCriterion("car_owner_name is not null");
            return (Criteria) this;
        }

        public Criteria andCarOwnerNameEqualTo(String value) {
            addCriterion("car_owner_name =", value, "carOwnerName");
            return (Criteria) this;
        }

        public Criteria andCarOwnerNameNotEqualTo(String value) {
            addCriterion("car_owner_name <>", value, "carOwnerName");
            return (Criteria) this;
        }

        public Criteria andCarOwnerNameGreaterThan(String value) {
            addCriterion("car_owner_name >", value, "carOwnerName");
            return (Criteria) this;
        }

        public Criteria andCarOwnerNameGreaterThanOrEqualTo(String value) {
            addCriterion("car_owner_name >=", value, "carOwnerName");
            return (Criteria) this;
        }

        public Criteria andCarOwnerNameLessThan(String value) {
            addCriterion("car_owner_name <", value, "carOwnerName");
            return (Criteria) this;
        }

        public Criteria andCarOwnerNameLessThanOrEqualTo(String value) {
            addCriterion("car_owner_name <=", value, "carOwnerName");
            return (Criteria) this;
        }

        public Criteria andCarOwnerNameLike(String value) {
            addCriterion("car_owner_name like", value, "carOwnerName");
            return (Criteria) this;
        }

        public Criteria andCarOwnerNameNotLike(String value) {
            addCriterion("car_owner_name not like", value, "carOwnerName");
            return (Criteria) this;
        }

        public Criteria andCarOwnerNameIn(List<String> values) {
            addCriterion("car_owner_name in", values, "carOwnerName");
            return (Criteria) this;
        }

        public Criteria andCarOwnerNameNotIn(List<String> values) {
            addCriterion("car_owner_name not in", values, "carOwnerName");
            return (Criteria) this;
        }

        public Criteria andCarOwnerNameBetween(String value1, String value2) {
            addCriterion("car_owner_name between", value1, value2, "carOwnerName");
            return (Criteria) this;
        }

        public Criteria andCarOwnerNameNotBetween(String value1, String value2) {
            addCriterion("car_owner_name not between", value1, value2, "carOwnerName");
            return (Criteria) this;
        }

        public Criteria andGroupFlagIsNull() {
            addCriterion("group_flag is null");
            return (Criteria) this;
        }

        public Criteria andGroupFlagIsNotNull() {
            addCriterion("group_flag is not null");
            return (Criteria) this;
        }

        public Criteria andGroupFlagEqualTo(String value) {
            addCriterion("group_flag =", value, "groupFlag");
            return (Criteria) this;
        }

        public Criteria andGroupFlagNotEqualTo(String value) {
            addCriterion("group_flag <>", value, "groupFlag");
            return (Criteria) this;
        }

        public Criteria andGroupFlagGreaterThan(String value) {
            addCriterion("group_flag >", value, "groupFlag");
            return (Criteria) this;
        }

        public Criteria andGroupFlagGreaterThanOrEqualTo(String value) {
            addCriterion("group_flag >=", value, "groupFlag");
            return (Criteria) this;
        }

        public Criteria andGroupFlagLessThan(String value) {
            addCriterion("group_flag <", value, "groupFlag");
            return (Criteria) this;
        }

        public Criteria andGroupFlagLessThanOrEqualTo(String value) {
            addCriterion("group_flag <=", value, "groupFlag");
            return (Criteria) this;
        }

        public Criteria andGroupFlagLike(String value) {
            addCriterion("group_flag like", value, "groupFlag");
            return (Criteria) this;
        }

        public Criteria andGroupFlagNotLike(String value) {
            addCriterion("group_flag not like", value, "groupFlag");
            return (Criteria) this;
        }

        public Criteria andGroupFlagIn(List<String> values) {
            addCriterion("group_flag in", values, "groupFlag");
            return (Criteria) this;
        }

        public Criteria andGroupFlagNotIn(List<String> values) {
            addCriterion("group_flag not in", values, "groupFlag");
            return (Criteria) this;
        }

        public Criteria andGroupFlagBetween(String value1, String value2) {
            addCriterion("group_flag between", value1, value2, "groupFlag");
            return (Criteria) this;
        }

        public Criteria andGroupFlagNotBetween(String value1, String value2) {
            addCriterion("group_flag not between", value1, value2, "groupFlag");
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

        public Criteria andRemainingParkTimeIsNull() {
            addCriterion("remaining_park_time is null");
            return (Criteria) this;
        }

        public Criteria andRemainingParkTimeIsNotNull() {
            addCriterion("remaining_park_time is not null");
            return (Criteria) this;
        }

        public Criteria andRemainingParkTimeEqualTo(Long value) {
            addCriterion("remaining_park_time =", value, "remainingParkTime");
            return (Criteria) this;
        }

        public Criteria andRemainingParkTimeNotEqualTo(Long value) {
            addCriterion("remaining_park_time <>", value, "remainingParkTime");
            return (Criteria) this;
        }

        public Criteria andRemainingParkTimeGreaterThan(Long value) {
            addCriterion("remaining_park_time >", value, "remainingParkTime");
            return (Criteria) this;
        }

        public Criteria andRemainingParkTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("remaining_park_time >=", value, "remainingParkTime");
            return (Criteria) this;
        }

        public Criteria andRemainingParkTimeLessThan(Long value) {
            addCriterion("remaining_park_time <", value, "remainingParkTime");
            return (Criteria) this;
        }

        public Criteria andRemainingParkTimeLessThanOrEqualTo(Long value) {
            addCriterion("remaining_park_time <=", value, "remainingParkTime");
            return (Criteria) this;
        }

        public Criteria andRemainingParkTimeIn(List<Long> values) {
            addCriterion("remaining_park_time in", values, "remainingParkTime");
            return (Criteria) this;
        }

        public Criteria andRemainingParkTimeNotIn(List<Long> values) {
            addCriterion("remaining_park_time not in", values, "remainingParkTime");
            return (Criteria) this;
        }

        public Criteria andRemainingParkTimeBetween(Long value1, Long value2) {
            addCriterion("remaining_park_time between", value1, value2, "remainingParkTime");
            return (Criteria) this;
        }

        public Criteria andRemainingParkTimeNotBetween(Long value1, Long value2) {
            addCriterion("remaining_park_time not between", value1, value2, "remainingParkTime");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayIsNull() {
            addCriterion("auto_give_away is null");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayIsNotNull() {
            addCriterion("auto_give_away is not null");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayEqualTo(Byte value) {
            addCriterion("auto_give_away =", value, "autoGiveAway");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayNotEqualTo(Byte value) {
            addCriterion("auto_give_away <>", value, "autoGiveAway");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayGreaterThan(Byte value) {
            addCriterion("auto_give_away >", value, "autoGiveAway");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayGreaterThanOrEqualTo(Byte value) {
            addCriterion("auto_give_away >=", value, "autoGiveAway");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayLessThan(Byte value) {
            addCriterion("auto_give_away <", value, "autoGiveAway");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayLessThanOrEqualTo(Byte value) {
            addCriterion("auto_give_away <=", value, "autoGiveAway");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayIn(List<Byte> values) {
            addCriterion("auto_give_away in", values, "autoGiveAway");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayNotIn(List<Byte> values) {
            addCriterion("auto_give_away not in", values, "autoGiveAway");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayBetween(Byte value1, Byte value2) {
            addCriterion("auto_give_away between", value1, value2, "autoGiveAway");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayNotBetween(Byte value1, Byte value2) {
            addCriterion("auto_give_away not between", value1, value2, "autoGiveAway");
            return (Criteria) this;
        }

        public Criteria andAutoClearedIsNull() {
            addCriterion("auto_cleared is null");
            return (Criteria) this;
        }

        public Criteria andAutoClearedIsNotNull() {
            addCriterion("auto_cleared is not null");
            return (Criteria) this;
        }

        public Criteria andAutoClearedEqualTo(Byte value) {
            addCriterion("auto_cleared =", value, "autoCleared");
            return (Criteria) this;
        }

        public Criteria andAutoClearedNotEqualTo(Byte value) {
            addCriterion("auto_cleared <>", value, "autoCleared");
            return (Criteria) this;
        }

        public Criteria andAutoClearedGreaterThan(Byte value) {
            addCriterion("auto_cleared >", value, "autoCleared");
            return (Criteria) this;
        }

        public Criteria andAutoClearedGreaterThanOrEqualTo(Byte value) {
            addCriterion("auto_cleared >=", value, "autoCleared");
            return (Criteria) this;
        }

        public Criteria andAutoClearedLessThan(Byte value) {
            addCriterion("auto_cleared <", value, "autoCleared");
            return (Criteria) this;
        }

        public Criteria andAutoClearedLessThanOrEqualTo(Byte value) {
            addCriterion("auto_cleared <=", value, "autoCleared");
            return (Criteria) this;
        }

        public Criteria andAutoClearedIn(List<Byte> values) {
            addCriterion("auto_cleared in", values, "autoCleared");
            return (Criteria) this;
        }

        public Criteria andAutoClearedNotIn(List<Byte> values) {
            addCriterion("auto_cleared not in", values, "autoCleared");
            return (Criteria) this;
        }

        public Criteria andAutoClearedBetween(Byte value1, Byte value2) {
            addCriterion("auto_cleared between", value1, value2, "autoCleared");
            return (Criteria) this;
        }

        public Criteria andAutoClearedNotBetween(Byte value1, Byte value2) {
            addCriterion("auto_cleared not between", value1, value2, "autoCleared");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayDateIsNull() {
            addCriterion("auto_give_away_date is null");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayDateIsNotNull() {
            addCriterion("auto_give_away_date is not null");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayDateEqualTo(String value) {
            addCriterion("auto_give_away_date =", value, "autoGiveAwayDate");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayDateNotEqualTo(String value) {
            addCriterion("auto_give_away_date <>", value, "autoGiveAwayDate");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayDateGreaterThan(String value) {
            addCriterion("auto_give_away_date >", value, "autoGiveAwayDate");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayDateGreaterThanOrEqualTo(String value) {
            addCriterion("auto_give_away_date >=", value, "autoGiveAwayDate");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayDateLessThan(String value) {
            addCriterion("auto_give_away_date <", value, "autoGiveAwayDate");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayDateLessThanOrEqualTo(String value) {
            addCriterion("auto_give_away_date <=", value, "autoGiveAwayDate");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayDateLike(String value) {
            addCriterion("auto_give_away_date like", value, "autoGiveAwayDate");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayDateNotLike(String value) {
            addCriterion("auto_give_away_date not like", value, "autoGiveAwayDate");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayDateIn(List<String> values) {
            addCriterion("auto_give_away_date in", values, "autoGiveAwayDate");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayDateNotIn(List<String> values) {
            addCriterion("auto_give_away_date not in", values, "autoGiveAwayDate");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayDateBetween(String value1, String value2) {
            addCriterion("auto_give_away_date between", value1, value2, "autoGiveAwayDate");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayDateNotBetween(String value1, String value2) {
            addCriterion("auto_give_away_date not between", value1, value2, "autoGiveAwayDate");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayAmountIsNull() {
            addCriterion("auto_give_away_amount is null");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayAmountIsNotNull() {
            addCriterion("auto_give_away_amount is not null");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayAmountEqualTo(BigDecimal value) {
            addCriterion("auto_give_away_amount =", value, "autoGiveAwayAmount");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayAmountNotEqualTo(BigDecimal value) {
            addCriterion("auto_give_away_amount <>", value, "autoGiveAwayAmount");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayAmountGreaterThan(BigDecimal value) {
            addCriterion("auto_give_away_amount >", value, "autoGiveAwayAmount");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("auto_give_away_amount >=", value, "autoGiveAwayAmount");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayAmountLessThan(BigDecimal value) {
            addCriterion("auto_give_away_amount <", value, "autoGiveAwayAmount");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("auto_give_away_amount <=", value, "autoGiveAwayAmount");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayAmountIn(List<BigDecimal> values) {
            addCriterion("auto_give_away_amount in", values, "autoGiveAwayAmount");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayAmountNotIn(List<BigDecimal> values) {
            addCriterion("auto_give_away_amount not in", values, "autoGiveAwayAmount");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("auto_give_away_amount between", value1, value2, "autoGiveAwayAmount");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("auto_give_away_amount not between", value1, value2, "autoGiveAwayAmount");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayTimeIsNull() {
            addCriterion("auto_give_away_time is null");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayTimeIsNotNull() {
            addCriterion("auto_give_away_time is not null");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayTimeEqualTo(Long value) {
            addCriterion("auto_give_away_time =", value, "autoGiveAwayTime");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayTimeNotEqualTo(Long value) {
            addCriterion("auto_give_away_time <>", value, "autoGiveAwayTime");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayTimeGreaterThan(Long value) {
            addCriterion("auto_give_away_time >", value, "autoGiveAwayTime");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("auto_give_away_time >=", value, "autoGiveAwayTime");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayTimeLessThan(Long value) {
            addCriterion("auto_give_away_time <", value, "autoGiveAwayTime");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayTimeLessThanOrEqualTo(Long value) {
            addCriterion("auto_give_away_time <=", value, "autoGiveAwayTime");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayTimeIn(List<Long> values) {
            addCriterion("auto_give_away_time in", values, "autoGiveAwayTime");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayTimeNotIn(List<Long> values) {
            addCriterion("auto_give_away_time not in", values, "autoGiveAwayTime");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayTimeBetween(Long value1, Long value2) {
            addCriterion("auto_give_away_time between", value1, value2, "autoGiveAwayTime");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayTimeNotBetween(Long value1, Long value2) {
            addCriterion("auto_give_away_time not between", value1, value2, "autoGiveAwayTime");
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