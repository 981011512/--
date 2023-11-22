package com.cf.pay.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CfOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfOrderExample() {
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

        public Criteria andRandomIdIsNull() {
            addCriterion("random_id is null");
            return (Criteria) this;
        }

        public Criteria andRandomIdIsNotNull() {
            addCriterion("random_id is not null");
            return (Criteria) this;
        }

        public Criteria andRandomIdEqualTo(String value) {
            addCriterion("random_id =", value, "randomId");
            return (Criteria) this;
        }

        public Criteria andRandomIdNotEqualTo(String value) {
            addCriterion("random_id <>", value, "randomId");
            return (Criteria) this;
        }

        public Criteria andRandomIdGreaterThan(String value) {
            addCriterion("random_id >", value, "randomId");
            return (Criteria) this;
        }

        public Criteria andRandomIdGreaterThanOrEqualTo(String value) {
            addCriterion("random_id >=", value, "randomId");
            return (Criteria) this;
        }

        public Criteria andRandomIdLessThan(String value) {
            addCriterion("random_id <", value, "randomId");
            return (Criteria) this;
        }

        public Criteria andRandomIdLessThanOrEqualTo(String value) {
            addCriterion("random_id <=", value, "randomId");
            return (Criteria) this;
        }

        public Criteria andRandomIdLike(String value) {
            addCriterion("random_id like", value, "randomId");
            return (Criteria) this;
        }

        public Criteria andRandomIdNotLike(String value) {
            addCriterion("random_id not like", value, "randomId");
            return (Criteria) this;
        }

        public Criteria andRandomIdIn(List<String> values) {
            addCriterion("random_id in", values, "randomId");
            return (Criteria) this;
        }

        public Criteria andRandomIdNotIn(List<String> values) {
            addCriterion("random_id not in", values, "randomId");
            return (Criteria) this;
        }

        public Criteria andRandomIdBetween(String value1, String value2) {
            addCriterion("random_id between", value1, value2, "randomId");
            return (Criteria) this;
        }

        public Criteria andRandomIdNotBetween(String value1, String value2) {
            addCriterion("random_id not between", value1, value2, "randomId");
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

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(String value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(String value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(String value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(String value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(String value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(String value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLike(String value) {
            addCriterion("goods_id like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotLike(String value) {
            addCriterion("goods_id not like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<String> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<String> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(String value1, String value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(String value1, String value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsImageIsNull() {
            addCriterion("goods_image is null");
            return (Criteria) this;
        }

        public Criteria andGoodsImageIsNotNull() {
            addCriterion("goods_image is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsImageEqualTo(String value) {
            addCriterion("goods_image =", value, "goodsImage");
            return (Criteria) this;
        }

        public Criteria andGoodsImageNotEqualTo(String value) {
            addCriterion("goods_image <>", value, "goodsImage");
            return (Criteria) this;
        }

        public Criteria andGoodsImageGreaterThan(String value) {
            addCriterion("goods_image >", value, "goodsImage");
            return (Criteria) this;
        }

        public Criteria andGoodsImageGreaterThanOrEqualTo(String value) {
            addCriterion("goods_image >=", value, "goodsImage");
            return (Criteria) this;
        }

        public Criteria andGoodsImageLessThan(String value) {
            addCriterion("goods_image <", value, "goodsImage");
            return (Criteria) this;
        }

        public Criteria andGoodsImageLessThanOrEqualTo(String value) {
            addCriterion("goods_image <=", value, "goodsImage");
            return (Criteria) this;
        }

        public Criteria andGoodsImageLike(String value) {
            addCriterion("goods_image like", value, "goodsImage");
            return (Criteria) this;
        }

        public Criteria andGoodsImageNotLike(String value) {
            addCriterion("goods_image not like", value, "goodsImage");
            return (Criteria) this;
        }

        public Criteria andGoodsImageIn(List<String> values) {
            addCriterion("goods_image in", values, "goodsImage");
            return (Criteria) this;
        }

        public Criteria andGoodsImageNotIn(List<String> values) {
            addCriterion("goods_image not in", values, "goodsImage");
            return (Criteria) this;
        }

        public Criteria andGoodsImageBetween(String value1, String value2) {
            addCriterion("goods_image between", value1, value2, "goodsImage");
            return (Criteria) this;
        }

        public Criteria andGoodsImageNotBetween(String value1, String value2) {
            addCriterion("goods_image not between", value1, value2, "goodsImage");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIsNull() {
            addCriterion("goods_type is null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIsNotNull() {
            addCriterion("goods_type is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeEqualTo(Byte value) {
            addCriterion("goods_type =", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotEqualTo(Byte value) {
            addCriterion("goods_type <>", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeGreaterThan(Byte value) {
            addCriterion("goods_type >", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("goods_type >=", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLessThan(Byte value) {
            addCriterion("goods_type <", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLessThanOrEqualTo(Byte value) {
            addCriterion("goods_type <=", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIn(List<Byte> values) {
            addCriterion("goods_type in", values, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotIn(List<Byte> values) {
            addCriterion("goods_type not in", values, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeBetween(Byte value1, Byte value2) {
            addCriterion("goods_type between", value1, value2, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("goods_type not between", value1, value2, "goodsType");
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

        public Criteria andAmountsPayableIsNull() {
            addCriterion("amounts_payable is null");
            return (Criteria) this;
        }

        public Criteria andAmountsPayableIsNotNull() {
            addCriterion("amounts_payable is not null");
            return (Criteria) this;
        }

        public Criteria andAmountsPayableEqualTo(BigDecimal value) {
            addCriterion("amounts_payable =", value, "amountsPayable");
            return (Criteria) this;
        }

        public Criteria andAmountsPayableNotEqualTo(BigDecimal value) {
            addCriterion("amounts_payable <>", value, "amountsPayable");
            return (Criteria) this;
        }

        public Criteria andAmountsPayableGreaterThan(BigDecimal value) {
            addCriterion("amounts_payable >", value, "amountsPayable");
            return (Criteria) this;
        }

        public Criteria andAmountsPayableGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amounts_payable >=", value, "amountsPayable");
            return (Criteria) this;
        }

        public Criteria andAmountsPayableLessThan(BigDecimal value) {
            addCriterion("amounts_payable <", value, "amountsPayable");
            return (Criteria) this;
        }

        public Criteria andAmountsPayableLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amounts_payable <=", value, "amountsPayable");
            return (Criteria) this;
        }

        public Criteria andAmountsPayableIn(List<BigDecimal> values) {
            addCriterion("amounts_payable in", values, "amountsPayable");
            return (Criteria) this;
        }

        public Criteria andAmountsPayableNotIn(List<BigDecimal> values) {
            addCriterion("amounts_payable not in", values, "amountsPayable");
            return (Criteria) this;
        }

        public Criteria andAmountsPayableBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amounts_payable between", value1, value2, "amountsPayable");
            return (Criteria) this;
        }

        public Criteria andAmountsPayableNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amounts_payable not between", value1, value2, "amountsPayable");
            return (Criteria) this;
        }

        public Criteria andAmountActuallyPaidIsNull() {
            addCriterion("amount_actually_paid is null");
            return (Criteria) this;
        }

        public Criteria andAmountActuallyPaidIsNotNull() {
            addCriterion("amount_actually_paid is not null");
            return (Criteria) this;
        }

        public Criteria andAmountActuallyPaidEqualTo(BigDecimal value) {
            addCriterion("amount_actually_paid =", value, "amountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andAmountActuallyPaidNotEqualTo(BigDecimal value) {
            addCriterion("amount_actually_paid <>", value, "amountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andAmountActuallyPaidGreaterThan(BigDecimal value) {
            addCriterion("amount_actually_paid >", value, "amountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andAmountActuallyPaidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount_actually_paid >=", value, "amountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andAmountActuallyPaidLessThan(BigDecimal value) {
            addCriterion("amount_actually_paid <", value, "amountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andAmountActuallyPaidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount_actually_paid <=", value, "amountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andAmountActuallyPaidIn(List<BigDecimal> values) {
            addCriterion("amount_actually_paid in", values, "amountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andAmountActuallyPaidNotIn(List<BigDecimal> values) {
            addCriterion("amount_actually_paid not in", values, "amountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andAmountActuallyPaidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount_actually_paid between", value1, value2, "amountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andAmountActuallyPaidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount_actually_paid not between", value1, value2, "amountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andRefundAmountIsNull() {
            addCriterion("refund_amount is null");
            return (Criteria) this;
        }

        public Criteria andRefundAmountIsNotNull() {
            addCriterion("refund_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRefundAmountEqualTo(BigDecimal value) {
            addCriterion("refund_amount =", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountNotEqualTo(BigDecimal value) {
            addCriterion("refund_amount <>", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountGreaterThan(BigDecimal value) {
            addCriterion("refund_amount >", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_amount >=", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountLessThan(BigDecimal value) {
            addCriterion("refund_amount <", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("refund_amount <=", value, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountIn(List<BigDecimal> values) {
            addCriterion("refund_amount in", values, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountNotIn(List<BigDecimal> values) {
            addCriterion("refund_amount not in", values, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_amount between", value1, value2, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andRefundAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refund_amount not between", value1, value2, "refundAmount");
            return (Criteria) this;
        }

        public Criteria andCouponIdIsNull() {
            addCriterion("coupon_id is null");
            return (Criteria) this;
        }

        public Criteria andCouponIdIsNotNull() {
            addCriterion("coupon_id is not null");
            return (Criteria) this;
        }

        public Criteria andCouponIdEqualTo(String value) {
            addCriterion("coupon_id =", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotEqualTo(String value) {
            addCriterion("coupon_id <>", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdGreaterThan(String value) {
            addCriterion("coupon_id >", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_id >=", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdLessThan(String value) {
            addCriterion("coupon_id <", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdLessThanOrEqualTo(String value) {
            addCriterion("coupon_id <=", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdLike(String value) {
            addCriterion("coupon_id like", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotLike(String value) {
            addCriterion("coupon_id not like", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdIn(List<String> values) {
            addCriterion("coupon_id in", values, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotIn(List<String> values) {
            addCriterion("coupon_id not in", values, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdBetween(String value1, String value2) {
            addCriterion("coupon_id between", value1, value2, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotBetween(String value1, String value2) {
            addCriterion("coupon_id not between", value1, value2, "couponId");
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

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Long value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Long value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Long value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Long value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Long value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Long> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Long> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Long value1, Long value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Long value1, Long value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeIsNull() {
            addCriterion("refund_time is null");
            return (Criteria) this;
        }

        public Criteria andRefundTimeIsNotNull() {
            addCriterion("refund_time is not null");
            return (Criteria) this;
        }

        public Criteria andRefundTimeEqualTo(Long value) {
            addCriterion("refund_time =", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeNotEqualTo(Long value) {
            addCriterion("refund_time <>", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeGreaterThan(Long value) {
            addCriterion("refund_time >", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("refund_time >=", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeLessThan(Long value) {
            addCriterion("refund_time <", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeLessThanOrEqualTo(Long value) {
            addCriterion("refund_time <=", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeIn(List<Long> values) {
            addCriterion("refund_time in", values, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeNotIn(List<Long> values) {
            addCriterion("refund_time not in", values, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeBetween(Long value1, Long value2) {
            addCriterion("refund_time between", value1, value2, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeNotBetween(Long value1, Long value2) {
            addCriterion("refund_time not between", value1, value2, "refundTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeIsNull() {
            addCriterion("cancel_time is null");
            return (Criteria) this;
        }

        public Criteria andCancelTimeIsNotNull() {
            addCriterion("cancel_time is not null");
            return (Criteria) this;
        }

        public Criteria andCancelTimeEqualTo(Long value) {
            addCriterion("cancel_time =", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeNotEqualTo(Long value) {
            addCriterion("cancel_time <>", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeGreaterThan(Long value) {
            addCriterion("cancel_time >", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("cancel_time >=", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeLessThan(Long value) {
            addCriterion("cancel_time <", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeLessThanOrEqualTo(Long value) {
            addCriterion("cancel_time <=", value, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeIn(List<Long> values) {
            addCriterion("cancel_time in", values, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeNotIn(List<Long> values) {
            addCriterion("cancel_time not in", values, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeBetween(Long value1, Long value2) {
            addCriterion("cancel_time between", value1, value2, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andCancelTimeNotBetween(Long value1, Long value2) {
            addCriterion("cancel_time not between", value1, value2, "cancelTime");
            return (Criteria) this;
        }

        public Criteria andPaymentAgencyShortNameIsNull() {
            addCriterion("payment_agency_short_name is null");
            return (Criteria) this;
        }

        public Criteria andPaymentAgencyShortNameIsNotNull() {
            addCriterion("payment_agency_short_name is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentAgencyShortNameEqualTo(String value) {
            addCriterion("payment_agency_short_name =", value, "paymentAgencyShortName");
            return (Criteria) this;
        }

        public Criteria andPaymentAgencyShortNameNotEqualTo(String value) {
            addCriterion("payment_agency_short_name <>", value, "paymentAgencyShortName");
            return (Criteria) this;
        }

        public Criteria andPaymentAgencyShortNameGreaterThan(String value) {
            addCriterion("payment_agency_short_name >", value, "paymentAgencyShortName");
            return (Criteria) this;
        }

        public Criteria andPaymentAgencyShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("payment_agency_short_name >=", value, "paymentAgencyShortName");
            return (Criteria) this;
        }

        public Criteria andPaymentAgencyShortNameLessThan(String value) {
            addCriterion("payment_agency_short_name <", value, "paymentAgencyShortName");
            return (Criteria) this;
        }

        public Criteria andPaymentAgencyShortNameLessThanOrEqualTo(String value) {
            addCriterion("payment_agency_short_name <=", value, "paymentAgencyShortName");
            return (Criteria) this;
        }

        public Criteria andPaymentAgencyShortNameLike(String value) {
            addCriterion("payment_agency_short_name like", value, "paymentAgencyShortName");
            return (Criteria) this;
        }

        public Criteria andPaymentAgencyShortNameNotLike(String value) {
            addCriterion("payment_agency_short_name not like", value, "paymentAgencyShortName");
            return (Criteria) this;
        }

        public Criteria andPaymentAgencyShortNameIn(List<String> values) {
            addCriterion("payment_agency_short_name in", values, "paymentAgencyShortName");
            return (Criteria) this;
        }

        public Criteria andPaymentAgencyShortNameNotIn(List<String> values) {
            addCriterion("payment_agency_short_name not in", values, "paymentAgencyShortName");
            return (Criteria) this;
        }

        public Criteria andPaymentAgencyShortNameBetween(String value1, String value2) {
            addCriterion("payment_agency_short_name between", value1, value2, "paymentAgencyShortName");
            return (Criteria) this;
        }

        public Criteria andPaymentAgencyShortNameNotBetween(String value1, String value2) {
            addCriterion("payment_agency_short_name not between", value1, value2, "paymentAgencyShortName");
            return (Criteria) this;
        }

        public Criteria andUserPaymentAgencyIdIsNull() {
            addCriterion("user_payment_agency_id is null");
            return (Criteria) this;
        }

        public Criteria andUserPaymentAgencyIdIsNotNull() {
            addCriterion("user_payment_agency_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserPaymentAgencyIdEqualTo(String value) {
            addCriterion("user_payment_agency_id =", value, "userPaymentAgencyId");
            return (Criteria) this;
        }

        public Criteria andUserPaymentAgencyIdNotEqualTo(String value) {
            addCriterion("user_payment_agency_id <>", value, "userPaymentAgencyId");
            return (Criteria) this;
        }

        public Criteria andUserPaymentAgencyIdGreaterThan(String value) {
            addCriterion("user_payment_agency_id >", value, "userPaymentAgencyId");
            return (Criteria) this;
        }

        public Criteria andUserPaymentAgencyIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_payment_agency_id >=", value, "userPaymentAgencyId");
            return (Criteria) this;
        }

        public Criteria andUserPaymentAgencyIdLessThan(String value) {
            addCriterion("user_payment_agency_id <", value, "userPaymentAgencyId");
            return (Criteria) this;
        }

        public Criteria andUserPaymentAgencyIdLessThanOrEqualTo(String value) {
            addCriterion("user_payment_agency_id <=", value, "userPaymentAgencyId");
            return (Criteria) this;
        }

        public Criteria andUserPaymentAgencyIdLike(String value) {
            addCriterion("user_payment_agency_id like", value, "userPaymentAgencyId");
            return (Criteria) this;
        }

        public Criteria andUserPaymentAgencyIdNotLike(String value) {
            addCriterion("user_payment_agency_id not like", value, "userPaymentAgencyId");
            return (Criteria) this;
        }

        public Criteria andUserPaymentAgencyIdIn(List<String> values) {
            addCriterion("user_payment_agency_id in", values, "userPaymentAgencyId");
            return (Criteria) this;
        }

        public Criteria andUserPaymentAgencyIdNotIn(List<String> values) {
            addCriterion("user_payment_agency_id not in", values, "userPaymentAgencyId");
            return (Criteria) this;
        }

        public Criteria andUserPaymentAgencyIdBetween(String value1, String value2) {
            addCriterion("user_payment_agency_id between", value1, value2, "userPaymentAgencyId");
            return (Criteria) this;
        }

        public Criteria andUserPaymentAgencyIdNotBetween(String value1, String value2) {
            addCriterion("user_payment_agency_id not between", value1, value2, "userPaymentAgencyId");
            return (Criteria) this;
        }

        public Criteria andThirdPartyOrderIdIsNull() {
            addCriterion("third_party_order_id is null");
            return (Criteria) this;
        }

        public Criteria andThirdPartyOrderIdIsNotNull() {
            addCriterion("third_party_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andThirdPartyOrderIdEqualTo(String value) {
            addCriterion("third_party_order_id =", value, "thirdPartyOrderId");
            return (Criteria) this;
        }

        public Criteria andThirdPartyOrderIdNotEqualTo(String value) {
            addCriterion("third_party_order_id <>", value, "thirdPartyOrderId");
            return (Criteria) this;
        }

        public Criteria andThirdPartyOrderIdGreaterThan(String value) {
            addCriterion("third_party_order_id >", value, "thirdPartyOrderId");
            return (Criteria) this;
        }

        public Criteria andThirdPartyOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("third_party_order_id >=", value, "thirdPartyOrderId");
            return (Criteria) this;
        }

        public Criteria andThirdPartyOrderIdLessThan(String value) {
            addCriterion("third_party_order_id <", value, "thirdPartyOrderId");
            return (Criteria) this;
        }

        public Criteria andThirdPartyOrderIdLessThanOrEqualTo(String value) {
            addCriterion("third_party_order_id <=", value, "thirdPartyOrderId");
            return (Criteria) this;
        }

        public Criteria andThirdPartyOrderIdLike(String value) {
            addCriterion("third_party_order_id like", value, "thirdPartyOrderId");
            return (Criteria) this;
        }

        public Criteria andThirdPartyOrderIdNotLike(String value) {
            addCriterion("third_party_order_id not like", value, "thirdPartyOrderId");
            return (Criteria) this;
        }

        public Criteria andThirdPartyOrderIdIn(List<String> values) {
            addCriterion("third_party_order_id in", values, "thirdPartyOrderId");
            return (Criteria) this;
        }

        public Criteria andThirdPartyOrderIdNotIn(List<String> values) {
            addCriterion("third_party_order_id not in", values, "thirdPartyOrderId");
            return (Criteria) this;
        }

        public Criteria andThirdPartyOrderIdBetween(String value1, String value2) {
            addCriterion("third_party_order_id between", value1, value2, "thirdPartyOrderId");
            return (Criteria) this;
        }

        public Criteria andThirdPartyOrderIdNotBetween(String value1, String value2) {
            addCriterion("third_party_order_id not between", value1, value2, "thirdPartyOrderId");
            return (Criteria) this;
        }

        public Criteria andEffectObjectIsNull() {
            addCriterion("effect_object is null");
            return (Criteria) this;
        }

        public Criteria andEffectObjectIsNotNull() {
            addCriterion("effect_object is not null");
            return (Criteria) this;
        }

        public Criteria andEffectObjectEqualTo(String value) {
            addCriterion("effect_object =", value, "effectObject");
            return (Criteria) this;
        }

        public Criteria andEffectObjectNotEqualTo(String value) {
            addCriterion("effect_object <>", value, "effectObject");
            return (Criteria) this;
        }

        public Criteria andEffectObjectGreaterThan(String value) {
            addCriterion("effect_object >", value, "effectObject");
            return (Criteria) this;
        }

        public Criteria andEffectObjectGreaterThanOrEqualTo(String value) {
            addCriterion("effect_object >=", value, "effectObject");
            return (Criteria) this;
        }

        public Criteria andEffectObjectLessThan(String value) {
            addCriterion("effect_object <", value, "effectObject");
            return (Criteria) this;
        }

        public Criteria andEffectObjectLessThanOrEqualTo(String value) {
            addCriterion("effect_object <=", value, "effectObject");
            return (Criteria) this;
        }

        public Criteria andEffectObjectLike(String value) {
            addCriterion("effect_object like", value, "effectObject");
            return (Criteria) this;
        }

        public Criteria andEffectObjectNotLike(String value) {
            addCriterion("effect_object not like", value, "effectObject");
            return (Criteria) this;
        }

        public Criteria andEffectObjectIn(List<String> values) {
            addCriterion("effect_object in", values, "effectObject");
            return (Criteria) this;
        }

        public Criteria andEffectObjectNotIn(List<String> values) {
            addCriterion("effect_object not in", values, "effectObject");
            return (Criteria) this;
        }

        public Criteria andEffectObjectBetween(String value1, String value2) {
            addCriterion("effect_object between", value1, value2, "effectObject");
            return (Criteria) this;
        }

        public Criteria andEffectObjectNotBetween(String value1, String value2) {
            addCriterion("effect_object not between", value1, value2, "effectObject");
            return (Criteria) this;
        }

        public Criteria andScorePaidIsNull() {
            addCriterion("score_paid is null");
            return (Criteria) this;
        }

        public Criteria andScorePaidIsNotNull() {
            addCriterion("score_paid is not null");
            return (Criteria) this;
        }

        public Criteria andScorePaidEqualTo(BigDecimal value) {
            addCriterion("score_paid =", value, "scorePaid");
            return (Criteria) this;
        }

        public Criteria andScorePaidNotEqualTo(BigDecimal value) {
            addCriterion("score_paid <>", value, "scorePaid");
            return (Criteria) this;
        }

        public Criteria andScorePaidGreaterThan(BigDecimal value) {
            addCriterion("score_paid >", value, "scorePaid");
            return (Criteria) this;
        }

        public Criteria andScorePaidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("score_paid >=", value, "scorePaid");
            return (Criteria) this;
        }

        public Criteria andScorePaidLessThan(BigDecimal value) {
            addCriterion("score_paid <", value, "scorePaid");
            return (Criteria) this;
        }

        public Criteria andScorePaidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("score_paid <=", value, "scorePaid");
            return (Criteria) this;
        }

        public Criteria andScorePaidIn(List<BigDecimal> values) {
            addCriterion("score_paid in", values, "scorePaid");
            return (Criteria) this;
        }

        public Criteria andScorePaidNotIn(List<BigDecimal> values) {
            addCriterion("score_paid not in", values, "scorePaid");
            return (Criteria) this;
        }

        public Criteria andScorePaidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("score_paid between", value1, value2, "scorePaid");
            return (Criteria) this;
        }

        public Criteria andScorePaidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("score_paid not between", value1, value2, "scorePaid");
            return (Criteria) this;
        }

        public Criteria andScoreKeyFlagIsNull() {
            addCriterion("score_key_flag is null");
            return (Criteria) this;
        }

        public Criteria andScoreKeyFlagIsNotNull() {
            addCriterion("score_key_flag is not null");
            return (Criteria) this;
        }

        public Criteria andScoreKeyFlagEqualTo(String value) {
            addCriterion("score_key_flag =", value, "scoreKeyFlag");
            return (Criteria) this;
        }

        public Criteria andScoreKeyFlagNotEqualTo(String value) {
            addCriterion("score_key_flag <>", value, "scoreKeyFlag");
            return (Criteria) this;
        }

        public Criteria andScoreKeyFlagGreaterThan(String value) {
            addCriterion("score_key_flag >", value, "scoreKeyFlag");
            return (Criteria) this;
        }

        public Criteria andScoreKeyFlagGreaterThanOrEqualTo(String value) {
            addCriterion("score_key_flag >=", value, "scoreKeyFlag");
            return (Criteria) this;
        }

        public Criteria andScoreKeyFlagLessThan(String value) {
            addCriterion("score_key_flag <", value, "scoreKeyFlag");
            return (Criteria) this;
        }

        public Criteria andScoreKeyFlagLessThanOrEqualTo(String value) {
            addCriterion("score_key_flag <=", value, "scoreKeyFlag");
            return (Criteria) this;
        }

        public Criteria andScoreKeyFlagLike(String value) {
            addCriterion("score_key_flag like", value, "scoreKeyFlag");
            return (Criteria) this;
        }

        public Criteria andScoreKeyFlagNotLike(String value) {
            addCriterion("score_key_flag not like", value, "scoreKeyFlag");
            return (Criteria) this;
        }

        public Criteria andScoreKeyFlagIn(List<String> values) {
            addCriterion("score_key_flag in", values, "scoreKeyFlag");
            return (Criteria) this;
        }

        public Criteria andScoreKeyFlagNotIn(List<String> values) {
            addCriterion("score_key_flag not in", values, "scoreKeyFlag");
            return (Criteria) this;
        }

        public Criteria andScoreKeyFlagBetween(String value1, String value2) {
            addCriterion("score_key_flag between", value1, value2, "scoreKeyFlag");
            return (Criteria) this;
        }

        public Criteria andScoreKeyFlagNotBetween(String value1, String value2) {
            addCriterion("score_key_flag not between", value1, value2, "scoreKeyFlag");
            return (Criteria) this;
        }

        public Criteria andCouponPaidIsNull() {
            addCriterion("coupon_paid is null");
            return (Criteria) this;
        }

        public Criteria andCouponPaidIsNotNull() {
            addCriterion("coupon_paid is not null");
            return (Criteria) this;
        }

        public Criteria andCouponPaidEqualTo(BigDecimal value) {
            addCriterion("coupon_paid =", value, "couponPaid");
            return (Criteria) this;
        }

        public Criteria andCouponPaidNotEqualTo(BigDecimal value) {
            addCriterion("coupon_paid <>", value, "couponPaid");
            return (Criteria) this;
        }

        public Criteria andCouponPaidGreaterThan(BigDecimal value) {
            addCriterion("coupon_paid >", value, "couponPaid");
            return (Criteria) this;
        }

        public Criteria andCouponPaidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("coupon_paid >=", value, "couponPaid");
            return (Criteria) this;
        }

        public Criteria andCouponPaidLessThan(BigDecimal value) {
            addCriterion("coupon_paid <", value, "couponPaid");
            return (Criteria) this;
        }

        public Criteria andCouponPaidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("coupon_paid <=", value, "couponPaid");
            return (Criteria) this;
        }

        public Criteria andCouponPaidIn(List<BigDecimal> values) {
            addCriterion("coupon_paid in", values, "couponPaid");
            return (Criteria) this;
        }

        public Criteria andCouponPaidNotIn(List<BigDecimal> values) {
            addCriterion("coupon_paid not in", values, "couponPaid");
            return (Criteria) this;
        }

        public Criteria andCouponPaidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("coupon_paid between", value1, value2, "couponPaid");
            return (Criteria) this;
        }

        public Criteria andCouponPaidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("coupon_paid not between", value1, value2, "couponPaid");
            return (Criteria) this;
        }

        public Criteria andScoreMoneyIsNull() {
            addCriterion("score_money is null");
            return (Criteria) this;
        }

        public Criteria andScoreMoneyIsNotNull() {
            addCriterion("score_money is not null");
            return (Criteria) this;
        }

        public Criteria andScoreMoneyEqualTo(BigDecimal value) {
            addCriterion("score_money =", value, "scoreMoney");
            return (Criteria) this;
        }

        public Criteria andScoreMoneyNotEqualTo(BigDecimal value) {
            addCriterion("score_money <>", value, "scoreMoney");
            return (Criteria) this;
        }

        public Criteria andScoreMoneyGreaterThan(BigDecimal value) {
            addCriterion("score_money >", value, "scoreMoney");
            return (Criteria) this;
        }

        public Criteria andScoreMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("score_money >=", value, "scoreMoney");
            return (Criteria) this;
        }

        public Criteria andScoreMoneyLessThan(BigDecimal value) {
            addCriterion("score_money <", value, "scoreMoney");
            return (Criteria) this;
        }

        public Criteria andScoreMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("score_money <=", value, "scoreMoney");
            return (Criteria) this;
        }

        public Criteria andScoreMoneyIn(List<BigDecimal> values) {
            addCriterion("score_money in", values, "scoreMoney");
            return (Criteria) this;
        }

        public Criteria andScoreMoneyNotIn(List<BigDecimal> values) {
            addCriterion("score_money not in", values, "scoreMoney");
            return (Criteria) this;
        }

        public Criteria andScoreMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("score_money between", value1, value2, "scoreMoney");
            return (Criteria) this;
        }

        public Criteria andScoreMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("score_money not between", value1, value2, "scoreMoney");
            return (Criteria) this;
        }

        public Criteria andManualOfferIsNull() {
            addCriterion("manual_offer is null");
            return (Criteria) this;
        }

        public Criteria andManualOfferIsNotNull() {
            addCriterion("manual_offer is not null");
            return (Criteria) this;
        }

        public Criteria andManualOfferEqualTo(BigDecimal value) {
            addCriterion("manual_offer =", value, "manualOffer");
            return (Criteria) this;
        }

        public Criteria andManualOfferNotEqualTo(BigDecimal value) {
            addCriterion("manual_offer <>", value, "manualOffer");
            return (Criteria) this;
        }

        public Criteria andManualOfferGreaterThan(BigDecimal value) {
            addCriterion("manual_offer >", value, "manualOffer");
            return (Criteria) this;
        }

        public Criteria andManualOfferGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("manual_offer >=", value, "manualOffer");
            return (Criteria) this;
        }

        public Criteria andManualOfferLessThan(BigDecimal value) {
            addCriterion("manual_offer <", value, "manualOffer");
            return (Criteria) this;
        }

        public Criteria andManualOfferLessThanOrEqualTo(BigDecimal value) {
            addCriterion("manual_offer <=", value, "manualOffer");
            return (Criteria) this;
        }

        public Criteria andManualOfferIn(List<BigDecimal> values) {
            addCriterion("manual_offer in", values, "manualOffer");
            return (Criteria) this;
        }

        public Criteria andManualOfferNotIn(List<BigDecimal> values) {
            addCriterion("manual_offer not in", values, "manualOffer");
            return (Criteria) this;
        }

        public Criteria andManualOfferBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("manual_offer between", value1, value2, "manualOffer");
            return (Criteria) this;
        }

        public Criteria andManualOfferNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("manual_offer not between", value1, value2, "manualOffer");
            return (Criteria) this;
        }

        public Criteria andManualOfferSetTimeIsNull() {
            addCriterion("manual_offer_set_time is null");
            return (Criteria) this;
        }

        public Criteria andManualOfferSetTimeIsNotNull() {
            addCriterion("manual_offer_set_time is not null");
            return (Criteria) this;
        }

        public Criteria andManualOfferSetTimeEqualTo(Long value) {
            addCriterion("manual_offer_set_time =", value, "manualOfferSetTime");
            return (Criteria) this;
        }

        public Criteria andManualOfferSetTimeNotEqualTo(Long value) {
            addCriterion("manual_offer_set_time <>", value, "manualOfferSetTime");
            return (Criteria) this;
        }

        public Criteria andManualOfferSetTimeGreaterThan(Long value) {
            addCriterion("manual_offer_set_time >", value, "manualOfferSetTime");
            return (Criteria) this;
        }

        public Criteria andManualOfferSetTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("manual_offer_set_time >=", value, "manualOfferSetTime");
            return (Criteria) this;
        }

        public Criteria andManualOfferSetTimeLessThan(Long value) {
            addCriterion("manual_offer_set_time <", value, "manualOfferSetTime");
            return (Criteria) this;
        }

        public Criteria andManualOfferSetTimeLessThanOrEqualTo(Long value) {
            addCriterion("manual_offer_set_time <=", value, "manualOfferSetTime");
            return (Criteria) this;
        }

        public Criteria andManualOfferSetTimeIn(List<Long> values) {
            addCriterion("manual_offer_set_time in", values, "manualOfferSetTime");
            return (Criteria) this;
        }

        public Criteria andManualOfferSetTimeNotIn(List<Long> values) {
            addCriterion("manual_offer_set_time not in", values, "manualOfferSetTime");
            return (Criteria) this;
        }

        public Criteria andManualOfferSetTimeBetween(Long value1, Long value2) {
            addCriterion("manual_offer_set_time between", value1, value2, "manualOfferSetTime");
            return (Criteria) this;
        }

        public Criteria andManualOfferSetTimeNotBetween(Long value1, Long value2) {
            addCriterion("manual_offer_set_time not between", value1, value2, "manualOfferSetTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseQuantityIsNull() {
            addCriterion("purchase_quantity is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseQuantityIsNotNull() {
            addCriterion("purchase_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseQuantityEqualTo(Integer value) {
            addCriterion("purchase_quantity =", value, "purchaseQuantity");
            return (Criteria) this;
        }

        public Criteria andPurchaseQuantityNotEqualTo(Integer value) {
            addCriterion("purchase_quantity <>", value, "purchaseQuantity");
            return (Criteria) this;
        }

        public Criteria andPurchaseQuantityGreaterThan(Integer value) {
            addCriterion("purchase_quantity >", value, "purchaseQuantity");
            return (Criteria) this;
        }

        public Criteria andPurchaseQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("purchase_quantity >=", value, "purchaseQuantity");
            return (Criteria) this;
        }

        public Criteria andPurchaseQuantityLessThan(Integer value) {
            addCriterion("purchase_quantity <", value, "purchaseQuantity");
            return (Criteria) this;
        }

        public Criteria andPurchaseQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("purchase_quantity <=", value, "purchaseQuantity");
            return (Criteria) this;
        }

        public Criteria andPurchaseQuantityIn(List<Integer> values) {
            addCriterion("purchase_quantity in", values, "purchaseQuantity");
            return (Criteria) this;
        }

        public Criteria andPurchaseQuantityNotIn(List<Integer> values) {
            addCriterion("purchase_quantity not in", values, "purchaseQuantity");
            return (Criteria) this;
        }

        public Criteria andPurchaseQuantityBetween(Integer value1, Integer value2) {
            addCriterion("purchase_quantity between", value1, value2, "purchaseQuantity");
            return (Criteria) this;
        }

        public Criteria andPurchaseQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("purchase_quantity not between", value1, value2, "purchaseQuantity");
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

        public Criteria andCollectionShopIdIsNull() {
            addCriterion("collection_shop_id is null");
            return (Criteria) this;
        }

        public Criteria andCollectionShopIdIsNotNull() {
            addCriterion("collection_shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionShopIdEqualTo(String value) {
            addCriterion("collection_shop_id =", value, "collectionShopId");
            return (Criteria) this;
        }

        public Criteria andCollectionShopIdNotEqualTo(String value) {
            addCriterion("collection_shop_id <>", value, "collectionShopId");
            return (Criteria) this;
        }

        public Criteria andCollectionShopIdGreaterThan(String value) {
            addCriterion("collection_shop_id >", value, "collectionShopId");
            return (Criteria) this;
        }

        public Criteria andCollectionShopIdGreaterThanOrEqualTo(String value) {
            addCriterion("collection_shop_id >=", value, "collectionShopId");
            return (Criteria) this;
        }

        public Criteria andCollectionShopIdLessThan(String value) {
            addCriterion("collection_shop_id <", value, "collectionShopId");
            return (Criteria) this;
        }

        public Criteria andCollectionShopIdLessThanOrEqualTo(String value) {
            addCriterion("collection_shop_id <=", value, "collectionShopId");
            return (Criteria) this;
        }

        public Criteria andCollectionShopIdLike(String value) {
            addCriterion("collection_shop_id like", value, "collectionShopId");
            return (Criteria) this;
        }

        public Criteria andCollectionShopIdNotLike(String value) {
            addCriterion("collection_shop_id not like", value, "collectionShopId");
            return (Criteria) this;
        }

        public Criteria andCollectionShopIdIn(List<String> values) {
            addCriterion("collection_shop_id in", values, "collectionShopId");
            return (Criteria) this;
        }

        public Criteria andCollectionShopIdNotIn(List<String> values) {
            addCriterion("collection_shop_id not in", values, "collectionShopId");
            return (Criteria) this;
        }

        public Criteria andCollectionShopIdBetween(String value1, String value2) {
            addCriterion("collection_shop_id between", value1, value2, "collectionShopId");
            return (Criteria) this;
        }

        public Criteria andCollectionShopIdNotBetween(String value1, String value2) {
            addCriterion("collection_shop_id not between", value1, value2, "collectionShopId");
            return (Criteria) this;
        }

        public Criteria andCollectionOrderIdIsNull() {
            addCriterion("collection_order_id is null");
            return (Criteria) this;
        }

        public Criteria andCollectionOrderIdIsNotNull() {
            addCriterion("collection_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionOrderIdEqualTo(String value) {
            addCriterion("collection_order_id =", value, "collectionOrderId");
            return (Criteria) this;
        }

        public Criteria andCollectionOrderIdNotEqualTo(String value) {
            addCriterion("collection_order_id <>", value, "collectionOrderId");
            return (Criteria) this;
        }

        public Criteria andCollectionOrderIdGreaterThan(String value) {
            addCriterion("collection_order_id >", value, "collectionOrderId");
            return (Criteria) this;
        }

        public Criteria andCollectionOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("collection_order_id >=", value, "collectionOrderId");
            return (Criteria) this;
        }

        public Criteria andCollectionOrderIdLessThan(String value) {
            addCriterion("collection_order_id <", value, "collectionOrderId");
            return (Criteria) this;
        }

        public Criteria andCollectionOrderIdLessThanOrEqualTo(String value) {
            addCriterion("collection_order_id <=", value, "collectionOrderId");
            return (Criteria) this;
        }

        public Criteria andCollectionOrderIdLike(String value) {
            addCriterion("collection_order_id like", value, "collectionOrderId");
            return (Criteria) this;
        }

        public Criteria andCollectionOrderIdNotLike(String value) {
            addCriterion("collection_order_id not like", value, "collectionOrderId");
            return (Criteria) this;
        }

        public Criteria andCollectionOrderIdIn(List<String> values) {
            addCriterion("collection_order_id in", values, "collectionOrderId");
            return (Criteria) this;
        }

        public Criteria andCollectionOrderIdNotIn(List<String> values) {
            addCriterion("collection_order_id not in", values, "collectionOrderId");
            return (Criteria) this;
        }

        public Criteria andCollectionOrderIdBetween(String value1, String value2) {
            addCriterion("collection_order_id between", value1, value2, "collectionOrderId");
            return (Criteria) this;
        }

        public Criteria andCollectionOrderIdNotBetween(String value1, String value2) {
            addCriterion("collection_order_id not between", value1, value2, "collectionOrderId");
            return (Criteria) this;
        }

        public Criteria andCollectionAmountIsNull() {
            addCriterion("collection_amount is null");
            return (Criteria) this;
        }

        public Criteria andCollectionAmountIsNotNull() {
            addCriterion("collection_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionAmountEqualTo(BigDecimal value) {
            addCriterion("collection_amount =", value, "collectionAmount");
            return (Criteria) this;
        }

        public Criteria andCollectionAmountNotEqualTo(BigDecimal value) {
            addCriterion("collection_amount <>", value, "collectionAmount");
            return (Criteria) this;
        }

        public Criteria andCollectionAmountGreaterThan(BigDecimal value) {
            addCriterion("collection_amount >", value, "collectionAmount");
            return (Criteria) this;
        }

        public Criteria andCollectionAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("collection_amount >=", value, "collectionAmount");
            return (Criteria) this;
        }

        public Criteria andCollectionAmountLessThan(BigDecimal value) {
            addCriterion("collection_amount <", value, "collectionAmount");
            return (Criteria) this;
        }

        public Criteria andCollectionAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("collection_amount <=", value, "collectionAmount");
            return (Criteria) this;
        }

        public Criteria andCollectionAmountIn(List<BigDecimal> values) {
            addCriterion("collection_amount in", values, "collectionAmount");
            return (Criteria) this;
        }

        public Criteria andCollectionAmountNotIn(List<BigDecimal> values) {
            addCriterion("collection_amount not in", values, "collectionAmount");
            return (Criteria) this;
        }

        public Criteria andCollectionAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("collection_amount between", value1, value2, "collectionAmount");
            return (Criteria) this;
        }

        public Criteria andCollectionAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("collection_amount not between", value1, value2, "collectionAmount");
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