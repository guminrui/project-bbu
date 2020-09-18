package com.bbu.setting.mapper;

import com.bbu.setting.pojo.TblCourse;
import com.bbu.setting.pojo.TblCourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblCourseMapper {
    int countByExample(TblCourseExample example);

    int deleteByExample(TblCourseExample example);

    int deleteByPrimaryKey(String id);

    int insert(TblCourse record);

    int insertSelective(TblCourse record);

    List<TblCourse> selectByExample(TblCourseExample example);

    TblCourse selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TblCourse record, @Param("example") TblCourseExample example);

    int updateByExample(@Param("record") TblCourse record, @Param("example") TblCourseExample example);

    int updateByPrimaryKeySelective(TblCourse record);

    int updateByPrimaryKey(TblCourse record);
}