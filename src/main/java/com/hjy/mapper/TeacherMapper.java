package com.hjy.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.hjy.pojo.Teacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hjy
 * @since 2022-04-13
 */
public interface TeacherMapper extends BaseMapper<Teacher> {
    Teacher selectByTeacherIdAndPassword(@Param("teacherId")double teacherId,@Param("password")String password);

}
