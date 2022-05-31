package com.hjy.mapper;

import com.hjy.pojo.SuggestionClassify;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hjy
 * @since 2022-04-13
 */
public interface SuggestionClassifyMapper extends BaseMapper<SuggestionClassify> {

    String selectSug(int parseInt);

}
