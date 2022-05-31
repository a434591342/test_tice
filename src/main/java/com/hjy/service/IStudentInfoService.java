package com.hjy.service;

import com.hjy.pojo.RespBean;
import com.hjy.pojo.StudentInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hjy.pojo.academyAndMajor;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hjy
 * @since 2022-04-13
 */
public interface IStudentInfoService extends IService<StudentInfo> {

    RespBean login(double username, String password, String code, HttpServletRequest request);

    StudentInfo selectById(Integer studentId);

    List<String> selectClassByAcademyAndMajor(String academy, String major);

    RespBean selectAllByInfo(academyAndMajor academyAndMajor);
}
