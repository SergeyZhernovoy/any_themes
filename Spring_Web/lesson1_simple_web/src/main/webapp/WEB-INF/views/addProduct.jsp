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
        <div class="pull-right" style="padding-right:50px">
            <a href="?language=en" >English</a>|<a href="?language=ru">Russian</a>
            <a href="<c:url value="/logout"/>">logout</a>
        </div>
    </section>
    <section>
        <div class="jumbotron">
            <div class="container">
                <h1>Products</h1>
                <p>Add products</p>
            </div>
        </div>
    </section>
    <section class="container">
        <form:form modelAttribute="product" class="form-horizontal" enctype="multipart/form-data">
            <fieldset>
                <legend>Add new product</legend>
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="productId">
                        <spring:message code="addProduct.form.productId.label"/>
                    </label>
                    <div class="col-lg-10">
                        <form:input path="productId" id="productId" type="text"></form:input>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="name">
                        <spring:message code="addProduct.form.name.label"/>
                    </label>
                    <div class="col-lg-10">
                        <form:input path="name" id="name" type="text"></form:input>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="unitPrice">
                        <spring:message code="addProduct.form.unitPrice.label"/>
                    </label>
                    <div class="col-lg-10">
                        <form:input path="unitPrice" id="unitPrice" type="text" ></form:input>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-lg-2" for="description">
                        <spring:message code="addProduct.form.description.label"/>
                    </label>
                    <div class="col-lg-10">
                        <form:textarea path="description" id="description" rows="2"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="manufactured">
                        <spring:message code="addProduct.form.manufacturer.label"/>
                    </label>
                    <div class="col-lg-10">
                        <form:input path="manufactured" id="manufactured" type="text"></form:input>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="category">
                        <spring:message code="addProduct.form.category.label"/>
                    </label>
                    <div class="col-lg-10">
                        <form:input path="category" id="category" type="text"></form:input>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2" for="unitsInStock">
                        <spring:message code="addProduct.form.unitsInStock.label"/>
                    </label>
                    <div class="col-lg-10">
                        <form:input path="unitsInStock" id="unitsInStock" type="number"></form:input>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-lg-2" for="condition">
                        <spring:message code="addProduct.form.condition.label"/>
                    </label>
                    <div class="col-lg-10" id="condition">
                        <form:radiobutton path="condition" value="New"/>New
                        <form:radiobutton path="condition" value="Old"/>Old
                        <form:radiobutton path="condition" value="Refurbished"/>Refurbished
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-lg-2" for="productImage">
                        <spring:message code="addProduct.form.productImage.label" />
                    </label>
                    <div class="col-lg-10">
                        <form:input id="productImage" path="productImage" type="file" class="form:input-large"/>
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
