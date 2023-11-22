package com.cf.pay.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CfCouponActivityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfCouponActivityExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andSubtitleIsNull() {
            addCriterion("subtitle is null");
            return (Criteria) this;
        }

        public Criteria andSubtitleIsNotNull() {
            addCriterion("subtitle is not null");
            return (Criteria) this;
        }

        public Criteria andSubtitleEqualTo(String value) {
            addCriterion("subtitle =", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotEqualTo(String value) {
            addCriterion("subtitle <>", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleGreaterThan(String value) {
            addCriterion("subtitle >", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleGreaterThanOrEqualTo(String value) {
            addCriterion("subtitle >=", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLessThan(String value) {
            addCriterion("subtitle <", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLessThanOrEqualTo(String value) {
            addCriterion("subtitle <=", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLike(String value) {
            addCriterion("subtitle like", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotLike(String value) {
            addCriterion("subtitle not like", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleIn(List<String> values) {
            addCriterion("subtitle in", values, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotIn(List<String> values) {
            addCriterion("subtitle not in", values, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleBetween(String value1, String value2) {
            addCriterion("subtitle between", value1, value2, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotBetween(String value1, String value2) {
            addCriterion("subtitle not between", value1, value2, "subtitle");
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

        public Criteria andIntroductionIsNull() {
            addCriterion("introduction is null");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNotNull() {
            addCriterion("introduction is not null");
            return (Criteria) this;
        }

        public Criteria andIntroductionEqualTo(String value) {
            addCriterion("introduction =", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotEqualTo(String value) {
            addCriterion("introduction <>", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThan(String value) {
            addCriterion("introduction >", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("introduction >=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThan(String value) {
            addCriterion("introduction <", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThanOrEqualTo(String value) {
            addCriterion("introduction <=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLike(String value) {
            addCriterion("introduction like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotLike(String value) {
            addCriterion("introduction not like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionIn(List<String> values) {
            addCriterion("introduction in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotIn(List<String> values) {
            addCriterion("introduction not in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionBetween(String value1, String value2) {
            addCriterion("introduction between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotBetween(String value1, String value2) {
            addCriterion("introduction not between", value1, value2, "introduction");
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

        public Criteria andMainBodyIdIsNull() {
            addCriterion("main_body_id is null");
            return (Criteria) this;
        }

        public Criteria andMainBodyIdIsNotNull() {
            addCriterion("main_body_id is not null");
            return (Criteria) this;
        }

        public Criteria andMainBodyIdEqualTo(String value) {
            addCriterion("main_body_id =", value, "mainBodyId");
            return (Criteria) this;
        }

        public Criteria andMainBodyIdNotEqualTo(String value) {
            addCriterion("main_body_id <>", value, "mainBodyId");
            return (Criteria) this;
        }

        public Criteria andMainBodyIdGreaterThan(String value) {
            addCriterion("main_body_id >", value, "mainBodyId");
            return (Criteria) this;
        }

        public Criteria andMainBodyIdGreaterThanOrEqualTo(String value) {
            addCriterion("main_body_id >=", value, "mainBodyId");
            return (Criteria) this;
        }

        public Criteria andMainBodyIdLessThan(String value) {
            addCriterion("main_body_id <", value, "mainBodyId");
            return (Criteria) this;
        }

        public Criteria andMainBodyIdLessThanOrEqualTo(String value) {
            addCriterion("main_body_id <=", value, "mainBodyId");
            return (Criteria) this;
        }

        public Criteria andMainBodyIdLike(String value) {
            addCriterion("main_body_id like", value, "mainBodyId");
            return (Criteria) this;
        }

        public Criteria andMainBodyIdNotLike(String value) {
            addCriterion("main_body_id not like", value, "mainBodyId");
            return (Criteria) this;
        }

        public Criteria andMainBodyIdIn(List<String> values) {
            addCriterion("main_body_id in", values, "mainBodyId");
            return (Criteria) this;
        }

        public Criteria andMainBodyIdNotIn(List<String> values) {
            addCriterion("main_body_id not in", values, "mainBodyId");
            return (Criteria) this;
        }

        public Criteria andMainBodyIdBetween(String value1, String value2) {
            addCriterion("main_body_id between", value1, value2, "mainBodyId");
            return (Criteria) this;
        }

        public Criteria andMainBodyIdNotBetween(String value1, String value2) {
            addCriterion("main_body_id not between", value1, value2, "mainBodyId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdIsNull() {
            addCriterion("creater_id is null");
            return (Criteria) this;
        }

        public Criteria andCreaterIdIsNotNull() {
            addCriterion("creater_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterIdEqualTo(String value) {
            addCriterion("creater_id =", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdNotEqualTo(String value) {
            addCriterion("creater_id <>", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdGreaterThan(String value) {
            addCriterion("creater_id >", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdGreaterThanOrEqualTo(String value) {
            addCriterion("creater_id >=", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdLessThan(String value) {
            addCriterion("creater_id <", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdLessThanOrEqualTo(String value) {
            addCriterion("creater_id <=", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdLike(String value) {
            addCriterion("creater_id like", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdNotLike(String value) {
            addCriterion("creater_id not like", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdIn(List<String> values) {
            addCriterion("creater_id in", values, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdNotIn(List<String> values) {
            addCriterion("creater_id not in", values, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdBetween(String value1, String value2) {
            addCriterion("creater_id between", value1, value2, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdNotBetween(String value1, String value2) {
            addCriterion("creater_id not between", value1, value2, "createrId");
            return (Criteria) this;
        }

        public Criteria andDenominationIsNull() {
            addCriterion("denomination is null");
            return (Criteria) this;
        }

        public Criteria andDenominationIsNotNull() {
            addCriterion("denomination is not null");
            return (Criteria) this;
        }

        public Criteria andDenominationEqualTo(BigDecimal value) {
            addCriterion("denomination =", value, "denomination");
            return (Criteria) this;
        }

        public Criteria andDenominationNotEqualTo(BigDecimal value) {
            addCriterion("denomination <>", value, "denomination");
            return (Criteria) this;
        }

        public Criteria andDenominationGreaterThan(BigDecimal value) {
            addCriterion("denomination >", value, "denomination");
            return (Criteria) this;
        }

        public Criteria andDenominationGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("denomination >=", value, "denomination");
            return (Criteria) this;
        }

        public Criteria andDenominationLessThan(BigDecimal value) {
            addCriterion("denomination <", value, "denomination");
            return (Criteria) this;
        }

        public Criteria andDenominationLessThanOrEqualTo(BigDecimal value) {
            addCriterion("denomination <=", value, "denomination");
            return (Criteria) this;
        }

        public Criteria andDenominationIn(List<BigDecimal> values) {
            addCriterion("denomination in", values, "denomination");
            return (Criteria) this;
        }

        public Criteria andDenominationNotIn(List<BigDecimal> values) {
            addCriterion("denomination not in", values, "denomination");
            return (Criteria) this;
        }

        public Criteria andDenominationBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("denomination between", value1, value2, "denomination");
            return (Criteria) this;
        }

        public Criteria andDenominationNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("denomination not between", value1, value2, "denomination");
            return (Criteria) this;
        }

        public Criteria andThresholdPriceIsNull() {
            addCriterion("threshold_price is null");
            return (Criteria) this;
        }

        public Criteria andThresholdPriceIsNotNull() {
            addCriterion("threshold_price is not null");
            return (Criteria) this;
        }

        public Criteria andThresholdPriceEqualTo(BigDecimal value) {
            addCriterion("threshold_price =", value, "thresholdPrice");
            return (Criteria) this;
        }

        public Criteria andThresholdPriceNotEqualTo(BigDecimal value) {
            addCriterion("threshold_price <>", value, "thresholdPrice");
            return (Criteria) this;
        }

        public Criteria andThresholdPriceGreaterThan(BigDecimal value) {
            addCriterion("threshold_price >", value, "thresholdPrice");
            return (Criteria) this;
        }

        public Criteria andThresholdPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("threshold_price >=", value, "thresholdPrice");
            return (Criteria) this;
        }

        public Criteria andThresholdPriceLessThan(BigDecimal value) {
            addCriterion("threshold_price <", value, "thresholdPrice");
            return (Criteria) this;
        }

        public Criteria andThresholdPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("threshold_price <=", value, "thresholdPrice");
            return (Criteria) this;
        }

        public Criteria andThresholdPriceIn(List<BigDecimal> values) {
            addCriterion("threshold_price in", values, "thresholdPrice");
            return (Criteria) this;
        }

        public Criteria andThresholdPriceNotIn(List<BigDecimal> values) {
            addCriterion("threshold_price not in", values, "thresholdPrice");
            return (Criteria) this;
        }

        public Criteria andThresholdPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("threshold_price between", value1, value2, "thresholdPrice");
            return (Criteria) this;
        }

        public Criteria andThresholdPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("threshold_price not between", value1, value2, "thresholdPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(String value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(String value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(String value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(String value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(String value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(String value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLike(String value) {
            addCriterion("goods_id like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotLike(String value) {
            addCriterion("goods_id not like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<String> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<String> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(String value1, String value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(String value1, String value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andTotalIssueQuantityIsNull() {
            addCriterion("total_issue_quantity is null");
            return (Criteria) this;
        }

        public Criteria andTotalIssueQuantityIsNotNull() {
            addCriterion("total_issue_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andTotalIssueQuantityEqualTo(Integer value) {
            addCriterion("total_issue_quantity =", value, "totalIssueQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalIssueQuantityNotEqualTo(Integer value) {
            addCriterion("total_issue_quantity <>", value, "totalIssueQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalIssueQuantityGreaterThan(Integer value) {
            addCriterion("total_issue_quantity >", value, "totalIssueQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalIssueQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_issue_quantity >=", value, "totalIssueQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalIssueQuantityLessThan(Integer value) {
            addCriterion("total_issue_quantity <", value, "totalIssueQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalIssueQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("total_issue_quantity <=", value, "totalIssueQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalIssueQuantityIn(List<Integer> values) {
            addCriterion("total_issue_quantity in", values, "totalIssueQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalIssueQuantityNotIn(List<Integer> values) {
            addCriterion("total_issue_quantity not in", values, "totalIssueQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalIssueQuantityBetween(Integer value1, Integer value2) {
            addCriterion("total_issue_quantity between", value1, value2, "totalIssueQuantity");
            return (Criteria) this;
        }

        public Criteria andTotalIssueQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("total_issue_quantity not between", value1, value2, "totalIssueQuantity");
            return (Criteria) this;
        }

        public Criteria andIssuedQuantityIsNull() {
            addCriterion("issued_quantity is null");
            return (Criteria) this;
        }

        public Criteria andIssuedQuantityIsNotNull() {
            addCriterion("issued_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andIssuedQuantityEqualTo(Integer value) {
            addCriterion("issued_quantity =", value, "issuedQuantity");
            return (Criteria) this;
        }

        public Criteria andIssuedQuantityNotEqualTo(Integer value) {
            addCriterion("issued_quantity <>", value, "issuedQuantity");
            return (Criteria) this;
        }

        public Criteria andIssuedQuantityGreaterThan(Integer value) {
            addCriterion("issued_quantity >", value, "issuedQuantity");
            return (Criteria) this;
        }

        public Criteria andIssuedQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("issued_quantity >=", value, "issuedQuantity");
            return (Criteria) this;
        }

        public Criteria andIssuedQuantityLessThan(Integer value) {
            addCriterion("issued_quantity <", value, "issuedQuantity");
            return (Criteria) this;
        }

        public Criteria andIssuedQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("issued_quantity <=", value, "issuedQuantity");
            return (Criteria) this;
        }

        public Criteria andIssuedQuantityIn(List<Integer> values) {
            addCriterion("issued_quantity in", values, "issuedQuantity");
            return (Criteria) this;
        }

        public Criteria andIssuedQuantityNotIn(List<Integer> values) {
            addCriterion("issued_quantity not in", values, "issuedQuantity");
            return (Criteria) this;
        }

        public Criteria andIssuedQuantityBetween(Integer value1, Integer value2) {
            addCriterion("issued_quantity between", value1, value2, "issuedQuantity");
            return (Criteria) this;
        }

        public Criteria andIssuedQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("issued_quantity not between", value1, value2, "issuedQuantity");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeIsNull() {
            addCriterion("unit_of_time is null");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeIsNotNull() {
            addCriterion("unit_of_time is not null");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeEqualTo(Long value) {
            addCriterion("unit_of_time =", value, "unitOfTime");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeNotEqualTo(Long value) {
            addCriterion("unit_of_time <>", value, "unitOfTime");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeGreaterThan(Long value) {
            addCriterion("unit_of_time >", value, "unitOfTime");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("unit_of_time >=", value, "unitOfTime");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeLessThan(Long value) {
            addCriterion("unit_of_time <", value, "unitOfTime");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeLessThanOrEqualTo(Long value) {
            addCriterion("unit_of_time <=", value, "unitOfTime");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeIn(List<Long> values) {
            addCriterion("unit_of_time in", values, "unitOfTime");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeNotIn(List<Long> values) {
            addCriterion("unit_of_time not in", values, "unitOfTime");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeBetween(Long value1, Long value2) {
            addCriterion("unit_of_time between", value1, value2, "unitOfTime");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeNotBetween(Long value1, Long value2) {
            addCriterion("unit_of_time not between", value1, value2, "unitOfTime");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeTotalIssueQuantityIsNull() {
            addCriterion("unit_of_time_total_issue_quantity is null");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeTotalIssueQuantityIsNotNull() {
            addCriterion("unit_of_time_total_issue_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeTotalIssueQuantityEqualTo(Integer value) {
            addCriterion("unit_of_time_total_issue_quantity =", value, "unitOfTimeTotalIssueQuantity");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeTotalIssueQuantityNotEqualTo(Integer value) {
            addCriterion("unit_of_time_total_issue_quantity <>", value, "unitOfTimeTotalIssueQuantity");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeTotalIssueQuantityGreaterThan(Integer value) {
            addCriterion("unit_of_time_total_issue_quantity >", value, "unitOfTimeTotalIssueQuantity");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeTotalIssueQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("unit_of_time_total_issue_quantity >=", value, "unitOfTimeTotalIssueQuantity");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeTotalIssueQuantityLessThan(Integer value) {
            addCriterion("unit_of_time_total_issue_quantity <", value, "unitOfTimeTotalIssueQuantity");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeTotalIssueQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("unit_of_time_total_issue_quantity <=", value, "unitOfTimeTotalIssueQuantity");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeTotalIssueQuantityIn(List<Integer> values) {
            addCriterion("unit_of_time_total_issue_quantity in", values, "unitOfTimeTotalIssueQuantity");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeTotalIssueQuantityNotIn(List<Integer> values) {
            addCriterion("unit_of_time_total_issue_quantity not in", values, "unitOfTimeTotalIssueQuantity");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeTotalIssueQuantityBetween(Integer value1, Integer value2) {
            addCriterion("unit_of_time_total_issue_quantity between", value1, value2, "unitOfTimeTotalIssueQuantity");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeTotalIssueQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("unit_of_time_total_issue_quantity not between", value1, value2, "unitOfTimeTotalIssueQuantity");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeTotalIssuedQuantityIsNull() {
            addCriterion("unit_of_time_total_issued_quantity is null");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeTotalIssuedQuantityIsNotNull() {
            addCriterion("unit_of_time_total_issued_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeTotalIssuedQuantityEqualTo(Integer value) {
            addCriterion("unit_of_time_total_issued_quantity =", value, "unitOfTimeTotalIssuedQuantity");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeTotalIssuedQuantityNotEqualTo(Integer value) {
            addCriterion("unit_of_time_total_issued_quantity <>", value, "unitOfTimeTotalIssuedQuantity");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeTotalIssuedQuantityGreaterThan(Integer value) {
            addCriterion("unit_of_time_total_issued_quantity >", value, "unitOfTimeTotalIssuedQuantity");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeTotalIssuedQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("unit_of_time_total_issued_quantity >=", value, "unitOfTimeTotalIssuedQuantity");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeTotalIssuedQuantityLessThan(Integer value) {
            addCriterion("unit_of_time_total_issued_quantity <", value, "unitOfTimeTotalIssuedQuantity");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeTotalIssuedQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("unit_of_time_total_issued_quantity <=", value, "unitOfTimeTotalIssuedQuantity");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeTotalIssuedQuantityIn(List<Integer> values) {
            addCriterion("unit_of_time_total_issued_quantity in", values, "unitOfTimeTotalIssuedQuantity");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeTotalIssuedQuantityNotIn(List<Integer> values) {
            addCriterion("unit_of_time_total_issued_quantity not in", values, "unitOfTimeTotalIssuedQuantity");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeTotalIssuedQuantityBetween(Integer value1, Integer value2) {
            addCriterion("unit_of_time_total_issued_quantity between", value1, value2, "unitOfTimeTotalIssuedQuantity");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeTotalIssuedQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("unit_of_time_total_issued_quantity not between", value1, value2, "unitOfTimeTotalIssuedQuantity");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeIssueGradientIsNull() {
            addCriterion("unit_of_time_issue_gradient is null");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeIssueGradientIsNotNull() {
            addCriterion("unit_of_time_issue_gradient is not null");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeIssueGradientEqualTo(Integer value) {
            addCriterion("unit_of_time_issue_gradient =", value, "unitOfTimeIssueGradient");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeIssueGradientNotEqualTo(Integer value) {
            addCriterion("unit_of_time_issue_gradient <>", value, "unitOfTimeIssueGradient");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeIssueGradientGreaterThan(Integer value) {
            addCriterion("unit_of_time_issue_gradient >", value, "unitOfTimeIssueGradient");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeIssueGradientGreaterThanOrEqualTo(Integer value) {
            addCriterion("unit_of_time_issue_gradient >=", value, "unitOfTimeIssueGradient");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeIssueGradientLessThan(Integer value) {
            addCriterion("unit_of_time_issue_gradient <", value, "unitOfTimeIssueGradient");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeIssueGradientLessThanOrEqualTo(Integer value) {
            addCriterion("unit_of_time_issue_gradient <=", value, "unitOfTimeIssueGradient");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeIssueGradientIn(List<Integer> values) {
            addCriterion("unit_of_time_issue_gradient in", values, "unitOfTimeIssueGradient");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeIssueGradientNotIn(List<Integer> values) {
            addCriterion("unit_of_time_issue_gradient not in", values, "unitOfTimeIssueGradient");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeIssueGradientBetween(Integer value1, Integer value2) {
            addCriterion("unit_of_time_issue_gradient between", value1, value2, "unitOfTimeIssueGradient");
            return (Criteria) this;
        }

        public Criteria andUnitOfTimeIssueGradientNotBetween(Integer value1, Integer value2) {
            addCriterion("unit_of_time_issue_gradient not between", value1, value2, "unitOfTimeIssueGradient");
            return (Criteria) this;
        }

        public Criteria andLastIssueTimeIsNull() {
            addCriterion("last_issue_time is null");
            return (Criteria) this;
        }

        public Criteria andLastIssueTimeIsNotNull() {
            addCriterion("last_issue_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastIssueTimeEqualTo(Long value) {
            addCriterion("last_issue_time =", value, "lastIssueTime");
            return (Criteria) this;
        }

        public Criteria andLastIssueTimeNotEqualTo(Long value) {
            addCriterion("last_issue_time <>", value, "lastIssueTime");
            return (Criteria) this;
        }

        public Criteria andLastIssueTimeGreaterThan(Long value) {
            addCriterion("last_issue_time >", value, "lastIssueTime");
            return (Criteria) this;
        }

        public Criteria andLastIssueTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("last_issue_time >=", value, "lastIssueTime");
            return (Criteria) this;
        }

        public Criteria andLastIssueTimeLessThan(Long value) {
            addCriterion("last_issue_time <", value, "lastIssueTime");
            return (Criteria) this;
        }

        public Criteria andLastIssueTimeLessThanOrEqualTo(Long value) {
            addCriterion("last_issue_time <=", value, "lastIssueTime");
            return (Criteria) this;
        }

        public Criteria andLastIssueTimeIn(List<Long> values) {
            addCriterion("last_issue_time in", values, "lastIssueTime");
            return (Criteria) this;
        }

        public Criteria andLastIssueTimeNotIn(List<Long> values) {
            addCriterion("last_issue_time not in", values, "lastIssueTime");
            return (Criteria) this;
        }

        public Criteria andLastIssueTimeBetween(Long value1, Long value2) {
            addCriterion("last_issue_time between", value1, value2, "lastIssueTime");
            return (Criteria) this;
        }

        public Criteria andLastIssueTimeNotBetween(Long value1, Long value2) {
            addCriterion("last_issue_time not between", value1, value2, "lastIssueTime");
            return (Criteria) this;
        }

        public Criteria andUserConditionIsNull() {
            addCriterion("user_condition is null");
            return (Criteria) this;
        }

        public Criteria andUserConditionIsNotNull() {
            addCriterion("user_condition is not null");
            return (Criteria) this;
        }

        public Criteria andUserConditionEqualTo(String value) {
            addCriterion("user_condition =", value, "userCondition");
            return (Criteria) this;
        }

        public Criteria andUserConditionNotEqualTo(String value) {
            addCriterion("user_condition <>", value, "userCondition");
            return (Criteria) this;
        }

        public Criteria andUserConditionGreaterThan(String value) {
            addCriterion("user_condition >", value, "userCondition");
            return (Criteria) this;
        }

        public Criteria andUserConditionGreaterThanOrEqualTo(String value) {
            addCriterion("user_condition >=", value, "userCondition");
            return (Criteria) this;
        }

        public Criteria andUserConditionLessThan(String value) {
            addCriterion("user_condition <", value, "userCondition");
            return (Criteria) this;
        }

        public Criteria andUserConditionLessThanOrEqualTo(String value) {
            addCriterion("user_condition <=", value, "userCondition");
            return (Criteria) this;
        }

        public Criteria andUserConditionLike(String value) {
            addCriterion("user_condition like", value, "userCondition");
            return (Criteria) this;
        }

        public Criteria andUserConditionNotLike(String value) {
            addCriterion("user_condition not like", value, "userCondition");
            return (Criteria) this;
        }

        public Criteria andUserConditionIn(List<String> values) {
            addCriterion("user_condition in", values, "userCondition");
            return (Criteria) this;
        }

        public Criteria andUserConditionNotIn(List<String> values) {
            addCriterion("user_condition not in", values, "userCondition");
            return (Criteria) this;
        }

        public Criteria andUserConditionBetween(String value1, String value2) {
            addCriterion("user_condition between", value1, value2, "userCondition");
            return (Criteria) this;
        }

        public Criteria andUserConditionNotBetween(String value1, String value2) {
            addCriterion("user_condition not between", value1, value2, "userCondition");
            return (Criteria) this;
        }

        public Criteria andRepeatTimesIsNull() {
            addCriterion("repeat_times is null");
            return (Criteria) this;
        }

        public Criteria andRepeatTimesIsNotNull() {
            addCriterion("repeat_times is not null");
            return (Criteria) this;
        }

        public Criteria andRepeatTimesEqualTo(Byte value) {
            addCriterion("repeat_times =", value, "repeatTimes");
            return (Criteria) this;
        }

        public Criteria andRepeatTimesNotEqualTo(Byte value) {
            addCriterion("repeat_times <>", value, "repeatTimes");
            return (Criteria) this;
        }

        public Criteria andRepeatTimesGreaterThan(Byte value) {
            addCriterion("repeat_times >", value, "repeatTimes");
            return (Criteria) this;
        }

        public Criteria andRepeatTimesGreaterThanOrEqualTo(Byte value) {
            addCriterion("repeat_times >=", value, "repeatTimes");
            return (Criteria) this;
        }

        public Criteria andRepeatTimesLessThan(Byte value) {
            addCriterion("repeat_times <", value, "repeatTimes");
            return (Criteria) this;
        }

        public Criteria andRepeatTimesLessThanOrEqualTo(Byte value) {
            addCriterion("repeat_times <=", value, "repeatTimes");
            return (Criteria) this;
        }

        public Criteria andRepeatTimesIn(List<Byte> values) {
            addCriterion("repeat_times in", values, "repeatTimes");
            return (Criteria) this;
        }

        public Criteria andRepeatTimesNotIn(List<Byte> values) {
            addCriterion("repeat_times not in", values, "repeatTimes");
            return (Criteria) this;
        }

        public Criteria andRepeatTimesBetween(Byte value1, Byte value2) {
            addCriterion("repeat_times between", value1, value2, "repeatTimes");
            return (Criteria) this;
        }

        public Criteria andRepeatTimesNotBetween(Byte value1, Byte value2) {
            addCriterion("repeat_times not between", value1, value2, "repeatTimes");
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

        public Criteria andShowInCarparkListIsNull() {
            addCriterion("show_in_carpark_list is null");
            return (Criteria) this;
        }

        public Criteria andShowInCarparkListIsNotNull() {
            addCriterion("show_in_carpark_list is not null");
            return (Criteria) this;
        }

        public Criteria andShowInCarparkListEqualTo(Byte value) {
            addCriterion("show_in_carpark_list =", value, "showInCarparkList");
            return (Criteria) this;
        }

        public Criteria andShowInCarparkListNotEqualTo(Byte value) {
            addCriterion("show_in_carpark_list <>", value, "showInCarparkList");
            return (Criteria) this;
        }

        public Criteria andShowInCarparkListGreaterThan(Byte value) {
            addCriterion("show_in_carpark_list >", value, "showInCarparkList");
            return (Criteria) this;
        }

        public Criteria andShowInCarparkListGreaterThanOrEqualTo(Byte value) {
            addCriterion("show_in_carpark_list >=", value, "showInCarparkList");
            return (Criteria) this;
        }

        public Criteria andShowInCarparkListLessThan(Byte value) {
            addCriterion("show_in_carpark_list <", value, "showInCarparkList");
            return (Criteria) this;
        }

        public Criteria andShowInCarparkListLessThanOrEqualTo(Byte value) {
            addCriterion("show_in_carpark_list <=", value, "showInCarparkList");
            return (Criteria) this;
        }

        public Criteria andShowInCarparkListIn(List<Byte> values) {
            addCriterion("show_in_carpark_list in", values, "showInCarparkList");
            return (Criteria) this;
        }

        public Criteria andShowInCarparkListNotIn(List<Byte> values) {
            addCriterion("show_in_carpark_list not in", values, "showInCarparkList");
            return (Criteria) this;
        }

        public Criteria andShowInCarparkListBetween(Byte value1, Byte value2) {
            addCriterion("show_in_carpark_list between", value1, value2, "showInCarparkList");
            return (Criteria) this;
        }

        public Criteria andShowInCarparkListNotBetween(Byte value1, Byte value2) {
            addCriterion("show_in_carpark_list not between", value1, value2, "showInCarparkList");
            return (Criteria) this;
        }

        public Criteria andTotalIssueQuotaIsNull() {
            addCriterion("total_issue_quota is null");
            return (Criteria) this;
        }

        public Criteria andTotalIssueQuotaIsNotNull() {
            addCriterion("total_issue_quota is not null");
            return (Criteria) this;
        }

        public Criteria andTotalIssueQuotaEqualTo(BigDecimal value) {
            addCriterion("total_issue_quota =", value, "totalIssueQuota");
            return (Criteria) this;
        }

        public Criteria andTotalIssueQuotaNotEqualTo(BigDecimal value) {
            addCriterion("total_issue_quota <>", value, "totalIssueQuota");
            return (Criteria) this;
        }

        public Criteria andTotalIssueQuotaGreaterThan(BigDecimal value) {
            addCriterion("total_issue_quota >", value, "totalIssueQuota");
            return (Criteria) this;
        }

        public Criteria andTotalIssueQuotaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_issue_quota >=", value, "totalIssueQuota");
            return (Criteria) this;
        }

        public Criteria andTotalIssueQuotaLessThan(BigDecimal value) {
            addCriterion("total_issue_quota <", value, "totalIssueQuota");
            return (Criteria) this;
        }

        public Criteria andTotalIssueQuotaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_issue_quota <=", value, "totalIssueQuota");
            return (Criteria) this;
        }

        public Criteria andTotalIssueQuotaIn(List<BigDecimal> values) {
            addCriterion("total_issue_quota in", values, "totalIssueQuota");
            return (Criteria) this;
        }

        public Criteria andTotalIssueQuotaNotIn(List<BigDecimal> values) {
            addCriterion("total_issue_quota not in", values, "totalIssueQuota");
            return (Criteria) this;
        }

        public Criteria andTotalIssueQuotaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_issue_quota between", value1, value2, "totalIssueQuota");
            return (Criteria) this;
        }

        public Criteria andTotalIssueQuotaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_issue_quota not between", value1, value2, "totalIssueQuota");
            return (Criteria) this;
        }

        public Criteria andIssuedQuotaIsNull() {
            addCriterion("issued_quota is null");
            return (Criteria) this;
        }

        public Criteria andIssuedQuotaIsNotNull() {
            addCriterion("issued_quota is not null");
            return (Criteria) this;
        }

        public Criteria andIssuedQuotaEqualTo(BigDecimal value) {
            addCriterion("issued_quota =", value, "issuedQuota");
            return (Criteria) this;
        }

        public Criteria andIssuedQuotaNotEqualTo(BigDecimal value) {
            addCriterion("issued_quota <>", value, "issuedQuota");
            return (Criteria) this;
        }

        public Criteria andIssuedQuotaGreaterThan(BigDecimal value) {
            addCriterion("issued_quota >", value, "issuedQuota");
            return (Criteria) this;
        }

        public Criteria andIssuedQuotaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("issued_quota >=", value, "issuedQuota");
            return (Criteria) this;
        }

        public Criteria andIssuedQuotaLessThan(BigDecimal value) {
            addCriterion("issued_quota <", value, "issuedQuota");
            return (Criteria) this;
        }

        public Criteria andIssuedQuotaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("issued_quota <=", value, "issuedQuota");
            return (Criteria) this;
        }

        public Criteria andIssuedQuotaIn(List<BigDecimal> values) {
            addCriterion("issued_quota in", values, "issuedQuota");
            return (Criteria) this;
        }

        public Criteria andIssuedQuotaNotIn(List<BigDecimal> values) {
            addCriterion("issued_quota not in", values, "issuedQuota");
            return (Criteria) this;
        }

        public Criteria andIssuedQuotaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("issued_quota between", value1, value2, "issuedQuota");
            return (Criteria) this;
        }

        public Criteria andIssuedQuotaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("issued_quota not between", value1, value2, "issuedQuota");
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

        public Criteria andRechargeRatioIsNull() {
            addCriterion("recharge_ratio is null");
            return (Criteria) this;
        }

        public Criteria andRechargeRatioIsNotNull() {
            addCriterion("recharge_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andRechargeRatioEqualTo(BigDecimal value) {
            addCriterion("recharge_ratio =", value, "rechargeRatio");
            return (Criteria) this;
        }

        public Criteria andRechargeRatioNotEqualTo(BigDecimal value) {
            addCriterion("recharge_ratio <>", value, "rechargeRatio");
            return (Criteria) this;
        }

        public Criteria andRechargeRatioGreaterThan(BigDecimal value) {
            addCriterion("recharge_ratio >", value, "rechargeRatio");
            return (Criteria) this;
        }

        public Criteria andRechargeRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("recharge_ratio >=", value, "rechargeRatio");
            return (Criteria) this;
        }

        public Criteria andRechargeRatioLessThan(BigDecimal value) {
            addCriterion("recharge_ratio <", value, "rechargeRatio");
            return (Criteria) this;
        }

        public Criteria andRechargeRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("recharge_ratio <=", value, "rechargeRatio");
            return (Criteria) this;
        }

        public Criteria andRechargeRatioIn(List<BigDecimal> values) {
            addCriterion("recharge_ratio in", values, "rechargeRatio");
            return (Criteria) this;
        }

        public Criteria andRechargeRatioNotIn(List<BigDecimal> values) {
            addCriterion("recharge_ratio not in", values, "rechargeRatio");
            return (Criteria) this;
        }

        public Criteria andRechargeRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("recharge_ratio between", value1, value2, "rechargeRatio");
            return (Criteria) this;
        }

        public Criteria andRechargeRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("recharge_ratio not between", value1, value2, "rechargeRatio");
            return (Criteria) this;
        }

        public Criteria andShopkeeperNameIsNull() {
            addCriterion("shopkeeper_name is null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperNameIsNotNull() {
            addCriterion("shopkeeper_name is not null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperNameEqualTo(String value) {
            addCriterion("shopkeeper_name =", value, "shopkeeperName");
            return (Criteria) this;
        }

        public Criteria andShopkeeperNameNotEqualTo(String value) {
            addCriterion("shopkeeper_name <>", value, "shopkeeperName");
            return (Criteria) this;
        }

        public Criteria andShopkeeperNameGreaterThan(String value) {
            addCriterion("shopkeeper_name >", value, "shopkeeperName");
            return (Criteria) this;
        }

        public Criteria andShopkeeperNameGreaterThanOrEqualTo(String value) {
            addCriterion("shopkeeper_name >=", value, "shopkeeperName");
            return (Criteria) this;
        }

        public Criteria andShopkeeperNameLessThan(String value) {
            addCriterion("shopkeeper_name <", value, "shopkeeperName");
            return (Criteria) this;
        }

        public Criteria andShopkeeperNameLessThanOrEqualTo(String value) {
            addCriterion("shopkeeper_name <=", value, "shopkeeperName");
            return (Criteria) this;
        }

        public Criteria andShopkeeperNameLike(String value) {
            addCriterion("shopkeeper_name like", value, "shopkeeperName");
            return (Criteria) this;
        }

        public Criteria andShopkeeperNameNotLike(String value) {
            addCriterion("shopkeeper_name not like", value, "shopkeeperName");
            return (Criteria) this;
        }

        public Criteria andShopkeeperNameIn(List<String> values) {
            addCriterion("shopkeeper_name in", values, "shopkeeperName");
            return (Criteria) this;
        }

        public Criteria andShopkeeperNameNotIn(List<String> values) {
            addCriterion("shopkeeper_name not in", values, "shopkeeperName");
            return (Criteria) this;
        }

        public Criteria andShopkeeperNameBetween(String value1, String value2) {
            addCriterion("shopkeeper_name between", value1, value2, "shopkeeperName");
            return (Criteria) this;
        }

        public Criteria andShopkeeperNameNotBetween(String value1, String value2) {
            addCriterion("shopkeeper_name not between", value1, value2, "shopkeeperName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIsNull() {
            addCriterion("trade_type is null");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIsNotNull() {
            addCriterion("trade_type is not null");
            return (Criteria) this;
        }

        public Criteria andTradeTypeEqualTo(String value) {
            addCriterion("trade_type =", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotEqualTo(String value) {
            addCriterion("trade_type <>", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeGreaterThan(String value) {
            addCriterion("trade_type >", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("trade_type >=", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLessThan(String value) {
            addCriterion("trade_type <", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLessThanOrEqualTo(String value) {
            addCriterion("trade_type <=", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLike(String value) {
            addCriterion("trade_type like", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotLike(String value) {
            addCriterion("trade_type not like", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIn(List<String> values) {
            addCriterion("trade_type in", values, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotIn(List<String> values) {
            addCriterion("trade_type not in", values, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeBetween(String value1, String value2) {
            addCriterion("trade_type between", value1, value2, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotBetween(String value1, String value2) {
            addCriterion("trade_type not between", value1, value2, "tradeType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeIsNull() {
            addCriterion("coupon_type is null");
            return (Criteria) this;
        }

        public Criteria andCouponTypeIsNotNull() {
            addCriterion("coupon_type is not null");
            return (Criteria) this;
        }

        public Criteria andCouponTypeEqualTo(Byte value) {
            addCriterion("coupon_type =", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeNotEqualTo(Byte value) {
            addCriterion("coupon_type <>", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeGreaterThan(Byte value) {
            addCriterion("coupon_type >", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("coupon_type >=", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeLessThan(Byte value) {
            addCriterion("coupon_type <", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeLessThanOrEqualTo(Byte value) {
            addCriterion("coupon_type <=", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeIn(List<Byte> values) {
            addCriterion("coupon_type in", values, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeNotIn(List<Byte> values) {
            addCriterion("coupon_type not in", values, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeBetween(Byte value1, Byte value2) {
            addCriterion("coupon_type between", value1, value2, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("coupon_type not between", value1, value2, "couponType");
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

        public Criteria andAutoGiveAwayQuotaIsNull() {
            addCriterion("auto_give_away_quota is null");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayQuotaIsNotNull() {
            addCriterion("auto_give_away_quota is not null");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayQuotaEqualTo(BigDecimal value) {
            addCriterion("auto_give_away_quota =", value, "autoGiveAwayQuota");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayQuotaNotEqualTo(BigDecimal value) {
            addCriterion("auto_give_away_quota <>", value, "autoGiveAwayQuota");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayQuotaGreaterThan(BigDecimal value) {
            addCriterion("auto_give_away_quota >", value, "autoGiveAwayQuota");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayQuotaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("auto_give_away_quota >=", value, "autoGiveAwayQuota");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayQuotaLessThan(BigDecimal value) {
            addCriterion("auto_give_away_quota <", value, "autoGiveAwayQuota");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayQuotaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("auto_give_away_quota <=", value, "autoGiveAwayQuota");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayQuotaIn(List<BigDecimal> values) {
            addCriterion("auto_give_away_quota in", values, "autoGiveAwayQuota");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayQuotaNotIn(List<BigDecimal> values) {
            addCriterion("auto_give_away_quota not in", values, "autoGiveAwayQuota");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayQuotaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("auto_give_away_quota between", value1, value2, "autoGiveAwayQuota");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayQuotaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("auto_give_away_quota not between", value1, value2, "autoGiveAwayQuota");
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

        public Criteria andAutoGiveAwayOverageQuotaIsNull() {
            addCriterion("auto_give_away_overage_quota is null");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayOverageQuotaIsNotNull() {
            addCriterion("auto_give_away_overage_quota is not null");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayOverageQuotaEqualTo(BigDecimal value) {
            addCriterion("auto_give_away_overage_quota =", value, "autoGiveAwayOverageQuota");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayOverageQuotaNotEqualTo(BigDecimal value) {
            addCriterion("auto_give_away_overage_quota <>", value, "autoGiveAwayOverageQuota");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayOverageQuotaGreaterThan(BigDecimal value) {
            addCriterion("auto_give_away_overage_quota >", value, "autoGiveAwayOverageQuota");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayOverageQuotaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("auto_give_away_overage_quota >=", value, "autoGiveAwayOverageQuota");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayOverageQuotaLessThan(BigDecimal value) {
            addCriterion("auto_give_away_overage_quota <", value, "autoGiveAwayOverageQuota");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayOverageQuotaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("auto_give_away_overage_quota <=", value, "autoGiveAwayOverageQuota");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayOverageQuotaIn(List<BigDecimal> values) {
            addCriterion("auto_give_away_overage_quota in", values, "autoGiveAwayOverageQuota");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayOverageQuotaNotIn(List<BigDecimal> values) {
            addCriterion("auto_give_away_overage_quota not in", values, "autoGiveAwayOverageQuota");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayOverageQuotaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("auto_give_away_overage_quota between", value1, value2, "autoGiveAwayOverageQuota");
            return (Criteria) this;
        }

        public Criteria andAutoGiveAwayOverageQuotaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("auto_give_away_overage_quota not between", value1, value2, "autoGiveAwayOverageQuota");
            return (Criteria) this;
        }

        public Criteria andRemainingTimesIsNull() {
            addCriterion("remaining_times is null");
            return (Criteria) this;
        }

        public Criteria andRemainingTimesIsNotNull() {
            addCriterion("remaining_times is not null");
            return (Criteria) this;
        }

        public Criteria andRemainingTimesEqualTo(Integer value) {
            addCriterion("remaining_times =", value, "remainingTimes");
            return (Criteria) this;
        }

        public Criteria andRemainingTimesNotEqualTo(Integer value) {
            addCriterion("remaining_times <>", value, "remainingTimes");
            return (Criteria) this;
        }

        public Criteria andRemainingTimesGreaterThan(Integer value) {
            addCriterion("remaining_times >", value, "remainingTimes");
            return (Criteria) this;
        }

        public Criteria andRemainingTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("remaining_times >=", value, "remainingTimes");
            return (Criteria) this;
        }

        public Criteria andRemainingTimesLessThan(Integer value) {
            addCriterion("remaining_times <", value, "remainingTimes");
            return (Criteria) this;
        }

        public Criteria andRemainingTimesLessThanOrEqualTo(Integer value) {
            addCriterion("remaining_times <=", value, "remainingTimes");
            return (Criteria) this;
        }

        public Criteria andRemainingTimesIn(List<Integer> values) {
            addCriterion("remaining_times in", values, "remainingTimes");
            return (Criteria) this;
        }

        public Criteria andRemainingTimesNotIn(List<Integer> values) {
            addCriterion("remaining_times not in", values, "remainingTimes");
            return (Criteria) this;
        }

        public Criteria andRemainingTimesBetween(Integer value1, Integer value2) {
            addCriterion("remaining_times between", value1, value2, "remainingTimes");
            return (Criteria) this;
        }

        public Criteria andRemainingTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("remaining_times not between", value1, value2, "remainingTimes");
            return (Criteria) this;
        }

        public Criteria andRemainingTimeIsNull() {
            addCriterion("remaining_time is null");
            return (Criteria) this;
        }

        public Criteria andRemainingTimeIsNotNull() {
            addCriterion("remaining_time is not null");
            return (Criteria) this;
        }

        public Criteria andRemainingTimeEqualTo(Long value) {
            addCriterion("remaining_time =", value, "remainingTime");
            return (Criteria) this;
        }

        public Criteria andRemainingTimeNotEqualTo(Long value) {
            addCriterion("remaining_time <>", value, "remainingTime");
            return (Criteria) this;
        }

        public Criteria andRemainingTimeGreaterThan(Long value) {
            addCriterion("remaining_time >", value, "remainingTime");
            return (Criteria) this;
        }

        public Criteria andRemainingTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("remaining_time >=", value, "remainingTime");
            return (Criteria) this;
        }

        public Criteria andRemainingTimeLessThan(Long value) {
            addCriterion("remaining_time <", value, "remainingTime");
            return (Criteria) this;
        }

        public Criteria andRemainingTimeLessThanOrEqualTo(Long value) {
            addCriterion("remaining_time <=", value, "remainingTime");
            return (Criteria) this;
        }

        public Criteria andRemainingTimeIn(List<Long> values) {
            addCriterion("remaining_time in", values, "remainingTime");
            return (Criteria) this;
        }

        public Criteria andRemainingTimeNotIn(List<Long> values) {
            addCriterion("remaining_time not in", values, "remainingTime");
            return (Criteria) this;
        }

        public Criteria andRemainingTimeBetween(Long value1, Long value2) {
            addCriterion("remaining_time between", value1, value2, "remainingTime");
            return (Criteria) this;
        }

        public Criteria andRemainingTimeNotBetween(Long value1, Long value2) {
            addCriterion("remaining_time not between", value1, value2, "remainingTime");
            return (Criteria) this;
        }

        public Criteria andTimesCouponPriceIsNull() {
            addCriterion("times_coupon_price is null");
            return (Criteria) this;
        }

        public Criteria andTimesCouponPriceIsNotNull() {
            addCriterion("times_coupon_price is not null");
            return (Criteria) this;
        }

        public Criteria andTimesCouponPriceEqualTo(BigDecimal value) {
            addCriterion("times_coupon_price =", value, "timesCouponPrice");
            return (Criteria) this;
        }

        public Criteria andTimesCouponPriceNotEqualTo(BigDecimal value) {
            addCriterion("times_coupon_price <>", value, "timesCouponPrice");
            return (Criteria) this;
        }

        public Criteria andTimesCouponPriceGreaterThan(BigDecimal value) {
            addCriterion("times_coupon_price >", value, "timesCouponPrice");
            return (Criteria) this;
        }

        public Criteria andTimesCouponPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("times_coupon_price >=", value, "timesCouponPrice");
            return (Criteria) this;
        }

        public Criteria andTimesCouponPriceLessThan(BigDecimal value) {
            addCriterion("times_coupon_price <", value, "timesCouponPrice");
            return (Criteria) this;
        }

        public Criteria andTimesCouponPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("times_coupon_price <=", value, "timesCouponPrice");
            return (Criteria) this;
        }

        public Criteria andTimesCouponPriceIn(List<BigDecimal> values) {
            addCriterion("times_coupon_price in", values, "timesCouponPrice");
            return (Criteria) this;
        }

        public Criteria andTimesCouponPriceNotIn(List<BigDecimal> values) {
            addCriterion("times_coupon_price not in", values, "timesCouponPrice");
            return (Criteria) this;
        }

        public Criteria andTimesCouponPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("times_coupon_price between", value1, value2, "timesCouponPrice");
            return (Criteria) this;
        }

        public Criteria andTimesCouponPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("times_coupon_price not between", value1, value2, "timesCouponPrice");
            return (Criteria) this;
        }

        public Criteria andTimeCouponPriceIsNull() {
            addCriterion("time_coupon_price is null");
            return (Criteria) this;
        }

        public Criteria andTimeCouponPriceIsNotNull() {
            addCriterion("time_coupon_price is not null");
            return (Criteria) this;
        }

        public Criteria andTimeCouponPriceEqualTo(BigDecimal value) {
            addCriterion("time_coupon_price =", value, "timeCouponPrice");
            return (Criteria) this;
        }

        public Criteria andTimeCouponPriceNotEqualTo(BigDecimal value) {
            addCriterion("time_coupon_price <>", value, "timeCouponPrice");
            return (Criteria) this;
        }

        public Criteria andTimeCouponPriceGreaterThan(BigDecimal value) {
            addCriterion("time_coupon_price >", value, "timeCouponPrice");
            return (Criteria) this;
        }

        public Criteria andTimeCouponPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("time_coupon_price >=", value, "timeCouponPrice");
            return (Criteria) this;
        }

        public Criteria andTimeCouponPriceLessThan(BigDecimal value) {
            addCriterion("time_coupon_price <", value, "timeCouponPrice");
            return (Criteria) this;
        }

        public Criteria andTimeCouponPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("time_coupon_price <=", value, "timeCouponPrice");
            return (Criteria) this;
        }

        public Criteria andTimeCouponPriceIn(List<BigDecimal> values) {
            addCriterion("time_coupon_price in", values, "timeCouponPrice");
            return (Criteria) this;
        }

        public Criteria andTimeCouponPriceNotIn(List<BigDecimal> values) {
            addCriterion("time_coupon_price not in", values, "timeCouponPrice");
            return (Criteria) this;
        }

        public Criteria andTimeCouponPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("time_coupon_price between", value1, value2, "timeCouponPrice");
            return (Criteria) this;
        }

        public Criteria andTimeCouponPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("time_coupon_price not between", value1, value2, "timeCouponPrice");
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