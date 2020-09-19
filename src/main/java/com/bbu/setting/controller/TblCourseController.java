package com.bbu.setting.controller;


import com.bbu.setting.pojo.TblCourse;
import com.bbu.setting.pojo.TblUser;
import com.bbu.setting.service.impl.TblCourseServiceImpl;
import com.bbu.util.Result;
import com.bbu.util.ResultPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/activity")
public class TblCourseController {
    @Autowired
    private TblCourseServiceImpl tblCourseService;
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public Result getByUser(){
            List<TblUser> list = tblCourseService.getList();
            return Result.OK(list);
    }
    @RequestMapping("/add")
    public Result addActivity(@RequestBody TblCourse tblCourse){
        tblCourseService.addItem(tblCourse);
            return  Result.OK();
    }
    @RequestMapping("/page")
    public Result pageList(int pageSize ,
                           @RequestParam(defaultValue = "1")int pageNo ,
                           @RequestParam(value = "name" , required = false) String name ,
                           @RequestParam(value = "stardate" , required = false) String stardate ,
                           @RequestParam(value = "enddate" , required = false) String enddate){
        ResultPage resultPage = null;
            resultPage = tblCourseService.pageItem(pageSize, pageNo, name,  stardate, enddate);
       //     System.out.println(resultPage);
            return Result.OK(resultPage);
    }
    @RequestMapping("/del")
    public Result pagedel(@RequestParam("ids[]") String[] ids){
        tblCourseService.delItem(ids);
        return Result.OK();
    }

    @RequestMapping("/{id}")
    public Result getActivity(@PathVariable("id") String id){
        Map resutlMap = tblCourseService.getByItem(id);
        return  Result.OK(resutlMap);
    }

    @RequestMapping("/edit")
    public Result edit(TblCourse tblCourse, HttpSession session){
        this.tblCourseService.editItem(tblCourse);
        return Result.OK();
    }

    @RequestMapping("/item")
    public Result item(String id){
        TblCourse item = tblCourseService.getItem(id);
        return Result.OK(item);
    }

}

