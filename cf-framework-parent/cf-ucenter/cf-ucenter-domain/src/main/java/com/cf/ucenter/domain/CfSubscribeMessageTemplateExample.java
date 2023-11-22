package com.cf.ucenter.domain;

import java.util.ArrayList;
import java.util.List;

public class CfSubscribeMessageTemplateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfSubscribeMessageTemplateExample() {
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

        public Criteria andMessageScenesIsNull() {
            addCriterion("message_scenes is null");
            return (Criteria) this;
        }

        public Criteria andMessageScenesIsNotNull() {
            addCriterion("message_scenes is not null");
            return (Criteria) this;
        }

        public Criteria andMessageScenesEqualTo(String value) {
            addCriterion("message_scenes =", value, "messageScenes");
            return (Criteria) this;
        }

        public Criteria andMessageScenesNotEqualTo(String value) {
            addCriterion("message_scenes <>", value, "messageScenes");
            return (Criteria) this;
        }

        public Criteria andMessageScenesGreaterThan(String value) {
            addCriterion("message_scenes >", value, "messageScenes");
            return (Criteria) this;
        }

        public Criteria andMessageScenesGreaterThanOrEqualTo(String value) {
            addCriterion("message_scenes >=", value, "messageScenes");
            return (Criteria) this;
        }

        public Criteria andMessageScenesLessThan(String value) {
            addCriterion("message_scenes <", value, "messageScenes");
            return (Criteria) this;
        }

        public Criteria andMessageScenesLessThanOrEqualTo(String value) {
            addCriterion("message_scenes <=", value, "messageScenes");
            return (Criteria) this;
        }

        public Criteria andMessageScenesLike(String value) {
            addCriterion("message_scenes like", value, "messageScenes");
            return (Criteria) this;
        }

        public Criteria andMessageScenesNotLike(String value) {
            addCriterion("message_scenes not like", value, "messageScenes");
            return (Criteria) this;
        }

        public Criteria andMessageScenesIn(List<String> values) {
            addCriterion("message_scenes in", values, "messageScenes");
            return (Criteria) this;
        }

        public Criteria andMessageScenesNotIn(List<String> values) {
            addCriterion("message_scenes not in", values, "messageScenes");
            return (Criteria) this;
        }

        public Criteria andMessageScenesBetween(String value1, String value2) {
            addCriterion("message_scenes between", value1, value2, "messageScenes");
            return (Criteria) this;
        }

