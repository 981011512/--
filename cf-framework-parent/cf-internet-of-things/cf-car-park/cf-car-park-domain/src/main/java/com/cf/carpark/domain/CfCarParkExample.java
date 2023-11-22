package com.cf.carpark.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CfCarParkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected boolean distance;

    public boolean isDistance() {
        return distance;
    }

    public void setDistance(boolean distance) {
        this.distance = distance;
    }

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

        public Criteria andFreeTimeIsNull() {
            addCriterion("free_time is null");
            return (Criteria) this;
        }

        public Criteria andFreeTimeIsNotNull() {
            addCriterion("free_time is not null");
            return (Criteria) this;
        }

        public Criteria andFreeTimeEqualTo(Long value) {
            addCriterion("free_time =", value, "freeTime");
            return (Criteria) this;
        }

        public Criteria andFreeTimeNotEqualTo(Long value) {
            addCriterion("free_time <>", value, "freeTime");
            return (Criteria) this;
        }

        public Criteria andFreeTimeGreaterThan(Long value) {
            addCriterion("free_time >", value, "freeTime");
            return (Criteria) this;
        }

        public Criteria andFreeTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("free_time >=", value, "freeTime");
            return (Criteria) this;
        }

        public Criteria andFreeTimeLessThan(Long value) {
            addCriterion("free_time <", value, "freeTime");
            return (Criteria) this;
        }

        public Criteria andFreeTimeLessThanOrEqualTo(Long value) {
            addCriterion("free_time <=", value, "freeTime");
            return (Criteria) this;
        }

        public Criteria andFreeTimeIn(List<Long> values) {
            addCriterion("free_time in", values, "freeTime");
            return (Criteria) this;
        }

        public Criteria andFreeTimeNotIn(List<Long> values) {
            addCriterion("free_time not in", values, "freeTime");
            return (Criteria) this;
        }

        public Criteria andFreeTimeBetween(Long value1, Long value2) {
            addCriterion("free_time between", value1, value2, "freeTime");
            return (Criteria) this;
        }

        public Criteria andFreeTimeNotBetween(Long value1, Long value2) {
            addCriterion("free_time not between", value1, value2, "freeTime");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(BigDecimal value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(BigDecimal value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(BigDecimal value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(BigDecimal value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<BigDecimal> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<BigDecimal> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andNumberOfCommentsIsNull() {
            addCriterion("number_of_comments is null");
            return (Criteria) this;
        }

        public Criteria andNumberOfCommentsIsNotNull() {
            addCriterion("number_of_comments is not null");
            return (Criteria) this;
        }

        public Criteria andNumberOfCommentsEqualTo(Integer value) {
            addCriterion("number_of_comments =", value, "numberOfComments");
            return (Criteria) this;
        }

        public Criteria andNumberOfCommentsNotEqualTo(Integer value) {
            addCriterion("number_of_comments <>", value, "numberOfComments");
            return (Criteria) this;
        }

        public Criteria andNumberOfCommentsGreaterThan(Integer value) {
            addCriterion("number_of_comments >", value, "numberOfComments");
            return (Criteria) this;
        }

        public Criteria andNumberOfCommentsGreaterThanOrEqualTo(Integer value) {
            addCriterion("number_of_comments >=", value, "numberOfComments");
            return (Criteria) this;
        }

        public Criteria andNumberOfCommentsLessThan(Integer value) {
            addCriterion("number_of_comments <", value, "numberOfComments");
            return (Criteria) this;
        }

        public Criteria andNumberOfCommentsLessThanOrEqualTo(Integer value) {
            addCriterion("number_of_comments <=", value, "numberOfComments");
            return (Criteria) this;
        }

        public Criteria andNumberOfCommentsIn(List<Integer> values) {
            addCriterion("number_of_comments in", values, "numberOfComments");
            return (Criteria) this;
        }

        public Criteria andNumberOfCommentsNotIn(List<Integer> values) {
            addCriterion("number_of_comments not in", values, "numberOfComments");
            return (Criteria) this;
        }

        public Criteria andNumberOfCommentsBetween(Integer value1, Integer value2) {
            addCriterion("number_of_comments between", value1, value2, "numberOfComments");
            return (Criteria) this;
        }

        public Criteria andNumberOfCommentsNotBetween(Integer value1, Integer value2) {
            addCriterion("number_of_comments not between", value1, value2, "numberOfComments");
            return (Criteria) this;
        }

        public Criteria andFeeUpperLimitIsNull() {
            addCriterion("fee_upper_limit is null");
            return (Criteria) this;
        }

        public Criteria andFeeUpperLimitIsNotNull() {
            addCriterion("fee_upper_limit is not null");
            return (Criteria) this;
        }

        public Criteria andFeeUpperLimitEqualTo(BigDecimal value) {
            addCriterion("fee_upper_limit =", value, "feeUpperLimit");
            return (Criteria) this;
        }

        public Criteria andFeeUpperLimitNotEqualTo(BigDecimal value) {
            addCriterion("fee_upper_limit <>", value, "feeUpperLimit");
            return (Criteria) this;
        }

        public Criteria andFeeUpperLimitGreaterThan(BigDecimal value) {
            addCriterion("fee_upper_limit >", value, "feeUpperLimit");
            return (Criteria) this;
        }

        public Criteria andFeeUpperLimitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fee_upper_limit >=", value, "feeUpperLimit");
            return (Criteria) this;
        }

        public Criteria andFeeUpperLimitLessThan(BigDecimal value) {
            addCriterion("fee_upper_limit <", value, "feeUpperLimit");
            return (Criteria) this;
        }

        public Criteria andFeeUpperLimitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fee_upper_limit <=", value, "feeUpperLimit");
            return (Criteria) this;
        }

        public Criteria andFeeUpperLimitIn(List<BigDecimal> values) {
            addCriterion("fee_upper_limit in", values, "feeUpperLimit");
            return (Criteria) this;
        }

        public Criteria andFeeUpperLimitNotIn(List<BigDecimal> values) {
            addCriterion("fee_upper_limit not in", values, "feeUpperLimit");
            return (Criteria) this;
        }

        public Criteria andFeeUpperLimitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fee_upper_limit between", value1, value2, "feeUpperLimit");
            return (Criteria) this;
        }

        public Criteria andFeeUpperLimitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fee_upper_limit not between", value1, value2, "feeUpperLimit");
            return (Criteria) this;
        }

        public Criteria andStartingPriceIsNull() {
            addCriterion("starting_price is null");
            return (Criteria) this;
        }

        public Criteria andStartingPriceIsNotNull() {
            addCriterion("starting_price is not null");
            return (Criteria) this;
        }

        public Criteria andStartingPriceEqualTo(BigDecimal value) {
            addCriterion("starting_price =", value, "startingPrice");
            return (Criteria) this;
        }

        public Criteria andStartingPriceNotEqualTo(BigDecimal value) {
            addCriterion("starting_price <>", value, "startingPrice");
            return (Criteria) this;
        }

        public Criteria andStartingPriceGreaterThan(BigDecimal value) {
            addCriterion("starting_price >", value, "startingPrice");
            return (Criteria) this;
        }

        public Criteria andStartingPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("starting_price >=", value, "startingPrice");
            return (Criteria) this;
        }

        public Criteria andStartingPriceLessThan(BigDecimal value) {
            addCriterion("starting_price <", value, "startingPrice");
            return (Criteria) this;
        }

        public Criteria andStartingPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("starting_price <=", value, "startingPrice");
            return (Criteria) this;
        }

        public Criteria andStartingPriceIn(List<BigDecimal> values) {
            addCriterion("starting_price in", values, "startingPrice");
            return (Criteria) this;
        }

        public Criteria andStartingPriceNotIn(List<BigDecimal> values) {
            addCriterion("starting_price not in", values, "startingPrice");
            return (Criteria) this;
        }

        public Criteria andStartingPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("starting_price between", value1, value2, "startingPrice");
            return (Criteria) this;
        }

        public Criteria andStartingPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("starting_price not between", value1, value2, "startingPrice");
            return (Criteria) this;
        }

        public Criteria andUnitDurationIsNull() {
            addCriterion("unit_duration is null");
            return (Criteria) this;
        }

        public Criteria andUnitDurationIsNotNull() {
            addCriterion("unit_duration is not null");
            return (Criteria) this;
        }

        public Criteria andUnitDurationEqualTo(Long value) {
            addCriterion("unit_duration =", value, "unitDuration");
            return (Criteria) this;
        }

        public Criteria andUnitDurationNotEqualTo(Long value) {
            addCriterion("unit_duration <>", value, "unitDuration");
            return (Criteria) this;
        }

        public Criteria andUnitDurationGreaterThan(Long value) {
            addCriterion("unit_duration >", value, "unitDuration");
            return (Criteria) this;
        }

        public Criteria andUnitDurationGreaterThanOrEqualTo(Long value) {
            addCriterion("unit_duration >=", value, "unitDuration");
            return (Criteria) this;
        }

        public Criteria andUnitDurationLessThan(Long value) {
            addCriterion("unit_duration <", value, "unitDuration");
            return (Criteria) this;
        }

        public Criteria andUnitDurationLessThanOrEqualTo(Long value) {
            addCriterion("unit_duration <=", value, "unitDuration");
            return (Criteria) this;
        }

        public Criteria andUnitDurationIn(List<Long> values) {
            addCriterion("unit_duration in", values, "unitDuration");
            return (Criteria) this;
        }

        public Criteria andUnitDurationNotIn(List<Long> values) {
            addCriterion("unit_duration not in", values, "unitDuration");
            return (Criteria) this;
        }

        public Criteria andUnitDurationBetween(Long value1, Long value2) {
            addCriterion("unit_duration between", value1, value2, "unitDuration");
            return (Criteria) this;
        }

        public Criteria andUnitDurationNotBetween(Long value1, Long value2) {
            addCriterion("unit_duration not between", value1, value2, "unitDuration");
            return (Criteria) this;
        }

        public Criteria andBillingModelIsNull() {
            addCriterion("billing_model is null");
            return (Criteria) this;
        }

        public Criteria andBillingModelIsNotNull() {
            addCriterion("billing_model is not null");
            return (Criteria) this;
        }

        public Criteria andBillingModelEqualTo(String value) {
            addCriterion("billing_model =", value, "billingModel");
            return (Criteria) this;
        }

        public Criteria andBillingModelNotEqualTo(String value) {
            addCriterion("billing_model <>", value, "billingModel");
            return (Criteria) this;
        }

        public Criteria andBillingModelGreaterThan(String value) {
            addCriterion("billing_model >", value, "billingModel");
            return (Criteria) this;
        }

        public Criteria andBillingModelGreaterThanOrEqualTo(String value) {
            addCriterion("billing_model >=", value, "billingModel");
            return (Criteria) this;
        }

        public Criteria andBillingModelLessThan(String value) {
            addCriterion("billing_model <", value, "billingModel");
            return (Criteria) this;
        }

        public Criteria andBillingModelLessThanOrEqualTo(String value) {
            addCriterion("billing_model <=", value, "billingModel");
            return (Criteria) this;
        }

        public Criteria andBillingModelLike(String value) {
            addCriterion("billing_model like", value, "billingModel");
            return (Criteria) this;
        }

        public Criteria andBillingModelNotLike(String value) {
            addCriterion("billing_model not like", value, "billingModel");
            return (Criteria) this;
        }

        public Criteria andBillingModelIn(List<String> values) {
            addCriterion("billing_model in", values, "billingModel");
            return (Criteria) this;
        }

        public Criteria andBillingModelNotIn(List<String> values) {
            addCriterion("billing_model not in", values, "billingModel");
            return (Criteria) this;
        }

        public Criteria andBillingModelBetween(String value1, String value2) {
            addCriterion("billing_model between", value1, value2, "billingModel");
            return (Criteria) this;
        }

        public Criteria andBillingModelNotBetween(String value1, String value2) {
            addCriterion("billing_model not between", value1, value2, "billingModel");
            return (Criteria) this;
        }

        public Criteria andMinAdvanceSubscribeTimeIsNull() {
            addCriterion("min_advance_subscribe_time is null");
            return (Criteria) this;
        }

        public Criteria andMinAdvanceSubscribeTimeIsNotNull() {
            addCriterion("min_advance_subscribe_time is not null");
            return (Criteria) this;
        }

        public Criteria andMinAdvanceSubscribeTimeEqualTo(Long value) {
            addCriterion("min_advance_subscribe_time =", value, "minAdvanceSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andMinAdvanceSubscribeTimeNotEqualTo(Long value) {
            addCriterion("min_advance_subscribe_time <>", value, "minAdvanceSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andMinAdvanceSubscribeTimeGreaterThan(Long value) {
            addCriterion("min_advance_subscribe_time >", value, "minAdvanceSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andMinAdvanceSubscribeTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("min_advance_subscribe_time >=", value, "minAdvanceSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andMinAdvanceSubscribeTimeLessThan(Long value) {
            addCriterion("min_advance_subscribe_time <", value, "minAdvanceSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andMinAdvanceSubscribeTimeLessThanOrEqualTo(Long value) {
            addCriterion("min_advance_subscribe_time <=", value, "minAdvanceSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andMinAdvanceSubscribeTimeIn(List<Long> values) {
            addCriterion("min_advance_subscribe_time in", values, "minAdvanceSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andMinAdvanceSubscribeTimeNotIn(List<Long> values) {
            addCriterion("min_advance_subscribe_time not in", values, "minAdvanceSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andMinAdvanceSubscribeTimeBetween(Long value1, Long value2) {
            addCriterion("min_advance_subscribe_time between", value1, value2, "minAdvanceSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andMinAdvanceSubscribeTimeNotBetween(Long value1, Long value2) {
            addCriterion("min_advance_subscribe_time not between", value1, value2, "minAdvanceSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andMaxAdvanceSubscribeTimeIsNull() {
            addCriterion("max_advance_subscribe_time is null");
            return (Criteria) this;
        }

        public Criteria andMaxAdvanceSubscribeTimeIsNotNull() {
            addCriterion("max_advance_subscribe_time is not null");
            return (Criteria) this;
        }

        public Criteria andMaxAdvanceSubscribeTimeEqualTo(Long value) {
            addCriterion("max_advance_subscribe_time =", value, "maxAdvanceSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andMaxAdvanceSubscribeTimeNotEqualTo(Long value) {
            addCriterion("max_advance_subscribe_time <>", value, "maxAdvanceSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andMaxAdvanceSubscribeTimeGreaterThan(Long value) {
            addCriterion("max_advance_subscribe_time >", value, "maxAdvanceSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andMaxAdvanceSubscribeTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("max_advance_subscribe_time >=", value, "maxAdvanceSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andMaxAdvanceSubscribeTimeLessThan(Long value) {
            addCriterion("max_advance_subscribe_time <", value, "maxAdvanceSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andMaxAdvanceSubscribeTimeLessThanOrEqualTo(Long value) {
            addCriterion("max_advance_subscribe_time <=", value, "maxAdvanceSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andMaxAdvanceSubscribeTimeIn(List<Long> values) {
            addCriterion("max_advance_subscribe_time in", values, "maxAdvanceSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andMaxAdvanceSubscribeTimeNotIn(List<Long> values) {
            addCriterion("max_advance_subscribe_time not in", values, "maxAdvanceSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andMaxAdvanceSubscribeTimeBetween(Long value1, Long value2) {
            addCriterion("max_advance_subscribe_time between", value1, value2, "maxAdvanceSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andMaxAdvanceSubscribeTimeNotBetween(Long value1, Long value2) {
            addCriterion("max_advance_subscribe_time not between", value1, value2, "maxAdvanceSubscribeTime");
            return (Criteria) this;
        }

        public Criteria andSubscribeFreeTimeIsNull() {
            addCriterion("subscribe_free_time is null");
            return (Criteria) this;
        }

        public Criteria andSubscribeFreeTimeIsNotNull() {
            addCriterion("subscribe_free_time is not null");
            return (Criteria) this;
        }

        public Criteria andSubscribeFreeTimeEqualTo(Long value) {
            addCriterion("subscribe_free_time =", value, "subscribeFreeTime");
            return (Criteria) this;
        }

        public Criteria andSubscribeFreeTimeNotEqualTo(Long value) {
            addCriterion("subscribe_free_time <>", value, "subscribeFreeTime");
            return (Criteria) this;
        }

        public Criteria andSubscribeFreeTimeGreaterThan(Long value) {
            addCriterion("subscribe_free_time >", value, "subscribeFreeTime");
            return (Criteria) this;
        }

        public Criteria andSubscribeFreeTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("subscribe_free_time >=", value, "subscribeFreeTime");
            return (Criteria) this;
        }

        public Criteria andSubscribeFreeTimeLessThan(Long value) {
            addCriterion("subscribe_free_time <", value, "subscribeFreeTime");
            return (Criteria) this;
        }

        public Criteria andSubscribeFreeTimeLessThanOrEqualTo(Long value) {
            addCriterion("subscribe_free_time <=", value, "subscribeFreeTime");
            return (Criteria) this;
        }

        public Criteria andSubscribeFreeTimeIn(List<Long> values) {
            addCriterion("subscribe_free_time in", values, "subscribeFreeTime");
            return (Criteria) this;
        }

        public Criteria andSubscribeFreeTimeNotIn(List<Long> values) {
            addCriterion("subscribe_free_time not in", values, "subscribeFreeTime");
            return (Criteria) this;
        }

        public Criteria andSubscribeFreeTimeBetween(Long value1, Long value2) {
            addCriterion("subscribe_free_time between", value1, value2, "subscribeFreeTime");
            return (Criteria) this;
        }

        public Criteria andSubscribeFreeTimeNotBetween(Long value1, Long value2) {
            addCriterion("subscribe_free_time not between", value1, value2, "subscribeFreeTime");
            return (Criteria) this;
        }

        public Criteria andSubscribeFeeIsNull() {
            addCriterion("subscribe_fee is null");
            return (Criteria) this;
        }

        public Criteria andSubscribeFeeIsNotNull() {
            addCriterion("subscribe_fee is not null");
            return (Criteria) this;
        }

        public Criteria andSubscribeFeeEqualTo(BigDecimal value) {
            addCriterion("subscribe_fee =", value, "subscribeFee");
            return (Criteria) this;
        }

        public Criteria andSubscribeFeeNotEqualTo(BigDecimal value) {
            addCriterion("subscribe_fee <>", value, "subscribeFee");
            return (Criteria) this;
        }

        public Criteria andSubscribeFeeGreaterThan(BigDecimal value) {
            addCriterion("subscribe_fee >", value, "subscribeFee");
            return (Criteria) this;
        }

        public Criteria andSubscribeFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("subscribe_fee >=", value, "subscribeFee");
            return (Criteria) this;
        }

        public Criteria andSubscribeFeeLessThan(BigDecimal value) {
            addCriterion("subscribe_fee <", value, "subscribeFee");
            return (Criteria) this;
        }

        public Criteria andSubscribeFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("subscribe_fee <=", value, "subscribeFee");
            return (Criteria) this;
        }

        public Criteria andSubscribeFeeIn(List<BigDecimal> values) {
            addCriterion("subscribe_fee in", values, "subscribeFee");
            return (Criteria) this;
        }

        public Criteria andSubscribeFeeNotIn(List<BigDecimal> values) {
            addCriterion("subscribe_fee not in", values, "subscribeFee");
            return (Criteria) this;
        }

        public Criteria andSubscribeFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("subscribe_fee between", value1, value2, "subscribeFee");
            return (Criteria) this;
        }

        public Criteria andSubscribeFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("subscribe_fee not between", value1, value2, "subscribeFee");
            return (Criteria) this;
        }

        public Criteria andSubscribeTimeoutFeeIsNull() {
            addCriterion("subscribe_timeout_fee is null");
            return (Criteria) this;
        }

        public Criteria andSubscribeTimeoutFeeIsNotNull() {
            addCriterion("subscribe_timeout_fee is not null");
            return (Criteria) this;
        }

        public Criteria andSubscribeTimeoutFeeEqualTo(Byte value) {
            addCriterion("subscribe_timeout_fee =", value, "subscribeTimeoutFee");
            return (Criteria) this;
        }

        public Criteria andSubscribeTimeoutFeeNotEqualTo(Byte value) {
            addCriterion("subscribe_timeout_fee <>", value, "subscribeTimeoutFee");
            return (Criteria) this;
        }

        public Criteria andSubscribeTimeoutFeeGreaterThan(Byte value) {
            addCriterion("subscribe_timeout_fee >", value, "subscribeTimeoutFee");
            return (Criteria) this;
        }

        public Criteria andSubscribeTimeoutFeeGreaterThanOrEqualTo(Byte value) {
            addCriterion("subscribe_timeout_fee >=", value, "subscribeTimeoutFee");
            return (Criteria) this;
        }

        public Criteria andSubscribeTimeoutFeeLessThan(Byte value) {
            addCriterion("subscribe_timeout_fee <", value, "subscribeTimeoutFee");
            return (Criteria) this;
        }

        public Criteria andSubscribeTimeoutFeeLessThanOrEqualTo(Byte value) {
            addCriterion("subscribe_timeout_fee <=", value, "subscribeTimeoutFee");
            return (Criteria) this;
        }

        public Criteria andSubscribeTimeoutFeeIn(List<Byte> values) {
            addCriterion("subscribe_timeout_fee in", values, "subscribeTimeoutFee");
            return (Criteria) this;
        }

        public Criteria andSubscribeTimeoutFeeNotIn(List<Byte> values) {
            addCriterion("subscribe_timeout_fee not in", values, "subscribeTimeoutFee");
            return (Criteria) this;
        }

        public Criteria andSubscribeTimeoutFeeBetween(Byte value1, Byte value2) {
            addCriterion("subscribe_timeout_fee between", value1, value2, "subscribeTimeoutFee");
            return (Criteria) this;
        }

        public Criteria andSubscribeTimeoutFeeNotBetween(Byte value1, Byte value2) {
            addCriterion("subscribe_timeout_fee not between", value1, value2, "subscribeTimeoutFee");
            return (Criteria) this;
        }

        public Criteria andCreaterIdIsNull() {
            addCriterion("creater_id is null");
            return (Criteria) this;
        }

        public Criteria andCreaterIdIsNotNull() {
            addCriterion("creater_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterIdEqualTo(String value) {
            addCriterion("creater_id =", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdNotEqualTo(String value) {
            addCriterion("creater_id <>", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdGreaterThan(String value) {
            addCriterion("creater_id >", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdGreaterThanOrEqualTo(String value) {
            addCriterion("creater_id >=", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdLessThan(String value) {
            addCriterion("creater_id <", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdLessThanOrEqualTo(String value) {
            addCriterion("creater_id <=", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdLike(String value) {
            addCriterion("creater_id like", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdNotLike(String value) {
            addCriterion("creater_id not like", value, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdIn(List<String> values) {
            addCriterion("creater_id in", values, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdNotIn(List<String> values) {
            addCriterion("creater_id not in", values, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdBetween(String value1, String value2) {
            addCriterion("creater_id between", value1, value2, "createrId");
            return (Criteria) this;
        }

        public Criteria andCreaterIdNotBetween(String value1, String value2) {
            addCriterion("creater_id not between", value1, value2, "createrId");
            return (Criteria) this;
        }

        public Criteria andSpecialFeeExpiredCarIsNull() {
            addCriterion("special_fee_expired_car is null");
            return (Criteria) this;
        }

        public Criteria andSpecialFeeExpiredCarIsNotNull() {
            addCriterion("special_fee_expired_car is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialFeeExpiredCarEqualTo(Byte value) {
            addCriterion("special_fee_expired_car =", value, "specialFeeExpiredCar");
            return (Criteria) this;
        }

        public Criteria andSpecialFeeExpiredCarNotEqualTo(Byte value) {
            addCriterion("special_fee_expired_car <>", value, "specialFeeExpiredCar");
            return (Criteria) this;
        }

        public Criteria andSpecialFeeExpiredCarGreaterThan(Byte value) {
            addCriterion("special_fee_expired_car >", value, "specialFeeExpiredCar");
            return (Criteria) this;
        }

        public Criteria andSpecialFeeExpiredCarGreaterThanOrEqualTo(Byte value) {
            addCriterion("special_fee_expired_car >=", value, "specialFeeExpiredCar");
            return (Criteria) this;
        }

        public Criteria andSpecialFeeExpiredCarLessThan(Byte value) {
            addCriterion("special_fee_expired_car <", value, "specialFeeExpiredCar");
            return (Criteria) this;
        }

        public Criteria andSpecialFeeExpiredCarLessThanOrEqualTo(Byte value) {
            addCriterion("special_fee_expired_car <=", value, "specialFeeExpiredCar");
            return (Criteria) this;
        }

        public Criteria andSpecialFeeExpiredCarIn(List<Byte> values) {
            addCriterion("special_fee_expired_car in", values, "specialFeeExpiredCar");
            return (Criteria) this;
        }

        public Criteria andSpecialFeeExpiredCarNotIn(List<Byte> values) {
            addCriterion("special_fee_expired_car not in", values, "specialFeeExpiredCar");
            return (Criteria) this;
        }

        public Criteria andSpecialFeeExpiredCarBetween(Byte value1, Byte value2) {
            addCriterion("special_fee_expired_car between", value1, value2, "specialFeeExpiredCar");
            return (Criteria) this;
        }

        public Criteria andSpecialFeeExpiredCarNotBetween(Byte value1, Byte value2) {
            addCriterion("special_fee_expired_car not between", value1, value2, "specialFeeExpiredCar");
            return (Criteria) this;
        }

        public Criteria andShowExpiredCarTypeIsNull() {
            addCriterion("show_expired_car_type is null");
            return (Criteria) this;
        }

        public Criteria andShowExpiredCarTypeIsNotNull() {
            addCriterion("show_expired_car_type is not null");
            return (Criteria) this;
        }

        public Criteria andShowExpiredCarTypeEqualTo(Byte value) {
            addCriterion("show_expired_car_type =", value, "showExpiredCarType");
            return (Criteria) this;
        }

        public Criteria andShowExpiredCarTypeNotEqualTo(Byte value) {
            addCriterion("show_expired_car_type <>", value, "showExpiredCarType");
            return (Criteria) this;
        }

        public Criteria andShowExpiredCarTypeGreaterThan(Byte value) {
            addCriterion("show_expired_car_type >", value, "showExpiredCarType");
            return (Criteria) this;
        }

        public Criteria andShowExpiredCarTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("show_expired_car_type >=", value, "showExpiredCarType");
            return (Criteria) this;
        }

        public Criteria andShowExpiredCarTypeLessThan(Byte value) {
            addCriterion("show_expired_car_type <", value, "showExpiredCarType");
            return (Criteria) this;
        }

        public Criteria andShowExpiredCarTypeLessThanOrEqualTo(Byte value) {
            addCriterion("show_expired_car_type <=", value, "showExpiredCarType");
            return (Criteria) this;
        }

        public Criteria andShowExpiredCarTypeIn(List<Byte> values) {
            addCriterion("show_expired_car_type in", values, "showExpiredCarType");
            return (Criteria) this;
        }

        public Criteria andShowExpiredCarTypeNotIn(List<Byte> values) {
            addCriterion("show_expired_car_type not in", values, "showExpiredCarType");
            return (Criteria) this;
        }

        public Criteria andShowExpiredCarTypeBetween(Byte value1, Byte value2) {
            addCriterion("show_expired_car_type between", value1, value2, "showExpiredCarType");
            return (Criteria) this;
        }

        public Criteria andShowExpiredCarTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("show_expired_car_type not between", value1, value2, "showExpiredCarType");
            return (Criteria) this;
        }

        public Criteria andExpiredCarFreeTimeIsNull() {
            addCriterion("expired_car_free_time is null");
            return (Criteria) this;
        }

        public Criteria andExpiredCarFreeTimeIsNotNull() {
            addCriterion("expired_car_free_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpiredCarFreeTimeEqualTo(Long value) {
            addCriterion("expired_car_free_time =", value, "expiredCarFreeTime");
            return (Criteria) this;
        }

        public Criteria andExpiredCarFreeTimeNotEqualTo(Long value) {
            addCriterion("expired_car_free_time <>", value, "expiredCarFreeTime");
            return (Criteria) this;
        }

        public Criteria andExpiredCarFreeTimeGreaterThan(Long value) {
            addCriterion("expired_car_free_time >", value, "expiredCarFreeTime");
            return (Criteria) this;
        }

        public Criteria andExpiredCarFreeTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("expired_car_free_time >=", value, "expiredCarFreeTime");
            return (Criteria) this;
        }

        public Criteria andExpiredCarFreeTimeLessThan(Long value) {
            addCriterion("expired_car_free_time <", value, "expiredCarFreeTime");
            return (Criteria) this;
        }

        public Criteria andExpiredCarFreeTimeLessThanOrEqualTo(Long value) {
            addCriterion("expired_car_free_time <=", value, "expiredCarFreeTime");
            return (Criteria) this;
        }

        public Criteria andExpiredCarFreeTimeIn(List<Long> values) {
            addCriterion("expired_car_free_time in", values, "expiredCarFreeTime");
            return (Criteria) this;
        }

        public Criteria andExpiredCarFreeTimeNotIn(List<Long> values) {
            addCriterion("expired_car_free_time not in", values, "expiredCarFreeTime");
            return (Criteria) this;
        }

        public Criteria andExpiredCarFreeTimeBetween(Long value1, Long value2) {
            addCriterion("expired_car_free_time between", value1, value2, "expiredCarFreeTime");
            return (Criteria) this;
        }

        public Criteria andExpiredCarFreeTimeNotBetween(Long value1, Long value2) {
            addCriterion("expired_car_free_time not between", value1, value2, "expiredCarFreeTime");
            return (Criteria) this;
        }

        public Criteria andShowRemarksIsNull() {
            addCriterion("show_remarks is null");
            return (Criteria) this;
        }

        public Criteria andShowRemarksIsNotNull() {
            addCriterion("show_remarks is not null");
            return (Criteria) this;
        }

        public Criteria andShowRemarksEqualTo(Byte value) {
            addCriterion("show_remarks =", value, "showRemarks");
            return (Criteria) this;
        }

        public Criteria andShowRemarksNotEqualTo(Byte value) {
            addCriterion("show_remarks <>", value, "showRemarks");
            return (Criteria) this;
        }

        public Criteria andShowRemarksGreaterThan(Byte value) {
            addCriterion("show_remarks >", value, "showRemarks");
            return (Criteria) this;
        }

        public Criteria andShowRemarksGreaterThanOrEqualTo(Byte value) {
            addCriterion("show_remarks >=", value, "showRemarks");
            return (Criteria) this;
        }

        public Criteria andShowRemarksLessThan(Byte value) {
            addCriterion("show_remarks <", value, "showRemarks");
            return (Criteria) this;
        }

        public Criteria andShowRemarksLessThanOrEqualTo(Byte value) {
            addCriterion("show_remarks <=", value, "showRemarks");
            return (Criteria) this;
        }

        public Criteria andShowRemarksIn(List<Byte> values) {
            addCriterion("show_remarks in", values, "showRemarks");
            return (Criteria) this;
        }

        public Criteria andShowRemarksNotIn(List<Byte> values) {
            addCriterion("show_remarks not in", values, "showRemarks");
            return (Criteria) this;
        }

        public Criteria andShowRemarksBetween(Byte value1, Byte value2) {
            addCriterion("show_remarks between", value1, value2, "showRemarks");
            return (Criteria) this;
        }

        public Criteria andShowRemarksNotBetween(Byte value1, Byte value2) {
            addCriterion("show_remarks not between", value1, value2, "showRemarks");
            return (Criteria) this;
        }

        public Criteria andCollectionCarparkIdIsNull() {
            addCriterion("collection_carpark_id is null");
            return (Criteria) this;
        }

        public Criteria andCollectionCarparkIdIsNotNull() {
            addCriterion("collection_carpark_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionCarparkIdEqualTo(String value) {
            addCriterion("collection_carpark_id =", value, "collectionCarparkId");
            return (Criteria) this;
        }

        public Criteria andCollectionCarparkIdNotEqualTo(String value) {
            addCriterion("collection_carpark_id <>", value, "collectionCarparkId");
            return (Criteria) this;
        }

        public Criteria andCollectionCarparkIdGreaterThan(String value) {
            addCriterion("collection_carpark_id >", value, "collectionCarparkId");
            return (Criteria) this;
        }

        public Criteria andCollectionCarparkIdGreaterThanOrEqualTo(String value) {
            addCriterion("collection_carpark_id >=", value, "collectionCarparkId");
            return (Criteria) this;
        }

        public Criteria andCollectionCarparkIdLessThan(String value) {
            addCriterion("collection_carpark_id <", value, "collectionCarparkId");
            return (Criteria) this;
        }

        public Criteria andCollectionCarparkIdLessThanOrEqualTo(String value) {
            addCriterion("collection_carpark_id <=", value, "collectionCarparkId");
            return (Criteria) this;
        }

        public Criteria andCollectionCarparkIdLike(String value) {
            addCriterion("collection_carpark_id like", value, "collectionCarparkId");
            return (Criteria) this;
        }

        public Criteria andCollectionCarparkIdNotLike(String value) {
            addCriterion("collection_carpark_id not like", value, "collectionCarparkId");
            return (Criteria) this;
        }

        public Criteria andCollectionCarparkIdIn(List<String> values) {
            addCriterion("collection_carpark_id in", values, "collectionCarparkId");
            return (Criteria) this;
        }

        public Criteria andCollectionCarparkIdNotIn(List<String> values) {
            addCriterion("collection_carpark_id not in", values, "collectionCarparkId");
            return (Criteria) this;
        }

        public Criteria andCollectionCarparkIdBetween(String value1, String value2) {
            addCriterion("collection_carpark_id between", value1, value2, "collectionCarparkId");
            return (Criteria) this;
        }

        public Criteria andCollectionCarparkIdNotBetween(String value1, String value2) {
            addCriterion("collection_carpark_id not between", value1, value2, "collectionCarparkId");
            return (Criteria) this;
        }

        public Criteria andLimitParkingSpaceNumberIsNull() {
            addCriterion("limit_parking_space_number is null");
            return (Criteria) this;
        }

        public Criteria andLimitParkingSpaceNumberIsNotNull() {
            addCriterion("limit_parking_space_number is not null");
            return (Criteria) this;
        }

        public Criteria andLimitParkingSpaceNumberEqualTo(Byte value) {
            addCriterion("limit_parking_space_number =", value, "limitParkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andLimitParkingSpaceNumberNotEqualTo(Byte value) {
            addCriterion("limit_parking_space_number <>", value, "limitParkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andLimitParkingSpaceNumberGreaterThan(Byte value) {
            addCriterion("limit_parking_space_number >", value, "limitParkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andLimitParkingSpaceNumberGreaterThanOrEqualTo(Byte value) {
            addCriterion("limit_parking_space_number >=", value, "limitParkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andLimitParkingSpaceNumberLessThan(Byte value) {
            addCriterion("limit_parking_space_number <", value, "limitParkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andLimitParkingSpaceNumberLessThanOrEqualTo(Byte value) {
            addCriterion("limit_parking_space_number <=", value, "limitParkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andLimitParkingSpaceNumberIn(List<Byte> values) {
            addCriterion("limit_parking_space_number in", values, "limitParkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andLimitParkingSpaceNumberNotIn(List<Byte> values) {
            addCriterion("limit_parking_space_number not in", values, "limitParkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andLimitParkingSpaceNumberBetween(Byte value1, Byte value2) {
            addCriterion("limit_parking_space_number between", value1, value2, "limitParkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andLimitParkingSpaceNumberNotBetween(Byte value1, Byte value2) {
            addCriterion("limit_parking_space_number not between", value1, value2, "limitParkingSpaceNumber");
            return (Criteria) this;
        }

        public Criteria andAllowEditUseLogIsNull() {
            addCriterion("allow_edit_use_log is null");
            return (Criteria) this;
        }

        public Criteria andAllowEditUseLogIsNotNull() {
            addCriterion("allow_edit_use_log is not null");
            return (Criteria) this;
        }

        public Criteria andAllowEditUseLogEqualTo(Byte value) {
            addCriterion("allow_edit_use_log =", value, "allowEditUseLog");
            return (Criteria) this;
        }

        public Criteria andAllowEditUseLogNotEqualTo(Byte value) {
            addCriterion("allow_edit_use_log <>", value, "allowEditUseLog");
            return (Criteria) this;
        }

        public Criteria andAllowEditUseLogGreaterThan(Byte value) {
            addCriterion("allow_edit_use_log >", value, "allowEditUseLog");
            return (Criteria) this;
        }

        public Criteria andAllowEditUseLogGreaterThanOrEqualTo(Byte value) {
            addCriterion("allow_edit_use_log >=", value, "allowEditUseLog");
            return (Criteria) this;
        }

        public Criteria andAllowEditUseLogLessThan(Byte value) {
            addCriterion("allow_edit_use_log <", value, "allowEditUseLog");
            return (Criteria) this;
        }

        public Criteria andAllowEditUseLogLessThanOrEqualTo(Byte value) {
            addCriterion("allow_edit_use_log <=", value, "allowEditUseLog");
            return (Criteria) this;
        }

        public Criteria andAllowEditUseLogIn(List<Byte> values) {
            addCriterion("allow_edit_use_log in", values, "allowEditUseLog");
            return (Criteria) this;
        }

        public Criteria andAllowEditUseLogNotIn(List<Byte> values) {
            addCriterion("allow_edit_use_log not in", values, "allowEditUseLog");
            return (Criteria) this;
        }

        public Criteria andAllowEditUseLogBetween(Byte value1, Byte value2) {
            addCriterion("allow_edit_use_log between", value1, value2, "allowEditUseLog");
            return (Criteria) this;
        }

        public Criteria andAllowEditUseLogNotBetween(Byte value1, Byte value2) {
            addCriterion("allow_edit_use_log not between", value1, value2, "allowEditUseLog");
            return (Criteria) this;
        }

        public Criteria andAbnormalAutoReleaseIsNull() {
            addCriterion("abnormal_auto_release is null");
            return (Criteria) this;
        }

        public Criteria andAbnormalAutoReleaseIsNotNull() {
            addCriterion("abnormal_auto_release is not null");
            return (Criteria) this;
        }

        public Criteria andAbnormalAutoReleaseEqualTo(Byte value) {
            addCriterion("abnormal_auto_release =", value, "abnormalAutoRelease");
            return (Criteria) this;
        }

        public Criteria andAbnormalAutoReleaseNotEqualTo(Byte value) {
            addCriterion("abnormal_auto_release <>", value, "abnormalAutoRelease");
            return (Criteria) this;
        }

        public Criteria andAbnormalAutoReleaseGreaterThan(Byte value) {
            addCriterion("abnormal_auto_release >", value, "abnormalAutoRelease");
            return (Criteria) this;
        }

        public Criteria andAbnormalAutoReleaseGreaterThanOrEqualTo(Byte value) {
            addCriterion("abnormal_auto_release >=", value, "abnormalAutoRelease");
            return (Criteria) this;
        }

        public Criteria andAbnormalAutoReleaseLessThan(Byte value) {
            addCriterion("abnormal_auto_release <", value, "abnormalAutoRelease");
            return (Criteria) this;
        }

        public Criteria andAbnormalAutoReleaseLessThanOrEqualTo(Byte value) {
            addCriterion("abnormal_auto_release <=", value, "abnormalAutoRelease");
            return (Criteria) this;
        }

        public Criteria andAbnormalAutoReleaseIn(List<Byte> values) {
            addCriterion("abnormal_auto_release in", values, "abnormalAutoRelease");
            return (Criteria) this;
        }

        public Criteria andAbnormalAutoReleaseNotIn(List<Byte> values) {
            addCriterion("abnormal_auto_release not in", values, "abnormalAutoRelease");
            return (Criteria) this;
        }

        public Criteria andAbnormalAutoReleaseBetween(Byte value1, Byte value2) {
            addCriterion("abnormal_auto_release between", value1, value2, "abnormalAutoRelease");
            return (Criteria) this;
        }

        public Criteria andAbnormalAutoReleaseNotBetween(Byte value1, Byte value2) {
            addCriterion("abnormal_auto_release not between", value1, value2, "abnormalAutoRelease");
            return (Criteria) this;
        }

        public Criteria andAutoIssuedWhitelistIsNull() {
            addCriterion("auto_issued_whitelist is null");
            return (Criteria) this;
        }

        public Criteria andAutoIssuedWhitelistIsNotNull() {
            addCriterion("auto_issued_whitelist is not null");
            return (Criteria) this;
        }

        public Criteria andAutoIssuedWhitelistEqualTo(Byte value) {
            addCriterion("auto_issued_whitelist =", value, "autoIssuedWhitelist");
            return (Criteria) this;
        }

        public Criteria andAutoIssuedWhitelistNotEqualTo(Byte value) {
            addCriterion("auto_issued_whitelist <>", value, "autoIssuedWhitelist");
            return (Criteria) this;
        }

        public Criteria andAutoIssuedWhitelistGreaterThan(Byte value) {
            addCriterion("auto_issued_whitelist >", value, "autoIssuedWhitelist");
            return (Criteria) this;
        }

        public Criteria andAutoIssuedWhitelistGreaterThanOrEqualTo(Byte value) {
            addCriterion("auto_issued_whitelist >=", value, "autoIssuedWhitelist");
            return (Criteria) this;
        }

        public Criteria andAutoIssuedWhitelistLessThan(Byte value) {
            addCriterion("auto_issued_whitelist <", value, "autoIssuedWhitelist");
            return (Criteria) this;
        }

        public Criteria andAutoIssuedWhitelistLessThanOrEqualTo(Byte value) {
            addCriterion("auto_issued_whitelist <=", value, "autoIssuedWhitelist");
            return (Criteria) this;
        }

        public Criteria andAutoIssuedWhitelistIn(List<Byte> values) {
            addCriterion("auto_issued_whitelist in", values, "autoIssuedWhitelist");
            return (Criteria) this;
        }

        public Criteria andAutoIssuedWhitelistNotIn(List<Byte> values) {
            addCriterion("auto_issued_whitelist not in", values, "autoIssuedWhitelist");
            return (Criteria) this;
        }

        public Criteria andAutoIssuedWhitelistBetween(Byte value1, Byte value2) {
            addCriterion("auto_issued_whitelist between", value1, value2, "autoIssuedWhitelist");
            return (Criteria) this;
        }

        public Criteria andAutoIssuedWhitelistNotBetween(Byte value1, Byte value2) {
            addCriterion("auto_issued_whitelist not between", value1, value2, "autoIssuedWhitelist");
            return (Criteria) this;
        }

        public Criteria andAdminerIsNull() {
            addCriterion("adminer is null");
            return (Criteria) this;
        }

        public Criteria andAdminerIsNotNull() {
            addCriterion("adminer is not null");
            return (Criteria) this;
        }

        public Criteria andAdminerEqualTo(String value) {
            addCriterion("adminer =", value, "adminer");
            return (Criteria) this;
        }

        public Criteria andAdminerNotEqualTo(String value) {
            addCriterion("adminer <>", value, "adminer");
            return (Criteria) this;
        }

        public Criteria andAdminerGreaterThan(String value) {
            addCriterion("adminer >", value, "adminer");
            return (Criteria) this;
        }

        public Criteria andAdminerGreaterThanOrEqualTo(String value) {
            addCriterion("adminer >=", value, "adminer");
            return (Criteria) this;
        }

        public Criteria andAdminerLessThan(String value) {
            addCriterion("adminer <", value, "adminer");
            return (Criteria) this;
        }

        public Criteria andAdminerLessThanOrEqualTo(String value) {
            addCriterion("adminer <=", value, "adminer");
            return (Criteria) this;
        }

        public Criteria andAdminerLike(String value) {
            addCriterion("adminer like", value, "adminer");
            return (Criteria) this;
        }

        public Criteria andAdminerNotLike(String value) {
            addCriterion("adminer not like", value, "adminer");
            return (Criteria) this;
        }

        public Criteria andAdminerIn(List<String> values) {
            addCriterion("adminer in", values, "adminer");
            return (Criteria) this;
        }

        public Criteria andAdminerNotIn(List<String> values) {
            addCriterion("adminer not in", values, "adminer");
            return (Criteria) this;
        }

        public Criteria andAdminerBetween(String value1, String value2) {
            addCriterion("adminer between", value1, value2, "adminer");
            return (Criteria) this;
        }

        public Criteria andAdminerNotBetween(String value1, String value2) {
            addCriterion("adminer not between", value1, value2, "adminer");
            return (Criteria) this;
        }

        public Criteria andForbidGroupFlagSameTimeInIsNull() {
            addCriterion("forbid_group_flag_same_time_in is null");
            return (Criteria) this;
        }

        public Criteria andForbidGroupFlagSameTimeInIsNotNull() {
            addCriterion("forbid_group_flag_same_time_in is not null");
            return (Criteria) this;
        }

        public Criteria andForbidGroupFlagSameTimeInEqualTo(Byte value) {
            addCriterion("forbid_group_flag_same_time_in =", value, "forbidGroupFlagSameTimeIn");
            return (Criteria) this;
        }

        public Criteria andForbidGroupFlagSameTimeInNotEqualTo(Byte value) {
            addCriterion("forbid_group_flag_same_time_in <>", value, "forbidGroupFlagSameTimeIn");
            return (Criteria) this;
        }

        public Criteria andForbidGroupFlagSameTimeInGreaterThan(Byte value) {
            addCriterion("forbid_group_flag_same_time_in >", value, "forbidGroupFlagSameTimeIn");
            return (Criteria) this;
        }

        public Criteria andForbidGroupFlagSameTimeInGreaterThanOrEqualTo(Byte value) {
            addCriterion("forbid_group_flag_same_time_in >=", value, "forbidGroupFlagSameTimeIn");
            return (Criteria) this;
        }

        public Criteria andForbidGroupFlagSameTimeInLessThan(Byte value) {
            addCriterion("forbid_group_flag_same_time_in <", value, "forbidGroupFlagSameTimeIn");
            return (Criteria) this;
        }

        public Criteria andForbidGroupFlagSameTimeInLessThanOrEqualTo(Byte value) {
            addCriterion("forbid_group_flag_same_time_in <=", value, "forbidGroupFlagSameTimeIn");
            return (Criteria) this;
        }

        public Criteria andForbidGroupFlagSameTimeInIn(List<Byte> values) {
            addCriterion("forbid_group_flag_same_time_in in", values, "forbidGroupFlagSameTimeIn");
            return (Criteria) this;
        }

        public Criteria andForbidGroupFlagSameTimeInNotIn(List<Byte> values) {
            addCriterion("forbid_group_flag_same_time_in not in", values, "forbidGroupFlagSameTimeIn");
            return (Criteria) this;
        }

        public Criteria andForbidGroupFlagSameTimeInBetween(Byte value1, Byte value2) {
            addCriterion("forbid_group_flag_same_time_in between", value1, value2, "forbidGroupFlagSameTimeIn");
            return (Criteria) this;
        }

        public Criteria andForbidGroupFlagSameTimeInNotBetween(Byte value1, Byte value2) {
            addCriterion("forbid_group_flag_same_time_in not between", value1, value2, "forbidGroupFlagSameTimeIn");
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

        public Criteria andDataReportPlatformIsNull() {
            addCriterion("data_report_platform is null");
            return (Criteria) this;
        }

        public Criteria andDataReportPlatformIsNotNull() {
            addCriterion("data_report_platform is not null");
            return (Criteria) this;
        }

        public Criteria andDataReportPlatformEqualTo(String value) {
            addCriterion("data_report_platform =", value, "dataReportPlatform");
            return (Criteria) this;
        }

        public Criteria andDataReportPlatformNotEqualTo(String value) {
            addCriterion("data_report_platform <>", value, "dataReportPlatform");
            return (Criteria) this;
        }

        public Criteria andDataReportPlatformGreaterThan(String value) {
            addCriterion("data_report_platform >", value, "dataReportPlatform");
            return (Criteria) this;
        }

        public Criteria andDataReportPlatformGreaterThanOrEqualTo(String value) {
            addCriterion("data_report_platform >=", value, "dataReportPlatform");
            return (Criteria) this;
        }

        public Criteria andDataReportPlatformLessThan(String value) {
            addCriterion("data_report_platform <", value, "dataReportPlatform");
            return (Criteria) this;
        }

        public Criteria andDataReportPlatformLessThanOrEqualTo(String value) {
            addCriterion("data_report_platform <=", value, "dataReportPlatform");
            return (Criteria) this;
        }

        public Criteria andDataReportPlatformLike(String value) {
            addCriterion("data_report_platform like", value, "dataReportPlatform");
            return (Criteria) this;
        }

        public Criteria andDataReportPlatformNotLike(String value) {
            addCriterion("data_report_platform not like", value, "dataReportPlatform");
            return (Criteria) this;
        }

        public Criteria andDataReportPlatformIn(List<String> values) {
            addCriterion("data_report_platform in", values, "dataReportPlatform");
            return (Criteria) this;
        }

        public Criteria andDataReportPlatformNotIn(List<String> values) {
            addCriterion("data_report_platform not in", values, "dataReportPlatform");
            return (Criteria) this;
        }

        public Criteria andDataReportPlatformBetween(String value1, String value2) {
            addCriterion("data_report_platform between", value1, value2, "dataReportPlatform");
            return (Criteria) this;
        }

        public Criteria andDataReportPlatformNotBetween(String value1, String value2) {
            addCriterion("data_report_platform not between", value1, value2, "dataReportPlatform");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLimitIsNull() {
            addCriterion("leave_time_limit is null");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLimitIsNotNull() {
            addCriterion("leave_time_limit is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLimitEqualTo(Long value) {
            addCriterion("leave_time_limit =", value, "leaveTimeLimit");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLimitNotEqualTo(Long value) {
            addCriterion("leave_time_limit <>", value, "leaveTimeLimit");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLimitGreaterThan(Long value) {
            addCriterion("leave_time_limit >", value, "leaveTimeLimit");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLimitGreaterThanOrEqualTo(Long value) {
            addCriterion("leave_time_limit >=", value, "leaveTimeLimit");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLimitLessThan(Long value) {
            addCriterion("leave_time_limit <", value, "leaveTimeLimit");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLimitLessThanOrEqualTo(Long value) {
            addCriterion("leave_time_limit <=", value, "leaveTimeLimit");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLimitIn(List<Long> values) {
            addCriterion("leave_time_limit in", values, "leaveTimeLimit");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLimitNotIn(List<Long> values) {
            addCriterion("leave_time_limit not in", values, "leaveTimeLimit");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLimitBetween(Long value1, Long value2) {
            addCriterion("leave_time_limit between", value1, value2, "leaveTimeLimit");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLimitNotBetween(Long value1, Long value2) {
            addCriterion("leave_time_limit not between", value1, value2, "leaveTimeLimit");
            return (Criteria) this;
        }

        public Criteria andSpecialNumberPlateIsNull() {
            addCriterion("special_number_plate is null");
            return (Criteria) this;
        }

        public Criteria andSpecialNumberPlateIsNotNull() {
            addCriterion("special_number_plate is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialNumberPlateEqualTo(String value) {
            addCriterion("special_number_plate =", value, "specialNumberPlate");
            return (Criteria) this;
        }

        public Criteria andSpecialNumberPlateNotEqualTo(String value) {
            addCriterion("special_number_plate <>", value, "specialNumberPlate");
            return (Criteria) this;
        }

        public Criteria andSpecialNumberPlateGreaterThan(String value) {
            addCriterion("special_number_plate >", value, "specialNumberPlate");
            return (Criteria) this;
        }

        public Criteria andSpecialNumberPlateGreaterThanOrEqualTo(String value) {
            addCriterion("special_number_plate >=", value, "specialNumberPlate");
            return (Criteria) this;
        }

        public Criteria andSpecialNumberPlateLessThan(String value) {
            addCriterion("special_number_plate <", value, "specialNumberPlate");
            return (Criteria) this;
        }

        public Criteria andSpecialNumberPlateLessThanOrEqualTo(String value) {
            addCriterion("special_number_plate <=", value, "specialNumberPlate");
            return (Criteria) this;
        }

        public Criteria andSpecialNumberPlateLike(String value) {
            addCriterion("special_number_plate like", value, "specialNumberPlate");
            return (Criteria) this;
        }

        public Criteria andSpecialNumberPlateNotLike(String value) {
            addCriterion("special_number_plate not like", value, "specialNumberPlate");
            return (Criteria) this;
        }

        public Criteria andSpecialNumberPlateIn(List<String> values) {
            addCriterion("special_number_plate in", values, "specialNumberPlate");
            return (Criteria) this;
        }

        public Criteria andSpecialNumberPlateNotIn(List<String> values) {
            addCriterion("special_number_plate not in", values, "specialNumberPlate");
            return (Criteria) this;
        }

        public Criteria andSpecialNumberPlateBetween(String value1, String value2) {
            addCriterion("special_number_plate between", value1, value2, "specialNumberPlate");
            return (Criteria) this;
        }

        public Criteria andSpecialNumberPlateNotBetween(String value1, String value2) {
            addCriterion("special_number_plate not between", value1, value2, "specialNumberPlate");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdIsNull() {
            addCriterion("storehouse_id is null");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdIsNotNull() {
            addCriterion("storehouse_id is not null");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdEqualTo(Long value) {
            addCriterion("storehouse_id =", value, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdNotEqualTo(Long value) {
            addCriterion("storehouse_id <>", value, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdGreaterThan(Long value) {
            addCriterion("storehouse_id >", value, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdGreaterThanOrEqualTo(Long value) {
            addCriterion("storehouse_id >=", value, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdLessThan(Long value) {
            addCriterion("storehouse_id <", value, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdLessThanOrEqualTo(Long value) {
            addCriterion("storehouse_id <=", value, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdIn(List<Long> values) {
            addCriterion("storehouse_id in", values, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdNotIn(List<Long> values) {
            addCriterion("storehouse_id not in", values, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdBetween(Long value1, Long value2) {
            addCriterion("storehouse_id between", value1, value2, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdNotBetween(Long value1, Long value2) {
            addCriterion("storehouse_id not between", value1, value2, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andNumberPlateColorToCarTypeIsNull() {
            addCriterion("number_plate_color_to_car_type is null");
            return (Criteria) this;
        }

        public Criteria andNumberPlateColorToCarTypeIsNotNull() {
            addCriterion("number_plate_color_to_car_type is not null");
            return (Criteria) this;
        }

        public Criteria andNumberPlateColorToCarTypeEqualTo(Byte value) {
            addCriterion("number_plate_color_to_car_type =", value, "numberPlateColorToCarType");
            return (Criteria) this;
        }

        public Criteria andNumberPlateColorToCarTypeNotEqualTo(Byte value) {
            addCriterion("number_plate_color_to_car_type <>", value, "numberPlateColorToCarType");
            return (Criteria) this;
        }

        public Criteria andNumberPlateColorToCarTypeGreaterThan(Byte value) {
            addCriterion("number_plate_color_to_car_type >", value, "numberPlateColorToCarType");
            return (Criteria) this;
        }

        public Criteria andNumberPlateColorToCarTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("number_plate_color_to_car_type >=", value, "numberPlateColorToCarType");
            return (Criteria) this;
        }

        public Criteria andNumberPlateColorToCarTypeLessThan(Byte value) {
            addCriterion("number_plate_color_to_car_type <", value, "numberPlateColorToCarType");
            return (Criteria) this;
        }

        public Criteria andNumberPlateColorToCarTypeLessThanOrEqualTo(Byte value) {
            addCriterion("number_plate_color_to_car_type <=", value, "numberPlateColorToCarType");
            return (Criteria) this;
        }

        public Criteria andNumberPlateColorToCarTypeIn(List<Byte> values) {
            addCriterion("number_plate_color_to_car_type in", values, "numberPlateColorToCarType");
            return (Criteria) this;
        }

        public Criteria andNumberPlateColorToCarTypeNotIn(List<Byte> values) {
            addCriterion("number_plate_color_to_car_type not in", values, "numberPlateColorToCarType");
            return (Criteria) this;
        }

        public Criteria andNumberPlateColorToCarTypeBetween(Byte value1, Byte value2) {
            addCriterion("number_plate_color_to_car_type between", value1, value2, "numberPlateColorToCarType");
            return (Criteria) this;
        }

        public Criteria andNumberPlateColorToCarTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("number_plate_color_to_car_type not between", value1, value2, "numberPlateColorToCarType");
            return (Criteria) this;
        }

        public Criteria andPackageGroupFlagFreeTimeChangeIsNull() {
            addCriterion("package_group_flag_free_time_change is null");
            return (Criteria) this;
        }

        public Criteria andPackageGroupFlagFreeTimeChangeIsNotNull() {
            addCriterion("package_group_flag_free_time_change is not null");
            return (Criteria) this;
        }

        public Criteria andPackageGroupFlagFreeTimeChangeEqualTo(Byte value) {
            addCriterion("package_group_flag_free_time_change =", value, "packageGroupFlagFreeTimeChange");
            return (Criteria) this;
        }

        public Criteria andPackageGroupFlagFreeTimeChangeNotEqualTo(Byte value) {
            addCriterion("package_group_flag_free_time_change <>", value, "packageGroupFlagFreeTimeChange");
            return (Criteria) this;
        }

        public Criteria andPackageGroupFlagFreeTimeChangeGreaterThan(Byte value) {
            addCriterion("package_group_flag_free_time_change >", value, "packageGroupFlagFreeTimeChange");
            return (Criteria) this;
        }

        public Criteria andPackageGroupFlagFreeTimeChangeGreaterThanOrEqualTo(Byte value) {
            addCriterion("package_group_flag_free_time_change >=", value, "packageGroupFlagFreeTimeChange");
            return (Criteria) this;
        }

        public Criteria andPackageGroupFlagFreeTimeChangeLessThan(Byte value) {
            addCriterion("package_group_flag_free_time_change <", value, "packageGroupFlagFreeTimeChange");
            return (Criteria) this;
        }

        public Criteria andPackageGroupFlagFreeTimeChangeLessThanOrEqualTo(Byte value) {
            addCriterion("package_group_flag_free_time_change <=", value, "packageGroupFlagFreeTimeChange");
            return (Criteria) this;
        }

        public Criteria andPackageGroupFlagFreeTimeChangeIn(List<Byte> values) {
            addCriterion("package_group_flag_free_time_change in", values, "packageGroupFlagFreeTimeChange");
            return (Criteria) this;
        }

        public Criteria andPackageGroupFlagFreeTimeChangeNotIn(List<Byte> values) {
            addCriterion("package_group_flag_free_time_change not in", values, "packageGroupFlagFreeTimeChange");
            return (Criteria) this;
        }

        public Criteria andPackageGroupFlagFreeTimeChangeBetween(Byte value1, Byte value2) {
            addCriterion("package_group_flag_free_time_change between", value1, value2, "packageGroupFlagFreeTimeChange");
            return (Criteria) this;
        }

        public Criteria andPackageGroupFlagFreeTimeChangeNotBetween(Byte value1, Byte value2) {
            addCriterion("package_group_flag_free_time_change not between", value1, value2, "packageGroupFlagFreeTimeChange");
            return (Criteria) this;
        }

        public Criteria andVisitProcessModeIsNull() {
            addCriterion("visit_process_mode is null");
            return (Criteria) this;
        }

        public Criteria andVisitProcessModeIsNotNull() {
            addCriterion("visit_process_mode is not null");
            return (Criteria) this;
        }

        public Criteria andVisitProcessModeEqualTo(Byte value) {
            addCriterion("visit_process_mode =", value, "visitProcessMode");
            return (Criteria) this;
        }

        public Criteria andVisitProcessModeNotEqualTo(Byte value) {
            addCriterion("visit_process_mode <>", value, "visitProcessMode");
            return (Criteria) this;
        }

        public Criteria andVisitProcessModeGreaterThan(Byte value) {
            addCriterion("visit_process_mode >", value, "visitProcessMode");
            return (Criteria) this;
        }

        public Criteria andVisitProcessModeGreaterThanOrEqualTo(Byte value) {
            addCriterion("visit_process_mode >=", value, "visitProcessMode");
            return (Criteria) this;
        }

        public Criteria andVisitProcessModeLessThan(Byte value) {
            addCriterion("visit_process_mode <", value, "visitProcessMode");
            return (Criteria) this;
        }

        public Criteria andVisitProcessModeLessThanOrEqualTo(Byte value) {
            addCriterion("visit_process_mode <=", value, "visitProcessMode");
            return (Criteria) this;
        }

        public Criteria andVisitProcessModeIn(List<Byte> values) {
            addCriterion("visit_process_mode in", values, "visitProcessMode");
            return (Criteria) this;
        }

        public Criteria andVisitProcessModeNotIn(List<Byte> values) {
            addCriterion("visit_process_mode not in", values, "visitProcessMode");
            return (Criteria) this;
        }

        public Criteria andVisitProcessModeBetween(Byte value1, Byte value2) {
            addCriterion("visit_process_mode between", value1, value2, "visitProcessMode");
            return (Criteria) this;
        }

        public Criteria andVisitProcessModeNotBetween(Byte value1, Byte value2) {
            addCriterion("visit_process_mode not between", value1, value2, "visitProcessMode");
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