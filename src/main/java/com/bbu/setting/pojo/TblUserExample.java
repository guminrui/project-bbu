package com.bbu.setting.pojo;

import java.util.ArrayList;
import java.util.List;

public class TblUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblUserExample() {
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

        public Criteria andLoginactIsNull() {
            addCriterion("loginAct is null");
            return (Criteria) this;
        }

        public Criteria andLoginactIsNotNull() {
            addCriterion("loginAct is not null");
            return (Criteria) this;
        }

        public Criteria andLoginactEqualTo(String value) {
            addCriterion("loginAct =", value, "loginact");
            return (Criteria) this;
        }

        public Criteria andLoginactNotEqualTo(String value) {
            addCriterion("loginAct <>", value, "loginact");
            return (Criteria) this;
        }

        public Criteria andLoginactGreaterThan(String value) {
            addCriterion("loginAct >", value, "loginact");
            return (Criteria) this;
        }

        public Criteria andLoginactGreaterThanOrEqualTo(String value) {
            addCriterion("loginAct >=", value, "loginact");
            return (Criteria) this;
        }

        public Criteria andLoginactLessThan(String value) {
            addCriterion("loginAct <", value, "loginact");
            return (Criteria) this;
        }

        public Criteria andLoginactLessThanOrEqualTo(String value) {
            addCriterion("loginAct <=", value, "loginact");
            return (Criteria) this;
        }

        public Criteria andLoginactLike(String value) {
            addCriterion("loginAct like", value, "loginact");
            return (Criteria) this;
        }

        public Criteria andLoginactNotLike(String value) {
            addCriterion("loginAct not like", value, "loginact");
            return (Criteria) this;
        }

        public Criteria andLoginactIn(List<String> values) {
            addCriterion("loginAct in", values, "loginact");
            return (Criteria) this;
        }

        public Criteria andLoginactNotIn(List<String> values) {
            addCriterion("loginAct not in", values, "loginact");
            return (Criteria) this;
        }

        public Criteria andLoginactBetween(String value1, String value2) {
            addCriterion("loginAct between", value1, value2, "loginact");
            return (Criteria) this;
        }

