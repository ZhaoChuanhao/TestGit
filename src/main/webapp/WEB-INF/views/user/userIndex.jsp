<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Zhao
  Date: 2018/7/21
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户个人信息主页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/user/userIndex.css">
</head>
<body>
    <div class="update_box"><a id="update" href="${pageContext.request.contextPath}/user/toUpdateUser?userId=${user.userId}">更新</a></div>
    <div class="welcome_box">
        欢迎您，${user.userName}
        <a href="${pageContext.request.contextPath}/user/toLogin" target="_top">退出</a>
    </div>

    <div class="table_box">
        <form action="#" method="post">
            基本信息
            <hr/>
            <table>
                <tr>
                    <td>用户名</td>
                    <td>${user.userName}</td>
                    <td>密码</td>
                    <td>${user.password}</td>
                </tr>
                <tr>
                    <td>性别</td>
                    <td>
                        <c:if test="${user.sex == 'M'}">男</c:if>
                        <c:if test="${user.sex == 'F'}">女</c:if>
                    </td>
                    <td>年龄</td>
                    <td>${user.age}</td>
                </tr>
                <tr>
                    <td>电话号码</td>
                    <td>${user.phoneNumber}</td>
                </tr>
            </table>
            <br/>
            其他信息
            <hr/>
            <table>
                <tr>
                    <td>创建时间</td>
                    <td>${user.creationTime}</td>
                </tr>
                <tr>
                    <td>修改时间</td>
                    <td>${user.lastUpdateTime}</td>
                </tr>
                <tr>
                    <td>备注</td>
                    <td>${user.comments}</td>
                </tr>
            </table>
        </form>
    </div>

</body>
</html>
