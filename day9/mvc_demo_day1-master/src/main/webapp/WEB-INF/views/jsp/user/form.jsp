<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Index</title>
</head>
<body>
<ul class="nav justify-content-center">
    <li class="nav-item">
        <a class="nav-link active" href="product/list">List of product</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="cart">My Cart</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="#">My Order</a>
    </li>
</ul>
<mvc:form action="${pageContext.request.getContextPath()}/cart/removeSession" modelAttribute="user" method="post">
    <div class="form-group">
        <label for="exampleInputEmail1">Name</label>
        <mvc:input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" path="name" required="true"/>
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Address</label>
        <mvc:input type="text" class="form-control" id="exampleInputPassword1" path="address" required="true"/>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</mvc:form>
</body>
</html>