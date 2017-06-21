<%--
  Created by IntelliJ IDEA.
  User: Dort
  Date: 21.06.2017
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <sf:form method="post" modelAttribute="User" action="/SpringMvcTest/onLogin">
    </sf:form>
    <h1>${error}</h1>
</body>
</html>
