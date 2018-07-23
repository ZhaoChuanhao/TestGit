package com.hd.controller;

import com.hd.pojo.TodoItem;
import com.hd.pojo.User;
import com.hd.service.TodoItemService;
import com.hd.utils.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 赵传昊 on 2018/7/21.
 */
@Controller
@RequestMapping("/todoItem")
public class TodoItemController extends BaseController {
    @Autowired
    private TodoItemService todoItemService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpSession session;

    @RequestMapping("toAddTodoItem")
    public String toAddTodoItem() {
        return "todoitem/addTodoItem";
    }

    @RequestMapping("addTodoItem")
    public String addTodoItem(TodoItem todoItem) {
        log.info("添加代办事项");
        User user = (User)session.getAttribute("user");
        todoItem.setUserId(user.getUserId());
        todoItem.setCreationDate(new Date());
        todoItem.setLastUpdateDate(new Date());
        todoItemService.addTodoItem(todoItem);
        log.info("代办事项添加完成");
        return "redirect:/todoItem/todoItemIndex";
    }

    @RequestMapping("deleteTodoItemByTodoItemId")
    public String deleteTodoItemByTodoItemId(TodoItem todoItem) {
        log.info("删除代办事项");
        todoItemService.deleteTodoItemByTodoItemId(todoItem.getTodoItemId());
        log.info("代办事项删除完成");
        return "redirect:/todoItem/todoItemIndex";
    }

    @RequestMapping("toUpdateTodoItem")
    public String toUpdateTodoItem(TodoItem todoItem, Model model) {
        log.info("跳转到修改代办事项页");
        todoItem = todoItemService.getTodoItemByTodoItemId(todoItem.getTodoItemId());
        model.addAttribute("todoItem", todoItem);
        return "todoitem/updateTodoItem";
    }

    @RequestMapping("updateTodoItem")
    public String updateTodoItem(TodoItem todoItem) {
        log.info("修改代办事项");
        todoItem.setLastUpdateDate(new Date());
        todoItemService.updateTodoItem(todoItem);
        log.info("代办事项修改完成");
        return "redirect:/todoItem/todoItemIndex";
    }

    @RequestMapping("todoItemIndex")
    public String todoItemIndex(Model model) {
        log.info("跳转到代办事项主页");
        User user = (User)session.getAttribute("user");
        List<TodoItem> todoItems = todoItemService.getTodoItemByUserId(user.getUserId());
        model.addAttribute("todoItems", todoItems);
        return "todoitem/todoItemIndex";
    }
}
