package com.cf.carpark.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CfCarParkCheckpointExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfCarParkCheckpointExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andCarParkIdIsNull() {
            addCriterion("car_park_id is null");
            return (Criteria) this;
        }

        public Criteria andCarParkIdIsNotNull() {
            addCriterion("car_park_id is not null");
            return (Criteria) this;
        }

        public Criteria andCarParkIdEqualTo(String value) {
            addCriterion("car_park_id =", value, "carParkId");
            return (Criteria) this;
        }

        public Criteria andCarParkIdNotEqualTo(String value) {
            addCriterion("car_park_id <>", value, "carParkId");
            return (Criteria) this;
        }

        public Criteria andCarParkIdGreaterThan(String value) {
            addCriterion("car_park_id >", value, "carParkId");
            return (Criteria) this;
        }

        public Criteria andCarParkIdGreaterThanOrEqualTo(String value) {
            addCriterion("car_park_id >=", value, "carParkId");
            return (Criteria) this;
        }

        public Criteria andCarParkIdLessThan(String value) {
            addCriterion("car_park_id <", value, "carParkId");
            return (Criteria) this;
        }

        public Criteria andCarParkIdLessThanOrEqualTo(String value) {
            addCriterion("car_park_id <=", value, "carParkId");
            return (Criteria) this;
        }

        public Criteria andCarParkIdLike(String value) {
            addCriterion("car_park_id like", value, "carParkId");
            return (Criteria) this;
        }

        public Criteria andCarParkIdNotLike(String value) {
            addCriterion("car_park_id not like", value, "carParkId");
            return (Criteria) this;
        }

        public Criteria andCarParkIdIn(List<String> values) {
            addCriterion("car_park_id in", values, "carParkId");
            return (Criteria) this;
        }

        public Criteria andCarParkIdNotIn(List<String> values) {
            addCriterion("car_park_id not in", values, "carParkId");
            return (Criteria) this;
        }

        public Criteria andCarParkIdBetween(String value1, String value2) {
            addCriterion("car_park_id between", value1, value2, "carParkId");
            return (Criteria) this;
        }

        public Criteria andCarParkIdNotBetween(String value1, String value2) {
            addCriterion("car_park_id not between", value1, value2, "carParkId");
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

        public Criteria andPositionDescribeIsNull() {
            addCriterion("position_describe is null");
            return (Criteria) this;
        }

        public Criteria andPositionDescribeIsNotNull() {
            addCriterion("position_describe is not null");
            return (Criteria) this;
        }

        public Criteria andPositionDescribeEqualTo(String value) {
            addCriterion("position_describe =", value, "positionDescribe");
            return (Criteria) this;
        }

        public Criteria andPositionDescribeNotEqualTo(String value) {
            addCriterion("position_describe <>", value, "positionDescribe");
            return (Criteria) this;
        }

        public Criteria andPositionDescribeGreaterThan(String value) {
            addCriterion("position_describe >", value, "positionDescribe");
            return (Criteria) this;
        }

        public Criteria andPositionDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("position_describe >=", value, "positionDescribe");
            return (Criteria) this;
        }

        public Criteria andPositionDescribeLessThan(String value) {
            addCriterion("position_describe <", value, "positionDescribe");
            return (Criteria) this;
        }

        public Criteria andPositionDescribeLessThanOrEqualTo(String value) {
            addCriterion("position_describe <=", value, "positionDescribe");
            return (Criteria) this;
        }

        public Criteria andPositionDescribeLike(String value) {
            addCriterion("position_describe like", value, "positionDescribe");
            return (Criteria) this;
        }

        public Criteria andPositionDescribeNotLike(String value) {
            addCriterion("position_describe not like", value, "positionDescribe");
            return (Criteria) this;
        }

        public Criteria andPositionDescribeIn(List<String> values) {
            addCriterion("position_describe in", values, "positionDescribe");
            return (Criteria) this;
        }

        public Criteria andPositionDescribeNotIn(List<String> values) {
            addCriterion("position_describe not in", values, "positionDescribe");
            return (Criteria) this;
        }

        public Criteria andPositionDescribeBetween(String value1, String value2) {
            addCriterion("position_describe between", value1, value2, "positionDescribe");
            return (Criteria) this;
        }

        public Criteria andPositionDescribeNotBetween(String value1, String value2) {
            addCriterion("position_describe not between", value1, value2, "positionDescribe");
            return (Criteria) this;
        }

        public Criteria andFloorIsNull() {
            addCriterion("floor is null");
            return (Criteria) this;
        }

        public Criteria andFloorIsNotNull() {
            addCriterion("floor is not null");
            return (Criteria) this;
        }

        public Criteria andFloorEqualTo(Byte value) {
            addCriterion("floor =", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotEqualTo(Byte value) {
            addCriterion("floor <>", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorGreaterThan(Byte value) {
            addCriterion("floor >", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorGreaterThanOrEqualTo(Byte value) {
            addCriterion("floor >=", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLessThan(Byte value) {
            addCriterion("floor <", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLessThanOrEqualTo(Byte value) {
            addCriterion("floor <=", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorIn(List<Byte> values) {
            addCriterion("floor in", values, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotIn(List<Byte> values) {
            addCriterion("floor not in", values, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorBetween(Byte value1, Byte value2) {
            addCriterion("floor between", value1, value2, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotBetween(Byte value1, Byte value2) {
            addCriterion("floor not between", value1, value2, "floor");
            return (Criteria) this;
        }

        public Criteria andModeIsNull() {
            addCriterion("mode is null");
            return (Criteria) this;
        }

        public Criteria andModeIsNotNull() {
            addCriterion("mode is not null");
            return (Criteria) this;
        }

        public Criteria andModeEqualTo(Byte value) {
            addCriterion("mode =", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeNotEqualTo(Byte value) {
            addCriterion("mode <>", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeGreaterThan(Byte value) {
            addCriterion("mode >", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeGreaterThanOrEqualTo(Byte value) {
            addCriterion("mode >=", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeLessThan(Byte value) {
            addCriterion("mode <", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeLessThanOrEqualTo(Byte value) {
            addCriterion("mode <=", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeIn(List<Byte> values) {
            addCriterion("mode in", values, "mode");
            return (Criteria) this;
        }

        public Criteria andModeNotIn(List<Byte> values) {
            addCriterion("mode not in", values, "mode");
            return (Criteria) this;
        }

        public Criteria andModeBetween(Byte value1, Byte value2) {
            addCriterion("mode between", value1, value2, "mode");
            return (Criteria) this;
        }

        public Criteria andModeNotBetween(Byte value1, Byte value2) {
            addCriterion("mode not between", value1, value2, "mode");
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