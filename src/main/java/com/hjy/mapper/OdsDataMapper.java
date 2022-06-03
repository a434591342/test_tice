package com.hjy.mapper;

import com.hjy.pojo.OdsData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hjy
 * @since 2022-04-13
 */
public interface OdsDataMapper extends BaseMapper<OdsData> {

    void truncate();
}
