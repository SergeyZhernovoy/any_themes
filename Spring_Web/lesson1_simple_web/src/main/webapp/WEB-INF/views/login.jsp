<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 08.10.2017
  Time: 0:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                <h1>Welcome to Web Store !</h1>
                <p>The one and only amazing web store</p>
            </div>
        </div>
    </section>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Please sign in</h3>
                    </div>
                    <div class="panel-body">
                        <c:url value= "/login" var="loginUrl"/>
                        <form action="${loginUrl}" method="post" class="form-horizontal">
                            <c:if test="${param.error != null}">
                                <div class="alert alert-danger">
                                    <p>Invalid username or password</p>
                                </div>
                            </c:if>

                            <c:if test="${param.logout != null}">
                                <div class="alert alert-success">
                                    <p>You have been logged out successfully.</p>
                                </div>
                            </c:if>
                            <c:if test="${param.accessDenied != null}">
                                <div class="alert alert-danger">
                                    <p>Access Denied: You are not authorized !</p>
                                </div>
                            </c:if>
                            <div class="input-group input-sm">
                                <label class="input-group-addon" for="username"><i class="fa fa-user"></i> </label>
                                <input class="form-control" id="username" placeholder="Enter username" name="username" type="text" required>
                            </div>
                            <div class="input-group input-sm">
                                <label class="input-group-addon" for="password"><i class="fa fa-lock"></i> </label>
                                <input class="form-control" id="password" placeholder="Enter password" name="password" type="password" required>
                            </div>
                            <div class="form-action">
                                <input class="btn btn-block btn-primary btn-default" type="submit" value="Log in">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

