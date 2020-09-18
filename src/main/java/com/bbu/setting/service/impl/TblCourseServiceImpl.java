package com.bbu.setting.service.impl;

import com.bbu.exception.ResultExecption;
import com.bbu.setting.mapper.TblCourseMapper;
import com.bbu.setting.mapper.TblUserMapper;
import com.bbu.setting.pojo.TblCourse;
import com.bbu.setting.pojo.TblCourseExample;
import com.bbu.setting.pojo.TblUser;
import com.bbu.setting.pojo.TblUserExample;
import com.bbu.setting.service.TblCourseService;
import com.bbu.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TblCourseServiceImpl implements TblCourseService {
    @Autowired
    private TblUserMapper tblUserMapper;

    @Autowired
    private TblCourseMapper tblCourseMapper;
    @Override
    public List<TblUser> getList() {
        List<TblUser> tblUsers = tblUserMapper.selectByExample(null);
        if (tblUsers==null || tblUsers.size()==0){
            throw new ResultExecption(ResultEnum.NOT_FOUND);
        }
        return tblUsers;
    }

    @Override
    public void addItem(TblCourse tblCourse) {
        String creattime = DateTimeUtil.systime();
        tblCourse.setCreatetime(creattime);
        tblCourse.setId(UUIDUtil.getUUID());
            tblCourseMapper.insertSelective(tblCourse);
    }
    @Override
        public ResultPage pageItem(int pageSize, int pageNo, String name, String owner, String startdate, String enddate){
            TblCourseExample tblCourseExample = new TblCourseExample();
            TblCourseExample.Criteria criteria = tblCourseExample.createCriteria();
            if (name!=null&&!"".equals(name)){
                criteria.andCoursenameLike("%"+name+"%");
            }
//            if (owner!=null&&!"".equals(owner)){
//                TblUserExample tblUserExample = new TblUserExample();
//                TblUserExample.Criteria criteria1 = tblUserExample.createCriteria();
//                criteria1.andNameLike("%"+owner+"%");
//                //获取指定名称通过条件查询
//                List<TblUser> tblUsers = tblUserMapper.selectByExample(tblUserExample);
//                List<String> ids = new ArrayList<String>();
//                if (tblUsers == null || tblUsers.size() == 0) {
//                    throw new ResultExecption(ResultEnum.NOT_FOUND);
//                }
//                //得到ID之后遍历到集合中
//                for (TblUser tblUser : tblUsers) {
//                    ids.add(tblUser.getId());
//                }
//                //查询出来的结果放在活动表中（在Owner中有的在放）
//                criteria.andOwnerIn(ids);
//            }
            //判断开始时间
            if (startdate!=null&&!"".equals(startdate)){
                criteria.andStartdateLike("%"+startdate+"%");
            }
            //判断结束时间
            if (enddate!=null&&!"".equals(enddate)){
                criteria.andEnddateLike("%"+enddate+"%");
            }
            //把前台的分页拿到这里
        PageHelper.startPage(pageNo,pageSize);

            //把封装好的条件放在条件查询中进行查询
        List<TblCourse> tblCourses = tblCourseMapper.selectByExample(tblCourseExample);
//            if (Utils.isListNull(tblCourses)){
//                throw new ResultExecption(ResultEnum.FILE_NOT_FOUND);
//            }
//        for (TblCourse tblCourse : tblCourses) {
//            //把条件放在这里，进行插入。对tblActivities结果进行封装
//            TblUser tblUser = tblUserMapper.selectByPrimaryKey(tblCourse.getOwner());
//            tblActivity.setOwner(tblUser.getName());
//        }
        PageInfo<TblCourse> pageInfo = new PageInfo<TblCourse>(tblCourses);
        ResultPage<TblCourse> tblCourseResultPage = new ResultPage<TblCourse>();
        tblCourseResultPage.setRows(pageInfo.getList());
        tblCourseResultPage.setPage(pageInfo.getTotal());
        return tblCourseResultPage;

    }

    @Override
    public void delItem(String[] ids) {
    if (ids==null){
            throw new ResultExecption(ResultEnum.PARAM_ERROR);
        }
        List<String> strings = Arrays.asList(ids);
        TblCourseExample tblCourseExample = new TblCourseExample();
        TblCourseExample.Criteria criteria = tblCourseExample.createCriteria();
        criteria.andIdIn(strings);
        try {
            tblCourseMapper.deleteByExample(tblCourseExample);
        } catch (Exception e) {
            throw new ResultExecption(ResultEnum.PARAM_ERROR);
        }
    }

    @Override
    public Map getByItem(String id) {
        TblCourse tblCourse = tblCourseMapper.selectByPrimaryKey(id);
        if (tblCourse == null){
            throw new ResultExecption(ResultEnum.NOT_FOUND);
        }
//        List<TblUser> tblUsers = tblUserMapper.selectByExample(null);
//        if (Utils.isListNull(tblUsers)){
//            throw new ResultExecption(ResultEnum.NOT_FOUND);
//        }
        Map map = new HashMap();
//        map.put("users",tblUsers);
        map.put("act",tblCourse);

        return map;
    }

    @Override
    public void editItem(TblCourse tblCourse) {
        tblCourse.setEdittime(DateTimeUtil.systime());
        try {
            tblCourseMapper.updateByPrimaryKeySelective(tblCourse);
        } catch (Exception e) {
            throw new ResultExecption(ResultEnum.FAILED);
        }
    }

    @Override
    public TblCourse getItem(String id) {

        TblCourse tblCourse = tblCourseMapper.selectByPrimaryKey(id);
        if (tblCourse==null){
            throw new ResultExecption(ResultEnum.NOT_FOUND);
        }else{
//            TblUser tblUser = tblUserMapper.selectByPrimaryKey(tblCourse.getOwner());
//            if (tblUser==null){
//                throw new ResultExecption(ResultEnum.NOT_FOUND);
//            }else{
//                tblCourse.setOwner(tblUser.getName());
                return tblCourse;
        }
    }
}
