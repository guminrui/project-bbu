package com.bbu.setting.controller;


import com.bbu.setting.pojo.TblUser;
import com.bbu.setting.service.UserService;
import com.bbu.util.Result;
import com.bbu.util.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("User")
public class UserController {
        @Autowired
            private UserService userService;

//    @Value("${user_session}")
//    private String USERSESSION;
    @RequestMapping(value = "/login")
    public Result login(TblUser user, HttpServletRequest request){
                user.setAllowips(request.getLocalAddr());
                TblUser byUser = userService.getByUser(user);
                request.getSession().setAttribute("USERSESSION",byUser);
                return Result.OK(byUser);
        }

    @RequestMapping("/byname")
    public Result getLoginByName(HttpSession session){
        TblUser tblUser = (TblUser)session.getAttribute("USERSESSION");
        return Result.OK(tblUser);
    }
    @RequestMapping("/changePwd")
    public Result changePwd(HttpSession session, @RequestParam("old")String old,
                            @RequestParam("newp")String newp){
        TblUser tblUser = (TblUser)session.getAttribute("USERSESSION");
            userService.changePwd(tblUser,newp,old);
            return Result.OK();
        }

    }


