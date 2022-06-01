package com.hjy.service.impl;

import com.hjy.config.ImportExcelUtils;
import com.hjy.mapper.UserMapper;
import com.hjy.pojo.User;
import com.hjy.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Resource
    ImportExcelUtils excelUtils;

    /**
     * 批量添加用户信息
     * @param userList 用户信息
     * @return 用户信息是否添加成功
     */
    @Override
    public boolean addBatchUser(List<User> userList) {
        return userMapper.addBatchUser(userList) > 0;
    }

    /**
     * 根据用户账号查看用户是否存在
     * @param account 用户账号
     * @return 查询到的用户信息
     */
    @Override
    public User findUserByAccount(String account) {
        return userMapper.findUserByAccount(account);
    }

    /**
     * 根据用户账号修改用户信息
     * @param user 用户信息
     * @return 是否修改成功
     */
    @Override
    public boolean updateUserByAccount(User user) {
        return userMapper.updateUserByAccount(user) > 0;
    }

    /**
     * 批量导入用户信息
     * @param fileName 导入的表名
     * @param is 导入表的输入流
     * @return 是否导入成功
     */
    @Override
    public boolean importUserInfo(String fileName, InputStream is){
        try {
            List<User> userList = excelUtils.upload(fileName, is);
            for (int i = 0; i < userList.size(); i++) {
                User user = findUserByAccount(userList.get(i).getAccount()); // 查找数据库中看这个用户信息是否存在
                if (user != null){
                    updateUserByAccount(userList.get(i)); // 更新数据库中的用户信息
                    userList.remove(i); // 移除更新后的用户
                    i = i - 1; // 因为移除了，所以userList大小减了一而循环加了一，所以要减回去
                }
            }
            return addBatchUser(userList); // 批量添加
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
