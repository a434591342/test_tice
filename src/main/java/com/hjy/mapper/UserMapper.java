package com.hjy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hjy.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

    // 批量添加用户数据
    int addBatchUser( @Param("userList") List<User> userList);

    // 根据用户账号查询用户数据
    User findUserByAccount(String account);

    // 根据用户账号修改用户信息
    int updateUserByAccount(User user);

}
