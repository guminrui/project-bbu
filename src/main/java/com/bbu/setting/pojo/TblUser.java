package com.bbu.setting.pojo;

public class TblUser {
    private String id;

    private String loginact;

    private String name;

    private String loginpwd;

    private String phone;

    private String expiretime;

    private String lockstate;

    private String allowips;

    private String createtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLoginact() {
        return loginact;
    }

    public void setLoginact(String loginact) {
        this.loginact = loginact == null ? null : loginact.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLoginpwd() {
        return loginpwd;
    }

    public void setLoginpwd(String loginpwd) {
        this.loginpwd = loginpwd == null ? null : loginpwd.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getExpiretime() {
        return expiretime;
    }

    public void setExpiretime(String expiretime) {
        this.expiretime = expiretime == null ? null : expiretime.trim();
    }

    public String getLockstate() {
        return lockstate;
    }

    public void setLockstate(String lockstate) {
        this.lockstate = lockstate == null ? null : lockstate.trim();
    }

    public String getAllowips() {
        return allowips;
    }

    public void setAllowips(String allowips) {
        this.allowips = allowips == null ? null : allowips.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }
}