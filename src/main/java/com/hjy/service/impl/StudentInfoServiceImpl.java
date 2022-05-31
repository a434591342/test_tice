package com.hjy.service.impl;

import com.hjy.mapper.MajorMapper;
import com.hjy.pojo.Major;
import com.hjy.pojo.RespBean;
import com.hjy.pojo.StudentInfo;
import com.hjy.mapper.StudentInfoMapper;
import com.hjy.pojo.academyAndMajor;
import com.hjy.service.IStudentInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hjy
 * @since 2022-04-13
 */
@Service
public class StudentInfoServiceImpl extends ServiceImpl<StudentInfoMapper, StudentInfo> implements IStudentInfoService {

    @Autowired
    private StudentInfoMapper studentInfoMapper;
    @Autowired
    private MajorMapper majorMapper;
    @Override
    public RespBean login(double username, String password, String code, HttpServletRequest request) {

        //从session里获取验证码
        String captcha = (String)request.getSession().getAttribute("captcha");
        if (captcha==null){
            return RespBean.error("未获取到验证码信息！");
        }
        if (StringUtils.isEmpty(code)||!captcha.equalsIgnoreCase(code)){
            return RespBean.error("验证码输入错误，请重新输入!");
        }
        StudentInfo studentInfo = studentInfoMapper.selectByIdAndPassword(username, password);
        if (studentInfo!=null){
            request.getSession().setAttribute("student",studentInfo);
            return RespBean.success("登录成功！！！");
        }
        else return RespBean.error("登录失败！！");
    }

    @Override
    public StudentInfo selectById(Integer studentId) {

        return studentInfoMapper.selectById(studentId);
    }

    @Override
    public List<String> selectClassByAcademyAndMajor(String academy, String major) {
        return studentInfoMapper.selectClassByAcademyAndMajor(academy,major);
    }

    @Override
    public RespBean selectAllByInfo(academyAndMajor academyAndMajor) {
        System.out.println(majorMapper.selectMajorInfo(academyAndMajor.getMajor(),academyAndMajor.getAcademy()));
        Major major = majorMapper.selectMajorInfo(academyAndMajor.getMajor(),academyAndMajor.getAcademy());
        int sex = 0;
        if (academyAndMajor.getSex().equals("男")){
            sex = 1;
        }else  sex = 2;
        System.out.println(major.getMajorId());
        System.out.println(academyAndMajor.getClass_id());
        System.out.println(sex);
        List<StudentInfo> res = studentInfoMapper.selectAllByInfo(major.getMajorId(),academyAndMajor.getClass_id(),sex);
        if (res.size()!=0){
            return RespBean.success("查询成功",res);
        }else return RespBean.error("查询失败");
    }

}
