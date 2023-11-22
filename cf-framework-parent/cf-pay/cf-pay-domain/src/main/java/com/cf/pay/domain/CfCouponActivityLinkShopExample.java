package com.cf.pay.domain;

import java.util.ArrayList;
import java.util.List;

public class CfCouponActivityLinkShopExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfCouponActivityLinkShopExample() {
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

        public Criteria andShopIdIsNull() {
            addCriterion("shop_id is null");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNotNull() {
            addCriterion("shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopIdEqualTo(String value) {
            addCriterion("shop_id =", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotEqualTo(String value) {
            addCriterion("shop_id <>", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThan(String value) {
            addCriterion("shop_id >", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(String value) {
            addCriterion("shop_id >=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThan(String value) {
            addCriterion("shop_id <", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThanOrEqualTo(String value) {
            addCriterion("shop_id <=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLike(String value) {
            addCriterion("shop_id like", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotLike(String value) {
            addCriterion("shop_id not like", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdIn(List<String> values) {
            addCriterion("shop_id in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotIn(List<String> values) {
            addCriterion("shop_id not in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdBetween(String value1, String value2) {
            addCriterion("shop_id between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotBetween(String value1, String value2) {
            addCriterion("shop_id not between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andSceneIsNull() {
            addCriterion("scene is null");
            return (Criteria) this;
        }

        public Criteria andSceneIsNotNull() {
            addCriterion("scene is not null");
            return (Criteria) this;
        }

        public Criteria andSceneEqualTo(String value) {
            addCriterion("scene =", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneNotEqualTo(String value) {
            addCriterion("scene <>", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneGreaterThan(String value) {
            addCriterion("scene >", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneGreaterThanOrEqualTo(String value) {
            addCriterion("scene >=", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneLessThan(String value) {
            addCriterion("scene <", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneLessThanOrEqualTo(String value) {
            addCriterion("scene <=", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneLike(String value) {
            addCriterion("scene like", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneNotLike(String value) {
            addCriterion("scene not like", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneIn(List<String> values) {
            addCriterion("scene in", values, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneNotIn(List<String> values) {
            addCriterion("scene not in", values, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneBetween(String value1, String value2) {
            addCriterion("scene between", value1, value2, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneNotBetween(String value1, String value2) {
            addCriterion("scene not between", value1, value2, "scene");
            return (Criteria) this;
        }

        public Criteria andMainShopIsNull() {
            addCriterion("main_shop is null");
            return (Criteria) this;
        }

        public Criteria andMainShopIsNotNull() {
            addCriterion("main_shop is not null");
            return (Criteria) this;
        }

        public Criteria andMainShopEqualTo(Byte value) {
            addCriterion("main_shop =", value, "mainShop");
            return (Criteria) this;
        }

        public Criteria andMainShopNotEqualTo(Byte value) {
            addCriterion("main_shop <>", value, "mainShop");
            return (Criteria) this;
        }

        public Criteria andMainShopGreaterThan(Byte value) {
            addCriterion("main_shop >", value, "mainShop");
            return (Criteria) this;
        }

        public Criteria andMainShopGreaterThanOrEqualTo(Byte value) {
            addCriterion("main_shop >=", value, "mainShop");
            return (Criteria) this;
        }

        public Criteria andMainShopLessThan(Byte value) {
            addCriterion("main_shop <", value, "mainShop");
            return (Criteria) this;
        }

        public Criteria andMainShopLessThanOrEqualTo(Byte value) {
            addCriterion("main_shop <=", value, "mainShop");
            return (Criteria) this;
        }

        public Criteria andMainShopIn(List<Byte> values) {
            addCriterion("main_shop in", values, "mainShop");
            return (Criteria) this;
        }

        public Criteria andMainShopNotIn(List<Byte> values) {
            addCriterion("main_shop not in", values, "mainShop");
            return (Criteria) this;
        }

        public Criteria andMainShopBetween(Byte value1, Byte value2) {
            addCriterion("main_shop between", value1, value2, "mainShop");
            return (Criteria) this;
        }

        public Criteria andMainShopNotBetween(Byte value1, Byte value2) {
            addCriterion("main_shop not between", value1, value2, "mainShop");
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