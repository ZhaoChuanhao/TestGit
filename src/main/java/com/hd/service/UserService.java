package com.hd.service;

import com.hd.pojo.User;

import java.util.List;

/**
 * Created by 赵传昊 on 2018/7/18.
 */
public interface UserService {

    User login(User user);

    void register(User user);

    User getUserByUserId(Integer userId);

    void updateUser(User user);

    boolean checkUserName(String userName);

}
