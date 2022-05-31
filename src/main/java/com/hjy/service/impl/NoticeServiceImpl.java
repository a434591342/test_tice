package com.hjy.service.impl;

import com.hjy.pojo.Notice;
import com.hjy.mapper.NoticeMapper;
import com.hjy.pojo.RespBean;
import com.hjy.service.INoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements INoticeService {

    @Autowired
    private NoticeMapper noticeMapper;
    @Override
    public RespBean getNoticeList() {
       List<Notice> list = noticeMapper.getNoticeList();
       if (list.size()!=0){
           return RespBean.success("查询成功！",list);
       }else return RespBean.error("没有最近公告");
    }

    @Override
    public RespBean selectById(Integer id) {
        Notice notice = noticeMapper.selectById(id);
        if (notice!=null){
            return RespBean.success("查询成功！",notice);
        }else return RespBean.error("查询失败");
    }

    @Override
    public RespBean getAllNotice() {
        List<Notice> list = noticeMapper.getAllNotice();
        if (list.size()!=0){
            return RespBean.success("查询成功！",list);
        }else return RespBean.error("没有最近公告");
    }
}
