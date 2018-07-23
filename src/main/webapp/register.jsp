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
    <title>用户注册</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/md5.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/user/register.js"></script>
    <script>
        var path = "${pageContext.request.contextPath}";
    </script>
</head>
<body>
<form id="registerForm" action="${pageContext.request.contextPath}/user/register" method="post">
    <table id="registerTable" align="center" cellpadding="10" border="1">
        <tr>
            <td>用户名：</td>
            <td width="360">
                <input type="text" name="userName" id="userName" placeholder="请输入用户名"/>
                <span>*</span>
            </td>
        </tr>
        <tr>
            <td>密码：</td>
            <td>
                <input type="hidden" name="password" id="hiddenPassword"/>
                <input type="password" id="password" placeholder="请输入密码"/>
                <span>*</span>
            </td>
        </tr>
        <tr>
            <td>确认密码：</td>
            <td>
                <input type="password" id="password2" placeholder="请再次输入密码"/>
                <span>*</span>
            </td>
        </tr>
        <tr>
            <td>性别：</td>
            <td>
                <input type="radio" name="sex" value="M" checked/>男
                <input type="radio" name="sex" value="F" />女
            </td>
        </tr>
        <tr>
            <td>年龄：</td>
            <td>
                <select name="age">
                    <c:forEach var="i" begin="1" end="200" step="1">
                        <option value="${i}">${i}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>电话：</td>
            <td>
                <input type="text" name="phoneNumber" id="phoneNumber" placeholder="请输入电话"/>
                <span></span>
            </td>
        </tr>
        <tr>
            <td>备注：</td>
            <td>
                <textarea name="comments" placeholder="备注"></textarea>
            </td>
        </tr>
        <tr>
            <td><input type="button" id="bt" value="注册"/></td>
            <td><input type="reset" value="重置"/></td>
        </tr>
    </table>
</form>
</body>
</html>
