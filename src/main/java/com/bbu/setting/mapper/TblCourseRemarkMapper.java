package com.bbu.setting.mapper;

import com.bbu.setting.pojo.TblCourseRemark;
import com.bbu.setting.pojo.TblCourseRemarkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblCourseRemarkMapper {
    int countByExample(TblCourseRemarkExample example);

    int deleteByExample(TblCourseRemarkExample example);

    int deleteByPrimaryKey(String id);

    int insert(TblCourseRemark record);

    int insertSelective(TblCourseRemark record);

    List<TblCourseRemark> selectByExample(TblCourseRemarkExample example);

    TblCourseRemark selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TblCourseRemark record, @Param("example") TblCourseRemarkExample example);

    int updateByExample(@Param("record") TblCourseRemark record, @Param("example") TblCourseRemarkExample example);

    int updateByPrimaryKeySelective(TblCourseRemark record);

    int updateByPrimaryKey(TblCourseRemark record);
}