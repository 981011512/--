package com.cf.pay.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CfHistoryOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfHistoryOrderExample() {
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

        public Criteria andOrderTimeIsNull() {
            addCriterion("order_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNotNull() {
            addCriterion("order_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeEqualTo(Long value) {
            addCriterion("order_time =", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotEqualTo(Long value) {
            addCriterion("order_time <>", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThan(Long value) {
            addCriterion("order_time >", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("order_time >=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThan(Long value) {
            addCriterion("order_time <", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThanOrEqualTo(Long value) {
            addCriterion("order_time <=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIn(List<Long> values) {
            addCriterion("order_time in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotIn(List<Long> values) {
            addCriterion("order_time not in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeBetween(Long value1, Long value2) {
            addCriterion("order_time between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotBetween(Long value1, Long value2) {
            addCriterion("order_time not between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andParkFeeAmountsPayableIsNull() {
            addCriterion("park_fee_amounts_payable is null");
            return (Criteria) this;
        }

        public Criteria andParkFeeAmountsPayableIsNotNull() {
            addCriterion("park_fee_amounts_payable is not null");
            return (Criteria) this;
        }

        public Criteria andParkFeeAmountsPayableEqualTo(BigDecimal value) {
            addCriterion("park_fee_amounts_payable =", value, "parkFeeAmountsPayable");
            return (Criteria) this;
        }

        public Criteria andParkFeeAmountsPayableNotEqualTo(BigDecimal value) {
            addCriterion("park_fee_amounts_payable <>", value, "parkFeeAmountsPayable");
            return (Criteria) this;
        }

        public Criteria andParkFeeAmountsPayableGreaterThan(BigDecimal value) {
            addCriterion("park_fee_amounts_payable >", value, "parkFeeAmountsPayable");
            return (Criteria) this;
        }

        public Criteria andParkFeeAmountsPayableGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("park_fee_amounts_payable >=", value, "parkFeeAmountsPayable");
            return (Criteria) this;
        }

        public Criteria andParkFeeAmountsPayableLessThan(BigDecimal value) {
            addCriterion("park_fee_amounts_payable <", value, "parkFeeAmountsPayable");
            return (Criteria) this;
        }

        public Criteria andParkFeeAmountsPayableLessThanOrEqualTo(BigDecimal value) {
            addCriterion("park_fee_amounts_payable <=", value, "parkFeeAmountsPayable");
            return (Criteria) this;
        }

        public Criteria andParkFeeAmountsPayableIn(List<BigDecimal> values) {
            addCriterion("park_fee_amounts_payable in", values, "parkFeeAmountsPayable");
            return (Criteria) this;
        }

        public Criteria andParkFeeAmountsPayableNotIn(List<BigDecimal> values) {
            addCriterion("park_fee_amounts_payable not in", values, "parkFeeAmountsPayable");
            return (Criteria) this;
        }

        public Criteria andParkFeeAmountsPayableBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("park_fee_amounts_payable between", value1, value2, "parkFeeAmountsPayable");
            return (Criteria) this;
        }

        public Criteria andParkFeeAmountsPayableNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("park_fee_amounts_payable not between", value1, value2, "parkFeeAmountsPayable");
            return (Criteria) this;
        }

        public Criteria andParkFeeAmountActuallyPaidIsNull() {
            addCriterion("park_fee_amount_actually_paid is null");
            return (Criteria) this;
        }

        public Criteria andParkFeeAmountActuallyPaidIsNotNull() {
            addCriterion("park_fee_amount_actually_paid is not null");
            return (Criteria) this;
        }

        public Criteria andParkFeeAmountActuallyPaidEqualTo(BigDecimal value) {
            addCriterion("park_fee_amount_actually_paid =", value, "parkFeeAmountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andParkFeeAmountActuallyPaidNotEqualTo(BigDecimal value) {
            addCriterion("park_fee_amount_actually_paid <>", value, "parkFeeAmountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andParkFeeAmountActuallyPaidGreaterThan(BigDecimal value) {
            addCriterion("park_fee_amount_actually_paid >", value, "parkFeeAmountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andParkFeeAmountActuallyPaidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("park_fee_amount_actually_paid >=", value, "parkFeeAmountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andParkFeeAmountActuallyPaidLessThan(BigDecimal value) {
            addCriterion("park_fee_amount_actually_paid <", value, "parkFeeAmountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andParkFeeAmountActuallyPaidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("park_fee_amount_actually_paid <=", value, "parkFeeAmountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andParkFeeAmountActuallyPaidIn(List<BigDecimal> values) {
            addCriterion("park_fee_amount_actually_paid in", values, "parkFeeAmountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andParkFeeAmountActuallyPaidNotIn(List<BigDecimal> values) {
            addCriterion("park_fee_amount_actually_paid not in", values, "parkFeeAmountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andParkFeeAmountActuallyPaidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("park_fee_amount_actually_paid between", value1, value2, "parkFeeAmountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andParkFeeAmountActuallyPaidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("park_fee_amount_actually_paid not between", value1, value2, "parkFeeAmountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andParkPackageAmountsPayableIsNull() {
            addCriterion("park_package_amounts_payable is null");
            return (Criteria) this;
        }

        public Criteria andParkPackageAmountsPayableIsNotNull() {
            addCriterion("park_package_amounts_payable is not null");
            return (Criteria) this;
        }

        public Criteria andParkPackageAmountsPayableEqualTo(BigDecimal value) {
            addCriterion("park_package_amounts_payable =", value, "parkPackageAmountsPayable");
            return (Criteria) this;
        }

        public Criteria andParkPackageAmountsPayableNotEqualTo(BigDecimal value) {
            addCriterion("park_package_amounts_payable <>", value, "parkPackageAmountsPayable");
            return (Criteria) this;
        }

        public Criteria andParkPackageAmountsPayableGreaterThan(BigDecimal value) {
            addCriterion("park_package_amounts_payable >", value, "parkPackageAmountsPayable");
            return (Criteria) this;
        }

        public Criteria andParkPackageAmountsPayableGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("park_package_amounts_payable >=", value, "parkPackageAmountsPayable");
            return (Criteria) this;
        }

        public Criteria andParkPackageAmountsPayableLessThan(BigDecimal value) {
            addCriterion("park_package_amounts_payable <", value, "parkPackageAmountsPayable");
            return (Criteria) this;
        }

        public Criteria andParkPackageAmountsPayableLessThanOrEqualTo(BigDecimal value) {
            addCriterion("park_package_amounts_payable <=", value, "parkPackageAmountsPayable");
            return (Criteria) this;
        }

        public Criteria andParkPackageAmountsPayableIn(List<BigDecimal> values) {
            addCriterion("park_package_amounts_payable in", values, "parkPackageAmountsPayable");
            return (Criteria) this;
        }

        public Criteria andParkPackageAmountsPayableNotIn(List<BigDecimal> values) {
            addCriterion("park_package_amounts_payable not in", values, "parkPackageAmountsPayable");
            return (Criteria) this;
        }

        public Criteria andParkPackageAmountsPayableBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("park_package_amounts_payable between", value1, value2, "parkPackageAmountsPayable");
            return (Criteria) this;
        }

        public Criteria andParkPackageAmountsPayableNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("park_package_amounts_payable not between", value1, value2, "parkPackageAmountsPayable");
            return (Criteria) this;
        }

        public Criteria andParkPackageAmountActuallyPaidIsNull() {
            addCriterion("park_package_amount_actually_paid is null");
            return (Criteria) this;
        }

        public Criteria andParkPackageAmountActuallyPaidIsNotNull() {
            addCriterion("park_package_amount_actually_paid is not null");
            return (Criteria) this;
        }

        public Criteria andParkPackageAmountActuallyPaidEqualTo(BigDecimal value) {
            addCriterion("park_package_amount_actually_paid =", value, "parkPackageAmountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andParkPackageAmountActuallyPaidNotEqualTo(BigDecimal value) {
            addCriterion("park_package_amount_actually_paid <>", value, "parkPackageAmountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andParkPackageAmountActuallyPaidGreaterThan(BigDecimal value) {
            addCriterion("park_package_amount_actually_paid >", value, "parkPackageAmountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andParkPackageAmountActuallyPaidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("park_package_amount_actually_paid >=", value, "parkPackageAmountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andParkPackageAmountActuallyPaidLessThan(BigDecimal value) {
            addCriterion("park_package_amount_actually_paid <", value, "parkPackageAmountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andParkPackageAmountActuallyPaidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("park_package_amount_actually_paid <=", value, "parkPackageAmountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andParkPackageAmountActuallyPaidIn(List<BigDecimal> values) {
            addCriterion("park_package_amount_actually_paid in", values, "parkPackageAmountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andParkPackageAmountActuallyPaidNotIn(List<BigDecimal> values) {
            addCriterion("park_package_amount_actually_paid not in", values, "parkPackageAmountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andParkPackageAmountActuallyPaidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("park_package_amount_actually_paid between", value1, value2, "parkPackageAmountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andParkPackageAmountActuallyPaidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("park_package_amount_actually_paid not between", value1, value2, "parkPackageAmountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andCashPayIsNull() {
            addCriterion("cash_pay is null");
            return (Criteria) this;
        }

        public Criteria andCashPayIsNotNull() {
            addCriterion("cash_pay is not null");
            return (Criteria) this;
        }

        public Criteria andCashPayEqualTo(BigDecimal value) {
            addCriterion("cash_pay =", value, "cashPay");
            return (Criteria) this;
        }

        public Criteria andCashPayNotEqualTo(BigDecimal value) {
            addCriterion("cash_pay <>", value, "cashPay");
            return (Criteria) this;
        }

        public Criteria andCashPayGreaterThan(BigDecimal value) {
            addCriterion("cash_pay >", value, "cashPay");
            return (Criteria) this;
        }

        public Criteria andCashPayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cash_pay >=", value, "cashPay");
            return (Criteria) this;
        }

        public Criteria andCashPayLessThan(BigDecimal value) {
            addCriterion("cash_pay <", value, "cashPay");
            return (Criteria) this;
        }

        public Criteria andCashPayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cash_pay <=", value, "cashPay");
            return (Criteria) this;
        }

        public Criteria andCashPayIn(List<BigDecimal> values) {
            addCriterion("cash_pay in", values, "cashPay");
            return (Criteria) this;
        }

        public Criteria andCashPayNotIn(List<BigDecimal> values) {
            addCriterion("cash_pay not in", values, "cashPay");
            return (Criteria) this;
        }

        public Criteria andCashPayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cash_pay between", value1, value2, "cashPay");
            return (Criteria) this;
        }

        public Criteria andCashPayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cash_pay not between", value1, value2, "cashPay");
            return (Criteria) this;
        }

        public Criteria andWeixinH5PayIsNull() {
            addCriterion("weixin_h5_pay is null");
            return (Criteria) this;
        }

        public Criteria andWeixinH5PayIsNotNull() {
            addCriterion("weixin_h5_pay is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinH5PayEqualTo(BigDecimal value) {
            addCriterion("weixin_h5_pay =", value, "weixinH5Pay");
            return (Criteria) this;
        }

        public Criteria andWeixinH5PayNotEqualTo(BigDecimal value) {
            addCriterion("weixin_h5_pay <>", value, "weixinH5Pay");
            return (Criteria) this;
        }

        public Criteria andWeixinH5PayGreaterThan(BigDecimal value) {
            addCriterion("weixin_h5_pay >", value, "weixinH5Pay");
            return (Criteria) this;
        }

        public Criteria andWeixinH5PayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weixin_h5_pay >=", value, "weixinH5Pay");
            return (Criteria) this;
        }

        public Criteria andWeixinH5PayLessThan(BigDecimal value) {
            addCriterion("weixin_h5_pay <", value, "weixinH5Pay");
            return (Criteria) this;
        }

        public Criteria andWeixinH5PayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("weixin_h5_pay <=", value, "weixinH5Pay");
            return (Criteria) this;
        }

        public Criteria andWeixinH5PayIn(List<BigDecimal> values) {
            addCriterion("weixin_h5_pay in", values, "weixinH5Pay");
            return (Criteria) this;
        }

        public Criteria andWeixinH5PayNotIn(List<BigDecimal> values) {
            addCriterion("weixin_h5_pay not in", values, "weixinH5Pay");
            return (Criteria) this;
        }

        public Criteria andWeixinH5PayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weixin_h5_pay between", value1, value2, "weixinH5Pay");
            return (Criteria) this;
        }

        public Criteria andWeixinH5PayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weixin_h5_pay not between", value1, value2, "weixinH5Pay");
            return (Criteria) this;
        }

        public Criteria andWeixinMinPayIsNull() {
            addCriterion("weixin_min_pay is null");
            return (Criteria) this;
        }

        public Criteria andWeixinMinPayIsNotNull() {
            addCriterion("weixin_min_pay is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinMinPayEqualTo(BigDecimal value) {
            addCriterion("weixin_min_pay =", value, "weixinMinPay");
            return (Criteria) this;
        }

        public Criteria andWeixinMinPayNotEqualTo(BigDecimal value) {
            addCriterion("weixin_min_pay <>", value, "weixinMinPay");
            return (Criteria) this;
        }

        public Criteria andWeixinMinPayGreaterThan(BigDecimal value) {
            addCriterion("weixin_min_pay >", value, "weixinMinPay");
            return (Criteria) this;
        }

        public Criteria andWeixinMinPayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weixin_min_pay >=", value, "weixinMinPay");
            return (Criteria) this;
        }

        public Criteria andWeixinMinPayLessThan(BigDecimal value) {
            addCriterion("weixin_min_pay <", value, "weixinMinPay");
            return (Criteria) this;
        }

        public Criteria andWeixinMinPayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("weixin_min_pay <=", value, "weixinMinPay");
            return (Criteria) this;
        }

        public Criteria andWeixinMinPayIn(List<BigDecimal> values) {
            addCriterion("weixin_min_pay in", values, "weixinMinPay");
            return (Criteria) this;
        }

        public Criteria andWeixinMinPayNotIn(List<BigDecimal> values) {
            addCriterion("weixin_min_pay not in", values, "weixinMinPay");
            return (Criteria) this;
        }

        public Criteria andWeixinMinPayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weixin_min_pay between", value1, value2, "weixinMinPay");
            return (Criteria) this;
        }

        public Criteria andWeixinMinPayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weixin_min_pay not between", value1, value2, "weixinMinPay");
            return (Criteria) this;
        }

        public Criteria andWeixinAppPayIsNull() {
            addCriterion("weixin_app_pay is null");
            return (Criteria) this;
        }

        public Criteria andWeixinAppPayIsNotNull() {
            addCriterion("weixin_app_pay is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinAppPayEqualTo(BigDecimal value) {
            addCriterion("weixin_app_pay =", value, "weixinAppPay");
            return (Criteria) this;
        }

        public Criteria andWeixinAppPayNotEqualTo(BigDecimal value) {
            addCriterion("weixin_app_pay <>", value, "weixinAppPay");
            return (Criteria) this;
        }

        public Criteria andWeixinAppPayGreaterThan(BigDecimal value) {
            addCriterion("weixin_app_pay >", value, "weixinAppPay");
            return (Criteria) this;
        }

        public Criteria andWeixinAppPayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weixin_app_pay >=", value, "weixinAppPay");
            return (Criteria) this;
        }

        public Criteria andWeixinAppPayLessThan(BigDecimal value) {
            addCriterion("weixin_app_pay <", value, "weixinAppPay");
            return (Criteria) this;
        }

        public Criteria andWeixinAppPayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("weixin_app_pay <=", value, "weixinAppPay");
            return (Criteria) this;
        }

        public Criteria andWeixinAppPayIn(List<BigDecimal> values) {
            addCriterion("weixin_app_pay in", values, "weixinAppPay");
            return (Criteria) this;
        }

        public Criteria andWeixinAppPayNotIn(List<BigDecimal> values) {
            addCriterion("weixin_app_pay not in", values, "weixinAppPay");
            return (Criteria) this;
        }

        public Criteria andWeixinAppPayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weixin_app_pay between", value1, value2, "weixinAppPay");
            return (Criteria) this;
        }

        public Criteria andWeixinAppPayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weixin_app_pay not between", value1, value2, "weixinAppPay");
            return (Criteria) this;
        }

        public Criteria andAliH5PayIsNull() {
            addCriterion("ali_h5_pay is null");
            return (Criteria) this;
        }

        public Criteria andAliH5PayIsNotNull() {
            addCriterion("ali_h5_pay is not null");
            return (Criteria) this;
        }

        public Criteria andAliH5PayEqualTo(BigDecimal value) {
            addCriterion("ali_h5_pay =", value, "aliH5Pay");
            return (Criteria) this;
        }

        public Criteria andAliH5PayNotEqualTo(BigDecimal value) {
            addCriterion("ali_h5_pay <>", value, "aliH5Pay");
            return (Criteria) this;
        }

        public Criteria andAliH5PayGreaterThan(BigDecimal value) {
            addCriterion("ali_h5_pay >", value, "aliH5Pay");
            return (Criteria) this;
        }

        public Criteria andAliH5PayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ali_h5_pay >=", value, "aliH5Pay");
            return (Criteria) this;
        }

        public Criteria andAliH5PayLessThan(BigDecimal value) {
            addCriterion("ali_h5_pay <", value, "aliH5Pay");
            return (Criteria) this;
        }

        public Criteria andAliH5PayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ali_h5_pay <=", value, "aliH5Pay");
            return (Criteria) this;
        }

        public Criteria andAliH5PayIn(List<BigDecimal> values) {
            addCriterion("ali_h5_pay in", values, "aliH5Pay");
            return (Criteria) this;
        }

        public Criteria andAliH5PayNotIn(List<BigDecimal> values) {
            addCriterion("ali_h5_pay not in", values, "aliH5Pay");
            return (Criteria) this;
        }

        public Criteria andAliH5PayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ali_h5_pay between", value1, value2, "aliH5Pay");
            return (Criteria) this;
        }

        public Criteria andAliH5PayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ali_h5_pay not between", value1, value2, "aliH5Pay");
            return (Criteria) this;
        }

        public Criteria andAliMinPayIsNull() {
            addCriterion("ali_min_pay is null");
            return (Criteria) this;
        }

        public Criteria andAliMinPayIsNotNull() {
            addCriterion("ali_min_pay is not null");
            return (Criteria) this;
        }

        public Criteria andAliMinPayEqualTo(BigDecimal value) {
            addCriterion("ali_min_pay =", value, "aliMinPay");
            return (Criteria) this;
        }

        public Criteria andAliMinPayNotEqualTo(BigDecimal value) {
            addCriterion("ali_min_pay <>", value, "aliMinPay");
            return (Criteria) this;
        }

        public Criteria andAliMinPayGreaterThan(BigDecimal value) {
            addCriterion("ali_min_pay >", value, "aliMinPay");
            return (Criteria) this;
        }

        public Criteria andAliMinPayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ali_min_pay >=", value, "aliMinPay");
            return (Criteria) this;
        }

        public Criteria andAliMinPayLessThan(BigDecimal value) {
            addCriterion("ali_min_pay <", value, "aliMinPay");
            return (Criteria) this;
        }

        public Criteria andAliMinPayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ali_min_pay <=", value, "aliMinPay");
            return (Criteria) this;
        }

        public Criteria andAliMinPayIn(List<BigDecimal> values) {
            addCriterion("ali_min_pay in", values, "aliMinPay");
            return (Criteria) this;
        }

        public Criteria andAliMinPayNotIn(List<BigDecimal> values) {
            addCriterion("ali_min_pay not in", values, "aliMinPay");
            return (Criteria) this;
        }

        public Criteria andAliMinPayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ali_min_pay between", value1, value2, "aliMinPay");
            return (Criteria) this;
        }

        public Criteria andAliMinPayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ali_min_pay not between", value1, value2, "aliMinPay");
            return (Criteria) this;
        }

        public Criteria andAliAppPayIsNull() {
            addCriterion("ali_app_pay is null");
            return (Criteria) this;
        }

        public Criteria andAliAppPayIsNotNull() {
            addCriterion("ali_app_pay is not null");
            return (Criteria) this;
        }

        public Criteria andAliAppPayEqualTo(BigDecimal value) {
            addCriterion("ali_app_pay =", value, "aliAppPay");
            return (Criteria) this;
        }

        public Criteria andAliAppPayNotEqualTo(BigDecimal value) {
            addCriterion("ali_app_pay <>", value, "aliAppPay");
            return (Criteria) this;
        }

        public Criteria andAliAppPayGreaterThan(BigDecimal value) {
            addCriterion("ali_app_pay >", value, "aliAppPay");
            return (Criteria) this;
        }

        public Criteria andAliAppPayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ali_app_pay >=", value, "aliAppPay");
            return (Criteria) this;
        }

        public Criteria andAliAppPayLessThan(BigDecimal value) {
            addCriterion("ali_app_pay <", value, "aliAppPay");
            return (Criteria) this;
        }

        public Criteria andAliAppPayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ali_app_pay <=", value, "aliAppPay");
            return (Criteria) this;
        }

        public Criteria andAliAppPayIn(List<BigDecimal> values) {
            addCriterion("ali_app_pay in", values, "aliAppPay");
            return (Criteria) this;
        }

        public Criteria andAliAppPayNotIn(List<BigDecimal> values) {
            addCriterion("ali_app_pay not in", values, "aliAppPay");
            return (Criteria) this;
        }

        public Criteria andAliAppPayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ali_app_pay between", value1, value2, "aliAppPay");
            return (Criteria) this;
        }

        public Criteria andAliAppPayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ali_app_pay not between", value1, value2, "aliAppPay");
            return (Criteria) this;
        }

        public Criteria andParkPackagePayIsNull() {
            addCriterion("park_package_pay is null");
            return (Criteria) this;
        }

        public Criteria andParkPackagePayIsNotNull() {
            addCriterion("park_package_pay is not null");
            return (Criteria) this;
        }

        public Criteria andParkPackagePayEqualTo(BigDecimal value) {
            addCriterion("park_package_pay =", value, "parkPackagePay");
            return (Criteria) this;
        }

        public Criteria andParkPackagePayNotEqualTo(BigDecimal value) {
            addCriterion("park_package_pay <>", value, "parkPackagePay");
            return (Criteria) this;
        }

        public Criteria andParkPackagePayGreaterThan(BigDecimal value) {
            addCriterion("park_package_pay >", value, "parkPackagePay");
            return (Criteria) this;
        }

        public Criteria andParkPackagePayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("park_package_pay >=", value, "parkPackagePay");
            return (Criteria) this;
        }

        public Criteria andParkPackagePayLessThan(BigDecimal value) {
            addCriterion("park_package_pay <", value, "parkPackagePay");
            return (Criteria) this;
        }

        public Criteria andParkPackagePayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("park_package_pay <=", value, "parkPackagePay");
            return (Criteria) this;
        }

        public Criteria andParkPackagePayIn(List<BigDecimal> values) {
            addCriterion("park_package_pay in", values, "parkPackagePay");
            return (Criteria) this;
        }

        public Criteria andParkPackagePayNotIn(List<BigDecimal> values) {
            addCriterion("park_package_pay not in", values, "parkPackagePay");
            return (Criteria) this;
        }

        public Criteria andParkPackagePayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("park_package_pay between", value1, value2, "parkPackagePay");
            return (Criteria) this;
        }

        public Criteria andParkPackagePayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("park_package_pay not between", value1, value2, "parkPackagePay");
            return (Criteria) this;
        }

        public Criteria andBbcPayIsNull() {
            addCriterion("bbc_pay is null");
            return (Criteria) this;
        }

        public Criteria andBbcPayIsNotNull() {
            addCriterion("bbc_pay is not null");
            return (Criteria) this;
        }

        public Criteria andBbcPayEqualTo(BigDecimal value) {
            addCriterion("bbc_pay =", value, "bbcPay");
            return (Criteria) this;
        }

        public Criteria andBbcPayNotEqualTo(BigDecimal value) {
            addCriterion("bbc_pay <>", value, "bbcPay");
            return (Criteria) this;
        }

        public Criteria andBbcPayGreaterThan(BigDecimal value) {
            addCriterion("bbc_pay >", value, "bbcPay");
            return (Criteria) this;
        }

        public Criteria andBbcPayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bbc_pay >=", value, "bbcPay");
            return (Criteria) this;
        }

        public Criteria andBbcPayLessThan(BigDecimal value) {
            addCriterion("bbc_pay <", value, "bbcPay");
            return (Criteria) this;
        }

        public Criteria andBbcPayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bbc_pay <=", value, "bbcPay");
            return (Criteria) this;
        }

        public Criteria andBbcPayIn(List<BigDecimal> values) {
            addCriterion("bbc_pay in", values, "bbcPay");
            return (Criteria) this;
        }

        public Criteria andBbcPayNotIn(List<BigDecimal> values) {
            addCriterion("bbc_pay not in", values, "bbcPay");
            return (Criteria) this;
        }

        public Criteria andBbcPayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bbc_pay between", value1, value2, "bbcPay");
            return (Criteria) this;
        }

        public Criteria andBbcPayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bbc_pay not between", value1, value2, "bbcPay");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountsPayableIsNull() {
            addCriterion("recharge_amounts_payable is null");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountsPayableIsNotNull() {
            addCriterion("recharge_amounts_payable is not null");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountsPayableEqualTo(BigDecimal value) {
            addCriterion("recharge_amounts_payable =", value, "rechargeAmountsPayable");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountsPayableNotEqualTo(BigDecimal value) {
            addCriterion("recharge_amounts_payable <>", value, "rechargeAmountsPayable");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountsPayableGreaterThan(BigDecimal value) {
            addCriterion("recharge_amounts_payable >", value, "rechargeAmountsPayable");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountsPayableGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("recharge_amounts_payable >=", value, "rechargeAmountsPayable");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountsPayableLessThan(BigDecimal value) {
            addCriterion("recharge_amounts_payable <", value, "rechargeAmountsPayable");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountsPayableLessThanOrEqualTo(BigDecimal value) {
            addCriterion("recharge_amounts_payable <=", value, "rechargeAmountsPayable");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountsPayableIn(List<BigDecimal> values) {
            addCriterion("recharge_amounts_payable in", values, "rechargeAmountsPayable");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountsPayableNotIn(List<BigDecimal> values) {
            addCriterion("recharge_amounts_payable not in", values, "rechargeAmountsPayable");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountsPayableBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("recharge_amounts_payable between", value1, value2, "rechargeAmountsPayable");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountsPayableNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("recharge_amounts_payable not between", value1, value2, "rechargeAmountsPayable");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountActuallyPaidIsNull() {
            addCriterion("recharge_amount_actually_paid is null");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountActuallyPaidIsNotNull() {
            addCriterion("recharge_amount_actually_paid is not null");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountActuallyPaidEqualTo(BigDecimal value) {
            addCriterion("recharge_amount_actually_paid =", value, "rechargeAmountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountActuallyPaidNotEqualTo(BigDecimal value) {
            addCriterion("recharge_amount_actually_paid <>", value, "rechargeAmountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountActuallyPaidGreaterThan(BigDecimal value) {
            addCriterion("recharge_amount_actually_paid >", value, "rechargeAmountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountActuallyPaidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("recharge_amount_actually_paid >=", value, "rechargeAmountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountActuallyPaidLessThan(BigDecimal value) {
            addCriterion("recharge_amount_actually_paid <", value, "rechargeAmountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountActuallyPaidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("recharge_amount_actually_paid <=", value, "rechargeAmountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountActuallyPaidIn(List<BigDecimal> values) {
            addCriterion("recharge_amount_actually_paid in", values, "rechargeAmountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountActuallyPaidNotIn(List<BigDecimal> values) {
            addCriterion("recharge_amount_actually_paid not in", values, "rechargeAmountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountActuallyPaidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("recharge_amount_actually_paid between", value1, value2, "rechargeAmountActuallyPaid");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountActuallyPaidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("recharge_amount_actually_paid not between", value1, value2, "rechargeAmountActuallyPaid");
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