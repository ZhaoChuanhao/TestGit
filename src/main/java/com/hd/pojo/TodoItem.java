package com.hd.pojo;

import java.io.Serializable;

/**
 * Created by 赵传昊 on 2018/7/21.
 */
public class TodoItem implements Serializable{
    private Integer todoItemId;  //代办事项ID
    private Integer userId;  //属主用户
    private String todoItemTitle;  //代办事项标题
    private String todoItemContent;  //待办事项内容
    private String priority;  //优先级：LOW/MEDIUM/HIGH
    private String creationDate;  //创建时间
    private String lastUpdateDate;  //更新时间
    private String comments;  //备注

    public Integer getTodoItemId() {
        return todoItemId;
    }

    public void setTodoItemId(Integer todoItemId) {
        this.todoItemId = todoItemId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTodoItemTitle() {
        return todoItemTitle;
    }

    public void setTodoItemTitle(String todoItemTitle) {
        this.todoItemTitle = todoItemTitle;
    }

    public String getTodoItemContent() {
        return todoItemContent;
    }

    public void setTodoItemContent(String todoItemContent) {
        this.todoItemContent = todoItemContent;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
