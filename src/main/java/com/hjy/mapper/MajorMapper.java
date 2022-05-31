package com.hjy.mapper;

import com.hjy.pojo.Major;
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
public interface MajorMapper extends BaseMapper<Major> {

    List<String> selectAllName();

    List<String> selectByAcademy(@Param("academy") String academy);

    Major selectMajorInfo(@Param("major") String major,@Param("academy") String academy);

}
