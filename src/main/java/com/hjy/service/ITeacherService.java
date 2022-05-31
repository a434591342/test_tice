package com.hjy.service;

import com.hjy.pojo.RespBean;
import com.hjy.pojo.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hjy
 * @since 2022-04-13
 */
public interface ITeacherService extends IService<Teacher> {

    RespBean login(double username, String password, String code, HttpServletRequest request);
}
