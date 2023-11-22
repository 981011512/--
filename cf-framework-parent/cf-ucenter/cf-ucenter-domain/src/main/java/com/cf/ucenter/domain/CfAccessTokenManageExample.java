package com.cf.ucenter.domain;

import java.util.ArrayList;
import java.util.List;

public class CfAccessTokenManageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfAccessTokenManageExample() {
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

        public Criteria andAppidIsNull() {
            addCriterion("appid is null");
            return (Criteria) this;
        }

        public Criteria andAppidIsNotNull() {
            addCriterion("appid is not null");
            return (Criteria) this;
        }

        public Criteria andAppidEqualTo(String value) {
            addCriterion("appid =", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotEqualTo(String value) {
            addCriterion("appid <>", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThan(String value) {
            addCriterion("appid >", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThanOrEqualTo(String value) {
            addCriterion("appid >=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThan(String value) {
            addCriterion("appid <", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThanOrEqualTo(String value) {
            addCriterion("appid <=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLike(String value) {
            addCriterion("appid like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotLike(String value) {
            addCriterion("appid not like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidIn(List<String> values) {
            addCriterion("appid in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotIn(List<String> values) {
            addCriterion("appid not in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidBetween(String value1, String value2) {
            addCriterion("appid between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotBetween(String value1, String value2) {
            addCriterion("appid not between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andTokenValueIsNull() {
            addCriterion("token_value is null");
            return (Criteria) this;
        }

        public Criteria andTokenValueIsNotNull() {
            addCriterion("token_value is not null");
            return (Criteria) this;
        }

        public Criteria andTokenValueEqualTo(String value) {
            addCriterion("token_value =", value, "tokenValue");
            return (Criteria) this;
        }

        public Criteria andTokenValueNotEqualTo(String value) {
            addCriterion("token_value <>", value, "tokenValue");
            return (Criteria) this;
        }

        public Criteria andTokenValueGreaterThan(String value) {
            addCriterion("token_value >", value, "tokenValue");
            return (Criteria) this;
        }

        public Criteria andTokenValueGreaterThanOrEqualTo(String value) {
            addCriterion("token_value >=", value, "tokenValue");
            return (Criteria) this;
        }

        public Criteria andTokenValueLessThan(String value) {
            addCriterion("token_value <", value, "tokenValue");
            return (Criteria) this;
        }

        public Criteria andTokenValueLessThanOrEqualTo(String value) {
            addCriterion("token_value <=", value, "tokenValue");
            return (Criteria) this;
        }

        public Criteria andTokenValueLike(String value) {
            addCriterion("token_value like", value, "tokenValue");
            return (Criteria) this;
        }

        public Criteria andTokenValueNotLike(String value) {
            addCriterion("token_value not like", value, "tokenValue");
            return (Criteria) this;
        }

        public Criteria andTokenValueIn(List<String> values) {
            addCriterion("token_value in", values, "tokenValue");
            return (Criteria) this;
        }

        public Criteria andTokenValueNotIn(List<String> values) {
            addCriterion("token_value not in", values, "tokenValue");
            return (Criteria) this;
        }

        public Criteria andTokenValueBetween(String value1, String value2) {
            addCriterion("token_value between", value1, value2, "tokenValue");
            return (Criteria) this;
        }

        public Criteria andTokenValueNotBetween(String value1, String value2) {
            addCriterion("token_value not between", value1, value2, "tokenValue");
            return (Criteria) this;
        }

        public Criteria andApplicationScenesIsNull() {
            addCriterion("application_scenes is null");
            return (Criteria) this;
        }

        public Criteria andApplicationScenesIsNotNull() {
            addCriterion("application_scenes is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationScenesEqualTo(String value) {
            addCriterion("application_scenes =", value, "applicationScenes");
            return (Criteria) this;
        }

        public Criteria andApplicationScenesNotEqualTo(String value) {
            addCriterion("application_scenes <>", value, "applicationScenes");
            return (Criteria) this;
        }

        public Criteria andApplicationScenesGreaterThan(String value) {
            addCriterion("application_scenes >", value, "applicationScenes");
            return (Criteria) this;
        }

        public Criteria andApplicationScenesGreaterThanOrEqualTo(String value) {
            addCriterion("application_scenes >=", value, "applicationScenes");
            return (Criteria) this;
        }

        public Criteria andApplicationScenesLessThan(String value) {
            addCriterion("application_scenes <", value, "applicationScenes");
            return (Criteria) this;
        }

        public Criteria andApplicationScenesLessThanOrEqualTo(String value) {
            addCriterion("application_scenes <=", value, "applicationScenes");
            return (Criteria) this;
        }

        public Criteria andApplicationScenesLike(String value) {
            addCriterion("application_scenes like", value, "applicationScenes");
            return (Criteria) this;
        }

        public Criteria andApplicationScenesNotLike(String value) {
            addCriterion("application_scenes not like", value, "applicationScenes");
            return (Criteria) this;
        }

        public Criteria andApplicationScenesIn(List<String> values) {
            addCriterion("application_scenes in", values, "applicationScenes");
            return (Criteria) this;
        }

        public Criteria andApplicationScenesNotIn(List<String> values) {
            addCriterion("application_scenes not in", values, "applicationScenes");
            return (Criteria) this;
        }

        public Criteria andApplicationScenesBetween(String value1, String value2) {
            addCriterion("application_scenes between", value1, value2, "applicationScenes");
            return (Criteria) this;
        }

        public Criteria andApplicationScenesNotBetween(String value1, String value2) {
            addCriterion("application_scenes not between", value1, value2, "applicationScenes");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeIsNull() {
            addCriterion("expired_time is null");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeIsNotNull() {
            addCriterion("expired_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeEqualTo(Long value) {
            addCriterion("expired_time =", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeNotEqualTo(Long value) {
            addCriterion("expired_time <>", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeGreaterThan(Long value) {
            addCriterion("expired_time >", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("expired_time >=", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeLessThan(Long value) {
            addCriterion("expired_time <", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeLessThanOrEqualTo(Long value) {
            addCriterion("expired_time <=", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeIn(List<Long> values) {
            addCriterion("expired_time in", values, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeNotIn(List<Long> values) {
            addCriterion("expired_time not in", values, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeBetween(Long value1, Long value2) {
            addCriterion("expired_time between", value1, value2, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeNotBetween(Long value1, Long value2) {
            addCriterion("expired_time not between", value1, value2, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andTokenNotesIsNull() {
            addCriterion("token_notes is null");
            return (Criteria) this;
        }

        public Criteria andTokenNotesIsNotNull() {
            addCriterion("token_notes is not null");
            return (Criteria) this;
        }

        public Criteria andTokenNotesEqualTo(String value) {
            addCriterion("token_notes =", value, "tokenNotes");
            return (Criteria) this;
        }

        public Criteria andTokenNotesNotEqualTo(String value) {
            addCriterion("token_notes <>", value, "tokenNotes");
            return (Criteria) this;
        }

        public Criteria andTokenNotesGreaterThan(String value) {
            addCriterion("token_notes >", value, "tokenNotes");
            return (Criteria) this;
        }

        public Criteria andTokenNotesGreaterThanOrEqualTo(String value) {
            addCriterion("token_notes >=", value, "tokenNotes");
            return (Criteria) this;
        }

        public Criteria andTokenNotesLessThan(String value) {
            addCriterion("token_notes <", value, "tokenNotes");
            return (Criteria) this;
        }

        public Criteria andTokenNotesLessThanOrEqualTo(String value) {
            addCriterion("token_notes <=", value, "tokenNotes");
            return (Criteria) this;
        }

        public Criteria andTokenNotesLike(String value) {
            addCriterion("token_notes like", value, "tokenNotes");
            return (Criteria) this;
        }

        public Criteria andTokenNotesNotLike(String value) {
            addCriterion("token_notes not like", value, "tokenNotes");
            return (Criteria) this;
        }

        public Criteria andTokenNotesIn(List<String> values) {
            addCriterion("token_notes in", values, "tokenNotes");
            return (Criteria) this;
        }

        public Criteria andTokenNotesNotIn(List<String> values) {
            addCriterion("token_notes not in", values, "tokenNotes");
            return (Criteria) this;
        }

        public Criteria andTokenNotesBetween(String value1, String value2) {
            addCriterion("token_notes between", value1, value2, "tokenNotes");
            return (Criteria) this;
        }

        public Criteria andTokenNotesNotBetween(String value1, String value2) {
            addCriterion("token_notes not between", value1, value2, "tokenNotes");
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