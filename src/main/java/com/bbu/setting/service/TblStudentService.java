package com.bbu.setting.service;

import com.bbu.setting.pojo.TblCourse;
import com.bbu.setting.pojo.TblStudent;
import com.bbu.setting.pojo.TblUser;
import com.bbu.util.ResultPage;


import java.util.List;

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


    void delRelation(String studentId, String courseId);
    /*



    *//**
     * 查询市场活动与线索关联
     *//*
    List<TblCourse> getConvertAct(String studentId, String search);

*/
//    /**
//     * 转换按钮
//     */
//    void convert(String createby, String clueId, String money, String tranName, String expecteddate, String stage, String activityId, String flg);
}
