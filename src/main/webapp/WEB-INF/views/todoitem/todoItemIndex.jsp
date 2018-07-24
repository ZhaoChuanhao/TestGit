<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Zhao
  Date: 2018/7/21
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>代办事项主页</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/todoitem/todoItemIndex.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/todoitem/todoItemIndex.js"></script>
    <script>
        var path = "${pageContext.request.contextPath}";
    </script>
</head>
<body>
    <div class="add_box"><a id="add" href="${pageContext.request.contextPath}/todoItem/toAddTodoItem">新增</a></div>
    <div class="update_box"><a id="update" href="#">更新</a></div>
    <div class="delete_box"><a id="delete" href="#">删除</a></div>
    <div class="welcome_box">
        欢迎您，${user.userName}
        <a href="${pageContext.request.contextPath}/user/toLogin" target="_top">退出</a>
    </div>
    <div class="table_box">
        <table width="1000">
            <tr id="head_tr">
                <th width="8%">序号</th>
                <th width="15%">标题</th>
                <th width="20%">内容</th>
                <th width="10%">优先级</th>
                <th width="20%">创建时间</th>
                <th width="20%">更新时间</th>
                <th width="12%">备注</th>
            </tr>
            <c:set var="i" value="1"></c:set>
            <c:forEach var="todoItem" items="${todoItems}">
                <tr>
                    <td>
                        <input type="hidden" id="todoItemId" value="${todoItem.todoItemId}"/>
                        ${i}
                    </td>
                    <td>${todoItem.todoItemTitle}</td>
                    <td title="${todoItem.todoItemContent}">${todoItem.todoItemContent}</td>
                    <td>
                        <c:if test="${todoItem.priority == 'LOW'}">低</c:if>
                        <c:if test="${todoItem.priority == 'MEDIUM'}">中</c:if>
                        <c:if test="${todoItem.priority == 'HIGH'}">高</c:if>
                    </td>
                    <td>${todoItem.creationTime}</td>
                    <td>${todoItem.lastUpdateTime}</td>
                    <td title="${todoItem.comments}">${todoItem.comments}</td>
                </tr>
                <c:set var="i" value="${i + 1}"></c:set>
            </c:forEach>
        </table>
    </div>

</body>
</html>
