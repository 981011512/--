package com.cf.logistics.domain;

import java.util.ArrayList;
import java.util.List;

public class CfLogisticsVehicleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfLogisticsVehicleExample() {
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

        public Criteria andVehicleOwnerIsNull() {
            addCriterion("vehicle_owner is null");
            return (Criteria) this;
        }

        public Criteria andVehicleOwnerIsNotNull() {
            addCriterion("vehicle_owner is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleOwnerEqualTo(String value) {
            addCriterion("vehicle_owner =", value, "vehicleOwner");
            return (Criteria) this;
        }

        public Criteria andVehicleOwnerNotEqualTo(String value) {
            addCriterion("vehicle_owner <>", value, "vehicleOwner");
            return (Criteria) this;
        }

        public Criteria andVehicleOwnerGreaterThan(String value) {
            addCriterion("vehicle_owner >", value, "vehicleOwner");
            return (Criteria) this;
        }

        public Criteria andVehicleOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle_owner >=", value, "vehicleOwner");
            return (Criteria) this;
        }

        public Criteria andVehicleOwnerLessThan(String value) {
            addCriterion("vehicle_owner <", value, "vehicleOwner");
            return (Criteria) this;
        }

        public Criteria andVehicleOwnerLessThanOrEqualTo(String value) {
            addCriterion("vehicle_owner <=", value, "vehicleOwner");
            return (Criteria) this;
        }

        public Criteria andVehicleOwnerLike(String value) {
            addCriterion("vehicle_owner like", value, "vehicleOwner");
            return (Criteria) this;
        }

        public Criteria andVehicleOwnerNotLike(String value) {
            addCriterion("vehicle_owner not like", value, "vehicleOwner");
            return (Criteria) this;
        }

        public Criteria andVehicleOwnerIn(List<String> values) {
            addCriterion("vehicle_owner in", values, "vehicleOwner");
            return (Criteria) this;
        }

        public Criteria andVehicleOwnerNotIn(List<String> values) {
            addCriterion("vehicle_owner not in", values, "vehicleOwner");
            return (Criteria) this;
        }

        public Criteria andVehicleOwnerBetween(String value1, String value2) {
            addCriterion("vehicle_owner between", value1, value2, "vehicleOwner");
            return (Criteria) this;
        }

