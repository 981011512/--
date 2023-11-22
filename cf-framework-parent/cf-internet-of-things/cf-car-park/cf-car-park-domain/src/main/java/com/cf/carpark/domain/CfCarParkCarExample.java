package com.cf.carpark.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CfCarParkCarExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfCarParkCarExample() {
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

        public Criteria andImageIsNull() {
            addCriterion("image is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("image is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("image =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("image <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("image >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("image >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("image <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("image <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("image like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("image not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("image in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("image not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("image between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("image not between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andBrandIsNull() {
            addCriterion("brand is null");
            return (Criteria) this;
        }

        public Criteria andBrandIsNotNull() {
            addCriterion("brand is not null");
            return (Criteria) this;
        }

        public Criteria andBrandEqualTo(String value) {
            addCriterion("brand =", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotEqualTo(String value) {
            addCriterion("brand <>", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThan(String value) {
            addCriterion("brand >", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThanOrEqualTo(String value) {
            addCriterion("brand >=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThan(String value) {
            addCriterion("brand <", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThanOrEqualTo(String value) {
            addCriterion("brand <=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLike(String value) {
            addCriterion("brand like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotLike(String value) {
            addCriterion("brand not like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandIn(List<String> values) {
            addCriterion("brand in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotIn(List<String> values) {
            addCriterion("brand not in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandBetween(String value1, String value2) {
            addCriterion("brand between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotBetween(String value1, String value2) {
            addCriterion("brand not between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andModelIsNull() {
            addCriterion("model is null");
            return (Criteria) this;
        }

        public Criteria andModelIsNotNull() {
            addCriterion("model is not null");
            return (Criteria) this;
        }

        public Criteria andModelEqualTo(String value) {
            addCriterion("model =", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotEqualTo(String value) {
            addCriterion("model <>", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThan(String value) {
            addCriterion("model >", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThanOrEqualTo(String value) {
            addCriterion("model >=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThan(String value) {
            addCriterion("model <", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThanOrEqualTo(String value) {
            addCriterion("model <=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLike(String value) {
            addCriterion("model like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotLike(String value) {
            addCriterion("model not like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelIn(List<String> values) {
            addCriterion("model in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotIn(List<String> values) {
            addCriterion("model not in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelBetween(String value1, String value2) {
            addCriterion("model between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotBetween(String value1, String value2) {
            addCriterion("model not between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeIsNull() {
            addCriterion("purchase_time is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeIsNotNull() {
            addCriterion("purchase_time is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeEqualTo(Long value) {
            addCriterion("purchase_time =", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeNotEqualTo(Long value) {
            addCriterion("purchase_time <>", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeGreaterThan(Long value) {
            addCriterion("purchase_time >", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("purchase_time >=", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeLessThan(Long value) {
            addCriterion("purchase_time <", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeLessThanOrEqualTo(Long value) {
            addCriterion("purchase_time <=", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeIn(List<Long> values) {
            addCriterion("purchase_time in", values, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeNotIn(List<Long> values) {
            addCriterion("purchase_time not in", values, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeBetween(Long value1, Long value2) {
            addCriterion("purchase_time between", value1, value2, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeNotBetween(Long value1, Long value2) {
            addCriterion("purchase_time not between", value1, value2, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Long value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Long value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Long value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Long value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Long value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Long> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Long> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Long value1, Long value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Long value1, Long value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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

        public Criteria andIdentityImageIsNull() {
            addCriterion("identity_image is null");
            return (Criteria) this;
        }

        public Criteria andIdentityImageIsNotNull() {
            addCriterion("identity_image is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityImageEqualTo(String value) {
            addCriterion("identity_image =", value, "identityImage");
            return (Criteria) this;
        }

        public Criteria andIdentityImageNotEqualTo(String value) {
            addCriterion("identity_image <>", value, "identityImage");
            return (Criteria) this;
        }

        public Criteria andIdentityImageGreaterThan(String value) {
            addCriterion("identity_image >", value, "identityImage");
            return (Criteria) this;
        }

        public Criteria andIdentityImageGreaterThanOrEqualTo(String value) {
            addCriterion("identity_image >=", value, "identityImage");
            return (Criteria) this;
        }

        public Criteria andIdentityImageLessThan(String value) {
            addCriterion("identity_image <", value, "identityImage");
            return (Criteria) this;
        }

        public Criteria andIdentityImageLessThanOrEqualTo(String value) {
            addCriterion("identity_image <=", value, "identityImage");
            return (Criteria) this;
        }

        public Criteria andIdentityImageLike(String value) {
            addCriterion("identity_image like", value, "identityImage");
            return (Criteria) this;
        }

        public Criteria andIdentityImageNotLike(String value) {
            addCriterion("identity_image not like", value, "identityImage");
            return (Criteria) this;
        }

        public Criteria andIdentityImageIn(List<String> values) {
            addCriterion("identity_image in", values, "identityImage");
            return (Criteria) this;
        }

        public Criteria andIdentityImageNotIn(List<String> values) {
            addCriterion("identity_image not in", values, "identityImage");
            return (Criteria) this;
        }

        public Criteria andIdentityImageBetween(String value1, String value2) {
            addCriterion("identity_image between", value1, value2, "identityImage");
            return (Criteria) this;
        }

        public Criteria andIdentityImageNotBetween(String value1, String value2) {
            addCriterion("identity_image not between", value1, value2, "identityImage");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberIsNull() {
            addCriterion("identity_number is null");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberIsNotNull() {
            addCriterion("identity_number is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberEqualTo(String value) {
            addCriterion("identity_number =", value, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberNotEqualTo(String value) {
            addCriterion("identity_number <>", value, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberGreaterThan(String value) {
            addCriterion("identity_number >", value, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberGreaterThanOrEqualTo(String value) {
            addCriterion("identity_number >=", value, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberLessThan(String value) {
            addCriterion("identity_number <", value, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberLessThanOrEqualTo(String value) {
            addCriterion("identity_number <=", value, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberLike(String value) {
            addCriterion("identity_number like", value, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberNotLike(String value) {
            addCriterion("identity_number not like", value, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberIn(List<String> values) {
            addCriterion("identity_number in", values, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberNotIn(List<String> values) {
            addCriterion("identity_number not in", values, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberBetween(String value1, String value2) {
            addCriterion("identity_number between", value1, value2, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberNotBetween(String value1, String value2) {
            addCriterion("identity_number not between", value1, value2, "identityNumber");
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

        public Criteria andCarTypeStartTimeIsNull() {
            addCriterion("car_type_start_time is null");
            return (Criteria) this;
        }

        public Criteria andCarTypeStartTimeIsNotNull() {
            addCriterion("car_type_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andCarTypeStartTimeEqualTo(Long value) {
            addCriterion("car_type_start_time =", value, "carTypeStartTime");
            return (Criteria) this;
        }

        public Criteria andCarTypeStartTimeNotEqualTo(Long value) {
            addCriterion("car_type_start_time <>", value, "carTypeStartTime");
            return (Criteria) this;
        }

        public Criteria andCarTypeStartTimeGreaterThan(Long value) {
            addCriterion("car_type_start_time >", value, "carTypeStartTime");
            return (Criteria) this;
        }

        public Criteria andCarTypeStartTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("car_type_start_time >=", value, "carTypeStartTime");
            return (Criteria) this;
        }

        public Criteria andCarTypeStartTimeLessThan(Long value) {
            addCriterion("car_type_start_time <", value, "carTypeStartTime");
            return (Criteria) this;
        }

        public Criteria andCarTypeStartTimeLessThanOrEqualTo(Long value) {
            addCriterion("car_type_start_time <=", value, "carTypeStartTime");
            return (Criteria) this;
        }

        public Criteria andCarTypeStartTimeIn(List<Long> values) {
            addCriterion("car_type_start_time in", values, "carTypeStartTime");
            return (Criteria) this;
        }

        public Criteria andCarTypeStartTimeNotIn(List<Long> values) {
            addCriterion("car_type_start_time not in", values, "carTypeStartTime");
            return (Criteria) this;
        }

        public Criteria andCarTypeStartTimeBetween(Long value1, Long value2) {
            addCriterion("car_type_start_time between", value1, value2, "carTypeStartTime");
            return (Criteria) this;
        }

        public Criteria andCarTypeStartTimeNotBetween(Long value1, Long value2) {
            addCriterion("car_type_start_time not between", value1, value2, "carTypeStartTime");
            return (Criteria) this;
        }

        public Criteria andCarTypeEndTimeIsNull() {
            addCriterion("car_type_end_time is null");
            return (Criteria) this;
        }

        public Criteria andCarTypeEndTimeIsNotNull() {
            addCriterion("car_type_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andCarTypeEndTimeEqualTo(Long value) {
            addCriterion("car_type_end_time =", value, "carTypeEndTime");
            return (Criteria) this;
        }

        public Criteria andCarTypeEndTimeNotEqualTo(Long value) {
            addCriterion("car_type_end_time <>", value, "carTypeEndTime");
            return (Criteria) this;
        }

        public Criteria andCarTypeEndTimeGreaterThan(Long value) {
            addCriterion("car_type_end_time >", value, "carTypeEndTime");
            return (Criteria) this;
        }

        public Criteria andCarTypeEndTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("car_type_end_time >=", value, "carTypeEndTime");
            return (Criteria) this;
        }

        public Criteria andCarTypeEndTimeLessThan(Long value) {
            addCriterion("car_type_end_time <", value, "carTypeEndTime");
            return (Criteria) this;
        }

        public Criteria andCarTypeEndTimeLessThanOrEqualTo(Long value) {
            addCriterion("car_type_end_time <=", value, "carTypeEndTime");
            return (Criteria) this;
        }

        public Criteria andCarTypeEndTimeIn(List<Long> values) {
            addCriterion("car_type_end_time in", values, "carTypeEndTime");
            return (Criteria) this;
        }

        public Criteria andCarTypeEndTimeNotIn(List<Long> values) {
            addCriterion("car_type_end_time not in", values, "carTypeEndTime");
            return (Criteria) this;
        }

        public Criteria andCarTypeEndTimeBetween(Long value1, Long value2) {
            addCriterion("car_type_end_time between", value1, value2, "carTypeEndTime");
            return (Criteria) this;
        }

        public Criteria andCarTypeEndTimeNotBetween(Long value1, Long value2) {
            addCriterion("car_type_end_time not between", value1, value2, "carTypeEndTime");
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