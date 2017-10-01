<%--
  Created by IntelliJ IDEA.
  User: Sergey
  Date: 16.09.2017
  Time: 0:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <h1>Customers</h1>
                <p>All the customer in our store</p>
            </div>
        </div>
    </section>

    <section class="container">
        <div class="row"><c:forEach items="${customers}" var="customer">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <div class="thumbnail">
                    <div class="caption">
                        <h3>Customer name: ${customer.name}</h3>
                        <p>Address: ${customer.address}</p>
                        <p>Made order : ${customer.noOrdersMade}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
        </div>
    </section>
</body>
</html>
