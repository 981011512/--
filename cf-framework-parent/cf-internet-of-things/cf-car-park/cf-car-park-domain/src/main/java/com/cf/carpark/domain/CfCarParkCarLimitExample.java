package com.cf.carpark.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CfCarParkCarLimitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfCarParkCarLimitExample() {
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

        public Criteria andCarTypeKeyIsNull() {
            addCriterion("car_type_key is null");
            return (Criteria) this;
        }

        public Criteria andCarTypeKeyIsNotNull() {
            addCriterion("car_type_key is not null");
            return (Criteria) this;
        }

        public Criteria andCarTypeKeyEqualTo(String value) {
            addCriterion("car_type_key =", value, "carTypeKey");
            return (Criteria) this;
        }

        public Criteria andCarTypeKeyNotEqualTo(String value) {
            addCriterion("car_type_key <>", value, "carTypeKey");
            return (Criteria) this;
        }

        public Criteria andCarTypeKeyGreaterThan(String value) {
            addCriterion("car_type_key >", value, "carTypeKey");
            return (Criteria) this;
        }

        public Criteria andCarTypeKeyGreaterThanOrEqualTo(String value) {
            addCriterion("car_type_key >=", value, "carTypeKey");
            return (Criteria) this;
        }

        public Criteria andCarTypeKeyLessThan(String value) {
            addCriterion("car_type_key <", value, "carTypeKey");
            return (Criteria) this;
        }

        public Criteria andCarTypeKeyLessThanOrEqualTo(String value) {
            addCriterion("car_type_key <=", value, "carTypeKey");
            return (Criteria) this;
        }

        public Criteria andCarTypeKeyLike(String value) {
            addCriterion("car_type_key like", value, "carTypeKey");
            return (Criteria) this;
        }

        public Criteria andCarTypeKeyNotLike(String value) {
            addCriterion("car_type_key not like", value, "carTypeKey");
            return (Criteria) this;
        }

        public Criteria andCarTypeKeyIn(List<String> values) {
            addCriterion("car_type_key in", values, "carTypeKey");
            return (Criteria) this;
        }

        public Criteria andCarTypeKeyNotIn(List<String> values) {
            addCriterion("car_type_key not in", values, "carTypeKey");
            return (Criteria) this;
        }

        public Criteria andCarTypeKeyBetween(String value1, String value2) {
            addCriterion("car_type_key between", value1, value2, "carTypeKey");
            return (Criteria) this;
        }

        public Criteria andCarTypeKeyNotBetween(String value1, String value2) {
            addCriterion("car_type_key not between", value1, value2, "carTypeKey");
            return (Criteria) this;
        }

        public Criteria andFreeTimeIsNull() {
            addCriterion("free_time is null");
            return (Criteria) this;
        }

        public Criteria andFreeTimeIsNotNull() {
            addCriterion("free_time is not null");
            return (Criteria) this;
        }

        public Criteria andFreeTimeEqualTo(Long value) {
            addCriterion("free_time =", value, "freeTime");
            return (Criteria) this;
        }

        public Criteria andFreeTimeNotEqualTo(Long value) {
            addCriterion("free_time <>", value, "freeTime");
            return (Criteria) this;
        }

        public Criteria andFreeTimeGreaterThan(Long value) {
            addCriterion("free_time >", value, "freeTime");
            return (Criteria) this;
        }

        public Criteria andFreeTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("free_time >=", value, "freeTime");
            return (Criteria) this;
        }

        public Criteria andFreeTimeLessThan(Long value) {
            addCriterion("free_time <", value, "freeTime");
            return (Criteria) this;
        }

        public Criteria andFreeTimeLessThanOrEqualTo(Long value) {
            addCriterion("free_time <=", value, "freeTime");
            return (Criteria) this;
        }

        public Criteria andFreeTimeIn(List<Long> values) {
            addCriterion("free_time in", values, "freeTime");
            return (Criteria) this;
        }

        public Criteria andFreeTimeNotIn(List<Long> values) {
            addCriterion("free_time not in", values, "freeTime");
            return (Criteria) this;
        }

        public Criteria andFreeTimeBetween(Long value1, Long value2) {
            addCriterion("free_time between", value1, value2, "freeTime");
            return (Criteria) this;
        }

        public Criteria andFreeTimeNotBetween(Long value1, Long value2) {
            addCriterion("free_time not between", value1, value2, "freeTime");
            return (Criteria) this;
        }

        public Criteria andGiveFreeTimeIsNull() {
            addCriterion("give_free_time is null");
            return (Criteria) this;
        }

        public Criteria andGiveFreeTimeIsNotNull() {
            addCriterion("give_free_time is not null");
            return (Criteria) this;
        }

        public Criteria andGiveFreeTimeEqualTo(Byte value) {
            addCriterion("give_free_time =", value, "giveFreeTime");
            return (Criteria) this;
        }

        public Criteria andGiveFreeTimeNotEqualTo(Byte value) {
            addCriterion("give_free_time <>", value, "giveFreeTime");
            return (Criteria) this;
        }

        public Criteria andGiveFreeTimeGreaterThan(Byte value) {
            addCriterion("give_free_time >", value, "giveFreeTime");
            return (Criteria) this;
        }

        public Criteria andGiveFreeTimeGreaterThanOrEqualTo(Byte value) {
            addCriterion("give_free_time >=", value, "giveFreeTime");
            return (Criteria) this;
        }

        public Criteria andGiveFreeTimeLessThan(Byte value) {
            addCriterion("give_free_time <", value, "giveFreeTime");
            return (Criteria) this;
        }

        public Criteria andGiveFreeTimeLessThanOrEqualTo(Byte value) {
            addCriterion("give_free_time <=", value, "giveFreeTime");
            return (Criteria) this;
        }

        public Criteria andGiveFreeTimeIn(List<Byte> values) {
            addCriterion("give_free_time in", values, "giveFreeTime");
            return (Criteria) this;
        }

        public Criteria andGiveFreeTimeNotIn(List<Byte> values) {
            addCriterion("give_free_time not in", values, "giveFreeTime");
            return (Criteria) this;
        }

        public Criteria andGiveFreeTimeBetween(Byte value1, Byte value2) {
            addCriterion("give_free_time between", value1, value2, "giveFreeTime");
            return (Criteria) this;
        }

        public Criteria andGiveFreeTimeNotBetween(Byte value1, Byte value2) {
            addCriterion("give_free_time not between", value1, value2, "giveFreeTime");
            return (Criteria) this;
        }

        public Criteria andAutoOpenDoorIsNull() {
            addCriterion("auto_open_door is null");
            return (Criteria) this;
        }

        public Criteria andAutoOpenDoorIsNotNull() {
            addCriterion("auto_open_door is not null");
            return (Criteria) this;
        }

        public Criteria andAutoOpenDoorEqualTo(Byte value) {
            addCriterion("auto_open_door =", value, "autoOpenDoor");
            return (Criteria) this;
        }

        public Criteria andAutoOpenDoorNotEqualTo(Byte value) {
            addCriterion("auto_open_door <>", value, "autoOpenDoor");
            return (Criteria) this;
        }

        public Criteria andAutoOpenDoorGreaterThan(Byte value) {
            addCriterion("auto_open_door >", value, "autoOpenDoor");
            return (Criteria) this;
        }

        public Criteria andAutoOpenDoorGreaterThanOrEqualTo(Byte value) {
            addCriterion("auto_open_door >=", value, "autoOpenDoor");
            return (Criteria) this;
        }

        public Criteria andAutoOpenDoorLessThan(Byte value) {
            addCriterion("auto_open_door <", value, "autoOpenDoor");
            return (Criteria) this;
        }

        public Criteria andAutoOpenDoorLessThanOrEqualTo(Byte value) {
            addCriterion("auto_open_door <=", value, "autoOpenDoor");
            return (Criteria) this;
        }

        public Criteria andAutoOpenDoorIn(List<Byte> values) {
            addCriterion("auto_open_door in", values, "autoOpenDoor");
            return (Criteria) this;
        }

        public Criteria andAutoOpenDoorNotIn(List<Byte> values) {
            addCriterion("auto_open_door not in", values, "autoOpenDoor");
            return (Criteria) this;
        }

        public Criteria andAutoOpenDoorBetween(Byte value1, Byte value2) {
            addCriterion("auto_open_door between", value1, value2, "autoOpenDoor");
            return (Criteria) this;
        }

        public Criteria andAutoOpenDoorNotBetween(Byte value1, Byte value2) {
            addCriterion("auto_open_door not between", value1, value2, "autoOpenDoor");
            return (Criteria) this;
        }

        public Criteria andForbidInIsNull() {
            addCriterion("forbid_in is null");
            return (Criteria) this;
        }

        public Criteria andForbidInIsNotNull() {
            addCriterion("forbid_in is not null");
            return (Criteria) this;
        }

        public Criteria andForbidInEqualTo(Byte value) {
            addCriterion("forbid_in =", value, "forbidIn");
            return (Criteria) this;
        }

        public Criteria andForbidInNotEqualTo(Byte value) {
            addCriterion("forbid_in <>", value, "forbidIn");
            return (Criteria) this;
        }

        public Criteria andForbidInGreaterThan(Byte value) {
            addCriterion("forbid_in >", value, "forbidIn");
            return (Criteria) this;
        }

        public Criteria andForbidInGreaterThanOrEqualTo(Byte value) {
            addCriterion("forbid_in >=", value, "forbidIn");
            return (Criteria) this;
        }

        public Criteria andForbidInLessThan(Byte value) {
            addCriterion("forbid_in <", value, "forbidIn");
            return (Criteria) this;
        }

        public Criteria andForbidInLessThanOrEqualTo(Byte value) {
            addCriterion("forbid_in <=", value, "forbidIn");
            return (Criteria) this;
        }

        public Criteria andForbidInIn(List<Byte> values) {
            addCriterion("forbid_in in", values, "forbidIn");
            return (Criteria) this;
        }

        public Criteria andForbidInNotIn(List<Byte> values) {
            addCriterion("forbid_in not in", values, "forbidIn");
            return (Criteria) this;
        }

        public Criteria andForbidInBetween(Byte value1, Byte value2) {
            addCriterion("forbid_in between", value1, value2, "forbidIn");
            return (Criteria) this;
        }

        public Criteria andForbidInNotBetween(Byte value1, Byte value2) {
            addCriterion("forbid_in not between", value1, value2, "forbidIn");
            return (Criteria) this;
        }

        public Criteria andFreeReleaseIsNull() {
            addCriterion("free_release is null");
            return (Criteria) this;
        }

        public Criteria andFreeReleaseIsNotNull() {
            addCriterion("free_release is not null");
            return (Criteria) this;
        }

        public Criteria andFreeReleaseEqualTo(Byte value) {
            addCriterion("free_release =", value, "freeRelease");
            return (Criteria) this;
        }

        public Criteria andFreeReleaseNotEqualTo(Byte value) {
            addCriterion("free_release <>", value, "freeRelease");
            return (Criteria) this;
        }

        public Criteria andFreeReleaseGreaterThan(Byte value) {
            addCriterion("free_release >", value, "freeRelease");
            return (Criteria) this;
        }

        public Criteria andFreeReleaseGreaterThanOrEqualTo(Byte value) {
            addCriterion("free_release >=", value, "freeRelease");
            return (Criteria) this;
        }

        public Criteria andFreeReleaseLessThan(Byte value) {
            addCriterion("free_release <", value, "freeRelease");
            return (Criteria) this;
        }

        public Criteria andFreeReleaseLessThanOrEqualTo(Byte value) {
            addCriterion("free_release <=", value, "freeRelease");
            return (Criteria) this;
        }

        public Criteria andFreeReleaseIn(List<Byte> values) {
            addCriterion("free_release in", values, "freeRelease");
            return (Criteria) this;
        }

        public Criteria andFreeReleaseNotIn(List<Byte> values) {
            addCriterion("free_release not in", values, "freeRelease");
            return (Criteria) this;
        }

        public Criteria andFreeReleaseBetween(Byte value1, Byte value2) {
            addCriterion("free_release between", value1, value2, "freeRelease");
            return (Criteria) this;
        }

        public Criteria andFreeReleaseNotBetween(Byte value1, Byte value2) {
            addCriterion("free_release not between", value1, value2, "freeRelease");
            return (Criteria) this;
        }

        public Criteria andUpperLimitTimeIsNull() {
            addCriterion("upper_limit_time is null");
            return (Criteria) this;
        }

        public Criteria andUpperLimitTimeIsNotNull() {
            addCriterion("upper_limit_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpperLimitTimeEqualTo(Long value) {
            addCriterion("upper_limit_time =", value, "upperLimitTime");
            return (Criteria) this;
        }

        public Criteria andUpperLimitTimeNotEqualTo(Long value) {
            addCriterion("upper_limit_time <>", value, "upperLimitTime");
            return (Criteria) this;
        }

        public Criteria andUpperLimitTimeGreaterThan(Long value) {
            addCriterion("upper_limit_time >", value, "upperLimitTime");
            return (Criteria) this;
        }

        public Criteria andUpperLimitTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("upper_limit_time >=", value, "upperLimitTime");
            return (Criteria) this;
        }

        public Criteria andUpperLimitTimeLessThan(Long value) {
            addCriterion("upper_limit_time <", value, "upperLimitTime");
            return (Criteria) this;
        }

        public Criteria andUpperLimitTimeLessThanOrEqualTo(Long value) {
            addCriterion("upper_limit_time <=", value, "upperLimitTime");
            return (Criteria) this;
        }

        public Criteria andUpperLimitTimeIn(List<Long> values) {
            addCriterion("upper_limit_time in", values, "upperLimitTime");
            return (Criteria) this;
        }

        public Criteria andUpperLimitTimeNotIn(List<Long> values) {
            addCriterion("upper_limit_time not in", values, "upperLimitTime");
            return (Criteria) this;
        }

        public Criteria andUpperLimitTimeBetween(Long value1, Long value2) {
            addCriterion("upper_limit_time between", value1, value2, "upperLimitTime");
            return (Criteria) this;
        }

        public Criteria andUpperLimitTimeNotBetween(Long value1, Long value2) {
            addCriterion("upper_limit_time not between", value1, value2, "upperLimitTime");
            return (Criteria) this;
        }

        public Criteria andBillingModelIsNull() {
            addCriterion("billing_model is null");
            return (Criteria) this;
        }

        public Criteria andBillingModelIsNotNull() {
            addCriterion("billing_model is not null");
            return (Criteria) this;
        }

        public Criteria andBillingModelEqualTo(String value) {
            addCriterion("billing_model =", value, "billingModel");
            return (Criteria) this;
        }

        public Criteria andBillingModelNotEqualTo(String value) {
            addCriterion("billing_model <>", value, "billingModel");
            return (Criteria) this;
        }

        public Criteria andBillingModelGreaterThan(String value) {
            addCriterion("billing_model >", value, "billingModel");
            return (Criteria) this;
        }

        public Criteria andBillingModelGreaterThanOrEqualTo(String value) {
            addCriterion("billing_model >=", value, "billingModel");
            return (Criteria) this;
        }

        public Criteria andBillingModelLessThan(String value) {
            addCriterion("billing_model <", value, "billingModel");
            return (Criteria) this;
        }

        public Criteria andBillingModelLessThanOrEqualTo(String value) {
            addCriterion("billing_model <=", value, "billingModel");
            return (Criteria) this;
        }

        public Criteria andBillingModelLike(String value) {
            addCriterion("billing_model like", value, "billingModel");
            return (Criteria) this;
        }

        public Criteria andBillingModelNotLike(String value) {
            addCriterion("billing_model not like", value, "billingModel");
            return (Criteria) this;
        }

        public Criteria andBillingModelIn(List<String> values) {
            addCriterion("billing_model in", values, "billingModel");
            return (Criteria) this;
        }

        public Criteria andBillingModelNotIn(List<String> values) {
            addCriterion("billing_model not in", values, "billingModel");
            return (Criteria) this;
        }

        public Criteria andBillingModelBetween(String value1, String value2) {
            addCriterion("billing_model between", value1, value2, "billingModel");
            return (Criteria) this;
        }

        public Criteria andBillingModelNotBetween(String value1, String value2) {
            addCriterion("billing_model not between", value1, value2, "billingModel");
            return (Criteria) this;
        }

        public Criteria andFeeUpperLimitIsNull() {
            addCriterion("fee_upper_limit is null");
            return (Criteria) this;
        }

        public Criteria andFeeUpperLimitIsNotNull() {
            addCriterion("fee_upper_limit is not null");
            return (Criteria) this;
        }

        public Criteria andFeeUpperLimitEqualTo(BigDecimal value) {
            addCriterion("fee_upper_limit =", value, "feeUpperLimit");
            return (Criteria) this;
        }

        public Criteria andFeeUpperLimitNotEqualTo(BigDecimal value) {
            addCriterion("fee_upper_limit <>", value, "feeUpperLimit");
            return (Criteria) this;
        }

        public Criteria andFeeUpperLimitGreaterThan(BigDecimal value) {
            addCriterion("fee_upper_limit >", value, "feeUpperLimit");
            return (Criteria) this;
        }

        public Criteria andFeeUpperLimitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fee_upper_limit >=", value, "feeUpperLimit");
            return (Criteria) this;
        }

        public Criteria andFeeUpperLimitLessThan(BigDecimal value) {
            addCriterion("fee_upper_limit <", value, "feeUpperLimit");
            return (Criteria) this;
        }

        public Criteria andFeeUpperLimitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fee_upper_limit <=", value, "feeUpperLimit");
            return (Criteria) this;
        }

        public Criteria andFeeUpperLimitIn(List<BigDecimal> values) {
            addCriterion("fee_upper_limit in", values, "feeUpperLimit");
            return (Criteria) this;
        }

        public Criteria andFeeUpperLimitNotIn(List<BigDecimal> values) {
            addCriterion("fee_upper_limit not in", values, "feeUpperLimit");
            return (Criteria) this;
        }

        public Criteria andFeeUpperLimitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fee_upper_limit between", value1, value2, "feeUpperLimit");
            return (Criteria) this;
        }

        public Criteria andFeeUpperLimitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fee_upper_limit not between", value1, value2, "feeUpperLimit");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLimitIsNull() {
            addCriterion("leave_time_limit is null");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLimitIsNotNull() {
            addCriterion("leave_time_limit is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLimitEqualTo(Long value) {
            addCriterion("leave_time_limit =", value, "leaveTimeLimit");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLimitNotEqualTo(Long value) {
            addCriterion("leave_time_limit <>", value, "leaveTimeLimit");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLimitGreaterThan(Long value) {
            addCriterion("leave_time_limit >", value, "leaveTimeLimit");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLimitGreaterThanOrEqualTo(Long value) {
            addCriterion("leave_time_limit >=", value, "leaveTimeLimit");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLimitLessThan(Long value) {
            addCriterion("leave_time_limit <", value, "leaveTimeLimit");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLimitLessThanOrEqualTo(Long value) {
            addCriterion("leave_time_limit <=", value, "leaveTimeLimit");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLimitIn(List<Long> values) {
            addCriterion("leave_time_limit in", values, "leaveTimeLimit");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLimitNotIn(List<Long> values) {
            addCriterion("leave_time_limit not in", values, "leaveTimeLimit");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLimitBetween(Long value1, Long value2) {
            addCriterion("leave_time_limit between", value1, value2, "leaveTimeLimit");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLimitNotBetween(Long value1, Long value2) {
            addCriterion("leave_time_limit not between", value1, value2, "leaveTimeLimit");
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