        public Criteria andMessageScenesNotBetween(String value1, String value2) {
            addCriterion("message_scenes not between", value1, value2, "messageScenes");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIsNull() {
            addCriterion("template_id is null");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIsNotNull() {
            addCriterion("template_id is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateIdEqualTo(String value) {
            addCriterion("template_id =", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotEqualTo(String value) {
            addCriterion("template_id <>", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdGreaterThan(String value) {
            addCriterion("template_id >", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdGreaterThanOrEqualTo(String value) {
            addCriterion("template_id >=", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLessThan(String value) {
            addCriterion("template_id <", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLessThanOrEqualTo(String value) {
            addCriterion("template_id <=", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLike(String value) {
            addCriterion("template_id like", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotLike(String value) {
            addCriterion("template_id not like", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIn(List<String> values) {
            addCriterion("template_id in", values, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotIn(List<String> values) {
            addCriterion("template_id not in", values, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdBetween(String value1, String value2) {
            addCriterion("template_id between", value1, value2, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotBetween(String value1, String value2) {
            addCriterion("template_id not between", value1, value2, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateContentsIsNull() {
            addCriterion("template_contents is null");
            return (Criteria) this;
        }

        public Criteria andTemplateContentsIsNotNull() {
            addCriterion("template_contents is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateContentsEqualTo(String value) {
            addCriterion("template_contents =", value, "templateContents");
            return (Criteria) this;
        }

        public Criteria andTemplateContentsNotEqualTo(String value) {
            addCriterion("template_contents <>", value, "templateContents");
            return (Criteria) this;
        }

        public Criteria andTemplateContentsGreaterThan(String value) {
            addCriterion("template_contents >", value, "templateContents");
            return (Criteria) this;
        }

        public Criteria andTemplateContentsGreaterThanOrEqualTo(String value) {
            addCriterion("template_contents >=", value, "templateContents");
            return (Criteria) this;
        }

        public Criteria andTemplateContentsLessThan(String value) {
            addCriterion("template_contents <", value, "templateContents");
            return (Criteria) this;
        }

        public Criteria andTemplateContentsLessThanOrEqualTo(String value) {
            addCriterion("template_contents <=", value, "templateContents");
            return (Criteria) this;
        }

        public Criteria andTemplateContentsLike(String value) {
            addCriterion("template_contents like", value, "templateContents");
            return (Criteria) this;
        }

        public Criteria andTemplateContentsNotLike(String value) {
            addCriterion("template_contents not like", value, "templateContents");
            return (Criteria) this;
        }

        public Criteria andTemplateContentsIn(List<String> values) {
            addCriterion("template_contents in", values, "templateContents");
            return (Criteria) this;
        }

        public Criteria andTemplateContentsNotIn(List<String> values) {
            addCriterion("template_contents not in", values, "templateContents");
            return (Criteria) this;
        }

        public Criteria andTemplateContentsBetween(String value1, String value2) {
            addCriterion("template_contents between", value1, value2, "templateContents");
            return (Criteria) this;
        }

        public Criteria andTemplateContentsNotBetween(String value1, String value2) {
            addCriterion("template_contents not between", value1, value2, "templateContents");
            return (Criteria) this;
        }

        public Criteria andTemplateNotesIsNull() {
            addCriterion("template_notes is null");
            return (Criteria) this;
        }

        public Criteria andTemplateNotesIsNotNull() {
            addCriterion("template_notes is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateNotesEqualTo(String value) {
            addCriterion("template_notes =", value, "templateNotes");
            return (Criteria) this;
        }

        public Criteria andTemplateNotesNotEqualTo(String value) {
            addCriterion("template_notes <>", value, "templateNotes");
            return (Criteria) this;
        }

        public Criteria andTemplateNotesGreaterThan(String value) {
            addCriterion("template_notes >", value, "templateNotes");
            return (Criteria) this;
        }

        public Criteria andTemplateNotesGreaterThanOrEqualTo(String value) {
            addCriterion("template_notes >=", value, "templateNotes");
            return (Criteria) this;
        }

        public Criteria andTemplateNotesLessThan(String value) {
            addCriterion("template_notes <", value, "templateNotes");
            return (Criteria) this;
        }

        public Criteria andTemplateNotesLessThanOrEqualTo(String value) {
            addCriterion("template_notes <=", value, "templateNotes");
            return (Criteria) this;
        }

        public Criteria andTemplateNotesLike(String value) {
            addCriterion("template_notes like", value, "templateNotes");
            return (Criteria) this;
        }

        public Criteria andTemplateNotesNotLike(String value) {
            addCriterion("template_notes not like", value, "templateNotes");
            return (Criteria) this;
        }

        public Criteria andTemplateNotesIn(List<String> values) {
            addCriterion("template_notes in", values, "templateNotes");
            return (Criteria) this;
        }

        public Criteria andTemplateNotesNotIn(List<String> values) {
            addCriterion("template_notes not in", values, "templateNotes");
            return (Criteria) this;
        }

        public Criteria andTemplateNotesBetween(String value1, String value2) {
            addCriterion("template_notes between", value1, value2, "templateNotes");
            return (Criteria) this;
        }

        public Criteria andTemplateNotesNotBetween(String value1, String value2) {
            addCriterion("template_notes not between", value1, value2, "templateNotes");
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