package com.hd.dao;

import com.hd.pojo.User;

import java.util.List;

/**
 * Created by 赵传昊 on 2018/7/18.
 */
public interface UserMapper {

    User login(User user);

    void register(User user);

    User getUserByUserId(Integer userId);

    void updateUser(User user);

    Integer checkUserName(String userName);

}
