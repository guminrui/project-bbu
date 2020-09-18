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

import java.util.ArrayList;
import java.util.List;

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

//    @Autowired
//    private TblCustomerMapper customerMapper;
//
//    @Autowired
//    private TblContactsMapper contactsMapper;
//
//    @Autowired
//    private TblClueRemarkMapper clueRemarkMapper;
//
//    @Autowired
//    private TblCustomerRemarkMapper customerRemarkMapper;
//
//    @Autowired
//    private TblContactsRemarkMapper contactsRemarkMapper;
//
//    @Autowired
//    private TblContactsActivityRelationMapper contactsActivityRelationMapper;
//
//    @Autowired
//    private TblTranMapper tblTranMapper;
//
//    @Autowired
//    private TblTranHistoryMapper tranHistoryMapper;


    @Override
    public ResultPage queryAll(int pageSize, int pageNo,String name, String classandgrade , String phone) {

        TblStudentExample tblStudentExample = new TblStudentExample();
        TblStudentExample.Criteria criteria = tblStudentExample.createCriteria();
        if (name!=null &&"".equals(name)){
            criteria.andNameLike('%'+name+'%');
        }
        if (classandgrade!=null &&"".equals(classandgrade)){
            criteria.andClassandgradeLike('%'+classandgrade+'%');
        }
        if (phone!=null &&"".equals(phone)){
            criteria.andClassandgradeLike('%'+phone+'%');
        }
        PageHelper.startPage(pageNo,pageSize);
        List<TblStudent> tblStudents = tblStudentMapper.selectByExample(tblStudentExample);

        PageInfo<TblStudent> pageInfo = new PageInfo<TblStudent>(tblStudents);
        ResultPage<TblStudent> tblStudentResultPage = new ResultPage<TblStudent>();
        tblStudentResultPage.setRows(pageInfo.getList());
        tblStudentResultPage.setPage(pageInfo.getTotal());
        return tblStudentResultPage;
//        return tblStudents;

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
    public TblStudent getByStudentId(String studentId) {
        TblStudent tblStudent = tblStudentMapper.selectByPrimaryKey(studentId);
        if (tblStudent==null){
            throw new ResultExecption(ResultEnum.NOT_FOUND);
        }
//        TblUser tblUser = userMapper.selectByPrimaryKey(tblStudent.getOwner());
//        if (tblUser==null){
//            throw new ResultExecption(ResultEnum.NOT_FOUND);
//        }
//        tblClue.setOwner(tblUser.getName());
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
//            TblUser tblUser = userMapper.selectByPrimaryKey(tblActivity.getOwner());
//            tblActivity.setOwner(tblUser.getName());
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
//        for (TblCourse activity : activities) {
//            TblUser tblUser = userMapper.selectByPrimaryKey(activity.getOwner());
//            activity.setOwner(tblUser.getName());
//        }
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


  /*  @Override




*/
  /*




    @Override
    public List<TblActivity> getConvertAct(String clueId,String search) {
        //1.查询线索与市场活动中间表
        TblClueActivityRelationExample example = new TblClueActivityRelationExample();
        TblClueActivityRelationExample.Criteria criteria = example.createCriteria();
        criteria.andClueidEqualTo(clueId);
        List<TblClueActivityRelation> tblClueActivityRelations = clueActivityRelationMapper.selectByExample(example);
        if (Utils.isListNull(tblClueActivityRelations)){
            throw new ResultExecption(ResultEnum.NOT_FOUND);
        }

        //2.根据中间表查询市场活动
        List<String> ids = new ArrayList<String>();
        for (TblClueActivityRelation tblClueActivityRelation : tblClueActivityRelations) {
            ids.add(tblClueActivityRelation.getActivityid());
        }
        List<TblActivity> result = null;
        if (search !=null && !"".equals(search)){
            TblActivityExample searchExample = new TblActivityExample();
            TblActivityExample.Criteria searchCriteria = searchExample.createCriteria();
            searchCriteria.andNameLike("%"+search+"%");
            List<TblActivity> activities = activityMapper.selectByExample(searchExample);
            if (Utils.isListNull(activities)){
                throw new ResultExecption(ResultEnum.NOT_FOUND);
            }
            List<String> activityIds = new ArrayList<String>();
            for (TblActivity activity : activities) {
                activityIds.add(activity.getId());
            }

            //保留中间表的id和市场活动id交集
            activityIds.retainAll(ids);
            TblActivityExample activityExample = new TblActivityExample();
            TblActivityExample.Criteria activityExampleCriteria = activityExample.createCriteria();
            activityExampleCriteria.andIdIn(activityIds);
            result = activityMapper.selectByExample(activityExample);
        }else {
            TblActivityExample activityExample = new TblActivityExample();
            TblActivityExample.Criteria activityCriteria = activityExample.createCriteria();
            activityCriteria.andIdIn(ids);
            result = activityMapper.selectByExample(activityExample);
        }
        if (Utils.isListNull(result)){
            throw new ResultExecption(ResultEnum.NOT_FOUND);
        }
        //3.根据所有者id查询出来所有者名称
        for (TblActivity activity : result) {
            TblUser tblUser = userMapper.selectByPrimaryKey(activity.getOwner());
            activity.setOwner(tblUser.getName());
        }

        return result;
    }

    @Override
    public void convert(String createby, String clueId, String money, String tranName, String expecteddate, String stage, String activityId, String flg) {
        String createtime = DateTimeUtil.systime();

        //1.根据线索id去查询线索对象
        TblClue tblClue = clueMapper.selectByPrimaryKey(clueId);
        if (tblClue == null){
            throw new ResultExecption(ResultEnum.NOT_FOUND);
        }

        TblCustomerExample customerExample = new TblCustomerExample();
        TblCustomerExample.Criteria customerExampleCriteria = customerExample.createCriteria();
        customerExampleCriteria.andNameEqualTo(tblClue.getCompany());
        List<TblCustomer> tblCustomers = customerMapper.selectByExample(customerExample);

        //2.根据公司名称来获取客户，存在即可以获取，不存在则创建新的客户对象
        TblCustomer customer= null;
        if (Utils.isListNull(tblCustomers)){//创建新的客户
            customer = new TblCustomer();
            customer.setAddress(tblClue.getAddress());
            customer.setContactsummary(tblClue.getContactsummary());
            customer.setCreateby(createby);
            customer.setCreatetime(createtime);
            customer.setDescription(tblClue.getDescription());
            customer.setId(UUIDUtil.getUUID());
            customer.setName(tblClue.getCompany());
            customer.setNextcontacttime(tblClue.getNextcontacttime());
            customer.setOwner(tblClue.getOwner());
            customer.setPhone(tblClue.getPhone());
            customer.setWebsite(tblClue.getWebsite());
            customerMapper.insert(customer);
        }else {//获取已经存在的客户
            customer = tblCustomers.get(0);
        }

        //3.创建联系人
        TblContacts contacts = new TblContacts();
        contacts.setAddress(tblClue.getAddress());
        contacts.setAppellation(tblClue.getAppellation());
        contacts.setContactsummary(tblClue.getContactsummary());
        contacts.setCreateby(createby);
        contacts.setCreatetime(createtime);
        contacts.setCustomerid(customer.getId());
        contacts.setDescription(tblClue.getDescription());
        contacts.setEmail(tblClue.getEmail());
        contacts.setFullname(tblClue.getFullname());
        contacts.setId(UUIDUtil.getUUID());
        contacts.setJob(tblClue.getJob());
        contacts.setMphone(tblClue.getMphone());
        contacts.setNextcontacttime(tblClue.getNextcontacttime());
        contacts.setOwner(tblClue.getOwner());
        contacts.setSource(tblClue.getSource());
        contactsMapper.insert(contacts);


        TblClueRemarkExample clueRemarkExample = new TblClueRemarkExample();
        TblClueRemarkExample.Criteria clueRemarkExampleCriteria = clueRemarkExample.createCriteria();
        clueRemarkExampleCriteria.andClueidEqualTo(clueId);
        List<TblClueRemark> tblClueRemarks = clueRemarkMapper.selectByExample(clueRemarkExample);
        if (!Utils.isListNull(tblClueRemarks)){
            for (TblClueRemark tblClueRemark : tblClueRemarks) {
                //4.把线索备注转到客户备注上
                TblCustomerRemark customerRemark = new TblCustomerRemark();
                customerRemark.setNotecontent(tblClueRemark.getNotecontent());
                customerRemark.setCreateby(tblClueRemark.getCreateby());
                customerRemark.setCreatetime(createtime);
                customerRemark.setCustomerid(customer.getId());
                customerRemark.setEditflag("0");
                customerRemark.setId(UUIDUtil.getUUID());
                customerRemarkMapper.insert(customerRemark);

                //5.把线索的备注转联系人备注上
                TblContactsRemark contactsRemark = new TblContactsRemark();
                contactsRemark.setContactsid(contacts.getId());
                contactsRemark.setCreateby(tblClueRemark.getCreateby());
                contactsRemark.setCreatetime(createtime);
                contactsRemark.setEditflag("0");
                contactsRemark.setId(UUIDUtil.getUUID());
                contactsRemark.setNotecontent(tblClueRemark.getNotecontent());
                contactsRemarkMapper.insert(contactsRemark);

            }
        }


        //6.需要把线索和市场活动关联关系转换为联系人和市场活动关联关系
        TblClueActivityRelationExample clueActivityRelationExample = new TblClueActivityRelationExample();
        TblClueActivityRelationExample.Criteria clueActivityRelationExampleCriteria = clueActivityRelationExample.createCriteria();
        clueActivityRelationExampleCriteria.andClueidEqualTo(clueId);
        List<TblClueActivityRelation> tblClueActivityRelations = clueActivityRelationMapper.selectByExample(clueActivityRelationExample);
        if (!Utils.isListNull(tblClueActivityRelations)){
            for (TblClueActivityRelation tblClueActivityRelation : tblClueActivityRelations) {
                TblContactsActivityRelation contactsActivityRelation = new TblContactsActivityRelation();
                contactsActivityRelation.setActivityid(tblClueActivityRelation.getActivityid());
                contactsActivityRelation.setContactsid(contacts.getId());
                contactsActivityRelation.setId(UUIDUtil.getUUID());
                contactsActivityRelationMapper.insert(contactsActivityRelation);
            }
        }


        if ("1".equals(flg)){
            //7.存在交易则添加一条交易
            TblTran tblTran = new TblTran();
            tblTran.setActivityid(activityId);
            tblTran.setContactsid(contacts.getId());
            tblTran.setContactsummary(tblClue.getContactsummary());
            tblTran.setCreateby(createby);
            tblTran.setCreatetime(createtime);
            tblTran.setCustomerid(customer.getId());
            tblTran.setDescription(tblClue.getDescription());
            tblTran.setExpecteddate(expecteddate);
            tblTran.setId(UUIDUtil.getUUID());
            tblTran.setMoney(money);
            tblTran.setName(tranName);
            tblTran.setNextcontacttime(tblClue.getNextcontacttime());
            tblTran.setOwner(tblClue.getOwner());
            tblTran.setSource(tblClue.getSource());
            tblTran.setStage(stage);
            tblTranMapper.insert(tblTran);

            //8.存在交易则添加一条交易记录
            TblTranHistory tblTranHistory = new TblTranHistory();
            tblTranHistory.setCreateby(createby);
            tblTranHistory.setCreatetime(createtime);
            tblTranHistory.setExpecteddate(expecteddate);
            tblTranHistory.setId(UUIDUtil.getUUID());
            tblTranHistory.setMoney(money);
            tblTranHistory.setStage(stage);
            tblTranHistory.setTranid(tblTran.getId());
            tranHistoryMapper.insert(tblTranHistory);

        }
        //9.删除线索备注记录
        TblClueRemarkExample clueRemarkExample1 = new TblClueRemarkExample();
        TblClueRemarkExample.Criteria clueCriteria = clueRemarkExample1.createCriteria();
        clueCriteria.andClueidEqualTo(clueId);
        clueRemarkMapper.deleteByExample(clueRemarkExample1);
        //10.删除线索与市场活动关联关系
        TblClueActivityRelationExample clueActivityRelationExample1 = new TblClueActivityRelationExample();
        TblClueActivityRelationExample.Criteria clueActivityRelationExample1Criteria = clueActivityRelationExample1.createCriteria();
        clueActivityRelationExample1Criteria.andClueidEqualTo(clueId);
        clueActivityRelationMapper.deleteByExample(clueActivityRelationExample1);

        //11.删除当前线索记录
        clueMapper.deleteByPrimaryKey(clueId);

    }*/

