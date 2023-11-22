package com.cf.charging.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CfChargingStationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfChargingStationExample() {
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

        public Criteria andStationNameIsNull() {
            addCriterion("station_name is null");
            return (Criteria) this;
        }

        public Criteria andStationNameIsNotNull() {
            addCriterion("station_name is not null");
            return (Criteria) this;
        }

        public Criteria andStationNameEqualTo(String value) {
            addCriterion("station_name =", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotEqualTo(String value) {
            addCriterion("station_name <>", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameGreaterThan(String value) {
            addCriterion("station_name >", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameGreaterThanOrEqualTo(String value) {
            addCriterion("station_name >=", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameLessThan(String value) {
            addCriterion("station_name <", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameLessThanOrEqualTo(String value) {
            addCriterion("station_name <=", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameLike(String value) {
            addCriterion("station_name like", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotLike(String value) {
            addCriterion("station_name not like", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameIn(List<String> values) {
            addCriterion("station_name in", values, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotIn(List<String> values) {
            addCriterion("station_name not in", values, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameBetween(String value1, String value2) {
            addCriterion("station_name between", value1, value2, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotBetween(String value1, String value2) {
            addCriterion("station_name not between", value1, value2, "stationName");
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

        public Criteria andStationTypeIsNull() {
            addCriterion("station_type is null");
            return (Criteria) this;
        }

        public Criteria andStationTypeIsNotNull() {
            addCriterion("station_type is not null");
            return (Criteria) this;
        }

        public Criteria andStationTypeEqualTo(Byte value) {
            addCriterion("station_type =", value, "stationType");
            return (Criteria) this;
        }

        public Criteria andStationTypeNotEqualTo(Byte value) {
            addCriterion("station_type <>", value, "stationType");
            return (Criteria) this;
        }

        public Criteria andStationTypeGreaterThan(Byte value) {
            addCriterion("station_type >", value, "stationType");
            return (Criteria) this;
        }

        public Criteria andStationTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("station_type >=", value, "stationType");
            return (Criteria) this;
        }

        public Criteria andStationTypeLessThan(Byte value) {
            addCriterion("station_type <", value, "stationType");
            return (Criteria) this;
        }

        public Criteria andStationTypeLessThanOrEqualTo(Byte value) {
            addCriterion("station_type <=", value, "stationType");
            return (Criteria) this;
        }

        public Criteria andStationTypeIn(List<Byte> values) {
            addCriterion("station_type in", values, "stationType");
            return (Criteria) this;
        }

        public Criteria andStationTypeNotIn(List<Byte> values) {
            addCriterion("station_type not in", values, "stationType");
            return (Criteria) this;
        }

        public Criteria andStationTypeBetween(Byte value1, Byte value2) {
            addCriterion("station_type between", value1, value2, "stationType");
            return (Criteria) this;
        }

        public Criteria andStationTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("station_type not between", value1, value2, "stationType");
            return (Criteria) this;
        }

        public Criteria andFreeParkTimeIsNull() {
            addCriterion("free_park_time is null");
            return (Criteria) this;
        }

        public Criteria andFreeParkTimeIsNotNull() {
            addCriterion("free_park_time is not null");
            return (Criteria) this;
        }

        public Criteria andFreeParkTimeEqualTo(Long value) {
            addCriterion("free_park_time =", value, "freeParkTime");
            return (Criteria) this;
        }

        public Criteria andFreeParkTimeNotEqualTo(Long value) {
            addCriterion("free_park_time <>", value, "freeParkTime");
            return (Criteria) this;
        }

        public Criteria andFreeParkTimeGreaterThan(Long value) {
            addCriterion("free_park_time >", value, "freeParkTime");
            return (Criteria) this;
        }

        public Criteria andFreeParkTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("free_park_time >=", value, "freeParkTime");
            return (Criteria) this;
        }

        public Criteria andFreeParkTimeLessThan(Long value) {
            addCriterion("free_park_time <", value, "freeParkTime");
            return (Criteria) this;
        }

        public Criteria andFreeParkTimeLessThanOrEqualTo(Long value) {
            addCriterion("free_park_time <=", value, "freeParkTime");
            return (Criteria) this;
        }

        public Criteria andFreeParkTimeIn(List<Long> values) {
            addCriterion("free_park_time in", values, "freeParkTime");
            return (Criteria) this;
        }

        public Criteria andFreeParkTimeNotIn(List<Long> values) {
            addCriterion("free_park_time not in", values, "freeParkTime");
            return (Criteria) this;
        }

        public Criteria andFreeParkTimeBetween(Long value1, Long value2) {
            addCriterion("free_park_time between", value1, value2, "freeParkTime");
            return (Criteria) this;
        }

        public Criteria andFreeParkTimeNotBetween(Long value1, Long value2) {
            addCriterion("free_park_time not between", value1, value2, "freeParkTime");
            return (Criteria) this;
        }

        public Criteria andStartPriceIsNull() {
            addCriterion("start_price is null");
            return (Criteria) this;
        }

        public Criteria andStartPriceIsNotNull() {
            addCriterion("start_price is not null");
            return (Criteria) this;
        }

        public Criteria andStartPriceEqualTo(BigDecimal value) {
            addCriterion("start_price =", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceNotEqualTo(BigDecimal value) {
            addCriterion("start_price <>", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceGreaterThan(BigDecimal value) {
            addCriterion("start_price >", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("start_price >=", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceLessThan(BigDecimal value) {
            addCriterion("start_price <", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("start_price <=", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceIn(List<BigDecimal> values) {
            addCriterion("start_price in", values, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceNotIn(List<BigDecimal> values) {
            addCriterion("start_price not in", values, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("start_price between", value1, value2, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("start_price not between", value1, value2, "startPrice");
            return (Criteria) this;
        }

        public Criteria andHasBathroomIsNull() {
            addCriterion("has_bathroom is null");
            return (Criteria) this;
        }

        public Criteria andHasBathroomIsNotNull() {
            addCriterion("has_bathroom is not null");
            return (Criteria) this;
        }

        public Criteria andHasBathroomEqualTo(Byte value) {
            addCriterion("has_bathroom =", value, "hasBathroom");
            return (Criteria) this;
        }

        public Criteria andHasBathroomNotEqualTo(Byte value) {
            addCriterion("has_bathroom <>", value, "hasBathroom");
            return (Criteria) this;
        }

        public Criteria andHasBathroomGreaterThan(Byte value) {
            addCriterion("has_bathroom >", value, "hasBathroom");
            return (Criteria) this;
        }

        public Criteria andHasBathroomGreaterThanOrEqualTo(Byte value) {
            addCriterion("has_bathroom >=", value, "hasBathroom");
            return (Criteria) this;
        }

        public Criteria andHasBathroomLessThan(Byte value) {
            addCriterion("has_bathroom <", value, "hasBathroom");
            return (Criteria) this;
        }

        public Criteria andHasBathroomLessThanOrEqualTo(Byte value) {
            addCriterion("has_bathroom <=", value, "hasBathroom");
            return (Criteria) this;
        }

        public Criteria andHasBathroomIn(List<Byte> values) {
            addCriterion("has_bathroom in", values, "hasBathroom");
            return (Criteria) this;
        }

        public Criteria andHasBathroomNotIn(List<Byte> values) {
            addCriterion("has_bathroom not in", values, "hasBathroom");
            return (Criteria) this;
        }

        public Criteria andHasBathroomBetween(Byte value1, Byte value2) {
            addCriterion("has_bathroom between", value1, value2, "hasBathroom");
            return (Criteria) this;
        }

        public Criteria andHasBathroomNotBetween(Byte value1, Byte value2) {
            addCriterion("has_bathroom not between", value1, value2, "hasBathroom");
            return (Criteria) this;
        }

        public Criteria andHasLoungeIsNull() {
            addCriterion("has_lounge is null");
            return (Criteria) this;
        }

        public Criteria andHasLoungeIsNotNull() {
            addCriterion("has_lounge is not null");
            return (Criteria) this;
        }

        public Criteria andHasLoungeEqualTo(Byte value) {
            addCriterion("has_lounge =", value, "hasLounge");
            return (Criteria) this;
        }

        public Criteria andHasLoungeNotEqualTo(Byte value) {
            addCriterion("has_lounge <>", value, "hasLounge");
            return (Criteria) this;
        }

        public Criteria andHasLoungeGreaterThan(Byte value) {
            addCriterion("has_lounge >", value, "hasLounge");
            return (Criteria) this;
        }

        public Criteria andHasLoungeGreaterThanOrEqualTo(Byte value) {
            addCriterion("has_lounge >=", value, "hasLounge");
            return (Criteria) this;
        }

        public Criteria andHasLoungeLessThan(Byte value) {
            addCriterion("has_lounge <", value, "hasLounge");
            return (Criteria) this;
        }

        public Criteria andHasLoungeLessThanOrEqualTo(Byte value) {
            addCriterion("has_lounge <=", value, "hasLounge");
            return (Criteria) this;
        }

        public Criteria andHasLoungeIn(List<Byte> values) {
            addCriterion("has_lounge in", values, "hasLounge");
            return (Criteria) this;
        }

        public Criteria andHasLoungeNotIn(List<Byte> values) {
            addCriterion("has_lounge not in", values, "hasLounge");
            return (Criteria) this;
        }

        public Criteria andHasLoungeBetween(Byte value1, Byte value2) {
            addCriterion("has_lounge between", value1, value2, "hasLounge");
            return (Criteria) this;
        }

        public Criteria andHasLoungeNotBetween(Byte value1, Byte value2) {
            addCriterion("has_lounge not between", value1, value2, "hasLounge");
            return (Criteria) this;
        }

        public Criteria andHasDinningRoomIsNull() {
            addCriterion("has_dinning_room is null");
            return (Criteria) this;
        }

        public Criteria andHasDinningRoomIsNotNull() {
            addCriterion("has_dinning_room is not null");
            return (Criteria) this;
        }

        public Criteria andHasDinningRoomEqualTo(Byte value) {
            addCriterion("has_dinning_room =", value, "hasDinningRoom");
            return (Criteria) this;
        }

        public Criteria andHasDinningRoomNotEqualTo(Byte value) {
            addCriterion("has_dinning_room <>", value, "hasDinningRoom");
            return (Criteria) this;
        }

        public Criteria andHasDinningRoomGreaterThan(Byte value) {
            addCriterion("has_dinning_room >", value, "hasDinningRoom");
            return (Criteria) this;
        }

        public Criteria andHasDinningRoomGreaterThanOrEqualTo(Byte value) {
            addCriterion("has_dinning_room >=", value, "hasDinningRoom");
            return (Criteria) this;
        }

        public Criteria andHasDinningRoomLessThan(Byte value) {
            addCriterion("has_dinning_room <", value, "hasDinningRoom");
            return (Criteria) this;
        }

        public Criteria andHasDinningRoomLessThanOrEqualTo(Byte value) {
            addCriterion("has_dinning_room <=", value, "hasDinningRoom");
            return (Criteria) this;
        }

        public Criteria andHasDinningRoomIn(List<Byte> values) {
            addCriterion("has_dinning_room in", values, "hasDinningRoom");
            return (Criteria) this;
        }

        public Criteria andHasDinningRoomNotIn(List<Byte> values) {
            addCriterion("has_dinning_room not in", values, "hasDinningRoom");
            return (Criteria) this;
        }

        public Criteria andHasDinningRoomBetween(Byte value1, Byte value2) {
            addCriterion("has_dinning_room between", value1, value2, "hasDinningRoom");
            return (Criteria) this;
        }

        public Criteria andHasDinningRoomNotBetween(Byte value1, Byte value2) {
            addCriterion("has_dinning_room not between", value1, value2, "hasDinningRoom");
            return (Criteria) this;
        }

        public Criteria andHasShopIsNull() {
            addCriterion("has_shop is null");
            return (Criteria) this;
        }

        public Criteria andHasShopIsNotNull() {
            addCriterion("has_shop is not null");
            return (Criteria) this;
        }

        public Criteria andHasShopEqualTo(Byte value) {
            addCriterion("has_shop =", value, "hasShop");
            return (Criteria) this;
        }

        public Criteria andHasShopNotEqualTo(Byte value) {
            addCriterion("has_shop <>", value, "hasShop");
            return (Criteria) this;
        }

        public Criteria andHasShopGreaterThan(Byte value) {
            addCriterion("has_shop >", value, "hasShop");
            return (Criteria) this;
        }

        public Criteria andHasShopGreaterThanOrEqualTo(Byte value) {
            addCriterion("has_shop >=", value, "hasShop");
            return (Criteria) this;
        }

        public Criteria andHasShopLessThan(Byte value) {
            addCriterion("has_shop <", value, "hasShop");
            return (Criteria) this;
        }

        public Criteria andHasShopLessThanOrEqualTo(Byte value) {
            addCriterion("has_shop <=", value, "hasShop");
            return (Criteria) this;
        }

        public Criteria andHasShopIn(List<Byte> values) {
            addCriterion("has_shop in", values, "hasShop");
            return (Criteria) this;
        }

        public Criteria andHasShopNotIn(List<Byte> values) {
            addCriterion("has_shop not in", values, "hasShop");
            return (Criteria) this;
        }

        public Criteria andHasShopBetween(Byte value1, Byte value2) {
            addCriterion("has_shop between", value1, value2, "hasShop");
            return (Criteria) this;
        }

        public Criteria andHasShopNotBetween(Byte value1, Byte value2) {
            addCriterion("has_shop not between", value1, value2, "hasShop");
            return (Criteria) this;
        }

        public Criteria andSlowChargeNumberIsNull() {
            addCriterion("slow_charge_number is null");
            return (Criteria) this;
        }

        public Criteria andSlowChargeNumberIsNotNull() {
            addCriterion("slow_charge_number is not null");
            return (Criteria) this;
        }

        public Criteria andSlowChargeNumberEqualTo(Byte value) {
            addCriterion("slow_charge_number =", value, "slowChargeNumber");
            return (Criteria) this;
        }

        public Criteria andSlowChargeNumberNotEqualTo(Byte value) {
            addCriterion("slow_charge_number <>", value, "slowChargeNumber");
            return (Criteria) this;
        }

        public Criteria andSlowChargeNumberGreaterThan(Byte value) {
            addCriterion("slow_charge_number >", value, "slowChargeNumber");
            return (Criteria) this;
        }

        public Criteria andSlowChargeNumberGreaterThanOrEqualTo(Byte value) {
            addCriterion("slow_charge_number >=", value, "slowChargeNumber");
            return (Criteria) this;
        }

        public Criteria andSlowChargeNumberLessThan(Byte value) {
            addCriterion("slow_charge_number <", value, "slowChargeNumber");
            return (Criteria) this;
        }

        public Criteria andSlowChargeNumberLessThanOrEqualTo(Byte value) {
            addCriterion("slow_charge_number <=", value, "slowChargeNumber");
            return (Criteria) this;
        }

        public Criteria andSlowChargeNumberIn(List<Byte> values) {
            addCriterion("slow_charge_number in", values, "slowChargeNumber");
            return (Criteria) this;
        }

        public Criteria andSlowChargeNumberNotIn(List<Byte> values) {
            addCriterion("slow_charge_number not in", values, "slowChargeNumber");
            return (Criteria) this;
        }

        public Criteria andSlowChargeNumberBetween(Byte value1, Byte value2) {
            addCriterion("slow_charge_number between", value1, value2, "slowChargeNumber");
            return (Criteria) this;
        }

        public Criteria andSlowChargeNumberNotBetween(Byte value1, Byte value2) {
            addCriterion("slow_charge_number not between", value1, value2, "slowChargeNumber");
            return (Criteria) this;
        }

        public Criteria andFastChargeNumberIsNull() {
            addCriterion("fast_charge_number is null");
            return (Criteria) this;
        }

        public Criteria andFastChargeNumberIsNotNull() {
            addCriterion("fast_charge_number is not null");
            return (Criteria) this;
        }

        public Criteria andFastChargeNumberEqualTo(Byte value) {
            addCriterion("fast_charge_number =", value, "fastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andFastChargeNumberNotEqualTo(Byte value) {
            addCriterion("fast_charge_number <>", value, "fastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andFastChargeNumberGreaterThan(Byte value) {
            addCriterion("fast_charge_number >", value, "fastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andFastChargeNumberGreaterThanOrEqualTo(Byte value) {
            addCriterion("fast_charge_number >=", value, "fastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andFastChargeNumberLessThan(Byte value) {
            addCriterion("fast_charge_number <", value, "fastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andFastChargeNumberLessThanOrEqualTo(Byte value) {
            addCriterion("fast_charge_number <=", value, "fastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andFastChargeNumberIn(List<Byte> values) {
            addCriterion("fast_charge_number in", values, "fastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andFastChargeNumberNotIn(List<Byte> values) {
            addCriterion("fast_charge_number not in", values, "fastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andFastChargeNumberBetween(Byte value1, Byte value2) {
            addCriterion("fast_charge_number between", value1, value2, "fastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andFastChargeNumberNotBetween(Byte value1, Byte value2) {
            addCriterion("fast_charge_number not between", value1, value2, "fastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andSuperFastChargeNumberIsNull() {
            addCriterion("super_fast_charge_number is null");
            return (Criteria) this;
        }

        public Criteria andSuperFastChargeNumberIsNotNull() {
            addCriterion("super_fast_charge_number is not null");
            return (Criteria) this;
        }

        public Criteria andSuperFastChargeNumberEqualTo(Byte value) {
            addCriterion("super_fast_charge_number =", value, "superFastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andSuperFastChargeNumberNotEqualTo(Byte value) {
            addCriterion("super_fast_charge_number <>", value, "superFastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andSuperFastChargeNumberGreaterThan(Byte value) {
            addCriterion("super_fast_charge_number >", value, "superFastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andSuperFastChargeNumberGreaterThanOrEqualTo(Byte value) {
            addCriterion("super_fast_charge_number >=", value, "superFastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andSuperFastChargeNumberLessThan(Byte value) {
            addCriterion("super_fast_charge_number <", value, "superFastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andSuperFastChargeNumberLessThanOrEqualTo(Byte value) {
            addCriterion("super_fast_charge_number <=", value, "superFastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andSuperFastChargeNumberIn(List<Byte> values) {
            addCriterion("super_fast_charge_number in", values, "superFastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andSuperFastChargeNumberNotIn(List<Byte> values) {
            addCriterion("super_fast_charge_number not in", values, "superFastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andSuperFastChargeNumberBetween(Byte value1, Byte value2) {
            addCriterion("super_fast_charge_number between", value1, value2, "superFastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andSuperFastChargeNumberNotBetween(Byte value1, Byte value2) {
            addCriterion("super_fast_charge_number not between", value1, value2, "superFastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andUsedSlowChargeNumberIsNull() {
            addCriterion("used_slow_charge_number is null");
            return (Criteria) this;
        }

        public Criteria andUsedSlowChargeNumberIsNotNull() {
            addCriterion("used_slow_charge_number is not null");
            return (Criteria) this;
        }

        public Criteria andUsedSlowChargeNumberEqualTo(Short value) {
            addCriterion("used_slow_charge_number =", value, "usedSlowChargeNumber");
            return (Criteria) this;
        }

        public Criteria andUsedSlowChargeNumberNotEqualTo(Short value) {
            addCriterion("used_slow_charge_number <>", value, "usedSlowChargeNumber");
            return (Criteria) this;
        }

        public Criteria andUsedSlowChargeNumberGreaterThan(Short value) {
            addCriterion("used_slow_charge_number >", value, "usedSlowChargeNumber");
            return (Criteria) this;
        }

        public Criteria andUsedSlowChargeNumberGreaterThanOrEqualTo(Short value) {
            addCriterion("used_slow_charge_number >=", value, "usedSlowChargeNumber");
            return (Criteria) this;
        }

        public Criteria andUsedSlowChargeNumberLessThan(Short value) {
            addCriterion("used_slow_charge_number <", value, "usedSlowChargeNumber");
            return (Criteria) this;
        }

        public Criteria andUsedSlowChargeNumberLessThanOrEqualTo(Short value) {
            addCriterion("used_slow_charge_number <=", value, "usedSlowChargeNumber");
            return (Criteria) this;
        }

        public Criteria andUsedSlowChargeNumberIn(List<Short> values) {
            addCriterion("used_slow_charge_number in", values, "usedSlowChargeNumber");
            return (Criteria) this;
        }

        public Criteria andUsedSlowChargeNumberNotIn(List<Short> values) {
            addCriterion("used_slow_charge_number not in", values, "usedSlowChargeNumber");
            return (Criteria) this;
        }

        public Criteria andUsedSlowChargeNumberBetween(Short value1, Short value2) {
            addCriterion("used_slow_charge_number between", value1, value2, "usedSlowChargeNumber");
            return (Criteria) this;
        }

        public Criteria andUsedSlowChargeNumberNotBetween(Short value1, Short value2) {
            addCriterion("used_slow_charge_number not between", value1, value2, "usedSlowChargeNumber");
            return (Criteria) this;
        }

        public Criteria andUsedFastChargeNumberIsNull() {
            addCriterion("used_fast_charge_number is null");
            return (Criteria) this;
        }

        public Criteria andUsedFastChargeNumberIsNotNull() {
            addCriterion("used_fast_charge_number is not null");
            return (Criteria) this;
        }

        public Criteria andUsedFastChargeNumberEqualTo(Short value) {
            addCriterion("used_fast_charge_number =", value, "usedFastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andUsedFastChargeNumberNotEqualTo(Short value) {
            addCriterion("used_fast_charge_number <>", value, "usedFastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andUsedFastChargeNumberGreaterThan(Short value) {
            addCriterion("used_fast_charge_number >", value, "usedFastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andUsedFastChargeNumberGreaterThanOrEqualTo(Short value) {
            addCriterion("used_fast_charge_number >=", value, "usedFastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andUsedFastChargeNumberLessThan(Short value) {
            addCriterion("used_fast_charge_number <", value, "usedFastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andUsedFastChargeNumberLessThanOrEqualTo(Short value) {
            addCriterion("used_fast_charge_number <=", value, "usedFastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andUsedFastChargeNumberIn(List<Short> values) {
            addCriterion("used_fast_charge_number in", values, "usedFastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andUsedFastChargeNumberNotIn(List<Short> values) {
            addCriterion("used_fast_charge_number not in", values, "usedFastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andUsedFastChargeNumberBetween(Short value1, Short value2) {
            addCriterion("used_fast_charge_number between", value1, value2, "usedFastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andUsedFastChargeNumberNotBetween(Short value1, Short value2) {
            addCriterion("used_fast_charge_number not between", value1, value2, "usedFastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andUsedSuperFastChargeNumberIsNull() {
            addCriterion("used_super_fast_charge_number is null");
            return (Criteria) this;
        }

        public Criteria andUsedSuperFastChargeNumberIsNotNull() {
            addCriterion("used_super_fast_charge_number is not null");
            return (Criteria) this;
        }

        public Criteria andUsedSuperFastChargeNumberEqualTo(Short value) {
            addCriterion("used_super_fast_charge_number =", value, "usedSuperFastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andUsedSuperFastChargeNumberNotEqualTo(Short value) {
            addCriterion("used_super_fast_charge_number <>", value, "usedSuperFastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andUsedSuperFastChargeNumberGreaterThan(Short value) {
            addCriterion("used_super_fast_charge_number >", value, "usedSuperFastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andUsedSuperFastChargeNumberGreaterThanOrEqualTo(Short value) {
            addCriterion("used_super_fast_charge_number >=", value, "usedSuperFastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andUsedSuperFastChargeNumberLessThan(Short value) {
            addCriterion("used_super_fast_charge_number <", value, "usedSuperFastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andUsedSuperFastChargeNumberLessThanOrEqualTo(Short value) {
            addCriterion("used_super_fast_charge_number <=", value, "usedSuperFastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andUsedSuperFastChargeNumberIn(List<Short> values) {
            addCriterion("used_super_fast_charge_number in", values, "usedSuperFastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andUsedSuperFastChargeNumberNotIn(List<Short> values) {
            addCriterion("used_super_fast_charge_number not in", values, "usedSuperFastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andUsedSuperFastChargeNumberBetween(Short value1, Short value2) {
            addCriterion("used_super_fast_charge_number between", value1, value2, "usedSuperFastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andUsedSuperFastChargeNumberNotBetween(Short value1, Short value2) {
            addCriterion("used_super_fast_charge_number not between", value1, value2, "usedSuperFastChargeNumber");
            return (Criteria) this;
        }

        public Criteria andFloorIsNull() {
            addCriterion("floor is null");
            return (Criteria) this;
        }

        public Criteria andFloorIsNotNull() {
            addCriterion("floor is not null");
            return (Criteria) this;
        }

        public Criteria andFloorEqualTo(Byte value) {
            addCriterion("floor =", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotEqualTo(Byte value) {
            addCriterion("floor <>", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorGreaterThan(Byte value) {
            addCriterion("floor >", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorGreaterThanOrEqualTo(Byte value) {
            addCriterion("floor >=", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLessThan(Byte value) {
            addCriterion("floor <", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLessThanOrEqualTo(Byte value) {
            addCriterion("floor <=", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorIn(List<Byte> values) {
            addCriterion("floor in", values, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotIn(List<Byte> values) {
            addCriterion("floor not in", values, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorBetween(Byte value1, Byte value2) {
            addCriterion("floor between", value1, value2, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotBetween(Byte value1, Byte value2) {
            addCriterion("floor not between", value1, value2, "floor");
            return (Criteria) this;
        }

        public Criteria andIndoorOrOutdoorIsNull() {
            addCriterion("indoor_or_outdoor is null");
            return (Criteria) this;
        }

        public Criteria andIndoorOrOutdoorIsNotNull() {
            addCriterion("indoor_or_outdoor is not null");
            return (Criteria) this;
        }

        public Criteria andIndoorOrOutdoorEqualTo(Byte value) {
            addCriterion("indoor_or_outdoor =", value, "indoorOrOutdoor");
            return (Criteria) this;
        }

        public Criteria andIndoorOrOutdoorNotEqualTo(Byte value) {
            addCriterion("indoor_or_outdoor <>", value, "indoorOrOutdoor");
            return (Criteria) this;
        }

        public Criteria andIndoorOrOutdoorGreaterThan(Byte value) {
            addCriterion("indoor_or_outdoor >", value, "indoorOrOutdoor");
            return (Criteria) this;
        }

        public Criteria andIndoorOrOutdoorGreaterThanOrEqualTo(Byte value) {
            addCriterion("indoor_or_outdoor >=", value, "indoorOrOutdoor");
            return (Criteria) this;
        }

        public Criteria andIndoorOrOutdoorLessThan(Byte value) {
            addCriterion("indoor_or_outdoor <", value, "indoorOrOutdoor");
            return (Criteria) this;
        }

        public Criteria andIndoorOrOutdoorLessThanOrEqualTo(Byte value) {
            addCriterion("indoor_or_outdoor <=", value, "indoorOrOutdoor");
            return (Criteria) this;
        }

        public Criteria andIndoorOrOutdoorIn(List<Byte> values) {
            addCriterion("indoor_or_outdoor in", values, "indoorOrOutdoor");
            return (Criteria) this;
        }

        public Criteria andIndoorOrOutdoorNotIn(List<Byte> values) {
            addCriterion("indoor_or_outdoor not in", values, "indoorOrOutdoor");
            return (Criteria) this;
        }

        public Criteria andIndoorOrOutdoorBetween(Byte value1, Byte value2) {
            addCriterion("indoor_or_outdoor between", value1, value2, "indoorOrOutdoor");
            return (Criteria) this;
        }

        public Criteria andIndoorOrOutdoorNotBetween(Byte value1, Byte value2) {
            addCriterion("indoor_or_outdoor not between", value1, value2, "indoorOrOutdoor");
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

        public Criteria andStartBusinessTimeIsNull() {
            addCriterion("start_business_time is null");
            return (Criteria) this;
        }

        public Criteria andStartBusinessTimeIsNotNull() {
            addCriterion("start_business_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartBusinessTimeEqualTo(Long value) {
            addCriterion("start_business_time =", value, "startBusinessTime");
            return (Criteria) this;
        }

        public Criteria andStartBusinessTimeNotEqualTo(Long value) {
            addCriterion("start_business_time <>", value, "startBusinessTime");
            return (Criteria) this;
        }

        public Criteria andStartBusinessTimeGreaterThan(Long value) {
            addCriterion("start_business_time >", value, "startBusinessTime");
            return (Criteria) this;
        }

        public Criteria andStartBusinessTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("start_business_time >=", value, "startBusinessTime");
            return (Criteria) this;
        }

        public Criteria andStartBusinessTimeLessThan(Long value) {
            addCriterion("start_business_time <", value, "startBusinessTime");
            return (Criteria) this;
        }

        public Criteria andStartBusinessTimeLessThanOrEqualTo(Long value) {
            addCriterion("start_business_time <=", value, "startBusinessTime");
            return (Criteria) this;
        }

        public Criteria andStartBusinessTimeIn(List<Long> values) {
            addCriterion("start_business_time in", values, "startBusinessTime");
            return (Criteria) this;
        }

        public Criteria andStartBusinessTimeNotIn(List<Long> values) {
            addCriterion("start_business_time not in", values, "startBusinessTime");
            return (Criteria) this;
        }

        public Criteria andStartBusinessTimeBetween(Long value1, Long value2) {
            addCriterion("start_business_time between", value1, value2, "startBusinessTime");
            return (Criteria) this;
        }

        public Criteria andStartBusinessTimeNotBetween(Long value1, Long value2) {
            addCriterion("start_business_time not between", value1, value2, "startBusinessTime");
            return (Criteria) this;
        }

        public Criteria andEndBusinessTimeIsNull() {
            addCriterion("end_business_time is null");
            return (Criteria) this;
        }

        public Criteria andEndBusinessTimeIsNotNull() {
            addCriterion("end_business_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndBusinessTimeEqualTo(Long value) {
            addCriterion("end_business_time =", value, "endBusinessTime");
            return (Criteria) this;
        }

        public Criteria andEndBusinessTimeNotEqualTo(Long value) {
            addCriterion("end_business_time <>", value, "endBusinessTime");
            return (Criteria) this;
        }

        public Criteria andEndBusinessTimeGreaterThan(Long value) {
            addCriterion("end_business_time >", value, "endBusinessTime");
            return (Criteria) this;
        }

        public Criteria andEndBusinessTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("end_business_time >=", value, "endBusinessTime");
            return (Criteria) this;
        }

        public Criteria andEndBusinessTimeLessThan(Long value) {
            addCriterion("end_business_time <", value, "endBusinessTime");
            return (Criteria) this;
        }

        public Criteria andEndBusinessTimeLessThanOrEqualTo(Long value) {
            addCriterion("end_business_time <=", value, "endBusinessTime");
            return (Criteria) this;
        }

        public Criteria andEndBusinessTimeIn(List<Long> values) {
            addCriterion("end_business_time in", values, "endBusinessTime");
            return (Criteria) this;
        }

        public Criteria andEndBusinessTimeNotIn(List<Long> values) {
            addCriterion("end_business_time not in", values, "endBusinessTime");
            return (Criteria) this;
        }

        public Criteria andEndBusinessTimeBetween(Long value1, Long value2) {
            addCriterion("end_business_time between", value1, value2, "endBusinessTime");
            return (Criteria) this;
        }

        public Criteria andEndBusinessTimeNotBetween(Long value1, Long value2) {
            addCriterion("end_business_time not between", value1, value2, "endBusinessTime");
            return (Criteria) this;
        }

        public Criteria andStationStatusIsNull() {
            addCriterion("station_status is null");
            return (Criteria) this;
        }

        public Criteria andStationStatusIsNotNull() {
            addCriterion("station_status is not null");
            return (Criteria) this;
        }

        public Criteria andStationStatusEqualTo(Byte value) {
            addCriterion("station_status =", value, "stationStatus");
            return (Criteria) this;
        }

        public Criteria andStationStatusNotEqualTo(Byte value) {
            addCriterion("station_status <>", value, "stationStatus");
            return (Criteria) this;
        }

        public Criteria andStationStatusGreaterThan(Byte value) {
            addCriterion("station_status >", value, "stationStatus");
            return (Criteria) this;
        }

        public Criteria andStationStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("station_status >=", value, "stationStatus");
            return (Criteria) this;
        }

        public Criteria andStationStatusLessThan(Byte value) {
            addCriterion("station_status <", value, "stationStatus");
            return (Criteria) this;
        }

        public Criteria andStationStatusLessThanOrEqualTo(Byte value) {
            addCriterion("station_status <=", value, "stationStatus");
            return (Criteria) this;
        }

        public Criteria andStationStatusIn(List<Byte> values) {
            addCriterion("station_status in", values, "stationStatus");
            return (Criteria) this;
        }

        public Criteria andStationStatusNotIn(List<Byte> values) {
            addCriterion("station_status not in", values, "stationStatus");
            return (Criteria) this;
        }

        public Criteria andStationStatusBetween(Byte value1, Byte value2) {
            addCriterion("station_status between", value1, value2, "stationStatus");
            return (Criteria) this;
        }

        public Criteria andStationStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("station_status not between", value1, value2, "stationStatus");
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

        public Criteria andServiceFeeIsNull() {
            addCriterion("service_fee is null");
            return (Criteria) this;
        }

        public Criteria andServiceFeeIsNotNull() {
            addCriterion("service_fee is not null");
            return (Criteria) this;
        }

        public Criteria andServiceFeeEqualTo(BigDecimal value) {
            addCriterion("service_fee =", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeNotEqualTo(BigDecimal value) {
            addCriterion("service_fee <>", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeGreaterThan(BigDecimal value) {
            addCriterion("service_fee >", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("service_fee >=", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeLessThan(BigDecimal value) {
            addCriterion("service_fee <", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("service_fee <=", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeIn(List<BigDecimal> values) {
            addCriterion("service_fee in", values, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeNotIn(List<BigDecimal> values) {
            addCriterion("service_fee not in", values, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("service_fee between", value1, value2, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("service_fee not between", value1, value2, "serviceFee");
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