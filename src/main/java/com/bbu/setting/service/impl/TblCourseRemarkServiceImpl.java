package com.bbu.setting.service.impl;

import com.bbu.exception.ResultExecption;
import com.bbu.setting.mapper.TblCourseRemarkMapper;
import com.bbu.setting.pojo.TblCourseRemark;
import com.bbu.setting.pojo.TblCourseRemarkExample;
import com.bbu.setting.service.TblCourseRemarkService;
import com.bbu.util.DateTimeUtil;
import com.bbu.util.ResultEnum;
import com.bbu.util.UUIDUtil;
import com.bbu.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TblCourseRemarkServiceImpl implements TblCourseRemarkService {

    @Autowired
    private TblCourseRemarkMapper tblCourseRemarkMapper;
    @Override
    public List<TblCourseRemark> getByList(String courseId) {
        TblCourseRemarkExample tblCourseRemarkExample = new TblCourseRemarkExample();
        TblCourseRemarkExample.Criteria criteria = tblCourseRemarkExample.createCriteria();
        criteria.andCourseidEqualTo(courseId);
        List<TblCourseRemark> tblCourseRemarks = tblCourseRemarkMapper.selectByExample(tblCourseRemarkExample);
        if (Utils.isListNull(tblCourseRemarks)){
            throw new ResultExecption(ResultEnum.NOT_FOUND);
        }
        return tblCourseRemarks;
    }

    @Override
    public TblCourseRemark getIteam(String remarkId) {
        TblCourseRemark tblCourseRemark = tblCourseRemarkMapper.selectByPrimaryKey(remarkId);
        if (tblCourseRemark==null){
            throw new ResultExecption(ResultEnum.NOT_FOUND);
        }
        return tblCourseRemark;
    }

    @Override
    public void editRemark(TblCourseRemark tblCourseRemark) {
      //      tblActivityRemark.setEditflag("1");
            tblCourseRemark.setCreatetime(DateTimeUtil.systime());
        try {
            tblCourseRemarkMapper.updateByPrimaryKeySelective(tblCourseRemark);
        } catch (Exception e) {
            throw new ResultExecption(ResultEnum.FAILED);

        }
    }

    @Override
    public void delItem(String remarkId) {

        try {
            tblCourseRemarkMapper.deleteByPrimaryKey(remarkId);
        } catch (Exception e) {
            throw new ResultExecption(ResultEnum.FAILED);
        }
    }

    @Override
    public void addItem(TblCourseRemark tblCourseRemark) {
        tblCourseRemark.setCreatetime(DateTimeUtil.systime());
        tblCourseRemark.setEditflag("0");
        tblCourseRemark.setId(UUIDUtil.getUUID());
        try {
            tblCourseRemarkMapper.insertSelective(tblCourseRemark);
        } catch (Exception e) {
            throw new ResultExecption(ResultEnum.FAILED);
        }
    }
}
