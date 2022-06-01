package com.hjy.service;

import com.hjy.pojo.User;

import java.io.InputStream;
import java.util.List;

public interface UserService {
    boolean addBatchUser(List<User> userList);
    User findUserByAccount(String account);
    boolean updateUserByAccount(User user);
    boolean importUserInfo(String fileName, InputStream is);
}
