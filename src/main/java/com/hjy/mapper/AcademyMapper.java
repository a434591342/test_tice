package com.hjy.mapper;

import com.hjy.pojo.Academy;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hjy
 * @since 2022-04-13
 */
public interface AcademyMapper extends BaseMapper<Academy> {

    String selectNameById(@Param("academyId") Integer academyId);

    List<String> selectNames();
}
