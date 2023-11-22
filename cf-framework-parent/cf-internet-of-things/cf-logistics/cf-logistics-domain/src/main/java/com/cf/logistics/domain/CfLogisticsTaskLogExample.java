package com.cf.logistics.domain;

import java.util.ArrayList;
import java.util.List;

public class CfLogisticsTaskLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfLogisticsTaskLogExample() {
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

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Long value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Long value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Long value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Long value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Long value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Long value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Long> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Long> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Long value1, Long value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Long value1, Long value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andDeliverUidIsNull() {
            addCriterion("deliver_uid is null");
            return (Criteria) this;
        }

        public Criteria andDeliverUidIsNotNull() {
            addCriterion("deliver_uid is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverUidEqualTo(String value) {
            addCriterion("deliver_uid =", value, "deliverUid");
            return (Criteria) this;
        }

        public Criteria andDeliverUidNotEqualTo(String value) {
            addCriterion("deliver_uid <>", value, "deliverUid");
            return (Criteria) this;
        }

        public Criteria andDeliverUidGreaterThan(String value) {
            addCriterion("deliver_uid >", value, "deliverUid");
            return (Criteria) this;
        }

        public Criteria andDeliverUidGreaterThanOrEqualTo(String value) {
            addCriterion("deliver_uid >=", value, "deliverUid");
            return (Criteria) this;
        }

        public Criteria andDeliverUidLessThan(String value) {
            addCriterion("deliver_uid <", value, "deliverUid");
            return (Criteria) this;
        }

        public Criteria andDeliverUidLessThanOrEqualTo(String value) {
            addCriterion("deliver_uid <=", value, "deliverUid");
            return (Criteria) this;
        }

        public Criteria andDeliverUidLike(String value) {
            addCriterion("deliver_uid like", value, "deliverUid");
            return (Criteria) this;
        }

        public Criteria andDeliverUidNotLike(String value) {
            addCriterion("deliver_uid not like", value, "deliverUid");
            return (Criteria) this;
        }

        public Criteria andDeliverUidIn(List<String> values) {
            addCriterion("deliver_uid in", values, "deliverUid");
            return (Criteria) this;
        }

        public Criteria andDeliverUidNotIn(List<String> values) {
            addCriterion("deliver_uid not in", values, "deliverUid");
            return (Criteria) this;
        }

        public Criteria andDeliverUidBetween(String value1, String value2) {
            addCriterion("deliver_uid between", value1, value2, "deliverUid");
            return (Criteria) this;
        }

        public Criteria andDeliverUidNotBetween(String value1, String value2) {
            addCriterion("deliver_uid not between", value1, value2, "deliverUid");
            return (Criteria) this;
        }

        public Criteria andReceiptUidIsNull() {
            addCriterion("receipt_uid is null");
            return (Criteria) this;
        }

        public Criteria andReceiptUidIsNotNull() {
            addCriterion("receipt_uid is not null");
            return (Criteria) this;
        }

        public Criteria andReceiptUidEqualTo(String value) {
            addCriterion("receipt_uid =", value, "receiptUid");
            return (Criteria) this;
        }

        public Criteria andReceiptUidNotEqualTo(String value) {
            addCriterion("receipt_uid <>", value, "receiptUid");
            return (Criteria) this;
        }

        public Criteria andReceiptUidGreaterThan(String value) {
            addCriterion("receipt_uid >", value, "receiptUid");
            return (Criteria) this;
        }

        public Criteria andReceiptUidGreaterThanOrEqualTo(String value) {
            addCriterion("receipt_uid >=", value, "receiptUid");
            return (Criteria) this;
        }

        public Criteria andReceiptUidLessThan(String value) {
            addCriterion("receipt_uid <", value, "receiptUid");
            return (Criteria) this;
        }

        public Criteria andReceiptUidLessThanOrEqualTo(String value) {
            addCriterion("receipt_uid <=", value, "receiptUid");
            return (Criteria) this;
        }

        public Criteria andReceiptUidLike(String value) {
            addCriterion("receipt_uid like", value, "receiptUid");
            return (Criteria) this;
        }

        public Criteria andReceiptUidNotLike(String value) {
            addCriterion("receipt_uid not like", value, "receiptUid");
            return (Criteria) this;
        }

        public Criteria andReceiptUidIn(List<String> values) {
            addCriterion("receipt_uid in", values, "receiptUid");
            return (Criteria) this;
        }

        public Criteria andReceiptUidNotIn(List<String> values) {
            addCriterion("receipt_uid not in", values, "receiptUid");
            return (Criteria) this;
        }

        public Criteria andReceiptUidBetween(String value1, String value2) {
            addCriterion("receipt_uid between", value1, value2, "receiptUid");
            return (Criteria) this;
        }

        public Criteria andReceiptUidNotBetween(String value1, String value2) {
            addCriterion("receipt_uid not between", value1, value2, "receiptUid");
            return (Criteria) this;
        }

        public Criteria andCheckerUidIsNull() {
            addCriterion("checker_uid is null");
            return (Criteria) this;
        }

        public Criteria andCheckerUidIsNotNull() {
            addCriterion("checker_uid is not null");
            return (Criteria) this;
        }

        public Criteria andCheckerUidEqualTo(String value) {
            addCriterion("checker_uid =", value, "checkerUid");
            return (Criteria) this;
        }

        public Criteria andCheckerUidNotEqualTo(String value) {
            addCriterion("checker_uid <>", value, "checkerUid");
            return (Criteria) this;
        }

        public Criteria andCheckerUidGreaterThan(String value) {
            addCriterion("checker_uid >", value, "checkerUid");
            return (Criteria) this;
        }

        public Criteria andCheckerUidGreaterThanOrEqualTo(String value) {
            addCriterion("checker_uid >=", value, "checkerUid");
            return (Criteria) this;
        }

        public Criteria andCheckerUidLessThan(String value) {
            addCriterion("checker_uid <", value, "checkerUid");
            return (Criteria) this;
        }

        public Criteria andCheckerUidLessThanOrEqualTo(String value) {
            addCriterion("checker_uid <=", value, "checkerUid");
            return (Criteria) this;
        }

        public Criteria andCheckerUidLike(String value) {
            addCriterion("checker_uid like", value, "checkerUid");
            return (Criteria) this;
        }

        public Criteria andCheckerUidNotLike(String value) {
            addCriterion("checker_uid not like", value, "checkerUid");
            return (Criteria) this;
        }

        public Criteria andCheckerUidIn(List<String> values) {
            addCriterion("checker_uid in", values, "checkerUid");
            return (Criteria) this;
        }

        public Criteria andCheckerUidNotIn(List<String> values) {
            addCriterion("checker_uid not in", values, "checkerUid");
            return (Criteria) this;
        }

        public Criteria andCheckerUidBetween(String value1, String value2) {
            addCriterion("checker_uid between", value1, value2, "checkerUid");
            return (Criteria) this;
        }

        public Criteria andCheckerUidNotBetween(String value1, String value2) {
            addCriterion("checker_uid not between", value1, value2, "checkerUid");
            return (Criteria) this;
        }

        public Criteria andTaskLogStatusIsNull() {
            addCriterion("task_log_status is null");
            return (Criteria) this;
        }

        public Criteria andTaskLogStatusIsNotNull() {
            addCriterion("task_log_status is not null");
            return (Criteria) this;
        }

        public Criteria andTaskLogStatusEqualTo(Byte value) {
            addCriterion("task_log_status =", value, "taskLogStatus");
            return (Criteria) this;
        }

        public Criteria andTaskLogStatusNotEqualTo(Byte value) {
            addCriterion("task_log_status <>", value, "taskLogStatus");
            return (Criteria) this;
        }

        public Criteria andTaskLogStatusGreaterThan(Byte value) {
            addCriterion("task_log_status >", value, "taskLogStatus");
            return (Criteria) this;
        }

        public Criteria andTaskLogStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("task_log_status >=", value, "taskLogStatus");
            return (Criteria) this;
        }

