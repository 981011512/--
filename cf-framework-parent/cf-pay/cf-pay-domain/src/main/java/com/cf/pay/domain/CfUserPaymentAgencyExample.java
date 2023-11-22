package com.cf.pay.domain;

import java.util.ArrayList;
import java.util.List;

public class CfUserPaymentAgencyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CfUserPaymentAgencyExample() {
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

        public Criteria andPayKeyIsNull() {
            addCriterion("pay_key is null");
            return (Criteria) this;
        }

        public Criteria andPayKeyIsNotNull() {
            addCriterion("pay_key is not null");
            return (Criteria) this;
        }

        public Criteria andPayKeyEqualTo(String value) {
            addCriterion("pay_key =", value, "payKey");
            return (Criteria) this;
        }

        public Criteria andPayKeyNotEqualTo(String value) {
            addCriterion("pay_key <>", value, "payKey");
            return (Criteria) this;
        }

        public Criteria andPayKeyGreaterThan(String value) {
            addCriterion("pay_key >", value, "payKey");
            return (Criteria) this;
        }

        public Criteria andPayKeyGreaterThanOrEqualTo(String value) {
            addCriterion("pay_key >=", value, "payKey");
            return (Criteria) this;
        }

        public Criteria andPayKeyLessThan(String value) {
            addCriterion("pay_key <", value, "payKey");
            return (Criteria) this;
        }

        public Criteria andPayKeyLessThanOrEqualTo(String value) {
            addCriterion("pay_key <=", value, "payKey");
            return (Criteria) this;
        }

        public Criteria andPayKeyLike(String value) {
            addCriterion("pay_key like", value, "payKey");
            return (Criteria) this;
        }

        public Criteria andPayKeyNotLike(String value) {
            addCriterion("pay_key not like", value, "payKey");
            return (Criteria) this;
        }

        public Criteria andPayKeyIn(List<String> values) {
            addCriterion("pay_key in", values, "payKey");
            return (Criteria) this;
        }

        public Criteria andPayKeyNotIn(List<String> values) {
            addCriterion("pay_key not in", values, "payKey");
            return (Criteria) this;
        }

        public Criteria andPayKeyBetween(String value1, String value2) {
            addCriterion("pay_key between", value1, value2, "payKey");
            return (Criteria) this;
        }

        public Criteria andPayKeyNotBetween(String value1, String value2) {
            addCriterion("pay_key not between", value1, value2, "payKey");
            return (Criteria) this;
        }

        public Criteria andSecretIsNull() {
            addCriterion("secret is null");
            return (Criteria) this;
        }

        public Criteria andSecretIsNotNull() {
            addCriterion("secret is not null");
            return (Criteria) this;
        }

