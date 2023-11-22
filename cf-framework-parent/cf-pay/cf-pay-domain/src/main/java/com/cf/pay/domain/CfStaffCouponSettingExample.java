package com.cf.pay.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CfStaffCouponSettingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfStaffCouponSettingExample() {
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

        public Criteria andSameDayQuotaIsNull() {
            addCriterion("same_day_quota is null");
            return (Criteria) this;
        }

        public Criteria andSameDayQuotaIsNotNull() {
            addCriterion("same_day_quota is not null");
            return (Criteria) this;
        }

        public Criteria andSameDayQuotaEqualTo(BigDecimal value) {
            addCriterion("same_day_quota =", value, "sameDayQuota");
            return (Criteria) this;
        }

        public Criteria andSameDayQuotaNotEqualTo(BigDecimal value) {
            addCriterion("same_day_quota <>", value, "sameDayQuota");
            return (Criteria) this;
        }

        public Criteria andSameDayQuotaGreaterThan(BigDecimal value) {
            addCriterion("same_day_quota >", value, "sameDayQuota");
            return (Criteria) this;
        }

        public Criteria andSameDayQuotaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("same_day_quota >=", value, "sameDayQuota");
            return (Criteria) this;
        }

        public Criteria andSameDayQuotaLessThan(BigDecimal value) {
            addCriterion("same_day_quota <", value, "sameDayQuota");
            return (Criteria) this;
        }

        public Criteria andSameDayQuotaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("same_day_quota <=", value, "sameDayQuota");
            return (Criteria) this;
        }

        public Criteria andSameDayQuotaIn(List<BigDecimal> values) {
            addCriterion("same_day_quota in", values, "sameDayQuota");
            return (Criteria) this;
        }

        public Criteria andSameDayQuotaNotIn(List<BigDecimal> values) {
            addCriterion("same_day_quota not in", values, "sameDayQuota");
            return (Criteria) this;
        }

        public Criteria andSameDayQuotaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("same_day_quota between", value1, value2, "sameDayQuota");
            return (Criteria) this;
        }

        public Criteria andSameDayQuotaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("same_day_quota not between", value1, value2, "sameDayQuota");
            return (Criteria) this;
        }

        public Criteria andStaffIdIsNull() {
            addCriterion("staff_id is null");
            return (Criteria) this;
        }

        public Criteria andStaffIdIsNotNull() {
            addCriterion("staff_id is not null");
            return (Criteria) this;
        }

        public Criteria andStaffIdEqualTo(String value) {
            addCriterion("staff_id =", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotEqualTo(String value) {
            addCriterion("staff_id <>", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThan(String value) {
            addCriterion("staff_id >", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("staff_id >=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThan(String value) {
            addCriterion("staff_id <", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThanOrEqualTo(String value) {
            addCriterion("staff_id <=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLike(String value) {
            addCriterion("staff_id like", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotLike(String value) {
            addCriterion("staff_id not like", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdIn(List<String> values) {
            addCriterion("staff_id in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotIn(List<String> values) {
            addCriterion("staff_id not in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdBetween(String value1, String value2) {
            addCriterion("staff_id between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotBetween(String value1, String value2) {
            addCriterion("staff_id not between", value1, value2, "staffId");
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