<%--
  Created by IntelliJ IDEA.
  User: Zhao
  Date: 2018/7/23
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>代办事项添加页</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/todoitem/addTodoItem.js"></script>
    <script>
        var path = "${pageContext.request.contextPath}";
    </script>
</head>
<body>
    <form id="addForm" action="${pageContext.request.contextPath}/todoItem/addTodoItem" method="post">
        <table cellpadding="10">
            <tr>
                <td>标题：</td>
                <td>
                    <input type="text" name="todoItemTitle" id="todoItemTitle" placeholder="请输入标题"/>
                    <span>*</span>
                </td>
            </tr>
            <tr>
                <td>内容：</td>
                <td>
                    <textarea name="todoItemContent" placeholder="请输入内容"></textarea>
                </td>
            </tr>
            <tr>
                <td>优先级：</td>
                <td>
                    <select name="priority">
                        <option value="LOW">低</option>
                        <option value="MEDIUM">中</option>
                        <option value="HIGH">高</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>备注：</td>
                <td>
                    <textarea name="comments" placeholder="备注"></textarea>
                </td>
            </tr>
            <tr>
                <td><input type="button" id="add" value="添加"/></td>
                <td><input type="reset" id="cancer" value="取消"/></td>
            </tr>
        </table>
    </form>
</body>
</html>
