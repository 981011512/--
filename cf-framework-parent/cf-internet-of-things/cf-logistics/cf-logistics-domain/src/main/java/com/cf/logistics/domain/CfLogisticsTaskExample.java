package com.cf.logistics.domain;

import java.util.ArrayList;
import java.util.List;

public class CfLogisticsTaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfLogisticsTaskExample() {
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

        public Criteria andTaskTitleIsNull() {
            addCriterion("task_title is null");
            return (Criteria) this;
        }

        public Criteria andTaskTitleIsNotNull() {
            addCriterion("task_title is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTitleEqualTo(String value) {
            addCriterion("task_title =", value, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleNotEqualTo(String value) {
            addCriterion("task_title <>", value, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleGreaterThan(String value) {
            addCriterion("task_title >", value, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleGreaterThanOrEqualTo(String value) {
            addCriterion("task_title >=", value, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleLessThan(String value) {
            addCriterion("task_title <", value, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleLessThanOrEqualTo(String value) {
            addCriterion("task_title <=", value, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleLike(String value) {
            addCriterion("task_title like", value, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleNotLike(String value) {
            addCriterion("task_title not like", value, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleIn(List<String> values) {
            addCriterion("task_title in", values, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleNotIn(List<String> values) {
            addCriterion("task_title not in", values, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleBetween(String value1, String value2) {
            addCriterion("task_title between", value1, value2, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleNotBetween(String value1, String value2) {
            addCriterion("task_title not between", value1, value2, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Long value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Long value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Long value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Long value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Long value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Long value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Long> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Long> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Long value1, Long value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Long value1, Long value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andEditerUidIsNull() {
            addCriterion("editer_uid is null");
            return (Criteria) this;
        }

        public Criteria andEditerUidIsNotNull() {
            addCriterion("editer_uid is not null");
            return (Criteria) this;
        }

        public Criteria andEditerUidEqualTo(String value) {
            addCriterion("editer_uid =", value, "editerUid");
            return (Criteria) this;
        }

        public Criteria andEditerUidNotEqualTo(String value) {
            addCriterion("editer_uid <>", value, "editerUid");
            return (Criteria) this;
        }

        public Criteria andEditerUidGreaterThan(String value) {
            addCriterion("editer_uid >", value, "editerUid");
            return (Criteria) this;
        }

        public Criteria andEditerUidGreaterThanOrEqualTo(String value) {
            addCriterion("editer_uid >=", value, "editerUid");
            return (Criteria) this;
        }

        public Criteria andEditerUidLessThan(String value) {
            addCriterion("editer_uid <", value, "editerUid");
            return (Criteria) this;
        }

        public Criteria andEditerUidLessThanOrEqualTo(String value) {
            addCriterion("editer_uid <=", value, "editerUid");
            return (Criteria) this;
        }

        public Criteria andEditerUidLike(String value) {
            addCriterion("editer_uid like", value, "editerUid");
            return (Criteria) this;
        }

        public Criteria andEditerUidNotLike(String value) {
            addCriterion("editer_uid not like", value, "editerUid");
            return (Criteria) this;
        }

        public Criteria andEditerUidIn(List<String> values) {
            addCriterion("editer_uid in", values, "editerUid");
            return (Criteria) this;
        }

        public Criteria andEditerUidNotIn(List<String> values) {
            addCriterion("editer_uid not in", values, "editerUid");
            return (Criteria) this;
        }

        public Criteria andEditerUidBetween(String value1, String value2) {
            addCriterion("editer_uid between", value1, value2, "editerUid");
            return (Criteria) this;
        }

        public Criteria andEditerUidNotBetween(String value1, String value2) {
            addCriterion("editer_uid not between", value1, value2, "editerUid");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Long value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Long value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Long value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Long value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Long value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Long> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Long> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Long value1, Long value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Long value1, Long value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Long value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Long value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Long value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Long value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Long value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Long> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Long> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Long value1, Long value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Long value1, Long value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andOriginIsNull() {
            addCriterion("origin is null");
            return (Criteria) this;
        }

        public Criteria andOriginIsNotNull() {
            addCriterion("origin is not null");
            return (Criteria) this;
        }

        public Criteria andOriginEqualTo(String value) {
            addCriterion("origin =", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotEqualTo(String value) {
            addCriterion("origin <>", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginGreaterThan(String value) {
            addCriterion("origin >", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginGreaterThanOrEqualTo(String value) {
            addCriterion("origin >=", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginLessThan(String value) {
            addCriterion("origin <", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginLessThanOrEqualTo(String value) {
            addCriterion("origin <=", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginLike(String value) {
            addCriterion("origin like", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotLike(String value) {
            addCriterion("origin not like", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginIn(List<String> values) {
            addCriterion("origin in", values, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotIn(List<String> values) {
            addCriterion("origin not in", values, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginBetween(String value1, String value2) {
            addCriterion("origin between", value1, value2, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotBetween(String value1, String value2) {
            addCriterion("origin not between", value1, value2, "origin");
            return (Criteria) this;
        }

        public Criteria andDestinationIsNull() {
            addCriterion("destination is null");
            return (Criteria) this;
        }

        public Criteria andDestinationIsNotNull() {
            addCriterion("destination is not null");
            return (Criteria) this;
        }

        public Criteria andDestinationEqualTo(String value) {
            addCriterion("destination =", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotEqualTo(String value) {
            addCriterion("destination <>", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationGreaterThan(String value) {
            addCriterion("destination >", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationGreaterThanOrEqualTo(String value) {
            addCriterion("destination >=", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationLessThan(String value) {
            addCriterion("destination <", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationLessThanOrEqualTo(String value) {
            addCriterion("destination <=", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationLike(String value) {
            addCriterion("destination like", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotLike(String value) {
            addCriterion("destination not like", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationIn(List<String> values) {
            addCriterion("destination in", values, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotIn(List<String> values) {
            addCriterion("destination not in", values, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationBetween(String value1, String value2) {
            addCriterion("destination between", value1, value2, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotBetween(String value1, String value2) {
            addCriterion("destination not between", value1, value2, "destination");
            return (Criteria) this;
        }

        public Criteria andCargoTypeIsNull() {
            addCriterion("cargo_type is null");
            return (Criteria) this;
        }

        public Criteria andCargoTypeIsNotNull() {
            addCriterion("cargo_type is not null");
            return (Criteria) this;
        }

        public Criteria andCargoTypeEqualTo(String value) {
            addCriterion("cargo_type =", value, "cargoType");
            return (Criteria) this;
        }

        public Criteria andCargoTypeNotEqualTo(String value) {
            addCriterion("cargo_type <>", value, "cargoType");
            return (Criteria) this;
        }

        public Criteria andCargoTypeGreaterThan(String value) {
            addCriterion("cargo_type >", value, "cargoType");
            return (Criteria) this;
        }

        public Criteria andCargoTypeGreaterThanOrEqualTo(String value) {
            addCriterion("cargo_type >=", value, "cargoType");
            return (Criteria) this;
        }

        public Criteria andCargoTypeLessThan(String value) {
            addCriterion("cargo_type <", value, "cargoType");
            return (Criteria) this;
        }

        public Criteria andCargoTypeLessThanOrEqualTo(String value) {
            addCriterion("cargo_type <=", value, "cargoType");
            return (Criteria) this;
        }

        public Criteria andCargoTypeLike(String value) {
            addCriterion("cargo_type like", value, "cargoType");
            return (Criteria) this;
        }

        public Criteria andCargoTypeNotLike(String value) {
            addCriterion("cargo_type not like", value, "cargoType");
            return (Criteria) this;
        }

        public Criteria andCargoTypeIn(List<String> values) {
            addCriterion("cargo_type in", values, "cargoType");
            return (Criteria) this;
        }

        public Criteria andCargoTypeNotIn(List<String> values) {
            addCriterion("cargo_type not in", values, "cargoType");
            return (Criteria) this;
        }

        public Criteria andCargoTypeBetween(String value1, String value2) {
            addCriterion("cargo_type between", value1, value2, "cargoType");
            return (Criteria) this;
        }

        public Criteria andCargoTypeNotBetween(String value1, String value2) {
            addCriterion("cargo_type not between", value1, value2, "cargoType");
            return (Criteria) this;
        }

        public Criteria andCarTypeIsNull() {
            addCriterion("car_type is null");
            return (Criteria) this;
        }

        public Criteria andCarTypeIsNotNull() {
            addCriterion("car_type is not null");
            return (Criteria) this;
        }

        public Criteria andCarTypeEqualTo(String value) {
            addCriterion("car_type =", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotEqualTo(String value) {
            addCriterion("car_type <>", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeGreaterThan(String value) {
            addCriterion("car_type >", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeGreaterThanOrEqualTo(String value) {
            addCriterion("car_type >=", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeLessThan(String value) {
            addCriterion("car_type <", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeLessThanOrEqualTo(String value) {
            addCriterion("car_type <=", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeLike(String value) {
            addCriterion("car_type like", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotLike(String value) {
            addCriterion("car_type not like", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeIn(List<String> values) {
            addCriterion("car_type in", values, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotIn(List<String> values) {
            addCriterion("car_type not in", values, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeBetween(String value1, String value2) {
            addCriterion("car_type between", value1, value2, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotBetween(String value1, String value2) {
            addCriterion("car_type not between", value1, value2, "carType");
            return (Criteria) this;
        }

        public Criteria andVehiclesRequiredIsNull() {
            addCriterion("vehicles_required is null");
            return (Criteria) this;
        }

        public Criteria andVehiclesRequiredIsNotNull() {
            addCriterion("vehicles_required is not null");
            return (Criteria) this;
        }

        public Criteria andVehiclesRequiredEqualTo(Short value) {
            addCriterion("vehicles_required =", value, "vehiclesRequired");
            return (Criteria) this;
        }

        public Criteria andVehiclesRequiredNotEqualTo(Short value) {
            addCriterion("vehicles_required <>", value, "vehiclesRequired");
            return (Criteria) this;
        }

        public Criteria andVehiclesRequiredGreaterThan(Short value) {
            addCriterion("vehicles_required >", value, "vehiclesRequired");
            return (Criteria) this;
        }

        public Criteria andVehiclesRequiredGreaterThanOrEqualTo(Short value) {
            addCriterion("vehicles_required >=", value, "vehiclesRequired");
            return (Criteria) this;
        }

        public Criteria andVehiclesRequiredLessThan(Short value) {
            addCriterion("vehicles_required <", value, "vehiclesRequired");
            return (Criteria) this;
        }

        public Criteria andVehiclesRequiredLessThanOrEqualTo(Short value) {
            addCriterion("vehicles_required <=", value, "vehiclesRequired");
            return (Criteria) this;
        }

        public Criteria andVehiclesRequiredIn(List<Short> values) {
            addCriterion("vehicles_required in", values, "vehiclesRequired");
            return (Criteria) this;
        }

        public Criteria andVehiclesRequiredNotIn(List<Short> values) {
            addCriterion("vehicles_required not in", values, "vehiclesRequired");
            return (Criteria) this;
        }

        public Criteria andVehiclesRequiredBetween(Short value1, Short value2) {
            addCriterion("vehicles_required between", value1, value2, "vehiclesRequired");
            return (Criteria) this;
        }

        public Criteria andVehiclesRequiredNotBetween(Short value1, Short value2) {
            addCriterion("vehicles_required not between", value1, value2, "vehiclesRequired");
            return (Criteria) this;
        }

        public Criteria andReservedVehiclesIsNull() {
            addCriterion("reserved_vehicles is null");
            return (Criteria) this;
        }

        public Criteria andReservedVehiclesIsNotNull() {
            addCriterion("reserved_vehicles is not null");
            return (Criteria) this;
        }

        public Criteria andReservedVehiclesEqualTo(Short value) {
            addCriterion("reserved_vehicles =", value, "reservedVehicles");
            return (Criteria) this;
        }

        public Criteria andReservedVehiclesNotEqualTo(Short value) {
            addCriterion("reserved_vehicles <>", value, "reservedVehicles");
            return (Criteria) this;
        }

        public Criteria andReservedVehiclesGreaterThan(Short value) {
            addCriterion("reserved_vehicles >", value, "reservedVehicles");
            return (Criteria) this;
        }

        public Criteria andReservedVehiclesGreaterThanOrEqualTo(Short value) {
            addCriterion("reserved_vehicles >=", value, "reservedVehicles");
            return (Criteria) this;
        }

        public Criteria andReservedVehiclesLessThan(Short value) {
            addCriterion("reserved_vehicles <", value, "reservedVehicles");
            return (Criteria) this;
        }

        public Criteria andReservedVehiclesLessThanOrEqualTo(Short value) {
            addCriterion("reserved_vehicles <=", value, "reservedVehicles");
            return (Criteria) this;
        }

        public Criteria andReservedVehiclesIn(List<Short> values) {
            addCriterion("reserved_vehicles in", values, "reservedVehicles");
            return (Criteria) this;
        }

        public Criteria andReservedVehiclesNotIn(List<Short> values) {
            addCriterion("reserved_vehicles not in", values, "reservedVehicles");
            return (Criteria) this;
        }

        public Criteria andReservedVehiclesBetween(Short value1, Short value2) {
            addCriterion("reserved_vehicles between", value1, value2, "reservedVehicles");
            return (Criteria) this;
        }

        public Criteria andReservedVehiclesNotBetween(Short value1, Short value2) {
            addCriterion("reserved_vehicles not between", value1, value2, "reservedVehicles");
            return (Criteria) this;
        }

        public Criteria andResEachIsNull() {
            addCriterion("res_each is null");
            return (Criteria) this;
        }

        public Criteria andResEachIsNotNull() {
            addCriterion("res_each is not null");
            return (Criteria) this;
        }

        public Criteria andResEachEqualTo(Integer value) {
            addCriterion("res_each =", value, "resEach");
            return (Criteria) this;
        }

        public Criteria andResEachNotEqualTo(Integer value) {
            addCriterion("res_each <>", value, "resEach");
            return (Criteria) this;
        }

        public Criteria andResEachGreaterThan(Integer value) {
            addCriterion("res_each >", value, "resEach");
            return (Criteria) this;
        }

        public Criteria andResEachGreaterThanOrEqualTo(Integer value) {
            addCriterion("res_each >=", value, "resEach");
            return (Criteria) this;
        }

        public Criteria andResEachLessThan(Integer value) {
            addCriterion("res_each <", value, "resEach");
            return (Criteria) this;
        }

        public Criteria andResEachLessThanOrEqualTo(Integer value) {
            addCriterion("res_each <=", value, "resEach");
            return (Criteria) this;
        }

        public Criteria andResEachIn(List<Integer> values) {
            addCriterion("res_each in", values, "resEach");
            return (Criteria) this;
        }

        public Criteria andResEachNotIn(List<Integer> values) {
            addCriterion("res_each not in", values, "resEach");
            return (Criteria) this;
        }

        public Criteria andResEachBetween(Integer value1, Integer value2) {
            addCriterion("res_each between", value1, value2, "resEach");
            return (Criteria) this;
        }

        public Criteria andResEachNotBetween(Integer value1, Integer value2) {
            addCriterion("res_each not between", value1, value2, "resEach");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Long value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Long value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Long value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Long value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Long value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Long value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Long> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Long> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Long value1, Long value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Long value1, Long value2) {
            addCriterion("weight not between", value1, value2, "weight");
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

        public Criteria andTaskStatusIsNull() {
            addCriterion("task_status is null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIsNotNull() {
            addCriterion("task_status is not null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusEqualTo(Byte value) {
            addCriterion("task_status =", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotEqualTo(Byte value) {
            addCriterion("task_status <>", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThan(Byte value) {
            addCriterion("task_status >", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("task_status >=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThan(Byte value) {
            addCriterion("task_status <", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThanOrEqualTo(Byte value) {
            addCriterion("task_status <=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIn(List<Byte> values) {
            addCriterion("task_status in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotIn(List<Byte> values) {
            addCriterion("task_status not in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusBetween(Byte value1, Byte value2) {
            addCriterion("task_status between", value1, value2, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("task_status not between", value1, value2, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNull() {
            addCriterion("task_type is null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNotNull() {
            addCriterion("task_type is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeEqualTo(Byte value) {
            addCriterion("task_type =", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotEqualTo(Byte value) {
            addCriterion("task_type <>", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThan(Byte value) {
            addCriterion("task_type >", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("task_type >=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThan(Byte value) {
            addCriterion("task_type <", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThanOrEqualTo(Byte value) {
            addCriterion("task_type <=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIn(List<Byte> values) {
            addCriterion("task_type in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotIn(List<Byte> values) {
            addCriterion("task_type not in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeBetween(Byte value1, Byte value2) {
            addCriterion("task_type between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("task_type not between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andFactoryIdIsNull() {
            addCriterion("factory_id is null");
            return (Criteria) this;
        }

        public Criteria andFactoryIdIsNotNull() {
            addCriterion("factory_id is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryIdEqualTo(Long value) {
            addCriterion("factory_id =", value, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdNotEqualTo(Long value) {
            addCriterion("factory_id <>", value, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdGreaterThan(Long value) {
            addCriterion("factory_id >", value, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("factory_id >=", value, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdLessThan(Long value) {
            addCriterion("factory_id <", value, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdLessThanOrEqualTo(Long value) {
            addCriterion("factory_id <=", value, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdIn(List<Long> values) {
            addCriterion("factory_id in", values, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdNotIn(List<Long> values) {
            addCriterion("factory_id not in", values, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdBetween(Long value1, Long value2) {
            addCriterion("factory_id between", value1, value2, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdNotBetween(Long value1, Long value2) {
            addCriterion("factory_id not between", value1, value2, "factoryId");
            return (Criteria) this;
        }

        public Criteria andSupplierIsNull() {
            addCriterion("supplier is null");
            return (Criteria) this;
        }

        public Criteria andSupplierIsNotNull() {
            addCriterion("supplier is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierEqualTo(String value) {
            addCriterion("supplier =", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotEqualTo(String value) {
            addCriterion("supplier <>", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierGreaterThan(String value) {
            addCriterion("supplier >", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierGreaterThanOrEqualTo(String value) {
            addCriterion("supplier >=", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLessThan(String value) {
            addCriterion("supplier <", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLessThanOrEqualTo(String value) {
            addCriterion("supplier <=", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLike(String value) {
            addCriterion("supplier like", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotLike(String value) {
            addCriterion("supplier not like", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierIn(List<String> values) {
            addCriterion("supplier in", values, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotIn(List<String> values) {
            addCriterion("supplier not in", values, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierBetween(String value1, String value2) {
            addCriterion("supplier between", value1, value2, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotBetween(String value1, String value2) {
            addCriterion("supplier not between", value1, value2, "supplier");
            return (Criteria) this;
        }

        public Criteria andWaybillNumberIsNull() {
            addCriterion("waybill_number is null");
            return (Criteria) this;
        }

        public Criteria andWaybillNumberIsNotNull() {
            addCriterion("waybill_number is not null");
            return (Criteria) this;
        }

        public Criteria andWaybillNumberEqualTo(String value) {
            addCriterion("waybill_number =", value, "waybillNumber");
            return (Criteria) this;
        }

        public Criteria andWaybillNumberNotEqualTo(String value) {
            addCriterion("waybill_number <>", value, "waybillNumber");
            return (Criteria) this;
        }

        public Criteria andWaybillNumberGreaterThan(String value) {
            addCriterion("waybill_number >", value, "waybillNumber");
            return (Criteria) this;
        }

        public Criteria andWaybillNumberGreaterThanOrEqualTo(String value) {
            addCriterion("waybill_number >=", value, "waybillNumber");
            return (Criteria) this;
        }

        public Criteria andWaybillNumberLessThan(String value) {
            addCriterion("waybill_number <", value, "waybillNumber");
            return (Criteria) this;
        }

        public Criteria andWaybillNumberLessThanOrEqualTo(String value) {
            addCriterion("waybill_number <=", value, "waybillNumber");
            return (Criteria) this;
        }

        public Criteria andWaybillNumberLike(String value) {
            addCriterion("waybill_number like", value, "waybillNumber");
            return (Criteria) this;
        }

        public Criteria andWaybillNumberNotLike(String value) {
            addCriterion("waybill_number not like", value, "waybillNumber");
            return (Criteria) this;
        }

        public Criteria andWaybillNumberIn(List<String> values) {
            addCriterion("waybill_number in", values, "waybillNumber");
            return (Criteria) this;
        }

        public Criteria andWaybillNumberNotIn(List<String> values) {
            addCriterion("waybill_number not in", values, "waybillNumber");
            return (Criteria) this;
        }

        public Criteria andWaybillNumberBetween(String value1, String value2) {
            addCriterion("waybill_number between", value1, value2, "waybillNumber");
            return (Criteria) this;
        }

        public Criteria andWaybillNumberNotBetween(String value1, String value2) {
            addCriterion("waybill_number not between", value1, value2, "waybillNumber");
            return (Criteria) this;
        }

        public Criteria andEmergencyLevelIsNull() {
            addCriterion("emergency_level is null");
            return (Criteria) this;
        }

        public Criteria andEmergencyLevelIsNotNull() {
            addCriterion("emergency_level is not null");
            return (Criteria) this;
        }

        public Criteria andEmergencyLevelEqualTo(Byte value) {
            addCriterion("emergency_level =", value, "emergencyLevel");
            return (Criteria) this;
        }

        public Criteria andEmergencyLevelNotEqualTo(Byte value) {
            addCriterion("emergency_level <>", value, "emergencyLevel");
            return (Criteria) this;
        }

        public Criteria andEmergencyLevelGreaterThan(Byte value) {
            addCriterion("emergency_level >", value, "emergencyLevel");
            return (Criteria) this;
        }

        public Criteria andEmergencyLevelGreaterThanOrEqualTo(Byte value) {
            addCriterion("emergency_level >=", value, "emergencyLevel");
            return (Criteria) this;
        }

        public Criteria andEmergencyLevelLessThan(Byte value) {
            addCriterion("emergency_level <", value, "emergencyLevel");
            return (Criteria) this;
        }

        public Criteria andEmergencyLevelLessThanOrEqualTo(Byte value) {
            addCriterion("emergency_level <=", value, "emergencyLevel");
            return (Criteria) this;
        }

        public Criteria andEmergencyLevelIn(List<Byte> values) {
            addCriterion("emergency_level in", values, "emergencyLevel");
            return (Criteria) this;
        }

        public Criteria andEmergencyLevelNotIn(List<Byte> values) {
            addCriterion("emergency_level not in", values, "emergencyLevel");
            return (Criteria) this;
        }

        public Criteria andEmergencyLevelBetween(Byte value1, Byte value2) {
            addCriterion("emergency_level between", value1, value2, "emergencyLevel");
            return (Criteria) this;
        }

        public Criteria andEmergencyLevelNotBetween(Byte value1, Byte value2) {
            addCriterion("emergency_level not between", value1, value2, "emergencyLevel");
            return (Criteria) this;
        }

        public Criteria andChildrenTaskCountsIsNull() {
            addCriterion("children_task_counts is null");
            return (Criteria) this;
        }

        public Criteria andChildrenTaskCountsIsNotNull() {
            addCriterion("children_task_counts is not null");
            return (Criteria) this;
        }

        public Criteria andChildrenTaskCountsEqualTo(Byte value) {
            addCriterion("children_task_counts =", value, "childrenTaskCounts");
            return (Criteria) this;
        }

        public Criteria andChildrenTaskCountsNotEqualTo(Byte value) {
            addCriterion("children_task_counts <>", value, "childrenTaskCounts");
            return (Criteria) this;
        }

        public Criteria andChildrenTaskCountsGreaterThan(Byte value) {
            addCriterion("children_task_counts >", value, "childrenTaskCounts");
            return (Criteria) this;
        }

        public Criteria andChildrenTaskCountsGreaterThanOrEqualTo(Byte value) {
            addCriterion("children_task_counts >=", value, "childrenTaskCounts");
            return (Criteria) this;
        }

        public Criteria andChildrenTaskCountsLessThan(Byte value) {
            addCriterion("children_task_counts <", value, "childrenTaskCounts");
            return (Criteria) this;
        }

        public Criteria andChildrenTaskCountsLessThanOrEqualTo(Byte value) {
            addCriterion("children_task_counts <=", value, "childrenTaskCounts");
            return (Criteria) this;
        }

        public Criteria andChildrenTaskCountsIn(List<Byte> values) {
            addCriterion("children_task_counts in", values, "childrenTaskCounts");
            return (Criteria) this;
        }

        public Criteria andChildrenTaskCountsNotIn(List<Byte> values) {
            addCriterion("children_task_counts not in", values, "childrenTaskCounts");
            return (Criteria) this;
        }

        public Criteria andChildrenTaskCountsBetween(Byte value1, Byte value2) {
            addCriterion("children_task_counts between", value1, value2, "childrenTaskCounts");
            return (Criteria) this;
        }

        public Criteria andChildrenTaskCountsNotBetween(Byte value1, Byte value2) {
            addCriterion("children_task_counts not between", value1, value2, "childrenTaskCounts");
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

        public Criteria andSortIndexEqualTo(Integer value) {
            addCriterion("sort_index =", value, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexNotEqualTo(Integer value) {
            addCriterion("sort_index <>", value, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexGreaterThan(Integer value) {
            addCriterion("sort_index >", value, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort_index >=", value, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexLessThan(Integer value) {
            addCriterion("sort_index <", value, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexLessThanOrEqualTo(Integer value) {
            addCriterion("sort_index <=", value, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexIn(List<Integer> values) {
            addCriterion("sort_index in", values, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexNotIn(List<Integer> values) {
            addCriterion("sort_index not in", values, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexBetween(Integer value1, Integer value2) {
            addCriterion("sort_index between", value1, value2, "sortIndex");
            return (Criteria) this;
        }

        public Criteria andSortIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("sort_index not between", value1, value2, "sortIndex");
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