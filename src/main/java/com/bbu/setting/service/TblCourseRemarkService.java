package com.bbu.setting.service;


import com.bbu.setting.pojo.TblCourseRemark;

import java.util.List;

public interface TblCourseRemarkService {

    List<TblCourseRemark> getByList(String courseId);
    TblCourseRemark getIteam(String remarkId);
    void editRemark(TblCourseRemark tblCourseRemark);
    void delItem(String remarkId);
    void addItem(TblCourseRemark tblCourseRemark);
}
