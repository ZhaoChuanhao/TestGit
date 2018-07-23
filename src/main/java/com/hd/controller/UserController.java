package com.hd.controller;

import com.hd.pojo.User;
import com.hd.service.UserService;
import com.hd.utils.MyUtil;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

/**
 * Created by 赵传昊 on 2018/7/18.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private HttpSession session;

    @RequestMapping("toLogin")
    public String toLogin(Model model, String message){
        log.info("跳转到登录页");
        log.info("读取session");
        User user = (User)session.getAttribute("user");

        log.info("读取cookie");
        String userName = null;
        String password = null;
        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++){
            if("userName".equals(cookies[i].getName())){
                userName = URLDecoder.decode(cookies[i].getValue());
            }else if("password".equals(cookies[i].getName())){
                password = cookies[i].getValue();
            }
        }

        log.info("如果session为空,则把cookie值赋给session");
        if(user == null){
            user = new User();
            user.setUserName(userName);
            user.setPassword(password);
            session.setAttribute("user", user);
        }else{
            log.info("否则，把session值赋给cookie");
            Cookie cookie1 = new Cookie("userName", URLEncoder.encode(user.getUserName()));
            Cookie cookie2 = new Cookie("password", user.getPassword());
            cookie1.setMaxAge(60 * 60 * 24);
            cookie2.setMaxAge(60 * 60 * 24);
            response.addCookie(cookie1);
            response.addCookie(cookie2);
        }

        log.info("跳转到登录页");
        model.addAttribute("message", message);
        return "redirect:/login.jsp";
    }

    @RequestMapping("login")
    public String login(User user, Model model){
        log.info("用户登录");
        user.setPassword(user.getPassword().substring(0, 16));
        user = userService.login(user);
        if (user != null){
            session.setAttribute("user", user);
            Cookie cookie1 = new Cookie("userName", URLEncoder.encode(user.getUserName()));
            Cookie cookie2 = new Cookie("password", user.getPassword());
            cookie1.setMaxAge(60 * 60 * 24);
            cookie2.setMaxAge(60 * 60 * 24);
            response.addCookie(cookie1);
            response.addCookie(cookie2);
            return "index";
        }else{
            model.addAttribute("message", "error");
            return "redirect:/user/toLogin";
        }
    }

    @RequestMapping("register")
    public String register(User user){
        log.info("用户注册");
        user.setPassword(user.getPassword().substring(0, 16));
        user.setCreationDate(new Date());
        user.setLastUpdateDate(new Date());
        userService.register(user);
        return "redirect:/user/toLogin";
    }

    @RequestMapping("userIndex")
    public String userIndex(Model model){
        log.info("跳转到用户主页");
        User user = (User)session.getAttribute("user");
        user = userService.getUserByUserId(user.getUserId());
        model.addAttribute("user", user);
        return "user/userIndex";
    }

    @RequestMapping("toUpdateUser")
    public String toUpdateUser(User user, Model model){
        log.info("跳转到修改用户页面");
        user = userService.getUserByUserId(user.getUserId());
        model.addAttribute("user", user);
        return "user/updateUser";
    }

    @RequestMapping("updateUser")
    public String updateUser(User user){
        log.info("修改用户信息");
        user.setPassword(user.getPassword().substring(0, 16));
        user.setLastUpdateDate(new Date());
        userService.updateUser(user);
        log.info("用户信息修改完成");
        return "redirect:/user/userIndex";
    }

    @RequestMapping("checkUser")
    @ResponseBody
    public void checkUser(String newUserName, User user) throws IOException{
        log.info("检查用户名是否重复以及原密码是否正确");
        int flag = 0;
        if(userService.checkUserName(newUserName)){
            flag = 1;
        }
        if(user != null){
            if(userService.login(user) != null){
                if (flag == 1){
                    flag = 2;
                }
            }
        }

        PrintWriter pw = response.getWriter();
        JSONArray jsonArray = JSONArray.fromObject(flag);
        pw.print(jsonArray.toString());
    }

}
