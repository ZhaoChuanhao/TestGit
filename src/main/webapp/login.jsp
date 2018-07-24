<%--
  Created by IntelliJ IDEA.
  User: Zhao
  Date: 2018/7/21
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户登录</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/md5.js"></script>
    <script>
        $(function () {
            $("#register").click(function () {
                $(location).attr("href", "${pageContext.request.contextPath}/register.jsp");
            })
        });
    </script>
</head>
<body>
    <c:if test="${!empty param.message}">
        <script>
            alert("用户名或密码错误！");
        </script>
    </c:if>

    <h1 align="center">个人代办事项管理系统</h1>
    <form id="form" action="${pageContext.request.contextPath}/user/login" method="post">
        <table align="center" cellpadding="10">
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="userName" placeholder="请输入用户名" value="${user.userName}"/></td>
            </tr>
            <tr>
                <td>密码</td>
                <td>
                    <input type="hidden" name="password" id="hiddenPassword"/>
                    <input type="password" id="password" placeholder="请输入密码"/>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" id="bt" value="登录"/>
                </td>
                <td>
                    <input type="button" id="register" value="注册"/>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
