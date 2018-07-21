package com.hd.controller;

import com.hd.pojo.User;
import com.hd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by 赵传昊 on 2018/7/18.
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("test")
    public String test(Model model){
        List<User> users = userService.getAllUser();
        for (User u:users) {
            System.out.println(u.getName());
        }
        model.addAttribute("users", users);
        return "test";
    }

}
