<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30.09.2017
  Time: 21:39
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
    <div class="jumbotron">
        <div class="container">
            <h1>Products</h1>
        </div>
    </div>
</section>
<section class="container">
    <div class="row">
        <div class="col-md-5">
            <h3>${product.name}</h3>
            <p>${product.description}</p>
            <p>$${product.unitPrice}</p>
            <p><strong>Item Code : </strong><span class="label label-warning">${product.productId}</span></p>
            <p><strong>manufacturer</strong> : ${product.manufactured}</p>
            <p><strong>category</strong> : ${product.category}</p>
            <p><strong>Availble units in stock </strong> :${product.unitsInStock}</p><h4>${product.unitPrice} USD</h4>
            <a href="<spring:url value="/products"/>" class="btn btn-default">
                <span class="glypicon-hand-left glyphicon"></span>back
            </a>
            <p><a href="#" class="btn btn-warning btn-large"> <span class="glyphicon-shopping-cart glyphicon"></span> Order Now</a></p>
        </div>
    </div>
</section>
</body>
</html>
