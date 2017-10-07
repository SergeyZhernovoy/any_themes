<%--
  Created by IntelliJ IDEA.
  User: Dort
  Date: 04.10.2017
  Time: 15:46
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
                <h1>Products</h1>
                <p>Add products</p>
            </div>
            <a href="<c:url value="/j_spring_security_logout" />" class="btn btndanger btn-mini pull-right">logout</a>
        </div>
    </section>
    <section class="container">
        <form:form modelAttribute="product" class="form-horizontal">
            <fieldset>
                <legend>Add new product</legend>
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="productId">
                        <spring:message code="addProduct.form.productId"/>
                    </label>
                    <div class="col-lg-10">
                        <form:input path="productId" id="productId" type="text"></form:input>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="name">Name</label>
                    <div class="col-lg-10">
                        <form:input path="name" id="name" type="text"></form:input>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="unitPrice">Unit price</label>
                    <div class="col-lg-10">
                        <form:input path="unitPrice" id="unitPrice" type="text" ></form:input>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-lg-2" for="description">Description</label>
                    <div class="col-lg-10">
                        <form:textarea path="description" id="description" rows="2"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="manufactured">Manufacturer</label>
                    <div class="col-lg-10">
                        <form:input path="manufactured" id="manufactured" type="text"></form:input>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="manufactured">Category</label>
                    <div class="col-lg-10">
                        <form:input path="category" id="category" type="text"></form:input>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="unitsInStock">Units in stock</label>
                    <div class="col-lg-10">
                        <form:input path="unitsInStock" id="unitsInStock" type="number"></form:input>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-lg-2" for="condition">Condition</label>
                    <div class="col-lg-10" id="condition">
                        <form:radiobutton path="condition" value="New"/>New
                        <form:radiobutton path="condition" value="Old"/>Old
                        <form:radiobutton path="condition" value="Refurbished"/>Refurbished
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-lg-offset-2 col-lg-10">
                        <div class="col-lg-10">
                            <input type="submit" id="btnAdd" class="btn btn-primary" value="Add">
                        </div>
                    </div>
                </div>
            </fieldset>

        </form:form>
    </section>
</body>
</html>
