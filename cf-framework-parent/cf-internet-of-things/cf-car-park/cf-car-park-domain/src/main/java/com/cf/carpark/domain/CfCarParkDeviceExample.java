package com.cf.carpark.domain;

import java.util.ArrayList;
import java.util.List;

public class CfCarParkDeviceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfCarParkDeviceExample() {
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

        public Criteria andBarCodeIsNull() {
            addCriterion("bar_code is null");
            return (Criteria) this;
        }

        public Criteria andBarCodeIsNotNull() {
            addCriterion("bar_code is not null");
            return (Criteria) this;
        }

        public Criteria andBarCodeEqualTo(String value) {
            addCriterion("bar_code =", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeNotEqualTo(String value) {
            addCriterion("bar_code <>", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeGreaterThan(String value) {
            addCriterion("bar_code >", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeGreaterThanOrEqualTo(String value) {
            addCriterion("bar_code >=", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeLessThan(String value) {
            addCriterion("bar_code <", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeLessThanOrEqualTo(String value) {
            addCriterion("bar_code <=", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeLike(String value) {
            addCriterion("bar_code like", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeNotLike(String value) {
            addCriterion("bar_code not like", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeIn(List<String> values) {
            addCriterion("bar_code in", values, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeNotIn(List<String> values) {
            addCriterion("bar_code not in", values, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeBetween(String value1, String value2) {
            addCriterion("bar_code between", value1, value2, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeNotBetween(String value1, String value2) {
            addCriterion("bar_code not between", value1, value2, "barCode");
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

        public Criteria andLastOnlineTimeIsNull() {
            addCriterion("last_online_time is null");
            return (Criteria) this;
        }

        public Criteria andLastOnlineTimeIsNotNull() {
            addCriterion("last_online_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastOnlineTimeEqualTo(Long value) {
            addCriterion("last_online_time =", value, "lastOnlineTime");
            return (Criteria) this;
        }

        public Criteria andLastOnlineTimeNotEqualTo(Long value) {
            addCriterion("last_online_time <>", value, "lastOnlineTime");
            return (Criteria) this;
        }

        public Criteria andLastOnlineTimeGreaterThan(Long value) {
            addCriterion("last_online_time >", value, "lastOnlineTime");
            return (Criteria) this;
        }

        public Criteria andLastOnlineTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("last_online_time >=", value, "lastOnlineTime");
            return (Criteria) this;
        }

        public Criteria andLastOnlineTimeLessThan(Long value) {
            addCriterion("last_online_time <", value, "lastOnlineTime");
            return (Criteria) this;
        }

        public Criteria andLastOnlineTimeLessThanOrEqualTo(Long value) {
            addCriterion("last_online_time <=", value, "lastOnlineTime");
            return (Criteria) this;
        }

        public Criteria andLastOnlineTimeIn(List<Long> values) {
            addCriterion("last_online_time in", values, "lastOnlineTime");
            return (Criteria) this;
        }

        public Criteria andLastOnlineTimeNotIn(List<Long> values) {
            addCriterion("last_online_time not in", values, "lastOnlineTime");
            return (Criteria) this;
        }

        public Criteria andLastOnlineTimeBetween(Long value1, Long value2) {
            addCriterion("last_online_time between", value1, value2, "lastOnlineTime");
            return (Criteria) this;
        }

        public Criteria andLastOnlineTimeNotBetween(Long value1, Long value2) {
            addCriterion("last_online_time not between", value1, value2, "lastOnlineTime");
            return (Criteria) this;
        }

        public Criteria andLinkModeIsNull() {
            addCriterion("link_mode is null");
            return (Criteria) this;
        }

        public Criteria andLinkModeIsNotNull() {
            addCriterion("link_mode is not null");
            return (Criteria) this;
        }

        public Criteria andLinkModeEqualTo(String value) {
            addCriterion("link_mode =", value, "linkMode");
            return (Criteria) this;
        }

        public Criteria andLinkModeNotEqualTo(String value) {
            addCriterion("link_mode <>", value, "linkMode");
            return (Criteria) this;
        }

        public Criteria andLinkModeGreaterThan(String value) {
            addCriterion("link_mode >", value, "linkMode");
            return (Criteria) this;
        }

        public Criteria andLinkModeGreaterThanOrEqualTo(String value) {
            addCriterion("link_mode >=", value, "linkMode");
            return (Criteria) this;
        }

        public Criteria andLinkModeLessThan(String value) {
            addCriterion("link_mode <", value, "linkMode");
            return (Criteria) this;
        }

        public Criteria andLinkModeLessThanOrEqualTo(String value) {
            addCriterion("link_mode <=", value, "linkMode");
            return (Criteria) this;
        }

        public Criteria andLinkModeLike(String value) {
            addCriterion("link_mode like", value, "linkMode");
            return (Criteria) this;
        }

        public Criteria andLinkModeNotLike(String value) {
            addCriterion("link_mode not like", value, "linkMode");
            return (Criteria) this;
        }

        public Criteria andLinkModeIn(List<String> values) {
            addCriterion("link_mode in", values, "linkMode");
            return (Criteria) this;
        }

        public Criteria andLinkModeNotIn(List<String> values) {
            addCriterion("link_mode not in", values, "linkMode");
            return (Criteria) this;
        }

        public Criteria andLinkModeBetween(String value1, String value2) {
            addCriterion("link_mode between", value1, value2, "linkMode");
            return (Criteria) this;
        }

        public Criteria andLinkModeNotBetween(String value1, String value2) {
            addCriterion("link_mode not between", value1, value2, "linkMode");
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

        public Criteria andCheckpointIdIsNull() {
            addCriterion("checkpoint_id is null");
            return (Criteria) this;
        }

        public Criteria andCheckpointIdIsNotNull() {
            addCriterion("checkpoint_id is not null");
            return (Criteria) this;
        }

        public Criteria andCheckpointIdEqualTo(String value) {
            addCriterion("checkpoint_id =", value, "checkpointId");
            return (Criteria) this;
        }

        public Criteria andCheckpointIdNotEqualTo(String value) {
            addCriterion("checkpoint_id <>", value, "checkpointId");
            return (Criteria) this;
        }

        public Criteria andCheckpointIdGreaterThan(String value) {
            addCriterion("checkpoint_id >", value, "checkpointId");
            return (Criteria) this;
        }

        public Criteria andCheckpointIdGreaterThanOrEqualTo(String value) {
            addCriterion("checkpoint_id >=", value, "checkpointId");
            return (Criteria) this;
        }

        public Criteria andCheckpointIdLessThan(String value) {
            addCriterion("checkpoint_id <", value, "checkpointId");
            return (Criteria) this;
        }

        public Criteria andCheckpointIdLessThanOrEqualTo(String value) {
            addCriterion("checkpoint_id <=", value, "checkpointId");
            return (Criteria) this;
        }

        public Criteria andCheckpointIdLike(String value) {
            addCriterion("checkpoint_id like", value, "checkpointId");
            return (Criteria) this;
        }

        public Criteria andCheckpointIdNotLike(String value) {
            addCriterion("checkpoint_id not like", value, "checkpointId");
            return (Criteria) this;
        }

        public Criteria andCheckpointIdIn(List<String> values) {
            addCriterion("checkpoint_id in", values, "checkpointId");
            return (Criteria) this;
        }

        public Criteria andCheckpointIdNotIn(List<String> values) {
            addCriterion("checkpoint_id not in", values, "checkpointId");
            return (Criteria) this;
        }

        public Criteria andCheckpointIdBetween(String value1, String value2) {
            addCriterion("checkpoint_id between", value1, value2, "checkpointId");
            return (Criteria) this;
        }

        public Criteria andCheckpointIdNotBetween(String value1, String value2) {
            addCriterion("checkpoint_id not between", value1, value2, "checkpointId");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(String value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(String value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(String value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(String value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(String value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLike(String value) {
            addCriterion("product_id like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotLike(String value) {
            addCriterion("product_id not like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<String> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<String> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(String value1, String value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(String value1, String value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNull() {
            addCriterion("direction is null");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNotNull() {
            addCriterion("direction is not null");
            return (Criteria) this;
        }

        public Criteria andDirectionEqualTo(String value) {
            addCriterion("direction =", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotEqualTo(String value) {
            addCriterion("direction <>", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThan(String value) {
            addCriterion("direction >", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThanOrEqualTo(String value) {
            addCriterion("direction >=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThan(String value) {
            addCriterion("direction <", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThanOrEqualTo(String value) {
            addCriterion("direction <=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLike(String value) {
            addCriterion("direction like", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotLike(String value) {
            addCriterion("direction not like", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionIn(List<String> values) {
            addCriterion("direction in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotIn(List<String> values) {
            addCriterion("direction not in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionBetween(String value1, String value2) {
            addCriterion("direction between", value1, value2, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotBetween(String value1, String value2) {
            addCriterion("direction not between", value1, value2, "direction");
            return (Criteria) this;
        }

        public Criteria andPlayContentsIsNull() {
            addCriterion("play_contents is null");
            return (Criteria) this;
        }

        public Criteria andPlayContentsIsNotNull() {
            addCriterion("play_contents is not null");
            return (Criteria) this;
        }

        public Criteria andPlayContentsEqualTo(String value) {
            addCriterion("play_contents =", value, "playContents");
            return (Criteria) this;
        }

        public Criteria andPlayContentsNotEqualTo(String value) {
            addCriterion("play_contents <>", value, "playContents");
            return (Criteria) this;
        }

        public Criteria andPlayContentsGreaterThan(String value) {
            addCriterion("play_contents >", value, "playContents");
            return (Criteria) this;
        }

        public Criteria andPlayContentsGreaterThanOrEqualTo(String value) {
            addCriterion("play_contents >=", value, "playContents");
            return (Criteria) this;
        }

        public Criteria andPlayContentsLessThan(String value) {
            addCriterion("play_contents <", value, "playContents");
            return (Criteria) this;
        }

        public Criteria andPlayContentsLessThanOrEqualTo(String value) {
            addCriterion("play_contents <=", value, "playContents");
            return (Criteria) this;
        }

        public Criteria andPlayContentsLike(String value) {
            addCriterion("play_contents like", value, "playContents");
            return (Criteria) this;
        }

        public Criteria andPlayContentsNotLike(String value) {
            addCriterion("play_contents not like", value, "playContents");
            return (Criteria) this;
        }

        public Criteria andPlayContentsIn(List<String> values) {
            addCriterion("play_contents in", values, "playContents");
            return (Criteria) this;
        }

        public Criteria andPlayContentsNotIn(List<String> values) {
            addCriterion("play_contents not in", values, "playContents");
            return (Criteria) this;
        }

        public Criteria andPlayContentsBetween(String value1, String value2) {
            addCriterion("play_contents between", value1, value2, "playContents");
            return (Criteria) this;
        }

        public Criteria andPlayContentsNotBetween(String value1, String value2) {
            addCriterion("play_contents not between", value1, value2, "playContents");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andVideoAddressIsNull() {
            addCriterion("video_address is null");
            return (Criteria) this;
        }

        public Criteria andVideoAddressIsNotNull() {
            addCriterion("video_address is not null");
            return (Criteria) this;
        }

        public Criteria andVideoAddressEqualTo(String value) {
            addCriterion("video_address =", value, "videoAddress");
            return (Criteria) this;
        }

        public Criteria andVideoAddressNotEqualTo(String value) {
            addCriterion("video_address <>", value, "videoAddress");
            return (Criteria) this;
        }

        public Criteria andVideoAddressGreaterThan(String value) {
            addCriterion("video_address >", value, "videoAddress");
            return (Criteria) this;
        }

        public Criteria andVideoAddressGreaterThanOrEqualTo(String value) {
            addCriterion("video_address >=", value, "videoAddress");
            return (Criteria) this;
        }

        public Criteria andVideoAddressLessThan(String value) {
            addCriterion("video_address <", value, "videoAddress");
            return (Criteria) this;
        }

        public Criteria andVideoAddressLessThanOrEqualTo(String value) {
            addCriterion("video_address <=", value, "videoAddress");
            return (Criteria) this;
        }

        public Criteria andVideoAddressLike(String value) {
            addCriterion("video_address like", value, "videoAddress");
            return (Criteria) this;
        }

        public Criteria andVideoAddressNotLike(String value) {
            addCriterion("video_address not like", value, "videoAddress");
            return (Criteria) this;
        }

        public Criteria andVideoAddressIn(List<String> values) {
            addCriterion("video_address in", values, "videoAddress");
            return (Criteria) this;
        }

        public Criteria andVideoAddressNotIn(List<String> values) {
            addCriterion("video_address not in", values, "videoAddress");
            return (Criteria) this;
        }

        public Criteria andVideoAddressBetween(String value1, String value2) {
            addCriterion("video_address between", value1, value2, "videoAddress");
            return (Criteria) this;
        }

        public Criteria andVideoAddressNotBetween(String value1, String value2) {
            addCriterion("video_address not between", value1, value2, "videoAddress");
            return (Criteria) this;
        }

        public Criteria andHistoryVideoAddressIsNull() {
            addCriterion("history_video_address is null");
            return (Criteria) this;
        }

        public Criteria andHistoryVideoAddressIsNotNull() {
            addCriterion("history_video_address is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryVideoAddressEqualTo(String value) {
            addCriterion("history_video_address =", value, "historyVideoAddress");
            return (Criteria) this;
        }

        public Criteria andHistoryVideoAddressNotEqualTo(String value) {
            addCriterion("history_video_address <>", value, "historyVideoAddress");
            return (Criteria) this;
        }

        public Criteria andHistoryVideoAddressGreaterThan(String value) {
            addCriterion("history_video_address >", value, "historyVideoAddress");
            return (Criteria) this;
        }

        public Criteria andHistoryVideoAddressGreaterThanOrEqualTo(String value) {
            addCriterion("history_video_address >=", value, "historyVideoAddress");
            return (Criteria) this;
        }

        public Criteria andHistoryVideoAddressLessThan(String value) {
            addCriterion("history_video_address <", value, "historyVideoAddress");
            return (Criteria) this;
        }

        public Criteria andHistoryVideoAddressLessThanOrEqualTo(String value) {
            addCriterion("history_video_address <=", value, "historyVideoAddress");
            return (Criteria) this;
        }

        public Criteria andHistoryVideoAddressLike(String value) {
            addCriterion("history_video_address like", value, "historyVideoAddress");
            return (Criteria) this;
        }

        public Criteria andHistoryVideoAddressNotLike(String value) {
            addCriterion("history_video_address not like", value, "historyVideoAddress");
            return (Criteria) this;
        }

        public Criteria andHistoryVideoAddressIn(List<String> values) {
            addCriterion("history_video_address in", values, "historyVideoAddress");
            return (Criteria) this;
        }

        public Criteria andHistoryVideoAddressNotIn(List<String> values) {
            addCriterion("history_video_address not in", values, "historyVideoAddress");
            return (Criteria) this;
        }

        public Criteria andHistoryVideoAddressBetween(String value1, String value2) {
            addCriterion("history_video_address between", value1, value2, "historyVideoAddress");
            return (Criteria) this;
        }

        public Criteria andHistoryVideoAddressNotBetween(String value1, String value2) {
            addCriterion("history_video_address not between", value1, value2, "historyVideoAddress");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andIndexNoIsNull() {
            addCriterion("index_no is null");
            return (Criteria) this;
        }

        public Criteria andIndexNoIsNotNull() {
            addCriterion("index_no is not null");
            return (Criteria) this;
        }

        public Criteria andIndexNoEqualTo(Byte value) {
            addCriterion("index_no =", value, "indexNo");
            return (Criteria) this;
        }

        public Criteria andIndexNoNotEqualTo(Byte value) {
            addCriterion("index_no <>", value, "indexNo");
            return (Criteria) this;
        }

        public Criteria andIndexNoGreaterThan(Byte value) {
            addCriterion("index_no >", value, "indexNo");
            return (Criteria) this;
        }

        public Criteria andIndexNoGreaterThanOrEqualTo(Byte value) {
            addCriterion("index_no >=", value, "indexNo");
            return (Criteria) this;
        }

        public Criteria andIndexNoLessThan(Byte value) {
            addCriterion("index_no <", value, "indexNo");
            return (Criteria) this;
        }

        public Criteria andIndexNoLessThanOrEqualTo(Byte value) {
            addCriterion("index_no <=", value, "indexNo");
            return (Criteria) this;
        }

        public Criteria andIndexNoIn(List<Byte> values) {
            addCriterion("index_no in", values, "indexNo");
            return (Criteria) this;
        }

        public Criteria andIndexNoNotIn(List<Byte> values) {
            addCriterion("index_no not in", values, "indexNo");
            return (Criteria) this;
        }

        public Criteria andIndexNoBetween(Byte value1, Byte value2) {
            addCriterion("index_no between", value1, value2, "indexNo");
            return (Criteria) this;
        }

        public Criteria andIndexNoNotBetween(Byte value1, Byte value2) {
            addCriterion("index_no not between", value1, value2, "indexNo");
            return (Criteria) this;
        }

        public Criteria andNoticedIsNull() {
            addCriterion("noticed is null");
            return (Criteria) this;
        }

        public Criteria andNoticedIsNotNull() {
            addCriterion("noticed is not null");
            return (Criteria) this;
        }

        public Criteria andNoticedEqualTo(Byte value) {
            addCriterion("noticed =", value, "noticed");
            return (Criteria) this;
        }

        public Criteria andNoticedNotEqualTo(Byte value) {
            addCriterion("noticed <>", value, "noticed");
            return (Criteria) this;
        }

        public Criteria andNoticedGreaterThan(Byte value) {
            addCriterion("noticed >", value, "noticed");
            return (Criteria) this;
        }

        public Criteria andNoticedGreaterThanOrEqualTo(Byte value) {
            addCriterion("noticed >=", value, "noticed");
            return (Criteria) this;
        }

        public Criteria andNoticedLessThan(Byte value) {
            addCriterion("noticed <", value, "noticed");
            return (Criteria) this;
        }

        public Criteria andNoticedLessThanOrEqualTo(Byte value) {
            addCriterion("noticed <=", value, "noticed");
            return (Criteria) this;
        }

        public Criteria andNoticedIn(List<Byte> values) {
            addCriterion("noticed in", values, "noticed");
            return (Criteria) this;
        }

        public Criteria andNoticedNotIn(List<Byte> values) {
            addCriterion("noticed not in", values, "noticed");
            return (Criteria) this;
        }

        public Criteria andNoticedBetween(Byte value1, Byte value2) {
            addCriterion("noticed between", value1, value2, "noticed");
            return (Criteria) this;
        }

        public Criteria andNoticedNotBetween(Byte value1, Byte value2) {
            addCriterion("noticed not between", value1, value2, "noticed");
            return (Criteria) this;
        }

        public Criteria andVideoModeIsNull() {
            addCriterion("video_mode is null");
            return (Criteria) this;
        }

        public Criteria andVideoModeIsNotNull() {
            addCriterion("video_mode is not null");
            return (Criteria) this;
        }

        public Criteria andVideoModeEqualTo(String value) {
            addCriterion("video_mode =", value, "videoMode");
            return (Criteria) this;
        }

        public Criteria andVideoModeNotEqualTo(String value) {
            addCriterion("video_mode <>", value, "videoMode");
            return (Criteria) this;
        }

        public Criteria andVideoModeGreaterThan(String value) {
            addCriterion("video_mode >", value, "videoMode");
            return (Criteria) this;
        }

        public Criteria andVideoModeGreaterThanOrEqualTo(String value) {
            addCriterion("video_mode >=", value, "videoMode");
            return (Criteria) this;
        }

        public Criteria andVideoModeLessThan(String value) {
            addCriterion("video_mode <", value, "videoMode");
            return (Criteria) this;
        }

        public Criteria andVideoModeLessThanOrEqualTo(String value) {
            addCriterion("video_mode <=", value, "videoMode");
            return (Criteria) this;
        }

        public Criteria andVideoModeLike(String value) {
            addCriterion("video_mode like", value, "videoMode");
            return (Criteria) this;
        }

        public Criteria andVideoModeNotLike(String value) {
            addCriterion("video_mode not like", value, "videoMode");
            return (Criteria) this;
        }

        public Criteria andVideoModeIn(List<String> values) {
            addCriterion("video_mode in", values, "videoMode");
            return (Criteria) this;
        }

        public Criteria andVideoModeNotIn(List<String> values) {
            addCriterion("video_mode not in", values, "videoMode");
            return (Criteria) this;
        }

        public Criteria andVideoModeBetween(String value1, String value2) {
            addCriterion("video_mode between", value1, value2, "videoMode");
            return (Criteria) this;
        }

        public Criteria andVideoModeNotBetween(String value1, String value2) {
            addCriterion("video_mode not between", value1, value2, "videoMode");
            return (Criteria) this;
        }

        public Criteria andRowsIsNull() {
            addCriterion("rows is null");
            return (Criteria) this;
        }

        public Criteria andRowsIsNotNull() {
            addCriterion("rows is not null");
            return (Criteria) this;
        }

        public Criteria andRowsEqualTo(Byte value) {
            addCriterion("rows =", value, "rows");
            return (Criteria) this;
        }

        public Criteria andRowsNotEqualTo(Byte value) {
            addCriterion("rows <>", value, "rows");
            return (Criteria) this;
        }

        public Criteria andRowsGreaterThan(Byte value) {
            addCriterion("rows >", value, "rows");
            return (Criteria) this;
        }

        public Criteria andRowsGreaterThanOrEqualTo(Byte value) {
            addCriterion("rows >=", value, "rows");
            return (Criteria) this;
        }

        public Criteria andRowsLessThan(Byte value) {
            addCriterion("rows <", value, "rows");
            return (Criteria) this;
        }

        public Criteria andRowsLessThanOrEqualTo(Byte value) {
            addCriterion("rows <=", value, "rows");
            return (Criteria) this;
        }

        public Criteria andRowsIn(List<Byte> values) {
            addCriterion("rows in", values, "rows");
            return (Criteria) this;
        }

        public Criteria andRowsNotIn(List<Byte> values) {
            addCriterion("rows not in", values, "rows");
            return (Criteria) this;
        }

        public Criteria andRowsBetween(Byte value1, Byte value2) {
            addCriterion("rows between", value1, value2, "rows");
            return (Criteria) this;
        }

        public Criteria andRowsNotBetween(Byte value1, Byte value2) {
            addCriterion("rows not between", value1, value2, "rows");
            return (Criteria) this;
        }

        public Criteria andMacAddressIsNull() {
            addCriterion("mac_address is null");
            return (Criteria) this;
        }

        public Criteria andMacAddressIsNotNull() {
            addCriterion("mac_address is not null");
            return (Criteria) this;
        }

        public Criteria andMacAddressEqualTo(String value) {
            addCriterion("mac_address =", value, "macAddress");
            return (Criteria) this;
        }

        public Criteria andMacAddressNotEqualTo(String value) {
            addCriterion("mac_address <>", value, "macAddress");
            return (Criteria) this;
        }

        public Criteria andMacAddressGreaterThan(String value) {
            addCriterion("mac_address >", value, "macAddress");
            return (Criteria) this;
        }

        public Criteria andMacAddressGreaterThanOrEqualTo(String value) {
            addCriterion("mac_address >=", value, "macAddress");
            return (Criteria) this;
        }

        public Criteria andMacAddressLessThan(String value) {
            addCriterion("mac_address <", value, "macAddress");
            return (Criteria) this;
        }

        public Criteria andMacAddressLessThanOrEqualTo(String value) {
            addCriterion("mac_address <=", value, "macAddress");
            return (Criteria) this;
        }

        public Criteria andMacAddressLike(String value) {
            addCriterion("mac_address like", value, "macAddress");
            return (Criteria) this;
        }

        public Criteria andMacAddressNotLike(String value) {
            addCriterion("mac_address not like", value, "macAddress");
            return (Criteria) this;
        }

        public Criteria andMacAddressIn(List<String> values) {
            addCriterion("mac_address in", values, "macAddress");
            return (Criteria) this;
        }

        public Criteria andMacAddressNotIn(List<String> values) {
            addCriterion("mac_address not in", values, "macAddress");
            return (Criteria) this;
        }

        public Criteria andMacAddressBetween(String value1, String value2) {
            addCriterion("mac_address between", value1, value2, "macAddress");
            return (Criteria) this;
        }

        public Criteria andMacAddressNotBetween(String value1, String value2) {
            addCriterion("mac_address not between", value1, value2, "macAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIsNull() {
            addCriterion("device_name is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIsNotNull() {
            addCriterion("device_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNameEqualTo(String value) {
            addCriterion("device_name =", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotEqualTo(String value) {
            addCriterion("device_name <>", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameGreaterThan(String value) {
            addCriterion("device_name >", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameGreaterThanOrEqualTo(String value) {
            addCriterion("device_name >=", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLessThan(String value) {
            addCriterion("device_name <", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLessThanOrEqualTo(String value) {
            addCriterion("device_name <=", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLike(String value) {
            addCriterion("device_name like", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotLike(String value) {
            addCriterion("device_name not like", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIn(List<String> values) {
            addCriterion("device_name in", values, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotIn(List<String> values) {
            addCriterion("device_name not in", values, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameBetween(String value1, String value2) {
            addCriterion("device_name between", value1, value2, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotBetween(String value1, String value2) {
            addCriterion("device_name not between", value1, value2, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNoIsNull() {
            addCriterion("device_no is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNoIsNotNull() {
            addCriterion("device_no is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNoEqualTo(String value) {
            addCriterion("device_no =", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoNotEqualTo(String value) {
            addCriterion("device_no <>", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoGreaterThan(String value) {
            addCriterion("device_no >", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoGreaterThanOrEqualTo(String value) {
            addCriterion("device_no >=", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoLessThan(String value) {
            addCriterion("device_no <", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoLessThanOrEqualTo(String value) {
            addCriterion("device_no <=", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoLike(String value) {
            addCriterion("device_no like", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoNotLike(String value) {
            addCriterion("device_no not like", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoIn(List<String> values) {
            addCriterion("device_no in", values, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoNotIn(List<String> values) {
            addCriterion("device_no not in", values, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoBetween(String value1, String value2) {
            addCriterion("device_no between", value1, value2, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoNotBetween(String value1, String value2) {
            addCriterion("device_no not between", value1, value2, "deviceNo");
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