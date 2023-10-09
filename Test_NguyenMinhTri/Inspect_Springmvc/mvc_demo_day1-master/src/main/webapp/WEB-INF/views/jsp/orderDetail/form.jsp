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
<%--@elvariable id="orderDetail" type=""--%>
<mvc:form action="${pageContext.request.getContextPath()}/orderDetail/search" modelAttribute="orderDetail" method="post">
    <div class="form-group">
        <label for="customer_name">Customer Name</label>
        <mvc:input type="text" class="form-control" id="customer_name" name="customer_name" aria-describedby="emailHelp" required="true" path="${orderDetail.order.name}"/>
    </div>

    <div class="form-group">
        <label for="date_order">Date Order</label>
        <mvc:input type="date" class="form-control" id="date_order" name="date_order" required="true" path="${orderDetail.order.orderDate}"/>
    </div>

    <div class="form-group">
        <label for="product_name">Product Name</label>
        <mvc:input type="text" class="form-control" id="product_name" name="product_name" required="true" path="${orderDetail.product.name}"/>
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
</mvc:form>
</body>
</html>