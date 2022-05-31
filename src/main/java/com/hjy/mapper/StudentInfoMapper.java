package com.hjy.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.hjy.mapper.SelectSchoolNumberAndPasswordResult;

import com.hjy.pojo.StudentInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author hjy
 * @since 2022-04-13
 */
public interface StudentInfoMapper extends BaseMapper<StudentInfo> {


    StudentInfo selectByIdAndPassword(@Param("username") double username, @Param("password") String password);

    List<String> selectClassByAcademyAndMajor(@Param("academy") String academy, @Param("major") String major);

    List<StudentInfo> selectAllByInfo(@Param("major") Integer major, @Param("a_class") String a_class, @Param("sex") Integer sex);

}
