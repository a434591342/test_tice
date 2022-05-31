package com.hjy.controller;

import com.hjy.pojo.AdminLoginParam;
import com.hjy.pojo.RespBean;
import com.hjy.service.IStudentInfoService;
import com.hjy.service.ITeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: Haojunyu
 * Date: 2022/4/24
 * Time: 11:47
 * Description: No Description
 */
@Api(tags = "登录界面")
@RestController
public class LoginController {
    @Autowired
    private IStudentInfoService studentInfoService;
    @Autowired
    private ITeacherService teacherService;

    @ApiOperation(value = "登录操作")
    @PostMapping("/login")
//    @RequestParam Map<String, Object> params
    public RespBean login(@RequestBody AdminLoginParam adminLoginParam, HttpServletRequest request){
        HttpSession session = request.getSession();
//        session.setAttribute();
        System.out.println(adminLoginParam);
        if (adminLoginParam.getRole().equals("teacher")){
            return teacherService.login(adminLoginParam.getUsername(),adminLoginParam.getPassword(),adminLoginParam.getCode(),request);
        }else {
            return studentInfoService.login(adminLoginParam.getUsername(),adminLoginParam.getPassword(),adminLoginParam.getCode(),request);
        }
    }


}
