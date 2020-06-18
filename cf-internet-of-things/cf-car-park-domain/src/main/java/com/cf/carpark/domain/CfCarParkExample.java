package com.cf.carpark.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CfCarParkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfCarParkExample() {
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

        public Criteria andStartBusinessHoursIsNull() {
            addCriterion("start_business_hours is null");
            return (Criteria) this;
        }

        public Criteria andStartBusinessHoursIsNotNull() {
            addCriterion("start_business_hours is not null");
            return (Criteria) this;
        }

        public Criteria andStartBusinessHoursEqualTo(Long value) {
            addCriterion("start_business_hours =", value, "startBusinessHours");
            return (Criteria) this;
        }

        public Criteria andStartBusinessHoursNotEqualTo(Long value) {
            addCriterion("start_business_hours <>", value, "startBusinessHours");
            return (Criteria) this;
        }

        public Criteria andStartBusinessHoursGreaterThan(Long value) {
            addCriterion("start_business_hours >", value, "startBusinessHours");
            return (Criteria) this;
        }

        public Criteria andStartBusinessHoursGreaterThanOrEqualTo(Long value) {
            addCriterion("start_business_hours >=", value, "startBusinessHours");
            return (Criteria) this;
        }

        public Criteria andStartBusinessHoursLessThan(Long value) {
            addCriterion("start_business_hours <", value, "startBusinessHours");
            return (Criteria) this;
        }

        public Criteria andStartBusinessHoursLessThanOrEqualTo(Long value) {
            addCriterion("start_business_hours <=", value, "startBusinessHours");
            return (Criteria) this;
        }

        public Criteria andStartBusinessHoursIn(List<Long> values) {
            addCriterion("start_business_hours in", values, "startBusinessHours");
            return (Criteria) this;
        }

        public Criteria andStartBusinessHoursNotIn(List<Long> values) {
            addCriterion("start_business_hours not in", values, "startBusinessHours");
            return (Criteria) this;
        }

        public Criteria andStartBusinessHoursBetween(Long value1, Long value2) {
            addCriterion("start_business_hours between", value1, value2, "startBusinessHours");
            return (Criteria) this;
        }

        public Criteria andStartBusinessHoursNotBetween(Long value1, Long value2) {
            addCriterion("start_business_hours not between", value1, value2, "startBusinessHours");
            return (Criteria) this;
        }

        public Criteria andEndBusinessHoursIsNull() {
            addCriterion("end_business_hours is null");
            return (Criteria) this;
        }

        public Criteria andEndBusinessHoursIsNotNull() {
            addCriterion("end_business_hours is not null");
            return (Criteria) this;
        }

        public Criteria andEndBusinessHoursEqualTo(Long value) {
            addCriterion("end_business_hours =", value, "endBusinessHours");
            return (Criteria) this;
        }

        public Criteria andEndBusinessHoursNotEqualTo(Long value) {
            addCriterion("end_business_hours <>", value, "endBusinessHours");
            return (Criteria) this;
        }

        public Criteria andEndBusinessHoursGreaterThan(Long value) {
            addCriterion("end_business_hours >", value, "endBusinessHours");
            return (Criteria) this;
        }

        public Criteria andEndBusinessHoursGreaterThanOrEqualTo(Long value) {
            addCriterion("end_business_hours >=", value, "endBusinessHours");
            return (Criteria) this;
        }

        public Criteria andEndBusinessHoursLessThan(Long value) {
            addCriterion("end_business_hours <", value, "endBusinessHours");
            return (Criteria) this;
        }

        public Criteria andEndBusinessHoursLessThanOrEqualTo(Long value) {
            addCriterion("end_business_hours <=", value, "endBusinessHours");
            return (Criteria) this;
        }

        public Criteria andEndBusinessHoursIn(List<Long> values) {
            addCriterion("end_business_hours in", values, "endBusinessHours");
            return (Criteria) this;
        }

        public Criteria andEndBusinessHoursNotIn(List<Long> values) {
            addCriterion("end_business_hours not in", values, "endBusinessHours");
            return (Criteria) this;
        }

        public Criteria andEndBusinessHoursBetween(Long value1, Long value2) {
            addCriterion("end_business_hours between", value1, value2, "endBusinessHours");
            return (Criteria) this;
        }

        public Criteria andEndBusinessHoursNotBetween(Long value1, Long value2) {
            addCriterion("end_business_hours not between", value1, value2, "endBusinessHours");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNumberIsNull() {
            addCriterion("parking_space_number is null");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNumberIsNotNull() {
            addCriterion("parking_space_number is not null");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNumberEqualTo(Integer value) {
            addCriterion("parking_space_number =", value, "parkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNumberNotEqualTo(Integer value) {
            addCriterion("parking_space_number <>", value, "parkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNumberGreaterThan(Integer value) {
            addCriterion("parking_space_number >", value, "parkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("parking_space_number >=", value, "parkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNumberLessThan(Integer value) {
            addCriterion("parking_space_number <", value, "parkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNumberLessThanOrEqualTo(Integer value) {
            addCriterion("parking_space_number <=", value, "parkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNumberIn(List<Integer> values) {
            addCriterion("parking_space_number in", values, "parkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNumberNotIn(List<Integer> values) {
            addCriterion("parking_space_number not in", values, "parkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNumberBetween(Integer value1, Integer value2) {
            addCriterion("parking_space_number between", value1, value2, "parkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("parking_space_number not between", value1, value2, "parkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andUsedParkingSpaceNumberIsNull() {
            addCriterion("used_parking_space_number is null");
            return (Criteria) this;
        }

        public Criteria andUsedParkingSpaceNumberIsNotNull() {
            addCriterion("used_parking_space_number is not null");
            return (Criteria) this;
        }

        public Criteria andUsedParkingSpaceNumberEqualTo(Integer value) {
            addCriterion("used_parking_space_number =", value, "usedParkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andUsedParkingSpaceNumberNotEqualTo(Integer value) {
            addCriterion("used_parking_space_number <>", value, "usedParkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andUsedParkingSpaceNumberGreaterThan(Integer value) {
            addCriterion("used_parking_space_number >", value, "usedParkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andUsedParkingSpaceNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("used_parking_space_number >=", value, "usedParkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andUsedParkingSpaceNumberLessThan(Integer value) {
            addCriterion("used_parking_space_number <", value, "usedParkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andUsedParkingSpaceNumberLessThanOrEqualTo(Integer value) {
            addCriterion("used_parking_space_number <=", value, "usedParkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andUsedParkingSpaceNumberIn(List<Integer> values) {
            addCriterion("used_parking_space_number in", values, "usedParkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andUsedParkingSpaceNumberNotIn(List<Integer> values) {
            addCriterion("used_parking_space_number not in", values, "usedParkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andUsedParkingSpaceNumberBetween(Integer value1, Integer value2) {
            addCriterion("used_parking_space_number between", value1, value2, "usedParkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andUsedParkingSpaceNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("used_parking_space_number not between", value1, value2, "usedParkingSpaceNumber");
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

        public Criteria andLandlineIsNull() {
            addCriterion("landline is null");
            return (Criteria) this;
        }

        public Criteria andLandlineIsNotNull() {
            addCriterion("landline is not null");
            return (Criteria) this;
        }

        public Criteria andLandlineEqualTo(String value) {
            addCriterion("landline =", value, "landline");
            return (Criteria) this;
        }

        public Criteria andLandlineNotEqualTo(String value) {
            addCriterion("landline <>", value, "landline");
            return (Criteria) this;
        }

        public Criteria andLandlineGreaterThan(String value) {
            addCriterion("landline >", value, "landline");
            return (Criteria) this;
        }

        public Criteria andLandlineGreaterThanOrEqualTo(String value) {
            addCriterion("landline >=", value, "landline");
            return (Criteria) this;
        }

        public Criteria andLandlineLessThan(String value) {
            addCriterion("landline <", value, "landline");
            return (Criteria) this;
        }

        public Criteria andLandlineLessThanOrEqualTo(String value) {
            addCriterion("landline <=", value, "landline");
            return (Criteria) this;
        }

        public Criteria andLandlineLike(String value) {
            addCriterion("landline like", value, "landline");
            return (Criteria) this;
        }

        public Criteria andLandlineNotLike(String value) {
            addCriterion("landline not like", value, "landline");
            return (Criteria) this;
        }

        public Criteria andLandlineIn(List<String> values) {
            addCriterion("landline in", values, "landline");
            return (Criteria) this;
        }

        public Criteria andLandlineNotIn(List<String> values) {
            addCriterion("landline not in", values, "landline");
            return (Criteria) this;
        }

        public Criteria andLandlineBetween(String value1, String value2) {
            addCriterion("landline between", value1, value2, "landline");
            return (Criteria) this;
        }

        public Criteria andLandlineNotBetween(String value1, String value2) {
            addCriterion("landline not between", value1, value2, "landline");
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

        public Criteria andCountryIdIsNull() {
            addCriterion("country_id is null");
            return (Criteria) this;
        }

        public Criteria andCountryIdIsNotNull() {
            addCriterion("country_id is not null");
            return (Criteria) this;
        }

        public Criteria andCountryIdEqualTo(String value) {
            addCriterion("country_id =", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdNotEqualTo(String value) {
            addCriterion("country_id <>", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdGreaterThan(String value) {
            addCriterion("country_id >", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdGreaterThanOrEqualTo(String value) {
            addCriterion("country_id >=", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdLessThan(String value) {
            addCriterion("country_id <", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdLessThanOrEqualTo(String value) {
            addCriterion("country_id <=", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdLike(String value) {
            addCriterion("country_id like", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdNotLike(String value) {
            addCriterion("country_id not like", value, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdIn(List<String> values) {
            addCriterion("country_id in", values, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdNotIn(List<String> values) {
            addCriterion("country_id not in", values, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdBetween(String value1, String value2) {
            addCriterion("country_id between", value1, value2, "countryId");
            return (Criteria) this;
        }

        public Criteria andCountryIdNotBetween(String value1, String value2) {
            addCriterion("country_id not between", value1, value2, "countryId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIsNull() {
            addCriterion("province_id is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIsNotNull() {
            addCriterion("province_id is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdEqualTo(String value) {
            addCriterion("province_id =", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotEqualTo(String value) {
            addCriterion("province_id <>", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThan(String value) {
            addCriterion("province_id >", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThanOrEqualTo(String value) {
            addCriterion("province_id >=", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThan(String value) {
            addCriterion("province_id <", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThanOrEqualTo(String value) {
            addCriterion("province_id <=", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLike(String value) {
            addCriterion("province_id like", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotLike(String value) {
            addCriterion("province_id not like", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIn(List<String> values) {
            addCriterion("province_id in", values, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotIn(List<String> values) {
            addCriterion("province_id not in", values, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdBetween(String value1, String value2) {
            addCriterion("province_id between", value1, value2, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotBetween(String value1, String value2) {
            addCriterion("province_id not between", value1, value2, "provinceId");
            return (Criteria) this;
        }

        public Criteria andStateOrCityIdIsNull() {
            addCriterion("state_or_city_id is null");
            return (Criteria) this;
        }

        public Criteria andStateOrCityIdIsNotNull() {
            addCriterion("state_or_city_id is not null");
            return (Criteria) this;
        }

        public Criteria andStateOrCityIdEqualTo(String value) {
            addCriterion("state_or_city_id =", value, "stateOrCityId");
            return (Criteria) this;
        }

        public Criteria andStateOrCityIdNotEqualTo(String value) {
            addCriterion("state_or_city_id <>", value, "stateOrCityId");
            return (Criteria) this;
        }

        public Criteria andStateOrCityIdGreaterThan(String value) {
            addCriterion("state_or_city_id >", value, "stateOrCityId");
            return (Criteria) this;
        }

        public Criteria andStateOrCityIdGreaterThanOrEqualTo(String value) {
            addCriterion("state_or_city_id >=", value, "stateOrCityId");
            return (Criteria) this;
        }

        public Criteria andStateOrCityIdLessThan(String value) {
            addCriterion("state_or_city_id <", value, "stateOrCityId");
            return (Criteria) this;
        }

        public Criteria andStateOrCityIdLessThanOrEqualTo(String value) {
            addCriterion("state_or_city_id <=", value, "stateOrCityId");
            return (Criteria) this;
        }

        public Criteria andStateOrCityIdLike(String value) {
            addCriterion("state_or_city_id like", value, "stateOrCityId");
            return (Criteria) this;
        }

        public Criteria andStateOrCityIdNotLike(String value) {
            addCriterion("state_or_city_id not like", value, "stateOrCityId");
            return (Criteria) this;
        }

        public Criteria andStateOrCityIdIn(List<String> values) {
            addCriterion("state_or_city_id in", values, "stateOrCityId");
            return (Criteria) this;
        }

        public Criteria andStateOrCityIdNotIn(List<String> values) {
            addCriterion("state_or_city_id not in", values, "stateOrCityId");
            return (Criteria) this;
        }

        public Criteria andStateOrCityIdBetween(String value1, String value2) {
            addCriterion("state_or_city_id between", value1, value2, "stateOrCityId");
            return (Criteria) this;
        }

        public Criteria andStateOrCityIdNotBetween(String value1, String value2) {
            addCriterion("state_or_city_id not between", value1, value2, "stateOrCityId");
            return (Criteria) this;
        }

        public Criteria andZoneOrCountyIdIsNull() {
            addCriterion("zone_or_county_id is null");
            return (Criteria) this;
        }

        public Criteria andZoneOrCountyIdIsNotNull() {
            addCriterion("zone_or_county_id is not null");
            return (Criteria) this;
        }

        public Criteria andZoneOrCountyIdEqualTo(String value) {
            addCriterion("zone_or_county_id =", value, "zoneOrCountyId");
            return (Criteria) this;
        }

        public Criteria andZoneOrCountyIdNotEqualTo(String value) {
            addCriterion("zone_or_county_id <>", value, "zoneOrCountyId");
            return (Criteria) this;
        }

        public Criteria andZoneOrCountyIdGreaterThan(String value) {
            addCriterion("zone_or_county_id >", value, "zoneOrCountyId");
            return (Criteria) this;
        }

        public Criteria andZoneOrCountyIdGreaterThanOrEqualTo(String value) {
            addCriterion("zone_or_county_id >=", value, "zoneOrCountyId");
            return (Criteria) this;
        }

        public Criteria andZoneOrCountyIdLessThan(String value) {
            addCriterion("zone_or_county_id <", value, "zoneOrCountyId");
            return (Criteria) this;
        }

        public Criteria andZoneOrCountyIdLessThanOrEqualTo(String value) {
            addCriterion("zone_or_county_id <=", value, "zoneOrCountyId");
            return (Criteria) this;
        }

        public Criteria andZoneOrCountyIdLike(String value) {
            addCriterion("zone_or_county_id like", value, "zoneOrCountyId");
            return (Criteria) this;
        }

        public Criteria andZoneOrCountyIdNotLike(String value) {
            addCriterion("zone_or_county_id not like", value, "zoneOrCountyId");
            return (Criteria) this;
        }

        public Criteria andZoneOrCountyIdIn(List<String> values) {
            addCriterion("zone_or_county_id in", values, "zoneOrCountyId");
            return (Criteria) this;
        }

        public Criteria andZoneOrCountyIdNotIn(List<String> values) {
            addCriterion("zone_or_county_id not in", values, "zoneOrCountyId");
            return (Criteria) this;
        }

        public Criteria andZoneOrCountyIdBetween(String value1, String value2) {
            addCriterion("zone_or_county_id between", value1, value2, "zoneOrCountyId");
            return (Criteria) this;
        }

        public Criteria andZoneOrCountyIdNotBetween(String value1, String value2) {
            addCriterion("zone_or_county_id not between", value1, value2, "zoneOrCountyId");
            return (Criteria) this;
        }

        public Criteria andTownshipIdIsNull() {
            addCriterion("township_id is null");
            return (Criteria) this;
        }

        public Criteria andTownshipIdIsNotNull() {
            addCriterion("township_id is not null");
            return (Criteria) this;
        }

        public Criteria andTownshipIdEqualTo(String value) {
            addCriterion("township_id =", value, "townshipId");
            return (Criteria) this;
        }

        public Criteria andTownshipIdNotEqualTo(String value) {
            addCriterion("township_id <>", value, "townshipId");
            return (Criteria) this;
        }

        public Criteria andTownshipIdGreaterThan(String value) {
            addCriterion("township_id >", value, "townshipId");
            return (Criteria) this;
        }

        public Criteria andTownshipIdGreaterThanOrEqualTo(String value) {
            addCriterion("township_id >=", value, "townshipId");
            return (Criteria) this;
        }

        public Criteria andTownshipIdLessThan(String value) {
            addCriterion("township_id <", value, "townshipId");
            return (Criteria) this;
        }

        public Criteria andTownshipIdLessThanOrEqualTo(String value) {
            addCriterion("township_id <=", value, "townshipId");
            return (Criteria) this;
        }

        public Criteria andTownshipIdLike(String value) {
            addCriterion("township_id like", value, "townshipId");
            return (Criteria) this;
        }

        public Criteria andTownshipIdNotLike(String value) {
            addCriterion("township_id not like", value, "townshipId");
            return (Criteria) this;
        }

        public Criteria andTownshipIdIn(List<String> values) {
            addCriterion("township_id in", values, "townshipId");
            return (Criteria) this;
        }

        public Criteria andTownshipIdNotIn(List<String> values) {
            addCriterion("township_id not in", values, "townshipId");
            return (Criteria) this;
        }

        public Criteria andTownshipIdBetween(String value1, String value2) {
            addCriterion("township_id between", value1, value2, "townshipId");
            return (Criteria) this;
        }

        public Criteria andTownshipIdNotBetween(String value1, String value2) {
            addCriterion("township_id not between", value1, value2, "townshipId");
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