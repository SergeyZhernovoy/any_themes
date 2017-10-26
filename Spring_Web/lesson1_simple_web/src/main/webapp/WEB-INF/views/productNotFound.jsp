<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12.09.2017
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
    <section>
        <div class="jumbotron">
            <div class="container">
                <h1 class="alert alert-danger">There is no product found with the Product id ${invalidProductId}
                </h1>
            </div>
        </div>
    </section>

    <section>
        <div class="container">
            <p>${url}</p>
            <p>${exception}</p>
        </div>
        <div class="container">
            <p>
                <a href="<spring:url value="/products" />"class="btn btnprimary">
                    <span class="glyphicon-hand-left glyphicon"></span>
                    products
                </a>
            </p>
        </div>
    </section>

</body>
</html>
