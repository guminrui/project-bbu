package com.bbu.setting.service;

import com.bbu.setting.pojo.TblUser;

import javax.servlet.http.HttpSession;

public interface UserService {
    TblUser getByUser(TblUser user);
    void  changePwd(TblUser tblUser , String newp,String old);
}
