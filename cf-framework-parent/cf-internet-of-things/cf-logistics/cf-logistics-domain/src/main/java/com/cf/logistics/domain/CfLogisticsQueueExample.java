package com.cf.logistics.domain;

import java.util.ArrayList;
import java.util.List;

public class CfLogisticsQueueExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfLogisticsQueueExample() {
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

        public Criteria andUseLogIdIsNull() {
            addCriterion("use_log_id is null");
            return (Criteria) this;
        }

        public Criteria andUseLogIdIsNotNull() {
            addCriterion("use_log_id is not null");
            return (Criteria) this;
        }

        public Criteria andUseLogIdEqualTo(Long value) {
            addCriterion("use_log_id =", value, "useLogId");
            return (Criteria) this;
        }

        public Criteria andUseLogIdNotEqualTo(Long value) {
            addCriterion("use_log_id <>", value, "useLogId");
            return (Criteria) this;
        }

        public Criteria andUseLogIdGreaterThan(Long value) {
            addCriterion("use_log_id >", value, "useLogId");
            return (Criteria) this;
        }

        public Criteria andUseLogIdGreaterThanOrEqualTo(Long value) {
            addCriterion("use_log_id >=", value, "useLogId");
            return (Criteria) this;
        }

        public Criteria andUseLogIdLessThan(Long value) {
            addCriterion("use_log_id <", value, "useLogId");
            return (Criteria) this;
        }

        public Criteria andUseLogIdLessThanOrEqualTo(Long value) {
            addCriterion("use_log_id <=", value, "useLogId");
            return (Criteria) this;
        }

        public Criteria andUseLogIdIn(List<Long> values) {
            addCriterion("use_log_id in", values, "useLogId");
            return (Criteria) this;
        }

        public Criteria andUseLogIdNotIn(List<Long> values) {
            addCriterion("use_log_id not in", values, "useLogId");
            return (Criteria) this;
        }

        public Criteria andUseLogIdBetween(Long value1, Long value2) {
            addCriterion("use_log_id between", value1, value2, "useLogId");
            return (Criteria) this;
        }

        public Criteria andUseLogIdNotBetween(Long value1, Long value2) {
            addCriterion("use_log_id not between", value1, value2, "useLogId");
            return (Criteria) this;
        }

        public Criteria andSortIndexIsNull() {
            addCriterion("sort_index is null");
            return (Criteria) this;
        }

        public Criteria andSortIndexIsNotNull() {
            addCriterion("sort_index is not null");
            return (Criteria) this;
        }

