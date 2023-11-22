package com.cf.pay.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CfCouponActivityCouponTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfCouponActivityCouponTypeExample() {
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

        public Criteria andCouponActivityIdIsNull() {
            addCriterion("coupon_activity_id is null");
            return (Criteria) this;
        }

        public Criteria andCouponActivityIdIsNotNull() {
            addCriterion("coupon_activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andCouponActivityIdEqualTo(String value) {
            addCriterion("coupon_activity_id =", value, "couponActivityId");
            return (Criteria) this;
        }

        public Criteria andCouponActivityIdNotEqualTo(String value) {
            addCriterion("coupon_activity_id <>", value, "couponActivityId");
            return (Criteria) this;
        }

        public Criteria andCouponActivityIdGreaterThan(String value) {
            addCriterion("coupon_activity_id >", value, "couponActivityId");
            return (Criteria) this;
        }

        public Criteria andCouponActivityIdGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_activity_id >=", value, "couponActivityId");
            return (Criteria) this;
        }

        public Criteria andCouponActivityIdLessThan(String value) {
            addCriterion("coupon_activity_id <", value, "couponActivityId");
            return (Criteria) this;
        }

        public Criteria andCouponActivityIdLessThanOrEqualTo(String value) {
            addCriterion("coupon_activity_id <=", value, "couponActivityId");
            return (Criteria) this;
        }

        public Criteria andCouponActivityIdLike(String value) {
            addCriterion("coupon_activity_id like", value, "couponActivityId");
            return (Criteria) this;
        }

        public Criteria andCouponActivityIdNotLike(String value) {
            addCriterion("coupon_activity_id not like", value, "couponActivityId");
            return (Criteria) this;
        }

        public Criteria andCouponActivityIdIn(List<String> values) {
            addCriterion("coupon_activity_id in", values, "couponActivityId");
            return (Criteria) this;
        }

        public Criteria andCouponActivityIdNotIn(List<String> values) {
            addCriterion("coupon_activity_id not in", values, "couponActivityId");
            return (Criteria) this;
        }

        public Criteria andCouponActivityIdBetween(String value1, String value2) {
            addCriterion("coupon_activity_id between", value1, value2, "couponActivityId");
            return (Criteria) this;
        }

        public Criteria andCouponActivityIdNotBetween(String value1, String value2) {
            addCriterion("coupon_activity_id not between", value1, value2, "couponActivityId");
            return (Criteria) this;
        }

        public Criteria andFixedExtensionTimeIsNull() {
            addCriterion("fixed_extension_time is null");
            return (Criteria) this;
        }

        public Criteria andFixedExtensionTimeIsNotNull() {
            addCriterion("fixed_extension_time is not null");
            return (Criteria) this;
        }

        public Criteria andFixedExtensionTimeEqualTo(Long value) {
            addCriterion("fixed_extension_time =", value, "fixedExtensionTime");
            return (Criteria) this;
        }

        public Criteria andFixedExtensionTimeNotEqualTo(Long value) {
            addCriterion("fixed_extension_time <>", value, "fixedExtensionTime");
            return (Criteria) this;
        }

        public Criteria andFixedExtensionTimeGreaterThan(Long value) {
            addCriterion("fixed_extension_time >", value, "fixedExtensionTime");
            return (Criteria) this;
        }

        public Criteria andFixedExtensionTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("fixed_extension_time >=", value, "fixedExtensionTime");
            return (Criteria) this;
        }

        public Criteria andFixedExtensionTimeLessThan(Long value) {
            addCriterion("fixed_extension_time <", value, "fixedExtensionTime");
            return (Criteria) this;
        }

        public Criteria andFixedExtensionTimeLessThanOrEqualTo(Long value) {
            addCriterion("fixed_extension_time <=", value, "fixedExtensionTime");
            return (Criteria) this;
        }

        public Criteria andFixedExtensionTimeIn(List<Long> values) {
            addCriterion("fixed_extension_time in", values, "fixedExtensionTime");
            return (Criteria) this;
        }

        public Criteria andFixedExtensionTimeNotIn(List<Long> values) {
            addCriterion("fixed_extension_time not in", values, "fixedExtensionTime");
            return (Criteria) this;
        }

        public Criteria andFixedExtensionTimeBetween(Long value1, Long value2) {
            addCriterion("fixed_extension_time between", value1, value2, "fixedExtensionTime");
            return (Criteria) this;
        }

        public Criteria andFixedExtensionTimeNotBetween(Long value1, Long value2) {
            addCriterion("fixed_extension_time not between", value1, value2, "fixedExtensionTime");
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

        public Criteria andRequireUsingIsNull() {
            addCriterion("require_using is null");
            return (Criteria) this;
        }

        public Criteria andRequireUsingIsNotNull() {
            addCriterion("require_using is not null");
            return (Criteria) this;
        }

        public Criteria andRequireUsingEqualTo(Byte value) {
            addCriterion("require_using =", value, "requireUsing");
            return (Criteria) this;
        }

        public Criteria andRequireUsingNotEqualTo(Byte value) {
            addCriterion("require_using <>", value, "requireUsing");
            return (Criteria) this;
        }

        public Criteria andRequireUsingGreaterThan(Byte value) {
            addCriterion("require_using >", value, "requireUsing");
            return (Criteria) this;
        }

        public Criteria andRequireUsingGreaterThanOrEqualTo(Byte value) {
            addCriterion("require_using >=", value, "requireUsing");
            return (Criteria) this;
        }

        public Criteria andRequireUsingLessThan(Byte value) {
            addCriterion("require_using <", value, "requireUsing");
            return (Criteria) this;
        }

        public Criteria andRequireUsingLessThanOrEqualTo(Byte value) {
            addCriterion("require_using <=", value, "requireUsing");
            return (Criteria) this;
        }

        public Criteria andRequireUsingIn(List<Byte> values) {
            addCriterion("require_using in", values, "requireUsing");
            return (Criteria) this;
        }

        public Criteria andRequireUsingNotIn(List<Byte> values) {
            addCriterion("require_using not in", values, "requireUsing");
            return (Criteria) this;
        }

        public Criteria andRequireUsingBetween(Byte value1, Byte value2) {
            addCriterion("require_using between", value1, value2, "requireUsing");
            return (Criteria) this;
        }

        public Criteria andRequireUsingNotBetween(Byte value1, Byte value2) {
            addCriterion("require_using not between", value1, value2, "requireUsing");
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