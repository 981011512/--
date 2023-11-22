package com.cf.ucenter.domain;

import java.util.ArrayList;
import java.util.List;

public class CfThirdPartySystemCallKeysExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfThirdPartySystemCallKeysExample() {
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

        public Criteria andKeyIdIsNull() {
            addCriterion("key_id is null");
            return (Criteria) this;
        }

        public Criteria andKeyIdIsNotNull() {
            addCriterion("key_id is not null");
            return (Criteria) this;
        }

        public Criteria andKeyIdEqualTo(Long value) {
            addCriterion("key_id =", value, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdNotEqualTo(Long value) {
            addCriterion("key_id <>", value, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdGreaterThan(Long value) {
            addCriterion("key_id >", value, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("key_id >=", value, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdLessThan(Long value) {
            addCriterion("key_id <", value, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdLessThanOrEqualTo(Long value) {
            addCriterion("key_id <=", value, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdIn(List<Long> values) {
            addCriterion("key_id in", values, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdNotIn(List<Long> values) {
            addCriterion("key_id not in", values, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdBetween(Long value1, Long value2) {
            addCriterion("key_id between", value1, value2, "keyId");
            return (Criteria) this;
        }

        public Criteria andKeyIdNotBetween(Long value1, Long value2) {
            addCriterion("key_id not between", value1, value2, "keyId");
            return (Criteria) this;
        }

        public Criteria andUseScenesIsNull() {
            addCriterion("use_scenes is null");
            return (Criteria) this;
        }

        public Criteria andUseScenesIsNotNull() {
            addCriterion("use_scenes is not null");
            return (Criteria) this;
        }

        public Criteria andUseScenesEqualTo(String value) {
            addCriterion("use_scenes =", value, "useScenes");
            return (Criteria) this;
        }

        public Criteria andUseScenesNotEqualTo(String value) {
            addCriterion("use_scenes <>", value, "useScenes");
            return (Criteria) this;
        }

        public Criteria andUseScenesGreaterThan(String value) {
            addCriterion("use_scenes >", value, "useScenes");
            return (Criteria) this;
        }

        public Criteria andUseScenesGreaterThanOrEqualTo(String value) {
            addCriterion("use_scenes >=", value, "useScenes");
            return (Criteria) this;
        }

        public Criteria andUseScenesLessThan(String value) {
            addCriterion("use_scenes <", value, "useScenes");
            return (Criteria) this;
        }

        public Criteria andUseScenesLessThanOrEqualTo(String value) {
            addCriterion("use_scenes <=", value, "useScenes");
            return (Criteria) this;
        }

        public Criteria andUseScenesLike(String value) {
            addCriterion("use_scenes like", value, "useScenes");
            return (Criteria) this;
        }

        public Criteria andUseScenesNotLike(String value) {
            addCriterion("use_scenes not like", value, "useScenes");
            return (Criteria) this;
        }

        public Criteria andUseScenesIn(List<String> values) {
            addCriterion("use_scenes in", values, "useScenes");
            return (Criteria) this;
        }

        public Criteria andUseScenesNotIn(List<String> values) {
            addCriterion("use_scenes not in", values, "useScenes");
            return (Criteria) this;
        }

        public Criteria andUseScenesBetween(String value1, String value2) {
            addCriterion("use_scenes between", value1, value2, "useScenes");
            return (Criteria) this;
        }

        public Criteria andUseScenesNotBetween(String value1, String value2) {
            addCriterion("use_scenes not between", value1, value2, "useScenes");
            return (Criteria) this;
        }

        public Criteria andKeyValueIsNull() {
            addCriterion("key_value is null");
            return (Criteria) this;
        }

        public Criteria andKeyValueIsNotNull() {
            addCriterion("key_value is not null");
            return (Criteria) this;
        }

        public Criteria andKeyValueEqualTo(String value) {
            addCriterion("key_value =", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueNotEqualTo(String value) {
            addCriterion("key_value <>", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueGreaterThan(String value) {
            addCriterion("key_value >", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueGreaterThanOrEqualTo(String value) {
            addCriterion("key_value >=", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueLessThan(String value) {
            addCriterion("key_value <", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueLessThanOrEqualTo(String value) {
            addCriterion("key_value <=", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueLike(String value) {
            addCriterion("key_value like", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueNotLike(String value) {
            addCriterion("key_value not like", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueIn(List<String> values) {
            addCriterion("key_value in", values, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueNotIn(List<String> values) {
            addCriterion("key_value not in", values, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueBetween(String value1, String value2) {
            addCriterion("key_value between", value1, value2, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueNotBetween(String value1, String value2) {
            addCriterion("key_value not between", value1, value2, "keyValue");
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

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andKeyNotesIsNull() {
            addCriterion("key_notes is null");
            return (Criteria) this;
        }

        public Criteria andKeyNotesIsNotNull() {
            addCriterion("key_notes is not null");
            return (Criteria) this;
        }

        public Criteria andKeyNotesEqualTo(String value) {
            addCriterion("key_notes =", value, "keyNotes");
            return (Criteria) this;
        }

        public Criteria andKeyNotesNotEqualTo(String value) {
            addCriterion("key_notes <>", value, "keyNotes");
            return (Criteria) this;
        }

        public Criteria andKeyNotesGreaterThan(String value) {
            addCriterion("key_notes >", value, "keyNotes");
            return (Criteria) this;
        }

        public Criteria andKeyNotesGreaterThanOrEqualTo(String value) {
            addCriterion("key_notes >=", value, "keyNotes");
            return (Criteria) this;
        }

        public Criteria andKeyNotesLessThan(String value) {
            addCriterion("key_notes <", value, "keyNotes");
            return (Criteria) this;
        }

        public Criteria andKeyNotesLessThanOrEqualTo(String value) {
            addCriterion("key_notes <=", value, "keyNotes");
            return (Criteria) this;
        }

        public Criteria andKeyNotesLike(String value) {
            addCriterion("key_notes like", value, "keyNotes");
            return (Criteria) this;
        }

        public Criteria andKeyNotesNotLike(String value) {
            addCriterion("key_notes not like", value, "keyNotes");
            return (Criteria) this;
        }

        public Criteria andKeyNotesIn(List<String> values) {
            addCriterion("key_notes in", values, "keyNotes");
            return (Criteria) this;
        }

        public Criteria andKeyNotesNotIn(List<String> values) {
            addCriterion("key_notes not in", values, "keyNotes");
            return (Criteria) this;
        }

        public Criteria andKeyNotesBetween(String value1, String value2) {
            addCriterion("key_notes between", value1, value2, "keyNotes");
            return (Criteria) this;
        }

        public Criteria andKeyNotesNotBetween(String value1, String value2) {
            addCriterion("key_notes not between", value1, value2, "keyNotes");
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