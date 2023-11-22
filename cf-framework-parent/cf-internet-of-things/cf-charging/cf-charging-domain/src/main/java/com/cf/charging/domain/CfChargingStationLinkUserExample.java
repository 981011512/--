package com.cf.charging.domain;

import java.util.ArrayList;
import java.util.List;

public class CfChargingStationLinkUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfChargingStationLinkUserExample() {
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

        public Criteria andChargingStationIdIsNull() {
            addCriterion("charging_station_id is null");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdIsNotNull() {
            addCriterion("charging_station_id is not null");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdEqualTo(String value) {
            addCriterion("charging_station_id =", value, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdNotEqualTo(String value) {
            addCriterion("charging_station_id <>", value, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdGreaterThan(String value) {
            addCriterion("charging_station_id >", value, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdGreaterThanOrEqualTo(String value) {
            addCriterion("charging_station_id >=", value, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdLessThan(String value) {
            addCriterion("charging_station_id <", value, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdLessThanOrEqualTo(String value) {
            addCriterion("charging_station_id <=", value, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdLike(String value) {
            addCriterion("charging_station_id like", value, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdNotLike(String value) {
            addCriterion("charging_station_id not like", value, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdIn(List<String> values) {
            addCriterion("charging_station_id in", values, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdNotIn(List<String> values) {
            addCriterion("charging_station_id not in", values, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdBetween(String value1, String value2) {
            addCriterion("charging_station_id between", value1, value2, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andChargingStationIdNotBetween(String value1, String value2) {
            addCriterion("charging_station_id not between", value1, value2, "chargingStationId");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(String value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(String value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(String value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(String value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(String value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(String value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLike(String value) {
            addCriterion("uid like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotLike(String value) {
            addCriterion("uid not like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<String> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<String> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(String value1, String value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(String value1, String value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andAllowEditIsNull() {
            addCriterion("allow_edit is null");
            return (Criteria) this;
        }

        public Criteria andAllowEditIsNotNull() {
            addCriterion("allow_edit is not null");
            return (Criteria) this;
        }

        public Criteria andAllowEditEqualTo(Byte value) {
            addCriterion("allow_edit =", value, "allowEdit");
            return (Criteria) this;
        }

        public Criteria andAllowEditNotEqualTo(Byte value) {
            addCriterion("allow_edit <>", value, "allowEdit");
            return (Criteria) this;
        }

        public Criteria andAllowEditGreaterThan(Byte value) {
            addCriterion("allow_edit >", value, "allowEdit");
            return (Criteria) this;
        }

        public Criteria andAllowEditGreaterThanOrEqualTo(Byte value) {
            addCriterion("allow_edit >=", value, "allowEdit");
            return (Criteria) this;
        }

        public Criteria andAllowEditLessThan(Byte value) {
            addCriterion("allow_edit <", value, "allowEdit");
            return (Criteria) this;
        }

        public Criteria andAllowEditLessThanOrEqualTo(Byte value) {
            addCriterion("allow_edit <=", value, "allowEdit");
            return (Criteria) this;
        }

        public Criteria andAllowEditIn(List<Byte> values) {
            addCriterion("allow_edit in", values, "allowEdit");
            return (Criteria) this;
        }

        public Criteria andAllowEditNotIn(List<Byte> values) {
            addCriterion("allow_edit not in", values, "allowEdit");
            return (Criteria) this;
        }

        public Criteria andAllowEditBetween(Byte value1, Byte value2) {
            addCriterion("allow_edit between", value1, value2, "allowEdit");
            return (Criteria) this;
        }

        public Criteria andAllowEditNotBetween(Byte value1, Byte value2) {
            addCriterion("allow_edit not between", value1, value2, "allowEdit");
            return (Criteria) this;
        }

        public Criteria andAllowDeleteIsNull() {
            addCriterion("allow_delete is null");
            return (Criteria) this;
        }

        public Criteria andAllowDeleteIsNotNull() {
            addCriterion("allow_delete is not null");
            return (Criteria) this;
        }

        public Criteria andAllowDeleteEqualTo(Byte value) {
            addCriterion("allow_delete =", value, "allowDelete");
            return (Criteria) this;
        }

        public Criteria andAllowDeleteNotEqualTo(Byte value) {
            addCriterion("allow_delete <>", value, "allowDelete");
            return (Criteria) this;
        }

        public Criteria andAllowDeleteGreaterThan(Byte value) {
            addCriterion("allow_delete >", value, "allowDelete");
            return (Criteria) this;
        }

        public Criteria andAllowDeleteGreaterThanOrEqualTo(Byte value) {
            addCriterion("allow_delete >=", value, "allowDelete");
            return (Criteria) this;
        }

        public Criteria andAllowDeleteLessThan(Byte value) {
            addCriterion("allow_delete <", value, "allowDelete");
            return (Criteria) this;
        }

        public Criteria andAllowDeleteLessThanOrEqualTo(Byte value) {
            addCriterion("allow_delete <=", value, "allowDelete");
            return (Criteria) this;
        }

        public Criteria andAllowDeleteIn(List<Byte> values) {
            addCriterion("allow_delete in", values, "allowDelete");
            return (Criteria) this;
        }

        public Criteria andAllowDeleteNotIn(List<Byte> values) {
            addCriterion("allow_delete not in", values, "allowDelete");
            return (Criteria) this;
        }

        public Criteria andAllowDeleteBetween(Byte value1, Byte value2) {
            addCriterion("allow_delete between", value1, value2, "allowDelete");
            return (Criteria) this;
        }

        public Criteria andAllowDeleteNotBetween(Byte value1, Byte value2) {
            addCriterion("allow_delete not between", value1, value2, "allowDelete");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNull() {
            addCriterion("creater is null");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNotNull() {
            addCriterion("creater is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterEqualTo(Byte value) {
            addCriterion("creater =", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotEqualTo(Byte value) {
            addCriterion("creater <>", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThan(Byte value) {
            addCriterion("creater >", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThanOrEqualTo(Byte value) {
            addCriterion("creater >=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThan(Byte value) {
            addCriterion("creater <", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThanOrEqualTo(Byte value) {
            addCriterion("creater <=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterIn(List<Byte> values) {
            addCriterion("creater in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotIn(List<Byte> values) {
            addCriterion("creater not in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterBetween(Byte value1, Byte value2) {
            addCriterion("creater between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotBetween(Byte value1, Byte value2) {
            addCriterion("creater not between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCheckPointIdsIsNull() {
            addCriterion("check_point_ids is null");
            return (Criteria) this;
        }

        public Criteria andCheckPointIdsIsNotNull() {
            addCriterion("check_point_ids is not null");
            return (Criteria) this;
        }

        public Criteria andCheckPointIdsEqualTo(String value) {
            addCriterion("check_point_ids =", value, "checkPointIds");
            return (Criteria) this;
        }

        public Criteria andCheckPointIdsNotEqualTo(String value) {
            addCriterion("check_point_ids <>", value, "checkPointIds");
            return (Criteria) this;
        }

        public Criteria andCheckPointIdsGreaterThan(String value) {
            addCriterion("check_point_ids >", value, "checkPointIds");
            return (Criteria) this;
        }

        public Criteria andCheckPointIdsGreaterThanOrEqualTo(String value) {
            addCriterion("check_point_ids >=", value, "checkPointIds");
            return (Criteria) this;
        }

        public Criteria andCheckPointIdsLessThan(String value) {
            addCriterion("check_point_ids <", value, "checkPointIds");
            return (Criteria) this;
        }

        public Criteria andCheckPointIdsLessThanOrEqualTo(String value) {
            addCriterion("check_point_ids <=", value, "checkPointIds");
            return (Criteria) this;
        }

        public Criteria andCheckPointIdsLike(String value) {
            addCriterion("check_point_ids like", value, "checkPointIds");
            return (Criteria) this;
        }

        public Criteria andCheckPointIdsNotLike(String value) {
            addCriterion("check_point_ids not like", value, "checkPointIds");
            return (Criteria) this;
        }

        public Criteria andCheckPointIdsIn(List<String> values) {
            addCriterion("check_point_ids in", values, "checkPointIds");
            return (Criteria) this;
        }

        public Criteria andCheckPointIdsNotIn(List<String> values) {
            addCriterion("check_point_ids not in", values, "checkPointIds");
            return (Criteria) this;
        }

        public Criteria andCheckPointIdsBetween(String value1, String value2) {
            addCriterion("check_point_ids between", value1, value2, "checkPointIds");
            return (Criteria) this;
        }

        public Criteria andCheckPointIdsNotBetween(String value1, String value2) {
            addCriterion("check_point_ids not between", value1, value2, "checkPointIds");
            return (Criteria) this;
        }

        public Criteria andStartDutyTimeIsNull() {
            addCriterion("start_duty_time is null");
            return (Criteria) this;
        }

        public Criteria andStartDutyTimeIsNotNull() {
            addCriterion("start_duty_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartDutyTimeEqualTo(Long value) {
            addCriterion("start_duty_time =", value, "startDutyTime");
            return (Criteria) this;
        }

        public Criteria andStartDutyTimeNotEqualTo(Long value) {
            addCriterion("start_duty_time <>", value, "startDutyTime");
            return (Criteria) this;
        }

        public Criteria andStartDutyTimeGreaterThan(Long value) {
            addCriterion("start_duty_time >", value, "startDutyTime");
            return (Criteria) this;
        }

        public Criteria andStartDutyTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("start_duty_time >=", value, "startDutyTime");
            return (Criteria) this;
        }

        public Criteria andStartDutyTimeLessThan(Long value) {
            addCriterion("start_duty_time <", value, "startDutyTime");
            return (Criteria) this;
        }

        public Criteria andStartDutyTimeLessThanOrEqualTo(Long value) {
            addCriterion("start_duty_time <=", value, "startDutyTime");
            return (Criteria) this;
        }

        public Criteria andStartDutyTimeIn(List<Long> values) {
            addCriterion("start_duty_time in", values, "startDutyTime");
            return (Criteria) this;
        }

        public Criteria andStartDutyTimeNotIn(List<Long> values) {
            addCriterion("start_duty_time not in", values, "startDutyTime");
            return (Criteria) this;
        }

        public Criteria andStartDutyTimeBetween(Long value1, Long value2) {
            addCriterion("start_duty_time between", value1, value2, "startDutyTime");
            return (Criteria) this;
        }

        public Criteria andStartDutyTimeNotBetween(Long value1, Long value2) {
            addCriterion("start_duty_time not between", value1, value2, "startDutyTime");
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