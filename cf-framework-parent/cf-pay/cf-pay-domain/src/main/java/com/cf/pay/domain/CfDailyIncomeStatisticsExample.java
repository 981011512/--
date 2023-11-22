package com.cf.pay.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CfDailyIncomeStatisticsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfDailyIncomeStatisticsExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
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

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(Short value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Short value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Short value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Short value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Short value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Short value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Short> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Short> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Short value1, Short value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Short value1, Short value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andMonthIsNull() {
            addCriterion("month is null");
            return (Criteria) this;
        }

        public Criteria andMonthIsNotNull() {
            addCriterion("month is not null");
            return (Criteria) this;
        }

        public Criteria andMonthEqualTo(Byte value) {
            addCriterion("month =", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotEqualTo(Byte value) {
            addCriterion("month <>", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThan(Byte value) {
            addCriterion("month >", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThanOrEqualTo(Byte value) {
            addCriterion("month >=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThan(Byte value) {
            addCriterion("month <", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThanOrEqualTo(Byte value) {
            addCriterion("month <=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthIn(List<Byte> values) {
            addCriterion("month in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotIn(List<Byte> values) {
            addCriterion("month not in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthBetween(Byte value1, Byte value2) {
            addCriterion("month between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotBetween(Byte value1, Byte value2) {
            addCriterion("month not between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Byte value) {
            addCriterion("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Byte value) {
            addCriterion("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Byte value) {
            addCriterion("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Byte value) {
            addCriterion("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Byte value) {
            addCriterion("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Byte value) {
            addCriterion("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Byte> values) {
            addCriterion("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Byte> values) {
            addCriterion("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Byte value1, Byte value2) {
            addCriterion("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Byte value1, Byte value2) {
            addCriterion("date not between", value1, value2, "date");
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

        public Criteria andPayCountsIsNull() {
            addCriterion("pay_counts is null");
            return (Criteria) this;
        }

        public Criteria andPayCountsIsNotNull() {
            addCriterion("pay_counts is not null");
            return (Criteria) this;
        }

        public Criteria andPayCountsEqualTo(Integer value) {
            addCriterion("pay_counts =", value, "payCounts");
            return (Criteria) this;
        }

        public Criteria andPayCountsNotEqualTo(Integer value) {
            addCriterion("pay_counts <>", value, "payCounts");
            return (Criteria) this;
        }

        public Criteria andPayCountsGreaterThan(Integer value) {
            addCriterion("pay_counts >", value, "payCounts");
            return (Criteria) this;
        }

        public Criteria andPayCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_counts >=", value, "payCounts");
            return (Criteria) this;
        }

        public Criteria andPayCountsLessThan(Integer value) {
            addCriterion("pay_counts <", value, "payCounts");
            return (Criteria) this;
        }

        public Criteria andPayCountsLessThanOrEqualTo(Integer value) {
            addCriterion("pay_counts <=", value, "payCounts");
            return (Criteria) this;
        }

        public Criteria andPayCountsIn(List<Integer> values) {
            addCriterion("pay_counts in", values, "payCounts");
            return (Criteria) this;
        }

        public Criteria andPayCountsNotIn(List<Integer> values) {
            addCriterion("pay_counts not in", values, "payCounts");
            return (Criteria) this;
        }

        public Criteria andPayCountsBetween(Integer value1, Integer value2) {
            addCriterion("pay_counts between", value1, value2, "payCounts");
            return (Criteria) this;
        }

        public Criteria andPayCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_counts not between", value1, value2, "payCounts");
            return (Criteria) this;
        }

        public Criteria andCountsTimeIsNull() {
            addCriterion("counts_time is null");
            return (Criteria) this;
        }

        public Criteria andCountsTimeIsNotNull() {
            addCriterion("counts_time is not null");
            return (Criteria) this;
        }

        public Criteria andCountsTimeEqualTo(Long value) {
            addCriterion("counts_time =", value, "countsTime");
            return (Criteria) this;
        }

        public Criteria andCountsTimeNotEqualTo(Long value) {
            addCriterion("counts_time <>", value, "countsTime");
            return (Criteria) this;
        }

        public Criteria andCountsTimeGreaterThan(Long value) {
            addCriterion("counts_time >", value, "countsTime");
            return (Criteria) this;
        }

        public Criteria andCountsTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("counts_time >=", value, "countsTime");
            return (Criteria) this;
        }

        public Criteria andCountsTimeLessThan(Long value) {
            addCriterion("counts_time <", value, "countsTime");
            return (Criteria) this;
        }

        public Criteria andCountsTimeLessThanOrEqualTo(Long value) {
            addCriterion("counts_time <=", value, "countsTime");
            return (Criteria) this;
        }

        public Criteria andCountsTimeIn(List<Long> values) {
            addCriterion("counts_time in", values, "countsTime");
            return (Criteria) this;
        }

        public Criteria andCountsTimeNotIn(List<Long> values) {
            addCriterion("counts_time not in", values, "countsTime");
            return (Criteria) this;
        }

        public Criteria andCountsTimeBetween(Long value1, Long value2) {
            addCriterion("counts_time between", value1, value2, "countsTime");
            return (Criteria) this;
        }

        public Criteria andCountsTimeNotBetween(Long value1, Long value2) {
            addCriterion("counts_time not between", value1, value2, "countsTime");
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