        public Criteria andVehicleOwnerNotBetween(String value1, String value2) {
            addCriterion("vehicle_owner not between", value1, value2, "vehicleOwner");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeIsNull() {
            addCriterion("vehicle_type is null");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeIsNotNull() {
            addCriterion("vehicle_type is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeEqualTo(String value) {
            addCriterion("vehicle_type =", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNotEqualTo(String value) {
            addCriterion("vehicle_type <>", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeGreaterThan(String value) {
            addCriterion("vehicle_type >", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle_type >=", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeLessThan(String value) {
            addCriterion("vehicle_type <", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeLessThanOrEqualTo(String value) {
            addCriterion("vehicle_type <=", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeLike(String value) {
            addCriterion("vehicle_type like", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNotLike(String value) {
            addCriterion("vehicle_type not like", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeIn(List<String> values) {
            addCriterion("vehicle_type in", values, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNotIn(List<String> values) {
            addCriterion("vehicle_type not in", values, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeBetween(String value1, String value2) {
            addCriterion("vehicle_type between", value1, value2, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNotBetween(String value1, String value2) {
            addCriterion("vehicle_type not between", value1, value2, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleVinIsNull() {
            addCriterion("vehicle_vin is null");
            return (Criteria) this;
        }

        public Criteria andVehicleVinIsNotNull() {
            addCriterion("vehicle_vin is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleVinEqualTo(String value) {
            addCriterion("vehicle_vin =", value, "vehicleVin");
            return (Criteria) this;
        }

        public Criteria andVehicleVinNotEqualTo(String value) {
            addCriterion("vehicle_vin <>", value, "vehicleVin");
            return (Criteria) this;
        }

        public Criteria andVehicleVinGreaterThan(String value) {
            addCriterion("vehicle_vin >", value, "vehicleVin");
            return (Criteria) this;
        }

        public Criteria andVehicleVinGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle_vin >=", value, "vehicleVin");
            return (Criteria) this;
        }

        public Criteria andVehicleVinLessThan(String value) {
            addCriterion("vehicle_vin <", value, "vehicleVin");
            return (Criteria) this;
        }

        public Criteria andVehicleVinLessThanOrEqualTo(String value) {
            addCriterion("vehicle_vin <=", value, "vehicleVin");
            return (Criteria) this;
        }

        public Criteria andVehicleVinLike(String value) {
            addCriterion("vehicle_vin like", value, "vehicleVin");
            return (Criteria) this;
        }

        public Criteria andVehicleVinNotLike(String value) {
            addCriterion("vehicle_vin not like", value, "vehicleVin");
            return (Criteria) this;
        }

        public Criteria andVehicleVinIn(List<String> values) {
            addCriterion("vehicle_vin in", values, "vehicleVin");
            return (Criteria) this;
        }

        public Criteria andVehicleVinNotIn(List<String> values) {
            addCriterion("vehicle_vin not in", values, "vehicleVin");
            return (Criteria) this;
        }

        public Criteria andVehicleVinBetween(String value1, String value2) {
            addCriterion("vehicle_vin between", value1, value2, "vehicleVin");
            return (Criteria) this;
        }

        public Criteria andVehicleVinNotBetween(String value1, String value2) {
            addCriterion("vehicle_vin not between", value1, value2, "vehicleVin");
            return (Criteria) this;
        }

        public Criteria andVehicleSizeIsNull() {
            addCriterion("vehicle_size is null");
            return (Criteria) this;
        }

        public Criteria andVehicleSizeIsNotNull() {
            addCriterion("vehicle_size is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleSizeEqualTo(String value) {
            addCriterion("vehicle_size =", value, "vehicleSize");
            return (Criteria) this;
        }

        public Criteria andVehicleSizeNotEqualTo(String value) {
            addCriterion("vehicle_size <>", value, "vehicleSize");
            return (Criteria) this;
        }

        public Criteria andVehicleSizeGreaterThan(String value) {
            addCriterion("vehicle_size >", value, "vehicleSize");
            return (Criteria) this;
        }

        public Criteria andVehicleSizeGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle_size >=", value, "vehicleSize");
            return (Criteria) this;
        }

        public Criteria andVehicleSizeLessThan(String value) {
            addCriterion("vehicle_size <", value, "vehicleSize");
            return (Criteria) this;
        }

        public Criteria andVehicleSizeLessThanOrEqualTo(String value) {
            addCriterion("vehicle_size <=", value, "vehicleSize");
            return (Criteria) this;
        }

        public Criteria andVehicleSizeLike(String value) {
            addCriterion("vehicle_size like", value, "vehicleSize");
            return (Criteria) this;
        }

        public Criteria andVehicleSizeNotLike(String value) {
            addCriterion("vehicle_size not like", value, "vehicleSize");
            return (Criteria) this;
        }

        public Criteria andVehicleSizeIn(List<String> values) {
            addCriterion("vehicle_size in", values, "vehicleSize");
            return (Criteria) this;
        }

        public Criteria andVehicleSizeNotIn(List<String> values) {
            addCriterion("vehicle_size not in", values, "vehicleSize");
            return (Criteria) this;
        }

        public Criteria andVehicleSizeBetween(String value1, String value2) {
            addCriterion("vehicle_size between", value1, value2, "vehicleSize");
            return (Criteria) this;
        }

        public Criteria andVehicleSizeNotBetween(String value1, String value2) {
            addCriterion("vehicle_size not between", value1, value2, "vehicleSize");
            return (Criteria) this;
        }

        public Criteria andApprovedLoadIsNull() {
            addCriterion("approved_load is null");
            return (Criteria) this;
        }

        public Criteria andApprovedLoadIsNotNull() {
            addCriterion("approved_load is not null");
            return (Criteria) this;
        }

        public Criteria andApprovedLoadEqualTo(Integer value) {
            addCriterion("approved_load =", value, "approvedLoad");
            return (Criteria) this;
        }

        public Criteria andApprovedLoadNotEqualTo(Integer value) {
            addCriterion("approved_load <>", value, "approvedLoad");
            return (Criteria) this;
        }

        public Criteria andApprovedLoadGreaterThan(Integer value) {
            addCriterion("approved_load >", value, "approvedLoad");
            return (Criteria) this;
        }

        public Criteria andApprovedLoadGreaterThanOrEqualTo(Integer value) {
            addCriterion("approved_load >=", value, "approvedLoad");
            return (Criteria) this;
        }

        public Criteria andApprovedLoadLessThan(Integer value) {
            addCriterion("approved_load <", value, "approvedLoad");
            return (Criteria) this;
        }

        public Criteria andApprovedLoadLessThanOrEqualTo(Integer value) {
            addCriterion("approved_load <=", value, "approvedLoad");
            return (Criteria) this;
        }

        public Criteria andApprovedLoadIn(List<Integer> values) {
            addCriterion("approved_load in", values, "approvedLoad");
            return (Criteria) this;
        }

        public Criteria andApprovedLoadNotIn(List<Integer> values) {
            addCriterion("approved_load not in", values, "approvedLoad");
            return (Criteria) this;
        }

        public Criteria andApprovedLoadBetween(Integer value1, Integer value2) {
            addCriterion("approved_load between", value1, value2, "approvedLoad");
            return (Criteria) this;
        }

        public Criteria andApprovedLoadNotBetween(Integer value1, Integer value2) {
            addCriterion("approved_load not between", value1, value2, "approvedLoad");
            return (Criteria) this;
        }

        public Criteria andNumberPlateColorIsNull() {
            addCriterion("number_plate_color is null");
            return (Criteria) this;
        }

        public Criteria andNumberPlateColorIsNotNull() {
            addCriterion("number_plate_color is not null");
            return (Criteria) this;
        }

        public Criteria andNumberPlateColorEqualTo(Byte value) {
            addCriterion("number_plate_color =", value, "numberPlateColor");
            return (Criteria) this;
        }

        public Criteria andNumberPlateColorNotEqualTo(Byte value) {
            addCriterion("number_plate_color <>", value, "numberPlateColor");
            return (Criteria) this;
        }

        public Criteria andNumberPlateColorGreaterThan(Byte value) {
            addCriterion("number_plate_color >", value, "numberPlateColor");
            return (Criteria) this;
        }

        public Criteria andNumberPlateColorGreaterThanOrEqualTo(Byte value) {
            addCriterion("number_plate_color >=", value, "numberPlateColor");
            return (Criteria) this;
        }

        public Criteria andNumberPlateColorLessThan(Byte value) {
            addCriterion("number_plate_color <", value, "numberPlateColor");
            return (Criteria) this;
        }

        public Criteria andNumberPlateColorLessThanOrEqualTo(Byte value) {
            addCriterion("number_plate_color <=", value, "numberPlateColor");
            return (Criteria) this;
        }

        public Criteria andNumberPlateColorIn(List<Byte> values) {
            addCriterion("number_plate_color in", values, "numberPlateColor");
            return (Criteria) this;
        }

        public Criteria andNumberPlateColorNotIn(List<Byte> values) {
            addCriterion("number_plate_color not in", values, "numberPlateColor");
            return (Criteria) this;
        }

        public Criteria andNumberPlateColorBetween(Byte value1, Byte value2) {
            addCriterion("number_plate_color between", value1, value2, "numberPlateColor");
            return (Criteria) this;
        }

        public Criteria andNumberPlateColorNotBetween(Byte value1, Byte value2) {
            addCriterion("number_plate_color not between", value1, value2, "numberPlateColor");
            return (Criteria) this;
        }

        public Criteria andRoadTransportCertificateNumberIsNull() {
            addCriterion("road_transport_certificate_number is null");
            return (Criteria) this;
        }

        public Criteria andRoadTransportCertificateNumberIsNotNull() {
            addCriterion("road_transport_certificate_number is not null");
            return (Criteria) this;
        }

        public Criteria andRoadTransportCertificateNumberEqualTo(String value) {
            addCriterion("road_transport_certificate_number =", value, "roadTransportCertificateNumber");
            return (Criteria) this;
        }

        public Criteria andRoadTransportCertificateNumberNotEqualTo(String value) {
            addCriterion("road_transport_certificate_number <>", value, "roadTransportCertificateNumber");
            return (Criteria) this;
        }

        public Criteria andRoadTransportCertificateNumberGreaterThan(String value) {
            addCriterion("road_transport_certificate_number >", value, "roadTransportCertificateNumber");
            return (Criteria) this;
        }

        public Criteria andRoadTransportCertificateNumberGreaterThanOrEqualTo(String value) {
            addCriterion("road_transport_certificate_number >=", value, "roadTransportCertificateNumber");
            return (Criteria) this;
        }

        public Criteria andRoadTransportCertificateNumberLessThan(String value) {
            addCriterion("road_transport_certificate_number <", value, "roadTransportCertificateNumber");
            return (Criteria) this;
        }

        public Criteria andRoadTransportCertificateNumberLessThanOrEqualTo(String value) {
            addCriterion("road_transport_certificate_number <=", value, "roadTransportCertificateNumber");
            return (Criteria) this;
        }

        public Criteria andRoadTransportCertificateNumberLike(String value) {
            addCriterion("road_transport_certificate_number like", value, "roadTransportCertificateNumber");
            return (Criteria) this;
        }

        public Criteria andRoadTransportCertificateNumberNotLike(String value) {
            addCriterion("road_transport_certificate_number not like", value, "roadTransportCertificateNumber");
            return (Criteria) this;
        }

        public Criteria andRoadTransportCertificateNumberIn(List<String> values) {
            addCriterion("road_transport_certificate_number in", values, "roadTransportCertificateNumber");
            return (Criteria) this;
        }

        public Criteria andRoadTransportCertificateNumberNotIn(List<String> values) {
            addCriterion("road_transport_certificate_number not in", values, "roadTransportCertificateNumber");
            return (Criteria) this;
        }

        public Criteria andRoadTransportCertificateNumberBetween(String value1, String value2) {
            addCriterion("road_transport_certificate_number between", value1, value2, "roadTransportCertificateNumber");
            return (Criteria) this;
        }

        public Criteria andRoadTransportCertificateNumberNotBetween(String value1, String value2) {
            addCriterion("road_transport_certificate_number not between", value1, value2, "roadTransportCertificateNumber");
            return (Criteria) this;
        }

        public Criteria andOperatingLicenseNumberIsNull() {
            addCriterion("operating_license_number is null");
            return (Criteria) this;
        }

        public Criteria andOperatingLicenseNumberIsNotNull() {
            addCriterion("operating_license_number is not null");
            return (Criteria) this;
        }

        public Criteria andOperatingLicenseNumberEqualTo(String value) {
            addCriterion("operating_license_number =", value, "operatingLicenseNumber");
            return (Criteria) this;
        }

        public Criteria andOperatingLicenseNumberNotEqualTo(String value) {
            addCriterion("operating_license_number <>", value, "operatingLicenseNumber");
            return (Criteria) this;
        }

        public Criteria andOperatingLicenseNumberGreaterThan(String value) {
            addCriterion("operating_license_number >", value, "operatingLicenseNumber");
            return (Criteria) this;
        }

        public Criteria andOperatingLicenseNumberGreaterThanOrEqualTo(String value) {
            addCriterion("operating_license_number >=", value, "operatingLicenseNumber");
            return (Criteria) this;
        }

        public Criteria andOperatingLicenseNumberLessThan(String value) {
            addCriterion("operating_license_number <", value, "operatingLicenseNumber");
            return (Criteria) this;
        }

        public Criteria andOperatingLicenseNumberLessThanOrEqualTo(String value) {
            addCriterion("operating_license_number <=", value, "operatingLicenseNumber");
            return (Criteria) this;
        }

        public Criteria andOperatingLicenseNumberLike(String value) {
            addCriterion("operating_license_number like", value, "operatingLicenseNumber");
            return (Criteria) this;
        }

        public Criteria andOperatingLicenseNumberNotLike(String value) {
            addCriterion("operating_license_number not like", value, "operatingLicenseNumber");
            return (Criteria) this;
        }

        public Criteria andOperatingLicenseNumberIn(List<String> values) {
            addCriterion("operating_license_number in", values, "operatingLicenseNumber");
            return (Criteria) this;
        }

        public Criteria andOperatingLicenseNumberNotIn(List<String> values) {
            addCriterion("operating_license_number not in", values, "operatingLicenseNumber");
            return (Criteria) this;
        }

        public Criteria andOperatingLicenseNumberBetween(String value1, String value2) {
            addCriterion("operating_license_number between", value1, value2, "operatingLicenseNumber");
            return (Criteria) this;
        }

        public Criteria andOperatingLicenseNumberNotBetween(String value1, String value2) {
            addCriterion("operating_license_number not between", value1, value2, "operatingLicenseNumber");
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

        public Criteria andActionUidIsNull() {
            addCriterion("action_uid is null");
            return (Criteria) this;
        }

        public Criteria andActionUidIsNotNull() {
            addCriterion("action_uid is not null");
            return (Criteria) this;
        }

        public Criteria andActionUidEqualTo(String value) {
            addCriterion("action_uid =", value, "actionUid");
            return (Criteria) this;
        }

        public Criteria andActionUidNotEqualTo(String value) {
            addCriterion("action_uid <>", value, "actionUid");
            return (Criteria) this;
        }

        public Criteria andActionUidGreaterThan(String value) {
            addCriterion("action_uid >", value, "actionUid");
            return (Criteria) this;
        }

        public Criteria andActionUidGreaterThanOrEqualTo(String value) {
            addCriterion("action_uid >=", value, "actionUid");
            return (Criteria) this;
        }

        public Criteria andActionUidLessThan(String value) {
            addCriterion("action_uid <", value, "actionUid");
            return (Criteria) this;
        }

        public Criteria andActionUidLessThanOrEqualTo(String value) {
            addCriterion("action_uid <=", value, "actionUid");
            return (Criteria) this;
        }

        public Criteria andActionUidLike(String value) {
            addCriterion("action_uid like", value, "actionUid");
            return (Criteria) this;
        }

        public Criteria andActionUidNotLike(String value) {
            addCriterion("action_uid not like", value, "actionUid");
            return (Criteria) this;
        }

        public Criteria andActionUidIn(List<String> values) {
            addCriterion("action_uid in", values, "actionUid");
            return (Criteria) this;
        }

        public Criteria andActionUidNotIn(List<String> values) {
            addCriterion("action_uid not in", values, "actionUid");
            return (Criteria) this;
        }

        public Criteria andActionUidBetween(String value1, String value2) {
            addCriterion("action_uid between", value1, value2, "actionUid");
            return (Criteria) this;
        }

        public Criteria andActionUidNotBetween(String value1, String value2) {
            addCriterion("action_uid not between", value1, value2, "actionUid");
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