package com.bbu.setting.service;

import com.bbu.setting.pojo.TblCourse;
import com.bbu.setting.pojo.TblUser;
import com.bbu.util.ResultPage;

import java.util.List;
import java.util.Map;

public interface TblCourseService {
    List<TblUser> getList();


    void addItem(TblCourse tblCourse);
    ResultPage pageItem(int pageSize, int pageNo, String name,String startdate, String enddate);
    void delItem(String[] ids);
    Map getByItem(String id);
    void editItem(TblCourse tblCourse);
    TblCourse  getItem(String id);
}
