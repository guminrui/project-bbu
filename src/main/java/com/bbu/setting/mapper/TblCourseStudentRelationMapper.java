package com.bbu.setting.mapper;

import com.bbu.setting.pojo.TblCourseStudentRelation;
import com.bbu.setting.pojo.TblCourseStudentRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblCourseStudentRelationMapper {
    int countByExample(TblCourseStudentRelationExample example);

    int deleteByExample(TblCourseStudentRelationExample example);

    int deleteByPrimaryKey(String id);

    int insert(TblCourseStudentRelation record);

    int insertSelective(TblCourseStudentRelation record);

    List<TblCourseStudentRelation> selectByExample(TblCourseStudentRelationExample example);

    TblCourseStudentRelation selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TblCourseStudentRelation record, @Param("example") TblCourseStudentRelationExample example);

    int updateByExample(@Param("record") TblCourseStudentRelation record, @Param("example") TblCourseStudentRelationExample example);

    int updateByPrimaryKeySelective(TblCourseStudentRelation record);

    int updateByPrimaryKey(TblCourseStudentRelation record);
}