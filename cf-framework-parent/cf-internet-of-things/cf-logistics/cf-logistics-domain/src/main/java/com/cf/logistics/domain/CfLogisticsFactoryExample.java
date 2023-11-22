package com.cf.logistics.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CfLogisticsFactoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfLogisticsFactoryExample() {
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

        public Criteria andFactoryNameIsNull() {
            addCriterion("factory_name is null");
            return (Criteria) this;
        }

        public Criteria andFactoryNameIsNotNull() {
            addCriterion("factory_name is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryNameEqualTo(String value) {
            addCriterion("factory_name =", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameNotEqualTo(String value) {
            addCriterion("factory_name <>", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameGreaterThan(String value) {
            addCriterion("factory_name >", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("factory_name >=", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameLessThan(String value) {
            addCriterion("factory_name <", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameLessThanOrEqualTo(String value) {
            addCriterion("factory_name <=", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameLike(String value) {
            addCriterion("factory_name like", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameNotLike(String value) {
            addCriterion("factory_name not like", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameIn(List<String> values) {
            addCriterion("factory_name in", values, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameNotIn(List<String> values) {
            addCriterion("factory_name not in", values, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameBetween(String value1, String value2) {
            addCriterion("factory_name between", value1, value2, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameNotBetween(String value1, String value2) {
            addCriterion("factory_name not between", value1, value2, "factoryName");
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

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andPrincipalIsNull() {
            addCriterion("principal is null");
            return (Criteria) this;
        }

        public Criteria andPrincipalIsNotNull() {
            addCriterion("principal is not null");
            return (Criteria) this;
        }

        public Criteria andPrincipalEqualTo(String value) {
            addCriterion("principal =", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotEqualTo(String value) {
            addCriterion("principal <>", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalGreaterThan(String value) {
            addCriterion("principal >", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalGreaterThanOrEqualTo(String value) {
            addCriterion("principal >=", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalLessThan(String value) {
            addCriterion("principal <", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalLessThanOrEqualTo(String value) {
            addCriterion("principal <=", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalLike(String value) {
            addCriterion("principal like", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotLike(String value) {
            addCriterion("principal not like", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalIn(List<String> values) {
            addCriterion("principal in", values, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotIn(List<String> values) {
            addCriterion("principal not in", values, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalBetween(String value1, String value2) {
            addCriterion("principal between", value1, value2, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotBetween(String value1, String value2) {
            addCriterion("principal not between", value1, value2, "principal");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andSignInRangeIsNull() {
            addCriterion("sign_in_range is null");
            return (Criteria) this;
        }

        public Criteria andSignInRangeIsNotNull() {
            addCriterion("sign_in_range is not null");
            return (Criteria) this;
        }

        public Criteria andSignInRangeEqualTo(Integer value) {
            addCriterion("sign_in_range =", value, "signInRange");
            return (Criteria) this;
        }

        public Criteria andSignInRangeNotEqualTo(Integer value) {
            addCriterion("sign_in_range <>", value, "signInRange");
            return (Criteria) this;
        }

        public Criteria andSignInRangeGreaterThan(Integer value) {
            addCriterion("sign_in_range >", value, "signInRange");
            return (Criteria) this;
        }

        public Criteria andSignInRangeGreaterThanOrEqualTo(Integer value) {
            addCriterion("sign_in_range >=", value, "signInRange");
            return (Criteria) this;
        }

        public Criteria andSignInRangeLessThan(Integer value) {
            addCriterion("sign_in_range <", value, "signInRange");
            return (Criteria) this;
        }

        public Criteria andSignInRangeLessThanOrEqualTo(Integer value) {
            addCriterion("sign_in_range <=", value, "signInRange");
            return (Criteria) this;
        }

        public Criteria andSignInRangeIn(List<Integer> values) {
            addCriterion("sign_in_range in", values, "signInRange");
            return (Criteria) this;
        }

        public Criteria andSignInRangeNotIn(List<Integer> values) {
            addCriterion("sign_in_range not in", values, "signInRange");
            return (Criteria) this;
        }

        public Criteria andSignInRangeBetween(Integer value1, Integer value2) {
            addCriterion("sign_in_range between", value1, value2, "signInRange");
            return (Criteria) this;
        }

        public Criteria andSignInRangeNotBetween(Integer value1, Integer value2) {
            addCriterion("sign_in_range not between", value1, value2, "signInRange");
            return (Criteria) this;
        }

        public Criteria andWxMpAppidIsNull() {
            addCriterion("wx_mp_appid is null");
            return (Criteria) this;
        }

        public Criteria andWxMpAppidIsNotNull() {
            addCriterion("wx_mp_appid is not null");
            return (Criteria) this;
        }

        public Criteria andWxMpAppidEqualTo(String value) {
            addCriterion("wx_mp_appid =", value, "wxMpAppid");
            return (Criteria) this;
        }

        public Criteria andWxMpAppidNotEqualTo(String value) {
            addCriterion("wx_mp_appid <>", value, "wxMpAppid");
            return (Criteria) this;
        }

        public Criteria andWxMpAppidGreaterThan(String value) {
            addCriterion("wx_mp_appid >", value, "wxMpAppid");
            return (Criteria) this;
        }

        public Criteria andWxMpAppidGreaterThanOrEqualTo(String value) {
            addCriterion("wx_mp_appid >=", value, "wxMpAppid");
            return (Criteria) this;
        }

        public Criteria andWxMpAppidLessThan(String value) {
            addCriterion("wx_mp_appid <", value, "wxMpAppid");
            return (Criteria) this;
        }

        public Criteria andWxMpAppidLessThanOrEqualTo(String value) {
            addCriterion("wx_mp_appid <=", value, "wxMpAppid");
            return (Criteria) this;
        }

        public Criteria andWxMpAppidLike(String value) {
            addCriterion("wx_mp_appid like", value, "wxMpAppid");
            return (Criteria) this;
        }

        public Criteria andWxMpAppidNotLike(String value) {
            addCriterion("wx_mp_appid not like", value, "wxMpAppid");
            return (Criteria) this;
        }

        public Criteria andWxMpAppidIn(List<String> values) {
            addCriterion("wx_mp_appid in", values, "wxMpAppid");
            return (Criteria) this;
        }

        public Criteria andWxMpAppidNotIn(List<String> values) {
            addCriterion("wx_mp_appid not in", values, "wxMpAppid");
            return (Criteria) this;
        }

        public Criteria andWxMpAppidBetween(String value1, String value2) {
            addCriterion("wx_mp_appid between", value1, value2, "wxMpAppid");
            return (Criteria) this;
        }

        public Criteria andWxMpAppidNotBetween(String value1, String value2) {
            addCriterion("wx_mp_appid not between", value1, value2, "wxMpAppid");
            return (Criteria) this;
        }

        public Criteria andWxPubAppidIsNull() {
            addCriterion("wx_pub_appid is null");
            return (Criteria) this;
        }

        public Criteria andWxPubAppidIsNotNull() {
            addCriterion("wx_pub_appid is not null");
            return (Criteria) this;
        }

        public Criteria andWxPubAppidEqualTo(String value) {
            addCriterion("wx_pub_appid =", value, "wxPubAppid");
            return (Criteria) this;
        }

        public Criteria andWxPubAppidNotEqualTo(String value) {
            addCriterion("wx_pub_appid <>", value, "wxPubAppid");
            return (Criteria) this;
        }

        public Criteria andWxPubAppidGreaterThan(String value) {
            addCriterion("wx_pub_appid >", value, "wxPubAppid");
            return (Criteria) this;
        }

        public Criteria andWxPubAppidGreaterThanOrEqualTo(String value) {
            addCriterion("wx_pub_appid >=", value, "wxPubAppid");
            return (Criteria) this;
        }

        public Criteria andWxPubAppidLessThan(String value) {
            addCriterion("wx_pub_appid <", value, "wxPubAppid");
            return (Criteria) this;
        }

        public Criteria andWxPubAppidLessThanOrEqualTo(String value) {
            addCriterion("wx_pub_appid <=", value, "wxPubAppid");
            return (Criteria) this;
        }

        public Criteria andWxPubAppidLike(String value) {
            addCriterion("wx_pub_appid like", value, "wxPubAppid");
            return (Criteria) this;
        }

        public Criteria andWxPubAppidNotLike(String value) {
            addCriterion("wx_pub_appid not like", value, "wxPubAppid");
            return (Criteria) this;
        }

        public Criteria andWxPubAppidIn(List<String> values) {
            addCriterion("wx_pub_appid in", values, "wxPubAppid");
            return (Criteria) this;
        }

        public Criteria andWxPubAppidNotIn(List<String> values) {
            addCriterion("wx_pub_appid not in", values, "wxPubAppid");
            return (Criteria) this;
        }

        public Criteria andWxPubAppidBetween(String value1, String value2) {
            addCriterion("wx_pub_appid between", value1, value2, "wxPubAppid");
            return (Criteria) this;
        }

        public Criteria andWxPubAppidNotBetween(String value1, String value2) {
            addCriterion("wx_pub_appid not between", value1, value2, "wxPubAppid");
            return (Criteria) this;
        }

        public Criteria andCarParkIdsIsNull() {
            addCriterion("car_park_ids is null");
            return (Criteria) this;
        }

        public Criteria andCarParkIdsIsNotNull() {
            addCriterion("car_park_ids is not null");
            return (Criteria) this;
        }

        public Criteria andCarParkIdsEqualTo(String value) {
            addCriterion("car_park_ids =", value, "carParkIds");
            return (Criteria) this;
        }

        public Criteria andCarParkIdsNotEqualTo(String value) {
            addCriterion("car_park_ids <>", value, "carParkIds");
            return (Criteria) this;
        }

        public Criteria andCarParkIdsGreaterThan(String value) {
            addCriterion("car_park_ids >", value, "carParkIds");
            return (Criteria) this;
        }

        public Criteria andCarParkIdsGreaterThanOrEqualTo(String value) {
            addCriterion("car_park_ids >=", value, "carParkIds");
            return (Criteria) this;
        }

        public Criteria andCarParkIdsLessThan(String value) {
            addCriterion("car_park_ids <", value, "carParkIds");
            return (Criteria) this;
        }

        public Criteria andCarParkIdsLessThanOrEqualTo(String value) {
            addCriterion("car_park_ids <=", value, "carParkIds");
            return (Criteria) this;
        }

        public Criteria andCarParkIdsLike(String value) {
            addCriterion("car_park_ids like", value, "carParkIds");
            return (Criteria) this;
        }

        public Criteria andCarParkIdsNotLike(String value) {
            addCriterion("car_park_ids not like", value, "carParkIds");
            return (Criteria) this;
        }

        public Criteria andCarParkIdsIn(List<String> values) {
            addCriterion("car_park_ids in", values, "carParkIds");
            return (Criteria) this;
        }

        public Criteria andCarParkIdsNotIn(List<String> values) {
            addCriterion("car_park_ids not in", values, "carParkIds");
            return (Criteria) this;
        }

        public Criteria andCarParkIdsBetween(String value1, String value2) {
            addCriterion("car_park_ids between", value1, value2, "carParkIds");
            return (Criteria) this;
        }

        public Criteria andCarParkIdsNotBetween(String value1, String value2) {
            addCriterion("car_park_ids not between", value1, value2, "carParkIds");
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