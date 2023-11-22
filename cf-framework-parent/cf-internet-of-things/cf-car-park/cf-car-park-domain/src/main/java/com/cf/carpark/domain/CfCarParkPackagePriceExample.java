package com.cf.carpark.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CfCarParkPackagePriceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfCarParkPackagePriceExample() {
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

        public Criteria andSubtitleIsNull() {
            addCriterion("subtitle is null");
            return (Criteria) this;
        }

        public Criteria andSubtitleIsNotNull() {
            addCriterion("subtitle is not null");
            return (Criteria) this;
        }

        public Criteria andSubtitleEqualTo(String value) {
            addCriterion("subtitle =", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotEqualTo(String value) {
            addCriterion("subtitle <>", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleGreaterThan(String value) {
            addCriterion("subtitle >", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleGreaterThanOrEqualTo(String value) {
            addCriterion("subtitle >=", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLessThan(String value) {
            addCriterion("subtitle <", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLessThanOrEqualTo(String value) {
            addCriterion("subtitle <=", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLike(String value) {
            addCriterion("subtitle like", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotLike(String value) {
            addCriterion("subtitle not like", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleIn(List<String> values) {
            addCriterion("subtitle in", values, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotIn(List<String> values) {
            addCriterion("subtitle not in", values, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleBetween(String value1, String value2) {
            addCriterion("subtitle between", value1, value2, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotBetween(String value1, String value2) {
            addCriterion("subtitle not between", value1, value2, "subtitle");
            return (Criteria) this;
        }

        public Criteria andImageIsNull() {
            addCriterion("image is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("image is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("image =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("image <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("image >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("image >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("image <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("image <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("image like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("image not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("image in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("image not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("image between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("image not between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andFlagKeyIsNull() {
            addCriterion("flag_key is null");
            return (Criteria) this;
        }

        public Criteria andFlagKeyIsNotNull() {
            addCriterion("flag_key is not null");
            return (Criteria) this;
        }

        public Criteria andFlagKeyEqualTo(String value) {
            addCriterion("flag_key =", value, "flagKey");
            return (Criteria) this;
        }

        public Criteria andFlagKeyNotEqualTo(String value) {
            addCriterion("flag_key <>", value, "flagKey");
            return (Criteria) this;
        }

        public Criteria andFlagKeyGreaterThan(String value) {
            addCriterion("flag_key >", value, "flagKey");
            return (Criteria) this;
        }

        public Criteria andFlagKeyGreaterThanOrEqualTo(String value) {
            addCriterion("flag_key >=", value, "flagKey");
            return (Criteria) this;
        }

        public Criteria andFlagKeyLessThan(String value) {
            addCriterion("flag_key <", value, "flagKey");
            return (Criteria) this;
        }

        public Criteria andFlagKeyLessThanOrEqualTo(String value) {
            addCriterion("flag_key <=", value, "flagKey");
            return (Criteria) this;
        }

        public Criteria andFlagKeyLike(String value) {
            addCriterion("flag_key like", value, "flagKey");
            return (Criteria) this;
        }

        public Criteria andFlagKeyNotLike(String value) {
            addCriterion("flag_key not like", value, "flagKey");
            return (Criteria) this;
        }

        public Criteria andFlagKeyIn(List<String> values) {
            addCriterion("flag_key in", values, "flagKey");
            return (Criteria) this;
        }

        public Criteria andFlagKeyNotIn(List<String> values) {
            addCriterion("flag_key not in", values, "flagKey");
            return (Criteria) this;
        }

        public Criteria andFlagKeyBetween(String value1, String value2) {
            addCriterion("flag_key between", value1, value2, "flagKey");
            return (Criteria) this;
        }

        public Criteria andFlagKeyNotBetween(String value1, String value2) {
            addCriterion("flag_key not between", value1, value2, "flagKey");
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

        public Criteria andOriginalPriceIsNull() {
            addCriterion("original_price is null");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIsNotNull() {
            addCriterion("original_price is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceEqualTo(BigDecimal value) {
            addCriterion("original_price =", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotEqualTo(BigDecimal value) {
            addCriterion("original_price <>", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceGreaterThan(BigDecimal value) {
            addCriterion("original_price >", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("original_price >=", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceLessThan(BigDecimal value) {
            addCriterion("original_price <", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("original_price <=", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIn(List<BigDecimal> values) {
            addCriterion("original_price in", values, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotIn(List<BigDecimal> values) {
            addCriterion("original_price not in", values, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("original_price between", value1, value2, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("original_price not between", value1, value2, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceIsNull() {
            addCriterion("current_price is null");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceIsNotNull() {
            addCriterion("current_price is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceEqualTo(BigDecimal value) {
            addCriterion("current_price =", value, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceNotEqualTo(BigDecimal value) {
            addCriterion("current_price <>", value, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceGreaterThan(BigDecimal value) {
            addCriterion("current_price >", value, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("current_price >=", value, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceLessThan(BigDecimal value) {
            addCriterion("current_price <", value, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("current_price <=", value, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceIn(List<BigDecimal> values) {
            addCriterion("current_price in", values, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceNotIn(List<BigDecimal> values) {
            addCriterion("current_price not in", values, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("current_price between", value1, value2, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("current_price not between", value1, value2, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andTimeQuotaIsNull() {
            addCriterion("time_quota is null");
            return (Criteria) this;
        }

        public Criteria andTimeQuotaIsNotNull() {
            addCriterion("time_quota is not null");
            return (Criteria) this;
        }

        public Criteria andTimeQuotaEqualTo(Long value) {
            addCriterion("time_quota =", value, "timeQuota");
            return (Criteria) this;
        }

        public Criteria andTimeQuotaNotEqualTo(Long value) {
            addCriterion("time_quota <>", value, "timeQuota");
            return (Criteria) this;
        }

        public Criteria andTimeQuotaGreaterThan(Long value) {
            addCriterion("time_quota >", value, "timeQuota");
            return (Criteria) this;
        }

        public Criteria andTimeQuotaGreaterThanOrEqualTo(Long value) {
            addCriterion("time_quota >=", value, "timeQuota");
            return (Criteria) this;
        }

        public Criteria andTimeQuotaLessThan(Long value) {
            addCriterion("time_quota <", value, "timeQuota");
            return (Criteria) this;
        }

        public Criteria andTimeQuotaLessThanOrEqualTo(Long value) {
            addCriterion("time_quota <=", value, "timeQuota");
            return (Criteria) this;
        }

        public Criteria andTimeQuotaIn(List<Long> values) {
            addCriterion("time_quota in", values, "timeQuota");
            return (Criteria) this;
        }

        public Criteria andTimeQuotaNotIn(List<Long> values) {
            addCriterion("time_quota not in", values, "timeQuota");
            return (Criteria) this;
        }

        public Criteria andTimeQuotaBetween(Long value1, Long value2) {
            addCriterion("time_quota between", value1, value2, "timeQuota");
            return (Criteria) this;
        }

        public Criteria andTimeQuotaNotBetween(Long value1, Long value2) {
            addCriterion("time_quota not between", value1, value2, "timeQuota");
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

        public Criteria andSpecialGiveIsNull() {
            addCriterion("special_give is null");
            return (Criteria) this;
        }

        public Criteria andSpecialGiveIsNotNull() {
            addCriterion("special_give is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialGiveEqualTo(Byte value) {
            addCriterion("special_give =", value, "specialGive");
            return (Criteria) this;
        }

        public Criteria andSpecialGiveNotEqualTo(Byte value) {
            addCriterion("special_give <>", value, "specialGive");
            return (Criteria) this;
        }

        public Criteria andSpecialGiveGreaterThan(Byte value) {
            addCriterion("special_give >", value, "specialGive");
            return (Criteria) this;
        }

        public Criteria andSpecialGiveGreaterThanOrEqualTo(Byte value) {
            addCriterion("special_give >=", value, "specialGive");
            return (Criteria) this;
        }

        public Criteria andSpecialGiveLessThan(Byte value) {
            addCriterion("special_give <", value, "specialGive");
            return (Criteria) this;
        }

        public Criteria andSpecialGiveLessThanOrEqualTo(Byte value) {
            addCriterion("special_give <=", value, "specialGive");
            return (Criteria) this;
        }

        public Criteria andSpecialGiveIn(List<Byte> values) {
            addCriterion("special_give in", values, "specialGive");
            return (Criteria) this;
        }

        public Criteria andSpecialGiveNotIn(List<Byte> values) {
            addCriterion("special_give not in", values, "specialGive");
            return (Criteria) this;
        }

        public Criteria andSpecialGiveBetween(Byte value1, Byte value2) {
            addCriterion("special_give between", value1, value2, "specialGive");
            return (Criteria) this;
        }

        public Criteria andSpecialGiveNotBetween(Byte value1, Byte value2) {
            addCriterion("special_give not between", value1, value2, "specialGive");
            return (Criteria) this;
        }

        public Criteria andGracePeriodIsNull() {
            addCriterion("grace_period is null");
            return (Criteria) this;
        }

        public Criteria andGracePeriodIsNotNull() {
            addCriterion("grace_period is not null");
            return (Criteria) this;
        }

        public Criteria andGracePeriodEqualTo(Long value) {
            addCriterion("grace_period =", value, "gracePeriod");
            return (Criteria) this;
        }

        public Criteria andGracePeriodNotEqualTo(Long value) {
            addCriterion("grace_period <>", value, "gracePeriod");
            return (Criteria) this;
        }

        public Criteria andGracePeriodGreaterThan(Long value) {
            addCriterion("grace_period >", value, "gracePeriod");
            return (Criteria) this;
        }

        public Criteria andGracePeriodGreaterThanOrEqualTo(Long value) {
            addCriterion("grace_period >=", value, "gracePeriod");
            return (Criteria) this;
        }

        public Criteria andGracePeriodLessThan(Long value) {
            addCriterion("grace_period <", value, "gracePeriod");
            return (Criteria) this;
        }

        public Criteria andGracePeriodLessThanOrEqualTo(Long value) {
            addCriterion("grace_period <=", value, "gracePeriod");
            return (Criteria) this;
        }

        public Criteria andGracePeriodIn(List<Long> values) {
            addCriterion("grace_period in", values, "gracePeriod");
            return (Criteria) this;
        }

        public Criteria andGracePeriodNotIn(List<Long> values) {
            addCriterion("grace_period not in", values, "gracePeriod");
            return (Criteria) this;
        }

        public Criteria andGracePeriodBetween(Long value1, Long value2) {
            addCriterion("grace_period between", value1, value2, "gracePeriod");
            return (Criteria) this;
        }

        public Criteria andGracePeriodNotBetween(Long value1, Long value2) {
            addCriterion("grace_period not between", value1, value2, "gracePeriod");
            return (Criteria) this;
        }

        public Criteria andUseGracePeriodIsNull() {
            addCriterion("use_grace_period is null");
            return (Criteria) this;
        }

        public Criteria andUseGracePeriodIsNotNull() {
            addCriterion("use_grace_period is not null");
            return (Criteria) this;
        }

        public Criteria andUseGracePeriodEqualTo(Byte value) {
            addCriterion("use_grace_period =", value, "useGracePeriod");
            return (Criteria) this;
        }

        public Criteria andUseGracePeriodNotEqualTo(Byte value) {
            addCriterion("use_grace_period <>", value, "useGracePeriod");
            return (Criteria) this;
        }

        public Criteria andUseGracePeriodGreaterThan(Byte value) {
            addCriterion("use_grace_period >", value, "useGracePeriod");
            return (Criteria) this;
        }

        public Criteria andUseGracePeriodGreaterThanOrEqualTo(Byte value) {
            addCriterion("use_grace_period >=", value, "useGracePeriod");
            return (Criteria) this;
        }

        public Criteria andUseGracePeriodLessThan(Byte value) {
            addCriterion("use_grace_period <", value, "useGracePeriod");
            return (Criteria) this;
        }

        public Criteria andUseGracePeriodLessThanOrEqualTo(Byte value) {
            addCriterion("use_grace_period <=", value, "useGracePeriod");
            return (Criteria) this;
        }

        public Criteria andUseGracePeriodIn(List<Byte> values) {
            addCriterion("use_grace_period in", values, "useGracePeriod");
            return (Criteria) this;
        }

        public Criteria andUseGracePeriodNotIn(List<Byte> values) {
            addCriterion("use_grace_period not in", values, "useGracePeriod");
            return (Criteria) this;
        }

        public Criteria andUseGracePeriodBetween(Byte value1, Byte value2) {
            addCriterion("use_grace_period between", value1, value2, "useGracePeriod");
            return (Criteria) this;
        }

        public Criteria andUseGracePeriodNotBetween(Byte value1, Byte value2) {
            addCriterion("use_grace_period not between", value1, value2, "useGracePeriod");
            return (Criteria) this;
        }

        public Criteria andSpecialCarPackageIsNull() {
            addCriterion("special_car_package is null");
            return (Criteria) this;
        }

        public Criteria andSpecialCarPackageIsNotNull() {
            addCriterion("special_car_package is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialCarPackageEqualTo(Byte value) {
            addCriterion("special_car_package =", value, "specialCarPackage");
            return (Criteria) this;
        }

        public Criteria andSpecialCarPackageNotEqualTo(Byte value) {
            addCriterion("special_car_package <>", value, "specialCarPackage");
            return (Criteria) this;
        }

        public Criteria andSpecialCarPackageGreaterThan(Byte value) {
            addCriterion("special_car_package >", value, "specialCarPackage");
            return (Criteria) this;
        }

        public Criteria andSpecialCarPackageGreaterThanOrEqualTo(Byte value) {
            addCriterion("special_car_package >=", value, "specialCarPackage");
            return (Criteria) this;
        }

        public Criteria andSpecialCarPackageLessThan(Byte value) {
            addCriterion("special_car_package <", value, "specialCarPackage");
            return (Criteria) this;
        }

        public Criteria andSpecialCarPackageLessThanOrEqualTo(Byte value) {
            addCriterion("special_car_package <=", value, "specialCarPackage");
            return (Criteria) this;
        }

        public Criteria andSpecialCarPackageIn(List<Byte> values) {
            addCriterion("special_car_package in", values, "specialCarPackage");
            return (Criteria) this;
        }

        public Criteria andSpecialCarPackageNotIn(List<Byte> values) {
            addCriterion("special_car_package not in", values, "specialCarPackage");
            return (Criteria) this;
        }

        public Criteria andSpecialCarPackageBetween(Byte value1, Byte value2) {
            addCriterion("special_car_package between", value1, value2, "specialCarPackage");
            return (Criteria) this;
        }

        public Criteria andSpecialCarPackageNotBetween(Byte value1, Byte value2) {
            addCriterion("special_car_package not between", value1, value2, "specialCarPackage");
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