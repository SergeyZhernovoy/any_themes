<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 16.04.2018
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sping" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Invalid promo code</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
    <section>
        <div class="jumbotron">
            <div class="container">
                <h1 class="alert alert-danger">Invalid promo code</h1>
            </div>
        </div>
    </section>

    <section>
            <div class="container">
                <p>
                    <a href="<sping:url value="/products/" />" class="btn btn-primary"><span class="glyphicon-hand-left glyphicon"></span> </a>
                </p>
            </div>
    </section>

</body>
</html>
