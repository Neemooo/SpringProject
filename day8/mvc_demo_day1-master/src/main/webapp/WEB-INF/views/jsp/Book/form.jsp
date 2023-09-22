<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Greeting</title>
</head>
<body>
<section >

    <form:form modelAttribute="book" action="/books/update" method="post">
        <p>
            <form:input type="hidden" path="id"/>
        </p>
        <p>
            <label for="name_book">Name</label><form:input type="text" path="name" id="name_book"/>
        </p>
        <p>
            <label for="author_book">Author</label><form:input type="text" path="author" id="author_book"/>
        </p>
        <p>
            <label for="isbn_book">ISBN</label><form:input type="text" path="isbn" id="isbn_book" />
        </p>
        <p>
            <label for="price_book">Price</label><form:input type="number" path="price" id="price_book" />
        </p>
        <p>
            <label for="date_book">Publish Date</label><form:input type="text" path="publishDate" id="date_book"/>
        </p>
        <mvc:select path="categoryId">
            <c:forEach items="category" var="cate">
                <mvc:option value="${cate.getId()}" label="${cate.getName()}"/>
            </c:forEach>
        </mvc:select>
        <button type="submit">Submit</button>
    </form:form>
</section>
</body>
</html>