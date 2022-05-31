package com.hjy.service;

import com.hjy.pojo.Academy;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hjy
 * @since 2022-04-13
 */
public interface IAcademyService extends IService<Academy> {


    String selectNameById(Integer academyId);

    List<String> selectAllName();
}
