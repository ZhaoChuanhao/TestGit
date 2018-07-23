<%--
  Created by IntelliJ IDEA.
  User: Zhao
  Date: 2018/7/23
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>框架页</title>
</head>
<body>

    <iframe width="15%" height="90%" src="${pageContext.request.contextPath}/list.jsp"></iframe>
    <iframe name="main" width="80%" height="90%" src="${pageContext.request.contextPath}/todoItem/todoItemIndex"></iframe>
</body>
</html>
