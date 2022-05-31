package com.hjy.mapper;

import com.hjy.pojo.Suggestion;
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
public interface SuggestionMapper extends BaseMapper<Suggestion> {

    Suggestion selectSugByTestScoreId(@Param("id") Integer id);
}
