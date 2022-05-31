package com.hjy.mapper;
import org.apache.ibatis.annotations.Param;

import com.hjy.pojo.Notice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hjy
 * @since 2022-04-13
 */
public interface NoticeMapper extends BaseMapper<Notice> {

    List<Notice> getNoticeList();


    List<Notice> getAllNotice();
}
