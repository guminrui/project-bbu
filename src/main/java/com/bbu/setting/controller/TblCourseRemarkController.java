package com.bbu.setting.controller;


import com.bbu.setting.pojo.TblCourseRemark;
import com.bbu.setting.pojo.TblUser;
import com.bbu.setting.service.TblCourseRemarkService;
import com.bbu.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/activityRemark")
public class TblCourseRemarkController {
    @Autowired
    private TblCourseRemarkService tblCourseRemarkService;
    @RequestMapping("/remarks")
    public Result queryList(String courseId){
        List<TblCourseRemark> byList = tblCourseRemarkService.getByList(courseId);
        return Result.OK(byList);
    }
    @RequestMapping("/item")
    public Result getById(String remarkId){
        TblCourseRemark iteam = tblCourseRemarkService.getIteam(remarkId);
        return Result.OK(iteam);
    }
    @RequestMapping("/edit")
    public Result editById(TblCourseRemark tblCourseRemark, HttpSession session){
        TblUser usersession = (TblUser) session.getAttribute("USERSESSION");
        tblCourseRemark.setEditby(usersession.getName());
        tblCourseRemarkService.editRemark(tblCourseRemark);
        return Result.OK();
    }

    @RequestMapping("/del")
    public Result delItem(String remarkId){
        tblCourseRemarkService.delItem(remarkId);
        return Result.OK();
    }
    @RequestMapping("/add")
    public Result additem(TblCourseRemark tblCourseRemark, HttpSession session){
        TblUser usersession = (TblUser) session.getAttribute("USERSESSION");
        tblCourseRemark.setCreateby(usersession.getName());
        tblCourseRemarkService.addItem(tblCourseRemark);
        return Result.OK();
    }

}
