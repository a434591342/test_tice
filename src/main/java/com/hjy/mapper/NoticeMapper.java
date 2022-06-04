package com.hjy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hjy.pojo.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author hjy
 * @since 2022-04-13
 */
public interface NoticeMapper extends BaseMapper<Notice> {

    List<Notice> getNoticeList();


    List<Notice> getAllNotice();

    boolean updateNotice(@Param("notice") Notice notice);

    boolean addNotice(@Param("notice") Notice notice);
}
