package com.hd.pojo;

import com.hd.utils.MyUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 赵传昊 on 2018/7/18.
 */
public class User implements Serializable{
    private Integer userId;  //用户ID
    private String userName;  //用户名称
    private String password;  //用户密码
    private String sex;  //性别（M-Male/F-Female）
    private Integer age;  //年龄，必须1...200之间
    private String phoneNumber;  //电话
    private Date creationDate;  //创建时间
    private Date lastUpdateDate;  //更新时间
    private String comments;  //备注

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCreationTime(){
        if (creationDate != null){
            return MyUtil.DateToString(creationDate);
        }else {
            return "";
        }
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastUpdateTime(){
        if (lastUpdateDate != null){
            return MyUtil.DateToString(lastUpdateDate);
        }else {
            return "";
        }
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", lastUpdateDate='" + lastUpdateDate + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
