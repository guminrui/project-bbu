package com.bbu.setting.mapper;

import com.bbu.setting.pojo.TblStudent;
import com.bbu.setting.pojo.TblStudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblStudentMapper {
    int countByExample(TblStudentExample example);

    int deleteByExample(TblStudentExample example);

    int deleteByPrimaryKey(String id);

    int insert(TblStudent record);

    int insertSelective(TblStudent record);

    List<TblStudent> selectByExample(TblStudentExample example);

    TblStudent selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TblStudent record, @Param("example") TblStudentExample example);

    int updateByExample(@Param("record") TblStudent record, @Param("example") TblStudentExample example);

    int updateByPrimaryKeySelective(TblStudent record);

    int updateByPrimaryKey(TblStudent record);
}