        public Criteria andTaskLogStatusLessThan(Byte value) {
            addCriterion("task_log_status <", value, "taskLogStatus");
            return (Criteria) this;
        }

        public Criteria andTaskLogStatusLessThanOrEqualTo(Byte value) {
            addCriterion("task_log_status <=", value, "taskLogStatus");
            return (Criteria) this;
        }

        public Criteria andTaskLogStatusIn(List<Byte> values) {
            addCriterion("task_log_status in", values, "taskLogStatus");
            return (Criteria) this;
        }

        public Criteria andTaskLogStatusNotIn(List<Byte> values) {
            addCriterion("task_log_status not in", values, "taskLogStatus");
            return (Criteria) this;
        }

        public Criteria andTaskLogStatusBetween(Byte value1, Byte value2) {
            addCriterion("task_log_status between", value1, value2, "taskLogStatus");
            return (Criteria) this;
        }

        public Criteria andTaskLogStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("task_log_status not between", value1, value2, "taskLogStatus");
            return (Criteria) this;
        }

        public Criteria andReserveQuantityIsNull() {
            addCriterion("reserve_quantity is null");
            return (Criteria) this;
        }

        public Criteria andReserveQuantityIsNotNull() {
            addCriterion("reserve_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andReserveQuantityEqualTo(Integer value) {
            addCriterion("reserve_quantity =", value, "reserveQuantity");
            return (Criteria) this;
        }

        public Criteria andReserveQuantityNotEqualTo(Integer value) {
            addCriterion("reserve_quantity <>", value, "reserveQuantity");
            return (Criteria) this;
        }

        public Criteria andReserveQuantityGreaterThan(Integer value) {
            addCriterion("reserve_quantity >", value, "reserveQuantity");
            return (Criteria) this;
        }

        public Criteria andReserveQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("reserve_quantity >=", value, "reserveQuantity");
            return (Criteria) this;
        }

        public Criteria andReserveQuantityLessThan(Integer value) {
            addCriterion("reserve_quantity <", value, "reserveQuantity");
            return (Criteria) this;
        }

        public Criteria andReserveQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("reserve_quantity <=", value, "reserveQuantity");
            return (Criteria) this;
        }

        public Criteria andReserveQuantityIn(List<Integer> values) {
            addCriterion("reserve_quantity in", values, "reserveQuantity");
            return (Criteria) this;
        }

        public Criteria andReserveQuantityNotIn(List<Integer> values) {
            addCriterion("reserve_quantity not in", values, "reserveQuantity");
            return (Criteria) this;
        }

        public Criteria andReserveQuantityBetween(Integer value1, Integer value2) {
            addCriterion("reserve_quantity between", value1, value2, "reserveQuantity");
            return (Criteria) this;
        }

        public Criteria andReserveQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("reserve_quantity not between", value1, value2, "reserveQuantity");
            return (Criteria) this;
        }

        public Criteria andFinallyQuantityIsNull() {
            addCriterion("finally_quantity is null");
            return (Criteria) this;
        }

        public Criteria andFinallyQuantityIsNotNull() {
            addCriterion("finally_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andFinallyQuantityEqualTo(Integer value) {
            addCriterion("finally_quantity =", value, "finallyQuantity");
            return (Criteria) this;
        }

        public Criteria andFinallyQuantityNotEqualTo(Integer value) {
            addCriterion("finally_quantity <>", value, "finallyQuantity");
            return (Criteria) this;
        }

        public Criteria andFinallyQuantityGreaterThan(Integer value) {
            addCriterion("finally_quantity >", value, "finallyQuantity");
            return (Criteria) this;
        }

        public Criteria andFinallyQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("finally_quantity >=", value, "finallyQuantity");
            return (Criteria) this;
        }

        public Criteria andFinallyQuantityLessThan(Integer value) {
            addCriterion("finally_quantity <", value, "finallyQuantity");
            return (Criteria) this;
        }

        public Criteria andFinallyQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("finally_quantity <=", value, "finallyQuantity");
            return (Criteria) this;
        }

        public Criteria andFinallyQuantityIn(List<Integer> values) {
            addCriterion("finally_quantity in", values, "finallyQuantity");
            return (Criteria) this;
        }

        public Criteria andFinallyQuantityNotIn(List<Integer> values) {
            addCriterion("finally_quantity not in", values, "finallyQuantity");
            return (Criteria) this;
        }

        public Criteria andFinallyQuantityBetween(Integer value1, Integer value2) {
            addCriterion("finally_quantity between", value1, value2, "finallyQuantity");
            return (Criteria) this;
        }

        public Criteria andFinallyQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("finally_quantity not between", value1, value2, "finallyQuantity");
            return (Criteria) this;
        }

        public Criteria andReserveWeightIsNull() {
            addCriterion("reserve_weight is null");
            return (Criteria) this;
        }

        public Criteria andReserveWeightIsNotNull() {
            addCriterion("reserve_weight is not null");
            return (Criteria) this;
        }

        public Criteria andReserveWeightEqualTo(Long value) {
            addCriterion("reserve_weight =", value, "reserveWeight");
            return (Criteria) this;
        }

        public Criteria andReserveWeightNotEqualTo(Long value) {
            addCriterion("reserve_weight <>", value, "reserveWeight");
            return (Criteria) this;
        }

        public Criteria andReserveWeightGreaterThan(Long value) {
            addCriterion("reserve_weight >", value, "reserveWeight");
            return (Criteria) this;
        }

        public Criteria andReserveWeightGreaterThanOrEqualTo(Long value) {
            addCriterion("reserve_weight >=", value, "reserveWeight");
            return (Criteria) this;
        }

        public Criteria andReserveWeightLessThan(Long value) {
            addCriterion("reserve_weight <", value, "reserveWeight");
            return (Criteria) this;
        }

        public Criteria andReserveWeightLessThanOrEqualTo(Long value) {
            addCriterion("reserve_weight <=", value, "reserveWeight");
            return (Criteria) this;
        }

        public Criteria andReserveWeightIn(List<Long> values) {
            addCriterion("reserve_weight in", values, "reserveWeight");
            return (Criteria) this;
        }

        public Criteria andReserveWeightNotIn(List<Long> values) {
            addCriterion("reserve_weight not in", values, "reserveWeight");
            return (Criteria) this;
        }

        public Criteria andReserveWeightBetween(Long value1, Long value2) {
            addCriterion("reserve_weight between", value1, value2, "reserveWeight");
            return (Criteria) this;
        }

        public Criteria andReserveWeightNotBetween(Long value1, Long value2) {
            addCriterion("reserve_weight not between", value1, value2, "reserveWeight");
            return (Criteria) this;
        }

        public Criteria andFinallyWeightIsNull() {
            addCriterion("finally_weight is null");
            return (Criteria) this;
        }

        public Criteria andFinallyWeightIsNotNull() {
            addCriterion("finally_weight is not null");
            return (Criteria) this;
        }

        public Criteria andFinallyWeightEqualTo(Long value) {
            addCriterion("finally_weight =", value, "finallyWeight");
            return (Criteria) this;
        }

        public Criteria andFinallyWeightNotEqualTo(Long value) {
            addCriterion("finally_weight <>", value, "finallyWeight");
            return (Criteria) this;
        }

        public Criteria andFinallyWeightGreaterThan(Long value) {
            addCriterion("finally_weight >", value, "finallyWeight");
            return (Criteria) this;
        }

        public Criteria andFinallyWeightGreaterThanOrEqualTo(Long value) {
            addCriterion("finally_weight >=", value, "finallyWeight");
            return (Criteria) this;
        }

        public Criteria andFinallyWeightLessThan(Long value) {
            addCriterion("finally_weight <", value, "finallyWeight");
            return (Criteria) this;
        }

        public Criteria andFinallyWeightLessThanOrEqualTo(Long value) {
            addCriterion("finally_weight <=", value, "finallyWeight");
            return (Criteria) this;
        }

        public Criteria andFinallyWeightIn(List<Long> values) {
            addCriterion("finally_weight in", values, "finallyWeight");
            return (Criteria) this;
        }

        public Criteria andFinallyWeightNotIn(List<Long> values) {
            addCriterion("finally_weight not in", values, "finallyWeight");
            return (Criteria) this;
        }

        public Criteria andFinallyWeightBetween(Long value1, Long value2) {
            addCriterion("finally_weight between", value1, value2, "finallyWeight");
            return (Criteria) this;
        }

        public Criteria andFinallyWeightNotBetween(Long value1, Long value2) {
            addCriterion("finally_weight not between", value1, value2, "finallyWeight");
            return (Criteria) this;
        }

        public Criteria andQueueIndexIsNull() {
            addCriterion("queue_index is null");
            return (Criteria) this;
        }

        public Criteria andQueueIndexIsNotNull() {
            addCriterion("queue_index is not null");
            return (Criteria) this;
        }

        public Criteria andQueueIndexEqualTo(Short value) {
            addCriterion("queue_index =", value, "queueIndex");
            return (Criteria) this;
        }

        public Criteria andQueueIndexNotEqualTo(Short value) {
            addCriterion("queue_index <>", value, "queueIndex");
            return (Criteria) this;
        }

        public Criteria andQueueIndexGreaterThan(Short value) {
            addCriterion("queue_index >", value, "queueIndex");
            return (Criteria) this;
        }

        public Criteria andQueueIndexGreaterThanOrEqualTo(Short value) {
            addCriterion("queue_index >=", value, "queueIndex");
            return (Criteria) this;
        }

        public Criteria andQueueIndexLessThan(Short value) {
            addCriterion("queue_index <", value, "queueIndex");
            return (Criteria) this;
        }

        public Criteria andQueueIndexLessThanOrEqualTo(Short value) {
            addCriterion("queue_index <=", value, "queueIndex");
            return (Criteria) this;
        }

        public Criteria andQueueIndexIn(List<Short> values) {
            addCriterion("queue_index in", values, "queueIndex");
            return (Criteria) this;
        }

        public Criteria andQueueIndexNotIn(List<Short> values) {
            addCriterion("queue_index not in", values, "queueIndex");
            return (Criteria) this;
        }

        public Criteria andQueueIndexBetween(Short value1, Short value2) {
            addCriterion("queue_index between", value1, value2, "queueIndex");
            return (Criteria) this;
        }

        public Criteria andQueueIndexNotBetween(Short value1, Short value2) {
            addCriterion("queue_index not between", value1, value2, "queueIndex");
            return (Criteria) this;
        }

        public Criteria andNumberPlateIsNull() {
            addCriterion("number_plate is null");
            return (Criteria) this;
        }

        public Criteria andNumberPlateIsNotNull() {
            addCriterion("number_plate is not null");
            return (Criteria) this;
        }

        public Criteria andNumberPlateEqualTo(String value) {
            addCriterion("number_plate =", value, "numberPlate");
            return (Criteria) this;
        }

        public Criteria andNumberPlateNotEqualTo(String value) {
            addCriterion("number_plate <>", value, "numberPlate");
            return (Criteria) this;
        }

        public Criteria andNumberPlateGreaterThan(String value) {
            addCriterion("number_plate >", value, "numberPlate");
            return (Criteria) this;
        }

        public Criteria andNumberPlateGreaterThanOrEqualTo(String value) {
            addCriterion("number_plate >=", value, "numberPlate");
            return (Criteria) this;
        }

        public Criteria andNumberPlateLessThan(String value) {
            addCriterion("number_plate <", value, "numberPlate");
            return (Criteria) this;
        }

        public Criteria andNumberPlateLessThanOrEqualTo(String value) {
            addCriterion("number_plate <=", value, "numberPlate");
            return (Criteria) this;
        }

        public Criteria andNumberPlateLike(String value) {
            addCriterion("number_plate like", value, "numberPlate");
            return (Criteria) this;
        }

        public Criteria andNumberPlateNotLike(String value) {
            addCriterion("number_plate not like", value, "numberPlate");
            return (Criteria) this;
        }

        public Criteria andNumberPlateIn(List<String> values) {
            addCriterion("number_plate in", values, "numberPlate");
            return (Criteria) this;
        }

        public Criteria andNumberPlateNotIn(List<String> values) {
            addCriterion("number_plate not in", values, "numberPlate");
            return (Criteria) this;
        }

        public Criteria andNumberPlateBetween(String value1, String value2) {
            addCriterion("number_plate between", value1, value2, "numberPlate");
            return (Criteria) this;
        }

        public Criteria andNumberPlateNotBetween(String value1, String value2) {
            addCriterion("number_plate not between", value1, value2, "numberPlate");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoteCodeIsNull() {
            addCriterion("delivery_note_code is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoteCodeIsNotNull() {
            addCriterion("delivery_note_code is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoteCodeEqualTo(String value) {
            addCriterion("delivery_note_code =", value, "deliveryNoteCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoteCodeNotEqualTo(String value) {
            addCriterion("delivery_note_code <>", value, "deliveryNoteCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoteCodeGreaterThan(String value) {
            addCriterion("delivery_note_code >", value, "deliveryNoteCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoteCodeGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_note_code >=", value, "deliveryNoteCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoteCodeLessThan(String value) {
            addCriterion("delivery_note_code <", value, "deliveryNoteCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoteCodeLessThanOrEqualTo(String value) {
            addCriterion("delivery_note_code <=", value, "deliveryNoteCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoteCodeLike(String value) {
            addCriterion("delivery_note_code like", value, "deliveryNoteCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoteCodeNotLike(String value) {
            addCriterion("delivery_note_code not like", value, "deliveryNoteCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoteCodeIn(List<String> values) {
            addCriterion("delivery_note_code in", values, "deliveryNoteCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoteCodeNotIn(List<String> values) {
            addCriterion("delivery_note_code not in", values, "deliveryNoteCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoteCodeBetween(String value1, String value2) {
            addCriterion("delivery_note_code between", value1, value2, "deliveryNoteCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoteCodeNotBetween(String value1, String value2) {
            addCriterion("delivery_note_code not between", value1, value2, "deliveryNoteCode");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoteImageIsNull() {
            addCriterion("delivery_note_image is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoteImageIsNotNull() {
            addCriterion("delivery_note_image is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoteImageEqualTo(String value) {
            addCriterion("delivery_note_image =", value, "deliveryNoteImage");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoteImageNotEqualTo(String value) {
            addCriterion("delivery_note_image <>", value, "deliveryNoteImage");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoteImageGreaterThan(String value) {
            addCriterion("delivery_note_image >", value, "deliveryNoteImage");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoteImageGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_note_image >=", value, "deliveryNoteImage");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoteImageLessThan(String value) {
            addCriterion("delivery_note_image <", value, "deliveryNoteImage");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoteImageLessThanOrEqualTo(String value) {
            addCriterion("delivery_note_image <=", value, "deliveryNoteImage");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoteImageLike(String value) {
            addCriterion("delivery_note_image like", value, "deliveryNoteImage");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoteImageNotLike(String value) {
            addCriterion("delivery_note_image not like", value, "deliveryNoteImage");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoteImageIn(List<String> values) {
            addCriterion("delivery_note_image in", values, "deliveryNoteImage");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoteImageNotIn(List<String> values) {
            addCriterion("delivery_note_image not in", values, "deliveryNoteImage");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoteImageBetween(String value1, String value2) {
            addCriterion("delivery_note_image between", value1, value2, "deliveryNoteImage");
            return (Criteria) this;
        }

        public Criteria andDeliveryNoteImageNotBetween(String value1, String value2) {
            addCriterion("delivery_note_image not between", value1, value2, "deliveryNoteImage");
            return (Criteria) this;
        }

        public Criteria andInboundDeliveryNoteNumberIsNull() {
            addCriterion("inbound_delivery_note_number is null");
            return (Criteria) this;
        }

        public Criteria andInboundDeliveryNoteNumberIsNotNull() {
            addCriterion("inbound_delivery_note_number is not null");
            return (Criteria) this;
        }

        public Criteria andInboundDeliveryNoteNumberEqualTo(String value) {
            addCriterion("inbound_delivery_note_number =", value, "inboundDeliveryNoteNumber");
            return (Criteria) this;
        }

        public Criteria andInboundDeliveryNoteNumberNotEqualTo(String value) {
            addCriterion("inbound_delivery_note_number <>", value, "inboundDeliveryNoteNumber");
            return (Criteria) this;
        }

        public Criteria andInboundDeliveryNoteNumberGreaterThan(String value) {
            addCriterion("inbound_delivery_note_number >", value, "inboundDeliveryNoteNumber");
            return (Criteria) this;
        }

        public Criteria andInboundDeliveryNoteNumberGreaterThanOrEqualTo(String value) {
            addCriterion("inbound_delivery_note_number >=", value, "inboundDeliveryNoteNumber");
            return (Criteria) this;
        }

        public Criteria andInboundDeliveryNoteNumberLessThan(String value) {
            addCriterion("inbound_delivery_note_number <", value, "inboundDeliveryNoteNumber");
            return (Criteria) this;
        }

        public Criteria andInboundDeliveryNoteNumberLessThanOrEqualTo(String value) {
            addCriterion("inbound_delivery_note_number <=", value, "inboundDeliveryNoteNumber");
            return (Criteria) this;
        }

        public Criteria andInboundDeliveryNoteNumberLike(String value) {
            addCriterion("inbound_delivery_note_number like", value, "inboundDeliveryNoteNumber");
            return (Criteria) this;
        }

        public Criteria andInboundDeliveryNoteNumberNotLike(String value) {
            addCriterion("inbound_delivery_note_number not like", value, "inboundDeliveryNoteNumber");
            return (Criteria) this;
        }

        public Criteria andInboundDeliveryNoteNumberIn(List<String> values) {
            addCriterion("inbound_delivery_note_number in", values, "inboundDeliveryNoteNumber");
            return (Criteria) this;
        }

        public Criteria andInboundDeliveryNoteNumberNotIn(List<String> values) {
            addCriterion("inbound_delivery_note_number not in", values, "inboundDeliveryNoteNumber");
            return (Criteria) this;
        }

        public Criteria andInboundDeliveryNoteNumberBetween(String value1, String value2) {
            addCriterion("inbound_delivery_note_number between", value1, value2, "inboundDeliveryNoteNumber");
            return (Criteria) this;
        }

        public Criteria andInboundDeliveryNoteNumberNotBetween(String value1, String value2) {
            addCriterion("inbound_delivery_note_number not between", value1, value2, "inboundDeliveryNoteNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberIsNull() {
            addCriterion("purchase_order_number is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberIsNotNull() {
            addCriterion("purchase_order_number is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberEqualTo(String value) {
            addCriterion("purchase_order_number =", value, "purchaseOrderNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberNotEqualTo(String value) {
            addCriterion("purchase_order_number <>", value, "purchaseOrderNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberGreaterThan(String value) {
            addCriterion("purchase_order_number >", value, "purchaseOrderNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberGreaterThanOrEqualTo(String value) {
            addCriterion("purchase_order_number >=", value, "purchaseOrderNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberLessThan(String value) {
            addCriterion("purchase_order_number <", value, "purchaseOrderNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberLessThanOrEqualTo(String value) {
            addCriterion("purchase_order_number <=", value, "purchaseOrderNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberLike(String value) {
            addCriterion("purchase_order_number like", value, "purchaseOrderNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberNotLike(String value) {
            addCriterion("purchase_order_number not like", value, "purchaseOrderNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberIn(List<String> values) {
            addCriterion("purchase_order_number in", values, "purchaseOrderNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberNotIn(List<String> values) {
            addCriterion("purchase_order_number not in", values, "purchaseOrderNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberBetween(String value1, String value2) {
            addCriterion("purchase_order_number between", value1, value2, "purchaseOrderNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseOrderNumberNotBetween(String value1, String value2) {
            addCriterion("purchase_order_number not between", value1, value2, "purchaseOrderNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberIsNull() {
            addCriterion("item_number is null");
            return (Criteria) this;
        }

        public Criteria andItemNumberIsNotNull() {
            addCriterion("item_number is not null");
            return (Criteria) this;
        }

        public Criteria andItemNumberEqualTo(String value) {
            addCriterion("item_number =", value, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberNotEqualTo(String value) {
            addCriterion("item_number <>", value, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberGreaterThan(String value) {
            addCriterion("item_number >", value, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberGreaterThanOrEqualTo(String value) {
            addCriterion("item_number >=", value, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberLessThan(String value) {
            addCriterion("item_number <", value, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberLessThanOrEqualTo(String value) {
            addCriterion("item_number <=", value, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberLike(String value) {
            addCriterion("item_number like", value, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberNotLike(String value) {
            addCriterion("item_number not like", value, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberIn(List<String> values) {
            addCriterion("item_number in", values, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberNotIn(List<String> values) {
            addCriterion("item_number not in", values, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberBetween(String value1, String value2) {
            addCriterion("item_number between", value1, value2, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberNotBetween(String value1, String value2) {
            addCriterion("item_number not between", value1, value2, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionIsNull() {
            addCriterion("item_description is null");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionIsNotNull() {
            addCriterion("item_description is not null");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionEqualTo(String value) {
            addCriterion("item_description =", value, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionNotEqualTo(String value) {
            addCriterion("item_description <>", value, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionGreaterThan(String value) {
            addCriterion("item_description >", value, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("item_description >=", value, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionLessThan(String value) {
            addCriterion("item_description <", value, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionLessThanOrEqualTo(String value) {
            addCriterion("item_description <=", value, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionLike(String value) {
            addCriterion("item_description like", value, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionNotLike(String value) {
            addCriterion("item_description not like", value, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionIn(List<String> values) {
            addCriterion("item_description in", values, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionNotIn(List<String> values) {
            addCriterion("item_description not in", values, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionBetween(String value1, String value2) {
            addCriterion("item_description between", value1, value2, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andItemDescriptionNotBetween(String value1, String value2) {
            addCriterion("item_description not between", value1, value2, "itemDescription");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andRequestedDeliveryTimeIsNull() {
            addCriterion("requested_delivery_time is null");
            return (Criteria) this;
        }

        public Criteria andRequestedDeliveryTimeIsNotNull() {
            addCriterion("requested_delivery_time is not null");
            return (Criteria) this;
        }

        public Criteria andRequestedDeliveryTimeEqualTo(Long value) {
            addCriterion("requested_delivery_time =", value, "requestedDeliveryTime");
            return (Criteria) this;
        }

        public Criteria andRequestedDeliveryTimeNotEqualTo(Long value) {
            addCriterion("requested_delivery_time <>", value, "requestedDeliveryTime");
            return (Criteria) this;
        }

        public Criteria andRequestedDeliveryTimeGreaterThan(Long value) {
            addCriterion("requested_delivery_time >", value, "requestedDeliveryTime");
            return (Criteria) this;
        }

        public Criteria andRequestedDeliveryTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("requested_delivery_time >=", value, "requestedDeliveryTime");
            return (Criteria) this;
        }

        public Criteria andRequestedDeliveryTimeLessThan(Long value) {
            addCriterion("requested_delivery_time <", value, "requestedDeliveryTime");
            return (Criteria) this;
        }

        public Criteria andRequestedDeliveryTimeLessThanOrEqualTo(Long value) {
            addCriterion("requested_delivery_time <=", value, "requestedDeliveryTime");
            return (Criteria) this;
        }

        public Criteria andRequestedDeliveryTimeIn(List<Long> values) {
            addCriterion("requested_delivery_time in", values, "requestedDeliveryTime");
            return (Criteria) this;
        }

        public Criteria andRequestedDeliveryTimeNotIn(List<Long> values) {
            addCriterion("requested_delivery_time not in", values, "requestedDeliveryTime");
            return (Criteria) this;
        }

        public Criteria andRequestedDeliveryTimeBetween(Long value1, Long value2) {
            addCriterion("requested_delivery_time between", value1, value2, "requestedDeliveryTime");
            return (Criteria) this;
        }

        public Criteria andRequestedDeliveryTimeNotBetween(Long value1, Long value2) {
            addCriterion("requested_delivery_time not between", value1, value2, "requestedDeliveryTime");
            return (Criteria) this;
        }

        public Criteria andExemptFromInspectionIsNull() {
            addCriterion("exempt_from_inspection is null");
            return (Criteria) this;
        }

        public Criteria andExemptFromInspectionIsNotNull() {
            addCriterion("exempt_from_inspection is not null");
            return (Criteria) this;
        }

        public Criteria andExemptFromInspectionEqualTo(Byte value) {
            addCriterion("exempt_from_inspection =", value, "exemptFromInspection");
            return (Criteria) this;
        }

        public Criteria andExemptFromInspectionNotEqualTo(Byte value) {
            addCriterion("exempt_from_inspection <>", value, "exemptFromInspection");
            return (Criteria) this;
        }

        public Criteria andExemptFromInspectionGreaterThan(Byte value) {
            addCriterion("exempt_from_inspection >", value, "exemptFromInspection");
            return (Criteria) this;
        }

        public Criteria andExemptFromInspectionGreaterThanOrEqualTo(Byte value) {
            addCriterion("exempt_from_inspection >=", value, "exemptFromInspection");
            return (Criteria) this;
        }

        public Criteria andExemptFromInspectionLessThan(Byte value) {
            addCriterion("exempt_from_inspection <", value, "exemptFromInspection");
            return (Criteria) this;
        }

        public Criteria andExemptFromInspectionLessThanOrEqualTo(Byte value) {
            addCriterion("exempt_from_inspection <=", value, "exemptFromInspection");
            return (Criteria) this;
        }

        public Criteria andExemptFromInspectionIn(List<Byte> values) {
            addCriterion("exempt_from_inspection in", values, "exemptFromInspection");
            return (Criteria) this;
        }

        public Criteria andExemptFromInspectionNotIn(List<Byte> values) {
            addCriterion("exempt_from_inspection not in", values, "exemptFromInspection");
            return (Criteria) this;
        }

        public Criteria andExemptFromInspectionBetween(Byte value1, Byte value2) {
            addCriterion("exempt_from_inspection between", value1, value2, "exemptFromInspection");
            return (Criteria) this;
        }

        public Criteria andExemptFromInspectionNotBetween(Byte value1, Byte value2) {
            addCriterion("exempt_from_inspection not between", value1, value2, "exemptFromInspection");
            return (Criteria) this;
        }

        public Criteria andEarliestDeliveryTimeIsNull() {
            addCriterion("earliest_delivery_time is null");
            return (Criteria) this;
        }

        public Criteria andEarliestDeliveryTimeIsNotNull() {
            addCriterion("earliest_delivery_time is not null");
            return (Criteria) this;
        }

        public Criteria andEarliestDeliveryTimeEqualTo(Long value) {
            addCriterion("earliest_delivery_time =", value, "earliestDeliveryTime");
            return (Criteria) this;
        }

        public Criteria andEarliestDeliveryTimeNotEqualTo(Long value) {
            addCriterion("earliest_delivery_time <>", value, "earliestDeliveryTime");
            return (Criteria) this;
        }

        public Criteria andEarliestDeliveryTimeGreaterThan(Long value) {
            addCriterion("earliest_delivery_time >", value, "earliestDeliveryTime");
            return (Criteria) this;
        }

        public Criteria andEarliestDeliveryTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("earliest_delivery_time >=", value, "earliestDeliveryTime");
            return (Criteria) this;
        }

        public Criteria andEarliestDeliveryTimeLessThan(Long value) {
            addCriterion("earliest_delivery_time <", value, "earliestDeliveryTime");
            return (Criteria) this;
        }

        public Criteria andEarliestDeliveryTimeLessThanOrEqualTo(Long value) {
            addCriterion("earliest_delivery_time <=", value, "earliestDeliveryTime");
            return (Criteria) this;
        }

        public Criteria andEarliestDeliveryTimeIn(List<Long> values) {
            addCriterion("earliest_delivery_time in", values, "earliestDeliveryTime");
            return (Criteria) this;
        }

        public Criteria andEarliestDeliveryTimeNotIn(List<Long> values) {
            addCriterion("earliest_delivery_time not in", values, "earliestDeliveryTime");
            return (Criteria) this;
        }

        public Criteria andEarliestDeliveryTimeBetween(Long value1, Long value2) {
            addCriterion("earliest_delivery_time between", value1, value2, "earliestDeliveryTime");
            return (Criteria) this;
        }

        public Criteria andEarliestDeliveryTimeNotBetween(Long value1, Long value2) {
            addCriterion("earliest_delivery_time not between", value1, value2, "earliestDeliveryTime");
            return (Criteria) this;
        }

        public Criteria andLatestDeliveryDateIsNull() {
            addCriterion("latest_delivery_date is null");
            return (Criteria) this;
        }

        public Criteria andLatestDeliveryDateIsNotNull() {
            addCriterion("latest_delivery_date is not null");
            return (Criteria) this;
        }

        public Criteria andLatestDeliveryDateEqualTo(Long value) {
            addCriterion("latest_delivery_date =", value, "latestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andLatestDeliveryDateNotEqualTo(Long value) {
            addCriterion("latest_delivery_date <>", value, "latestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andLatestDeliveryDateGreaterThan(Long value) {
            addCriterion("latest_delivery_date >", value, "latestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andLatestDeliveryDateGreaterThanOrEqualTo(Long value) {
            addCriterion("latest_delivery_date >=", value, "latestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andLatestDeliveryDateLessThan(Long value) {
            addCriterion("latest_delivery_date <", value, "latestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andLatestDeliveryDateLessThanOrEqualTo(Long value) {
            addCriterion("latest_delivery_date <=", value, "latestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andLatestDeliveryDateIn(List<Long> values) {
            addCriterion("latest_delivery_date in", values, "latestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andLatestDeliveryDateNotIn(List<Long> values) {
            addCriterion("latest_delivery_date not in", values, "latestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andLatestDeliveryDateBetween(Long value1, Long value2) {
            addCriterion("latest_delivery_date between", value1, value2, "latestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andLatestDeliveryDateNotBetween(Long value1, Long value2) {
            addCriterion("latest_delivery_date not between", value1, value2, "latestDeliveryDate");
            return (Criteria) this;
        }

        public Criteria andShelfLifeIsNull() {
            addCriterion("shelf_life is null");
            return (Criteria) this;
        }

        public Criteria andShelfLifeIsNotNull() {
            addCriterion("shelf_life is not null");
            return (Criteria) this;
        }

        public Criteria andShelfLifeEqualTo(Long value) {
            addCriterion("shelf_life =", value, "shelfLife");
            return (Criteria) this;
        }

        public Criteria andShelfLifeNotEqualTo(Long value) {
            addCriterion("shelf_life <>", value, "shelfLife");
            return (Criteria) this;
        }

        public Criteria andShelfLifeGreaterThan(Long value) {
            addCriterion("shelf_life >", value, "shelfLife");
            return (Criteria) this;
        }

        public Criteria andShelfLifeGreaterThanOrEqualTo(Long value) {
            addCriterion("shelf_life >=", value, "shelfLife");
            return (Criteria) this;
        }

        public Criteria andShelfLifeLessThan(Long value) {
            addCriterion("shelf_life <", value, "shelfLife");
            return (Criteria) this;
        }

        public Criteria andShelfLifeLessThanOrEqualTo(Long value) {
            addCriterion("shelf_life <=", value, "shelfLife");
            return (Criteria) this;
        }

        public Criteria andShelfLifeIn(List<Long> values) {
            addCriterion("shelf_life in", values, "shelfLife");
            return (Criteria) this;
        }

        public Criteria andShelfLifeNotIn(List<Long> values) {
            addCriterion("shelf_life not in", values, "shelfLife");
            return (Criteria) this;
        }

        public Criteria andShelfLifeBetween(Long value1, Long value2) {
            addCriterion("shelf_life between", value1, value2, "shelfLife");
            return (Criteria) this;
        }

        public Criteria andShelfLifeNotBetween(Long value1, Long value2) {
            addCriterion("shelf_life not between", value1, value2, "shelfLife");
            return (Criteria) this;
        }

        public Criteria andNotifyDriverTimeIsNull() {
            addCriterion("notify_driver_time is null");
            return (Criteria) this;
        }

        public Criteria andNotifyDriverTimeIsNotNull() {
            addCriterion("notify_driver_time is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyDriverTimeEqualTo(Long value) {
            addCriterion("notify_driver_time =", value, "notifyDriverTime");
            return (Criteria) this;
        }

        public Criteria andNotifyDriverTimeNotEqualTo(Long value) {
            addCriterion("notify_driver_time <>", value, "notifyDriverTime");
            return (Criteria) this;
        }

        public Criteria andNotifyDriverTimeGreaterThan(Long value) {
            addCriterion("notify_driver_time >", value, "notifyDriverTime");
            return (Criteria) this;
        }

        public Criteria andNotifyDriverTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("notify_driver_time >=", value, "notifyDriverTime");
            return (Criteria) this;
        }

        public Criteria andNotifyDriverTimeLessThan(Long value) {
            addCriterion("notify_driver_time <", value, "notifyDriverTime");
            return (Criteria) this;
        }

        public Criteria andNotifyDriverTimeLessThanOrEqualTo(Long value) {
            addCriterion("notify_driver_time <=", value, "notifyDriverTime");
            return (Criteria) this;
        }

        public Criteria andNotifyDriverTimeIn(List<Long> values) {
            addCriterion("notify_driver_time in", values, "notifyDriverTime");
            return (Criteria) this;
        }

        public Criteria andNotifyDriverTimeNotIn(List<Long> values) {
            addCriterion("notify_driver_time not in", values, "notifyDriverTime");
            return (Criteria) this;
        }

        public Criteria andNotifyDriverTimeBetween(Long value1, Long value2) {
            addCriterion("notify_driver_time between", value1, value2, "notifyDriverTime");
            return (Criteria) this;
        }

        public Criteria andNotifyDriverTimeNotBetween(Long value1, Long value2) {
            addCriterion("notify_driver_time not between", value1, value2, "notifyDriverTime");
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

        public Criteria andCheckTimeIsNull() {
            addCriterion("check_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNotNull() {
            addCriterion("check_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeEqualTo(Long value) {
            addCriterion("check_time =", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotEqualTo(Long value) {
            addCriterion("check_time <>", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThan(Long value) {
            addCriterion("check_time >", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("check_time >=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThan(Long value) {
            addCriterion("check_time <", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThanOrEqualTo(Long value) {
            addCriterion("check_time <=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIn(List<Long> values) {
            addCriterion("check_time in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotIn(List<Long> values) {
            addCriterion("check_time not in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeBetween(Long value1, Long value2) {
            addCriterion("check_time between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotBetween(Long value1, Long value2) {
            addCriterion("check_time not between", value1, value2, "checkTime");
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

        public Criteria andQueuingAreaIdIsNull() {
            addCriterion("queuing_area_id is null");
            return (Criteria) this;
        }

        public Criteria andQueuingAreaIdIsNotNull() {
            addCriterion("queuing_area_id is not null");
            return (Criteria) this;
        }

        public Criteria andQueuingAreaIdEqualTo(Long value) {
            addCriterion("queuing_area_id =", value, "queuingAreaId");
            return (Criteria) this;
        }

        public Criteria andQueuingAreaIdNotEqualTo(Long value) {
            addCriterion("queuing_area_id <>", value, "queuingAreaId");
            return (Criteria) this;
        }

        public Criteria andQueuingAreaIdGreaterThan(Long value) {
            addCriterion("queuing_area_id >", value, "queuingAreaId");
            return (Criteria) this;
        }

        public Criteria andQueuingAreaIdGreaterThanOrEqualTo(Long value) {
            addCriterion("queuing_area_id >=", value, "queuingAreaId");
            return (Criteria) this;
        }

        public Criteria andQueuingAreaIdLessThan(Long value) {
            addCriterion("queuing_area_id <", value, "queuingAreaId");
            return (Criteria) this;
        }

        public Criteria andQueuingAreaIdLessThanOrEqualTo(Long value) {
            addCriterion("queuing_area_id <=", value, "queuingAreaId");
            return (Criteria) this;
        }

        public Criteria andQueuingAreaIdIn(List<Long> values) {
            addCriterion("queuing_area_id in", values, "queuingAreaId");
            return (Criteria) this;
        }

        public Criteria andQueuingAreaIdNotIn(List<Long> values) {
            addCriterion("queuing_area_id not in", values, "queuingAreaId");
            return (Criteria) this;
        }

        public Criteria andQueuingAreaIdBetween(Long value1, Long value2) {
            addCriterion("queuing_area_id between", value1, value2, "queuingAreaId");
            return (Criteria) this;
        }

        public Criteria andQueuingAreaIdNotBetween(Long value1, Long value2) {
            addCriterion("queuing_area_id not between", value1, value2, "queuingAreaId");
            return (Criteria) this;
        }

        public Criteria andStartQueuingTimeIsNull() {
            addCriterion("start_queuing_time is null");
            return (Criteria) this;
        }

        public Criteria andStartQueuingTimeIsNotNull() {
            addCriterion("start_queuing_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartQueuingTimeEqualTo(Long value) {
            addCriterion("start_queuing_time =", value, "startQueuingTime");
            return (Criteria) this;
        }

        public Criteria andStartQueuingTimeNotEqualTo(Long value) {
            addCriterion("start_queuing_time <>", value, "startQueuingTime");
            return (Criteria) this;
        }

        public Criteria andStartQueuingTimeGreaterThan(Long value) {
            addCriterion("start_queuing_time >", value, "startQueuingTime");
            return (Criteria) this;
        }

        public Criteria andStartQueuingTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("start_queuing_time >=", value, "startQueuingTime");
            return (Criteria) this;
        }

        public Criteria andStartQueuingTimeLessThan(Long value) {
            addCriterion("start_queuing_time <", value, "startQueuingTime");
            return (Criteria) this;
        }

        public Criteria andStartQueuingTimeLessThanOrEqualTo(Long value) {
            addCriterion("start_queuing_time <=", value, "startQueuingTime");
            return (Criteria) this;
        }

        public Criteria andStartQueuingTimeIn(List<Long> values) {
            addCriterion("start_queuing_time in", values, "startQueuingTime");
            return (Criteria) this;
        }

        public Criteria andStartQueuingTimeNotIn(List<Long> values) {
            addCriterion("start_queuing_time not in", values, "startQueuingTime");
            return (Criteria) this;
        }

        public Criteria andStartQueuingTimeBetween(Long value1, Long value2) {
            addCriterion("start_queuing_time between", value1, value2, "startQueuingTime");
            return (Criteria) this;
        }

        public Criteria andStartQueuingTimeNotBetween(Long value1, Long value2) {
            addCriterion("start_queuing_time not between", value1, value2, "startQueuingTime");
            return (Criteria) this;
        }

        public Criteria andCallTimeIsNull() {
            addCriterion("call_time is null");
            return (Criteria) this;
        }

        public Criteria andCallTimeIsNotNull() {
            addCriterion("call_time is not null");
            return (Criteria) this;
        }

        public Criteria andCallTimeEqualTo(Long value) {
            addCriterion("call_time =", value, "callTime");
            return (Criteria) this;
        }

        public Criteria andCallTimeNotEqualTo(Long value) {
            addCriterion("call_time <>", value, "callTime");
            return (Criteria) this;
        }

        public Criteria andCallTimeGreaterThan(Long value) {
            addCriterion("call_time >", value, "callTime");
            return (Criteria) this;
        }

        public Criteria andCallTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("call_time >=", value, "callTime");
            return (Criteria) this;
        }

        public Criteria andCallTimeLessThan(Long value) {
            addCriterion("call_time <", value, "callTime");
            return (Criteria) this;
        }

        public Criteria andCallTimeLessThanOrEqualTo(Long value) {
            addCriterion("call_time <=", value, "callTime");
            return (Criteria) this;
        }

        public Criteria andCallTimeIn(List<Long> values) {
            addCriterion("call_time in", values, "callTime");
            return (Criteria) this;
        }

        public Criteria andCallTimeNotIn(List<Long> values) {
            addCriterion("call_time not in", values, "callTime");
            return (Criteria) this;
        }

        public Criteria andCallTimeBetween(Long value1, Long value2) {
            addCriterion("call_time between", value1, value2, "callTime");
            return (Criteria) this;
        }

        public Criteria andCallTimeNotBetween(Long value1, Long value2) {
            addCriterion("call_time not between", value1, value2, "callTime");
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