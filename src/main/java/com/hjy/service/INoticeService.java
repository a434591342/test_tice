package com.hjy.service;

import com.hjy.pojo.Notice;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hjy.pojo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hjy
 * @since 2022-04-13
 */
public interface INoticeService extends IService<Notice> {
    RespBean getNoticeList();

    RespBean selectById(Integer id);

    RespBean getAllNotice();
}