        public Criteria andSortIndexEqualTo(Short value) {
            addCriterion("sort_index =", value, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexNotEqualTo(Short value) {
            addCriterion("sort_index <>", value, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexGreaterThan(Short value) {
            addCriterion("sort_index >", value, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexGreaterThanOrEqualTo(Short value) {
            addCriterion("sort_index >=", value, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexLessThan(Short value) {
            addCriterion("sort_index <", value, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexLessThanOrEqualTo(Short value) {
            addCriterion("sort_index <=", value, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexIn(List<Short> values) {
            addCriterion("sort_index in", values, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexNotIn(List<Short> values) {
            addCriterion("sort_index not in", values, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexBetween(Short value1, Short value2) {
            addCriterion("sort_index between", value1, value2, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexNotBetween(Short value1, Short value2) {
            addCriterion("sort_index not between", value1, value2, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andLogisticsStorehouseIdIsNull() {
            addCriterion("logistics_storehouse_id is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsStorehouseIdIsNotNull() {
            addCriterion("logistics_storehouse_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsStorehouseIdEqualTo(Long value) {
            addCriterion("logistics_storehouse_id =", value, "logisticsStorehouseId");
            return (Criteria) this;
        }

        public Criteria andLogisticsStorehouseIdNotEqualTo(Long value) {
            addCriterion("logistics_storehouse_id <>", value, "logisticsStorehouseId");
            return (Criteria) this;
        }

        public Criteria andLogisticsStorehouseIdGreaterThan(Long value) {
            addCriterion("logistics_storehouse_id >", value, "logisticsStorehouseId");
            return (Criteria) this;
        }

        public Criteria andLogisticsStorehouseIdGreaterThanOrEqualTo(Long value) {
            addCriterion("logistics_storehouse_id >=", value, "logisticsStorehouseId");
            return (Criteria) this;
        }

        public Criteria andLogisticsStorehouseIdLessThan(Long value) {
            addCriterion("logistics_storehouse_id <", value, "logisticsStorehouseId");
            return (Criteria) this;
        }

        public Criteria andLogisticsStorehouseIdLessThanOrEqualTo(Long value) {
            addCriterion("logistics_storehouse_id <=", value, "logisticsStorehouseId");
            return (Criteria) this;
        }

        public Criteria andLogisticsStorehouseIdIn(List<Long> values) {
            addCriterion("logistics_storehouse_id in", values, "logisticsStorehouseId");
            return (Criteria) this;
        }

        public Criteria andLogisticsStorehouseIdNotIn(List<Long> values) {
            addCriterion("logistics_storehouse_id not in", values, "logisticsStorehouseId");
            return (Criteria) this;
        }

        public Criteria andLogisticsStorehouseIdBetween(Long value1, Long value2) {
            addCriterion("logistics_storehouse_id between", value1, value2, "logisticsStorehouseId");
            return (Criteria) this;
        }

        public Criteria andLogisticsStorehouseIdNotBetween(Long value1, Long value2) {
            addCriterion("logistics_storehouse_id not between", value1, value2, "logisticsStorehouseId");
            return (Criteria) this;
        }

        public Criteria andLogisticsPlatformIdIsNull() {
            addCriterion("logistics_platform_id is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsPlatformIdIsNotNull() {
            addCriterion("logistics_platform_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsPlatformIdEqualTo(Long value) {
            addCriterion("logistics_platform_id =", value, "logisticsPlatformId");
            return (Criteria) this;
        }

        public Criteria andLogisticsPlatformIdNotEqualTo(Long value) {
            addCriterion("logistics_platform_id <>", value, "logisticsPlatformId");
            return (Criteria) this;
        }

        public Criteria andLogisticsPlatformIdGreaterThan(Long value) {
            addCriterion("logistics_platform_id >", value, "logisticsPlatformId");
            return (Criteria) this;
        }

        public Criteria andLogisticsPlatformIdGreaterThanOrEqualTo(Long value) {
            addCriterion("logistics_platform_id >=", value, "logisticsPlatformId");
            return (Criteria) this;
        }

        public Criteria andLogisticsPlatformIdLessThan(Long value) {
            addCriterion("logistics_platform_id <", value, "logisticsPlatformId");
            return (Criteria) this;
        }

        public Criteria andLogisticsPlatformIdLessThanOrEqualTo(Long value) {
            addCriterion("logistics_platform_id <=", value, "logisticsPlatformId");
            return (Criteria) this;
        }

        public Criteria andLogisticsPlatformIdIn(List<Long> values) {
            addCriterion("logistics_platform_id in", values, "logisticsPlatformId");
            return (Criteria) this;
        }

        public Criteria andLogisticsPlatformIdNotIn(List<Long> values) {
            addCriterion("logistics_platform_id not in", values, "logisticsPlatformId");
            return (Criteria) this;
        }

        public Criteria andLogisticsPlatformIdBetween(Long value1, Long value2) {
            addCriterion("logistics_platform_id between", value1, value2, "logisticsPlatformId");
            return (Criteria) this;
        }

        public Criteria andLogisticsPlatformIdNotBetween(Long value1, Long value2) {
            addCriterion("logistics_platform_id not between", value1, value2, "logisticsPlatformId");
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