        public Criteria andSecretEqualTo(String value) {
            addCriterion("secret =", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretNotEqualTo(String value) {
            addCriterion("secret <>", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretGreaterThan(String value) {
            addCriterion("secret >", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretGreaterThanOrEqualTo(String value) {
            addCriterion("secret >=", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretLessThan(String value) {
            addCriterion("secret <", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretLessThanOrEqualTo(String value) {
            addCriterion("secret <=", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretLike(String value) {
            addCriterion("secret like", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretNotLike(String value) {
            addCriterion("secret not like", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretIn(List<String> values) {
            addCriterion("secret in", values, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretNotIn(List<String> values) {
            addCriterion("secret not in", values, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretBetween(String value1, String value2) {
            addCriterion("secret between", value1, value2, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretNotBetween(String value1, String value2) {
            addCriterion("secret not between", value1, value2, "secret");
            return (Criteria) this;
        }

        public Criteria andAppidIsNull() {
            addCriterion("appid is null");
            return (Criteria) this;
        }

        public Criteria andAppidIsNotNull() {
            addCriterion("appid is not null");
            return (Criteria) this;
        }

        public Criteria andAppidEqualTo(String value) {
            addCriterion("appid =", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotEqualTo(String value) {
            addCriterion("appid <>", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThan(String value) {
            addCriterion("appid >", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThanOrEqualTo(String value) {
            addCriterion("appid >=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThan(String value) {
            addCriterion("appid <", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThanOrEqualTo(String value) {
            addCriterion("appid <=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLike(String value) {
            addCriterion("appid like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotLike(String value) {
            addCriterion("appid not like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidIn(List<String> values) {
            addCriterion("appid in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotIn(List<String> values) {
            addCriterion("appid not in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidBetween(String value1, String value2) {
            addCriterion("appid between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotBetween(String value1, String value2) {
            addCriterion("appid not between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andSubAppidIsNull() {
            addCriterion("sub_appid is null");
            return (Criteria) this;
        }

        public Criteria andSubAppidIsNotNull() {
            addCriterion("sub_appid is not null");
            return (Criteria) this;
        }

        public Criteria andSubAppidEqualTo(String value) {
            addCriterion("sub_appid =", value, "subAppid");
            return (Criteria) this;
        }

        public Criteria andSubAppidNotEqualTo(String value) {
            addCriterion("sub_appid <>", value, "subAppid");
            return (Criteria) this;
        }

        public Criteria andSubAppidGreaterThan(String value) {
            addCriterion("sub_appid >", value, "subAppid");
            return (Criteria) this;
        }

        public Criteria andSubAppidGreaterThanOrEqualTo(String value) {
            addCriterion("sub_appid >=", value, "subAppid");
            return (Criteria) this;
        }

        public Criteria andSubAppidLessThan(String value) {
            addCriterion("sub_appid <", value, "subAppid");
            return (Criteria) this;
        }

        public Criteria andSubAppidLessThanOrEqualTo(String value) {
            addCriterion("sub_appid <=", value, "subAppid");
            return (Criteria) this;
        }

        public Criteria andSubAppidLike(String value) {
            addCriterion("sub_appid like", value, "subAppid");
            return (Criteria) this;
        }

        public Criteria andSubAppidNotLike(String value) {
            addCriterion("sub_appid not like", value, "subAppid");
            return (Criteria) this;
        }

        public Criteria andSubAppidIn(List<String> values) {
            addCriterion("sub_appid in", values, "subAppid");
            return (Criteria) this;
        }

        public Criteria andSubAppidNotIn(List<String> values) {
            addCriterion("sub_appid not in", values, "subAppid");
            return (Criteria) this;
        }

        public Criteria andSubAppidBetween(String value1, String value2) {
            addCriterion("sub_appid between", value1, value2, "subAppid");
            return (Criteria) this;
        }

        public Criteria andSubAppidNotBetween(String value1, String value2) {
            addCriterion("sub_appid not between", value1, value2, "subAppid");
            return (Criteria) this;
        }

        public Criteria andAccountNumberNoteIsNull() {
            addCriterion("account_number_note is null");
            return (Criteria) this;
        }

        public Criteria andAccountNumberNoteIsNotNull() {
            addCriterion("account_number_note is not null");
            return (Criteria) this;
        }

        public Criteria andAccountNumberNoteEqualTo(String value) {
            addCriterion("account_number_note =", value, "accountNumberNote");
            return (Criteria) this;
        }

        public Criteria andAccountNumberNoteNotEqualTo(String value) {
            addCriterion("account_number_note <>", value, "accountNumberNote");
            return (Criteria) this;
        }

        public Criteria andAccountNumberNoteGreaterThan(String value) {
            addCriterion("account_number_note >", value, "accountNumberNote");
            return (Criteria) this;
        }

        public Criteria andAccountNumberNoteGreaterThanOrEqualTo(String value) {
            addCriterion("account_number_note >=", value, "accountNumberNote");
            return (Criteria) this;
        }

        public Criteria andAccountNumberNoteLessThan(String value) {
            addCriterion("account_number_note <", value, "accountNumberNote");
            return (Criteria) this;
        }

        public Criteria andAccountNumberNoteLessThanOrEqualTo(String value) {
            addCriterion("account_number_note <=", value, "accountNumberNote");
            return (Criteria) this;
        }

        public Criteria andAccountNumberNoteLike(String value) {
            addCriterion("account_number_note like", value, "accountNumberNote");
            return (Criteria) this;
        }

        public Criteria andAccountNumberNoteNotLike(String value) {
            addCriterion("account_number_note not like", value, "accountNumberNote");
            return (Criteria) this;
        }

        public Criteria andAccountNumberNoteIn(List<String> values) {
            addCriterion("account_number_note in", values, "accountNumberNote");
            return (Criteria) this;
        }

        public Criteria andAccountNumberNoteNotIn(List<String> values) {
            addCriterion("account_number_note not in", values, "accountNumberNote");
            return (Criteria) this;
        }

        public Criteria andAccountNumberNoteBetween(String value1, String value2) {
            addCriterion("account_number_note between", value1, value2, "accountNumberNote");
            return (Criteria) this;
        }

        public Criteria andAccountNumberNoteNotBetween(String value1, String value2) {
            addCriterion("account_number_note not between", value1, value2, "accountNumberNote");
            return (Criteria) this;
        }

        public Criteria andMchIdIsNull() {
            addCriterion("mch_id is null");
            return (Criteria) this;
        }

        public Criteria andMchIdIsNotNull() {
            addCriterion("mch_id is not null");
            return (Criteria) this;
        }

        public Criteria andMchIdEqualTo(String value) {
            addCriterion("mch_id =", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotEqualTo(String value) {
            addCriterion("mch_id <>", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdGreaterThan(String value) {
            addCriterion("mch_id >", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdGreaterThanOrEqualTo(String value) {
            addCriterion("mch_id >=", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLessThan(String value) {
            addCriterion("mch_id <", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLessThanOrEqualTo(String value) {
            addCriterion("mch_id <=", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLike(String value) {
            addCriterion("mch_id like", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotLike(String value) {
            addCriterion("mch_id not like", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdIn(List<String> values) {
            addCriterion("mch_id in", values, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotIn(List<String> values) {
            addCriterion("mch_id not in", values, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdBetween(String value1, String value2) {
            addCriterion("mch_id between", value1, value2, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotBetween(String value1, String value2) {
            addCriterion("mch_id not between", value1, value2, "mchId");
            return (Criteria) this;
        }

        public Criteria andSubMchIdIsNull() {
            addCriterion("sub_mch_id is null");
            return (Criteria) this;
        }

        public Criteria andSubMchIdIsNotNull() {
            addCriterion("sub_mch_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubMchIdEqualTo(String value) {
            addCriterion("sub_mch_id =", value, "subMchId");
            return (Criteria) this;
        }

        public Criteria andSubMchIdNotEqualTo(String value) {
            addCriterion("sub_mch_id <>", value, "subMchId");
            return (Criteria) this;
        }

        public Criteria andSubMchIdGreaterThan(String value) {
            addCriterion("sub_mch_id >", value, "subMchId");
            return (Criteria) this;
        }

        public Criteria andSubMchIdGreaterThanOrEqualTo(String value) {
            addCriterion("sub_mch_id >=", value, "subMchId");
            return (Criteria) this;
        }

        public Criteria andSubMchIdLessThan(String value) {
            addCriterion("sub_mch_id <", value, "subMchId");
            return (Criteria) this;
        }

        public Criteria andSubMchIdLessThanOrEqualTo(String value) {
            addCriterion("sub_mch_id <=", value, "subMchId");
            return (Criteria) this;
        }

        public Criteria andSubMchIdLike(String value) {
            addCriterion("sub_mch_id like", value, "subMchId");
            return (Criteria) this;
        }

        public Criteria andSubMchIdNotLike(String value) {
            addCriterion("sub_mch_id not like", value, "subMchId");
            return (Criteria) this;
        }

        public Criteria andSubMchIdIn(List<String> values) {
            addCriterion("sub_mch_id in", values, "subMchId");
            return (Criteria) this;
        }

        public Criteria andSubMchIdNotIn(List<String> values) {
            addCriterion("sub_mch_id not in", values, "subMchId");
            return (Criteria) this;
        }

        public Criteria andSubMchIdBetween(String value1, String value2) {
            addCriterion("sub_mch_id between", value1, value2, "subMchId");
            return (Criteria) this;
        }

        public Criteria andSubMchIdNotBetween(String value1, String value2) {
            addCriterion("sub_mch_id not between", value1, value2, "subMchId");
            return (Criteria) this;
        }

        public Criteria andCertPathIsNull() {
            addCriterion("cert_path is null");
            return (Criteria) this;
        }

        public Criteria andCertPathIsNotNull() {
            addCriterion("cert_path is not null");
            return (Criteria) this;
        }

        public Criteria andCertPathEqualTo(String value) {
            addCriterion("cert_path =", value, "certPath");
            return (Criteria) this;
        }

        public Criteria andCertPathNotEqualTo(String value) {
            addCriterion("cert_path <>", value, "certPath");
            return (Criteria) this;
        }

        public Criteria andCertPathGreaterThan(String value) {
            addCriterion("cert_path >", value, "certPath");
            return (Criteria) this;
        }

        public Criteria andCertPathGreaterThanOrEqualTo(String value) {
            addCriterion("cert_path >=", value, "certPath");
            return (Criteria) this;
        }

        public Criteria andCertPathLessThan(String value) {
            addCriterion("cert_path <", value, "certPath");
            return (Criteria) this;
        }

        public Criteria andCertPathLessThanOrEqualTo(String value) {
            addCriterion("cert_path <=", value, "certPath");
            return (Criteria) this;
        }

        public Criteria andCertPathLike(String value) {
            addCriterion("cert_path like", value, "certPath");
            return (Criteria) this;
        }

        public Criteria andCertPathNotLike(String value) {
            addCriterion("cert_path not like", value, "certPath");
            return (Criteria) this;
        }

        public Criteria andCertPathIn(List<String> values) {
            addCriterion("cert_path in", values, "certPath");
            return (Criteria) this;
        }

        public Criteria andCertPathNotIn(List<String> values) {
            addCriterion("cert_path not in", values, "certPath");
            return (Criteria) this;
        }

        public Criteria andCertPathBetween(String value1, String value2) {
            addCriterion("cert_path between", value1, value2, "certPath");
            return (Criteria) this;
        }

        public Criteria andCertPathNotBetween(String value1, String value2) {
            addCriterion("cert_path not between", value1, value2, "certPath");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlIsNull() {
            addCriterion("pay_notify_url is null");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlIsNotNull() {
            addCriterion("pay_notify_url is not null");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlEqualTo(String value) {
            addCriterion("pay_notify_url =", value, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlNotEqualTo(String value) {
            addCriterion("pay_notify_url <>", value, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlGreaterThan(String value) {
            addCriterion("pay_notify_url >", value, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlGreaterThanOrEqualTo(String value) {
            addCriterion("pay_notify_url >=", value, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlLessThan(String value) {
            addCriterion("pay_notify_url <", value, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlLessThanOrEqualTo(String value) {
            addCriterion("pay_notify_url <=", value, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlLike(String value) {
            addCriterion("pay_notify_url like", value, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlNotLike(String value) {
            addCriterion("pay_notify_url not like", value, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlIn(List<String> values) {
            addCriterion("pay_notify_url in", values, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlNotIn(List<String> values) {
            addCriterion("pay_notify_url not in", values, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlBetween(String value1, String value2) {
            addCriterion("pay_notify_url between", value1, value2, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlNotBetween(String value1, String value2) {
            addCriterion("pay_notify_url not between", value1, value2, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andRefundPayNotifyUrlIsNull() {
            addCriterion("refund_pay_notify_url is null");
            return (Criteria) this;
        }

        public Criteria andRefundPayNotifyUrlIsNotNull() {
            addCriterion("refund_pay_notify_url is not null");
            return (Criteria) this;
        }

        public Criteria andRefundPayNotifyUrlEqualTo(String value) {
            addCriterion("refund_pay_notify_url =", value, "refundPayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andRefundPayNotifyUrlNotEqualTo(String value) {
            addCriterion("refund_pay_notify_url <>", value, "refundPayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andRefundPayNotifyUrlGreaterThan(String value) {
            addCriterion("refund_pay_notify_url >", value, "refundPayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andRefundPayNotifyUrlGreaterThanOrEqualTo(String value) {
            addCriterion("refund_pay_notify_url >=", value, "refundPayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andRefundPayNotifyUrlLessThan(String value) {
            addCriterion("refund_pay_notify_url <", value, "refundPayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andRefundPayNotifyUrlLessThanOrEqualTo(String value) {
            addCriterion("refund_pay_notify_url <=", value, "refundPayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andRefundPayNotifyUrlLike(String value) {
            addCriterion("refund_pay_notify_url like", value, "refundPayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andRefundPayNotifyUrlNotLike(String value) {
            addCriterion("refund_pay_notify_url not like", value, "refundPayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andRefundPayNotifyUrlIn(List<String> values) {
            addCriterion("refund_pay_notify_url in", values, "refundPayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andRefundPayNotifyUrlNotIn(List<String> values) {
            addCriterion("refund_pay_notify_url not in", values, "refundPayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andRefundPayNotifyUrlBetween(String value1, String value2) {
            addCriterion("refund_pay_notify_url between", value1, value2, "refundPayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andRefundPayNotifyUrlNotBetween(String value1, String value2) {
            addCriterion("refund_pay_notify_url not between", value1, value2, "refundPayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andUseScenesIsNull() {
            addCriterion("use_scenes is null");
            return (Criteria) this;
        }

        public Criteria andUseScenesIsNotNull() {
            addCriterion("use_scenes is not null");
            return (Criteria) this;
        }

        public Criteria andUseScenesEqualTo(String value) {
            addCriterion("use_scenes =", value, "useScenes");
            return (Criteria) this;
        }

        public Criteria andUseScenesNotEqualTo(String value) {
            addCriterion("use_scenes <>", value, "useScenes");
            return (Criteria) this;
        }

        public Criteria andUseScenesGreaterThan(String value) {
            addCriterion("use_scenes >", value, "useScenes");
            return (Criteria) this;
        }

        public Criteria andUseScenesGreaterThanOrEqualTo(String value) {
            addCriterion("use_scenes >=", value, "useScenes");
            return (Criteria) this;
        }

        public Criteria andUseScenesLessThan(String value) {
            addCriterion("use_scenes <", value, "useScenes");
            return (Criteria) this;
        }

        public Criteria andUseScenesLessThanOrEqualTo(String value) {
            addCriterion("use_scenes <=", value, "useScenes");
            return (Criteria) this;
        }

        public Criteria andUseScenesLike(String value) {
            addCriterion("use_scenes like", value, "useScenes");
            return (Criteria) this;
        }

        public Criteria andUseScenesNotLike(String value) {
            addCriterion("use_scenes not like", value, "useScenes");
            return (Criteria) this;
        }

        public Criteria andUseScenesIn(List<String> values) {
            addCriterion("use_scenes in", values, "useScenes");
            return (Criteria) this;
        }

        public Criteria andUseScenesNotIn(List<String> values) {
            addCriterion("use_scenes not in", values, "useScenes");
            return (Criteria) this;
        }

        public Criteria andUseScenesBetween(String value1, String value2) {
            addCriterion("use_scenes between", value1, value2, "useScenes");
            return (Criteria) this;
        }

        public Criteria andUseScenesNotBetween(String value1, String value2) {
            addCriterion("use_scenes not between", value1, value2, "useScenes");
            return (Criteria) this;
        }

        public Criteria andAuthTokenIsNull() {
            addCriterion("auth_token is null");
            return (Criteria) this;
        }

        public Criteria andAuthTokenIsNotNull() {
            addCriterion("auth_token is not null");
            return (Criteria) this;
        }

        public Criteria andAuthTokenEqualTo(String value) {
            addCriterion("auth_token =", value, "authToken");
            return (Criteria) this;
        }

        public Criteria andAuthTokenNotEqualTo(String value) {
            addCriterion("auth_token <>", value, "authToken");
            return (Criteria) this;
        }

        public Criteria andAuthTokenGreaterThan(String value) {
            addCriterion("auth_token >", value, "authToken");
            return (Criteria) this;
        }

        public Criteria andAuthTokenGreaterThanOrEqualTo(String value) {
            addCriterion("auth_token >=", value, "authToken");
            return (Criteria) this;
        }

        public Criteria andAuthTokenLessThan(String value) {
            addCriterion("auth_token <", value, "authToken");
            return (Criteria) this;
        }

        public Criteria andAuthTokenLessThanOrEqualTo(String value) {
            addCriterion("auth_token <=", value, "authToken");
            return (Criteria) this;
        }

        public Criteria andAuthTokenLike(String value) {
            addCriterion("auth_token like", value, "authToken");
            return (Criteria) this;
        }

        public Criteria andAuthTokenNotLike(String value) {
            addCriterion("auth_token not like", value, "authToken");
            return (Criteria) this;
        }

        public Criteria andAuthTokenIn(List<String> values) {
            addCriterion("auth_token in", values, "authToken");
            return (Criteria) this;
        }

        public Criteria andAuthTokenNotIn(List<String> values) {
            addCriterion("auth_token not in", values, "authToken");
            return (Criteria) this;
        }

        public Criteria andAuthTokenBetween(String value1, String value2) {
            addCriterion("auth_token between", value1, value2, "authToken");
            return (Criteria) this;
        }

        public Criteria andAuthTokenNotBetween(String value1, String value2) {
            addCriterion("auth_token not between", value1, value2, "authToken");
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