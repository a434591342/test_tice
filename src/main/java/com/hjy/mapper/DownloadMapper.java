package com.hjy.mapper;

import com.hjy.pojo.Download;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface DownloadMapper extends BaseMapper<Download> {

    List<Download> getServiceList();

    List<Download> getAllList();

    boolean updateDownload(@Param("download") Download download);

    boolean addDownload(@Param("download") Download download);
}
