package com.cf.carpark.domain;

import java.util.ArrayList;
import java.util.List;

public class CfCarParkPackageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfCarParkPackageExample() {
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

        public Criteria andSpecialGiveIsNull() {
            addCriterion("special_give is null");
            return (Criteria) this;
        }

        public Criteria andSpecialGiveIsNotNull() {
            addCriterion("special_give is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialGiveEqualTo(Byte value) {
            addCriterion("special_give =", value, "specialGive");
            return (Criteria) this;
        }

        public Criteria andSpecialGiveNotEqualTo(Byte value) {
            addCriterion("special_give <>", value, "specialGive");
            return (Criteria) this;
        }

        public Criteria andSpecialGiveGreaterThan(Byte value) {
            addCriterion("special_give >", value, "specialGive");
            return (Criteria) this;
        }

        public Criteria andSpecialGiveGreaterThanOrEqualTo(Byte value) {
            addCriterion("special_give >=", value, "specialGive");
            return (Criteria) this;
        }

        public Criteria andSpecialGiveLessThan(Byte value) {
            addCriterion("special_give <", value, "specialGive");
            return (Criteria) this;
        }

        public Criteria andSpecialGiveLessThanOrEqualTo(Byte value) {
            addCriterion("special_give <=", value, "specialGive");
            return (Criteria) this;
        }

        public Criteria andSpecialGiveIn(List<Byte> values) {
            addCriterion("special_give in", values, "specialGive");
            return (Criteria) this;
        }

        public Criteria andSpecialGiveNotIn(List<Byte> values) {
            addCriterion("special_give not in", values, "specialGive");
            return (Criteria) this;
        }

        public Criteria andSpecialGiveBetween(Byte value1, Byte value2) {
            addCriterion("special_give between", value1, value2, "specialGive");
            return (Criteria) this;
        }

        public Criteria andSpecialGiveNotBetween(Byte value1, Byte value2) {
            addCriterion("special_give not between", value1, value2, "specialGive");
            return (Criteria) this;
        }

        public Criteria andPackagePriceIdIsNull() {
            addCriterion("package_price_id is null");
            return (Criteria) this;
        }

        public Criteria andPackagePriceIdIsNotNull() {
            addCriterion("package_price_id is not null");
            return (Criteria) this;
        }

        public Criteria andPackagePriceIdEqualTo(String value) {
            addCriterion("package_price_id =", value, "packagePriceId");
            return (Criteria) this;
        }

        public Criteria andPackagePriceIdNotEqualTo(String value) {
            addCriterion("package_price_id <>", value, "packagePriceId");
            return (Criteria) this;
        }

        public Criteria andPackagePriceIdGreaterThan(String value) {
            addCriterion("package_price_id >", value, "packagePriceId");
            return (Criteria) this;
        }

        public Criteria andPackagePriceIdGreaterThanOrEqualTo(String value) {
            addCriterion("package_price_id >=", value, "packagePriceId");
            return (Criteria) this;
        }

        public Criteria andPackagePriceIdLessThan(String value) {
            addCriterion("package_price_id <", value, "packagePriceId");
            return (Criteria) this;
        }

        public Criteria andPackagePriceIdLessThanOrEqualTo(String value) {
            addCriterion("package_price_id <=", value, "packagePriceId");
            return (Criteria) this;
        }

        public Criteria andPackagePriceIdLike(String value) {
            addCriterion("package_price_id like", value, "packagePriceId");
            return (Criteria) this;
        }

        public Criteria andPackagePriceIdNotLike(String value) {
            addCriterion("package_price_id not like", value, "packagePriceId");
            return (Criteria) this;
        }

        public Criteria andPackagePriceIdIn(List<String> values) {
            addCriterion("package_price_id in", values, "packagePriceId");
            return (Criteria) this;
        }

        public Criteria andPackagePriceIdNotIn(List<String> values) {
            addCriterion("package_price_id not in", values, "packagePriceId");
            return (Criteria) this;
        }

        public Criteria andPackagePriceIdBetween(String value1, String value2) {
            addCriterion("package_price_id between", value1, value2, "packagePriceId");
            return (Criteria) this;
        }

        public Criteria andPackagePriceIdNotBetween(String value1, String value2) {
            addCriterion("package_price_id not between", value1, value2, "packagePriceId");
            return (Criteria) this;
        }

        public Criteria andTransRegionalIsNull() {
            addCriterion("trans_regional is null");
            return (Criteria) this;
        }

        public Criteria andTransRegionalIsNotNull() {
            addCriterion("trans_regional is not null");
            return (Criteria) this;
        }

        public Criteria andTransRegionalEqualTo(Byte value) {
            addCriterion("trans_regional =", value, "transRegional");
            return (Criteria) this;
        }

        public Criteria andTransRegionalNotEqualTo(Byte value) {
            addCriterion("trans_regional <>", value, "transRegional");
            return (Criteria) this;
        }

        public Criteria andTransRegionalGreaterThan(Byte value) {
            addCriterion("trans_regional >", value, "transRegional");
            return (Criteria) this;
        }

        public Criteria andTransRegionalGreaterThanOrEqualTo(Byte value) {
            addCriterion("trans_regional >=", value, "transRegional");
            return (Criteria) this;
        }

        public Criteria andTransRegionalLessThan(Byte value) {
            addCriterion("trans_regional <", value, "transRegional");
            return (Criteria) this;
        }

        public Criteria andTransRegionalLessThanOrEqualTo(Byte value) {
            addCriterion("trans_regional <=", value, "transRegional");
            return (Criteria) this;
        }

        public Criteria andTransRegionalIn(List<Byte> values) {
            addCriterion("trans_regional in", values, "transRegional");
            return (Criteria) this;
        }

        public Criteria andTransRegionalNotIn(List<Byte> values) {
            addCriterion("trans_regional not in", values, "transRegional");
            return (Criteria) this;
        }

        public Criteria andTransRegionalBetween(Byte value1, Byte value2) {
            addCriterion("trans_regional between", value1, value2, "transRegional");
            return (Criteria) this;
        }

        public Criteria andTransRegionalNotBetween(Byte value1, Byte value2) {
            addCriterion("trans_regional not between", value1, value2, "transRegional");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(String value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(String value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(String value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(String value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(String value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLike(String value) {
            addCriterion("parent_id like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotLike(String value) {
            addCriterion("parent_id not like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<String> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<String> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(String value1, String value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(String value1, String value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
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

        public Criteria andMainCarParkIdIsNull() {
            addCriterion("main_car_park_id is null");
            return (Criteria) this;
        }

        public Criteria andMainCarParkIdIsNotNull() {
            addCriterion("main_car_park_id is not null");
            return (Criteria) this;
        }

        public Criteria andMainCarParkIdEqualTo(String value) {
            addCriterion("main_car_park_id =", value, "mainCarParkId");
            return (Criteria) this;
        }

        public Criteria andMainCarParkIdNotEqualTo(String value) {
            addCriterion("main_car_park_id <>", value, "mainCarParkId");
            return (Criteria) this;
        }

        public Criteria andMainCarParkIdGreaterThan(String value) {
            addCriterion("main_car_park_id >", value, "mainCarParkId");
            return (Criteria) this;
        }

        public Criteria andMainCarParkIdGreaterThanOrEqualTo(String value) {
            addCriterion("main_car_park_id >=", value, "mainCarParkId");
            return (Criteria) this;
        }

        public Criteria andMainCarParkIdLessThan(String value) {
            addCriterion("main_car_park_id <", value, "mainCarParkId");
            return (Criteria) this;
        }

        public Criteria andMainCarParkIdLessThanOrEqualTo(String value) {
            addCriterion("main_car_park_id <=", value, "mainCarParkId");
            return (Criteria) this;
        }

        public Criteria andMainCarParkIdLike(String value) {
            addCriterion("main_car_park_id like", value, "mainCarParkId");
            return (Criteria) this;
        }

        public Criteria andMainCarParkIdNotLike(String value) {
            addCriterion("main_car_park_id not like", value, "mainCarParkId");
            return (Criteria) this;
        }

        public Criteria andMainCarParkIdIn(List<String> values) {
            addCriterion("main_car_park_id in", values, "mainCarParkId");
            return (Criteria) this;
        }

        public Criteria andMainCarParkIdNotIn(List<String> values) {
            addCriterion("main_car_park_id not in", values, "mainCarParkId");
            return (Criteria) this;
        }

        public Criteria andMainCarParkIdBetween(String value1, String value2) {
            addCriterion("main_car_park_id between", value1, value2, "mainCarParkId");
            return (Criteria) this;
        }

        public Criteria andMainCarParkIdNotBetween(String value1, String value2) {
            addCriterion("main_car_park_id not between", value1, value2, "mainCarParkId");
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

        public Criteria andIssuedWhitelistIsNull() {
            addCriterion("issued_whitelist is null");
            return (Criteria) this;
        }

        public Criteria andIssuedWhitelistIsNotNull() {
            addCriterion("issued_whitelist is not null");
            return (Criteria) this;
        }

        public Criteria andIssuedWhitelistEqualTo(Byte value) {
            addCriterion("issued_whitelist =", value, "issuedWhitelist");
            return (Criteria) this;
        }

        public Criteria andIssuedWhitelistNotEqualTo(Byte value) {
            addCriterion("issued_whitelist <>", value, "issuedWhitelist");
            return (Criteria) this;
        }

        public Criteria andIssuedWhitelistGreaterThan(Byte value) {
            addCriterion("issued_whitelist >", value, "issuedWhitelist");
            return (Criteria) this;
        }

        public Criteria andIssuedWhitelistGreaterThanOrEqualTo(Byte value) {
            addCriterion("issued_whitelist >=", value, "issuedWhitelist");
            return (Criteria) this;
        }

        public Criteria andIssuedWhitelistLessThan(Byte value) {
            addCriterion("issued_whitelist <", value, "issuedWhitelist");
            return (Criteria) this;
        }

        public Criteria andIssuedWhitelistLessThanOrEqualTo(Byte value) {
            addCriterion("issued_whitelist <=", value, "issuedWhitelist");
            return (Criteria) this;
        }

        public Criteria andIssuedWhitelistIn(List<Byte> values) {
            addCriterion("issued_whitelist in", values, "issuedWhitelist");
            return (Criteria) this;
        }

        public Criteria andIssuedWhitelistNotIn(List<Byte> values) {
            addCriterion("issued_whitelist not in", values, "issuedWhitelist");
            return (Criteria) this;
        }

        public Criteria andIssuedWhitelistBetween(Byte value1, Byte value2) {
            addCriterion("issued_whitelist between", value1, value2, "issuedWhitelist");
            return (Criteria) this;
        }

        public Criteria andIssuedWhitelistNotBetween(Byte value1, Byte value2) {
            addCriterion("issued_whitelist not between", value1, value2, "issuedWhitelist");
            return (Criteria) this;
        }

        public Criteria andIssuedWhitelistTimeIsNull() {
            addCriterion("issued_whitelist_time is null");
            return (Criteria) this;
        }

        public Criteria andIssuedWhitelistTimeIsNotNull() {
            addCriterion("issued_whitelist_time is not null");
            return (Criteria) this;
        }

        public Criteria andIssuedWhitelistTimeEqualTo(Long value) {
            addCriterion("issued_whitelist_time =", value, "issuedWhitelistTime");
            return (Criteria) this;
        }

        public Criteria andIssuedWhitelistTimeNotEqualTo(Long value) {
            addCriterion("issued_whitelist_time <>", value, "issuedWhitelistTime");
            return (Criteria) this;
        }

        public Criteria andIssuedWhitelistTimeGreaterThan(Long value) {
            addCriterion("issued_whitelist_time >", value, "issuedWhitelistTime");
            return (Criteria) this;
        }

        public Criteria andIssuedWhitelistTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("issued_whitelist_time >=", value, "issuedWhitelistTime");
            return (Criteria) this;
        }

        public Criteria andIssuedWhitelistTimeLessThan(Long value) {
            addCriterion("issued_whitelist_time <", value, "issuedWhitelistTime");
            return (Criteria) this;
        }

        public Criteria andIssuedWhitelistTimeLessThanOrEqualTo(Long value) {
            addCriterion("issued_whitelist_time <=", value, "issuedWhitelistTime");
            return (Criteria) this;
        }

        public Criteria andIssuedWhitelistTimeIn(List<Long> values) {
            addCriterion("issued_whitelist_time in", values, "issuedWhitelistTime");
            return (Criteria) this;
        }

        public Criteria andIssuedWhitelistTimeNotIn(List<Long> values) {
            addCriterion("issued_whitelist_time not in", values, "issuedWhitelistTime");
            return (Criteria) this;
        }

        public Criteria andIssuedWhitelistTimeBetween(Long value1, Long value2) {
            addCriterion("issued_whitelist_time between", value1, value2, "issuedWhitelistTime");
            return (Criteria) this;
        }

        public Criteria andIssuedWhitelistTimeNotBetween(Long value1, Long value2) {
            addCriterion("issued_whitelist_time not between", value1, value2, "issuedWhitelistTime");
            return (Criteria) this;
        }

        public Criteria andNoticeExpiringSoonIsNull() {
            addCriterion("notice_expiring_soon is null");
            return (Criteria) this;
        }

        public Criteria andNoticeExpiringSoonIsNotNull() {
            addCriterion("notice_expiring_soon is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeExpiringSoonEqualTo(Byte value) {
            addCriterion("notice_expiring_soon =", value, "noticeExpiringSoon");
            return (Criteria) this;
        }

        public Criteria andNoticeExpiringSoonNotEqualTo(Byte value) {
            addCriterion("notice_expiring_soon <>", value, "noticeExpiringSoon");
            return (Criteria) this;
        }

        public Criteria andNoticeExpiringSoonGreaterThan(Byte value) {
            addCriterion("notice_expiring_soon >", value, "noticeExpiringSoon");
            return (Criteria) this;
        }

        public Criteria andNoticeExpiringSoonGreaterThanOrEqualTo(Byte value) {
            addCriterion("notice_expiring_soon >=", value, "noticeExpiringSoon");
            return (Criteria) this;
        }

        public Criteria andNoticeExpiringSoonLessThan(Byte value) {
            addCriterion("notice_expiring_soon <", value, "noticeExpiringSoon");
            return (Criteria) this;
        }

        public Criteria andNoticeExpiringSoonLessThanOrEqualTo(Byte value) {
            addCriterion("notice_expiring_soon <=", value, "noticeExpiringSoon");
            return (Criteria) this;
        }

        public Criteria andNoticeExpiringSoonIn(List<Byte> values) {
            addCriterion("notice_expiring_soon in", values, "noticeExpiringSoon");
            return (Criteria) this;
        }

        public Criteria andNoticeExpiringSoonNotIn(List<Byte> values) {
            addCriterion("notice_expiring_soon not in", values, "noticeExpiringSoon");
            return (Criteria) this;
        }

        public Criteria andNoticeExpiringSoonBetween(Byte value1, Byte value2) {
            addCriterion("notice_expiring_soon between", value1, value2, "noticeExpiringSoon");
            return (Criteria) this;
        }

        public Criteria andNoticeExpiringSoonNotBetween(Byte value1, Byte value2) {
            addCriterion("notice_expiring_soon not between", value1, value2, "noticeExpiringSoon");
            return (Criteria) this;
        }

        public Criteria andNoticeExpiredIsNull() {
            addCriterion("notice_expired is null");
            return (Criteria) this;
        }

        public Criteria andNoticeExpiredIsNotNull() {
            addCriterion("notice_expired is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeExpiredEqualTo(Byte value) {
            addCriterion("notice_expired =", value, "noticeExpired");
            return (Criteria) this;
        }

        public Criteria andNoticeExpiredNotEqualTo(Byte value) {
            addCriterion("notice_expired <>", value, "noticeExpired");
            return (Criteria) this;
        }

        public Criteria andNoticeExpiredGreaterThan(Byte value) {
            addCriterion("notice_expired >", value, "noticeExpired");
            return (Criteria) this;
        }

        public Criteria andNoticeExpiredGreaterThanOrEqualTo(Byte value) {
            addCriterion("notice_expired >=", value, "noticeExpired");
            return (Criteria) this;
        }

        public Criteria andNoticeExpiredLessThan(Byte value) {
            addCriterion("notice_expired <", value, "noticeExpired");
            return (Criteria) this;
        }

        public Criteria andNoticeExpiredLessThanOrEqualTo(Byte value) {
            addCriterion("notice_expired <=", value, "noticeExpired");
            return (Criteria) this;
        }

        public Criteria andNoticeExpiredIn(List<Byte> values) {
            addCriterion("notice_expired in", values, "noticeExpired");
            return (Criteria) this;
        }

        public Criteria andNoticeExpiredNotIn(List<Byte> values) {
            addCriterion("notice_expired not in", values, "noticeExpired");
            return (Criteria) this;
        }

        public Criteria andNoticeExpiredBetween(Byte value1, Byte value2) {
            addCriterion("notice_expired between", value1, value2, "noticeExpired");
            return (Criteria) this;
        }

        public Criteria andNoticeExpiredNotBetween(Byte value1, Byte value2) {
            addCriterion("notice_expired not between", value1, value2, "noticeExpired");
            return (Criteria) this;
        }

        public Criteria andSpecialCarIdIsNull() {
            addCriterion("special_car_id is null");
            return (Criteria) this;
        }

        public Criteria andSpecialCarIdIsNotNull() {
            addCriterion("special_car_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialCarIdEqualTo(String value) {
            addCriterion("special_car_id =", value, "specialCarId");
            return (Criteria) this;
        }

        public Criteria andSpecialCarIdNotEqualTo(String value) {
            addCriterion("special_car_id <>", value, "specialCarId");
            return (Criteria) this;
        }

        public Criteria andSpecialCarIdGreaterThan(String value) {
            addCriterion("special_car_id >", value, "specialCarId");
            return (Criteria) this;
        }

        public Criteria andSpecialCarIdGreaterThanOrEqualTo(String value) {
            addCriterion("special_car_id >=", value, "specialCarId");
            return (Criteria) this;
        }

        public Criteria andSpecialCarIdLessThan(String value) {
            addCriterion("special_car_id <", value, "specialCarId");
            return (Criteria) this;
        }

        public Criteria andSpecialCarIdLessThanOrEqualTo(String value) {
            addCriterion("special_car_id <=", value, "specialCarId");
            return (Criteria) this;
        }

        public Criteria andSpecialCarIdLike(String value) {
            addCriterion("special_car_id like", value, "specialCarId");
            return (Criteria) this;
        }

        public Criteria andSpecialCarIdNotLike(String value) {
            addCriterion("special_car_id not like", value, "specialCarId");
            return (Criteria) this;
        }

        public Criteria andSpecialCarIdIn(List<String> values) {
            addCriterion("special_car_id in", values, "specialCarId");
            return (Criteria) this;
        }

        public Criteria andSpecialCarIdNotIn(List<String> values) {
            addCriterion("special_car_id not in", values, "specialCarId");
            return (Criteria) this;
        }

        public Criteria andSpecialCarIdBetween(String value1, String value2) {
            addCriterion("special_car_id between", value1, value2, "specialCarId");
            return (Criteria) this;
        }

        public Criteria andSpecialCarIdNotBetween(String value1, String value2) {
            addCriterion("special_car_id not between", value1, value2, "specialCarId");
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