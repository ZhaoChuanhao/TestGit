<%--
  Created by IntelliJ IDEA.
  User: Zhao
  Date: 2018/7/23
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>代办事项修改页</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/todoitem/updateTodoItem.js"></script>
    <script>
        var path = "${pageContext.request.contextPath}";
    </script>
</head>
<body>
<form id="updateForm" action="${pageContext.request.contextPath}/todoItem/updateTodoItem?todoItemId=${todoItem.todoItemId}" method="post">
    <table align="center" cellpadding="10">
        <tr>
            <td>标题：</td>
            <td>
                <input type="text" name="todoItemTitle" placeholder="请输入标题" value="${todoItem.todoItemTitle}"/>
                <span>*</span>
            </td>
        </tr>
        <tr>
            <td>内容：</td>
            <td><input type="text" name="todoItemContent" placeholder="请输入内容" value="${todoItem.todoItemContent}"/></td>
        </tr>
        <tr>
            <td>优先级：</td>
            <td>
                <select name="priority">
                    <option value="LOW" <c:if test="${todoItem.priority == 'LOW'}">selected</c:if>>低</option>
                    <option value="MEDIUM" <c:if test="${todoItem.priority == 'MEDIUM'}">selected</c:if>>中</option>
                    <option value="HIGH" <c:if test="${todoItem.priority == 'HIGH'}">selected</c:if>>高</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>备注：</td>
            <td>
                <textarea name="comments" placeholder="备注">${todoItem.comments}</textarea>
            </td>
        </tr>
        <tr>
            <td><input type="button" id="update" value="修改"/></td>
            <td><input type="reset" id="cancer" value="取消"/></td>
        </tr>
    </table>
</form>
</body>
</html>
