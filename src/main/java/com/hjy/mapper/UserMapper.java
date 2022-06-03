package com.hjy.mapper;

import com.hjy.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    // 批量添加用户数据
    public int addBatchUser(@Param("userList") List<User> userList);

    // 根据用户账号查询用户数据
    public User findUserByAccount(String account);

    // 根据用户账号修改用户信息
    public int updateUserByAccount(User user);

}