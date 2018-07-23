package com.hd.service;

import com.hd.pojo.TodoItem;

import java.util.List;

/**
 * Created by 赵传昊 on 2018/7/21.
 */
public interface TodoItemService {

    void addTodoItem(TodoItem todoItem);

    void deleteTodoItemByTodoItemId(Integer todoItemId);

    void updateTodoItem(TodoItem todoItem);

    List<TodoItem> getTodoItemByUserId(Integer userId);

    TodoItem getTodoItemByTodoItemId(Integer todoItemId);
}
