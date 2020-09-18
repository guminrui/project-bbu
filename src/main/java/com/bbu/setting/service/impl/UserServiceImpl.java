package com.bbu.setting.service.impl;


import com.bbu.exception.ResultExecption;
import com.bbu.setting.mapper.TblUserMapper;
import com.bbu.setting.pojo.TblUser;
import com.bbu.setting.pojo.TblUserExample;
import com.bbu.setting.service.UserService;
import com.bbu.util.DateTimeUtil;
import com.bbu.util.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TblUserMapper tblUserMapper;

    @Override
    public TblUser getByUser(TblUser user) {
        TblUserExample userExample = new TblUserExample();
        TblUserExample.Criteria criteria = userExample.createCriteria();
        criteria.andLoginactEqualTo(user.getLoginact());
        List<TblUser> tblUsers1 = tblUserMapper.selectByExample(userExample);
        criteria.andLoginpwdEqualTo(user.getLoginpwd());
        List<TblUser> tblUsers = tblUserMapper.selectByExample(userExample);
      //  System.out.println(user.getLoginact().length()); 这个加上判断可以确定用户名是否为空
        if (tblUsers1.size()==0){
            throw new ResultExecption(ResultEnum.USERNAME_NOT_FOUND);
        }
        if (tblUsers1.size()!=0){
            if (tblUsers.size()==0)
            throw new ResultExecption(ResultEnum.NOT_FOUND);
        }
//        if(tblUsers==null||tblUsers.size()==0){
//            throw new ResultExecption(ResultEnum.NOT_FOUND);
//        }
        TblUser tblUser = tblUsers.get(0);
        if(tblUser.getLoginact()==null){
                throw new ResultExecption(ResultEnum.USER_NOT_FOUND);
        }
   //     if(tblUser.getLoginact()==)
        if (tblUser.getAllowips()!=null){
            if(!tblUser.getAllowips().contains(user.getAllowips())){
                throw new ResultExecption(ResultEnum.USER_IP_LIMIT);
            }
        }
        String systime = DateTimeUtil.systime();
        if (systime.compareTo(tblUser.getExpiretime())>0){
            throw new ResultExecption(ResultEnum.USER_EXPIRETIME);
        }
        if ("0".equals(tblUser.getLockstate())){
            throw new ResultExecption(ResultEnum.USER_LOCK);
        }
        return tblUser;
    }

    @Override
    public void changePwd( TblUser tblUser ,  String newp ,String old) {
        if (!old.equals(tblUser.getLoginpwd())){
            throw new ResultExecption(ResultEnum.FAILED);
        }else {
            tblUser.setLoginpwd(old);
        tblUserMapper.updateByPrimaryKey(tblUser);
        }
    }
}
