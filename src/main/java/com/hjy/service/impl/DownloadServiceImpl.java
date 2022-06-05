package com.hjy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjy.mapper.DownloadMapper;
import com.hjy.pojo.Download;
import com.hjy.pojo.RespBean;
import com.hjy.service.IDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class DownloadServiceImpl extends ServiceImpl<DownloadMapper, Download> implements IDownloadService {
    @Autowired
    private DownloadMapper downloadMapper;
    @Override
    public RespBean getServiceList() {
        List<Download> list = downloadMapper.getServiceList();
        if (list!=null){
            return RespBean.success("查询成功",list);
        }else return RespBean.error("查询失败");
    }
    public RespBean getAllList() {
        List<Download> list = downloadMapper.getAllList();
        if (list!=null){
            return RespBean.success("查询成功",list);
        }else return RespBean.error("查询失败");
    }

    @Override
    public RespBean selectById(Integer id) {
        Download download = downloadMapper.selectById(id);
        if (download!=null){
            return RespBean.success("查询成功！",download);
        }else return RespBean.error("查询失败");
    }

    @Override
    public boolean updateDownload(Download download) {

        return downloadMapper.updateDownload(download);
    }

    @Override
    public boolean addDownload(Download download) {
        return downloadMapper.addDownload(download);
    }
}
