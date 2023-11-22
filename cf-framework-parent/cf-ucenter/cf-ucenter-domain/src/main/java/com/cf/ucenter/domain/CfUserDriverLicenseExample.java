package com.cf.ucenter.domain;

import java.util.ArrayList;
import java.util.List;

public class CfUserDriverLicenseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfUserDriverLicenseExample() {
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

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Byte value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Byte value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Byte value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Byte value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Byte value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Byte value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Byte> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Byte> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Byte value1, Byte value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Byte value1, Byte value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andNationalityIsNull() {
            addCriterion("nationality is null");
            return (Criteria) this;
        }

        public Criteria andNationalityIsNotNull() {
            addCriterion("nationality is not null");
            return (Criteria) this;
        }

        public Criteria andNationalityEqualTo(String value) {
            addCriterion("nationality =", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityNotEqualTo(String value) {
            addCriterion("nationality <>", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityGreaterThan(String value) {
            addCriterion("nationality >", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityGreaterThanOrEqualTo(String value) {
            addCriterion("nationality >=", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityLessThan(String value) {
            addCriterion("nationality <", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityLessThanOrEqualTo(String value) {
            addCriterion("nationality <=", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityLike(String value) {
            addCriterion("nationality like", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityNotLike(String value) {
            addCriterion("nationality not like", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityIn(List<String> values) {
            addCriterion("nationality in", values, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityNotIn(List<String> values) {
            addCriterion("nationality not in", values, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityBetween(String value1, String value2) {
            addCriterion("nationality between", value1, value2, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityNotBetween(String value1, String value2) {
            addCriterion("nationality not between", value1, value2, "nationality");
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

        public Criteria andBirthdayYearIsNull() {
            addCriterion("birthday_year is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayYearIsNotNull() {
            addCriterion("birthday_year is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayYearEqualTo(Short value) {
            addCriterion("birthday_year =", value, "birthdayYear");
            return (Criteria) this;
        }

        public Criteria andBirthdayYearNotEqualTo(Short value) {
            addCriterion("birthday_year <>", value, "birthdayYear");
            return (Criteria) this;
        }

        public Criteria andBirthdayYearGreaterThan(Short value) {
            addCriterion("birthday_year >", value, "birthdayYear");
            return (Criteria) this;
        }

        public Criteria andBirthdayYearGreaterThanOrEqualTo(Short value) {
            addCriterion("birthday_year >=", value, "birthdayYear");
            return (Criteria) this;
        }

        public Criteria andBirthdayYearLessThan(Short value) {
            addCriterion("birthday_year <", value, "birthdayYear");
            return (Criteria) this;
        }

        public Criteria andBirthdayYearLessThanOrEqualTo(Short value) {
            addCriterion("birthday_year <=", value, "birthdayYear");
            return (Criteria) this;
        }

        public Criteria andBirthdayYearIn(List<Short> values) {
            addCriterion("birthday_year in", values, "birthdayYear");
            return (Criteria) this;
        }

        public Criteria andBirthdayYearNotIn(List<Short> values) {
            addCriterion("birthday_year not in", values, "birthdayYear");
            return (Criteria) this;
        }

        public Criteria andBirthdayYearBetween(Short value1, Short value2) {
            addCriterion("birthday_year between", value1, value2, "birthdayYear");
            return (Criteria) this;
        }

        public Criteria andBirthdayYearNotBetween(Short value1, Short value2) {
            addCriterion("birthday_year not between", value1, value2, "birthdayYear");
            return (Criteria) this;
        }

        public Criteria andBirthdayMonthIsNull() {
            addCriterion("birthday_month is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayMonthIsNotNull() {
            addCriterion("birthday_month is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayMonthEqualTo(Byte value) {
            addCriterion("birthday_month =", value, "birthdayMonth");
            return (Criteria) this;
        }

        public Criteria andBirthdayMonthNotEqualTo(Byte value) {
            addCriterion("birthday_month <>", value, "birthdayMonth");
            return (Criteria) this;
        }

        public Criteria andBirthdayMonthGreaterThan(Byte value) {
            addCriterion("birthday_month >", value, "birthdayMonth");
            return (Criteria) this;
        }

        public Criteria andBirthdayMonthGreaterThanOrEqualTo(Byte value) {
            addCriterion("birthday_month >=", value, "birthdayMonth");
            return (Criteria) this;
        }

        public Criteria andBirthdayMonthLessThan(Byte value) {
            addCriterion("birthday_month <", value, "birthdayMonth");
            return (Criteria) this;
        }

        public Criteria andBirthdayMonthLessThanOrEqualTo(Byte value) {
            addCriterion("birthday_month <=", value, "birthdayMonth");
            return (Criteria) this;
        }

        public Criteria andBirthdayMonthIn(List<Byte> values) {
            addCriterion("birthday_month in", values, "birthdayMonth");
            return (Criteria) this;
        }

        public Criteria andBirthdayMonthNotIn(List<Byte> values) {
            addCriterion("birthday_month not in", values, "birthdayMonth");
            return (Criteria) this;
        }

        public Criteria andBirthdayMonthBetween(Byte value1, Byte value2) {
            addCriterion("birthday_month between", value1, value2, "birthdayMonth");
            return (Criteria) this;
        }

        public Criteria andBirthdayMonthNotBetween(Byte value1, Byte value2) {
            addCriterion("birthday_month not between", value1, value2, "birthdayMonth");
            return (Criteria) this;
        }

        public Criteria andBirthdayDayIsNull() {
            addCriterion("birthday_day is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayDayIsNotNull() {
            addCriterion("birthday_day is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayDayEqualTo(Byte value) {
            addCriterion("birthday_day =", value, "birthdayDay");
            return (Criteria) this;
        }

        public Criteria andBirthdayDayNotEqualTo(Byte value) {
            addCriterion("birthday_day <>", value, "birthdayDay");
            return (Criteria) this;
        }

        public Criteria andBirthdayDayGreaterThan(Byte value) {
            addCriterion("birthday_day >", value, "birthdayDay");
            return (Criteria) this;
        }

        public Criteria andBirthdayDayGreaterThanOrEqualTo(Byte value) {
            addCriterion("birthday_day >=", value, "birthdayDay");
            return (Criteria) this;
        }

        public Criteria andBirthdayDayLessThan(Byte value) {
            addCriterion("birthday_day <", value, "birthdayDay");
            return (Criteria) this;
        }

        public Criteria andBirthdayDayLessThanOrEqualTo(Byte value) {
            addCriterion("birthday_day <=", value, "birthdayDay");
            return (Criteria) this;
        }

        public Criteria andBirthdayDayIn(List<Byte> values) {
            addCriterion("birthday_day in", values, "birthdayDay");
            return (Criteria) this;
        }

        public Criteria andBirthdayDayNotIn(List<Byte> values) {
            addCriterion("birthday_day not in", values, "birthdayDay");
            return (Criteria) this;
        }

        public Criteria andBirthdayDayBetween(Byte value1, Byte value2) {
            addCriterion("birthday_day between", value1, value2, "birthdayDay");
            return (Criteria) this;
        }

        public Criteria andBirthdayDayNotBetween(Byte value1, Byte value2) {
            addCriterion("birthday_day not between", value1, value2, "birthdayDay");
            return (Criteria) this;
        }

        public Criteria andFirstIssueYearIsNull() {
            addCriterion("first_issue_year is null");
            return (Criteria) this;
        }

        public Criteria andFirstIssueYearIsNotNull() {
            addCriterion("first_issue_year is not null");
            return (Criteria) this;
        }

        public Criteria andFirstIssueYearEqualTo(Short value) {
            addCriterion("first_issue_year =", value, "firstIssueYear");
            return (Criteria) this;
        }

        public Criteria andFirstIssueYearNotEqualTo(Short value) {
            addCriterion("first_issue_year <>", value, "firstIssueYear");
            return (Criteria) this;
        }

        public Criteria andFirstIssueYearGreaterThan(Short value) {
            addCriterion("first_issue_year >", value, "firstIssueYear");
            return (Criteria) this;
        }

        public Criteria andFirstIssueYearGreaterThanOrEqualTo(Short value) {
            addCriterion("first_issue_year >=", value, "firstIssueYear");
            return (Criteria) this;
        }

        public Criteria andFirstIssueYearLessThan(Short value) {
            addCriterion("first_issue_year <", value, "firstIssueYear");
            return (Criteria) this;
        }

        public Criteria andFirstIssueYearLessThanOrEqualTo(Short value) {
            addCriterion("first_issue_year <=", value, "firstIssueYear");
            return (Criteria) this;
        }

        public Criteria andFirstIssueYearIn(List<Short> values) {
            addCriterion("first_issue_year in", values, "firstIssueYear");
            return (Criteria) this;
        }

        public Criteria andFirstIssueYearNotIn(List<Short> values) {
            addCriterion("first_issue_year not in", values, "firstIssueYear");
            return (Criteria) this;
        }

        public Criteria andFirstIssueYearBetween(Short value1, Short value2) {
            addCriterion("first_issue_year between", value1, value2, "firstIssueYear");
            return (Criteria) this;
        }

        public Criteria andFirstIssueYearNotBetween(Short value1, Short value2) {
            addCriterion("first_issue_year not between", value1, value2, "firstIssueYear");
            return (Criteria) this;
        }

        public Criteria andFirstIssueMonthIsNull() {
            addCriterion("first_issue_month is null");
            return (Criteria) this;
        }

        public Criteria andFirstIssueMonthIsNotNull() {
            addCriterion("first_issue_month is not null");
            return (Criteria) this;
        }

        public Criteria andFirstIssueMonthEqualTo(Byte value) {
            addCriterion("first_issue_month =", value, "firstIssueMonth");
            return (Criteria) this;
        }

        public Criteria andFirstIssueMonthNotEqualTo(Byte value) {
            addCriterion("first_issue_month <>", value, "firstIssueMonth");
            return (Criteria) this;
        }

        public Criteria andFirstIssueMonthGreaterThan(Byte value) {
            addCriterion("first_issue_month >", value, "firstIssueMonth");
            return (Criteria) this;
        }

        public Criteria andFirstIssueMonthGreaterThanOrEqualTo(Byte value) {
            addCriterion("first_issue_month >=", value, "firstIssueMonth");
            return (Criteria) this;
        }

        public Criteria andFirstIssueMonthLessThan(Byte value) {
            addCriterion("first_issue_month <", value, "firstIssueMonth");
            return (Criteria) this;
        }

        public Criteria andFirstIssueMonthLessThanOrEqualTo(Byte value) {
            addCriterion("first_issue_month <=", value, "firstIssueMonth");
            return (Criteria) this;
        }

        public Criteria andFirstIssueMonthIn(List<Byte> values) {
            addCriterion("first_issue_month in", values, "firstIssueMonth");
            return (Criteria) this;
        }

        public Criteria andFirstIssueMonthNotIn(List<Byte> values) {
            addCriterion("first_issue_month not in", values, "firstIssueMonth");
            return (Criteria) this;
        }

        public Criteria andFirstIssueMonthBetween(Byte value1, Byte value2) {
            addCriterion("first_issue_month between", value1, value2, "firstIssueMonth");
            return (Criteria) this;
        }

        public Criteria andFirstIssueMonthNotBetween(Byte value1, Byte value2) {
            addCriterion("first_issue_month not between", value1, value2, "firstIssueMonth");
            return (Criteria) this;
        }

        public Criteria andFirstIssueDayIsNull() {
            addCriterion("first_issue_day is null");
            return (Criteria) this;
        }

        public Criteria andFirstIssueDayIsNotNull() {
            addCriterion("first_issue_day is not null");
            return (Criteria) this;
        }

        public Criteria andFirstIssueDayEqualTo(Byte value) {
            addCriterion("first_issue_day =", value, "firstIssueDay");
            return (Criteria) this;
        }

        public Criteria andFirstIssueDayNotEqualTo(Byte value) {
            addCriterion("first_issue_day <>", value, "firstIssueDay");
            return (Criteria) this;
        }

        public Criteria andFirstIssueDayGreaterThan(Byte value) {
            addCriterion("first_issue_day >", value, "firstIssueDay");
            return (Criteria) this;
        }

        public Criteria andFirstIssueDayGreaterThanOrEqualTo(Byte value) {
            addCriterion("first_issue_day >=", value, "firstIssueDay");
            return (Criteria) this;
        }

        public Criteria andFirstIssueDayLessThan(Byte value) {
            addCriterion("first_issue_day <", value, "firstIssueDay");
            return (Criteria) this;
        }

        public Criteria andFirstIssueDayLessThanOrEqualTo(Byte value) {
            addCriterion("first_issue_day <=", value, "firstIssueDay");
            return (Criteria) this;
        }

        public Criteria andFirstIssueDayIn(List<Byte> values) {
            addCriterion("first_issue_day in", values, "firstIssueDay");
            return (Criteria) this;
        }

        public Criteria andFirstIssueDayNotIn(List<Byte> values) {
            addCriterion("first_issue_day not in", values, "firstIssueDay");
            return (Criteria) this;
        }

        public Criteria andFirstIssueDayBetween(Byte value1, Byte value2) {
            addCriterion("first_issue_day between", value1, value2, "firstIssueDay");
            return (Criteria) this;
        }

        public Criteria andFirstIssueDayNotBetween(Byte value1, Byte value2) {
            addCriterion("first_issue_day not between", value1, value2, "firstIssueDay");
            return (Criteria) this;
        }

        public Criteria andCarClassIsNull() {
            addCriterion("car_class is null");
            return (Criteria) this;
        }

        public Criteria andCarClassIsNotNull() {
            addCriterion("car_class is not null");
            return (Criteria) this;
        }

        public Criteria andCarClassEqualTo(String value) {
            addCriterion("car_class =", value, "carClass");
            return (Criteria) this;
        }

        public Criteria andCarClassNotEqualTo(String value) {
            addCriterion("car_class <>", value, "carClass");
            return (Criteria) this;
        }

        public Criteria andCarClassGreaterThan(String value) {
            addCriterion("car_class >", value, "carClass");
            return (Criteria) this;
        }

        public Criteria andCarClassGreaterThanOrEqualTo(String value) {
            addCriterion("car_class >=", value, "carClass");
            return (Criteria) this;
        }

        public Criteria andCarClassLessThan(String value) {
            addCriterion("car_class <", value, "carClass");
            return (Criteria) this;
        }

        public Criteria andCarClassLessThanOrEqualTo(String value) {
            addCriterion("car_class <=", value, "carClass");
            return (Criteria) this;
        }

        public Criteria andCarClassLike(String value) {
            addCriterion("car_class like", value, "carClass");
            return (Criteria) this;
        }

        public Criteria andCarClassNotLike(String value) {
            addCriterion("car_class not like", value, "carClass");
            return (Criteria) this;
        }

        public Criteria andCarClassIn(List<String> values) {
            addCriterion("car_class in", values, "carClass");
            return (Criteria) this;
        }

        public Criteria andCarClassNotIn(List<String> values) {
            addCriterion("car_class not in", values, "carClass");
            return (Criteria) this;
        }

        public Criteria andCarClassBetween(String value1, String value2) {
            addCriterion("car_class between", value1, value2, "carClass");
            return (Criteria) this;
        }

        public Criteria andCarClassNotBetween(String value1, String value2) {
            addCriterion("car_class not between", value1, value2, "carClass");
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

        public Criteria andCertificateNumberIsNull() {
            addCriterion("certificate_number is null");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberIsNotNull() {
            addCriterion("certificate_number is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberEqualTo(String value) {
            addCriterion("certificate_number =", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberNotEqualTo(String value) {
            addCriterion("certificate_number <>", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberGreaterThan(String value) {
            addCriterion("certificate_number >", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberGreaterThanOrEqualTo(String value) {
            addCriterion("certificate_number >=", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberLessThan(String value) {
            addCriterion("certificate_number <", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberLessThanOrEqualTo(String value) {
            addCriterion("certificate_number <=", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberLike(String value) {
            addCriterion("certificate_number like", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberNotLike(String value) {
            addCriterion("certificate_number not like", value, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberIn(List<String> values) {
            addCriterion("certificate_number in", values, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberNotIn(List<String> values) {
            addCriterion("certificate_number not in", values, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberBetween(String value1, String value2) {
            addCriterion("certificate_number between", value1, value2, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andCertificateNumberNotBetween(String value1, String value2) {
            addCriterion("certificate_number not between", value1, value2, "certificateNumber");
            return (Criteria) this;
        }

        public Criteria andIssuingAuthorityIsNull() {
            addCriterion("issuing_authority is null");
            return (Criteria) this;
        }

        public Criteria andIssuingAuthorityIsNotNull() {
            addCriterion("issuing_authority is not null");
            return (Criteria) this;
        }

        public Criteria andIssuingAuthorityEqualTo(String value) {
            addCriterion("issuing_authority =", value, "issuingAuthority");
            return (Criteria) this;
        }

        public Criteria andIssuingAuthorityNotEqualTo(String value) {
            addCriterion("issuing_authority <>", value, "issuingAuthority");
            return (Criteria) this;
        }

        public Criteria andIssuingAuthorityGreaterThan(String value) {
            addCriterion("issuing_authority >", value, "issuingAuthority");
            return (Criteria) this;
        }

        public Criteria andIssuingAuthorityGreaterThanOrEqualTo(String value) {
            addCriterion("issuing_authority >=", value, "issuingAuthority");
            return (Criteria) this;
        }

        public Criteria andIssuingAuthorityLessThan(String value) {
            addCriterion("issuing_authority <", value, "issuingAuthority");
            return (Criteria) this;
        }

        public Criteria andIssuingAuthorityLessThanOrEqualTo(String value) {
            addCriterion("issuing_authority <=", value, "issuingAuthority");
            return (Criteria) this;
        }

        public Criteria andIssuingAuthorityLike(String value) {
            addCriterion("issuing_authority like", value, "issuingAuthority");
            return (Criteria) this;
        }

        public Criteria andIssuingAuthorityNotLike(String value) {
            addCriterion("issuing_authority not like", value, "issuingAuthority");
            return (Criteria) this;
        }

        public Criteria andIssuingAuthorityIn(List<String> values) {
            addCriterion("issuing_authority in", values, "issuingAuthority");
            return (Criteria) this;
        }

        public Criteria andIssuingAuthorityNotIn(List<String> values) {
            addCriterion("issuing_authority not in", values, "issuingAuthority");
            return (Criteria) this;
        }

        public Criteria andIssuingAuthorityBetween(String value1, String value2) {
            addCriterion("issuing_authority between", value1, value2, "issuingAuthority");
            return (Criteria) this;
        }

        public Criteria andIssuingAuthorityNotBetween(String value1, String value2) {
            addCriterion("issuing_authority not between", value1, value2, "issuingAuthority");
            return (Criteria) this;
        }

        public Criteria andFileNumberIsNull() {
            addCriterion("file_number is null");
            return (Criteria) this;
        }

        public Criteria andFileNumberIsNotNull() {
            addCriterion("file_number is not null");
            return (Criteria) this;
        }

        public Criteria andFileNumberEqualTo(String value) {
            addCriterion("file_number =", value, "fileNumber");
            return (Criteria) this;
        }

        public Criteria andFileNumberNotEqualTo(String value) {
            addCriterion("file_number <>", value, "fileNumber");
            return (Criteria) this;
        }

        public Criteria andFileNumberGreaterThan(String value) {
            addCriterion("file_number >", value, "fileNumber");
            return (Criteria) this;
        }

        public Criteria andFileNumberGreaterThanOrEqualTo(String value) {
            addCriterion("file_number >=", value, "fileNumber");
            return (Criteria) this;
        }

        public Criteria andFileNumberLessThan(String value) {
            addCriterion("file_number <", value, "fileNumber");
            return (Criteria) this;
        }

        public Criteria andFileNumberLessThanOrEqualTo(String value) {
            addCriterion("file_number <=", value, "fileNumber");
            return (Criteria) this;
        }

        public Criteria andFileNumberLike(String value) {
            addCriterion("file_number like", value, "fileNumber");
            return (Criteria) this;
        }

        public Criteria andFileNumberNotLike(String value) {
            addCriterion("file_number not like", value, "fileNumber");
            return (Criteria) this;
        }

        public Criteria andFileNumberIn(List<String> values) {
            addCriterion("file_number in", values, "fileNumber");
            return (Criteria) this;
        }

        public Criteria andFileNumberNotIn(List<String> values) {
            addCriterion("file_number not in", values, "fileNumber");
            return (Criteria) this;
        }

        public Criteria andFileNumberBetween(String value1, String value2) {
            addCriterion("file_number between", value1, value2, "fileNumber");
            return (Criteria) this;
        }

        public Criteria andFileNumberNotBetween(String value1, String value2) {
            addCriterion("file_number not between", value1, value2, "fileNumber");
            return (Criteria) this;
        }

        public Criteria andInternshipPeriodEndsIsNull() {
            addCriterion("internship_period_ends is null");
            return (Criteria) this;
        }

        public Criteria andInternshipPeriodEndsIsNotNull() {
            addCriterion("internship_period_ends is not null");
            return (Criteria) this;
        }

        public Criteria andInternshipPeriodEndsEqualTo(Long value) {
            addCriterion("internship_period_ends =", value, "internshipPeriodEnds");
            return (Criteria) this;
        }

        public Criteria andInternshipPeriodEndsNotEqualTo(Long value) {
            addCriterion("internship_period_ends <>", value, "internshipPeriodEnds");
            return (Criteria) this;
        }

        public Criteria andInternshipPeriodEndsGreaterThan(Long value) {
            addCriterion("internship_period_ends >", value, "internshipPeriodEnds");
            return (Criteria) this;
        }

        public Criteria andInternshipPeriodEndsGreaterThanOrEqualTo(Long value) {
            addCriterion("internship_period_ends >=", value, "internshipPeriodEnds");
            return (Criteria) this;
        }

        public Criteria andInternshipPeriodEndsLessThan(Long value) {
            addCriterion("internship_period_ends <", value, "internshipPeriodEnds");
            return (Criteria) this;
        }

        public Criteria andInternshipPeriodEndsLessThanOrEqualTo(Long value) {
            addCriterion("internship_period_ends <=", value, "internshipPeriodEnds");
            return (Criteria) this;
        }

        public Criteria andInternshipPeriodEndsIn(List<Long> values) {
            addCriterion("internship_period_ends in", values, "internshipPeriodEnds");
            return (Criteria) this;
        }

        public Criteria andInternshipPeriodEndsNotIn(List<Long> values) {
            addCriterion("internship_period_ends not in", values, "internshipPeriodEnds");
            return (Criteria) this;
        }

        public Criteria andInternshipPeriodEndsBetween(Long value1, Long value2) {
            addCriterion("internship_period_ends between", value1, value2, "internshipPeriodEnds");
            return (Criteria) this;
        }

        public Criteria andInternshipPeriodEndsNotBetween(Long value1, Long value2) {
            addCriterion("internship_period_ends not between", value1, value2, "internshipPeriodEnds");
            return (Criteria) this;
        }

        public Criteria andImagesIsNull() {
            addCriterion("images is null");
            return (Criteria) this;
        }

        public Criteria andImagesIsNotNull() {
            addCriterion("images is not null");
            return (Criteria) this;
        }

        public Criteria andImagesEqualTo(String value) {
            addCriterion("images =", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesNotEqualTo(String value) {
            addCriterion("images <>", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesGreaterThan(String value) {
            addCriterion("images >", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesGreaterThanOrEqualTo(String value) {
            addCriterion("images >=", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesLessThan(String value) {
            addCriterion("images <", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesLessThanOrEqualTo(String value) {
            addCriterion("images <=", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesLike(String value) {
            addCriterion("images like", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesNotLike(String value) {
            addCriterion("images not like", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesIn(List<String> values) {
            addCriterion("images in", values, "images");
            return (Criteria) this;
        }

        public Criteria andImagesNotIn(List<String> values) {
            addCriterion("images not in", values, "images");
            return (Criteria) this;
        }

        public Criteria andImagesBetween(String value1, String value2) {
            addCriterion("images between", value1, value2, "images");
            return (Criteria) this;
        }

        public Criteria andImagesNotBetween(String value1, String value2) {
            addCriterion("images not between", value1, value2, "images");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNull() {
            addCriterion("check_status is null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNotNull() {
            addCriterion("check_status is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusEqualTo(Byte value) {
            addCriterion("check_status =", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotEqualTo(Byte value) {
            addCriterion("check_status <>", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThan(Byte value) {
            addCriterion("check_status >", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("check_status >=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThan(Byte value) {
            addCriterion("check_status <", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThanOrEqualTo(Byte value) {
            addCriterion("check_status <=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIn(List<Byte> values) {
            addCriterion("check_status in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotIn(List<Byte> values) {
            addCriterion("check_status not in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusBetween(Byte value1, Byte value2) {
            addCriterion("check_status between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("check_status not between", value1, value2, "checkStatus");
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

        public Criteria andQualificationCertificateNumberIsNull() {
            addCriterion("qualification_certificate_number is null");
            return (Criteria) this;
        }

        public Criteria andQualificationCertificateNumberIsNotNull() {
            addCriterion("qualification_certificate_number is not null");
            return (Criteria) this;
        }

        public Criteria andQualificationCertificateNumberEqualTo(String value) {
            addCriterion("qualification_certificate_number =", value, "qualificationCertificateNumber");
            return (Criteria) this;
        }

        public Criteria andQualificationCertificateNumberNotEqualTo(String value) {
            addCriterion("qualification_certificate_number <>", value, "qualificationCertificateNumber");
            return (Criteria) this;
        }

        public Criteria andQualificationCertificateNumberGreaterThan(String value) {
            addCriterion("qualification_certificate_number >", value, "qualificationCertificateNumber");
            return (Criteria) this;
        }

        public Criteria andQualificationCertificateNumberGreaterThanOrEqualTo(String value) {
            addCriterion("qualification_certificate_number >=", value, "qualificationCertificateNumber");
            return (Criteria) this;
        }

        public Criteria andQualificationCertificateNumberLessThan(String value) {
            addCriterion("qualification_certificate_number <", value, "qualificationCertificateNumber");
            return (Criteria) this;
        }

        public Criteria andQualificationCertificateNumberLessThanOrEqualTo(String value) {
            addCriterion("qualification_certificate_number <=", value, "qualificationCertificateNumber");
            return (Criteria) this;
        }

        public Criteria andQualificationCertificateNumberLike(String value) {
            addCriterion("qualification_certificate_number like", value, "qualificationCertificateNumber");
            return (Criteria) this;
        }

        public Criteria andQualificationCertificateNumberNotLike(String value) {
            addCriterion("qualification_certificate_number not like", value, "qualificationCertificateNumber");
            return (Criteria) this;
        }

        public Criteria andQualificationCertificateNumberIn(List<String> values) {
            addCriterion("qualification_certificate_number in", values, "qualificationCertificateNumber");
            return (Criteria) this;
        }

        public Criteria andQualificationCertificateNumberNotIn(List<String> values) {
            addCriterion("qualification_certificate_number not in", values, "qualificationCertificateNumber");
            return (Criteria) this;
        }

        public Criteria andQualificationCertificateNumberBetween(String value1, String value2) {
            addCriterion("qualification_certificate_number between", value1, value2, "qualificationCertificateNumber");
            return (Criteria) this;
        }

        public Criteria andQualificationCertificateNumberNotBetween(String value1, String value2) {
            addCriterion("qualification_certificate_number not between", value1, value2, "qualificationCertificateNumber");
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