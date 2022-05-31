package com.hjy.service.impl;

import com.hjy.pojo.RespBean;
import com.hjy.pojo.Teacher;
import com.hjy.mapper.TeacherMapper;
import com.hjy.service.ITeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hjy
 * @since 2022-04-13
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {

    @Autowired
    private TeacherMapper teacherInformationMapper;
    @Override
    public RespBean login(double username, String password, String code, HttpServletRequest request) {

        //从session里获取验证码
        String captcha = (String)request.getSession().getAttribute("captcha");
        System.out.println(captcha);
        if (StringUtils.isEmpty(code)||!captcha.equalsIgnoreCase(code)){
            return RespBean.error("验证码输入错误，请重新输入!");
        }
        Teacher teacher = teacherInformationMapper.selectByTeacherIdAndPassword(username, password);
        System.out.println(teacher);
        if (teacher!=null){
            request.getSession().setAttribute("teacher",teacher);
            return RespBean.success("登录成功！！！");
        }
        else return RespBean.error("登录失败！！");
    }
}