        public Criteria andLoginactNotBetween(String value1, String value2) {
            addCriterion("loginAct not between", value1, value2, "loginact");
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

        public Criteria andLoginpwdIsNull() {
            addCriterion("loginPwd is null");
            return (Criteria) this;
        }

        public Criteria andLoginpwdIsNotNull() {
            addCriterion("loginPwd is not null");
            return (Criteria) this;
        }

        public Criteria andLoginpwdEqualTo(String value) {
            addCriterion("loginPwd =", value, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdNotEqualTo(String value) {
            addCriterion("loginPwd <>", value, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdGreaterThan(String value) {
            addCriterion("loginPwd >", value, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdGreaterThanOrEqualTo(String value) {
            addCriterion("loginPwd >=", value, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdLessThan(String value) {
            addCriterion("loginPwd <", value, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdLessThanOrEqualTo(String value) {
            addCriterion("loginPwd <=", value, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdLike(String value) {
            addCriterion("loginPwd like", value, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdNotLike(String value) {
            addCriterion("loginPwd not like", value, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdIn(List<String> values) {
            addCriterion("loginPwd in", values, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdNotIn(List<String> values) {
            addCriterion("loginPwd not in", values, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdBetween(String value1, String value2) {
            addCriterion("loginPwd between", value1, value2, "loginpwd");
            return (Criteria) this;
        }

        public Criteria andLoginpwdNotBetween(String value1, String value2) {
            addCriterion("loginPwd not between", value1, value2, "loginpwd");
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

        public Criteria andExpiretimeIsNull() {
            addCriterion("expireTime is null");
            return (Criteria) this;
        }

        public Criteria andExpiretimeIsNotNull() {
            addCriterion("expireTime is not null");
            return (Criteria) this;
        }

        public Criteria andExpiretimeEqualTo(String value) {
            addCriterion("expireTime =", value, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeNotEqualTo(String value) {
            addCriterion("expireTime <>", value, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeGreaterThan(String value) {
            addCriterion("expireTime >", value, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeGreaterThanOrEqualTo(String value) {
            addCriterion("expireTime >=", value, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeLessThan(String value) {
            addCriterion("expireTime <", value, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeLessThanOrEqualTo(String value) {
            addCriterion("expireTime <=", value, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeLike(String value) {
            addCriterion("expireTime like", value, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeNotLike(String value) {
            addCriterion("expireTime not like", value, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeIn(List<String> values) {
            addCriterion("expireTime in", values, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeNotIn(List<String> values) {
            addCriterion("expireTime not in", values, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeBetween(String value1, String value2) {
            addCriterion("expireTime between", value1, value2, "expiretime");
            return (Criteria) this;
        }

        public Criteria andExpiretimeNotBetween(String value1, String value2) {
            addCriterion("expireTime not between", value1, value2, "expiretime");
            return (Criteria) this;
        }

        public Criteria andLockstateIsNull() {
            addCriterion("lockState is null");
            return (Criteria) this;
        }

        public Criteria andLockstateIsNotNull() {
            addCriterion("lockState is not null");
            return (Criteria) this;
        }

        public Criteria andLockstateEqualTo(String value) {
            addCriterion("lockState =", value, "lockstate");
            return (Criteria) this;
        }

        public Criteria andLockstateNotEqualTo(String value) {
            addCriterion("lockState <>", value, "lockstate");
            return (Criteria) this;
        }

        public Criteria andLockstateGreaterThan(String value) {
            addCriterion("lockState >", value, "lockstate");
            return (Criteria) this;
        }

        public Criteria andLockstateGreaterThanOrEqualTo(String value) {
            addCriterion("lockState >=", value, "lockstate");
            return (Criteria) this;
        }

        public Criteria andLockstateLessThan(String value) {
            addCriterion("lockState <", value, "lockstate");
            return (Criteria) this;
        }

        public Criteria andLockstateLessThanOrEqualTo(String value) {
            addCriterion("lockState <=", value, "lockstate");
            return (Criteria) this;
        }

        public Criteria andLockstateLike(String value) {
            addCriterion("lockState like", value, "lockstate");
            return (Criteria) this;
        }

        public Criteria andLockstateNotLike(String value) {
            addCriterion("lockState not like", value, "lockstate");
            return (Criteria) this;
        }

        public Criteria andLockstateIn(List<String> values) {
            addCriterion("lockState in", values, "lockstate");
            return (Criteria) this;
        }

        public Criteria andLockstateNotIn(List<String> values) {
            addCriterion("lockState not in", values, "lockstate");
            return (Criteria) this;
        }

        public Criteria andLockstateBetween(String value1, String value2) {
            addCriterion("lockState between", value1, value2, "lockstate");
            return (Criteria) this;
        }

        public Criteria andLockstateNotBetween(String value1, String value2) {
            addCriterion("lockState not between", value1, value2, "lockstate");
            return (Criteria) this;
        }

        public Criteria andAllowipsIsNull() {
            addCriterion("allowIps is null");
            return (Criteria) this;
        }

        public Criteria andAllowipsIsNotNull() {
            addCriterion("allowIps is not null");
            return (Criteria) this;
        }

        public Criteria andAllowipsEqualTo(String value) {
            addCriterion("allowIps =", value, "allowips");
            return (Criteria) this;
        }

        public Criteria andAllowipsNotEqualTo(String value) {
            addCriterion("allowIps <>", value, "allowips");
            return (Criteria) this;
        }

        public Criteria andAllowipsGreaterThan(String value) {
            addCriterion("allowIps >", value, "allowips");
            return (Criteria) this;
        }

        public Criteria andAllowipsGreaterThanOrEqualTo(String value) {
            addCriterion("allowIps >=", value, "allowips");
            return (Criteria) this;
        }

        public Criteria andAllowipsLessThan(String value) {
            addCriterion("allowIps <", value, "allowips");
            return (Criteria) this;
        }

        public Criteria andAllowipsLessThanOrEqualTo(String value) {
            addCriterion("allowIps <=", value, "allowips");
            return (Criteria) this;
        }

        public Criteria andAllowipsLike(String value) {
            addCriterion("allowIps like", value, "allowips");
            return (Criteria) this;
        }

        public Criteria andAllowipsNotLike(String value) {
            addCriterion("allowIps not like", value, "allowips");
            return (Criteria) this;
        }

        public Criteria andAllowipsIn(List<String> values) {
            addCriterion("allowIps in", values, "allowips");
            return (Criteria) this;
        }

        public Criteria andAllowipsNotIn(List<String> values) {
            addCriterion("allowIps not in", values, "allowips");
            return (Criteria) this;
        }

        public Criteria andAllowipsBetween(String value1, String value2) {
            addCriterion("allowIps between", value1, value2, "allowips");
            return (Criteria) this;
        }

        public Criteria andAllowipsNotBetween(String value1, String value2) {
            addCriterion("allowIps not between", value1, value2, "allowips");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(String value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(String value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(String value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(String value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLike(String value) {
            addCriterion("createTime like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotLike(String value) {
            addCriterion("createTime not like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<String> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<String> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(String value1, String value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(String value1, String value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
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