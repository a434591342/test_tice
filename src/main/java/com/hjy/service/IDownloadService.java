package com.hjy.service;

import com.hjy.pojo.Download;
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
public interface IDownloadService extends IService<Download> {

    RespBean getServiceList();
    RespBean getAllList();

    RespBean selectById(Integer id);

    boolean updateDownload(Download download);

    boolean addDownload(Download download);
}
