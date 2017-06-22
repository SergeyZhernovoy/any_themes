<%--
  Created by IntelliJ IDEA.
  User: Dort
  Date: 22.06.2017
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Библиотека</title>
</head>
<body>
      <s:form method="post" modelAttribute="User" action="${pageContext.request.contextPath}/onLogin">
          <label>User name:</label>
          <input name="name" title="User name">
          <lable>Password:</lable>
          <input name="password" title="Password" id="password">
          <input type="submit">
      </s:form>
       <h1>:${error}</h1>
</body>
</html>
