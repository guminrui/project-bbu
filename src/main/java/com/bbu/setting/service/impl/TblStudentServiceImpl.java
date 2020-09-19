package com.bbu.setting.service.impl;

import com.bbu.exception.ResultExecption;
import com.bbu.setting.mapper.TblCourseMapper;
import com.bbu.setting.mapper.TblCourseStudentRelationMapper;
import com.bbu.setting.mapper.TblStudentMapper;
import com.bbu.setting.mapper.TblUserMapper;
import com.bbu.setting.pojo.*;
import com.bbu.setting.service.TblStudentService;
import com.bbu.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TblStudentServiceImpl implements TblStudentService {

    @Autowired
    private TblUserMapper userMapper;

    @Autowired
    private TblStudentMapper tblStudentMapper;

    @Autowired
    private TblCourseMapper tblCourseMapper;

    @Autowired
    private TblCourseStudentRelationMapper tblCourseStudentRelationMapper;


    @Override
    public ResultPage queryAll(int pageSize, int pageNo,String name, String classandgrade , String phone) {

        TblStudentExample tblStudentExample = new TblStudentExample();
        TblStudentExample.Criteria criteria = tblStudentExample.createCriteria();
        if (name!=null &&!"".equals(name)){
            criteria.andNameLike("%"+name+"%");
        }
        if (classandgrade!=null &&!"".equals(classandgrade)){
            criteria.andClassandgradeLike("%"+classandgrade+"%");
        }
        if (phone!=null &&!"".equals(phone)){
            criteria.andPhoneLike('%'+phone+'%');
        }
        PageHelper.startPage(pageNo,pageSize);
        List<TblStudent> tblStudents = tblStudentMapper.selectByExample(tblStudentExample);

        PageInfo<TblStudent> pageInfo = new PageInfo<TblStudent>(tblStudents);
        ResultPage<TblStudent> tblStudentResultPage = new ResultPage<TblStudent>();
        tblStudentResultPage.setRows(pageInfo.getList());
        tblStudentResultPage.setPage(pageInfo.getTotal());
        return tblStudentResultPage;

    }

    @Override
    public void addItem(TblStudent tblStudent) {
        tblStudent.setId(UUIDUtil.getUUID());
        tblStudent.setCreatetime(DateTimeUtil.systime());
        try {
            tblStudentMapper.insertSelective(tblStudent);
        } catch (Exception e) {
            throw new ResultExecption(ResultEnum.FAILED);
        }
    }

    @Override
    public void delItem(String[] ids) {
        if (ids==null){
            throw new ResultExecption(ResultEnum.PARAM_ERROR);
        }
        List<String> strings = Arrays.asList(ids);
        TblStudentExample tblStudentExample = new TblStudentExample();
        TblStudentExample.Criteria criteria = tblStudentExample.createCriteria();
        criteria.andIdIn(strings);
        try {
            tblStudentMapper.deleteByExample(tblStudentExample);
        } catch (Exception e) {
            throw new ResultExecption(ResultEnum.PARAM_ERROR);
        }
    }

    @Override
    public Map getByItem(String id) {
        TblStudent tblStudent = tblStudentMapper.selectByPrimaryKey(id);
        if (tblStudent == null){
            throw new ResultExecption(ResultEnum.NOT_FOUND);
        }
        Map map = new HashMap();
        map.put("act",tblStudent);

        return map;
    }
    @Override
    public void editItem(TblStudent tblStudent) {
        tblStudent.setEdittime(DateTimeUtil.systime());
        try {
            tblStudentMapper.updateByPrimaryKeySelective(tblStudent);
        } catch (Exception e) {
            throw new ResultExecption(ResultEnum.FAILED);
        }
    }






    @Override
    public TblStudent getByStudentId(String studentId) {
        TblStudent tblStudent = tblStudentMapper.selectByPrimaryKey(studentId);
        if (tblStudent==null){
            throw new ResultExecption(ResultEnum.NOT_FOUND);
        }

        return tblStudent;
    }
    @Override
    public List<TblCourse> getClueRelationActivity(String studentId) {
        //1.根据线索id去查询中间表
        TblCourseStudentRelationExample tblCourseStudentRelationExample = new TblCourseStudentRelationExample();
        TblCourseStudentRelationExample.Criteria relationExampleCriteria = tblCourseStudentRelationExample.createCriteria();
        relationExampleCriteria.andClueidEqualTo(studentId);
        List<TblCourseStudentRelation> tblCourseStudentRelations = tblCourseStudentRelationMapper.selectByExample(tblCourseStudentRelationExample);
        if (Utils.isListNull(tblCourseStudentRelations)){
            throw new ResultExecption(ResultEnum.NOT_FOUND);
        }
        //2.根据中间表对象获取市场活动的id值
        List<TblCourse> activities = new ArrayList<TblCourse>();
        for (TblCourseStudentRelation tblCourseStudentRelation : tblCourseStudentRelations) {
            //3.根据市场活动id，查询市场活动
            TblCourse tblCourse = tblCourseMapper.selectByPrimaryKey(tblCourseStudentRelation.getActivityid());

            activities.add(tblCourse);
        }
        return activities;
    }
    @Override
    public List<TblCourse> getCourses(String search) {
        TblCourseExample tblCourseExample = new TblCourseExample();
        TblCourseExample.Criteria criteria = tblCourseExample.createCriteria();
        if (search !=null && !"".equals(search)){
            criteria.andCoursenameLike("%"+search+"%");
        }
        List<TblCourse> activities = tblCourseMapper.selectByExample(tblCourseExample);
        if (Utils.isListNull(activities)){
            throw new ResultExecption(ResultEnum.NOT_FOUND);
        }

        return activities;
    }

    @Override
    public void addRelation(String[] ids, String studentId) {
        if (ids !=null){
            for (String courseId : ids) {
                TblCourseStudentRelation tblCourseStudentRelation = new TblCourseStudentRelation();
                tblCourseStudentRelation.setId(UUIDUtil.getUUID());
                tblCourseStudentRelation.setClueid(studentId);
                tblCourseStudentRelation.setActivityid(courseId);
                tblCourseStudentRelationMapper.insert(tblCourseStudentRelation);
            }
        }

    }

    @Override
    public void delRelation(String studentId, String courseId) {
        TblCourseStudentRelationExample tblCourseStudentRelationExample = new TblCourseStudentRelationExample();
        TblCourseStudentRelationExample.Criteria criteria = tblCourseStudentRelationExample.createCriteria();
        criteria.andClueidEqualTo(studentId);
        criteria.andActivityidEqualTo(courseId);
        try {
            tblCourseStudentRelationMapper.deleteByExample(tblCourseStudentRelationExample);
        } catch (Exception e) {
            throw new ResultExecption(ResultEnum.FAILED);
        }
    }

}



