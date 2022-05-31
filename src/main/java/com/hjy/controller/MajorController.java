package com.hjy.controller;


import com.hjy.mapper.MajorMapper;
import com.hjy.pojo.Major;
import com.hjy.pojo.RespBean;
import com.hjy.pojo.academyAndMajor;
import com.hjy.service.IAcademyService;
import com.hjy.service.IMajorService;
import com.hjy.service.IStudentInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hjy
 * @since 2022-04-13
 */
@RestController
@RequestMapping("/major")
public class MajorController {

    @Autowired
    private IMajorService majorService;

    @Autowired
    private IAcademyService academyService;

    @Autowired
    private IStudentInfoService studentInfoService;

    @ApiOperation(value = "查询所有系信息")
    @GetMapping("/getAllAcademy")
    public RespBean getAllSelectInfo(){
        Map<String,List<String>> res = new HashMap<>();
        List<String> academyList = academyService.selectAllName();
        res.put("academy",academyList);
        List<String> majorList = majorService.selectAllName();
        res.put("major",majorList);
        if (res.size()!=0){
            return RespBean.success("查询成功",res);
        }else return RespBean.error("查询失败");
    }
    @ApiOperation(value = "查询对应系的专业")
    @PostMapping("/getAllMajor")
    public RespBean getAllMajor(@RequestBody academyAndMajor academyAndMajor){
        return majorService.selectMajor(academyAndMajor.getAcademy());
    }

    @ApiOperation(value = "获取对应的班级")
    @PostMapping("/getAllClass")
    public RespBean getAllClass(@RequestBody academyAndMajor academyAndMajor){
        List<String> res = studentInfoService.selectClassByAcademyAndMajor(academyAndMajor.getAcademy(),academyAndMajor.getMajor());
        if (res.size()!=0){
            return RespBean.success("查询成功",res);
        }else return RespBean.error("查询失败");
    }

}
