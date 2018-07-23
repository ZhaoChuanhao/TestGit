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
    <title>用户信息修改页</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/md5.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/user/updateUser.js"></script>
    <script>
        var path = "${pageContext.request.contextPath}";
    </script>
</head>
<body>
<form id="updateForm" action="${pageContext.request.contextPath}/user/updateUser?userId=${user.userId}" method="post">
    <table align="center" cellpadding="10">
        <tr>
            <td>用户名：</td>
            <td width="320">
                <input type="text" name="userName" id="userName" placeholder="请输入用户名" value="${user.userName}"/>
                <span>*</span>
            </td>
        </tr>
        <tr>
            <td>原密码：</td>
            <td>
                <input type="hidden" id="hiddenPassword"/>
                <input type="password" id="password" placeholder="请输入原密码" />
                <span>*</span>
            </td>
        </tr>
        <tr>
            <td>新密码：</td>
            <td>
                <input type="hidden" name="password" id="hiddenPassword2"/>
                <input type="password" id="password2" placeholder="请输入新密码" />
                <span>*</span>
            </td>
        </tr>
        <tr>
            <td>确认密码：</td>
            <td>
                <input type="password" id="password3" placeholder="请再次输入新密码" />
                <span>*</span>
            </td>
        </tr>
        <tr>
            <td>性别：</td>
            <td>
                <input type="radio" name="sex" value="M" <c:if test="${user.sex == 'M'}">checked</c:if>/>男
                <input type="radio" name="sex" value="F" <c:if test="${user.sex == 'F'}">checked</c:if>/>女
            </td>
        </tr>
        <tr>
            <td>年龄：</td>
            <td>
                <select name="age">
                    <c:forEach var="i" begin="1" end="200" step="1">
                        <option value="${i}" <c:if test="${user.age == i}">selected</c:if>>${i}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>电话：</td>
            <td>
                <input type="text" name="phoneNumber" id="phoneNumber" placeholder="请输入电话" value="${user.phoneNumber}"/>
                <span></span>
            </td>
        </tr>
        <tr>
            <td>备注：</td>
            <td>
                <textarea name="comments" id="comments" placeholder="备注">${user.comments}</textarea>
                <span></span>
            </td>
        </tr>
        <tr>
            <td><input type="button" id="bt" value="修改"/></td>
            <td><input type="reset" id="cancer" value="取消"/></td>
        </tr>
    </table>
</form>
</body>
</html>
