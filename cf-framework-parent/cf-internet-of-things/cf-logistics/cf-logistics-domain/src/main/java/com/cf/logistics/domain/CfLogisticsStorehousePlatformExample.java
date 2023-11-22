package com.cf.logistics.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CfLogisticsStorehousePlatformExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfLogisticsStorehousePlatformExample() {
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

        public Criteria andPlatformNameIsNull() {
            addCriterion("platform_name is null");
            return (Criteria) this;
        }

        public Criteria andPlatformNameIsNotNull() {
            addCriterion("platform_name is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformNameEqualTo(String value) {
            addCriterion("platform_name =", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameNotEqualTo(String value) {
            addCriterion("platform_name <>", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameGreaterThan(String value) {
            addCriterion("platform_name >", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameGreaterThanOrEqualTo(String value) {
            addCriterion("platform_name >=", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameLessThan(String value) {
            addCriterion("platform_name <", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameLessThanOrEqualTo(String value) {
            addCriterion("platform_name <=", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameLike(String value) {
            addCriterion("platform_name like", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameNotLike(String value) {
            addCriterion("platform_name not like", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameIn(List<String> values) {
            addCriterion("platform_name in", values, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameNotIn(List<String> values) {
            addCriterion("platform_name not in", values, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameBetween(String value1, String value2) {
            addCriterion("platform_name between", value1, value2, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameNotBetween(String value1, String value2) {
            addCriterion("platform_name not between", value1, value2, "platformName");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdIsNull() {
            addCriterion("storehouse_id is null");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdIsNotNull() {
            addCriterion("storehouse_id is not null");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdEqualTo(Long value) {
            addCriterion("storehouse_id =", value, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdNotEqualTo(Long value) {
            addCriterion("storehouse_id <>", value, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdGreaterThan(Long value) {
            addCriterion("storehouse_id >", value, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdGreaterThanOrEqualTo(Long value) {
            addCriterion("storehouse_id >=", value, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdLessThan(Long value) {
            addCriterion("storehouse_id <", value, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdLessThanOrEqualTo(Long value) {
            addCriterion("storehouse_id <=", value, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdIn(List<Long> values) {
            addCriterion("storehouse_id in", values, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdNotIn(List<Long> values) {
            addCriterion("storehouse_id not in", values, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdBetween(Long value1, Long value2) {
            addCriterion("storehouse_id between", value1, value2, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdNotBetween(Long value1, Long value2) {
            addCriterion("storehouse_id not between", value1, value2, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andPositionXIsNull() {
            addCriterion("position_x is null");
            return (Criteria) this;
        }

        public Criteria andPositionXIsNotNull() {
            addCriterion("position_x is not null");
            return (Criteria) this;
        }

        public Criteria andPositionXEqualTo(BigDecimal value) {
            addCriterion("position_x =", value, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXNotEqualTo(BigDecimal value) {
            addCriterion("position_x <>", value, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXGreaterThan(BigDecimal value) {
            addCriterion("position_x >", value, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("position_x >=", value, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXLessThan(BigDecimal value) {
            addCriterion("position_x <", value, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXLessThanOrEqualTo(BigDecimal value) {
            addCriterion("position_x <=", value, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXIn(List<BigDecimal> values) {
            addCriterion("position_x in", values, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXNotIn(List<BigDecimal> values) {
            addCriterion("position_x not in", values, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("position_x between", value1, value2, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionXNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("position_x not between", value1, value2, "positionX");
            return (Criteria) this;
        }

        public Criteria andPositionYIsNull() {
            addCriterion("position_y is null");
            return (Criteria) this;
        }

        public Criteria andPositionYIsNotNull() {
            addCriterion("position_y is not null");
            return (Criteria) this;
        }

        public Criteria andPositionYEqualTo(BigDecimal value) {
            addCriterion("position_y =", value, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYNotEqualTo(BigDecimal value) {
            addCriterion("position_y <>", value, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYGreaterThan(BigDecimal value) {
            addCriterion("position_y >", value, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("position_y >=", value, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYLessThan(BigDecimal value) {
            addCriterion("position_y <", value, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYLessThanOrEqualTo(BigDecimal value) {
            addCriterion("position_y <=", value, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYIn(List<BigDecimal> values) {
            addCriterion("position_y in", values, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYNotIn(List<BigDecimal> values) {
            addCriterion("position_y not in", values, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("position_y between", value1, value2, "positionY");
            return (Criteria) this;
        }

        public Criteria andPositionYNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("position_y not between", value1, value2, "positionY");
            return (Criteria) this;
        }

        public Criteria andQueueCapacityIsNull() {
            addCriterion("queue_capacity is null");
            return (Criteria) this;
        }

        public Criteria andQueueCapacityIsNotNull() {
            addCriterion("queue_capacity is not null");
            return (Criteria) this;
        }

        public Criteria andQueueCapacityEqualTo(Integer value) {
            addCriterion("queue_capacity =", value, "queueCapacity");
            return (Criteria) this;
        }

        public Criteria andQueueCapacityNotEqualTo(Integer value) {
            addCriterion("queue_capacity <>", value, "queueCapacity");
            return (Criteria) this;
        }

        public Criteria andQueueCapacityGreaterThan(Integer value) {
            addCriterion("queue_capacity >", value, "queueCapacity");
            return (Criteria) this;
        }

        public Criteria andQueueCapacityGreaterThanOrEqualTo(Integer value) {
            addCriterion("queue_capacity >=", value, "queueCapacity");
            return (Criteria) this;
        }

        public Criteria andQueueCapacityLessThan(Integer value) {
            addCriterion("queue_capacity <", value, "queueCapacity");
            return (Criteria) this;
        }

        public Criteria andQueueCapacityLessThanOrEqualTo(Integer value) {
            addCriterion("queue_capacity <=", value, "queueCapacity");
            return (Criteria) this;
        }

        public Criteria andQueueCapacityIn(List<Integer> values) {
            addCriterion("queue_capacity in", values, "queueCapacity");
            return (Criteria) this;
        }

        public Criteria andQueueCapacityNotIn(List<Integer> values) {
            addCriterion("queue_capacity not in", values, "queueCapacity");
            return (Criteria) this;
        }

        public Criteria andQueueCapacityBetween(Integer value1, Integer value2) {
            addCriterion("queue_capacity between", value1, value2, "queueCapacity");
            return (Criteria) this;
        }

        public Criteria andQueueCapacityNotBetween(Integer value1, Integer value2) {
            addCriterion("queue_capacity not between", value1, value2, "queueCapacity");
            return (Criteria) this;
        }

        public Criteria andUsedQueueCapacityIsNull() {
            addCriterion("used_queue_capacity is null");
            return (Criteria) this;
        }

        public Criteria andUsedQueueCapacityIsNotNull() {
            addCriterion("used_queue_capacity is not null");
            return (Criteria) this;
        }

        public Criteria andUsedQueueCapacityEqualTo(Integer value) {
            addCriterion("used_queue_capacity =", value, "usedQueueCapacity");
            return (Criteria) this;
        }

        public Criteria andUsedQueueCapacityNotEqualTo(Integer value) {
            addCriterion("used_queue_capacity <>", value, "usedQueueCapacity");
            return (Criteria) this;
        }

        public Criteria andUsedQueueCapacityGreaterThan(Integer value) {
            addCriterion("used_queue_capacity >", value, "usedQueueCapacity");
            return (Criteria) this;
        }

        public Criteria andUsedQueueCapacityGreaterThanOrEqualTo(Integer value) {
            addCriterion("used_queue_capacity >=", value, "usedQueueCapacity");
            return (Criteria) this;
        }

        public Criteria andUsedQueueCapacityLessThan(Integer value) {
            addCriterion("used_queue_capacity <", value, "usedQueueCapacity");
            return (Criteria) this;
        }

        public Criteria andUsedQueueCapacityLessThanOrEqualTo(Integer value) {
            addCriterion("used_queue_capacity <=", value, "usedQueueCapacity");
            return (Criteria) this;
        }

        public Criteria andUsedQueueCapacityIn(List<Integer> values) {
            addCriterion("used_queue_capacity in", values, "usedQueueCapacity");
            return (Criteria) this;
        }

        public Criteria andUsedQueueCapacityNotIn(List<Integer> values) {
            addCriterion("used_queue_capacity not in", values, "usedQueueCapacity");
            return (Criteria) this;
        }

        public Criteria andUsedQueueCapacityBetween(Integer value1, Integer value2) {
            addCriterion("used_queue_capacity between", value1, value2, "usedQueueCapacity");
            return (Criteria) this;
        }

        public Criteria andUsedQueueCapacityNotBetween(Integer value1, Integer value2) {
            addCriterion("used_queue_capacity not between", value1, value2, "usedQueueCapacity");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusIsNull() {
            addCriterion("platform_status is null");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusIsNotNull() {
            addCriterion("platform_status is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusEqualTo(Byte value) {
            addCriterion("platform_status =", value, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusNotEqualTo(Byte value) {
            addCriterion("platform_status <>", value, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusGreaterThan(Byte value) {
            addCriterion("platform_status >", value, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("platform_status >=", value, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusLessThan(Byte value) {
            addCriterion("platform_status <", value, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusLessThanOrEqualTo(Byte value) {
            addCriterion("platform_status <=", value, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusIn(List<Byte> values) {
            addCriterion("platform_status in", values, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusNotIn(List<Byte> values) {
            addCriterion("platform_status not in", values, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusBetween(Byte value1, Byte value2) {
            addCriterion("platform_status between", value1, value2, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("platform_status not between", value1, value2, "platformStatus");
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

        public Criteria andHandleUidIsNull() {
            addCriterion("handle_uid is null");
            return (Criteria) this;
        }

        public Criteria andHandleUidIsNotNull() {
            addCriterion("handle_uid is not null");
            return (Criteria) this;
        }

        public Criteria andHandleUidEqualTo(String value) {
            addCriterion("handle_uid =", value, "handleUid");
            return (Criteria) this;
        }

        public Criteria andHandleUidNotEqualTo(String value) {
            addCriterion("handle_uid <>", value, "handleUid");
            return (Criteria) this;
        }

        public Criteria andHandleUidGreaterThan(String value) {
            addCriterion("handle_uid >", value, "handleUid");
            return (Criteria) this;
        }

        public Criteria andHandleUidGreaterThanOrEqualTo(String value) {
            addCriterion("handle_uid >=", value, "handleUid");
            return (Criteria) this;
        }

        public Criteria andHandleUidLessThan(String value) {
            addCriterion("handle_uid <", value, "handleUid");
            return (Criteria) this;
        }

        public Criteria andHandleUidLessThanOrEqualTo(String value) {
            addCriterion("handle_uid <=", value, "handleUid");
            return (Criteria) this;
        }

        public Criteria andHandleUidLike(String value) {
            addCriterion("handle_uid like", value, "handleUid");
            return (Criteria) this;
        }

        public Criteria andHandleUidNotLike(String value) {
            addCriterion("handle_uid not like", value, "handleUid");
            return (Criteria) this;
        }

        public Criteria andHandleUidIn(List<String> values) {
            addCriterion("handle_uid in", values, "handleUid");
            return (Criteria) this;
        }

        public Criteria andHandleUidNotIn(List<String> values) {
            addCriterion("handle_uid not in", values, "handleUid");
            return (Criteria) this;
        }

        public Criteria andHandleUidBetween(String value1, String value2) {
            addCriterion("handle_uid between", value1, value2, "handleUid");
            return (Criteria) this;
        }

        public Criteria andHandleUidNotBetween(String value1, String value2) {
            addCriterion("handle_uid not between", value1, value2, "handleUid");
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