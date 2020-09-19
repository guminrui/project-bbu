package com.bbu.setting.service;

import com.bbu.setting.pojo.TblCourse;
import com.bbu.setting.pojo.TblStudent;
import com.bbu.setting.pojo.TblUser;
import com.bbu.util.ResultPage;


import java.util.List;
import java.util.Map;

public interface TblStudentService {
    /**
     * 查询所有线索信息
     */

    ResultPage queryAll(int pageSize, int pageNo, String name, String classandgrade, String phone);

    void addItem(TblStudent tblStudent);


    TblStudent getByStudentId(String studentId);


    List<TblCourse> getClueRelationActivity(String studentId);

    List<TblCourse> getCourses(String search);


    void addRelation(String[] ids, String studentId);
    Map getByItem(String id);

    void editItem(TblStudent tblStudent );

    void delRelation(String studentId, String courseId);

    void delItem(String[] ids);

}
