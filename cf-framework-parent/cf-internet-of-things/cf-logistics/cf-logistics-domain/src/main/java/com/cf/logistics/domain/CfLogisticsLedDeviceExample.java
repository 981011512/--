package com.cf.logistics.domain;

import java.util.ArrayList;
import java.util.List;

public class CfLogisticsLedDeviceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfLogisticsLedDeviceExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andQueuingAreaIdIsNull() {
            addCriterion("queuing_area_id is null");
            return (Criteria) this;
        }

        public Criteria andQueuingAreaIdIsNotNull() {
            addCriterion("queuing_area_id is not null");
            return (Criteria) this;
        }

        public Criteria andQueuingAreaIdEqualTo(Long value) {
            addCriterion("queuing_area_id =", value, "queuingAreaId");
            return (Criteria) this;
        }

        public Criteria andQueuingAreaIdNotEqualTo(Long value) {
            addCriterion("queuing_area_id <>", value, "queuingAreaId");
            return (Criteria) this;
        }

        public Criteria andQueuingAreaIdGreaterThan(Long value) {
            addCriterion("queuing_area_id >", value, "queuingAreaId");
            return (Criteria) this;
        }

        public Criteria andQueuingAreaIdGreaterThanOrEqualTo(Long value) {
            addCriterion("queuing_area_id >=", value, "queuingAreaId");
            return (Criteria) this;
        }

        public Criteria andQueuingAreaIdLessThan(Long value) {
            addCriterion("queuing_area_id <", value, "queuingAreaId");
            return (Criteria) this;
        }

        public Criteria andQueuingAreaIdLessThanOrEqualTo(Long value) {
            addCriterion("queuing_area_id <=", value, "queuingAreaId");
            return (Criteria) this;
        }

        public Criteria andQueuingAreaIdIn(List<Long> values) {
            addCriterion("queuing_area_id in", values, "queuingAreaId");
            return (Criteria) this;
        }

        public Criteria andQueuingAreaIdNotIn(List<Long> values) {
            addCriterion("queuing_area_id not in", values, "queuingAreaId");
            return (Criteria) this;
        }

        public Criteria andQueuingAreaIdBetween(Long value1, Long value2) {
            addCriterion("queuing_area_id between", value1, value2, "queuingAreaId");
            return (Criteria) this;
        }

        public Criteria andQueuingAreaIdNotBetween(Long value1, Long value2) {
            addCriterion("queuing_area_id not between", value1, value2, "queuingAreaId");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNull() {
            addCriterion("serial_number is null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNotNull() {
            addCriterion("serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberEqualTo(String value) {
            addCriterion("serial_number =", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotEqualTo(String value) {
            addCriterion("serial_number <>", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThan(String value) {
            addCriterion("serial_number >", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("serial_number >=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThan(String value) {
            addCriterion("serial_number <", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("serial_number <=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLike(String value) {
            addCriterion("serial_number like", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotLike(String value) {
            addCriterion("serial_number not like", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIn(List<String> values) {
            addCriterion("serial_number in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotIn(List<String> values) {
            addCriterion("serial_number not in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberBetween(String value1, String value2) {
            addCriterion("serial_number between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotBetween(String value1, String value2) {
            addCriterion("serial_number not between", value1, value2, "serialNumber");
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