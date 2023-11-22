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

        public Criteria andInSmallImageIsNull() {
            addCriterion("in_small_image is null");
            return (Criteria) this;
        }

        public Criteria andInSmallImageIsNotNull() {
            addCriterion("in_small_image is not null");
            return (Criteria) this;
        }

        public Criteria andInSmallImageEqualTo(String value) {
            addCriterion("in_small_image =", value, "inSmallImage");
            return (Criteria) this;
        }

        public Criteria andInSmallImageNotEqualTo(String value) {
            addCriterion("in_small_image <>", value, "inSmallImage");
            return (Criteria) this;
        }

        public Criteria andInSmallImageGreaterThan(String value) {
            addCriterion("in_small_image >", value, "inSmallImage");
            return (Criteria) this;
        }

        public Criteria andInSmallImageGreaterThanOrEqualTo(String value) {
            addCriterion("in_small_image >=", value, "inSmallImage");
            return (Criteria) this;
        }

        public Criteria andInSmallImageLessThan(String value) {
            addCriterion("in_small_image <", value, "inSmallImage");
            return (Criteria) this;
        }

        public Criteria andInSmallImageLessThanOrEqualTo(String value) {
            addCriterion("in_small_image <=", value, "inSmallImage");
            return (Criteria) this;
        }

        public Criteria andInSmallImageLike(String value) {
            addCriterion("in_small_image like", value, "inSmallImage");
            return (Criteria) this;
        }

        public Criteria andInSmallImageNotLike(String value) {
            addCriterion("in_small_image not like", value, "inSmallImage");
            return (Criteria) this;
        }

        public Criteria andInSmallImageIn(List<String> values) {
            addCriterion("in_small_image in", values, "inSmallImage");
            return (Criteria) this;
        }

        public Criteria andInSmallImageNotIn(List<String> values) {
            addCriterion("in_small_image not in", values, "inSmallImage");
            return (Criteria) this;
        }

        public Criteria andInSmallImageBetween(String value1, String value2) {
            addCriterion("in_small_image between", value1, value2, "inSmallImage");
            return (Criteria) this;
        }

        public Criteria andInSmallImageNotBetween(String value1, String value2) {
            addCriterion("in_small_image not between", value1, value2, "inSmallImage");
            return (Criteria) this;
        }

        public Criteria andOutSmallImageIsNull() {
            addCriterion("out_small_image is null");
            return (Criteria) this;
        }

        public Criteria andOutSmallImageIsNotNull() {
            addCriterion("out_small_image is not null");
            return (Criteria) this;
        }

        public Criteria andOutSmallImageEqualTo(String value) {
            addCriterion("out_small_image =", value, "outSmallImage");
            return (Criteria) this;
        }

        public Criteria andOutSmallImageNotEqualTo(String value) {
            addCriterion("out_small_image <>", value, "outSmallImage");
            return (Criteria) this;
        }

        public Criteria andOutSmallImageGreaterThan(String value) {
            addCriterion("out_small_image >", value, "outSmallImage");
            return (Criteria) this;
        }

        public Criteria andOutSmallImageGreaterThanOrEqualTo(String value) {
            addCriterion("out_small_image >=", value, "outSmallImage");
            return (Criteria) this;
        }

        public Criteria andOutSmallImageLessThan(String value) {
            addCriterion("out_small_image <", value, "outSmallImage");
            return (Criteria) this;
        }

        public Criteria andOutSmallImageLessThanOrEqualTo(String value) {
            addCriterion("out_small_image <=", value, "outSmallImage");
            return (Criteria) this;
        }

        public Criteria andOutSmallImageLike(String value) {
            addCriterion("out_small_image like", value, "outSmallImage");
            return (Criteria) this;
        }

        public Criteria andOutSmallImageNotLike(String value) {
            addCriterion("out_small_image not like", value, "outSmallImage");
            return (Criteria) this;
        }

        public Criteria andOutSmallImageIn(List<String> values) {
            addCriterion("out_small_image in", values, "outSmallImage");
            return (Criteria) this;
        }

        public Criteria andOutSmallImageNotIn(List<String> values) {
            addCriterion("out_small_image not in", values, "outSmallImage");
            return (Criteria) this;
        }

        public Criteria andOutSmallImageBetween(String value1, String value2) {
            addCriterion("out_small_image between", value1, value2, "outSmallImage");
            return (Criteria) this;
        }

        public Criteria andOutSmallImageNotBetween(String value1, String value2) {
            addCriterion("out_small_image not between", value1, value2, "outSmallImage");
            return (Criteria) this;
        }

        public Criteria andInBigImageIsNull() {
            addCriterion("in_big_image is null");
            return (Criteria) this;
        }

        public Criteria andInBigImageIsNotNull() {
            addCriterion("in_big_image is not null");
            return (Criteria) this;
        }

        public Criteria andInBigImageEqualTo(String value) {
            addCriterion("in_big_image =", value, "inBigImage");
            return (Criteria) this;
        }

        public Criteria andInBigImageNotEqualTo(String value) {
            addCriterion("in_big_image <>", value, "inBigImage");
            return (Criteria) this;
        }

        public Criteria andInBigImageGreaterThan(String value) {
            addCriterion("in_big_image >", value, "inBigImage");
            return (Criteria) this;
        }

        public Criteria andInBigImageGreaterThanOrEqualTo(String value) {
            addCriterion("in_big_image >=", value, "inBigImage");
            return (Criteria) this;
        }

        public Criteria andInBigImageLessThan(String value) {
            addCriterion("in_big_image <", value, "inBigImage");
            return (Criteria) this;
        }

        public Criteria andInBigImageLessThanOrEqualTo(String value) {
            addCriterion("in_big_image <=", value, "inBigImage");
            return (Criteria) this;
        }

        public Criteria andInBigImageLike(String value) {
            addCriterion("in_big_image like", value, "inBigImage");
            return (Criteria) this;
        }

        public Criteria andInBigImageNotLike(String value) {
            addCriterion("in_big_image not like", value, "inBigImage");
            return (Criteria) this;
        }

        public Criteria andInBigImageIn(List<String> values) {
            addCriterion("in_big_image in", values, "inBigImage");
            return (Criteria) this;
        }

        public Criteria andInBigImageNotIn(List<String> values) {
            addCriterion("in_big_image not in", values, "inBigImage");
            return (Criteria) this;
        }

        public Criteria andInBigImageBetween(String value1, String value2) {
            addCriterion("in_big_image between", value1, value2, "inBigImage");
            return (Criteria) this;
        }

        public Criteria andInBigImageNotBetween(String value1, String value2) {
            addCriterion("in_big_image not between", value1, value2, "inBigImage");
            return (Criteria) this;
        }

        public Criteria andOutBigImageIsNull() {
            addCriterion("out_big_image is null");
            return (Criteria) this;
        }

        public Criteria andOutBigImageIsNotNull() {
            addCriterion("out_big_image is not null");
            return (Criteria) this;
        }

        public Criteria andOutBigImageEqualTo(String value) {
            addCriterion("out_big_image =", value, "outBigImage");
            return (Criteria) this;
        }

        public Criteria andOutBigImageNotEqualTo(String value) {
            addCriterion("out_big_image <>", value, "outBigImage");
            return (Criteria) this;
        }

        public Criteria andOutBigImageGreaterThan(String value) {
            addCriterion("out_big_image >", value, "outBigImage");
            return (Criteria) this;
        }

        public Criteria andOutBigImageGreaterThanOrEqualTo(String value) {
            addCriterion("out_big_image >=", value, "outBigImage");
            return (Criteria) this;
        }

        public Criteria andOutBigImageLessThan(String value) {
            addCriterion("out_big_image <", value, "outBigImage");
            return (Criteria) this;
        }

        public Criteria andOutBigImageLessThanOrEqualTo(String value) {
            addCriterion("out_big_image <=", value, "outBigImage");
            return (Criteria) this;
        }

        public Criteria andOutBigImageLike(String value) {
            addCriterion("out_big_image like", value, "outBigImage");
            return (Criteria) this;
        }

        public Criteria andOutBigImageNotLike(String value) {
            addCriterion("out_big_image not like", value, "outBigImage");
            return (Criteria) this;
        }

        public Criteria andOutBigImageIn(List<String> values) {
            addCriterion("out_big_image in", values, "outBigImage");
            return (Criteria) this;
        }

        public Criteria andOutBigImageNotIn(List<String> values) {
            addCriterion("out_big_image not in", values, "outBigImage");
            return (Criteria) this;
        }

        public Criteria andOutBigImageBetween(String value1, String value2) {
            addCriterion("out_big_image between", value1, value2, "outBigImage");
            return (Criteria) this;
        }

        public Criteria andOutBigImageNotBetween(String value1, String value2) {
            addCriterion("out_big_image not between", value1, value2, "outBigImage");
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

        public Criteria andSubscribeTimeIsNull() {
            addCriterion("subscribe_time is null");
            return (Criteria) this;
        }

        public Criteria andSubscribeTimeIsNotNull() {
            addCriterion("subscribe_time is not null");
            return (Criteria) this;
        }

        public Criteria andSubscribeTimeEqualTo(Long value) {
            addCriterion("subscribe_time =", value, "subscribeTime");
            return (Criteria) this;
        }

        public Criteria andSubscribeTimeNotEqualTo(Long value) {
            addCriterion("subscribe_time <>", value, "subscribeTime");
            return (Criteria) this;
        }

        public Criteria andSubscribeTimeGreaterThan(Long value) {
            addCriterion("subscribe_time >", value, "subscribeTime");
            return (Criteria) this;
        }

        public Criteria andSubscribeTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("subscribe_time >=", value, "subscribeTime");
            return (Criteria) this;
        }

        public Criteria andSubscribeTimeLessThan(Long value) {
            addCriterion("subscribe_time <", value, "subscribeTime");
            return (Criteria) this;
        }

        public Criteria andSubscribeTimeLessThanOrEqualTo(Long value) {
            addCriterion("subscribe_time <=", value, "subscribeTime");
            return (Criteria) this;
        }

        public Criteria andSubscribeTimeIn(List<Long> values) {
            addCriterion("subscribe_time in", values, "subscribeTime");
            return (Criteria) this;
        }

        public Criteria andSubscribeTimeNotIn(List<Long> values) {
            addCriterion("subscribe_time not in", values, "subscribeTime");
            return (Criteria) this;
        }

        public Criteria andSubscribeTimeBetween(Long value1, Long value2) {
            addCriterion("subscribe_time between", value1, value2, "subscribeTime");
            return (Criteria) this;
        }

        public Criteria andSubscribeTimeNotBetween(Long value1, Long value2) {
            addCriterion("subscribe_time not between", value1, value2, "subscribeTime");
            return (Criteria) this;
        }

        public Criteria andCancelSubscribeTimeIsNull() {
            addCriterion("cancel_subscribe_time is null");
            return (Criteria) this;
        }

        public Criteria andCancelSubscribeTimeIsNotNull() {
            addCriterion("cancel_subscribe_time is not null");
            return (Criteria) this;
        }

        public Criteria andCancelSubscribeTimeEqualTo(Long value) {
            addCriterion("cancel_subscribe_time =", value, "cancelSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andCancelSubscribeTimeNotEqualTo(Long value) {
            addCriterion("cancel_subscribe_time <>", value, "cancelSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andCancelSubscribeTimeGreaterThan(Long value) {
            addCriterion("cancel_subscribe_time >", value, "cancelSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andCancelSubscribeTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("cancel_subscribe_time >=", value, "cancelSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andCancelSubscribeTimeLessThan(Long value) {
            addCriterion("cancel_subscribe_time <", value, "cancelSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andCancelSubscribeTimeLessThanOrEqualTo(Long value) {
            addCriterion("cancel_subscribe_time <=", value, "cancelSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andCancelSubscribeTimeIn(List<Long> values) {
            addCriterion("cancel_subscribe_time in", values, "cancelSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andCancelSubscribeTimeNotIn(List<Long> values) {
            addCriterion("cancel_subscribe_time not in", values, "cancelSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andCancelSubscribeTimeBetween(Long value1, Long value2) {
            addCriterion("cancel_subscribe_time between", value1, value2, "cancelSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andCancelSubscribeTimeNotBetween(Long value1, Long value2) {
            addCriterion("cancel_subscribe_time not between", value1, value2, "cancelSubscribeTime");
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

        public Criteria andInReleaseTypeIsNull() {
            addCriterion("in_release_type is null");
            return (Criteria) this;
        }

        public Criteria andInReleaseTypeIsNotNull() {
            addCriterion("in_release_type is not null");
            return (Criteria) this;
        }

        public Criteria andInReleaseTypeEqualTo(Byte value) {
            addCriterion("in_release_type =", value, "inReleaseType");
            return (Criteria) this;
        }

        public Criteria andInReleaseTypeNotEqualTo(Byte value) {
            addCriterion("in_release_type <>", value, "inReleaseType");
            return (Criteria) this;
        }

        public Criteria andInReleaseTypeGreaterThan(Byte value) {
            addCriterion("in_release_type >", value, "inReleaseType");
            return (Criteria) this;
        }

        public Criteria andInReleaseTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("in_release_type >=", value, "inReleaseType");
            return (Criteria) this;
        }

        public Criteria andInReleaseTypeLessThan(Byte value) {
            addCriterion("in_release_type <", value, "inReleaseType");
            return (Criteria) this;
        }

        public Criteria andInReleaseTypeLessThanOrEqualTo(Byte value) {
            addCriterion("in_release_type <=", value, "inReleaseType");
            return (Criteria) this;
        }

        public Criteria andInReleaseTypeIn(List<Byte> values) {
            addCriterion("in_release_type in", values, "inReleaseType");
            return (Criteria) this;
        }

        public Criteria andInReleaseTypeNotIn(List<Byte> values) {
            addCriterion("in_release_type not in", values, "inReleaseType");
            return (Criteria) this;
        }

        public Criteria andInReleaseTypeBetween(Byte value1, Byte value2) {
            addCriterion("in_release_type between", value1, value2, "inReleaseType");
            return (Criteria) this;
        }

        public Criteria andInReleaseTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("in_release_type not between", value1, value2, "inReleaseType");
            return (Criteria) this;
        }

        public Criteria andOutReleaseTypeIsNull() {
            addCriterion("out_release_type is null");
            return (Criteria) this;
        }

        public Criteria andOutReleaseTypeIsNotNull() {
            addCriterion("out_release_type is not null");
            return (Criteria) this;
        }

        public Criteria andOutReleaseTypeEqualTo(Byte value) {
            addCriterion("out_release_type =", value, "outReleaseType");
            return (Criteria) this;
        }

        public Criteria andOutReleaseTypeNotEqualTo(Byte value) {
            addCriterion("out_release_type <>", value, "outReleaseType");
            return (Criteria) this;
        }

        public Criteria andOutReleaseTypeGreaterThan(Byte value) {
            addCriterion("out_release_type >", value, "outReleaseType");
            return (Criteria) this;
        }

        public Criteria andOutReleaseTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("out_release_type >=", value, "outReleaseType");
            return (Criteria) this;
        }

        public Criteria andOutReleaseTypeLessThan(Byte value) {
            addCriterion("out_release_type <", value, "outReleaseType");
            return (Criteria) this;
        }

        public Criteria andOutReleaseTypeLessThanOrEqualTo(Byte value) {
            addCriterion("out_release_type <=", value, "outReleaseType");
            return (Criteria) this;
        }

        public Criteria andOutReleaseTypeIn(List<Byte> values) {
            addCriterion("out_release_type in", values, "outReleaseType");
            return (Criteria) this;
        }

        public Criteria andOutReleaseTypeNotIn(List<Byte> values) {
            addCriterion("out_release_type not in", values, "outReleaseType");
            return (Criteria) this;
        }

        public Criteria andOutReleaseTypeBetween(Byte value1, Byte value2) {
            addCriterion("out_release_type between", value1, value2, "outReleaseType");
            return (Criteria) this;
        }

        public Criteria andOutReleaseTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("out_release_type not between", value1, value2, "outReleaseType");
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

        public Criteria andCreatePositionIsNull() {
            addCriterion("create_position is null");
            return (Criteria) this;
        }

        public Criteria andCreatePositionIsNotNull() {
            addCriterion("create_position is not null");
            return (Criteria) this;
        }

        public Criteria andCreatePositionEqualTo(String value) {
            addCriterion("create_position =", value, "createPosition");
            return (Criteria) this;
        }

        public Criteria andCreatePositionNotEqualTo(String value) {
            addCriterion("create_position <>", value, "createPosition");
            return (Criteria) this;
        }

        public Criteria andCreatePositionGreaterThan(String value) {
            addCriterion("create_position >", value, "createPosition");
            return (Criteria) this;
        }

        public Criteria andCreatePositionGreaterThanOrEqualTo(String value) {
            addCriterion("create_position >=", value, "createPosition");
            return (Criteria) this;
        }

        public Criteria andCreatePositionLessThan(String value) {
            addCriterion("create_position <", value, "createPosition");
            return (Criteria) this;
        }

        public Criteria andCreatePositionLessThanOrEqualTo(String value) {
            addCriterion("create_position <=", value, "createPosition");
            return (Criteria) this;
        }

        public Criteria andCreatePositionLike(String value) {
            addCriterion("create_position like", value, "createPosition");
            return (Criteria) this;
        }

        public Criteria andCreatePositionNotLike(String value) {
            addCriterion("create_position not like", value, "createPosition");
            return (Criteria) this;
        }

        public Criteria andCreatePositionIn(List<String> values) {
            addCriterion("create_position in", values, "createPosition");
            return (Criteria) this;
        }

        public Criteria andCreatePositionNotIn(List<String> values) {
            addCriterion("create_position not in", values, "createPosition");
            return (Criteria) this;
        }

        public Criteria andCreatePositionBetween(String value1, String value2) {
            addCriterion("create_position between", value1, value2, "createPosition");
            return (Criteria) this;
        }

        public Criteria andCreatePositionNotBetween(String value1, String value2) {
            addCriterion("create_position not between", value1, value2, "createPosition");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Long value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Long value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Long value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Long value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Long value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Long> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Long> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Long value1, Long value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Long value1, Long value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
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

        public Criteria andInHandleUidIsNull() {
            addCriterion("in_handle_uid is null");
            return (Criteria) this;
        }

        public Criteria andInHandleUidIsNotNull() {
            addCriterion("in_handle_uid is not null");
            return (Criteria) this;
        }

        public Criteria andInHandleUidEqualTo(String value) {
            addCriterion("in_handle_uid =", value, "inHandleUid");
            return (Criteria) this;
        }

        public Criteria andInHandleUidNotEqualTo(String value) {
            addCriterion("in_handle_uid <>", value, "inHandleUid");
            return (Criteria) this;
        }

        public Criteria andInHandleUidGreaterThan(String value) {
            addCriterion("in_handle_uid >", value, "inHandleUid");
            return (Criteria) this;
        }

        public Criteria andInHandleUidGreaterThanOrEqualTo(String value) {
            addCriterion("in_handle_uid >=", value, "inHandleUid");
            return (Criteria) this;
        }

        public Criteria andInHandleUidLessThan(String value) {
            addCriterion("in_handle_uid <", value, "inHandleUid");
            return (Criteria) this;
        }

        public Criteria andInHandleUidLessThanOrEqualTo(String value) {
            addCriterion("in_handle_uid <=", value, "inHandleUid");
            return (Criteria) this;
        }

        public Criteria andInHandleUidLike(String value) {
            addCriterion("in_handle_uid like", value, "inHandleUid");
            return (Criteria) this;
        }

        public Criteria andInHandleUidNotLike(String value) {
            addCriterion("in_handle_uid not like", value, "inHandleUid");
            return (Criteria) this;
        }

        public Criteria andInHandleUidIn(List<String> values) {
            addCriterion("in_handle_uid in", values, "inHandleUid");
            return (Criteria) this;
        }

        public Criteria andInHandleUidNotIn(List<String> values) {
            addCriterion("in_handle_uid not in", values, "inHandleUid");
            return (Criteria) this;
        }

        public Criteria andInHandleUidBetween(String value1, String value2) {
            addCriterion("in_handle_uid between", value1, value2, "inHandleUid");
            return (Criteria) this;
        }

        public Criteria andInHandleUidNotBetween(String value1, String value2) {
            addCriterion("in_handle_uid not between", value1, value2, "inHandleUid");
            return (Criteria) this;
        }

        public Criteria andOutHandleUidIsNull() {
            addCriterion("out_handle_uid is null");
            return (Criteria) this;
        }

        public Criteria andOutHandleUidIsNotNull() {
            addCriterion("out_handle_uid is not null");
            return (Criteria) this;
        }

        public Criteria andOutHandleUidEqualTo(String value) {
            addCriterion("out_handle_uid =", value, "outHandleUid");
            return (Criteria) this;
        }

        public Criteria andOutHandleUidNotEqualTo(String value) {
            addCriterion("out_handle_uid <>", value, "outHandleUid");
            return (Criteria) this;
        }

        public Criteria andOutHandleUidGreaterThan(String value) {
            addCriterion("out_handle_uid >", value, "outHandleUid");
            return (Criteria) this;
        }

        public Criteria andOutHandleUidGreaterThanOrEqualTo(String value) {
            addCriterion("out_handle_uid >=", value, "outHandleUid");
            return (Criteria) this;
        }

        public Criteria andOutHandleUidLessThan(String value) {
            addCriterion("out_handle_uid <", value, "outHandleUid");
            return (Criteria) this;
        }

        public Criteria andOutHandleUidLessThanOrEqualTo(String value) {
            addCriterion("out_handle_uid <=", value, "outHandleUid");
            return (Criteria) this;
        }

        public Criteria andOutHandleUidLike(String value) {
            addCriterion("out_handle_uid like", value, "outHandleUid");
            return (Criteria) this;
        }

        public Criteria andOutHandleUidNotLike(String value) {
            addCriterion("out_handle_uid not like", value, "outHandleUid");
            return (Criteria) this;
        }

        public Criteria andOutHandleUidIn(List<String> values) {
            addCriterion("out_handle_uid in", values, "outHandleUid");
            return (Criteria) this;
        }

        public Criteria andOutHandleUidNotIn(List<String> values) {
            addCriterion("out_handle_uid not in", values, "outHandleUid");
            return (Criteria) this;
        }

        public Criteria andOutHandleUidBetween(String value1, String value2) {
            addCriterion("out_handle_uid between", value1, value2, "outHandleUid");
            return (Criteria) this;
        }

        public Criteria andOutHandleUidNotBetween(String value1, String value2) {
            addCriterion("out_handle_uid not between", value1, value2, "outHandleUid");
            return (Criteria) this;
        }

        public Criteria andCountFeeStatusIsNull() {
            addCriterion("count_fee_status is null");
            return (Criteria) this;
        }

        public Criteria andCountFeeStatusIsNotNull() {
            addCriterion("count_fee_status is not null");
            return (Criteria) this;
        }

        public Criteria andCountFeeStatusEqualTo(Byte value) {
            addCriterion("count_fee_status =", value, "countFeeStatus");
            return (Criteria) this;
        }

        public Criteria andCountFeeStatusNotEqualTo(Byte value) {
            addCriterion("count_fee_status <>", value, "countFeeStatus");
            return (Criteria) this;
        }

        public Criteria andCountFeeStatusGreaterThan(Byte value) {
            addCriterion("count_fee_status >", value, "countFeeStatus");
            return (Criteria) this;
        }

        public Criteria andCountFeeStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("count_fee_status >=", value, "countFeeStatus");
            return (Criteria) this;
        }

        public Criteria andCountFeeStatusLessThan(Byte value) {
            addCriterion("count_fee_status <", value, "countFeeStatus");
            return (Criteria) this;
        }

        public Criteria andCountFeeStatusLessThanOrEqualTo(Byte value) {
            addCriterion("count_fee_status <=", value, "countFeeStatus");
            return (Criteria) this;
        }

        public Criteria andCountFeeStatusIn(List<Byte> values) {
            addCriterion("count_fee_status in", values, "countFeeStatus");
            return (Criteria) this;
        }

        public Criteria andCountFeeStatusNotIn(List<Byte> values) {
            addCriterion("count_fee_status not in", values, "countFeeStatus");
            return (Criteria) this;
        }

        public Criteria andCountFeeStatusBetween(Byte value1, Byte value2) {
            addCriterion("count_fee_status between", value1, value2, "countFeeStatus");
            return (Criteria) this;
        }

        public Criteria andCountFeeStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("count_fee_status not between", value1, value2, "countFeeStatus");
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

        public Criteria andCarTypeIsNull() {
            addCriterion("car_type is null");
            return (Criteria) this;
        }

        public Criteria andCarTypeIsNotNull() {
            addCriterion("car_type is not null");
            return (Criteria) this;
        }

        public Criteria andCarTypeEqualTo(String value) {
            addCriterion("car_type =", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotEqualTo(String value) {
            addCriterion("car_type <>", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeGreaterThan(String value) {
            addCriterion("car_type >", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeGreaterThanOrEqualTo(String value) {
            addCriterion("car_type >=", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeLessThan(String value) {
            addCriterion("car_type <", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeLessThanOrEqualTo(String value) {
            addCriterion("car_type <=", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeLike(String value) {
            addCriterion("car_type like", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotLike(String value) {
            addCriterion("car_type not like", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeIn(List<String> values) {
            addCriterion("car_type in", values, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotIn(List<String> values) {
            addCriterion("car_type not in", values, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeBetween(String value1, String value2) {
            addCriterion("car_type between", value1, value2, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotBetween(String value1, String value2) {
            addCriterion("car_type not between", value1, value2, "carType");
            return (Criteria) this;
        }

        public Criteria andCarStatusIsNull() {
            addCriterion("car_status is null");
            return (Criteria) this;
        }

        public Criteria andCarStatusIsNotNull() {
            addCriterion("car_status is not null");
            return (Criteria) this;
        }

        public Criteria andCarStatusEqualTo(Byte value) {
            addCriterion("car_status =", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusNotEqualTo(Byte value) {
            addCriterion("car_status <>", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusGreaterThan(Byte value) {
            addCriterion("car_status >", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("car_status >=", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusLessThan(Byte value) {
            addCriterion("car_status <", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusLessThanOrEqualTo(Byte value) {
            addCriterion("car_status <=", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusIn(List<Byte> values) {
            addCriterion("car_status in", values, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusNotIn(List<Byte> values) {
            addCriterion("car_status not in", values, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusBetween(Byte value1, Byte value2) {
            addCriterion("car_status between", value1, value2, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("car_status not between", value1, value2, "carStatus");
            return (Criteria) this;
        }

        public Criteria andVisitUnitIsNull() {
            addCriterion("visit_unit is null");
            return (Criteria) this;
        }

        public Criteria andVisitUnitIsNotNull() {
            addCriterion("visit_unit is not null");
            return (Criteria) this;
        }

        public Criteria andVisitUnitEqualTo(String value) {
            addCriterion("visit_unit =", value, "visitUnit");
            return (Criteria) this;
        }

        public Criteria andVisitUnitNotEqualTo(String value) {
            addCriterion("visit_unit <>", value, "visitUnit");
            return (Criteria) this;
        }

        public Criteria andVisitUnitGreaterThan(String value) {
            addCriterion("visit_unit >", value, "visitUnit");
            return (Criteria) this;
        }

        public Criteria andVisitUnitGreaterThanOrEqualTo(String value) {
            addCriterion("visit_unit >=", value, "visitUnit");
            return (Criteria) this;
        }

        public Criteria andVisitUnitLessThan(String value) {
            addCriterion("visit_unit <", value, "visitUnit");
            return (Criteria) this;
        }

        public Criteria andVisitUnitLessThanOrEqualTo(String value) {
            addCriterion("visit_unit <=", value, "visitUnit");
            return (Criteria) this;
        }

        public Criteria andVisitUnitLike(String value) {
            addCriterion("visit_unit like", value, "visitUnit");
            return (Criteria) this;
        }

        public Criteria andVisitUnitNotLike(String value) {
            addCriterion("visit_unit not like", value, "visitUnit");
            return (Criteria) this;
        }

        public Criteria andVisitUnitIn(List<String> values) {
            addCriterion("visit_unit in", values, "visitUnit");
            return (Criteria) this;
        }

        public Criteria andVisitUnitNotIn(List<String> values) {
            addCriterion("visit_unit not in", values, "visitUnit");
            return (Criteria) this;
        }

        public Criteria andVisitUnitBetween(String value1, String value2) {
            addCriterion("visit_unit between", value1, value2, "visitUnit");
            return (Criteria) this;
        }

        public Criteria andVisitUnitNotBetween(String value1, String value2) {
            addCriterion("visit_unit not between", value1, value2, "visitUnit");
            return (Criteria) this;
        }

        public Criteria andGiveAwayParkTimeIsNull() {
            addCriterion("give_away_park_time is null");
            return (Criteria) this;
        }

        public Criteria andGiveAwayParkTimeIsNotNull() {
            addCriterion("give_away_park_time is not null");
            return (Criteria) this;
        }

        public Criteria andGiveAwayParkTimeEqualTo(Long value) {
            addCriterion("give_away_park_time =", value, "giveAwayParkTime");
            return (Criteria) this;
        }

        public Criteria andGiveAwayParkTimeNotEqualTo(Long value) {
            addCriterion("give_away_park_time <>", value, "giveAwayParkTime");
            return (Criteria) this;
        }

        public Criteria andGiveAwayParkTimeGreaterThan(Long value) {
            addCriterion("give_away_park_time >", value, "giveAwayParkTime");
            return (Criteria) this;
        }

        public Criteria andGiveAwayParkTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("give_away_park_time >=", value, "giveAwayParkTime");
            return (Criteria) this;
        }

        public Criteria andGiveAwayParkTimeLessThan(Long value) {
            addCriterion("give_away_park_time <", value, "giveAwayParkTime");
            return (Criteria) this;
        }

        public Criteria andGiveAwayParkTimeLessThanOrEqualTo(Long value) {
            addCriterion("give_away_park_time <=", value, "giveAwayParkTime");
            return (Criteria) this;
        }

        public Criteria andGiveAwayParkTimeIn(List<Long> values) {
            addCriterion("give_away_park_time in", values, "giveAwayParkTime");
            return (Criteria) this;
        }

        public Criteria andGiveAwayParkTimeNotIn(List<Long> values) {
            addCriterion("give_away_park_time not in", values, "giveAwayParkTime");
            return (Criteria) this;
        }

        public Criteria andGiveAwayParkTimeBetween(Long value1, Long value2) {
            addCriterion("give_away_park_time between", value1, value2, "giveAwayParkTime");
            return (Criteria) this;
        }

        public Criteria andGiveAwayParkTimeNotBetween(Long value1, Long value2) {
            addCriterion("give_away_park_time not between", value1, value2, "giveAwayParkTime");
            return (Criteria) this;
        }

        public Criteria andCarNumberPlateColorIsNull() {
            addCriterion("car_number_plate_color is null");
            return (Criteria) this;
        }

        public Criteria andCarNumberPlateColorIsNotNull() {
            addCriterion("car_number_plate_color is not null");
            return (Criteria) this;
        }

        public Criteria andCarNumberPlateColorEqualTo(Byte value) {
            addCriterion("car_number_plate_color =", value, "carNumberPlateColor");
            return (Criteria) this;
        }

        public Criteria andCarNumberPlateColorNotEqualTo(Byte value) {
            addCriterion("car_number_plate_color <>", value, "carNumberPlateColor");
            return (Criteria) this;
        }

        public Criteria andCarNumberPlateColorGreaterThan(Byte value) {
            addCriterion("car_number_plate_color >", value, "carNumberPlateColor");
            return (Criteria) this;
        }

        public Criteria andCarNumberPlateColorGreaterThanOrEqualTo(Byte value) {
            addCriterion("car_number_plate_color >=", value, "carNumberPlateColor");
            return (Criteria) this;
        }

        public Criteria andCarNumberPlateColorLessThan(Byte value) {
            addCriterion("car_number_plate_color <", value, "carNumberPlateColor");
            return (Criteria) this;
        }

        public Criteria andCarNumberPlateColorLessThanOrEqualTo(Byte value) {
            addCriterion("car_number_plate_color <=", value, "carNumberPlateColor");
            return (Criteria) this;
        }

        public Criteria andCarNumberPlateColorIn(List<Byte> values) {
            addCriterion("car_number_plate_color in", values, "carNumberPlateColor");
            return (Criteria) this;
        }

        public Criteria andCarNumberPlateColorNotIn(List<Byte> values) {
            addCriterion("car_number_plate_color not in", values, "carNumberPlateColor");
            return (Criteria) this;
        }

        public Criteria andCarNumberPlateColorBetween(Byte value1, Byte value2) {
            addCriterion("car_number_plate_color between", value1, value2, "carNumberPlateColor");
            return (Criteria) this;
        }

        public Criteria andCarNumberPlateColorNotBetween(Byte value1, Byte value2) {
            addCriterion("car_number_plate_color not between", value1, value2, "carNumberPlateColor");
            return (Criteria) this;
        }

        public Criteria andCarBrandIsNull() {
            addCriterion("car_brand is null");
            return (Criteria) this;
        }

        public Criteria andCarBrandIsNotNull() {
            addCriterion("car_brand is not null");
            return (Criteria) this;
        }

        public Criteria andCarBrandEqualTo(String value) {
            addCriterion("car_brand =", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandNotEqualTo(String value) {
            addCriterion("car_brand <>", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandGreaterThan(String value) {
            addCriterion("car_brand >", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandGreaterThanOrEqualTo(String value) {
            addCriterion("car_brand >=", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandLessThan(String value) {
            addCriterion("car_brand <", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandLessThanOrEqualTo(String value) {
            addCriterion("car_brand <=", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandLike(String value) {
            addCriterion("car_brand like", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandNotLike(String value) {
            addCriterion("car_brand not like", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandIn(List<String> values) {
            addCriterion("car_brand in", values, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandNotIn(List<String> values) {
            addCriterion("car_brand not in", values, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandBetween(String value1, String value2) {
            addCriterion("car_brand between", value1, value2, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandNotBetween(String value1, String value2) {
            addCriterion("car_brand not between", value1, value2, "carBrand");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNumberIsNull() {
            addCriterion("parking_space_number is null");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNumberIsNotNull() {
            addCriterion("parking_space_number is not null");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNumberEqualTo(String value) {
            addCriterion("parking_space_number =", value, "parkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNumberNotEqualTo(String value) {
            addCriterion("parking_space_number <>", value, "parkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNumberGreaterThan(String value) {
            addCriterion("parking_space_number >", value, "parkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNumberGreaterThanOrEqualTo(String value) {
            addCriterion("parking_space_number >=", value, "parkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNumberLessThan(String value) {
            addCriterion("parking_space_number <", value, "parkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNumberLessThanOrEqualTo(String value) {
            addCriterion("parking_space_number <=", value, "parkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNumberLike(String value) {
            addCriterion("parking_space_number like", value, "parkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNumberNotLike(String value) {
            addCriterion("parking_space_number not like", value, "parkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNumberIn(List<String> values) {
            addCriterion("parking_space_number in", values, "parkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNumberNotIn(List<String> values) {
            addCriterion("parking_space_number not in", values, "parkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNumberBetween(String value1, String value2) {
            addCriterion("parking_space_number between", value1, value2, "parkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNumberNotBetween(String value1, String value2) {
            addCriterion("parking_space_number not between", value1, value2, "parkingSpaceNumber");
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