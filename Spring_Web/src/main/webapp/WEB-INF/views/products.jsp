<%--
  Created by IntelliJ IDEA.
  User: Sergey
  Date: 16.09.2017
  Time: 0:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Products</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
    <section>
        <div class="pull-right" style="padding-right:50px">
            <a href="?language=en" >English</a>|<a href="?language=ru">Russian</a>
            <a href="<c:url value="/logout"/>">logout</a>
        </div>
    </section>
    <section>
        <div class="jumbotron">
            <div class="container">
                <h1>Products</h1>
                <p>All the available products in our store</p>
            </div>
        </div>
    </section>

    <section class="container">
        <div class="row"><c:forEach items="${products}" var="product">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <div class="thumbnail">
                    <img src="<c:url value="/img/${product.productId}.png"/>" alt="image" style = "width:100%">
                    <div class="caption">
                        <h3>${product.name}</h3>
                        <p>${product.description}</p>
                        <p>$${product.unitPrice}</p>
                        <p>Available ${product.unitsInStock} units in stock</p>
                        <p>
                            <a href="<spring:url value="/products/product?id=${product.productId}"/>"
                               class="btn btn-primary">
                                <span class = "glyphicon-info-sign glyphicon"></span> Details
                            </a>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
        </div>
    </section>
</body>
</html>
