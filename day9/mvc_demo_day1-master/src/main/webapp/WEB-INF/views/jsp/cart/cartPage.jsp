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
    <title>Greeting</title>
</head>
<body>
<ul class="nav justify-content-center">
    <li class="nav-item">
        <a class="nav-link active" href="${pageContext.request.getContextPath()}/product/list">List of product</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.getContextPath()}/cart">My Cart</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="#">My Order</a>
    </li>
</ul>
<table class="table table-bordered">
    <tr>
        <th>Name</th>
        <th>Quantity</th>
        <th>Price</th>
        <th></th>
    </tr>
    <c:forEach items="${cart}" var="product">
        <tr>
            <td>${product.product.name}</td>
            <td>${product.quantity}</td>
            <td>${product.product.price}</td>

            <td><a href="${pageContext.request.getContextPath()}/cart/delete/${product.product.id}" style="text-decoration: none">
                <button type="button" class="btn btn-outline-primary">
                    <i class="fa-solid fa-trash"></i>
                </button>
            </a></td>
        </tr>
    </c:forEach>
</table>
<h3>Total: ${total}</h3>
<c:if test="${not empty cart}">
    <a href="${pageContext.request.getContextPath()}/user/result" style="text-decoration: none">
        <button type="button" class="btn btn-outline-primary">
            Check out
        </button>
    </a>
</c:if>

</body>
</html>