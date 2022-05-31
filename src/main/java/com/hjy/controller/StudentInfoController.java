package com.hjy.controller;


import com.hjy.pojo.RespBean;
import com.hjy.pojo.StudentInfo;
import com.hjy.pojo.academyAndMajor;
import com.hjy.service.IStudentInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hjy
 * @since 2022-04-13
 */
@RestController
@RequestMapping("/student-info")
public class StudentInfoController {
    @Autowired
    private IStudentInfoService studentInfoService;
    @ApiOperation(value = "查询学生成绩信息")
    @PostMapping("/getStuInfo")
    public RespBean getStuInfo(@RequestBody academyAndMajor academyAndMajor){
        return studentInfoService.selectAllByInfo(academyAndMajor);
    }
    @ApiOperation(value = "根据学号查询学生信息")
    @GetMapping("/getStuInfoByNum")
    public RespBean getStuInfoByNum(@RequestParam Integer school_num){
        StudentInfo studentInfo = studentInfoService.selectById(school_num);
        List<StudentInfo> res = new ArrayList<>();
        res.add(studentInfo);
        if (studentInfo!=null){
            return RespBean.success("查询成功",res);
        }else return RespBean.error("查询失败！");
    }
}
