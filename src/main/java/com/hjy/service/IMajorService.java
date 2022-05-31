package com.hjy.service;

import com.hjy.pojo.Major;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hjy.pojo.RespBean;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hjy
 * @since 2022-04-13
 */
public interface IMajorService extends IService<Major> {

    Major selectById(Integer majorId);

    List<String> selectAllName();

    RespBean selectMajor(String academy);
}
