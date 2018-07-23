package com.hd.service.impl;

import com.hd.dao.UserMapper;
import com.hd.pojo.User;
import com.hd.service.BaseService;
import com.hd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 赵传昊 on 2018/7/18.
 */
@Service
public class UserServiceImpl extends BaseService implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public void register(User user) {
        userMapper.register(user);
    }

    @Override
    public User getUserByUserId(Integer userId) {
        return userMapper.getUserByUserId(userId);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public boolean checkUserName(String userName) {
        if (userMapper.checkUserName(userName) == 0){
            log.info("用户名不重复，返回true");
            return true;
        }else{
            log.info("用户名重复，返回false");
            return false;
        }
    }

}
