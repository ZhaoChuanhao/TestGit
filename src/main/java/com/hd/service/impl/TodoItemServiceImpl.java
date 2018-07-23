package com.hd.service.impl;

import com.hd.dao.TodoItemMapper;
import com.hd.pojo.TodoItem;
import com.hd.service.BaseService;
import com.hd.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 赵传昊 on 2018/7/21.
 */
@Service
public class TodoItemServiceImpl extends BaseService implements TodoItemService {

    @Autowired
    private TodoItemMapper todoItemMapper;

    @Override
    public void addTodoItem(TodoItem todoItem) {
        todoItemMapper.addTodoItem(todoItem);
    }

    @Override
    public void deleteTodoItemByTodoItemId(Integer todoItemId) {
        todoItemMapper.deleteTodoItemByTodoItemId(todoItemId);
    }

    @Override
    public void updateTodoItem(TodoItem todoItem) {
        todoItemMapper.updateTodoItem(todoItem);
    }

    @Override
    public List<TodoItem> getTodoItemByUserId(Integer userId) {
        return todoItemMapper.getTodoItemByUserId(userId);
    }

    @Override
    public TodoItem getTodoItemByTodoItemId(Integer todoItemId) {
        return todoItemMapper.getTodoItemByTodoItemId(todoItemId);
    }
}
