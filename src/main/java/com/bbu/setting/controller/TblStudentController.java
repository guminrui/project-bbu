package com.bbu.setting.controller;


import com.bbu.setting.pojo.TblCourse;
import com.bbu.setting.pojo.TblStudent;
import com.bbu.setting.pojo.TblUser;
import com.bbu.setting.service.TblStudentService;
import com.bbu.util.Result;
import com.bbu.util.ResultPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clue")
public class TblStudentController {
    @Autowired
    private TblStudentService tblStudentService;
    @RequestMapping("/queryAll")
    public Result queryAll(int pageSize ,
                           @RequestParam(defaultValue = "1")int pageNo ,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) String classandgrade,
                           @RequestParam(required = false) String phone ){
        System.out.println(pageSize+pageNo+name+classandgrade+phone);
        ResultPage resultPages = null;
        resultPages = tblStudentService.queryAll(pageSize,pageNo, name, classandgrade , phone);
        return Result.OK(resultPages);
    }

    @RequestMapping("/add")
    public Result addClue(TblStudent tblStudent){
        tblStudentService.addItem(tblStudent);
        return Result.OK();
    }
    @RequestMapping("/del")
    public Result pagedel(@RequestParam("ids[]") String[] ids){
        tblStudentService.delItem(ids);
        return Result.OK();
    }

    @RequestMapping("/{id}")
    public Result getActivity(@PathVariable("id") String id){
        Map resutlMap = tblStudentService.getByItem(id);
        return  Result.OK(resutlMap);
    }

    @RequestMapping("/edit")
    public Result edit(TblStudent tblStudent){
        this.tblStudentService.editItem(tblStudent);
        return Result.OK();
    }

    @RequestMapping("/item")
    public Result getItem(String studentId){
        return  Result.OK(tblStudentService.getByStudentId(studentId));
    }
    @RequestMapping("/relation")
    public Result getClueRelationActivity(String studentId){
        return Result.OK(tblStudentService.getClueRelationActivity(studentId));
    }

    @RequestMapping("/activitys")
    public Result getCourses(@RequestParam(value = "search",required = false) String search){
        return Result.OK(tblStudentService.getCourses(search));
    }

    @RequestMapping("/addrelation")
    public Result addRelation(@RequestParam(value = "ids[]") String[] ids,
                              @RequestParam("studentid") String studentid){
        System.out.println("fdsa");
        tblStudentService.addRelation(ids,studentid);
        return Result.OK();
    }
    @RequestMapping("/delrelation")
    public Result delRelation(String studentId, String courseId){
        tblStudentService.delRelation(studentId,courseId);
        return Result.OK();
    }

}
